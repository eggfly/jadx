package anet.channel.security;

/* renamed from: anet.channel.security.c */
public class C0684c {
    private static volatile ISecurity f2267a;

    static {
        f2267a = null;
    }

    public static ISecurity m2818a() {
        if (f2267a == null) {
            f2267a = new C0682a();
        }
        return f2267a;
    }

    public static void m2819a(ISecurity iSecurity) {
        f2267a = iSecurity;
    }
}
