package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.o */
public class C0619o {
    private final ImageView f2095a;
    private final C0616l f2096b;

    public C0619o(ImageView imageView, C0616l c0616l) {
        this.f2095a = imageView;
        this.f2096b = c0616l;
    }

    public void m2699a(int i) {
        if (i != 0) {
            Drawable a = this.f2096b != null ? this.f2096b.m2695a(this.f2095a.getContext(), i) : ContextCompat.getDrawable(this.f2095a.getContext(), i);
            if (a != null) {
                ak.m2321b(a);
            }
            this.f2095a.setImageDrawable(a);
            return;
        }
        this.f2095a.setImageDrawable(null);
    }

    public void m2700a(AttributeSet attributeSet, int i) {
        bh a = bh.m2502a(this.f2095a.getContext(), attributeSet, C0417R.styleable.AppCompatImageView, i, 0);
        try {
            Drawable b = a.m2509b(C0417R.styleable.AppCompatImageView_android_src);
            if (b != null) {
                this.f2095a.setImageDrawable(b);
            }
            int g = a.m2518g(C0417R.styleable.AppCompatImageView_srcCompat, -1);
            if (g != -1) {
                b = this.f2096b.m2695a(this.f2095a.getContext(), g);
                if (b != null) {
                    this.f2095a.setImageDrawable(b);
                }
            }
            b = this.f2095a.getDrawable();
            if (b != null) {
                ak.m2321b(b);
            }
            a.m2506a();
        } catch (Throwable th) {
            a.m2506a();
        }
    }
}
