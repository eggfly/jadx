package android.support.v4.view;

import android.view.KeyEvent;

class h {
    public static int j6(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean j6(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean DW(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
