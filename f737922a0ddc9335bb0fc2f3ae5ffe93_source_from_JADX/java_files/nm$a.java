import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.trainer.c.c;
import java.util.List;

class nm$a extends BaseExpandableListAdapter {
    private Context DW;
    private List<List<pn$a>> j6;

    public nm$a(Context context, List<List<pn$a>> list) {
        this.DW = context;
        this.j6 = list;
    }

    public String j6(int i) {
        return ((pn$a) ((List) this.j6.get(i)).get(0)).Zo.EQ;
    }

    public boolean j6(int i, int i2) {
        return DW(i) && i2 == ((List) this.j6.get(i)).size();
    }

    private boolean DW(int i) {
        c Hw = e.QX().Hw(j6(i));
        return Hw != null && Hw.v5() > 0;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.DW).inflate(R.c.designer_widgetlist_group, viewGroup, false);
        }
        ((TextView) view.findViewById(R.b.widgetlistGroupName)).setText(((pn$a) getChild(i, 0)).Zo.Hw);
        return view;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.DW).inflate(R.c.createproject_entry, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.b.projecttypeEntryLabel);
        TextView textView2 = (TextView) view.findViewById(R.b.projecttypeEntryDescription);
        ImageView imageView = (ImageView) view.findViewById(R.b.projecttypeEntryImage);
        pn$a pn_a;
        float f;
        if (j6(i, i2)) {
            pn_a = (pn$a) getChild(i, 0);
            textView.setText(R.f.dialog_create_project_samples);
            textView2.setVisibility(8);
            imageView.setImageResource(pn_a.v5);
            f = pn_a.Zo.u7 ? 1.0f : 0.5f;
            imageView.setAlpha(f);
            textView.setAlpha(f);
            textView2.setAlpha(f);
        } else {
            pn_a = (pn$a) getChild(i, i2);
            textView.setText(this.DW.getResources().getString(R.f.dialog_create_project_new, new Object[]{pn_a.j6}));
            textView2.setVisibility(0);
            textView2.setText(pn_a.Zo.DW);
            imageView.setImageResource(pn_a.v5);
            f = pn_a.Zo.u7 ? 1.0f : 0.5f;
            imageView.setAlpha(f);
            textView.setAlpha(f);
            textView2.setAlpha(f);
        }
        return view;
    }

    public Object getGroup(int i) {
        return this.j6.get(i);
    }

    public Object getChild(int i, int i2) {
        return ((List) this.j6.get(i)).get(i2);
    }

    public int getGroupCount() {
        return this.j6.size();
    }

    public int getChildrenCount(int i) {
        return (DW(i) ? 1 : 0) + ((List) this.j6.get(i)).size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public long getChildId(int i, int i2) {
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
