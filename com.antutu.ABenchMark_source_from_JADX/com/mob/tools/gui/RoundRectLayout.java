package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RoundRectLayout extends RelativeLayout {
    private Path path;
    private float[] rect;

    public RoundRectLayout(Context context) {
        super(context);
    }

    public RoundRectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundRectLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.rect != null) {
            if (this.path == null) {
                int width = getWidth();
                int height = getHeight();
                this.path = new Path();
                this.path.addRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), this.rect, Direction.CW);
            }
            canvas.clipPath(this.path);
        }
        super.dispatchDraw(canvas);
    }

    public void setRound(float f) {
        setRound(f, f, f, f);
    }

    public void setRound(float f, float f2, float f3, float f4) {
        this.rect = new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }
}
