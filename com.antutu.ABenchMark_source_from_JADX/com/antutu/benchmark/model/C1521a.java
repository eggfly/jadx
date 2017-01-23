package com.antutu.benchmark.model;

import com.antutu.utils.JSONTools;
import com.antutu.utils.MLog;
import com.antutu.utils.jni;
import com.igexin.download.Downloads;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.model.a */
public class C1521a extends C1520b implements C1519k {
    private Map<String, List<C1518a>> f5212b;
    private String[] f5213c;
    private int f5214d;

    /* renamed from: com.antutu.benchmark.model.a.a */
    public static final class C1518a implements Serializable {
        public String f5203a;
        public String f5204b;
        public String f5205c;
        public String f5206d;
        public String f5207e;
        public String f5208f;
        public String f5209g;
        public String f5210h;
    }

    public C1521a(String... strArr) {
        this.f5214d = -1;
        this.f5213c = strArr;
    }

    private void m6043a(JSONArray jSONArray, String str) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            if (length > 0) {
                List arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = JSONTools.getJsonObject(jSONArray, i);
                    C1518a c1518a = new C1518a();
                    c1518a.f5203a = JSONTools.getStringValue(jsonObject, AgooConstants.MESSAGE_ID);
                    c1518a.f5204b = JSONTools.getStringValue(jsonObject, "softaid");
                    c1518a.f5205c = JSONTools.getStringValue(jsonObject, "package_name");
                    c1518a.f5206d = JSONTools.getStringValue(jsonObject, "icon");
                    c1518a.f5207e = JSONTools.getStringValue(jsonObject, "app_name");
                    c1518a.f5208f = JSONTools.getStringValue(jsonObject, Downloads.COLUMN_DESCRIPTION);
                    c1518a.f5209g = JSONTools.getStringValue(jsonObject, "app_url");
                    c1518a.f5210h = JSONTools.getStringValue(jsonObject, "button_name");
                    arrayList.add(c1518a);
                }
                this.f5212b.put(str, arrayList);
            }
        }
    }

    public C1519k m6044a(String str) {
        String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
        MLog.m6865d("AdInfosModel", "hzd, " + stringSafe);
        try {
            this.f5212b = new HashMap();
            JSONObject jSONObject = new JSONObject(stringSafe);
            if (this.f5213c != null) {
                for (String str2 : this.f5213c) {
                    m6043a(JSONTools.getJsonArrayValue(jSONObject, str2), str2);
                }
            }
        } catch (Exception e) {
        }
        return this;
    }

    public Map<String, List<C1518a>> m6045a() {
        return this.f5212b;
    }
}
