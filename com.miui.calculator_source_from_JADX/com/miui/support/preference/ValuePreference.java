package com.miui.support.preference;

import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;

public class ValuePreference extends Preference {
    private CharSequence f3517a;
    private boolean f3518b;
    private Drawable f3519c;

    public CharSequence m5208a() {
        return this.f3517a;
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(C0234R.id.value_right);
        if (textView != null) {
            CharSequence a = m5208a();
            if (TextUtils.isEmpty(a)) {
                textView.setVisibility(8);
            } else {
                textView.setText(a);
                textView.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) view.findViewById(C0264R.id.arrow_right);
        if (imageView != null) {
            int i;
            if (this.f3518b) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
            if (this.f3518b) {
                imageView.setVisibility(0);
                if (this.f3519c != null) {
                    imageView.setImageDrawable(this.f3519c);
                    return;
                } else {
                    this.f3519c = imageView.getDrawable();
                    return;
                }
            }
            imageView.setVisibility(8);
        }
    }
}
