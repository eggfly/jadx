package com.faizmalkani.floatingactionbutton;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Fab extends View {
    Context _context;
    float currentY;
    private Display display;
    Bitmap mBitmap;
    Paint mButtonPaint;
    Paint mDrawablePaint;
    boolean mHidden;
    int mScreenHeight;

    public Fab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHidden = false;
        this._context = context;
        init(-1);
    }

    @SuppressLint({"NewApi"})
    public Fab(Context context) {
        super(context);
        this.mHidden = false;
        this._context = context;
        init(-1);
    }

    public void setFabColor(int fabColor) {
        init(fabColor);
    }

    public void setFabDrawable(Drawable fabDrawable) {
        this.mBitmap = ((BitmapDrawable) fabDrawable).getBitmap();
        invalidate();
    }

    @SuppressLint({"NewApi"})
    public void init(int fabColor) {
        setWillNotDraw(false);
        try {
            setLayerType(1, null);
        } catch (NoSuchMethodError e) {
            try {
                Method setLayerTypeMethod = getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class});
                if (setLayerTypeMethod != null) {
                    setLayerTypeMethod.invoke(this, new Object[]{Integer.valueOf(1), null});
                }
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
        this.mButtonPaint = new Paint(1);
        this.mButtonPaint.setColor(fabColor);
        this.mButtonPaint.setStyle(Style.FILL);
        this.mButtonPaint.setShadowLayer(10.0f, 0.0f, 3.5f, Color.argb(100, 0, 0, 0));
        this.mDrawablePaint = new Paint(1);
        invalidate();
        this.display = ((WindowManager) this._context.getSystemService("window")).getDefaultDisplay();
        this.mScreenHeight = getSize().y;
    }

    @TargetApi(13)
    protected Point getSize() {
        Point point = new Point();
        if (VERSION.SDK_INT >= 13) {
            this.display.getSize(point);
        } else {
            point.x = this.display.getWidth();
            point.y = this.display.getHeight();
        }
        return point;
    }

    protected void onDraw(Canvas canvas) {
        setClickable(true);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) (((double) getWidth()) / 2.6d), this.mButtonPaint);
        try {
            canvas.drawBitmap(this.mBitmap, (float) ((getWidth() - this.mBitmap.getWidth()) / 2), (float) ((getHeight() - this.mBitmap.getHeight()) / 2), this.mDrawablePaint);
        } catch (NullPointerException e) {
            this.mBitmap = ((BitmapDrawable) getResources().getDrawable(17301564)).getBitmap();
            canvas.drawBitmap(this.mBitmap, (float) ((getWidth() - this.mBitmap.getWidth()) / 2), (float) ((getHeight() - this.mBitmap.getHeight()) / 2), this.mDrawablePaint);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 1) {
            ViewHelper.setAlpha(this, 1.0f);
        } else if (event.getAction() == 0) {
            ViewHelper.setAlpha(this, 0.6f);
        }
        return super.onTouchEvent(event);
    }

    public int dpToPx(int dp) {
        return Math.round(((float) dp) * (getContext().getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void hideFab() {
        try {
            if (!this.mHidden) {
                this.currentY = ViewHelper.getY(this);
                ObjectAnimator mHideAnimation = ObjectAnimator.ofFloat((Object) this, "Y", (float) this.mScreenHeight);
                mHideAnimation.setInterpolator(new AccelerateInterpolator());
                mHideAnimation.start();
            }
        } catch (Exception e) {
            this.currentY = ViewHelper.getY(this);
            Animation animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.currentY);
            animation.setDuration(1000);
            animation.setFillAfter(true);
            startAnimation(animation);
            setVisibility(8);
        }
        this.mHidden = true;
    }

    public void showFab() {
        try {
            if (this.mHidden) {
                ObjectAnimator mShowAnimation = ObjectAnimator.ofFloat((Object) this, "Y", this.currentY);
                mShowAnimation.setInterpolator(new DecelerateInterpolator());
                mShowAnimation.start();
            }
        } catch (Exception e) {
            setVisibility(0);
            this.currentY = ViewHelper.getY(this);
            Animation animation = new TranslateAnimation(0.0f, 0.0f, this.currentY, 0.0f);
            animation.setDuration(500);
            startAnimation(animation);
        }
        this.mHidden = false;
    }
}
