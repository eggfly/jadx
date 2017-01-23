package p000a;

import java.io.IOException;

/* renamed from: a.v */
public enum C0135v {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String f615e;

    private C0135v(String str) {
        this.f615e = str;
    }

    public static C0135v m643a(String str) {
        if (str.equals(HTTP_1_0.f615e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f615e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f615e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f615e)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f615e;
    }
}
