package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.content.c;

public class d extends c {
    public static void j6(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            e.j6(activity);
        } else {
            activity.finish();
        }
    }
}
