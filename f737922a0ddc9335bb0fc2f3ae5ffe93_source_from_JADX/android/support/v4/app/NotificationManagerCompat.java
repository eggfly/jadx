package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings.Secure;
import android.util.Log;
import com.aide.uidesigner.ProxyTextView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NotificationManagerCompat {
    private static final Object DW;
    private static String FH;
    private static Set<String> Hw;
    private static final a Zo;
    private static final int j6;
    private static final Object v5;

    private static class SideChannelManager implements ServiceConnection, Callback {
        private final HandlerThread DW;
        private final Handler FH;
        private final Map<ComponentName, a> Hw;
        private final Context j6;
        private Set<String> v5;

        private static class a {
            public boolean DW;
            public s FH;
            public LinkedList<f> Hw;
            public final ComponentName j6;
            public int v5;

            public a(ComponentName componentName) {
                this.DW = false;
                this.Hw = new LinkedList();
                this.v5 = 0;
                this.j6 = componentName;
            }
        }

        public SideChannelManager(Context context) {
            this.Hw = new HashMap();
            this.v5 = new HashSet();
            this.j6 = context;
            this.DW = new HandlerThread("NotificationManagerCompat");
            this.DW.start();
            this.FH = new Handler(this.DW.getLooper(), this);
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    j6((f) message.obj);
                    return true;
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    e eVar = (e) message.obj;
                    j6(eVar.j6, eVar.DW);
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    j6((ComponentName) message.obj);
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    DW((ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        private void j6(f fVar) {
            j6();
            for (a aVar : this.Hw.values()) {
                aVar.Hw.add(fVar);
                Hw(aVar);
            }
        }

        private void j6(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.Hw.get(componentName);
            if (aVar != null) {
                aVar.FH = android.support.v4.app.s.a.j6(iBinder);
                aVar.v5 = 0;
                Hw(aVar);
            }
        }

        private void j6(ComponentName componentName) {
            a aVar = (a) this.Hw.get(componentName);
            if (aVar != null) {
                DW(aVar);
            }
        }

        private void DW(ComponentName componentName) {
            a aVar = (a) this.Hw.get(componentName);
            if (aVar != null) {
                Hw(aVar);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.FH.obtainMessage(1, new e(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.FH.obtainMessage(2, componentName).sendToTarget();
        }

        private void j6() {
            Set j6 = NotificationManagerCompat.j6(this.j6);
            if (!j6.equals(this.v5)) {
                this.v5 = j6;
                List<ResolveInfo> queryIntentServices = this.j6.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                Set<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (j6.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.Hw.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.Hw.put(componentName2, new a(componentName2));
                    }
                }
                Iterator it = this.Hw.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        DW((a) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        private boolean j6(a aVar) {
            if (aVar.DW) {
                return true;
            }
            aVar.DW = this.j6.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.j6), this, NotificationManagerCompat.j6);
            if (aVar.DW) {
                aVar.v5 = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.j6);
                this.j6.unbindService(this);
            }
            return aVar.DW;
        }

        private void DW(a aVar) {
            if (aVar.DW) {
                this.j6.unbindService(this);
                aVar.DW = false;
            }
            aVar.FH = null;
        }

        private void FH(a aVar) {
            if (!this.FH.hasMessages(3, aVar.j6)) {
                aVar.v5++;
                if (aVar.v5 > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.Hw.size() + " tasks to " + aVar.j6 + " after " + aVar.v5 + " retries");
                    aVar.Hw.clear();
                    return;
                }
                int i = (1 << (aVar.v5 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.FH.sendMessageDelayed(this.FH.obtainMessage(3, aVar.j6), (long) i);
            }
        }

        private void Hw(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.j6 + ", " + aVar.Hw.size() + " queued tasks");
            }
            if (!aVar.Hw.isEmpty()) {
                if (!j6(aVar) || aVar.FH == null) {
                    FH(aVar);
                    return;
                }
                while (true) {
                    f fVar = (f) aVar.Hw.peek();
                    if (fVar == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + fVar);
                        }
                        fVar.j6(aVar.FH);
                        aVar.Hw.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.j6);
                        }
                    } catch (Throwable e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.j6, e2);
                    }
                }
                if (!aVar.Hw.isEmpty()) {
                    FH(aVar);
                }
            }
        }
    }

    interface a {
        int j6();
    }

    static class b implements a {
        b() {
        }

        public int j6() {
            return 1;
        }
    }

    static class c extends b {
        c() {
        }
    }

    static class d extends c {
        d() {
        }

        public int j6() {
            return 33;
        }
    }

    private static class e {
        final IBinder DW;
        final ComponentName j6;

        public e(ComponentName componentName, IBinder iBinder) {
            this.j6 = componentName;
            this.DW = iBinder;
        }
    }

    private interface f {
        void j6(s sVar);
    }

    static {
        DW = new Object();
        Hw = new HashSet();
        v5 = new Object();
        if (VERSION.SDK_INT >= 14) {
            Zo = new d();
        } else if (VERSION.SDK_INT >= 5) {
            Zo = new c();
        } else {
            Zo = new b();
        }
        j6 = Zo.j6();
    }

    public static Set<String> j6(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (!(string == null || string.equals(FH))) {
            String[] split = string.split(":");
            Set hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (DW) {
                Hw = hashSet;
                FH = string;
            }
        }
        return Hw;
    }
}
