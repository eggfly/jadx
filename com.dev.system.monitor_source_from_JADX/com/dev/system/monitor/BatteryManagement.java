package com.dev.system.monitor;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;
import com.github.amlcurran.showcaseview.C0158R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;
import java.util.ArrayList;
import java.util.Iterator;

public class BatteryManagement extends Fragment {
    private BroadcastReceiver batteryInfo;
    private int batteryPct;
    private Intent batteryStatus;
    private GeneralInfoCard cardView;
    private PieGraph pieGraph;
    private View rootView;

    /* renamed from: com.dev.system.monitor.BatteryManagement.1 */
    class C00931 extends BroadcastReceiver {
        C00931() {
        }

        public void onReceive(Context context, Intent intent) {
            BatteryManagement.this.batteryPct = intent.getIntExtra("level", 100);
            BatteryManagement.this.pieGraph.removeSlices();
            PieSlice slice = new PieSlice();
            PieSlice _slice = new PieSlice();
            slice.setColor(Color.parseColor("#99CC00"));
            slice.setValue((float) BatteryManagement.this.batteryPct);
            _slice.setColor(Color.parseColor("#0099CC00"));
            _slice.setValue(((float) (100 - BatteryManagement.this.batteryPct)) + 1.0E-5f);
            BatteryManagement.this.pieGraph.addSlice(slice);
            BatteryManagement.this.pieGraph.addSlice(_slice);
            BatteryManagement.this.pieGraph.setInnerCircleRatio(150);
            Iterator it = BatteryManagement.this.pieGraph.getSlices().iterator();
            while (it.hasNext()) {
                PieSlice s = (PieSlice) it.next();
                s.setGoalValue(s.getValue());
            }
            BatteryManagement.this.pieGraph.setDuration(1000);
            BatteryManagement.this.pieGraph.setInterpolator(new AccelerateDecelerateInterpolator());
            BatteryManagement.this.pieGraph.animateToGoalValues();
            ((TextView) BatteryManagement.this.rootView.findViewById(C0133R.id.textView1)).setText(BatteryManagement.this.batteryPct + " %");
            int health = intent.getIntExtra("health", 0);
            int plugged = intent.getIntExtra("plugged", 0);
            String technology = intent.getExtras().getString("technology");
            float temperature = (float) intent.getIntExtra("temperature", 0);
            int voltage = intent.getIntExtra("voltage", 0);
            ArrayList<String> info = new ArrayList();
            ArrayList<String> value = new ArrayList();
            info.add(BatteryManagement.this.getString(C0133R.string.ba_power_source));
            value.add(plugged == 0 ? BatteryManagement.this.getString(C0133R.string.battery) : BatteryManagement.this.getString(C0133R.string.charge));
            info.add(BatteryManagement.this.getString(C0133R.string.ba_type));
            value.add(technology);
            info.add(BatteryManagement.this.getString(C0133R.string.temperature));
            value.add((temperature / 10.0f) + " \u00b0C");
            info.add(BatteryManagement.this.getString(C0133R.string.voltage));
            value.add(voltage + " mV");
            info.add(BatteryManagement.this.getString(C0133R.string.health));
            value.add(BatteryManagement.this.getBatteryHealth(health));
            BatteryManagement.this.initCard(info, value);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.fragment_battery, container, false);
        getActivity().setTitle(getString(C0133R.string.battery));
        IntentFilter ifilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        this.batteryPct = -1;
        this.pieGraph = (PieGraph) this.rootView.findViewById(C0133R.id.graph);
        this.batteryInfo = new C00931();
        getActivity().registerReceiver(this.batteryInfo, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return this.rootView;
    }

    public void onResume() {
        getActivity().registerReceiver(this.batteryInfo, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        super.onResume();
    }

    public void onPause() {
        getActivity().unregisterReceiver(this.batteryInfo);
        super.onPause();
    }

    private String getBatteryHealth(int health) {
        switch (health) {
            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                return getString(C0133R.string.unknown);
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                return getString(C0133R.string.good);
            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                return getString(C0133R.string.over_heat);
            case FragmentManagerImpl.ANIM_STYLE_FADE_ENTER /*5*/:
                return getString(C0133R.string.over_volt);
            case C0158R.styleable.ShowcaseView_sv_titleTextAppearance /*7*/:
                return getString(C0133R.string.cold);
            default:
                return getString(C0133R.string.unknown);
        }
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value) {
        this.cardView = new GeneralInfoCard(getActivity(), info, value, getString(C0133R.string.battery_info));
        this.cardView.init();
        ((CardView) this.rootView.findViewById(C0133R.id.card_battery)).setCard(this.cardView);
    }
}
