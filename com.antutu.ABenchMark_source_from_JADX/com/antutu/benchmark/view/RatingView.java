package com.antutu.benchmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.antutu.ABenchMark.C1082R;

public class RatingView extends LinearLayout implements OnClickListener {
    private Context f5858a;
    private boolean f5859b;
    private int f5860c;
    private ImageView f5861d;
    private ImageView f5862e;
    private ImageView f5863f;
    private ImageView f5864g;
    private ImageView f5865h;
    private ImageView[] f5866i;
    private C1442a f5867j;

    /* renamed from: com.antutu.benchmark.view.RatingView.a */
    public interface C1442a {
        void m5676a(int i);
    }

    public RatingView(Context context) {
        super(context);
        this.f5858a = null;
        this.f5859b = false;
        this.f5866i = new ImageView[5];
        m6474a(context, null, 0);
    }

    public RatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5858a = null;
        this.f5859b = false;
        this.f5866i = new ImageView[5];
        m6474a(context, attributeSet, 0);
    }

    public RatingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5858a = null;
        this.f5859b = false;
        this.f5866i = new ImageView[5];
        m6474a(context, attributeSet, i);
    }

    private void m6474a(Context context, AttributeSet attributeSet, int i) {
        this.f5858a = context;
        View.inflate(context, C1082R.layout.view_rating, this);
        m6476c();
        m6475b();
    }

    private void m6475b() {
        this.f5861d.setOnClickListener(this);
        this.f5862e.setOnClickListener(this);
        this.f5863f.setOnClickListener(this);
        this.f5864g.setOnClickListener(this);
        this.f5865h.setOnClickListener(this);
    }

    private void m6476c() {
        this.f5861d = (ImageView) findViewById(C1082R.id.leve1);
        this.f5862e = (ImageView) findViewById(C1082R.id.leve2);
        this.f5863f = (ImageView) findViewById(C1082R.id.leve3);
        this.f5864g = (ImageView) findViewById(C1082R.id.leve4);
        this.f5865h = (ImageView) findViewById(C1082R.id.leve5);
        this.f5866i[0] = this.f5861d;
        this.f5866i[1] = this.f5862e;
        this.f5866i[2] = this.f5863f;
        this.f5866i[3] = this.f5864g;
        this.f5866i[4] = this.f5865h;
    }

    public void m6477a() {
        for (ImageView imageResource : this.f5866i) {
            imageResource.setImageResource(C1082R.drawable.star_gray);
        }
        this.f5860c = 0;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.leve1 /*2131624591*/:
                setLevel(1);
            case C1082R.id.leve2 /*2131624592*/:
                setLevel(2);
            case C1082R.id.leve3 /*2131624593*/:
                setLevel(3);
            case C1082R.id.leve4 /*2131624594*/:
                setLevel(4);
            case C1082R.id.leve5 /*2131624595*/:
                setLevel(5);
            default:
        }
    }

    public void setCanRate(boolean z) {
        this.f5859b = z;
    }

    public void setLevel(int i) {
        if (this.f5859b && i >= 1 && i <= this.f5866i.length && i != this.f5860c) {
            for (int i2 = 0; i2 < this.f5866i.length; i2++) {
                if (i2 + 1 > i) {
                    this.f5866i[i2].setImageResource(C1082R.drawable.star_gray);
                } else {
                    this.f5866i[i2].setImageResource(C1082R.drawable.star_black);
                }
            }
            this.f5860c = i;
            if (this.f5867j != null) {
                this.f5867j.m5676a(i);
            }
        }
    }

    public void setOnRateChangeListener(C1442a c1442a) {
        this.f5867j = c1442a;
    }
}
