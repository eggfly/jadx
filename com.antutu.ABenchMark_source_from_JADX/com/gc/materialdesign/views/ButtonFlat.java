package com.gc.materialdesign.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gc.materialdesign.C2513R;
import com.gc.materialdesign.p135a.C2514a;

public class ButtonFlat extends C2516a {
    TextView f8645n;

    public ButtonFlat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void m9526a() {
        this.b = 36;
        this.a = 88;
        this.e = 3;
        setMinimumHeight(C2514a.m9521a((float) this.b, getResources()));
        setMinimumWidth(C2514a.m9521a((float) this.a, getResources()));
        setBackgroundResource(C2513R.drawable.background_transparent);
    }

    protected int m9527b() {
        return Color.parseColor("#88DDDDDD");
    }

    public String getText() {
        return this.f8645n.getText().toString();
    }

    public TextView getTextView() {
        return this.f8645n;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k != -1.0f) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(m9527b());
            canvas.drawCircle(this.k, this.l, this.m, paint);
            if (this.m > ((float) (getHeight() / this.e))) {
                this.m += this.d;
            }
            if (this.m >= ((float) getWidth())) {
                this.k = -1.0f;
                this.l = -1.0f;
                this.m = (float) (getHeight() / this.e);
                if (this.g != null && this.h) {
                    this.g.onClick(this);
                }
            }
            invalidate();
        }
    }

    protected void setAttributes(AttributeSet attributeSet) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "text", -1);
        String string = attributeResourceValue != -1 ? getResources().getString(attributeResourceValue) : attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        if (string != null) {
            this.f8645n = new TextView(getContext());
            this.f8645n.setText(string.toUpperCase());
            this.f8645n.setTextColor(this.i);
            this.f8645n.setTypeface(null, 1);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            this.f8645n.setLayoutParams(layoutParams);
            addView(this.f8645n);
        }
        attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
        if (attributeResourceValue != -1) {
            setBackgroundColor(getResources().getColor(attributeResourceValue));
            return;
        }
        this.c = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "background", -1);
        if (this.c != -1) {
            setBackgroundColor(this.c);
        }
    }

    public void setBackgroundColor(int i) {
        this.i = i;
        if (isEnabled()) {
            this.p = this.i;
        }
        this.f8645n.setTextColor(i);
    }

    public void setText(String str) {
        this.f8645n.setText(str.toUpperCase());
    }
}
