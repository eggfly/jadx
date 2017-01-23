package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

class aa {
    private static Method j6;

    public static boolean j6(View view) {
        return view.isOpaque();
    }

    public static void j6(ViewGroup viewGroup, boolean z) {
        if (j6 == null) {
            try {
                j6 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            j6.setAccessible(true);
        }
        try {
            j6.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (Throwable e22) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e22);
        } catch (Throwable e222) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e222);
        }
    }
}
