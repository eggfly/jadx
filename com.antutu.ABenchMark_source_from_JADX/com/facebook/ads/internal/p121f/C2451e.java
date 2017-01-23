package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/* renamed from: com.facebook.ads.internal.f.e */
public class C2451e extends LinearLayout {
    private Bitmap f8456a;
    private Bitmap f8457b;
    private ImageView f8458c;
    private ImageView f8459d;
    private ImageView f8460e;
    private Bitmap f8461f;
    private int f8462g;
    private int f8463h;

    public C2451e(Context context) {
        super(context);
        m9346b();
    }

    private void m9345a() {
        if (getHeight() > 0) {
            this.f8463h = m9347c();
            this.f8462g = (int) Math.ceil((double) (((float) (getHeight() - this.f8463h)) / 2.0f));
            Matrix matrix = new Matrix();
            matrix.preScale(1.0f, -1.0f);
            int floor = (int) Math.floor((double) (((float) (getHeight() - this.f8463h)) / 2.0f));
            float height = ((float) this.f8456a.getHeight()) / ((float) this.f8463h);
            int min = Math.min(Math.round(((float) this.f8462g) * height), this.f8457b.getHeight());
            if (min > 0) {
                this.f8461f = Bitmap.createBitmap(this.f8457b, 0, 0, this.f8457b.getWidth(), min, matrix, true);
                this.f8458c.setImageBitmap(this.f8461f);
            }
            min = Math.min(Math.round(((float) floor) * height), this.f8457b.getHeight());
            if (min > 0) {
                this.f8460e.setImageBitmap(Bitmap.createBitmap(this.f8457b, 0, this.f8457b.getHeight() - min, this.f8457b.getWidth(), min, matrix, true));
            }
        }
    }

    private void m9346b() {
        getContext().getResources().getDisplayMetrics();
        setOrientation(1);
        this.f8458c = new ImageView(getContext());
        this.f8458c.setScaleType(ScaleType.FIT_XY);
        addView(this.f8458c);
        this.f8459d = new ImageView(getContext());
        this.f8459d.setLayoutParams(new LayoutParams(-1, -1));
        this.f8459d.setScaleType(ScaleType.FIT_CENTER);
        addView(this.f8459d);
        this.f8460e = new ImageView(getContext());
        this.f8460e.setScaleType(ScaleType.FIT_XY);
        addView(this.f8460e);
    }

    private int m9347c() {
        return (int) Math.round(((double) getWidth()) / 1.91d);
    }

    public void m9348a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            this.f8459d.setImageDrawable(null);
            return;
        }
        this.f8459d.setImageBitmap(Bitmap.createBitmap(bitmap));
        this.f8456a = bitmap;
        this.f8457b = bitmap2;
        m9345a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f8456a == null || this.f8457b == null) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int c = m9347c();
        if (this.f8461f == null || this.f8463h != c) {
            m9345a();
        }
        this.f8458c.layout(i, i2, i3, this.f8462g);
        this.f8459d.layout(i, this.f8462g + i2, i3, this.f8462g + this.f8463h);
        this.f8460e.layout(i, (this.f8462g + i2) + this.f8463h, i3, i4);
    }
}
