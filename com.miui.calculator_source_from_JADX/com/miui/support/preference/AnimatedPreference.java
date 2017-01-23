package com.miui.support.preference;

import android.graphics.drawable.Drawable;
import android.preference.CheckBoxPreference;
import android.view.View;
import android.widget.ImageView;
import com.miui.support.internal.C0264R;
import com.miui.support.widget.AnimatedImageView;

public class AnimatedPreference extends CheckBoxPreference {
    private int f3497a;
    private Drawable f3498b;
    private Drawable f3499c;

    public void onBindView(View view) {
        int i = 0;
        super.onBindView(view);
        AnimatedImageView animatedImageView = (AnimatedImageView) view.findViewById(C0264R.id.animate);
        ImageView imageView = (ImageView) view.findViewById(C0264R.id.animate_finish);
        if (this.f3498b != null) {
            animatedImageView.setImageDrawable(this.f3498b);
        }
        if (this.f3499c != null) {
            imageView.setImageDrawable(this.f3499c);
        }
        animatedImageView.setVisibility(m5192a() ? 0 : 8);
        animatedImageView.setAnimating(m5193b());
        if (!m5194c()) {
            i = 8;
        }
        imageView.setVisibility(i);
        ((ImageView) view.findViewById(16908294)).setAlpha(isEnabled() ? 1.0f : 0.3f);
    }

    public boolean m5192a() {
        return (this.f3497a & 1) != 0;
    }

    public boolean m5193b() {
        return (this.f3497a & 2) != 0;
    }

    public boolean m5194c() {
        return (this.f3497a & 4) != 0;
    }
}
