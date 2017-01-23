package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class EasyTracker {
    static final int NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY = 1000;
    private static EasyTracker sInstance;
    private int mActivitiesActive;
    private final Map<String, String> mActivityNameMap;
    private GoogleAnalytics mAnalyticsInstance;
    private String mAppName;
    private String mAppVersion;
    private Clock mClock;
    private Context mContext;
    private boolean mDebug;
    private int mDispatchPeriod;
    private UncaughtExceptionHandler mExceptionHandler;
    private boolean mIsAnonymizeIpEnabled;
    private boolean mIsAutoActivityTracking;
    private boolean mIsEnabled;
    private boolean mIsInForeground;
    private boolean mIsReportUncaughtExceptionsEnabled;
    private long mLastOnStopTime;
    private ParameterLoader mParameterFetcher;
    private Double mSampleRate;
    private ServiceManager mServiceManager;
    private long mSessionTimeout;
    private Timer mTimer;
    private TimerTask mTimerTask;
    private Tracker mTracker;
    private String mTrackingId;

    /* renamed from: com.google.analytics.tracking.android.EasyTracker.1 */
    class C26681 implements Clock {
        C26681() {
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    class NoopTracker extends Tracker {
        private String mAppId;
        private String mAppInstallerId;
        private ExceptionParser mExceptionParser;
        private boolean mIsAnonymizeIp;
        private boolean mIsUseSecure;
        private double mSampleRate;

        NoopTracker() {
            this.mSampleRate = 100.0d;
        }

        public void close() {
        }

        public Map<String, String> constructEvent(String str, String str2, String str3, Long l) {
            return new HashMap();
        }

        public Map<String, String> constructException(String str, boolean z) {
            return new HashMap();
        }

        public Map<String, String> constructRawException(String str, Throwable th, boolean z) {
            return new HashMap();
        }

        public Map<String, String> constructSocial(String str, String str2, String str3) {
            return new HashMap();
        }

        public Map<String, String> constructTiming(String str, long j, String str2, String str3) {
            return new HashMap();
        }

        public Map<String, String> constructTransaction(Transaction transaction) {
            return new HashMap();
        }

        public String get(String str) {
            return BuildConfig.FLAVOR;
        }

        public String getAppId() {
            return this.mAppId;
        }

        public String getAppInstallerId() {
            return this.mAppInstallerId;
        }

        public ExceptionParser getExceptionParser() {
            return this.mExceptionParser;
        }

        public double getSampleRate() {
            return this.mSampleRate;
        }

        public String getTrackingId() {
            return BuildConfig.FLAVOR;
        }

        public boolean isAnonymizeIpEnabled() {
            return this.mIsAnonymizeIp;
        }

        public boolean isUseSecure() {
            return this.mIsUseSecure;
        }

        public void send(String str, Map<String, String> map) {
        }

        public void sendEvent(String str, String str2, String str3, Long l) {
        }

        public void sendException(String str, Throwable th, boolean z) {
        }

        public void sendException(String str, boolean z) {
        }

        public void sendSocial(String str, String str2, String str3) {
        }

        public void sendTiming(String str, long j, String str2, String str3) {
        }

        public void sendTransaction(Transaction transaction) {
        }

        public void sendView() {
        }

        public void sendView(String str) {
        }

        public void set(String str, String str2) {
        }

        public void setAnonymizeIp(boolean z) {
            this.mIsAnonymizeIp = z;
        }

        public void setAppId(String str) {
            this.mAppId = str;
        }

        public void setAppInstallerId(String str) {
            this.mAppInstallerId = str;
        }

        public void setAppName(String str) {
        }

        public void setAppScreen(String str) {
        }

        public int setAppVersion(String str) {
            return 0;
        }

        public void setCampaign(String str) {
        }

        public void setCustomDimension(int i, String str) {
        }

        public void setCustomDimensionsAndMetrics(Map<Integer, String> map, Map<Integer, Long> map2) {
        }

        public void setCustomMetric(int i, Long l) {
        }

        public void setExceptionParser(ExceptionParser exceptionParser) {
            this.mExceptionParser = exceptionParser;
        }

        public void setReferrer(String str) {
        }

        public void setSampleRate(double d) {
            this.mSampleRate = d;
        }

        public void setStartSession(boolean z) {
        }

        public void setUseSecure(boolean z) {
            this.mIsUseSecure = z;
        }
    }

    private class NotInForegroundTimerTask extends TimerTask {
        private NotInForegroundTimerTask() {
        }

        public void run() {
            EasyTracker.this.mIsInForeground = false;
        }
    }

    private EasyTracker() {
        this.mIsEnabled = false;
        this.mDispatchPeriod = 1800;
        this.mIsAutoActivityTracking = false;
        this.mActivitiesActive = 0;
        this.mActivityNameMap = new HashMap();
        this.mTracker = null;
        this.mIsInForeground = false;
        this.mClock = new C26681();
    }

    private synchronized void clearExistingTimer() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @VisibleForTesting
    static void clearTracker() {
        sInstance = null;
    }

    private String getActivityName(Activity activity) {
        String canonicalName = activity.getClass().getCanonicalName();
        if (this.mActivityNameMap.containsKey(canonicalName)) {
            return (String) this.mActivityNameMap.get(canonicalName);
        }
        String string = this.mParameterFetcher.getString(canonicalName);
        if (string == null) {
            string = canonicalName;
        }
        this.mActivityNameMap.put(canonicalName, string);
        return string;
    }

    public static EasyTracker getInstance() {
        if (sInstance == null) {
            sInstance = new EasyTracker();
        }
        return sInstance;
    }

    public static Tracker getTracker() {
        if (getInstance().mContext != null) {
            return getInstance().mTracker;
        }
        throw new IllegalStateException("You must call EasyTracker.getInstance().setContext(context) or startActivity(activity) before calling getTracker()");
    }

    private void loadParameters() {
        boolean z = true;
        this.mTrackingId = this.mParameterFetcher.getString("ga_trackingId");
        if (TextUtils.isEmpty(this.mTrackingId)) {
            this.mTrackingId = this.mParameterFetcher.getString("ga_api_key");
            if (TextUtils.isEmpty(this.mTrackingId)) {
                Log.m10257e("EasyTracker requested, but missing required ga_trackingId");
                this.mTracker = new NoopTracker();
                return;
            }
        }
        this.mIsEnabled = true;
        this.mAppName = this.mParameterFetcher.getString("ga_appName");
        this.mAppVersion = this.mParameterFetcher.getString("ga_appVersion");
        this.mDebug = this.mParameterFetcher.getBoolean("ga_debug");
        this.mSampleRate = this.mParameterFetcher.getDoubleFromString("ga_sampleFrequency");
        if (this.mSampleRate == null) {
            this.mSampleRate = new Double((double) this.mParameterFetcher.getInt("ga_sampleRate", 100));
        }
        this.mDispatchPeriod = this.mParameterFetcher.getInt("ga_dispatchPeriod", 1800);
        this.mSessionTimeout = (long) (this.mParameterFetcher.getInt("ga_sessionTimeout", 30) * NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY);
        if (!(this.mParameterFetcher.getBoolean("ga_autoActivityTracking") || this.mParameterFetcher.getBoolean("ga_auto_activity_tracking"))) {
            z = false;
        }
        this.mIsAutoActivityTracking = z;
        this.mIsAnonymizeIpEnabled = this.mParameterFetcher.getBoolean("ga_anonymizeIp");
        this.mIsReportUncaughtExceptionsEnabled = this.mParameterFetcher.getBoolean("ga_reportUncaughtExceptions");
        this.mTracker = this.mAnalyticsInstance.getTracker(this.mTrackingId);
        if (!TextUtils.isEmpty(this.mAppName)) {
            Log.m10258i("setting appName to " + this.mAppName);
            this.mTracker.setAppName(this.mAppName);
        }
        if (this.mAppVersion != null) {
            this.mTracker.setAppVersion(this.mAppVersion);
        }
        this.mTracker.setAnonymizeIp(this.mIsAnonymizeIpEnabled);
        this.mTracker.setSampleRate(this.mSampleRate.doubleValue());
        this.mAnalyticsInstance.setDebug(this.mDebug);
        this.mServiceManager.setDispatchPeriod(this.mDispatchPeriod);
        if (this.mIsReportUncaughtExceptionsEnabled) {
            UncaughtExceptionHandler uncaughtExceptionHandler = this.mExceptionHandler;
            if (uncaughtExceptionHandler == null) {
                uncaughtExceptionHandler = new ExceptionReporter(this.mTracker, this.mServiceManager, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
            }
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void activityStart(android.app.Activity r3) {
        /*
        r2 = this;
        r1 = 1;
        r2.setContext(r3);
        r0 = r2.mIsEnabled;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r2.clearExistingTimer();
        r0 = r2.mIsInForeground;
        if (r0 != 0) goto L_0x0023;
    L_0x0010:
        r0 = r2.mActivitiesActive;
        if (r0 != 0) goto L_0x0023;
    L_0x0014:
        r0 = r2.checkForNewSession();
        if (r0 == 0) goto L_0x0023;
    L_0x001a:
        r0 = r2.mTracker;
        r0.setStartSession(r1);
        r0 = r2.mIsAutoActivityTracking;
        if (r0 == 0) goto L_0x0023;
    L_0x0023:
        r2.mIsInForeground = r1;
        r0 = r2.mActivitiesActive;
        r0 = r0 + 1;
        r2.mActivitiesActive = r0;
        r0 = r2.mIsAutoActivityTracking;
        if (r0 == 0) goto L_0x0008;
    L_0x002f:
        r0 = r2.mTracker;
        r1 = r2.getActivityName(r3);
        r0.sendView(r1);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.tracking.android.EasyTracker.activityStart(android.app.Activity):void");
    }

    public void activityStop(Activity activity) {
        setContext(activity);
        if (this.mIsEnabled) {
            this.mActivitiesActive--;
            this.mActivitiesActive = Math.max(0, this.mActivitiesActive);
            this.mLastOnStopTime = this.mClock.currentTimeMillis();
            if (this.mActivitiesActive == 0) {
                clearExistingTimer();
                this.mTimerTask = new NotInForegroundTimerTask();
                this.mTimer = new Timer("waitForActivityStart");
                this.mTimer.schedule(this.mTimerTask, 1000);
            }
        }
    }

    boolean checkForNewSession() {
        return this.mSessionTimeout == 0 || (this.mSessionTimeout > 0 && this.mClock.currentTimeMillis() > this.mLastOnStopTime + this.mSessionTimeout);
    }

    public void dispatch() {
        if (this.mIsEnabled) {
            this.mServiceManager.dispatch();
        }
    }

    @VisibleForTesting
    int getActivitiesActive() {
        return this.mActivitiesActive;
    }

    @VisibleForTesting
    void setClock(Clock clock) {
        this.mClock = clock;
    }

    public void setContext(Context context) {
        if (context == null) {
            Log.m10257e("Context cannot be null");
            return;
        }
        setContext(context, new ParameterLoaderImpl(context.getApplicationContext()), GoogleAnalytics.getInstance(context.getApplicationContext()), GAServiceManager.getInstance());
    }

    @VisibleForTesting
    void setContext(Context context, ParameterLoader parameterLoader, GoogleAnalytics googleAnalytics, ServiceManager serviceManager) {
        if (context == null) {
            Log.m10257e("Context cannot be null");
        }
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            this.mAnalyticsInstance = googleAnalytics;
            this.mServiceManager = serviceManager;
            this.mParameterFetcher = parameterLoader;
            loadParameters();
        }
    }

    @VisibleForTesting
    void setUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mExceptionHandler = uncaughtExceptionHandler;
    }
}
