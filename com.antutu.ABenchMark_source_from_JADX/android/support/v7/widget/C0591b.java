package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.widget.b */
class C0591b extends Drawable {
    final ActionBarContainer f1948a;

    public C0591b(ActionBarContainer actionBarContainer) {
        this.f1948a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f1948a.f1294d) {
            if (this.f1948a.f1291a != null) {
                this.f1948a.f1291a.draw(canvas);
            }
            if (this.f1948a.f1292b != null && this.f1948a.f1295e) {
                this.f1948a.f1292b.draw(canvas);
            }
        } else if (this.f1948a.f1293c != null) {
            this.f1948a.f1293c.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
