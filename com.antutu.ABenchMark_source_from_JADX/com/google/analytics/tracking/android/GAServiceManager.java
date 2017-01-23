package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.facebook.ads.AdError;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.android.gms.common.util.VisibleForTesting;
import com.igexin.sdk.PushConsts;

public class GAServiceManager implements ServiceManager {
    private static final int MSG_KEY = 1;
    private static final Object MSG_OBJECT;
    private static GAServiceManager instance;
    private boolean connected;
    private Context ctx;
    private int dispatchPeriodInSeconds;
    private Handler handler;
    private boolean listenForNetwork;
    private AnalyticsStoreStateListener listener;
    private GANetworkReceiver networkReceiver;
    private boolean pendingDispatch;
    private AnalyticsStore store;
    private boolean storeIsEmpty;
    private volatile AnalyticsThread thread;

    /* renamed from: com.google.analytics.tracking.android.GAServiceManager.1 */
    class C26691 implements AnalyticsStoreStateListener {
        C26691() {
        }

        public void reportStoreIsEmpty(boolean z) {
            GAServiceManager.this.updatePowerSaveMode(z, GAServiceManager.this.connected);
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAServiceManager.2 */
    class C26702 implements Callback {
        C26702() {
        }

        public boolean handleMessage(Message message) {
            if (GAServiceManager.MSG_KEY == message.what && GAServiceManager.MSG_OBJECT.equals(message.obj)) {
                GAUsage.getInstance().setDisableUsage(true);
                GAServiceManager.this.dispatch();
                GAUsage.getInstance().setDisableUsage(false);
                if (GAServiceManager.this.dispatchPeriodInSeconds > 0 && !GAServiceManager.this.storeIsEmpty) {
                    GAServiceManager.this.handler.sendMessageDelayed(GAServiceManager.this.handler.obtainMessage(GAServiceManager.MSG_KEY, GAServiceManager.MSG_OBJECT), (long) (GAServiceManager.this.dispatchPeriodInSeconds * AdError.NETWORK_ERROR_CODE));
                }
            }
            return true;
        }
    }

    static {
        MSG_OBJECT = new Object();
    }

    private GAServiceManager() {
        this.dispatchPeriodInSeconds = 1800;
        this.pendingDispatch = true;
        this.connected = true;
        this.listenForNetwork = true;
        this.listener = new C26691();
        this.storeIsEmpty = false;
    }

    @VisibleForTesting
    GAServiceManager(Context context, AnalyticsThread analyticsThread, AnalyticsStore analyticsStore, boolean z) {
        this.dispatchPeriodInSeconds = 1800;
        this.pendingDispatch = true;
        this.connected = true;
        this.listenForNetwork = true;
        this.listener = new C26691();
        this.storeIsEmpty = false;
        this.store = analyticsStore;
        this.thread = analyticsThread;
        this.listenForNetwork = z;
        initialize(context, analyticsThread);
    }

    public static GAServiceManager getInstance() {
        if (instance == null) {
            instance = new GAServiceManager();
        }
        return instance;
    }

    private void initializeHandler() {
        this.handler = new Handler(this.ctx.getMainLooper(), new C26702());
        if (this.dispatchPeriodInSeconds > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(MSG_KEY, MSG_OBJECT), (long) (this.dispatchPeriodInSeconds * AdError.NETWORK_ERROR_CODE));
        }
    }

    private void initializeNetworkReceiver() {
        this.networkReceiver = new GANetworkReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        this.ctx.registerReceiver(this.networkReceiver, intentFilter);
    }

    public synchronized void dispatch() {
        if (this.thread == null) {
            Log.m10260w("dispatch call queued.  Need to call GAServiceManager.getInstance().initialize().");
            this.pendingDispatch = true;
        } else {
            GAUsage.getInstance().setUsage(Field.DISPATCH);
            this.thread.dispatch();
        }
    }

    @VisibleForTesting
    AnalyticsStoreStateListener getListener() {
        return this.listener;
    }

    synchronized AnalyticsStore getStore() {
        if (this.store == null) {
            if (this.ctx == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.store = new PersistentAnalyticsStore(this.listener, this.ctx);
        }
        if (this.handler == null) {
            initializeHandler();
        }
        if (this.networkReceiver == null && this.listenForNetwork) {
            initializeNetworkReceiver();
        }
        return this.store;
    }

    synchronized void initialize(Context context, AnalyticsThread analyticsThread) {
        if (this.ctx == null) {
            this.ctx = context.getApplicationContext();
            if (this.thread == null) {
                this.thread = analyticsThread;
                if (this.pendingDispatch) {
                    analyticsThread.dispatch();
                }
            }
        }
    }

    public synchronized void setDispatchPeriod(int i) {
        if (this.handler == null) {
            Log.m10260w("Need to call initialize() and be in fallback mode to start dispatch.");
            this.dispatchPeriodInSeconds = i;
        } else {
            GAUsage.getInstance().setUsage(Field.SET_DISPATCH_PERIOD);
            if (!this.storeIsEmpty && this.connected && this.dispatchPeriodInSeconds > 0) {
                this.handler.removeMessages(MSG_KEY, MSG_OBJECT);
            }
            this.dispatchPeriodInSeconds = i;
            if (i > 0 && !this.storeIsEmpty && this.connected) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(MSG_KEY, MSG_OBJECT), (long) (i * AdError.NETWORK_ERROR_CODE));
            }
        }
    }

    public synchronized void updateConnectivityStatus(boolean z) {
        updatePowerSaveMode(this.storeIsEmpty, z);
    }

    @VisibleForTesting
    synchronized void updatePowerSaveMode(boolean z, boolean z2) {
        if (!(this.storeIsEmpty == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.dispatchPeriodInSeconds > 0) {
                    this.handler.removeMessages(MSG_KEY, MSG_OBJECT);
                }
            }
            if (!z && z2 && this.dispatchPeriodInSeconds > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(MSG_KEY, MSG_OBJECT), (long) (this.dispatchPeriodInSeconds * AdError.NETWORK_ERROR_CODE));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            Log.iDebug(append.append(str).toString());
            this.storeIsEmpty = z;
            this.connected = z2;
        }
    }
}
