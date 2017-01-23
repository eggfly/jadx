package com.aide.ui;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.webkit.MimeTypeMap;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.aide.common.KeyStrokeDetector;
import com.aide.common.e;
import com.aide.common.p;
import com.aide.common.v;
import com.aide.common.x;
import com.aide.common.y;
import com.aide.ui.AIDEEditorPager.b;
import com.aide.ui.activities.GotoBrowserActivity;
import com.aide.ui.activities.TrainerCourseActivity;
import com.aide.ui.browsers.BrowserPager;
import com.aide.ui.browsers.DebugBrowser;
import com.aide.ui.browsers.ErrorBrowser;
import com.aide.ui.browsers.FileBrowser;
import com.aide.ui.browsers.LogCatBrowser;
import com.aide.ui.build.OutputConsoleActivity;
import com.aide.ui.build.android.m;
import com.aide.ui.build.c;
import com.aide.ui.marketing.WhatsNewDialog;
import com.aide.ui.preferences.PreferencesActivity;
import com.aide.ui.trainer.c.i;
import com.aide.ui.views.SplitView;
import com.aide.uidesigner.XmlLayoutDesignActivity;
import com.appfour.common.gcm.d;
import iq;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import nk;
import nr;
import nv;
import ok;
import pc$a;
import pf;
import pi;
import pl$a;
import py;
import qg;
import qh;
import qk;
import ql;
import qm;
import tv.ouya.console.api.f;

public class MainActivity extends ThemedActionbarActivity implements OnSharedPreferenceChangeListener, b, pc$a {
    private KeyStrokeDetector DW;
    private boolean EQ;
    private p FH;
    private p Hw;
    private int J0;
    private boolean J8;
    private g Mr;
    private boolean QX;
    private n U2;
    private k VH;
    private boolean Ws;
    private int XL;
    private p Zo;
    private View a8;
    private Handler aM;
    private boolean er;
    private boolean gn;
    private a j3;
    private long j6;
    private boolean lg;
    private long rN;
    private Object tp;
    private l u7;
    private o v5;
    private boolean we;

    class 10 implements Runnable {
        final /* synthetic */ MainActivity j6;

        10(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            this.j6.ei().DW(BrowserPager.Hw, false);
            this.j6.v5(BrowserPager.Hw);
            this.j6.cn().openSplit(false);
            this.j6.sh().aM();
        }
    }

    class 11 implements y<Integer> {
        final /* synthetic */ MainActivity DW;
        final /* synthetic */ List j6;

        11(MainActivity mainActivity, List list) {
            this.DW = mainActivity;
            this.j6 = list;
        }

        public void j6(Integer num) {
            e.j3().v5(((AIDEEditor) this.j6.get(num.intValue())).getFilePath());
        }
    }

    static class 12 implements Runnable {
        final /* synthetic */ Context j6;

        12(Context context) {
            this.j6 = context;
        }

        public void run() {
            if (!e.u7().Qq()) {
                MainActivity.j6(this.j6);
            }
        }
    }

    class 13 implements Runnable {
        final /* synthetic */ MainActivity j6;

        13(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            this.j6.jO();
        }
    }

    class 14 implements y<List<Integer>> {
        final /* synthetic */ MainActivity DW;
        final /* synthetic */ List j6;

        14(MainActivity mainActivity, List list) {
            this.DW = mainActivity;
            this.j6 = list;
        }

        public void j6(List<Integer> list) {
            for (Integer intValue : list) {
                e.j3().Hw(((AIDEEditor) this.j6.get(intValue.intValue())).getFilePath());
            }
        }
    }

    class 15 implements Runnable {
        final /* synthetic */ MainActivity j6;

        15(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            synchronized (this.j6.tp) {
                try {
                    this.j6.tp.wait(5000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class 16 implements Runnable {
        final /* synthetic */ MainActivity j6;

        16(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            v.FH(this.j6);
        }
    }

    class 17 implements com.aide.analytics.b {
        final /* synthetic */ MainActivity j6;

        17(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public boolean j6() {
            return h.j6();
        }
    }

    class 18 implements OnClickListener {
        final /* synthetic */ MainActivity j6;

        18(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void onClick(View view) {
            this.j6.a8();
        }
    }

    class 19 implements com.aide.ui.views.SplitView.a {
        final /* synthetic */ MainActivity j6;

        19(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void j6(boolean z) {
            this.j6.u7();
            if (z) {
                this.j6.ei().VH();
            }
        }
    }

    class 1 extends p {
        final /* synthetic */ MainActivity j6;

        1(MainActivity mainActivity, Activity activity, String str) {
            this.j6 = mainActivity;
            super(activity, str);
        }

        protected void Hw() {
            e.XL().J8();
            e.XL().J0();
        }
    }

    class 20 implements OnClickListener {
        final /* synthetic */ MainActivity j6;

        20(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void onClick(View view) {
            if (!e.VH()) {
                this.j6.rN();
            }
        }
    }

    class 21 implements com.aide.ui.build.a.a {
        final /* synthetic */ MainActivity j6;

        21(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void i_() {
            if (!e.U2().DW()) {
                this.j6.FH.DW();
            }
        }
    }

    class 22 implements Runnable {
        final /* synthetic */ MainActivity j6;

        22(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            this.j6.finish();
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ MainActivity j6;

        2(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            this.j6.finish();
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ MainActivity j6;

        3(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            q.j6(this.j6);
        }
    }

    class 4 extends Thread {
        final /* synthetic */ MainActivity j6;

        4(MainActivity mainActivity, String str) {
            this.j6 = mainActivity;
            super(str);
        }

        public void run() {
            m.Hw();
        }
    }

    class 5 implements TabListener {
        final /* synthetic */ String DW;
        final /* synthetic */ MainActivity FH;
        final /* synthetic */ Tab j6;

        5(MainActivity mainActivity, Tab tab, String str) {
            this.FH = mainActivity;
            this.j6 = tab;
            this.DW = str;
        }

        public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
        }

        public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
            if (this.j6 == tab && !this.DW.equals(e.j3().Hw())) {
                e.j3().v5(this.DW);
            }
        }

        public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
            if (this.j6 == tab && !e.VH()) {
                this.FH.FH();
            }
        }
    }

    class 6 implements Runnable {
        final /* synthetic */ MainActivity j6;

        6(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            e.j3().j6(false, false);
            this.j6.finish();
        }
    }

    class 7 implements Runnable {
        final /* synthetic */ MainActivity j6;

        7(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            this.j6.finish();
        }
    }

    class 8 implements Runnable {
        final /* synthetic */ MainActivity j6;

        8(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            e.sG().j6(true);
        }
    }

    class 9 implements Runnable {
        final /* synthetic */ MainActivity j6;

        9(MainActivity mainActivity) {
            this.j6 = mainActivity;
        }

        public void run() {
            e.sG().j6(true);
        }
    }

    private static class a implements Runnable {
        private a() {
        }

        public void run() {
            e.j3().j6(true, false);
        }
    }

    public MainActivity() {
        this.FH = new p(this, "Starting...");
        this.Hw = new 1(this, this, "Analyzing...");
        this.v5 = new o(this);
        this.tp = new Object();
        this.J0 = -1;
        this.j3 = new a();
    }

    public static void j6(Activity activity, IntentSender intentSender) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra("EXTRA_NAVIGATE_PLAY_STORE_INTENT_SENDER", intentSender);
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }

    public static void j6(Context context) {
        Intent intent;
        if (e.J0()) {
            intent = new Intent(context, MainActivity.class);
            intent.addFlags(335544320);
            intent.putExtra("EXTRA_NAVIGATE_BREAKPOINT", true);
            context.startActivity(intent);
        } else if (e.u7().Qq()) {
            e.u7().u7();
            e.u7().j6(e.Sf().J0());
            e.u7().KD().FH();
            e.u7().sh().invalidate();
            new Handler().postDelayed(new 12(context), 500);
        } else {
            intent = new Intent(context, MainActivity.class);
            intent.addFlags(805306368);
            intent.putExtra("EXTRA_NAVIGATE_BREAKPOINT", true);
            context.startActivity(intent);
        }
    }

    public static PendingIntent DW(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("EXTRA_SHOWN_FROM_TRAINER_NOTIFICATION", true);
        intent.addFlags(67108864);
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    public static PendingIntent FH(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("EXTRA_SHOWN_FROM_PROMO_NOTIFICATION", true);
        intent.addFlags(67108864);
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    public static PendingIntent j6(Context context, String str) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("EXTRA_SHOWN_FROM_GCM_NOTIFICATION", true);
        if (!(str == null || str.isEmpty())) {
            intent.putExtra("EXTRA_GCM_NOTIFICATION_IAP_PRODUCT_ID", str);
        }
        intent.addFlags(67108864);
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    public static PendingIntent Hw(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("EXTRA_SHOWN_FROM_UPDATE_TRAINER_NOTIFICATION", true);
        intent.addFlags(67108864);
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    public static PendingIntent v5(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("EXTRA_SHOWN_FROM_NOTIFICATION", true);
        intent.addFlags(67108864);
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    public static void j6(Context context, d dVar) {
        if (!pi.j6(context)) {
            Builder builder = new Builder(context);
            builder.j6(dVar.DW);
            builder.DW(dVar.FH);
            builder.FH(dVar.Hw);
            builder.j6(VH(context));
            builder.j6(j6(context, dVar.v5));
            builder.j6(true);
            builder.FH(-1);
            ((NotificationManager) context.getSystemService("notification")).notify(123, builder.j6());
        }
    }

    public static PendingIntent Zo(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("EXTRA_UPGRADE_NOTIFICATION_CLICKED", true);
        intent.addFlags(67108864);
        return PendingIntent.getActivity(context, new Random().nextInt(), intent, 134217728);
    }

    protected void onNewIntent(Intent intent) {
        e.j6((Object) this, "onNewIntent");
        super.onNewIntent(intent);
        if (intent != null && intent.getBooleanExtra("EXTRA_SHOWN_FROM_UPDATE_TRAINER_NOTIFICATION", false)) {
            TrainerCourseActivity.j6((Activity) this);
        } else if (intent != null && intent.getBooleanExtra("EXTRA_SHOWN_FROM_TRAINER_NOTIFICATION", false)) {
            com.aide.analytics.a.DW("Shown from trainer notification");
        } else if (intent != null && intent.getBooleanExtra("EXTRA_SHOWN_FROM_PROMO_NOTIFICATION", false)) {
            com.aide.analytics.a.DW("Shown from promo notification");
            q.Hw(this);
        } else if (intent != null && intent.getBooleanExtra("EXTRA_SHOWN_FROM_GCM_NOTIFICATION", false)) {
            com.aide.analytics.a.DW("Shown from gcm notification");
            q.j6(this, intent.getStringExtra("EXTRA_GCM_NOTIFICATION_IAP_PRODUCT_ID"));
        } else if (intent != null && intent.getBooleanExtra("EXTRA_UPGRADE_NOTIFICATION_CLICKED", false)) {
            com.aide.analytics.a.DW("Shown from upgrade notification");
            WhatsNewDialog.DW(this, null);
        } else if (intent != null && intent.getExtras() != null && intent.getExtras().getParcelable("EXTRA_NAVIGATE_PLAY_STORE_INTENT_SENDER") != null) {
            pf.j6((Activity) this, (IntentSender) intent.getExtras().getParcelable("EXTRA_NAVIGATE_PLAY_STORE_INTENT_SENDER"));
        } else if (intent != null && intent.getExtras() != null && intent.getExtras().getBoolean("EXTRA_SHOWN_FROM_NOTIFICATION", false)) {
            if (e.aM().FH() > 0) {
                yS();
            }
            if (e.U2().DW() && !e.U2().j6()) {
                dx();
            } else if (e.ei().Hw()) {
                sG();
            } else if (e.nw().VH()) {
                ef();
            }
        } else if (intent != null && intent.getData() != null) {
            FH(intent.getData().getPath());
        } else if (intent != null && intent.getExtras() != null && intent.getExtras().getString("NavigateFile") != null) {
            int i = intent.getExtras().getInt("NavigateLine");
            int i2 = intent.getExtras().getInt("NavigateColumn");
            j6(new qg(intent.getExtras().getString("NavigateFile"), i, i2, i, i2));
        } else if (intent != null && intent.getExtras() != null && intent.getExtras().getBoolean("EXTRA_NAVIGATE_BREAKPOINT")) {
            FN();
        }
    }

    protected void onPause() {
        e.j6((Object) this, "onPause");
        if (this.XL > 0) {
            e.j3().j6(true, false);
        }
        if (e.VH()) {
            e.EQ().FH();
        }
        this.QX = false;
        super.onPause();
    }

    protected void onDestroy() {
        e.j6((Object) this, "onDestroy - finishing: " + isFinishing());
        super.onDestroy();
        this.aM.removeCallbacks(this.j3);
        e.aM().DW((pc$a) this);
        sh().tp();
        h.DW(this, this);
        e.we();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals("send_analytics_data")) {
            com.aide.analytics.a.DW();
        } else {
            com.aide.analytics.a.j6("Setting changed", Collections.singletonMap("key", str));
        }
        this.XL = h.VH();
        if ("user_androidjar".equals(str) || "user_m2repositories".equals(str)) {
            e.a8().j3();
        }
        e.XL().Hw();
        if (!e.j6.equals("com.aide.web")) {
            ro().J8();
        }
        SplitView cn = cn();
        boolean z = !e.VH() && h.sh();
        cn.setSwipeEnabled(z);
        if ("light_theme".equals(str) || "app_language".equals(str) || "editor_tabs".equals(str) || "send_analytics_data".equals(str)) {
            this.EQ = true;
        }
        sh().EQ();
        if ("editor_font_size".equals(str)) {
            sh().we();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cb().j6((Context) this);
        jJ();
        u7();
    }

    public Object onRetainNonConfigurationInstance() {
        return "dummy";
    }

    protected void onResume() {
        super.onResume();
        this.QX = true;
        synchronized (this.tp) {
            this.tp.notifyAll();
        }
        if (this.EQ) {
            e.j3().j6(false, false);
            recreate();
        } else {
            e.nw().FH();
            vJ();
            e.a8().BT();
        }
        u7();
    }

    public void j6(String str, String str2, Runnable runnable) {
        if (!com.aide.common.d.DW((Context) this) && !getSharedPreferences("Rate", 0).getBoolean("Rated", false)) {
            Editor edit = getSharedPreferences("Rate", 0).edit();
            edit.putBoolean("Rated", true);
            edit.commit();
            v.j6(this, str, str2, e.j6, "rate", runnable);
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public boolean j6() {
        if (e.a8().J0() && e.a8().yS()) {
            String DW = ok.DW(e.a8().u7(), null);
            SharedPreferences sharedPreferences = getSharedPreferences("ValuableApps", 0);
            String string = sharedPreferences.getString("ValuableApps", "");
            if (!new HashSet(Arrays.asList(string.split("\n"))).contains(DW)) {
                StringBuilder stringBuilder = new StringBuilder(string);
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(DW);
                Editor edit = sharedPreferences.edit();
                edit.putString("ValuableApps", stringBuilder.toString());
                edit.commit();
                com.aide.common.m.j6((Activity) this, "Do you want to get more exposure for your app?", "If you have built something great using AIDE please write about it in our Google+ community.", true, "Open Google+", new 16(this), "Not now", null);
                return true;
            }
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        e.j6((Object) this, "onCreate");
        if (com.aide.common.d.j6()) {
            f.j6().j6((Context) this, "9b57b7e2-2fa3-44db-9131-04b76a1f491c");
        }
        e.j6((Context) this);
        com.aide.common.d.Hw((Activity) this);
        this.lg = true;
        this.aM = new Handler();
        this.we = h.j6((Context) this);
        com.aide.common.d.j6((Activity) this, e.vJ());
        if (!com.aide.analytics.a.j6()) {
            com.aide.analytics.a.j6((Context) this, new 17(this));
        }
        super.onCreate(bundle);
        if (!(e.VH() || wc())) {
            getWindow().requestFeature(9);
        }
        String str = null;
        if (!(getIntent() == null || getIntent().getData() == null)) {
            str = getIntent().getData().getPath();
        }
        e.j6(this, str);
        this.Mr = new g(this, R.d.filetab_menu);
        this.DW = new KeyStrokeDetector(this);
        h.j6((Context) this, (OnSharedPreferenceChangeListener) this);
        this.XL = h.VH();
        setContentView(R.c.main);
        com.aide.common.d.DW((Activity) this);
        if (!e.VH()) {
            com.aide.common.d.j6(findViewById(R.b.mainFrame));
        }
        this.U2 = new n(this);
        XG();
        this.u7 = new l(this, R.b.mainMasterButton);
        this.u7.j6(e.VH());
        this.u7.j6(new 18(this));
        SplitView cn = cn();
        boolean z2 = !e.VH() && h.sh();
        cn.setSwipeEnabled(z2);
        cn().setOnSplitChangeListener(new 19(this));
        findViewById(R.b.mainNoOpenFilesView).setOnClickListener(new 20(this));
        if (e.VH()) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().setDisplayShowHomeEnabled(true);
        } else if (wc()) {
            getActionBar().setDisplayShowTitleEnabled(false);
            getActionBar().setNavigationMode(2);
            if (!com.aide.common.d.j6((Context) this) && e.QX().vy()) {
                getActionBar().setDisplayHomeAsUpEnabled(true);
            }
            getActionBar().setDisplayShowHomeEnabled(true);
        } else {
            getActionBar().setDisplayOptions(16);
            getActionBar().setDisplayShowCustomEnabled(true);
            getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));
            findViewById(R.b.mainActionBarNoTabs).setBackgroundDrawable(new c(this));
            findViewById(R.b.mainSearchBarNoTabs).setBackgroundDrawable(new d(this));
        }
        if (e.VH()) {
            e.U2().j6(new 21(this));
        }
        if (e.VH() && com.aide.common.d.DW((Context) this)) {
            getActionBar().hide();
        }
        e.j3().j6(str);
        if (!e.j6.equals("com.aide.web")) {
            ro().VH();
            KD().FH();
        }
        e.rN().j6(sh().getCurrentFileSpan());
        e.aM().j6((pc$a) this);
        sh().setSoftKeyboardListener(this);
        jJ();
        u7();
        CU();
        if (this.J8) {
            com.aide.analytics.a.DW("First run after inital install");
        }
        if (getIntent() != null && getIntent().getBooleanExtra("EXTRA_SHOWN_FROM_TRAINER_NOTIFICATION", false)) {
            com.aide.analytics.a.DW("Shown from trainer notification");
        }
        if (getIntent() != null && getIntent().getBooleanExtra("EXTRA_SHOWN_FROM_PROMO_NOTIFICATION", false)) {
            com.aide.analytics.a.DW("Shown from promo notification");
        }
        if (!(e.Zo() || e.VH() || !e.a8().J0())) {
            e.j6(false);
        }
        if (!m.v5() || e.Mr().gn() || e.Mr().FH() || e.Mr().QX() || ((!e.VH() && e.Zo()) || !new GregorianCalendar().before(m.Hw()))) {
            PromoNotificationAlarmReceiver.j6(e.gn());
        } else {
            PromoNotificationAlarmReceiver.j6(e.gn(), m.Hw().getTimeInMillis(), VH(this), "20% off special offer", "Special offer", "Save 20% on an annual subscription");
        }
        if (com.aide.common.d.j6() && !f.j6().v5()) {
            com.aide.common.m.j6((Activity) this, "AIDE for OUYA", "This version of AIDE is only intended to run on the OUYA. Contact info@appfour.com for details.", false, new 22(this), new 2(this));
        } else if (e.VH()) {
            e.QX().DW();
            if (getIntent() == null || !getIntent().getBooleanExtra("EXTRA_SHOWN_FROM_UPDATE_TRAINER_NOTIFICATION", false)) {
                q.Hw(this);
            } else {
                TrainerCourseActivity.j6((Activity) this);
            }
        } else {
            et();
            if (getLastNonConfigurationInstance() == null) {
                z = false;
            }
            if (z) {
                q.FH(this);
                return;
            }
            if (e.j3().VH()) {
                e.nw().DW(e.j3().Hw());
            }
            if (e.a8().J0()) {
                e.nw().j6(e.a8().we());
            }
            kQ();
            XX();
            if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().getBoolean("EXTRA_NAVIGATE_BREAKPOINT")) {
                FN();
            } else if (getIntent() != null && getIntent().getBooleanExtra("EXTRA_SHOWN_FROM_UPDATE_TRAINER_NOTIFICATION", false)) {
                TrainerCourseActivity.j6((Activity) this);
            } else if (e.j6.equals("com.aide.ui") && getIntent() != null && getIntent().getBooleanExtra("EXTRA_SHOWN_FROM_PROMO_NOTIFICATION", false) && !e.VH()) {
                q.Hw(this);
            } else if (getIntent() != null && getIntent().getBooleanExtra("EXTRA_SHOWN_FROM_GCM_NOTIFICATION", false) && getIntent().hasExtra("EXTRA_GCM_NOTIFICATION_IAP_PRODUCT_ID")) {
                com.aide.analytics.a.DW("Shown from GCM notification");
                q.j6(this, getIntent().getStringExtra("EXTRA_GCM_NOTIFICATION_IAP_PRODUCT_ID"));
            } else if (getIntent() == null || !getIntent().getBooleanExtra("EXTRA_UPGRADE_NOTIFICATION_CLICKED", false)) {
                q.j6(this);
            } else {
                com.aide.analytics.a.DW("Shown from upgrade notification");
                WhatsNewDialog.DW(this, new 3(this));
            }
        }
    }

    private static int VH(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).icon;
        } catch (NameNotFoundException e) {
            return R.drawable.ic_launcher;
        }
    }

    private void XX() {
        if (m.FH()) {
            Thread 4 = new 4(this, "Old NDK Version Deleter");
            4.setDaemon(true);
            4.setPriority(1);
            4.start();
        }
    }

    private void kQ() {
        String path = new File(e.er().DW(), ".nomedia").getPath();
        if (qh.VH(e.er().DW()) && !qh.VH(path)) {
            try {
                qh.aM(path);
            } catch (Throwable e) {
                e.j6(e);
            }
        }
    }

    private Spinner yO() {
        try {
            View findViewById = findViewById(getResources().getIdentifier("action_bar", "id", "android"));
            Field declaredField = findViewById.getClass().getDeclaredField("mTabScrollView");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(findViewById);
            if (obj == null) {
                return null;
            }
            declaredField = obj.getClass().getDeclaredField("mTabSpinner");
            declaredField.setAccessible(true);
            obj = declaredField.get(obj);
            if (obj != null) {
                return (Spinner) obj;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public void j6(int i) {
        XG();
        ActionBar actionBar = getActionBar();
        if (i >= 0 && i < actionBar.getTabCount()) {
            actionBar.removeTab(actionBar.getTabAt(i));
        }
    }

    private void XG() {
        this.U2.j6(sh().getQuickKeys());
    }

    public void DW(int i) {
        aj();
        XG();
        ActionBar actionBar = getActionBar();
        if (i >= 0 && i < actionBar.getTabCount() && i != actionBar.getSelectedNavigationIndex()) {
            actionBar.selectTab(actionBar.getTabAt(i));
            Spinner yO = yO();
            if (yO != null) {
                yO.setSelection(i);
            }
        }
    }

    public void DW() {
        if (wc()) {
            ActionBar actionBar = getActionBar();
            List fileEditors = sh().getFileEditors();
            for (int i = 0; i < fileEditors.size(); i++) {
                pl$a model = ((AIDEEditor) fileEditors.get(i)).getModel();
                CharSequence Zo = qh.Zo(model.j6());
                if (!e.VH() && model.gn()) {
                    Zo = Zo + " *";
                }
                actionBar.getTabAt(i).setText(Zo);
            }
        }
    }

    public void j6(String str) {
        ActionBar actionBar = getActionBar();
        Tab text = actionBar.newTab().setText(qh.Zo(str));
        text.setTabListener(new 5(this, text, str));
        actionBar.addTab(text, false);
        jJ();
    }

    public void FH() {
        this.Mr.j6(findViewById(R.b.mainActionBarPopupAnchor), true);
    }

    public void FH(boolean z) {
        this.er = z;
        if (VERSION.SDK_INT >= 20) {
            jJ();
        }
    }

    private void jJ() {
        if (e.VH() && com.aide.common.d.u7(this) <= 610.0f) {
            com.aide.common.d.j6((Activity) this, false);
        } else if (com.aide.common.d.j6((Context) this)) {
            com.aide.common.d.j6((Activity) this, true);
        }
        com.aide.common.d.FH((Activity) this);
    }

    private boolean wc() {
        return (e.VH() && e.QX().FH()) || h.cb();
    }

    public int Hw() {
        return this.J0;
    }

    private void et() {
        int i = getSharedPreferences("BrowserLayout", 0).getInt("CurrentBrowser", -1);
        if (i >= 0) {
            j6(i, false);
        }
    }

    public boolean v5() {
        return this.J8;
    }

    public long Zo() {
        return this.rN;
    }

    private void CU() {
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            this.J0 = defaultSharedPreferences.getInt("first_seen_version", -1);
            if (this.J0 == -1) {
                if (Hw(false) == null) {
                    this.J0 = gn();
                    this.J8 = true;
                } else {
                    this.J0 = 103;
                }
                Editor edit = defaultSharedPreferences.edit();
                edit.putInt("first_seen_version", gn());
                edit.commit();
            }
            this.rN = defaultSharedPreferences.getLong("first_run_time", -1);
            if (this.rN == -1) {
                this.rN = System.currentTimeMillis();
                Editor edit2 = defaultSharedPreferences.edit();
                edit2.putLong("first_run_time", this.rN);
                edit2.commit();
            }
        } catch (Throwable th) {
            e.j6(th);
        }
    }

    public String Hw(boolean z) {
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String string = defaultSharedPreferences.getString("last_seen_version", "");
            String VH = VH();
            if (z && ("".equals(string) || !VH.equals(string))) {
                Editor edit = defaultSharedPreferences.edit();
                edit.putString("last_seen_version", VH);
                edit.commit();
            }
            if (VH == null || "".equals(VH)) {
                return null;
            }
            if ("".equals(string)) {
                if (this.we) {
                    return null;
                }
                return "";
            } else if (VH.equals(string)) {
                return null;
            } else {
                return string;
            }
        } catch (Throwable th) {
            e.j6(th);
            return null;
        }
    }

    public String VH() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Throwable e) {
            e.j6(e);
            return "";
        }
    }

    public int gn() {
        int i = 0;
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (Throwable e) {
            e.j6(e);
            return i;
        }
    }

    public void Mr() {
        Eq();
        hz();
        nw().Hw();
    }

    public void DW(String str) {
        Eq();
        hz();
        nw().FH();
    }

    public void u7() {
        if (!tp() && this.lg) {
            invalidateOptionsMenu();
        }
        Xa();
    }

    private void Xa() {
        if (this.u7 != null) {
            l lVar = this.u7;
            boolean z = !e.VH() && ((cn().splitHorizontalByDefault() || !cn().isSplit()) && !sh().vy() && com.aide.common.d.Hw(e.gn()));
            lVar.j6(z);
        }
    }

    public boolean tp() {
        return (this.Zo != null && this.Zo.j6()) || (this.VH != null && this.VH.j6());
    }

    private void Eq() {
        ((AIDEAnalysisProgressBar) findViewById(R.b.mainErrorProgress)).j6();
    }

    private void hz() {
        AIDEErrorsView aq = aq();
        if (aq != null) {
            aq.j6();
            findViewById(R.b.mainActionBarNoTabs).invalidate();
        }
    }

    public float EQ() {
        if (!com.aide.common.d.j6((Context) this)) {
            AIDEErrorsView aq = aq();
            if (aq != null) {
                return ((float) ((View) aq.getParent()).getLeft()) - (getResources().getDisplayMetrics().density * 10.0f);
            }
        }
        return (com.aide.common.d.u7(this) - 300.0f) * getResources().getDisplayMetrics().density;
    }

    private AIDEErrorsView aq() {
        AIDEErrorsView aIDEErrorsView = (AIDEErrorsView) findViewById(R.b.mainMenuErrorsView);
        if (aIDEErrorsView != null) {
            return aIDEErrorsView;
        }
        View findViewById = findViewById(R.b.errorsViewContainer);
        if (findViewById != null) {
            ViewParent parent = findViewById.getParent();
            if (parent instanceof AIDEErrorsView) {
                return (AIDEErrorsView) parent;
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        this.DW.DW(i, keyEvent);
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            sh().gn();
        }
        this.DW.j6(i, keyEvent);
        return super.onKeyUp(i, keyEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 12) {
            if (i2 == -1) {
                GotoBrowserActivity.j6(intent);
            }
        } else if (i == 1194684) {
            e.cn().j6(intent);
        } else if (i == 15) {
            if (i2 == -1) {
                OutputConsoleActivity.j6(intent);
            }
        } else if (i == 13) {
            if (i2 != -1) {
                return;
            }
            if (XmlLayoutDesignActivity.j6(intent)) {
                e.QX().J0();
            } else if (XmlLayoutDesignActivity.DW(intent)) {
                e.QX().EQ();
            }
        } else if (i == 14) {
            if (i2 == -1) {
                e.QX().J0();
            }
        } else if (i == 16) {
            q.DW(this);
        } else if (i == 17) {
            dx();
            e.sG().Hw();
            c.j6.VH();
        } else if (i == 18) {
            dx();
            e.sG().Hw();
            c.DW.VH();
        } else if (i == 19) {
            e.sG().Hw();
            c.Hw.VH();
        } else if (i == 20) {
            e.sG().Hw();
            c.v5.VH();
        }
    }

    public void we() {
        this.Hw.j6();
    }

    public void J0() {
        this.Hw.DW();
    }

    public void FH(String str) {
        String lg = qh.lg(str);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lg);
        if (!lg.equals("java") && !lg.equals("xml") && !lg.equals("svg") && mimeTypeFromExtension != null && !mimeTypeFromExtension.startsWith("text")) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(str)), mimeTypeFromExtension);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(e.gn(), "No handler found for type " + mimeTypeFromExtension, 0).show();
            }
        } else if (!qh.DW(str)) {
            j6(new qg(str, 1, 1, 1, 1));
            e.a8().Hw(str);
        }
    }

    public void j6(qg qgVar) {
        j6(qgVar, true);
    }

    public void j6(qg qgVar, boolean z) {
        if (qgVar != null && qh.J8(qgVar.j6)) {
            if (qgVar.j6.equals(e.j3().Hw())) {
                sh().j6(qgVar.DW, qgVar.FH, qgVar.Hw, qgVar.v5);
                if (z) {
                    sh().j3();
                }
                e.rN().j6(true);
                return;
            }
            boolean j6 = e.rN().j6();
            e.rN().j6(false);
            try {
                e.j3().j6(qgVar.j6, true);
                if (j6) {
                    e.rN().j6(true);
                }
                sh().j6(qgVar.DW, qgVar.FH, qgVar.Hw, qgVar.v5);
                sh().aM();
                e.rN().j6(true);
            } catch (IOException e) {
                Toast.makeText(e.gn(), qgVar.j6 + " could not be loaded!", 1).show();
                if (j6) {
                    e.rN().j6(true);
                }
            } catch (Throwable th) {
                if (j6) {
                    e.rN().j6(true);
                }
            }
        }
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return com.aide.common.m.j6((Activity) this, i);
    }

    public void onUserLeaveHint() {
        sh().QX();
        super.onUserLeaveHint();
    }

    public void onBackPressed() {
        if (this.v5.Hw()) {
            this.v5.FH();
        } else if (cn().isSplit()) {
            v5(true);
        } else if (!e.VH() && J8()) {
        } else {
            long currentTimeMillis;
            if (com.aide.common.d.DW((Context) this)) {
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.j6 < 2000) {
                    TrainerCourseActivity.j6((Activity) this);
                    return;
                }
                this.j6 = currentTimeMillis;
                Toast.makeText(e.gn(), R.f.view_toast_press_back, 0).show();
                return;
            }
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.j6 < 2000) {
                XL();
                return;
            }
            this.j6 = currentTimeMillis;
            Toast.makeText(e.gn(), R.f.view_toast_press_back, 0).show();
        }
    }

    public boolean J8() {
        qg v5 = e.rN().v5();
        if (v5 == null) {
            return false;
        }
        e.rN().j6(false);
        j6(v5);
        return true;
    }

    public void Ws() {
        qg Hw = e.rN().Hw();
        if (Hw != null) {
            e.rN().j6(false);
            j6(Hw);
        }
    }

    public void QX() {
        this.aM.removeCallbacks(this.j3);
        if (this.XL > 0) {
            this.aM.postDelayed(this.j3, ((long) this.XL) * 1000);
        }
    }

    public void XL() {
        if (e.j3().we()) {
            com.aide.common.m.j6((Activity) this, (int) R.f.dialog_save_files_title, (int) R.f.dialog_save_files_message, new 6(this), new 7(this));
        } else {
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        if (e.VH()) {
            menuInflater.inflate(R.d.main_trainer_options_menu, menu);
        } else {
            menuInflater.inflate(R.d.main_options_menu, menu);
            this.Zo = new p(menu);
            this.VH = new k(menu);
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean onPrepareOptionsMenu = super.onPrepareOptionsMenu(menu);
        if (!e.J0()) {
            j6(menu);
            if (com.aide.common.d.j6((Context) this)) {
                MenuItem findItem = menu.findItem(R.b.mainMenuErrorsView);
                if (findItem != null) {
                    findItem.setVisible(com.aide.common.d.u7(this) > 360.0f);
                }
            }
            if (this.Zo != null) {
                this.Zo.FH();
                this.VH.FH();
            }
        }
        return onPrepareOptionsMenu;
    }

    private void j6(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            qk j6 = f.j6(item.getItemId());
            if (j6 != null) {
                item.setEnabled(j6.g_());
                if (j6 instanceof qm) {
                    item.setVisible(((qm) j6).j6(false));
                }
                if (j6 instanceof ql) {
                    CharSequence VH = ((ql) j6).VH();
                    if (VH != null) {
                        item.setTitle(VH);
                    }
                }
            }
            py DW = f.DW(item.getItemId());
            if (DW != null) {
                item.setVisible(DW.h_());
                item.setEnabled(DW.g_());
            }
            if (item.hasSubMenu()) {
                j6(item.getSubMenu());
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            qk j6 = f.j6(menuItem.getItemId());
            if (j6 == null || !j6.g_()) {
                py DW = f.DW(menuItem.getItemId());
                if (DW == null || !DW.h_()) {
                    return super.onOptionsItemSelected(menuItem);
                }
                com.aide.analytics.a.DW("Action bar command: " + DW.VH());
                DW.DW();
                return true;
            }
            com.aide.analytics.a.DW("Main Menu: " + menuItem.getTitle());
            j6.DW();
            return true;
        } else if (!e.QX().vy()) {
            return true;
        } else {
            TrainerCourseActivity.j6((Activity) this);
            return true;
        }
    }

    public void aM() {
        FH(-1);
    }

    public void FH(int i) {
        PreferencesActivity.j6(this, i);
    }

    public void j3() {
        if (!Sf()) {
            Zo(true);
            sh().QX();
            sh().setIdentifierClickingEnabled(Sf());
            u7();
        }
    }

    public void U2() {
        if (Sf()) {
            Zo(false);
            sh().setIdentifierClickingEnabled(Sf());
            u7();
        }
    }

    public void v5(boolean z) {
        v5(-1);
        if (cn().isSplit()) {
            cn().closeSplit(z, new 8(this));
            sh().j3();
        }
    }

    private void v5(int i) {
        Editor edit = getSharedPreferences("BrowserLayout", 0).edit();
        edit.putInt("CurrentBrowser", i);
        edit.commit();
    }

    public void a8() {
        cn().toggleSplit(new 9(this));
        if (cn().isSplit()) {
            sh().QX();
        }
        if (cn().isSplit()) {
            e.sG().j6(false);
        }
    }

    private void j6(int i, boolean z) {
        BrowserPager ei = ei();
        boolean z2 = z && cn().isSplit();
        ei.DW(i, z2);
        v5(i);
        cn().openSplit(z);
        cn().getBottomView().requestFocus();
        e.sG().j6(false);
    }

    public void Hw(int i) {
        v5(i);
    }

    public void lg() {
        if (cn().isSplit() && ei().getCurrentBrowser() == BrowserPager.DW) {
            v5(true);
        } else {
            yS();
        }
    }

    public void rN() {
        sh().QX();
        j6(BrowserPager.j6, true);
    }

    public void er() {
        sh().QX();
        j6(BrowserPager.FH, true);
    }

    public void yS() {
        sh().QX();
        j6(BrowserPager.DW, true);
    }

    public void gW() {
        sh().QX();
        j6(BrowserPager.v5, true);
    }

    public void BT() {
        if (ei().getCurrentBrowser() == BrowserPager.Hw) {
            cn().closeSplit(true);
        }
    }

    private void FN() {
        j6(e.Sf().J0());
        e.u7().KD().FH();
        new Handler().postDelayed(new 10(this), 500);
    }

    public void vy() {
        sh().QX();
        j6(BrowserPager.Hw, true);
    }

    public int P8() {
        return this.U2.j6();
    }

    public void j6(boolean z) {
        boolean z2;
        boolean z3 = true;
        n nVar = this.U2;
        if (z && this.QX) {
            z2 = true;
        } else {
            z2 = false;
        }
        nVar.j6(z2);
        iq sG = e.sG();
        if (z) {
            z3 = false;
        }
        sG.j6(z3);
    }

    public void DW(boolean z) {
        e.sG().j6(!z);
        u7();
        if (!z) {
            return;
        }
        if ((com.aide.common.d.gn(this) <= 800.0f && !cn().isHorizontal()) || com.aide.common.d.gn(this) < 540.0f) {
            v5(false);
        }
    }

    public BrowserPager ei() {
        return (BrowserPager) findViewById(R.b.mainBrowserPager);
    }

    public ErrorBrowser nw() {
        return ei().getErrorBrowser();
    }

    public FileBrowser SI() {
        return ei().getFileBrowser();
    }

    public DebugBrowser KD() {
        return ei().getDebugBrowser();
    }

    public LogCatBrowser ro() {
        return ei().getLogCatBrowser();
    }

    public SplitView cn() {
        return (SplitView) findViewById(R.b.mainSplitView);
    }

    public AIDEEditorPager sh() {
        return (AIDEEditorPager) findViewById(R.b.mainCodePageView);
    }

    public KeyStrokeDetector cb() {
        return this.DW;
    }

    public void dx() {
        if (e.VH()) {
            this.FH.FH();
        } else {
            com.aide.common.m.j6((Activity) this, new nk());
        }
    }

    public void sG() {
        com.aide.common.m.j6((Activity) this, new nv());
    }

    public void ef() {
        com.aide.common.m.j6((Activity) this, new nr());
    }

    private void Zo(boolean z) {
        this.gn = z;
    }

    public boolean Sf() {
        return this.gn;
    }

    public void vJ() {
        if (e.tp() == this) {
            e.j3().j6(true);
        }
    }

    public void g3() {
        vJ();
        e.a8().j3();
        e.er().FH();
        e.XL().tp();
    }

    public void Mz() {
        if (ca()) {
            this.Zo.DW();
        } else {
            this.v5.j6();
        }
    }

    public void I() {
        if (ca()) {
            this.VH.DW();
        } else {
            this.v5.DW();
        }
    }

    public boolean ca() {
        return wc();
    }

    public void x9() {
        List<AIDEEditor> fileEditors = sh().getFileEditors();
        List arrayList = new ArrayList();
        for (AIDEEditor filePath : fileEditors) {
            String filePath2 = filePath.getFilePath();
            Object Zo = qh.Zo(filePath2);
            if (e.j3().DW(filePath2).gn()) {
                Zo = Zo + " *";
            }
            arrayList.add(Zo);
        }
        com.aide.common.m.j6(e.u7(), "Open Files", arrayList, "Close Files...", new 11(this, fileEditors), new 13(this));
    }

    private void jO() {
        List<AIDEEditor> fileEditors = sh().getFileEditors();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (AIDEEditor filePath : fileEditors) {
            String filePath2 = filePath.getFilePath();
            Object Zo = qh.Zo(filePath2);
            boolean gn = e.j3().DW(filePath2).gn();
            if (gn) {
                Zo = Zo + " *";
            }
            arrayList.add(Zo);
            arrayList2.add(Boolean.valueOf(!gn));
        }
        com.aide.common.m.j6(e.u7(), "Close Files", arrayList, arrayList2, new 14(this, fileEditors));
    }

    public void j6(String str, String str2) {
        sh().QX();
        e.j6(e.u7(), "Starting App...", new 15(this), null);
        e.ro().j6(str, str2);
    }

    protected void onStart() {
        super.onStart();
        Map hashMap = new HashMap();
        hashMap.put("isPremiumKeyInstalled", Boolean.toString(e.Mr().gn()));
        hashMap.put("isPremium", Boolean.toString(e.Mr().FH()));
        String str = "isPremiumHacked";
        boolean z = !e.Mr().gn() && e.Mr().FH();
        hashMap.put(str, Boolean.toString(z));
        hashMap.put("isUiBuilderKeyInstalled", Boolean.toString(e.Mr().Mr()));
        hashMap.put("isUiBuilderLicensed", Boolean.toString(e.Mr().j3()));
        com.aide.analytics.a.j6((Activity) this, "Main", hashMap);
        if (e.Zo()) {
            com.aide.analytics.a.j6(e.VH() ? "Trainer view" : "Expert view");
        }
        String property = System.getProperty("os.arch");
        if (property == null) {
            property = "unknown";
        }
        if (!property.toLowerCase(Locale.US).contains("86") && e.ef()) {
            property = "x86";
        }
        com.aide.analytics.a.j6("Session data", 1, property);
        com.aide.analytics.a.DW("CPU arch: " + property);
        if (com.aide.common.d.DW((Context) this)) {
            com.aide.analytics.a.DW("Android TV detected");
        }
        File dir = getDir("installreferrerdata", 0);
        com.aide.analytics.a.j6("AIDE installed", dir);
        if (!e.j6.equals("com.aide.phonegap")) {
            com.aide.analytics.a.j6("AIDE Premium Key installed", new File(dir.getPath().replace(getPackageName(), "com.aide.premium.key")));
        }
        this.Ws = true;
    }

    protected void onStop() {
        super.onStop();
        com.aide.analytics.a.DW(this, "Main");
        this.Ws = false;
    }

    public boolean Qq() {
        return this.QX;
    }

    public boolean sy() {
        return this.Ws;
    }

    public View j6(Rect rect) {
        this.a8 = null;
        AbsoluteLayout absoluteLayout = (AbsoluteLayout) findViewById(R.b.mainPopupAnchorContainer);
        int[] iArr = new int[2];
        absoluteLayout.getLocationOnScreen(iArr);
        absoluteLayout.removeAllViews();
        View linearLayout = new LinearLayout(this);
        absoluteLayout.addView(linearLayout, new LayoutParams(rect.width(), rect.height(), rect.left - iArr[0], rect.top - iArr[1]));
        return linearLayout;
    }

    public void j6(View view, Rect rect) {
        this.a8 = view;
        AbsoluteLayout absoluteLayout = (AbsoluteLayout) findViewById(R.b.mainPopupAnchorContainer);
        int[] iArr = new int[2];
        absoluteLayout.getLocationOnScreen(iArr);
        absoluteLayout.removeAllViews();
        absoluteLayout.addView(view, new LayoutParams(rect.width(), rect.height(), rect.left - iArr[0], rect.top - iArr[1]));
    }

    public void aj() {
        this.a8 = null;
        ((AbsoluteLayout) findViewById(R.b.mainPopupAnchorContainer)).removeAllViews();
    }

    public View lp() {
        return this.a8;
    }

    public void OW() {
        x.j6(getActionBar(), e.QX().er().u7(), e.QX().er().VH());
        if (e.QX().FH()) {
            getActionBar().setNavigationMode(2);
        } else {
            getActionBar().setNavigationMode(0);
        }
    }

    public void br() {
        if (e.VH()) {
            j6(false, null, null);
        }
    }

    public void j6(boolean z, String str, i iVar) {
        this.lg = false;
        if (z) {
            v5(false);
        } else {
            String Hw = e.j3().Hw();
            if (Hw != null) {
                e.er().j6(qh.v5(Hw));
            } else {
                e.er().j6(e.er().DW());
            }
        }
        e.j3().j6(false, false);
        if (str != null) {
            e.QX().j6(str);
        } else if (iVar != null) {
            e.QX().j6(iVar);
        }
        e.j6(z);
        recreate();
    }

    public void recreate() {
        com.aide.common.m.j6();
        super.recreate();
    }
}
