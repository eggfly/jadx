import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

public class afp {
    public static boolean j6() {
        return false;
    }

    public static boolean j6(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
