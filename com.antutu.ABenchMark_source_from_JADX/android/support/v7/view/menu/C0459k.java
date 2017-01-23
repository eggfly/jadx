package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.menu.C0439m.C0436a;
import android.support.v7.view.menu.C0441l.C0342a;
import android.support.v7.widget.ap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.k */
public class C0459k implements C0441l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f1271a;
    boolean f1272b;
    private final Context f1273c;
    private final LayoutInflater f1274d;
    private final C0447f f1275e;
    private final C0458a f1276f;
    private final boolean f1277g;
    private final int f1278h;
    private final int f1279i;
    private final int f1280j;
    private View f1281k;
    private ap f1282l;
    private ViewTreeObserver f1283m;
    private C0342a f1284n;
    private ViewGroup f1285o;
    private boolean f1286p;
    private int f1287q;
    private int f1288r;

    /* renamed from: android.support.v7.view.menu.k.a */
    private class C0458a extends BaseAdapter {
        final /* synthetic */ C0459k f1268a;
        private C0447f f1269b;
        private int f1270c;

        public C0458a(C0459k c0459k, C0447f c0447f) {
            this.f1268a = c0459k;
            this.f1270c = -1;
            this.f1269b = c0447f;
            m1468a();
        }

        public C0450h m1467a(int i) {
            ArrayList l = this.f1268a.f1277g ? this.f1269b.m1424l() : this.f1269b.m1421i();
            if (this.f1270c >= 0 && i >= this.f1270c) {
                i++;
            }
            return (C0450h) l.get(i);
        }

        void m1468a() {
            C0450h r = this.f1268a.f1275e.m1430r();
            if (r != null) {
                ArrayList l = this.f1268a.f1275e.m1424l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0450h) l.get(i)) == r) {
                        this.f1270c = i;
                        return;
                    }
                }
            }
            this.f1270c = -1;
        }

        public int getCount() {
            ArrayList l = this.f1268a.f1277g ? this.f1269b.m1424l() : this.f1269b.m1421i();
            return this.f1270c < 0 ? l.size() : l.size() - 1;
        }

        public /* synthetic */ Object getItem(int i) {
            return m1467a(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? this.f1268a.f1274d.inflate(C0459k.f1271a, viewGroup, false) : view;
            C0436a c0436a = (C0436a) inflate;
            if (this.f1268a.f1272b) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            c0436a.m1310a(m1467a(i), 0);
            return inflate;
        }

        public void notifyDataSetChanged() {
            m1468a();
            super.notifyDataSetChanged();
        }
    }

    static {
        f1271a = C0417R.layout.abc_popup_menu_item_layout;
    }

    public C0459k(Context context, C0447f c0447f, View view) {
        this(context, c0447f, view, false, C0417R.attr.popupMenuStyle);
    }

    public C0459k(Context context, C0447f c0447f, View view, boolean z, int i) {
        this(context, c0447f, view, z, i, 0);
    }

    public C0459k(Context context, C0447f c0447f, View view, boolean z, int i, int i2) {
        this.f1288r = 0;
        this.f1273c = context;
        this.f1274d = LayoutInflater.from(context);
        this.f1275e = c0447f;
        this.f1276f = new C0458a(this, this.f1275e);
        this.f1277g = z;
        this.f1279i = i;
        this.f1280j = i2;
        Resources resources = context.getResources();
        this.f1278h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0417R.dimen.abc_config_prefDialogWidth));
        this.f1281k = view;
        c0447f.m1398a((C0441l) this, context);
    }

    private int m1472g() {
        ListAdapter listAdapter = this.f1276f;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.f1285o == null) {
                this.f1285o = new FrameLayout(this.f1273c);
            }
            view = listAdapter.getView(i, view2, this.f1285o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.f1278h) {
                return this.f1278h;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void m1473a() {
        if (!m1486d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void m1474a(int i) {
        this.f1288r = i;
    }

    public void m1475a(Context context, C0447f c0447f) {
    }

    public void m1476a(C0447f c0447f, boolean z) {
        if (c0447f == this.f1275e) {
            m1487e();
            if (this.f1284n != null) {
                this.f1284n.m847a(c0447f, z);
            }
        }
    }

    public void m1477a(C0342a c0342a) {
        this.f1284n = c0342a;
    }

    public void m1478a(View view) {
        this.f1281k = view;
    }

    public void m1479a(boolean z) {
        this.f1286p = false;
        if (this.f1276f != null) {
            this.f1276f.notifyDataSetChanged();
        }
    }

    public boolean m1480a(C0447f c0447f, C0450h c0450h) {
        return false;
    }

    public boolean m1481a(C0462p c0462p) {
        if (c0462p.hasVisibleItems()) {
            boolean z;
            C0459k c0459k = new C0459k(this.f1273c, c0462p, this.f1281k);
            c0459k.m1477a(this.f1284n);
            int size = c0462p.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = c0462p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            c0459k.m1482b(z);
            if (c0459k.m1486d()) {
                if (this.f1284n == null) {
                    return true;
                }
                this.f1284n.m848a(c0462p);
                return true;
            }
        }
        return false;
    }

    public void m1482b(boolean z) {
        this.f1272b = z;
    }

    public boolean m1483b() {
        return false;
    }

    public boolean m1484b(C0447f c0447f, C0450h c0450h) {
        return false;
    }

    public ap m1485c() {
        return this.f1282l;
    }

    public boolean m1486d() {
        boolean z = false;
        this.f1282l = new ap(this.f1273c, null, this.f1279i, this.f1280j);
        this.f1282l.m2354a((OnDismissListener) this);
        this.f1282l.m2352a((OnItemClickListener) this);
        this.f1282l.m2353a(this.f1276f);
        this.f1282l.m2355a(true);
        View view = this.f1281k;
        if (view == null) {
            return false;
        }
        if (this.f1283m == null) {
            z = true;
        }
        this.f1283m = view.getViewTreeObserver();
        if (z) {
            this.f1283m.addOnGlobalLayoutListener(this);
        }
        this.f1282l.m2351a(view);
        this.f1282l.m2360d(this.f1288r);
        if (!this.f1286p) {
            this.f1287q = m1472g();
            this.f1286p = true;
        }
        this.f1282l.m2364f(this.f1287q);
        this.f1282l.m2366g(2);
        this.f1282l.m2357c();
        this.f1282l.m2373m().setOnKeyListener(this);
        return true;
    }

    public void m1487e() {
        if (m1488f()) {
            this.f1282l.m2369i();
        }
    }

    public boolean m1488f() {
        return this.f1282l != null && this.f1282l.m2371k();
    }

    public void onDismiss() {
        this.f1282l = null;
        this.f1275e.close();
        if (this.f1283m != null) {
            if (!this.f1283m.isAlive()) {
                this.f1283m = this.f1281k.getViewTreeObserver();
            }
            this.f1283m.removeGlobalOnLayoutListener(this);
            this.f1283m = null;
        }
    }

    public void onGlobalLayout() {
        if (m1488f()) {
            View view = this.f1281k;
            if (view == null || !view.isShown()) {
                m1487e();
            } else if (m1488f()) {
                this.f1282l.m2357c();
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0458a c0458a = this.f1276f;
        c0458a.f1269b.m1403a(c0458a.m1467a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m1487e();
        return true;
    }
}
