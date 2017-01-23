package com.aide.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.aide.analytics.a;
import java.util.List;

public class u {

    static class 1 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ Context j6;

        1(Context context, String str) {
            this.j6 = context;
            this.DW = str;
        }

        public void run() {
            Toast makeText = Toast.makeText(this.j6, "Long press to paste: \"" + this.DW + "\"", 1);
            makeText.setGravity(49, 0, 20);
            makeText.show();
        }
    }

    private static boolean j6(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 1) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (str.equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                        intent.setPackage(str);
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static void j6(Context context, String str, String str2) {
        a.DW("Shared via twitter");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://www.twitter.com/intent/tweet?url=" + str2 + "&text=" + str));
        j6(context, "com.twitter.android", intent);
        j6(context, intent);
    }

    public static void DW(Context context, String str, String str2) {
        a.DW("Shared via gplus");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str + "\n\n" + str2);
        if (!j6(context, "com.google.android.apps.plus", intent)) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("https://plus.google.com/share?url=" + str2 + "&text=" + str));
        }
        j6(context, intent);
    }

    public static void FH(Context context, String str, String str2) {
        Intent intent;
        a.DW("Shared via facebook");
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("text/plain");
        intent2.putExtra("android.intent.extra.SUBJECT", str);
        intent2.putExtra("android.intent.extra.TEXT", str2);
        if (j6(context, "com.facebook.katana", intent2)) {
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            new Handler().postDelayed(new 1(context, str), 1000);
            intent = intent2;
        } else {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/sharer/sharer.php?u=" + str2));
        }
        j6(context, intent);
    }

    public static void j6(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/" + str));
        if (!j6(context, "com.facebook.katana", intent)) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/" + str));
        }
        intent.setFlags(1074266112);
        j6(context, intent);
    }

    public static void DW(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://twitter.com/#!/" + str));
        intent.setFlags(1074266112);
        j6(context, "com.twitter.android", intent);
        j6(context, intent);
    }

    public static void FH(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://plus.google.com/" + str + "/posts"));
        intent.setFlags(1074266112);
        j6(context, "com.google.android.apps.plus", intent);
        j6(context, intent);
    }

    public static void Hw(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://plus.google.com/communities/" + str));
        intent.setFlags(1074266112);
        if (j6(context, "com.google.android.apps.plus", intent)) {
            j6(context, intent);
        } else {
            j6(context, intent);
        }
    }

    public static void v5(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://groups.google.com/group/" + str));
        intent.setFlags(1074266112);
        j6(context, intent);
    }

    public static void Hw(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(a.j6(str, str, str2)));
        intent.setFlags(1074266112);
        j6(context, intent);
    }

    public static void j6(Context context, String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.SUBJECT", "AIDE Feedback");
        intent.putExtra("android.intent.extra.TEXT", str3);
        j6(context, intent);
    }

    private static void j6(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
        }
    }
}
