package com.baidu.mobads.vo;

import com.antutu.benchmark.modelreflact.TestResultModel;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.vo.c */
public class C2078c implements IXAdResponseInfo {
    private int f7299a;
    private Boolean f7300b;
    private String f7301c;
    private int f7302d;
    private int f7303e;
    private String f7304f;
    private String f7305g;
    private String f7306h;
    private int f7307i;
    private int f7308j;
    private String f7309k;
    private String f7310l;
    private String f7311m;
    private String f7312n;
    private String f7313o;
    private ArrayList<IXAdInstanceInfo> f7314p;
    private long f7315q;

    public C2078c(String str) {
        boolean z = true;
        this.f7299a = 0;
        this.f7300b = Boolean.valueOf(false);
        this.f7307i = -1;
        this.f7308j = -1;
        this.f7314p = new ArrayList();
        this.f7313o = str;
        this.f7315q = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(str);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(TestResultModel.TYPE_AD);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        this.f7314p.add(new XAdInstanceInfo(jSONArray.getJSONObject(i)));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Exception e2) {
            this.f7314p = new ArrayList();
        }
        this.f7299a = jSONObject.optInt(IXAdRequestInfo.AD_COUNT, 0);
        this.f7302d = jSONObject.optInt("x", 0);
        this.f7303e = jSONObject.optInt("y", 0);
        if (jSONObject.optInt("m", 0) != 1) {
            z = false;
        }
        this.f7300b = Boolean.valueOf(z);
        this.f7301c = jSONObject.optString("u", BuildConfig.FLAVOR);
        this.f7304f = jSONObject.optString("exp2", "{}");
        this.f7305g = jSONObject.optString("ext_act", "{}");
        this.f7307i = jSONObject.optInt("lunpan", -1);
        this.f7308j = jSONObject.optInt("intIcon", -1);
        this.f7309k = jSONObject.optString("ck", BuildConfig.FLAVOR);
        this.f7310l = jSONObject.optString("req_id");
        this.f7311m = jSONObject.optString("error_code", BuildConfig.FLAVOR);
        this.f7312n = jSONObject.optString("error_msg", BuildConfig.FLAVOR);
        try {
            this.f7306h = jSONObject.getString("theme");
        } catch (JSONException e3) {
        }
    }

    public ArrayList<IXAdInstanceInfo> getAdInstanceList() {
        return this.f7314p;
    }

    public int getAdsNum() {
        return this.f7299a;
    }

    public String getBaiduidOfCookie() {
        return this.f7309k;
    }

    public String getDefaultFillInThemeForStaticAds() {
        return this.f7306h;
    }

    public String getErrorCode() {
        return this.f7311m;
    }

    public String getErrorMessage() {
        return this.f7312n;
    }

    public String getExp2() {
        return this.f7304f;
    }

    public String getExtentionActionExp() {
        return this.f7305g;
    }

    public int getIntIcon() {
        return this.f7308j;
    }

    public int getLatitude() {
        return this.f7303e;
    }

    public int getLongitude() {
        return this.f7302d;
    }

    public int getLunpan() {
        return this.f7307i;
    }

    public Boolean getOpenPointModeForWall() {
        return this.f7300b;
    }

    public String getOriginResponseStr() {
        return this.f7313o;
    }

    public String getPointUnitForWall() {
        return this.f7301c;
    }

    public IXAdInstanceInfo getPrimaryAdInstanceInfo() {
        return this.f7314p.size() > 0 ? (IXAdInstanceInfo) this.f7314p.get(0) : null;
    }

    public String getRequestId() {
        return this.f7310l;
    }

    public long getTimeStamp() {
        return this.f7315q;
    }

    public void setAdInstanceList(ArrayList<IXAdInstanceInfo> arrayList) {
        this.f7314p = arrayList;
    }

    public void setAdsNum(int i) {
        this.f7299a = i;
    }

    public void setBaiduidOfCookie(String str) {
        this.f7309k = str;
    }

    public void setDefaultFillInThemeForStaticAds(String str) {
        this.f7306h = str;
    }

    public void setErrorCode(String str) {
        this.f7311m = str;
    }

    public void setErrorMessage(String str) {
        this.f7312n = str;
    }

    public void setExp2(String str) {
        this.f7304f = str;
    }

    public void setExtentionActionExp(String str) {
        this.f7305g = str;
    }

    public void setIntIcon(int i) {
        this.f7308j = i;
    }

    public void setLatitude(int i) {
        this.f7303e = i;
    }

    public void setLongitude(int i) {
        this.f7302d = i;
    }

    public void setLunpan(int i) {
        this.f7307i = i;
    }

    public void setOpenPointModeForWall(Boolean bool) {
        this.f7300b = bool;
    }

    public void setOriginResponseStr(String str) {
        this.f7313o = str;
    }

    public void setPointUnitForWall(String str) {
        this.f7301c = str;
    }

    public void setRequestId(String str) {
        this.f7310l = str;
    }
}
