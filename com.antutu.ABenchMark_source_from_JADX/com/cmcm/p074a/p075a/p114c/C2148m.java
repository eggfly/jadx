package com.cmcm.p074a.p075a.p114c;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.cmcm.p074a.p075a.p112a.C2126s;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.c.m */
public class C2148m extends C2136b {
    public static String m8107c(String str) {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = C2126s.m8041c().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            jSONObject.put(Constants.KEY_PACKAGE_NAME, str);
            String str2 = "isSystemApp";
            if ((packageInfo.applicationInfo.flags & 1) != 0) {
                z = true;
            }
            jSONObject.put(str2, z);
            jSONObject.put("versionCode", packageInfo.versionCode);
            jSONObject.put("versionName", packageInfo.versionName);
            jSONObject.put("appSource", packageManager.getInstallerPackageName(str));
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void m8108b(String str) {
        String c = C2148m.m8107c(str);
        if (c != null) {
            m8069a(c);
        }
    }

    public String m8109f() {
        return "inst_app";
    }
}
