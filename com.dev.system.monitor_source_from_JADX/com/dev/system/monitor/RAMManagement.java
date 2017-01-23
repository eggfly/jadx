package com.dev.system.monitor;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;
import com.faizmalkani.floatingactionbutton.Fab;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import it.gmariotti.cardslib.library.view.CardView;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class RAMManagement extends Fragment {
    private GeneralInfoCard card;
    private boolean firstrun;
    private ArrayList<String> info;
    private boolean isCleaning;
    private Activity mainActivity;
    private MemoryInfo mi;
    private PieGraph pg;
    private ProgressBar progressBar;
    private View rootView;
    private ShowcaseView sv;
    private ArrayList<String> values;

    /* renamed from: com.dev.system.monitor.RAMManagement.1 */
    class C01341 implements OnClickListener {
        C01341() {
        }

        public void onClick(View arg0) {
            if (!RAMManagement.this.isCleaning) {
                RAMManagement.this.isCleaning = true;
                new KillProcesses(null).execute(new Void[0]);
            }
        }
    }

    /* renamed from: com.dev.system.monitor.RAMManagement.2 */
    class C01352 implements OnLongClickListener {
        C01352() {
        }

        public boolean onLongClick(View v) {
            if (RAMManagement.this.firstrun) {
                RAMManagement.this.sv.hide();
            }
            new Builder(RAMManagement.this.mainActivity).setMessage(RAMManagement.this.getString(C0133R.string.ram_msg)).show();
            return false;
        }
    }

    private class DrawTask extends AsyncTask<Void, Void, Void> {
        private PieSlice _slice;
        private long free;
        private long rate;
        private PieSlice slice;
        private long total;

        public DrawTask() {
            this.total = 0;
            this.free = 0;
            this.rate = 0;
            RAMManagement.this.pg = (PieGraph) RAMManagement.this.rootView.findViewById(C0133R.id.graph);
        }

        protected synchronized Void doInBackground(Void... unused) {
            Exception e;
            Throwable th;
            RandomAccessFile reader = null;
            try {
                RandomAccessFile reader2 = new RandomAccessFile("/proc/meminfo", "r");
                try {
                    long[] mems = new long[4];
                    for (int i = 0; i < 4; i++) {
                        mems[i] = Long.parseLong(reader2.readLine().split(":")[1].replace("kB", BuildConfig.VERSION_NAME).trim());
                    }
                    this.total = mems[0] / 1024;
                    this.free = ((mems[1] + mems[2]) + mems[3]) / 1024;
                    this.rate = (long) ((int) ((((float) (this.total - this.free)) / ((float) this.total)) * 100.0f));
                    reader = reader2;
                } catch (Exception e2) {
                    e = e2;
                    reader = reader2;
                    try {
                        e.printStackTrace();
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                    this.slice = new PieSlice();
                    this.slice.setColor(Color.parseColor("#FFBB33"));
                    this.slice.setValue((float) (this.total - this.free));
                    this._slice = new PieSlice();
                    this._slice.setColor(Color.parseColor("#99CC00"));
                    this._slice.setValue((float) this.free);
                    publishProgress(new Void[0]);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    reader = reader2;
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (reader != null) {
                    reader.close();
                }
                this.slice = new PieSlice();
                this.slice.setColor(Color.parseColor("#FFBB33"));
                this.slice.setValue((float) (this.total - this.free));
                this._slice = new PieSlice();
                this._slice.setColor(Color.parseColor("#99CC00"));
                this._slice.setValue((float) this.free);
                publishProgress(new Void[0]);
                return null;
            }
            if (reader != null) {
                reader.close();
            }
            this.slice = new PieSlice();
            this.slice.setColor(Color.parseColor("#FFBB33"));
            this.slice.setValue((float) (this.total - this.free));
            this._slice = new PieSlice();
            this._slice.setColor(Color.parseColor("#99CC00"));
            this._slice.setValue((float) this.free);
            publishProgress(new Void[0]);
            return null;
        }

        protected void onProgressUpdate(Void... values) {
            RAMManagement.this.pg.addSlice(this.slice);
            RAMManagement.this.pg.addSlice(this._slice);
            RAMManagement.this.pg.setInnerCircleRatio(150);
            Iterator it = RAMManagement.this.pg.getSlices().iterator();
            while (it.hasNext()) {
                PieSlice s = (PieSlice) it.next();
                s.setGoalValue(s.getValue());
            }
            RAMManagement.this.pg.setDuration(1000);
            RAMManagement.this.pg.setInterpolator(new AccelerateDecelerateInterpolator());
            RAMManagement.this.pg.animateToGoalValues();
            RAMManagement.this.pg.setPadding(3);
            RAMManagement.this.info.clear();
            RAMManagement.this.values.clear();
            RAMManagement.this.info.add(RAMManagement.this.getString(C0133R.string.total_ram));
            RAMManagement.this.values.add(this.total + " MB");
            RAMManagement.this.info.add(RAMManagement.this.getString(C0133R.string.available_ram));
            RAMManagement.this.values.add(this.free + " MB");
            RAMManagement.this.info.add(RAMManagement.this.getString(C0133R.string.used_ram));
            RAMManagement.this.values.add((this.total - this.free) + " MB");
            ((TextView) RAMManagement.this.rootView.findViewById(C0133R.id.textView3)).setText(this.rate + " %");
            RAMManagement.this.initCard(RAMManagement.this.info, RAMManagement.this.values);
        }
    }

    private class KillProcesses extends AsyncTask<Void, Void, Void> {
        private KillProcesses() {
        }

        protected void onPreExecute() {
            if (RAMManagement.this.firstrun) {
                RAMManagement.this.sv.hide();
            }
            ((TextView) RAMManagement.this.rootView.findViewById(C0133R.id.textView3)).setText(" ");
            RAMManagement.this.progressBar.setVisibility(0);
        }

        protected Void doInBackground(Void... params) {
            ActivityManager activityManager = (ActivityManager) RAMManagement.this.mainActivity.getSystemService("activity");
            List<RunningAppProcessInfo> procInfo = activityManager.getRunningAppProcesses();
            for (int i = 0; i < procInfo.size(); i++) {
                RunningAppProcessInfo process = (RunningAppProcessInfo) procInfo.get(i);
                int importance = process.importance;
                String name = process.processName;
                if (!(name.equals(BuildConfig.APPLICATION_ID) || name.contains("launcher") || name.contains("googlequicksearchbox") || importance <= 200)) {
                    activityManager.killBackgroundProcesses(name);
                }
            }
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            RAMManagement.this.progressBar.setVisibility(4);
            Toast.makeText(RAMManagement.this.mainActivity, RAMManagement.this.getString(C0133R.string.ram_cls), 1).show();
            RAMManagement.this.isCleaning = false;
            RAMManagement.this.pg.removeSlices();
            new DrawTask().execute(new Void[0]);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.fragment_ram, container, false);
        getActivity();
        this.firstrun = getActivity().getSharedPreferences("PREFERENCE", 0).getBoolean("firstrun_fab", true);
        this.isCleaning = false;
        Fab mFab = (Fab) this.rootView.findViewById(C0133R.id.fabbutton);
        this.info = new ArrayList();
        this.values = new ArrayList();
        if (this.firstrun) {
            getActivity();
            getActivity().getSharedPreferences("PREFERENCE", 0).edit().putBoolean("firstrun_fab", false).commit();
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
                this.sv = new ShowcaseView.Builder(getActivity(), true).setTarget(new ViewTarget(mFab)).setContentTitle(getString(C0133R.string.tut_ram)).setStyle(C0133R.style.CustomShowcaseTheme).setShowcaseEventListener(null).build();
                this.sv.setButtonPosition(lps);
                this.sv.show();
            } catch (NullPointerException e) {
            }
        }
        this.mainActivity = getActivity();
        this.mainActivity.setTitle("Random Access Memory");
        this.progressBar = (ProgressBar) this.rootView.findViewById(C0133R.id.progressBar);
        this.mi = new MemoryInfo();
        ((ActivityManager) this.mainActivity.getSystemService("activity")).getMemoryInfo(this.mi);
        mFab.setFabColor(-1);
        mFab.setFabDrawable(getResources().getDrawable(17301564));
        mFab.setOnClickListener(new C01341());
        mFab.setOnLongClickListener(new C01352());
        mFab.showFab();
        new DrawTask().execute(new Void[0]);
        return this.rootView;
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value) {
        this.card = new GeneralInfoCard(this.mainActivity, info, value, "RAM Information");
        this.card.init();
        ((CardView) this.rootView.findViewById(C0133R.id.card_ram)).setCard(this.card);
    }
}
