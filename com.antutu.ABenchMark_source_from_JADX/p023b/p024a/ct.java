package p023b.p024a;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.umeng.analytics.C4156a;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* renamed from: b.a.ct */
public class ct {
    private static final byte[] f2898a;
    private static ct f2899e;
    private C0871q f2900b;
    private C0863a f2901c;
    private af f2902d;
    private Context f2903f;

    /* renamed from: b.a.ct.a */
    public static class C0863a {
        private int f2883a;
        private int f2884b;
        private int f2885c;
        private int f2886d;
        private int f2887e;
        private String f2888f;
        private int f2889g;
        private String f2890h;
        private int f2891i;
        private int f2892j;
        private String f2893k;
        private String f2894l;
        private String f2895m;
        private String f2896n;
        private String f2897o;

        C0863a() {
            this.f2883a = -1;
            this.f2884b = -1;
            this.f2885c = -1;
            this.f2886d = -1;
            this.f2887e = -1;
            this.f2888f = null;
            this.f2889g = -1;
            this.f2890h = null;
            this.f2891i = -1;
            this.f2892j = -1;
            this.f2893k = null;
            this.f2894l = null;
            this.f2895m = null;
            this.f2896n = null;
            this.f2897o = null;
        }

        private int m3804a(af afVar, String str) {
            if (afVar != null) {
                try {
                    if (afVar.m3199b()) {
                        ag agVar = (ag) afVar.m3194a().get(str);
                        if (agVar == null || TextUtils.isEmpty(agVar.m3222a())) {
                            return -1;
                        }
                        try {
                            return Integer.parseInt(agVar.m3222a().trim());
                        } catch (Exception e) {
                            return -1;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return -1;
                }
            }
            return -1;
        }

        private String m3805b(af afVar, String str) {
            if (afVar == null) {
                return null;
            }
            String a;
            try {
                if (!afVar.m3199b()) {
                    return null;
                }
                ag agVar = (ag) afVar.m3194a().get(str);
                if (agVar == null || TextUtils.isEmpty(agVar.m3222a())) {
                    return null;
                }
                a = agVar.m3222a();
                return a;
            } catch (Exception e) {
                e.printStackTrace();
                a = null;
            }
        }

        public int m3806a(int i) {
            return (this.f2883a != -1 && this.f2883a <= 3 && this.f2883a >= 0) ? this.f2883a : i;
        }

        public long m3807a(long j) {
            return (this.f2892j != -1 && this.f2892j >= 48) ? C4156a.f13949k * ((long) this.f2892j) : j;
        }

        public String m3808a(String str) {
            return this.f2897o != null ? this.f2897o : str;
        }

        public void m3809a(af afVar) {
            if (afVar != null) {
                this.f2883a = m3804a(afVar, "defcon");
                this.f2884b = m3804a(afVar, "latent");
                this.f2885c = m3804a(afVar, "codex");
                this.f2886d = m3804a(afVar, "report_policy");
                this.f2887e = m3804a(afVar, "report_interval");
                this.f2888f = m3805b(afVar, "client_test");
                this.f2889g = m3804a(afVar, "test_report_interval");
                this.f2890h = m3805b(afVar, "umid");
                this.f2891i = m3804a(afVar, "integrated_test");
                this.f2892j = m3804a(afVar, "latent_hours");
                this.f2893k = m3805b(afVar, "country");
                this.f2894l = m3805b(afVar, "domain_p");
                this.f2895m = m3805b(afVar, "domain_s");
                this.f2896n = m3805b(afVar, "initial_view_time");
                this.f2897o = m3805b(afVar, "track_list");
            }
        }

        public boolean m3810a() {
            return this.f2889g != -1;
        }

        public int[] m3811a(int i, int i2) {
            if (this.f2886d == -1 || !ar.m3412a(this.f2886d)) {
                return new int[]{i, i2};
            }
            if (this.f2887e == -1 || this.f2887e < 90 || this.f2887e > 86400) {
                this.f2887e = 90;
            }
            return new int[]{this.f2886d, this.f2887e * AdError.NETWORK_ERROR_CODE};
        }

        public int m3812b(int i) {
            return (this.f2884b != -1 && this.f2884b >= 0 && this.f2884b <= 1800) ? this.f2884b * AdError.NETWORK_ERROR_CODE : i;
        }

        public String m3813b(String str) {
            return this.f2893k != null ? this.f2893k : str;
        }

        public boolean m3814b() {
            return this.f2891i == 1;
        }

        public int m3815c(int i) {
            return (this.f2885c == 0 || this.f2885c == 1 || this.f2885c == -1) ? this.f2885c : i;
        }

        public String m3816c(String str) {
            return (this.f2888f == null || !C0910x.m3984a(this.f2888f)) ? str : this.f2888f;
        }

        public int m3817d(int i) {
            return (this.f2889g == -1 || this.f2889g < 90 || this.f2889g > 86400) ? i : this.f2889g * AdError.NETWORK_ERROR_CODE;
        }

        public String m3818d(String str) {
            return this.f2890h;
        }
    }

    static {
        f2898a = "pbl0".getBytes();
    }

    ct(Context context) {
        this.f2901c = new C0863a();
        this.f2902d = null;
        this.f2903f = context;
    }

    private af m3819a(af afVar, af afVar2) {
        if (afVar2 != null) {
            Map a = afVar.m3194a();
            for (Entry entry : afVar2.m3194a().entrySet()) {
                if (((ag) entry.getValue()).m3227b()) {
                    a.put(entry.getKey(), entry.getValue());
                } else {
                    a.remove(entry.getKey());
                }
            }
            afVar.m3192a(afVar2.m3200c());
            afVar.m3193a(m3825a(afVar));
        }
        return afVar;
    }

    public static synchronized ct m3820a(Context context) {
        ct ctVar;
        synchronized (ct.class) {
            if (f2899e == null) {
                f2899e = new ct(context);
                f2899e.m3830c();
            }
            ctVar = f2899e;
        }
        return ctVar;
    }

    private boolean m3821a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private boolean m3822c(af afVar) {
        if (!afVar.m3203e().equals(m3825a(afVar))) {
            return false;
        }
        for (ag agVar : afVar.m3194a().values()) {
            byte[] a = ak.m3324a(agVar.m3231e());
            byte[] a2 = m3827a(agVar);
            for (int i = 0; i < 4; i++) {
                if (a[i] != a2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private af m3823d(af afVar) {
        Map a = afVar.m3194a();
        List<String> arrayList = new ArrayList(a.size() / 2);
        for (Entry entry : a.entrySet()) {
            if (!((ag) entry.getValue()).m3227b()) {
                arrayList.add(entry.getKey());
            }
        }
        for (String remove : arrayList) {
            a.remove(remove);
        }
        return afVar;
    }

    public synchronized af m3824a() {
        return this.f2902d;
    }

    public String m3825a(af afVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : new TreeMap(afVar.m3194a()).entrySet()) {
            stringBuilder.append((String) entry.getKey());
            if (((ag) entry.getValue()).m3227b()) {
                stringBuilder.append(((ag) entry.getValue()).m3222a());
            }
            stringBuilder.append(((ag) entry.getValue()).m3228c());
            stringBuilder.append(((ag) entry.getValue()).m3231e());
        }
        stringBuilder.append(afVar.f2593b);
        return an.m3370a(stringBuilder.toString()).toLowerCase(Locale.US);
    }

    public void m3826a(C0871q c0871q) {
        this.f2900b = c0871q;
    }

    public byte[] m3827a(ag agVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(agVar.m3228c());
        byte[] array = allocate.array();
        byte[] bArr = f2898a;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    public C0863a m3828b() {
        return this.f2901c;
    }

    public void m3829b(af afVar) {
        String str = null;
        if (afVar != null && m3822c(afVar)) {
            Object obj = null;
            synchronized (this) {
                af afVar2 = this.f2902d;
                String e = afVar2 == null ? null : afVar2.m3203e();
                af d = afVar2 == null ? m3823d(afVar) : m3819a(afVar2, afVar);
                this.f2902d = d;
                if (d != null) {
                    str = d.m3203e();
                }
                if (!m3821a(e, str)) {
                    obj = 1;
                }
            }
            if (this.f2902d != null && r0 != null) {
                this.f2901c.m3809a(this.f2902d);
                if (this.f2900b != null) {
                    this.f2900b.m3856a(this.f2901c);
                }
            }
        }
    }

    public void m3830c() {
        InputStream openFileInput;
        byte[] b;
        Exception e;
        af afVar;
        Throwable th;
        InputStream inputStream = null;
        if (new File(this.f2903f.getFilesDir(), ".imprint").exists()) {
            try {
                openFileInput = this.f2903f.openFileInput(".imprint");
                try {
                    b = an.m3376b(openFileInput);
                    an.m3377c(openFileInput);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        an.m3377c(openFileInput);
                        if (b == null) {
                            try {
                                afVar = new af();
                                new ay().m3468a(afVar, b);
                                this.f2902d = afVar;
                                this.f2901c.m3809a(afVar);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openFileInput;
                        an.m3377c(inputStream);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e3 = e4;
                openFileInput = inputStream;
                e3.printStackTrace();
                an.m3377c(openFileInput);
                if (b == null) {
                    afVar = new af();
                    new ay().m3468a(afVar, b);
                    this.f2902d = afVar;
                    this.f2901c.m3809a(afVar);
                }
            } catch (Throwable th3) {
                th = th3;
                an.m3377c(inputStream);
                throw th;
            }
            if (b == null) {
                afVar = new af();
                new ay().m3468a(afVar, b);
                this.f2902d = afVar;
                this.f2901c.m3809a(afVar);
            }
        }
    }

    public void m3831d() {
        if (this.f2902d != null) {
            try {
                an.m3373a(new File(this.f2903f.getFilesDir(), ".imprint"), new bb().m3488a(this.f2902d));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
