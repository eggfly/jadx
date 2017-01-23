package com.antutu.benchmark.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.gc.materialdesign.C2513R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.view.m */
public class C1687m extends PopupWindow {
    private C1098c f6023a;

    /* renamed from: com.antutu.benchmark.view.m.c */
    public interface C1098c {
        void m4847a(int i);
    }

    /* renamed from: com.antutu.benchmark.view.m.1 */
    class C16831 implements OnItemClickListener {
        final /* synthetic */ C1687m f6015a;

        C16831(C1687m c1687m) {
            this.f6015a = c1687m;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f6015a.dismiss();
            if (this.f6015a.f6023a != null) {
                this.f6015a.f6023a.m4847a((int) j);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.m.a */
    private class C1685a extends BaseAdapter {
        final /* synthetic */ C1687m f6018a;
        private List<C1686b> f6019b;
        private Context f6020c;

        /* renamed from: com.antutu.benchmark.view.m.a.a */
        protected class C1684a {
            TextView f6016a;
            final /* synthetic */ C1685a f6017b;

            protected C1684a(C1685a c1685a) {
                this.f6017b = c1685a;
            }
        }

        public C1685a(C1687m c1687m, List<C1686b> list, Context context) {
            this.f6018a = c1687m;
            this.f6019b = list;
            this.f6020c = context;
        }

        public C1686b m6593a(int i) {
            return (C1686b) this.f6019b.get(i);
        }

        public int getCount() {
            return this.f6019b == null ? 0 : this.f6019b.size();
        }

        public /* synthetic */ Object getItem(int i) {
            return m6593a(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1684a c1684a;
            if (view == null) {
                view = LayoutInflater.from(this.f6020c).inflate(C1082R.layout.adapter_popup_reply_comment, null);
                c1684a = new C1684a(this);
                c1684a.f6016a = (TextView) view.findViewById(C2513R.id.title);
                view.setTag(c1684a);
            } else {
                c1684a = (C1684a) view.getTag();
            }
            c1684a.f6016a.setText(((C1686b) this.f6019b.get(i)).f6021a);
            return view;
        }
    }

    /* renamed from: com.antutu.benchmark.view.m.b */
    private class C1686b {
        protected String f6021a;
        final /* synthetic */ C1687m f6022b;

        private C1686b(C1687m c1687m) {
            this.f6022b = c1687m;
        }
    }

    public C1687m(Activity activity, String[] strArr) {
        super(activity);
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(C1082R.layout.popup_reply_commnet, null);
        ListView listView = (ListView) inflate.findViewById(C1082R.id.popview_list);
        listView.setAdapter(new C1685a(this, m6595a(strArr), activity));
        setContentView(inflate);
        setWidth(m6596a(activity, 150.0f));
        setHeight(-2);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        listView.setOnItemClickListener(new C16831(this));
    }

    private List<C1686b> m6595a(String[] strArr) {
        List<C1686b> arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                C1686b c1686b = new C1686b();
                c1686b.f6021a = str;
                arrayList.add(c1686b);
            }
        }
        return arrayList;
    }

    public int m6596a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public void m6597a(C1098c c1098c) {
        this.f6023a = c1098c;
    }
}
