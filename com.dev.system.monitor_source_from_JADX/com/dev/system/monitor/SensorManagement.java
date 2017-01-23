package com.dev.system.monitor;

import android.app.Activity;
import android.app.Fragment;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import it.gmariotti.cardslib.library.view.CardView;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SensorManagement extends Fragment implements SensorEventListener {
    private Sensor accelerometer;
    private GeneralInfoCard accelerometerCard;
    private Sensor gravity;
    private GeneralInfoCard gravityCard;
    private Sensor gyroscope;
    private GeneralInfoCard gyroscopeCard;
    private ArrayList<TextView>[] infoTextViews;
    private Sensor light;
    private GeneralInfoCard lightCard;
    private GeneralInfoCard magneticFieldCard;
    private Sensor magnetic_field;
    private Activity mainActivity;
    private Sensor pressure;
    private GeneralInfoCard pressureCard;
    private View rootView;
    private SensorManager sensorManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.fragment_sensors, container, false);
        this.mainActivity = getActivity();
        this.sensorManager = (SensorManager) this.mainActivity.getSystemService("sensor");
        this.light = this.sensorManager.getDefaultSensor(5);
        this.gravity = this.sensorManager.getDefaultSensor(9);
        this.accelerometer = this.sensorManager.getDefaultSensor(1);
        this.gyroscope = this.sensorManager.getDefaultSensor(4);
        this.magnetic_field = this.sensorManager.getDefaultSensor(2);
        this.pressure = this.sensorManager.getDefaultSensor(6);
        this.infoTextViews = new ArrayList[6];
        ArrayList<String> info = new ArrayList();
        ArrayList<String> value = new ArrayList();
        if (this.light != null) {
            info.clear();
            value.clear();
            info.add(getString(C0133R.string.light_sens));
            value.add("Loading");
            initCard(info, value, this.lightCard, getString(C0133R.string.light), 0, C0133R.id.card_sensors_light);
        } else {
            ((CardView) this.rootView.findViewById(C0133R.id.card_sensors_light)).setVisibility(8);
        }
        if (this.gravity != null) {
            info.clear();
            value.clear();
            info.add(getString(C0133R.string.x));
            value.add("Loading");
            info.add(getString(C0133R.string.y));
            value.add("Loading");
            info.add(getString(C0133R.string.z));
            value.add("Loading");
            initCard(info, value, this.gravityCard, getString(C0133R.string.gravity), 1, C0133R.id.card_sensors_gravity);
        } else {
            ((CardView) this.rootView.findViewById(C0133R.id.card_sensors_gravity)).setVisibility(8);
        }
        if (this.accelerometer != null) {
            info.clear();
            value.clear();
            info.add(getString(C0133R.string.x));
            value.add("Loading");
            info.add(getString(C0133R.string.y));
            value.add("Loading");
            info.add(getString(C0133R.string.z));
            value.add("Loading");
            initCard(info, value, this.accelerometerCard, getString(C0133R.string.acceleration), 2, C0133R.id.card_sensors_accelerometer);
        } else {
            ((CardView) this.rootView.findViewById(C0133R.id.card_sensors_accelerometer)).setVisibility(8);
        }
        if (this.gyroscope != null) {
            info.clear();
            value.clear();
            info.add(getString(C0133R.string.x));
            value.add("Loading");
            info.add(getString(C0133R.string.y));
            value.add("Loading");
            info.add(getString(C0133R.string.z));
            value.add("Loading");
            initCard(info, value, this.gyroscopeCard, getString(C0133R.string.gyroscope), 3, C0133R.id.card_sensors_gyroscope);
        } else {
            ((CardView) this.rootView.findViewById(C0133R.id.card_sensors_gyroscope)).setVisibility(8);
        }
        if (this.magnetic_field != null) {
            info.clear();
            value.clear();
            info.add(getString(C0133R.string.x));
            value.add("Loading");
            info.add(getString(C0133R.string.y));
            value.add("Loading");
            info.add(getString(C0133R.string.z));
            value.add("Loading");
            initCard(info, value, this.magneticFieldCard, getString(C0133R.string.magnetic_field), 4, C0133R.id.card_sensors_magnetic);
        } else {
            ((CardView) this.rootView.findViewById(C0133R.id.card_sensors_magnetic)).setVisibility(8);
        }
        if (this.pressure != null) {
            info.clear();
            value.clear();
            info.add(getString(C0133R.string.pressure_sens));
            value.add("Loading");
            initCard(info, value, this.pressureCard, getString(C0133R.string.pressure), 5, C0133R.id.card_sensors_pressure);
        } else {
            ((CardView) this.rootView.findViewById(C0133R.id.card_sensors_pressure)).setVisibility(8);
        }
        this.mainActivity.setTitle(getString(C0133R.string.sensor));
        return this.rootView;
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value, GeneralInfoCard card, String cardTitle, int index, int id) {
        card = new GeneralInfoCard(this.mainActivity, info, value, cardTitle);
        card.init();
        ((CardView) this.rootView.findViewById(id)).setCard(card);
        this.infoTextViews[index] = card.getTextViews();
    }

    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public final void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == 5 && this.light != null) {
            ((TextView) this.infoTextViews[0].get(0)).setText(event.values[0] + " lx");
        } else if (event.sensor.getType() == 1 && this.accelerometer != null) {
            ((TextView) this.infoTextViews[2].get(0)).setText(new DecimalFormat("#.##").format((double) event.values[0]) + " m/s\u00b2");
            ((TextView) this.infoTextViews[2].get(1)).setText(new DecimalFormat("#.##").format((double) event.values[1]) + " m/s\u00b2");
            ((TextView) this.infoTextViews[2].get(2)).setText(new DecimalFormat("#.##").format((double) event.values[2]) + " m/s\u00b2");
        } else if (event.sensor.getType() == 9 && this.gravity != null) {
            ((TextView) this.infoTextViews[1].get(0)).setText(new DecimalFormat("#.##").format((double) event.values[0]) + " m/s\u00b2");
            ((TextView) this.infoTextViews[1].get(1)).setText(new DecimalFormat("#.##").format((double) event.values[1]) + " m/s\u00b2");
            ((TextView) this.infoTextViews[1].get(2)).setText(new DecimalFormat("#.##").format((double) event.values[2]) + " m/s\u00b2");
        } else if (event.sensor.getType() == 4 && this.gyroscope != null) {
            ((TextView) this.infoTextViews[3].get(0)).setText(new DecimalFormat("#.##").format((double) event.values[0]) + " rad/s");
            ((TextView) this.infoTextViews[3].get(1)).setText(new DecimalFormat("#.##").format((double) event.values[1]) + " rad/s");
            ((TextView) this.infoTextViews[3].get(2)).setText(new DecimalFormat("#.##").format((double) event.values[2]) + " rad/s");
        } else if (event.sensor.getType() == 2 && this.magnetic_field != null) {
            ((TextView) this.infoTextViews[4].get(0)).setText(new DecimalFormat("#.##").format((double) event.values[0]) + " \u03bcT");
            ((TextView) this.infoTextViews[4].get(1)).setText(new DecimalFormat("#.##").format((double) event.values[1]) + " \u03bcT");
            ((TextView) this.infoTextViews[4].get(2)).setText(new DecimalFormat("#.##").format((double) event.values[2]) + " \u03bcT");
        } else if (event.sensor.getType() == 6 && this.pressure != null) {
            ((TextView) this.infoTextViews[5].get(0)).setText(new DecimalFormat("#.##").format((double) event.values[0]) + " hPa");
        }
    }

    public void onResume() {
        super.onResume();
        if (this.light != null) {
            this.sensorManager.registerListener(this, this.light, 3);
        }
        if (this.accelerometer != null) {
            this.sensorManager.registerListener(this, this.accelerometer, 3);
        }
        if (this.gravity != null) {
            this.sensorManager.registerListener(this, this.gravity, 3);
        }
        if (this.gyroscope != null) {
            this.sensorManager.registerListener(this, this.gyroscope, 3);
        }
        if (this.magnetic_field != null) {
            this.sensorManager.registerListener(this, this.magnetic_field, 3);
        }
        if (this.pressure != null) {
            this.sensorManager.registerListener(this, this.pressure, 3);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.light != null) {
            this.sensorManager.unregisterListener(this, this.light);
        }
        if (this.accelerometer != null) {
            this.sensorManager.unregisterListener(this, this.accelerometer);
        }
        if (this.gravity != null) {
            this.sensorManager.unregisterListener(this, this.gravity);
        }
        if (this.gyroscope != null) {
            this.sensorManager.unregisterListener(this, this.gyroscope);
        }
        if (this.magnetic_field != null) {
            this.sensorManager.unregisterListener(this, this.magnetic_field);
        }
        if (this.pressure != null) {
            this.sensorManager.unregisterListener(this, this.pressure);
        }
    }
}
