package com.aide.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.aide.common.d;
import com.aide.ui.R;
import com.aide.ui.views.editor.OConsole;
import com.aide.ui.views.editor.i;
import com.aide.ui.views.editor.o;
import java.util.Timer;
import java.util.TimerTask;

public class CodeEditTextScrollView extends ScrollView {
    public static boolean j6;
    private boolean DW;
    private DragHandle EQ;
    private float FH;
    private float Hw;
    private a J0;
    private a J8;
    private boolean QX;
    private int VH;
    private DragHandle[] Ws;
    private boolean XL;
    private int Zo;
    private float gn;
    private DragHandle tp;
    private float u7;
    private float v5;
    private DragHandle we;

    private abstract class DragHandle {
        private float bounce;
        private float charCenterX;
        private float charCenterY;
        private int dragDX;
        private int dragDY;
        private boolean dragIsActive;
        private int handleCenterX;
        private int handleCenterY;
        private int handleHeight;
        private int handleWidth;
        private Drawable icon;
        private Drawable iconDown;
        private boolean isDown;
        private boolean isVisible;
        private Timer removeTimer;
        private TimerTask removeTimerTask;
        private long timeout;

        class 1 extends TimerTask {
            final /* synthetic */ DragHandle j6;

            class 1 implements Runnable {
                final /* synthetic */ 1 j6;

                1(1 1) {
                    this.j6 = 1;
                }

                public void run() {
                    this.j6.j6.dragIsActive = false;
                    this.j6.j6.isVisible = false;
                    CodeEditTextScrollView.this.invalidate();
                }
            }

            1(DragHandle dragHandle) {
                this.j6 = dragHandle;
            }

            public void run() {
                CodeEditTextScrollView.this.post(new 1(this));
            }
        }

        protected abstract int getColumn();

        protected abstract int getLine();

        protected abstract void onClick();

        protected abstract void onDraggedTo(int i, int i2);

        public DragHandle(Drawable drawable, Drawable drawable2, float f, float f2, float f3, float f4, long j) {
            this.timeout = j;
            this.removeTimer = new Timer();
            this.icon = drawable;
            this.iconDown = drawable2;
            this.handleHeight = drawable.getIntrinsicHeight();
            this.handleWidth = drawable.getIntrinsicWidth();
            this.handleCenterX = (int) (((float) this.handleWidth) * f);
            this.handleCenterY = (int) (((float) this.handleHeight) * f2);
            this.charCenterY = f4;
            this.charCenterX = f3;
        }

        public void onDestroy() {
            this.removeTimer.cancel();
        }

        public boolean isVisible() {
            return this.isVisible;
        }

        public void show() {
            this.isVisible = true;
            CodeEditTextScrollView.this.invalidate();
            scheduleRemoveCaretHandle();
        }

        public void hide() {
            if (this.isVisible) {
                this.isVisible = false;
                CodeEditTextScrollView.this.invalidate();
                if (this.removeTimerTask != null) {
                    this.removeTimerTask.cancel();
                }
            }
        }

        public boolean isTouchEventInsideHandle(MotionEvent motionEvent) {
            if (!this.isVisible) {
                return false;
            }
            int x = (int) motionEvent.getX(0);
            int y = (int) motionEvent.getY(0);
            OConsole j6 = CodeEditTextScrollView.this.getOEditorView();
            int v5 = j6.v5(getLine());
            return getHandleRect((int) (j6.VH(getColumn(), v5) - ((float) CodeEditTextScrollView.this.getHorizontalScrollView().getScrollX())), (int) (j6.Hw(v5) - ((float) CodeEditTextScrollView.this.getScrollLineY()))).contains(x, y);
        }

        private Rect getHandleRect(int i, int i2) {
            int fontHeight = (int) CodeEditTextScrollView.this.getOEditorView().getFontHeight();
            return new Rect(i - this.handleCenterX, (int) (((float) ((i2 + fontHeight) - this.handleCenterY)) - (this.charCenterY * ((float) fontHeight))), (i - this.handleCenterX) + this.handleWidth, (int) (((float) (((i2 + fontHeight) + this.handleHeight) - this.handleCenterY)) - (((float) fontHeight) * this.charCenterY)));
        }

        private Rect getHandleRectInWindow() {
            OConsole j6 = CodeEditTextScrollView.this.getOEditorView();
            int v5 = j6.v5(getLine());
            return getHandleRect((int) (j6.VH(getColumn(), v5) - ((float) CodeEditTextScrollView.this.getHorizontalScrollView().getScrollX())), (int) (j6.Hw(v5) + ((float) CodeEditTextScrollView.this.getHeaderHeight())));
        }

        public void setBounce(float f) {
            this.bounce = f;
            Rect handleRectInWindow = getHandleRectInWindow();
            handleRectInWindow.right += 100;
            CodeEditTextScrollView.this.invalidate(handleRectInWindow);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (this.isVisible && motionEvent.getActionMasked() == 0 && motionEvent.getPointerCount() == 1) {
                int x = (int) motionEvent.getX(0);
                int y = (int) motionEvent.getY(0);
                OConsole j6 = CodeEditTextScrollView.this.getOEditorView();
                int v5 = j6.v5(getLine());
                int Hw = (int) (j6.Hw(v5) - ((float) CodeEditTextScrollView.this.getScrollLineY()));
                int VH = (int) (j6.VH(getColumn(), v5) - ((float) CodeEditTextScrollView.this.getHorizontalScrollView().getScrollX()));
                if (getHandleRect(VH, Hw).contains(x, y)) {
                    this.dragIsActive = true;
                    this.isDown = true;
                    if (this.removeTimerTask != null) {
                        this.removeTimerTask.cancel();
                    }
                    this.dragDX = x - (VH + ((int) CodeEditTextScrollView.this.getOEditorView().getSpaceCharWidth()));
                    this.dragDY = y - ((((int) CodeEditTextScrollView.this.getOEditorView().getFontHeight()) / 2) + Hw);
                    CodeEditTextScrollView.this.invalidate();
                }
            }
            if (this.dragIsActive) {
                return true;
            }
            return false;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!this.dragIsActive) {
                return false;
            }
            if (motionEvent.getAction() == 1) {
                this.dragIsActive = false;
                scheduleRemoveCaretHandle();
                CodeEditTextScrollView.this.invalidate();
                if (this.isDown) {
                    onClick();
                    this.isDown = false;
                }
            }
            if (motionEvent.getAction() != 2) {
                return true;
            }
            float x = motionEvent.getX(0);
            float scrollX = ((float) CodeEditTextScrollView.this.getHorizontalScrollView().getScrollX()) + (x - ((float) this.dragDX));
            float FH = ((float) CodeEditTextScrollView.this.getScrollLineY()) + (motionEvent.getY(0) - ((float) this.dragDY));
            int FH2 = CodeEditTextScrollView.this.getOEditorView().FH(scrollX, FH);
            int DW = CodeEditTextScrollView.this.getOEditorView().DW(scrollX, FH);
            if (FH2 == getLine() && DW == getColumn()) {
                return true;
            }
            try {
                CodeEditTextScrollView.this.QX = true;
                onDraggedTo(FH2, DW);
                CodeEditTextScrollView.this.invalidate();
                CodeEditTextScrollView.this.j6(FH2, DW, 1, 3, getScrollPaddingBottom(), 3, true);
                return true;
            } finally {
                DW = CodeEditTextScrollView.this;
                DW.QX = false;
            }
        }

        private int getScrollPaddingBottom() {
            int fontHeight = (int) (((float) this.handleHeight) / CodeEditTextScrollView.this.getOEditorView().getFontHeight());
            if (fontHeight > CodeEditTextScrollView.this.DW(true) - 4) {
                fontHeight = CodeEditTextScrollView.this.DW(true) - 4;
            }
            return fontHeight + 2;
        }

        private void scheduleRemoveCaretHandle() {
            if (this.removeTimerTask != null) {
                this.removeTimerTask.cancel();
            }
            this.removeTimerTask = new 1(this);
            this.removeTimer.schedule(this.removeTimerTask, this.timeout);
        }

        public void draw(Canvas canvas) {
            if (this.isVisible) {
                Rect handleRectInWindow = getHandleRectInWindow();
                handleRectInWindow.left = (int) (((float) handleRectInWindow.left) + this.bounce);
                handleRectInWindow.right = (int) (((float) handleRectInWindow.right) + this.bounce);
                if (this.isDown) {
                    this.iconDown.setBounds(handleRectInWindow);
                    this.iconDown.draw(canvas);
                    return;
                }
                this.icon.setBounds(handleRectInWindow);
                this.icon.draw(canvas);
            }
        }
    }

    class 1 extends DragHandle {
        final /* synthetic */ CodeEditTextScrollView j6;

        1(CodeEditTextScrollView codeEditTextScrollView, Drawable drawable, Drawable drawable2, float f, float f2, float f3, float f4, long j) {
            this.j6 = codeEditTextScrollView;
            super(drawable, drawable2, f, f2, f3, f4, j);
        }

        protected int getLine() {
            return this.j6.getOEditorView().getCaretLine();
        }

        protected int getColumn() {
            return this.j6.getOEditorView().getCaretColumn();
        }

        protected void onDraggedTo(int i, int i2) {
            this.j6.getOEditorView().Zo(i2, i);
        }

        protected void onClick() {
        }
    }

    class 2 extends DragHandle {
        final /* synthetic */ CodeEditTextScrollView j6;

        2(CodeEditTextScrollView codeEditTextScrollView, Drawable drawable, Drawable drawable2, float f, float f2, float f3, float f4, long j) {
            this.j6 = codeEditTextScrollView;
            super(drawable, drawable2, f, f2, f3, f4, j);
        }

        protected int getLine() {
            return this.j6.getOEditorView().getSelectionAnchorLine();
        }

        protected int getColumn() {
            return this.j6.getOEditorView().getSelectionAnchorColumn();
        }

        protected void onDraggedTo(int i, int i2) {
            this.j6.getOEditorView().FH(i, i2, this.j6.getOEditorView().getSelectionPointLine(), this.j6.getOEditorView().getSelectionPointColumn());
        }

        protected void onClick() {
        }
    }

    class 3 extends DragHandle {
        final /* synthetic */ CodeEditTextScrollView j6;

        3(CodeEditTextScrollView codeEditTextScrollView, Drawable drawable, Drawable drawable2, float f, float f2, float f3, float f4, long j) {
            this.j6 = codeEditTextScrollView;
            super(drawable, drawable2, f, f2, f3, f4, j);
        }

        protected int getLine() {
            return this.j6.getOEditorView().getSelectionPointLine();
        }

        protected int getColumn() {
            return this.j6.getOEditorView().getSelectionPointColumn();
        }

        protected void onDraggedTo(int i, int i2) {
            this.j6.getOEditorView().FH(this.j6.getOEditorView().getSelectionAnchorLine(), this.j6.getOEditorView().getSelectionAnchorColumn(), i, i2);
        }

        protected void onClick() {
        }
    }

    class 4 implements i {
        final /* synthetic */ CodeEditTextScrollView j6;

        4(CodeEditTextScrollView codeEditTextScrollView) {
            this.j6 = codeEditTextScrollView;
        }

        public void j6(OConsole oConsole, int i, int i2, boolean z) {
            this.j6.FH();
            this.j6.DW();
        }
    }

    class 5 implements o {
        final /* synthetic */ CodeEditTextScrollView j6;

        5(CodeEditTextScrollView codeEditTextScrollView) {
            this.j6 = codeEditTextScrollView;
        }

        public void j6(OConsole oConsole, boolean z) {
            this.j6.DW();
        }

        public void j6(OConsole oConsole) {
            this.j6.DW();
        }
    }

    class 6 implements Runnable {
        final /* synthetic */ int DW;
        final /* synthetic */ CodeEditTextScrollView FH;
        final /* synthetic */ int j6;

        6(CodeEditTextScrollView codeEditTextScrollView, int i, int i2) {
            this.FH = codeEditTextScrollView;
            this.j6 = i;
            this.DW = i2;
        }

        public void run() {
            this.FH.scrollTo(this.FH.getScrollX(), this.j6);
            this.FH.getHorizontalScrollView().scrollTo(this.DW, this.FH.getHorizontalScrollView().getScrollY());
        }
    }

    class 7 extends AnimatorListenerAdapter {
        final /* synthetic */ CodeEditTextScrollView DW;
        final /* synthetic */ Runnable j6;

        7(CodeEditTextScrollView codeEditTextScrollView, Runnable runnable) {
            this.DW = codeEditTextScrollView;
            this.j6 = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.j6 != null) {
                this.j6.run();
            }
        }
    }

    private class a extends DragHandle {
        private int DW;
        private int FH;
        private AnimatorSet Hw;
        final /* synthetic */ CodeEditTextScrollView j6;
        private boolean v5;

        class 1 extends AnimatorListenerAdapter {
            final /* synthetic */ a DW;
            final /* synthetic */ CodeEditTextScrollView j6;

            1(a aVar, CodeEditTextScrollView codeEditTextScrollView) {
                this.DW = aVar;
                this.j6 = codeEditTextScrollView;
            }

            public void onAnimationEnd(Animator animator) {
                if (this.DW.isVisible() && !this.DW.v5) {
                    animator.start();
                }
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ a j6;

            2(a aVar) {
                this.j6 = aVar;
            }

            public void run() {
                this.j6.hide();
            }
        }

        public a(CodeEditTextScrollView codeEditTextScrollView, int i) {
            this.j6 = codeEditTextScrollView;
            super(codeEditTextScrollView.getResources().getDrawable(i), codeEditTextScrollView.getResources().getDrawable(R.drawable.task_arrow_down), 0.0f, 0.5f, 0.0f, 0.5f, 10000000);
            float f = codeEditTextScrollView.getResources().getDisplayMetrics().density * 15.0f;
            Animator ofFloat = ObjectAnimator.ofFloat(this, "bounce", new float[]{f, 0.0f});
            ofFloat.setDuration((long) 300);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            Animator ofFloat2 = ObjectAnimator.ofFloat(this, "bounce", new float[]{0.0f, f});
            ofFloat2.setDuration((long) 300);
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            this.Hw = new AnimatorSet();
            this.Hw.play(ofFloat).before(ofFloat2);
            this.Hw.addListener(new 1(this, codeEditTextScrollView));
        }

        public void show() {
            super.show();
            this.v5 = false;
            if (!this.Hw.isRunning()) {
                this.Hw.start();
            }
        }

        public void j6(int i, int i2) {
            this.DW = i;
            this.FH = i2;
            show();
        }

        protected int getLine() {
            return this.DW;
        }

        protected int getColumn() {
            return this.FH;
        }

        protected void onDraggedTo(int i, int i2) {
        }

        protected void onClick() {
            this.j6.getCodeEditText().FH(this.DW, this.FH);
            this.v5 = true;
            this.j6.j6(this.DW, this.FH, this.j6.getCodeEditText().getDefaultFontSize(), new 2(this));
        }
    }

    static {
        j6 = false;
    }

    public CodeEditTextScrollView(Context context) {
        super(context);
        j6(context);
    }

    public CodeEditTextScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j6(context);
    }

    public CodeEditTextScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j6(context);
    }

    private void j6(Context context) {
        setFocusable(false);
        this.J0 = new a(this, R.drawable.task_arrow_edit);
        this.J8 = new a(this, R.drawable.task_arrow_view);
        this.tp = new 1(this, DW(context), DW(context), 0.5f, 0.0f, 0.0f, 0.0f, 3000);
        this.EQ = new 2(this, FH(context), FH(context), 0.8f, 0.0f, 0.0f, 0.0f, 10000000);
        this.we = new 3(this, Hw(context), Hw(context), 0.2f, 0.0f, 0.0f, 0.0f, 10000000);
        this.Ws = new DragHandle[]{this.J0, this.J8, this.tp, this.EQ, this.we};
    }

    private static Drawable DW(Context context) {
        if (d.j6(context)) {
            return d.j6(context, 16843463, 16843829);
        }
        return context.getResources().getDrawable(R.drawable.text_select_handle_middle);
    }

    private static Drawable FH(Context context) {
        if (d.j6(context)) {
            return d.j6(context, 16843461, 16843829);
        }
        return context.getResources().getDrawable(R.drawable.text_select_handle_left);
    }

    private static Drawable Hw(Context context) {
        if (d.j6(context)) {
            return d.j6(context, 16843462, 16843829);
        }
        return context.getResources().getDrawable(R.drawable.text_select_handle_right);
    }

    public void j6() {
        for (DragHandle onDestroy : this.Ws) {
            onDestroy.onDestroy();
        }
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (u7()) {
            return 0;
        }
        return super.computeScrollDeltaToGetChildRectOnScreen(rect);
    }

    private boolean u7() {
        return d.DW(getContext());
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        getOEditorView().j6(new 4(this));
        getOEditorView().j6(new 5(this));
    }

    public void DW() {
        if (!this.QX && !this.XL) {
            this.tp.hide();
            this.EQ.hide();
            this.we.hide();
            getCodeEditText().Hw();
        }
    }

    public void j6(int i, int i2, int i3, int i4) {
        try {
            this.XL = true;
            if (this.tp.isVisible() && !(i == i3 && i2 == i4)) {
                we();
            }
            getOEditorView().j6(i, i2, i3, i4);
            if (this.tp.isVisible() || this.EQ.isVisible()) {
                invalidate();
            }
            this.XL = false;
        } catch (Throwable th) {
            this.XL = false;
        }
    }

    private boolean tp() {
        return isHardwareAccelerated();
    }

    protected void onAttachedToWindow() {
        if (!j6 && tp()) {
            setLayerType(1, null);
        }
    }

    public View getHeaderView() {
        return ((ViewGroup) ((ViewGroup) getChildAt(0)).getChildAt(0)).getChildAt(0);
    }

    private CodeEditText getCodeEditText() {
        return (CodeEditText) ((ViewGroup) ((ViewGroup) getChildAt(0)).getChildAt(0)).getChildAt(1);
    }

    private c getOEditorView() {
        return getCodeEditText().getOEditorView();
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        super.draw(canvas);
        canvas.restoreToCount(save);
        for (DragHandle draw : this.Ws) {
            draw.draw(canvas);
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("scrollx", getScrollX());
        bundle.putInt("scrolly", getHorizontalScrollView().getScrollY());
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            postDelayed(new 6(this, bundle.getInt("scrolly"), bundle.getInt("scrollx")), 100);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public boolean FH() {
        return j6(getOEditorView().getCaretLine(), getOEditorView().getCaretColumn(), 1, 1, 1, 1, false);
    }

    private boolean j6(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        Object obj;
        Object obj2 = null;
        OConsole oEditorView = getOEditorView();
        int v5 = oEditorView.v5(i);
        int firstVisibleLine = (getFirstVisibleLine() + i3) - 1;
        int j6 = (j6(z) - i5) + 1;
        if (v5 < firstVisibleLine) {
            obj2 = 1;
            firstVisibleLine = (v5 - i3) + 1;
        }
        if (v5 > j6) {
            obj2 = 1;
            firstVisibleLine = (v5 - DW(z)) + i5;
        }
        float VH = getOEditorView().VH(i2, v5);
        float scrollX = (float) getHorizontalScrollView().getScrollX();
        float spaceCharWidth = VH - (((float) i6) * oEditorView.getSpaceCharWidth());
        if (spaceCharWidth < ((float) getHorizontalScrollView().getScrollX())) {
            obj = 1;
        } else {
            spaceCharWidth = scrollX;
            obj = null;
        }
        float spaceCharWidth2 = (((float) i4) * oEditorView.getSpaceCharWidth()) + VH;
        if (spaceCharWidth2 > ((float) (getHorizontalScrollView().getScrollX() + getMeasuredWidth()))) {
            obj = 1;
            spaceCharWidth = spaceCharWidth2 - ((float) getMeasuredWidth());
        }
        if (!(obj == null && obj2 == null)) {
            if (obj2 != null) {
                if (firstVisibleLine < 0) {
                    firstVisibleLine = 0;
                }
                scrollTo(getScrollX(), (int) ((((float) firstVisibleLine) * getOEditorView().getFontHeight()) + ((float) getHeaderHeight())));
            }
            if (obj != null) {
                getHorizontalScrollView().scrollTo((int) spaceCharWidth, getHorizontalScrollView().getScrollY());
            }
            if (v5 <= 0) {
                EQ();
            }
        }
        return (obj == null && obj2 == null) ? false : true;
    }

    public void j6(int i, int i2) {
        int firstVisibleLine = getFirstVisibleLine() + 1;
        int min = Math.min(i, Math.max(1, ((((int) (((float) i2) / getOEditorView().getFontHeight())) + i) - getScreenLinesCount()) + 2));
        if (firstVisibleLine < min) {
            scrollTo(getScrollX(), (int) ((((float) (min - 1)) * getOEditorView().getFontHeight()) + ((float) getHeaderHeight())));
        }
    }

    private int getScrollLineY() {
        return getScrollY() - getHeaderHeight();
    }

    private int getScrollColumnX() {
        return getHorizontalScrollView().getScrollX();
    }

    private void DW(int i, int i2) {
        scrollTo(getScrollX(), getHeaderHeight() + i2);
        getHorizontalScrollView().scrollTo(i, getScrollY());
    }

    private int getHeaderHeight() {
        return getHeaderView().getMeasuredHeight();
    }

    private void EQ() {
        scrollTo(getScrollX(), 0);
    }

    public void Hw() {
        getHorizontalScrollView().scrollTo(0, 0);
        scrollTo(0, getHeaderHeight());
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "scrollY", new int[]{0});
        ofInt.setDuration(500);
        ofInt.start();
    }

    private HorizontalScrollView getHorizontalScrollView() {
        return (HorizontalScrollView) getChildAt(0);
    }

    public int getFirstVisibleLine() {
        return (int) (((float) getScrollLineY()) / getOEditorView().getFontHeight());
    }

    public int j6(boolean z) {
        return (getFirstVisibleLine() + DW(z)) - 1;
    }

    private int DW(boolean z) {
        return (int) (((float) (getMeasuredHeight() - (z ? 0 : getQuickKeyBarHeight()))) / getOEditorView().getFontHeight());
    }

    private int getScreenLinesCount() {
        return (int) (((float) (((Activity) getContext()).getWindow().getDecorView().findViewById(16908290).getHeight() - getQuickKeyBarHeight())) / getOEditorView().getFontHeight());
    }

    private int getQuickKeyBarHeight() {
        return getCodeEditText().getQuickKeyBarHeight();
    }

    private int getVisibleColumnsCount() {
        return (int) (((float) getMeasuredWidth()) / getOEditorView().getSpaceCharWidth());
    }

    public boolean j6(MotionEvent motionEvent) {
        return this.tp.isTouchEventInsideHandle(motionEvent) || this.EQ.isTouchEventInsideHandle(motionEvent) || this.we.isTouchEventInsideHandle(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        for (DragHandle onInterceptTouchEvent : this.Ws) {
            if (onInterceptTouchEvent.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
        }
        if (d.j6(motionEvent)) {
            return false;
        }
        if (!this.DW && motionEvent.getActionMasked() == 5 && motionEvent.getPointerCount() == 2) {
            Hw(motionEvent);
        }
        if (this.DW) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (DragHandle onTouchEvent : this.Ws) {
            if (onTouchEvent.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        if (!this.DW && motionEvent.getActionMasked() == 5 && motionEvent.getPointerCount() == 2) {
            Hw(motionEvent);
        }
        if (!this.DW) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 2 && motionEvent.getPointerCount() == 2) {
            FH(motionEvent);
        }
        if ((motionEvent.getAction() != 1 || motionEvent.getPointerCount() != 1) && motionEvent.getAction() != 3) {
            return true;
        }
        DW(motionEvent);
        return true;
    }

    private void DW(MotionEvent motionEvent) {
        this.DW = false;
    }

    private void FH(MotionEvent motionEvent) {
        setPinchZoom(j6(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1)) / this.FH);
    }

    private void setPinchZoom(float f) {
        float[] j6 = getOEditorView().j6(f);
        float f2 = j6[1];
        this.gn = (j6[0] * (((float) this.Zo) + this.Hw)) - this.Hw;
        this.u7 = ((((float) this.VH) + this.v5) * f2) - this.v5;
        DW((int) this.gn, (int) this.u7);
    }

    private void Hw(MotionEvent motionEvent) {
        this.DW = true;
        this.FH = j6(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        j6((motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f, ((motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f) - ((float) getHeaderHeight()));
    }

    private void j6(float f, float f2) {
        this.Hw = f;
        this.v5 = f2;
        this.Zo = getScrollColumnX();
        this.VH = getScrollLineY();
        getOEditorView().Hw();
    }

    private float j6(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt((double) (((f - f3) * (f - f3)) + ((f2 - f4) * (f2 - f4))));
    }

    public void j6(int i, int i2, float f, Runnable runnable) {
        if (getOEditorView().getFontSize() != f) {
            getOEditorView().requestFocus();
            j6(getOEditorView().VH(i2, i), getOEditorView().Hw(i) - ((float) getScrollLineY()));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "pinchZoom", new float[]{1.0f, f / getOEditorView().getFontSize()});
            ofFloat.setDuration(1000);
            ofFloat.addListener(new 7(this, runnable));
            ofFloat.start();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public boolean v5() {
        return this.J0.isVisible() || this.J8.isVisible();
    }

    public void Zo() {
        if (this.J0.isVisible() && getOEditorView().getCaretLine() != this.J0.getLine()) {
            getOEditorView().Zo(this.J0.getColumn(), this.J0.getLine());
        }
    }

    public void VH() {
        this.J8.hide();
        this.J0.hide();
    }

    public void j6(int i, int i2, boolean z, boolean z2) {
        if (z) {
            this.J0.j6(i - 1, i2 - 1);
        } else {
            this.J8.j6(i - 1, i2 - 1);
        }
        if (z2) {
            getOEditorView().setFontSize(0.5f * getCodeEditText().getDefaultFontSize());
        }
    }

    public void gn() {
        if (getOEditorView().QX()) {
            we();
        } else {
            J0();
        }
    }

    private void we() {
        this.tp.hide();
        this.EQ.show();
        this.we.show();
    }

    private void J0() {
        this.tp.show();
        this.EQ.hide();
        this.we.hide();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getOEditorView().aM();
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        getOEditorView().aM();
    }
}
