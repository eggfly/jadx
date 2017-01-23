package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public class f {
    static final d j6;

    interface d {
        boolean DW(int i);

        void j6(KeyEvent keyEvent);

        boolean j6(int i, int i2);
    }

    static class a implements d {
        a() {
        }

        private static int j6(int i, int i2, int i3, int i4, int i5) {
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

        public int j6(int i) {
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

        public boolean j6(int i, int i2) {
            if (j6(j6(j6(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean DW(int i) {
            return (j6(i) & 247) == 0;
        }

        public void j6(KeyEvent keyEvent) {
        }
    }

    static class b extends a {
        b() {
        }

        public void j6(KeyEvent keyEvent) {
            g.j6(keyEvent);
        }
    }

    static class c extends b {
        c() {
        }

        public int j6(int i) {
            return h.j6(i);
        }

        public boolean j6(int i, int i2) {
            return h.j6(i, i2);
        }

        public boolean DW(int i) {
            return h.DW(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            j6 = new c();
        } else {
            j6 = new a();
        }
    }

    public static boolean j6(KeyEvent keyEvent, int i) {
        return j6.j6(keyEvent.getMetaState(), i);
    }

    public static boolean j6(KeyEvent keyEvent) {
        return j6.DW(keyEvent.getMetaState());
    }

    public static void DW(KeyEvent keyEvent) {
        j6.j6(keyEvent);
    }
}
