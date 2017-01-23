package com.nineoldandroids.animation;

import android.support.v4.view.MotionEventCompat;

public class ArgbEvaluator implements TypeEvaluator {
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int startInt = ((Integer) startValue).intValue();
        int startA = startInt >> 24;
        int startR = (startInt >> 16) & MotionEventCompat.ACTION_MASK;
        int startG = (startInt >> 8) & MotionEventCompat.ACTION_MASK;
        int startB = startInt & MotionEventCompat.ACTION_MASK;
        int endInt = ((Integer) endValue).intValue();
        return Integer.valueOf(((((((int) (((float) ((endInt >> 24) - startA)) * fraction)) + startA) << 24) | ((((int) (((float) (((endInt >> 16) & MotionEventCompat.ACTION_MASK) - startR)) * fraction)) + startR) << 16)) | ((((int) (((float) (((endInt >> 8) & MotionEventCompat.ACTION_MASK) - startG)) * fraction)) + startG) << 8)) | (((int) (((float) ((endInt & MotionEventCompat.ACTION_MASK) - startB)) * fraction)) + startB));
    }
}
