package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0417R;
import android.support.v7.p015b.C0418a;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import com.antutu.redacc.C1692R;
import com.facebook.ads.AdError;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class SwitchCompat extends CompoundButton {
    private static final int[] f1673F;
    private Layout f1674A;
    private TransformationMethod f1675B;
    private C0547a f1676C;
    private final Rect f1677D;
    private final C0616l f1678E;
    private Drawable f1679a;
    private Drawable f1680b;
    private int f1681c;
    private int f1682d;
    private int f1683e;
    private boolean f1684f;
    private CharSequence f1685g;
    private CharSequence f1686h;
    private boolean f1687i;
    private int f1688j;
    private int f1689k;
    private float f1690l;
    private float f1691m;
    private VelocityTracker f1692n;
    private int f1693o;
    private float f1694p;
    private int f1695q;
    private int f1696r;
    private int f1697s;
    private int f1698t;
    private int f1699u;
    private int f1700v;
    private int f1701w;
    private TextPaint f1702x;
    private ColorStateList f1703y;
    private Layout f1704z;

    /* renamed from: android.support.v7.widget.SwitchCompat.1 */
    class C05461 implements AnimationListener {
        final /* synthetic */ boolean f1667a;
        final /* synthetic */ SwitchCompat f1668b;

        C05461(SwitchCompat switchCompat, boolean z) {
            this.f1668b = switchCompat;
            this.f1667a = z;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f1668b.f1676C == animation) {
                this.f1668b.setThumbPosition(this.f1667a ? 1.0f : 0.0f);
                this.f1668b.f1676C = null;
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.v7.widget.SwitchCompat.a */
    private class C0547a extends Animation {
        final float f1669a;
        final float f1670b;
        final float f1671c;
        final /* synthetic */ SwitchCompat f1672d;

        private C0547a(SwitchCompat switchCompat, float f, float f2) {
            this.f1672d = switchCompat;
            this.f1669a = f;
            this.f1670b = f2;
            this.f1671c = f2 - f;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            this.f1672d.setThumbPosition(this.f1669a + (this.f1671c * f));
        }
    }

    static {
        f1673F = new int[]{16842912};
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1692n = VelocityTracker.obtain();
        this.f1677D = new Rect();
        this.f1702x = new TextPaint(1);
        Resources resources = getResources();
        this.f1702x.density = resources.getDisplayMetrics().density;
        bh a = bh.m2502a(context, attributeSet, C0417R.styleable.SwitchCompat, i, 0);
        this.f1679a = a.m2505a(C0417R.styleable.SwitchCompat_android_thumb);
        if (this.f1679a != null) {
            this.f1679a.setCallback(this);
        }
        this.f1680b = a.m2505a(C0417R.styleable.SwitchCompat_track);
        if (this.f1680b != null) {
            this.f1680b.setCallback(this);
        }
        this.f1685g = a.m2511c(C0417R.styleable.SwitchCompat_android_textOn);
        this.f1686h = a.m2511c(C0417R.styleable.SwitchCompat_android_textOff);
        this.f1687i = a.m2507a(C0417R.styleable.SwitchCompat_showText, true);
        this.f1681c = a.m2514e(C0417R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1682d = a.m2514e(C0417R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f1683e = a.m2514e(C0417R.styleable.SwitchCompat_switchPadding, 0);
        this.f1684f = a.m2507a(C0417R.styleable.SwitchCompat_splitTrack, false);
        int g = a.m2518g(C0417R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (g != 0) {
            m2098a(context, g);
        }
        this.f1678E = C0616l.m2672a();
        a.m2506a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1689k = viewConfiguration.getScaledTouchSlop();
        this.f1693o = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private static float m2087a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private Layout m2090a(CharSequence charSequence) {
        CharSequence transformation = this.f1675B != null ? this.f1675B.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.f1702x, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.f1702x)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void m2091a() {
        if (this.f1676C != null) {
            clearAnimation();
            this.f1676C = null;
        }
    }

    private void m2092a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                typeface = Typeface.SANS_SERIF;
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                typeface = Typeface.SERIF;
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                typeface = Typeface.MONOSPACE;
                break;
        }
        m2099a(typeface, i2);
    }

    private void m2094a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void m2095a(boolean z) {
        if (this.f1676C != null) {
            m2091a();
        }
        this.f1676C = new C0547a(this.f1694p, z ? 1.0f : 0.0f, null);
        this.f1676C.setDuration(250);
        this.f1676C.setAnimationListener(new C05461(this, z));
        startAnimation(this.f1676C);
    }

    private boolean m2096a(float f, float f2) {
        if (this.f1679a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f1679a.getPadding(this.f1677D);
        thumbOffset = (thumbOffset + this.f1698t) - this.f1689k;
        return f > ((float) thumbOffset) && f < ((float) ((((this.f1697s + thumbOffset) + this.f1677D.left) + this.f1677D.right) + this.f1689k)) && f2 > ((float) (this.f1699u - this.f1689k)) && f2 < ((float) (this.f1701w + this.f1689k));
    }

    private void m2097b(MotionEvent motionEvent) {
        boolean z = true;
        this.f1688j = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.f1692n.computeCurrentVelocity(AdError.NETWORK_ERROR_CODE);
            float xVelocity = this.f1692n.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f1693o)) {
                z = getTargetCheckedState();
            } else if (bl.m2591a(this)) {
                if (xVelocity >= 0.0f) {
                    z = false;
                }
            } else if (xVelocity <= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        m2094a(motionEvent);
    }

    private boolean getTargetCheckedState() {
        return this.f1694p > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((bl.m2591a(this) ? 1.0f - this.f1694p : this.f1694p) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.f1680b == null) {
            return 0;
        }
        Rect rect = this.f1677D;
        this.f1680b.getPadding(rect);
        Rect a = this.f1679a != null ? ak.m2320a(this.f1679a) : ak.f1817a;
        return ((((this.f1695q - this.f1697s) - rect.left) - rect.right) - a.left) - a.right;
    }

    private void setThumbPosition(float f) {
        this.f1694p = f;
        invalidate();
    }

    public void m2098a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0417R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0417R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.f1703y = colorStateList;
        } else {
            this.f1703y = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0417R.styleable.TextAppearance_android_textSize, 0);
        if (!(dimensionPixelSize == 0 || ((float) dimensionPixelSize) == this.f1702x.getTextSize())) {
            this.f1702x.setTextSize((float) dimensionPixelSize);
            requestLayout();
        }
        m2092a(obtainStyledAttributes.getInt(C0417R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(C0417R.styleable.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(C0417R.styleable.TextAppearance_textAllCaps, false)) {
            this.f1675B = new C0418a(getContext());
        } else {
            this.f1675B = null;
        }
        obtainStyledAttributes.recycle();
    }

    public void m2099a(Typeface typeface, int i) {
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setSwitchTypeface(defaultFromStyle);
            int style = ((defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) ^ -1) & i;
            TextPaint textPaint = this.f1702x;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            this.f1702x.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.f1702x.setFakeBoldText(false);
        this.f1702x.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void draw(Canvas canvas) {
        int i;
        Rect rect = this.f1677D;
        int i2 = this.f1698t;
        int i3 = this.f1699u;
        int i4 = this.f1700v;
        int i5 = this.f1701w;
        int thumbOffset = i2 + getThumbOffset();
        Rect a = this.f1679a != null ? ak.m2320a(this.f1679a) : ak.f1817a;
        if (this.f1680b != null) {
            this.f1680b.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (a != null) {
                if (a.left > rect.left) {
                    i2 += a.left - rect.left;
                }
                thumbOffset = a.top > rect.top ? (a.top - rect.top) + i3 : i3;
                if (a.right > rect.right) {
                    i4 -= a.right - rect.right;
                }
                i = a.bottom > rect.bottom ? i5 - (a.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.f1680b.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.f1679a != null) {
            this.f1679a.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.f1697s) + rect.right;
            this.f1679a.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f1679a != null) {
            DrawableCompat.setHotspot(this.f1679a, f, f2);
        }
        if (this.f1680b != null) {
            DrawableCompat.setHotspot(this.f1680b, f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f1679a != null) {
            this.f1679a.setState(drawableState);
        }
        if (this.f1680b != null) {
            this.f1680b.setState(drawableState);
        }
        invalidate();
    }

    public int getCompoundPaddingLeft() {
        if (!bl.m2591a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f1695q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1683e : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (bl.m2591a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f1695q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1683e : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f1687i;
    }

    public boolean getSplitTrack() {
        return this.f1684f;
    }

    public int getSwitchMinWidth() {
        return this.f1682d;
    }

    public int getSwitchPadding() {
        return this.f1683e;
    }

    public CharSequence getTextOff() {
        return this.f1686h;
    }

    public CharSequence getTextOn() {
        return this.f1685g;
    }

    public Drawable getThumbDrawable() {
        return this.f1679a;
    }

    public int getThumbTextPadding() {
        return this.f1681c;
    }

    public Drawable getTrackDrawable() {
        return this.f1680b;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1679a != null) {
                this.f1679a.jumpToCurrentState();
            }
            if (this.f1680b != null) {
                this.f1680b.jumpToCurrentState();
            }
            m2091a();
            setThumbPosition(isChecked() ? 1.0f : 0.0f);
        }
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f1673F);
        }
        return onCreateDrawableState;
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.f1677D;
        Drawable drawable = this.f1680b;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f1699u + rect.top;
        int i2 = this.f1701w - rect.bottom;
        Drawable drawable2 = this.f1679a;
        if (drawable != null) {
            if (!this.f1684f || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a = ak.m2320a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f1704z : this.f1674A;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.f1703y != null) {
                this.f1702x.setColor(this.f1703y.getColorForState(drawableState, 0));
            }
            this.f1702x.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.f1685g : this.f1686h;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1679a != null) {
            Rect rect = this.f1677D;
            if (this.f1680b != null) {
                this.f1680b.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a = ak.m2320a(this.f1679a);
            max = Math.max(0, a.left - rect.left);
            i5 = Math.max(0, a.right - rect.right);
        } else {
            max = 0;
        }
        if (bl.m2591a(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.f1695q + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.f1695q);
            max = paddingLeft;
        }
        switch (getGravity() & 112) {
            case SpdyProtocol.CUSTOM /*16*/:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f1696r / 2);
                paddingLeft = this.f1696r + paddingTop;
                break;
            case C1692R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.f1696r;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.f1696r + paddingTop;
                break;
        }
        this.f1698t = i5;
        this.f1699u = paddingTop;
        this.f1701w = paddingLeft;
        this.f1700v = max;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int i3 = 0;
        if (this.f1687i) {
            if (this.f1704z == null) {
                this.f1704z = m2090a(this.f1685g);
            }
            if (this.f1674A == null) {
                this.f1674A = m2090a(this.f1686h);
            }
        }
        Rect rect = this.f1677D;
        if (this.f1679a != null) {
            this.f1679a.getPadding(rect);
            intrinsicWidth = (this.f1679a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f1679a.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        this.f1697s = Math.max(this.f1687i ? Math.max(this.f1704z.getWidth(), this.f1674A.getWidth()) + (this.f1681c * 2) : 0, intrinsicWidth);
        if (this.f1680b != null) {
            this.f1680b.getPadding(rect);
            i3 = this.f1680b.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i4 = rect.left;
        intrinsicWidth = rect.right;
        if (this.f1679a != null) {
            rect = ak.m2320a(this.f1679a);
            i4 = Math.max(i4, rect.left);
            intrinsicWidth = Math.max(intrinsicWidth, rect.right);
        }
        intrinsicWidth = Math.max(this.f1682d, intrinsicWidth + (i4 + (this.f1697s * 2)));
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.f1695q = intrinsicWidth;
        this.f1696r = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), intrinsicHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.f1685g : this.f1686h;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1692n.addMovement(motionEvent);
        float x;
        float y;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (isEnabled() && m2096a(x, y)) {
                    this.f1688j = 1;
                    this.f1690l = x;
                    this.f1691m = y;
                    break;
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (this.f1688j != 2) {
                    this.f1688j = 0;
                    this.f1692n.clear();
                    break;
                }
                m2097b(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                switch (this.f1688j) {
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.f1690l) > ((float) this.f1689k) || Math.abs(y - this.f1691m) > ((float) this.f1689k)) {
                            this.f1688j = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f1690l = x;
                            this.f1691m = y;
                            return true;
                        }
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x2 - this.f1690l;
                        x = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > 0.0f ? 1.0f : -1.0f;
                        if (bl.m2591a(this)) {
                            x = -x;
                        }
                        x = m2087a(x + this.f1694p, 0.0f, 1.0f);
                        if (x != this.f1694p) {
                            this.f1690l = x2;
                            setThumbPosition(x);
                        }
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && isShown()) {
            m2095a(isChecked);
            return;
        }
        m2091a();
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    public void setShowText(boolean z) {
        if (this.f1687i != z) {
            this.f1687i = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.f1684f = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f1682d = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f1683e = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.f1702x.getTypeface() != typeface) {
            this.f1702x.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.f1686h = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.f1685g = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f1679a = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.f1678E.m2695a(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f1681c = i;
        requestLayout();
    }

    public void setTrackDrawable(Drawable drawable) {
        this.f1680b = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.f1678E.m2695a(getContext(), i));
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1679a || drawable == this.f1680b;
    }
}
