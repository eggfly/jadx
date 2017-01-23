package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class PagerTitleStripIcs {

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale f824a;

        public SingleLineAllCapsTransform(Context context) {
            this.f824a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            return transformation != null ? transformation.toString().toUpperCase(this.f824a) : null;
        }
    }

    PagerTitleStripIcs() {
    }

    public static void m1329a(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }
}
