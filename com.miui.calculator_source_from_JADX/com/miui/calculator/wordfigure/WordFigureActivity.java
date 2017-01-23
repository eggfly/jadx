package com.miui.calculator.wordfigure;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.miui.calculator.cal.ResultTextView;
import com.miui.calculator.cal.ResultTextView.PopupMenuCallback;
import com.miui.calculator.common.BaseActivity;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.utils.NumberFormatUtils;
import com.miui.calculator.common.widget.NumberPad;
import com.miui.calculator.common.widget.NumberPad.OnNumberClickListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.HashMap;

public class WordFigureActivity extends BaseActivity {
    private NumberPad f1897a;
    private TextView f1898b;
    private ResultTextView f1899c;
    private String f1900d;
    private OnNumberClickListener f1901e;
    private PopupMenuCallback f1902f;

    /* renamed from: com.miui.calculator.wordfigure.WordFigureActivity.1 */
    class C02321 implements OnNumberClickListener {
        final /* synthetic */ WordFigureActivity f1895a;

        C02321(WordFigureActivity wordFigureActivity) {
            this.f1895a = wordFigureActivity;
        }

        public void m3240a(NumberPad numberPad, int i) {
            int lastIndexOf = this.f1895a.f1900d.lastIndexOf(46);
            if (lastIndexOf == -1 || lastIndexOf >= this.f1895a.f1900d.length() - 2 || !NumberPad.m2909a(i)) {
                this.f1895a.m3245a(numberPad.m2921a(this.f1895a.f1900d, i, true));
            }
        }
    }

    /* renamed from: com.miui.calculator.wordfigure.WordFigureActivity.2 */
    class C02332 implements PopupMenuCallback {
        final /* synthetic */ WordFigureActivity f1896a;

        C02332(WordFigureActivity wordFigureActivity) {
            this.f1896a = wordFigureActivity;
        }

        public void m3242a(HashMap<Integer, String> hashMap) {
            hashMap.put(Integer.valueOf(1), this.f1896a.getString(C0264R.string.cal_copy));
        }

        public void m3241a(int i) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    CalculatorUtils.m2818a(this.f1896a.getApplicationContext(), this.f1896a.f1899c.getText());
                default:
            }
        }
    }

    public WordFigureActivity() {
        this.f1900d = "0";
        this.f1901e = new C02321(this);
        this.f1902f = new C02332(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.word_figure_activity);
        m3247c();
    }

    private void m3247c() {
        this.f1897a = (NumberPad) findViewById(C0264R.id.nbp_pad);
        this.f1897a.setOnNumberClickListener(this.f1901e);
        this.f1897a.setPadType(1);
        this.f1898b = (TextView) findViewById(C0264R.id.txv_number);
        this.f1899c = (ResultTextView) findViewById(C0264R.id.txv_word_figure);
        this.f1899c.setSingleLine(false);
        this.f1899c.setGravity(21);
        this.f1899c.m2786a(true);
        this.f1899c.setPopupMenuCallback(this.f1902f);
        m3245a("0");
    }

    private void m3245a(String str) {
        String d = NumberFormatUtils.m2886d(str);
        if (d != null) {
            Resources resources = getResources();
            this.f1900d = str;
            this.f1898b.setText(this.f1900d);
            this.f1899c.setText(d);
            int length = d.length();
            int width = ((this.f1899c.getWidth() - this.f1899c.getPaddingStart()) - this.f1899c.getPaddingEnd()) - (length * 3);
            float dimensionPixelSize = (float) (resources.getDimensionPixelSize(C0264R.dimen.wf_word_size_normal) + 1);
            double measureText;
            do {
                dimensionPixelSize -= 1.0f;
                this.f1899c.setTextSize(0, dimensionPixelSize);
                measureText = ((double) (this.f1899c.getPaint().measureText(d) / ((float) length))) * Math.ceil(((double) length) / 2.0d);
                if (width <= 0) {
                    break;
                }
            } while (measureText >= ((double) width));
            int width2 = (this.f1898b.getWidth() - this.f1898b.getPaddingStart()) - this.f1898b.getPaddingEnd();
            dimensionPixelSize = (float) (resources.getDimensionPixelSize(C0264R.dimen.wf_number_size_normal) + 1);
            float measureText2;
            do {
                dimensionPixelSize -= 1.0f;
                this.f1898b.setTextSize(0, dimensionPixelSize);
                measureText2 = this.f1898b.getPaint().measureText(this.f1900d);
                if (width2 <= 0) {
                    return;
                }
            } while (measureText2 >= ((float) width2));
        }
    }
}
