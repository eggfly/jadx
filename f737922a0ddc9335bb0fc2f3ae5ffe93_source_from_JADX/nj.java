import com.aide.ui.R;
import com.aide.ui.e;

public class nj implements qm {
    public int f_() {
        return R.b.mainMenuGoPremium;
    }

    public boolean DW() {
        e.Mr().j6(e.tp(), (int) R.f.shop_feature_features_and_lessons, "go_premium_command", false, false);
        return true;
    }

    public boolean g_() {
        return true;
    }

    public boolean j6(boolean z) {
        if ((e.j6.equals("com.aide.ui") || e.j6.equals("com.aide.web")) && !e.Mr().v5()) {
            return true;
        }
        return false;
    }
}
