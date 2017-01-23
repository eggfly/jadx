package com.miui.support.hybrid.feature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class Mipay implements HybridFeature {

    /* renamed from: com.miui.support.hybrid.feature.Mipay.1 */
    class C02611 extends LifecycleListener {
        final /* synthetic */ NativeInterface f2083a;
        final /* synthetic */ Request f2084b;
        final /* synthetic */ Mipay f2085c;

        C02611(Mipay mipay, NativeInterface nativeInterface, Request request) {
            this.f2085c = mipay;
            this.f2083a = nativeInterface;
            this.f2084b = request;
        }

        public void m3583a(int i, int i2, Intent intent) {
            if (i == 20140424) {
                Response response;
                this.f2083a.m3546b(this);
                if (i2 == -1) {
                    response = new Response(0, this.f2085c.m3585a(intent));
                } else if (i2 == 0) {
                    response = new Response(100, this.f2085c.m3585a(intent));
                } else {
                    response = new Response(200);
                }
                this.f2084b.m3558c().m3492a(response);
            }
        }
    }

    public void m3588a(Map<String, String> map) {
    }

    public Response m3587a(Request request) {
        if (!TextUtils.equals(request.m3550a(), "pay")) {
            return new Response(204, "no such action");
        }
        String string;
        NativeInterface e = request.m3560e();
        Activity a = e.m3544a();
        e.m3545a(new C02611(this, e, request));
        try {
            string = new JSONObject(request.m3556b()).getString("orderInfo");
        } catch (JSONException e2) {
            e2.printStackTrace();
            string = null;
        }
        return m3584a(a, string, null);
    }

    private JSONObject m3585a(Intent intent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", intent.getIntExtra("code", -1));
            CharSequence stringExtra = intent.getStringExtra("message");
            if (!TextUtils.isEmpty(stringExtra)) {
                jSONObject.put("message", stringExtra);
            }
            stringExtra = intent.getStringExtra("result");
            if (!TextUtils.isEmpty(stringExtra)) {
                jSONObject.put("result", stringExtra);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private Response m3584a(Activity activity, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return new Response(204, "order cannot be empty");
        }
        Intent intent = new Intent("com.xiaomi.action.MIPAY_PAY_ORDER");
        intent.setPackage("com.mipay.wallet");
        if (activity.getPackageManager().resolveActivity(intent, 0) == null) {
            return new Response(204, "mipay feature not available");
        }
        intent.putExtra("order", str);
        intent.putExtra("extra", bundle);
        activity.startActivityForResult(intent, 20140424);
        return null;
    }

    public Mode m3589b(Request request) {
        if (TextUtils.equals(request.m3550a(), "pay")) {
            return Mode.CALLBACK;
        }
        return null;
    }
}
