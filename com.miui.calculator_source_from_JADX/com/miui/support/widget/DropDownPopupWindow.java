package com.miui.support.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.miui.support.internal.util.DeviceHelper;

public class DropDownPopupWindow {
    private PopupWindow f4075a;
    private ContainerView f4076b;
    private View f4077c;
    private ContentController f4078d;
    private ContainerController f4079e;
    private Controller f4080f;
    private int f4081g;
    private ValueAnimator f4082h;
    private boolean f4083i;
    private AnimatorUpdateListener f4084j;
    private AnimatorListener f4085k;

    /* renamed from: com.miui.support.widget.DropDownPopupWindow.1 */
    class C04661 implements AnimatorUpdateListener {
        final /* synthetic */ DropDownPopupWindow f4071a;

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) this.f4071a.f4082h.getAnimatedValue()).floatValue();
            if (this.f4071a.f4079e != null) {
                this.f4071a.f4079e.m5781a(this.f4071a.f4076b, floatValue);
            }
            if (this.f4071a.f4078d != null) {
                this.f4071a.f4078d.m5781a(this.f4071a.f4077c, floatValue);
            }
        }
    }

    /* renamed from: com.miui.support.widget.DropDownPopupWindow.2 */
    class C04672 implements AnimatorListener {
        final /* synthetic */ DropDownPopupWindow f4072a;

        private void m5779a() {
            if (this.f4072a.f4083i) {
                this.f4072a.m5789b();
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f4072a.f4083i && this.f4072a.f4080f != null) {
                this.f4072a.f4080f.m5780a();
            }
        }

        public void onAnimationEnd(Animator animator) {
            m5779a();
        }

        public void onAnimationCancel(Animator animator) {
            m5779a();
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.miui.support.widget.DropDownPopupWindow.3 */
    class C04683 implements OnTouchListener {
        final /* synthetic */ DropDownPopupWindow f4073a;

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() != 0 || (x >= 0 && x < this.f4073a.f4076b.getWidth() && y >= 0 && y < this.f4073a.f4076b.getHeight())) {
                return false;
            }
            this.f4073a.m5796a();
            return true;
        }
    }

    public interface Controller {
        void m5780a();

        void m5781a(View view, float f);
    }

    public interface ContainerController extends Controller {
    }

    private class ContainerView extends FrameLayout {
        final /* synthetic */ DropDownPopupWindow f4074a;

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!super.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                this.f4074a.m5796a();
            }
            return true;
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            this.f4074a.m5796a();
            return true;
        }
    }

    public interface ContentController extends Controller {
    }

    public static class DefaultContainerController implements ContainerController {
        public void m5782a() {
        }

        public void m5783a(View view, float f) {
            Drawable background = view.getBackground();
            if (background != null) {
                background.setAlpha((int) (255.0f * f));
            }
        }
    }

    public static class ViewContentController implements ContentController {
        public void m5784a() {
        }

        public void m5785a(View view, float f) {
            if (view != null) {
                view.setTranslationY(((float) (-view.getHeight())) * (1.0f - f));
            }
        }
    }

    public static class ListController extends ViewContentController {
    }

    private void m5787a(float f, float f2, int i) {
        if (this.f4082h != null) {
            this.f4082h.cancel();
        }
        if (this.f4079e != null || this.f4078d != null) {
            if (this.f4082h == null) {
                this.f4082h = ValueAnimator.ofFloat(new float[]{f, f2});
            } else {
                this.f4082h.setFloatValues(new float[]{f, f2});
            }
            this.f4082h.setDuration(DeviceHelper.f2553e ? (long) i : 0);
            this.f4082h.addUpdateListener(this.f4084j);
            this.f4082h.addListener(this.f4085k);
            this.f4082h.start();
        }
    }

    private void m5789b() {
        if (this.f4075a != null) {
            this.f4075a.dismiss();
        }
        if (this.f4079e != null) {
            this.f4079e.m5780a();
        }
        if (this.f4078d != null) {
            this.f4078d.m5780a();
        }
        this.f4083i = false;
    }

    public void m5796a() {
        this.f4083i = true;
        m5787a(1.0f, 0.0f, this.f4081g);
    }
}
