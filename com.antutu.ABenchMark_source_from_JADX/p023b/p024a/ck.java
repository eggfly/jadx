package p023b.p024a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.message.MsgConstant;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;
import p023b.p024a.C0909w.C0897d;
import p023b.p024a.C0909w.C0898e;

/* renamed from: b.a.ck */
public class ck {
    private static Context f2854a;

    /* renamed from: b.a.ck.a */
    private static final class C0861a {
        private static final ck f2853a;

        static {
            f2853a = new ck();
        }
    }

    private ck() {
        if (f2854a == null) {
        }
    }

    public static ck m3751a(Context context) {
        f2854a = context;
        return C0861a.f2853a;
    }

    public Map<String, List<C0897d>> m3752a() {
        try {
            Map<String, List<C0897d>> b = C0773a.m3070b(aa.m3074a(f2854a).m3076a());
            return b;
        } catch (Exception e) {
            ap.m3391d("upload agg date error");
            return null;
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }

    public void m3753a(cd cdVar) {
        try {
            SQLiteDatabase a = aa.m3074a(f2854a).m3076a();
            String a2 = C0773a.m3059a(a);
            String a3 = cm.m3768a(System.currentTimeMillis());
            if (a2.equals(MessageService.MSG_DB_READY_REPORT)) {
                cdVar.m3414a("faild", false);
                return;
            }
            if (a2.equals(a3)) {
                C0773a.m3071b(a, cdVar);
            } else {
                C0773a.m3065a(a, cdVar);
            }
            aa.m3074a(f2854a).m3078c();
        } catch (Exception e) {
            cdVar.m3414a(Boolean.valueOf(false), false);
            ap.m3391d("load agg data error");
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }

    public void m3754a(cd cdVar, String str, long j, long j2) {
        try {
            C0773a.m3061a(aa.m3074a(f2854a).m3077b(), str, j, j2);
            cdVar.m3414a(MsgConstant.KEY_SUCCESS, false);
        } catch (Exception e) {
            ap.m3391d("package size to big or envelopeOverflowPackageCount exception");
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }

    public void m3755a(cd cdVar, List<String> list) {
        try {
            C0773a.m3064a(cdVar, aa.m3074a(f2854a).m3077b(), (List) list);
        } catch (Exception e) {
            ap.m3391d("saveToLimitCKTable exception");
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }

    public void m3756a(cd cdVar, Map<List<String>, cf> map) {
        try {
            C0773a.m3067a(aa.m3074a(f2854a).m3077b(), map.values());
            cdVar.m3414a(MsgConstant.KEY_SUCCESS, false);
        } catch (Exception e) {
            ap.m3391d("save agg data error");
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }

    public void m3757a(cd cdVar, boolean z) {
        try {
            C0773a.m3063a(aa.m3074a(f2854a).m3077b(), z, cdVar);
        } catch (Exception e) {
            ap.m3391d("notifyUploadSuccess error");
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }

    public List<String> m3758b() {
        try {
            List<String> c = C0773a.m3072c(aa.m3074a(f2854a).m3076a());
            return c;
        } catch (Exception e) {
            ap.m3391d("loadCKToMemory exception");
            return null;
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }

    public Map<String, List<C0898e>> m3759b(cd cdVar) {
        try {
            Map<String, List<C0898e>> a = C0773a.m3060a(cdVar, aa.m3074a(f2854a).m3076a());
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }

    public void m3760b(cd cdVar, Map<String, cg> map) {
        try {
            C0773a.m3062a(aa.m3074a(f2854a).m3077b(), (Map) map, cdVar);
        } catch (Exception e) {
            ap.m3391d("arrgetated system buffer exception");
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }

    public void m3761c(cd cdVar, Map<List<String>, cf> map) {
        try {
            C0773a.m3068a(cdVar, aa.m3074a(f2854a).m3077b(), map.values());
        } catch (Exception e) {
            ap.m3391d("cacheToData error");
        } finally {
            aa.m3074a(f2854a).m3078c();
        }
    }
}
