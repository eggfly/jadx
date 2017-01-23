package com.antutu.redacc.p066a;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView.C0510a;
import android.support.v7.widget.RecyclerView.C0532u;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p067f.C1762r;
import com.antutu.redacc.p072e.C1737a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.redacc.a.a */
public class C1695a extends C0510a<C1694b> implements OnClickListener {
    private List<C1737a> f6042a;
    private Activity f6043b;
    private C1693a f6044c;
    private Context f6045d;

    /* renamed from: com.antutu.redacc.a.a.a */
    public interface C1693a {
        void m6607a(C1737a c1737a);
    }

    /* renamed from: com.antutu.redacc.a.a.b */
    static class C1694b extends C0532u {
        ImageView f6037a;
        TextView f6038b;
        TextView f6039c;
        TextView f6040d;
        ImageView f6041e;

        public C1694b(View view) {
            super(view);
            this.f6037a = (ImageView) view.findViewById(C1692R.id.iv_icon);
            this.f6038b = (TextView) view.findViewById(C1692R.id.tv_appName);
            this.f6039c = (TextView) view.findViewById(C1692R.id.tv_createTime);
            this.f6040d = (TextView) view.findViewById(C1692R.id.tv_room);
            this.f6041e = (ImageView) view.findViewById(C1692R.id.iv_check);
        }
    }

    public C1695a(Activity activity, Context context, List<C1737a> list) {
        this.f6042a = new ArrayList();
        this.f6043b = activity;
        if (list != null) {
            this.f6042a.addAll(list);
        }
        this.f6045d = context;
    }

    public C1694b m6608a(ViewGroup viewGroup, int i) {
        return new C1694b(LayoutInflater.from(this.f6043b).inflate(C1692R.layout.item_apps_recycleview, viewGroup, false));
    }

    public void m6609a(C1693a c1693a) {
        this.f6044c = c1693a;
    }

    public void m6610a(C1694b c1694b, int i) {
        C1737a c1737a = (C1737a) this.f6042a.get(i);
        if (!this.f6045d.getApplicationInfo().packageName.equalsIgnoreCase(c1737a.m6721i())) {
            c1694b.f6037a.setImageURI(c1737a.m6716d());
            if (c1694b.f6037a.getDrawable() == null) {
                c1694b.f6037a.setImageResource(C1692R.drawable.ic_app_default);
            }
            c1694b.f6038b.setText(c1737a.m6718f());
            if (c1737a.m6708b() > 0) {
                TextView textView = c1694b.f6040d;
                StringBuilder append = new StringBuilder().append(this.f6045d.getString(C1692R.string.str9));
                C1762r.m6776e();
                textView.setText(append.append(C1762r.m6770a(c1737a.m6708b())).toString());
            }
            if (c1737a.m6702a() == -1) {
                c1694b.f6039c.setVisibility(8);
            } else {
                c1694b.f6039c.setVisibility(0);
                c1694b.f6039c.setText(DateUtils.getRelativeTimeSpanString(c1737a.m6702a(), System.currentTimeMillis(), 1000).toString());
            }
            if (c1737a.m6717e()) {
                c1694b.f6041e.setBackgroundResource(C1692R.drawable.bg_cb_checked);
                c1694b.f6041e.setImageResource(C1692R.drawable.cb_checked_all);
            } else {
                c1694b.f6041e.setBackgroundResource(C1692R.drawable.bg_cb_unchecked);
                c1694b.f6041e.setImageResource(C1692R.drawable.bg_cb_unchecked);
            }
            c1694b.f6041e.setTag(Integer.valueOf(i));
            c1694b.f6041e.setOnClickListener(this);
        }
    }

    public void m6611a(List<C1737a> list) {
        if (this.f6042a.size() != 0) {
            this.f6042a.clear();
        }
        this.f6042a.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f6042a.size();
    }

    public /* synthetic */ void onBindViewHolder(C0532u c0532u, int i) {
        m6610a((C1694b) c0532u, i);
    }

    public void onClick(View view) {
        C1737a c1737a = this.f6042a == null ? null : (C1737a) this.f6042a.get(((Integer) view.getTag()).intValue());
        if (c1737a != null) {
            if (c1737a.m6717e()) {
                view.setBackgroundResource(C1692R.drawable.bg_cb_unchecked);
                ((ImageView) view).setImageResource(C1692R.drawable.bg_cb_unchecked);
                c1737a.m6707a(false);
            } else {
                view.setBackgroundResource(C1692R.drawable.bg_cb_checked);
                ((ImageView) view).setImageResource(C1692R.drawable.cb_checked_all);
                c1737a.m6707a(true);
            }
            if (this.f6044c != null) {
                this.f6044c.m6607a(c1737a);
            }
        }
    }

    public /* synthetic */ C0532u onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m6608a(viewGroup, i);
    }
}
