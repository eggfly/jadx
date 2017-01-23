package com.cmcm.p074a.p075a.p112a;

import android.content.Context;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.a.x */
public class C2131x {
    private static final C2131x f7469a;
    private boolean f7470b;
    private Integer f7471c;
    private String f7472d;
    private String f7473e;
    private boolean f7474f;
    private String f7475g;
    private String f7476h;
    private String f7477i;
    private String f7478j;
    private String f7479k;
    private HashSet f7480l;
    private HashSet f7481m;

    static {
        f7469a = new C2131x();
    }

    public C2131x() {
        this.f7471c = Integer.valueOf(0);
        this.f7480l = new HashSet();
        this.f7481m = new HashSet();
    }

    public static C2131x m8050a() {
        return f7469a;
    }

    public boolean m8051a(Context context) {
        try {
            int i;
            JSONObject jSONObject = new JSONObject(C2115i.m7965a(context, "dmc_config.json"));
            this.f7470b = jSONObject.optBoolean("log", false);
            this.f7471c = Integer.valueOf(jSONObject.getInt("update_type"));
            this.f7472d = jSONObject.getString("report_url");
            this.f7473e = jSONObject.optString("report_env", null);
            this.f7475g = jSONObject.optString("host_product");
            this.f7476h = jSONObject.optString("host_package");
            this.f7477i = jSONObject.optString("host_version");
            this.f7478j = jSONObject.optString("host_channel");
            this.f7479k = jSONObject.optString("pick_version");
            JSONArray optJSONArray = jSONObject.optJSONArray("receiver_off");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (i = 0; i < length; i++) {
                    this.f7481m.add(optJSONArray.getString(i));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("receiver_on");
            if (optJSONArray2 == null) {
                return true;
            }
            int length2 = optJSONArray2.length();
            for (i = 0; i < length2; i++) {
                String string = optJSONArray2.getString(i);
                if (string.equals("*")) {
                    this.f7474f = true;
                    return true;
                }
                this.f7480l.add(string);
            }
            return true;
        } catch (Exception e) {
            ad.m7932a("failed to load dmc_config.json : " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public final boolean m8052a(String str) {
        return !this.f7481m.contains(str) && (this.f7480l.contains(str) || this.f7474f);
    }

    public final boolean m8053b() {
        return this.f7470b;
    }

    public final Integer m8054c() {
        return this.f7471c;
    }

    public final String m8055d() {
        return this.f7472d;
    }

    public final String m8056e() {
        return this.f7473e;
    }

    public final String m8057f() {
        return this.f7475g;
    }

    public final String m8058g() {
        return this.f7476h;
    }

    public final String m8059h() {
        return this.f7477i;
    }

    public final String m8060i() {
        return this.f7478j;
    }
}
