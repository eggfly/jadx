package com.miui.support.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.miui.support.internal.C0264R;

public class DropDownImageView extends ImageView {
    private Context f4068a;
    private AnimatorSet f4069b;
    private AnimatorSet f4070c;

    /* renamed from: com.miui.support.widget.DropDownImageView.1 */
    class C04621 extends AnimatorListenerAdapter {
        final /* synthetic */ DropDownImageView f4064a;

        C04621(DropDownImageView dropDownImageView) {
            this.f4064a = dropDownImageView;
        }

        public void onAnimationEnd(Animator animator) {
            ImageView imageView = (ImageView) ((ObjectAnimator) animator).getTarget();
            imageView.setRotationX(-90.0f);
            imageView.setImageLevel(0);
            imageView.setRotationX(90.0f);
        }
    }

    /* renamed from: com.miui.support.widget.DropDownImageView.2 */
    class C04632 extends AnimatorListenerAdapter {
        final /* synthetic */ DropDownImageView f4065a;

        C04632(DropDownImageView dropDownImageView) {
            this.f4065a = dropDownImageView;
        }

        public void onAnimationEnd(Animator animator) {
            ((ImageView) ((ObjectAnimator) animator).getTarget()).setRotationX(0.0f);
        }
    }

    /* renamed from: com.miui.support.widget.DropDownImageView.3 */
    class C04643 extends AnimatorListenerAdapter {
        final /* synthetic */ DropDownImageView f4066a;

        C04643(DropDownImageView dropDownImageView) {
            this.f4066a = dropDownImageView;
        }

        public void onAnimationEnd(Animator animator) {
            ImageView imageView = (ImageView) ((ObjectAnimator) animator).getTarget();
            imageView.setRotationX(90.0f);
            imageView.setImageLevel(1);
            imageView.setRotationX(-90.0f);
        }
    }

    /* renamed from: com.miui.support.widget.DropDownImageView.4 */
    class C04654 extends AnimatorListenerAdapter {
        final /* synthetic */ DropDownImageView f4067a;

        C04654(DropDownImageView dropDownImageView) {
            this.f4067a = dropDownImageView;
        }

        public void onAnimationEnd(Animator animator) {
            ((ImageView) ((ObjectAnimator) animator).getTarget()).setRotationX(0.0f);
        }
    }

    public DropDownImageView(Context context) {
        this(context, null);
    }

    public DropDownImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropDownImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, C0264R.attr.dropdownImageViewStyle);
        this.f4069b = null;
        this.f4070c = null;
        this.f4068a = context;
        m5778a();
    }

    private void m5778a() {
        this.f4070c = new AnimatorSet();
        this.f4070c.setDuration(150);
        Animator ofFloat = ObjectAnimator.ofFloat(this, "rotationX", new float[]{0.0f, -90.0f});
        ofFloat.addListener(new C04621(this));
        Animator ofFloat2 = ObjectAnimator.ofFloat(this, "rotationX", new float[]{90.0f, 0.0f});
        ofFloat2.addListener(new C04632(this));
        this.f4070c.play(ofFloat).before(ofFloat2);
        this.f4070c.setDuration(150);
        this.f4069b = new AnimatorSet();
        ofFloat = ObjectAnimator.ofFloat(this, "rotationX", new float[]{0.0f, 90.0f});
        ofFloat.addListener(new C04643(this));
        ofFloat2 = ObjectAnimator.ofFloat(this, "rotationX", new float[]{-90.0f, 0.0f});
        ofFloat2.addListener(new C04654(this));
        this.f4069b.play(ofFloat).before(ofFloat2);
    }
}
