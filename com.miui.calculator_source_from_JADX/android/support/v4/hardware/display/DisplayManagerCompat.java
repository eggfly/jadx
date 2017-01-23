package android.support.v4.hardware.display;

import android.content.Context;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat {
    private static final WeakHashMap<Context, DisplayManagerCompat> f472a;

    private static class JellybeanMr1Impl extends DisplayManagerCompat {
    }

    private static class LegacyImpl extends DisplayManagerCompat {
    }

    static {
        f472a = new WeakHashMap();
    }

    DisplayManagerCompat() {
    }
}
