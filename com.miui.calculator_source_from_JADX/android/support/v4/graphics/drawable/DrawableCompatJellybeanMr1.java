package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class DrawableCompatJellybeanMr1 {
    private static Method f451a;
    private static boolean f452b;

    DrawableCompatJellybeanMr1() {
    }

    public static void m591a(Drawable drawable, int i) {
        if (!f452b) {
            try {
                f451a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f451a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f452b = true;
        }
        if (f451a != null) {
            try {
                f451a.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f451a = null;
            }
        }
    }
}
