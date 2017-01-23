package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.analytics.tracking.android.AnalyticsThread.ClientIdCallback;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GoogleAnalytics implements TrackerHandler {
    private static GoogleAnalytics sInstance;
    private AdHitIdGenerator mAdHitIdGenerator;
    private volatile Boolean mAppOptOut;
    private volatile String mClientId;
    private Context mContext;
    private boolean mDebug;
    private Tracker mDefaultTracker;
    private String mLastTrackingId;
    private AnalyticsThread mThread;
    private final Map<String, Tracker> mTrackers;

    public interface AppOptOutCallback {
        void reportAppOptOut(boolean z);
    }

    /* renamed from: com.google.analytics.tracking.android.GoogleAnalytics.1 */
    class C26781 implements AppOptOutCallback {
        C26781() {
        }

        public void reportAppOptOut(boolean z) {
            GoogleAnalytics.this.mAppOptOut = Boolean.valueOf(z);
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GoogleAnalytics.2 */
    class C26792 implements ClientIdCallback {
        C26792() {
        }

        public void reportClientId(String str) {
            GoogleAnalytics.this.mClientId = str;
        }
    }

    @VisibleForTesting
    GoogleAnalytics() {
        this.mTrackers = new HashMap();
    }

    private GoogleAnalytics(Context context) {
        this(context, GAThread.getInstance(context));
    }

    private GoogleAnalytics(Context context, AnalyticsThread analyticsThread) {
        this.mTrackers = new HashMap();
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.mThread = analyticsThread;
        this.mAdHitIdGenerator = new AdHitIdGenerator();
        this.mThread.requestAppOptOut(new C26781());
        this.mThread.requestClientId(new C26792());
    }

    @VisibleForTesting
    static void clearInstance() {
        synchronized (GoogleAnalytics.class) {
            sInstance = null;
        }
    }

    static GoogleAnalytics getInstance() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = sInstance;
        }
        return googleAnalytics;
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (sInstance == null) {
                sInstance = new GoogleAnalytics(context);
            }
            googleAnalytics = sInstance;
        }
        return googleAnalytics;
    }

    @VisibleForTesting
    static GoogleAnalytics getNewInstance(Context context, AnalyticsThread analyticsThread) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (sInstance != null) {
                sInstance.close();
            }
            sInstance = new GoogleAnalytics(context, analyticsThread);
            googleAnalytics = sInstance;
        }
        return googleAnalytics;
    }

    @VisibleForTesting
    void close() {
    }

    public void closeTracker(Tracker tracker) {
        synchronized (this) {
            this.mTrackers.values().remove(tracker);
            if (tracker == this.mDefaultTracker) {
                this.mDefaultTracker = null;
            }
        }
    }

    @VisibleForTesting
    Boolean getAppOptOut() {
        return this.mAppOptOut;
    }

    String getClientIdForAds() {
        return this.mClientId == null ? null : this.mClientId.toString();
    }

    public Tracker getDefaultTracker() {
        Tracker tracker;
        synchronized (this) {
            GAUsage.getInstance().setUsage(Field.GET_DEFAULT_TRACKER);
            tracker = this.mDefaultTracker;
        }
        return tracker;
    }

    public Tracker getTracker(String str) {
        Tracker tracker;
        synchronized (this) {
            if (str == null) {
                throw new IllegalArgumentException("trackingId cannot be null");
            }
            String str2 = "UA-41235882-2";
            tracker = (Tracker) this.mTrackers.get(str2);
            if (tracker == null) {
                tracker = new Tracker(str2, this);
                this.mTrackers.put(str2, tracker);
                if (this.mDefaultTracker == null) {
                    this.mDefaultTracker = tracker;
                }
            }
            GAUsage.getInstance().setUsage(Field.GET_TRACKER);
        }
        return tracker;
    }

    String getTrackingIdForAds() {
        return this.mLastTrackingId;
    }

    public boolean isDebugEnabled() {
        GAUsage.getInstance().setUsage(Field.GET_DEBUG);
        return this.mDebug;
    }

    public void requestAppOptOut(AppOptOutCallback appOptOutCallback) {
        GAUsage.getInstance().setUsage(Field.REQUEST_APP_OPT_OUT);
        if (this.mAppOptOut != null) {
            appOptOutCallback.reportAppOptOut(this.mAppOptOut.booleanValue());
        } else {
            this.mThread.requestAppOptOut(appOptOutCallback);
        }
    }

    public void sendHit(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            map.put(ModelFields.LANGUAGE, Utils.getLanguage(Locale.getDefault()));
            map.put("adSenseAdMobHitId", Integer.toString(this.mAdHitIdGenerator.getAdHitId()));
            map.put(ModelFields.SCREEN_RESOLUTION, this.mContext.getResources().getDisplayMetrics().widthPixels + "x" + this.mContext.getResources().getDisplayMetrics().heightPixels);
            map.put("usage", GAUsage.getInstance().getAndClearSequence());
            GAUsage.getInstance().getAndClearUsage();
            this.mThread.sendHit(map);
            this.mLastTrackingId = (String) map.get(ModelFields.TRACKING_ID);
        }
    }

    public void setAppOptOut(boolean z) {
        GAUsage.getInstance().setUsage(Field.SET_APP_OPT_OUT);
        this.mAppOptOut = Boolean.valueOf(z);
        this.mThread.setAppOptOut(z);
    }

    public void setDebug(boolean z) {
        GAUsage.getInstance().setUsage(Field.SET_DEBUG);
        this.mDebug = z;
        Log.setDebug(z);
    }

    public void setDefaultTracker(Tracker tracker) {
        synchronized (this) {
            GAUsage.getInstance().setUsage(Field.SET_DEFAULT_TRACKER);
            this.mDefaultTracker = tracker;
        }
    }
}
