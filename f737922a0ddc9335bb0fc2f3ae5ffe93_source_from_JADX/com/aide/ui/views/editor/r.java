package com.aide.ui.views.editor;

import android.graphics.Paint;
import android.graphics.Typeface;

public class r {
    public Typeface DW;
    public boolean FH;
    public float j6;

    public r(float f, Typeface typeface, int i) {
        this.DW = Typeface.create(typeface, i);
        this.j6 = f;
        boolean z = ((i & 1) == 0 || typeface.isBold()) ? false : true;
        this.FH = z;
    }

    public static boolean j6(Typeface typeface, float f) {
        Typeface create = Typeface.create(typeface, 1);
        if (j6(create, f, !create.isBold()) == j6(Typeface.create(typeface, 0), f, false)) {
            return true;
        }
        return false;
    }

    private static float j6(Typeface typeface, float f, boolean z) {
        Paint paint = new Paint();
        paint.setFakeBoldText(z);
        paint.setTypeface(typeface);
        paint.setTextSize(f);
        return paint.measureText("public");
    }
}
