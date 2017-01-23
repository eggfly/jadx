package com.miui.support.preference;

import android.graphics.drawable.Drawable;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.ImageView;
import com.miui.support.internal.C0264R;

public class SeekBarDialogPreference extends DialogPreference {
    private Drawable f3516a;

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        ImageView imageView = (ImageView) view.findViewById(C0264R.id.icon);
        if (this.f3516a != null) {
            imageView.setImageDrawable(this.f3516a);
        } else {
            imageView.setVisibility(8);
        }
    }
}
