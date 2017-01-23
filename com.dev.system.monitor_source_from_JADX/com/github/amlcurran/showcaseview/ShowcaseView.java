package com.github.amlcurran.showcaseview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.github.amlcurran.showcaseview.AnimationFactory.AnimationEndListener;
import com.github.amlcurran.showcaseview.AnimationFactory.AnimationStartListener;
import com.github.amlcurran.showcaseview.targets.Target;

public class ShowcaseView extends RelativeLayout implements OnClickListener, OnTouchListener, OnPreDrawListener, OnGlobalLayoutListener {
    private static final int HOLO_BLUE;
    private final AnimationFactory animationFactory;
    private Bitmap bitmapBuffer;
    private boolean blockTouches;
    private long fadeInMillis;
    private long fadeOutMillis;
    private boolean hasAlteredText;
    private boolean hasCustomClickListener;
    private boolean hasNoTarget;
    private boolean hideOnTouch;
    private final Button mEndButton;
    private OnShowcaseEventListener mEventListener;
    private float scaleMultiplier;
    private final ShotStateStore shotStateStore;
    private boolean shouldCentreText;
    private final ShowcaseAreaCalculator showcaseAreaCalculator;
    private final ShowcaseDrawer showcaseDrawer;
    private int showcaseX;
    private int showcaseY;
    private final TextDrawer textDrawer;

    /* renamed from: com.github.amlcurran.showcaseview.ShowcaseView.1 */
    class C01591 implements Runnable {
        final /* synthetic */ boolean val$animate;
        final /* synthetic */ Target val$target;

        C01591(Target target, boolean z) {
            this.val$target = target;
            this.val$animate = z;
        }

        public void run() {
            if (!ShowcaseView.this.shotStateStore.hasShot()) {
                ShowcaseView.this.updateBitmap();
                Point targetPoint = this.val$target.getPoint();
                if (targetPoint != null) {
                    ShowcaseView.this.hasNoTarget = false;
                    if (this.val$animate) {
                        ShowcaseView.this.animationFactory.animateTargetToPoint(ShowcaseView.this, targetPoint);
                        return;
                    } else {
                        ShowcaseView.this.setShowcasePosition(targetPoint);
                        return;
                    }
                }
                ShowcaseView.this.hasNoTarget = true;
                ShowcaseView.this.invalidate();
            }
        }
    }

    public static class Builder {
        private final Activity activity;
        final ShowcaseView showcaseView;

        public Builder(Activity activity) {
            this(activity, false);
        }

        public Builder(Activity activity, boolean useNewStyle) {
            this.activity = activity;
            this.showcaseView = new ShowcaseView(activity, useNewStyle);
            this.showcaseView.setTarget(Target.NONE);
        }

        public ShowcaseView build() {
            ShowcaseView.insertShowcaseView(this.showcaseView, this.activity);
            return this.showcaseView;
        }

        public Builder setContentTitle(int resId) {
            return setContentTitle(this.activity.getString(resId));
        }

        public Builder setContentTitle(CharSequence title) {
            this.showcaseView.setContentTitle(title);
            return this;
        }

        public Builder setContentText(int resId) {
            return setContentText(this.activity.getString(resId));
        }

        public Builder setContentText(CharSequence text) {
            this.showcaseView.setContentText(text);
            return this;
        }

        public Builder setTarget(Target target) {
            this.showcaseView.setTarget(target);
            return this;
        }

        public Builder setStyle(int theme) {
            this.showcaseView.setStyle(theme);
            return this;
        }

        public Builder setOnClickListener(OnClickListener onClickListener) {
            this.showcaseView.overrideButtonClick(onClickListener);
            return this;
        }

        public Builder doNotBlockTouches() {
            this.showcaseView.setBlocksTouches(false);
            return this;
        }

        public Builder hideOnTouchOutside() {
            this.showcaseView.setBlocksTouches(true);
            this.showcaseView.setHideOnTouchOutside(true);
            return this;
        }

        public Builder singleShot(long shotId) {
            this.showcaseView.setSingleShot(shotId);
            return this;
        }

        public Builder setShowcaseEventListener(OnShowcaseEventListener showcaseEventListener) {
            this.showcaseView.setOnShowcaseEventListener(showcaseEventListener);
            return this;
        }
    }

    /* renamed from: com.github.amlcurran.showcaseview.ShowcaseView.2 */
    class C02452 implements AnimationEndListener {
        C02452() {
        }

        public void onAnimationEnd() {
            ShowcaseView.this.setVisibility(8);
            ShowcaseView.this.mEventListener.onShowcaseViewDidHide(ShowcaseView.this);
        }
    }

    /* renamed from: com.github.amlcurran.showcaseview.ShowcaseView.3 */
    class C02463 implements AnimationStartListener {
        C02463() {
        }

        public void onAnimationStart() {
            ShowcaseView.this.setVisibility(0);
        }
    }

    static {
        HOLO_BLUE = Color.parseColor("#33B5E5");
    }

    protected ShowcaseView(Context context, boolean newStyle) {
        this(context, null, C0158R.styleable.CustomTheme_showcaseViewStyle, newStyle);
    }

    protected ShowcaseView(Context context, AttributeSet attrs, int defStyle, boolean newStyle) {
        super(context, attrs, defStyle);
        this.showcaseX = -1;
        this.showcaseY = -1;
        this.scaleMultiplier = 1.0f;
        this.hasCustomClickListener = false;
        this.blockTouches = true;
        this.hideOnTouch = false;
        this.mEventListener = OnShowcaseEventListener.NONE;
        this.hasAlteredText = false;
        this.hasNoTarget = false;
        ApiUtils apiUtils = new ApiUtils();
        this.animationFactory = new AnimatorAnimationFactory();
        this.showcaseAreaCalculator = new ShowcaseAreaCalculator();
        this.shotStateStore = new ShotStateStore(context);
        apiUtils.setFitsSystemWindowsCompat(this);
        getViewTreeObserver().addOnPreDrawListener(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        TypedArray styled = context.getTheme().obtainStyledAttributes(attrs, C0158R.styleable.ShowcaseView, C0158R.attr.showcaseViewStyle, C0158R.style.ShowcaseView);
        this.fadeInMillis = (long) getResources().getInteger(17694721);
        this.fadeOutMillis = (long) getResources().getInteger(17694721);
        this.mEndButton = (Button) LayoutInflater.from(context).inflate(C0158R.layout.showcase_button, null);
        if (newStyle) {
            this.showcaseDrawer = new NewShowcaseDrawer(getResources());
        } else {
            this.showcaseDrawer = new StandardShowcaseDrawer(getResources());
        }
        this.textDrawer = new TextDrawer(getResources(), this.showcaseAreaCalculator, getContext());
        updateStyle(styled, false);
        init();
    }

    private void init() {
        setOnTouchListener(this);
        if (this.mEndButton.getParent() == null) {
            int margin = (int) getResources().getDimension(C0158R.dimen.button_margin);
            LayoutParams lps = (LayoutParams) generateDefaultLayoutParams();
            lps.addRule(12);
            lps.addRule(11);
            lps.setMargins(margin, margin, margin, margin);
            this.mEndButton.setLayoutParams(lps);
            this.mEndButton.setText(17039370);
            if (!this.hasCustomClickListener) {
                this.mEndButton.setOnClickListener(this);
            }
            addView(this.mEndButton);
        }
    }

    private boolean hasShot() {
        return this.shotStateStore.hasShot();
    }

    void setShowcasePosition(Point point) {
        setShowcasePosition(point.x, point.y);
    }

    void setShowcasePosition(int x, int y) {
        if (!this.shotStateStore.hasShot()) {
            this.showcaseX = x;
            this.showcaseY = y;
            invalidate();
        }
    }

    public void setTarget(Target target) {
        setShowcase(target, false);
    }

    public void setShowcase(Target target, boolean animate) {
        postDelayed(new C01591(target, animate), 100);
    }

    private void updateBitmap() {
        if (this.bitmapBuffer == null || haveBoundsChanged()) {
            if (this.bitmapBuffer != null) {
                this.bitmapBuffer.recycle();
            }
            this.bitmapBuffer = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Config.ARGB_8888);
        }
    }

    private boolean haveBoundsChanged() {
        return (getMeasuredWidth() == this.bitmapBuffer.getWidth() && getMeasuredHeight() == this.bitmapBuffer.getHeight()) ? false : true;
    }

    public boolean hasShowcaseView() {
        return (this.showcaseX == 1000000 || this.showcaseY == 1000000 || this.hasNoTarget) ? false : true;
    }

    public void setShowcaseX(int x) {
        setShowcasePosition(x, this.showcaseY);
    }

    public void setShowcaseY(int y) {
        setShowcasePosition(this.showcaseX, y);
    }

    public int getShowcaseX() {
        return this.showcaseX;
    }

    public int getShowcaseY() {
        return this.showcaseY;
    }

    public void overrideButtonClick(OnClickListener listener) {
        if (!this.shotStateStore.hasShot()) {
            if (this.mEndButton != null) {
                Button button = this.mEndButton;
                if (listener == null) {
                    Object listener2 = this;
                }
                button.setOnClickListener(listener);
            }
            this.hasCustomClickListener = true;
        }
    }

    public void setOnShowcaseEventListener(OnShowcaseEventListener listener) {
        if (listener != null) {
            this.mEventListener = listener;
        } else {
            this.mEventListener = OnShowcaseEventListener.NONE;
        }
    }

    public void setButtonText(CharSequence text) {
        if (this.mEndButton != null) {
            this.mEndButton.setText(text);
        }
    }

    public boolean onPreDraw() {
        boolean recalculateText;
        if (this.showcaseAreaCalculator.calculateShowcaseRect((float) this.showcaseX, (float) this.showcaseY, this.showcaseDrawer) || this.hasAlteredText) {
            recalculateText = true;
        } else {
            recalculateText = false;
        }
        if (recalculateText) {
            this.textDrawer.calculateTextPosition(getMeasuredWidth(), getMeasuredHeight(), this, this.shouldCentreText);
        }
        this.hasAlteredText = false;
        return true;
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.showcaseX < 0 || this.showcaseY < 0 || this.shotStateStore.hasShot()) {
            super.dispatchDraw(canvas);
            return;
        }
        this.showcaseDrawer.erase(this.bitmapBuffer);
        if (!this.hasNoTarget) {
            this.showcaseDrawer.drawShowcase(this.bitmapBuffer, (float) this.showcaseX, (float) this.showcaseY, this.scaleMultiplier);
            this.showcaseDrawer.drawToCanvas(canvas, this.bitmapBuffer);
        }
        this.textDrawer.draw(canvas);
        super.dispatchDraw(canvas);
    }

    public void onClick(View view) {
        hide();
    }

    public void hide() {
        clearBitmap();
        this.shotStateStore.storeShot();
        this.mEventListener.onShowcaseViewHide(this);
        fadeOutShowcase();
    }

    private void clearBitmap() {
        if (this.bitmapBuffer != null && !this.bitmapBuffer.isRecycled()) {
            this.bitmapBuffer.recycle();
            this.bitmapBuffer = null;
        }
    }

    private void fadeOutShowcase() {
        this.animationFactory.fadeOutView(this, this.fadeOutMillis, new C02452());
    }

    public void show() {
        this.mEventListener.onShowcaseViewShow(this);
        fadeInShowcase();
    }

    private void fadeInShowcase() {
        this.animationFactory.fadeInView(this, this.fadeInMillis, new C02463());
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        double distanceFromFocus = Math.sqrt(Math.pow((double) Math.abs(motionEvent.getRawX() - ((float) this.showcaseX)), 2.0d) + Math.pow((double) Math.abs(motionEvent.getRawY() - ((float) this.showcaseY)), 2.0d));
        if (1 == motionEvent.getAction() && this.hideOnTouch && distanceFromFocus > ((double) this.showcaseDrawer.getBlockedRadius())) {
            hide();
            return true;
        } else if (!this.blockTouches || distanceFromFocus <= ((double) this.showcaseDrawer.getBlockedRadius())) {
            return false;
        } else {
            return true;
        }
    }

    private static void insertShowcaseView(ShowcaseView showcaseView, Activity activity) {
        ((ViewGroup) activity.getWindow().getDecorView()).addView(showcaseView);
        if (showcaseView.hasShot()) {
            showcaseView.hideImmediate();
        } else {
            showcaseView.show();
        }
    }

    private void hideImmediate() {
        setVisibility(8);
    }

    public void setContentTitle(CharSequence title) {
        this.textDrawer.setContentTitle(title);
    }

    public void setContentText(CharSequence text) {
        this.textDrawer.setContentText(text);
    }

    private void setScaleMultiplier(float scaleMultiplier) {
        this.scaleMultiplier = scaleMultiplier;
    }

    public void onGlobalLayout() {
        if (!this.shotStateStore.hasShot()) {
            updateBitmap();
        }
    }

    public void hideButton() {
        this.mEndButton.setVisibility(8);
    }

    public void showButton() {
        this.mEndButton.setVisibility(0);
    }

    public void setShouldCentreText(boolean shouldCentreText) {
        this.shouldCentreText = shouldCentreText;
        this.hasAlteredText = true;
        invalidate();
    }

    private void setSingleShot(long shotId) {
        this.shotStateStore.setSingleShot(shotId);
    }

    public void setButtonPosition(LayoutParams layoutParams) {
        this.mEndButton.setLayoutParams(layoutParams);
    }

    private void setFadeDurations(long fadeInMillis, long fadeOutMillis) {
        this.fadeInMillis = fadeInMillis;
        this.fadeOutMillis = fadeOutMillis;
    }

    public void setHideOnTouchOutside(boolean hideOnTouch) {
        this.hideOnTouch = hideOnTouch;
    }

    public void setBlocksTouches(boolean blockTouches) {
        this.blockTouches = blockTouches;
    }

    public void setStyle(int theme) {
        updateStyle(getContext().obtainStyledAttributes(theme, C0158R.styleable.ShowcaseView), true);
    }

    private void updateStyle(TypedArray styled, boolean invalidate) {
        int backgroundColor = styled.getColor(C0158R.styleable.ShowcaseView_sv_backgroundColor, Color.argb(TransportMediator.FLAG_KEY_MEDIA_NEXT, 80, 80, 80));
        int showcaseColor = styled.getColor(C0158R.styleable.ShowcaseView_sv_showcaseColor, HOLO_BLUE);
        String buttonText = styled.getString(C0158R.styleable.ShowcaseView_sv_buttonText);
        if (TextUtils.isEmpty(buttonText)) {
            buttonText = getResources().getString(17039370);
        }
        boolean tintButton = styled.getBoolean(C0158R.styleable.ShowcaseView_sv_tintButtonColor, true);
        int titleTextAppearance = styled.getResourceId(C0158R.styleable.ShowcaseView_sv_titleTextAppearance, C0158R.style.TextAppearance_ShowcaseView_Title);
        int detailTextAppearance = styled.getResourceId(C0158R.styleable.ShowcaseView_sv_detailTextAppearance, C0158R.style.TextAppearance_ShowcaseView_Detail);
        styled.recycle();
        this.showcaseDrawer.setShowcaseColour(showcaseColor);
        this.showcaseDrawer.setBackgroundColour(backgroundColor);
        tintButton(showcaseColor, tintButton);
        this.mEndButton.setText(buttonText);
        this.textDrawer.setTitleStyling(titleTextAppearance);
        this.textDrawer.setDetailStyling(detailTextAppearance);
        this.hasAlteredText = true;
        if (invalidate) {
            invalidate();
        }
    }

    private void tintButton(int showcaseColor, boolean tintButton) {
        if (tintButton) {
            this.mEndButton.getBackground().setColorFilter(showcaseColor, Mode.MULTIPLY);
        } else {
            this.mEndButton.getBackground().setColorFilter(HOLO_BLUE, Mode.MULTIPLY);
        }
    }
}
