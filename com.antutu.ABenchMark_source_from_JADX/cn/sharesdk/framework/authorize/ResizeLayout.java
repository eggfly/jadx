package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ResizeLayout extends LinearLayout {
    private OnResizeListener f3189a;

    public interface OnResizeListener {
        void OnResize(int i, int i2, int i3, int i4);
    }

    public ResizeLayout(Context context) {
        super(context);
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void m4108a(OnResizeListener onResizeListener) {
        this.f3189a = onResizeListener;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f3189a != null) {
            this.f3189a.OnResize(i, i2, i3, i4);
        }
    }
}
