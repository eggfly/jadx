import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class ac$1 extends AccessibilityNodeProvider {
    final /* synthetic */ ac$a j6;

    ac$1(ac$a ac_a) {
        this.j6 = ac_a;
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

    public AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.j6.DW(i);
    }
}
