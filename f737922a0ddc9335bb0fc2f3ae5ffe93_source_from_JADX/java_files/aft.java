import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class aft {
    private static Boolean DW;
    private static Boolean FH;
    private static Boolean Hw;
    private static Boolean j6;

    @TargetApi(21)
    public static boolean DW(Context context) {
        if (Hw == null) {
            boolean z = agb.tp() && context.getPackageManager().hasSystemFeature("cn.google");
            Hw = Boolean.valueOf(z);
        }
        return Hw.booleanValue();
    }

    @TargetApi(13)
    private static boolean DW(Resources resources) {
        if (DW == null) {
            Configuration configuration = resources.getConfiguration();
            boolean z = agb.DW() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
            DW = Boolean.valueOf(z);
        }
        return DW.booleanValue();
    }

    @TargetApi(20)
    public static boolean j6(Context context) {
        if (FH == null) {
            boolean z = agb.gn() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            FH = Boolean.valueOf(z);
        }
        return FH.booleanValue();
    }

    public static boolean j6(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (j6 == null) {
            boolean z2 = (resources.getConfiguration().screenLayout & 15) > 3;
            if ((agb.j6() && z2) || DW(resources)) {
                z = true;
            }
            j6 = Boolean.valueOf(z);
        }
        return j6.booleanValue();
    }
}
