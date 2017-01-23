import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class ab$1 extends AccessibilityNodeProvider {
    final /* synthetic */ ab$a j6;

    ab$1(ab$a ab_a) {
        this.j6 = ab_a;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.j6.j6(i);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.j6.j6(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.j6.j6(i, i2, bundle);
    }
}
