package android.support.v4.app;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings.Secure;
import android.support.v4.app.INotificationSideChannel.Stub;
import android.util.Log;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NotificationManagerCompat {
    private static final int f369a;
    private static final Object f370b;
    private static String f371c;
    private static Set<String> f372d;
    private static final Object f373e;
    private static final Impl f374f;

    private interface Task {
        void m467a(INotificationSideChannel iNotificationSideChannel);
    }

    private static class CancelTask implements Task {
        final String f350a;
        final int f351b;
        final String f352c;
        final boolean f353d;

        public void m468a(INotificationSideChannel iNotificationSideChannel) {
            if (this.f353d) {
                iNotificationSideChannel.m414a(this.f350a);
            } else {
                iNotificationSideChannel.m415a(this.f350a, this.f351b, this.f352c);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.f350a);
            stringBuilder.append(", id:").append(this.f351b);
            stringBuilder.append(", tag:").append(this.f352c);
            stringBuilder.append(", all:").append(this.f353d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    interface Impl {
        int m469a();
    }

    static class ImplBase implements Impl {
        ImplBase() {
        }

        public int m470a() {
            return 1;
        }
    }

    static class ImplEclair extends ImplBase {
        ImplEclair() {
        }
    }

    static class ImplIceCreamSandwich extends ImplEclair {
        ImplIceCreamSandwich() {
        }

        public int m471a() {
            return 33;
        }
    }

    private static class NotifyTask implements Task {
        final String f354a;
        final int f355b;
        final String f356c;
        final Notification f357d;

        public void m472a(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.m416a(this.f354a, this.f355b, this.f356c, this.f357d);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.f354a);
            stringBuilder.append(", id:").append(this.f355b);
            stringBuilder.append(", tag:").append(this.f356c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class ServiceConnectedEvent {
        final ComponentName f358a;
        final IBinder f359b;

        public ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f358a = componentName;
            this.f359b = iBinder;
        }
    }

    private static class SideChannelManager implements ServiceConnection, Callback {
        private final Context f365a;
        private final Handler f366b;
        private final Map<ComponentName, ListenerRecord> f367c;
        private Set<String> f368d;

        private static class ListenerRecord {
            public final ComponentName f360a;
            public boolean f361b;
            public INotificationSideChannel f362c;
            public LinkedList<Task> f363d;
            public int f364e;

            public ListenerRecord(ComponentName componentName) {
                this.f361b = false;
                this.f363d = new LinkedList();
                this.f364e = 0;
                this.f360a = componentName;
            }
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    m476a((Task) message.obj);
                    return true;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                    m475a(serviceConnectedEvent.f358a, serviceConnectedEvent.f359b);
                    return true;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    m474a((ComponentName) message.obj);
                    return true;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    m478b((ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        private void m476a(Task task) {
            m473a();
            for (ListenerRecord listenerRecord : this.f367c.values()) {
                listenerRecord.f363d.add(task);
                m481d(listenerRecord);
            }
        }

        private void m475a(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = (ListenerRecord) this.f367c.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.f362c = Stub.m420a(iBinder);
                listenerRecord.f364e = 0;
                m481d(listenerRecord);
            }
        }

        private void m474a(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.f367c.get(componentName);
            if (listenerRecord != null) {
                m479b(listenerRecord);
            }
        }

        private void m478b(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.f367c.get(componentName);
            if (listenerRecord != null) {
                m481d(listenerRecord);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f366b.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f366b.obtainMessage(2, componentName).sendToTarget();
        }

        private void m473a() {
            Set a = NotificationManagerCompat.m483a(this.f365a);
            if (!a.equals(this.f368d)) {
                this.f368d = a;
                List<ResolveInfo> queryIntentServices = this.f365a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                Set<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (a.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f367c.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f367c.put(componentName2, new ListenerRecord(componentName2));
                    }
                }
                Iterator it = this.f367c.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        m479b((ListenerRecord) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        private boolean m477a(ListenerRecord listenerRecord) {
            if (listenerRecord.f361b) {
                return true;
            }
            listenerRecord.f361b = this.f365a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.f360a), this, NotificationManagerCompat.f369a);
            if (listenerRecord.f361b) {
                listenerRecord.f364e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + listenerRecord.f360a);
                this.f365a.unbindService(this);
            }
            return listenerRecord.f361b;
        }

        private void m479b(ListenerRecord listenerRecord) {
            if (listenerRecord.f361b) {
                this.f365a.unbindService(this);
                listenerRecord.f361b = false;
            }
            listenerRecord.f362c = null;
        }

        private void m480c(ListenerRecord listenerRecord) {
            if (!this.f366b.hasMessages(3, listenerRecord.f360a)) {
                listenerRecord.f364e++;
                if (listenerRecord.f364e > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + listenerRecord.f363d.size() + " tasks to " + listenerRecord.f360a + " after " + listenerRecord.f364e + " retries");
                    listenerRecord.f363d.clear();
                    return;
                }
                int i = (1 << (listenerRecord.f364e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f366b.sendMessageDelayed(this.f366b.obtainMessage(3, listenerRecord.f360a), (long) i);
            }
        }

        private void m481d(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + listenerRecord.f360a + ", " + listenerRecord.f363d.size() + " queued tasks");
            }
            if (!listenerRecord.f363d.isEmpty()) {
                if (!m477a(listenerRecord) || listenerRecord.f362c == null) {
                    m480c(listenerRecord);
                    return;
                }
                while (true) {
                    Task task = (Task) listenerRecord.f363d.peek();
                    if (task == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + task);
                        }
                        task.m467a(listenerRecord.f362c);
                        listenerRecord.f363d.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + listenerRecord.f360a);
                        }
                    } catch (Throwable e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + listenerRecord.f360a, e2);
                    }
                }
                if (!listenerRecord.f363d.isEmpty()) {
                    m480c(listenerRecord);
                }
            }
        }
    }

    static {
        f370b = new Object();
        f372d = new HashSet();
        f373e = new Object();
        if (VERSION.SDK_INT >= 14) {
            f374f = new ImplIceCreamSandwich();
        } else if (VERSION.SDK_INT >= 5) {
            f374f = new ImplEclair();
        } else {
            f374f = new ImplBase();
        }
        f369a = f374f.m469a();
    }

    public static Set<String> m483a(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (!(string == null || string.equals(f371c))) {
            String[] split = string.split(":");
            Set hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (f370b) {
                f372d = hashSet;
                f371c = string;
            }
        }
        return f372d;
    }
}
