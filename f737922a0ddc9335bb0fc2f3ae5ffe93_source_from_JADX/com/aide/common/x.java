package com.aide.common;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class x extends Drawable {
    private Drawable DW;
    private String[] FH;
    private Context j6;

    public static void j6(ActionBar actionBar, int i, String[] strArr) {
        Context themedContext = actionBar.getThemedContext();
        if (d.j6(themedContext)) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setIcon(i);
            actionBar.setTitle(strArr[0]);
            actionBar.setSubtitle(strArr[1]);
            return;
        }
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setLogo(new x(themedContext, i, strArr));
    }

    public x(Context context, int i, String[] strArr) {
        this.j6 = context;
        this.FH = strArr;
        this.DW = context.getResources().getDrawable(i);
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(-13421773);
        paint.setAntiAlias(true);
        paint.setTextSize(40.0f);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText(this.FH[0], 120.0f, 40.0f, paint);
        paint.setTextSize(35.0f);
        paint.setTypeface(Typeface.DEFAULT);
        canvas.drawText(this.FH[1], 120.0f, 90.0f, paint);
        this.DW.setBounds(0, 0, 100, 100);
        this.DW.draw(canvas);
    }

    public int getIntrinsicWidth() {
        return 400;
    }

    public int getIntrinsicHeight() {
        return 100;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }
}
