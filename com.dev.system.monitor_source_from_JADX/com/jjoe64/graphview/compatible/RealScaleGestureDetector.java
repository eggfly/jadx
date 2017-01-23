package com.jjoe64.graphview.compatible;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

@SuppressLint({"NewApi"})
public class RealScaleGestureDetector extends ScaleGestureDetector {

    /* renamed from: com.jjoe64.graphview.compatible.RealScaleGestureDetector.1 */
    class C01631 extends SimpleOnScaleGestureListener {
        final /* synthetic */ ScaleGestureDetector.SimpleOnScaleGestureListener val$fakeListener;
        final /* synthetic */ ScaleGestureDetector val$fakeScaleGestureDetector;

        C01631(ScaleGestureDetector.SimpleOnScaleGestureListener simpleOnScaleGestureListener, ScaleGestureDetector scaleGestureDetector) {
            this.val$fakeListener = simpleOnScaleGestureListener;
            this.val$fakeScaleGestureDetector = scaleGestureDetector;
        }

        public boolean onScale(ScaleGestureDetector detector) {
            return this.val$fakeListener.onScale(this.val$fakeScaleGestureDetector);
        }
    }

    public RealScaleGestureDetector(Context context, ScaleGestureDetector fakeScaleGestureDetector, ScaleGestureDetector.SimpleOnScaleGestureListener fakeListener) {
        super(context, new C01631(fakeListener, fakeScaleGestureDetector));
    }
}
