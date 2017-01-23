package cn.sharesdk.tencent.qq;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.C0979d;
import com.google.analytics.tracking.android.ModelFields;
import com.igexin.download.Downloads;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.DeviceHelper;
import java.io.File;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* renamed from: cn.sharesdk.tencent.qq.e */
public class C1015e extends FakeActivity {
    private Platform f3430a;
    private String f3431b;
    private PlatformActionListener f3432c;

    /* renamed from: cn.sharesdk.tencent.qq.e.1 */
    class C10141 extends Thread {
        final /* synthetic */ String f3421a;
        final /* synthetic */ String f3422b;
        final /* synthetic */ String f3423c;
        final /* synthetic */ String f3424d;
        final /* synthetic */ String f3425e;
        final /* synthetic */ String f3426f;
        final /* synthetic */ String f3427g;
        final /* synthetic */ int f3428h;
        final /* synthetic */ C1015e f3429i;

        C10141(C1015e c1015e, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
            this.f3429i = c1015e;
            this.f3421a = str;
            this.f3422b = str2;
            this.f3423c = str3;
            this.f3424d = str4;
            this.f3425e = str5;
            this.f3426f = str6;
            this.f3427g = str7;
            this.f3428h = i;
        }

        public void run() {
            String downloadBitmap;
            try {
                downloadBitmap = BitmapHelper.downloadBitmap(this.f3429i.activity, this.f3421a);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
                return;
            }
            this.f3429i.m4518a(this.f3422b, this.f3423c, this.f3424d, this.f3421a, downloadBitmap, this.f3425e, this.f3426f, this.f3427g, this.f3428h);
        }
    }

    private void m4518a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        String b = m4520b(str, str2, str3, str4, str5, str6, str7, str8, i);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(b));
        try {
            int[] a = m4519a();
            C1013d c1013d = new C1013d();
            c1013d.m4515a(this.f3431b);
            c1013d.m4514a(this.f3430a, this.f3432c);
            FakeActivity.registerExecutor(this.f3431b, c1013d);
            if (a.length <= 1 || (a[0] < 4 && a[1] < 6)) {
                intent.putExtra("key_request_code", 0);
            }
            intent.putExtra("pkg_name", this.activity.getPackageName());
            this.activity.startActivityForResult(intent, 0);
        } catch (Throwable th) {
            this.activity.finish();
            if (this.f3432c != null) {
                this.f3432c.onError(this.f3430a, 9, th);
            }
        }
    }

    private int[] m4519a() {
        String str;
        try {
            str = this.f3430a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            str = MessageService.MSG_DB_READY_REPORT;
        }
        String[] split = str.split("\\.");
        int[] iArr = new int[split.length];
        for (int i = 0; i < iArr.length; i++) {
            try {
                iArr[i] = C4021R.parseInt(split[i]);
            } catch (Throwable th2) {
                C0979d.m4390a().m4376d(th2);
                iArr[i] = 0;
            }
        }
        return iArr;
    }

    private String m4520b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        String str9 = "mqqapi://share/to_fri?src_type=app&version=1&file_type=news";
        if (!TextUtils.isEmpty(str4)) {
            str9 = str9 + "&image_url=" + Base64.encodeToString(str4.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str5)) {
            str9 = str9 + "&file_data=" + Base64.encodeToString(str5.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str)) {
            str9 = str9 + "&title=" + Base64.encodeToString(str.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str3)) {
            str9 = str9 + "&description=" + Base64.encodeToString(str3.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str7)) {
            if (str7.length() > 20) {
                str7 = str7.substring(0, 20) + "...";
            }
            str9 = str9 + "&app_name=" + Base64.encodeToString(str7.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str8)) {
            str9 = str9 + "&share_id=" + str8;
        }
        if (!TextUtils.isEmpty(str2)) {
            str9 = str9 + "&url=" + Base64.encodeToString(str2.getBytes(), 2);
        }
        if (!TextUtils.isEmpty(str3)) {
            str9 = str9 + "&share_qq_ext_str=" + Base64.encodeToString(str3.getBytes(), 2);
        }
        String str10 = "00";
        r2 = (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str5)) ? str9 + "&req_type=" + Base64.encodeToString("5".getBytes(), 2) : (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str2)) ? !TextUtils.isEmpty(str6) ? (str9 + "&req_type=" + Base64.encodeToString(MessageService.MSG_DB_NOTIFY_CLICK.getBytes(), 2)) + "&audioUrl=" + Base64.encodeToString(str6.getBytes(), 2) : str9 + "&req_type=" + Base64.encodeToString(MessageService.MSG_DB_NOTIFY_REACHED.getBytes(), 2) : str9 + "&req_type=" + Base64.encodeToString("6".getBytes(), 2);
        return r2 + "&cflag=" + Base64.encodeToString((i == 1 ? AgooConstants.ACK_REMOVE_PACKAGE : str10).getBytes(), 2);
    }

    public void m4521a(Platform platform, PlatformActionListener platformActionListener) {
        this.f3430a = platform;
        this.f3432c = platformActionListener;
    }

    public void m4522a(String str) {
        this.f3431b = "tencent" + str;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        finish();
    }

    public void onCreate() {
        Bundle extras = this.activity.getIntent().getExtras();
        String string = extras.getString(Downloads.COLUMN_TITLE);
        String string2 = extras.getString("titleUrl");
        String string3 = extras.getString("summary");
        String string4 = extras.getString("imageUrl");
        String string5 = extras.getString("musicUrl");
        String appName = DeviceHelper.getInstance(this.activity).getAppName();
        String string6 = extras.getString(ModelFields.APP_ID);
        int i = extras.getInt("hidden");
        String string7 = extras.getString("imagePath");
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string3) && TextUtils.isEmpty(string2) && ((TextUtils.isEmpty(string7) || !new File(string7).exists()) && !TextUtils.isEmpty(string4))) {
            new C10141(this, string4, string, string2, string3, string5, appName, string6, i).start();
        } else {
            m4518a(string, string2, string3, string4, string7, string5, appName, string6, i);
        }
    }
}
