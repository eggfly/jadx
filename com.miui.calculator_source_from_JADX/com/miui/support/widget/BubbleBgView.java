package com.miui.support.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BubbleBgView extends View {
    private static final int[] f3992a;
    private ArrayList<Bubble> f3993b;
    private Paint f3994c;
    private Handler f3995d;

    /* renamed from: com.miui.support.widget.BubbleBgView.1 */
    class C04551 extends Handler {
        final /* synthetic */ BubbleBgView f3980a;

        C04551(BubbleBgView bubbleBgView) {
            this.f3980a = bubbleBgView;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    this.f3980a.invalidate();
                    this.f3980a.f3995d.sendEmptyMessageDelayed(1, 10);
                default:
            }
        }
    }

    private static class Bubble {
        private static final Random f3982j;
        private final int f3983a;
        private final int f3984b;
        private final int f3985c;
        private final int f3986d;
        private final int f3987e;
        private final int f3988f;
        private final int f3989g;
        private final int f3990h;
        private AnimatorSet f3991i;

        /* renamed from: com.miui.support.widget.BubbleBgView.Bubble.1 */
        class C04561 implements AnimatorListener {
            final /* synthetic */ Bubble f3981a;

            C04561(Bubble bubble) {
                this.f3981a = bubble;
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                this.f3981a.m5699a();
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }
        }

        static {
            f3982j = new Random(System.currentTimeMillis());
        }

        public Bubble(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f3983a = i;
            this.f3984b = i2;
            this.f3985c = i3;
            this.f3987e = i4 + i;
            this.f3986d = i5 + i;
            this.f3989g = i6 + i2;
            this.f3988f = i7 + i2;
            this.f3990h = i8;
            m5699a();
        }

        private void m5699a() {
            int nextInt = f3982j.nextInt(1000) + 2000;
            this.f3991i = new AnimatorSet();
            new ValueAnimator().setDuration((long) nextInt);
            new ValueAnimator().setDuration((long) nextInt);
            this.f3991i.playTogether(new Animator[]{r1, r2});
            this.f3991i.addListener(new C04561(this));
            this.f3991i.cancel();
            int nextInt2 = this.f3987e + f3982j.nextInt(this.f3986d - this.f3987e);
            int nextInt3 = this.f3989g + f3982j.nextInt(this.f3988f - this.f3989g);
            ((ValueAnimator) this.f3991i.getChildAnimations().get(0)).setFloatValues(new float[]{(float) this.f3983a, (float) nextInt2, (float) this.f3983a});
            ((ValueAnimator) this.f3991i.getChildAnimations().get(1)).setFloatValues(new float[]{(float) this.f3984b, (float) nextInt3, (float) this.f3984b});
            this.f3991i.start();
        }

        private float m5700b() {
            if (this.f3991i == null) {
                return (float) this.f3983a;
            }
            return ((Float) ((ValueAnimator) this.f3991i.getChildAnimations().get(0)).getAnimatedValue()).floatValue();
        }

        private float m5702c() {
            if (this.f3991i == null) {
                return (float) this.f3984b;
            }
            return ((Float) ((ValueAnimator) this.f3991i.getChildAnimations().get(1)).getAnimatedValue()).floatValue();
        }
    }

    static {
        if (DeviceHelper.f2555g) {
            f3992a = new int[]{110, 197, 198, 0, 30, -80, 20, -9703, 160, -32, 230, 0, 30, 0, 100, 872358400, 591, 24, 367, 0, 30, -50, 50, -419432704, 805, 273, 173, -30, 10, -80, 20, 1929561904, 326, -68, 417, 0, 30, 0, 50, -637576704};
        } else {
            f3992a = new int[]{39, 161, 103, 0, 30, -80, 20, -9703, 103, 39, 114, 0, 30, 0, 100, 872358400, 302, 41, 211, 0, 30, -50, 50, -419432704, 411, 166, 119, -30, 10, -80, 20, 1929561904, 171, 226, 181, -15, 15, -20, 30, 1291385080, 135, 33, 195, 0, 30, 0, 50, -637576704};
        }
    }

    public BubbleBgView(Context context) {
        this(context, null);
    }

    public BubbleBgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleBgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3993b = new ArrayList();
        this.f3994c = new Paint(1);
        this.f3995d = new C04551(this);
        m5707a();
        this.f3995d.sendEmptyMessage(1);
    }

    private void m5707a() {
        float f = getResources().getDisplayMetrics().density;
        for (int i = 0; i < f3992a.length; i += 8) {
            this.f3993b.add(new Bubble((int) (((float) f3992a[i + 0]) * f), (int) (((float) f3992a[i + 1]) * f), (int) (((float) f3992a[i + 2]) * f), f3992a[i + 3], f3992a[i + 4], f3992a[i + 5], f3992a[i + 6], f3992a[i + 7]));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator it = this.f3993b.iterator();
        while (it.hasNext()) {
            Bubble bubble = (Bubble) it.next();
            this.f3994c.setColor(bubble.f3990h);
            canvas.drawCircle(bubble.m5700b(), bubble.m5702c(), (float) bubble.f3985c, this.f3994c);
        }
    }
}
