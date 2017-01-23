package com.igexin.sdk.p186a;

import android.content.Context;
import com.igexin.sdk.IPushCore;

/* renamed from: com.igexin.sdk.a.a */
public class C3939a {
    private static String f13238a;
    private static C3939a f13239c;
    private IPushCore f13240b;

    static {
        f13238a = "PushSdk";
    }

    private C3939a() {
    }

    public static C3939a m16217a() {
        if (f13239c == null) {
            f13239c = new C3939a();
        }
        return f13239c;
    }

    public void m16218a(IPushCore iPushCore) {
        this.f13240b = iPushCore;
    }

    public boolean m16219a(Context context) {
        try {
            IPushCore iPushCore = (IPushCore) context.getClassLoader().loadClass("com.igexin.push.core.stub.PushCore").newInstance();
            if (iPushCore != null) {
                m16218a(iPushCore);
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public IPushCore m16220b() {
        return this.f13240b;
    }
}
