package com.miui.calculator.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.support.internal.C0264R;

public class OptionItemView extends LinearLayout {
    private TextView f1569a;
    private TextView f1570b;

    public OptionItemView(Context context) {
        this(context, null);
    }

    public OptionItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OptionItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.option_item_view, this, true);
        this.f1569a = (TextView) inflate.findViewById(C0264R.id.txv_title);
        this.f1570b = (TextView) inflate.findViewById(C0264R.id.txv_summary);
    }

    public void setTitle(int i) {
        this.f1569a.setText(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1569a.setText(charSequence);
    }

    public void setSummary(String str) {
        this.f1570b.setText(str);
    }

    public CharSequence getSummary() {
        return this.f1570b.getText();
    }
}
