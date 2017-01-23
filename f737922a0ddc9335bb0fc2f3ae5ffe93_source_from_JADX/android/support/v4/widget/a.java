package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class a extends ImageView {
    private int DW;
    private AnimationListener j6;

    private class a extends OvalShape {
        private RadialGradient DW;
        private Paint FH;
        private int Hw;
        final /* synthetic */ a j6;

        public a(a aVar, int i, int i2) {
            this.j6 = aVar;
            this.FH = new Paint();
            aVar.DW = i;
            this.Hw = i2;
            this.DW = new RadialGradient((float) (this.Hw / 2), (float) (this.Hw / 2), (float) aVar.DW, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.FH.setShader(this.DW);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.j6.getWidth();
            int height = this.j6.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.Hw / 2) + this.j6.DW), this.FH);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.Hw / 2), paint);
        }
    }

    public a(Context context, int i, float f) {
        Drawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) ((f * f2) * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.DW = (int) (3.5f * f2);
        if (j6()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            z.FH((View) this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new a(this, this.DW, i2));
            z.j6(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.DW, (float) i4, (float) i3, 503316480);
            int i5 = this.DW;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean j6() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!j6()) {
            setMeasuredDimension(getMeasuredWidth() + (this.DW * 2), getMeasuredHeight() + (this.DW * 2));
        }
    }

    public void j6(AnimationListener animationListener) {
        this.j6 = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.j6 != null) {
            this.j6.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.j6 != null) {
            this.j6.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
