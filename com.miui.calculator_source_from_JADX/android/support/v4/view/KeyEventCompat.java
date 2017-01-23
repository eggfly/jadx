package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public class KeyEventCompat {
    static final KeyEventVersionImpl f771a;

    interface KeyEventVersionImpl {
        void m1228a(KeyEvent keyEvent);

        boolean m1229a(int i, int i2);

        boolean m1230b(int i);
    }

    static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        BaseKeyEventVersionImpl() {
        }

        private static int m1231a(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 != null) {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            } else if (obj != null) {
                return i & (i3 ^ -1);
            } else {
                return i;
            }
        }

        public int m1232a(int i) {
            int i2;
            if ((i & 192) != 0) {
                i2 = i | 1;
            } else {
                i2 = i;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean m1234a(int i, int i2) {
            if (m1231a(m1231a(m1232a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean m1235b(int i) {
            return (m1232a(i) & 247) == 0;
        }

        public void m1233a(KeyEvent keyEvent) {
        }
    }

    static class EclairKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        EclairKeyEventVersionImpl() {
        }

        public void m1236a(KeyEvent keyEvent) {
            KeyEventCompatEclair.m1243a(keyEvent);
        }
    }

    static class HoneycombKeyEventVersionImpl extends EclairKeyEventVersionImpl {
        HoneycombKeyEventVersionImpl() {
        }

        public int m1237a(int i) {
            return KeyEventCompatHoneycomb.m1244a(i);
        }

        public boolean m1238a(int i, int i2) {
            return KeyEventCompatHoneycomb.m1245a(i, i2);
        }

        public boolean m1239b(int i) {
            return KeyEventCompatHoneycomb.m1246b(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f771a = new HoneycombKeyEventVersionImpl();
        } else {
            f771a = new BaseKeyEventVersionImpl();
        }
    }

    public static boolean m1241a(KeyEvent keyEvent, int i) {
        return f771a.m1229a(keyEvent.getMetaState(), i);
    }

    public static boolean m1240a(KeyEvent keyEvent) {
        return f771a.m1230b(keyEvent.getMetaState());
    }

    public static void m1242b(KeyEvent keyEvent) {
        f771a.m1228a(keyEvent);
    }
}
