package com.dev.system.monitor;

import android.app.Activity;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.fortysevendeg.swipelistview.C0149R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;
import java.util.ArrayList;

public class BluetoothManagement extends Fragment {
    private BluetoothAdapter bluetoothAdapter;
    private BroadcastReceiver bluetoothChanged;
    private ImageView bluetoothState;
    private GeneralInfoCard card;
    private Activity mainActivity;
    private View rootView;

    /* renamed from: com.dev.system.monitor.BluetoothManagement.1 */
    class C00951 implements OnLongClickListener {
        C00951() {
        }

        public boolean onLongClick(View v) {
            try {
                boolean state;
                if (BluetoothManagement.this.bluetoothAdapter.isEnabled()) {
                    BluetoothManagement.this.bluetoothState.setImageResource(C0133R.drawable.bluetooth_off);
                    state = BluetoothManagement.this.bluetoothAdapter.disable();
                } else {
                    BluetoothManagement.this.bluetoothState.setImageResource(C0133R.drawable.bluetooth_on);
                    state = BluetoothManagement.this.bluetoothAdapter.enable();
                }
                if (!state) {
                    Toast.makeText(BluetoothManagement.this.mainActivity, BluetoothManagement.this.getString(C0133R.string.b_err), 1).show();
                }
            } catch (NullPointerException e) {
                Toast.makeText(BluetoothManagement.this.mainActivity, BluetoothManagement.this.getString(C0133R.string.b_not_av_msg), 1).show();
            }
            return false;
        }
    }

    /* renamed from: com.dev.system.monitor.BluetoothManagement.2 */
    class C00962 extends BroadcastReceiver {
        C00962() {
        }

        public void onReceive(Context context, Intent intent) {
            ArrayList<String> info;
            ArrayList<String> value;
            try {
                BluetoothManagement.this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                info = new ArrayList();
                value = new ArrayList();
                info.add(BluetoothManagement.this.getString(C0133R.string.mac));
                value.add(BluetoothManagement.this.bluetoothAdapter.getAddress());
                info.add(BluetoothManagement.this.getString(C0133R.string.b_device_name));
                value.add(BluetoothManagement.this.bluetoothAdapter.getName());
                info.add(BluetoothManagement.this.getString(C0133R.string.b_visibility));
                switch (BluetoothManagement.this.bluetoothAdapter.getScanMode()) {
                    case 20:
                        value.add(BluetoothManagement.this.getString(C0133R.string.b_not_vi));
                        break;
                    case 21:
                        value.add(BluetoothManagement.this.getString(C0133R.string.b_con));
                        break;
                    case 23:
                        value.add(BluetoothManagement.this.getString(C0133R.string.b_con));
                        break;
                }
                switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1)) {
                    case Card.CLICK_LISTENER_CONTENT_VIEW /*10*/:
                        BluetoothManagement.this.bluetoothState.setImageResource(C0133R.drawable.bluetooth_off);
                        break;
                    case C0149R.styleable.MenuItem_android_onClick /*12*/:
                        BluetoothManagement.this.bluetoothState.setImageResource(C0133R.drawable.bluetooth_on);
                        break;
                }
                BluetoothManagement.this.initCard(info, value);
            } catch (NullPointerException e) {
                Toast.makeText(BluetoothManagement.this.mainActivity, BluetoothManagement.this.getString(C0133R.string.b_not_av_msg), 1).show();
                info = new ArrayList();
                value = new ArrayList();
                info.add(BluetoothManagement.this.getString(C0133R.string.mac));
                value.add(BluetoothManagement.this.getString(C0133R.string.b_not_av));
                info.add(BluetoothManagement.this.getString(C0133R.string.b_device_name));
                value.add(BluetoothManagement.this.getString(C0133R.string.b_not_av));
                info.add(BluetoothManagement.this.getString(C0133R.string.b_visibility));
                BluetoothManagement.this.bluetoothState.setImageResource(C0133R.drawable.bluetooth_off);
                value.add(BluetoothManagement.this.getString(C0133R.string.b_not_vi));
                BluetoothManagement.this.initCard(info, value);
            } catch (RuntimeException e2) {
                if (!BluetoothManagement.this.isAdded()) {
                    info = new ArrayList();
                    value = new ArrayList();
                    info.add("MAC Address");
                    value.add("Not available");
                    info.add("Device Name");
                    value.add("Not available");
                    info.add("Visibility");
                    value.add("Not visible");
                    BluetoothManagement.this.initCard(info, value);
                }
                BluetoothManagement.this.mainActivity.unregisterReceiver(BluetoothManagement.this.bluetoothChanged);
                BluetoothManagement.this.mainActivity.registerReceiver(BluetoothManagement.this.bluetoothChanged, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayList<String> info;
        this.rootView = inflater.inflate(C0133R.layout.fragment_bluetooth, container, false);
        this.mainActivity = getActivity();
        this.bluetoothState = (ImageView) this.rootView.findViewById(C0133R.id.bluetooth_state);
        ArrayList<String> value;
        try {
            this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            info = new ArrayList();
            value = new ArrayList();
            info.add(getString(C0133R.string.mac));
            value.add(this.bluetoothAdapter.getAddress());
            info.add(getString(C0133R.string.b_device_name));
            value.add(this.bluetoothAdapter.getName());
            info.add(getString(C0133R.string.b_visibility));
            this.mainActivity.setTitle("Bluetooth");
            if (this.bluetoothAdapter.isEnabled()) {
                this.bluetoothState.setImageResource(C0133R.drawable.bluetooth_on);
            } else {
                this.bluetoothState.setImageResource(C0133R.drawable.bluetooth_off);
            }
            switch (this.bluetoothAdapter.getScanMode()) {
                case 20:
                    value.add(getString(C0133R.string.b_not_vi));
                    break;
                case 21:
                    value.add(getString(C0133R.string.b_con));
                    break;
                case 23:
                    value.add(getString(C0133R.string.b_vi));
                    break;
            }
            initCard(info, value);
        } catch (NullPointerException e) {
            Toast.makeText(this.mainActivity, getString(C0133R.string.b_not_av_msg), 1).show();
            info = new ArrayList();
            value = new ArrayList();
            info.add(getString(C0133R.string.mac));
            value.add(this.bluetoothAdapter != null ? this.bluetoothAdapter.getAddress() : "Not available");
            info.add(getString(C0133R.string.b_device_name));
            value.add(this.bluetoothAdapter != null ? this.bluetoothAdapter.getName() : "Not available");
            info.add(getString(C0133R.string.b_visibility));
            this.mainActivity.setTitle("Bluetooth");
            this.bluetoothState.setImageResource(C0133R.drawable.bluetooth_off);
            value.add(getString(C0133R.string.b_not_vi));
            initCard(info, value);
        }
        this.bluetoothState.setOnLongClickListener(new C00951());
        this.bluetoothChanged = new C00962();
        this.mainActivity.registerReceiver(this.bluetoothChanged, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        return this.rootView;
    }

    public void onPause() {
        super.onPause();
        this.mainActivity.unregisterReceiver(this.bluetoothChanged);
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value) {
        if (isAdded()) {
            this.card = new GeneralInfoCard(this.mainActivity, info, value, getString(C0133R.string.bluetooth_info));
        } else {
            this.card = new GeneralInfoCard(this.mainActivity, info, value, "Bluetooth Network Information");
        }
        this.card.init();
        ((CardView) this.rootView.findViewById(C0133R.id.card_mobile)).setCard(this.card);
    }
}
