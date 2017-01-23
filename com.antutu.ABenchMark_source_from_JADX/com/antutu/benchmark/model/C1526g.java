package com.antutu.benchmark.model;

import com.antutu.utils.DevAdvFactor;
import com.antutu.utils.jni;
import com.igexin.download.Downloads;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.model.g */
public class C1526g implements C1519k {
    public final String f5248a;
    public final String f5249b;
    public final String f5250c;
    public final String f5251d;
    public final String f5252e;
    public final String f5253f;
    public final String f5254g;
    public final String f5255h;
    public final String f5256i;
    ArrayList<DevAdvFactor> f5257j;

    public C1526g() {
        this.f5248a = AgooConstants.MESSAGE_ID;
        this.f5249b = "softaid";
        this.f5250c = "package_name";
        this.f5251d = "icon";
        this.f5252e = "app_name";
        this.f5253f = Downloads.COLUMN_DESCRIPTION;
        this.f5254g = "app_url";
        this.f5255h = "button_name";
        this.f5256i = "a_order";
        this.f5257j = new ArrayList();
    }

    public C1519k m6070a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(jni.getStringSafe(str, BuildConfig.FLAVOR));
            for (int i = 0; i < C1523d.f5230a.length; i++) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(C1523d.f5230a[i]);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        DevAdvFactor devAdvFactor = new DevAdvFactor();
                        getClass();
                        String string = jSONObject2.getString(AgooConstants.MESSAGE_ID);
                        getClass();
                        String string2 = jSONObject2.getString("softaid");
                        getClass();
                        String string3 = jSONObject2.getString("package_name");
                        getClass();
                        String string4 = jSONObject2.getString("icon");
                        getClass();
                        String string5 = jSONObject2.getString("app_name");
                        getClass();
                        String string6 = jSONObject2.getString(Downloads.COLUMN_DESCRIPTION);
                        getClass();
                        String string7 = jSONObject2.getString("app_url");
                        getClass();
                        String string8 = jSONObject2.getString("button_name");
                        getClass();
                        String string9 = jSONObject2.getString("a_order");
                        devAdvFactor.setId(string);
                        devAdvFactor.setA_order(string9);
                        devAdvFactor.setAdvDescription(string6);
                        devAdvFactor.setAppName(string5);
                        devAdvFactor.setBtnTxt(string8);
                        devAdvFactor.setIcon(string4);
                        devAdvFactor.setPn(string3);
                        devAdvFactor.setSoftaid(string2);
                        devAdvFactor.setUrl(string7);
                        devAdvFactor.setType(i);
                        this.f5257j.add(devAdvFactor);
                    }
                } catch (Exception e) {
                }
            }
            return this;
        } catch (JSONException e2) {
            return null;
        }
    }

    public ArrayList<DevAdvFactor> m6071a() {
        return this.f5257j;
    }
}
