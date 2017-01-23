package com.igexin.push.p178e;

import android.content.ServiceConnection;
import com.igexin.sdk.aidl.IGexinMsgService;

/* renamed from: com.igexin.push.e.b */
public class C3901b {
    private String f13129a;
    private String f13130b;
    private IGexinMsgService f13131c;
    private ServiceConnection f13132d;
    private String f13133e;

    public String m16005a() {
        return this.f13129a;
    }

    public void m16006a(ServiceConnection serviceConnection) {
        this.f13132d = serviceConnection;
    }

    public void m16007a(IGexinMsgService iGexinMsgService) {
        this.f13131c = iGexinMsgService;
    }

    public void m16008a(String str) {
        this.f13129a = str;
    }

    public String m16009b() {
        return this.f13130b;
    }

    public void m16010b(String str) {
        this.f13130b = str;
    }

    public IGexinMsgService m16011c() {
        return this.f13131c;
    }

    public void m16012c(String str) {
        this.f13133e = str;
    }

    public ServiceConnection m16013d() {
        return this.f13132d;
    }

    public String m16014e() {
        return this.f13133e;
    }
}
