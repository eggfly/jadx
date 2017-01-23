package android.support.v4.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;

public class c {
    public static final Drawable j6(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return d.j6(context, i);
        }
        return context.getResources().getDrawable(i);
    }

    public final File j6(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return d.j6(context);
        }
        return j6(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File j6(File file) {
        synchronized (c.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}
