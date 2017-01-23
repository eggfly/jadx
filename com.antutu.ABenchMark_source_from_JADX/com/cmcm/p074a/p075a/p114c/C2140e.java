package com.cmcm.p074a.p075a.p114c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.c.e */
public class C2140e extends C2136b {
    Map f7495a;
    private C2142g f7496b;

    private void m8093a(BluetoothDevice bluetoothDevice, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceName", bluetoothDevice.getName());
            jSONObject.put("deviceAddress", bluetoothDevice.getAddress());
            if (bluetoothDevice.getBluetoothClass() != null) {
                jSONObject.put("deviceCategory", bluetoothDevice.getBluetoothClass().getDeviceClass());
            }
            if (VERSION.SDK_INT >= 18) {
                jSONObject.put("deviceBluetoothType", bluetoothDevice.getType());
            }
            jSONObject.put("startTime", i);
            jSONObject.put("endTime", i2);
            m8069a(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void m8095b() {
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            if (this.f7495a == null) {
                this.f7495a = new HashMap();
            } else {
                this.f7495a.clear();
            }
            this.f7496b = new C2142g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            m8068a(this.f7496b, intentFilter);
        }
    }

    public String m8096f() {
        return "bluetooth";
    }

    protected void m8097g() {
        if (this.f7496b != null) {
            m8067a(this.f7496b);
        }
        if (this.f7495a != null) {
            this.f7495a.clear();
        }
    }
}
