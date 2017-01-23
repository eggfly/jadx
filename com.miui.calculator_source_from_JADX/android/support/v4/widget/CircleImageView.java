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
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CircleImageView extends ImageView {
    private AnimationListener f1002a;
    private int f1003b;

    private class OvalShadow extends OvalShape {
        final /* synthetic */ CircleImageView f998a;
        private RadialGradient f999b;
        private Paint f1000c;
        private int f1001d;

        public OvalShadow(CircleImageView circleImageView, int i, int i2) {
            this.f998a = circleImageView;
            this.f1000c = new Paint();
            circleImageView.f1003b = i;
            this.f1001d = i2;
            this.f999b = new RadialGradient((float) (this.f1001d / 2), (float) (this.f1001d / 2), (float) circleImageView.f1003b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f1000c.setShader(this.f999b);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.f998a.getWidth();
            int height = this.f998a.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f1001d / 2) + this.f998a.f1003b), this.f1000c);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f1001d / 2), paint);
        }
    }

    public CircleImageView(Context context, int i, float f) {
        Drawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) ((f * f2) * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f1003b = (int) (3.5f * f2);
        if (m2044a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.m1463c((View) this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new OvalShadow(this, this.f1003b, i2));
            ViewCompat.m1448a((View) this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f1003b, (float) i4, (float) i3, 503316480);
            int i5 = this.f1003b;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean m2044a() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m2044a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f1003b * 2), getMeasuredHeight() + (this.f1003b * 2));
        }
    }

    public void m2045a(AnimationListener animationListener) {
        this.f1002a = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f1002a != null) {
            this.f1002a.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f1002a != null) {
            this.f1002a.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
