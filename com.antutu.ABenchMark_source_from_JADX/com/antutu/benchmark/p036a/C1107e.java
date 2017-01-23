package com.antutu.benchmark.p036a;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.e */
public class C1107e extends BaseAdapter {
    private LayoutInflater f3728a;
    private List<C1105d> f3729b;
    private int f3730c;
    private int f3731d;
    private int f3732e;
    private int f3733f;

    /* renamed from: com.antutu.benchmark.a.e.a */
    static class C1106a {
        ImageView f3723a;
        ImageView f3724b;
        TextView f3725c;
        TextView f3726d;
        TextView f3727e;

        C1106a() {
        }
    }

    public C1107e(Context context, List<C1105d> list) {
        this.f3728a = null;
        this.f3729b = null;
        this.f3728a = LayoutInflater.from(context);
        this.f3730c = Color.parseColor("#57be0b");
        this.f3731d = Color.parseColor("#999999");
        this.f3732e = Color.parseColor("#1c1c1c");
        this.f3733f = Color.parseColor("#1e1f1f");
        this.f3729b = list;
    }

    public C1105d m4868a(int i) {
        return this.f3729b != null ? (C1105d) this.f3729b.get(i) : null;
    }

    public int getCount() {
        return this.f3729b == null ? 0 : this.f3729b.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return m4868a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        C1106a c1106a;
        if (view == null) {
            try {
                inflate = this.f3728a.inflate(C1082R.layout.compare_item, null);
            } catch (Exception e) {
                return view;
            }
            try {
                c1106a = new C1106a();
                c1106a.f3726d = (TextView) inflate.findViewById(C1082R.id.text_left);
                c1106a.f3727e = (TextView) inflate.findViewById(C1082R.id.text_right);
                c1106a.f3725c = (TextView) inflate.findViewById(C1082R.id.text_info);
                c1106a.f3723a = (ImageView) inflate.findViewById(C1082R.id.img_info);
                c1106a.f3724b = (ImageView) inflate.findViewById(C1082R.id.win);
                inflate.setTag(c1106a);
            } catch (Exception e2) {
                return inflate;
            }
        }
        c1106a = (C1106a) view.getTag();
        inflate = view;
        C1105d c1105d = (C1105d) this.f3729b.get(i);
        c1106a.f3726d.setText(c1105d.f3717a + c1105d.f3721e);
        c1106a.f3727e.setText(c1105d.f3722f + c1105d.f3718b);
        if (c1105d.f3717a > c1105d.f3718b) {
            c1106a.f3726d.setTextColor(this.f3730c);
            c1106a.f3727e.setTextColor(this.f3731d);
        } else {
            c1106a.f3726d.setTextColor(this.f3731d);
            c1106a.f3727e.setTextColor(this.f3730c);
        }
        if (i % 2 == 0) {
            inflate.setBackgroundColor(this.f3732e);
        } else {
            inflate.setBackgroundColor(this.f3733f);
        }
        c1106a.f3725c.setText(c1105d.f3720d);
        return inflate;
    }
}
