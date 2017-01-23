package android.support.v4.hardware.display;

import android.content.Context;
import android.view.WindowManager;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat {
    private static final WeakHashMap<Context, DisplayManagerCompat> j6;

    private static class JellybeanMr1Impl extends DisplayManagerCompat {
        private final Object j6;

        public JellybeanMr1Impl(Context context) {
            this.j6 = a.j6(context);
        }
    }

    private static class LegacyImpl extends DisplayManagerCompat {
        private final WindowManager j6;

        public LegacyImpl(Context context) {
            this.j6 = (WindowManager) context.getSystemService("window");
        }
    }

    static {
        j6 = new WeakHashMap();
    }

    DisplayManagerCompat() {
    }
}
