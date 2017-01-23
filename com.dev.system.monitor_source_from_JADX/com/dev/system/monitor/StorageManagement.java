package com.dev.system.monitor;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;
import it.gmariotti.cardslib.library.view.CardView;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class StorageManagement extends Fragment {
    private GeneralInfoCard card;
    private Activity mainActivity;
    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.fragment_storage, container, false);
        this.mainActivity = getActivity();
        this.mainActivity.setTitle(getString(C0133R.string.storage));
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long kbAvailable = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024;
        long kbTotal = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 1024;
        ArrayList<String> info = new ArrayList();
        ArrayList<String> values = new ArrayList();
        info.add(getString(C0133R.string.total_mem));
        values.add(getMostSuitableSizeUnit((double) kbTotal));
        info.add(getString(C0133R.string.available_mem));
        values.add(getMostSuitableSizeUnit((double) kbAvailable));
        double d = (double) (kbTotal - (kbTotal - kbAvailable));
        double d2 = (double) kbTotal;
        ((TextView) this.rootView.findViewById(C0133R.id.stat_main_storage)).setText(new DecimalFormat("#.##").format(100.0d - ((r0 / r0) * 100.0d)) + " %");
        initCard(info, values, getString(C0133R.string.internal_storage), C0133R.id.card_main_storage);
        PieGraph pieGraph = (PieGraph) this.rootView.findViewById(C0133R.id.graph_main_storage);
        PieSlice slice = new PieSlice();
        PieSlice _slice = new PieSlice();
        slice.setColor(Color.parseColor("#99CC00"));
        slice.setValue((float) kbAvailable);
        _slice.setColor(Color.parseColor("#FFBB33"));
        _slice.setValue((float) (kbTotal - kbAvailable));
        pieGraph.addSlice(slice);
        pieGraph.addSlice(_slice);
        pieGraph.setInnerCircleRatio(150);
        Iterator it = pieGraph.getSlices().iterator();
        while (it.hasNext()) {
            PieSlice s = (PieSlice) it.next();
            s.setGoalValue(s.getValue());
        }
        pieGraph.setDuration(1000);
        pieGraph.setInterpolator(new AccelerateDecelerateInterpolator());
        pieGraph.animateToGoalValues();
        String sdPath = getExternalStoragePath();
        if (sdPath != null) {
            statFs = new StatFs(new File(sdPath).getPath());
            kbAvailable = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024;
            kbTotal = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 1024;
            if (Double.isNaN(100.0d - ((((double) (kbTotal - (kbTotal - kbAvailable))) / ((double) kbTotal)) * 100.0d))) {
                ((PieGraph) this.rootView.findViewById(C0133R.id.graph_extra_storage)).setVisibility(8);
                ((CardView) this.rootView.findViewById(C0133R.id.card_extra_storage)).setVisibility(8);
                return this.rootView;
            }
            info.clear();
            values.clear();
            info.add(getString(C0133R.string.total_mem));
            values.add(getMostSuitableSizeUnit((double) kbTotal));
            info.add(getString(C0133R.string.available_mem));
            values.add(getMostSuitableSizeUnit((double) kbAvailable));
            d = (double) (kbTotal - (kbTotal - kbAvailable));
            d2 = (double) kbTotal;
            ((TextView) this.rootView.findViewById(C0133R.id.stat_extra_storage)).setText(new DecimalFormat("#.##").format(100.0d - ((r0 / r0) * 100.0d)) + " %");
            initCard(info, values, getString(C0133R.string.external_storage), C0133R.id.card_extra_storage);
            pieGraph = (PieGraph) this.rootView.findViewById(C0133R.id.graph_extra_storage);
            slice = new PieSlice();
            _slice = new PieSlice();
            slice.setColor(Color.parseColor("#99CC00"));
            slice.setValue((float) kbAvailable);
            _slice.setColor(Color.parseColor("#FFBB33"));
            _slice.setValue((float) (kbTotal - kbAvailable));
            pieGraph.addSlice(slice);
            pieGraph.addSlice(_slice);
            pieGraph.setInnerCircleRatio(150);
            it = pieGraph.getSlices().iterator();
            while (it.hasNext()) {
                s = (PieSlice) it.next();
                s.setGoalValue(s.getValue());
            }
            pieGraph.setDuration(1000);
            pieGraph.setInterpolator(new AccelerateDecelerateInterpolator());
            pieGraph.animateToGoalValues();
        } else {
            ((PieGraph) this.rootView.findViewById(C0133R.id.graph_extra_storage)).setVisibility(8);
            ((CardView) this.rootView.findViewById(C0133R.id.card_extra_storage)).setVisibility(8);
        }
        return this.rootView;
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value, String title, int id) {
        this.card = new GeneralInfoCard(this.mainActivity, info, value, title);
        this.card.init();
        ((CardView) this.rootView.findViewById(id)).setCard(this.card);
    }

    private String getExternalStoragePath() {
        String[] paths = new String[]{"/emmc", "/mnt/sdcard/external_sd", "/storage/extSdCard", "/mnt/extSdCard/", "/storage/extSdCard/", "/mnt/external_sd", "/sdcard/sd", "/mnt/sdcard/bpemmctest", "/mnt/sdcard/_ExternalSD", "/mnt/sdcard-ext", "/mnt/Removable/MicroSD", "/Removable/MicroSD", "/mnt/external1", "/mnt/extSdCard", "/mnt/extsd", "/storage/sdcard1", "/storage/extsdcard", "/storage/sdcard0/external_sdcard", "/mnt/extsdcard", "/mnt/media_rw/sdcard1", "/removable/microsd", "/mnt/emmc", "/storage/external_SD", "/storage/ext_sd", "/storage/removable/sdcard1", "/data/sdext", "/data/sdext2", "/data/sdext3", "/data/sdext4"};
        for (int i = 0; i < paths.length; i++) {
            if (new File(paths[i]).exists()) {
                return paths[i];
            }
        }
        return null;
    }

    private String getMostSuitableSizeUnit(double valueInKB) {
        double temp = valueInKB / 1048576.0d;
        if (temp > 0.0d) {
            return new DecimalFormat("#.##").format(temp) + " GB";
        }
        temp = valueInKB / 1024.0d;
        if (temp > 0.0d) {
            return new DecimalFormat("#.##").format(temp) + " MB";
        }
        return new DecimalFormat("#.##").format(valueInKB) + " KB";
    }
}
