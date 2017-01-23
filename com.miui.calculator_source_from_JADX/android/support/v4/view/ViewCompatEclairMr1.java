package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

class ViewCompatEclairMr1 {
    private static Method f830a;

    ViewCompatEclairMr1() {
    }

    public static boolean m1477a(View view) {
        return view.isOpaque();
    }

    public static void m1476a(ViewGroup viewGroup, boolean z) {
        if (f830a == null) {
            try {
                f830a = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            f830a.setAccessible(true);
        }
        try {
            f830a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (Throwable e22) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e22);
        } catch (Throwable e222) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e222);
        }
    }
}
