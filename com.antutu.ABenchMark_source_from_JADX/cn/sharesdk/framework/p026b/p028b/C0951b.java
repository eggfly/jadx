package cn.sharesdk.framework.p026b.p028b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.Data;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: cn.sharesdk.framework.b.b.b */
public class C0951b extends C0949c {
    private static int f3234n;
    private static long f3235o;
    public int f3236a;
    public String f3237b;
    public String f3238c;
    public String f3239d;

    protected String m4195a() {
        return "[AUT]";
    }

    protected void m4196a(long j) {
        f3235o = j;
    }

    protected int m4197b() {
        return BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
    }

    protected int m4198c() {
        return 5;
    }

    protected long m4199d() {
        return (long) f3234n;
    }

    protected long m4200e() {
        return f3235o;
    }

    protected void m4201f() {
        f3234n++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append('|').append(this.f3236a);
        stringBuilder.append('|').append(this.f3237b);
        stringBuilder.append('|');
        if (!TextUtils.isEmpty(this.f3239d)) {
            try {
                String encodeToString = Base64.encodeToString(Data.AES128Encode(this.f.substring(0, 16), this.f3239d), 0);
                if (!TextUtils.isEmpty(encodeToString) && encodeToString.contains("\n")) {
                    encodeToString = encodeToString.replace("\n", BuildConfig.FLAVOR);
                }
                stringBuilder.append(encodeToString);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        stringBuilder.append('|');
        if (!TextUtils.isEmpty(this.m)) {
            stringBuilder.append(this.m);
        }
        stringBuilder.append('|');
        if (!TextUtils.isEmpty(this.f3238c)) {
            stringBuilder.append(this.f3238c);
        }
        return stringBuilder.toString();
    }
}
