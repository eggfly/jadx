import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import com.aide.analytics.a;
import com.aide.common.m;
import com.aide.ui.activities.TrainerCourseActivity;
import com.aide.ui.e;
import java.util.List;

class nm$2 implements OnChildClickListener {
    final /* synthetic */ AlertDialog DW;
    final /* synthetic */ Activity FH;
    final /* synthetic */ List Hw;
    final /* synthetic */ nm$a j6;
    final /* synthetic */ nm v5;

    nm$2(nm nmVar, nm$a nm_a, AlertDialog alertDialog, Activity activity, List list) {
        this.v5 = nmVar;
        this.j6 = nm_a;
        this.DW = alertDialog;
        this.FH = activity;
        this.Hw = list;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        if (this.j6.j6(i, i2)) {
            a.DW("Samples click");
            this.v5.FH = false;
            this.DW.dismiss();
            this.v5.DW();
            String j6 = this.j6.j6(i);
            if (e.Hw() || e.QX().Hw(j6).Ws()) {
                TrainerCourseActivity.j6(this.FH, j6);
            } else {
                e.Mr().Hw(e.u7(), j6, "show_samples");
            }
        } else {
            pn$a pn_a = (pn$a) ((List) this.Hw.get(i)).get(i2);
            if (pn_a.Zo.u7) {
                this.v5.FH = false;
                this.DW.dismiss();
                this.v5.DW();
                m.j6(this.FH, new nn(this.v5.j6, pn_a, null));
            } else {
                e.Mr().v5(e.u7(), pn_a.Zo.FH, "create_project");
            }
        }
        return true;
    }
}
