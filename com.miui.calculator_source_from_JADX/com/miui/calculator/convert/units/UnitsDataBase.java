package com.miui.calculator.convert.units;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.miui.calculator.CalculatorApplication;
import com.miui.calculator.common.utils.Calculator;
import com.miui.calculator.common.utils.DefaultPreferenceHelper;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class UnitsDataBase {
    protected int f1627a;
    protected Context f1628b;
    protected String f1629c;
    protected HashMap<Pair<String, String>, String> f1630d;
    protected HashMap<String, UnitData> f1631e;
    private ArrayList<String> f1632f;
    private Calculator f1633g;

    /* renamed from: com.miui.calculator.convert.units.UnitsDataBase.1 */
    class C01941 implements Comparator<String> {
        final /* synthetic */ String[] f1639a;
        final /* synthetic */ UnitsDataBase f1640b;

        C01941(UnitsDataBase unitsDataBase, String[] strArr) {
            this.f1640b = unitsDataBase;
            this.f1639a = strArr;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3026a((String) obj, (String) obj2);
        }

        public int m3026a(String str, String str2) {
            int a = m3027a(this.f1639a, str);
            int a2 = m3027a(this.f1639a, str2);
            if (a != a2) {
                return a - a2;
            }
            return this.f1640b.m2991d(str).compareToIgnoreCase(this.f1640b.m2991d(str2));
        }

        int m3027a(String[] strArr, String str) {
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

    private class UnitData {
        String f1641a;
        String f1642b;
        String f1643c;
        int f1644d;
        final /* synthetic */ UnitsDataBase f1645e;

        UnitData(UnitsDataBase unitsDataBase, String str, String str2, String str3, int i) {
            this.f1645e = unitsDataBase;
            this.f1641a = str;
            this.f1642b = str2;
            this.f1643c = str3;
            this.f1644d = i;
        }
    }

    public abstract void m2984a();

    protected abstract String m2988b();

    public UnitsDataBase(Context context, int i) {
        this.f1630d = new HashMap();
        this.f1631e = new HashMap();
        this.f1632f = new ArrayList();
        this.f1628b = context;
        this.f1627a = i;
        this.f1633g = Calculator.m2801a();
    }

    public void m2992d() {
        m2984a();
        m2994e();
    }

    private String m2980b(int i) {
        return "unit_data_default_" + m2988b() + String.valueOf(i);
    }

    public String m2982a(int i) {
        String str = null;
        String b = m2980b(i);
        try {
            str = this.f1628b.getResources().getString(this.f1628b.getResources().getIdentifier(b, "string", this.f1628b.getPackageName()));
        } catch (Throwable e) {
            Log.e("Calculator:UnitsDataBase", "NotFoundException", e);
        }
        return DefaultPreferenceHelper.m2837b(this.f1628b, b, str);
    }

    public void m2985a(int i, String str) {
        DefaultPreferenceHelper.m2832a(this.f1628b, m2980b(i), str);
    }

    protected void m2994e() {
        HashSet hashSet = new HashSet();
        for (Pair pair : this.f1630d.keySet()) {
            String str = (String) pair.first;
            if (!hashSet.contains(str)) {
                this.f1631e.put(str, m2978a(str));
                hashSet.add(str);
            }
            String str2 = (String) pair.second;
            if (!hashSet.contains(str2)) {
                this.f1631e.put(str2, m2978a(str2));
                hashSet.add(str2);
            }
        }
        this.f1632f.clear();
        for (String str22 : this.f1631e.keySet()) {
            this.f1632f.add(str22);
        }
        String[] strArr = null;
        try {
            strArr = this.f1628b.getResources().getStringArray(this.f1628b.getResources().getIdentifier("unit_data_order_" + m2988b(), "array", this.f1628b.getPackageName()));
        } catch (NotFoundException e) {
        }
        m2986a(this.f1632f, strArr);
    }

    private UnitData m2978a(String str) {
        String string;
        String string2;
        String string3;
        try {
            string = this.f1628b.getResources().getString(this.f1628b.getResources().getIdentifier("unit_data_display_" + m2988b() + str.toLowerCase(), "string", this.f1628b.getPackageName()));
        } catch (NotFoundException e) {
            string = str;
        }
        try {
            string2 = this.f1628b.getResources().getString(this.f1628b.getResources().getIdentifier("unit_data_name_" + m2988b() + str.toLowerCase(), "string", this.f1628b.getPackageName()));
        } catch (NotFoundException e2) {
            string2 = str;
        }
        try {
            string3 = this.f1628b.getResources().getString(this.f1628b.getResources().getIdentifier("unit_data_short_" + m2988b() + str.toLowerCase(), "string", this.f1628b.getPackageName()));
        } catch (NotFoundException e3) {
            string3 = str;
        }
        return new UnitData(this, string, string2, string3, this.f1628b.getResources().getIdentifier("unit_data_icon_" + m2988b() + str.toLowerCase(), "drawable", this.f1628b.getPackageName()));
    }

    protected void m2986a(ArrayList<String> arrayList, String[] strArr) {
        if (arrayList != null) {
            Collections.sort(arrayList, new C01941(this, strArr));
        }
    }

    private static boolean m2981c() {
        return !CalculatorApplication.m2559b().getResources().getConfiguration().locale.getLanguage().equals(Locale.CHINESE.getLanguage());
    }

    public String m2989b(String str) {
        return m2981c() ? m2993e(str) : m2991d(str);
    }

    public String m2990c(String str) {
        return m2981c() ? m2991d(str) : m2993e(str);
    }

    public String m2991d(String str) {
        UnitData unitData = (UnitData) this.f1631e.get(str);
        if (unitData != null) {
            return unitData.f1641a;
        }
        return str;
    }

    public String m2997g(String str) {
        UnitData unitData = (UnitData) this.f1631e.get(str);
        if (unitData != null) {
            return unitData.f1642b;
        }
        return str;
    }

    public String m2993e(String str) {
        UnitData unitData = (UnitData) this.f1631e.get(str);
        if (unitData != null) {
            return unitData.f1643c;
        }
        return str;
    }

    public int m2998h(String str) {
        UnitData unitData = (UnitData) this.f1631e.get(str);
        if (unitData != null) {
            return unitData.f1644d;
        }
        return 0;
    }

    public String m2995f(String str) {
        return m2991d(str) + " " + m2993e(str);
    }

    public String m2983a(String str, String str2, String str3) {
        if (str == null || str3 == null || str2 == null) {
            return null;
        }
        String str4;
        String str5;
        if (str.equals(str3)) {
            str4 = str2;
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str5 = (String) this.f1630d.get(new Pair(str, str3));
            if (str5 != null) {
                str5 = this.f1633g.m2811a(str5.replaceAll(String.valueOf('x'), str2), true);
                if (str5 == null) {
                    return str5;
                }
                if (this.f1629c.equals(str) || this.f1629c.equals(str3)) {
                    return null;
                }
                return m2983a(this.f1629c, m2983a(str, str2, this.f1629c), str3);
            }
        }
        str5 = str4;
        if (str5 == null) {
            return str5;
        }
        if (!this.f1629c.equals(str)) {
        }
        return null;
    }

    public String[] m2996f() {
        String[] strArr = new String[this.f1632f.size()];
        Iterator it = this.f1632f.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = (String) it.next();
            i++;
        }
        return strArr;
    }

    public boolean m2999i(String str) {
        return m2987a(null, str);
    }

    public boolean m2987a(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("base")) {
                str = jSONObject.getString("base");
            }
            JSONArray jSONArray = new JSONObject(str2).getJSONArray("rate");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("n1");
                String string2 = jSONObject2.getString("n2");
                if (jSONObject2.has("f")) {
                    hashMap.put(new Pair(string, string2), jSONObject2.getString("f"));
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append('(').append(jSONObject2.getString("r")).append(')').append('\u00d7').append('x');
                    hashMap.put(new Pair(string, string2), stringBuilder.toString());
                    Pair pair = new Pair(string2, string);
                    if (!hashMap.containsKey(pair)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append('(').append('1').append('\u00f7').append('(').append(jSONObject2.getString("r")).append(')').append(')').append('\u00d7').append('x');
                        hashMap.put(pair, stringBuilder2.toString());
                    }
                }
            }
            this.f1630d = hashMap;
            this.f1629c = str;
            return true;
        } catch (Throwable e) {
            Log.e("Calculator:UnitsDataBase", "JSONException", e);
            return false;
        }
    }

    public static UnitsDataBase m2979a(Context context, int i) {
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                CurrencyUnitsData currencyUnitsData = new CurrencyUnitsData(context);
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                return new AreaUnitsData(context);
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                return new VolumeUnitsData(context);
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                return new TemperatureUnitsData(context);
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                return new VelocityUnitsData(context);
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                return new TimeUnitsData(context);
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                return new WeightUnitsData(context);
            default:
                return null;
        }
        return new LengthUnitsData(context);
    }
}
