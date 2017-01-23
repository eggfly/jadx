package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.v */
public class C0626v extends SeekBar {
    private C0627w f2114a;
    private C0616l f2115b;

    public C0626v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.seekBarStyle);
    }

    public C0626v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2115b = C0616l.m2672a();
        this.f2114a = new C0627w(this, this.f2115b);
        this.f2114a.m2708a(attributeSet, i);
    }
}
