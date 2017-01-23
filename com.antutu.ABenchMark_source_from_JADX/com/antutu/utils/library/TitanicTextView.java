package com.antutu.utils.library;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;

public class TitanicTextView extends TextView {
    private AnimationSetupCallback animationSetupCallback;
    private float maskX;
    private float maskY;
    private float offsetY;
    private boolean setUp;
    private BitmapShader shader;
    private Matrix shaderMatrix;
    private boolean sinking;
    private Drawable wave;

    public interface AnimationSetupCallback {
        void onSetupAnimation(TitanicTextView titanicTextView);
    }

    public TitanicTextView(Context context) {
        super(context);
        init();
    }

    public TitanicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TitanicTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void createShader() {
        if (this.wave == null) {
            this.wave = getResources().getDrawable(C1082R.drawable.wave);
        }
        int intrinsicWidth = this.wave.getIntrinsicWidth();
        int intrinsicHeight = this.wave.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(getCurrentTextColor());
        this.wave.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.wave.draw(canvas);
        this.shader = new BitmapShader(createBitmap, TileMode.REPEAT, TileMode.CLAMP);
        getPaint().setShader(this.shader);
        this.offsetY = (float) ((getHeight() - intrinsicHeight) / 2);
    }

    private void init() {
        this.shaderMatrix = new Matrix();
    }

    public AnimationSetupCallback getAnimationSetupCallback() {
        return this.animationSetupCallback;
    }

    public float getMaskX() {
        return this.maskX;
    }

    public float getMaskY() {
        return this.maskY;
    }

    public boolean isSetUp() {
        return this.setUp;
    }

    public boolean isSinking() {
        return this.sinking;
    }

    protected void onDraw(Canvas canvas) {
        if (!this.sinking || this.shader == null) {
            getPaint().setShader(null);
        } else {
            if (getPaint().getShader() == null) {
                getPaint().setShader(this.shader);
            }
            this.shaderMatrix.setTranslate(this.maskX, this.maskY + this.offsetY);
            this.shader.setLocalMatrix(this.shaderMatrix);
        }
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        createShader();
        if (!this.setUp) {
            this.setUp = true;
            if (this.animationSetupCallback != null) {
                this.animationSetupCallback.onSetupAnimation(this);
            }
        }
    }

    public void setAnimationSetupCallback(AnimationSetupCallback animationSetupCallback) {
        this.animationSetupCallback = animationSetupCallback;
    }

    public void setMaskX(float f) {
        this.maskX = f;
        invalidate();
    }

    public void setMaskY(float f) {
        this.maskY = f;
        invalidate();
    }

    public void setSinking(boolean z) {
        this.sinking = z;
    }

    public void setTextColor(int i) {
        super.setTextColor(i);
        createShader();
    }

    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        createShader();
    }
}
