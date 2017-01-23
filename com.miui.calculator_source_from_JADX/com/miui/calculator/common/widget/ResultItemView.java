package com.miui.calculator.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.miui.support.internal.C0264R;

public class ResultItemView extends LinearLayout {
    private TextView f1571a;
    private TextView f1572b;

    public ResultItemView(Context context) {
        this(context, null);
    }

    public ResultItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResultItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.result_item_view, this, true);
        this.f1571a = (TextView) inflate.findViewById(C0264R.id.txv_title);
        this.f1572b = (TextView) inflate.findViewById(C0264R.id.txv_summary);
        View view = new View(context);
        view.setLayoutParams(new LayoutParams(-1, 1));
        view.setBackgroundColor(getResources().getColor(C0264R.color.divider_item));
        addView(view);
    }

    public void setTitle(int i) {
        this.f1571a.setText(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1571a.setText(charSequence);
    }

    public void setSummary(String str) {
        this.f1572b.setText(str);
    }
}
