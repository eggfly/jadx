package com.miui.support.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.util.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DynamicListView extends ListView {
    private static final TypeEvaluator<Rect> f4120a;
    private int f4121A;
    private OnScrollListener f4122B;
    private ObjectAnimator f4123C;
    private ObjectAnimator f4124D;
    private RearrangeListener f4125E;
    private OnItemRemoveListener f4126F;
    private Map<Long, Integer> f4127G;
    private Paint f4128H;
    private Bitmap f4129I;
    private AnimatorListenerAdapter f4130J;
    private Runnable f4131K;
    private OnScrollListener f4132L;
    private final int f4133b;
    private final int f4134c;
    private float f4135d;
    private long f4136e;
    private int f4137f;
    private int f4138g;
    private int f4139h;
    private boolean f4140i;
    private boolean f4141j;
    private int f4142k;
    private int f4143l;
    private int f4144m;
    private int f4145n;
    private long f4146o;
    private long f4147p;
    private long f4148q;
    private BitmapDrawable f4149r;
    private Rect f4150s;
    private Rect f4151t;
    private Rect f4152u;
    private Rect f4153v;
    private int f4154w;
    private boolean f4155x;
    private int f4156y;
    private Drawable f4157z;

    /* renamed from: com.miui.support.widget.DynamicListView.10 */
    class AnonymousClass10 extends AnimatorListenerAdapter {
        final /* synthetic */ View f4091a;

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f4091a.setLayerType(2, null);
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f4091a.setLayerType(0, null);
        }

        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f4091a.setLayerType(0, null);
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.11 */
    class AnonymousClass11 extends AnimatorListenerAdapter {
        final /* synthetic */ List f4092a;
        final /* synthetic */ List f4093b;
        final /* synthetic */ DynamicListView f4094c;

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f4094c.m5825a(this.f4092a, this.f4093b);
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.12 */
    class AnonymousClass12 implements OnPreDrawListener {
        final /* synthetic */ BaseAdapter f4098a;
        final /* synthetic */ List f4099b;
        final /* synthetic */ DynamicListView f4100c;

        /* renamed from: com.miui.support.widget.DynamicListView.12.1 */
        class C04711 extends AnimatorListenerAdapter {
            final /* synthetic */ View f4095a;
            final /* synthetic */ AnonymousClass12 f4096b;

            C04711(AnonymousClass12 anonymousClass12, View view) {
                this.f4096b = anonymousClass12;
                this.f4095a = view;
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                this.f4095a.setLayerType(2, null);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.f4095a.setLayerType(0, null);
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.f4095a.setLayerType(0, null);
            }
        }

        /* renamed from: com.miui.support.widget.DynamicListView.12.2 */
        class C04722 extends AnimatorListenerAdapter {
            final /* synthetic */ AnonymousClass12 f4097a;

            C04722(AnonymousClass12 anonymousClass12) {
                this.f4097a = anonymousClass12;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                this.f4097a.f4100c.setEnabled(true);
            }
        }

        AnonymousClass12(DynamicListView dynamicListView, BaseAdapter baseAdapter, List list) {
            this.f4100c = dynamicListView;
            this.f4098a = baseAdapter;
            this.f4099b = list;
        }

        public boolean onPreDraw() {
            this.f4100c.getViewTreeObserver().removeOnPreDrawListener(this);
            int firstVisiblePosition = this.f4100c.getFirstVisiblePosition();
            int childCount = this.f4100c.getChildCount();
            Collection arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f4100c.getChildAt(i);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, View.TRANSLATION_Y, new float[]{0.0f});
                ofFloat.addListener(new C04711(this, childAt));
                arrayList.add(ofFloat);
                Integer num = (Integer) this.f4100c.f4127G.get(Long.valueOf(this.f4098a.getItemId(firstVisiblePosition + i)));
                int top = childAt.getTop();
                if (num == null) {
                    childAt.setTranslationY((float) (Integer.valueOf(((childAt.getHeight() + this.f4100c.getDividerHeight()) * this.f4099b.size()) + top).intValue() - top));
                } else if (num.intValue() != top) {
                    childAt.setTranslationY((float) (num.intValue() - top));
                }
            }
            this.f4100c.f4127G.clear();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.addListener(new C04722(this));
            animatorSet.setDuration(this.f4100c.f4136e);
            animatorSet.start();
            return true;
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.1 */
    final class C04731 implements TypeEvaluator<Rect> {
        private Rect f4101a;

        C04731() {
            this.f4101a = new Rect();
        }

        public /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            return m5808a(f, (Rect) obj, (Rect) obj2);
        }

        public Rect m5808a(float f, Rect rect, Rect rect2) {
            this.f4101a.set(m5807a(rect.left, rect2.left, f), m5807a(rect.top, rect2.top, f), m5807a(rect.right, rect2.right, f), m5807a(rect.bottom, rect2.bottom, f));
            return this.f4101a;
        }

        public int m5807a(int i, int i2, float f) {
            return (int) (((float) i) + (((float) (i2 - i)) * f));
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.2 */
    class C04742 extends AnimatorListenerAdapter {
        final /* synthetic */ DynamicListView f4102a;
        private boolean f4103b;

        C04742(DynamicListView dynamicListView) {
            this.f4102a = dynamicListView;
        }

        public void onAnimationStart(Animator animator) {
            this.f4102a.setEnabled(false);
            this.f4103b = false;
        }

        public void onAnimationEnd(Animator animator) {
            View a = this.f4102a.m5849a(this.f4102a.f4147p);
            if (a != null) {
                a.setVisibility(0);
            }
            this.f4102a.f4146o = -1;
            this.f4102a.f4147p = -1;
            this.f4102a.f4148q = -1;
            this.f4102a.f4149r = null;
            this.f4102a.setEnabled(true);
            this.f4102a.invalidate();
            this.f4102a.f4124D = null;
            if (!this.f4103b && this.f4102a.f4125E != null) {
                this.f4102a.f4125E.m5813a();
            }
        }

        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f4102a.f4124D = null;
            this.f4103b = true;
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.3 */
    class C04753 implements Runnable {
        final /* synthetic */ DynamicListView f4104a;

        C04753(DynamicListView dynamicListView) {
            this.f4104a = dynamicListView;
        }

        public void run() {
            if (this.f4104a.f4141j) {
                this.f4104a.smoothScrollBy(this.f4104a.f4142k, 10);
                this.f4104a.removeCallbacks(this);
                this.f4104a.postDelayed(this, 5);
            }
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.4 */
    class C04764 implements OnScrollListener {
        final /* synthetic */ DynamicListView f4105a;
        private int f4106b;
        private int f4107c;
        private int f4108d;
        private int f4109e;
        private int f4110f;

        C04764(DynamicListView dynamicListView) {
            this.f4105a = dynamicListView;
            this.f4106b = -1;
            this.f4107c = -1;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.f4105a.f4122B != null) {
                this.f4105a.f4122B.onScroll(absListView, i, i2, i3);
            }
            this.f4108d = i;
            this.f4109e = i2;
            this.f4106b = this.f4106b == -1 ? this.f4108d : this.f4106b;
            this.f4107c = this.f4107c == -1 ? this.f4109e : this.f4107c;
            m5810a();
            m5811b();
            this.f4106b = this.f4108d;
            this.f4107c = this.f4109e;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (this.f4105a.f4122B != null) {
                this.f4105a.f4122B.onScrollStateChanged(absListView, i);
            }
            this.f4110f = i;
            this.f4105a.f4156y = i;
            m5809c();
        }

        private void m5809c() {
            if (this.f4109e > 0 && this.f4110f == 0) {
                if (this.f4105a.f4140i && this.f4105a.f4141j) {
                    this.f4105a.m5836d();
                } else if (this.f4105a.f4155x) {
                    this.f4105a.m5830b();
                }
            }
        }

        public void m5810a() {
            if (this.f4108d != this.f4106b && this.f4105a.f4140i && this.f4105a.f4147p != -1) {
                this.f4105a.m5833c(this.f4105a.f4147p);
                this.f4105a.m5822a();
            }
        }

        public void m5811b() {
            if (this.f4108d + this.f4109e != this.f4106b + this.f4107c && this.f4105a.f4140i && this.f4105a.f4147p != -1) {
                this.f4105a.m5833c(this.f4105a.f4147p);
                this.f4105a.m5822a();
            }
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.5 */
    class C04775 implements AnimatorUpdateListener {
        final /* synthetic */ DynamicListView f4111a;

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f4111a.f4157z.setAlpha((int) (valueAnimator.getAnimatedFraction() * 255.0f));
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.6 */
    class C04786 extends AnimatorListenerAdapter {
        final /* synthetic */ DynamicListView f4112a;

        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f4112a.f4123C = null;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f4112a.f4123C = null;
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.7 */
    class C04797 implements OnPreDrawListener {
        final /* synthetic */ ViewTreeObserver f4113a;
        final /* synthetic */ long f4114b;
        final /* synthetic */ int f4115c;
        final /* synthetic */ int f4116d;
        final /* synthetic */ DynamicListView f4117e;

        C04797(DynamicListView dynamicListView, ViewTreeObserver viewTreeObserver, long j, int i, int i2) {
            this.f4117e = dynamicListView;
            this.f4113a = viewTreeObserver;
            this.f4114b = j;
            this.f4115c = i;
            this.f4116d = i2;
        }

        public boolean onPreDraw() {
            this.f4113a.removeOnPreDrawListener(this);
            View a = this.f4117e.m5849a(this.f4114b);
            this.f4117e.f4139h = this.f4117e.f4139h + this.f4115c;
            a.setTranslationY((float) (this.f4116d - a.getTop()));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a, View.TRANSLATION_Y, new float[]{0.0f});
            ofFloat.setDuration(this.f4117e.f4136e);
            ofFloat.start();
            return true;
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.8 */
    class C04808 implements AnimatorUpdateListener {
        final /* synthetic */ DynamicListView f4118a;

        C04808(DynamicListView dynamicListView) {
            this.f4118a = dynamicListView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f4118a.f4157z.setAlpha((int) ((1.0f - valueAnimator.getAnimatedFraction()) * 255.0f));
            this.f4118a.invalidate();
        }
    }

    /* renamed from: com.miui.support.widget.DynamicListView.9 */
    class C04819 extends AnimatorListenerAdapter {
        final /* synthetic */ DynamicListView f4119a;

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f4119a.f4129I = null;
            this.f4119a.f4128H.setAlpha(255);
        }
    }

    public interface OnItemRemoveListener {
        void m5812a(List<Long> list);
    }

    public interface RearrangeListener {
        void m5813a();

        void m5814a(int i, int i2);
    }

    static {
        f4120a = new C04731();
    }

    public DynamicListView(Context context) {
        super(context);
        this.f4133b = -1;
        this.f4134c = -1;
        this.f4135d = 0.0f;
        this.f4136e = 200;
        this.f4137f = -1;
        this.f4138g = -1;
        this.f4139h = 0;
        this.f4140i = false;
        this.f4141j = false;
        this.f4142k = 0;
        this.f4145n = 0;
        this.f4146o = -1;
        this.f4147p = -1;
        this.f4148q = -1;
        this.f4152u = new Rect();
        this.f4153v = new Rect();
        this.f4154w = -1;
        this.f4155x = false;
        this.f4156y = 0;
        this.f4127G = new ArrayMap();
        this.f4128H = new Paint();
        this.f4130J = new C04742(this);
        this.f4131K = new C04753(this);
        this.f4132L = new C04764(this);
        m5823a(context);
    }

    public DynamicListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4133b = -1;
        this.f4134c = -1;
        this.f4135d = 0.0f;
        this.f4136e = 200;
        this.f4137f = -1;
        this.f4138g = -1;
        this.f4139h = 0;
        this.f4140i = false;
        this.f4141j = false;
        this.f4142k = 0;
        this.f4145n = 0;
        this.f4146o = -1;
        this.f4147p = -1;
        this.f4148q = -1;
        this.f4152u = new Rect();
        this.f4153v = new Rect();
        this.f4154w = -1;
        this.f4155x = false;
        this.f4156y = 0;
        this.f4127G = new ArrayMap();
        this.f4128H = new Paint();
        this.f4130J = new C04742(this);
        this.f4131K = new C04753(this);
        this.f4132L = new C04764(this);
        m5823a(context);
    }

    public DynamicListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4133b = -1;
        this.f4134c = -1;
        this.f4135d = 0.0f;
        this.f4136e = 200;
        this.f4137f = -1;
        this.f4138g = -1;
        this.f4139h = 0;
        this.f4140i = false;
        this.f4141j = false;
        this.f4142k = 0;
        this.f4145n = 0;
        this.f4146o = -1;
        this.f4147p = -1;
        this.f4148q = -1;
        this.f4152u = new Rect();
        this.f4153v = new Rect();
        this.f4154w = -1;
        this.f4155x = false;
        this.f4156y = 0;
        this.f4127G = new ArrayMap();
        this.f4128H = new Paint();
        this.f4130J = new C04742(this);
        this.f4131K = new C04753(this);
        this.f4132L = new C04764(this);
        m5823a(context);
    }

    private void m5823a(Context context) {
        super.setOnScrollListener(this.f4132L);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.f4144m = (int) (5.0f * displayMetrics.density);
        this.f4143l = (int) (1.5f * ((float) this.f4144m));
        this.f4145n = (int) (displayMetrics.density * 50.0f);
        this.f4157z = resources.getDrawable(C0264R.drawable.dynamic_listview_dragging_item_shadow);
        this.f4121A = this.f4157z.getIntrinsicHeight();
    }

    public void setDuration(long j) {
        this.f4136e = j;
    }

    public void setScaleFactor(float f) {
        this.f4135d = f;
    }

    public Rect getHoverCellBounds() {
        return this.f4149r.getBounds();
    }

    public void setHoverCellBounds(Rect rect) {
        this.f4153v.set(this.f4152u);
        this.f4149r.setBounds(rect);
        this.f4152u.set(rect.left, rect.top - (this.f4121A / 2), rect.right, rect.bottom + (this.f4121A / 2));
        this.f4157z.setBounds(this.f4152u);
        this.f4153v.union(this.f4152u);
        invalidate(this.f4153v);
    }

    private void m5833c(long j) {
        int b = m5851b(j);
        BaseAdapter baseAdapter = (BaseAdapter) getAdapter();
        this.f4146o = baseAdapter.getItemId(b - 1);
        this.f4148q = baseAdapter.getItemId(b + 1);
    }

    public View m5849a(long j) {
        int firstVisiblePosition = getFirstVisiblePosition();
        BaseAdapter baseAdapter = (BaseAdapter) getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (baseAdapter.getItemId(firstVisiblePosition + i) == j) {
                return childAt;
            }
        }
        return null;
    }

    public int m5851b(long j) {
        View a = m5849a(j);
        if (a == null) {
            return -1;
        }
        return getPositionForView(a);
    }

    private View m5821a(int i) {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (i < firstVisiblePosition || i > getLastVisiblePosition()) {
            return null;
        }
        return getChildAt(i - firstVisiblePosition);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f4149r != null) {
            this.f4157z.draw(canvas);
            this.f4149r.draw(canvas);
        }
        if (this.f4129I != null) {
            canvas.drawBitmap(this.f4129I, 0.0f, 0.0f, this.f4128H);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f4138g = (int) motionEvent.getY();
                this.f4154w = motionEvent.getPointerId(0);
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                m5830b();
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (this.f4154w != -1) {
                    this.f4137f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f4154w));
                    int i = this.f4137f - this.f4138g;
                    if (this.f4140i) {
                        if (this.f4123C != null && this.f4123C.isRunning()) {
                            this.f4123C.end();
                        }
                        i = (i + this.f4151t.top) + this.f4139h;
                        if (i < 0) {
                            i = 0;
                        } else if (i > getHeight() - this.f4150s.height()) {
                            i = getHeight() - this.f4150s.height();
                        }
                        this.f4150s.offsetTo(this.f4151t.left, i);
                        setHoverCellBounds(this.f4150s);
                        m5822a();
                        this.f4141j = false;
                        m5836d();
                        return false;
                    }
                }
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m5832c();
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                if (motionEvent.getPointerId((motionEvent.getAction() & 65280) >> 8) == this.f4154w) {
                    m5830b();
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void m5822a() {
        int i = 1;
        int i2 = this.f4137f - this.f4138g;
        int i3 = (this.f4151t.top + this.f4139h) + i2;
        int height = this.f4150s.height() / 2;
        View a = m5849a(this.f4148q);
        View a2 = m5849a(this.f4147p);
        View a3 = m5849a(this.f4146o);
        int i4 = (a == null || i3 + height <= a.getTop()) ? 0 : 1;
        if (a3 == null || i3 - height >= a3.getTop()) {
            i = 0;
        }
        if (i4 != 0 || r2 != 0) {
            long j = i4 != 0 ? this.f4148q : this.f4146o;
            if (i4 != 0) {
                a3 = a;
            }
            int positionForView = getPositionForView(a2);
            if (this.f4125E != null) {
                this.f4125E.m5814a(positionForView, getPositionForView(a3));
            }
            ((BaseAdapter) getAdapter()).notifyDataSetChanged();
            this.f4138g = this.f4137f;
            i4 = a3.getTop();
            a2.setVisibility(0);
            a3.setVisibility(4);
            m5833c(this.f4147p);
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            viewTreeObserver.addOnPreDrawListener(new C04797(this, viewTreeObserver, j, i2, i4));
        }
    }

    private void m5830b() {
        View a = m5849a(this.f4147p);
        if (this.f4140i || this.f4155x) {
            this.f4140i = false;
            this.f4155x = false;
            this.f4141j = false;
            this.f4154w = -1;
            if (this.f4156y != 0) {
                this.f4155x = true;
                return;
            }
            this.f4150s.offsetTo(this.f4151t.left, a.getTop());
            this.f4150s.set(this.f4151t.left, a.getTop(), this.f4151t.left + a.getWidth(), a.getHeight() + a.getTop());
            this.f4124D = ObjectAnimator.ofObject(this, "HoverCellBounds", f4120a, new Object[]{this.f4150s});
            this.f4124D.setDuration(DeviceHelper.f2553e ? this.f4136e : 0);
            this.f4124D.addUpdateListener(new C04808(this));
            this.f4124D.addListener(this.f4130J);
            this.f4124D.start();
            return;
        }
        m5832c();
    }

    private void m5832c() {
        View a = m5849a(this.f4147p);
        if (this.f4140i) {
            this.f4146o = -1;
            this.f4147p = -1;
            this.f4148q = -1;
            a.setVisibility(0);
            this.f4149r = null;
            invalidate();
        }
        this.f4140i = false;
        this.f4141j = false;
        this.f4154w = -1;
    }

    private void m5836d() {
        this.f4141j = m5850a(this.f4150s);
    }

    public boolean m5850a(Rect rect) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i = rect.top;
        int height2 = rect.height();
        if (i <= this.f4145n * 2 && computeVerticalScrollOffset > 0) {
            this.f4142k = -this.f4144m;
            if (i <= this.f4145n) {
                this.f4142k = -this.f4143l;
            }
            postDelayed(this.f4131K, 10);
            return true;
        } else if (i + height2 < height - (this.f4145n * 2) || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            removeCallbacks(this.f4131K);
            return false;
        } else {
            this.f4142k = this.f4144m;
            if (i + height2 >= height - this.f4145n) {
                this.f4142k = this.f4143l;
            }
            postDelayed(this.f4131K, 10);
            return true;
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f4122B = onScrollListener;
    }

    public int getLastStateAlpha() {
        return this.f4128H.getAlpha();
    }

    public void setLastStateAlpha(int i) {
        this.f4128H.setAlpha(i);
        invalidate();
    }

    private void m5825a(List<Long> list, List<Integer> list2) {
        BaseAdapter baseAdapter = (BaseAdapter) getAdapter();
        List arrayList = new ArrayList(1);
        for (Integer intValue : list2) {
            View a = m5821a(intValue.intValue());
            if (a != null) {
                arrayList.add(a);
            }
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        this.f4127G.clear();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            childAt.setTranslationX(0.0f);
            if (!arrayList.contains(childAt)) {
                this.f4127G.put(Long.valueOf(baseAdapter.getItemId(firstVisiblePosition + i)), Integer.valueOf(childAt.getTop()));
            }
        }
        this.f4126F.m5812a(list);
        baseAdapter.notifyDataSetChanged();
        getViewTreeObserver().addOnPreDrawListener(new AnonymousClass12(this, baseAdapter, list2));
    }

    public void setOnItemRemoveListener(OnItemRemoveListener onItemRemoveListener) {
        this.f4126F = onItemRemoveListener;
    }

    public void setRearrangeListener(RearrangeListener rearrangeListener) {
        this.f4125E = rearrangeListener;
    }
}
