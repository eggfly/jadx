package com.miui.calculator.common.utils;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

public class AnimationUtils {

    public interface ExitAnimationEndListener {
        void m2794a();
    }

    /* renamed from: com.miui.calculator.common.utils.AnimationUtils.1 */
    final class C01751 implements AnimatorListener {
        final /* synthetic */ ExitAnimationEndListener f1519a;

        C01751(ExitAnimationEndListener exitAnimationEndListener) {
            this.f1519a = exitAnimationEndListener;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f1519a != null) {
                this.f1519a.m2794a();
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public static void m2798a(View view, int i, int i2) {
        view.setScaleX(0.33f);
        view.setScaleY(0.33f);
        view.setPivotX((float) i);
        view.setPivotY((float) i2);
        view.setAlpha(0.0f);
        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).start();
    }

    public static void m2799a(View view, int i, int i2, ExitAnimationEndListener exitAnimationEndListener) {
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX((float) i);
        view.setPivotY((float) i2);
        view.setAlpha(1.0f);
        view.animate().scaleX(0.33f).scaleY(0.33f).alpha(0.0f).setDuration(200).setListener(new C01751(exitAnimationEndListener)).start();
    }

    public static void m2797a(Activity activity) {
        try {
            Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]).invoke(activity, new Object[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }
}
