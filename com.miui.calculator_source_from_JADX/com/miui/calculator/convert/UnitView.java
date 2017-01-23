package com.miui.calculator.convert;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class UnitView extends RelativeLayout {
    private TextView f1621a;
    private TextView f1622b;
    private TextView f1623c;
    private ImageView f1624d;
    private OnItemClickListener f1625e;
    private OnClickListener f1626f;

    public interface OnItemClickListener {
        void m2934a(UnitView unitView, int i);
    }

    /* renamed from: com.miui.calculator.convert.UnitView.1 */
    class C01911 implements OnClickListener {
        final /* synthetic */ UnitView f1620a;

        C01911(UnitView unitView) {
            this.f1620a = unitView;
        }

        public void onClick(View view) {
            int i;
            switch (view.getId()) {
                case C0264R.id.lyt_unit /*2131689565*/:
                case C0264R.id.txv_unit_display /*2131689567*/:
                    i = 1;
                    break;
                default:
                    i = 2;
                    break;
            }
            if (this.f1620a.f1625e != null) {
                this.f1620a.f1625e.m2934a(this.f1620a, i);
            }
        }
    }

    public UnitView(Context context) {
        this(context, null);
    }

    public UnitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1626f = new C01911(this);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.layout_unit, this, true);
        this.f1621a = (TextView) findViewById(C0264R.id.txv_unit_display);
        this.f1622b = (TextView) findViewById(C0264R.id.txv_value);
        this.f1623c = (TextView) findViewById(C0264R.id.txv_unit_short);
        this.f1624d = (ImageView) findViewById(C0264R.id.img_unit_icon);
        findViewById(C0264R.id.lyt_unit).setOnClickListener(this.f1626f);
        findViewById(C0264R.id.lyt_value).setOnClickListener(this.f1626f);
        this.f1621a.setOnClickListener(this.f1626f);
        this.f1622b.setOnClickListener(this.f1626f);
        this.f1623c.setOnClickListener(this.f1626f);
    }

    public void setOnItemClickListner(OnItemClickListener onItemClickListener) {
        this.f1625e = onItemClickListener;
    }

    public void m2977a(String str, String str2) {
        this.f1621a.setText(str);
        this.f1623c.setText(str2);
    }

    public void setUnitIcon(int i) {
        if (i <= 0 || CalculatorUtils.m2821b()) {
            this.f1624d.setVisibility(8);
            return;
        }
        this.f1624d.setVisibility(0);
        this.f1624d.setBackgroundResource(i);
    }

    public void setValue(String str) {
        this.f1622b.setText(str);
        CalculatorUtils.m2815a(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.convert_value_size), this.f1622b);
    }

    public void m2976a(int i, boolean z) {
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (z) {
                    this.f1621a.setTextColor(getResources().getColor(C0264R.color.convert_high_light));
                } else {
                    this.f1621a.setTextColor(getResources().getColor(C0264R.color.convert_unit_display));
                }
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (z) {
                    this.f1622b.setTextColor(getResources().getColor(C0264R.color.convert_high_light));
                } else {
                    this.f1622b.setTextColor(getResources().getColor(C0264R.color.convert_unit_value));
                }
            default:
        }
    }
}
