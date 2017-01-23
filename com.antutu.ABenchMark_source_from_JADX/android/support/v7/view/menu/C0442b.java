package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.C0439m.C0436a;
import android.support.v7.view.menu.C0441l.C0342a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.b */
public abstract class C0442b implements C0441l {
    protected Context f1179a;
    protected Context f1180b;
    protected C0447f f1181c;
    protected LayoutInflater f1182d;
    protected LayoutInflater f1183e;
    protected C0439m f1184f;
    private C0342a f1185g;
    private int f1186h;
    private int f1187i;
    private int f1188j;

    public C0442b(Context context, int i, int i2) {
        this.f1179a = context;
        this.f1182d = LayoutInflater.from(context);
        this.f1186h = i;
        this.f1187i = i2;
    }

    public C0342a m1343a() {
        return this.f1185g;
    }

    public C0439m m1344a(ViewGroup viewGroup) {
        if (this.f1184f == null) {
            this.f1184f = (C0439m) this.f1182d.inflate(this.f1186h, viewGroup, false);
            this.f1184f.m1324a(this.f1181c);
            m1352a(true);
        }
        return this.f1184f;
    }

    public View m1345a(C0450h c0450h, View view, ViewGroup viewGroup) {
        C0436a b = view instanceof C0436a ? (C0436a) view : m1357b(viewGroup);
        m1349a(c0450h, b);
        return (View) b;
    }

    public void m1346a(int i) {
        this.f1188j = i;
    }

    public void m1347a(Context context, C0447f c0447f) {
        this.f1180b = context;
        this.f1183e = LayoutInflater.from(this.f1180b);
        this.f1181c = c0447f;
    }

    public void m1348a(C0447f c0447f, boolean z) {
        if (this.f1185g != null) {
            this.f1185g.m847a(c0447f, z);
        }
    }

    public abstract void m1349a(C0450h c0450h, C0436a c0436a);

    public void m1350a(C0342a c0342a) {
        this.f1185g = c0342a;
    }

    protected void m1351a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1184f).addView(view, i);
    }

    public void m1352a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1184f;
        if (viewGroup != null) {
            int i;
            if (this.f1181c != null) {
                this.f1181c.m1422j();
                ArrayList i2 = this.f1181c.m1421i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0450h c0450h = (C0450h) i2.get(i3);
                    if (m1353a(i, c0450h)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0450h itemData = childAt instanceof C0436a ? ((C0436a) childAt).getItemData() : null;
                        View a = m1345a(c0450h, childAt, viewGroup);
                        if (c0450h != itemData) {
                            a.setPressed(false);
                            ViewCompat.jumpDrawablesToCurrentState(a);
                        }
                        if (a != childAt) {
                            m1351a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!m1356a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean m1353a(int i, C0450h c0450h) {
        return true;
    }

    public boolean m1354a(C0447f c0447f, C0450h c0450h) {
        return false;
    }

    public boolean m1355a(C0462p c0462p) {
        return this.f1185g != null ? this.f1185g.m848a(c0462p) : false;
    }

    protected boolean m1356a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public C0436a m1357b(ViewGroup viewGroup) {
        return (C0436a) this.f1182d.inflate(this.f1187i, viewGroup, false);
    }

    public boolean m1358b() {
        return false;
    }

    public boolean m1359b(C0447f c0447f, C0450h c0450h) {
        return false;
    }
}
