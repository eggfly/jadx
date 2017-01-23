package com.miui.calculator.relationship;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.miui.calculator.common.BaseActivity;
import com.miui.calculator.common.utils.AssetReader;
import com.miui.calculator.common.widget.NumberPad;
import com.miui.calculator.common.widget.NumberPad.OnNumberClickListener;
import com.miui.support.internal.C0264R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class RelationshipActivity extends BaseActivity {
    private Context f1755a;
    private NumberPad f1756b;
    private TextView f1757c;
    private TextView f1758d;
    private TextView f1759e;
    private RelationshipCalculator f1760f;
    private String f1761g;
    private boolean f1762h;
    private int f1763i;
    private double f1764j;
    private int f1765k;
    private List<String> f1766l;
    private OnNumberClickListener f1767m;

    /* renamed from: com.miui.calculator.relationship.RelationshipActivity.1 */
    class C02121 implements OnNumberClickListener {
        final /* synthetic */ RelationshipActivity f1753a;

        C02121(RelationshipActivity relationshipActivity) {
            this.f1753a = relationshipActivity;
        }

        public void m3104a(NumberPad numberPad, int i) {
            try {
                this.f1753a.m3111a(numberPad, i);
                if (this.f1753a.f1765k == 0) {
                    this.f1753a.m3125g();
                    int dimensionPixelSize = this.f1753a.getResources().getDimensionPixelSize(C0264R.dimen.cal_primary_min);
                    this.f1753a.f1756b;
                    if (i == C0264R.id.btn_equal) {
                        if (this.f1753a.f1758d.getTextSize() <= ((float) dimensionPixelSize)) {
                            int dimensionPixelSize2 = this.f1753a.getResources().getDimensionPixelSize(C0264R.dimen.cal_secondary);
                            if (this.f1753a.f1758d.getTextSize() == ((float) dimensionPixelSize)) {
                                this.f1753a.f1758d.setTextSize(0, (float) dimensionPixelSize2);
                            } else if (this.f1753a.f1758d.getTextSize() > ((float) dimensionPixelSize2)) {
                                this.f1753a.f1758d.setTextSize(0, (float) dimensionPixelSize2);
                            }
                        }
                        this.f1753a.m3126h();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private class LoadDataAsyncTask extends AsyncTask<String, Integer, String> {
        final /* synthetic */ RelationshipActivity f1754a;

        private LoadDataAsyncTask(RelationshipActivity relationshipActivity) {
            this.f1754a = relationshipActivity;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3105a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m3106a((String) obj);
        }

        protected String m3105a(String... strArr) {
            this.f1754a.f1760f = new RelationshipCalculator(AssetReader.m2800a(this.f1754a.f1755a, "default_data/data.json"), AssetReader.m2800a(this.f1754a.f1755a, "default_data/filter.json"));
            return null;
        }

        protected void m3106a(String str) {
            super.onPostExecute(str);
            this.f1754a.f1756b.setOnNumberClickListener(this.f1754a.f1767m);
        }
    }

    public RelationshipActivity() {
        this.f1763i = -1;
        this.f1766l = new ArrayList();
        this.f1767m = new C02121(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.relationship_activity);
        this.f1755a = this;
        m3121d();
        new LoadDataAsyncTask().execute(new String[]{""});
    }

    private void m3121d() {
        setTitle(getString(C0264R.string.item_title_relationship));
        this.f1761g = "\u6211";
        this.f1765k = 0;
        this.f1764j = 2.0d;
        this.f1757c = (TextView) findViewById(C0264R.id.text_view_result);
        this.f1758d = (TextView) findViewById(C0264R.id.text_view_input);
        this.f1756b = (NumberPad) findViewById(C0264R.id.nbp_pad);
        this.f1758d.setSingleLine(false);
        this.f1758d.setText(this.f1761g);
        this.f1756b.setPadType(7);
        this.f1757c.setTextColor(Color.argb(153, 0, 0, 0));
        this.f1759e = (TextView) this.f1756b.findViewById(C0264R.id.relationship_btn_cross_check);
    }

    private void m3125g() {
        int length = this.f1761g.length();
        int width = ((this.f1758d.getWidth() - this.f1758d.getPaddingStart()) - this.f1758d.getPaddingEnd()) - (length * 3);
        float dimensionPixelSize = (float) (getResources().getDimensionPixelSize(C0264R.dimen.cal_primary_min) + 1);
        double measureText;
        do {
            dimensionPixelSize -= 1.0f;
            this.f1758d.setTextSize(0, dimensionPixelSize);
            measureText = ((double) (this.f1758d.getPaint().measureText(this.f1761g) / ((float) length))) * Math.ceil(((double) length) / this.f1764j);
            if (width <= 0) {
                return;
            }
        } while (measureText >= ((double) width));
    }

    private void m3126h() {
        int length = this.f1757c.getText().length();
        int width = ((this.f1757c.getWidth() - this.f1757c.getPaddingStart()) - this.f1757c.getPaddingEnd()) - (length * 3);
        float dimensionPixelSize = (float) (getResources().getDimensionPixelSize(C0264R.dimen.cal_primary_min) + 1);
        while (true) {
            float f = dimensionPixelSize - 1.0f;
            this.f1757c.setTextSize(0, f);
            double measureText = ((double) (this.f1757c.getPaint().measureText((String) this.f1757c.getText()) / ((float) length))) * Math.ceil(((double) length) / 2.0d);
            if (width > 0 && measureText >= ((double) width)) {
                dimensionPixelSize = f;
            } else {
                return;
            }
        }
    }

    private void m3111a(NumberPad numberPad, int i) {
        boolean z = true;
        if (this.f1765k != 1 || i == C0264R.id.btn_equal) {
            if (this.f1760f.m3144a(i)) {
                m3110a(i);
                return;
            }
            this.f1761g += "\u7684" + NumberPad.m2910b(i);
            m3130l();
        } else if (i == C0264R.id.relationship_btn_cross_check) {
            if (this.f1762h) {
                z = false;
            }
            this.f1762h = z;
            String str = "";
            if (this.f1766l.size() > 0) {
                str = (String) this.f1766l.get(this.f1766l.size() - 1);
            }
            if (!this.f1762h) {
                this.f1765k = 0;
                this.f1756b.m2924b(false);
            }
            m3117b(this.f1761g, str);
        } else {
            m3115b(numberPad, i);
        }
    }

    private String m3109a(String str, int i, boolean z) {
        List a = this.f1760f.m3143a(str, i, z);
        if (a == null) {
            this.f1756b.m2923a(false);
            if (this.f1760f.f1769a == 1) {
                return getString(C0264R.string.gay_search_result);
            }
            if (this.f1760f.f1769a == 2) {
                return getString(C0264R.string.lesbian_search_result);
            }
            return getString(C0264R.string.gay_other_search_result);
        }
        String str2 = "";
        if (a.size() > 0) {
            this.f1760f.f1769a = 0;
            this.f1756b.m2923a(true);
            String str3 = str2;
            int i2 = false;
            while (i2 < a.size() - 1) {
                String str4 = str3 + ((String) a.get(i2)) + "/";
                i2++;
                str3 = str4;
            }
            return str3 + ((String) a.get(a.size() - 1));
        }
        this.f1760f.f1769a = 4;
        this.f1756b.m2923a(false);
        return getText(C0264R.string.far_relationship_result).toString();
    }

    private void m3115b(NumberPad numberPad, int i) {
        this.f1761g = "\u6211";
        m3132a(this.f1761g, "");
        this.f1765k = 0;
        this.f1762h = !this.f1762h;
        this.f1766l.clear();
        m3111a(numberPad, i);
        if (!this.f1762h) {
            this.f1756b.m2924b(false);
        }
    }

    private void m3110a(int i) {
        switch (i) {
            case C0264R.id.relationship_btn_cross_check /*2131689646*/:
                m3129k();
            case C0264R.id.btn_c /*2131689698*/:
                m3127i();
            case C0264R.id.btn_del /*2131689700*/:
                m3113a(true);
            case C0264R.id.btn_equal /*2131689707*/:
                m3128j();
            default:
        }
    }

    private void m3127i() {
        m3113a(false);
        if (this.f1760f.f1769a != 0) {
            this.f1756b.m2923a(true);
            this.f1760f.f1769a = 0;
        }
        this.f1766l.clear();
    }

    private void m3128j() {
        if (!TextUtils.isEmpty(this.f1757c.getText())) {
            m3133c();
        }
        if (this.f1760f.f1769a != 0) {
            this.f1756b.m2924b(false);
        } else {
            this.f1756b.m2924b(true);
        }
    }

    private void m3129k() {
        this.f1762h = !this.f1762h;
        if (this.f1762h) {
            this.f1765k = 1;
            if (this.f1761g.length() > 1) {
                m3130l();
                return;
            }
            return;
        }
        this.f1765k = 0;
        this.f1756b.m2924b(false);
        m3130l();
    }

    private void m3113a(boolean z) {
        String str = "";
        if (z) {
            if (this.f1761g.length() >= 4) {
                this.f1761g = this.f1761g.substring(0, this.f1761g.lastIndexOf("\u7684"));
                this.f1766l.remove(this.f1766l.size() - 1);
                if (this.f1766l.size() > 0) {
                    str = (String) this.f1766l.get(this.f1766l.size() - 1);
                }
            }
            if (this.f1760f.f1769a != 0) {
                this.f1760f.f1769a = 0;
                this.f1756b.m2923a(true);
            }
        } else {
            this.f1761g = "\u6211";
        }
        m3132a(this.f1761g, str);
    }

    private String m3114b(String str) {
        return str.substring(2, str.length());
    }

    private void m3130l() {
        String a = m3109a(m3114b(this.f1761g), this.f1763i, this.f1762h);
        if (this.f1765k != 1) {
            this.f1766l.add(a);
        }
        if (this.f1765k == 1) {
            m3117b("", a);
        } else {
            m3132a(this.f1761g, a);
        }
    }

    protected void m3132a(String str, String str2) {
        m3131a(str);
        m3119c(str2);
    }

    protected void m3133c() {
        this.f1757c.setTextColor(getResources().getColor(C0264R.color.cal_result));
        this.f1758d.setTextColor(getResources().getColor(C0264R.color.cal_history));
    }

    protected void m3131a(String str) {
        this.f1758d.setText(str);
        this.f1758d.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_primary_min));
        this.f1758d.setTextColor(getResources().getColor(C0264R.color.cal_result));
    }

    private void m3119c(String str) {
        this.f1757c.setText(str);
        this.f1757c.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_secondary));
        this.f1757c.setTextColor(getResources().getColor(C0264R.color.cal_history));
    }

    private void m3117b(String str, String str2) {
        this.f1757c.setText(str2);
        if (this.f1765k == 1) {
            this.f1758d.setText(getString(C0264R.string.relationship_cross_check_suggestion));
            this.f1758d.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_secondary));
            this.f1758d.setTextColor(getResources().getColor(C0264R.color.cal_history));
            this.f1757c.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_primary_min));
            this.f1757c.setTextColor(getResources().getColor(C0264R.color.cal_result));
            return;
        }
        this.f1758d.setText(str);
        this.f1758d.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_primary_min));
        this.f1758d.setTextColor(getResources().getColor(C0264R.color.cal_result));
        this.f1757c.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.cal_secondary));
        this.f1757c.setTextColor(getResources().getColor(C0264R.color.cal_history));
    }
}
