import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import com.aide.analytics.a;
import com.aide.analytics.c;
import com.aide.ui.MainActivity;
import com.aide.ui.activities.HelpViewActivity;
import com.aide.ui.e;
import com.aide.ui.m;
import com.aide.uidesigner.ProxyTextView;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class pf {
    private static final Set<String> DW;
    private static final Set<String> FH;
    private static final Set<String> Hw;
    private static boolean VH;
    private static final Set<String> Zo;
    private static final Set<String> j6;
    private static final Set<String> v5;
    private Handler EQ;
    private Object J0;
    private AtomicReference<String> J8;
    private boolean Mr;
    private pf$h QX;
    private boolean U2;
    private boolean Ws;
    private AtomicLong XL;
    private boolean a8;
    private ArrayDeque<String> aM;
    private Map<String, pf$g> er;
    private boolean gn;
    private Object j3;
    private boolean lg;
    private String rN;
    private ServiceConnection tp;
    private adu u7;
    private ThreadPoolExecutor we;

    static {
        j6 = new HashSet(Arrays.asList(new String[]{"aide_prime_monthly_0500", "aide_prime_monthly_0500_7days_trial", "aide_prime_monthly_1000"}));
        DW = new HashSet(Arrays.asList(new String[]{"aide_prime_yearly_3000", "aide_prime_yearly_3000_7days_trial", "aide_prime_yearly_2400", "aide_prime_yearly_6000"}));
        FH = new HashSet(Arrays.asList(new String[]{"aide_premium_key_1000"}));
        Hw = new HashSet(Arrays.asList(new String[]{"app_ui_builder_0300"}));
        v5 = new HashSet(Arrays.asList(new String[]{"aide_debugger_0500"}));
        Zo = new HashSet(Arrays.asList(new String[]{"aide_developer_key_1500", "aide_developer_key_1000", "aide_developer_key_upgrade_1000"}));
        VH = true;
    }

    public pf() {
        this.J0 = new Object();
        this.J8 = new AtomicReference("");
        this.XL = new AtomicLong(-1);
        this.aM = new ArrayDeque(2001);
        this.j3 = new Object();
        this.er = new HashMap();
        this.QX = new pf$h();
        this.EQ = new Handler();
        this.we = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public void j6() {
        if (!VH || !J0() || e.Hw()) {
            return;
        }
        if (e.j6.equals("com.aide.ui") || e.j6.equals("com.aide.trainer.java") || e.j6.equals("com.aide.web")) {
            try {
                this.XL.set(com.aide.licensing.e.DW(e.u7()));
            } catch (Throwable th) {
                j6(th);
            }
            J8();
        }
    }

    private boolean we() {
        try {
            e.gn().getPackageManager().getPackageInfo("com.android.vending", 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public void DW() {
        this.QX.j6();
        if (this.tp != null) {
            if (this.gn) {
                e.u7().unbindService(this.tp);
            }
            synchronized (this.J0) {
                this.u7 = null;
            }
            this.gn = false;
            this.tp = null;
        }
    }

    private pf$d DW(Intent intent) {
        if (intent == null) {
            VH("Null data in activity result");
            return new pf$d(null);
        }
        pf$f j6 = pf$f.DW(intent.getIntExtra("RESPONSE_CODE", 0));
        VH("Received activity result - response code: " + intent.getIntExtra("RESPONSE_CODE", 0));
        if (j6 == pf$f.RESULT_OK || j6 == pf$f.RESULT_ITEM_ALREADY_OWNED) {
            qp$c j62 = j6(intent.getStringExtra("INAPP_PURCHASE_DATA"), intent.getStringExtra("INAPP_DATA_SIGNATURE"), true);
            if (j62 == null) {
                VH("Null purchase in activity result");
                return new pf$d(null);
            } else if (j6 == pf$f.RESULT_OK) {
                return new pf$d(j62, null);
            } else {
                if (j6 == pf$f.RESULT_ITEM_ALREADY_OWNED) {
                    VH("Item already owned");
                    FH();
                    return new pf$d(j62, null);
                }
            }
        }
        try {
            DW(j6);
        } catch (Throwable e) {
            j6(e);
        } catch (Throwable e2) {
            j6(e2);
        }
        return new pf$d(null);
    }

    public void j6(Set<String> set, pf$a pf_a) {
        if (!VH) {
            throw new IllegalStateException("getSkuDetailsFuture() future called without IN_APP_PURCHASE_ENABLED");
        } else if (J0()) {
            this.we.execute(new pf$1(this, set, pf_a));
        } else {
            pf_a.j6("AIDE does not have in-app billing permission. Please enable it.");
        }
    }

    private Map<String, pf$g> j6(Set<String> set) {
        ArrayList arrayList = new ArrayList(set);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        Map hashMap = new HashMap();
        j6(this.u7.j6(3, e.j6, "subs", bundle), hashMap);
        j6(this.u7.j6(3, e.j6, "inapp", bundle), hashMap);
        if (hashMap.size() == set.size()) {
            return hashMap;
        }
        String str = "Internal error in in-app billing (SKU details not found - expected: " + set.size() + " actual: " + hashMap.size() + ").";
        com.aide.common.e.FH(str);
        VH(str);
        throw new pf$b("Internal error in in-app billing (SKU details not found).");
    }

    private void j6(Bundle bundle, Map<String, pf$g> map) {
        DW(pf$f.DW(bundle.getInt("RESPONSE_CODE")));
        ArrayList stringArrayList = bundle.getStringArrayList("DETAILS_LIST");
        if (stringArrayList != null) {
            Iterator it = stringArrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                com.aide.common.e.j6("SKU: " + str);
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString("productId");
                map.put(string2, new pf$g(string, string2, jSONObject.getString("title"), jSONObject.getString("description"), jSONObject.getString("price"), jSONObject.getLong("price_amount_micros"), jSONObject.getString("price_currency_code")));
            }
        }
    }

    public void FH() {
        if (VH && J0()) {
            synchronized (this.J0) {
                if (this.Ws) {
                    return;
                }
                this.Ws = true;
                this.we.execute(new pf$3(this));
            }
        }
    }

    public void j6(String str, boolean z, String str2) {
        this.rN = str2;
        this.we.execute(new pf$4(this, str, z));
    }

    private void j6(PendingIntent pendingIntent) {
        if (e.tp() instanceof HelpViewActivity) {
            MainActivity.j6(e.tp(), pendingIntent.getIntentSender());
            e.tp().finish();
            return;
        }
        j6(e.tp(), pendingIntent.getIntentSender());
    }

    public static void j6(Activity activity, IntentSender intentSender) {
        try {
            activity.startIntentSenderForResult(intentSender, 1194684, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (Throwable e) {
            com.aide.common.e.j6(e);
        }
    }

    public void j6(Intent intent) {
        Context gn = e.gn();
        pf$d DW = DW(intent);
        if (DW.j6 != pf$e.OK_PURCHASED) {
            return;
        }
        if (DW(DW.DW.FH) || j6(DW.DW.FH)) {
            if (this.rN != null) {
                a.DW("PrimeConvertedWithLinkID:" + this.rN);
                if (e.Mr().XL()) {
                    a.DW((e.Mr().aM() ? "PrimeYearlyConvertedWithLinkID:" : "PrimeMonthlyConvertedWithLinkID:") + this.rN);
                }
            }
            if (e.u7().Hw() >= 2530) {
                c.j6(gn, "PrimeAfterShop", e.Mr().U2());
                c.j6(gn, "PrimeAfterInstall", e.u7().Zo());
            }
            c.j6(gn, "Prime");
            if (e.Mr().XL()) {
                c.j6(gn, e.Mr().aM() ? "PrimeYearly" : "PrimeMonthly");
                j6(DW, this.er);
            }
        } else if (FH(DW.DW.FH)) {
            if (this.rN != null) {
                a.DW("PremiumInAppConvertedWithLinkID:" + this.rN);
            }
            if (e.u7().Hw() >= 2530) {
                c.j6(gn, "PremiumInAppAfterShop", e.Mr().U2());
                c.j6(gn, "PremiumInAppAfterInstall", e.u7().Zo());
            }
            c.j6(gn, "PremiumInApp");
            j6(DW, this.er);
        } else if (Hw(DW.DW.FH)) {
            if (this.rN != null) {
                a.DW("DesignerInAppConvertedWithLinkID:" + this.rN);
            }
            if (e.u7().Hw() >= 2530) {
                c.j6(gn, "DesignerInAppAfterShop", e.Mr().U2());
                c.j6(gn, "DesignerInAppAfterInstall", e.u7().Zo());
            }
            c.j6(gn, "DesignerInApp");
            j6(DW, this.er);
        } else if (Zo(DW.DW.FH)) {
            if (this.rN != null) {
                a.DW("DeveloperKeyInAppConvertedWithLinkID:" + this.rN);
            }
            if (e.u7().Hw() >= 2530) {
                c.j6(gn, "DeveloperKeyInAppAfterShop", e.Mr().U2());
                c.j6(gn, "DeveloperKeyInAppAfterInstall", e.u7().Zo());
            }
            c.j6(gn, "DeveloperKeyInApp");
            j6(DW, this.er);
        }
    }

    private void j6(pf$d pf_d, Map<String, pf$g> map) {
        if (map != null) {
            String str = "GooglePlay:" + pf_d.DW.j6;
            String str2 = "Google Play";
            String str3 = pf_d.DW.FH;
            pf$g pf_g = (pf$g) map.get(str3);
            String str4 = pf_g.FH;
            boolean equals = "subs".equals(pf_g.j6);
            String str5 = equals ? "Subscription" : "In-app purchase";
            double d = (((double) pf_g.Zo) / 1000000.0d) * 0.7d;
            if (equals) {
                d *= 2.0d;
            }
            a.j6(e.gn(), str, str2, str3, str4, str5, d, pf_g.VH);
        }
    }

    private boolean J0() {
        return e.u7().checkCallingOrSelfPermission("com.android.vending.BILLING") == 0;
    }

    private void J8() {
        boolean z = true;
        try {
            synchronized (this.J0) {
                this.Mr = we();
                if (this.Mr) {
                    this.tp = new pf$5(this);
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    synchronized (this.J0) {
                        if (e.gn().getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
                            z = false;
                        }
                        this.U2 = z;
                        if (this.U2) {
                            z = e.u7().bindService(intent, this.tp, 1);
                            synchronized (this.J0) {
                                this.lg = z;
                                if (this.lg) {
                                    VH("Google Play Store IAB bind requested.");
                                    if (z) {
                                        this.gn = true;
                                        return;
                                    }
                                    return;
                                }
                                VH("Google Play Store IAB Service bind request failed.");
                                this.a8 = true;
                                this.J0.notifyAll();
                                return;
                            }
                        }
                        VH("Google Play Store IAB Service not found.");
                        this.a8 = true;
                        this.J0.notifyAll();
                        return;
                    }
                }
                this.a8 = true;
                this.J0.notify();
                VH("Google Play Store not installed.");
            }
        } catch (Throwable e) {
            j6(e);
            synchronized (this.J0) {
            }
            this.lg = false;
            this.a8 = true;
            this.J0.notifyAll();
        }
    }

    private qp$c j6(String str, String str2, boolean z) {
        VH("Processing data: " + str);
        VH("...with signature: " + str2);
        if (e.J0()) {
            return null;
        }
        qp$c j6 = qp.j6(str, str2);
        if (j6 == null) {
            return null;
        }
        if (j6.VH.matches("[0-9]*")) {
            return null;
        }
        VH("Purchase verified");
        if (z && !((String) this.J8.get()).equals(j6.Zo)) {
            VH("Invalid payload");
            return null;
        } else if (j6.v5 != qp$a.PURCHASED && j6.v5 != qp$a.REFUNDED) {
            return null;
        } else {
            if (j6(j6.FH)) {
                VH("Prime monthly subscription found - setting prime subscribed");
                e.Mr().j6(System.currentTimeMillis() + 86400000, false);
                this.QX.j6(gn(str), z);
            } else if (DW(j6.FH)) {
                VH("Prime yearly subscription found - setting prime subscribed");
                e.Mr().j6(System.currentTimeMillis() + 86400000, true);
                this.QX.j6(gn(str), z);
            } else if (FH(j6.FH)) {
                VH("Premium key found - setting premium");
                e.j6(new pf$6(this));
            } else if (Hw(j6.FH)) {
                VH("UI Designer found - setting designer");
                e.j6(new pf$7(this));
            } else if (v5(j6.FH)) {
                VH("Debugger found - setting debugger");
                e.j6(new pf$8(this));
            } else if (Zo(j6.FH)) {
                VH("Developer found - setting developer");
                e.j6(new pf$9(this));
            } else {
                VH("Unknown product id");
                return null;
            }
            return j6;
        }
    }

    private JSONObject gn(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("deviceId", this.XL.get());
            Context gn = e.gn();
            try {
                String str2 = "aideVersion";
                jSONObject.put(str2, gn.getPackageManager().getPackageInfo(gn.getPackageName(), 0).versionName);
                return jSONObject;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                return jSONObject;
            }
        } catch (Throwable e2) {
            j6(e2);
            return null;
        }
    }

    public String Hw() {
        if (m.u7()) {
            return "aide_developer_key_upgrade_1000";
        }
        if (m.gn()) {
            return "aide_developer_key_1000";
        }
        return "aide_developer_key_1500";
    }

    public String v5() {
        return "aide_premium_key_1000";
    }

    public String Zo() {
        return "app_ui_builder_0300";
    }

    public String VH() {
        return "aide_debugger_0500";
    }

    public String gn() {
        if (m.VH()) {
            return "aide_prime_monthly_0500_7days_trial";
        }
        return "aide_prime_monthly_0500";
    }

    public String u7() {
        if (m.Zo() || m.v5()) {
            return "aide_prime_yearly_2400_monthly_reference";
        }
        return "aide_prime_yearly_3000_monthly_reference";
    }

    public String tp() {
        if (m.Zo() || m.v5()) {
            return "aide_prime_yearly_2400";
        }
        return "aide_prime_yearly_3000";
    }

    public boolean j6(String str) {
        return j6.contains(str);
    }

    public boolean DW(String str) {
        return DW.contains(str);
    }

    public boolean FH(String str) {
        return FH.contains(str);
    }

    public boolean Hw(String str) {
        return Hw.contains(str);
    }

    public boolean v5(String str) {
        return v5.contains(str);
    }

    public boolean Zo(String str) {
        return Zo.contains(str);
    }

    private boolean j6(Bundle bundle) {
        pf$f j6 = pf$f.DW(bundle.getInt("RESPONSE_CODE"));
        if (j6 != pf$f.RESULT_OK) {
            VH("Response code for checking purchases: " + j6);
            return false;
        }
        ArrayList stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        VH("Response code for checking purchases: " + j6 + " - number of datas: " + stringArrayList.size());
        for (int i = 0; i < stringArrayList.size(); i++) {
            j6((String) stringArrayList.get(i), (String) stringArrayList2.get(i), false);
        }
        return true;
    }

    private adu Ws() {
        adu adu;
        synchronized (this.J0) {
            if (!this.a8) {
                VH("Waiting for bound service");
                this.J0.wait();
            }
            adu = this.u7;
        }
        return adu;
    }

    private void QX() {
        if (!this.Mr) {
            throw new pf$b("Google Play store is not installed. Please install it and restart the app.");
        } else if (!this.U2) {
            throw new pf$b("Google Play store IAB service is not available. Please install the latest version of the Google Play Store and restart your device.");
        } else if (this.lg) {
            DW(pf$f.DW(Ws().j6(3, e.j6, "inapp")));
            DW(pf$f.DW(Ws().j6(3, e.j6, "subs")));
        } else {
            throw new pf$b("Google Play store IAB service bind requested failed. Please install the latest version of the Google Play Store and restart your device.");
        }
    }

    private static void DW(pf$f pf_f) {
        switch (pf$2.j6[pf_f.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                throw new pf$c();
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                throw new pf$b("In-app billing not supported. Upgrade to a newer version of the Play Store.");
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                throw new pf$b("In-app billing not available. Check your network connection!");
            case 5:
                throw new pf$b("Internal error in in-app billing (DEVELOPER_ERROR).");
            case 6:
                throw new pf$b("Error in in-app billing. Check your network connection!");
            case 7:
                throw new pf$b("Error in in-app billing (ITEM_ALREADY_OWNED).");
            case 8:
                throw new pf$b("Error in in-app billing (ITEM_NOT_OWNED).");
            case 9:
                throw new pf$b("Error in in-app billing (ITEM_UNAVAILABLE).");
            default:
                throw new pf$b("Internal error in in-app billing (unexpected response code).");
        }
    }

    private void u7(String str) {
        this.EQ.post(new pf$10(this, str));
    }

    private void XL() {
        u7("Error communicating with Play Store service.");
    }

    public void VH(String str) {
        com.aide.common.e.j6("In-app Billing: " + str);
        synchronized (this.j3) {
            if (this.aM.isEmpty() || !str.equals(this.aM.getLast())) {
                this.aM.addLast(str);
                while (this.aM.size() > 2000) {
                    this.aM.removeFirst();
                }
                return;
            }
        }
    }

    public void j6(Throwable th) {
        com.aide.common.e.j6(th);
        synchronized (this.j3) {
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (this.aM.isEmpty() || !stringWriter2.equals(this.aM.getLast())) {
                this.aM.addLast(stringWriter2);
                while (this.aM.size() > 2000) {
                    this.aM.removeFirst();
                }
                return;
            }
        }
    }

    public List<String> EQ() {
        List arrayList;
        synchronized (this.j3) {
            arrayList = new ArrayList(this.aM);
        }
        return arrayList;
    }
}
