package p023b.p024a;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import p023b.p024a.ct.C0863a;

/* renamed from: b.a.x */
public class C0910x implements C0871q {
    private static C0910x f3096h;
    private boolean f3097a;
    private int f3098b;
    private int f3099c;
    private int f3100d;
    private float f3101e;
    private float f3102f;
    private Context f3103g;

    static {
        f3096h = null;
    }

    private C0910x(Context context, String str, int i) {
        this.f3097a = false;
        this.f3098b = -1;
        this.f3099c = -1;
        this.f3100d = -1;
        this.f3101e = 0.0f;
        this.f3102f = 0.0f;
        this.f3103g = null;
        this.f3103g = context;
        m3990a(str, i);
    }

    public static synchronized C0910x m3983a(Context context) {
        C0910x c0910x;
        synchronized (C0910x.class) {
            if (f3096h == null) {
                C0863a b = ct.m3820a(context).m3828b();
                f3096h = new C0910x(context, b.m3816c(null), b.m3817d(0));
            }
            c0910x = f3096h;
        }
        return c0910x;
    }

    public static boolean m3984a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\|");
        if (split.length != 6) {
            return false;
        }
        if (split[0].startsWith("SIG7") && split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP).length) {
            return true;
        }
        if (!split[0].startsWith("FIXED")) {
            return false;
        }
        int length = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP).length;
        int parseInt = Integer.parseInt(split[1]);
        return length >= parseInt && parseInt >= 1;
    }

    private float m3985b(String str, int i) {
        int i2 = i * 2;
        return str == null ? 0.0f : ((float) Integer.valueOf(str.substring(i2, i2 + 5), 16).intValue()) / 1048576.0f;
    }

    private void m3986b(String str) {
        if (str != null) {
            String[] split = str.split("\\|");
            if (this.f3101e > (split[2].equals("SIG13") ? Float.valueOf(split[3]).floatValue() : 0.0f)) {
                this.f3097a = false;
                return;
            }
            String[] split2;
            float[] fArr = null;
            if (split[0].equals("SIG7")) {
                split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                float[] fArr2 = new float[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    fArr2[i] = Float.valueOf(split2[i]).floatValue();
                }
                fArr = fArr2;
            }
            int[] iArr = null;
            if (split[4].equals("RPT")) {
                split2 = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int[] iArr2 = new int[split2.length];
                for (int i2 = 0; i2 < split2.length; i2++) {
                    iArr2[i2] = Integer.valueOf(split2[i2]).intValue();
                }
                iArr = iArr2;
            } else if (split[4].equals("DOM")) {
                if (am.m3354l(this.f3103g)) {
                    this.f3097a = false;
                    return;
                }
                try {
                    split2 = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    iArr = new int[split2.length];
                    for (int i3 = 0; i3 < split2.length; i3++) {
                        iArr[i3] = Integer.valueOf(split2[i3]).intValue();
                    }
                } catch (Exception e) {
                }
            }
            float f = 0.0f;
            int i4 = 0;
            while (i4 < fArr.length) {
                f += fArr[i4];
                if (this.f3102f < f) {
                    break;
                }
                i4++;
            }
            i4 = -1;
            if (i4 != -1) {
                this.f3097a = true;
                this.f3100d = i4 + 1;
                if (iArr != null) {
                    this.f3098b = iArr[i4];
                    return;
                }
                return;
            }
            this.f3097a = false;
        }
    }

    private void m3987c(String str) {
        if (str != null) {
            String[] split = str.split("\\|");
            float f = 0.0f;
            if (split[2].equals("SIG13")) {
                f = Float.valueOf(split[3]).floatValue();
            }
            if (this.f3101e > f) {
                this.f3097a = false;
                return;
            }
            int intValue = split[0].equals("FIXED") ? Integer.valueOf(split[1]).intValue() : -1;
            int[] iArr = null;
            String[] split2;
            if (split[4].equals("RPT")) {
                split2 = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int[] iArr2 = new int[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    iArr2[i] = Integer.valueOf(split2[i]).intValue();
                }
                iArr = iArr2;
            } else if (split[4].equals("DOM")) {
                if (am.m3354l(this.f3103g)) {
                    this.f3097a = false;
                    return;
                }
                try {
                    split2 = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    iArr = new int[split2.length];
                    for (int i2 = 0; i2 < split2.length; i2++) {
                        iArr[i2] = Integer.valueOf(split2[i2]).intValue();
                    }
                } catch (Exception e) {
                }
            }
            if (intValue != -1) {
                this.f3097a = true;
                this.f3100d = intValue;
                if (iArr != null) {
                    this.f3098b = iArr[intValue - 1];
                    return;
                }
                return;
            }
            this.f3097a = false;
        }
    }

    public void m3988a(C0863a c0863a) {
        m3990a(c0863a.m3816c(null), c0863a.m3817d(0));
    }

    public void m3989a(C0909w c0909w) {
        if (this.f3097a) {
            c0909w.f3095b.f3030f.put("client_test", Integer.valueOf(this.f3100d));
        }
    }

    public void m3990a(String str, int i) {
        this.f3099c = i;
        String a = cp.m3776a(this.f3103g);
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(str)) {
            this.f3097a = false;
            return;
        }
        try {
            this.f3101e = m3985b(a, 12);
            this.f3102f = m3985b(a, 6);
            if (str.startsWith("SIG7")) {
                m3986b(str);
            } else if (str.startsWith("FIXED")) {
                m3987c(str);
            }
        } catch (Throwable e) {
            this.f3097a = false;
            ap.m3383a("v:" + str, e);
        }
    }

    public boolean m3991a() {
        return this.f3097a;
    }

    public int m3992b() {
        return this.f3098b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" p13:");
        stringBuilder.append(this.f3101e);
        stringBuilder.append(" p07:");
        stringBuilder.append(this.f3102f);
        stringBuilder.append(" policy:");
        stringBuilder.append(this.f3098b);
        stringBuilder.append(" interval:");
        stringBuilder.append(this.f3099c);
        return stringBuilder.toString();
    }
}
