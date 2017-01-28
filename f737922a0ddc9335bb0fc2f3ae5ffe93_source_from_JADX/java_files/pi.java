import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.aide.analytics.c;
import com.aide.common.d;
import com.aide.common.m;
import com.aide.licensing.a;
import com.aide.ui.PromoNotificationAlarmReceiver;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.trainer.TrainerNotificationAlarmReceiver;
import com.aide.ui.trainer.c.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class pi {
    private long DW;
    private AtomicBoolean EQ;
    private long FH;
    private boolean Hw;
    private AtomicLong VH;
    private a Zo;
    private AtomicLong gn;
    private long j6;
    private oc tp;
    private ob u7;
    private boolean v5;

    public pi() {
        this.j6 = 0;
        this.DW = 0;
        this.FH = 0;
        this.Hw = false;
        this.v5 = false;
        this.VH = new AtomicLong(0);
        this.gn = new AtomicLong(0);
        this.u7 = new ob();
        this.tp = new oc();
        this.EQ = new AtomicBoolean(false);
    }

    public void j6() {
        this.u7.FH();
        this.tp.FH();
    }

    public void DW() {
        this.u7.DW();
        this.u7.v5();
        this.tp.DW();
        this.tp.v5();
        if (!gn()) {
            c.j6(e.gn(), "Premium", false);
        }
        if (!Mr()) {
            c.j6(e.gn(), "UIDesigner", false);
        }
    }

    public boolean FH() {
        if (e.FH() || e.Hw()) {
            return true;
        }
        if (e.j6.equals("com.aide.phonegap")) {
            if (this.Zo == null) {
                this.Zo = new a();
                this.Zo.j6(e.u7(), false);
            }
            this.Zo.j6(new pi$1(this));
            return true;
        } else if (a8()) {
            return true;
        } else {
            lg();
            if (System.currentTimeMillis() < this.VH.get()) {
                return true;
            }
            this.u7.v5();
            if (System.currentTimeMillis() >= this.j6) {
                return false;
            }
            return true;
        }
    }

    public boolean Hw() {
        return a8() || XL() || tp() || FH() || j3();
    }

    public boolean v5() {
        if (XL() || a8()) {
            return true;
        }
        if (FH() && j3() && tp()) {
            return true;
        }
        return false;
    }

    public boolean Zo() {
        if (QX() || VH()) {
            return true;
        }
        if (gn() && Mr() && EQ()) {
            return true;
        }
        return false;
    }

    private boolean a8() {
        if (e.FH() || e.Hw()) {
            return true;
        }
        if (e.j6.equals("com.aide.web")) {
            try {
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeInMillis(e.gn().getPackageManager().getPackageInfo(e.j6, 0).firstInstallTime);
                if (gregorianCalendar.before(new GregorianCalendar(2016, 11, 13))) {
                    return true;
                }
            } catch (NameNotFoundException e) {
            }
        }
        lg();
        if (System.currentTimeMillis() >= this.gn.get()) {
            return false;
        }
        return true;
    }

    public boolean VH() {
        if (e.FH() || e.Hw()) {
            return true;
        }
        if (e.j6.equals("com.aide.web")) {
            try {
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeInMillis(e.gn().getPackageManager().getPackageInfo(e.j6, 0).firstInstallTime);
                if (gregorianCalendar.before(new GregorianCalendar(2016, 11, 13))) {
                    return true;
                }
            } catch (NameNotFoundException e) {
            }
        }
        return e.gn().getSharedPreferences("InAppBillingSettings", 0).getBoolean("WasDeveloperLicensedAtSomePoint", false);
    }

    private void lg() {
        e.cn().FH();
        e.sh().FH();
    }

    public boolean gn() {
        return this.u7.Hw();
    }

    public boolean u7() {
        this.u7.v5();
        return this.Hw;
    }

    public boolean j6(Activity activity) {
        if (tp()) {
            return true;
        }
        j6(activity, (int) R.f.shop_feature_debugger, "debugger", false, false);
        return false;
    }

    public boolean tp() {
        if (e.FH() || e.Hw() || a8()) {
            return true;
        }
        lg();
        if (System.currentTimeMillis() < this.VH.get() || System.currentTimeMillis() < this.FH) {
            return true;
        }
        return false;
    }

    public boolean EQ() {
        if (e.FH() || e.Hw()) {
            return true;
        }
        return e.gn().getSharedPreferences("InAppBillingSettings", 0).getBoolean("WasDebuggerLicensedAtSomePoint", false);
    }

    private boolean DW(Activity activity, int i, String str) {
        if (FH()) {
            return true;
        }
        j6(activity, i, str);
        return false;
    }

    public boolean j6(Activity activity, String str) {
        return DW(activity, (int) R.f.shop_feature_premium_settings, "setting_" + str);
    }

    public boolean DW(Activity activity, String str) {
        return DW(activity, (int) R.f.shop_feature_premium, "feature_" + str);
    }

    public void we() {
        this.j6 = 0;
        c.j6(e.gn(), "Premium", false);
    }

    public void j6(long j) {
        boolean z = System.currentTimeMillis() < this.j6;
        this.j6 = j;
        if (!z) {
            rN();
            j6("Premium license verified");
            c.j6(e.gn(), "Premium", true);
        }
    }

    public void J0() {
        this.Hw = true;
    }

    public void J8() {
        this.DW = 0;
        c.j6(e.gn(), "UIDesigner", false);
    }

    public void DW(long j) {
        this.DW = j;
        j6("UI Builder license verified");
        c.j6(e.gn(), "UIDesigner", true);
    }

    public void FH(long j) {
        this.FH = j;
        j6("Debugger license verified");
        c.j6(e.gn(), "Debugger", true);
        Editor edit = e.gn().getSharedPreferences("InAppBillingSettings", 0).edit();
        edit.putBoolean("WasDebuggerLicensedAtSomePoint", true);
        edit.commit();
    }

    public void Hw(long j) {
        this.gn.set(j);
        j6("Developer license verified");
        c.j6(e.gn(), "Developer", true);
        Editor edit = e.gn().getSharedPreferences("InAppBillingSettings", 0).edit();
        edit.putBoolean("WasDeveloperLicensedAtSomePoint", true);
        edit.commit();
    }

    public void Ws() {
        this.v5 = true;
    }

    public void j6(long j, boolean z) {
        this.VH.set(j);
        this.EQ.set(z);
        e.j6(new pi$2(this));
    }

    private void rN() {
        TrainerNotificationAlarmReceiver.j6(e.gn());
        PromoNotificationAlarmReceiver.j6(e.gn());
    }

    public boolean QX() {
        if (e.FH() || e.Hw()) {
            return true;
        }
        return e.gn().getSharedPreferences("InAppBillingSettings", 0).getBoolean("WasPrimeAtSomePoint", false);
    }

    public static boolean j6(Context context) {
        return context.getSharedPreferences("InAppBillingSettings", 0).getBoolean("WasPrimeAtSomePoint", false);
    }

    public boolean XL() {
        if (e.FH() || e.Hw()) {
            return true;
        }
        lg();
        if (System.currentTimeMillis() >= this.VH.get()) {
            return false;
        }
        return true;
    }

    public boolean aM() {
        return this.EQ.get();
    }

    private void j6(String str) {
        if (e.u7().sy()) {
            com.aide.analytics.a.DW(str);
            return;
        }
        com.aide.analytics.a.j6(e.u7());
        com.aide.analytics.a.DW(str);
        com.aide.analytics.a.DW(e.u7());
    }

    public void FH(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(com.aide.analytics.a.j6(e.j6, "com.aide.designer", str)));
        intent.setFlags(1074266112);
        try {
            e.tp().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            m.j6(e.tp(), "Google Play Store", "Google Play Store App could not be opened. Not installed?");
        }
        com.aide.analytics.a.j6("UI Designer market page shown", Collections.singletonMap("linkid", str));
    }

    public void Hw(Activity activity, String str) {
        if (!FH()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(com.aide.analytics.a.j6(e.j6, "com.aide.premium.key", str)));
            intent.setFlags(1074266112);
            try {
                e.tp().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                m.j6(e.tp(), "Google Play Store", "Google Play Store App could not be opened. Not installed?");
            }
            com.aide.analytics.a.j6("Premium key market page shown", Collections.singletonMap("linkid", str));
        }
    }

    public void j6(Activity activity, String str, String str2) {
        if (!e.Hw()) {
            e.cn().j6(str, true, str2);
        }
    }

    public void DW(Activity activity, String str, String str2) {
        if (!e.Hw()) {
            e.cn().j6(str, false, str2);
        }
    }

    public void FH(Activity activity, String str, String str2) {
        if (!e.Hw()) {
            e.cn().j6(str, false, str2);
        }
    }

    public void j6(Activity activity, int i, String str) {
        if (!FH()) {
            lg();
            j6(activity, i, str, false, false);
        }
    }

    public void Hw(Activity activity, String str, String str2) {
        for (String str3 : new String[]{"com.aide.ui", "com.aide.web", "com.aide.cpp", "com.aide.phonegap"}) {
            for (og DW : e.j6()) {
                List<b> DW2 = DW.DW();
                if (DW2 != null) {
                    for (b bVar : DW2) {
                        if (bVar.j6.equals(str) && Arrays.asList(bVar.FH).contains(str3)) {
                            v5(activity, str3, str2);
                            return;
                        }
                    }
                    continue;
                }
            }
        }
    }

    public void v5(Activity activity, String str, String str2) {
        if (!e.Hw()) {
            com.aide.analytics.a.j6("Edition shown " + str, Collections.singletonMap("linkid", str2));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(com.aide.analytics.a.j6(e.j6, str, str2)));
            intent.setFlags(1074266112);
            try {
                e.tp().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                m.j6(e.tp(), "Google Play Store", "Google Play Store App could not be opened. Not installed?");
            }
        }
    }

    public boolean j3() {
        if (e.FH() || e.Hw() || a8()) {
            return true;
        }
        lg();
        if (System.currentTimeMillis() < this.VH.get()) {
            return true;
        }
        this.tp.v5();
        if (System.currentTimeMillis() >= this.DW) {
            return false;
        }
        return true;
    }

    public boolean Mr() {
        return this.tp.Hw();
    }

    public long U2() {
        return e.gn().getSharedPreferences("LicenseService", 0).getLong("first_shop_time", -1);
    }

    public void j6(Activity activity, int i, int i2, String str, boolean z) {
        er();
        String str2 = "";
        if (i2 != 0) {
            str2 = e.gn().getResources().getString(i2);
        }
        com.aide.common.c.j6(activity, i, str2, str, z);
    }

    public void j6(Activity activity, int i, String str, boolean z, boolean z2) {
        er();
        if (d.DW((Context) activity) || !(e.j6.equals("com.aide.ui") || e.j6.equals("com.aide.web"))) {
            j6(activity, i, 0, str, z2);
        } else {
            com.aide.common.c.j6(activity, i, str, z, z2);
        }
    }

    private void er() {
        SharedPreferences sharedPreferences = e.gn().getSharedPreferences("LicenseService", 0);
        if (sharedPreferences.getLong("first_shop_time", -1) == -1) {
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = sharedPreferences.edit();
            edit.putLong("first_shop_time", currentTimeMillis);
            edit.commit();
        }
    }
}
