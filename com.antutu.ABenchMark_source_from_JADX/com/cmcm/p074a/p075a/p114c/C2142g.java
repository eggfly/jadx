package com.cmcm.p074a.p075a.p114c;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.cmcm.a.a.c.g */
class C2142g extends BroadcastReceiver {
    final /* synthetic */ C2140e f7497a;

    private C2142g(C2140e c2140e) {
        this.f7497a = c2140e;
    }

    public void onReceive(Context context, Intent intent) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String action = intent.getAction();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
            this.f7497a.f7495a.put(bluetoothDevice.getAddress(), new C2143h(this.f7497a, bluetoothDevice, currentTimeMillis));
        } else if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED") && this.f7497a.f7495a.containsKey(bluetoothDevice.getAddress())) {
            if (bluetoothDevice.getBondState() == 12 || ((C2143h) this.f7497a.f7495a.get(bluetoothDevice.getAddress())).m8098a().getBondState() == 12) {
                this.f7497a.m8093a(bluetoothDevice, ((C2143h) this.f7497a.f7495a.get(bluetoothDevice.getAddress())).m8099b(), currentTimeMillis);
            }
            this.f7497a.f7495a.remove(bluetoothDevice.getAddress());
        }
    }
}
