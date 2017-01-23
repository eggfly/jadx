package cn.sharesdk.framework.p026b.p028b;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.p026b.p027a.C0947e;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/* renamed from: cn.sharesdk.framework.b.b.e */
public class C0953e extends C0949c {
    private static int f3245b;
    private static long f3246c;
    public long f3247a;

    protected String m4209a() {
        return "[EXT]";
    }

    protected void m4210a(long j) {
        f3246c = j;
    }

    public boolean m4211a(Context context) {
        C0947e a = C0947e.m4134a(context);
        f3245b = a.m4154g("insertExitEventCount");
        f3246c = a.m4152f("lastInsertExitEventTime");
        return super.m4181a(context);
    }

    protected int m4212b() {
        return BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
    }

    public void m4213b(Context context) {
        super.m4183b(context);
        C0947e a = C0947e.m4134a(context);
        a.m4139a("lastInsertExitEventTime", Long.valueOf(f3246c));
        a.m4138a("insertExitEventCount", f3245b);
    }

    protected int m4214c() {
        return 5;
    }

    protected long m4215d() {
        return (long) f3245b;
    }

    protected long m4216e() {
        return f3246c;
    }

    protected void m4217f() {
        f3245b++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append('|');
        if (!TextUtils.isEmpty(this.m)) {
            stringBuilder.append(this.m);
        }
        stringBuilder.append('|').append(Math.round(((float) this.f3247a) / 1000.0f));
        return stringBuilder.toString();
    }
}
