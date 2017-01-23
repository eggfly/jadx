package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.menu.C0439m.C0436a;
import android.support.v7.view.menu.C0441l.C0342a;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.e */
public class C0446e implements C0441l, OnItemClickListener {
    Context f1195a;
    LayoutInflater f1196b;
    C0447f f1197c;
    ExpandedMenuView f1198d;
    int f1199e;
    int f1200f;
    C0445a f1201g;
    private int f1202h;
    private C0342a f1203i;

    /* renamed from: android.support.v7.view.menu.e.a */
    private class C0445a extends BaseAdapter {
        final /* synthetic */ C0446e f1193a;
        private int f1194b;

        public C0445a(C0446e c0446e) {
            this.f1193a = c0446e;
            this.f1194b = -1;
            m1366a();
        }

        public C0450h m1365a(int i) {
            ArrayList l = this.f1193a.f1197c.m1424l();
            int a = this.f1193a.f1202h + i;
            if (this.f1194b >= 0 && a >= this.f1194b) {
                a++;
            }
            return (C0450h) l.get(a);
        }

        void m1366a() {
            C0450h r = this.f1193a.f1197c.m1430r();
            if (r != null) {
                ArrayList l = this.f1193a.f1197c.m1424l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0450h) l.get(i)) == r) {
                        this.f1194b = i;
                        return;
                    }
                }
            }
            this.f1194b = -1;
        }

        public int getCount() {
            int size = this.f1193a.f1197c.m1424l().size() - this.f1193a.f1202h;
            return this.f1194b < 0 ? size : size - 1;
        }

        public /* synthetic */ Object getItem(int i) {
            return m1365a(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? this.f1193a.f1196b.inflate(this.f1193a.f1200f, viewGroup, false) : view;
            ((C0436a) inflate).m1310a(m1365a(i), 0);
            return inflate;
        }

        public void notifyDataSetChanged() {
            m1366a();
            super.notifyDataSetChanged();
        }
    }

    public C0446e(int i, int i2) {
        this.f1200f = i;
        this.f1199e = i2;
    }

    public C0446e(Context context, int i) {
        this(i, 0);
        this.f1195a = context;
        this.f1196b = LayoutInflater.from(this.f1195a);
    }

    public C0439m m1368a(ViewGroup viewGroup) {
        if (this.f1198d == null) {
            this.f1198d = (ExpandedMenuView) this.f1196b.inflate(C0417R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1201g == null) {
                this.f1201g = new C0445a(this);
            }
            this.f1198d.setAdapter(this.f1201g);
            this.f1198d.setOnItemClickListener(this);
        }
        return this.f1198d;
    }

    public ListAdapter m1369a() {
        if (this.f1201g == null) {
            this.f1201g = new C0445a(this);
        }
        return this.f1201g;
    }

    public void m1370a(Context context, C0447f c0447f) {
        if (this.f1199e != 0) {
            this.f1195a = new ContextThemeWrapper(context, this.f1199e);
            this.f1196b = LayoutInflater.from(this.f1195a);
        } else if (this.f1195a != null) {
            this.f1195a = context;
            if (this.f1196b == null) {
                this.f1196b = LayoutInflater.from(this.f1195a);
            }
        }
        this.f1197c = c0447f;
        if (this.f1201g != null) {
            this.f1201g.notifyDataSetChanged();
        }
    }

    public void m1371a(C0447f c0447f, boolean z) {
        if (this.f1203i != null) {
            this.f1203i.m847a(c0447f, z);
        }
    }

    public void m1372a(C0342a c0342a) {
        this.f1203i = c0342a;
    }

    public void m1373a(boolean z) {
        if (this.f1201g != null) {
            this.f1201g.notifyDataSetChanged();
        }
    }

    public boolean m1374a(C0447f c0447f, C0450h c0450h) {
        return false;
    }

    public boolean m1375a(C0462p c0462p) {
        if (!c0462p.hasVisibleItems()) {
            return false;
        }
        new C0448g(c0462p).m1432a(null);
        if (this.f1203i != null) {
            this.f1203i.m848a(c0462p);
        }
        return true;
    }

    public boolean m1376b() {
        return false;
    }

    public boolean m1377b(C0447f c0447f, C0450h c0450h) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1197c.m1404a(this.f1201g.m1365a(i), (C0441l) this, 0);
    }
}
