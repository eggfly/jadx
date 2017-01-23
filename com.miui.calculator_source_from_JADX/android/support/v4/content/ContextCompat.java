package android.support.v4.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Process;
import android.support.annotation.NonNull;

public class ContextCompat {
    public static final Drawable m78a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.m555a(context, i);
        }
        return context.getResources().getDrawable(i);
    }

    public static int m77a(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }
}
