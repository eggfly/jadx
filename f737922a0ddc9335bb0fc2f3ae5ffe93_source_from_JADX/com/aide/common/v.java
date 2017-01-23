package com.aide.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.aide.ui.R;
import java.util.ArrayList;
import java.util.List;

public class v extends m {
    private String DW;
    private Runnable FH;
    private List<b> Hw;
    private boolean Zo;
    private String j6;
    private List<b> v5;

    static class 10 implements Runnable {
        final /* synthetic */ Activity j6;

        10(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            u.v5(this.j6, "android-ide");
        }
    }

    static class 11 implements Runnable {
        final /* synthetic */ Activity j6;

        11(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            u.j6(this.j6, "support@appfour.com", "AIDE Feedback", "With AIDE " + j6() + " " + DW() + " (SDK " + VERSION.SDK_INT + ")...\n\n[Write text here]");
        }

        private String j6() {
            try {
                return this.j6.getPackageManager().getPackageInfo(this.j6.getPackageName(), 0).versionName;
            } catch (Throwable e) {
                e.j6(e);
                return "(version unknown)";
            }
        }

        private String DW() {
            String str = Build.MODEL;
            if (str == null || str.length() > 40) {
                return "";
            }
            return "on my " + str;
        }
    }

    static class 12 implements Runnable {
        final /* synthetic */ Activity j6;

        12(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            u.Hw(this.j6, "com.aide.ui", "community");
        }
    }

    static class 13 implements Runnable {
        final /* synthetic */ Activity j6;

        13(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            v.FH(this.j6);
        }
    }

    static class 14 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ Activity j6;

        14(Activity activity, String str, String str2) {
            this.j6 = activity;
            this.DW = str;
            this.FH = str2;
        }

        public void run() {
            u.Hw(this.j6, this.DW, this.FH);
        }
    }

    static class 1 implements Runnable {
        final /* synthetic */ Activity j6;

        1(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            u.FH(this.j6, "101304250883271700981");
        }
    }

    static class 2 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ Activity j6;

        2(Activity activity, String str, String str2) {
            this.j6 = activity;
            this.DW = str;
            this.FH = str2;
        }

        public void run() {
            u.DW(this.j6, this.DW, this.FH);
        }
    }

    static class 3 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ Activity j6;

        3(Activity activity, String str, String str2) {
            this.j6 = activity;
            this.DW = str;
            this.FH = str2;
        }

        public void run() {
            u.j6(this.j6, this.DW, this.FH);
        }
    }

    static class 4 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ Activity j6;

        4(Activity activity, String str, String str2) {
            this.j6 = activity;
            this.DW = str;
            this.FH = str2;
        }

        public void run() {
            u.FH(this.j6, this.DW, this.FH);
        }
    }

    class 5 implements OnCancelListener {
        final /* synthetic */ v j6;

        5(v vVar) {
            this.j6 = vVar;
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (this.j6.FH != null) {
                this.j6.FH.run();
            }
        }
    }

    class 6 implements OnItemClickListener {
        final /* synthetic */ Activity DW;
        final /* synthetic */ AlertDialog FH;
        final /* synthetic */ v Hw;
        final /* synthetic */ ListView j6;

        6(v vVar, ListView listView, Activity activity, AlertDialog alertDialog) {
            this.Hw = vVar;
            this.j6 = listView;
            this.DW = activity;
            this.FH = alertDialog;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) adapterView.getItemAtPosition(i);
            if (bVar.Hw) {
                if (this.Hw.v5 == null || this.Hw.Zo) {
                    this.FH.dismiss();
                    if (this.Hw.FH != null) {
                        this.Hw.FH.run();
                    }
                } else {
                    this.Hw.Zo = true;
                    this.j6.setAdapter(new a(this.Hw, this.DW, this.Hw.v5));
                }
            }
            if (bVar.FH != null) {
                bVar.FH.run();
            }
        }
    }

    static class 7 implements Runnable {
        final /* synthetic */ Activity j6;

        7(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            u.DW(this.j6, "AndroidIDE");
        }
    }

    static class 8 implements Runnable {
        final /* synthetic */ Activity j6;

        8(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            u.j6(this.j6, "239564276138537");
        }
    }

    static class 9 implements Runnable {
        final /* synthetic */ Activity j6;

        9(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            v.FH(this.j6);
        }
    }

    private class a extends ArrayAdapter<b> {
        final /* synthetic */ v j6;

        public a(v vVar, Context context, List<b> list) {
            this.j6 = vVar;
            super(context, R.c.share_dialog_entry, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.c.share_dialog_entry, viewGroup, false);
            }
            b bVar = (b) getItem(i);
            ((TextView) view.findViewById(R.b.shareDialogEntryText)).setText(bVar.j6);
            ImageView imageView = (ImageView) view.findViewById(R.b.shareDialogEntryImage);
            if (bVar.DW != 0) {
                imageView.setImageResource(bVar.DW);
            }
            if (bVar.DW == 0) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            return view;
        }
    }

    private static class b {
        private int DW;
        private Runnable FH;
        private boolean Hw;
        private String j6;

        public b(int i, String str) {
            this.DW = i;
            this.j6 = str;
            this.FH = null;
            this.Hw = true;
        }

        public b(int i, String str, Runnable runnable) {
            this.DW = i;
            this.j6 = str;
            this.FH = runnable;
            this.Hw = false;
        }

        public b(int i, String str, Runnable runnable, boolean z) {
            this.DW = i;
            this.j6 = str;
            this.FH = runnable;
            this.Hw = z;
        }
    }

    public static void DW(Activity activity) {
        List arrayList = new ArrayList();
        arrayList.add(new b(R.drawable.community_googleplus, "Google+", new 1(activity)));
        arrayList.add(new b(R.drawable.community_twitter, "Twitter", new 7(activity)));
        arrayList.add(new b(R.drawable.community_facebook, "Facebook", new 8(activity)));
        List arrayList2 = new ArrayList(arrayList);
        arrayList2.add(new b(R.drawable.community_googleplus, "G+ Community", new 9(activity)));
        arrayList2.add(new b(R.drawable.community_google_groups, "Google Group", new 10(activity)));
        arrayList2.add(new b(R.drawable.community_email, "Email", new 11(activity)));
        if (!d.j6()) {
            arrayList2.add(new b(R.drawable.community_market, activity.getResources().getString(R.f.dialog_community_rate), new 12(activity)));
        }
        arrayList.add(new b(0, activity.getResources().getString(R.f.dialog_community_more)));
        m.j6(activity, new v(activity.getResources().getString(R.f.dialog_community_title), activity.getResources().getString(R.f.dialog_community_message), arrayList, arrayList2, null));
    }

    public static void FH(Activity activity) {
        if (d.j6()) {
            u.FH(activity, "101304250883271700981");
        } else {
            u.Hw(activity, "104927725094165066286");
        }
    }

    public static void DW(Activity activity, String str, String str2, Runnable runnable) {
        List arrayList = new ArrayList();
        arrayList.add(new b(R.drawable.community_googleplus, activity.getResources().getString(R.f.dialog_community_ask), new 13(activity)));
        if (runnable != null) {
            arrayList.add(new b(0, activity.getResources().getString(R.f.trainer_skip_lesson) + " \u21b7", runnable, true));
        }
        arrayList.add(new b(0, activity.getResources().getString(R.f.dialog_community_continue) + " \u226b"));
        m.j6(activity, new v(str, str2, arrayList, null, null));
    }

    public static void j6(Activity activity, String str, String str2, String str3, String str4, Runnable runnable) {
        List arrayList = new ArrayList();
        arrayList.add(new b(R.drawable.community_market, activity.getResources().getString(R.f.dialog_community_rate), new 14(activity, str3, str4)));
        arrayList.add(new b(0, activity.getResources().getString(R.f.dialog_community_continue) + " \u226b"));
        m.j6(activity, new v(str, str2, arrayList, null, runnable));
    }

    public static void DW(Activity activity, String str, String str2, String str3, Runnable runnable) {
        List arrayList = new ArrayList();
        arrayList.add(new b(R.drawable.community_googleplus, "Google+", new 2(activity, str2, str3)));
        arrayList.add(new b(R.drawable.community_twitter, "Twitter", new 3(activity, str2, str3)));
        arrayList.add(new b(R.drawable.community_facebook, "Facebook", new 4(activity, str2, str3)));
        arrayList.add(new b(0, activity.getResources().getString(R.f.dialog_community_continue) + " \u226b"));
        m.j6(activity, new v(str, "\"" + str2 + "\"", arrayList, null, runnable));
    }

    private v(String str, String str2, List<b> list, List<b> list2, Runnable runnable) {
        this.j6 = str;
        this.DW = str2;
        this.FH = runnable;
        this.Hw = list;
        this.v5 = list2;
    }

    protected Dialog j6(Activity activity) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.c.share_dialog, null);
        Builder builder = new Builder(activity);
        builder.setView(linearLayout).setCancelable(true).setTitle(this.j6);
        Dialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        create.setOnCancelListener(new 5(this));
        ((TextView) linearLayout.findViewById(R.b.shareDialogMessage)).setText(this.DW);
        ListView listView = (ListView) linearLayout.findViewById(R.b.shareDialogList);
        listView.setAdapter(new a(this, activity, this.Hw));
        listView.setOnItemClickListener(new 6(this, listView, activity, create));
        return create;
    }
}
