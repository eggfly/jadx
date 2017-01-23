package com.github.mikephil.charting.p145i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.widget.AutoScrollHelper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.facebook.ads.AdError;
import com.github.mikephil.charting.p039d.C1202f;
import com.github.mikephil.charting.p039d.C2554b;
import com.github.mikephil.charting.p138c.C2541g.C2539a;
import java.util.List;

/* renamed from: com.github.mikephil.charting.i.f */
public abstract class C2620f {
    private static DisplayMetrics f9077a;
    private static int f9078b;
    private static int f9079c;
    private static final int[] f9080d;
    private static Rect f9081e;
    private static FontMetrics f9082f;

    static {
        f9078b = 50;
        f9079c = 8000;
        f9080d = new int[]{1, 10, 100, AdError.NETWORK_ERROR_CODE, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        f9081e = new Rect();
        f9082f = new FontMetrics();
    }

    public static float m10052a(double d) {
        float pow = (float) Math.pow(10.0d, (double) (1 - ((int) ((float) Math.ceil((double) ((float) Math.log10(d < 0.0d ? -d : d)))))));
        return ((float) Math.round(((double) pow) * d)) / pow;
    }

    public static float m10053a(float f) {
        if (f9077a != null) {
            return f * (((float) f9077a.densityDpi) / 160.0f);
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f;
    }

    public static float m10054a(Paint paint) {
        FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static int m10055a() {
        return f9078b;
    }

    public static int m10056a(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static int m10057a(List<C2617c> list, float f, C2539a c2539a) {
        int i = -2147483647;
        float f2 = AutoScrollHelper.NO_MAX;
        for (int i2 = 0; i2 < list.size(); i2++) {
            C2617c c2617c = (C2617c) list.get(i2);
            if (c2539a == null || c2617c.f9071c.m9791l() == c2539a) {
                float abs = Math.abs(c2617c.f9069a - f);
                if (abs < f2) {
                    i = ((C2617c) list.get(i2)).f9070b;
                    f2 = abs;
                }
            }
        }
        return i;
    }

    public static PointF m10058a(PointF pointF, float f, float f2) {
        return new PointF((float) (((double) pointF.x) + (((double) f) * Math.cos(Math.toRadians((double) f2)))), (float) (((double) pointF.y) + (((double) f) * Math.sin(Math.toRadians((double) f2)))));
    }

    public static C2615a m10059a(float f, float f2, float f3) {
        return C2620f.m10072b(f, f2, 0.017453292f * f3);
    }

    public static void m10060a(Context context) {
        if (context == null) {
            f9078b = ViewConfiguration.getMinimumFlingVelocity();
            f9079c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        f9078b = viewConfiguration.getScaledMinimumFlingVelocity();
        f9079c = viewConfiguration.getScaledMaximumFlingVelocity();
        f9077a = context.getResources().getDisplayMetrics();
    }

    public static void m10061a(Canvas canvas, String str, float f, float f2, Paint paint, PointF pointF, float f3) {
        paint.getTextBounds(str, 0, str.length(), f9081e);
        float height = (float) f9081e.height();
        float f4 = 0.0f - ((float) f9081e.left);
        float f5 = 0.0f + height;
        Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Align.LEFT);
        if (f3 != 0.0f) {
            f4 -= ((float) f9081e.width()) * 0.5f;
            f5 -= height * 0.5f;
            if (!(pointF.x == 0.5f && pointF.y == 0.5f)) {
                C2615a a = C2620f.m10059a((float) f9081e.width(), height, f3);
                f -= a.f9065a * (pointF.x - 0.5f);
                f2 -= a.f9066b * (pointF.y - 0.5f);
            }
            canvas.save();
            canvas.translate(f, f2);
            canvas.rotate(f3);
            canvas.drawText(str, f4, f5, paint);
            canvas.restore();
        } else {
            if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
                f4 -= ((float) f9081e.width()) * pointF.x;
                f5 -= height * pointF.y;
            }
            canvas.drawText(str, f4 + f, f5 + f2, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static void m10062a(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(AdError.NETWORK_ERROR_CODE, (float) f9079c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (pointerId = 0; pointerId < pointerCount; pointerId++) {
            if (pointerId != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(pointerId);
                if ((velocityTracker.getYVelocity(pointerId2) * yVelocity) + (velocityTracker.getXVelocity(pointerId2) * xVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void m10063a(View view) {
        if (VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10);
        }
    }

    public static boolean m10064a(C1202f c1202f) {
        return c1202f == null || (c1202f instanceof C2554b);
    }

    public static int[] m10065a(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        return iArr;
    }

    public static double m10066b(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            return d;
        }
        double d2 = d + 0.0d;
        return Double.longBitsToDouble((d2 >= 0.0d ? 1 : -1) + Double.doubleToRawLongBits(d2));
    }

    public static float m10067b(Paint paint) {
        FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom + (fontMetrics.ascent - fontMetrics.top);
    }

    public static float m10068b(List<C2617c> list, float f, C2539a c2539a) {
        float f2 = AutoScrollHelper.NO_MAX;
        for (int i = 0; i < list.size(); i++) {
            C2617c c2617c = (C2617c) list.get(i);
            if (c2617c.f9071c.m9791l() == c2539a) {
                float abs = Math.abs(c2617c.f9069a - f);
                if (abs < f2) {
                    f2 = abs;
                }
            }
        }
        return f2;
    }

    public static int m10069b() {
        return f9079c;
    }

    public static int m10070b(float f) {
        return ((int) Math.ceil(-Math.log10((double) C2620f.m10052a((double) f)))) + 2;
    }

    public static int m10071b(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static C2615a m10072b(float f, float f2, float f3) {
        return new C2615a(Math.abs(((float) Math.cos((double) f3)) * f) + Math.abs(((float) Math.sin((double) f3)) * f2), Math.abs(((float) Math.sin((double) f3)) * f) + Math.abs(((float) Math.cos((double) f3)) * f2));
    }

    public static String[] m10073b(List<String> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = (String) list.get(i);
        }
        return strArr;
    }

    public static float m10074c(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        return f % 360.0f;
    }

    public static C2615a m10075c(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return new C2615a((float) rect.width(), (float) rect.height());
    }
}
