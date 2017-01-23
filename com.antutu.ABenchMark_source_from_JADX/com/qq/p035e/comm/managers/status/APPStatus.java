package com.qq.p035e.comm.managers.status;

import android.content.Context;
import com.qq.p035e.comm.util.StringUtil;

/* renamed from: com.qq.e.comm.managers.status.APPStatus */
public class APPStatus {
    private String f13487a;
    private Context f13488b;

    public APPStatus(String str, Context context) {
        this.f13487a = str;
        this.f13488b = context;
    }

    public String getAPPID() {
        return this.f13487a;
    }

    public String getAPPName() {
        return this.f13488b.getPackageName();
    }

    public String getAPPVersion() {
        String str = null;
        String aPPName = getAPPName();
        if (StringUtil.isEmpty(aPPName)) {
            return str;
        }
        try {
            return this.f13488b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
        } catch (Exception e) {
            return str;
        }
    }
}
