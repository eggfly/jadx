package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.eo;

@eh
public class a {
    public boolean j6(Context context, Intent intent, m mVar) {
        try {
            String str = "Launching an intent: ";
            String valueOf = String.valueOf(intent.toURI());
            eo.v5(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            f.FH().j6(context, intent);
            if (mVar != null) {
                mVar.j6();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            b.Hw(e.getMessage());
            return false;
        }
    }

    public boolean j6(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, m mVar) {
        if (adLauncherIntentInfoParcel == null) {
            b.Hw("No intent data for launcher overlay.");
            return false;
        } else if (adLauncherIntentInfoParcel.u7 != null) {
            return j6(context, adLauncherIntentInfoParcel.u7, mVar);
        } else {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.FH)) {
                b.Hw("Open GMSG did not contain a URL.");
                return false;
            }
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.Hw)) {
                intent.setData(Uri.parse(adLauncherIntentInfoParcel.FH));
            } else {
                intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.FH), adLauncherIntentInfoParcel.Hw);
            }
            intent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.v5)) {
                intent.setPackage(adLauncherIntentInfoParcel.v5);
            }
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.Zo)) {
                String[] split = adLauncherIntentInfoParcel.Zo.split("/", 2);
                if (split.length < 2) {
                    String str = "Could not parse component name from open GMSG: ";
                    String valueOf = String.valueOf(adLauncherIntentInfoParcel.Zo);
                    b.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return false;
                }
                intent.setClassName(split[0], split[1]);
            }
            Object obj = adLauncherIntentInfoParcel.VH;
            if (!TextUtils.isEmpty(obj)) {
                int parseInt;
                try {
                    parseInt = Integer.parseInt(obj);
                } catch (NumberFormatException e) {
                    b.Hw("Could not parse intent flags.");
                    parseInt = 0;
                }
                intent.addFlags(parseInt);
            }
            return j6(context, intent, mVar);
        }
    }
}
