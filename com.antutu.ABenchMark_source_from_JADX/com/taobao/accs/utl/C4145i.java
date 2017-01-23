package com.taobao.accs.utl;

import com.ut.mini.IUTApplication;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;

/* renamed from: com.taobao.accs.utl.i */
class C4145i implements IUTApplication {
    final /* synthetic */ String f13898a;
    final /* synthetic */ String f13899b;
    final /* synthetic */ UTMini f13900c;

    C4145i(UTMini uTMini, String str, String str2) {
        this.f13900c = uTMini;
        this.f13898a = str;
        this.f13899b = str2;
    }

    public String getUTAppVersion() {
        return null;
    }

    public String getUTChannel() {
        return this.f13898a;
    }

    public IUTCrashCaughtListner getUTCrashCraughtListener() {
        return null;
    }

    public IUTRequestAuthentication getUTRequestAuthInstance() {
        return new UTSecuritySDKRequestAuthentication(this.f13899b);
    }

    public boolean isAliyunOsSystem() {
        return false;
    }

    public boolean isUTCrashHandlerDisable() {
        return false;
    }

    public boolean isUTLogEnable() {
        return false;
    }
}
