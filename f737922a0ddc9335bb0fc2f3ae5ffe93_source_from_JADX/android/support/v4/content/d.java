package android.support.v4.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

class d {
    public static Drawable j6(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File j6(Context context) {
        return context.getNoBackupFilesDir();
    }
}
