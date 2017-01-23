package com.miui.calculator.convert.units;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.utils.DefaultPreferenceHelper;
import com.miui.calculator.common.utils.HanziToPinyin;
import com.miui.calculator.common.utils.NetRequestor;
import com.miui.calculator.common.utils.NumberFormatUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;

public class CurrencyUnitsData extends UnitsDataBase {
    private long f1638f;

    public interface UnitDataListener {
        void m2957a(boolean z);
    }

    /* renamed from: com.miui.calculator.convert.units.CurrencyUnitsData.1 */
    class C01921 implements Comparator<String> {
        final /* synthetic */ String[] f1634a;
        final /* synthetic */ CurrencyUnitsData f1635b;

        C01921(CurrencyUnitsData currencyUnitsData, String[] strArr) {
            this.f1635b = currencyUnitsData;
            this.f1634a = strArr;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3002a((String) obj, (String) obj2);
        }

        public int m3002a(String str, String str2) {
            int a = m3003a(this.f1634a, str);
            int a2 = m3003a(this.f1634a, str2);
            if (a != a2) {
                return a - a2;
            }
            String e = this.f1635b.m3018e(str);
            String e2 = this.f1635b.m3018e(str2);
            return this.f1635b.m3018e(HanziToPinyin.m2839a().m2844b(e)).compareToIgnoreCase(this.f1635b.m3018e(HanziToPinyin.m2839a().m2844b(e2)));
        }

        int m3003a(String[] strArr, String str) {
            if (strArr == null) {
                return -1;
            }
            int i = 0;
            while (i < strArr.length && !TextUtils.equals(strArr[i], str)) {
                i++;
            }
            return i;
        }
    }

    /* renamed from: com.miui.calculator.convert.units.CurrencyUnitsData.2 */
    class C01932 extends AsyncTask<Void, Void, String> {
        final /* synthetic */ UnitDataListener f1636a;
        final /* synthetic */ CurrencyUnitsData f1637b;

        C01932(CurrencyUnitsData currencyUnitsData, UnitDataListener unitDataListener) {
            this.f1637b = currencyUnitsData;
            this.f1636a = unitDataListener;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3004a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m3005a((String) obj);
        }

        protected String m3004a(Void... voidArr) {
            return NetRequestor.m2865a("http://quoteapi.webull.sec.miui.com/api/securities/market/tabs/mi/foreignExchangesRates");
        }

        protected void m3005a(String str) {
            boolean z = str != null;
            if (z) {
                this.f1637b.m3008a(str, System.currentTimeMillis());
            }
            if (this.f1636a != null) {
                this.f1636a.m2957a(z);
            }
        }
    }

    public CurrencyUnitsData(Context context) {
        super(context, 1);
    }

    public void m3010a() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("currency_units_prefs", 0);
        String string = sharedPreferences.getString("pref_unitsdata", null);
        this.f1638f = sharedPreferences.getLong("pref_updatetime", 1457623682814L);
        if (string == null || !m3008a(string, this.f1638f)) {
            m3008a(CalculatorUtils.m2820b("default_data/units_currency"), this.f1638f);
        }
    }

    protected String m3013b() {
        return "currency_";
    }

    protected void m3012a(ArrayList<String> arrayList, String[] strArr) {
        if (arrayList != null) {
            Collections.sort(arrayList, new C01921(this, strArr));
        }
    }

    public String m3009a(String str, String str2, String str3) {
        return m3006a(super.m2983a(str, str2, str3));
    }

    public static String m3006a(String str) {
        if (TextUtils.isEmpty(str) || str.lastIndexOf(46) == -1 || str.lastIndexOf(101) != -1) {
            return str;
        }
        return NumberFormatUtils.m2883c(NumberFormatUtils.m2885d(CalculatorUtils.m2813a(str.replaceAll(String.valueOf(','), "")), 4));
    }

    public String m3014b(String str) {
        return m3017d(str);
    }

    public String m3016c(String str) {
        return m3018e(str);
    }

    public String m3017d(String str) {
        return str;
    }

    public String m3018e(String str) {
        String str2 = null;
        CharSequence d = super.m2991d(str);
        if (TextUtils.equals(d, str)) {
            try {
                str2 = Currency.getInstance(str).getDisplayName();
            } catch (Exception e) {
                Log.e("Calculator:CurrencyUnitsData", "No name found for unit: " + str);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return d;
        }
        return str2;
    }

    public String m3019f(String str) {
        return m3018e(str) + " " + m2997g(str);
    }

    public long m3015c() {
        return this.f1638f;
    }

    public void m3011a(UnitDataListener unitDataListener) {
        if (DefaultPreferenceHelper.m2835a(this.b)) {
            new C01932(this, unitDataListener).execute(new Void[0]);
        }
    }

    private boolean m3008a(String str, long j) {
        boolean a = m2987a("USD", str);
        if (a && j > this.f1638f) {
            this.f1638f = j;
            this.b.getSharedPreferences("currency_units_prefs", 0).edit().putString("pref_unitsdata", str).putLong("pref_updatetime", j).commit();
        }
        return a;
    }
}
