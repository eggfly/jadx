package com.xiaomi.mistatistic.sdk.controller;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.mistatistic.sdk.BuildSetting;
import com.xiaomi.mistatistic.sdk.CustomSettings;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.data.AbstractEvent;
import com.xiaomi.mistatistic.sdk.data.C0605f;
import com.xiaomi.mistatistic.sdk.data.C0606g;
import com.xiaomi.mistatistic.sdk.data.StatEventPojo;
import com.xiaomi.xmsf.push.service.C0621b;
import com.xiaomi.xmsf.push.service.C0621b.C0623a;
import java.util.ArrayList;
import java.util.List;

public abstract class LocalEventRecorder {
    private static volatile C0621b f4675a;
    private static volatile boolean f4676b;
    private static List<AbstractEvent> f4677c;
    private static Object f4678d;
    private static ServiceConnection f4679e;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.LocalEventRecorder.1 */
    final class C05351 implements C0523a {
        final /* synthetic */ AbstractEvent f4672a;

        C05351(AbstractEvent abstractEvent) {
            this.f4672a = abstractEvent;
        }

        public void m6292a() {
            LocalEventRecorder.m6305c(this.f4672a);
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.LocalEventRecorder.2 */
    final class C05362 implements C0523a {
        final /* synthetic */ Context f4673a;

        C05362(Context context) {
            this.f4673a = context;
        }

        public void m6293a() {
            try {
                if (LocalEventRecorder.f4676b) {
                    this.f4673a.unbindService(LocalEventRecorder.f4679e);
                    LocalEventRecorder.f4676b = false;
                    LocalEventRecorder.f4675a = null;
                    C0566h.m6415a("LER", "unbind StatSystemService success");
                    return;
                }
                C0566h.m6415a("LER", "StatSystemService is already disconnected");
            } catch (Throwable e) {
                C0566h.m6418a("", e);
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.LocalEventRecorder.3 */
    final class C05373 implements ServiceConnection {
        C05373() {
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0566h.m6415a("LER", "IStatService has unexpectedly disconnected");
            LocalEventRecorder.f4675a = null;
            LocalEventRecorder.f4676b = false;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                C0566h.m6415a("LER", "IStatService connected");
                LocalEventRecorder.f4675a = C0623a.m6617a(iBinder);
                LocalEventRecorder.f4676b = true;
                if (LocalEventRecorder.f4675a != null) {
                    synchronized (LocalEventRecorder.f4678d) {
                        for (AbstractEvent b : LocalEventRecorder.f4677c) {
                            LocalEventRecorder.f4675a.m6615a(b.m6542b().toString());
                            C0566h.m6415a("LER", "insert a reserved event into IStatService");
                        }
                        C0566h.m6415a("LER", "pending eventList size: " + LocalEventRecorder.f4677c.size());
                        LocalEventRecorder.f4677c.clear();
                    }
                }
            } catch (Throwable e) {
                C0566h.m6418a("", e);
            } catch (Throwable e2) {
                C0566h.m6418a("", e2);
                synchronized (LocalEventRecorder.f4678d) {
                }
                LocalEventRecorder.f4677c.clear();
            } catch (Throwable e22) {
                C0566h.m6418a("", e22);
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.LocalEventRecorder.a */
    private static class C0538a implements C0523a {
        private AbstractEvent f4674a;

        public C0538a(AbstractEvent abstractEvent) {
            this.f4674a = abstractEvent;
        }

        public void m6294a() {
            StatEventPojo c = this.f4674a.m6543c();
            C0559f c0559f = new C0559f();
            if ((this.f4674a instanceof C0605f) || (this.f4674a instanceof C0606g)) {
                String str = c.f4823c;
                String str2 = c.f4821a;
                StatEventPojo a = c0559f.m6378a(str2, str);
                if (a == null || !c.f4824d.equals(a.f4824d)) {
                    c0559f.m6381a(c);
                    C0566h.m6419b("LocalEventRecordingJob insert event with new key");
                    return;
                }
                c0559f.m6382a(str, str2, c.f4825e);
                C0566h.m6419b("LocalEventRecordingJob update event by key and category");
                return;
            }
            c0559f.m6381a(c);
            C0566h.m6419b("LocalEventRecordingJob insert new event");
        }
    }

    static {
        f4675a = null;
        f4676b = false;
        f4677c = new ArrayList();
        f4678d = new Object();
        f4679e = new C05373();
    }

    public static void m6297a(AbstractEvent abstractEvent) {
        Context a = C0551c.m6352a();
        if (a == null) {
            C0566h.m6415a("LER", "mistats is not initialized properly.");
        } else if (BuildSetting.m6244c()) {
            C0566h.m6415a("LER", "disable local event upload for CTA build");
        } else if (CustomSettings.m6254b()) {
            C0566h.m6420b("LER", "insert event use systemstatsvc");
            C0555d.m6362a().m6365a(new C05351(abstractEvent));
        } else if (!BuildSetting.m6241a(a) || m6299a(abstractEvent.m6541a())) {
            C0555d.m6362a().m6365a(new C0538a(abstractEvent));
            C0596p.m6514a().m6519c();
        } else {
            C0566h.m6415a("LER", "disabled local event upload, event category:" + abstractEvent.m6541a());
        }
    }

    private static boolean m6299a(String str) {
        return "mistat_basic".equals(str) || "mistat_session".equals(str);
    }

    private static void m6305c(AbstractEvent abstractEvent) {
        try {
            Context a = C0551c.m6352a();
            m6296a(a);
            if (f4675a != null) {
                f4675a.m6615a(abstractEvent.m6542b().toString());
                C0566h.m6420b("LER", "sysservice insert a event");
            } else {
                C0566h.m6415a("LER", "StatSystemService is null, insert event into eventList");
                synchronized (f4678d) {
                    f4677c.add(abstractEvent);
                }
            }
            m6302b(a);
        } catch (Throwable th) {
            C0566h.m6416a("LER", "insertEventUseSystemService exception: ", th);
        }
    }

    private static void m6296a(Context context) {
        if (f4676b) {
            C0566h.m6415a("LER", "StatSystemService is already binded");
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.xmsf.push.service.StatService");
        context.bindService(intent, f4679e, 1);
        f4676b = true;
        C0566h.m6415a("LER", "bind StatSystemService success");
    }

    private static void m6302b(Context context) {
        C0555d.m6362a().m6366a(new C05362(context), 10000);
    }
}
