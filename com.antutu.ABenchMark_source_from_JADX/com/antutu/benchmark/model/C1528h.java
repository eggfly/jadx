package com.antutu.benchmark.model;

import com.antutu.ABenchMark.C1082R;
import com.antutu.utils.MLog;
import com.antutu.utils.jni;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.model.h */
public class C1528h implements C1519k {
    public C1527a f5296a;

    /* renamed from: com.antutu.benchmark.model.h.a */
    public class C1527a {
        public int f5258A;
        public int f5259B;
        public int f5260C;
        public int f5261D;
        public int f5262E;
        public int f5263F;
        public int f5264G;
        public String f5265H;
        public int f5266I;
        public int f5267J;
        public int f5268K;
        final /* synthetic */ C1528h f5269L;
        public String f5270a;
        public String f5271b;
        public String f5272c;
        public String f5273d;
        public String f5274e;
        public String f5275f;
        public String f5276g;
        public String f5277h;
        public String f5278i;
        public String f5279j;
        public String f5280k;
        public String f5281l;
        public String f5282m;
        public String f5283n;
        public String f5284o;
        public String f5285p;
        public String f5286q;
        public String f5287r;
        public String f5288s;
        public String f5289t;
        public String f5290u;
        public int f5291v;
        public int f5292w;
        public int f5293x;
        public int f5294y;
        public int f5295z;

        public C1527a(C1528h c1528h) {
            this.f5269L = c1528h;
            this.f5291v = -1;
            this.f5292w = -1;
            this.f5293x = -1;
            this.f5294y = -1;
            this.f5295z = -1;
            this.f5258A = -1;
            this.f5259B = -1;
            this.f5260C = -1;
            this.f5261D = -1;
            this.f5266I = 0;
            this.f5267J = 0;
            this.f5268K = 0;
        }
    }

    public C1519k m6072a(String str) {
        try {
            String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
            MLog.m6865d("info_tag", stringSafe);
            JSONObject jSONObject = new JSONObject(stringSafe);
            this.f5296a = new C1527a(this);
            if (jSONObject.has("unknowmodel")) {
                this.f5296a.f5267J = jSONObject.getInt("unknowmodel");
            }
            if (jSONObject.has("isallowgetroot")) {
                this.f5296a.f5266I = jSONObject.getInt("isallowgetroot");
            }
            if (jSONObject.has("unmatchmodel")) {
                this.f5296a.f5268K = jSONObject.getInt("unmatchmodel");
            }
            if (jSONObject.has("name")) {
                this.f5296a.f5274e = jSONObject.getString("name");
            }
            if (jSONObject.has("brandname")) {
                this.f5296a.f5275f = jSONObject.getString("brandname");
            }
            if (jSONObject.has(Constants.KEY_OS_VERSION)) {
                this.f5296a.f5270a = jSONObject.getString(Constants.KEY_OS_VERSION);
            }
            if (jSONObject.has("cpumodel")) {
                this.f5296a.f5271b = jSONObject.getString("cpumodel");
            }
            if (jSONObject.has("cpucorenum")) {
                this.f5296a.f5272c = jSONObject.getString("cpucorenum");
            }
            if (jSONObject.has("screensize")) {
                this.f5296a.f5273d = jSONObject.getString("screensize");
            }
            if (jSONObject.has("screen_chara")) {
                this.f5296a.f5276g = jSONObject.getString("screen_chara");
            }
            if (jSONObject.has("m_weight")) {
                this.f5296a.f5277h = jSONObject.getString("m_weight");
            }
            if (jSONObject.has("specification")) {
                this.f5296a.f5279j = jSONObject.getString("specification");
            }
            if (jSONObject.has("appearance")) {
                this.f5296a.f5278i = jSONObject.getString("appearance");
            }
            if (jSONObject.has("gprs")) {
                this.f5296a.f5280k = jSONObject.getString("gprs");
            }
            if (jSONObject.has("WIFI")) {
                this.f5296a.f5281l = jSONObject.getString("WIFI");
            }
            if (jSONObject.has("bluetooth")) {
                this.f5296a.f5282m = jSONObject.getString("bluetooth");
            }
            if (jSONObject.has("memory")) {
                this.f5296a.f5283n = jSONObject.getString("memory");
            }
            if (jSONObject.has("memory_capacity")) {
                this.f5296a.f5284o = jSONObject.getString("memory_capacity");
            }
            if (jSONObject.has("camerafu")) {
                this.f5296a.f5285p = jSONObject.getString("camerafu");
            }
            if (jSONObject.has("camera")) {
                this.f5296a.f5286q = jSONObject.getString("camera");
            }
            if (jSONObject.has("video")) {
                this.f5296a.f5287r = jSONObject.getString("video");
            }
            if (jSONObject.has("m_camera")) {
                this.f5296a.f5288s = jSONObject.getString("m_camera");
            }
            if (jSONObject.has("sensor")) {
                this.f5296a.f5289t = jSONObject.getString("sensor");
            }
            if (jSONObject.has("modelpic")) {
                this.f5296a.f5290u = jSONObject.getString("modelpic");
            }
            if (jSONObject.has("Gr-sensor")) {
                this.f5296a.f5291v = jSONObject.getInt("Gr-sensor");
                if (this.f5296a.f5291v == 0) {
                    this.f5296a.f5291v = C1082R.string.support;
                } else {
                    this.f5296a.f5291v = C1082R.string.nonsupport;
                }
            }
            if (jSONObject.has("lightSensor")) {
                this.f5296a.f5292w = jSONObject.getInt("lightSensor");
                if (this.f5296a.f5292w == 0) {
                    this.f5296a.f5292w = C1082R.string.support;
                } else {
                    this.f5296a.f5292w = C1082R.string.nonsupport;
                }
            }
            if (jSONObject.has("E-compass")) {
                this.f5296a.f5293x = jSONObject.getInt("E-compass");
                if (this.f5296a.f5293x == 0) {
                    this.f5296a.f5293x = C1082R.string.support;
                } else {
                    this.f5296a.f5293x = C1082R.string.nonsupport;
                }
            }
            if (jSONObject.has("proximitySensor")) {
                this.f5296a.f5294y = jSONObject.getInt("proximitySensor");
                if (this.f5296a.f5294y == 0) {
                    this.f5296a.f5294y = C1082R.string.support;
                } else {
                    this.f5296a.f5294y = C1082R.string.nonsupport;
                }
            }
            if (jSONObject.has("D-sensor")) {
                this.f5296a.f5295z = jSONObject.getInt("D-sensor");
                if (this.f5296a.f5295z == 0) {
                    this.f5296a.f5295z = C1082R.string.support;
                } else {
                    this.f5296a.f5295z = C1082R.string.nonsupport;
                }
            }
            if (jSONObject.has("A-sensor")) {
                this.f5296a.f5258A = jSONObject.getInt("A-sensor");
                if (this.f5296a.f5258A == 0) {
                    this.f5296a.f5258A = C1082R.string.support;
                } else {
                    this.f5296a.f5258A = C1082R.string.nonsupport;
                }
            }
            if (jSONObject.has("P-sensor")) {
                this.f5296a.f5259B = jSONObject.getInt("P-sensor");
                if (this.f5296a.f5259B == 0) {
                    this.f5296a.f5259B = C1082R.string.support;
                } else {
                    this.f5296a.f5259B = C1082R.string.nonsupport;
                }
            }
            if (jSONObject.has("T-sensor")) {
                this.f5296a.f5260C = jSONObject.getInt("T-sensor");
                if (this.f5296a.f5260C == 0) {
                    this.f5296a.f5260C = C1082R.string.support;
                } else {
                    this.f5296a.f5260C = C1082R.string.nonsupport;
                }
            }
            if (jSONObject.has("Gy-sensor")) {
                this.f5296a.f5261D = jSONObject.getInt("Gy-sensor");
                if (this.f5296a.f5261D == 0) {
                    this.f5296a.f5261D = C1082R.string.support;
                } else {
                    this.f5296a.f5261D = C1082R.string.nonsupport;
                }
            }
            if (jSONObject.has("glVendor_check")) {
                this.f5296a.f5262E = jSONObject.getInt("glVendor_check");
            }
            if (jSONObject.has("glRenderer_check")) {
                this.f5296a.f5263F = jSONObject.getInt("glRenderer_check");
            }
            if (jSONObject.has("resolution_check")) {
                this.f5296a.f5264G = jSONObject.getInt("resolution_check");
            }
            if (jSONObject.has("cpuname")) {
                this.f5296a.f5265H = jSONObject.getString("cpuname");
            }
        } catch (JSONException e) {
        }
        return this;
    }
}
