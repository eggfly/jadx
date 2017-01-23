package com.igexin.push.config;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.p174c.C3730i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.config.o */
public class C3756o {
    public static void m15416a(String str, boolean z) {
        JSONObject jSONObject;
        C3688a.m15097b("IDCConfigParse parse idc config data : " + str);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            String[] a;
            if (jSONObject.has("N")) {
                try {
                    SDKUrlConfig.setLocation(jSONObject.getString("N"));
                } catch (JSONException e2) {
                }
            }
            if (jSONObject.has("X1")) {
                a = C3756o.m15417a(jSONObject, "X1");
                if (a != null && a.length > 0) {
                    SDKUrlConfig.setXfrAddressIps(a);
                    C3688a.m15097b("Detect_IDCConfigParse parse idc success, set new xfr address, reset and redetect +++++++++++++++++");
                    if (z) {
                        C3730i.m15273a().m15280h();
                    }
                }
            }
            if (jSONObject.has("X2")) {
                a = C3756o.m15417a(jSONObject, "X2");
                if (a != null && a.length > 0) {
                    SDKUrlConfig.XFR_ADDRESS_BAK = a;
                }
            }
            if (jSONObject.has("B")) {
                a = C3756o.m15417a(jSONObject, "B");
                if (a != null && a.length > 0) {
                    SDKUrlConfig.BI_ADDRESS_IPS = a;
                }
            }
            if (jSONObject.has("C")) {
                a = C3756o.m15417a(jSONObject, "C");
                if (a != null && a.length > 0) {
                    SDKUrlConfig.CONFIG_ADDRESS_IPS = a;
                }
            }
            if (jSONObject.has("S")) {
                a = C3756o.m15417a(jSONObject, "S");
                if (a != null && a.length > 0) {
                    SDKUrlConfig.STATE_ADDRESS_IPS = a;
                }
            }
            if (jSONObject.has("LO")) {
                a = C3756o.m15417a(jSONObject, "LO");
                if (a != null && a.length > 0) {
                    SDKUrlConfig.LOG_ADDRESS_IPS = a;
                }
            }
            if (jSONObject.has("A")) {
                a = C3756o.m15417a(jSONObject, "A");
                if (a != null && a.length > 0) {
                    SDKUrlConfig.AMP_ADDRESS_IPS = a;
                }
            }
            if (jSONObject.has("LB")) {
                a = C3756o.m15417a(jSONObject, "LB");
                if (a != null && a.length > 0) {
                    SDKUrlConfig.LBS_ADDRESS_IPS = a;
                }
            }
            if (jSONObject.has("I")) {
                String[] a2 = C3756o.m15417a(jSONObject, "I");
                if (a2 != null && a2.length > 0) {
                    SDKUrlConfig.INC_ADDRESS_IPS = a2;
                }
            }
        }
    }

    private static String[] m15417a(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                if (str.equals("X1") || str.equals("X2")) {
                    strArr[i] = "socket://" + jSONArray.getString(i);
                } else {
                    strArr[i] = "http://" + jSONArray.getString(i);
                }
            }
            return strArr;
        } catch (Exception e) {
            return null;
        }
    }
}
