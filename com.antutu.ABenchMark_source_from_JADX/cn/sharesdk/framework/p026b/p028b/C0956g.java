package cn.sharesdk.framework.p026b.p028b;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.p026b.p027a.C0947e;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/* renamed from: cn.sharesdk.framework.b.b.g */
public class C0956g extends C0949c {
    private static int f3263a;
    private static long f3264b;

    protected String m4225a() {
        return "[RUN]";
    }

    protected void m4226a(long j) {
        f3264b = j;
    }

    public boolean m4227a(Context context) {
        C0947e a = C0947e.m4134a(context);
        f3263a = a.m4154g("insertRunEventCount");
        f3264b = a.m4152f("lastInsertRunEventTime");
        return super.m4181a(context);
    }

    protected int m4228b() {
        return BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
    }

    public void m4229b(Context context) {
        super.m4183b(context);
        C0947e a = C0947e.m4134a(context);
        a.m4139a("lastInsertRunEventTime", Long.valueOf(f3264b));
        a.m4138a("insertRunEventCount", f3263a);
    }

    protected int m4230c() {
        return 5;
    }

    protected long m4231d() {
        return (long) f3263a;
    }

    protected long m4232e() {
        return f3264b;
    }

    protected void m4233f() {
        f3263a++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append('|');
        if (!TextUtils.isEmpty(this.m)) {
            stringBuilder.append(this.m);
        }
        return stringBuilder.toString();
    }
}
