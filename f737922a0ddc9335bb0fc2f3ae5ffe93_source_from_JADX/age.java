import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.l;
import com.google.android.gms.internal.hl;

public final class age {
    public static boolean j6(Context context, int i) {
        boolean z = false;
        if (!j6(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return l.j6(context).j6(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean j6(Context context, int i, String str) {
        return hl.DW(context).j6(i, str);
    }
}
