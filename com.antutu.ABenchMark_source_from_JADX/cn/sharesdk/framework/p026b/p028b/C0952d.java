package cn.sharesdk.framework.p026b.p028b;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: cn.sharesdk.framework.b.b.d */
public class C0952d extends C0949c {
    private static int f3240d;
    private static long f3241n;
    public String f3242a;
    public int f3243b;
    public String f3244c;

    public C0952d() {
        this.f3244c = BuildConfig.FLAVOR;
    }

    protected String m4202a() {
        return "[EVT]";
    }

    protected void m4203a(long j) {
        f3241n = j;
    }

    protected int m4204b() {
        return BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
    }

    protected int m4205c() {
        return 30;
    }

    protected long m4206d() {
        return (long) f3240d;
    }

    protected long m4207e() {
        return f3241n;
    }

    protected void m4208f() {
        f3240d++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append('|').append(this.f3242a);
        stringBuilder.append('|').append(this.f3243b);
        stringBuilder.append('|').append(this.f3244c);
        return stringBuilder.toString();
    }
}
