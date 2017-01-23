package com.miui.calculator.tax;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.miui.calculator.common.utils.HanziToPinyin;
import com.miui.calculator.common.utils.HanziToPinyin.Token;
import com.miui.calculator.common.utils.LocationGetter;
import com.miui.calculator.tax.TaxRateGetter.CityTaxData;
import com.miui.support.app.Activity;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class CityPickerActivity extends Activity {
    private ListView f1786a;
    private CityAdapter f1787b;

    /* renamed from: com.miui.calculator.tax.CityPickerActivity.1 */
    class C02131 implements OnItemClickListener {
        final /* synthetic */ CityPickerActivity f1772a;

        C02131(CityPickerActivity cityPickerActivity) {
            this.f1772a = cityPickerActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CityItem a = this.f1772a.f1787b.m3156a(i);
            if (a.f1775a == 2 || a.f1775a == 3) {
                Intent intent = new Intent();
                intent.putExtra("result_city", a.f1776b);
                this.f1772a.setResult(-1, intent);
                this.f1772a.finish();
            }
        }
    }

    private static class CityAdapter extends BaseAdapter {
        private ArrayList<CityItem> f1783a;
        private Context f1784b;
        private LayoutInflater f1785c;

        /* renamed from: com.miui.calculator.tax.CityPickerActivity.CityAdapter.1 */
        class C02141 implements Comparator<String> {
            final /* synthetic */ HanziToPinyin f1773a;
            final /* synthetic */ CityAdapter f1774b;

            C02141(CityAdapter cityAdapter, HanziToPinyin hanziToPinyin) {
                this.f1774b = cityAdapter;
                this.f1773a = hanziToPinyin;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return m3145a((String) obj, (String) obj2);
            }

            public int m3145a(String str, String str2) {
                int i = 0;
                ArrayList a = this.f1773a.m2842a(str);
                ArrayList a2 = this.f1773a.m2842a(str2);
                ArrayList arrayList = a.size() < a2.size() ? a : a2;
                int i2 = 0;
                while (i2 < arrayList.size()) {
                    int compareTo = ((Token) a.get(i2)).f1527c.compareTo(((Token) a2.get(i2)).f1527c);
                    if (compareTo != 0) {
                        i = compareTo;
                        break;
                    }
                    i2++;
                    i = compareTo;
                }
                if (i == 0) {
                    return a.size() - a2.size();
                }
                return i;
            }
        }

        private static class CityItem {
            int f1775a;
            String f1776b;
            String f1777c;

            public CityItem(Context context, int i, String str) {
                this.f1775a = i;
                this.f1776b = str;
                this.f1777c = m3146a(context, str);
            }

            private String m3146a(Context context, String str) {
                return context != null ? str : str;
            }
        }

        private class ViewHolder {
            final /* synthetic */ CityAdapter f1778a;
            private TextView f1779b;
            private TextView f1780c;
            private ImageView f1781d;
            private LinearLayout f1782e;

            private ViewHolder(CityAdapter cityAdapter) {
                this.f1778a = cityAdapter;
            }
        }

        public /* synthetic */ Object getItem(int i) {
            return m3156a(i);
        }

        private CityAdapter(Context context) {
            this.f1784b = context;
            this.f1785c = (LayoutInflater) this.f1784b.getSystemService("layout_inflater");
            m3155a();
        }

        private void m3155a() {
            Object arrayList = new ArrayList();
            TaxRateGetter a = TaxRateGetter.m3208a(this.f1784b);
            if (!a.m3221c()) {
                a.m3222d();
            }
            ArrayList f = a.m3224f();
            for (int i = 0; i < f.size(); i++) {
                arrayList.add(((CityTaxData) f.get(i)).f1842a);
            }
            HanziToPinyin a2 = HanziToPinyin.m2839a();
            Collections.sort(arrayList, new C02141(this, a2));
            this.f1783a = new ArrayList();
            String str = "";
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String valueOf = String.valueOf(((Token) a2.m2842a(str2).get(0)).f1527c.toUpperCase().charAt(0));
                if (str.equals(valueOf)) {
                    valueOf = str;
                } else {
                    this.f1783a.add(new CityItem(this.f1784b, 1, valueOf));
                }
                this.f1783a.add(new CityItem(this.f1784b, 2, str2));
                str = valueOf;
            }
            LocationGetter a3 = LocationGetter.m2850a(this.f1784b);
            CityTaxData cityTaxData = null;
            if (a3.m2862a()) {
                cityTaxData = a.m3219b(a3.m2863b());
                if (cityTaxData == null) {
                    cityTaxData = a.m3219b(a3.m2864c());
                }
            }
            if (cityTaxData != null) {
                this.f1783a.add(0, new CityItem(this.f1784b, 3, cityTaxData.f1842a));
                this.f1783a.add(0, new CityItem(this.f1784b, 1, this.f1784b.getString(C0264R.string.tax_city_located)));
            }
        }

        public int getCount() {
            return this.f1783a.size();
        }

        public CityItem m3156a(int i) {
            return (CityItem) this.f1783a.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f1785c.inflate(C0264R.layout.city_item, null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.f1779b = (TextView) view.findViewById(C0264R.id.txv_capital);
                viewHolder.f1780c = (TextView) view.findViewById(C0264R.id.txv_city);
                viewHolder.f1781d = (ImageView) view.findViewById(C0264R.id.imv_located);
                viewHolder.f1782e = (LinearLayout) view.findViewById(C0264R.id.lyt_city);
                view.setTag(viewHolder);
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            CityItem cityItem = (CityItem) this.f1783a.get(i);
            switch (cityItem.f1775a) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    viewHolder2.f1779b.setText(cityItem.f1776b);
                    viewHolder2.f1779b.setVisibility(0);
                    viewHolder2.f1782e.setVisibility(8);
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    viewHolder2.f1780c.setText(cityItem.f1776b);
                    viewHolder2.f1779b.setVisibility(8);
                    viewHolder2.f1782e.setVisibility(0);
                    viewHolder2.f1781d.setVisibility(8);
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    viewHolder2.f1780c.setText(cityItem.f1776b);
                    viewHolder2.f1779b.setVisibility(8);
                    viewHolder2.f1782e.setVisibility(0);
                    viewHolder2.f1781d.setVisibility(0);
                    break;
            }
            return view;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0264R.layout.city_picker_activity);
        m3158a();
    }

    private void m3158a() {
        this.f1786a = (ListView) findViewById(C0264R.id.lst_cities);
        this.f1787b = new CityAdapter(null);
        this.f1786a.setAdapter(this.f1787b);
        this.f1786a.setOnItemClickListener(new C02131(this));
    }
}
