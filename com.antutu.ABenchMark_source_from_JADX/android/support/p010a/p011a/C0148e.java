package android.support.p010a.p011a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.TintAwareDrawable;
import android.util.AttributeSet;

@TargetApi(21)
/* renamed from: android.support.a.a.e */
abstract class C0148e extends Drawable implements TintAwareDrawable {
    Drawable f675a;

    C0148e() {
    }

    static TypedArray m705b(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void applyTheme(Theme theme) {
        if (this.f675a != null) {
            DrawableCompat.applyTheme(this.f675a, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f675a != null) {
            this.f675a.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f675a != null ? DrawableCompat.getColorFilter(this.f675a) : null;
    }

    public Drawable getCurrent() {
        return this.f675a != null ? this.f675a.getCurrent() : super.getCurrent();
    }

    public int getLayoutDirection() {
        if (this.f675a != null) {
            DrawableCompat.getLayoutDirection(this.f675a);
        }
        return 0;
    }

    public int getMinimumHeight() {
        return this.f675a != null ? this.f675a.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f675a != null ? this.f675a.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        return this.f675a != null ? this.f675a.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        return this.f675a != null ? this.f675a.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        return this.f675a != null ? this.f675a.getTransparentRegion() : super.getTransparentRegion();
    }

    public boolean isAutoMirrored() {
        if (this.f675a != null) {
            DrawableCompat.isAutoMirrored(this.f675a);
        }
        return false;
    }

    public void jumpToCurrentState() {
        if (this.f675a != null) {
            DrawableCompat.jumpToCurrentState(this.f675a);
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f675a != null) {
            this.f675a.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f675a != null ? this.f675a.setLevel(i) : super.onLevelChange(i);
    }

    public void setAutoMirrored(boolean z) {
        if (this.f675a != null) {
            DrawableCompat.setAutoMirrored(this.f675a, z);
        }
    }

    public void setChangingConfigurations(int i) {
        if (this.f675a != null) {
            this.f675a.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f675a != null) {
            this.f675a.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f675a != null) {
            this.f675a.setFilterBitmap(z);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f675a != null) {
            DrawableCompat.setHotspot(this.f675a, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f675a != null) {
            DrawableCompat.setHotspotBounds(this.f675a, i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.f675a != null ? this.f675a.setState(iArr) : super.setState(iArr);
    }
}
