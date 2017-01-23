package android.support.v4.view;

import android.view.KeyEvent;

class KeyEventCompatHoneycomb {
    KeyEventCompatHoneycomb() {
    }

    public static int m1244a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m1245a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m1246b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
