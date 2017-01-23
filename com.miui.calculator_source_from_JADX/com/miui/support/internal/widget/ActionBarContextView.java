package com.miui.support.internal.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.view.EditActionModeImpl;
import com.miui.support.internal.view.menu.ActionMenuItem;
import com.miui.support.internal.view.menu.ActionMenuPresenter;
import com.miui.support.internal.view.menu.ActionMenuView;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.view.ActionModeAnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ActionBarContextView extends AbsActionBarView implements ActionModeView {
    private final VisibilityAnimListener f2888g;
    private CharSequence f2889h;
    private LinearLayout f2890i;
    private Button f2891j;
    private Button f2892k;
    private TextView f2893l;
    private int f2894m;
    private Drawable f2895n;
    private boolean f2896o;
    private ActionMenuItem f2897p;
    private ActionMenuItem f2898q;
    private WeakReference<ActionMode> f2899r;
    private Animator f2900s;
    private boolean f2901t;
    private int f2902u;
    private int f2903v;
    private List<ActionModeAnimationListener> f2904w;
    private float f2905x;
    private boolean f2906y;
    private OnClickListener f2907z;

    /* renamed from: com.miui.support.internal.widget.ActionBarContextView.1 */
    class C03721 implements OnClickListener {
        final /* synthetic */ ActionBarContextView f2881a;

        C03721(ActionBarContextView actionBarContextView) {
            this.f2881a = actionBarContextView;
        }

        public void onClick(View view) {
            if (view.getId() == 16908313) {
                MenuItem a = this.f2881a.f2897p;
            } else {
                Object b = this.f2881a.f2898q;
            }
            EditActionModeImpl editActionModeImpl = (EditActionModeImpl) this.f2881a.f2899r.get();
            if (editActionModeImpl != null) {
                editActionModeImpl.m4281a((MenuBuilder) editActionModeImpl.getMenu(), a);
            }
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        public CharSequence f2882a;
        public CharSequence f2883b;
        public boolean f2884c;

        /* renamed from: com.miui.support.internal.widget.ActionBarContextView.SavedState.1 */
        final class C03731 implements Creator<SavedState> {
            C03731() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4627a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4628a(i);
            }

            public SavedState m4627a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m4628a(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = new C03731();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2884c = parcel.readInt() != 0;
            this.f2882a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2883b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            super.writeToParcel(parcel, i);
            if (this.f2884c) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            TextUtils.writeToParcel(this.f2882a, parcel, 0);
            TextUtils.writeToParcel(this.f2883b, parcel, 0);
        }
    }

    protected class VisibilityAnimListener implements AnimatorListener {
        boolean f2885a;
        final /* synthetic */ ActionBarContextView f2886b;
        private boolean f2887c;

        protected VisibilityAnimListener(ActionBarContextView actionBarContextView) {
            this.f2886b = actionBarContextView;
            this.f2887c = false;
        }

        public VisibilityAnimListener m4629a(boolean z) {
            this.f2885a = z;
            return this;
        }

        public void onAnimationStart(Animator animator) {
            this.f2886b.setVisibility(0);
            this.f2887c = false;
            this.f2886b.m4649c(this.f2885a);
        }

        public void onAnimationEnd(Animator animator) {
            int i = 0;
            if (!this.f2887c) {
                int i2;
                this.f2886b.m4651d(this.f2885a);
                if (this.f2886b.f2902u == 2) {
                    this.f2886b.m4656h();
                }
                this.f2886b.f2902u = 0;
                this.f2886b.f2900s = null;
                ActionBarContextView actionBarContextView = this.f2886b;
                if (this.f2885a) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                actionBarContextView.setVisibility(i2);
                if (this.f2886b.c != null && this.f2886b.a != null) {
                    ActionMenuView actionMenuView = this.f2886b.a;
                    if (!this.f2885a) {
                        i = 8;
                    }
                    actionMenuView.setVisibility(i);
                }
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f2887c = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public /* bridge */ /* synthetic */ void m4647b() {
        super.m4614b();
    }

    public /* bridge */ /* synthetic */ boolean m4653e() {
        return super.m4618e();
    }

    public /* bridge */ /* synthetic */ ActionMenuView getActionMenuView() {
        return super.getActionMenuView();
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ ActionMenuView getMenuView() {
        return super.getMenuView();
    }

    public /* bridge */ /* synthetic */ void setContentHeight(int i) {
        super.setContentHeight(i);
    }

    public /* bridge */ /* synthetic */ void setSplitView(ActionBarContainer actionBarContainer) {
        super.setSplitView(actionBarContainer);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843668);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2888g = new VisibilityAnimListener(this);
        this.f2907z = new C03721(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.ActionMode, i, 0);
        setBackground(obtainStyledAttributes.getDrawable(C0234R.styleable.ActionMode_android_background));
        this.f2894m = obtainStyledAttributes.getResourceId(C0234R.styleable.ActionMode_android_titleTextStyle, 0);
        this.f = obtainStyledAttributes.getLayoutDimension(C0234R.styleable.ActionMode_android_height, 0);
        this.f2895n = obtainStyledAttributes.getDrawable(C0234R.styleable.ActionMode_android_backgroundSplit);
        this.f2897p = new ActionMenuItem(context, 0, 16908313, 0, 0, context.getString(17039360));
        this.f2898q = new ActionMenuItem(context, 0, 16908314, 0, 0, context.getString(C0234R.string.action_mode_select_all));
        obtainStyledAttributes.recycle();
    }

    public void setContentInset(int i) {
        this.f2903v = i;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.m4386e(false);
            this.b.m4380b();
        }
    }

    public void setSplitActionBar(boolean z) {
        if (this.d != z) {
            if (this.b != null) {
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
                ViewGroup viewGroup;
                if (z) {
                    this.b.m4370a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    layoutParams.width = -1;
                    layoutParams.height = -2;
                    layoutParams.gravity = DeviceHelper.f2555g ? 17 : 80;
                    this.a = (ActionMenuView) this.b.m4369a((ViewGroup) this);
                    this.a.setBackground(this.f2895n);
                    viewGroup = (ViewGroup) this.a.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.a);
                    }
                    this.c.addView(this.a, layoutParams);
                } else {
                    this.a = (ActionMenuView) this.b.m4369a((ViewGroup) this);
                    this.a.setBackground(null);
                    viewGroup = (ViewGroup) this.a.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.a);
                    }
                    addView(this.a, layoutParams);
                }
            }
            super.setSplitActionBar(z);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2884c = m4652d();
        savedState.f2882a = getTitle();
        if (this.f2892k != null) {
            savedState.f2883b = this.f2892k.getText();
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setTitle(savedState.f2882a);
        m4642a(16908314, savedState.f2883b);
        if (savedState.f2884c) {
            m4647b();
        }
    }

    int getActionBarStyle() {
        return 16843668;
    }

    public CharSequence getTitle() {
        return this.f2889h;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2889h = charSequence;
        if (this.f2893l != null) {
            this.f2893l.setText(charSequence);
            this.f2890i.setVisibility(!TextUtils.isEmpty(this.f2889h) ? 0 : 8);
        }
    }

    protected void m4654f() {
        int i;
        int i2 = 0;
        if (this.f2890i == null) {
            CharSequence title;
            this.f2890i = (LinearLayout) LayoutInflater.from(getContext()).inflate(C0264R.layout.action_mode_title_item, this, false);
            this.f2891j = (Button) this.f2890i.findViewById(16908313);
            this.f2892k = (Button) this.f2890i.findViewById(16908314);
            if (this.f2891j != null) {
                title = this.f2897p.getTitle();
                this.f2891j.setText(title);
                this.f2891j.setVisibility(TextUtils.isEmpty(title) ? 8 : 0);
                this.f2891j.setOnClickListener(this.f2907z);
            }
            if (this.f2892k != null) {
                title = this.f2898q.getTitle();
                this.f2892k.setText(title);
                Button button = this.f2892k;
                if (TextUtils.isEmpty(title)) {
                    i = 8;
                } else {
                    i = 0;
                }
                button.setVisibility(i);
                this.f2892k.setOnClickListener(this.f2907z);
            }
            this.f2893l = (TextView) this.f2890i.findViewById(16908310);
            if (this.f2894m != 0) {
                this.f2893l.setTextAppearance(getContext(), this.f2894m);
            }
        }
        this.f2893l.setText(this.f2889h);
        i = !TextUtils.isEmpty(this.f2889h) ? 1 : 0;
        LinearLayout linearLayout = this.f2890i;
        if (i == 0) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
        if (this.f2890i.getParent() == null) {
            addView(this.f2890i);
        }
    }

    public void m4643a(ActionMode actionMode) {
        if (this.f2899r != null) {
            m4657i();
            m4656h();
        }
        m4654f();
        this.f2899r = new WeakReference(actionMode);
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        if (this.b != null) {
            this.b.m4387f(false);
        }
        this.b = new ActionMenuPresenter(getContext(), C0264R.layout.action_menu_layout, C0264R.layout.action_mode_menu_item_layout, C0264R.layout.action_bar_expanded_menu_layout, C0264R.layout.action_bar_list_menu_item_layout);
        this.b.m4375a(true);
        this.b.m4381c(true);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        if (this.d) {
            this.b.m4370a(getContext().getResources().getDisplayMetrics().widthPixels, true);
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.gravity = DeviceHelper.f2555g ? 17 : 80;
            menuBuilder.m4422a(this.b);
            this.a = (ActionMenuView) this.b.m4369a((ViewGroup) this);
            this.a.setBackground(this.f2895n);
            this.c.addView(this.a, layoutParams);
            return;
        }
        menuBuilder.m4422a(this.b);
        this.a = (ActionMenuView) this.b.m4369a((ViewGroup) this);
        this.a.setBackground(null);
        addView(this.a, layoutParams);
    }

    public void m4655g() {
        m4658j();
        this.f2902u = 2;
    }

    public void m4656h() {
        removeAllViews();
        if (this.f2904w != null) {
            this.f2904w.clear();
            this.f2904w = null;
        }
        if (this.c != null) {
            this.c.removeView(this.a);
        }
        this.a = null;
        this.f2899r = null;
    }

    public boolean m4646a() {
        return this.b != null && this.b.m4376a();
    }

    public boolean m4650c() {
        return this.b != null && this.b.m4386e(false);
    }

    public boolean m4652d() {
        return this.b != null && this.b.m4382c();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        int size = MeasureSpec.getSize(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((this.f > 0 ? this.f : MeasureSpec.getSize(i2)) - paddingTop, Integer.MIN_VALUE);
        if (this.a == null || this.a.getParent() != this) {
            i3 = 0;
        } else {
            paddingLeft = m4611a(this.a, paddingLeft, makeMeasureSpec, 0);
            i3 = this.a.getMeasuredHeight() + 0;
        }
        if (!(this.f2890i == null || this.f2890i.getVisibility() == 8)) {
            this.f2890i.measure(MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), makeMeasureSpec);
            i3 += this.f2890i.getMeasuredHeight();
        }
        if (this.f <= 0) {
            int childCount = getChildCount();
            makeMeasureSpec = 0;
            paddingLeft = 0;
            while (makeMeasureSpec < childCount) {
                i3 = getChildAt(makeMeasureSpec).getMeasuredHeight() + paddingTop;
                if (i3 <= paddingLeft) {
                    i3 = paddingLeft;
                }
                makeMeasureSpec++;
                paddingLeft = i3;
            }
            if (paddingLeft > 0) {
                i4 = paddingLeft + this.f2903v;
            }
            setMeasuredDimension(size, i4);
            return;
        }
        if (i3 > 0) {
            i4 = this.f2903v + this.f;
        }
        setMeasuredDimension(size, i4);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop() + this.f2903v;
        int paddingTop2 = (((i4 - i2) - getPaddingTop()) - getPaddingBottom()) - this.f2903v;
        if (!(this.f2890i == null || this.f2890i.getVisibility() == 8)) {
            m4613b(this.f2890i, paddingStart, paddingTop, paddingTop2);
        }
        paddingStart = (i3 - i) - getPaddingEnd();
        if (this.a != null && this.a.getParent() == this) {
            m4615c(this.a, paddingStart, paddingTop, paddingTop2);
        }
        if (this.f2901t) {
            this.f2902u = 1;
            m4641a(true).start();
            this.f2901t = false;
        }
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f2896o) {
            requestLayout();
        }
        this.f2896o = z;
    }

    protected void m4657i() {
        if (this.f2900s != null) {
            this.f2900s.cancel();
            this.f2900s = null;
        }
    }

    protected void m4658j() {
        if (this.f2900s != null) {
            this.f2900s.end();
            this.f2900s = null;
        }
    }

    public float getAnimationProgress() {
        return this.f2905x;
    }

    public void setAnimationProgress(float f) {
        this.f2905x = f;
        m4645a(this.f2906y, this.f2905x);
    }

    protected Animator m4641a(boolean z) {
        float f = 0.0f;
        if (z == this.f2906y && this.f2900s != null) {
            return new AnimatorSet();
        }
        float f2;
        float f3;
        this.f2906y = z;
        ActionMenuView actionMenuView = this.a;
        int height = actionMenuView.getHeight();
        float translationY = actionMenuView.getTranslationY();
        if (z) {
            f2 = (float) ((-this.f) - this.f2903v);
            f3 = ((float) height) + translationY;
        } else {
            float f4 = ((float) height) + translationY;
            f3 = translationY;
            translationY = f4;
            f2 = 0.0f;
            f = (float) ((-this.f) - this.f2903v);
        }
        Animator ofFloat = ObjectAnimator.ofFloat(this, "TranslationY", new float[]{f2, f});
        if (!DeviceHelper.f2553e) {
            ofFloat.setDuration(0);
        }
        if (this.d) {
            long j;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, "TranslationY", new float[]{f3, translationY});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "AnimationProgress", new float[]{0.0f, 1.0f});
            Animator animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            animatorSet.addListener(this.f2888g.m4629a(z));
            if (DeviceHelper.f2553e) {
                j = 250;
            } else {
                j = 0;
            }
            animatorSet.setDuration(j);
            this.f2900s = animatorSet;
            return animatorSet;
        }
        ofFloat.addListener(this.f2888g.m4629a(z));
        return ofFloat;
    }

    public void m4642a(int i, CharSequence charSequence) {
        int i2 = 8;
        Button button;
        if (i == 16908313) {
            if (this.f2891j != null) {
                button = this.f2891j;
                if (!TextUtils.isEmpty(charSequence)) {
                    i2 = 0;
                }
                button.setVisibility(i2);
                this.f2891j.setText(charSequence);
            }
            this.f2897p.setTitle(charSequence);
        } else if (i == 16908314) {
            if (this.f2892k != null) {
                button = this.f2892k;
                if (!TextUtils.isEmpty(charSequence)) {
                    i2 = 0;
                }
                button.setVisibility(i2);
                this.f2892k.setText(charSequence);
            }
            this.f2898q.setTitle(charSequence);
        }
    }

    public void m4648b(boolean z) {
        m4657i();
        if (z) {
            setVisibility(0);
            this.f2901t = true;
            return;
        }
        m4641a(z).start();
    }

    public void m4649c(boolean z) {
        if (this.f2904w != null) {
            for (ActionModeAnimationListener a : this.f2904w) {
                a.m4273a(z);
            }
        }
    }

    public void m4645a(boolean z, float f) {
        if (this.f2904w != null) {
            for (ActionModeAnimationListener a : this.f2904w) {
                a.m4274a(z, f);
            }
        }
    }

    public void m4651d(boolean z) {
        if (this.f2904w != null) {
            for (ActionModeAnimationListener b : this.f2904w) {
                b.m4275b(z);
            }
        }
    }

    public void m4644a(ActionModeAnimationListener actionModeAnimationListener) {
        if (actionModeAnimationListener != null) {
            if (this.f2904w == null) {
                this.f2904w = new ArrayList();
            }
            this.f2904w.add(actionModeAnimationListener);
        }
    }
}
