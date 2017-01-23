package com.antutu.benchmark.p036a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.CpuInfoActivity.C1227c;
import com.antutu.utils.MLog;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.f */
public class C1110f extends BaseAdapter {
    private List<C1108a> f3740a;
    private Context f3741b;
    private LayoutInflater f3742c;
    private int f3743d;
    private Drawable f3744e;
    private Drawable f3745f;

    /* renamed from: com.antutu.benchmark.a.f.a */
    class C1108a {
        String f3734a;
        String f3735b;
        final /* synthetic */ C1110f f3736c;

        public C1108a(C1110f c1110f, String str, String str2) {
            this.f3736c = c1110f;
            this.f3734a = str;
            this.f3735b = str2;
        }
    }

    /* renamed from: com.antutu.benchmark.a.f.b */
    class C1109b {
        public TextView f3737a;
        public TextView f3738b;
        final /* synthetic */ C1110f f3739c;

        C1109b(C1110f c1110f) {
            this.f3739c = c1110f;
        }
    }

    public C1110f(Context context, List<C1227c> list) {
        this.f3740a = new ArrayList();
        this.f3741b = context;
        this.f3743d = list.size();
        for (int i = 0; i < list.size(); i++) {
            this.f3740a.add(new C1108a(this, ((C1227c) list.get(i)).f4138e, ((C1227c) list.get(i)).f4139f));
        }
        MLog.m6865d(getClass().getName(), "count :" + list);
        this.f3742c = (LayoutInflater) this.f3741b.getSystemService("layout_inflater");
        this.f3744e = this.f3741b.getResources().getDrawable(C1082R.drawable.danshu);
        this.f3745f = this.f3741b.getResources().getDrawable(C1082R.drawable.oushu);
    }

    public void m4869a(List<C1227c> list) {
        this.f3740a.clear();
        for (int i = 0; i < list.size(); i++) {
            String str = ((C1227c) list.get(i)).f4138e;
            String str2 = ((C1227c) list.get(i)).f4139f;
            C1108a c1108a = new C1108a(this, str, str2);
            MLog.m6865d("cpu_size", "name:" + str + "  value:" + str2);
            this.f3740a.add(c1108a);
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f3743d;
    }

    public Object getItem(int i) {
        return this.f3740a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1109b c1109b;
        if (view == null) {
            view = this.f3742c.inflate(C1082R.layout.cpu_item_per, null);
            c1109b = new C1109b(this);
            c1109b.f3737a = (TextView) view.findViewById(C1082R.id.cpuHead);
            c1109b.f3738b = (TextView) view.findViewById(C1082R.id.cpuBtom);
            view.setTag(c1109b);
        } else {
            c1109b = (C1109b) view.getTag();
        }
        String str = BuildConfig.FLAVOR;
        str = BuildConfig.FLAVOR;
        CharSequence charSequence = ((C1108a) this.f3740a.get(i)).f3734a;
        CharSequence charSequence2 = ((C1108a) this.f3740a.get(i)).f3735b;
        view.setBackgroundDrawable(null);
        if (i == this.f3743d - 1) {
            MLog.m6864d("size:" + this.f3743d);
            if (i % 2 != 0) {
                view.setBackgroundResource(C1082R.drawable.list_item_bottom3);
            } else {
                view.setBackgroundResource(C1082R.drawable.list_item_bottom2);
            }
        } else if (i == 0) {
            view.setBackgroundResource(C1082R.drawable.list_item_top2);
        } else if (i % 2 != 0) {
            view.setBackgroundResource(C1082R.drawable.list_item_mid3);
        } else {
            view.setBackgroundResource(C1082R.drawable.list_item_mid2);
        }
        if (charSequence.contains("Core ")) {
            c1109b.f3737a.setPadding(20, 0, 0, 0);
        }
        c1109b.f3737a.setText(charSequence);
        c1109b.f3738b.setText(charSequence2);
        return view;
    }
}
