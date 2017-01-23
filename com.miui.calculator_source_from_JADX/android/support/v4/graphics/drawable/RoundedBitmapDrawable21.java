package android.support.v4.graphics.drawable;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    public void getOutline(Outline outline) {
        m597a();
        outline.setRoundRect(this.b, m599b());
    }

    void m600a(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }
}
