import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class c {
    private static boolean DW;
    private static Method j6;

    public static void j6(Drawable drawable, int i) {
        if (!DW) {
            try {
                j6 = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                j6.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            DW = true;
        }
        if (j6 != null) {
            try {
                j6.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                j6 = null;
            }
        }
    }
}
