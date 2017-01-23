package com.aide.common;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

public class b {
    public static void j6(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(activity, "com.aide.ui.activities.HelpViewActivity"));
        intent.putExtra("EXTRA_URL", str);
        intent.putExtra("EXTRA_CAT", str2);
        intent.addFlags(268435456);
        intent.addFlags(4096);
        activity.startActivity(intent);
    }
}
