package com.antutu.benchmark.p036a;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1538p;
import com.antutu.benchmark.view.MaterialRippleLayout;
import com.antutu.redacc.C1692R;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.t */
public class C1177t extends BaseAdapter {
    private Context f3976a;
    private List<C1538p> f3977b;
    private C1175a f3978c;

    /* renamed from: com.antutu.benchmark.a.t.1 */
    class C11731 implements OnClickListener {
        final /* synthetic */ View f3964a;
        final /* synthetic */ int f3965b;
        final /* synthetic */ C1538p f3966c;
        final /* synthetic */ C1177t f3967d;

        C11731(C1177t c1177t, View view, int i, C1538p c1538p) {
            this.f3967d = c1177t;
            this.f3964a = view;
            this.f3965b = i;
            this.f3966c = c1538p;
        }

        public void onClick(View view) {
            if (this.f3967d.f3978c != null) {
                this.f3967d.f3978c.m4936a(this.f3967d, this.f3964a, this.f3965b, this.f3966c);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.a.t.2 */
    class C11742 implements OnClickListener {
        final /* synthetic */ C1176b f3968a;
        final /* synthetic */ C1177t f3969b;

        C11742(C1177t c1177t, C1176b c1176b) {
            this.f3969b = c1177t;
            this.f3968a = c1176b;
        }

        public void onClick(View view) {
            this.f3968a.f3974e.setChecked(!this.f3968a.f3974e.isChecked());
        }
    }

    /* renamed from: com.antutu.benchmark.a.t.a */
    public interface C1175a {
        void m4936a(C1177t c1177t, View view, int i, C1538p c1538p);
    }

    /* renamed from: com.antutu.benchmark.a.t.b */
    public static class C1176b {
        public ImageView f3970a;
        public TextView f3971b;
        public ImageView f3972c;
        private MaterialRippleLayout f3973d;
        private SwitchCompat f3974e;
        private TextView f3975f;
    }

    public C1177t(Context context, List<C1538p> list) {
        this.f3976a = context;
        this.f3977b = list;
    }

    public void m4944a(C1175a c1175a) {
        this.f3978c = c1175a;
    }

    public int getCount() {
        return this.f3977b.size();
    }

    public Object getItem(int i) {
        return this.f3977b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1176b c1176b;
        if (view == null) {
            view = View.inflate(this.f3976a, C1082R.layout.adapter_slidemenu_option_item, null);
            c1176b = new C1176b();
            c1176b.f3970a = (ImageView) view.findViewById(C1692R.id.iv_icon);
            c1176b.f3971b = (TextView) view.findViewById(C1082R.id.tv_text);
            c1176b.f3972c = (ImageView) view.findViewById(C1082R.id.iv_red_point);
            c1176b.f3973d = (MaterialRippleLayout) view.findViewById(C1082R.id.ll_background);
            c1176b.f3974e = (SwitchCompat) view.findViewById(C1082R.id.ss_toggle);
            c1176b.f3975f = (TextView) view.findViewById(C1082R.id.tv_desc);
            view.setTag(c1176b);
        } else {
            c1176b = (C1176b) view.getTag();
        }
        C1538p c1538p = (C1538p) this.f3977b.get(i);
        c1176b.f3970a.setImageResource(c1538p.m6089a());
        c1176b.f3971b.setText(c1538p.m6091b());
        if (c1538p.m6094e() != 0) {
            c1176b.f3975f.setText(c1538p.m6094e());
        } else {
            c1176b.f3975f.setText(BuildConfig.FLAVOR);
        }
        if (c1538p.m6092c()) {
            c1176b.f3972c.setVisibility(0);
        } else {
            c1176b.f3972c.setVisibility(8);
        }
        if ("NORMAL_TYPE".equals(c1538p.m6093d())) {
            c1176b.f3974e.setVisibility(8);
            c1176b.f3973d.setOnClickListener(new C11731(this, view, i, c1538p));
        } else if ("SWITCH_TYPE".equals(c1538p.m6093d())) {
            c1176b.f3974e.setVisibility(0);
            c1176b.f3973d.setOnClickListener(new C11742(this, c1176b));
            c1176b.f3974e.setOnCheckedChangeListener(null);
            c1176b.f3974e.setChecked(c1538p.m6096g());
            c1176b.f3974e.setOnCheckedChangeListener(c1538p.m6095f());
        }
        return view;
    }
}
