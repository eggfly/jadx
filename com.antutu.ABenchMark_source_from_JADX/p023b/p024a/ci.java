package p023b.p024a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b.a.ci.AnonymousClass10;
import b.a.ci.AnonymousClass11;
import com.antutu.redacc.C1692R;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p023b.p024a.C0909w.C0897d;
import p023b.p024a.C0909w.C0898e;
import p023b.p024a.as;
import p023b.p024a.cd;
import p023b.p024a.ce;
import p023b.p024a.ci.10.C08461;

/* renamed from: b.a.ci */
public class ci {
    private static Context f2840i;
    private ce f2841a;
    private ck f2842b;
    private cl f2843c;
    private boolean f2844d;
    private boolean f2845e;
    private long f2846f;
    private final String f2847g;
    private final String f2848h;
    private List<String> f2849j;
    private C0856a f2850k;
    private final Thread f2851l;

    /* renamed from: b.a.ci.10 */
    class AnonymousClass10 extends as {
        final /* synthetic */ cd f2823a;
        final /* synthetic */ p023b.p024a.ci f2824b;

        /* renamed from: b.a.ci.10.1 */
        class C08461 extends cd {
            final /* synthetic */ AnonymousClass10 f2822a;

            C08461(AnonymousClass10 anonymousClass10) {
                this.f2822a = anonymousClass10;
            }

            public void m3688a(Object obj, boolean z) {
                if (obj instanceof Map) {
                    this.f2822a.f2824b.f2841a.m3658a((Map) obj);
                } else if (!(obj instanceof String) && (obj instanceof Boolean)) {
                }
                this.f2822a.f2824b.f2844d = true;
            }
        }

        AnonymousClass10(p023b.p024a.ci ciVar, cd cdVar) {
            this.f2824b = ciVar;
            this.f2823a = cdVar;
        }

        public void m3689a() {
            try {
                this.f2824b.f2842b.m3753a(new C08461(this));
                this.f2824b.m3721i();
                this.f2824b.m3729n();
                this.f2823a.m3414a(MsgConstant.KEY_SUCCESS, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b.a.ci.11 */
    class AnonymousClass11 extends cd {
        final /* synthetic */ cd f2825a;
        final /* synthetic */ p023b.p024a.ci f2826b;

        AnonymousClass11(p023b.p024a.ci ciVar, cd cdVar) {
            this.f2826b = ciVar;
            this.f2825a = cdVar;
        }

        public void m3690a(Object obj, boolean z) {
            if (obj instanceof ce) {
                this.f2826b.f2841a = (ce) obj;
            }
            this.f2825a.m3414a(MsgConstant.KEY_SUCCESS, false);
        }
    }

    /* renamed from: b.a.ci.1 */
    class C08471 implements Runnable {
        final /* synthetic */ ci f2829a;

        C08471(ci ciVar) {
            this.f2829a = ciVar;
        }

        public void run() {
            Looper.prepare();
            if (this.f2829a.f2850k == null) {
                this.f2829a.f2850k = new C0856a(this.f2829a);
            }
            this.f2829a.m3714e();
        }
    }

    /* renamed from: b.a.ci.2 */
    class C08482 extends cd {
        final /* synthetic */ ci f2830a;

        C08482(ci ciVar) {
            this.f2830a = ciVar;
        }

        public void m3693a(Object obj, boolean z) {
            if (obj instanceof String) {
                this.f2830a.f2843c.m3766b();
            }
        }
    }

    /* renamed from: b.a.ci.3 */
    class C08493 extends cd {
        final /* synthetic */ ci f2831a;

        C08493(ci ciVar) {
            this.f2831a = ciVar;
        }

        public void m3694a(Object obj, boolean z) {
            if (obj.equals(MsgConstant.KEY_SUCCESS)) {
                this.f2831a.m3724j();
            }
        }
    }

    /* renamed from: b.a.ci.4 */
    class C08504 extends cd {
        final /* synthetic */ ci f2832a;

        C08504(ci ciVar) {
            this.f2832a = ciVar;
        }

        public void m3695a(Object obj, boolean z) {
            this.f2832a.f2843c = (cl) obj;
        }
    }

    /* renamed from: b.a.ci.5 */
    class C08515 extends cd {
        final /* synthetic */ ci f2833a;

        C08515(ci ciVar) {
            this.f2833a = ciVar;
        }

        public void m3696a(Object obj, boolean z) {
            if (!obj.equals(MsgConstant.KEY_SUCCESS)) {
            }
        }
    }

    /* renamed from: b.a.ci.6 */
    class C08526 extends cd {
        final /* synthetic */ ci f2834a;

        C08526(ci ciVar) {
            this.f2834a = ciVar;
        }

        public void m3697a(Object obj, boolean z) {
            if (obj instanceof String) {
                this.f2834a.f2841a.m3661b();
            }
        }
    }

    /* renamed from: b.a.ci.7 */
    class C08537 extends cd {
        final /* synthetic */ ci f2835a;

        C08537(ci ciVar) {
            this.f2835a = ciVar;
        }

        public void m3698a(Object obj, boolean z) {
            if (obj instanceof String) {
                this.f2835a.f2843c.m3766b();
            }
        }
    }

    /* renamed from: b.a.ci.8 */
    class C08548 extends cd {
        final /* synthetic */ ci f2836a;

        C08548(ci ciVar) {
            this.f2836a = ciVar;
        }

        public void m3699a(Object obj, boolean z) {
        }
    }

    /* renamed from: b.a.ci.9 */
    class C08559 extends cd {
        final /* synthetic */ ci f2837a;

        C08559(ci ciVar) {
            this.f2837a = ciVar;
        }

        public void m3700a(Object obj, boolean z) {
            if (obj instanceof String) {
                this.f2837a.f2843c.m3766b();
            }
        }
    }

    /* renamed from: b.a.ci.a */
    private static class C0856a extends Handler {
        private final WeakReference<ci> f2838a;

        public C0856a(ci ciVar) {
            this.f2838a = new WeakReference(ciVar);
        }

        public void handleMessage(Message message) {
            if (this.f2838a != null) {
                switch (message.what) {
                    case C1692R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        sendEmptyMessageDelayed(48, cm.m3770b(System.currentTimeMillis()));
                        ci.m3705a(ci.f2840i).m3728m();
                    case C1692R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                        sendEmptyMessageDelayed(49, cm.m3771c(System.currentTimeMillis()));
                        ci.m3705a(ci.f2840i).m3727l();
                    default:
                }
            }
        }
    }

    /* renamed from: b.a.ci.b */
    private static class C0857b {
        private static final ci f2839a;

        static {
            f2839a = new ci();
        }
    }

    private ci() {
        this.f2841a = null;
        this.f2842b = null;
        this.f2843c = null;
        this.f2844d = false;
        this.f2845e = false;
        this.f2846f = 0;
        this.f2847g = "main_fest_mode";
        this.f2848h = "main_fest_timestamp";
        this.f2849j = new ArrayList();
        this.f2850k = null;
        this.f2851l = new Thread(new C08471(this));
        if (f2840i != null) {
            if (this.f2841a == null) {
                this.f2841a = new ce();
            }
            if (this.f2842b == null) {
                this.f2842b = ck.m3751a(f2840i);
            }
            if (this.f2843c == null) {
                this.f2843c = new cl();
            }
        }
        this.f2851l.start();
    }

    public static final ci m3705a(Context context) {
        f2840i = context;
        return C0857b.f2839a;
    }

    private void m3707a(ch chVar, List<String> list) {
        this.f2841a.m3656a(new cd() {
            final /* synthetic */ p023b.p024a.ci f2828a;

            {
                this.f2828a = r1;
            }

            public void m3692a(Object obj, boolean z) {
                if (obj instanceof ce) {
                    this.f2828a.f2841a = (ce) obj;
                } else if (obj instanceof Boolean) {
                    this.f2828a.m3725k();
                }
            }
        }, chVar, list, this.f2849j);
    }

    private void m3714e() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f2850k.sendEmptyMessageDelayed(48, cm.m3770b(currentTimeMillis));
        this.f2850k.sendEmptyMessageDelayed(49, cm.m3771c(currentTimeMillis));
    }

    private boolean m3716f() {
        return this.f2849j.size() < cj.m3741a().m3749d();
    }

    private void m3717g() {
        SharedPreferences a = C0888r.m3932a(f2840i);
        if (!a.getBoolean("main_fest_mode", false)) {
            this.f2845e = true;
            Editor edit = a.edit();
            edit.putBoolean("main_fest_mode", true);
            edit.putLong("main_fest_timestamp", System.currentTimeMillis());
            edit.commit();
        }
    }

    private void m3719h() {
        Editor edit = C0888r.m3932a(f2840i).edit();
        edit.putBoolean("main_fest_mode", false);
        edit.putLong("main_fest_timestamp", 0);
        edit.commit();
        this.f2845e = false;
    }

    private void m3721i() {
        SharedPreferences a = C0888r.m3932a(f2840i);
        this.f2845e = a.getBoolean("main_fest_mode", false);
        this.f2846f = a.getLong("main_fest_timestamp", 0);
    }

    private void m3724j() {
        for (Entry key : this.f2841a.m3654a().entrySet()) {
            List list = (List) key.getKey();
            if (!this.f2849j.contains(list)) {
                this.f2849j.add(br.m3619a(list));
            }
        }
        if (this.f2849j.size() > 0) {
            this.f2842b.m3755a(new cd(), this.f2849j);
        }
    }

    private void m3725k() {
        this.f2843c.m3765a(new C08504(this), C4156a.f13956r);
    }

    private void m3727l() {
        try {
            if (this.f2841a.m3654a().size() > 0) {
                this.f2842b.m3761c(new C08526(this), this.f2841a.m3654a());
            }
            if (this.f2843c.m3764a().size() > 0) {
                this.f2842b.m3760b(new C08537(this), this.f2843c.m3764a());
            }
            if (this.f2849j.size() > 0) {
                this.f2842b.m3755a(new cd(), this.f2849j);
            }
        } catch (Throwable th) {
            ap.m3381a("converyMemoryToDataTable happen error: " + th.toString());
        }
    }

    private void m3728m() {
        try {
            if (this.f2841a.m3654a().size() > 0) {
                this.f2842b.m3756a(new C08548(this), this.f2841a.m3654a());
            }
            if (this.f2843c.m3764a().size() > 0) {
                this.f2842b.m3760b(new C08559(this), this.f2843c.m3764a());
            }
            if (this.f2849j.size() > 0) {
                this.f2842b.m3755a(new cd(), this.f2849j);
            }
        } catch (Throwable th) {
            ap.m3381a("convertMemoryToCacheTable happen error: " + th.toString());
        }
    }

    private void m3729n() {
        List b = this.f2842b.m3758b();
        if (b != null) {
            this.f2849j = b;
        }
    }

    public void m3730a() {
        m3728m();
    }

    public void m3731a(long j, long j2, String str) {
        this.f2842b.m3754a(new C08515(this), str, j, j2);
    }

    public void m3732a(cd cdVar) {
        if (!this.f2844d) {
            aq.m3396b(new AnonymousClass10(this, cdVar));
        }
    }

    public void m3733a(cd cdVar, Map<List<String>, ch> map) {
        ch chVar = (ch) map.values().toArray()[0];
        List a = chVar.m3684a();
        if (this.f2849j.size() > 0 && this.f2849j.contains(br.m3619a(a))) {
            this.f2841a.m3655a(new AnonymousClass11(this, cdVar), chVar);
        } else if (this.f2845e) {
            m3707a(chVar, a);
        } else if (m3716f()) {
            String a2 = br.m3619a(a);
            if (!this.f2849j.contains(a2)) {
                this.f2849j.add(a2);
            }
            this.f2841a.m3657a(new cd() {
                final /* synthetic */ p023b.p024a.ci f2827a;

                {
                    this.f2827a = r1;
                }

                public void m3691a(Object obj, boolean z) {
                    this.f2827a.f2841a = (ce) obj;
                }
            }, a, chVar);
        } else {
            m3707a(chVar, a);
            m3717g();
        }
    }

    public void m3734a(C0909w c0909w) {
        if (c0909w.f3095b.f3032h != null) {
            c0909w.f3095b.f3032h.f2993a = m3735b(new cd());
            c0909w.f3095b.f3032h.f2994b = m3737c(new cd());
        }
    }

    public Map<String, List<C0897d>> m3735b(cd cdVar) {
        Map a = this.f2842b.m3752a();
        Map<String, List<C0897d>> hashMap = new HashMap();
        if (a == null || a.size() <= 0) {
            return null;
        }
        for (String str : this.f2849j) {
            if (a.containsKey(str)) {
                hashMap.put(str, a.get(str));
            }
        }
        return hashMap;
    }

    public void m3736b() {
        m3728m();
    }

    public Map<String, List<C0898e>> m3737c(cd cdVar) {
        if (this.f2843c.m3764a().size() > 0) {
            this.f2842b.m3760b(new C08482(this), this.f2843c.m3764a());
        }
        return this.f2842b.m3759b(new cd());
    }

    public void m3738c() {
        m3728m();
    }

    public void m3739d(cd cdVar) {
        boolean z = false;
        if (this.f2845e) {
            if (this.f2846f == 0) {
                m3721i();
            }
            z = cm.m3769a(System.currentTimeMillis(), this.f2846f);
        }
        if (!z) {
            m3719h();
            this.f2849j.clear();
        }
        this.f2843c.m3766b();
        this.f2842b.m3757a(new C08493(this), z);
    }
}
