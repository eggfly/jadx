package com.miui.calculator.mortgage;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.miui.calculator.common.utils.NetRequestor;
import org.json.JSONObject;

public class InterestRateGetter {
    private static InterestRateGetter f1649a;
    private static Context f1650b;
    private MortgageRate f1651c;
    private MortgageRate f1652d;
    private MortgageRate f1653e;
    private MortgageRate f1654f;
    private MortgageRate f1655g;

    /* renamed from: com.miui.calculator.mortgage.InterestRateGetter.1 */
    class C01951 extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ InterestRateGetter f1646a;

        C01951(InterestRateGetter interestRateGetter) {
            this.f1646a = interestRateGetter;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3034a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m3035a((Void) obj);
        }

        protected Void m3034a(Void... voidArr) {
            MortgageDatas.m3065a(InterestRateGetter.f1650b, NetRequestor.m2865a("http://data.bank.hexun.sec.miui.com/other/mi/dkll_json.ashx"));
            return null;
        }

        protected void m3035a(Void voidR) {
            super.onPostExecute(voidR);
            this.f1646a.m3041a();
        }
    }

    public static class MortgageRate {
        double f1647a;
        double f1648b;
    }

    public static InterestRateGetter m3037a(Context context) {
        InterestRateGetter interestRateGetter;
        synchronized (InterestRateGetter.class) {
            if (f1649a == null) {
                f1649a = new InterestRateGetter(context.getApplicationContext());
            }
            interestRateGetter = f1649a;
        }
        return interestRateGetter;
    }

    private InterestRateGetter(Context context) {
        f1650b = context.getApplicationContext();
    }

    public MortgageRate m3040a(int i) {
        if (i <= 5) {
            return this.f1651c;
        }
        if (i <= 12) {
            return this.f1652d;
        }
        if (i <= 36) {
            return this.f1653e;
        }
        if (i <= 60) {
            return this.f1654f;
        }
        return this.f1655g;
    }

    public void m3041a() {
        if (!m3038a(MortgageDatas.m3064a(f1650b))) {
            m3038a(MortgageDatas.m3063a());
        }
    }

    private boolean m3038a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f1651c = m3036a(jSONObject.getJSONObject("d0"));
            this.f1652d = m3036a(jSONObject.getJSONObject("d1"));
            this.f1653e = m3036a(jSONObject.getJSONObject("d2"));
            this.f1654f = m3036a(jSONObject.getJSONObject("d3"));
            this.f1655g = m3036a(jSONObject.getJSONObject("d4"));
            return true;
        } catch (Throwable e) {
            Log.e("Calculator:InterestRateGetter", "Exception", e);
            return false;
        }
    }

    private MortgageRate m3036a(JSONObject jSONObject) {
        MortgageRate mortgageRate = new MortgageRate();
        mortgageRate.f1647a = jSONObject.getDouble("com") / 100.0d;
        mortgageRate.f1648b = jSONObject.getDouble("acc") / 100.0d;
        return mortgageRate;
    }

    public void m3042b() {
        new C01951(this).execute(new Void[0]);
    }
}
