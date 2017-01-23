package com.jjoe64.graphview.compatible;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import com.jjoe64.graphview.BuildConfig;
import java.lang.reflect.Method;

public class ScaleGestureDetector {
    private Method method_getScaleFactor;
    private Method method_isInProgress;
    private Method method_onTouchEvent;
    private Object realScaleGestureDetector;

    public interface SimpleOnScaleGestureListener {
        boolean onScale(ScaleGestureDetector scaleGestureDetector);
    }

    public ScaleGestureDetector(Context context, SimpleOnScaleGestureListener simpleOnScaleGestureListener) {
        try {
            Class.forName("android.view.ScaleGestureDetector");
            Class<?> classRealScaleGestureDetector = Class.forName("com.jjoe64.graphview.compatible.RealScaleGestureDetector");
            this.method_getScaleFactor = classRealScaleGestureDetector.getMethod("getScaleFactor", new Class[0]);
            this.method_isInProgress = classRealScaleGestureDetector.getMethod("isInProgress", new Class[0]);
            this.method_onTouchEvent = classRealScaleGestureDetector.getMethod("onTouchEvent", new Class[]{MotionEvent.class});
            this.realScaleGestureDetector = classRealScaleGestureDetector.getConstructor(new Class[]{Context.class, getClass(), SimpleOnScaleGestureListener.class}).newInstance(new Object[]{context, this, simpleOnScaleGestureListener});
        } catch (Exception e) {
            Log.w(BuildConfig.PACKAGE_NAME, "*** WARNING *** No scaling available for graphs. Exception:");
            e.printStackTrace();
        }
    }

    public double getScaleFactor() {
        if (this.method_getScaleFactor == null) {
            return 1.0d;
        }
        try {
            return (double) ((Float) this.method_getScaleFactor.invoke(this.realScaleGestureDetector, new Object[0])).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 1.0d;
        }
    }

    public boolean isInProgress() {
        if (this.method_getScaleFactor == null) {
            return false;
        }
        try {
            return ((Boolean) this.method_isInProgress.invoke(this.realScaleGestureDetector, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onTouchEvent(MotionEvent event) {
        if (this.method_onTouchEvent != null) {
            try {
                this.method_onTouchEvent.invoke(this.realScaleGestureDetector, new Object[]{event});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
