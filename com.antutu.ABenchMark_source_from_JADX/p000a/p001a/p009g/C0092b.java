package p000a.p001a.p009g;

import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import p000a.C0135v;

/* renamed from: a.a.g.b */
final class C0092b extends C0090e {
    final Method f344a;
    final Method f345b;

    public C0092b(Method method, Method method2) {
        this.f344a = method;
        this.f345b = method2;
    }

    public static C0092b m409a() {
        try {
            return new C0092b(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public String m410a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f345b.invoke(sSLSocket, new Object[0]);
            return (str == null || str.equals(BuildConfig.FLAVOR)) ? null : str;
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (InvocationTargetException e2) {
            throw new AssertionError();
        }
    }

    public void m411a(SSLSocket sSLSocket, String str, List<C0135v> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List a = C0090e.m388a((List) list);
            this.f344a.invoke(sSLParameters, new Object[]{a.toArray(new String[a.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (InvocationTargetException e2) {
            throw new AssertionError();
        }
    }
}
