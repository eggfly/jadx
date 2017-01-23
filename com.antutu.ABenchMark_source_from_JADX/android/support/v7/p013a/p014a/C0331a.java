package android.support.v7.p013a.p014a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.graphics.drawable.DrawableCompat;

/* renamed from: android.support.v7.a.a.a */
public class C0331a extends Drawable implements Callback {
    private Drawable f764a;

    public C0331a(Drawable drawable) {
        m832a(drawable);
    }

    public Drawable m831a() {
        return this.f764a;
    }

    public void m832a(Drawable drawable) {
        if (this.f764a != null) {
            this.f764a.setCallback(null);
        }
        this.f764a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f764a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f764a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f764a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f764a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f764a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f764a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f764a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f764a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f764a.getPadding(rect);
    }

    public int[] getState() {
        return this.f764a.getState();
    }

    public Region getTransparentRegion() {
        return this.f764a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.f764a);
    }

    public boolean isStateful() {
        return this.f764a.isStateful();
    }

    public void jumpToCurrentState() {
        DrawableCompat.jumpToCurrentState(this.f764a);
    }

    protected void onBoundsChange(Rect rect) {
        this.f764a.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.f764a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f764a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.setAutoMirrored(this.f764a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f764a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f764a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f764a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f764a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        DrawableCompat.setHotspot(this.f764a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        DrawableCompat.setHotspotBounds(this.f764a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f764a.setState(iArr);
    }

    public void setTint(int i) {
        DrawableCompat.setTint(this.f764a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f764a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        DrawableCompat.setTintMode(this.f764a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f764a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
