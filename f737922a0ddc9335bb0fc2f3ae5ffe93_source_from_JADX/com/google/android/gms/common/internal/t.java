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
import com.aide.uidesigner.ProxyTextView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class t extends s implements Callback {
    private final Context DW;
    private final Handler FH;
    private final com.google.android.gms.common.stats.b Hw;
    private final HashMap<a, b> j6;
    private final long v5;

    private static final class a {
        private final String DW;
        private final ComponentName FH;
        private final String j6;

        public a(String str, String str2) {
            this.j6 = b.j6(str);
            this.DW = b.j6(str2);
            this.FH = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return ae.j6(this.j6, aVar.j6) && ae.j6(this.FH, aVar.FH);
        }

        public int hashCode() {
            return ae.j6(this.j6, this.FH);
        }

        public Intent j6() {
            return this.j6 != null ? new Intent(this.j6).setPackage(this.DW) : new Intent().setComponent(this.FH);
        }

        public String toString() {
            return this.j6 == null ? this.FH.flattenToString() : this.j6;
        }
    }

    private final class b {
        private final a DW;
        private final Set<ServiceConnection> FH;
        private int Hw;
        private final a VH;
        private IBinder Zo;
        private ComponentName gn;
        final /* synthetic */ t j6;
        private boolean v5;

        public class a implements ServiceConnection {
            final /* synthetic */ b j6;

            public a(b bVar) {
                this.j6 = bVar;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.j6.j6.j6) {
                    this.j6.Zo = iBinder;
                    this.j6.gn = componentName;
                    for (ServiceConnection onServiceConnected : this.j6.FH) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.j6.Hw = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.j6.j6.j6) {
                    this.j6.Zo = null;
                    this.j6.gn = componentName;
                    for (ServiceConnection onServiceDisconnected : this.j6.FH) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.j6.Hw = 2;
                }
            }
        }

        public b(t tVar, a aVar) {
            this.j6 = tVar;
            this.VH = aVar;
            this.DW = new a(this);
            this.FH = new HashSet();
            this.Hw = 2;
        }

        public int DW() {
            return this.Hw;
        }

        public void DW(ServiceConnection serviceConnection, String str) {
            this.j6.Hw.DW(this.j6.DW, serviceConnection);
            this.FH.remove(serviceConnection);
        }

        public void DW(String str) {
            this.j6.Hw.j6(this.j6.DW, this.DW);
            this.v5 = false;
            this.Hw = 2;
        }

        public boolean FH() {
            return this.FH.isEmpty();
        }

        public IBinder Hw() {
            return this.Zo;
        }

        public void j6(ServiceConnection serviceConnection, String str) {
            this.j6.Hw.j6(this.j6.DW, serviceConnection, str, this.VH.j6());
            this.FH.add(serviceConnection);
        }

        @TargetApi(14)
        public void j6(String str) {
            this.Hw = 3;
            this.v5 = this.j6.Hw.j6(this.j6.DW, str, this.VH.j6(), this.DW, (int) ProxyTextView.INPUTTYPE_textPassword);
            if (!this.v5) {
                this.Hw = 2;
                try {
                    this.j6.Hw.j6(this.j6.DW, this.DW);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public boolean j6() {
            return this.v5;
        }

        public boolean j6(ServiceConnection serviceConnection) {
            return this.FH.contains(serviceConnection);
        }

        public ComponentName v5() {
            return this.gn;
        }
    }

    t(Context context) {
        this.j6 = new HashMap();
        this.DW = context.getApplicationContext();
        this.FH = new Handler(context.getMainLooper(), this);
        this.Hw = com.google.android.gms.common.stats.b.j6();
        this.v5 = 5000;
    }

    private void DW(a aVar, ServiceConnection serviceConnection, String str) {
        b.j6((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.j6) {
            b bVar = (b) this.j6.get(aVar);
            String valueOf;
            if (bVar == null) {
                valueOf = String.valueOf(aVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (bVar.j6(serviceConnection)) {
                bVar.DW(serviceConnection, str);
                if (bVar.FH()) {
                    this.FH.sendMessageDelayed(this.FH.obtainMessage(0, bVar), this.v5);
                }
            } else {
                valueOf = String.valueOf(aVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    private boolean j6(a aVar, ServiceConnection serviceConnection, String str) {
        boolean j6;
        b.j6((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.j6) {
            b bVar = (b) this.j6.get(aVar);
            if (bVar != null) {
                this.FH.removeMessages(0, bVar);
                if (!bVar.j6(serviceConnection)) {
                    bVar.j6(serviceConnection, str);
                    switch (bVar.DW()) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            serviceConnection.onServiceConnected(bVar.v5(), bVar.Hw());
                            break;
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            bVar.j6(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(aVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            bVar = new b(this, aVar);
            bVar.j6(serviceConnection, str);
            bVar.j6(str);
            this.j6.put(aVar, bVar);
            j6 = bVar.j6();
        }
        return j6;
    }

    public void DW(String str, String str2, ServiceConnection serviceConnection, String str3) {
        DW(new a(str, str2), serviceConnection, str3);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                b bVar = (b) message.obj;
                synchronized (this.j6) {
                    if (bVar.FH()) {
                        if (bVar.j6()) {
                            bVar.DW("GmsClientSupervisor");
                        }
                        this.j6.remove(bVar.VH);
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }

    public boolean j6(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return j6(new a(str, str2), serviceConnection, str3);
    }
}
