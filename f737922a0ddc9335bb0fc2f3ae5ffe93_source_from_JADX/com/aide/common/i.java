package com.aide.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class i extends LinearLayout {
    private Paint DW;
    private float FH;
    private boolean Hw;
    private Paint j6;
    private boolean v5;

    class 1 implements OnClickListener {
        final /* synthetic */ i j6;

        1(i iVar) {
            this.j6 = iVar;
        }

        public void onClick(View view) {
            this.j6.j6();
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ i j6;

        2(i iVar) {
            this.j6 = iVar;
        }

        public void run() {
            if (this.j6.Hw) {
                this.j6.Hw = false;
                this.j6.DW();
            }
        }
    }

    public i(Context context, View view) {
        super(context);
        this.v5 = true;
        if (view != null) {
            addView(view, new LayoutParams(-1, -1));
        }
        setWillNotDraw(false);
        setClipChildren(false);
        setEnabled(true);
        setFocusable(true);
        setOnClickListener(new 1(this));
        this.j6 = new Paint();
        this.j6.setStyle(Style.STROKE);
        this.j6.setColor(-5592406);
        this.j6.setStrokeWidth(1.0f);
        this.j6.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        this.DW = new Paint();
        this.DW.setStyle(Style.STROKE);
        this.DW.setColor(-13388315);
        this.DW.setStrokeWidth(6.0f * getResources().getDisplayMetrics().density);
        this.FH = 2.0f * getResources().getDisplayMetrics().density;
    }

    public View focusSearch(int i) {
        ViewGroup viewGroup;
        if (i == 130) {
            if (getChildCount() > 0 && (getChildAt(0) instanceof ViewGroup)) {
                viewGroup = (ViewGroup) getChildAt(0);
                if (viewGroup.getChildCount() > 0 && (viewGroup.getChildAt(0) instanceof i)) {
                    return viewGroup.getChildAt(0);
                }
            }
        } else if (i == 33 && (getParent().getParent() instanceof i)) {
            viewGroup = (ViewGroup) getParent().getParent();
            if (((ViewGroup) viewGroup.getChildAt(0)).getChildAt(0) == this) {
                return viewGroup;
            }
        }
        return super.focusSearch(i);
    }

    protected void j6() {
    }

    public void setIsVisible(boolean z) {
        this.v5 = z;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.v5) {
            return;
        }
        if (this.Hw || isFocused()) {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) (getWidth() - 1), (float) (getHeight() - 1)), this.FH, this.FH, this.DW);
        } else {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) (getWidth() - 1), (float) (getHeight() - 1)), this.FH, this.FH, this.j6);
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (getParent() instanceof View) {
            ((View) getParent()).invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View childAt = getChildAt(0);
        if (!(childAt instanceof ViewGroup) || (childAt instanceof AdapterView)) {
            return true;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            if (motionEvent.getAction() == 0) {
                this.Hw = true;
                DW();
                postDelayed(new 2(this), 1000);
            }
            if (motionEvent.getAction() == 1 && this.Hw) {
                this.Hw = false;
                DW();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void DW() {
        invalidate(-10, -10, getWidth() + 10, getHeight() + 10);
    }
}
