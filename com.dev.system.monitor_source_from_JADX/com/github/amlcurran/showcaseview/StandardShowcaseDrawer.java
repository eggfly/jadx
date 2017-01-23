package com.github.amlcurran.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;

class StandardShowcaseDrawer implements ShowcaseDrawer {
    protected int backgroundColour;
    private final Paint basicPaint;
    protected final Paint eraserPaint;
    protected final Drawable showcaseDrawable;
    private final float showcaseRadius;

    public StandardShowcaseDrawer(Resources resources) {
        PorterDuffXfermode xfermode = new PorterDuffXfermode(Mode.MULTIPLY);
        this.eraserPaint = new Paint();
        this.eraserPaint.setColor(ViewCompat.MEASURED_SIZE_MASK);
        this.eraserPaint.setAlpha(0);
        this.eraserPaint.setXfermode(xfermode);
        this.eraserPaint.setAntiAlias(true);
        this.basicPaint = new Paint();
        this.showcaseRadius = resources.getDimension(C0158R.dimen.showcase_radius);
        this.showcaseDrawable = resources.getDrawable(C0158R.drawable.cling_bleached);
    }

    public void setShowcaseColour(int color) {
        this.showcaseDrawable.setColorFilter(color, Mode.MULTIPLY);
    }

    public void drawShowcase(Bitmap buffer, float x, float y, float scaleMultiplier) {
        Canvas bufferCanvas = new Canvas(buffer);
        bufferCanvas.drawCircle(x, y, this.showcaseRadius, this.eraserPaint);
        int left = (int) (x - ((float) (getShowcaseWidth() / 2)));
        int top = (int) (y - ((float) (getShowcaseHeight() / 2)));
        this.showcaseDrawable.setBounds(left, top, getShowcaseWidth() + left, getShowcaseHeight() + top);
        this.showcaseDrawable.draw(bufferCanvas);
    }

    public int getShowcaseWidth() {
        return this.showcaseDrawable.getIntrinsicWidth();
    }

    public int getShowcaseHeight() {
        return this.showcaseDrawable.getIntrinsicHeight();
    }

    public float getBlockedRadius() {
        return this.showcaseRadius;
    }

    public void setBackgroundColour(int backgroundColor) {
        this.backgroundColour = backgroundColor;
    }

    public void erase(Bitmap bitmapBuffer) {
        try {
            bitmapBuffer.eraseColor(this.backgroundColour);
        } catch (NullPointerException e) {
        }
    }

    public void drawToCanvas(Canvas canvas, Bitmap bitmapBuffer) {
        try {
            canvas.drawBitmap(bitmapBuffer, 0.0f, 0.0f, this.basicPaint);
        } catch (Exception e) {
        }
    }
}
