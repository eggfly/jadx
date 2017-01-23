package com.miui.support.hybrid.feature;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
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

public class Network implements HybridFeature {
    private IntentFilter f2089a;
    private Callback f2090b;
    private NetworkStateReceiver f2091c;
    private LifecycleListener f2092d;

    /* renamed from: com.miui.support.hybrid.feature.Network.1 */
    class C02621 extends LifecycleListener {
        final /* synthetic */ NativeInterface f2086a;
        final /* synthetic */ Network f2087b;

        C02621(Network network, NativeInterface nativeInterface) {
            this.f2087b = network;
            this.f2086a = nativeInterface;
        }

        public void m3591a() {
            m3590g();
        }

        public void m3592f() {
            m3590g();
        }

        private void m3590g() {
            this.f2087b.m3594a(this.f2086a);
            this.f2087b.f2090b.m3492a(new Response(100));
        }
    }

    private class NetworkStateReceiver extends BroadcastReceiver {
        final /* synthetic */ Network f2088a;

        private NetworkStateReceiver(Network network) {
            this.f2088a = network;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getExtras() != null) {
                boolean z = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getState() == State.CONNECTED;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("connected", z);
                    this.f2088a.f2090b.m3492a(new Response(jSONObject));
                } catch (JSONException e) {
                    Log.e("Network", e.getMessage());
                }
            }
        }
    }

    public Network() {
        this.f2089a = new IntentFilter();
        this.f2089a.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public void m3600a(Map<String, String> map) {
    }

    public Response m3599a(Request request) {
        String a = request.m3550a();
        if ("getType".equals(a)) {
            return m3596c(request);
        }
        if ("enableNotification".equals(a)) {
            return m3597d(request);
        }
        if ("disableNotification".equals(a)) {
            return m3598e(request);
        }
        return new Response(204, "no such action");
    }

    private Response m3596c(Request request) {
        boolean isActiveNetworkMetered = ((ConnectivityManager) request.m3560e().m3544a().getSystemService("connectivity")).isActiveNetworkMetered();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metered", isActiveNetworkMetered);
        } catch (JSONException e) {
            Log.e("Network", e.getMessage());
        }
        return new Response(jSONObject);
    }

    private void m3594a(NativeInterface nativeInterface) {
        if (this.f2091c != null) {
            Activity a = nativeInterface.m3544a();
            nativeInterface.m3546b(this.f2092d);
            a.unregisterReceiver(this.f2091c);
            this.f2091c = null;
        }
    }

    private Response m3597d(Request request) {
        NativeInterface e = request.m3560e();
        m3594a(e);
        Activity a = e.m3544a();
        this.f2090b = request.m3558c();
        this.f2091c = new NetworkStateReceiver();
        a.registerReceiver(this.f2091c, this.f2089a);
        this.f2092d = new C02621(this, e);
        e.m3545a(this.f2092d);
        return null;
    }

    private Response m3598e(Request request) {
        m3594a(request.m3560e());
        return new Response(100);
    }

    public Mode m3601b(Request request) {
        String a = request.m3550a();
        if ("getType".equals(a)) {
            return Mode.SYNC;
        }
        if ("enableNotification".equals(a)) {
            return Mode.CALLBACK;
        }
        if ("disableNotification".equals(a)) {
            return Mode.SYNC;
        }
        return null;
    }
}
