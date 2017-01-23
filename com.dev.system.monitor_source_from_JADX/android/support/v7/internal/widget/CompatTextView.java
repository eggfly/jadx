package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.appcompat.C0056R;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

public class CompatTextView extends TextView {

    private static class AllCapsTransformationMethod implements TransformationMethod {
        private final Locale mLocale;

        public AllCapsTransformationMethod(Context context) {
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence source, View view) {
            return source != null ? source.toString().toUpperCase(this.mLocale) : null;
        }

        public void onFocusChanged(View view, CharSequence charSequence, boolean b, int i, Rect rect) {
        }
    }

    public CompatTextView(Context context) {
        this(context, null);
    }

    public CompatTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompatTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray style = context.obtainStyledAttributes(attrs, C0056R.styleable.CompatTextView, defStyle, 0);
        boolean allCaps = style.getBoolean(0, false);
        style.recycle();
        if (allCaps) {
            setTransformationMethod(new AllCapsTransformationMethod(context));
        }
    }
}
