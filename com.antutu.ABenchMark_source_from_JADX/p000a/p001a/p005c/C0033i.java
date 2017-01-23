package p000a.p001a.p005c;

import java.net.Proxy.Type;
import p000a.C0130r;
import p000a.C0139x;

/* renamed from: a.a.c.i */
public final class C0033i {
    public static String m135a(C0130r c0130r) {
        String h = c0130r.m600h();
        String j = c0130r.m602j();
        return j != null ? h + '?' + j : h;
    }

    public static String m136a(C0139x c0139x, Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0139x.m663b());
        stringBuilder.append(' ');
        if (C0033i.m137b(c0139x, type)) {
            stringBuilder.append(c0139x.m661a());
        } else {
            stringBuilder.append(C0033i.m135a(c0139x.m661a()));
        }
        stringBuilder.append(" HTTP/1.1");
        return stringBuilder.toString();
    }

    private static boolean m137b(C0139x c0139x, Type type) {
        return !c0139x.m668g() && type == Type.HTTP;
    }
}
