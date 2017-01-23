package com.cmcm.p074a.p075a.p114c;

import android.content.pm.PackageInfo;
import com.cmcm.p074a.p075a.p112a.C2126s;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.c.n */
public class C2149n extends C2137a {
    protected void m8110c() {
        try {
            List installedPackages = C2126s.m8041c().getPackageManager().getInstalledPackages(0);
            List arrayList = new ArrayList();
            for (int i = 0; i < installedPackages.size(); i++) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.KEY_PACKAGE_NAME, ((PackageInfo) installedPackages.get(i)).packageName);
                jSONObject.put("isSystemApp", (((PackageInfo) installedPackages.get(i)).applicationInfo.flags & 1) != 0);
                jSONObject.put("versionCode", ((PackageInfo) installedPackages.get(i)).versionCode);
                jSONObject.put("versionName", ((PackageInfo) installedPackages.get(i)).versionName);
                jSONObject.put("installDate", ((PackageInfo) installedPackages.get(i)).firstInstallTime / 1000);
                arrayList.add(jSONObject);
            }
            m8069a(arrayList.toString());
        } catch (Exception e) {
        }
    }

    public String m8111f() {
        return "inst_app_list";
    }
}
