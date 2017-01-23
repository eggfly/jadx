package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.C3628R;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import org.android.spdy.SpdyProtocol;

@SuppressLint({"ViewConstructor"})
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    static final Interpolator ANIMATION_INTERPOLATOR;
    static final String LOG_TAG = "PullToRefresh-LoadingLayout";
    protected final ImageView mHeaderImage;
    protected final ProgressBar mHeaderProgress;
    private final TextView mHeaderText;
    private FrameLayout mInnerLayout;
    protected final Mode mMode;
    private CharSequence mPullLabel;
    private CharSequence mRefreshingLabel;
    private CharSequence mReleaseLabel;
    protected final Orientation mScrollDirection;
    private final TextView mSubHeaderText;
    private boolean mUseIntrinsicAnimation;

    /* renamed from: com.handmark.pulltorefresh.library.internal.LoadingLayout.1 */
    static /* synthetic */ class C36311 {
        static final /* synthetic */ int[] f12294x9a7fbd92;
        static final /* synthetic */ int[] f12295x5795f701;

        static {
            f12294x9a7fbd92 = new int[Mode.values().length];
            try {
                f12294x9a7fbd92[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12294x9a7fbd92[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f12295x5795f701 = new int[Orientation.values().length];
            try {
                f12295x5795f701[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12295x5795f701[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        ANIMATION_INTERPOLATOR = new LinearInterpolator();
    }

    public LoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        Drawable drawable;
        ColorStateList colorStateList;
        super(context);
        this.mMode = mode;
        this.mScrollDirection = orientation;
        switch (C36311.f12295x5795f701[orientation.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                LayoutInflater.from(context).inflate(C3628R.layout.pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(C3628R.layout.pull_to_refresh_header_vertical, this);
                break;
        }
        this.mInnerLayout = (FrameLayout) findViewById(C3628R.id.fl_inner);
        this.mHeaderText = (TextView) this.mInnerLayout.findViewById(C3628R.id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.mInnerLayout.findViewById(C3628R.id.pull_to_refresh_progress);
        this.mSubHeaderText = (TextView) this.mInnerLayout.findViewById(C3628R.id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.mInnerLayout.findViewById(C3628R.id.pull_to_refresh_image);
        LayoutParams layoutParams = (LayoutParams) this.mInnerLayout.getLayoutParams();
        switch (C36311.f12294x9a7fbd92[mode.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                layoutParams.gravity = orientation == Orientation.VERTICAL ? 48 : 3;
                this.mPullLabel = context.getString(C3628R.string.pull_to_refresh_from_bottom_pull_label);
                this.mRefreshingLabel = context.getString(C3628R.string.pull_to_refresh_from_bottom_refreshing_label);
                this.mReleaseLabel = context.getString(C3628R.string.pull_to_refresh_from_bottom_release_label);
                break;
            default:
                layoutParams.gravity = orientation == Orientation.VERTICAL ? 80 : 5;
                this.mPullLabel = context.getString(C3628R.string.pull_to_refresh_pull_label);
                this.mRefreshingLabel = context.getString(C3628R.string.pull_to_refresh_refreshing_label);
                this.mReleaseLabel = context.getString(C3628R.string.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrHeaderBackground)) {
            drawable = typedArray.getDrawable(C3628R.styleable.PullToRefresh_ptrHeaderBackground);
            if (drawable != null) {
                ViewCompat.setBackground(this, drawable);
            }
        }
        if (typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(C3628R.styleable.PullToRefresh_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrSubHeaderTextAppearance)) {
            typedValue = new TypedValue();
            typedArray.getValue(C3628R.styleable.PullToRefresh_ptrSubHeaderTextAppearance, typedValue);
            setSubTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrHeaderTextColor)) {
            colorStateList = typedArray.getColorStateList(C3628R.styleable.PullToRefresh_ptrHeaderTextColor);
            if (colorStateList != null) {
                setTextColor(colorStateList);
            }
        }
        if (typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrHeaderSubTextColor)) {
            colorStateList = typedArray.getColorStateList(C3628R.styleable.PullToRefresh_ptrHeaderSubTextColor);
            if (colorStateList != null) {
                setSubTextColor(colorStateList);
            }
        }
        drawable = null;
        if (typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrDrawable)) {
            drawable = typedArray.getDrawable(C3628R.styleable.PullToRefresh_ptrDrawable);
        }
        switch (C36311.f12294x9a7fbd92[mode.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                if (!typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrDrawableEnd)) {
                    if (typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrDrawableBottom)) {
                        Utils.warnDeprecation("ptrDrawableBottom", "ptrDrawableEnd");
                        drawable = typedArray.getDrawable(C3628R.styleable.PullToRefresh_ptrDrawableBottom);
                        break;
                    }
                }
                drawable = typedArray.getDrawable(C3628R.styleable.PullToRefresh_ptrDrawableEnd);
                break;
                break;
            default:
                if (!typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrDrawableStart)) {
                    if (typedArray.hasValue(C3628R.styleable.PullToRefresh_ptrDrawableTop)) {
                        Utils.warnDeprecation("ptrDrawableTop", "ptrDrawableStart");
                        drawable = typedArray.getDrawable(C3628R.styleable.PullToRefresh_ptrDrawableTop);
                        break;
                    }
                }
                drawable = typedArray.getDrawable(C3628R.styleable.PullToRefresh_ptrDrawableStart);
                break;
                break;
        }
        if (drawable == null) {
            drawable = context.getResources().getDrawable(getDefaultDrawableResId());
        }
        setLoadingDrawable(drawable);
        reset();
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.mSubHeaderText == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.mSubHeaderText.setVisibility(8);
            return;
        }
        this.mSubHeaderText.setText(charSequence);
        if (8 == this.mSubHeaderText.getVisibility()) {
            this.mSubHeaderText.setVisibility(0);
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.mHeaderText != null) {
            this.mHeaderText.setTextAppearance(getContext(), i);
        }
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.mHeaderText != null) {
            this.mHeaderText.setTextColor(colorStateList);
        }
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setTextColor(colorStateList);
        }
    }

    public final int getContentSize() {
        switch (C36311.f12295x5795f701[this.mScrollDirection.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return this.mInnerLayout.getWidth();
            default:
                return this.mInnerLayout.getHeight();
        }
    }

    protected abstract int getDefaultDrawableResId();

    public final void hideAllViews() {
        if (this.mHeaderText.getVisibility() == 0) {
            this.mHeaderText.setVisibility(4);
        }
        if (this.mHeaderProgress.getVisibility() == 0) {
            this.mHeaderProgress.setVisibility(4);
        }
        if (this.mHeaderImage.getVisibility() == 0) {
            this.mHeaderImage.setVisibility(4);
        }
        if (this.mSubHeaderText.getVisibility() == 0) {
            this.mSubHeaderText.setVisibility(4);
        }
    }

    protected abstract void onLoadingDrawableSet(Drawable drawable);

    public final void onPull(float f) {
        if (!this.mUseIntrinsicAnimation) {
            onPullImpl(f);
        }
    }

    protected abstract void onPullImpl(float f);

    public final void pullToRefresh() {
        if (this.mHeaderText != null) {
            this.mHeaderText.setText(this.mPullLabel);
        }
        pullToRefreshImpl();
    }

    protected abstract void pullToRefreshImpl();

    public final void refreshing() {
        if (this.mHeaderText != null) {
            this.mHeaderText.setText(this.mRefreshingLabel);
        }
        if (this.mUseIntrinsicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setVisibility(8);
        }
    }

    protected abstract void refreshingImpl();

    public final void releaseToRefresh() {
        if (this.mHeaderText != null) {
            this.mHeaderText.setText(this.mReleaseLabel);
        }
        releaseToRefreshImpl();
    }

    protected abstract void releaseToRefreshImpl();

    public final void reset() {
        if (this.mHeaderText != null) {
            this.mHeaderText.setText(this.mPullLabel);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.mUseIntrinsicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.mSubHeaderText == null) {
            return;
        }
        if (TextUtils.isEmpty(this.mSubHeaderText.getText())) {
            this.mSubHeaderText.setVisibility(8);
        } else {
            this.mSubHeaderText.setVisibility(0);
        }
    }

    protected abstract void resetImpl();

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    public final void setLoadingDrawable(Drawable drawable) {
        this.mHeaderImage.setImageDrawable(drawable);
        this.mUseIntrinsicAnimation = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    public void setPullLabel(CharSequence charSequence) {
        this.mPullLabel = charSequence;
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        this.mRefreshingLabel = charSequence;
    }

    public void setReleaseLabel(CharSequence charSequence) {
        this.mReleaseLabel = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.mHeaderText.setTypeface(typeface);
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }

    public final void showInvisibleViews() {
        if (4 == this.mHeaderText.getVisibility()) {
            this.mHeaderText.setVisibility(0);
        }
        if (4 == this.mHeaderProgress.getVisibility()) {
            this.mHeaderProgress.setVisibility(0);
        }
        if (4 == this.mHeaderImage.getVisibility()) {
            this.mHeaderImage.setVisibility(0);
        }
        if (4 == this.mSubHeaderText.getVisibility()) {
            this.mSubHeaderText.setVisibility(0);
        }
    }
}
