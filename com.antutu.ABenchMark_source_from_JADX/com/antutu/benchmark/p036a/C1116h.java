package com.antutu.benchmark.p036a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1524e;
import com.antutu.benchmark.model.C1525f;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.h */
public class C1116h extends BaseExpandableListAdapter {
    private Activity f3762a;
    private List<C1525f> f3763b;
    private List<List<C1524e>> f3764c;

    /* renamed from: com.antutu.benchmark.a.h.a */
    static class C1114a {
        TextView f3754a;
        TextView f3755b;
        TextView f3756c;

        C1114a() {
        }
    }

    /* renamed from: com.antutu.benchmark.a.h.b */
    static class C1115b {
        TextView f3757a;
        TextView f3758b;
        ImageView f3759c;
        TextView f3760d;
        View f3761e;

        C1115b() {
        }
    }

    public C1116h(Activity activity, List<C1525f> list, List<List<C1524e>> list2) {
        this.f3762a = activity;
        this.f3763b = list;
        this.f3764c = list2;
    }

    public Object getChild(int i, int i2) {
        return ((List) this.f3764c.get(i)).get(i2);
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1114a c1114a;
        C1524e c1524e = (C1524e) ((List) this.f3764c.get(i)).get(i2);
        if (view == null) {
            C1114a c1114a2 = new C1114a();
            view = View.inflate(this.f3762a, C1082R.layout.item_child_detail_score, null);
            c1114a2.f3754a = (TextView) view.findViewById(C1082R.id.tv_title);
            c1114a2.f3755b = (TextView) view.findViewById(C1082R.id.tv_score);
            c1114a2.f3756c = (TextView) view.findViewById(C1082R.id.tv_colon);
            view.setTag(c1114a2);
            c1114a = c1114a2;
        } else {
            c1114a = (C1114a) view.getTag();
        }
        if (c1524e.m6066c() == null || BuildConfig.FLAVOR.equals(c1524e.m6066c())) {
            c1114a.f3755b.setVisibility(8);
            c1114a.f3756c.setVisibility(8);
        } else {
            c1114a.f3755b.setVisibility(0);
            c1114a.f3756c.setVisibility(0);
        }
        c1114a.f3754a.setText(c1524e.m6065b());
        c1114a.f3755b.setText(c1524e.m6066c());
        try {
            if (c1524e.m6064a()) {
                c1114a.f3755b.setTextColor(view.getResources().getColor(C1082R.color.fake_score));
            } else {
                c1114a.f3755b.setTextColor(view.getResources().getColor(C1082R.color.green_text));
            }
        } catch (Exception e) {
        }
        return view;
    }

    public int getChildrenCount(int i) {
        return ((List) this.f3764c.get(i)).size();
    }

    public Object getGroup(int i) {
        return this.f3763b.get(i);
    }

    public int getGroupCount() {
        return this.f3763b.size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C1115b c1115b;
        C1525f c1525f = (C1525f) this.f3763b.get(i);
        if (view == null) {
            c1115b = new C1115b();
            view = View.inflate(this.f3762a, C1082R.layout.item_parent_detail_score_title, null);
            c1115b.f3757a = (TextView) view.findViewById(C1082R.id.tv_title);
            c1115b.f3758b = (TextView) view.findViewById(C1082R.id.tv_score);
            c1115b.f3759c = (ImageView) view.findViewById(C1082R.id.iv_arrow);
            c1115b.f3760d = (TextView) view.findViewById(C1082R.id.tv_score_tail);
            c1115b.f3761e = view.findViewById(C1082R.id.ll_background);
            view.setTag(c1115b);
        } else {
            c1115b = (C1115b) view.getTag();
        }
        c1115b.f3757a.setText(c1525f.m6068b());
        c1115b.f3758b.setText(c1525f.m6069c());
        if (this.f3762a.getString(C1082R.string.unsupported).equals(c1525f.m6069c())) {
            c1115b.f3760d.setVisibility(8);
        } else {
            c1115b.f3760d.setVisibility(0);
        }
        if (z) {
            c1115b.f3759c.setImageResource(C1082R.drawable.arrow_up);
        } else {
            c1115b.f3759c.setImageResource(C1082R.drawable.arrow_down);
        }
        if (((List) this.f3764c.get(i)).size() <= 0) {
            c1115b.f3759c.setVisibility(8);
        } else {
            c1115b.f3759c.setVisibility(0);
        }
        try {
            if (c1525f.m6067a()) {
                c1115b.f3758b.setTextColor(view.getResources().getColor(C1082R.color.fake_score));
                c1115b.f3760d.setTextColor(view.getResources().getColor(C1082R.color.fake_score));
            } else {
                c1115b.f3758b.setTextColor(view.getResources().getColor(C1082R.color.green_text));
                c1115b.f3760d.setTextColor(view.getResources().getColor(C1082R.color.green_text));
            }
        } catch (Exception e) {
        }
        return view;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
