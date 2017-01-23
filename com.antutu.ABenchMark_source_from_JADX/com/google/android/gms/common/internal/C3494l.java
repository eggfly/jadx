package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.C3527b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.android.gms.common.internal.l */
final class C3494l extends C3490k implements Callback {
    private final HashMap<C3491a, C3493b> f12105a;
    private final Context f12106b;
    private final Handler f12107c;
    private final C3527b f12108d;
    private final long f12109e;

    /* renamed from: com.google.android.gms.common.internal.l.a */
    private static final class C3491a {
        private final String f12094a;
        private final ComponentName f12095b;

        public C3491a(String str) {
            this.f12094a = C3512u.m14582a(str);
            this.f12095b = null;
        }

        public Intent m14391a() {
            return this.f12094a != null ? new Intent(this.f12094a).setPackage("com.google.android.gms") : new Intent().setComponent(this.f12095b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C3491a)) {
                return false;
            }
            C3491a c3491a = (C3491a) obj;
            return C3511t.m14579a(this.f12094a, c3491a.f12094a) && C3511t.m14579a(this.f12095b, c3491a.f12095b);
        }

        public int hashCode() {
            return C3511t.m14577a(this.f12094a, this.f12095b);
        }

        public String toString() {
            return this.f12094a == null ? this.f12095b.flattenToString() : this.f12094a;
        }
    }

    /* renamed from: com.google.android.gms.common.internal.l.b */
    private final class C3493b {
        final /* synthetic */ C3494l f12097a;
        private final C3492a f12098b;
        private final Set<ServiceConnection> f12099c;
        private int f12100d;
        private boolean f12101e;
        private IBinder f12102f;
        private final C3491a f12103g;
        private ComponentName f12104h;

        /* renamed from: com.google.android.gms.common.internal.l.b.a */
        public class C3492a implements ServiceConnection {
            final /* synthetic */ C3493b f12096a;

            public C3492a(C3493b c3493b) {
                this.f12096a = c3493b;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.f12096a.f12097a.f12105a) {
                    this.f12096a.f12102f = iBinder;
                    this.f12096a.f12104h = componentName;
                    for (ServiceConnection onServiceConnected : this.f12096a.f12099c) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.f12096a.f12100d = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.f12096a.f12097a.f12105a) {
                    this.f12096a.f12102f = null;
                    this.f12096a.f12104h = componentName;
                    for (ServiceConnection onServiceDisconnected : this.f12096a.f12099c) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.f12096a.f12100d = 2;
                }
            }
        }

        public C3493b(C3494l c3494l, C3491a c3491a) {
            this.f12097a = c3494l;
            this.f12103g = c3491a;
            this.f12098b = new C3492a(this);
            this.f12099c = new HashSet();
            this.f12100d = 2;
        }

        public void m14397a(ServiceConnection serviceConnection, String str) {
            this.f12097a.f12108d.m14728a(this.f12097a.f12106b, serviceConnection, str, this.f12103g.m14391a());
            this.f12099c.add(serviceConnection);
        }

        @TargetApi(14)
        public void m14398a(String str) {
            this.f12100d = 3;
            this.f12101e = this.f12097a.f12108d.m14730a(this.f12097a.f12106b, str, this.f12103g.m14391a(), this.f12098b, 129);
            if (!this.f12101e) {
                this.f12100d = 2;
                try {
                    this.f12097a.f12108d.m14727a(this.f12097a.f12106b, this.f12098b);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public boolean m14399a() {
            return this.f12101e;
        }

        public boolean m14400a(ServiceConnection serviceConnection) {
            return this.f12099c.contains(serviceConnection);
        }

        public int m14401b() {
            return this.f12100d;
        }

        public void m14402b(ServiceConnection serviceConnection, String str) {
            this.f12097a.f12108d.m14731b(this.f12097a.f12106b, serviceConnection);
            this.f12099c.remove(serviceConnection);
        }

        public void m14403b(String str) {
            this.f12097a.f12108d.m14727a(this.f12097a.f12106b, this.f12098b);
            this.f12101e = false;
            this.f12100d = 2;
        }

        public boolean m14404c() {
            return this.f12099c.isEmpty();
        }

        public IBinder m14405d() {
            return this.f12102f;
        }

        public ComponentName m14406e() {
            return this.f12104h;
        }
    }

    C3494l(Context context) {
        this.f12105a = new HashMap();
        this.f12106b = context.getApplicationContext();
        this.f12107c = new Handler(context.getMainLooper(), this);
        this.f12108d = C3527b.m14718a();
        this.f12109e = 5000;
    }

    private boolean m14408a(C3491a c3491a, ServiceConnection serviceConnection, String str) {
        boolean a;
        C3512u.m14581a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f12105a) {
            C3493b c3493b = (C3493b) this.f12105a.get(c3491a);
            if (c3493b != null) {
                this.f12107c.removeMessages(0, c3493b);
                if (!c3493b.m14400a(serviceConnection)) {
                    c3493b.m14397a(serviceConnection, str);
                    switch (c3493b.m14401b()) {
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                            serviceConnection.onServiceConnected(c3493b.m14406e(), c3493b.m14405d());
                            break;
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                            c3493b.m14398a(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + c3491a);
            }
            c3493b = new C3493b(this, c3491a);
            c3493b.m14397a(serviceConnection, str);
            c3493b.m14398a(str);
            this.f12105a.put(c3491a, c3493b);
            a = c3493b.m14399a();
        }
        return a;
    }

    private void m14410b(C3491a c3491a, ServiceConnection serviceConnection, String str) {
        C3512u.m14581a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f12105a) {
            C3493b c3493b = (C3493b) this.f12105a.get(c3491a);
            if (c3493b == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + c3491a);
            } else if (c3493b.m14400a(serviceConnection)) {
                c3493b.m14402b(serviceConnection, str);
                if (c3493b.m14404c()) {
                    this.f12107c.sendMessageDelayed(this.f12107c.obtainMessage(0, c3493b), this.f12109e);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + c3491a);
            }
        }
    }

    public boolean m14412a(String str, ServiceConnection serviceConnection, String str2) {
        return m14408a(new C3491a(str), serviceConnection, str2);
    }

    public void m14413b(String str, ServiceConnection serviceConnection, String str2) {
        m14410b(new C3491a(str), serviceConnection, str2);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                C3493b c3493b = (C3493b) message.obj;
                synchronized (this.f12105a) {
                    if (c3493b.m14404c()) {
                        if (c3493b.m14399a()) {
                            c3493b.m14403b("GmsClientSupervisor");
                        }
                        this.f12105a.remove(c3493b.f12103g);
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
