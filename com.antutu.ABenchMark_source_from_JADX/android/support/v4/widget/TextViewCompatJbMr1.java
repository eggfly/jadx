package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

class TextViewCompatJbMr1 {
    TextViewCompatJbMr1() {
    }

    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
        Drawable drawable5 = obj != null ? drawable3 : drawable;
        if (obj == null) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, int i, int i2, int i3, int i4) {
        Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
        int i5 = obj != null ? i3 : i;
        if (obj == null) {
            i = i3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(i5, i2, i, i4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
        Drawable drawable5 = obj != null ? drawable3 : drawable;
        if (obj == null) {
            drawable = drawable3;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
    }
}
