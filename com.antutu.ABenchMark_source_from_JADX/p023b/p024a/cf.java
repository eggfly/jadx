package p023b.p024a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: b.a.cf */
public class cf implements Serializable {
    private List<String> f2807a;
    private List<String> f2808b;
    private long f2809c;
    private long f2810d;
    private long f2811e;
    private String f2812f;

    public cf() {
        this.f2807a = new ArrayList();
        this.f2808b = new ArrayList();
        this.f2809c = 0;
        this.f2810d = 0;
        this.f2811e = 0;
        this.f2812f = null;
    }

    public String m3662a() {
        return br.m3619a(this.f2807a);
    }

    public void m3663a(long j) {
        this.f2809c = j;
    }

    public void m3664a(cd cdVar, ch chVar) {
        m3666a(chVar.m3685b());
        this.f2811e++;
        this.f2810d += chVar.m3686c();
        this.f2809c += chVar.m3687d();
        cdVar.m3414a(this, false);
    }

    public void m3665a(ch chVar) {
        this.f2811e = 1;
        this.f2807a = chVar.m3684a();
        m3666a(chVar.m3685b());
        this.f2810d = chVar.m3686c();
        this.f2809c = System.currentTimeMillis();
        this.f2812f = cm.m3768a(System.currentTimeMillis());
    }

    public void m3666a(String str) {
        try {
            if (this.f2808b.size() < cj.m3741a().m3745b()) {
                this.f2808b.add(str);
            } else {
                this.f2808b.remove(this.f2808b.get(0));
                this.f2808b.add(str);
            }
            if (this.f2808b.size() > cj.m3741a().m3745b()) {
                for (int i = 0; i < this.f2808b.size() - cj.m3741a().m3745b(); i++) {
                    this.f2808b.remove(this.f2808b.get(0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m3667a(List<String> list) {
        this.f2807a = list;
    }

    public List<String> m3668b() {
        return this.f2807a;
    }

    public void m3669b(long j) {
        this.f2810d = j;
    }

    public void m3670b(String str) {
        this.f2812f = str;
    }

    public void m3671b(List<String> list) {
        this.f2808b = list;
    }

    public String m3672c() {
        return br.m3619a(this.f2808b);
    }

    public void m3673c(long j) {
        this.f2811e = j;
    }

    public List<String> m3674d() {
        return this.f2808b;
    }

    public long m3675e() {
        return this.f2809c;
    }

    public long m3676f() {
        return this.f2810d;
    }

    public long m3677g() {
        return this.f2811e;
    }

    public String m3678h() {
        return this.f2812f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[key: ").append(this.f2807a).append("] [label: ").append(this.f2808b).append("][ totalTimeStamp").append(this.f2812f).append("][ value").append(this.f2810d).append("][ count").append(this.f2811e).append("][ timeWindowNum").append(this.f2812f).append("]");
        return stringBuffer.toString();
    }
}
