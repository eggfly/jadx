package com.miui.support.hybrid.feature;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.miui.support.hybrid.Callback;
import com.miui.support.hybrid.HybridFeature;
import com.miui.support.hybrid.HybridFeature.Mode;
import com.miui.support.hybrid.LifecycleListener;
import com.miui.support.hybrid.NativeInterface;
import com.miui.support.hybrid.Request;
import com.miui.support.hybrid.Response;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Share implements HybridFeature {

    /* renamed from: com.miui.support.hybrid.feature.Share.1 */
    class C02631 extends LifecycleListener {
        final /* synthetic */ NativeInterface f2093a;
        final /* synthetic */ Callback f2094b;
        final /* synthetic */ Share f2095c;

        C02631(Share share, NativeInterface nativeInterface, Callback callback) {
            this.f2095c = share;
            this.f2093a = nativeInterface;
            this.f2094b = callback;
        }

        public void m3602a(int i, int i2, Intent intent) {
            Response response;
            this.f2093a.m3546b(this);
            if (i2 == -1) {
                response = new Response(0, "success");
            } else if (i2 == 0) {
                response = new Response(100, "cancel");
            } else {
                response = new Response(200);
            }
            this.f2094b.m3492a(response);
        }
    }

    public void m3605a(Map<String, String> map) {
    }

    public Response m3604a(Request request) {
        if ("send".equals(request.m3550a())) {
            return m3603c(request);
        }
        return new Response(204, "no such action");
    }

    private Response m3603c(Request request) {
        NativeInterface e = request.m3560e();
        Activity a = e.m3544a();
        Callback c = request.m3558c();
        e.m3545a(new C02631(this, e, c));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        String b = request.m3556b();
        try {
            JSONObject jSONObject = new JSONObject(b);
            String string = jSONObject.getString("type");
            String string2 = jSONObject.getString("data");
            if (string == null || string2 == null) {
                c.m3492a(new Response(200, "no data to share"));
                return null;
            }
            intent.setType(string);
            if (string.startsWith("text/")) {
                intent.putExtra("android.intent.extra.TEXT", string2);
            } else {
                intent.putExtra("android.intent.extra.STREAM", string2);
            }
            a.startActivityForResult(intent, 1);
            return null;
        } catch (JSONException e2) {
            Log.i("HybridShare", "invalid JSON string:" + b);
            c.m3492a(new Response(200, "invalid data to share"));
        }
    }

    public Mode m3606b(Request request) {
        return Mode.CALLBACK;
    }
}
