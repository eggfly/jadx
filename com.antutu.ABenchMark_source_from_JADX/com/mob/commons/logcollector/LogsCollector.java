package com.mob.commons.logcollector;

import android.content.Context;
import android.content.Intent;
import cn.sharesdk.framework.ShareSDK;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.mob.tools.MobLog;
import com.mob.tools.log.LogCollector;
import com.umeng.message.common.C4209a;

public abstract class LogsCollector implements LogCollector {
    private C3999c f3350a;
    private boolean f3351b;

    public LogsCollector(Context context) {
        this.f3350a = C3999c.m16472a(context);
        this.f3350a.m16485a(getSDKVersion(), getSDKTag(), getAppkey());
        try {
            if (context.getPackageManager().getPackageInfo("cn.sharesdk.log", 64) != null) {
                this.f3351b = true;
            }
        } catch (Throwable th) {
        }
        this.f3351b = false;
    }

    final int m4374a(int i, String str) {
        if (this.f3350a.m16483a() != null && this.f3351b) {
            try {
                Intent intent = new Intent();
                intent.setAction("cn.sharesdk.log");
                intent.putExtra(C4209a.f14200c, this.f3350a.m16483a().getPackageName());
                intent.putExtra("priority", i);
                intent.putExtra(XAdErrorCode.ERROR_CODE_MESSAGE, str);
                this.f3350a.m16483a().sendBroadcast(intent);
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
        return 0;
    }

    protected abstract String getAppkey();

    protected abstract String getSDKTag();

    protected abstract int getSDKVersion();

    public final void log(String str, int i, int i2, String str2, String str3) {
        m4374a(i, str3);
        if (str != null && str.equals(getSDKTag())) {
            if (ShareSDK.SDK_TAG.equals(str) && (!str3.contains("com.mob.") || !str3.contains("cn.sharesdk."))) {
                return;
            }
            if (i2 == 1) {
                this.f3350a.m16486b(getSDKVersion(), i2, str, getAppkey(), str3);
            } else if (i2 == 2) {
                this.f3350a.m16484a(getSDKVersion(), i2, str, getAppkey(), str3);
            } else if (i == 5) {
                this.f3350a.m16484a(getSDKVersion(), i2, str, getAppkey(), str3);
            }
        }
    }
}
