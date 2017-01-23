package com.miui.support.internal.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.app.ActionBarImpl;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.util.ActionBarUtils;
import com.miui.support.util.ViewUtils;
import com.miui.support.view.ActionModeAnimationListener;
import com.miui.support.view.ViewPager;
import com.miui.support.view.inputmethod.InputMethodHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SearchActionModeView extends FrameLayout implements AnimatorListener, IdleHandler, TextWatcher, OnClickListener, ActionModeView {
    private View f3223A;
    private List<ActionModeAnimationListener> f3224B;
    private float f3225C;
    private boolean f3226D;
    private int f3227E;
    private int f3228F;
    private View f3229a;
    private EditText f3230b;
    private WeakReference<View> f3231c;
    private WeakReference<View> f3232d;
    private WeakReference<View> f3233e;
    private int[] f3234f;
    private int f3235g;
    private int f3236h;
    private int f3237i;
    private int f3238j;
    private int f3239k;
    private int f3240l;
    private int f3241m;
    private int f3242n;
    private int f3243o;
    private int f3244p;
    private int f3245q;
    private int f3246r;
    private int f3247s;
    private boolean f3248t;
    private boolean f3249u;
    private boolean f3250v;
    private ObjectAnimator f3251w;
    private ActionBarContainer f3252x;
    private ActionBarContainer f3253y;
    private ActionBarView f3254z;

    /* renamed from: com.miui.support.internal.widget.SearchActionModeView.1 */
    class C03961 implements Runnable {
        final /* synthetic */ SearchActionModeView f3215a;

        C03961(SearchActionModeView searchActionModeView) {
            this.f3215a = searchActionModeView;
        }

        public void run() {
            this.f3215a.setResultViewMargin(this.f3215a.f3248t);
        }
    }

    class ActionBarAnimationProcessor implements ActionModeAnimationListener {
        final /* synthetic */ SearchActionModeView f3216a;

        ActionBarAnimationProcessor(SearchActionModeView searchActionModeView) {
            this.f3216a = searchActionModeView;
        }

        public void m4885a(boolean z) {
        }

        public void m4886a(boolean z, float f) {
            if (!z) {
                f = 1.0f - f;
            }
            View actionBarContainer = this.f3216a.getActionBarContainer();
            if (actionBarContainer != null) {
                actionBarContainer.setTranslationY((-f) * ((float) (actionBarContainer.getHeight() - this.f3216a.f3240l)));
            }
        }

        public void m4887b(boolean z) {
            if (z) {
                View tabContainer = this.f3216a.getActionBarContainer().getTabContainer();
                if (tabContainer != null) {
                    tabContainer.setVisibility(8);
                }
            }
        }
    }

    class ContentViewAnimationProcessor implements ActionModeAnimationListener {
        ViewPager f3217a;
        final /* synthetic */ SearchActionModeView f3218b;

        ContentViewAnimationProcessor(SearchActionModeView searchActionModeView) {
            this.f3218b = searchActionModeView;
        }

        public void m4888a(boolean z) {
            if (z) {
                if (this.f3218b.f3227E == Integer.MAX_VALUE) {
                    this.f3218b.getActionBarContainer().getLocationInWindow(this.f3218b.f3234f);
                    this.f3218b.f3227E = this.f3218b.f3234f[1];
                }
                ((View) this.f3218b.f3231c.get()).setAlpha(0.0f);
                ((View) this.f3218b.f3231c.get()).getLocationInWindow(this.f3218b.f3234f);
                this.f3218b.f3237i = this.f3218b.f3234f[1] - this.f3218b.f3227E;
                this.f3218b.f3238j = -this.f3218b.f3237i;
                this.f3218b.f3235g = ((View) this.f3218b.f3231c.get()).getHeight() + this.f3218b.f3240l;
                this.f3218b.f3236h = -this.f3218b.f3235g;
            } else {
                this.f3218b.setContentViewTranslation(this.f3218b.f3240l);
                this.f3218b.m4927a(0, 0);
            }
            this.f3217a = this.f3218b.getViewPager();
            if (this.f3217a != null) {
                this.f3217a.setBottomMarginProgress(z ? 0.0f : 1.0f);
            }
        }

        public void m4889a(boolean z, float f) {
            if (!z) {
                f = 1.0f - f;
            }
            if (this.f3218b.f3240l > 0) {
                this.f3218b.setContentViewTranslation((int) (((float) this.f3218b.f3240l) * f));
            }
            ((View) this.f3218b.f3232d.get()).setTranslationY(((float) this.f3218b.f3237i) + (((float) this.f3218b.f3238j) * f));
            this.f3218b.setTranslationY(((float) this.f3218b.f3235g) + (((float) this.f3218b.f3236h) * f));
        }

        public void m4890b(boolean z) {
            if (!z) {
                ((View) this.f3218b.f3232d.get()).setTranslationY(0.0f);
                ((View) this.f3218b.f3231c.get()).setAlpha(1.0f);
            }
            if (this.f3218b.f3231c.get() != null) {
                ((View) this.f3218b.f3231c.get()).setEnabled(!z);
            }
            if (this.f3218b.f3240l > 0) {
                int f;
                this.f3218b.setContentViewTranslation(0);
                SearchActionModeView searchActionModeView = this.f3218b;
                if (z) {
                    f = this.f3218b.f3240l;
                } else {
                    f = 0;
                }
                searchActionModeView.m4927a(f, 0);
            }
            if (this.f3217a != null) {
                float f2;
                ViewPager viewPager = this.f3217a;
                if (z) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.0f;
                }
                viewPager.setBottomMarginProgress(f2);
            }
            this.f3217a = null;
        }
    }

    class DimViewAnimationProcessor implements ActionModeAnimationListener {
        final /* synthetic */ SearchActionModeView f3219a;

        DimViewAnimationProcessor(SearchActionModeView searchActionModeView) {
            this.f3219a = searchActionModeView;
        }

        public void m4891a(boolean z) {
            if (z) {
                this.f3219a.f3223A.setOnClickListener(this.f3219a);
                this.f3219a.f3223A.setVisibility(0);
                this.f3219a.f3223A.setAlpha(0.0f);
            }
        }

        public void m4892a(boolean z, float f) {
            if (!z) {
                f = 1.0f - f;
            }
            this.f3219a.f3223A.setAlpha(f);
        }

        public void m4893b(boolean z) {
            if (!z) {
                this.f3219a.f3223A.setVisibility(8);
                this.f3219a.f3223A.setAlpha(1.0f);
            } else if (this.f3219a.f3230b.getText().length() > 0) {
                this.f3219a.f3223A.setVisibility(8);
            }
        }
    }

    class SearchViewAnimationProcessor implements ActionModeAnimationListener {
        final /* synthetic */ SearchActionModeView f3220a;
        private int f3221b;

        SearchViewAnimationProcessor(SearchActionModeView searchActionModeView) {
            this.f3220a = searchActionModeView;
        }

        public void m4894a(boolean z) {
            if (z) {
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f3220a.f3229a.measure(makeMeasureSpec, makeMeasureSpec);
                if (DeviceHelper.f2555g) {
                    this.f3221b = ((MarginLayoutParams) this.f3220a.f3229a.getLayoutParams()).getMarginStart();
                } else {
                    this.f3221b = ((MarginLayoutParams) this.f3220a.f3229a.getLayoutParams()).getMarginEnd();
                    this.f3220a.f3230b.setBackgroundResource(C0264R.drawable.edit_text_search_input_bg_light);
                }
                this.f3220a.f3241m = this.f3220a.f3229a.getMeasuredWidth() + this.f3221b;
                this.f3220a.f3242n = this.f3220a.f3241m;
                this.f3220a.f3230b.getText().clear();
                this.f3220a.f3230b.addTextChangedListener(this.f3220a);
            }
        }

        public void m4895a(boolean z, float f) {
            if (!z) {
                f = 1.0f - f;
            }
            boolean a = ViewUtils.m5452a(this.f3220a);
            int i = a ? -1 : 1;
            int width = this.f3220a.getWidth();
            if (DeviceHelper.f2555g) {
                this.f3220a.f3229a.setTranslationX(((float) i) * (((float) this.f3220a.f3241m) - (((float) this.f3220a.f3242n) * f)));
                i = (int) (((float) (width - this.f3220a.getPaddingEnd())) - (((float) this.f3220a.f3242n) * f));
                if (a) {
                    this.f3220a.f3230b.setLeft(width - i);
                } else {
                    this.f3220a.f3230b.setRight(i);
                }
            } else {
                this.f3220a.f3229a.setTranslationX(((((float) this.f3220a.f3242n) * f) - ((float) this.f3220a.f3241m)) * ((float) i));
                float d = ((float) this.f3220a.f3241m) - ((1.0f - f) * ((float) this.f3220a.f3242n));
                if (!z) {
                    d -= (float) this.f3220a.f3242n;
                }
                this.f3220a.f3230b.setTranslationX(((float) i) * d);
            }
            if (this.f3220a.f3240l > 0) {
                this.f3220a.setPadding(this.f3220a.getPaddingLeft(), (int) (((float) this.f3220a.f3239k) + (((float) this.f3220a.f3240l) * f)), this.f3220a.getPaddingRight(), this.f3220a.getPaddingBottom());
            }
            this.f3220a.f3230b.setAlpha(f);
            this.f3220a.setAlpha(f);
        }

        public void m4896b(boolean z) {
            float f = 0.0f;
            this.f3220a.f3230b.setTranslationX(0.0f);
            EditText c = this.f3220a.f3230b;
            if (z) {
                f = 1.0f;
            }
            c.setAlpha(f);
            if (!DeviceHelper.f2555g) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f3220a.f3230b.getLayoutParams();
                marginLayoutParams.setMarginStart(z ? this.f3220a.f3229a.getWidth() + this.f3221b : 0);
                this.f3220a.f3230b.setLayoutParams(marginLayoutParams);
            }
            if (!z) {
                this.f3220a.f3230b.setBackgroundResource(C0264R.drawable.edit_text_search_normal_light);
                this.f3220a.f3230b.removeTextChangedListener(this.f3220a);
            } else if (DeviceHelper.f2555g) {
                marginLayoutParams = (MarginLayoutParams) this.f3220a.f3230b.getLayoutParams();
                marginLayoutParams.setMarginEnd(this.f3220a.f3229a.getWidth() + this.f3221b);
                this.f3220a.f3230b.setLayoutParams(marginLayoutParams);
            }
        }
    }

    class SplitActionBarAnimationProcessor implements ActionModeAnimationListener {
        final /* synthetic */ SearchActionModeView f3222a;

        SplitActionBarAnimationProcessor(SearchActionModeView searchActionModeView) {
            this.f3222a = searchActionModeView;
        }

        public void m4897a(boolean z) {
        }

        public void m4898a(boolean z, float f) {
            if (!z) {
                f = 1.0f - f;
            }
            View splitActionBarContainer = this.f3222a.getSplitActionBarContainer();
            if (splitActionBarContainer != null) {
                splitActionBarContainer.setTranslationY(((float) splitActionBarContainer.getHeight()) * f);
            }
        }

        public void m4899b(boolean z) {
        }
    }

    public SearchActionModeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3234f = new int[2];
        this.f3227E = Integer.MAX_VALUE;
        setAlpha(0.0f);
    }

    public void m4933b(boolean z) {
        if (this.f3248t == z) {
            this.f3250v = false;
            return;
        }
        m4934c();
        this.f3248t = z;
        this.f3251w = m4932b();
        m4936d();
        if (z) {
            setOverlayMode(true);
        }
        m4930a(z);
        if (m4917i()) {
            requestLayout();
            this.f3250v = true;
        } else {
            this.f3251w.start();
        }
        if (!this.f3248t) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f3230b.getWindowToken(), 0);
        }
    }

    public void setOnBackClickListener(OnClickListener onClickListener) {
        this.f3229a.setOnClickListener(onClickListener);
    }

    public void setAnchorView(View view) {
        if (view != null) {
            this.f3231c = new WeakReference(view);
        }
    }

    public void setAnimateView(View view) {
        if (view != null) {
            this.f3232d = new WeakReference(view);
        }
    }

    public void m4929a(ActionModeAnimationListener actionModeAnimationListener) {
        if (actionModeAnimationListener != null) {
            if (this.f3224B == null) {
                this.f3224B = new ArrayList();
            }
            this.f3224B.add(actionModeAnimationListener);
        }
    }

    public void setResultView(View view) {
        if (view != null) {
            this.f3233e = new WeakReference(view);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof MarginLayoutParams) {
                this.f3244p = ((MarginLayoutParams) layoutParams).topMargin;
                this.f3245q = ((MarginLayoutParams) layoutParams).bottomMargin;
                this.f3249u = true;
            }
        }
    }

    public EditText getSearchInput() {
        return this.f3230b;
    }

    public void m4937g() {
        if (this.f3251w != null) {
            this.f3251w.cancel();
        }
    }

    public void m4938h() {
        m4926a();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.f3252x = null;
        this.f3254z = null;
        if (this.f3224B != null) {
            this.f3224B.clear();
            this.f3224B = null;
        }
        this.f3253y = null;
    }

    public float getAnimationProgress() {
        return this.f3225C;
    }

    public void setAnimationProgress(float f) {
        this.f3225C = f;
        m4931a(this.f3248t, this.f3225C);
    }

    protected void m4926a() {
        if (this.f3251w != null) {
            this.f3251w.cancel();
            this.f3251w = null;
        }
    }

    protected ObjectAnimator m4932b() {
        if (this.f3251w != null) {
            this.f3251w.cancel();
            this.f3251w = null;
            m4913f();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "AnimationProgress", new float[]{0.0f, 1.0f});
        ofFloat.addListener(this);
        ofFloat.setDuration(DeviceHelper.f2553e ? 250 : 0);
        return ofFloat;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f3229a = findViewById(C0264R.id.search_btn_cancel);
        this.f3230b = (EditText) findViewById(16908297);
        this.f3239k = getPaddingTop();
        View contentView = getContentView();
        if (contentView != null) {
            this.f3246r = contentView.getPaddingTop();
            this.f3247s = contentView.getPaddingBottom();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3250v) {
            if (this.f3248t && m4917i()) {
                ((View) this.f3232d.get()).setTranslationY((float) this.f3237i);
            }
            m4910e();
            this.f3250v = false;
        }
    }

    protected ActionBarContainer getActionBarContainer() {
        if (this.f3252x == null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) ActionBarUtils.m5257a(this);
            if (actionBarOverlayLayout != null) {
                for (int i = 0; i < actionBarOverlayLayout.getChildCount(); i++) {
                    View childAt = actionBarOverlayLayout.getChildAt(i);
                    if (childAt.getId() == C0264R.id.action_bar_container && (childAt instanceof ActionBarContainer)) {
                        this.f3252x = (ActionBarContainer) childAt;
                        break;
                    }
                }
            }
            if (this.f3252x != null) {
                this.f3228F = ((MarginLayoutParams) this.f3252x.getLayoutParams()).topMargin;
                if (this.f3228F > 0) {
                    setPadding(getPaddingLeft(), this.f3239k + this.f3228F, getPaddingRight(), getPaddingBottom());
                }
            }
        }
        return this.f3252x;
    }

    protected ActionBarContainer getSplitActionBarContainer() {
        if (this.f3253y == null) {
            ViewGroup a = ActionBarUtils.m5257a(this);
            if (a != null) {
                for (int i = 0; i < a.getChildCount(); i++) {
                    View childAt = a.getChildAt(i);
                    if (childAt.getId() == C0264R.id.split_action_bar && (childAt instanceof ActionBarContainer)) {
                        this.f3253y = (ActionBarContainer) childAt;
                        break;
                    }
                }
            }
        }
        return this.f3253y;
    }

    protected ActionBarView getActionBarView() {
        if (this.f3254z == null) {
            ViewGroup a = ActionBarUtils.m5257a(this);
            if (a != null) {
                this.f3254z = (ActionBarView) a.findViewById(C0264R.id.action_bar);
            }
        }
        return this.f3254z;
    }

    protected View getDimView() {
        if (this.f3223A == null) {
            ViewGroup a = ActionBarUtils.m5257a(this);
            if (a != null) {
                this.f3223A = a.findViewById(C0264R.id.content_mask);
            }
        }
        return this.f3223A;
    }

    protected void m4934c() {
        getActionBarView();
        getActionBarContainer();
        getSplitActionBarContainer();
    }

    protected void setOverlayMode(boolean z) {
        ((ActionBarOverlayLayout) ActionBarUtils.m5257a(this)).setOverlayMode(z);
    }

    protected ViewPager getViewPager() {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) ActionBarUtils.m5257a(this);
        if (((ActionBarImpl) actionBarOverlayLayout.getActionBar()).m3679e()) {
            return (ViewPager) actionBarOverlayLayout.findViewById(C0264R.id.view_pager);
        }
        return null;
    }

    protected void setResultViewMargin(boolean z) {
        if (this.f3233e != null && this.f3249u) {
            int height;
            int i;
            if (z) {
                height = (getHeight() - this.f3240l) - this.f3228F;
                i = 0;
            } else {
                height = this.f3244p;
                i = this.f3245q;
            }
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) ((View) this.f3233e.get()).getLayoutParams();
            marginLayoutParams.topMargin = height;
            marginLayoutParams.bottomMargin = i;
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f3226D = false;
        if (this.f3248t) {
            setAlpha(1.0f);
            return;
        }
        View tabContainer = getActionBarContainer().getTabContainer();
        if (tabContainer != null) {
            tabContainer.setVisibility(0);
        }
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f3226D) {
            this.f3251w = null;
            m4935c(this.f3248t);
            if (this.f3248t) {
                InputMethodHelper.m5661a().m5662a(this.f3230b);
            } else {
                InputMethodHelper.m5661a().m5664b(this.f3230b);
            }
            if (DeviceHelper.f2553e) {
                setResultViewMargin(this.f3248t);
            } else {
                post(new C03961(this));
            }
            if (!this.f3248t) {
                setOverlayMode(false);
                setAlpha(0.0f);
                m4938h();
            }
        }
    }

    public void onAnimationCancel(Animator animator) {
        this.f3226D = true;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void m4928a(ActionMode actionMode) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f3243o = charSequence == null ? 0 : charSequence.length();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        if ((editable == null ? 0 : editable.length()) == 0) {
            if (this.f3223A != null) {
                this.f3223A.setVisibility(0);
            }
            InputMethodHelper.m5661a().m5662a(this.f3230b);
        } else if (this.f3243o == 0 && this.f3223A != null) {
            this.f3223A.setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (view.getId() == C0264R.id.content_mask) {
            this.f3229a.performClick();
        }
    }

    protected void setContentViewTranslation(int i) {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.setTranslationY((float) i);
        }
    }

    protected void m4927a(int i, int i2) {
        View contentView = getContentView();
        if (contentView != null) {
            contentView.setPadding(contentView.getPaddingLeft(), this.f3246r + i, contentView.getPaddingRight(), this.f3247s + i2);
        }
    }

    private View getContentView() {
        ViewGroup a = ActionBarUtils.m5257a(this);
        if (a != null) {
            return a.findViewById(16908290);
        }
        return null;
    }

    public boolean queueIdle() {
        this.f3251w.start();
        return false;
    }

    private void m4910e() {
        m4913f();
        getMessageQueue().addIdleHandler(this);
    }

    private void m4913f() {
        getMessageQueue().removeIdleHandler(this);
    }

    private MessageQueue getMessageQueue() {
        return Looper.myQueue();
    }

    protected void m4936d() {
        if (this.f3224B == null) {
            this.f3224B = new ArrayList();
        }
        if (getDimView() != null) {
            this.f3224B.add(new DimViewAnimationProcessor(this));
        }
        this.f3224B.add(new SearchViewAnimationProcessor(this));
        if (m4917i()) {
            this.f3224B.add(new ContentViewAnimationProcessor(this));
            this.f3224B.add(new ActionBarAnimationProcessor(this));
            this.f3224B.add(new SplitActionBarAnimationProcessor(this));
        }
    }

    public void m4930a(boolean z) {
        if (this.f3224B != null) {
            for (ActionModeAnimationListener a : this.f3224B) {
                a.m4273a(z);
            }
        }
    }

    public void m4931a(boolean z, float f) {
        if (this.f3224B != null) {
            for (ActionModeAnimationListener a : this.f3224B) {
                a.m4274a(z, f);
            }
        }
    }

    public void m4935c(boolean z) {
        if (this.f3224B != null) {
            for (ActionModeAnimationListener b : this.f3224B) {
                b.m4275b(z);
            }
        }
    }

    public void setStatusBarPaddingTop(int i) {
        this.f3240l = i;
    }

    private boolean m4917i() {
        return (this.f3231c == null || this.f3232d == null) ? false : true;
    }
}
