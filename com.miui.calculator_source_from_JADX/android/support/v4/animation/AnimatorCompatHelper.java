package android.support.v4.animation;

import android.os.Build.VERSION;

public abstract class AnimatorCompatHelper {
    static AnimatorProvider f19a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f19a = new HoneycombMr1AnimatorCompatProvider();
        } else {
            f19a = new DonutAnimatorCompatProvider();
        }
    }

    AnimatorCompatHelper() {
    }
}
