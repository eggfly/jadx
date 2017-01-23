package com.miui.calculator.tax;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.miui.calculator.common.utils.AssetReader;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.utils.DefaultPreferenceHelper;
import com.miui.calculator.common.utils.NetRequestor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TaxRateGetter {
    private static TaxRateGetter f1858a;
    private String f1859b;
    private final ArrayList<CityTaxData> f1860c;
    private long f1861d;
    private boolean f1862e;
    private Context f1863f;

    public interface TaxRateUpdateListener {
        void m3166a(boolean z);
    }

    /* renamed from: com.miui.calculator.tax.TaxRateGetter.1 */
    class C02261 extends AsyncTask<Void, Void, TaxData> {
        final /* synthetic */ TaxRateUpdateListener f1840a;
        final /* synthetic */ TaxRateGetter f1841b;

        C02261(TaxRateGetter taxRateGetter, TaxRateUpdateListener taxRateUpdateListener) {
            this.f1841b = taxRateGetter;
            this.f1840a = taxRateUpdateListener;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3203a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m3204a((TaxData) obj);
        }

        protected TaxData m3203a(Void... voidArr) {
            String a = NetRequestor.m2868a("http://data.tool.hexun.sec.miui.com/mi/fiveinsurancecontributionrate", "gbk");
            if (a == null) {
                return null;
            }
            String a2 = NetRequestor.m2868a("http://data.tool.hexun.sec.miui.com/mi/wage/", "gbk");
            if (a2 == null) {
                return null;
            }
            String a3 = NetRequestor.m2868a("http://api.comm.miui.com/cspmisc/salary.json", "utf-8");
            if (a3 != null) {
                return new TaxData(a, a2, a3);
            }
            return null;
        }

        protected void m3204a(TaxData taxData) {
            if (taxData != null) {
                this.f1841b.m3211a(taxData.f1855a, taxData.f1856b, taxData.f1857c, System.currentTimeMillis());
            }
            this.f1840a.m3166a(taxData != null);
        }
    }

    public static class CityTaxData implements Parcelable {
        public static final Creator<CityTaxData> CREATOR;
        String f1842a;
        String f1843b;
        double f1844c;
        double f1845d;
        double f1846e;
        double f1847f;
        double f1848g;
        double f1849h;
        double f1850i;
        double f1851j;
        double f1852k;
        double f1853l;
        double f1854m;

        /* renamed from: com.miui.calculator.tax.TaxRateGetter.CityTaxData.1 */
        final class C02271 implements Creator<CityTaxData> {
            C02271() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3205a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3206a(i);
            }

            public CityTaxData m3205a(Parcel parcel) {
                return new CityTaxData(parcel);
            }

            public CityTaxData[] m3206a(int i) {
                return new CityTaxData[i];
            }
        }

        protected /* synthetic */ Object clone() {
            return m3207a();
        }

        protected CityTaxData m3207a() {
            CityTaxData cityTaxData = new CityTaxData();
            cityTaxData.f1842a = this.f1842a;
            cityTaxData.f1843b = this.f1843b;
            cityTaxData.f1844c = this.f1844c;
            cityTaxData.f1845d = this.f1845d;
            cityTaxData.f1846e = this.f1846e;
            cityTaxData.f1847f = this.f1847f;
            cityTaxData.f1848g = this.f1848g;
            cityTaxData.f1849h = this.f1849h;
            cityTaxData.f1850i = this.f1850i;
            cityTaxData.f1851j = this.f1851j;
            cityTaxData.f1852k = this.f1852k;
            cityTaxData.f1853l = this.f1853l;
            cityTaxData.f1854m = this.f1854m;
            return cityTaxData;
        }

        public CityTaxData(Parcel parcel) {
            this.f1842a = parcel.readString();
            this.f1843b = parcel.readString();
            this.f1844c = parcel.readDouble();
            this.f1845d = parcel.readDouble();
            this.f1846e = parcel.readDouble();
            this.f1847f = parcel.readDouble();
            this.f1848g = parcel.readDouble();
            this.f1849h = parcel.readDouble();
            this.f1850i = parcel.readDouble();
            this.f1851j = parcel.readDouble();
            this.f1852k = parcel.readDouble();
            this.f1853l = parcel.readDouble();
            this.f1854m = parcel.readDouble();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1842a);
            parcel.writeString(this.f1843b);
            parcel.writeDouble(this.f1844c);
            parcel.writeDouble(this.f1845d);
            parcel.writeDouble(this.f1846e);
            parcel.writeDouble(this.f1847f);
            parcel.writeDouble(this.f1848g);
            parcel.writeDouble(this.f1849h);
            parcel.writeDouble(this.f1850i);
            parcel.writeDouble(this.f1851j);
            parcel.writeDouble(this.f1852k);
            parcel.writeDouble(this.f1853l);
            parcel.writeDouble(this.f1854m);
        }

        static {
            CREATOR = new C02271();
        }
    }

    private static class TaxData {
        String f1855a;
        String f1856b;
        String f1857c;

        public TaxData(String str, String str2, String str3) {
            this.f1855a = str;
            this.f1856b = str2;
            this.f1857c = str3;
        }
    }

    public static TaxRateGetter m3208a(Context context) {
        TaxRateGetter taxRateGetter;
        synchronized (TaxRateGetter.class) {
            if (f1858a == null) {
                f1858a = new TaxRateGetter(context.getApplicationContext());
            }
            taxRateGetter = f1858a;
        }
        return taxRateGetter;
    }

    private TaxRateGetter(Context context) {
        this.f1860c = new ArrayList();
        this.f1861d = 1457623682814L;
        this.f1863f = context;
        this.f1859b = DefaultPreferenceHelper.m2836b(context, null);
    }

    public String m3216a() {
        return this.f1859b;
    }

    public String m3220b() {
        return TextUtils.isEmpty(this.f1859b) ? "\u5317\u4eac" : this.f1859b;
    }

    public void m3218a(String str) {
        this.f1859b = str;
        DefaultPreferenceHelper.m2831a(this.f1863f, str);
    }

    public boolean m3221c() {
        return this.f1862e;
    }

    public void m3217a(TaxRateUpdateListener taxRateUpdateListener) {
        new C02261(this, taxRateUpdateListener).execute(new Void[0]);
    }

    public void m3222d() {
        SharedPreferences sharedPreferences = this.f1863f.getSharedPreferences("tax_data_preference", 0);
        String string = sharedPreferences.getString("pref_tax_datas", null);
        String string2 = sharedPreferences.getString("pref_average_salaries", null);
        String string3 = sharedPreferences.getString("pref_pay_base", null);
        this.f1861d = sharedPreferences.getLong("pref_updatetime", 1457623682814L);
        if (string == null || string2 == null || string3 == null) {
            string = AssetReader.m2800a(this.f1863f, "default_data/tax_datas");
            string2 = AssetReader.m2800a(this.f1863f, "default_data/average_salaries");
            string3 = AssetReader.m2800a(this.f1863f, "default_data/pay_base");
        }
        if (string == null || string2 == null || string3 == null) {
            throw new RuntimeException("Could not load the default tax datas");
        }
        m3211a(string, string2, string3, this.f1861d);
        this.f1862e = true;
    }

    private void m3211a(String str, String str2, String str3, long j) {
        try {
            HashMap c = m3213c(str2);
            HashMap d = m3214d(str3);
            JSONArray jSONArray = new JSONObject(str).getJSONArray("IF");
            Collection arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("m");
                String string2 = jSONObject.getString("e");
                String string3 = jSONObject.getString("u");
                String string4 = jSONObject.getString("i");
                String string5 = jSONObject.getString("b");
                String string6 = jSONObject.getString("f");
                String string7 = jSONObject.getString("s");
                String string8 = jSONObject.getString("n");
                CityTaxData cityTaxData = new CityTaxData();
                cityTaxData.f1844c = CalculatorUtils.m2813a(string) / 100.0d;
                cityTaxData.f1845d = CalculatorUtils.m2813a(string2) / 100.0d;
                cityTaxData.f1846e = CalculatorUtils.m2813a(string3) / 100.0d;
                cityTaxData.f1847f = CalculatorUtils.m2813a(string4) / 100.0d;
                cityTaxData.f1848g = CalculatorUtils.m2813a(string5) / 100.0d;
                cityTaxData.f1849h = CalculatorUtils.m2813a(string6) / 100.0d;
                cityTaxData.f1842a = string7;
                cityTaxData.f1843b = string8;
                m3209a(cityTaxData, c);
                m3212b(cityTaxData, d);
                arrayList.add(cityTaxData);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CityTaxData cityTaxData2 = (CityTaxData) it.next();
                if (cityTaxData2.f1850i <= 0.0d) {
                    double d2 = 0.0d;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        CityTaxData cityTaxData3 = (CityTaxData) arrayList.get(i2);
                        if (d2 <= 0.0d) {
                            d2 = cityTaxData3.f1850i;
                        }
                        if ("\u5317\u4eac".equals(cityTaxData3.f1842a)) {
                            d2 = cityTaxData3.f1850i;
                            break;
                        }
                    }
                    Log.w("Cal:TaxRateGetter", "Cannot find the average salary of " + cityTaxData2.f1842a);
                    cityTaxData2.f1850i = d2;
                }
            }
            this.f1860c.clear();
            this.f1860c.addAll(arrayList);
            if (j > this.f1861d) {
                this.f1861d = j;
                this.f1863f.getSharedPreferences("tax_data_preference", 0).edit().putString("pref_tax_datas", str).putString("pref_average_salaries", str2).putLong("pref_updatetime", j).commit();
            }
        } catch (Throwable e) {
            Log.e("Cal:TaxRateGetter", "updateTaxDatas", e);
        } catch (Throwable e2) {
            Log.e("Cal:TaxRateGetter", "updateTaxDatas", e2);
        }
    }

    private HashMap<String, Double> m3213c(String str) {
        HashMap<String, Double> hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("IF");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                hashMap.put(jSONObject.getString("n"), Double.valueOf(CalculatorUtils.m2813a(jSONObject.getString("s"))));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    private HashMap<String, CityTaxData> m3214d(String str) {
        HashMap<String, CityTaxData> hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONObject jSONObject2 = jSONObject.getJSONObject("base");
                String string = jSONObject.getString("name");
                CityTaxData cityTaxData = new CityTaxData();
                cityTaxData.f1851j = jSONObject2.getDouble("max_base_3j");
                cityTaxData.f1852k = jSONObject2.getDouble("min_base_3j");
                cityTaxData.f1853l = jSONObject2.getDouble("max_base_gjj");
                cityTaxData.f1854m = jSONObject2.getDouble("min_base_gjj");
                hashMap.put(string, cityTaxData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    private void m3209a(CityTaxData cityTaxData, HashMap<String, Double> hashMap) {
        if (hashMap.containsKey(cityTaxData.f1842a)) {
            cityTaxData.f1850i = ((Double) hashMap.get(cityTaxData.f1842a)).doubleValue();
        }
    }

    private void m3212b(CityTaxData cityTaxData, HashMap<String, CityTaxData> hashMap) {
        if (hashMap.containsKey(cityTaxData.f1842a)) {
            CityTaxData cityTaxData2 = (CityTaxData) hashMap.get(cityTaxData.f1842a);
            cityTaxData.f1851j = cityTaxData2.f1851j;
            cityTaxData.f1852k = cityTaxData2.f1852k;
            cityTaxData.f1853l = cityTaxData2.f1853l;
            cityTaxData.f1854m = cityTaxData2.f1854m;
        }
    }

    public long m3223e() {
        return this.f1861d;
    }

    public CityTaxData m3219b(String str) {
        CityTaxData cityTaxData = null;
        Iterator it = this.f1860c.iterator();
        while (it.hasNext()) {
            CityTaxData cityTaxData2 = (CityTaxData) it.next();
            if (!cityTaxData2.f1842a.equals(str)) {
                cityTaxData2 = cityTaxData;
            }
            cityTaxData = cityTaxData2;
        }
        return cityTaxData;
    }

    public CityTaxData m3215a(int i) {
        if (this.f1860c.size() > i) {
            return (CityTaxData) this.f1860c.get(i);
        }
        return null;
    }

    public ArrayList<CityTaxData> m3224f() {
        return (ArrayList) this.f1860c.clone();
    }
}
