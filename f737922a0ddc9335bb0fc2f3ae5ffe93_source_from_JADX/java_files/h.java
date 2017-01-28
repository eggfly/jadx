import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class h {
    public static <T> Creator<T> j6(i<T> iVar) {
        if (VERSION.SDK_INT >= 13) {
            return k.j6(iVar);
        }
        return new h$a(iVar);
    }
}
