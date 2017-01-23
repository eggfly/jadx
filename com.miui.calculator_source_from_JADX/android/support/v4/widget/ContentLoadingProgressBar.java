package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private long f1007a;
    private boolean f1008b;
    private boolean f1009c;
    private boolean f1010d;
    private final Runnable f1011e;
    private final Runnable f1012f;

    /* renamed from: android.support.v4.widget.ContentLoadingProgressBar.1 */
    class C01061 implements Runnable {
        final /* synthetic */ ContentLoadingProgressBar f1005a;

        C01061(ContentLoadingProgressBar contentLoadingProgressBar) {
            this.f1005a = contentLoadingProgressBar;
        }

        public void run() {
            this.f1005a.f1008b = false;
            this.f1005a.f1007a = -1;
            this.f1005a.setVisibility(8);
        }
    }

    /* renamed from: android.support.v4.widget.ContentLoadingProgressBar.2 */
    class C01072 implements Runnable {
        final /* synthetic */ ContentLoadingProgressBar f1006a;

        C01072(ContentLoadingProgressBar contentLoadingProgressBar) {
            this.f1006a = contentLoadingProgressBar;
        }

        public void run() {
            this.f1006a.f1009c = false;
            if (!this.f1006a.f1010d) {
                this.f1006a.f1007a = System.currentTimeMillis();
                this.f1006a.setVisibility(0);
            }
        }
    }

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1007a = -1;
        this.f1008b = false;
        this.f1009c = false;
        this.f1010d = false;
        this.f1011e = new C01061(this);
        this.f1012f = new C01072(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m2047a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2047a();
    }

    private void m2047a() {
        removeCallbacks(this.f1011e);
        removeCallbacks(this.f1012f);
    }
}
