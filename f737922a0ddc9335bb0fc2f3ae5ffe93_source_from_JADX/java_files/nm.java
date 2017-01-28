import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.view.View;
import android.widget.ExpandableListView;
import com.aide.analytics.a;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nm extends m {
    private boolean DW;
    private boolean FH;
    private String j6;

    public nm(String str, boolean z) {
        this.FH = true;
        this.j6 = str;
        this.DW = z;
    }

    protected Dialog j6(Activity activity) {
        Builder builder = new Builder(activity);
        List j6 = e.vy().j6();
        View expandableListView = new ExpandableListView(activity);
        expandableListView.setCacheColorHint(0);
        Object nm_a = new nm$a(activity, j6);
        expandableListView.setAdapter(nm_a);
        builder.setTitle(R.f.dialog_create_project_title).setView(expandableListView);
        builder.setOnCancelListener(new nm$1(this));
        Dialog create = builder.create();
        expandableListView.setOnChildClickListener(new nm$2(this, nm_a, create, activity, j6));
        expandableListView.expandGroup(0);
        return create;
    }

    private void DW() {
        if (this.DW) {
            Object obj;
            Map hashMap = new HashMap();
            if (this.FH) {
                obj = "cancelled";
            } else {
                obj = "createContinued";
            }
            hashMap.put("exit", obj);
            a.j6("New user experience", hashMap);
        }
    }
}
