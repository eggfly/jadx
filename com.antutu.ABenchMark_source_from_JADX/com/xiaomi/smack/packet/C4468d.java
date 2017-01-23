package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.smack.util.C4496g;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.smack.packet.d */
public abstract class C4468d {
    protected static final String f15333a;
    public static final DateFormat f15334b;
    private static String f15335c;
    private static String f15336d;
    private static long f15337e;
    private String f15338f;
    private String f15339g;
    private String f15340h;
    private String f15341i;
    private String f15342j;
    private String f15343k;
    private List<C4479a> f15344l;
    private final Map<String, Object> f15345m;
    private C4488h f15346n;

    static {
        f15333a = Locale.getDefault().getLanguage().toLowerCase();
        f15335c = null;
        f15334b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f15334b.setTimeZone(TimeZone.getTimeZone("UTC"));
        f15336d = C4496g.m18646a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        f15337e = 0;
    }

    public C4468d() {
        this.f15338f = f15335c;
        this.f15339g = null;
        this.f15340h = null;
        this.f15341i = null;
        this.f15342j = null;
        this.f15343k = null;
        this.f15344l = new CopyOnWriteArrayList();
        this.f15345m = new HashMap();
        this.f15346n = null;
    }

    public C4468d(Bundle bundle) {
        this.f15338f = f15335c;
        this.f15339g = null;
        this.f15340h = null;
        this.f15341i = null;
        this.f15342j = null;
        this.f15343k = null;
        this.f15344l = new CopyOnWriteArrayList();
        this.f15345m = new HashMap();
        this.f15346n = null;
        this.f15340h = bundle.getString("ext_to");
        this.f15341i = bundle.getString("ext_from");
        this.f15342j = bundle.getString("ext_chid");
        this.f15339g = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f15344l = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C4479a a = C4479a.m18568a((Bundle) parcelable);
                if (a != null) {
                    this.f15344l.add(a);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f15346n = new C4488h(bundle2);
        }
    }

    public static synchronized String m18508j() {
        String stringBuilder;
        synchronized (C4468d.class) {
            StringBuilder append = new StringBuilder().append(f15336d);
            long j = f15337e;
            f15337e = 1 + j;
            stringBuilder = append.append(Long.toString(j)).toString();
        }
        return stringBuilder;
    }

    public static String m18509u() {
        return f15333a;
    }

    public abstract String m18510a();

    public void m18511a(C4479a c4479a) {
        this.f15344l.add(c4479a);
    }

    public void m18512a(C4488h c4488h) {
        this.f15346n = c4488h;
    }

    public C4479a m18513b(String str, String str2) {
        for (C4479a c4479a : this.f15344l) {
            if ((str2 == null || str2.equals(c4479a.m18573b())) && str.equals(c4479a.m18571a())) {
                return c4479a;
            }
        }
        return null;
    }

    public Bundle m18514c() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f15338f)) {
            bundle.putString("ext_ns", this.f15338f);
        }
        if (!TextUtils.isEmpty(this.f15341i)) {
            bundle.putString("ext_from", this.f15341i);
        }
        if (!TextUtils.isEmpty(this.f15340h)) {
            bundle.putString("ext_to", this.f15340h);
        }
        if (!TextUtils.isEmpty(this.f15339g)) {
            bundle.putString("ext_pkt_id", this.f15339g);
        }
        if (!TextUtils.isEmpty(this.f15342j)) {
            bundle.putString("ext_chid", this.f15342j);
        }
        if (this.f15346n != null) {
            bundle.putBundle("ext_ERROR", this.f15346n.m18620c());
        }
        if (this.f15344l != null) {
            Parcelable[] parcelableArr = new Bundle[this.f15344l.size()];
            int i = 0;
            for (C4479a e : this.f15344l) {
                int i2;
                Bundle e2 = e.m18577e();
                if (e2 != null) {
                    i2 = i + 1;
                    parcelableArr[i] = e2;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            bundle.putParcelableArray("ext_exts", parcelableArr);
        }
        return bundle;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r4 != r5) goto L_0x0006;
    L_0x0004:
        r1 = r0;
    L_0x0005:
        return r1;
    L_0x0006:
        if (r5 == 0) goto L_0x0005;
    L_0x0008:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 != r3) goto L_0x0005;
    L_0x0012:
        r5 = (com.xiaomi.smack.packet.C4468d) r5;
        r2 = r4.f15346n;
        if (r2 == 0) goto L_0x0083;
    L_0x0018:
        r2 = r4.f15346n;
        r3 = r5.f15346n;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0022:
        r2 = r4.f15341i;
        if (r2 == 0) goto L_0x0089;
    L_0x0026:
        r2 = r4.f15341i;
        r3 = r5.f15341i;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0030:
        r2 = r4.f15344l;
        r3 = r5.f15344l;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x003a:
        r2 = r4.f15339g;
        if (r2 == 0) goto L_0x008f;
    L_0x003e:
        r2 = r4.f15339g;
        r3 = r5.f15339g;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0048:
        r2 = r4.f15342j;
        if (r2 == 0) goto L_0x0095;
    L_0x004c:
        r2 = r4.f15342j;
        r3 = r5.f15342j;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0056:
        r2 = r4.f15345m;
        if (r2 == 0) goto L_0x009b;
    L_0x005a:
        r2 = r4.f15345m;
        r3 = r5.f15345m;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0064:
        r2 = r4.f15340h;
        if (r2 == 0) goto L_0x00a1;
    L_0x0068:
        r2 = r4.f15340h;
        r3 = r5.f15340h;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0072:
        r2 = r4.f15338f;
        if (r2 == 0) goto L_0x00a7;
    L_0x0076:
        r2 = r4.f15338f;
        r3 = r5.f15338f;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0081;
    L_0x0080:
        r0 = r1;
    L_0x0081:
        r1 = r0;
        goto L_0x0005;
    L_0x0083:
        r2 = r5.f15346n;
        if (r2 == 0) goto L_0x0022;
    L_0x0087:
        goto L_0x0005;
    L_0x0089:
        r2 = r5.f15341i;
        if (r2 == 0) goto L_0x0030;
    L_0x008d:
        goto L_0x0005;
    L_0x008f:
        r2 = r5.f15339g;
        if (r2 == 0) goto L_0x0048;
    L_0x0093:
        goto L_0x0005;
    L_0x0095:
        r2 = r5.f15342j;
        if (r2 == 0) goto L_0x0056;
    L_0x0099:
        goto L_0x0005;
    L_0x009b:
        r2 = r5.f15345m;
        if (r2 == 0) goto L_0x0064;
    L_0x009f:
        goto L_0x0005;
    L_0x00a1:
        r2 = r5.f15340h;
        if (r2 == 0) goto L_0x0072;
    L_0x00a5:
        goto L_0x0005;
    L_0x00a7:
        r2 = r5.f15338f;
        if (r2 != 0) goto L_0x0080;
    L_0x00ab:
        goto L_0x0081;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.packet.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f15342j != null ? this.f15342j.hashCode() : 0) + (((this.f15341i != null ? this.f15341i.hashCode() : 0) + (((this.f15340h != null ? this.f15340h.hashCode() : 0) + (((this.f15339g != null ? this.f15339g.hashCode() : 0) + ((this.f15338f != null ? this.f15338f.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31) + this.f15344l.hashCode()) * 31) + this.f15345m.hashCode()) * 31;
        if (this.f15346n != null) {
            i = this.f15346n.hashCode();
        }
        return hashCode + i;
    }

    public String m18515k() {
        if ("ID_NOT_AVAILABLE".equals(this.f15339g)) {
            return null;
        }
        if (this.f15339g == null) {
            this.f15339g = C4468d.m18508j();
        }
        return this.f15339g;
    }

    public void m18516k(String str) {
        this.f15339g = str;
    }

    public String m18517l() {
        return this.f15342j;
    }

    public void m18518l(String str) {
        this.f15342j = str;
    }

    public String m18519m() {
        return this.f15340h;
    }

    public void m18520m(String str) {
        this.f15340h = str;
    }

    public String m18521n() {
        return this.f15341i;
    }

    public void m18522n(String str) {
        this.f15341i = str;
    }

    public String m18523o() {
        return this.f15343k;
    }

    public void m18524o(String str) {
        this.f15343k = str;
    }

    public C4479a m18525p(String str) {
        return m18513b(str, null);
    }

    public C4488h m18526p() {
        return this.f15346n;
    }

    public synchronized Object m18527q(String str) {
        return this.f15345m == null ? null : this.f15345m.get(str);
    }

    public synchronized Collection<C4479a> m18528q() {
        return this.f15344l == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(this.f15344l));
    }

    public synchronized Collection<String> m18529r() {
        return this.f15345m == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(this.f15345m.keySet()));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected synchronized java.lang.String m18530s() {
        /*
        r8 = this;
        r4 = 0;
        monitor-enter(r8);
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0023 }
        r6.<init>();	 Catch:{ all -> 0x0023 }
        r1 = r8.m18528q();	 Catch:{ all -> 0x0023 }
        r2 = r1.iterator();	 Catch:{ all -> 0x0023 }
    L_0x000f:
        r1 = r2.hasNext();	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x0026;
    L_0x0015:
        r1 = r2.next();	 Catch:{ all -> 0x0023 }
        r1 = (com.xiaomi.smack.packet.C4478e) r1;	 Catch:{ all -> 0x0023 }
        r1 = r1.m18567d();	 Catch:{ all -> 0x0023 }
        r6.append(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000f;
    L_0x0023:
        r1 = move-exception;
        monitor-exit(r8);
        throw r1;
    L_0x0026:
        r1 = r8.f15345m;	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x0149;
    L_0x002a:
        r1 = r8.f15345m;	 Catch:{ all -> 0x0023 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x0149;
    L_0x0032:
        r1 = "<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">";
        r6.append(r1);	 Catch:{ all -> 0x0023 }
        r1 = r8.m18529r();	 Catch:{ all -> 0x0023 }
        r7 = r1.iterator();	 Catch:{ all -> 0x0023 }
    L_0x003f:
        r1 = r7.hasNext();	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x0144;
    L_0x0045:
        r1 = r7.next();	 Catch:{ all -> 0x0023 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0023 }
        r2 = r8.m18527q(r1);	 Catch:{ all -> 0x0023 }
        r3 = "<property>";
        r6.append(r3);	 Catch:{ all -> 0x0023 }
        r3 = "<name>";
        r3 = r6.append(r3);	 Catch:{ all -> 0x0023 }
        r1 = com.xiaomi.smack.util.C4496g.m18647a(r1);	 Catch:{ all -> 0x0023 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0023 }
        r3 = "</name>";
        r1.append(r3);	 Catch:{ all -> 0x0023 }
        r1 = "<value type=\"";
        r6.append(r1);	 Catch:{ all -> 0x0023 }
        r1 = r2 instanceof java.lang.Integer;	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x0085;
    L_0x0070:
        r1 = "integer\">";
        r1 = r6.append(r1);	 Catch:{ all -> 0x0023 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0023 }
        r2 = "</value>";
        r1.append(r2);	 Catch:{ all -> 0x0023 }
    L_0x007f:
        r1 = "</property>";
        r6.append(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x003f;
    L_0x0085:
        r1 = r2 instanceof java.lang.Long;	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x0099;
    L_0x0089:
        r1 = "long\">";
        r1 = r6.append(r1);	 Catch:{ all -> 0x0023 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0023 }
        r2 = "</value>";
        r1.append(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x007f;
    L_0x0099:
        r1 = r2 instanceof java.lang.Float;	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x00ad;
    L_0x009d:
        r1 = "float\">";
        r1 = r6.append(r1);	 Catch:{ all -> 0x0023 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0023 }
        r2 = "</value>";
        r1.append(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x007f;
    L_0x00ad:
        r1 = r2 instanceof java.lang.Double;	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x00c1;
    L_0x00b1:
        r1 = "double\">";
        r1 = r6.append(r1);	 Catch:{ all -> 0x0023 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0023 }
        r2 = "</value>";
        r1.append(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x007f;
    L_0x00c1:
        r1 = r2 instanceof java.lang.Boolean;	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x00d5;
    L_0x00c5:
        r1 = "boolean\">";
        r1 = r6.append(r1);	 Catch:{ all -> 0x0023 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0023 }
        r2 = "</value>";
        r1.append(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x007f;
    L_0x00d5:
        r1 = r2 instanceof java.lang.String;	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x00ef;
    L_0x00d9:
        r1 = "string\">";
        r6.append(r1);	 Catch:{ all -> 0x0023 }
        r0 = r2;
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0023 }
        r1 = r0;
        r1 = com.xiaomi.smack.util.C4496g.m18647a(r1);	 Catch:{ all -> 0x0023 }
        r6.append(r1);	 Catch:{ all -> 0x0023 }
        r1 = "</value>";
        r6.append(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x007f;
    L_0x00ef:
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0121, all -> 0x0136 }
        r5.<init>();	 Catch:{ Exception -> 0x0121, all -> 0x0136 }
        r3 = new java.io.ObjectOutputStream;	 Catch:{ Exception -> 0x0160, all -> 0x0157 }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0160, all -> 0x0157 }
        r3.writeObject(r2);	 Catch:{ Exception -> 0x0164, all -> 0x015a }
        r1 = "java-object\">";
        r6.append(r1);	 Catch:{ Exception -> 0x0164, all -> 0x015a }
        r1 = r5.toByteArray();	 Catch:{ Exception -> 0x0164, all -> 0x015a }
        r1 = com.xiaomi.smack.util.C4496g.m18649a(r1);	 Catch:{ Exception -> 0x0164, all -> 0x015a }
        r1 = r6.append(r1);	 Catch:{ Exception -> 0x0164, all -> 0x015a }
        r2 = "</value>";
        r1.append(r2);	 Catch:{ Exception -> 0x0164, all -> 0x015a }
        if (r3 == 0) goto L_0x0117;
    L_0x0114:
        r3.close();	 Catch:{ Exception -> 0x014f }
    L_0x0117:
        if (r5 == 0) goto L_0x007f;
    L_0x0119:
        r5.close();	 Catch:{ Exception -> 0x011e }
        goto L_0x007f;
    L_0x011e:
        r1 = move-exception;
        goto L_0x007f;
    L_0x0121:
        r1 = move-exception;
        r2 = r4;
        r3 = r4;
    L_0x0124:
        r1.printStackTrace();	 Catch:{ all -> 0x015c }
        if (r2 == 0) goto L_0x012c;
    L_0x0129:
        r2.close();	 Catch:{ Exception -> 0x0151 }
    L_0x012c:
        if (r3 == 0) goto L_0x007f;
    L_0x012e:
        r3.close();	 Catch:{ Exception -> 0x0133 }
        goto L_0x007f;
    L_0x0133:
        r1 = move-exception;
        goto L_0x007f;
    L_0x0136:
        r1 = move-exception;
        r3 = r4;
        r5 = r4;
    L_0x0139:
        if (r3 == 0) goto L_0x013e;
    L_0x013b:
        r3.close();	 Catch:{ Exception -> 0x0153 }
    L_0x013e:
        if (r5 == 0) goto L_0x0143;
    L_0x0140:
        r5.close();	 Catch:{ Exception -> 0x0155 }
    L_0x0143:
        throw r1;	 Catch:{ all -> 0x0023 }
    L_0x0144:
        r1 = "</properties>";
        r6.append(r1);	 Catch:{ all -> 0x0023 }
    L_0x0149:
        r1 = r6.toString();	 Catch:{ all -> 0x0023 }
        monitor-exit(r8);
        return r1;
    L_0x014f:
        r1 = move-exception;
        goto L_0x0117;
    L_0x0151:
        r1 = move-exception;
        goto L_0x012c;
    L_0x0153:
        r2 = move-exception;
        goto L_0x013e;
    L_0x0155:
        r2 = move-exception;
        goto L_0x0143;
    L_0x0157:
        r1 = move-exception;
        r3 = r4;
        goto L_0x0139;
    L_0x015a:
        r1 = move-exception;
        goto L_0x0139;
    L_0x015c:
        r1 = move-exception;
        r5 = r3;
        r3 = r2;
        goto L_0x0139;
    L_0x0160:
        r1 = move-exception;
        r2 = r4;
        r3 = r5;
        goto L_0x0124;
    L_0x0164:
        r1 = move-exception;
        r2 = r3;
        r3 = r5;
        goto L_0x0124;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.packet.d.s():java.lang.String");
    }

    public String m18531t() {
        return this.f15338f;
    }
}
