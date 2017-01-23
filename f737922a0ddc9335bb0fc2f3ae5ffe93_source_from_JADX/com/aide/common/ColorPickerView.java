package com.aide.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ColorPickerView extends View {
    private int DW;
    private int FH;
    private int Hw;
    private Paint VH;
    private a Zo;
    private final int[] gn;
    private float j6;
    private float tp;
    private int[] u7;
    private int v5;

    public interface a {
        void j6(int i, String str);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = 0.0f;
        this.DW = 0;
        this.FH = 0;
        this.gn = new int[258];
        this.u7 = new int[65536];
        j6();
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j6 = 0.0f;
        this.DW = 0;
        this.FH = 0;
        this.gn = new int[258];
        this.u7 = new int[65536];
        j6();
    }

    public ColorPickerView(Context context) {
        super(context);
        this.j6 = 0.0f;
        this.DW = 0;
        this.FH = 0;
        this.gn = new int[258];
        this.u7 = new int[65536];
        j6();
    }

    private void j6() {
        DW();
        Context context = getContext();
        this.tp = context.getResources().getDisplayMetrics().density * (Math.min(300.0f, d.v5(context) - 150.0f) / 256.0f);
        this.VH = new Paint(1);
        this.VH.setTextAlign(Align.CENTER);
        this.VH.setTextSize(12.0f);
    }

    public void setCurrentColor(String str) {
        this.Hw = j6(str);
        float[] fArr = new float[3];
        Color.colorToHSV(this.Hw | -16777216, fArr);
        this.j6 = fArr[0];
        FH();
        getCurrentXY();
        invalidate();
        this.Zo.j6(this.Hw, j6(this.Hw));
    }

    public void setInitialColor(String str) {
        this.v5 = j6(str);
    }

    public void setOnColorChangedListener(a aVar) {
        this.Zo = aVar;
    }

    private void DW() {
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        while (f2 < 256.0f) {
            this.gn[i] = Color.rgb(255, 0, (int) f2);
            f2 += 6.0f;
            i++;
        }
        f2 = 0.0f;
        while (f2 < 256.0f) {
            this.gn[i] = Color.rgb(255 - ((int) f2), 0, 255);
            f2 += 6.0f;
            i++;
        }
        f2 = 0.0f;
        while (f2 < 256.0f) {
            this.gn[i] = Color.rgb(0, (int) f2, 255);
            f2 += 6.0f;
            i++;
        }
        f2 = 0.0f;
        while (f2 < 256.0f) {
            this.gn[i] = Color.rgb(0, 255, 255 - ((int) f2));
            f2 += 6.0f;
            i++;
        }
        f2 = 0.0f;
        while (f2 < 256.0f) {
            this.gn[i] = Color.rgb((int) f2, 255, 0);
            f2 += 6.0f;
            i++;
        }
        while (f < 256.0f) {
            this.gn[i] = Color.rgb(255, 255 - ((int) f), 0);
            i++;
            f += 6.0f;
        }
    }

    private void getCurrentXY() {
        int i = 1000;
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = 0;
            while (i3 < 256) {
                int j6 = j6(DW(i2, i3), this.Hw | -16777216);
                if (j6 == 0) {
                    this.DW = i2;
                    this.FH = i3;
                    return;
                }
                if (j6 < i) {
                    this.DW = i2;
                    this.FH = i3;
                } else {
                    j6 = i;
                }
                i3++;
                i = j6;
            }
        }
    }

    private int j6(int i, int i2) {
        return (Math.abs(Color.red(i) - Color.red(i2)) + Math.abs(Color.green(i) - Color.green(i2))) + Math.abs(Color.blue(i) - Color.blue(i2));
    }

    private int getCurrentMainColor() {
        float f = 0.0f;
        int i = 255 - ((int) ((this.j6 * 255.0f) / 360.0f));
        float f2 = 0.0f;
        int i2 = 0;
        while (f2 < 256.0f) {
            if (i2 == i) {
                return Color.rgb(255, 0, (int) f2);
            }
            f2 += 6.0f;
            i2++;
        }
        f2 = 0.0f;
        while (f2 < 256.0f) {
            if (i2 == i) {
                return Color.rgb(255 - ((int) f2), 0, 255);
            }
            f2 += 6.0f;
            i2++;
        }
        f2 = 0.0f;
        while (f2 < 256.0f) {
            if (i2 == i) {
                return Color.rgb(0, (int) f2, 255);
            }
            f2 += 6.0f;
            i2++;
        }
        f2 = 0.0f;
        while (f2 < 256.0f) {
            if (i2 == i) {
                return Color.rgb(0, 255, 255 - ((int) f2));
            }
            f2 += 6.0f;
            i2++;
        }
        f2 = 0.0f;
        while (f2 < 256.0f) {
            if (i2 == i) {
                return Color.rgb((int) f2, 255, 0);
            }
            f2 += 6.0f;
            i2++;
        }
        while (f < 256.0f) {
            if (i2 == i) {
                return Color.rgb(255, 255 - ((int) f), 0);
            }
            i2++;
            f += 6.0f;
        }
        return -65536;
    }

    private void FH() {
        int currentMainColor = getCurrentMainColor();
        int[] iArr = new int[256];
        int i = 0;
        int i2 = 0;
        while (i < 256) {
            int i3 = i2;
            for (i2 = 0; i2 < 256; i2++) {
                if (i == 0) {
                    this.u7[i3] = Color.rgb(255 - (((255 - Color.red(currentMainColor)) * i2) / 255), 255 - (((255 - Color.green(currentMainColor)) * i2) / 255), 255 - (((255 - Color.blue(currentMainColor)) * i2) / 255));
                    iArr[i2] = this.u7[i3];
                } else {
                    this.u7[i3] = Color.rgb(((255 - i) * Color.red(iArr[i2])) / 255, ((255 - i) * Color.green(iArr[i2])) / 255, ((255 - i) * Color.blue(iArr[i2])) / 255);
                }
                i3++;
            }
            i++;
            i2 = i3;
        }
    }

    private int DW(int i, int i2) {
        int i3 = (i2 * 256) + i;
        if (i3 < 0 || i3 >= this.u7.length) {
            return 0;
        }
        return this.u7[i3];
    }

    protected void onDraw(Canvas canvas) {
        Canvas canvas2;
        int i = 255 - ((int) ((this.j6 * 255.0f) / 360.0f));
        for (int i2 = 0; i2 < 256; i2++) {
            this.VH.setStrokeWidth(2.0f * this.tp);
            this.VH.setColor(this.gn[i2]);
            canvas2 = canvas;
            canvas2.drawLine(this.tp * ((float) (i2 + 10)), 0.0f, this.tp * ((float) (i2 + 10)), this.tp * 40.0f, this.VH);
        }
        this.VH.setStrokeWidth(3.0f * this.tp);
        this.VH.setColor(-16777216);
        canvas2 = canvas;
        canvas2.drawLine(this.tp * ((float) (i + 10)), 0.0f, this.tp * ((float) (i + 10)), this.tp * 40.0f, this.VH);
        this.VH.setStyle(Style.STROKE);
        this.VH.setColor(-16777216);
        this.VH.setStrokeWidth(1.0f);
        canvas.drawRect(9.5f * this.tp, 0.0f * this.tp, 266.5f * this.tp, 40.0f * this.tp, this.VH);
        for (int i3 = 0; i3 < 256; i3++) {
            float f = 0.0f;
            this.VH.setShader(new LinearGradient(0.0f, 50.0f * this.tp, f, this.tp * 306.0f, new int[]{this.u7[i3], -16777216}, null, TileMode.REPEAT));
            this.VH.setStrokeWidth(2.0f * this.tp);
            canvas.drawLine(((float) (i3 + 10)) * this.tp, 50.0f * this.tp, ((float) (i3 + 10)) * this.tp, 306.0f * this.tp, this.VH);
        }
        this.VH.setShader(null);
        this.VH.setStyle(Style.STROKE);
        this.VH.setColor(-16777216);
        this.VH.setStrokeWidth(2.0f * this.tp);
        canvas.drawCircle(((float) (this.DW + 10)) * this.tp, ((float) (this.FH + 50)) * this.tp, 6.0f * this.tp, this.VH);
        this.VH.setStyle(Style.STROKE);
        this.VH.setColor(-16777216);
        this.VH.setStrokeWidth(1.0f);
        canvas.drawRect(9.5f * this.tp, this.tp * 50.0f, 266.5f * this.tp, this.tp * 306.0f, this.VH);
        this.VH.setStyle(Style.FILL);
        this.VH.setColor(this.Hw | -16777216);
        canvas.drawRect(9.5f * this.tp, this.tp * 316.0f, this.tp * 139.0f, this.tp * 356.0f, this.VH);
        this.VH.setStyle(Style.FILL);
        this.VH.setColor(this.v5 | -16777216);
        canvas.drawRect(this.tp * 138.0f, this.tp * 316.0f, 266.5f * this.tp, this.tp * 356.0f, this.VH);
        this.VH.setStyle(Style.STROKE);
        this.VH.setColor(-16777216);
        this.VH.setStrokeWidth(1.0f);
        canvas.drawRect(9.5f * this.tp, this.tp * 316.0f, 266.5f * this.tp, this.tp * 356.0f, this.VH);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) (276.0f * this.tp), (int) (366.0f * this.tp));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            float x = (motionEvent.getX() / this.tp) - 10.0f;
            if (x >= 0.0f) {
                f = x;
            }
            if (f > 255.0f) {
                f = 255.0f;
            }
            x = motionEvent.getY() / this.tp;
            if (x < 40.0f) {
                this.j6 = ((255.0f - f) * 360.0f) / 255.0f;
                FH();
            } else {
                this.DW = (int) f;
                this.FH = ((int) x) - 50;
                if (this.FH < 0) {
                    this.FH = 0;
                }
                if (this.FH > 255) {
                    this.FH = 255;
                }
            }
            int DW = DW(this.DW, this.FH);
            this.Hw = Color.argb(Color.alpha(this.Hw), Color.red(DW), Color.green(DW), Color.blue(DW));
            this.Zo.j6(this.Hw, j6(this.Hw));
            invalidate();
        }
        return true;
    }

    public static String j6(int i) {
        if (Color.alpha(i) == 255) {
            return String.format("#%06X", new Object[]{Integer.valueOf(16777215 & i)});
        }
        return String.format("#%08X", new Object[]{Integer.valueOf(i & -1)});
    }

    public static int j6(String str) {
        if (str != null && str.length() == 9 && str.startsWith("#")) {
            return (int) Long.parseLong(str.substring(1), 16);
        }
        if (str != null && str.length() == 7 && str.startsWith("#")) {
            return -16777216 | ((int) Long.parseLong(str.substring(1), 16));
        }
        return -16777216;
    }
}
