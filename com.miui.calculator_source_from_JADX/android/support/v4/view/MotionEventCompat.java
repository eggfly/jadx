package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class MotionEventCompat {
    static final MotionEventVersionImpl f780a;

    interface MotionEventVersionImpl {
        int m1262a(MotionEvent motionEvent);

        int m1263a(MotionEvent motionEvent, int i);

        int m1264b(MotionEvent motionEvent);

        int m1265b(MotionEvent motionEvent, int i);

        float m1266c(MotionEvent motionEvent, int i);

        float m1267d(MotionEvent motionEvent, int i);

        float m1268e(MotionEvent motionEvent, int i);
    }

    static class BaseMotionEventVersionImpl implements MotionEventVersionImpl {
        BaseMotionEventVersionImpl() {
        }

        public int m1270a(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            return -1;
        }

        public int m1272b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float m1273c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float m1274d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public int m1269a(MotionEvent motionEvent) {
            return 1;
        }

        public int m1271b(MotionEvent motionEvent) {
            return 0;
        }

        public float m1275e(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    static class EclairMotionEventVersionImpl extends BaseMotionEventVersionImpl {
        EclairMotionEventVersionImpl() {
        }

        public int m1277a(MotionEvent motionEvent, int i) {
            return MotionEventCompatEclair.m1293a(motionEvent, i);
        }

        public int m1278b(MotionEvent motionEvent, int i) {
            return MotionEventCompatEclair.m1294b(motionEvent, i);
        }

        public float m1279c(MotionEvent motionEvent, int i) {
            return MotionEventCompatEclair.m1295c(motionEvent, i);
        }

        public float m1280d(MotionEvent motionEvent, int i) {
            return MotionEventCompatEclair.m1296d(motionEvent, i);
        }

        public int m1276a(MotionEvent motionEvent) {
            return MotionEventCompatEclair.m1292a(motionEvent);
        }
    }

    static class GingerbreadMotionEventVersionImpl extends EclairMotionEventVersionImpl {
        GingerbreadMotionEventVersionImpl() {
        }

        public int m1281b(MotionEvent motionEvent) {
            return MotionEventCompatGingerbread.m1297a(motionEvent);
        }
    }

    static class HoneycombMr1MotionEventVersionImpl extends GingerbreadMotionEventVersionImpl {
        HoneycombMr1MotionEventVersionImpl() {
        }

        public float m1282e(MotionEvent motionEvent, int i) {
            return MotionEventCompatHoneycombMr1.m1298a(motionEvent, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 12) {
            f780a = new HoneycombMr1MotionEventVersionImpl();
        } else if (VERSION.SDK_INT >= 9) {
            f780a = new GingerbreadMotionEventVersionImpl();
        } else if (VERSION.SDK_INT >= 5) {
            f780a = new EclairMotionEventVersionImpl();
        } else {
            f780a = new BaseMotionEventVersionImpl();
        }
    }

    public static int m1283a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m1285b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m1284a(MotionEvent motionEvent, int i) {
        return f780a.m1263a(motionEvent, i);
    }

    public static int m1286b(MotionEvent motionEvent, int i) {
        return f780a.m1265b(motionEvent, i);
    }

    public static float m1287c(MotionEvent motionEvent, int i) {
        return f780a.m1266c(motionEvent, i);
    }

    public static float m1289d(MotionEvent motionEvent, int i) {
        return f780a.m1267d(motionEvent, i);
    }

    public static int m1288c(MotionEvent motionEvent) {
        return f780a.m1262a(motionEvent);
    }

    public static int m1290d(MotionEvent motionEvent) {
        return f780a.m1264b(motionEvent);
    }

    public static float m1291e(MotionEvent motionEvent, int i) {
        return f780a.m1268e(motionEvent, i);
    }
}
