import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public class u {
    private static final u$d j6;

    static {
        if (VERSION.SDK_INT >= 19) {
            j6 = new u$b();
        } else if (VERSION.SDK_INT >= 14) {
            j6 = new u$a();
        } else {
            j6 = new u$c();
        }
    }

    public static ad j6(AccessibilityEvent accessibilityEvent) {
        return new ad(accessibilityEvent);
    }
}
