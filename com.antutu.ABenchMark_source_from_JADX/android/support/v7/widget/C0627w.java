package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.w */
class C0627w extends C0623s {
    private static final int[] f2116b;
    private final SeekBar f2117c;

    static {
        f2116b = new int[]{16843074};
    }

    C0627w(SeekBar seekBar, C0616l c0616l) {
        super(seekBar, c0616l);
        this.f2117c = seekBar;
    }

    void m2708a(AttributeSet attributeSet, int i) {
        super.m2707a(attributeSet, i);
        bh a = bh.m2502a(this.f2117c.getContext(), attributeSet, f2116b, i, 0);
        Drawable b = a.m2509b(0);
        if (b != null) {
            this.f2117c.setThumb(b);
        }
        a.m2506a();
    }
}
