package p023b.p024a;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.C4156a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: b.a.cr */
public class cr {
    public static cr f2874a;
    private final String f2875b;
    private File f2876c;
    private ae f2877d;
    private long f2878e;
    private long f2879f;
    private Set<cn> f2880g;
    private C0862a f2881h;

    /* renamed from: b.a.cr.a */
    public static class C0862a {
        private Context f2872a;
        private Set<String> f2873b;

        public C0862a(Context context) {
            this.f2873b = new HashSet();
            this.f2872a = context;
        }

        public void m3789a() {
            if (!this.f2873b.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String append : this.f2873b) {
                    stringBuilder.append(append);
                    stringBuilder.append(',');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                C0888r.m3932a(this.f2872a).edit().putString("invld_id", stringBuilder.toString()).commit();
            }
        }

        public boolean m3790a(String str) {
            return !this.f2873b.contains(str);
        }

        public void m3791b() {
            Object string = C0888r.m3932a(this.f2872a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null) {
                    for (CharSequence charSequence : split) {
                        if (!TextUtils.isEmpty(charSequence)) {
                            this.f2873b.add(charSequence);
                        }
                    }
                }
            }
        }

        public void m3792b(String str) {
            this.f2873b.add(str);
        }
    }

    cr(Context context) {
        this.f2875b = "umeng_it.cache";
        this.f2877d = null;
        this.f2880g = new HashSet();
        this.f2881h = null;
        this.f2876c = new File(context.getFilesDir(), "umeng_it.cache");
        this.f2879f = C4156a.f13948j;
        this.f2881h = new C0862a(context);
        this.f2881h.m3791b();
    }

    public static synchronized cr m3793a(Context context) {
        cr crVar;
        synchronized (cr.class) {
            if (f2874a == null) {
                f2874a = new cr(context);
                f2874a.m3798a(new cs(context));
                f2874a.m3798a(new co(context));
                f2874a.m3798a(new C0844c(context));
                f2874a.m3798a(new C0841b(context));
                f2874a.m3798a(new cq(context));
                f2874a.m3798a(new cu(context));
                f2874a.m3798a(new cv());
                f2874a.m3798a(new C0865d(context));
                f2874a.m3801d();
            }
            crVar = f2874a;
        }
        return crVar;
    }

    private void m3794a(ae aeVar) {
        if (aeVar != null) {
            try {
                byte[] a;
                synchronized (this) {
                    a = new bb().m3488a(aeVar);
                }
                if (a != null) {
                    an.m3373a(this.f2876c, a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void m3795f() {
        ae aeVar = new ae();
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (cn cnVar : this.f2880g) {
            if (cnVar.m3484d()) {
                if (cnVar.m3485e() != null) {
                    hashMap.put(cnVar.m3483c(), cnVar.m3485e());
                }
                if (!(cnVar.m3486f() == null || cnVar.m3486f().isEmpty())) {
                    arrayList.addAll(cnVar.m3486f());
                }
            }
        }
        aeVar.m3163a(arrayList);
        aeVar.m3164a(hashMap);
        synchronized (this) {
            this.f2877d = aeVar;
        }
    }

    private ae m3796g() {
        InputStream fileInputStream;
        Exception e;
        Throwable th;
        if (!this.f2876c.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(this.f2876c);
            try {
                byte[] b = an.m3376b(fileInputStream);
                aw aeVar = new ae();
                new ay().m3468a(aeVar, b);
                an.m3377c(fileInputStream);
                return aeVar;
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    an.m3377c(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    an.m3377c(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            an.m3377c(fileInputStream);
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            an.m3377c(fileInputStream);
            throw th;
        }
    }

    public void m3797a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f2878e >= this.f2879f) {
            Object obj = null;
            for (cn cnVar : this.f2880g) {
                if (cnVar.m3484d()) {
                    if (cnVar.m3482b()) {
                        obj = 1;
                        if (!cnVar.m3484d()) {
                            this.f2881h.m3792b(cnVar.m3483c());
                        }
                    }
                    obj = obj;
                }
            }
            if (obj != null) {
                m3795f();
                this.f2881h.m3789a();
                m3802e();
            }
            this.f2878e = currentTimeMillis;
        }
    }

    public boolean m3798a(cn cnVar) {
        return this.f2881h.m3790a(cnVar.m3483c()) ? this.f2880g.add(cnVar) : false;
    }

    public ae m3799b() {
        return this.f2877d;
    }

    public void m3800c() {
        boolean z = false;
        for (cn cnVar : this.f2880g) {
            if (cnVar.m3484d()) {
                boolean z2;
                if (cnVar.m3486f() == null || cnVar.m3486f().isEmpty()) {
                    z2 = z;
                } else {
                    cnVar.m3481a(null);
                    z2 = true;
                }
                z = z2;
            }
        }
        if (z) {
            this.f2877d.m3170b(false);
            m3802e();
        }
    }

    public void m3801d() {
        ae g = m3796g();
        if (g != null) {
            List<cn> arrayList = new ArrayList(this.f2880g.size());
            synchronized (this) {
                this.f2877d = g;
                for (cn cnVar : this.f2880g) {
                    cnVar.m3480a(this.f2877d);
                    if (!cnVar.m3484d()) {
                        arrayList.add(cnVar);
                    }
                }
                for (cn cnVar2 : arrayList) {
                    this.f2880g.remove(cnVar2);
                }
            }
            m3795f();
        }
    }

    public void m3802e() {
        if (this.f2877d != null) {
            m3794a(this.f2877d);
        }
    }
}
