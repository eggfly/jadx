package com.igexin.push.core;

import com.igexin.sdk.aidl.C3864a;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.igexin.push.core.p */
final class C3865p extends C3864a {
    C3865p() {
    }

    public byte[] extFunction(byte[] bArr) {
        return null;
    }

    public int isStarted(String str) {
        return 1;
    }

    public int onASNLConnected(String str, String str2, String str3, long j) {
        return C3854f.m15859a() != null ? C3854f.m15859a().m15878h().m16032a(str3) : -1;
    }

    public int onASNLNetworkConnected() {
        if (C3854f.m15859a().m15877g().m16062a()) {
            return -1;
        }
        C3854f.m15859a().m15877g().m16063b();
        return 0;
    }

    public int onASNLNetworkDisconnected() {
        if (C3854f.m15859a().m15877g().m16062a()) {
            return -1;
        }
        C3854f.m15859a().m15877g().m16064b(false);
        return 0;
    }

    public int onPSNLConnected(String str, String str2, String str3, long j) {
        return (C3854f.m15859a() == null || str.equals(BuildConfig.FLAVOR) || str2.equals(BuildConfig.FLAVOR)) ? -1 : C3854f.m15859a().m15878h().m16034a(str, str2);
    }

    public int receiveToPSNL(String str, String str2, byte[] bArr) {
        return (str2 == null || bArr == null || C3854f.m15859a().m15877g().m16062a()) ? -1 : C3854f.m15859a().m15878h().m16041b(str, str2, bArr);
    }

    public int sendByASNL(String str, String str2, byte[] bArr) {
        return (str2 == null || bArr == null || !C3854f.m15859a().m15877g().m16062a()) ? -1 : C3854f.m15859a().m15878h().m16035a(str, str2, bArr);
    }

    public int setSilentTime(int i, int i2, String str) {
        return 1;
    }

    public int startService(String str) {
        return 1;
    }

    public int stopService(String str) {
        return 1;
    }
}
