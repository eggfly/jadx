package com.dev.system.monitor;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.ShowcaseView.Builder;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;
import java.util.ArrayList;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class WiFiManagement extends Fragment {
    private DhcpInfo DHCPInfo;
    private BroadcastReceiver RSSIListener;
    private TextView RX;
    private TextView TX;
    private BroadcastReceiver WiFiListener;
    private GeneralInfoCard card;
    private Handler handler;
    private Activity mainActivity;
    private View rootView;
    private Runnable runnable;
    private ImageView signalImg;
    private long startRX;
    private long startTX;
    private ShowcaseView sv;
    private ArrayList<String> valuesBackup;
    private WifiInfo wifiInfo;
    private WifiManager wifiManager;

    /* renamed from: com.dev.system.monitor.WiFiManagement.1 */
    class C01381 implements Runnable {
        C01381() {
        }

        public void run() {
            try {
                if (((ConnectivityManager) WiFiManagement.this.mainActivity.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
                    long rxBytes = TrafficStats.getTotalRxBytes() - WiFiManagement.this.startRX;
                    if (rxBytes / 1073741824 > 0) {
                        WiFiManagement.this.RX.setText(Long.toString(rxBytes / 1073741824) + " GB/s");
                    } else if (rxBytes / 1048576 > 0) {
                        WiFiManagement.this.RX.setText(Long.toString(rxBytes / 1048576) + " MB/s");
                    } else if (rxBytes / 1024 > 0) {
                        WiFiManagement.this.RX.setText(Long.toString(rxBytes / 1024) + " KB/s");
                    } else {
                        WiFiManagement.this.RX.setText(Long.toString(rxBytes) + " B/s");
                    }
                    long txBytes = TrafficStats.getTotalTxBytes() - WiFiManagement.this.startTX;
                    WiFiManagement.this.startRX = WiFiManagement.this.startRX + rxBytes;
                    WiFiManagement.this.startTX = WiFiManagement.this.startTX + txBytes;
                    if (txBytes / 1073741824 > 0) {
                        WiFiManagement.this.TX.setText(Long.toString(txBytes / 1073741824) + " GB/s");
                    } else if (txBytes / 1048576 > 0) {
                        WiFiManagement.this.TX.setText(Long.toString(txBytes / 1048576) + " MB/s");
                    } else if (txBytes / 1024 > 0) {
                        WiFiManagement.this.TX.setText(Long.toString(txBytes / 1024) + " KB/s");
                    } else {
                        WiFiManagement.this.TX.setText(Long.toString(txBytes) + " B/s");
                    }
                }
            } catch (NullPointerException e) {
                WiFiManagement.this.TX.setText(BuildConfig.VERSION_NAME);
                WiFiManagement.this.RX.setText(BuildConfig.VERSION_NAME);
            }
            WiFiManagement.this.handler.postDelayed(this, 1000);
        }
    }

    /* renamed from: com.dev.system.monitor.WiFiManagement.2 */
    class C01392 extends BroadcastReceiver {
        C01392() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                new RSSIBroadcastReceiverTask(null).execute(new Void[0]);
            } catch (NullPointerException e) {
            }
        }
    }

    /* renamed from: com.dev.system.monitor.WiFiManagement.3 */
    class C01403 extends BroadcastReceiver {
        C01403() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                new WiFiBroadcastReceiverTask().execute(new Void[0]);
            } catch (NullPointerException e) {
            }
        }
    }

    /* renamed from: com.dev.system.monitor.WiFiManagement.4 */
    class C01414 implements OnLongClickListener {
        final /* synthetic */ boolean val$firstrun;

        C01414(boolean z) {
            this.val$firstrun = z;
        }

        public boolean onLongClick(View v) {
            boolean stat = true;
            if (this.val$firstrun) {
                WiFiManagement.this.sv.hide();
            }
            try {
                WifiManager access$800 = WiFiManagement.this.wifiManager;
                if (WiFiManagement.this.wifiManager.isWifiEnabled()) {
                    stat = false;
                }
                access$800.setWifiEnabled(stat);
                if (stat) {
                    Toast.makeText(WiFiManagement.this.getActivity(), WiFiManagement.this.getString(C0133R.string.wifi_on), 1).show();
                    WiFiManagement.this.wifiManager = (WifiManager) WiFiManagement.this.mainActivity.getSystemService("wifi");
                    WiFiManagement.this.wifiInfo = WiFiManagement.this.wifiManager.getConnectionInfo();
                    WiFiManagement.this.DHCPInfo = WiFiManagement.this.wifiManager.getDhcpInfo();
                    switch (WifiManager.calculateSignalLevel(WiFiManagement.this.wifiInfo.getRssi(), 3)) {
                        case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                            WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_low);
                            break;
                        case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                            WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_med);
                            break;
                        case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                            WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_full);
                            break;
                        default:
                            break;
                    }
                }
                WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_off);
                Toast.makeText(WiFiManagement.this.getActivity(), WiFiManagement.this.getString(C0133R.string.wifi_off), 1).show();
                WiFiManagement.this.TX.setText(BuildConfig.VERSION_NAME);
                WiFiManagement.this.RX.setText(BuildConfig.VERSION_NAME);
            } catch (Exception e) {
            }
            return false;
        }
    }

    private class GeneralWiFiInfoTask extends AsyncTask<Void, Void, Void> {
        ArrayList<String> info;
        ArrayList<String> value;

        public GeneralWiFiInfoTask() {
            this.info = new ArrayList();
            this.value = new ArrayList();
        }

        protected Void doInBackground(Void... params) {
            WiFiManagement.this.wifiManager = (WifiManager) WiFiManagement.this.mainActivity.getSystemService("wifi");
            WiFiManagement.this.wifiInfo = WiFiManagement.this.wifiManager.getConnectionInfo();
            WiFiManagement.this.DHCPInfo = WiFiManagement.this.wifiManager.getDhcpInfo();
            this.info.add(WiFiManagement.this.getString(C0133R.string.ip));
            this.value.add(WiFiManagement.this.intToIP(WiFiManagement.this.wifiInfo.getIpAddress()));
            this.info.add(WiFiManagement.this.getString(C0133R.string.mac));
            this.value.add(WiFiManagement.this.wifiInfo.getMacAddress());
            this.info.add("DNS 1");
            this.value.add(WiFiManagement.this.intToIP(WiFiManagement.this.DHCPInfo.dns1));
            this.info.add("DNS 2");
            this.value.add(WiFiManagement.this.intToIP(WiFiManagement.this.DHCPInfo.dns2));
            this.info.add("Gateway");
            this.value.add(WiFiManagement.this.intToIP(WiFiManagement.this.DHCPInfo.gateway));
            this.info.add(WiFiManagement.this.getString(C0133R.string.bandwidth));
            this.value.add(WiFiManagement.this.wifiInfo.getLinkSpeed() + " Mbps");
            publishProgress(new Void[0]);
            return null;
        }

        protected void onProgressUpdate(Void... values) {
            NetworkInfo wifi = ((ConnectivityManager) WiFiManagement.this.mainActivity.getSystemService("connectivity")).getNetworkInfo(1);
            try {
                WiFiManagement.this.mainActivity.setTitle(WiFiManagement.this.wifiInfo.getSSID().replace("\"", BuildConfig.VERSION_NAME) + " " + WiFiManagement.this.wifiInfo.getRssi() + " dB");
            } catch (NullPointerException e) {
                WiFiManagement.this.mainActivity.setTitle(WiFiManagement.this.getString(C0133R.string.wifi_not_conn));
            }
            if (wifi != null && wifi.isConnected() && WiFiManagement.this.wifiManager.isWifiEnabled()) {
                switch (WifiManager.calculateSignalLevel(WiFiManagement.this.wifiInfo.getRssi(), 3)) {
                    case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                        WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_low);
                        break;
                    case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                        WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_med);
                        break;
                    case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                        WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_full);
                        break;
                }
            }
            WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_off);
            WiFiManagement.this.TX.setText(BuildConfig.VERSION_NAME);
            WiFiManagement.this.RX.setText(BuildConfig.VERSION_NAME);
            WiFiManagement.this.initCard(this.info, this.value);
        }
    }

    private class RSSIBroadcastReceiverTask extends AsyncTask<Void, Void, Void> {
        private RSSIBroadcastReceiverTask() {
        }

        protected Void doInBackground(Void... params) {
            WiFiManagement.this.wifiManager = (WifiManager) WiFiManagement.this.mainActivity.getSystemService("wifi");
            WiFiManagement.this.wifiInfo = WiFiManagement.this.wifiManager.getConnectionInfo();
            WiFiManagement.this.DHCPInfo = WiFiManagement.this.wifiManager.getDhcpInfo();
            publishProgress(new Void[0]);
            return null;
        }

        protected void onProgressUpdate(Void... values) {
            NetworkInfo wifi = ((ConnectivityManager) WiFiManagement.this.mainActivity.getSystemService("connectivity")).getNetworkInfo(1);
            WiFiManagement.this.mainActivity.setTitle(WiFiManagement.this.wifiInfo.getSSID().replace("\"", BuildConfig.VERSION_NAME) + " " + WiFiManagement.this.wifiInfo.getRssi() + " dB");
            if (wifi != null && wifi.isConnected() && WiFiManagement.this.wifiManager.isWifiEnabled()) {
                switch (WifiManager.calculateSignalLevel(WiFiManagement.this.wifiInfo.getRssi(), 3)) {
                    case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                        WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_low);
                        return;
                    case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                        WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_med);
                        return;
                    case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                        WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_full);
                        return;
                    default:
                        return;
                }
            }
            WiFiManagement.this.signalImg.setImageResource(C0133R.drawable.wifi_off);
            WiFiManagement.this.TX.setText(BuildConfig.VERSION_NAME);
            WiFiManagement.this.RX.setText(BuildConfig.VERSION_NAME);
        }
    }

    private class WiFiBroadcastReceiverTask extends AsyncTask<Void, Void, Void> {
        ArrayList<String> info;
        ArrayList<String> value;

        public WiFiBroadcastReceiverTask() {
            this.info = new ArrayList();
            this.value = new ArrayList();
        }

        protected Void doInBackground(Void... params) {
            WiFiManagement.this.wifiManager = (WifiManager) WiFiManagement.this.mainActivity.getSystemService("wifi");
            WiFiManagement.this.wifiInfo = WiFiManagement.this.wifiManager.getConnectionInfo();
            WiFiManagement.this.DHCPInfo = WiFiManagement.this.wifiManager.getDhcpInfo();
            this.info.add(WiFiManagement.this.getString(C0133R.string.ip));
            this.value.add(WiFiManagement.this.intToIP(WiFiManagement.this.wifiInfo.getIpAddress()));
            this.info.add(WiFiManagement.this.getString(C0133R.string.mac));
            this.value.add(WiFiManagement.this.wifiInfo.getMacAddress());
            this.info.add("DNS 1");
            this.value.add(WiFiManagement.this.intToIP(WiFiManagement.this.DHCPInfo.dns1));
            this.info.add("DNS 2");
            this.value.add(WiFiManagement.this.intToIP(WiFiManagement.this.DHCPInfo.dns2));
            this.info.add("Gateway");
            this.value.add(WiFiManagement.this.intToIP(WiFiManagement.this.DHCPInfo.gateway));
            this.info.add(WiFiManagement.this.getString(C0133R.string.bandwidth));
            this.value.add(WiFiManagement.this.wifiInfo.getLinkSpeed() + " Mbps");
            for (int i = 0; i < WiFiManagement.this.valuesBackup.size(); i++) {
                if (!((String) WiFiManagement.this.valuesBackup.get(i)).equals(this.value.get(i))) {
                    publishProgress(new Void[0]);
                    break;
                }
            }
            WiFiManagement.this.valuesBackup = this.value;
            return null;
        }

        protected void onProgressUpdate(Void... values) {
            try {
                WiFiManagement.this.mainActivity.setTitle(WiFiManagement.this.wifiInfo.getSSID().replace("\"", BuildConfig.VERSION_NAME) + " " + WiFiManagement.this.wifiInfo.getRssi() + " dB");
            } catch (NullPointerException e) {
                WiFiManagement.this.mainActivity.setTitle(WiFiManagement.this.getString(C0133R.string.wifi_not_conn));
            }
            WiFiManagement.this.initCard(this.info, this.value);
        }
    }

    public WiFiManagement() {
        this.startRX = 0;
        this.startTX = 0;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.fragment_wifi, container, false);
        this.signalImg = (ImageView) this.rootView.findViewById(C0133R.id.signalImg);
        getActivity();
        boolean firstrun = getActivity().getSharedPreferences("PREFERENCE", 0).getBoolean("firstrun_fgr", true);
        if (firstrun) {
            getActivity();
            getActivity().getSharedPreferences("PREFERENCE", 0).edit().putBoolean("firstrun_fgr", false).commit();
            try {
                LayoutParams lps = new LayoutParams(-2, -2);
                lps.addRule(12);
                lps.addRule(9);
                int margin = Float.valueOf(getResources().getDisplayMetrics().density * 12.0f).intValue();
                if (VERSION.SDK_INT >= 19) {
                    lps.setMargins(margin, margin, margin, margin + 70);
                } else {
                    lps.setMargins(margin, margin, margin, margin);
                }
                this.sv = new Builder(getActivity(), true).setTarget(new ViewTarget(this.signalImg)).setContentTitle(getString(C0133R.string.tut_wifi)).setStyle(C0133R.style.CustomShowcaseTheme).setShowcaseEventListener(null).build();
                this.sv.setButtonPosition(lps);
                this.sv.show();
            } catch (NullPointerException e) {
            }
        }
        this.startRX = TrafficStats.getTotalRxBytes();
        this.startTX = TrafficStats.getTotalTxBytes();
        this.RX = (TextView) this.rootView.findViewById(C0133R.id.dataDown);
        this.TX = (TextView) this.rootView.findViewById(C0133R.id.dataUp);
        this.mainActivity = getActivity();
        this.runnable = new C01381();
        if (!(this.startRX == -1 || this.startTX == -1)) {
            this.handler = new Handler();
            this.handler.postDelayed(this.runnable, 1000);
        }
        new GeneralWiFiInfoTask().execute(new Void[0]);
        this.RSSIListener = new C01392();
        this.WiFiListener = new C01403();
        this.mainActivity.registerReceiver(this.RSSIListener, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
        this.mainActivity.registerReceiver(this.WiFiListener, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        this.signalImg.setOnLongClickListener(new C01414(firstrun));
        this.valuesBackup = new ArrayList();
        return this.rootView;
    }

    private String intToIP(int address) {
        return (address & MotionEventCompat.ACTION_MASK) + "." + ((address >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((address >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((address >> 24) & MotionEventCompat.ACTION_MASK);
    }

    public void onPause() {
        this.mainActivity.unregisterReceiver(this.RSSIListener);
        this.mainActivity.unregisterReceiver(this.WiFiListener);
        try {
            if (this.card != null) {
                this.card.unregisterDataSetObserver();
            }
        } catch (IllegalStateException e) {
        }
        super.onPause();
    }

    public void onResume() {
        this.mainActivity.registerReceiver(this.RSSIListener, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
        this.mainActivity.registerReceiver(this.WiFiListener, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        super.onResume();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value) {
        this.card = new GeneralInfoCard(getActivity(), info, value, getString(C0133R.string.wifi_info));
        this.card.init();
        ((CardView) this.rootView.findViewById(C0133R.id.carddemo_weathercard)).setCard(this.card);
    }
}
