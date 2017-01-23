package com.antutu.benchmark.model;

import com.antutu.utils.JSONTools;
import com.antutu.utils.MLog;
import com.antutu.utils.PointMark;
import com.antutu.utils.jni;
import com.igexin.download.Downloads;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.model.j */
public class C1533j implements C1519k {
    public C1531b f5340a;

    /* renamed from: com.antutu.benchmark.model.j.a */
    public static class C1530a {
        public String f5298a;
        public String f5299b;
        public String f5300c;
        public String f5301d;
        public String f5302e;
        public boolean f5303f;
    }

    /* renamed from: com.antutu.benchmark.model.j.b */
    public static class C1531b {
        public String f5304A;
        public String f5305B;
        public List<C1532c> f5306C;
        public int f5307D;
        public int f5308a;
        public int f5309b;
        public String f5310c;
        public String f5311d;
        public C1530a f5312e;
        public String f5313f;
        public String f5314g;
        public String f5315h;
        public String f5316i;
        public String f5317j;
        public String f5318k;
        public String f5319l;
        public String f5320m;
        public boolean f5321n;
        public boolean f5322o;
        public boolean f5323p;
        public int f5324q;
        public String f5325r;
        public int f5326s;
        public String f5327t;
        public int f5328u;
        public String f5329v;
        public String f5330w;
        public String f5331x;
        public String f5332y;
        public String f5333z;

        public C1531b() {
            this.f5309b = -1;
            this.f5325r = null;
            this.f5327t = null;
            this.f5329v = null;
        }
    }

    /* renamed from: com.antutu.benchmark.model.j.c */
    public static class C1532c {
        public String f5334a;
        public String f5335b;
        public int f5336c;
        public int f5337d;
        public String f5338e;
        public String f5339f;
    }

    public C1519k m6075a(String str) {
        boolean z = true;
        int i = 0;
        try {
            JSONObject jSONObject;
            String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
            MLog.m6865d("HomeInfo", "JsonObj:" + stringSafe);
            JSONObject jSONObject2 = new JSONObject(stringSafe);
            this.f5340a = new C1531b();
            if (jSONObject2.has(PointMark.T_MODELID)) {
                this.f5340a.f5308a = jSONObject2.getInt(PointMark.T_MODELID);
            }
            if (jSONObject2.has("model_level")) {
                this.f5340a.f5309b = jSONObject2.getInt("model_level");
            }
            if (jSONObject2.has(Downloads.COLUMN_DESCRIPTION)) {
                this.f5340a.f5310c = jSONObject2.getString(Downloads.COLUMN_DESCRIPTION);
            }
            if (jSONObject2.has("description_url")) {
                this.f5340a.f5311d = jSONObject2.getString("description_url");
            }
            this.f5340a.f5321n = JSONTools.getIntValue(jSONObject2, "listClearMaster", 0) == 1;
            int intValue = JSONTools.getIntValue(jSONObject2, "ClearMasterforFirstPage", 0);
            this.f5340a.f5322o = intValue == 1;
            intValue = JSONTools.getIntValue(jSONObject2, "GoesPubic", 0);
            C1531b c1531b = this.f5340a;
            if (intValue != 1) {
                z = false;
            }
            c1531b.f5323p = z;
            if (jSONObject2.has("Ads")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("Ads");
                int i2 = 0;
                while (i2 < jSONArray.length() && i2 <= 0) {
                    C1530a c1530a = new C1530a();
                    c1530a.f5301d = jSONArray.getJSONObject(i2).getString(AgooConstants.MESSAGE_ID);
                    c1530a.f5300c = jSONArray.getJSONObject(i2).getString("ibody");
                    c1530a.f5298a = jSONArray.getJSONObject(i2).getString("ilink");
                    c1530a.f5302e = jSONArray.getJSONObject(i2).getString("ititle");
                    c1530a.f5299b = jSONArray.getJSONObject(i2).getString("iurl");
                    c1530a.f5303f = MessageService.MSG_DB_NOTIFY_REACHED.equals(jSONArray.getJSONObject(i2).getString("existscore"));
                    this.f5340a.f5312e = c1530a;
                    i2++;
                }
            }
            if (jSONObject2.has("PolicyModels")) {
                this.f5340a.f5306C = new ArrayList();
                JSONArray jsonArrayValue = JSONTools.getJsonArrayValue(jSONObject2, "PolicyModels");
                intValue = jsonArrayValue.length();
                while (i < intValue) {
                    JSONObject jsonObject = JSONTools.getJsonObject(jsonArrayValue, i);
                    C1532c c1532c = new C1532c();
                    c1532c.f5334a = JSONTools.getStringValue(jsonObject, Constants.KEY_MODEL);
                    c1532c.f5335b = JSONTools.getStringValue(jsonObject, Constants.KEY_BRAND);
                    c1532c.f5336c = JSONTools.getIntValue(jsonObject, "score");
                    c1532c.f5337d = JSONTools.getIntValue(jsonObject, AgooConstants.MESSAGE_FLAG);
                    c1532c.f5338e = JSONTools.getStringValue(jsonObject, C4233j.f14376C);
                    c1532c.f5339f = JSONTools.getStringValue(jsonObject, "tips");
                    this.f5340a.f5306C.add(c1532c);
                    i++;
                }
            }
            this.f5340a.f5307D = JSONTools.getIntValue(jSONObject2, "OfficerVersionCode");
            if (jSONObject2.has("medal")) {
                this.f5340a.f5313f = jSONObject2.getString("medal");
            }
            if (jSONObject2.has("manufacturer")) {
                this.f5340a.f5314g = jSONObject2.getString("manufacturer");
            }
            if (jSONObject2.has(Constants.KEY_MODEL)) {
                this.f5340a.f5315h = jSONObject2.getString(Constants.KEY_MODEL);
                if (this.f5340a.f5315h.contains("\uff08")) {
                    this.f5340a.f5315h = this.f5340a.f5315h.substring(0, this.f5340a.f5315h.indexOf("\uff08"));
                }
            }
            if (jSONObject2.has("model_pic")) {
                this.f5340a.f5316i = jSONObject2.getString("model_pic");
            }
            if (jSONObject2.has("is_certification")) {
                this.f5340a.f5317j = jSONObject2.getString("is_certification");
            }
            if (jSONObject2.has("certification_pic")) {
                this.f5340a.f5318k = jSONObject2.getString("certification_pic");
            }
            if (jSONObject2.has("brand_url")) {
                this.f5340a.f5319l = jSONObject2.getString("brand_url");
            }
            if (jSONObject2.has("brand_info")) {
                this.f5340a.f5320m = jSONObject2.getString("brand_info");
            }
            if (jSONObject2.has("brand_url")) {
                this.f5340a.f5319l = jSONObject2.getString("brand_url");
            }
            if (jSONObject2.has("level")) {
                jSONObject = jSONObject2.getJSONObject("level");
                this.f5340a.f5324q = jSONObject.getInt("sublevel_1");
                this.f5340a.f5326s = jSONObject.getInt("sublevel_2");
                this.f5340a.f5328u = jSONObject.getInt("sublevel_3");
                this.f5340a.f5325r = jSONObject.getString("sublevel_1_description");
                this.f5340a.f5327t = jSONObject.getString("sublevel_2_description");
                this.f5340a.f5329v = jSONObject.getString("sublevel_3_description");
            }
            if (jSONObject2.has(C4233j.f14376C)) {
                jSONObject = jSONObject2.getJSONObject(C4233j.f14376C);
                this.f5340a.f5330w = jSONObject.getString(Downloads.COLUMN_TITLE);
                this.f5340a.f5331x = jSONObject.getString("title_url");
                this.f5340a.f5332y = jSONObject.getString(Downloads.COLUMN_DESCRIPTION);
                this.f5340a.f5333z = jSONObject.getString("description_url");
                this.f5340a.f5304A = jSONObject.getString("bg_url");
                this.f5340a.f5305B = jSONObject.getString("icon_url");
            }
        } catch (JSONException e) {
        }
        return this;
    }
}
