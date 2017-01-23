package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class n {
    static final e j6;

    interface e {
        int DW(MotionEvent motionEvent);

        int DW(MotionEvent motionEvent, int i);

        float FH(MotionEvent motionEvent, int i);

        float Hw(MotionEvent motionEvent, int i);

        int j6(MotionEvent motionEvent);

        int j6(MotionEvent motionEvent, int i);

        float v5(MotionEvent motionEvent, int i);
    }

    static class a implements e {
        a() {
        }

        public int j6(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            return -1;
        }

        public int DW(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float FH(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float Hw(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public int j6(MotionEvent motionEvent) {
            return 1;
        }

        public int DW(MotionEvent motionEvent) {
            return 0;
        }

        public float v5(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    static class b extends a {
        b() {
        }

        public int j6(MotionEvent motionEvent, int i) {
            return o.j6(motionEvent, i);
        }

        public int DW(MotionEvent motionEvent, int i) {
            return o.DW(motionEvent, i);
        }

        public float FH(MotionEvent motionEvent, int i) {
            return o.FH(motionEvent, i);
        }

        public float Hw(MotionEvent motionEvent, int i) {
            return o.Hw(motionEvent, i);
        }

        public int j6(MotionEvent motionEvent) {
            return o.j6(motionEvent);
        }
    }

    static class c extends b {
        c() {
        }

        public int DW(MotionEvent motionEvent) {
            return p.j6(motionEvent);
        }
    }

    static class d extends c {
        d() {
        }

        public float v5(MotionEvent motionEvent, int i) {
            return q.j6(motionEvent, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 12) {
            j6 = new d();
        } else if (VERSION.SDK_INT >= 9) {
            j6 = new c();
        } else if (VERSION.SDK_INT >= 5) {
            j6 = new b();
        } else {
            j6 = new a();
        }
    }

    public static int j6(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int DW(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int j6(MotionEvent motionEvent, int i) {
        return j6.j6(motionEvent, i);
    }

    public static int DW(MotionEvent motionEvent, int i) {
        return j6.DW(motionEvent, i);
    }

    public static float FH(MotionEvent motionEvent, int i) {
        return j6.FH(motionEvent, i);
    }

    public static float Hw(MotionEvent motionEvent, int i) {
        return j6.Hw(motionEvent, i);
    }

    public static int FH(MotionEvent motionEvent) {
        return j6.j6(motionEvent);
    }

    public static int Hw(MotionEvent motionEvent) {
        return j6.DW(motionEvent);
    }

    public static float v5(MotionEvent motionEvent, int i) {
        return j6.v5(motionEvent, i);
    }
}
