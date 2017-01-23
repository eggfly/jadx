package com.aide.ui.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.aide.analytics.a;
import com.aide.analytics.c;
import com.aide.common.d;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import pf$a;
import pf$g;

public class ShopPopupActivity extends Activity {
    protected AlertDialog DW;
    private boolean FH;
    private Map<String, pf$g> Hw;
    protected View j6;

    class 1 extends m {
        final /* synthetic */ ShopPopupActivity j6;

        class 1 implements OnCancelListener {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void onCancel(DialogInterface dialogInterface) {
                this.j6.j6.finish();
            }
        }

        class 2 implements OnClickListener {
            final /* synthetic */ 1 j6;

            2(1 1) {
                this.j6 = 1;
            }

            public void onClick(View view) {
                this.j6.j6.DW();
            }
        }

        1(ShopPopupActivity shopPopupActivity) {
            this.j6 = shopPopupActivity;
        }

        protected Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            LayoutInflater from = LayoutInflater.from(activity);
            this.j6.j6 = from.inflate(R.c.shop_popup, null);
            builder.setView(this.j6.j6).setOnCancelListener(new 1(this));
            this.j6.v5();
            this.j6.j6.findViewById(R.b.shoppopupHelpButton).setOnClickListener(new 2(this));
            this.j6.DW = builder.create();
            this.j6.DW.setCancelable(true);
            this.j6.DW.setCanceledOnTouchOutside(true);
            return this.j6.DW;
        }
    }

    class 2 implements pf$a {
        final /* synthetic */ ShopPopupActivity j6;

        class 1 implements Runnable {
            final /* synthetic */ 2 DW;
            final /* synthetic */ Map j6;

            1(2 2, Map map) {
                this.DW = 2;
                this.j6 = map;
            }

            public void run() {
                if (!this.DW.j6.FH) {
                    a.DW("ShopOKShown");
                    this.DW.j6.Hw = this.j6;
                    this.DW.j6.Zo();
                }
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 2 DW;
            final /* synthetic */ String j6;

            2(2 2, String str) {
                this.DW = 2;
                this.j6 = str;
            }

            public void run() {
                if (!this.DW.j6.FH) {
                    a.DW("ShopErrorShown: " + this.j6);
                    this.DW.j6.j6(this.j6);
                }
            }
        }

        2(ShopPopupActivity shopPopupActivity) {
            this.j6 = shopPopupActivity;
        }

        public void j6(Map<String, pf$g> map) {
            e.j6(new 1(this, map));
        }

        public void j6(String str) {
            e.j6(new 2(this, str));
        }
    }

    class 3 implements OnClickListener {
        final /* synthetic */ ShopPopupActivity DW;
        final /* synthetic */ String j6;

        3(ShopPopupActivity shopPopupActivity, String str) {
            this.DW = shopPopupActivity;
            this.j6 = str;
        }

        public void onClick(View view) {
            c.j6(this.DW, "ShopPrimeYearlyClicked");
            this.DW.DW.dismiss();
            e.Mr().j6(this.DW, this.j6, this.DW.j6());
        }
    }

    class 4 implements OnClickListener {
        final /* synthetic */ ShopPopupActivity DW;
        final /* synthetic */ String j6;

        4(ShopPopupActivity shopPopupActivity, String str) {
            this.DW = shopPopupActivity;
            this.j6 = str;
        }

        public void onClick(View view) {
            c.j6(this.DW, "ShopPrimeMonthlyClicked");
            this.DW.DW.dismiss();
            e.Mr().j6(this.DW, this.j6, this.DW.j6());
        }
    }

    class 5 implements OnClickListener {
        final /* synthetic */ ShopPopupActivity j6;

        5(ShopPopupActivity shopPopupActivity) {
            this.j6 = shopPopupActivity;
        }

        public void onClick(View view) {
            c.j6(this.j6, "ShopPremiumClicked");
            e.Mr().Hw(e.tp(), this.j6.getIntent().getStringExtra("EXTRA_LINKID"));
        }
    }

    class 6 implements OnClickListener {
        final /* synthetic */ ShopPopupActivity DW;
        final /* synthetic */ String j6;

        6(ShopPopupActivity shopPopupActivity, String str) {
            this.DW = shopPopupActivity;
            this.j6 = str;
        }

        public void onClick(View view) {
            c.j6(this.DW, "ShopDebuggerClicked");
            this.DW.DW.dismiss();
            e.Mr().DW(this.DW, this.j6, this.DW.j6());
        }
    }

    class 7 implements OnClickListener {
        final /* synthetic */ ShopPopupActivity j6;

        7(ShopPopupActivity shopPopupActivity) {
            this.j6 = shopPopupActivity;
        }

        public void onClick(View view) {
            c.j6(this.j6, "ShopDesignerClicked");
            e.Mr().FH(e.tp(), this.j6.getIntent().getStringExtra("EXTRA_LINKID"));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (e.J0()) {
            finish();
        } else if (d.j6()) {
            finish();
            e.sh().Hw();
        } else {
            String stringExtra = getIntent().getStringExtra("EXTRA_LINKID");
            if (stringExtra != null) {
                a.DW("ShopShownWithLinkID:" + stringExtra);
            }
            c.j6((Context) this, "ShopShown");
            m.j6((Activity) this, new 1(this));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1194684) {
            e.cn().j6(intent);
            setResult(-1);
            finish();
        }
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onMenuItemSelected(i, menuItem);
        }
        finish();
        return true;
    }

    protected void onResume() {
        super.onResume();
        e.j6((Activity) this);
        Set hashSet = new HashSet();
        if (EQ()) {
            hashSet.add(e.cn().gn());
        }
        if (tp()) {
            hashSet.add(e.cn().tp());
            hashSet.add(e.cn().u7());
        }
        if (u7()) {
            hashSet.add(e.cn().v5());
        }
        if (VH()) {
            hashSet.add(e.cn().Zo());
        }
        if (gn()) {
            hashSet.add(e.cn().VH());
        }
        e.cn().j6(hashSet, new 2(this));
    }

    private void DW() {
        ((ViewGroup) this.j6.findViewById(R.b.shopPopupEntries)).setVisibility(8);
        ((TextView) this.j6.findViewById(R.b.shopPopupErrorMessage)).setVisibility(8);
        TextView textView = (TextView) this.j6.findViewById(R.b.shopPopupHelpMessage);
        textView.setVisibility(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Problem description:\r\n<Put the problem description here.>\r\n\r\n");
        stringBuilder.append("Device: " + Hw() + " running Android " + VERSION.RELEASE + "\r\n");
        stringBuilder.append("AIDE version: " + FH() + "\r\n\r\n");
        stringBuilder.append("Log:\r\n\r\n");
        e eVar = e.DW;
        for (String append : e.cn().EQ()) {
            stringBuilder.append(append);
            stringBuilder.append("\r\n");
        }
        try {
            textView.setText(Html.fromHtml("<b>More information about Google Play:</b><br><br><a href='https://support.google.com/googleplay/digital-content/'>https://support.google.com/googleplay/digital-content/</a><br><br><br><b>Troubleshooting if your license is not recognized:</b><br><br>- select the right account in the Google Play Store app,<br>- make sure the device is connected to the internet,<br>- try to delete the Google Play Store app cache,<br>- try to restart your device,<br>- try to uninstall and reinstall the app.<br><br>If it still does not work <a href='" + ("mailto:support@appfour.com?subject=In-app%20billing%20problems&amp;body=" + URLEncoder.encode(stringBuilder.toString(), "UTF-8")) + "'>please contact us</a>.<br><br>"));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } catch (UnsupportedEncodingException e) {
        }
    }

    private String FH() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Throwable e) {
            com.aide.common.e.j6(e);
            return "(version unknown)";
        }
    }

    private String Hw() {
        String str = Build.MODEL;
        if (str == null || str.trim().isEmpty()) {
            return "(unknown)";
        }
        if (str.length() > 40) {
            return str.substring(0, 40);
        }
        return str;
    }

    private void j6(String str) {
        ((ViewGroup) this.j6.findViewById(R.b.shopPopupEntries)).setVisibility(8);
        ((TextView) this.j6.findViewById(R.b.shopPopupHelpMessage)).setVisibility(8);
        TextView textView = (TextView) this.j6.findViewById(R.b.shopPopupErrorMessage);
        textView.setVisibility(0);
        textView.setText(Html.fromHtml("<b>Error! Please verify that:</b><br><br>- the device is connected to the internet,<br>- the latest version of the Google Play Store is installed,<br>- you are signed in with a valid Google account.<br><br>More information about troubleshooting is available at:<br><br><a href='https://support.google.com/googleplay/digital-content/'>https://support.google.com/googleplay/digital-content/</a><br><br><em>Error details: " + str + "</em>"));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void v5() {
        String stringExtra = getIntent().getStringExtra("EXTRA_FEATURE");
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.f.shop_feature_features_and_lessons);
        }
        ((TextView) this.j6.findViewById(R.b.shopPopupTitle)).setText(stringExtra.substring(0, 1).toUpperCase() + stringExtra.substring(1));
    }

    private void Zo() {
        String str;
        String str2;
        String string;
        ((TextView) this.j6.findViewById(R.b.shopPopupHelpMessage)).setVisibility(8);
        ((TextView) this.j6.findViewById(R.b.shopPopupErrorMessage)).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) this.j6.findViewById(R.b.shopPopupEntries);
        viewGroup.removeAllViews();
        if (tp()) {
            String str3;
            String tp = e.cn().tp();
            String u7 = e.cn().u7();
            if (e.v5()) {
                str = "1 year";
                str2 = null;
            } else if (e.j6.equals("com.aide.ui")) {
                str = getResources().getString(R.f.shop_prime_yearly_title);
                str2 = j6((int) R.f.shop_prime_text);
            } else {
                str = "1 year access to all features";
                str2 = null;
            }
            if (com.aide.ui.m.Zo()) {
                string = getResources().getString(R.f.shop_off, new Object[]{"20%", DateFormat.getDateInstance(2, Locale.US).format(com.aide.ui.m.j6().getTime())});
                str3 = null;
            } else if (com.aide.ui.m.v5()) {
                str3 = getResources().getString(R.f.shop_off, new Object[]{"20%", DateFormat.getDateInstance(2, Locale.US).format(com.aide.ui.m.DW().getTime())});
                string = null;
            } else {
                str3 = null;
                string = null;
            }
            j6(viewGroup, str, str2, ((pf$g) this.Hw.get(u7)).v5 + "/" + getResources().getString(R.f.shop_month), string, str3, null, new 3(this, tp));
        }
        if (EQ()) {
            String str4;
            str = e.cn().gn();
            if (e.v5()) {
                str4 = "1 month";
                string = null;
            } else if (e.j6.equals("com.aide.ui")) {
                str4 = getResources().getString(R.f.shop_prime_monthly_title);
                string = j6((int) R.f.shop_prime_text);
            } else {
                str4 = "1 month access to all features";
                string = null;
            }
            if (com.aide.ui.m.VH()) {
                tp = "7 days free trial";
            } else {
                tp = null;
            }
            j6(viewGroup, str4, string, ((pf$g) this.Hw.get(str)).v5 + "/" + getResources().getString(R.f.shop_month), null, null, tp, new 4(this, str));
        }
        if (u7()) {
            j6(viewGroup, getResources().getString(R.f.shop_premium_title), j6((int) R.f.shop_premium_text), ((pf$g) this.Hw.get(e.cn().v5())).v5 + "", null, null, null, new 5(this));
        }
        if (gn()) {
            str2 = j6((int) R.f.shop_debugger_text);
            str = getResources().getString(R.f.shop_debugger_title);
            string = e.cn().VH();
            j6(viewGroup, str, str2, ((pf$g) this.Hw.get(string)).v5 + "", null, null, null, new 6(this, string));
        }
        if (VH()) {
            j6(viewGroup, getResources().getString(R.f.shop_designer_title), j6((int) R.f.shop_designer_text), ((pf$g) this.Hw.get(e.cn().Zo())).v5 + "", null, null, null, new 7(this));
        }
    }

    protected String j6() {
        return getIntent().getStringExtra("EXTRA_LINKID");
    }

    private String j6(int i) {
        return getResources().getString(i).replace("!_", "<b>").replace("_!", "</b>");
    }

    private boolean VH() {
        return getIntent().getBooleanExtra("EXTRA_SHOW_DESIGNER", false);
    }

    private boolean gn() {
        return getIntent().getBooleanExtra("EXTRA_SHOW_DEBUGGER", false);
    }

    private boolean u7() {
        return getIntent().getBooleanExtra("EXTRA_SHOW_PREMIUM", false);
    }

    private boolean tp() {
        return getIntent().getBooleanExtra("EXTRA_SHOW_PRIME_YEARLY", false);
    }

    private boolean EQ() {
        return getIntent().getBooleanExtra("EXTRA_SHOW_PRIME_MONTHLY", false);
    }

    private void j6(ViewGroup viewGroup, String str, String str2, String str3, String str4, String str5, String str6, OnClickListener onClickListener) {
        View inflate = LayoutInflater.from(this).inflate(R.c.shop_popup_entry, null);
        viewGroup.addView(inflate);
        if (str4 != null) {
            str = str + " (" + str4 + ")";
        } else if (str6 != null) {
            str = str + " (" + str6 + ")";
        } else if (str5 != null) {
            str = str + " (" + str5 + ")";
        }
        ((TextView) inflate.findViewById(R.b.shopPopupEntryText)).setText(str);
        ((TextView) inflate.findViewById(R.b.shopPopupEntryPrice)).setText(str3);
        if (str4 != null) {
            ((ImageView) inflate.findViewById(R.b.shopPopupEntrySpecialImage)).setImageResource(R.drawable.badge_sale);
            ((ImageView) inflate.findViewById(R.b.shopPopupEntrySpecialImage)).setVisibility(0);
        } else if (str5 != null) {
            ((ImageView) inflate.findViewById(R.b.shopPopupEntrySpecialImage)).setImageResource(R.drawable.badge_special);
            ((ImageView) inflate.findViewById(R.b.shopPopupEntrySpecialImage)).setVisibility(0);
        } else if (str6 != null) {
            ((ImageView) inflate.findViewById(R.b.shopPopupEntrySpecialImage)).setImageResource(R.drawable.badge_seven_day_free_trial);
            ((ImageView) inflate.findViewById(R.b.shopPopupEntrySpecialImage)).setVisibility(0);
        } else {
            ((ImageView) inflate.findViewById(R.b.shopPopupEntrySpecialImage)).setVisibility(8);
        }
        if (str2 != null) {
            ((TextView) inflate.findViewById(R.b.shopPopupEntryDescription)).setText(Html.fromHtml(str2));
        } else {
            ((TextView) inflate.findViewById(R.b.shopPopupEntryDescription)).setVisibility(8);
        }
        inflate.findViewById(R.b.shopPopupEntryButton).setOnClickListener(onClickListener);
    }

    protected void onStart() {
        super.onStart();
        a.j6((Activity) this, "SubscriptionPopupInfo");
    }

    protected void onStop() {
        super.onStop();
        a.DW(this, "SubscriptionPopupInfo");
    }

    protected void onPause() {
        super.onPause();
        e.DW((Activity) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.FH = true;
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return m.j6((Activity) this, i);
    }
}
