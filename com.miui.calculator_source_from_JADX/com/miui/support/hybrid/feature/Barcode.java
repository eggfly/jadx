package com.miui.support.hybrid.feature;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.miui.support.hybrid.HybridFeature;
import com.miui.support.hybrid.HybridFeature.Mode;
import com.miui.support.hybrid.LifecycleListener;
import com.miui.support.hybrid.NativeInterface;
import com.miui.support.hybrid.Request;
import com.miui.support.hybrid.Response;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Barcode implements HybridFeature {
    private static final int f2078a;

    /* renamed from: com.miui.support.hybrid.feature.Barcode.1 */
    class C02591 extends LifecycleListener {
        final /* synthetic */ NativeInterface f2075a;
        final /* synthetic */ Request f2076b;
        final /* synthetic */ Barcode f2077c;

        C02591(Barcode barcode, NativeInterface nativeInterface, Request request) {
            this.f2077c = barcode;
            this.f2075a = nativeInterface;
            this.f2076b = request;
        }

        public void m3563a(int i, int i2, Intent intent) {
            if (i == Barcode.f2078a) {
                Response response;
                this.f2075a.m3546b(this);
                if (i2 == -1) {
                    response = new Response(0, this.f2077c.m3565a(intent));
                } else if (i2 == 0) {
                    response = new Response(100);
                } else {
                    response = new Response(200);
                }
                this.f2076b.m3558c().m3492a(response);
            }
        }
    }

    static {
        f2078a = "REQUEST_SCAN_BARCODE".hashCode();
    }

    public void m3568a(Map<String, String> map) {
    }

    public Response m3567a(Request request) {
        if (!TextUtils.equals(request.m3550a(), "scan")) {
            return new Response(204, "no such action");
        }
        NativeInterface e = request.m3560e();
        Activity a = e.m3544a();
        Intent intent = new Intent("android.intent.action.scanbarcode");
        intent.addCategory("com.miui.support.intent.category.SYSAPP_TOOL");
        intent.putExtra("isBackToThirdApp", true);
        if (a.getPackageManager().resolveActivity(intent, 0) == null) {
            request.m3558c().m3492a(new Response(204, "can't find barcode scanner activity"));
            return null;
        }
        e.m3545a(new C02591(this, e, request));
        a.startActivityForResult(intent, f2078a);
        return null;
    }

    private JSONObject m3565a(Intent intent) {
        if (intent == null) {
            return null;
        }
        int intExtra = intent.getIntExtra("type", -1);
        String stringExtra = intent.getStringExtra("result");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", intExtra);
            jSONObject.put("result", stringExtra);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public Mode m3569b(Request request) {
        if (TextUtils.equals(request.m3550a(), "scan")) {
            return Mode.CALLBACK;
        }
        return null;
    }
}
