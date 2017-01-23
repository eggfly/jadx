package android.support.v4.view;

import android.os.Build.VERSION;

public class ScaleGestureDetectorCompat {
    static final ScaleGestureDetectorImpl f825a;

    interface ScaleGestureDetectorImpl {
    }

    private static class BaseScaleGestureDetectorImpl implements ScaleGestureDetectorImpl {
        private BaseScaleGestureDetectorImpl() {
        }
    }

    private static class ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorImpl {
        private ScaleGestureDetectorCompatKitKatImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f825a = new ScaleGestureDetectorCompatKitKatImpl();
        } else {
            f825a = new BaseScaleGestureDetectorImpl();
        }
    }

    private ScaleGestureDetectorCompat() {
    }
}
