package cn.sharesdk.framework.p026b.p028b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: cn.sharesdk.framework.b.b.f */
public class C0955f extends C0949c {
    private static int f3255p;
    private static long f3256q;
    public int f3257a;
    public String f3258b;
    public String f3259c;
    public C0954a f3260d;
    public String f3261n;
    public String[] f3262o;

    /* renamed from: cn.sharesdk.framework.b.b.f.a */
    public static class C0954a {
        public String f3248a;
        public String f3249b;
        public ArrayList<String> f3250c;
        public ArrayList<String> f3251d;
        public ArrayList<String> f3252e;
        public ArrayList<Bitmap> f3253f;
        public HashMap<String, Object> f3254g;

        public C0954a() {
            this.f3248a = BuildConfig.FLAVOR;
            this.f3250c = new ArrayList();
            this.f3251d = new ArrayList();
            this.f3252e = new ArrayList();
            this.f3253f = new ArrayList();
        }

        public String toString() {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f3249b)) {
                this.f3249b = this.f3249b.trim().replaceAll("\r", BuildConfig.FLAVOR);
                this.f3249b = this.f3249b.trim().replaceAll("\n", BuildConfig.FLAVOR);
                this.f3249b = this.f3249b.trim().replaceAll("\r\n", BuildConfig.FLAVOR);
            }
            hashMap.put("text", this.f3249b);
            hashMap.put("url", this.f3250c);
            if (this.f3251d != null && this.f3251d.size() > 0) {
                hashMap.put("imgs", this.f3251d);
            }
            if (this.f3254g != null) {
                hashMap.put("attch", new Hashon().fromHashMap(this.f3254g));
            }
            return new Hashon().fromHashMap(hashMap);
        }
    }

    public C0955f() {
        this.f3260d = new C0954a();
    }

    protected String m4218a() {
        return "[SHR]";
    }

    protected void m4219a(long j) {
        f3256q = j;
    }

    protected int m4220b() {
        return BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
    }

    protected int m4221c() {
        return 30;
    }

    protected long m4222d() {
        return (long) f3255p;
    }

    protected long m4223e() {
        return f3256q;
    }

    protected void m4224f() {
        f3255p++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append('|').append(this.f3257a);
        stringBuilder.append('|').append(this.f3258b);
        stringBuilder.append('|').append(TextUtils.isEmpty(this.f3259c) ? BuildConfig.FLAVOR : this.f3259c);
        String str = BuildConfig.FLAVOR;
        if (this.f3262o != null && this.f3262o.length > 0) {
            str = "[\"" + TextUtils.join("\",\"", this.f3262o) + "\"]";
        }
        stringBuilder.append('|').append(str);
        stringBuilder.append('|');
        if (this.f3260d != null) {
            try {
                str = Base64.encodeToString(Data.AES128Encode(this.f.substring(0, 16), this.f3260d.toString()), 0);
                if (str.contains("\n")) {
                    str = str.replace("\n", BuildConfig.FLAVOR);
                }
                stringBuilder.append(str);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        stringBuilder.append('|');
        if (!TextUtils.isEmpty(this.m)) {
            stringBuilder.append(this.m);
        }
        stringBuilder.append('|');
        if (!TextUtils.isEmpty(this.f3261n)) {
            try {
                str = Base64.encodeToString(Data.AES128Encode(this.f.substring(0, 16), this.f3261n), 0);
                if (!TextUtils.isEmpty(str) && str.contains("\n")) {
                    str = str.replace("\n", BuildConfig.FLAVOR);
                }
                stringBuilder.append(str);
            } catch (Throwable th2) {
                C0979d.m4390a().m4388w(th2);
            }
        }
        return stringBuilder.toString();
    }
}
