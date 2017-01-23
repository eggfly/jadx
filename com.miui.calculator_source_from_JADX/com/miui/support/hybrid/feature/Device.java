package com.miui.support.hybrid.feature;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.miui.support.hybrid.HybridFeature;
import com.miui.support.hybrid.HybridFeature.Mode;
import com.miui.support.hybrid.Request;
import com.miui.support.hybrid.Response;
import com.miui.support.telephony.TelephonyHelper;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Device implements HybridFeature {
    public void m3572a(Map<String, String> map) {
    }

    public Response m3571a(Request request) {
        if ("getDeviceInfo".equals(request.m3550a())) {
            return m3570a();
        }
        return new Response(204, "no such action");
    }

    public Mode m3573b(Request request) {
        if ("getDeviceInfo".equals(request.m3550a())) {
            return Mode.SYNC;
        }
        return null;
    }

    private Response m3570a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("romVersion", VERSION.RELEASE);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("deviceId", TelephonyHelper.m5238a().m5239b());
            return new Response(jSONObject);
        } catch (JSONException e) {
            JSONException jSONException = e;
            Log.e("Device", jSONException.getMessage());
            return new Response(200, jSONException.getMessage());
        }
    }
}
