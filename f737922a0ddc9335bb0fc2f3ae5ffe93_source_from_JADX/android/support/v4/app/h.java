package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

abstract class h extends Activity {
    abstract View j6(View view, String str, Context context, AttributeSet attributeSet);

    h() {
    }

    protected void onCreate(Bundle bundle) {
        if (VERSION.SDK_INT < 11 && getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View j6 = j6(null, str, context, attributeSet);
        if (j6 == null) {
            return super.onCreateView(str, context, attributeSet);
        }
        return j6;
    }
}
