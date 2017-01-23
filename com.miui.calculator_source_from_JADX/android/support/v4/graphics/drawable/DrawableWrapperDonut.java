package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class DrawableWrapperDonut extends Drawable implements Callback, DrawableWrapper {
    static final Mode f453a;
    Drawable f454b;
    private ColorStateList f455c;
    private Mode f456d;
    private int f457e;
    private Mode f458f;
    private boolean f459g;

    static {
        f453a = Mode.SRC_IN;
    }

    public void draw(Canvas canvas) {
        this.f454b.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f454b.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f454b.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f454b.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f454b.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f454b.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f454b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f454b.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return (this.f455c != null && this.f455c.isStateful()) || this.f454b.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m593a(iArr) || this.f454b.setState(iArr);
    }

    public int[] getState() {
        return this.f454b.getState();
    }

    public Drawable getCurrent() {
        return this.f454b.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f454b.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f454b.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f454b.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f454b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f454b.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f454b.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f454b.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f454b.getPadding(rect);
    }

    public Drawable mutate() {
        Drawable drawable = this.f454b;
        Drawable mutate = drawable.mutate();
        if (mutate != drawable) {
            m594a(mutate);
        }
        return this;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.f454b.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f455c = colorStateList;
        m593a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f456d = mode;
        m593a(getState());
    }

    private boolean m593a(int[] iArr) {
        if (this.f455c == null || this.f456d == null) {
            this.f459g = false;
            clearColorFilter();
        } else {
            int colorForState = this.f455c.getColorForState(iArr, this.f455c.getDefaultColor());
            Mode mode = this.f456d;
            if (!(this.f459g && colorForState == this.f457e && mode == this.f458f)) {
                setColorFilter(colorForState, mode);
                this.f457e = colorForState;
                this.f458f = mode;
                this.f459g = true;
                return true;
            }
        }
        return false;
    }

    public void m594a(Drawable drawable) {
        if (this.f454b != null) {
            this.f454b.setCallback(null);
        }
        this.f454b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidateSelf();
    }
}
