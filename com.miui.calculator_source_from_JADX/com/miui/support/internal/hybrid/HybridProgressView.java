package com.miui.support.internal.hybrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.miui.support.internal.C0264R;

public class HybridProgressView extends ImageView {
    private int f2454a;
    private int f2455b;
    private int f2456c;
    private Rect f2457d;
    private Handler f2458e;
    private Context f2459f;
    private Drawable f2460g;
    private Rect f2461h;

    /* renamed from: com.miui.support.internal.hybrid.HybridProgressView.1 */
    class C02831 extends Handler {
        final /* synthetic */ HybridProgressView f2453a;

        C02831(HybridProgressView hybridProgressView) {
            this.f2453a = hybridProgressView;
        }

        public void handleMessage(Message message) {
            if (message.what != 42) {
                return;
            }
            if (this.f2453a.f2454a < this.f2453a.f2455b) {
                this.f2453a.f2454a = Math.min(this.f2453a.f2455b, this.f2453a.f2454a + this.f2453a.f2456c);
                this.f2453a.f2457d.right = (this.f2453a.getWidth() * this.f2453a.f2454a) / 10000;
                this.f2453a.invalidate();
                sendMessageDelayed(this.f2453a.f2458e.obtainMessage(42), 40);
            } else if (this.f2453a.f2454a <= 9500 && this.f2453a.f2454a >= 800) {
                this.f2453a.f2454a = this.f2453a.f2454a + 30;
                this.f2453a.f2457d.right = (this.f2453a.getWidth() * this.f2453a.f2454a) / 10000;
                this.f2453a.invalidate();
                sendMessageDelayed(this.f2453a.f2458e.obtainMessage(42), 40);
            }
        }
    }

    public HybridProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4054a(context);
    }

    public HybridProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4054a(context);
    }

    public HybridProgressView(Context context) {
        super(context);
        m4054a(context);
    }

    private void m4054a(Context context) {
        this.f2459f = context;
        this.f2457d = new Rect(0, 0, 0, 0);
        this.f2454a = 0;
        this.f2455b = 0;
        this.f2460g = this.f2459f.getResources().getDrawable(C0264R.drawable.hybrid_progress_reverse);
        this.f2458e = new C02831(this);
        this.f2461h = new Rect(0, 0, 0, 0);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2457d.left = 0;
        this.f2457d.right = ((i3 - i) * this.f2454a) / 10000;
        this.f2457d.top = 0;
        this.f2457d.bottom = i4 - i2;
    }

    public void setProgress(int i) {
        int i2 = i * 100;
        if (this.f2455b <= 800) {
            this.f2454a = this.f2455b;
        }
        this.f2455b = i2;
        this.f2456c = (this.f2455b - this.f2454a) / 10;
        this.f2458e.removeMessages(42);
        this.f2458e.sendEmptyMessage(42);
    }

    public int getMax() {
        return 100;
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        drawable.setBounds(this.f2457d);
        drawable.draw(canvas);
        float width = ((float) getWidth()) - ((((float) getWidth()) * ((float) this.f2454a)) / 10000.0f);
        canvas.save();
        canvas.translate(-width, 0.0f);
        this.f2461h.set(0, 0, getWidth(), getHeight());
        this.f2460g.setBounds(this.f2461h);
        this.f2460g.draw(canvas);
        canvas.translate(width, 0.0f);
        canvas.restore();
    }
}
