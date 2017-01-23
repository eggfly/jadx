package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.analytics.tracking.android.Transaction.Item;
import com.google.android.gms.common.util.VisibleForTesting;
import com.igexin.download.Downloads;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.android.agoo.message.MessageService;

public class Tracker {
    private static final DecimalFormat DF;
    static final long MAX_TOKENS = 120000;
    static final long TIME_PER_TOKEN_MILLIS = 2000;
    private volatile ExceptionParser mExceptionParser;
    private final TrackerHandler mHandler;
    private boolean mIsThrottlingEnabled;
    private volatile boolean mIsTrackerClosed;
    private volatile boolean mIsTrackingStarted;
    private long mLastTrackTime;
    private final SimpleModel mModel;
    private long mTokens;

    private static class SimpleModel {
        private Map<String, String> permanentMap;
        private Map<String, String> temporaryMap;

        private SimpleModel() {
            this.temporaryMap = new HashMap();
            this.permanentMap = new HashMap();
        }

        public synchronized void clearTemporaryValues() {
            this.temporaryMap.clear();
        }

        public synchronized String get(String str) {
            String str2;
            str2 = (String) this.temporaryMap.get(str);
            if (str2 == null) {
                str2 = (String) this.permanentMap.get(str);
            }
            return str2;
        }

        public synchronized Map<String, String> getKeysAndValues() {
            Map<String, String> hashMap;
            hashMap = new HashMap(this.permanentMap);
            hashMap.putAll(this.temporaryMap);
            return hashMap;
        }

        public synchronized void set(String str, String str2) {
            this.permanentMap.put(str, str2);
        }

        public synchronized void setAll(Map<String, String> map, Boolean bool) {
            if (bool.booleanValue()) {
                this.temporaryMap.putAll(map);
            } else {
                this.permanentMap.putAll(map);
            }
        }

        public synchronized void setForNextHit(String str, String str2) {
            this.temporaryMap.put(str, str2);
        }
    }

    static {
        DF = new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US));
    }

    Tracker() {
        this.mIsTrackerClosed = false;
        this.mIsTrackingStarted = false;
        this.mTokens = MAX_TOKENS;
        this.mIsThrottlingEnabled = true;
        this.mHandler = null;
        this.mModel = null;
    }

    Tracker(String str, TrackerHandler trackerHandler) {
        this.mIsTrackerClosed = false;
        this.mIsTrackingStarted = false;
        this.mTokens = MAX_TOKENS;
        this.mIsThrottlingEnabled = true;
        if (str == null) {
            throw new IllegalArgumentException("trackingId cannot be null");
        }
        this.mHandler = trackerHandler;
        this.mModel = new SimpleModel();
        this.mModel.set(ModelFields.TRACKING_ID, "UA-41235882-2");
        this.mModel.set(ModelFields.SAMPLE_RATE, MessageService.MSG_DB_COMPLETE);
        this.mModel.setForNextHit(ModelFields.SESSION_CONTROL, "start");
        this.mModel.set(ModelFields.USE_SECURE, Boolean.toString(true));
    }

    private void assertTrackerOpen() {
        if (this.mIsTrackerClosed) {
            throw new IllegalStateException("Tracker closed");
        }
    }

    private Map<String, String> constructItem(Item item, Transaction transaction) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(ModelFields.TRANSACTION_ID, transaction.getTransactionId());
        hashMap.put("currencyCode", transaction.getCurrencyCode());
        hashMap.put(ModelFields.ITEM_CODE, item.getSKU());
        hashMap.put(ModelFields.ITEM_NAME, item.getName());
        hashMap.put(ModelFields.ITEM_CATEGORY, item.getCategory());
        hashMap.put(ModelFields.ITEM_PRICE, microsToCurrencyString(item.getPriceInMicros()));
        hashMap.put(ModelFields.ITEM_QUANTITY, Long.toString(item.getQuantity()));
        GAUsage.getInstance().setUsage(Field.CONSTRUCT_ITEM);
        return hashMap;
    }

    private void internalSend(String str, Map<String, String> map) {
        Map hashMap;
        this.mIsTrackingStarted = true;
        if (map == null) {
            hashMap = new HashMap();
        }
        hashMap.put(ModelFields.HIT_TYPE, str);
        this.mModel.setAll(hashMap, Boolean.valueOf(true));
        if (tokensAvailable()) {
            this.mHandler.sendHit(this.mModel.getKeysAndValues());
        } else {
            Log.wDebug("Too many hits sent too quickly, throttling invoked.");
        }
        this.mModel.clearTemporaryValues();
    }

    private static String microsToCurrencyString(long j) {
        return DF.format(((double) j) / 1000000.0d);
    }

    public void close() {
        this.mIsTrackerClosed = true;
        this.mHandler.closeTracker(this);
    }

    public Map<String, String> constructEvent(String str, String str2, String str3, Long l) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(ModelFields.EVENT_CATEGORY, str);
        hashMap.put(ModelFields.EVENT_ACTION, str2);
        hashMap.put(ModelFields.EVENT_LABEL, str3);
        if (l != null) {
            hashMap.put(ModelFields.EVENT_VALUE, Long.toString(l.longValue()));
        }
        GAUsage.getInstance().setUsage(Field.CONSTRUCT_EVENT);
        return hashMap;
    }

    public Map<String, String> constructException(String str, boolean z) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(ModelFields.EX_DESCRIPTION, str);
        hashMap.put(ModelFields.EX_FATAL, Boolean.toString(z));
        GAUsage.getInstance().setUsage(Field.CONSTRUCT_EXCEPTION);
        return hashMap;
    }

    public Map<String, String> constructRawException(String str, Throwable th, boolean z) {
        Map<String, String> hashMap = new HashMap();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(th);
        objectOutputStream.close();
        hashMap.put(ModelFields.RAW_EXCEPTION, Utils.hexEncode(byteArrayOutputStream.toByteArray()));
        if (str != null) {
            hashMap.put(ModelFields.EXCEPTION_THREAD_NAME, str);
        }
        hashMap.put(ModelFields.EX_FATAL, Boolean.toString(z));
        GAUsage.getInstance().setUsage(Field.CONSTRUCT_RAW_EXCEPTION);
        return hashMap;
    }

    public Map<String, String> constructSocial(String str, String str2, String str3) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(ModelFields.SOCIAL_NETWORK, str);
        hashMap.put(ModelFields.SOCIAL_ACTION, str2);
        hashMap.put(ModelFields.SOCIAL_TARGET, str3);
        GAUsage.getInstance().setUsage(Field.CONSTRUCT_SOCIAL);
        return hashMap;
    }

    public Map<String, String> constructTiming(String str, long j, String str2, String str3) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(ModelFields.TIMING_CATEGORY, str);
        hashMap.put(ModelFields.TIMING_VALUE, Long.toString(j));
        hashMap.put(ModelFields.TIMING_VAR, str2);
        hashMap.put(ModelFields.TIMING_LABEL, str3);
        GAUsage.getInstance().setUsage(Field.CONSTRUCT_TIMING);
        return hashMap;
    }

    public Map<String, String> constructTransaction(Transaction transaction) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(ModelFields.TRANSACTION_ID, transaction.getTransactionId());
        hashMap.put(ModelFields.TRANSACTION_AFFILIATION, transaction.getAffiliation());
        hashMap.put(ModelFields.TRANSACTION_SHIPPING, microsToCurrencyString(transaction.getShippingCostInMicros()));
        hashMap.put(ModelFields.TRANSACTION_TAX, microsToCurrencyString(transaction.getTotalTaxInMicros()));
        hashMap.put(ModelFields.TRANSACTION_TOTAL, microsToCurrencyString(transaction.getTotalCostInMicros()));
        hashMap.put("currencyCode", transaction.getCurrencyCode());
        GAUsage.getInstance().setUsage(Field.CONSTRUCT_TRANSACTION);
        return hashMap;
    }

    public String get(String str) {
        GAUsage.getInstance().setUsage(Field.GET);
        return this.mModel.get(str);
    }

    public String getAppId() {
        GAUsage.getInstance().setUsage(Field.GET_APP_ID);
        return this.mModel.get(ModelFields.APP_ID);
    }

    public String getAppInstallerId() {
        GAUsage.getInstance().setUsage(Field.GET_APP_INSTALLER_ID);
        return this.mModel.get(ModelFields.APP_INSTALLER_ID);
    }

    public ExceptionParser getExceptionParser() {
        GAUsage.getInstance().setUsage(Field.GET_EXCEPTION_PARSER);
        return this.mExceptionParser;
    }

    public double getSampleRate() {
        GAUsage.getInstance().setUsage(Field.GET_SAMPLE_RATE);
        return Utils.safeParseDouble(this.mModel.get(ModelFields.SAMPLE_RATE));
    }

    public String getTrackingId() {
        GAUsage.getInstance().setUsage(Field.GET_TRACKING_ID);
        return this.mModel.get(ModelFields.TRACKING_ID);
    }

    public boolean isAnonymizeIpEnabled() {
        GAUsage.getInstance().setUsage(Field.GET_ANONYMIZE_IP);
        return Utils.safeParseBoolean(this.mModel.get(ModelFields.ANONYMIZE_IP));
    }

    public boolean isUseSecure() {
        GAUsage.getInstance().setUsage(Field.GET_USE_SECURE);
        return Boolean.parseBoolean(this.mModel.get(ModelFields.USE_SECURE));
    }

    public void send(String str, Map<String, String> map) {
        assertTrackerOpen();
        GAUsage.getInstance().setUsage(Field.SEND);
        internalSend(str, map);
    }

    public void sendEvent(String str, String str2, String str3, Long l) {
        assertTrackerOpen();
        GAUsage.getInstance().setUsage(Field.TRACK_EVENT);
        GAUsage.getInstance().setDisableUsage(true);
        internalSend(ModelFields.EVENT, constructEvent(str, str2, str3, l));
        GAUsage.getInstance().setDisableUsage(false);
    }

    public void sendException(String str, Throwable th, boolean z) {
        String description;
        assertTrackerOpen();
        GAUsage.getInstance().setUsage(Field.TRACK_EXCEPTION_WITH_THROWABLE);
        if (this.mExceptionParser != null) {
            description = this.mExceptionParser.getDescription(str, th);
        } else {
            try {
                GAUsage.getInstance().setDisableUsage(true);
                internalSend(ModelFields.EXCEPTION, constructRawException(str, th, z));
                GAUsage.getInstance().setDisableUsage(false);
                return;
            } catch (IOException e) {
                Log.m10260w("trackException: couldn't serialize, sending \"Unknown Exception\"");
                description = "Unknown Exception";
            }
        }
        GAUsage.getInstance().setDisableUsage(true);
        sendException(description, z);
        GAUsage.getInstance().setDisableUsage(false);
    }

    public void sendException(String str, boolean z) {
        assertTrackerOpen();
        GAUsage.getInstance().setUsage(Field.TRACK_EXCEPTION_WITH_DESCRIPTION);
        GAUsage.getInstance().setDisableUsage(true);
        internalSend(ModelFields.EXCEPTION, constructException(str, z));
        GAUsage.getInstance().setDisableUsage(false);
    }

    public void sendSocial(String str, String str2, String str3) {
        assertTrackerOpen();
        GAUsage.getInstance().setUsage(Field.TRACK_SOCIAL);
        GAUsage.getInstance().setDisableUsage(true);
        internalSend(ModelFields.SOCIAL, constructSocial(str, str2, str3));
        GAUsage.getInstance().setDisableUsage(false);
    }

    public void sendTiming(String str, long j, String str2, String str3) {
        assertTrackerOpen();
        GAUsage.getInstance().setUsage(Field.TRACK_TIMING);
        GAUsage.getInstance().setDisableUsage(true);
        internalSend(ModelFields.TIMING, constructTiming(str, j, str2, str3));
        GAUsage.getInstance().setDisableUsage(false);
    }

    public void sendTransaction(Transaction transaction) {
        assertTrackerOpen();
        GAUsage.getInstance().setUsage(Field.TRACK_TRANSACTION);
        GAUsage.getInstance().setDisableUsage(true);
        internalSend(ModelFields.TRANSACTION, constructTransaction(transaction));
        for (Item constructItem : transaction.getItems()) {
            internalSend(ModelFields.ITEM, constructItem(constructItem, transaction));
        }
        GAUsage.getInstance().setDisableUsage(false);
    }

    public void sendView() {
        assertTrackerOpen();
        if (TextUtils.isEmpty(this.mModel.get(Downloads.COLUMN_DESCRIPTION))) {
            throw new IllegalStateException("trackView requires a appScreen to be set");
        }
        GAUsage.getInstance().setUsage(Field.TRACK_VIEW);
        internalSend(ModelFields.APP_VIEW, null);
    }

    public void sendView(String str) {
        assertTrackerOpen();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("trackView requires a appScreen to be set");
        }
        GAUsage.getInstance().setUsage(Field.TRACK_VIEW_WITH_APPSCREEN);
        this.mModel.set(Downloads.COLUMN_DESCRIPTION, str);
        internalSend(ModelFields.APP_VIEW, null);
    }

    public void set(String str, String str2) {
        GAUsage.getInstance().setUsage(Field.SET);
        this.mModel.set(str, str2);
    }

    public void setAnonymizeIp(boolean z) {
        GAUsage.getInstance().setUsage(Field.SET_ANONYMIZE_IP);
        this.mModel.set(ModelFields.ANONYMIZE_IP, Boolean.toString(z));
    }

    public void setAppId(String str) {
        GAUsage.getInstance().setUsage(Field.SET_APP_ID);
        this.mModel.set(ModelFields.APP_ID, str);
    }

    public void setAppInstallerId(String str) {
        GAUsage.getInstance().setUsage(Field.SET_APP_INSTALLER_ID);
        this.mModel.set(ModelFields.APP_INSTALLER_ID, str);
    }

    public void setAppName(String str) {
        if (this.mIsTrackingStarted) {
            Log.wDebug("Tracking already started, setAppName call ignored");
        } else if (TextUtils.isEmpty(str)) {
            Log.wDebug("setting appName to empty value not allowed, call ignored");
        } else {
            GAUsage.getInstance().setUsage(Field.SET_APP_NAME);
            this.mModel.set(ModelFields.APP_NAME, str);
        }
    }

    public void setAppScreen(String str) {
        assertTrackerOpen();
        GAUsage.getInstance().setUsage(Field.SET_APP_SCREEN);
        this.mModel.set(Downloads.COLUMN_DESCRIPTION, str);
    }

    public int setAppVersion(String str) {
        if (this.mIsTrackingStarted) {
            Log.wDebug("Tracking already started, setAppVersion call ignored");
        }
        GAUsage.getInstance().setUsage(Field.SET_APP_VERSION);
        this.mModel.set(Constants.KEY_APP_VERSION, str);
        return 0;
    }

    public void setCampaign(String str) {
        GAUsage.getInstance().setUsage(Field.SET_CAMPAIGN);
        this.mModel.setForNextHit(ModelFields.CAMPAIGN, str);
    }

    public void setCustomDimension(int i, String str) {
        if (i < 1) {
            Log.m10260w("index must be > 0, ignoring setCustomDimension call for " + i + ", " + str);
        } else {
            this.mModel.setForNextHit(Utils.getSlottedModelField(ModelFields.CUSTOM_DIMENSION, i), str);
        }
    }

    public void setCustomDimensionsAndMetrics(Map<Integer, String> map, Map<Integer, Long> map2) {
        if (map != null) {
            for (Integer num : map.keySet()) {
                setCustomDimension(num.intValue(), (String) map.get(num));
            }
        }
        if (map2 != null) {
            for (Integer num2 : map2.keySet()) {
                setCustomMetric(num2.intValue(), (Long) map2.get(num2));
            }
        }
    }

    public void setCustomMetric(int i, Long l) {
        if (i < 1) {
            Log.m10260w("index must be > 0, ignoring setCustomMetric call for " + i + ", " + l);
            return;
        }
        String str = null;
        if (l != null) {
            str = Long.toString(l.longValue());
        }
        this.mModel.setForNextHit(Utils.getSlottedModelField(ModelFields.CUSTOM_METRIC, i), str);
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        GAUsage.getInstance().setUsage(Field.SET_EXCEPTION_PARSER);
        this.mExceptionParser = exceptionParser;
    }

    @VisibleForTesting
    void setLastTrackTime(long j) {
        this.mLastTrackTime = j;
    }

    public void setReferrer(String str) {
        GAUsage.getInstance().setUsage(Field.SET_REFERRER);
        this.mModel.setForNextHit(ModelFields.REFERRER, str);
    }

    public void setSampleRate(double d) {
        GAUsage.getInstance().setUsage(Field.SET_SAMPLE_RATE);
        this.mModel.set(ModelFields.SAMPLE_RATE, Double.toString(d));
    }

    public void setStartSession(boolean z) {
        assertTrackerOpen();
        GAUsage.getInstance().setUsage(Field.SET_START_SESSION);
        this.mModel.setForNextHit(ModelFields.SESSION_CONTROL, z ? "start" : null);
    }

    @VisibleForTesting
    public void setThrottlingEnabled(boolean z) {
        this.mIsThrottlingEnabled = z;
    }

    @VisibleForTesting
    void setTokens(long j) {
        this.mTokens = j;
    }

    public void setUseSecure(boolean z) {
        GAUsage.getInstance().setUsage(Field.SET_USE_SECURE);
        this.mModel.set(ModelFields.USE_SECURE, Boolean.toString(z));
    }

    @VisibleForTesting
    synchronized boolean tokensAvailable() {
        boolean z = true;
        synchronized (this) {
            if (this.mIsThrottlingEnabled) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.mTokens < MAX_TOKENS) {
                    long j = currentTimeMillis - this.mLastTrackTime;
                    if (j > 0) {
                        this.mTokens = Math.min(MAX_TOKENS, j + this.mTokens);
                    }
                }
                this.mLastTrackTime = currentTimeMillis;
                if (this.mTokens >= TIME_PER_TOKEN_MILLIS) {
                    this.mTokens -= TIME_PER_TOKEN_MILLIS;
                } else {
                    Log.wDebug("Excessive tracking detected.  Tracking call ignored.");
                    z = false;
                }
            }
        }
        return z;
    }

    @Deprecated
    public void trackEvent(String str, String str2, String str3, Long l) {
        sendEvent(str, str2, str3, l);
    }

    @Deprecated
    public void trackException(String str, Throwable th, boolean z) {
        sendException(str, th, z);
    }

    @Deprecated
    public void trackException(String str, boolean z) {
        sendException(str, z);
    }

    @Deprecated
    public void trackSocial(String str, String str2, String str3) {
        sendSocial(str, str2, str3);
    }

    @Deprecated
    public void trackTiming(String str, long j, String str2, String str3) {
        sendTiming(str, j, str2, str3);
    }

    @Deprecated
    public void trackTransaction(Transaction transaction) {
        sendTransaction(transaction);
    }

    @Deprecated
    public void trackView() {
        sendView();
    }

    @Deprecated
    public void trackView(String str) {
        sendView(str);
    }
}
