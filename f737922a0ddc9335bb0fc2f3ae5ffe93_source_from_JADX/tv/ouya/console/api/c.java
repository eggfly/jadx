package tv.ouya.console.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class c {
    public static boolean j6(Activity activity, int i, String str, Bundle bundle, int i2, h<Void> hVar) {
        if (i == 2001) {
            if (bundle.containsKey("intent")) {
                activity.startActivityForResult((Intent) bundle.getParcelable("intent"), i2);
                return true;
            }
        } else if (i == 2014 || i == 2020 || i == 2021 || i == 2019) {
            String str2 = "ERROR_CODE";
            str2 = "tv.ouya.console";
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str2, str2 + ".launcher.settings.CreditCardErrorActivity"));
            intent.putExtra("ERROR_CODE", i);
            activity.startActivityForResult(intent, i2);
            return true;
        }
        return false;
    }
}
