package p023b.p024a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b.a.ch */
public class ch implements Serializable {
    private List<String> f2817a;
    private String f2818b;
    private long f2819c;
    private long f2820d;
    private String f2821e;

    public ch(List<String> list, long j, String str, long j2) {
        this.f2817a = new ArrayList();
        this.f2817a = list;
        this.f2819c = j;
        this.f2818b = str;
        this.f2820d = j2;
        m3683e();
    }

    private void m3683e() {
        this.f2821e = cm.m3768a(this.f2820d);
    }

    public List<String> m3684a() {
        return this.f2817a;
    }

    public String m3685b() {
        return this.f2818b;
    }

    public long m3686c() {
        return this.f2819c;
    }

    public long m3687d() {
        return this.f2820d;
    }
}
