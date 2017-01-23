package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

abstract class i extends h {
    i() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View j6 = j6(view, str, context, attributeSet);
        if (j6 != null || VERSION.SDK_INT < 11) {
            return j6;
        }
        return super.onCreateView(view, str, context, attributeSet);
    }
}
