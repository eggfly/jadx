package com.google.android.gms.p146b;

import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.b.gi */
class gi {
    private final List<String> f11091a;
    private final List<String> f11092b;
    private final String f11093c;
    private final String f11094d;
    private final String f11095e;
    private final String f11096f;
    private final boolean f11097g;
    private final boolean f11098h;
    private final String f11099i;
    private String f11100j;
    private int f11101k;

    public gi(int i, Map<String, String> map) {
        this.f11100j = (String) map.get("url");
        this.f11094d = (String) map.get("base_uri");
        this.f11095e = (String) map.get("post_parameters");
        this.f11097g = gi.m12878b((String) map.get("drt_include"));
        this.f11098h = gi.m12878b((String) map.get("pan_include"));
        this.f11093c = (String) map.get("activation_overlay_url");
        this.f11092b = m12879c((String) map.get("check_packages"));
        this.f11099i = (String) map.get("request_id");
        this.f11096f = (String) map.get(C4233j.f14402y);
        this.f11091a = m12879c((String) map.get("errors"));
        this.f11101k = i;
    }

    private static boolean m12878b(String str) {
        return str != null && (str.equals(MessageService.MSG_DB_NOTIFY_REACHED) || str.equals("true"));
    }

    private List<String> m12879c(String str) {
        return str == null ? null : Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
    }

    public int m12880a() {
        return this.f11101k;
    }

    public void m12881a(String str) {
        this.f11100j = str;
    }

    public List<String> m12882b() {
        return this.f11091a;
    }

    public String m12883c() {
        return this.f11095e;
    }

    public String m12884d() {
        return this.f11100j;
    }

    public String m12885e() {
        return this.f11096f;
    }

    public boolean m12886f() {
        return this.f11097g;
    }

    public String m12887g() {
        return this.f11099i;
    }

    public boolean m12888h() {
        return this.f11098h;
    }
}
