package com.github.amlcurran.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

class NewShowcaseDrawer extends StandardShowcaseDrawer {
    private static final int ALPHA_60_PERCENT = 153;
    private final float innerRadius;
    private final float outerRadius;

    public NewShowcaseDrawer(Resources resources) {
        super(resources);
        this.outerRadius = resources.getDimension(C0158R.dimen.showcase_radius_outer);
        this.innerRadius = resources.getDimension(C0158R.dimen.showcase_radius_inner);
    }

    public void setShowcaseColour(int color) {
        this.eraserPaint.setColor(color);
    }

    public void drawShowcase(Bitmap buffer, float x, float y, float scaleMultiplier) {
        try {
            Canvas bufferCanvas = new Canvas(buffer);
            this.eraserPaint.setAlpha(ALPHA_60_PERCENT);
            bufferCanvas.drawCircle(x, y, this.outerRadius, this.eraserPaint);
            this.eraserPaint.setAlpha(0);
            bufferCanvas.drawCircle(x, y, this.innerRadius, this.eraserPaint);
        } catch (NullPointerException e) {
        }
    }

    public int getShowcaseWidth() {
        return (int) (this.outerRadius * 2.0f);
    }

    public int getShowcaseHeight() {
        return (int) (this.outerRadius * 2.0f);
    }

    public float getBlockedRadius() {
        return this.innerRadius;
    }

    public void setBackgroundColour(int backgroundColor) {
        this.backgroundColour = backgroundColor;
    }
}
