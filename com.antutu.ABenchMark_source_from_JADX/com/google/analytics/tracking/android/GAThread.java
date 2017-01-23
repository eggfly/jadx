package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.analytics.tracking.android.AnalyticsThread.ClientIdCallback;
import com.google.analytics.tracking.android.GoogleAnalytics.AppOptOutCallback;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

class GAThread extends Thread implements AnalyticsThread {
    static final String API_VERSION = "1";
    private static final String CLIENT_VERSION = "ma1b5";
    private static final int MAX_SAMPLE_RATE = 100;
    private static final int SAMPLE_RATE_MODULO = 10000;
    private static final int SAMPLE_RATE_MULTIPLIER = 100;
    private static GAThread sInstance;
    private volatile boolean mAppOptOut;
    private volatile String mClientId;
    private volatile boolean mClosed;
    private volatile List<Command> mCommands;
    private final Context mContext;
    private volatile boolean mDisabled;
    private volatile String mInstallCampaign;
    private volatile MetaModel mMetaModel;
    private volatile ServiceProxy mServiceProxy;
    private final LinkedBlockingQueue<Runnable> queue;

    /* renamed from: com.google.analytics.tracking.android.GAThread.1 */
    class C26731 implements Runnable {
        final /* synthetic */ Map val$hitCopy;
        final /* synthetic */ long val$hitTime;

        C26731(Map map, long j) {
            this.val$hitCopy = map;
            this.val$hitTime = j;
        }

        public void run() {
            this.val$hitCopy.put(ModelFields.CLIENT_ID, GAThread.this.mClientId);
            if (!GAThread.this.mAppOptOut && !GAThread.this.isSampledOut(this.val$hitCopy)) {
                if (!TextUtils.isEmpty(GAThread.this.mInstallCampaign)) {
                    this.val$hitCopy.put(ModelFields.CAMPAIGN, GAThread.this.mInstallCampaign);
                    GAThread.this.mInstallCampaign = null;
                }
                GAThread.this.fillAppParameters(this.val$hitCopy);
                GAThread.this.fillCampaignParameters(this.val$hitCopy);
                GAThread.this.fillExceptionParameters(this.val$hitCopy);
                GAThread.this.mServiceProxy.putHit(HitBuilder.generateHitParams(GAThread.this.mMetaModel, this.val$hitCopy), this.val$hitTime, GAThread.this.getHostUrl(this.val$hitCopy), GAThread.this.mCommands);
            }
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAThread.2 */
    class C26742 implements Runnable {
        C26742() {
        }

        public void run() {
            GAThread.this.mServiceProxy.dispatch();
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAThread.3 */
    class C26753 implements Runnable {
        final /* synthetic */ boolean val$appOptOut;

        C26753(boolean z) {
            this.val$appOptOut = z;
        }

        public void run() {
            if (GAThread.this.mAppOptOut != this.val$appOptOut) {
                if (this.val$appOptOut) {
                    try {
                        GAThread.this.mContext.getFileStreamPath("gaOptOut").createNewFile();
                    } catch (IOException e) {
                        Log.m10260w("Error creating optOut file.");
                    }
                    GAThread.this.mServiceProxy.clearHits();
                } else {
                    GAThread.this.mContext.deleteFile("gaOptOut");
                }
                GAThread.this.mAppOptOut = this.val$appOptOut;
            }
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAThread.4 */
    class C26764 implements Runnable {
        final /* synthetic */ AppOptOutCallback val$callback;

        C26764(AppOptOutCallback appOptOutCallback) {
            this.val$callback = appOptOutCallback;
        }

        public void run() {
            this.val$callback.reportAppOptOut(GAThread.this.mAppOptOut);
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAThread.5 */
    class C26775 implements Runnable {
        final /* synthetic */ ClientIdCallback val$callback;

        C26775(ClientIdCallback clientIdCallback) {
            this.val$callback = clientIdCallback;
        }

        public void run() {
            this.val$callback.reportClientId(GAThread.this.mClientId);
        }
    }

    private GAThread(Context context) {
        super("GAThread");
        this.queue = new LinkedBlockingQueue();
        this.mDisabled = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    @VisibleForTesting
    GAThread(Context context, ServiceProxy serviceProxy) {
        super("GAThread");
        this.queue = new LinkedBlockingQueue();
        this.mDisabled = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        this.mServiceProxy = serviceProxy;
        start();
    }

    private void fillAppParameters(Map<String, String> map) {
        String charSequence;
        PackageManager packageManager = this.mContext.getPackageManager();
        String packageName = this.mContext.getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        String str = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
            if (packageInfo != null) {
                charSequence = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                try {
                    str = packageInfo.versionName;
                } catch (NameNotFoundException e) {
                    Log.m10257e("Error retrieving package info: appName set to " + charSequence);
                    putIfAbsent(map, ModelFields.APP_NAME, charSequence);
                    putIfAbsent(map, Constants.KEY_APP_VERSION, str);
                    putIfAbsent(map, ModelFields.APP_ID, packageName);
                    putIfAbsent(map, ModelFields.APP_INSTALLER_ID, installerPackageName);
                    map.put(ModelFields.API_VERSION, API_VERSION);
                }
            }
            charSequence = packageName;
        } catch (NameNotFoundException e2) {
            charSequence = packageName;
            Log.m10257e("Error retrieving package info: appName set to " + charSequence);
            putIfAbsent(map, ModelFields.APP_NAME, charSequence);
            putIfAbsent(map, Constants.KEY_APP_VERSION, str);
            putIfAbsent(map, ModelFields.APP_ID, packageName);
            putIfAbsent(map, ModelFields.APP_INSTALLER_ID, installerPackageName);
            map.put(ModelFields.API_VERSION, API_VERSION);
        }
        putIfAbsent(map, ModelFields.APP_NAME, charSequence);
        putIfAbsent(map, Constants.KEY_APP_VERSION, str);
        putIfAbsent(map, ModelFields.APP_ID, packageName);
        putIfAbsent(map, ModelFields.APP_INSTALLER_ID, installerPackageName);
        map.put(ModelFields.API_VERSION, API_VERSION);
    }

    private void fillCampaignParameters(Map<String, String> map) {
        Object filterCampaign = Utils.filterCampaign((String) map.get(ModelFields.CAMPAIGN));
        if (!TextUtils.isEmpty(filterCampaign)) {
            Map parseURLParameters = Utils.parseURLParameters(filterCampaign);
            map.put(ModelFields.CAMPAIGN_CONTENT, (String) parseURLParameters.get("utm_content"));
            map.put(ModelFields.CAMPAIGN_MEDIUM, (String) parseURLParameters.get("utm_medium"));
            map.put(ModelFields.CAMPAIGN_NAME, (String) parseURLParameters.get("utm_campaign"));
            map.put(ModelFields.CAMPAIGN_SOURCE, (String) parseURLParameters.get("utm_source"));
            map.put(ModelFields.CAMPAIGN_KEYWORD, (String) parseURLParameters.get("utm_term"));
            map.put(ModelFields.CAMPAIGN_ID, (String) parseURLParameters.get("utm_id"));
            map.put(ModelFields.GCLID, (String) parseURLParameters.get(ModelFields.GCLID));
            map.put(ModelFields.DCLID, (String) parseURLParameters.get(ModelFields.DCLID));
            map.put(ModelFields.GMOB_T, (String) parseURLParameters.get(ModelFields.GMOB_T));
        }
    }

    private void fillExceptionParameters(Map<String, String> map) {
        String str = (String) map.get(ModelFields.RAW_EXCEPTION);
        if (str != null) {
            map.remove(ModelFields.RAW_EXCEPTION);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Utils.hexDecode(str)));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                if (readObject instanceof Throwable) {
                    Throwable th = (Throwable) readObject;
                    map.put(ModelFields.EX_DESCRIPTION, new StandardExceptionParser(this.mContext, new ArrayList()).getDescription((String) map.get(ModelFields.EXCEPTION_THREAD_NAME), th));
                }
            } catch (IOException e) {
                Log.m10260w("IOException reading exception");
            } catch (ClassNotFoundException e2) {
                Log.m10260w("ClassNotFoundException reading exception");
            }
        }
    }

    private String generateClientId() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        return !storeClientId(toLowerCase) ? MessageService.MSG_DB_READY_REPORT : toLowerCase;
    }

    @VisibleForTesting
    static String getAndClearCampaign(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
            int read = openFileInput.read(bArr, 0, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            if (openFileInput.available() > 0) {
                Log.m10257e("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                Log.m10260w("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            Log.m10258i("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            Log.m10258i("No campaign data found.");
            return null;
        } catch (IOException e2) {
            Log.m10257e("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    private String getHostUrl(Map<String, String> map) {
        String str = (String) map.get("internalHitUrl");
        return str == null ? map.containsKey(ModelFields.USE_SECURE) ? Utils.safeParseBoolean((String) map.get(ModelFields.USE_SECURE)) ? "https://ssl.google-analytics.com/collect" : "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect" : str;
    }

    static GAThread getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new GAThread(context);
        }
        return sInstance;
    }

    private void init() {
        this.mServiceProxy.createService();
        this.mCommands = new ArrayList();
        this.mCommands.add(new Command(Command.APPEND_VERSION, "_v", CLIENT_VERSION));
        this.mCommands.add(new Command(Command.APPEND_QUEUE_TIME, ModelFields.QUEUE_TIME, null));
        this.mCommands.add(new Command(Command.APPEND_CACHE_BUSTER, ModelFields.CACHE_BUSTER, null));
        this.mMetaModel = new MetaModel();
        MetaModelInitializer.set(this.mMetaModel);
    }

    private boolean isSampledOut(Map<String, String> map) {
        if (map.get(ModelFields.SAMPLE_RATE) != null) {
            double safeParseDouble = Utils.safeParseDouble((String) map.get(ModelFields.SAMPLE_RATE));
            if (safeParseDouble <= 0.0d) {
                return true;
            }
            if (safeParseDouble < 100.0d) {
                String str = (String) map.get(ModelFields.CLIENT_ID);
                if (str != null && ((double) (Math.abs(str.hashCode()) % SAMPLE_RATE_MODULO)) >= safeParseDouble * 100.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean loadAppOptOut() {
        return this.mContext.getFileStreamPath("gaOptOut").exists();
    }

    private String printStackTrace(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    private void putIfAbsent(Map<String, String> map, String str, String str2) {
        if (!map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    private void queueToThread(Runnable runnable) {
        this.queue.add(runnable);
    }

    private boolean storeClientId(String str) {
        try {
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            Log.m10257e("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            Log.m10257e("Error writing to clientId file.");
            return false;
        }
    }

    @VisibleForTesting
    void close() {
        this.mClosed = true;
        interrupt();
    }

    public void dispatch() {
        queueToThread(new C26742());
    }

    public LinkedBlockingQueue<Runnable> getQueue() {
        return this.queue;
    }

    public Thread getThread() {
        return this;
    }

    @VisibleForTesting
    String initializeClientId() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSLV2];
            int read = openFileInput.read(bArr, 0, SpdyProtocol.SLIGHTSSLV2);
            if (openFileInput.available() > 0) {
                Log.m10257e("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaInstallData");
            }
            if (read <= 0) {
                Log.m10257e("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaInstallData");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    Log.m10257e("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaInstallData");
                } catch (NumberFormatException e3) {
                    str = str2;
                    Log.m10257e("cliendId file doesn't have long value, deleting it.");
                    this.mContext.deleteFile("gaInstallData");
                }
            }
        } catch (FileNotFoundException e4) {
        } catch (IOException e5) {
            Log.m10257e("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaInstallData");
        } catch (NumberFormatException e6) {
            Log.m10257e("cliendId file doesn't have long value, deleting it.");
            this.mContext.deleteFile("gaInstallData");
        }
        return str == null ? generateClientId() : str;
    }

    @VisibleForTesting
    boolean isDisabled() {
        return this.mDisabled;
    }

    public void requestAppOptOut(AppOptOutCallback appOptOutCallback) {
        queueToThread(new C26764(appOptOutCallback));
    }

    public void requestClientId(ClientIdCallback clientIdCallback) {
        queueToThread(new C26775(clientIdCallback));
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Log.m10260w("sleep interrupted in GAThread initialize");
        }
        if (this.mServiceProxy == null) {
            this.mServiceProxy = new GAServiceProxy(this.mContext, this);
        }
        init();
        try {
            this.mAppOptOut = loadAppOptOut();
            this.mClientId = initializeClientId();
            this.mInstallCampaign = getAndClearCampaign(this.mContext);
        } catch (Throwable th) {
            Log.m10257e("Error initializing the GAThread: " + printStackTrace(th));
            Log.m10257e("Google Analytics will not start up.");
            this.mDisabled = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.queue.take();
                if (!this.mDisabled) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                Log.m10258i(e2.toString());
            } catch (Throwable th2) {
                Log.m10257e("Error on GAThread: " + printStackTrace(th2));
                Log.m10257e("Google Analytics is shutting down.");
                this.mDisabled = true;
            }
        }
    }

    public void sendHit(Map<String, String> map) {
        Map hashMap = new HashMap(map);
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("hitTime", Long.toString(currentTimeMillis));
        queueToThread(new C26731(hashMap, currentTimeMillis));
    }

    public void setAppOptOut(boolean z) {
        queueToThread(new C26753(z));
    }
}
