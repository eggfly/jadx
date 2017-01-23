package com.aide.common;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

public class a {
    public static void j6(Activity activity, String str, int i, int i2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(activity, "com.aide.ui.MainActivity"));
        intent.putExtra("NavigateFile", str);
        intent.putExtra("NavigateLine", i);
        intent.putExtra("NavigateColumn", i2);
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }
}
