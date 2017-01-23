package com.aide.ui.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.aide.analytics.a;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import pf$a;
import pf$g;

public class ShopExpertPopupActivity extends Activity {
    protected AlertDialog DW;
    private Map<String, pf$g> FH;
    private boolean Hw;
    private String Zo;
    protected View j6;
    private boolean v5;

    class 1 extends m {
        final /* synthetic */ ShopExpertPopupActivity j6;

        class 1 implements OnCancelListener {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void onCancel(DialogInterface dialogInterface) {
                a.DW("Cancelled free version in expert shop.");
                this.j6.j6.setResult(-1);
                this.j6.j6.finish();
            }
        }

        class 2 implements OnClickListener {
            final /* synthetic */ 1 j6;

            2(1 1) {
                this.j6 = 1;
            }

            public void onClick(View view) {
                a.DW("Clicked on Free Version in expert shop.");
                this.j6.j6.DW.dismiss();
                this.j6.j6.setResult(-1);
                this.j6.j6.finish();
            }
        }

        class 3 implements OnClickListener {
            final /* synthetic */ 1 j6;

            3(1 1) {
                this.j6 = 1;
            }

            public void onClick(View view) {
                a.DW("Clicked on Buy in expert shop.");
                e.Mr().FH(e.tp(), this.j6.j6.Zo, this.j6.j6.getIntent().getStringExtra("EXTRA_LINKID"));
                this.j6.j6.finish();
            }
        }

        1(ShopExpertPopupActivity shopExpertPopupActivity) {
            this.j6 = shopExpertPopupActivity;
        }

        protected Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            LayoutInflater from = LayoutInflater.from(activity);
            this.j6.j6 = from.inflate(R.c.shop_expert_popup, null);
            builder.setView(this.j6.j6).setOnCancelListener(new 1(this));
            if (this.j6.v5) {
                View findViewById = this.j6.j6.findViewById(R.b.shopExpertPopupFreeButton);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new 2(this));
            }
            this.j6.j6.findViewById(R.b.shopExpertPopupBuyButton).setOnClickListener(new 3(this));
            TextView textView = (TextView) this.j6.j6.findViewById(R.b.shopExpertPopupTitle);
            ImageView imageView = (ImageView) this.j6.j6.findViewById(R.b.shopExpertPopupEntrySpecialImage);
            if (com.aide.ui.m.u7()) {
                textView.setText(this.j6.getString(R.f.shop_expert_title_promo_upgrade, new Object[]{"33%"}));
                imageView.setVisibility(0);
            } else if (com.aide.ui.m.gn()) {
                textView.setText(this.j6.getString(R.f.shop_expert_title_promo, new Object[]{"33%"}));
                imageView.setVisibility(0);
            } else {
                textView.setText(this.j6.getString(R.f.shop_expert_title));
            }
            this.j6.DW = builder.create();
            this.j6.DW.setCancelable(true);
            this.j6.DW.setCanceledOnTouchOutside(false);
            return this.j6.DW;
        }
    }

    class 2 implements pf$a {
        final /* synthetic */ ShopExpertPopupActivity j6;

        class 1 implements Runnable {
            final /* synthetic */ 2 DW;
            final /* synthetic */ Map j6;

            1(2 2, Map map) {
                this.DW = 2;
                this.j6 = map;
            }

            public void run() {
                if (!this.DW.j6.Hw) {
                    a.DW("ExpertShopOKShown");
                    this.DW.j6.FH = this.j6;
                    this.DW.j6.j6();
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
                if (!this.DW.j6.Hw) {
                    if (this.DW.j6.v5) {
                        this.DW.j6.setResult(-1);
                        this.DW.j6.finish();
                        return;
                    }
                    a.DW("ExpertShopErrorShown: " + this.j6);
                    this.DW.j6.DW.setCanceledOnTouchOutside(true);
                    this.DW.j6.j6(this.j6);
                }
            }
        }

        2(ShopExpertPopupActivity shopExpertPopupActivity) {
            this.j6 = shopExpertPopupActivity;
        }

        public void j6(Map<String, pf$g> map) {
            e.j6(new 1(this, map));
        }

        public void j6(String str) {
            e.j6(new 2(this, str));
        }
    }

    public ShopExpertPopupActivity() {
        this.v5 = false;
        this.Zo = e.cn().Hw();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (e.J0()) {
            finish();
            return;
        }
        a.DW("ExpertShopShownWithLinkId:" + getIntent().getStringExtra("EXTRA_LINKID"));
        FH();
        if (getIntent().getBooleanExtra("EXTRA_IS_OPTIONAL_OFFER", false)) {
            this.v5 = true;
        }
        m.j6((Activity) this, new 1(this));
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onMenuItemSelected(i, menuItem);
        }
        setResult(-1);
        finish();
        return true;
    }

    protected void onStart() {
        super.onStart();
        a.j6((Activity) this, "ShopExpertPopup");
    }

    protected void onStop() {
        super.onStop();
        a.DW(this, "ShopExpertPopup");
    }

    protected void onPause() {
        super.onPause();
        e.DW((Activity) this);
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return m.j6((Activity) this, i);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.Hw = true;
    }

    private void j6() {
        this.j6.findViewById(R.b.shopExpertProgressBar).setVisibility(8);
        TextView textView = (TextView) this.j6.findViewById(R.b.shopExpertPopupBuyButton);
        if (DW()) {
            textView.setText(getString(R.f.shop_expert_upgrade_for, new Object[]{((pf$g) this.FH.get(this.Zo)).v5}));
            ((TextView) this.j6.findViewById(R.b.shopExpertPopupFreeButton)).setText("No thanks");
        } else {
            textView.setText(getString(R.f.shop_expert_get_for, new Object[]{((pf$g) this.FH.get(this.Zo)).v5}));
        }
        ((ViewGroup) this.j6.findViewById(R.b.shopExpertButtonsLayout)).setVisibility(0);
        if (e.j6.equals("com.aide.web")) {
            ((TableLayout) this.j6.findViewById(R.b.shopExpertFeatureTableWeb)).setVisibility(0);
        } else if (DW()) {
            ((TableLayout) this.j6.findViewById(R.b.shopExpertFeatureTableUpgrade)).setVisibility(0);
            if (e.Mr().gn()) {
                ((ImageView) this.j6.findViewById(R.b.shopExpertFeatureTableUpgradeCurrentPremiumImage)).setImageResource(R.drawable.project_no_errors);
            }
            if (e.Mr().Mr()) {
                ((ImageView) this.j6.findViewById(R.b.shopExpertFeatureTableUpgradeCurrentUIDesignerImage)).setImageResource(R.drawable.project_no_errors);
            }
            if (e.Mr().tp()) {
                ((ImageView) this.j6.findViewById(R.b.shopExpertFeatureTableUpgradeCurrentDebuggerImage)).setImageResource(R.drawable.project_no_errors);
            }
        } else if (getIntent().getBooleanExtra("EXTRA_HILIGHT_ADS", false)) {
            ((TableLayout) this.j6.findViewById(R.b.shopExpertFeatureTableNoAds)).setVisibility(0);
        } else {
            ((TableLayout) this.j6.findViewById(R.b.shopExpertFeatureTable)).setVisibility(0);
        }
    }

    private boolean DW() {
        return e.j6.equals("com.aide.ui") && (e.Mr().gn() || e.Mr().Mr() || e.Mr().tp());
    }

    private void j6(String str) {
        this.j6.findViewById(R.b.shopExpertProgressBar).setVisibility(8);
        ((ViewGroup) this.j6.findViewById(R.b.shopExpertButtonsLayout)).setVisibility(8);
        ((TableLayout) this.j6.findViewById(R.b.shopExpertFeatureTable)).setVisibility(8);
        TextView textView = (TextView) this.j6.findViewById(R.b.shopExpertPopupErrorMessage);
        textView.setVisibility(0);
        textView.setText(Html.fromHtml("<b>Error! Please verify that:</b><br><br>- the device is connected to the internet,<br>- the latest version of the Google Play Store is installed,<br>- you are signed in with a valid Google account.<br><br>More information about troubleshooting is available at:<br><br><a href='https://support.google.com/googleplay/digital-content/'>https://support.google.com/googleplay/digital-content/</a><br><br><em>Error details: " + str + "</em>"));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void FH() {
        Set hashSet = new HashSet();
        hashSet.add(this.Zo);
        e.cn().j6(hashSet, new 2(this));
    }
}
