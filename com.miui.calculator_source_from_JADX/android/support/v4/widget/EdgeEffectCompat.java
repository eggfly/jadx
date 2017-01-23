package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class EdgeEffectCompat {
    private static final EdgeEffectImpl f1077b;
    private Object f1078a;

    interface EdgeEffectImpl {
        Object m2161a(Context context);

        void m2162a(Object obj, int i, int i2);

        boolean m2163a(Object obj);

        boolean m2164a(Object obj, float f);

        boolean m2165a(Object obj, float f, float f2);

        boolean m2166a(Object obj, int i);

        boolean m2167a(Object obj, Canvas canvas);

        void m2168b(Object obj);

        boolean m2169c(Object obj);
    }

    static class BaseEdgeEffectImpl implements EdgeEffectImpl {
        BaseEdgeEffectImpl() {
        }

        public Object m2170a(Context context) {
            return null;
        }

        public void m2171a(Object obj, int i, int i2) {
        }

        public boolean m2172a(Object obj) {
            return true;
        }

        public void m2177b(Object obj) {
        }

        public boolean m2173a(Object obj, float f) {
            return false;
        }

        public boolean m2178c(Object obj) {
            return false;
        }

        public boolean m2175a(Object obj, int i) {
            return false;
        }

        public boolean m2176a(Object obj, Canvas canvas) {
            return false;
        }

        public boolean m2174a(Object obj, float f, float f2) {
            return false;
        }
    }

    static class EdgeEffectIcsImpl implements EdgeEffectImpl {
        EdgeEffectIcsImpl() {
        }

        public Object m2179a(Context context) {
            return EdgeEffectCompatIcs.m2197a(context);
        }

        public void m2180a(Object obj, int i, int i2) {
            EdgeEffectCompatIcs.m2198a(obj, i, i2);
        }

        public boolean m2181a(Object obj) {
            return EdgeEffectCompatIcs.m2199a(obj);
        }

        public void m2186b(Object obj) {
            EdgeEffectCompatIcs.m2203b(obj);
        }

        public boolean m2182a(Object obj, float f) {
            return EdgeEffectCompatIcs.m2200a(obj, f);
        }

        public boolean m2187c(Object obj) {
            return EdgeEffectCompatIcs.m2204c(obj);
        }

        public boolean m2184a(Object obj, int i) {
            return EdgeEffectCompatIcs.m2201a(obj, i);
        }

        public boolean m2185a(Object obj, Canvas canvas) {
            return EdgeEffectCompatIcs.m2202a(obj, canvas);
        }

        public boolean m2183a(Object obj, float f, float f2) {
            return EdgeEffectCompatIcs.m2200a(obj, f);
        }
    }

    static class EdgeEffectLollipopImpl extends EdgeEffectIcsImpl {
        EdgeEffectLollipopImpl() {
        }

        public boolean m2188a(Object obj, float f, float f2) {
            return EdgeEffectCompatLollipop.m2205a(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1077b = new EdgeEffectLollipopImpl();
        } else if (VERSION.SDK_INT >= 14) {
            f1077b = new EdgeEffectIcsImpl();
        } else {
            f1077b = new BaseEdgeEffectImpl();
        }
    }

    public EdgeEffectCompat(Context context) {
        this.f1078a = f1077b.m2161a(context);
    }

    public void m2189a(int i, int i2) {
        f1077b.m2162a(this.f1078a, i, i2);
    }

    public boolean m2190a() {
        return f1077b.m2163a(this.f1078a);
    }

    public void m2195b() {
        f1077b.m2168b(this.f1078a);
    }

    public boolean m2191a(float f) {
        return f1077b.m2164a(this.f1078a, f);
    }

    public boolean m2192a(float f, float f2) {
        return f1077b.m2165a(this.f1078a, f, f2);
    }

    public boolean m2196c() {
        return f1077b.m2169c(this.f1078a);
    }

    public boolean m2193a(int i) {
        return f1077b.m2166a(this.f1078a, i);
    }

    public boolean m2194a(Canvas canvas) {
        return f1077b.m2167a(this.f1078a, canvas);
    }
}
