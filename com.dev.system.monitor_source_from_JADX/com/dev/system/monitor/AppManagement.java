package com.dev.system.monitor;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.support.v4.media.TransportMediator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.ShowcaseView.Builder;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import it.gmariotti.cardslib.library.internal.Card;
import java.util.ArrayList;
import java.util.List;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class AppManagement extends Fragment {
    private static final int REQUEST_CODE_SETTINGS = 0;
    private PackageAdapter adapter;
    private ArrayList<PackageItem> data;
    String operatingThirdPackage;
    private ProgressBar progressBar;
    private View rootView;
    private ShowcaseView sv;
    private SwipeListView swipeListView;
    private ListAppTask task;

    public class ListAppTask extends AsyncTask<Void, Void, ArrayList<PackageItem>> {

        /* renamed from: com.dev.system.monitor.AppManagement.ListAppTask.1 */
        class C00911 implements OnClickListener {
            C00911() {
            }

            public void onClick(View arg0) {
                for (int i = 0; i < AppManagement.this.data.size(); i++) {
                    for (int j = i + 1; j < AppManagement.this.data.size(); j++) {
                        if (((PackageItem) AppManagement.this.data.get(i)).getMemoryInKByte() < ((PackageItem) AppManagement.this.data.get(j)).getMemoryInKByte()) {
                            PackageItem temp = (PackageItem) AppManagement.this.data.get(j);
                            PackageItem _temp = (PackageItem) AppManagement.this.data.get(i);
                            AppManagement.this.data.remove(i);
                            AppManagement.this.data.add(i, temp);
                            AppManagement.this.data.remove(j);
                            AppManagement.this.data.add(j, _temp);
                        }
                    }
                }
                AppManagement.this.adapter.notifyDataSetChanged();
            }
        }

        /* renamed from: com.dev.system.monitor.AppManagement.ListAppTask.2 */
        class C00922 implements OnClickListener {
            C00922() {
            }

            public void onClick(View arg0) {
                for (int i = 0; i < AppManagement.this.data.size(); i++) {
                    for (int j = i + 1; j < AppManagement.this.data.size(); j++) {
                        if (((PackageItem) AppManagement.this.data.get(i)).getName().compareTo(((PackageItem) AppManagement.this.data.get(j)).getName()) > 0) {
                            PackageItem temp = (PackageItem) AppManagement.this.data.get(j);
                            PackageItem _temp = (PackageItem) AppManagement.this.data.get(i);
                            AppManagement.this.data.remove(i);
                            AppManagement.this.data.add(i, temp);
                            AppManagement.this.data.remove(j);
                            AppManagement.this.data.add(j, _temp);
                        }
                    }
                }
                AppManagement.this.adapter.notifyDataSetChanged();
            }
        }

        protected ArrayList<PackageItem> doInBackground(Void... args) {
            PackageManager appInfo = AppManagement.this.getActivity().getPackageManager();
            ArrayList<PackageItem> data = new ArrayList();
            ActivityManager activityManager = (ActivityManager) AppManagement.this.getActivity().getSystemService("activity");
            List<RunningAppProcessInfo> procInfo = activityManager.getRunningAppProcesses();
            System.out.println("Running proc size : " + procInfo.size());
            AppManagement.this.progressBar.setMax(procInfo.size() - 1);
            AppManagement.this.progressBar.setProgress(0);
            for (int i = 0; i < procInfo.size(); i++) {
                RunningAppProcessInfo process = (RunningAppProcessInfo) procInfo.get(i);
                String name = process.processName;
                try {
                    PackageItem item = new PackageItem();
                    item.setName(appInfo.getApplicationLabel(appInfo.getApplicationInfo(process.processName, TransportMediator.FLAG_KEY_MEDIA_NEXT)).toString());
                    item.setPackageName(name);
                    item.setIcon(appInfo.getApplicationIcon(name));
                    MemoryInfo[] mi = activityManager.getProcessMemoryInfo(new int[]{process.pid});
                    item.setMemoryInKByte(((((mi[0].dalvikPrivateDirty + mi[0].dalvikSharedDirty) + mi[0].dalvikPss) + mi[0].nativePrivateDirty) + mi[0].nativeSharedDirty) + mi[0].nativePss);
                    data.add(item);
                    publishProgress(new Void[0]);
                } catch (NameNotFoundException e) {
                }
            }
            return data;
        }

        protected void onProgressUpdate(Void... values) {
            AppManagement.this.progressBar.setProgress(AppManagement.this.progressBar.getProgress() + 1);
        }

        protected void onPostExecute(ArrayList<PackageItem> result) {
            AppManagement.this.progressBar.setProgress(AppManagement.this.progressBar.getMax());
            AppManagement.this.progressBar.setVisibility(8);
            AppManagement.this.data.clear();
            AppManagement.this.data.addAll(result);
            AppManagement.this.adapter.notifyDataSetChanged();
            SwipeListView access$300 = AppManagement.this.swipeListView;
            View headerView = AppManagement.this.getActivity().getLayoutInflater().inflate(C0133R.layout.listview_header, null, false);
            access$300.addHeaderView(headerView);
            ((TextView) headerView.findViewById(C0133R.id.ram_header)).setOnClickListener(new C00911());
            ((TextView) headerView.findViewById(C0133R.id.app_header)).setOnClickListener(new C00922());
            AppManagement.this.swipeListView.setAdapter(AppManagement.this.adapter);
            AppManagement.this.getActivity();
            if (AppManagement.this.getActivity().getSharedPreferences("PREFERENCE", 0).getBoolean("firstrun_apprun", true)) {
                AppManagement.this.getActivity();
                AppManagement.this.getActivity().getSharedPreferences("PREFERENCE", 0).edit().putBoolean("firstrun_apprun", false).commit();
                LayoutParams lps = new LayoutParams(-2, -2);
                lps.addRule(12);
                lps.addRule(9);
                int margin = Float.valueOf(AppManagement.this.getResources().getDisplayMetrics().density * 12.0f).intValue();
                if (VERSION.SDK_INT >= 19) {
                    lps.setMargins(margin, margin, margin, margin + 70);
                } else {
                    lps.setMargins(margin, margin, margin, margin);
                }
                AppManagement.this.sv = new Builder(AppManagement.this.getActivity(), true).setTarget(new ViewTarget(AppManagement.this.swipeListView)).setContentTitle(AppManagement.this.getString(C0133R.string.tut_apps)).setStyle(C0133R.style.CustomShowcaseTheme).setShowcaseEventListener(null).build();
                try {
                    AppManagement.this.sv.setButtonPosition(lps);
                    AppManagement.this.sv.show();
                } catch (NullPointerException e) {
                }
            }
        }
    }

    public AppManagement() {
        this.operatingThirdPackage = BuildConfig.VERSION_NAME;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.swipe_list_view_activity, container, false);
        getActivity().setTitle(getString(C0133R.string.running_apps));
        this.progressBar = (ProgressBar) this.rootView.findViewById(C0133R.id.progressBar1);
        this.swipeListView = (SwipeListView) this.rootView.findViewById(C0133R.id.example_lv_list);
        this.data = new ArrayList();
        this.adapter = new PackageAdapter(getActivity(), this.data, this.swipeListView, this);
        if (VERSION.SDK_INT >= 11) {
            this.swipeListView.setChoiceMode(2);
        }
        reload();
        this.task = new ListAppTask();
        this.task.execute(new Void[0]);
        return this.rootView;
    }

    private void reload() {
        this.swipeListView.setSwipeMode(1);
        this.swipeListView.setSwipeActionLeft(0);
        this.swipeListView.setSwipeActionRight(0);
        this.swipeListView.setOffsetLeft(12.0f);
        this.swipeListView.setOffsetRight(12.0f);
        this.swipeListView.setAnimationTime(250);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                reload();
                break;
            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                break;
            default:
                return;
        }
        int i = 0;
        while (i < this.data.size()) {
            if (!((PackageItem) this.data.get(i)).getPackageName().equals(this.operatingThirdPackage)) {
                i++;
            } else if (!isAppPresent(this.operatingThirdPackage, getActivity())) {
                this.data.remove(i);
                this.adapter.notifyDataSetChanged();
                return;
            } else {
                return;
            }
        }
    }

    private boolean isAppPresent(String packageName, Context context) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public void onPause() {
        this.task.cancel(true);
        super.onPause();
    }
}
