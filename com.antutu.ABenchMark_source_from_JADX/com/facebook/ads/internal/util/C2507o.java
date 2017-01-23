package com.facebook.ads.internal.util;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.ads.internal.p127e.p128a.C2360a;
import com.facebook.ads.internal.p127e.p128a.C2374o;
import com.taobao.accs.common.Constants;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.util.o */
public class C2507o extends AsyncTask<String, Void, Void> {
    private static final String f8616a;
    private static final Set<String> f8617b;
    private Map<String, String> f8618c;
    private Map<String, String> f8619d;

    static {
        f8616a = C2507o.class.getSimpleName();
        f8617b = new HashSet();
        f8617b.add("#");
        f8617b.add("null");
    }

    public C2507o() {
        this(null, null);
    }

    public C2507o(Map<String, String> map) {
        this(map, null);
    }

    public C2507o(Map<String, String> map, Map<String, String> map2) {
        this.f8618c = map;
        this.f8619d = map2;
    }

    private String m9509a(String str, String str2, String str3) {
        if (C2510r.m9516a(str) || C2510r.m9516a(str2) || C2510r.m9516a(str3)) {
            return str;
        }
        return str + (str.contains("?") ? "&" : "?") + str2 + "=" + URLEncoder.encode(str3);
    }

    private boolean m9510a(String str) {
        C2360a c = C2498g.m9487c();
        try {
            if (this.f8619d == null || this.f8619d.size() == 0) {
                return c.m9096a(str, null).m9134a() == Constants.COMMAND_HANDSHAKE;
            } else {
                C2374o c2374o = new C2374o();
                c2374o.m9139a(this.f8619d);
                return c.m9104b(str, c2374o).m9134a() == Constants.COMMAND_HANDSHAKE;
            }
        } catch (Throwable e) {
            Log.e(f8616a, "Error opening url: " + str, e);
            return false;
        }
    }

    private String m9511b(String str) {
        try {
            str = m9509a(str, "analog", C2498g.m9472a(C2486a.m9449a()));
        } catch (Exception e) {
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.Void m9512a(java.lang.String... r6) {
        /*
        r5 = this;
        r4 = 0;
        r0 = 0;
        r0 = r6[r0];
        r1 = com.facebook.ads.internal.util.C2510r.m9516a(r0);
        if (r1 != 0) goto L_0x0012;
    L_0x000a:
        r1 = f8617b;
        r1 = r1.contains(r0);
        if (r1 == 0) goto L_0x0013;
    L_0x0012:
        return r4;
    L_0x0013:
        r0 = r5.m9511b(r0);
        r1 = r5.f8618c;
        if (r1 == 0) goto L_0x004d;
    L_0x001b:
        r1 = r5.f8618c;
        r1 = r1.isEmpty();
        if (r1 != 0) goto L_0x004d;
    L_0x0023:
        r1 = r5.f8618c;
        r1 = r1.entrySet();
        r3 = r1.iterator();
        r2 = r0;
    L_0x002e:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x004c;
    L_0x0034:
        r0 = r3.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r0 = r5.m9509a(r2, r1, r0);
        r2 = r0;
        goto L_0x002e;
    L_0x004c:
        r0 = r2;
    L_0x004d:
        r1 = 1;
    L_0x004e:
        r2 = r1 + 1;
        r3 = 2;
        if (r1 > r3) goto L_0x0012;
    L_0x0053:
        r1 = r5.m9510a(r0);
        if (r1 != 0) goto L_0x0012;
    L_0x0059:
        r1 = r2;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.util.o.a(java.lang.String[]):java.lang.Void");
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9512a((String[]) objArr);
    }
}
