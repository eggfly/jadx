package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.AnalyticsGmsCoreClient.OnConnectedListener;
import com.google.analytics.tracking.android.AnalyticsGmsCoreClient.OnConnectionFailedListener;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.android.spdy.SpdyProtocol;

class GAServiceProxy implements OnConnectedListener, OnConnectionFailedListener, ServiceProxy {
    private static final long FAILED_CONNECT_WAIT_TIME = 3000;
    private static final int MAX_TRIES = 2;
    private static final long RECONNECT_WAIT_TIME = 5000;
    private static final long SERVICE_CONNECTION_TIMEOUT = 300000;
    private volatile AnalyticsClient client;
    private Clock clock;
    private volatile int connectTries;
    private final Context ctx;
    private volatile Timer disconnectCheckTimer;
    private volatile Timer failedConnectTimer;
    private long idleTimeout;
    private volatile long lastRequestTime;
    private boolean pendingClearHits;
    private boolean pendingDispatch;
    private final Queue<HitParams> queue;
    private volatile Timer reConnectTimer;
    private volatile ConnectState state;
    private AnalyticsStore store;
    private AnalyticsStore testStore;
    private final AnalyticsThread thread;

    /* renamed from: com.google.analytics.tracking.android.GAServiceProxy.1 */
    class C26711 implements Clock {
        C26711() {
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAServiceProxy.2 */
    class C26722 implements Runnable {
        C26722() {
        }

        public void run() {
            GAServiceProxy.this.sendQueue();
        }
    }

    private enum ConnectState {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    private class DisconnectCheckTask extends TimerTask {
        private DisconnectCheckTask() {
        }

        public void run() {
            if (GAServiceProxy.this.state == ConnectState.CONNECTED_SERVICE && GAServiceProxy.this.queue.isEmpty() && GAServiceProxy.this.lastRequestTime + GAServiceProxy.this.idleTimeout < GAServiceProxy.this.clock.currentTimeMillis()) {
                Log.iDebug("Disconnecting due to inactivity");
                GAServiceProxy.this.disconnectFromService();
                return;
            }
            GAServiceProxy.this.disconnectCheckTimer.schedule(new DisconnectCheckTask(), GAServiceProxy.this.idleTimeout);
        }
    }

    private class FailedConnectTask extends TimerTask {
        private FailedConnectTask() {
        }

        public void run() {
            if (GAServiceProxy.this.state == ConnectState.CONNECTING) {
                GAServiceProxy.this.useStore();
            }
        }
    }

    private static class HitParams {
        private final List<Command> commands;
        private final long hitTimeInMilliseconds;
        private final String path;
        private final Map<String, String> wireFormatParams;

        public HitParams(Map<String, String> map, long j, String str, List<Command> list) {
            this.wireFormatParams = map;
            this.hitTimeInMilliseconds = j;
            this.path = str;
            this.commands = list;
        }

        public List<Command> getCommands() {
            return this.commands;
        }

        public long getHitTimeInMilliseconds() {
            return this.hitTimeInMilliseconds;
        }

        public String getPath() {
            return this.path;
        }

        public Map<String, String> getWireFormatParams() {
            return this.wireFormatParams;
        }
    }

    private class ReconnectTask extends TimerTask {
        private ReconnectTask() {
        }

        public void run() {
            GAServiceProxy.this.connectToService();
        }
    }

    GAServiceProxy(Context context, AnalyticsThread analyticsThread) {
        this(context, analyticsThread, null);
    }

    GAServiceProxy(Context context, AnalyticsThread analyticsThread, AnalyticsStore analyticsStore) {
        this.queue = new ConcurrentLinkedQueue();
        this.idleTimeout = SERVICE_CONNECTION_TIMEOUT;
        this.testStore = analyticsStore;
        this.ctx = context;
        this.thread = analyticsThread;
        this.clock = new C26711();
        this.connectTries = 0;
        this.state = ConnectState.DISCONNECTED;
    }

    private Timer cancelTimer(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private void clearAllTimers() {
        this.reConnectTimer = cancelTimer(this.reConnectTimer);
        this.failedConnectTimer = cancelTimer(this.failedConnectTimer);
        this.disconnectCheckTimer = cancelTimer(this.disconnectCheckTimer);
    }

    private synchronized void connectToService() {
        if (this.client == null || this.state == ConnectState.CONNECTED_LOCAL) {
            Log.m10260w("client not initialized.");
            useStore();
        } else {
            try {
                this.connectTries++;
                cancelTimer(this.failedConnectTimer);
                this.state = ConnectState.CONNECTING;
                this.failedConnectTimer = new Timer("Failed Connect");
                this.failedConnectTimer.schedule(new FailedConnectTask(), FAILED_CONNECT_WAIT_TIME);
                Log.iDebug("connecting to Analytics service");
                this.client.connect();
            } catch (SecurityException e) {
                Log.m10260w("security exception on connectToService");
                useStore();
            }
        }
    }

    private synchronized void disconnectFromService() {
        if (this.client != null && this.state == ConnectState.CONNECTED_SERVICE) {
            this.state = ConnectState.PENDING_DISCONNECT;
            this.client.disconnect();
        }
    }

    private void dispatchToStore() {
        this.store.dispatch();
        this.pendingDispatch = false;
    }

    private void fireReconnectAttempt() {
        this.reConnectTimer = cancelTimer(this.reConnectTimer);
        this.reConnectTimer = new Timer("Service Reconnect");
        this.reConnectTimer.schedule(new ReconnectTask(), RECONNECT_WAIT_TIME);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void sendQueue() {
        /*
        r8 = this;
        monitor-enter(r8);
        r2 = java.lang.Thread.currentThread();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r3 = r8.thread;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r3 = r3.getThread();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        if (r2 != 0) goto L_0x0021;
    L_0x0011:
        r2 = r8.thread;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r2.getQueue();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r3 = new com.google.analytics.tracking.android.GAServiceProxy$2;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r3.<init>();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2.add(r3);	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
    L_0x001f:
        monitor-exit(r8);
        return;
    L_0x0021:
        r2 = r8.pendingClearHits;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        if (r2 == 0) goto L_0x0028;
    L_0x0025:
        r8.clearHits();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
    L_0x0028:
        r2 = r8.state;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r2.ordinal();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        switch(r2) {
            case 1: goto L_0x0032;
            case 2: goto L_0x006c;
            case 3: goto L_0x00a8;
            default: goto L_0x0031;
        };	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
    L_0x0031:
        goto L_0x001f;
    L_0x0032:
        r2 = r8.queue;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r2.isEmpty();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        if (r2 != 0) goto L_0x0061;
    L_0x003a:
        r2 = r8.queue;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r2.poll();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r0 = r2;
        r0 = (com.google.analytics.tracking.android.GAServiceProxy.HitParams) r0;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r7 = r0;
        r2 = "Sending hit to store";
        com.google.analytics.tracking.android.Log.iDebug(r2);	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r8.store;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r3 = r7.getWireFormatParams();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r4 = r7.getHitTimeInMilliseconds();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r6 = r7.getPath();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r7 = r7.getCommands();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2.putHit(r3, r4, r6, r7);	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        goto L_0x0032;
    L_0x005f:
        r2 = move-exception;
        goto L_0x001f;
    L_0x0061:
        r2 = r8.pendingDispatch;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        if (r2 == 0) goto L_0x001f;
    L_0x0065:
        r8.dispatchToStore();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        goto L_0x001f;
    L_0x0069:
        r2 = move-exception;
        monitor-exit(r8);
        throw r2;
    L_0x006c:
        r2 = r8.queue;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r2.isEmpty();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        if (r2 != 0) goto L_0x009e;
    L_0x0074:
        r2 = r8.queue;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r2.peek();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r0 = r2;
        r0 = (com.google.analytics.tracking.android.GAServiceProxy.HitParams) r0;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r7 = r0;
        r2 = "Sending hit to service";
        com.google.analytics.tracking.android.Log.iDebug(r2);	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r8.client;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r3 = r7.getWireFormatParams();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r4 = r7.getHitTimeInMilliseconds();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r6 = r7.getPath();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r7 = r7.getCommands();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2.sendHit(r3, r4, r6, r7);	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r8.queue;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2.poll();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        goto L_0x006c;
    L_0x009e:
        r2 = r8.clock;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r2.currentTimeMillis();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r8.lastRequestTime = r2;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        goto L_0x001f;
    L_0x00a8:
        r2 = "Need to reconnect";
        com.google.analytics.tracking.android.Log.iDebug(r2);	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r8.queue;	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        r2 = r2.isEmpty();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        if (r2 != 0) goto L_0x001f;
    L_0x00b5:
        r8.connectToService();	 Catch:{ Exception -> 0x005f, all -> 0x0069 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.tracking.android.GAServiceProxy.sendQueue():void");
    }

    private synchronized void useStore() {
        if (this.state != ConnectState.CONNECTED_LOCAL) {
            clearAllTimers();
            Log.iDebug("falling back to local store");
            if (this.testStore != null) {
                this.store = this.testStore;
            } else {
                GAServiceManager instance = GAServiceManager.getInstance();
                instance.initialize(this.ctx, this.thread);
                this.store = instance.getStore();
            }
            this.state = ConnectState.CONNECTED_LOCAL;
            sendQueue();
        }
    }

    public void clearHits() {
        Log.iDebug("clearHits called");
        this.queue.clear();
        switch (this.state.ordinal()) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.store.clearHits(0);
                this.pendingClearHits = false;
            case MAX_TRIES /*2*/:
                this.client.clearHits();
                this.pendingClearHits = false;
            default:
                this.pendingClearHits = true;
        }
    }

    public void createService() {
        if (this.client == null) {
            this.client = new AnalyticsGmsCoreClient(this.ctx, this, this);
            connectToService();
        }
    }

    void createService(AnalyticsClient analyticsClient) {
        if (this.client == null) {
            this.client = analyticsClient;
            connectToService();
        }
    }

    public void dispatch() {
        switch (this.state.ordinal()) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                dispatchToStore();
            case MAX_TRIES /*2*/:
            default:
                this.pendingDispatch = true;
        }
    }

    public synchronized void onConnected() {
        this.failedConnectTimer = cancelTimer(this.failedConnectTimer);
        this.connectTries = 0;
        Log.iDebug("Connected to service");
        this.state = ConnectState.CONNECTED_SERVICE;
        sendQueue();
        this.disconnectCheckTimer = cancelTimer(this.disconnectCheckTimer);
        this.disconnectCheckTimer = new Timer("disconnect check");
        this.disconnectCheckTimer.schedule(new DisconnectCheckTask(), this.idleTimeout);
    }

    public synchronized void onConnectionFailed(int i, Intent intent) {
        this.state = ConnectState.PENDING_CONNECTION;
        if (this.connectTries < MAX_TRIES) {
            Log.m10260w("Service unavailable (code=" + i + "), will retry.");
            fireReconnectAttempt();
        } else {
            Log.m10260w("Service unavailable (code=" + i + "), using local store.");
            useStore();
        }
    }

    public synchronized void onDisconnected() {
        if (this.state == ConnectState.PENDING_DISCONNECT) {
            Log.iDebug("Disconnected from service");
            clearAllTimers();
            this.state = ConnectState.DISCONNECTED;
        } else {
            Log.iDebug("Unexpected disconnect.");
            this.state = ConnectState.PENDING_CONNECTION;
            if (this.connectTries < MAX_TRIES) {
                fireReconnectAttempt();
            } else {
                useStore();
            }
        }
    }

    public void putHit(Map<String, String> map, long j, String str, List<Command> list) {
        Log.iDebug("putHit called");
        this.queue.add(new HitParams(map, j, str, list));
        sendQueue();
    }

    void setClock(Clock clock) {
        this.clock = clock;
    }

    public void setIdleTimeout(long j) {
        this.idleTimeout = j;
    }
}
