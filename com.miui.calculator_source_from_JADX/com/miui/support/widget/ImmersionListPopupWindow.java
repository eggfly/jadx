package com.miui.support.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.miui.support.app.IActivity;
import com.miui.support.graphics.BitmapFactory;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_View_View_class;
import com.miui.support.internal.variable.Android_Widget_PopupWindow_class;
import com.miui.support.internal.variable.Android_Widget_PopupWindow_class.Factory;
import com.miui.support.util.AttributeResolver;
import com.miui.support.view.inputmethod.InputMethodHelper;

public class ImmersionListPopupWindow extends PopupWindow {
    private Context f2815a;
    private FrameLayout f2816b;
    private View f2817c;
    private ListView f2818d;
    private ListAdapter f2819e;
    private OnItemClickListener f2820f;
    private LayoutAnimationController f2821g;
    private LayoutAnimationController f2822h;
    private AnimationListener f2823i;
    private View f2824j;
    private Runnable f2825k;

    /* renamed from: com.miui.support.widget.ImmersionListPopupWindow.1 */
    class C04861 implements OnClickListener {
        final /* synthetic */ ImmersionListPopupWindow f4178a;

        C04861(ImmersionListPopupWindow immersionListPopupWindow) {
            this.f4178a = immersionListPopupWindow;
        }

        public void onClick(View view) {
            this.f4178a.dismiss();
        }
    }

    /* renamed from: com.miui.support.widget.ImmersionListPopupWindow.2 */
    class C04872 implements OnItemClickListener {
        final /* synthetic */ ImmersionListPopupWindow f4179a;

        C04872(ImmersionListPopupWindow immersionListPopupWindow) {
            this.f4179a = immersionListPopupWindow;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int headerViewsCount = i - this.f4179a.f2818d.getHeaderViewsCount();
            if (headerViewsCount >= 0 && headerViewsCount < this.f4179a.f2819e.getCount()) {
                this.f4179a.f2820f.onItemClick(adapterView, view, headerViewsCount, j);
            }
        }
    }

    /* renamed from: com.miui.support.widget.ImmersionListPopupWindow.3 */
    class C04883 implements Runnable {
        final /* synthetic */ IActivity f4180a;
        final /* synthetic */ int f4181b;
        final /* synthetic */ ImmersionListPopupWindow f4182c;

        C04883(ImmersionListPopupWindow immersionListPopupWindow, IActivity iActivity, int i) {
            this.f4182c = immersionListPopupWindow;
            this.f4180a = iActivity;
            this.f4181b = i;
        }

        public void run() {
            this.f4180a.m2623c(this.f4181b);
        }
    }

    /* renamed from: com.miui.support.widget.ImmersionListPopupWindow.4 */
    class C04894 implements OnClickListener {
        final /* synthetic */ ImmersionListPopupWindow f4183a;

        C04894(ImmersionListPopupWindow immersionListPopupWindow) {
            this.f4183a = immersionListPopupWindow;
        }

        public void onClick(View view) {
            this.f4183a.m4571a(true);
        }
    }

    private class AnimationListener implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ ImmersionListPopupWindow f4184a;
        private boolean f4185b;
        private Animator f4186c;

        private AnimationListener(ImmersionListPopupWindow immersionListPopupWindow) {
            this.f4184a = immersionListPopupWindow;
        }

        public void m5874a(boolean z) {
            this.f4185b = z;
        }

        public void onAnimationStart(Animation animation) {
            this.f4186c = this.f4184a.m4565a(this.f4185b ? this.f4184a.f2821g : this.f4184a.f2822h, this.f4185b);
            if (this.f4186c != null) {
                this.f4186c.start();
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f4186c != null) {
                this.f4186c.end();
                this.f4186c = null;
            }
            this.f4184a.f2818d.setLayoutAnimation(null);
            if (!this.f4185b) {
                this.f4184a.m4557c();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    private class ClipDrawable extends StateListDrawable {
        final /* synthetic */ ImmersionListPopupWindow f4187a;
        private float f4188b;
        private Drawable f4189c;

        public ClipDrawable(ImmersionListPopupWindow immersionListPopupWindow, Drawable drawable) {
            this.f4187a = immersionListPopupWindow;
            this.f4189c = AttributeResolver.m5320b(immersionListPopupWindow.f2815a, C0264R.attr.immersionWindowFooterBackground);
            if (DeviceHelper.f2560l) {
                this.f4189c = immersionListPopupWindow.f2815a.getResources().getDrawable(C0264R.drawable.immersion_window_footer_background_oled_light);
            }
            if (drawable == null) {
                drawable = new ColorDrawable(immersionListPopupWindow.f2815a.getResources().getColor(17170445));
            }
            addState(new int[0], drawable);
        }

        public void setRangeRatio(float f) {
            this.f4188b = f;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            canvas.save();
            int bottom = (int) (((float) (this.f4187a.f2817c.getBottom() + this.f4187a.f2816b.getTop())) * this.f4188b);
            canvas.clipRect(this.f4187a.f2817c.getLeft(), 0, this.f4187a.f2817c.getRight(), bottom);
            super.draw(canvas);
            canvas.restore();
            Rect bounds = getBounds();
            this.f4189c.setBounds(bounds.left, bottom, bounds.right, bounds.bottom);
            this.f4189c.setAlpha((int) (this.f4188b * 255.0f));
            this.f4189c.draw(canvas);
        }

        public int getOpacity() {
            return -3;
        }
    }

    public ImmersionListPopupWindow(Context context) {
        super(context);
        this.f2815a = context;
        this.f2823i = new AnimationListener();
        setFocusable(true);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setWidth(displayMetrics.widthPixels);
        setHeight(displayMetrics.heightPixels);
        this.f2816b = new FrameLayout(context);
        this.f2816b.setOnClickListener(new C04861(this));
        super.setContentView(this.f2816b);
        Android_Widget_PopupWindow_class android_Widget_PopupWindow_class = Factory.getInstance().get();
        android_Widget_PopupWindow_class.setLayoutInScreenEnabled(this, true);
        android_Widget_PopupWindow_class.setLayoutInsetDecor(this, true);
    }

    public void m4570a(ListAdapter listAdapter) {
        this.f2819e = listAdapter;
    }

    public void m4569a(OnItemClickListener onItemClickListener) {
        this.f2820f = onItemClickListener;
    }

    public void setContentView(View view) {
        this.f2817c = view;
    }

    public View getContentView() {
        return this.f2817c;
    }

    public void m4568a(View view, ViewGroup viewGroup) {
        if (view == null) {
            Log.e("ImmersionListPopupWindow", "show: anchor is null");
            return;
        }
        if (this.f2817c == null) {
            this.f2817c = new ListView(this.f2815a);
            this.f2817c.setId(16908298);
            this.f2817c.setPadding(0, 0, 0, this.f2815a.getResources().getDimensionPixelSize(C0264R.dimen.immersion_list_padding_bottom));
        }
        if (!(this.f2816b.getChildCount() == 1 && this.f2816b.getChildAt(0) == this.f2817c)) {
            this.f2816b.removeAllViews();
            this.f2816b.addView(this.f2817c);
            LayoutParams layoutParams = this.f2817c.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
        }
        this.f2818d = (ListView) this.f2817c.findViewById(16908298);
        if (this.f2818d == null) {
            Log.e("ImmersionListPopupWindow", "list not found");
            return;
        }
        this.f2818d.setOnItemClickListener(new C04872(this));
        if (DeviceHelper.f2553e) {
            if (this.f2821g == null) {
                this.f2821g = m4567a();
            }
            this.f2818d.setLayoutAnimation(this.f2821g);
            this.f2818d.setLayoutAnimationListener(this.f2823i);
            this.f2823i.m5874a(true);
        }
        if (this.f2824j == null) {
            m4574c(view, viewGroup);
        }
        this.f2818d.setAdapter(this.f2819e);
        Drawable clipDrawable = new ClipDrawable(this, m4566a(this.f2815a, view));
        clipDrawable.setRangeRatio(DeviceHelper.f2553e ? 0.0f : 1.0f);
        setBackgroundDrawable(clipDrawable);
        InputMethodHelper.m5661a().m5663b().hideSoftInputFromWindow(view.getWindowToken(), 0);
        m4553a(view);
        showAtLocation(view, 0, 0, 0);
    }

    private void m4553a(View view) {
        if (!isShowing()) {
            Context context = view.getRootView().getContext();
            if (context instanceof IActivity) {
                IActivity iActivity = (IActivity) context;
                int f = iActivity.m2624f();
                iActivity.m2623c(AttributeResolver.m5317a(context, C0264R.attr.immersionStatusBarStyle, 0));
                this.f2825k = new C04883(this, iActivity, f);
                return;
            }
            Log.w("ImmersionListPopupWindow", "Fail to setup translucent status for unknown context: " + context.getClass().getName());
            this.f2825k = null;
        }
    }

    public void m4573b(View view, ViewGroup viewGroup) {
        if (DeviceHelper.f2553e) {
            this.f2818d.setLayoutAnimation(this.f2821g);
            this.f2823i.m5874a(true);
        } else {
            m4552a(1.0f);
        }
        showAtLocation(view, 0, 0, 0);
    }

    protected void m4574c(View view, ViewGroup viewGroup) {
        this.f2824j = LayoutInflater.from(this.f2815a).inflate(C0264R.layout.list_immersion_header, this.f2818d, false);
        this.f2818d.addHeaderView(this.f2824j);
        View findViewById = this.f2824j.findViewById(C0264R.id.close);
        if (findViewById != null) {
            findViewById.setOnClickListener(new C04894(this));
            if (viewGroup == null) {
                m4555b(findViewById);
            } else {
                m4559d(view, viewGroup);
            }
        }
    }

    private void m4555b(View view) {
        int e = AttributeResolver.m5324e(this.f2815a, 16843499);
        this.f2824j.getLayoutParams().height = e;
        view.measure(0, 0);
        this.f2824j.setPaddingRelative(0, 0, this.f2824j.getPaddingEnd(), (e - view.getMeasuredHeight()) / 2);
    }

    private void m4559d(View view, ViewGroup viewGroup) {
        this.f2824j.getLayoutParams().height = viewGroup.getHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        viewGroup.getLocationOnScreen(iArr2);
        this.f2824j.setPaddingRelative(0, 0, (iArr2[0] + viewGroup.getWidth()) - (iArr[0] + view.getWidth()), (iArr2[1] + viewGroup.getHeight()) - (iArr[1] + view.getHeight()));
    }

    protected LayoutAnimationController m4567a() {
        return AnimationUtils.loadLayoutAnimation(this.f2815a, C0264R.anim.immersion_layout_fade_in);
    }

    protected LayoutAnimationController m4572b() {
        return AnimationUtils.loadLayoutAnimation(this.f2815a, C0264R.anim.immersion_layout_fade_out);
    }

    protected Animator m4565a(LayoutAnimationController layoutAnimationController, boolean z) {
        Animator ofFloat;
        long duration;
        long j = 0;
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(getBackground(), "rangeRatio", new float[]{0.0f, 1.0f});
            ofFloat.setInterpolator(new DecelerateInterpolator());
            duration = layoutAnimationController.getAnimation().getDuration();
        } else {
            ofFloat = ObjectAnimator.ofFloat(getBackground(), "rangeRatio", new float[]{1.0f, 0.0f});
            ofFloat.setInterpolator(new AccelerateInterpolator());
            long duration2 = (long) (((float) layoutAnimationController.getAnimation().getDuration()) * (1.0f + (layoutAnimationController.getDelay() * ((float) (this.f2818d.getAdapter().getCount() - 1)))));
            duration = layoutAnimationController.getAnimation().getDuration();
            j = Math.max(duration2 - duration, 0);
        }
        ofFloat.setDuration(duration);
        ofFloat.setStartDelay(j);
        return ofFloat;
    }

    public void dismiss() {
        if (!isShowing() || !DeviceHelper.f2553e) {
            m4557c();
        } else if (this.f2818d.getLayoutAnimation() == null) {
            if (this.f2822h == null) {
                this.f2822h = m4572b();
            }
            if (this.f2822h != null) {
                this.f2818d.setLayoutAnimation(this.f2822h);
                this.f2818d.setLayoutAnimationListener(this.f2823i);
                this.f2823i.m5874a(false);
                this.f2818d.startLayoutAnimation();
            }
            if (this.f2825k != null) {
                this.f2825k.run();
                this.f2825k = null;
            }
        }
    }

    public void m4571a(boolean z) {
        if (z) {
            dismiss();
        } else {
            m4557c();
        }
    }

    private void m4557c() {
        if (this.f2825k != null) {
            this.f2825k.run();
            this.f2825k = null;
        }
        if (!DeviceHelper.f2553e) {
            m4552a(0.0f);
        }
        super.dismiss();
    }

    private void m4552a(float f) {
        Drawable background = getBackground();
        if (background instanceof ClipDrawable) {
            ((ClipDrawable) background).setRangeRatio(f);
        }
    }

    protected Drawable m4566a(Context context, View view) {
        if (!DeviceHelper.f2553e && AttributeResolver.m5317a(context, C0264R.attr.themeType, -1) == 0) {
            return new ColorDrawable(context.getResources().getColor(C0264R.color.immersion_window_background_light));
        }
        Drawable b = AttributeResolver.m5320b(context, C0264R.attr.immersionBlurMask);
        View rootView = view.getRootView();
        if (rootView == null) {
            Log.e("ImmersionListPopupWindow", "getBlurBackground: decorView is null");
            return b;
        }
        Bitmap createSnapshot;
        try {
            createSnapshot = Android_View_View_class.Factory.getInstance().get().createSnapshot(rootView, Config.ARGB_8888, 0, true);
        } catch (Throwable e) {
            Log.e("ImmersionListPopupWindow", "getBlurBackground: OOM occurs while createSnapshot", e);
            createSnapshot = null;
        }
        if (createSnapshot == null) {
            Log.e("ImmersionListPopupWindow", "getBlurBackground: snapshot is null");
            return b;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createSnapshot, createSnapshot.getWidth() / 3, createSnapshot.getHeight() / 3, false);
        if (createScaledBitmap != createSnapshot) {
            createSnapshot.recycle();
        } else {
            createScaledBitmap = createSnapshot;
        }
        createSnapshot = BitmapFactory.m3485a(createScaledBitmap, context.getResources().getDimensionPixelSize(C0264R.dimen.screenshot_blur_radius));
        Canvas canvas = new Canvas(createSnapshot);
        b.setBounds(0, 0, createSnapshot.getWidth(), createSnapshot.getHeight());
        b.draw(canvas);
        canvas.setBitmap(null);
        return new BitmapDrawable(context.getResources(), createSnapshot);
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        Factory.getInstance().get().setFitsSystemWindows(this);
    }
}
