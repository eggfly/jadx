package com.dev.system.monitor;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.faizmalkani.floatingactionbutton.Fab;
import it.gmariotti.cardslib.library.view.CardView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class GPSManagement extends Fragment {
    private boolean GPS_Status;
    private GeneralInfoCard card;
    private int card_update;
    private ArrayList<String> info;
    private ImageView locationImg;
    private LocationManager locationManager;
    private BroadcastReceiver locationReceiver;
    private Activity mainActivity;
    private View rootView;
    private ArrayList<String> value;

    /* renamed from: com.dev.system.monitor.GPSManagement.1 */
    class C01071 implements OnClickListener {
        C01071() {
        }

        public void onClick(View arg0) {
            try {
                if (GPSManagement.this.locationManager.isProviderEnabled("gps")) {
                    GPSManagement.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + ((String) GPSManagement.this.card.getValue().get(GPSManagement.this.card.getInfo().indexOf("Latitude"))) + "," + ((String) GPSManagement.this.card.getValue().get(GPSManagement.this.card.getInfo().indexOf("Longitude"))) + "(Your position)")));
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.dev.system.monitor.GPSManagement.2 */
    class C01082 implements OnLongClickListener {
        C01082() {
        }

        public boolean onLongClick(View v) {
            new Builder(GPSManagement.this.mainActivity).setMessage(GPSManagement.this.getString(C0133R.string.gps_msg)).show();
            return false;
        }
    }

    /* renamed from: com.dev.system.monitor.GPSManagement.3 */
    class C01093 extends BroadcastReceiver {
        C01093() {
        }

        public void onReceive(Context context, Intent intent) {
            GPSManagement.this.locationManager = (LocationManager) GPSManagement.this.mainActivity.getSystemService("location");
            if (GPSManagement.this.locationManager.isProviderEnabled("gps")) {
                GPSManagement.this.locationImg.setImageResource(C0133R.drawable.satellite);
                GPSManagement.this.GPS_Status = true;
            }
        }
    }

    /* renamed from: com.dev.system.monitor.GPSManagement.4 */
    class C01124 implements OnLongClickListener {

        /* renamed from: com.dev.system.monitor.GPSManagement.4.1 */
        class C01101 implements DialogInterface.OnClickListener {
            C01101() {
            }

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }

        /* renamed from: com.dev.system.monitor.GPSManagement.4.2 */
        class C01112 implements DialogInterface.OnClickListener {
            C01112() {
            }

            public void onClick(DialogInterface dialog, int which) {
                GPSManagement.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 100);
                dialog.dismiss();
            }
        }

        C01124() {
        }

        public boolean onLongClick(View v) {
            Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
            try {
                GPSManagement.this.mainActivity.sendBroadcast(intent);
                if (intent.getBooleanExtra("enabled", false) || !GPSManagement.this.GPS_Status) {
                    GPSManagement.this.locate();
                }
            } catch (SecurityException e) {
                new Builder(GPSManagement.this.mainActivity).setMessage(!GPSManagement.this.GPS_Status ? GPSManagement.this.getString(C0133R.string.gps_msg_true) : GPSManagement.this.getString(C0133R.string.gps_msg_false)).setPositiveButton(GPSManagement.this.getString(C0133R.string.ok), new C01112()).setNegativeButton(GPSManagement.this.getString(C0133R.string.cancel), new C01101()).show();
            }
            return false;
        }
    }

    /* renamed from: com.dev.system.monitor.GPSManagement.5 */
    class C01135 implements LocationListener {
        C01135() {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
            if (GPSManagement.this.isAdded()) {
                GPSManagement.this.info = new ArrayList();
                GPSManagement.this.value = new ArrayList();
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.latitude));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.linking));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.longitude));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.linking));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.altitude));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.linking));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.speed));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.linking));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.precision));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.linking));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.satellites));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.linking));
                if (GPSManagement.this.card_update != 1) {
                    GPSManagement.this.initCard(GPSManagement.this.info, GPSManagement.this.value);
                }
                GPSManagement.this.card_update = 1;
            }
        }

        public void onProviderDisabled(String provider) {
            if (GPSManagement.this.isAdded()) {
                GPSManagement.this.info = new ArrayList();
                GPSManagement.this.value = new ArrayList();
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.latitude));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.no_link));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.longitude));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.no_link));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.altitude));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.no_link));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.speed));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.no_link));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.precision));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.no_link));
                GPSManagement.this.info.add(GPSManagement.this.getString(C0133R.string.satellites));
                GPSManagement.this.value.add(GPSManagement.this.getString(C0133R.string.no_link));
                if (GPSManagement.this.card_update != 2) {
                    GPSManagement.this.initCard(GPSManagement.this.info, GPSManagement.this.value);
                }
                GPSManagement.this.card_update = 2;
            }
        }

        public void onLocationChanged(Location location) {
            new GPSTask().execute(new Location[]{location});
        }
    }

    private class GPSTask extends AsyncTask<Location, Void, Void> {
        private ArrayList<String> info;
        private ArrayList<String> value;

        public GPSTask() {
            this.info = new ArrayList();
            this.value = new ArrayList();
        }

        protected Void doInBackground(Location... params) {
            try {
                if (GPSManagement.this.isAdded()) {
                    this.info.add(GPSManagement.this.getString(C0133R.string.latitude));
                    this.value.add(params[0].getLatitude() + BuildConfig.VERSION_NAME);
                    this.info.add(GPSManagement.this.getString(C0133R.string.longitude));
                    this.value.add(params[0].getLongitude() + BuildConfig.VERSION_NAME);
                    this.info.add(GPSManagement.this.getString(C0133R.string.altitude));
                    this.value.add(new DecimalFormat("#.###").format(params[0].getAltitude()) + " m");
                    this.info.add(GPSManagement.this.getString(C0133R.string.speed));
                    this.value.add((((double) params[0].getSpeed()) * 3.6d) + " Km/h");
                    this.info.add(GPSManagement.this.getString(C0133R.string.precision));
                    this.value.add(params[0].getAccuracy() + " m");
                    this.info.add(GPSManagement.this.getString(C0133R.string.satellites));
                    this.value.add(params[0].getExtras().getInt("satellites") + BuildConfig.VERSION_NAME);
                } else {
                    this.info.add("Latitude");
                    this.value.add(params[0].getLatitude() + BuildConfig.VERSION_NAME);
                    this.info.add("Longitude");
                    this.value.add(params[0].getLongitude() + BuildConfig.VERSION_NAME);
                    this.info.add("Altitude");
                    this.value.add(new DecimalFormat("#.###").format(params[0].getAltitude()) + " m");
                    this.info.add("Speed");
                    this.value.add((((double) params[0].getSpeed()) * 3.6d) + " Km/h");
                    this.info.add("Precision");
                    this.value.add(params[0].getAccuracy() + " m");
                    this.info.add("Satellites");
                    this.value.add(params[0].getExtras().getInt("satellites") + BuildConfig.VERSION_NAME);
                }
            } catch (IllegalStateException e) {
                try {
                    Intent intent = GPSManagement.this.mainActivity.getIntent();
                    GPSManagement.this.mainActivity.finish();
                    GPSManagement.this.startActivity(intent);
                } catch (Exception e2) {
                }
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            GPSManagement.this.initCard(this.info, this.value);
        }
    }

    public GPSManagement() {
        this.card_update = -1;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.fragment_gps, container, false);
        this.mainActivity = getActivity();
        this.mainActivity.setTitle("Global Position System");
        Fab mFab = (Fab) this.rootView.findViewById(C0133R.id.fabbutton);
        mFab.setFabColor(-1);
        mFab.setFabDrawable(getResources().getDrawable(17301561));
        mFab.setOnClickListener(new C01071());
        mFab.setOnLongClickListener(new C01082());
        mFab.showFab();
        this.locationImg = (ImageView) this.rootView.findViewById(C0133R.id.signalMobileImg);
        this.locationManager = (LocationManager) this.mainActivity.getSystemService("location");
        if (this.locationManager.isProviderEnabled("gps")) {
            this.locationImg.setImageResource(C0133R.drawable.satellite);
            this.GPS_Status = true;
        } else {
            this.locationImg.setImageResource(C0133R.drawable.satelliteoff);
            this.GPS_Status = false;
        }
        locate();
        this.locationReceiver = new C01093();
        this.mainActivity.registerReceiver(this.locationReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
        this.locationImg.setOnLongClickListener(new C01124());
        return this.rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            this.locationManager = (LocationManager) this.mainActivity.getSystemService("location");
            if (this.locationManager.isProviderEnabled("gps")) {
                this.locationImg.setImageResource(C0133R.drawable.satellite);
                this.GPS_Status = true;
            } else {
                this.locationImg.setImageResource(C0133R.drawable.satelliteoff);
                this.GPS_Status = false;
            }
            locate();
        }
    }

    private void locate() {
        this.locationManager = (LocationManager) this.mainActivity.getSystemService("location");
        if (this.locationManager.getLastKnownLocation(this.locationManager.getBestProvider(new Criteria(), false)) != null) {
            new GPSTask().execute(new Location[]{location});
        } else if (this.locationManager.isProviderEnabled("gps")) {
            if (isAdded()) {
                this.info = new ArrayList();
                this.value = new ArrayList();
                this.info.add(getString(C0133R.string.latitude));
                this.value.add(getString(C0133R.string.linking));
                this.info.add(getString(C0133R.string.longitude));
                this.value.add(getString(C0133R.string.linking));
                this.info.add(getString(C0133R.string.altitude));
                this.value.add(getString(C0133R.string.linking));
                this.info.add(getString(C0133R.string.speed));
                this.value.add(getString(C0133R.string.linking));
                this.info.add(getString(C0133R.string.precision));
                this.value.add(getString(C0133R.string.linking));
                this.info.add(getString(C0133R.string.satellites));
                this.value.add(getString(C0133R.string.linking));
                if (this.card_update != 0) {
                    initCard(this.info, this.value);
                }
                this.card_update = 0;
            }
            this.locationManager.requestLocationUpdates("gps", 2500, 1.0f, new C01135());
        } else if (isAdded()) {
            this.info = new ArrayList();
            this.value = new ArrayList();
            this.info.add(getString(C0133R.string.latitude));
            this.value.add(getString(C0133R.string.no_link));
            this.info.add(getString(C0133R.string.longitude));
            this.value.add(getString(C0133R.string.no_link));
            this.info.add(getString(C0133R.string.altitude));
            this.value.add(getString(C0133R.string.no_link));
            this.info.add(getString(C0133R.string.speed));
            this.value.add(getString(C0133R.string.no_link));
            this.info.add(getString(C0133R.string.precision));
            this.value.add(getString(C0133R.string.no_link));
            this.info.add(getString(C0133R.string.satellites));
            this.value.add(getString(C0133R.string.no_link));
            if (this.card_update != 3) {
                initCard(this.info, this.value);
            }
            this.card_update = 3;
        }
    }

    public void onPause() {
        this.mainActivity.unregisterReceiver(this.locationReceiver);
        try {
            if (this.card != null) {
                this.card.unregisterDataSetObserver();
            }
        } catch (IllegalStateException e) {
        }
        super.onPause();
    }

    public void onResume() {
        this.mainActivity.registerReceiver(this.locationReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
        super.onResume();
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value) {
        if (isAdded()) {
            this.card = new GeneralInfoCard(this.mainActivity, info, value, getString(C0133R.string.gps));
            this.card.init();
            ((CardView) this.rootView.findViewById(C0133R.id.card_mobile)).setCard(this.card);
        }
    }
}
