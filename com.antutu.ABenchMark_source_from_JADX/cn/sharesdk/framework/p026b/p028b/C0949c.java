package cn.sharesdk.framework.p026b.p028b;

import android.content.Context;

/* renamed from: cn.sharesdk.framework.b.b.c */
public abstract class C0949c {
    public long f3221e;
    public String f3222f;
    public String f3223g;
    public String f3224h;
    public int f3225i;
    public String f3226j;
    public int f3227k;
    public String f3228l;
    public String f3229m;

    protected abstract String m4179a();

    protected abstract void m4180a(long j);

    public boolean m4181a(Context context) {
        int b = m4182b();
        int c = m4184c();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - m4186e() < ((long) b)) {
            return m4185d() < ((long) c);
        } else {
            m4180a(currentTimeMillis);
            return true;
        }
    }

    protected abstract int m4182b();

    public void m4183b(Context context) {
        m4187f();
    }

    protected abstract int m4184c();

    protected abstract long m4185d();

    protected abstract long m4186e();

    protected abstract void m4187f();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m4179a()).append(':');
        stringBuilder.append(this.f3221e).append('|');
        stringBuilder.append(this.f3222f).append('|');
        stringBuilder.append(this.f3223g).append('|');
        stringBuilder.append(this.f3224h).append('|');
        stringBuilder.append(this.f3225i).append('|');
        stringBuilder.append(this.f3226j).append('|');
        stringBuilder.append(this.f3227k).append('|');
        stringBuilder.append(this.f3228l);
        return stringBuilder.toString();
    }
}
