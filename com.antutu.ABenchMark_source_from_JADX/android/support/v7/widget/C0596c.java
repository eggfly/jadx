package android.support.v7.widget;

import android.graphics.Outline;

/* renamed from: android.support.v7.widget.c */
class C0596c extends C0591b {
    public C0596c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1294d) {
            if (this.a.f1293c != null) {
                this.a.f1293c.getOutline(outline);
            }
        } else if (this.a.f1291a != null) {
            this.a.f1291a.getOutline(outline);
        }
    }
}
