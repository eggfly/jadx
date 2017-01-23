package com.aide.common;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

public class c {
    public static void j6(Activity activity, int i, String str, String str2, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_LINKID", str2);
        intent.putExtra("EXTRA_IS_OPTIONAL_OFFER", z);
        intent.setComponent(new ComponentName(activity, "com.aide.ui.activities.ShopLearningPopupActivity"));
        intent.putExtra("EXTRA_FEATURE", str);
        intent.putExtra("EXTRA_SHOW_PRIME_MONTHLY", true);
        intent.putExtra("EXTRA_SHOW_PRIME_YEARLY", true);
        if (i == 0) {
            activity.startActivity(intent);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void j6(Activity activity, int i, String str, boolean z, boolean z2) {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_LINKID", str);
        intent.putExtra("EXTRA_HILIGHT_ADS", z);
        intent.putExtra("EXTRA_IS_OPTIONAL_OFFER", z2);
        intent.setComponent(new ComponentName(activity, "com.aide.ui.activities.ShopExpertPopupActivity"));
        if (i == 0) {
            activity.startActivity(intent);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }
}
