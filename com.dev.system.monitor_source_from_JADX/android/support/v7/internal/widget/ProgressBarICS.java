package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class ProgressBarICS extends View {
    private static final int ANIMATION_RESOLUTION = 200;
    private static final int MAX_LEVEL = 10000;
    private static final int[] android_R_styleable_ProgressBar;
    private AlphaAnimation mAnimation;
    private int mBehavior;
    private Drawable mCurrentDrawable;
    private int mDuration;
    private boolean mInDrawing;
    private boolean mIndeterminate;
    private Drawable mIndeterminateDrawable;
    private Interpolator mInterpolator;
    private long mLastDrawTime;
    private int mMax;
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    private boolean mNoInvalidate;
    private boolean mOnlyIndeterminate;
    private int mProgress;
    private Drawable mProgressDrawable;
    private RefreshProgressRunnable mRefreshProgressRunnable;
    Bitmap mSampleTile;
    private int mSecondaryProgress;
    private boolean mShouldStartAnimationDrawable;
    private Transformation mTransformation;
    private long mUiThreadId;

    private class RefreshProgressRunnable implements Runnable {
        private boolean mFromUser;
        private int mId;
        private int mProgress;

        RefreshProgressRunnable(int id, int progress, boolean fromUser) {
            this.mId = id;
            this.mProgress = progress;
            this.mFromUser = fromUser;
        }

        public void run() {
            ProgressBarICS.this.doRefreshProgress(this.mId, this.mProgress, this.mFromUser, true);
            ProgressBarICS.this.mRefreshProgressRunnable = this;
        }

        public void setup(int id, int progress, boolean fromUser) {
            this.mId = id;
            this.mProgress = progress;
            this.mFromUser = fromUser;
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int progress;
        int secondaryProgress;

        /* renamed from: android.support.v7.internal.widget.ProgressBarICS.SavedState.1 */
        static class C00741 implements Creator<SavedState> {
            C00741() {
            }

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(null);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.progress = in.readInt();
            this.secondaryProgress = in.readInt();
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.progress);
            out.writeInt(this.secondaryProgress);
        }

        static {
            CREATOR = new C00741();
        }
    }

    static {
        android_R_styleable_ProgressBar = new int[]{16843062, 16843063, 16843064, 16843065, 16843066, 16843067, 16843068, 16843069, 16843070, 16843071, 16843039, 16843072, 16843040, 16843073};
    }

    public ProgressBarICS(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        boolean z = false;
        super(context, attrs, defStyle);
        this.mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray a = context.obtainStyledAttributes(attrs, android_R_styleable_ProgressBar, defStyle, styleRes);
        this.mNoInvalidate = true;
        setMax(a.getInt(0, this.mMax));
        setProgress(a.getInt(1, this.mProgress));
        setSecondaryProgress(a.getInt(2, this.mSecondaryProgress));
        boolean indeterminate = a.getBoolean(3, this.mIndeterminate);
        this.mOnlyIndeterminate = a.getBoolean(4, this.mOnlyIndeterminate);
        Drawable drawable = a.getDrawable(5);
        if (drawable != null) {
            setIndeterminateDrawable(tileifyIndeterminate(drawable));
        }
        drawable = a.getDrawable(6);
        if (drawable != null) {
            setProgressDrawable(tileify(drawable, false));
        }
        this.mDuration = a.getInt(7, this.mDuration);
        this.mBehavior = a.getInt(8, this.mBehavior);
        this.mMinWidth = a.getDimensionPixelSize(9, this.mMinWidth);
        this.mMaxWidth = a.getDimensionPixelSize(10, this.mMaxWidth);
        this.mMinHeight = a.getDimensionPixelSize(11, this.mMinHeight);
        this.mMaxHeight = a.getDimensionPixelSize(12, this.mMaxHeight);
        int resID = a.getResourceId(13, 17432587);
        if (resID > 0) {
            setInterpolator(context, resID);
        }
        a.recycle();
        this.mNoInvalidate = false;
        if (this.mOnlyIndeterminate || indeterminate) {
            z = true;
        }
        setIndeterminate(z);
    }

    private Drawable tileify(Drawable drawable, boolean clip) {
        if (drawable instanceof LayerDrawable) {
            int i;
            LayerDrawable background = (LayerDrawable) drawable;
            int N = background.getNumberOfLayers();
            Drawable[] outDrawables = new Drawable[N];
            for (i = 0; i < N; i++) {
                int id = background.getId(i);
                Drawable drawable2 = background.getDrawable(i);
                boolean z = id == 16908301 || id == 16908303;
                outDrawables[i] = tileify(drawable2, z);
            }
            Drawable layerDrawable = new LayerDrawable(outDrawables);
            for (i = 0; i < N; i++) {
                layerDrawable.setId(i, background.getId(i));
            }
            return layerDrawable;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            Bitmap tileBitmap = ((BitmapDrawable) drawable).getBitmap();
            if (this.mSampleTile == null) {
                this.mSampleTile = tileBitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(getDrawableShape());
            shapeDrawable.getPaint().setShader(new BitmapShader(tileBitmap, TileMode.REPEAT, TileMode.CLAMP));
            if (clip) {
                shapeDrawable = new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
    }

    Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable background = (AnimationDrawable) drawable;
        int N = background.getNumberOfFrames();
        Drawable newBg = new AnimationDrawable();
        newBg.setOneShot(background.isOneShot());
        for (int i = 0; i < N; i++) {
            Drawable frame = tileify(background.getFrame(i), true);
            frame.setLevel(MAX_LEVEL);
            newBg.addFrame(frame, background.getDuration(i));
        }
        newBg.setLevel(MAX_LEVEL);
        return newBg;
    }

    private void initProgressBar() {
        this.mMax = 100;
        this.mProgress = 0;
        this.mSecondaryProgress = 0;
        this.mIndeterminate = false;
        this.mOnlyIndeterminate = false;
        this.mDuration = 4000;
        this.mBehavior = 1;
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
    }

    public synchronized boolean isIndeterminate() {
        return this.mIndeterminate;
    }

    public synchronized void setIndeterminate(boolean indeterminate) {
        if (!((this.mOnlyIndeterminate && this.mIndeterminate) || indeterminate == this.mIndeterminate)) {
            this.mIndeterminate = indeterminate;
            if (indeterminate) {
                this.mCurrentDrawable = this.mIndeterminateDrawable;
                startAnimation();
            } else {
                this.mCurrentDrawable = this.mProgressDrawable;
                stopAnimation();
            }
        }
    }

    public Drawable getIndeterminateDrawable() {
        return this.mIndeterminateDrawable;
    }

    public void setIndeterminateDrawable(Drawable d) {
        if (d != null) {
            d.setCallback(this);
        }
        this.mIndeterminateDrawable = d;
        if (this.mIndeterminate) {
            this.mCurrentDrawable = d;
            postInvalidate();
        }
    }

    public Drawable getProgressDrawable() {
        return this.mProgressDrawable;
    }

    public void setProgressDrawable(Drawable d) {
        boolean needUpdate;
        if (this.mProgressDrawable == null || d == this.mProgressDrawable) {
            needUpdate = false;
        } else {
            this.mProgressDrawable.setCallback(null);
            needUpdate = true;
        }
        if (d != null) {
            d.setCallback(this);
            int drawableHeight = d.getMinimumHeight();
            if (this.mMaxHeight < drawableHeight) {
                this.mMaxHeight = drawableHeight;
                requestLayout();
            }
        }
        this.mProgressDrawable = d;
        if (!this.mIndeterminate) {
            this.mCurrentDrawable = d;
            postInvalidate();
        }
        if (needUpdate) {
            updateDrawableBounds(getWidth(), getHeight());
            updateDrawableState();
            doRefreshProgress(16908301, this.mProgress, false, false);
            doRefreshProgress(16908303, this.mSecondaryProgress, false, false);
        }
    }

    protected boolean verifyDrawable(Drawable who) {
        return who == this.mProgressDrawable || who == this.mIndeterminateDrawable || super.verifyDrawable(who);
    }

    public void postInvalidate() {
        if (!this.mNoInvalidate) {
            super.postInvalidate();
        }
    }

    private synchronized void doRefreshProgress(int id, int progress, boolean fromUser, boolean callBackToApp) {
        float scale = this.mMax > 0 ? ((float) progress) / ((float) this.mMax) : 0.0f;
        Drawable d = this.mCurrentDrawable;
        if (d != null) {
            Drawable progressDrawable = null;
            if (d instanceof LayerDrawable) {
                progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(id);
            }
            int level = (int) (10000.0f * scale);
            if (progressDrawable == null) {
                progressDrawable = d;
            }
            progressDrawable.setLevel(level);
        } else {
            invalidate();
        }
    }

    private synchronized void refreshProgress(int id, int progress, boolean fromUser) {
        if (this.mUiThreadId == Thread.currentThread().getId()) {
            doRefreshProgress(id, progress, fromUser, true);
        } else {
            RefreshProgressRunnable r;
            if (this.mRefreshProgressRunnable != null) {
                r = this.mRefreshProgressRunnable;
                this.mRefreshProgressRunnable = null;
                r.setup(id, progress, fromUser);
            } else {
                r = new RefreshProgressRunnable(id, progress, fromUser);
            }
            post(r);
        }
    }

    public synchronized void setProgress(int progress) {
        setProgress(progress, false);
    }

    synchronized void setProgress(int progress, boolean fromUser) {
        if (!this.mIndeterminate) {
            if (progress < 0) {
                progress = 0;
            }
            if (progress > this.mMax) {
                progress = this.mMax;
            }
            if (progress != this.mProgress) {
                this.mProgress = progress;
                refreshProgress(16908301, this.mProgress, fromUser);
            }
        }
    }

    public synchronized void setSecondaryProgress(int secondaryProgress) {
        if (!this.mIndeterminate) {
            if (secondaryProgress < 0) {
                secondaryProgress = 0;
            }
            if (secondaryProgress > this.mMax) {
                secondaryProgress = this.mMax;
            }
            if (secondaryProgress != this.mSecondaryProgress) {
                this.mSecondaryProgress = secondaryProgress;
                refreshProgress(16908303, this.mSecondaryProgress, false);
            }
        }
    }

    public synchronized int getProgress() {
        return this.mIndeterminate ? 0 : this.mProgress;
    }

    public synchronized int getSecondaryProgress() {
        return this.mIndeterminate ? 0 : this.mSecondaryProgress;
    }

    public synchronized int getMax() {
        return this.mMax;
    }

    public synchronized void setMax(int max) {
        if (max < 0) {
            max = 0;
        }
        if (max != this.mMax) {
            this.mMax = max;
            postInvalidate();
            if (this.mProgress > max) {
                this.mProgress = max;
            }
            refreshProgress(16908301, this.mProgress, false);
        }
    }

    public final synchronized void incrementProgressBy(int diff) {
        setProgress(this.mProgress + diff);
    }

    public final synchronized void incrementSecondaryProgressBy(int diff) {
        setSecondaryProgress(this.mSecondaryProgress + diff);
    }

    void startAnimation() {
        if (getVisibility() == 0) {
            if (this.mIndeterminateDrawable instanceof Animatable) {
                this.mShouldStartAnimationDrawable = true;
                this.mAnimation = null;
            } else {
                if (this.mInterpolator == null) {
                    this.mInterpolator = new LinearInterpolator();
                }
                this.mTransformation = new Transformation();
                this.mAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.mAnimation.setRepeatMode(this.mBehavior);
                this.mAnimation.setRepeatCount(-1);
                this.mAnimation.setDuration((long) this.mDuration);
                this.mAnimation.setInterpolator(this.mInterpolator);
                this.mAnimation.setStartTime(-1);
            }
            postInvalidate();
        }
    }

    void stopAnimation() {
        this.mAnimation = null;
        this.mTransformation = null;
        if (this.mIndeterminateDrawable instanceof Animatable) {
            ((Animatable) this.mIndeterminateDrawable).stop();
            this.mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    public void setInterpolator(Context context, int resID) {
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setVisibility(int v) {
        if (getVisibility() != v) {
            super.setVisibility(v);
            if (!this.mIndeterminate) {
                return;
            }
            if (v == 8 || v == 4) {
                stopAnimation();
            } else {
                startAnimation();
            }
        }
    }

    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (!this.mIndeterminate) {
            return;
        }
        if (visibility == 8 || visibility == 4) {
            stopAnimation();
        } else {
            startAnimation();
        }
    }

    public void invalidateDrawable(Drawable dr) {
        if (!this.mInDrawing) {
            if (verifyDrawable(dr)) {
                Rect dirty = dr.getBounds();
                int scrollX = getScrollX() + getPaddingLeft();
                int scrollY = getScrollY() + getPaddingTop();
                invalidate(dirty.left + scrollX, dirty.top + scrollY, dirty.right + scrollX, dirty.bottom + scrollY);
                return;
            }
            super.invalidateDrawable(dr);
        }
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        updateDrawableBounds(w, h);
    }

    private void updateDrawableBounds(int w, int h) {
        int right = (w - getPaddingRight()) - getPaddingLeft();
        int bottom = (h - getPaddingBottom()) - getPaddingTop();
        int top = 0;
        int left = 0;
        if (this.mIndeterminateDrawable != null) {
            if (this.mOnlyIndeterminate && !(this.mIndeterminateDrawable instanceof AnimationDrawable)) {
                float intrinsicAspect = ((float) this.mIndeterminateDrawable.getIntrinsicWidth()) / ((float) this.mIndeterminateDrawable.getIntrinsicHeight());
                float boundAspect = ((float) w) / ((float) h);
                if (intrinsicAspect != boundAspect) {
                    if (boundAspect > intrinsicAspect) {
                        int width = (int) (((float) h) * intrinsicAspect);
                        left = (w - width) / 2;
                        right = left + width;
                    } else {
                        int height = (int) (((float) w) * (1.0f / intrinsicAspect));
                        top = (h - height) / 2;
                        bottom = top + height;
                    }
                }
            }
            this.mIndeterminateDrawable.setBounds(left, top, right, bottom);
        }
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.setBounds(0, 0, right, bottom);
        }
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable d = this.mCurrentDrawable;
        if (d != null) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            long time = getDrawingTime();
            if (this.mAnimation != null) {
                this.mAnimation.getTransformation(time, this.mTransformation);
                float scale = this.mTransformation.getAlpha();
                try {
                    this.mInDrawing = true;
                    d.setLevel((int) (10000.0f * scale));
                    this.mInDrawing = false;
                    if (SystemClock.uptimeMillis() - this.mLastDrawTime >= 200) {
                        this.mLastDrawTime = SystemClock.uptimeMillis();
                        postInvalidateDelayed(200);
                    }
                } catch (Throwable th) {
                    this.mInDrawing = false;
                }
            }
            d.draw(canvas);
            canvas.restore();
            if (this.mShouldStartAnimationDrawable && (d instanceof Animatable)) {
                ((Animatable) d).start();
                this.mShouldStartAnimationDrawable = false;
            }
        }
    }

    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = this.mCurrentDrawable;
        int dw = 0;
        int dh = 0;
        if (d != null) {
            dw = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, d.getIntrinsicWidth()));
            dh = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, d.getIntrinsicHeight()));
        }
        updateDrawableState();
        setMeasuredDimension(resolveSize(dw + (getPaddingLeft() + getPaddingRight()), widthMeasureSpec), resolveSize(dh + (getPaddingTop() + getPaddingBottom()), heightMeasureSpec));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    private void updateDrawableState() {
        int[] state = getDrawableState();
        if (this.mProgressDrawable != null && this.mProgressDrawable.isStateful()) {
            this.mProgressDrawable.setState(state);
        }
        if (this.mIndeterminateDrawable != null && this.mIndeterminateDrawable.isStateful()) {
            this.mIndeterminateDrawable.setState(state);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.progress = this.mProgress;
        ss.secondaryProgress = this.mSecondaryProgress;
        return ss;
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setProgress(ss.progress);
        setSecondaryProgress(ss.secondaryProgress);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIndeterminate) {
            startAnimation();
        }
    }

    protected void onDetachedFromWindow() {
        if (this.mIndeterminate) {
            stopAnimation();
        }
        if (this.mRefreshProgressRunnable != null) {
            removeCallbacks(this.mRefreshProgressRunnable);
        }
        super.onDetachedFromWindow();
    }
}
