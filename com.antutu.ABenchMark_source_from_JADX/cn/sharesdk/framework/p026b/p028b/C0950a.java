package cn.sharesdk.framework.p026b.p028b;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/* renamed from: cn.sharesdk.framework.b.b.a */
public class C0950a extends C0949c {
    private static int f3230c;
    private static long f3231d;
    public int f3232a;
    public String f3233b;

    protected String m4188a() {
        return "[API]";
    }

    protected void m4189a(long j) {
        f3231d = j;
    }

    protected int m4190b() {
        return BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
    }

    protected int m4191c() {
        return 50;
    }

    protected long m4192d() {
        return (long) f3230c;
    }

    protected long m4193e() {
        return f3231d;
    }

    protected void m4194f() {
        f3230c++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append('|').append(this.f3232a);
        stringBuilder.append('|').append(this.f3233b);
        return stringBuilder.toString();
    }
}
