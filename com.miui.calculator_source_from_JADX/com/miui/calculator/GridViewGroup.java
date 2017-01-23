package com.miui.calculator;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Adapter;
import android.widget.Scroller;
import com.miui.calculator.cal.CalculatorActivity;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.Locale;

public class GridViewGroup extends ViewGroup {
    private static String f1320a;
    private boolean f1321A;
    private boolean f1322B;
    private int f1323C;
    private Scroller f1324D;
    private float f1325E;
    private VelocityTracker f1326F;
    private int f1327G;
    private int f1328H;
    private Paint f1329I;
    private OnTouchListener f1330J;
    private OnDragListener f1331K;
    private int f1332b;
    private int f1333c;
    private int f1334d;
    private int f1335e;
    private int f1336f;
    private int f1337g;
    private int f1338h;
    private int f1339i;
    private int f1340j;
    private int f1341k;
    private int f1342l;
    private int f1343m;
    private Adapter f1344n;
    private OnClickListener f1345o;
    private OnLongClickListener f1346p;
    private OnPageChangeListener f1347q;
    private OnItemMovedListener f1348r;
    private OnItemExchangedListener f1349s;
    private int f1350t;
    private long f1351u;
    private int[] f1352v;
    private int f1353w;
    private int f1354x;
    private int f1355y;
    private int f1356z;

    public interface OnItemExchangedListener {
        void m2561a(int i, int i2);
    }

    /* renamed from: com.miui.calculator.GridViewGroup.1 */
    class C01351 implements OnTouchListener {
        final /* synthetic */ GridViewGroup f1313a;

        C01351(GridViewGroup gridViewGroup) {
            this.f1313a = gridViewGroup;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    this.f1313a.f1340j = (int) motionEvent.getX();
                    this.f1313a.f1341k = (int) motionEvent.getY();
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.miui.calculator.GridViewGroup.2 */
    class C01362 implements OnLongClickListener {
        final /* synthetic */ GridViewGroup f1314a;

        C01362(GridViewGroup gridViewGroup) {
            this.f1314a = gridViewGroup;
        }

        public boolean onLongClick(View view) {
            view.startDrag(ClipData.newPlainText("", ""), new DragShadowBuilder(this.f1314a, view, this.f1314a.f1340j, this.f1314a.f1341k), view, 0);
            view.setAlpha(0.0f);
            return false;
        }
    }

    /* renamed from: com.miui.calculator.GridViewGroup.3 */
    class C01373 implements OnDragListener {
        final /* synthetic */ GridViewGroup f1315a;

        C01373(GridViewGroup gridViewGroup) {
            this.f1315a = gridViewGroup;
        }

        public boolean onDrag(View view, DragEvent dragEvent) {
            switch (dragEvent.getAction()) {
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    int b = this.f1315a.m2605f(this.f1315a.m2608a((View) dragEvent.getLocalState()), (int) dragEvent.getX());
                    if (this.f1315a.f1353w != -1) {
                        if (b == this.f1315a.f1353w) {
                            if (this.f1315a.f1350t == this.f1315a.m2608a(view)) {
                                if (System.currentTimeMillis() - this.f1315a.f1351u >= 800) {
                                    if (b == 0) {
                                        this.f1315a.setCurrentPage(this.f1315a.f1323C - 1);
                                    } else {
                                        this.f1315a.setCurrentPage(this.f1315a.f1323C + 1);
                                    }
                                    this.f1315a.f1353w = -1;
                                    break;
                                }
                            }
                            this.f1315a.f1353w = -1;
                            break;
                        }
                        this.f1315a.f1353w = -1;
                        break;
                    } else if (b != this.f1315a.f1353w) {
                        this.f1315a.f1353w = b;
                        this.f1315a.f1351u = System.currentTimeMillis();
                        this.f1315a.f1350t = this.f1315a.m2608a(view);
                        break;
                    }
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    View view2 = (View) dragEvent.getLocalState();
                    int x = (int) dragEvent.getX();
                    int y = (int) dragEvent.getY();
                    int a = this.f1315a.m2608a(view2);
                    this.f1315a.m2608a(view);
                    this.f1315a.m2585a(x, y, view2, a);
                    if (this.f1315a.f1348r != null) {
                        this.f1315a.f1348r.m2577a();
                        break;
                    }
                    break;
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    ((View) dragEvent.getLocalState()).setAlpha(1.0f);
                    break;
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    this.f1315a.m2601d(this.f1315a.m2608a((View) dragEvent.getLocalState()), this.f1315a.m2608a(view));
                    break;
            }
            return true;
        }
    }

    class DragShadowBuilder extends android.view.View.DragShadowBuilder {
        final /* synthetic */ GridViewGroup f1316a;
        private int f1317b;
        private int f1318c;
        private Paint f1319d;

        public DragShadowBuilder(GridViewGroup gridViewGroup, View view, int i, int i2) {
            this.f1316a = gridViewGroup;
            super(view);
            this.f1317b = i;
            this.f1318c = i2;
            this.f1319d = new Paint();
        }

        public void onProvideShadowMetrics(Point point, Point point2) {
            super.onProvideShadowMetrics(point, point2);
            point2.set(this.f1317b, this.f1318c);
        }

        public void onDrawShadow(Canvas canvas) {
            super.onDrawShadow(canvas);
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.right--;
            clipBounds.bottom--;
            this.f1319d.setColor(this.f1316a.getResources().getColor(C0264R.color.grid_item_border));
            this.f1319d.setStyle(Style.STROKE);
            this.f1319d.setStrokeWidth(1.0f);
            canvas.drawRect(clipBounds, this.f1319d);
        }
    }

    public interface OnItemMovedListener {
        void m2577a();
    }

    public interface OnPageChangeListener {
        void m2578a(int i);
    }

    static {
        f1320a = "Calculator:ViewGroup";
    }

    public GridViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1332b = 3;
        this.f1333c = 3;
        this.f1334d = this.f1332b * this.f1333c;
        this.f1351u = 0;
        this.f1353w = -1;
        this.f1321A = true;
        this.f1330J = new C01351(this);
        this.f1331K = new C01373(this);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1322B = m2593b();
        this.f1324D = new Scroller(context);
        this.f1355y = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1356z = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1328H = viewConfiguration.getScaledPagingTouchSlop();
        this.f1346p = new C01362(this);
        m2583a();
    }

    public void m2612a(Activity activity) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        this.f1335e = (int) (0.5f * displayMetrics.density);
        this.f1342l = getPaddingLeft();
        this.f1343m = getPaddingRight();
        this.f1323C = 0;
        m2592b(displayMetrics.widthPixels, (displayMetrics.heightPixels - CalculatorUtils.m2816a(activity)) - CalculatorUtils.m2829h());
    }

    private void m2592b(int i, int i2) {
        this.f1337g = (((i - this.f1342l) - this.f1343m) - ((this.f1332b + 1) * this.f1335e)) / this.f1332b;
        this.f1338h = (i2 - ((this.f1333c + 1) * this.f1335e)) / this.f1333c;
        this.f1339i = this.f1337g / 2;
        this.f1327G = this.f1337g / 2;
        this.f1354x = (((this.f1337g + this.f1335e) * this.f1332b) + this.f1342l) + this.f1343m;
    }

    private void m2583a() {
        this.f1329I = new Paint();
        this.f1329I.setColor(getResources().getColor(C0264R.color.grid_item_border));
        this.f1329I.setStrokeJoin(Join.ROUND);
        this.f1329I.setStrokeCap(Cap.ROUND);
        this.f1329I.setStrokeWidth((float) this.f1335e);
    }

    public void setAdapter(Adapter adapter) {
        removeAllViews();
        this.f1352v = null;
        this.f1344n = adapter;
        if (this.f1344n != null) {
            this.f1352v = new int[this.f1344n.getCount()];
            for (int i = 0; i < this.f1344n.getCount(); i++) {
                View view = this.f1344n.getView(i, null, this);
                view.setOnDragListener(this.f1331K);
                view.setOnLongClickListener(this.f1346p);
                view.setOnTouchListener(this.f1330J);
                if (this.f1345o != null) {
                    view.setOnClickListener(this.f1345o);
                }
                addView(view);
                this.f1352v[i] = i;
            }
        }
        this.f1336f = (int) Math.ceil((double) (((float) getChildCount()) / ((float) this.f1334d)));
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f1347q = onPageChangeListener;
    }

    public void setItemOnClickListener(OnClickListener onClickListener) {
        this.f1345o = onClickListener;
    }

    public void setOnItemMovedListener(OnItemMovedListener onItemMovedListener) {
        this.f1348r = onItemMovedListener;
    }

    public void setOnItemExchangedListener(OnItemExchangedListener onItemExchangedListener) {
        this.f1349s = onItemExchangedListener;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        m2592b(getWidth(), getHeight());
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            Rect b = m2591b(m2608a(childAt));
            childAt.measure(MeasureSpec.makeMeasureSpec(b.width(), 1073741824), MeasureSpec.makeMeasureSpec(b.height(), 1073741824));
            childAt.layout(b.left, b.top, b.right, b.bottom);
        }
    }

    protected void onDraw(Canvas canvas) {
        int width;
        int i;
        int i2 = 0;
        super.onDraw(canvas);
        if (this.f1322B) {
            int width2 = (1 - this.f1336f) * getWidth();
            width = getWidth();
            i = width2;
        } else {
            width = getWidth() * this.f1336f;
            i = 0;
        }
        for (int i3 = 0; i3 <= this.f1332b; i3++) {
            int i4 = ((this.f1338h + this.f1335e) * i3) + 1;
            canvas.drawLine((float) i, (float) i4, (float) width, (float) i4, this.f1329I);
        }
        width = ((this.f1337g + this.f1335e) * 3) + 1;
        while (i2 <= this.f1333c * this.f1336f) {
            i4 = ((this.f1337g + this.f1335e) * i2) + 1;
            int height = getHeight();
            if (this.f1322B) {
                i4 = (width - i4) + 1;
            }
            canvas.drawLine((float) i4, 0.0f, (float) i4, (float) height, this.f1329I);
            i2++;
        }
    }

    private Rect m2591b(int i) {
        return m2596c(((i / this.f1334d) * this.f1332b) + (i % this.f1332b), (i % this.f1334d) / this.f1333c);
    }

    private Rect m2596c(int i, int i2) {
        int i3;
        int i4;
        int i5 = (((this.f1338h + this.f1335e) * i2) + this.f1335e) + 1;
        int i6 = (this.f1338h + i5) - 1;
        if (this.f1322B) {
            i3 = ((3 - i) * (this.f1337g + this.f1335e)) + this.f1343m;
            i4 = (i3 - this.f1337g) + 1;
        } else {
            i4 = ((this.f1342l + ((this.f1337g + this.f1335e) * i)) + this.f1335e) + 1;
            i3 = (this.f1337g + i4) - 1;
        }
        return new Rect(i4, i5, i3, i6);
    }

    private Point m2595c(int i) {
        return new Point(i % this.f1332b, (i % this.f1334d) / this.f1333c);
    }

    public void m2613a(Intent intent, int i, Activity activity) {
        Point c = m2595c(i);
        Rect c2 = m2596c(c.x, c.y);
        int centerX = c.x < 1 ? c2.left : c.x > 1 ? c2.right : c2.centerX();
        int centerY = c.y < 1 ? c2.top : c.y > 1 ? c2.bottom : c2.centerY();
        intent.putExtra(CalculatorActivity.f1460b, centerX);
        intent.putExtra(CalculatorActivity.f1461c, (centerY + CalculatorUtils.m2829h()) + CalculatorUtils.m2816a(activity));
    }

    public int m2608a(View view) {
        for (int i = 0; i < this.f1352v.length; i++) {
            if (getChildAt(this.f1352v[i]) == view) {
                return i;
            }
        }
        return -1;
    }

    public void m2609a(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (m2608a(childAt) == i) {
                childAt.setBackgroundResource(C0264R.drawable.bg_item_selected);
            } else {
                childAt.setBackgroundResource(C0264R.drawable.bg_item_normal);
            }
        }
    }

    private void m2585a(int i, int i2, View view, int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            Rect b = m2591b(i3);
            b.offset(-view.getLeft(), -view.getTop());
            Animation translateAnimation = new TranslateAnimation((float) (b.left - (this.f1340j - i)), (float) b.left, (float) (b.top + (i2 - this.f1341k)), (float) b.top);
            translateAnimation.setDuration(250);
            translateAnimation.setFillEnabled(true);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            view.clearAnimation();
            view.startAnimation(translateAnimation);
        }
    }

    private void m2601d(int i, int i2) {
        if (i != i2 && i < getChildCount() && i >= 0 && i2 >= 0 && i2 < getChildCount()) {
            View childAt = getChildAt(this.f1352v[i]);
            Rect b = m2591b(i2);
            childAt.layout(b.left, b.top, b.right, b.bottom);
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (i >= i2) {
                    int childCount = (getChildCount() - 1) - i3;
                    if (childCount >= i2 && childCount < i) {
                        m2584a(childCount, childCount + 1, getChildAt(this.f1352v[childCount]));
                        m2603e(childCount, childCount + 1);
                    }
                } else if (i3 > i && i3 <= i2) {
                    m2584a(i3, i3 - 1, getChildAt(this.f1352v[i3]));
                    m2603e(i3, i3 - 1);
                }
                i3++;
            }
        }
    }

    private void m2603e(int i, int i2) {
        int i3 = this.f1352v[i];
        this.f1352v[i] = this.f1352v[i2];
        this.f1352v[i2] = i3;
        if (this.f1349s != null) {
            this.f1349s.m2561a(i, i2);
        }
    }

    private void m2584a(int i, int i2, View view) {
        Rect b = m2591b(i);
        Rect b2 = m2591b(i2);
        view.layout(b2.left, b2.top, b2.right, b2.bottom);
        b.offset(-view.getLeft(), -view.getTop());
        b2.offset(-view.getLeft(), -view.getTop());
        Animation translateAnimation = new TranslateAnimation((float) b.left, (float) b2.left, (float) b.top, (float) b2.top);
        translateAnimation.setDuration(250);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        view.clearAnimation();
        view.startAnimation(translateAnimation);
    }

    private int m2605f(int i, int i2) {
        int i3 = this.f1322B ? i % this.f1332b == this.f1332b + -1 ? 1 : 0 : i % this.f1332b == 0 ? 1 : 0;
        int i4 = this.f1322B ? i % this.f1332b == 0 ? 1 : 0 : i % this.f1332b == this.f1332b + -1 ? 1 : 0;
        int i5 = this.f1322B ? i >= this.f1334d ? 1 : 0 : i < (this.f1336f + -1) * this.f1334d ? 1 : 0;
        int i6 = this.f1322B ? i < (this.f1336f + -1) * this.f1334d ? 1 : 0 : i >= this.f1334d ? 1 : 0;
        if (i2 < this.f1339i && r0 != 0 && r5 != 0) {
            Log.d(f1320a, "arrived the edge of left");
            return 0;
        } else if (i2 < this.f1337g - this.f1339i || r3 == 0 || r4 == 0) {
            return -1;
        } else {
            Log.d(f1320a, "arrived the edge of right");
            return 1;
        }
    }

    private boolean m2593b() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        switch (motionEvent.getAction()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f1324D.abortAnimation();
                this.f1325E = motionEvent.getX();
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f1326F == null) {
                    this.f1326F = VelocityTracker.obtain();
                }
                this.f1326F.addMovement(motionEvent);
                velocityTracker = this.f1326F;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f1355y);
                setCurrentPage(m2579a(motionEvent.getX() - this.f1325E, (int) velocityTracker.getXVelocity()));
                this.f1321A = true;
                m2598c();
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (this.f1326F == null) {
                    this.f1326F = VelocityTracker.obtain();
                }
                this.f1326F.addMovement(motionEvent);
                velocityTracker = this.f1326F;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f1355y);
                int xVelocity = (int) velocityTracker.getXVelocity();
                m2611a((-xVelocity) / 100, 0, xVelocity);
                if (Math.abs(motionEvent.getX() - this.f1325E) > ((float) this.f1328H)) {
                    this.f1321A = false;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return !this.f1321A;
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
    }

    private void m2598c() {
        if (this.f1326F != null) {
            this.f1326F.clear();
            this.f1326F.recycle();
            this.f1326F = null;
        }
    }

    private void setCurrentPage(int i) {
        m2610a((this.f1354x * i) - this.f1324D.getFinalX(), 0);
        this.f1323C = i;
        if (this.f1347q != null) {
            this.f1347q.m2578a(i);
        }
    }

    public void m2610a(int i, int i2) {
        this.f1324D.startScroll(this.f1324D.getFinalX(), this.f1324D.getFinalY(), i, i2, 350);
        invalidate();
    }

    public void m2611a(int i, int i2, int i3) {
        if (i3 != 0) {
            int i4 = this.f1322B ? i3 : -i3;
            int scrollX = this.f1322B ? getScrollX() : -getScrollX();
            int scrollX2 = this.f1322B ? (i3 / 100) - getScrollX() : getScrollX() - (i3 / 100);
            if ((scrollX2 <= this.f1354x && i4 > 0) || (scrollX2 >= 0 && i4 < 0)) {
                if (Math.abs(getScrollX()) > getWidth() && i4 > 0) {
                    return;
                }
                if (scrollX <= 0 || i4 >= 0) {
                    this.f1324D.startScroll(this.f1324D.getFinalX(), this.f1324D.getFinalY(), i, i2, i / i3);
                    invalidate();
                }
            }
        }
    }

    public void computeScroll() {
        if (this.f1324D.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f1324D.getCurrX();
            int currY = this.f1324D.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            postInvalidateOnAnimation();
        }
        super.computeScroll();
    }

    private int m2579a(float f, int i) {
        int i2 = this.f1323C;
        Float valueOf = Float.valueOf(((float) (getScrollX() - (this.f1323C * this.f1354x))) / ((float) this.f1354x));
        i2 = (Math.abs(f) <= ((float) this.f1327G) || Math.abs(i) <= this.f1356z) ? this.f1322B ? (int) ((valueOf.floatValue() + ((float) this.f1323C)) - 0.5f) : (int) ((valueOf.floatValue() + ((float) this.f1323C)) + 0.5f) : i > 0 ? this.f1323C - 1 : this.f1323C + 1;
        if (this.f1322B) {
            if (i2 > 0) {
                return 0;
            }
            if (i2 <= (-this.f1336f)) {
                return 1 - this.f1336f;
            }
            return i2;
        } else if (i2 < 0) {
            return 0;
        } else {
            if (i2 >= this.f1336f) {
                return this.f1336f - 1;
            }
            return i2;
        }
    }

    public int getPageCount() {
        return this.f1336f;
    }
}
