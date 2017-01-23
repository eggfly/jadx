package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.C3512u;
import com.umeng.message.MsgConstant;

@gb
/* renamed from: com.google.android.gms.b.ai */
public class ai {
    private final Context f10247a;

    public ai(Context context) {
        C3512u.m14581a((Object) context, (Object) "Context can not be null");
        this.f10247a = context;
    }

    public static boolean m11775e() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean m11776a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return m11777a(intent);
    }

    public boolean m11777a(Intent intent) {
        C3512u.m14581a((Object) intent, (Object) "Intent can not be null");
        return !this.f10247a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean m11778b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return m11777a(intent);
    }

    public boolean m11779c() {
        return ai.m11775e() && this.f10247a.checkCallingOrSelfPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) == 0;
    }

    public boolean m11780d() {
        return true;
    }

    @TargetApi(14)
    public boolean m11781f() {
        return VERSION.SDK_INT >= 14 && m11777a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
