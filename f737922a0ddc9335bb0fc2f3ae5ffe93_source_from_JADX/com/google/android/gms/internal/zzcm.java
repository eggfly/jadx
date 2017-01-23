package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.b;

@eh
public class zzcm {
    private final Context j6;

    public zzcm(Context context) {
        b.j6((Object) context, (Object) "Context can not be null");
        this.j6 = context;
    }

    public static boolean v5() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean DW() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return j6(intent);
    }

    public boolean FH() {
        return v5() && this.j6.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public boolean Hw() {
        return true;
    }

    @TargetApi(14)
    public boolean Zo() {
        return VERSION.SDK_INT >= 14 && j6(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    public boolean j6() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return j6(intent);
    }

    public boolean j6(Intent intent) {
        b.j6((Object) intent, (Object) "Intent can not be null");
        return !this.j6.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }
}
