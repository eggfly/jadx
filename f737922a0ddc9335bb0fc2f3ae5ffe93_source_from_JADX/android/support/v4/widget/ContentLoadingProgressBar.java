package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private boolean DW;
    private boolean FH;
    private boolean Hw;
    private final Runnable Zo;
    private long j6;
    private final Runnable v5;

    class 1 implements Runnable {
        final /* synthetic */ ContentLoadingProgressBar j6;

        1(ContentLoadingProgressBar contentLoadingProgressBar) {
            this.j6 = contentLoadingProgressBar;
        }

        public void run() {
            this.j6.DW = false;
            this.j6.j6 = -1;
            this.j6.setVisibility(8);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ ContentLoadingProgressBar j6;

        2(ContentLoadingProgressBar contentLoadingProgressBar) {
            this.j6 = contentLoadingProgressBar;
        }

        public void run() {
            this.j6.FH = false;
            if (!this.j6.Hw) {
                this.j6.j6 = System.currentTimeMillis();
                this.j6.setVisibility(0);
            }
        }
    }

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.j6 = -1;
        this.DW = false;
        this.FH = false;
        this.Hw = false;
        this.v5 = new 1(this);
        this.Zo = new 2(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j6();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j6();
    }

    private void j6() {
        removeCallbacks(this.v5);
        removeCallbacks(this.Zo);
    }
}
