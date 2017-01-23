package com.miui.calculator.common.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class SuffixNumberInput extends LinearLayout {
    private static final String f1576a;
    private TextView f1577b;
    private EditText f1578c;
    private int f1579d;
    private OnTextChangedListener f1580e;
    private TextWatcher f1581f;
    private OnFocusChangeListener f1582g;

    /* renamed from: com.miui.calculator.common.widget.SuffixNumberInput.1 */
    class C01781 implements TextWatcher {
        final /* synthetic */ SuffixNumberInput f1573a;
        private int f1574b;

        C01781(SuffixNumberInput suffixNumberInput) {
            this.f1573a = suffixNumberInput;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f1574b = i3;
        }

        public void afterTextChanged(Editable editable) {
            Object obj;
            String obj2 = editable.toString();
            double d = 0.0d;
            if (TextUtils.isEmpty(obj2)) {
                int i = 1;
            } else {
                try {
                    d = Double.parseDouble(obj2);
                    obj = 1;
                } catch (Exception e) {
                    obj = null;
                }
                if (obj != null) {
                    String b = NumberFormatUtils.m2877b(d, 2);
                    if (Double.parseDouble(b) - d < -1.0E-6d || b.length() < obj2.length()) {
                        obj = null;
                    }
                }
            }
            if (obj == null) {
                if (this.f1574b != 1) {
                    this.f1573a.f1578c.setText(NumberFormatUtils.m2882c(d, 2));
                } else {
                    editable.delete(editable.length() - 1, editable.length());
                }
            }
            if (this.f1573a.f1580e != null) {
                this.f1573a.f1580e.m2926a();
            }
        }
    }

    /* renamed from: com.miui.calculator.common.widget.SuffixNumberInput.2 */
    class C01792 implements OnFocusChangeListener {
        final /* synthetic */ SuffixNumberInput f1575a;

        C01792(SuffixNumberInput suffixNumberInput) {
            this.f1575a = suffixNumberInput;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                if ((this.f1575a.f1579d == 5 || this.f1575a.f1579d == 4) && TextUtils.isEmpty(this.f1575a.f1578c.getText())) {
                    this.f1575a.f1578c.setText(this.f1575a.f1578c.getHint());
                }
            }
        }
    }

    public interface OnTextChangedListener {
        void m2926a();
    }

    static {
        f1576a = NumberFormatUtils.m2877b(1.0d, 1);
    }

    public SuffixNumberInput(Context context) {
        this(context, null);
    }

    public SuffixNumberInput(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SuffixNumberInput(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1581f = new C01781(this);
        this.f1582g = new C01792(this);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.suffix_number_input, this, true);
        this.f1577b = (TextView) inflate.findViewById(C0264R.id.txv_unit);
        this.f1578c = (EditText) inflate.findViewById(C0264R.id.edt_text);
        this.f1578c.addTextChangedListener(this.f1581f);
        this.f1578c.setOnFocusChangeListener(this.f1582g);
    }

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.f1580e = onTextChangedListener;
    }

    public void setType(int i) {
        this.f1579d = i;
        m2928a();
    }

    private void m2928a() {
        switch (this.f1579d) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                this.f1577b.setText(C0264R.string.unit_myriads);
                if (this.f1579d == 3) {
                    this.f1578c.setHint(C0264R.string.mortgage_hint_accumulation_fund);
                } else if (this.f1579d == 2) {
                    this.f1578c.setHint(C0264R.string.mortgage_hint_commercial);
                } else {
                    this.f1578c.setHint(C0264R.string.mortgage_hint_loan);
                }
                this.f1578c.setGravity(8388611);
                return;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                this.f1577b.setText(C0264R.string.unit_times);
                this.f1578c.setGravity(17);
                this.f1578c.setHint(f1576a);
                return;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                this.f1578c.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.tax_si_text_size));
                this.f1577b.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.tax_si_text_size));
                this.f1578c.setTextColor(getResources().getColor(C0264R.color.tax_si_text));
                this.f1578c.setGravity(8388613);
                getChildAt(0).setBackgroundResource(C0264R.drawable.edt_si);
                break;
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                this.f1577b.setVisibility(8);
                this.f1578c.setHint(C0264R.string.tax_fixed_salary_hint);
                this.f1578c.setInputType(2);
                return;
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                this.f1577b.setVisibility(8);
                this.f1578c.setHint(C0264R.string.tax_annual_bonus_hint);
                this.f1578c.setInputType(2);
                return;
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                this.f1577b.setVisibility(8);
                this.f1578c.setHint(C0264R.string.tax_last_salary_hint);
                this.f1578c.setInputType(2);
                return;
            default:
                return;
        }
        this.f1577b.setText(C0264R.string.unit_percentage);
        this.f1578c.setGravity(17);
    }

    public void setError(int i) {
        this.f1578c.setError(getResources().getString(i));
    }

    public void setText(String str) {
        this.f1578c.setText(str);
    }

    public void setHint(String str) {
        this.f1578c.setHint(str);
    }

    public String getText() {
        String obj = this.f1578c.getText().toString();
        if ((this.f1579d == 5 || this.f1579d == 4) && TextUtils.isEmpty(obj)) {
            return f1576a;
        }
        return obj;
    }
}
