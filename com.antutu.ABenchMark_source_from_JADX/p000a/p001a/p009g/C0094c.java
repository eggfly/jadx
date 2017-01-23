package p000a.p001a.p009g;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p000a.C0135v;
import p000a.p001a.C0037c;

/* renamed from: a.a.g.c */
class C0094c extends C0090e {
    private final Method f349a;
    private final Method f350b;
    private final Method f351c;
    private final Class<?> f352d;
    private final Class<?> f353e;

    /* renamed from: a.a.g.c.a */
    private static class C0093a implements InvocationHandler {
        boolean f346a;
        String f347b;
        private final List<String> f348c;

        public C0093a(List<String> list) {
            this.f348c = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C0037c.f117b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f346a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f348c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f348c.contains(list.get(i))) {
                            name = (String) list.get(i);
                            this.f347b = name;
                            return name;
                        }
                    }
                    name = (String) this.f348c.get(0);
                    this.f347b = name;
                    return name;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f347b = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    public C0094c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f349a = method;
        this.f350b = method2;
        this.f351c = method3;
        this.f352d = cls;
        this.f353e = cls2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p000a.p001a.p009g.C0090e m412a() {
        /*
        r0 = "org.eclipse.jetty.alpn.ALPN";
        r3 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r1 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r1.<init>();	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r1 = r1.append(r0);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r2 = "$Provider";
        r1 = r1.append(r2);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r1 = r1.toString();	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r2 = r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r4 = "$ClientProvider";
        r2 = r2.append(r4);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r4 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r0 = r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r2 = "$ServerProvider";
        r0 = r0.append(r2);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r0 = r0.toString();	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r5 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r0 = "put";
        r2 = 2;
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r6 = 0;
        r7 = javax.net.ssl.SSLSocket.class;
        r2[r6] = r7;	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r6 = 1;
        r2[r6] = r1;	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r1 = r3.getMethod(r0, r2);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r0 = "get";
        r2 = 1;
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r6 = 0;
        r7 = javax.net.ssl.SSLSocket.class;
        r2[r6] = r7;	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r2 = r3.getMethod(r0, r2);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r0 = "remove";
        r6 = 1;
        r6 = new java.lang.Class[r6];	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r7 = 0;
        r8 = javax.net.ssl.SSLSocket.class;
        r6[r7] = r8;	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r3 = r3.getMethod(r0, r6);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r0 = new a.a.g.c;	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ ClassNotFoundException -> 0x007e, NoSuchMethodException -> 0x0081 }
    L_0x007d:
        return r0;
    L_0x007e:
        r0 = move-exception;
    L_0x007f:
        r0 = 0;
        goto L_0x007d;
    L_0x0081:
        r0 = move-exception;
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.g.c.a():a.a.g.e");
    }

    public String m413a(SSLSocket sSLSocket) {
        try {
            C0093a c0093a = (C0093a) Proxy.getInvocationHandler(this.f350b.invoke(null, new Object[]{sSLSocket}));
            if (c0093a.f346a || c0093a.f347b != null) {
                return c0093a.f346a ? null : c0093a.f347b;
            }
            C0090e.m389b().m394a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
            return null;
        } catch (InvocationTargetException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    public void m414a(SSLSocket sSLSocket, String str, List<C0135v> list) {
        Object newProxyInstance;
        List a = C0090e.m388a((List) list);
        try {
            newProxyInstance = Proxy.newProxyInstance(C0090e.class.getClassLoader(), new Class[]{this.f352d, this.f353e}, new C0093a(a));
            this.f349a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e) {
            newProxyInstance = e;
            throw new AssertionError(newProxyInstance);
        } catch (IllegalAccessException e2) {
            newProxyInstance = e2;
            throw new AssertionError(newProxyInstance);
        }
    }

    public void m415b(SSLSocket sSLSocket) {
        try {
            this.f351c.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (InvocationTargetException e2) {
            throw new AssertionError();
        }
    }
}
