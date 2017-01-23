package cn.sharesdk.framework.p026b.p027a;

import android.content.Context;
import android.text.TextUtils;
import com.mob.tools.utils.SharePrefrenceHelper;

/* renamed from: cn.sharesdk.framework.b.a.e */
public class C0947e {
    private static C0947e f3213c;
    private Context f3214a;
    private SharePrefrenceHelper f3215b;

    private C0947e(Context context) {
        this.f3214a = context.getApplicationContext();
        this.f3215b = new SharePrefrenceHelper(this.f3214a);
        this.f3215b.open("share_sdk", 1);
    }

    public static C0947e m4134a(Context context) {
        if (f3213c == null) {
            f3213c = new C0947e(context.getApplicationContext());
        }
        return f3213c;
    }

    public long m4135a() {
        return this.f3215b.getLong("service_time");
    }

    public void m4136a(long j) {
        this.f3215b.putLong("device_time", Long.valueOf(j));
    }

    public void m4137a(String str) {
        this.f3215b.putString("trans_short_link", str);
    }

    public void m4138a(String str, int i) {
        this.f3215b.putInt(str, Integer.valueOf(i));
    }

    public void m4139a(String str, Long l) {
        this.f3215b.putLong(str, l);
    }

    public void m4140a(String str, Object obj) {
        this.f3215b.put(str, obj);
    }

    public void m4141a(String str, String str2) {
        this.f3215b.putString("buffered_snsconf_" + str, str2);
    }

    public void m4142a(boolean z) {
        this.f3215b.putBoolean("connect_server", Boolean.valueOf(z));
    }

    public void m4143b(long j) {
        this.f3215b.putLong("connect_server_time", Long.valueOf(j));
    }

    public void m4144b(String str) {
        this.f3215b.putString("upload_device_info", str);
    }

    public boolean m4145b() {
        Object string = this.f3215b.getString("upload_device_info");
        return TextUtils.isEmpty(string) ? true : Boolean.parseBoolean(string);
    }

    public void m4146c(String str) {
        this.f3215b.putString("upload_user_info", str);
    }

    public boolean m4147c() {
        Object string = this.f3215b.getString("upload_user_info");
        return TextUtils.isEmpty(string) ? true : Boolean.parseBoolean(string);
    }

    public void m4148d(String str) {
        this.f3215b.putString("upload_share_content", str);
    }

    public boolean m4149d() {
        Object string = this.f3215b.getString("trans_short_link");
        return TextUtils.isEmpty(string) ? false : Boolean.parseBoolean(string);
    }

    public int m4150e() {
        String string = this.f3215b.getString("upload_share_content");
        return "true".equals(string) ? 1 : "false".equals(string) ? -1 : 0;
    }

    public String m4151e(String str) {
        return this.f3215b.getString("buffered_snsconf_" + str);
    }

    public long m4152f(String str) {
        return this.f3215b.getLong(str);
    }

    public Long m4153f() {
        return Long.valueOf(this.f3215b.getLong("device_time"));
    }

    public int m4154g(String str) {
        return this.f3215b.getInt(str);
    }

    public boolean m4155g() {
        return this.f3215b.getBoolean("connect_server");
    }

    public Long m4156h() {
        return Long.valueOf(this.f3215b.getLong("connect_server_time"));
    }

    public Object m4157h(String str) {
        return this.f3215b.get(str);
    }
}
