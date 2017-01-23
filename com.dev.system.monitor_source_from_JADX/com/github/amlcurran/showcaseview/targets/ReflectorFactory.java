package com.github.amlcurran.showcaseview.targets;

import android.app.Activity;
import com.github.amlcurran.showcaseview.targets.Reflector.ActionBarType;
import it.gmariotti.cardslib.library.internal.Card;

class ReflectorFactory {

    /* renamed from: com.github.amlcurran.showcaseview.targets.ReflectorFactory.1 */
    static /* synthetic */ class C01611 {
        static final /* synthetic */ int[] f7x376977e2;

        static {
            f7x376977e2 = new int[ActionBarType.values().length];
            try {
                f7x376977e2[ActionBarType.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7x376977e2[ActionBarType.APP_COMPAT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7x376977e2[ActionBarType.ACTIONBAR_SHERLOCK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    ReflectorFactory() {
    }

    public static Reflector getReflectorForActivity(Activity activity) {
        switch (C01611.f7x376977e2[searchForActivitySuperClass(activity).ordinal()]) {
            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                return new ActionBarReflector(activity);
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                return new AppCompatReflector(activity);
            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                return new SherlockReflector(activity);
            default:
                return null;
        }
    }

    private static ActionBarType searchForActivitySuperClass(Activity activity) {
        Class currentLevel = activity.getClass();
        while (currentLevel != Activity.class) {
            if (currentLevel.getSimpleName().equals("SherlockActivity") || currentLevel.getSimpleName().equals("SherlockFragmentActivity")) {
                return ActionBarType.ACTIONBAR_SHERLOCK;
            }
            if (currentLevel.getSimpleName().equals("ActionBarActivity")) {
                return ActionBarType.APP_COMPAT;
            }
            currentLevel = currentLevel.getSuperclass();
        }
        return ActionBarType.STANDARD;
    }
}
