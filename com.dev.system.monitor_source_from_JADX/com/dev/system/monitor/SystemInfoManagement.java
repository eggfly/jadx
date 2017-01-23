package com.dev.system.monitor;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fortysevendeg.swipelistview.C0149R;
import it.gmariotti.cardslib.library.view.CardView;
import java.util.ArrayList;

public class SystemInfoManagement extends Fragment {
    private GeneralInfoCard card;
    private Activity mainActivity;
    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.fragment_system_info, container, false);
        this.mainActivity = getActivity();
        this.mainActivity.setTitle(getString(C0133R.string.system));
        ArrayList<String> info = new ArrayList();
        ArrayList<String> value = new ArrayList();
        info.add(getString(C0133R.string.name));
        value.add(getVersionName());
        info.add("Version");
        value.add(VERSION.RELEASE);
        info.add("API");
        value.add(VERSION.SDK);
        info.add("Kernel");
        value.add(System.getProperty("os.version"));
        info.add("Build Number");
        value.add(getBuildNumber());
        info.add("Device");
        value.add(Build.DEVICE);
        info.add(getString(C0133R.string.model));
        value.add(Build.MODEL);
        info.add(getString(C0133R.string.product));
        value.add(Build.PRODUCT);
        initCard(info, value);
        return this.rootView;
    }

    private String getVersionName() {
        switch (VERSION.SDK_INT) {
            case C0149R.styleable.MenuItem_actionLayout /*14*/:
            case C0149R.styleable.MenuItem_actionViewClass /*15*/:
                return "Ice Cream Sandwich";
            case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
            case C0149R.styleable.ActionBar_progressBarPadding /*17*/:
            case C0149R.styleable.ActionBar_itemPadding /*18*/:
                return "Jelly Bean";
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return "KitKat";
            case 20:
                return "KitKat Watch";
            case 21:
            case 22:
                return "Lollipop";
            case 23:
                return "Marshmallow";
            default:
                return "Android";
        }
    }

    private String getBuildNumber() {
        String fingerPrint = Build.FINGERPRINT;
        char temp = '/';
        int i = 0;
        int slashes = 0;
        while (i < fingerPrint.length()) {
            if (fingerPrint.charAt(i) == '\\' || fingerPrint.charAt(i) == '/') {
                slashes++;
                temp = fingerPrint.charAt(i);
            }
            if (slashes == 3) {
                try {
                    return fingerPrint.substring(i + 1, fingerPrint.substring(i + 1).indexOf(temp) + i);
                } catch (StringIndexOutOfBoundsException e) {
                    return fingerPrint;
                }
            }
            i++;
        }
        return getVersionName();
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value) {
        this.card = new GeneralInfoCard(this.mainActivity, info, value, "Android");
        this.card.init();
        ((CardView) this.rootView.findViewById(C0133R.id.card_system_info)).setCard(this.card);
    }
}
