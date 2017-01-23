package p023b.p024a;

import java.io.Serializable;

/* renamed from: b.a.cg */
public class cg implements Serializable {
    private String f2813a;
    private long f2814b;
    private long f2815c;
    private String f2816d;

    private cg() {
        this.f2813a = null;
        this.f2814b = 0;
        this.f2815c = 0;
        this.f2816d = null;
    }

    public cg(String str, long j, long j2) {
        this(str, j, j2, null);
    }

    public cg(String str, long j, long j2, String str2) {
        this.f2813a = null;
        this.f2814b = 0;
        this.f2815c = 0;
        this.f2816d = null;
        this.f2813a = str;
        this.f2814b = j;
        this.f2815c = j2;
        this.f2816d = str2;
    }

    public cg m3679a() {
        this.f2815c++;
        return this;
    }

    public String m3680b() {
        return this.f2813a;
    }

    public long m3681c() {
        return this.f2814b;
    }

    public long m3682d() {
        return this.f2815c;
    }
}
