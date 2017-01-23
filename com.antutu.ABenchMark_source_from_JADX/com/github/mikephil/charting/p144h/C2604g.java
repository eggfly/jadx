package com.github.mikephil.charting.p144h;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import com.github.mikephil.charting.p136a.C2522a;
import com.github.mikephil.charting.p145i.C2621g;

/* renamed from: com.github.mikephil.charting.h.g */
public abstract class C2604g extends C2603h {
    public C2604g(C2522a c2522a, C2621g c2621g) {
        super(c2522a, c2621g);
    }

    protected void m9966a(Canvas canvas, Path path, int i, int i2) {
        canvas.save();
        canvas.clipPath(path);
        canvas.drawColor((i2 << 24) | (ViewCompat.MEASURED_SIZE_MASK & i));
        canvas.restore();
    }

    protected void m9967a(Canvas canvas, Path path, Drawable drawable) {
        canvas.save();
        canvas.clipPath(path);
        drawable.setBounds((int) this.o.m10092f(), (int) this.o.m10090e(), (int) this.o.m10094g(), (int) this.o.m10096h());
        drawable.draw(canvas);
        canvas.restore();
    }
}
