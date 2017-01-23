package com.miui.support.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.util.ViewUtils;

public class SlidingButton extends CheckBox {
    private Drawable f4454a;
    private Drawable f4455b;
    private int f4456c;
    private Drawable f4457d;
    private Bitmap f4458e;
    private Paint f4459f;
    private Bitmap f4460g;
    private Paint f4461h;
    private Bitmap f4462i;
    private int f4463j;
    private int f4464k;
    private int f4465l;
    private int f4466m;
    private int f4467n;
    private int f4468o;
    private OnCheckedChangeListener f4469p;
    private Animator f4470q;
    private boolean f4471r;
    private boolean f4472s;
    private Drawable f4473t;
    private Drawable f4474u;
    private AnimatorListener f4475v;

    /* renamed from: com.miui.support.widget.SlidingButton.1 */
    class C05091 extends AnimatorListenerAdapter {
        final /* synthetic */ SlidingButton f4452a;
        private boolean f4453b;

        /* renamed from: com.miui.support.widget.SlidingButton.1.1 */
        class C05081 implements Runnable {
            final /* synthetic */ boolean f4450a;
            final /* synthetic */ C05091 f4451b;

            C05081(C05091 c05091, boolean z) {
                this.f4451b = c05091;
                this.f4450a = z;
            }

            public void run() {
                if (this.f4451b.f4452a.f4469p != null) {
                    this.f4451b.f4452a.f4469p.onCheckedChanged(this.f4451b.f4452a, this.f4450a);
                }
            }
        }

        C05091(SlidingButton slidingButton) {
            this.f4452a = slidingButton;
        }

        public void onAnimationStart(Animator animator) {
            this.f4453b = false;
            this.f4452a.f4471r = true;
        }

        public void onAnimationCancel(Animator animator) {
            this.f4453b = true;
        }

        public void onAnimationEnd(Animator animator) {
            boolean z = false;
            this.f4452a.f4471r = false;
            if (!this.f4453b) {
                this.f4452a.f4470q = null;
                if (this.f4452a.f4468o >= this.f4452a.f4467n) {
                    z = true;
                }
                if (z != this.f4452a.isChecked()) {
                    this.f4452a.setChecked(z);
                    if (this.f4452a.f4469p != null) {
                        this.f4452a.post(new C05081(this, z));
                    }
                }
            }
        }
    }

    public SlidingButton(Context context) {
        this(context, null);
    }

    public SlidingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4471r = false;
        this.f4472s = false;
        this.f4475v = new C05091(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.SlidingButton, i, C0264R.style.Widget_SlidingButton);
        setDrawingCacheEnabled(false);
        this.f4454a = obtainStyledAttributes.getDrawable(C0264R.styleable.SlidingButton_frame);
        this.f4455b = obtainStyledAttributes.getDrawable(C0264R.styleable.SlidingButton_sliderOn);
        this.f4457d = obtainStyledAttributes.getDrawable(C0264R.styleable.SlidingButton_sliderOff);
        setBackground(obtainStyledAttributes.getDrawable(C0264R.styleable.SlidingButton_android_background));
        this.f4463j = this.f4454a.getIntrinsicWidth();
        this.f4464k = this.f4454a.getIntrinsicHeight();
        this.f4465l = Math.min(this.f4463j, this.f4455b.getIntrinsicWidth());
        this.f4466m = 0;
        this.f4467n = this.f4463j - this.f4465l;
        this.f4468o = this.f4466m;
        TypedValue typedValue = new TypedValue();
        obtainStyledAttributes.getValue(C0264R.styleable.SlidingButton_barOff, typedValue);
        TypedValue typedValue2 = new TypedValue();
        obtainStyledAttributes.getValue(C0264R.styleable.SlidingButton_barOn, typedValue2);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0264R.styleable.SlidingButton_barOff);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(C0264R.styleable.SlidingButton_barOn);
        if ((drawable instanceof BitmapDrawable) && (drawable2 instanceof BitmapDrawable)) {
            this.f4458e = Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), (this.f4463j * 2) - this.f4465l, this.f4464k, true);
            if (typedValue.type == typedValue2.type && typedValue.data == typedValue2.data && typedValue.resourceId == typedValue2.resourceId) {
                this.f4460g = this.f4458e;
            } else {
                this.f4460g = Bitmap.createScaledBitmap(((BitmapDrawable) drawable2).getBitmap(), (this.f4463j * 2) - this.f4465l, this.f4464k, true);
            }
        }
        this.f4454a.setBounds(0, 0, this.f4463j, this.f4464k);
        this.f4459f = new Paint();
        this.f4461h = new Paint();
        this.f4461h.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        this.f4459f.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        if (!(this.f4460g == null || this.f4458e == null)) {
            drawable = obtainStyledAttributes.getDrawable(C0264R.styleable.SlidingButton_mask);
            drawable.setBounds(0, 0, this.f4463j, this.f4464k);
            this.f4462i = m6089a(drawable);
            this.f4473t = m6094b(true);
            this.f4474u = m6094b(false);
        }
        obtainStyledAttributes.recycle();
    }

    public void setOnPerformCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f4469p = onCheckedChangeListener;
    }

    private Bitmap m6089a(Drawable drawable) {
        Rect bounds = drawable.getBounds();
        Bitmap createBitmap = Bitmap.createBitmap(bounds.width(), bounds.height(), Config.ALPHA_8);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public void setChecked(boolean z) {
        int i = 255;
        if (isChecked() != z) {
            super.setChecked(z);
            if (this.f4472s) {
                m6091a(z);
                this.f4472s = false;
                return;
            }
            int i2;
            this.f4468o = z ? this.f4467n : this.f4466m;
            Paint paint = this.f4461h;
            if (z) {
                i2 = 255;
            } else {
                i2 = 0;
            }
            paint.setAlpha(i2);
            paint = this.f4459f;
            if (z) {
                i2 = 0;
            } else {
                i2 = 255;
            }
            paint.setAlpha(i2);
            if (!z) {
                i = 0;
            }
            this.f4456c = i;
            invalidate();
        }
    }

    public void setButtonDrawable(Drawable drawable) {
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f4455b.setState(getDrawableState());
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f4463j, this.f4464k);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            this.f4472s = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPressed(boolean z) {
        super.setPressed(z);
        invalidate();
    }

    private void m6091a(boolean z) {
        int i;
        long j;
        long j2 = 180;
        if (this.f4470q != null) {
            this.f4470q.cancel();
            this.f4470q = null;
        }
        Animator animatorSet = new AnimatorSet();
        String str = "SliderOffset";
        int[] iArr = new int[1];
        iArr[0] = z ? this.f4467n : this.f4466m;
        Animator ofInt = ObjectAnimator.ofInt(this, str, iArr);
        str = "SliderOnAlpha";
        iArr = new int[1];
        if (z) {
            i = 255;
        } else {
            i = 0;
        }
        iArr[0] = i;
        Animator ofInt2 = ObjectAnimator.ofInt(this, str, iArr);
        if (DeviceHelper.f2553e) {
            j = 180;
        } else {
            j = 0;
        }
        ofInt2.setDuration(j);
        if (!DeviceHelper.f2553e) {
            j2 = 0;
        }
        ofInt.setDuration(j2);
        if (DeviceHelper.f2553e) {
            animatorSet.play(ofInt2).after(ofInt).after(100);
        } else {
            animatorSet.playTogether(new Animator[]{ofInt2, ofInt});
        }
        this.f4470q = animatorSet;
        this.f4470q.addListener(this.f4475v);
        this.f4470q.start();
    }

    public int getSliderOffset() {
        return this.f4468o;
    }

    public void setSliderOffset(int i) {
        this.f4468o = i;
        invalidate();
    }

    public int getSliderOnAlpha() {
        return this.f4456c;
    }

    public void setSliderOnAlpha(int i) {
        this.f4456c = i;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int i = isEnabled() ? 255 : 127;
        if (!(this.f4462i == null || this.f4460g == null || this.f4458e == null)) {
            if (this.f4471r) {
                canvas.saveLayerAlpha(0.0f, 0.0f, (float) this.f4462i.getWidth(), (float) this.f4462i.getHeight(), i, 4);
                canvas.drawBitmap(this.f4462i, 0.0f, 0.0f, null);
                m6090a(canvas);
                canvas.restore();
            } else if (isChecked()) {
                this.f4473t.draw(canvas);
            } else {
                this.f4474u.draw(canvas);
            }
        }
        this.f4454a.draw(canvas);
        boolean a = ViewUtils.m5452a((View) this);
        int i2 = a ? (this.f4463j - this.f4468o) - this.f4465l : this.f4468o;
        int i3 = a ? this.f4463j - this.f4468o : this.f4465l + this.f4468o;
        if (isChecked()) {
            this.f4455b.setBounds(i2, 0, i3, this.f4464k);
            this.f4455b.draw(canvas);
        } else {
            this.f4457d.setBounds(i2, 0, i3, this.f4464k);
            this.f4457d.draw(canvas);
        }
        setAlpha(((float) i) / 255.0f);
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    private void m6090a(Canvas canvas) {
        if (this.f4461h.getAlpha() != 0) {
            canvas.drawBitmap(this.f4460g, 0.0f, 0.0f, this.f4461h);
        }
        if (this.f4459f.getAlpha() != 0) {
            canvas.drawBitmap(this.f4458e, 0.0f, 0.0f, this.f4459f);
        }
    }

    private Drawable m6094b(boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(this.f4463j, this.f4464k, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(this.f4462i, 0.0f, 0.0f, null);
        if (z) {
            canvas.drawBitmap(this.f4460g, 0.0f, 0.0f, this.f4461h);
        } else {
            canvas.drawBitmap(this.f4458e, 0.0f, 0.0f, this.f4459f);
        }
        Drawable bitmapDrawable = new BitmapDrawable(getContext().getResources(), createBitmap);
        bitmapDrawable.setBounds(0, 0, this.f4463j, this.f4464k);
        return bitmapDrawable;
    }
}
