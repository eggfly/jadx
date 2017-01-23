package com.antutu.benchmark.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;

public class SettingTextAndToggle extends LinearLayout {
    private Context f5868a;
    private TextView f5869b;
    private TextView f5870c;
    private SwitchCompat f5871d;
    private String f5872e;
    private String f5873f;

    public SettingTextAndToggle(Context context) {
        super(context);
    }

    public SettingTextAndToggle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingTextAndToggle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5868a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1082R.styleable.SettingTextAndToggle, i, 0);
        this.f5872e = obtainStyledAttributes.getString(0);
        this.f5873f = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        m6478a();
    }

    private void m6478a() {
        LayoutInflater.from(this.f5868a).inflate(C1082R.layout.customview_setting_text_toggle, this);
        this.f5869b = (TextView) findViewById(C1082R.id.tv_title);
        this.f5870c = (TextView) findViewById(C1082R.id.tv_subhead);
        this.f5871d = (SwitchCompat) findViewById(C1082R.id.ss_toggle);
        this.f5869b.setText(this.f5872e);
        this.f5870c.setText(this.f5873f);
    }

    public void setSlideListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f5871d.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setState(boolean z) {
        this.f5871d.setChecked(z);
    }
}
