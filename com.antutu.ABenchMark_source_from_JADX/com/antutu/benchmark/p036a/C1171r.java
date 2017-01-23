package com.antutu.benchmark.p036a;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.r */
public abstract class C1171r extends BaseAdapter implements SectionIndexer {
    private static int f3958c;
    private List<C1170b> f3959a;
    private List<Integer> f3960b;
    private ArrayList<String> f3961d;
    private List<C1169a> f3962e;
    private int f3963f;

    /* renamed from: com.antutu.benchmark.a.r.a */
    public class C1169a {
        public int f3953a;
        final /* synthetic */ C1171r f3954b;

        public C1169a(C1171r c1171r) {
            this.f3954b = c1171r;
        }
    }

    /* renamed from: com.antutu.benchmark.a.r.b */
    public class C1170b {
        public String f3955a;
        public Adapter f3956b;
        final /* synthetic */ C1171r f3957c;

        public C1170b(C1171r c1171r, String str, Adapter adapter) {
            this.f3957c = c1171r;
            this.f3955a = str;
            this.f3956b = adapter;
        }
    }

    static {
        f3958c = 0;
    }

    public C1171r() {
        this.f3959a = new ArrayList();
        this.f3960b = new ArrayList();
        this.f3961d = new ArrayList();
        this.f3962e = new ArrayList();
        this.f3963f = 0;
    }

    private void m4931b() {
        this.f3960b.clear();
        this.f3960b.add(Integer.valueOf(0));
        int i = 0;
        for (int i2 = 0; i2 < this.f3959a.size() - 1; i2++) {
            i += ((C1170b) this.f3959a.get(i2)).f3956b.getCount() + 1;
            this.f3960b.add(Integer.valueOf(i));
        }
    }

    public abstract View m4932a(String str, int i, View view, ViewGroup viewGroup);

    public void m4933a() {
        this.f3959a.clear();
        this.f3960b.clear();
    }

    public void m4934a(String str, Adapter adapter) {
        this.f3959a.add(new C1170b(this, str, adapter));
        m4931b();
    }

    public int getCount() {
        this.f3961d.clear();
        this.f3962e.clear();
        int i = 0;
        int i2 = 0;
        for (C1170b c1170b : this.f3959a) {
            int i3;
            i2 += c1170b.f3956b.getCount() + 1;
            try {
                this.f3961d.add(c1170b.f3955a);
                C1169a c1169a = new C1169a(this);
                c1169a.f3953a = i;
                this.f3962e.add(c1169a);
                Iterator it = ((C1129l) c1170b.f3956b).m4890a().iterator();
                while (it.hasNext()) {
                    this.f3961d.add((String) it.next());
                    C1169a c1169a2 = new C1169a(this);
                    c1169a2.f3953a = i;
                    this.f3962e.add(c1169a2);
                }
                i3 = i + 1;
            } catch (Exception e) {
                i3 = i;
            }
            i = i3;
        }
        return i2;
    }

    public Object getItem(int i) {
        for (C1170b c1170b : this.f3959a) {
            if (i == 0) {
                return c1170b;
            }
            int count = c1170b.f3956b.getCount() + 1;
            if (i < count) {
                return c1170b.f3956b.getItem(i - 1);
            }
            i -= count;
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        int i2 = f3958c + 1;
        int i3 = i2;
        for (C1170b c1170b : this.f3959a) {
            if (i == 0) {
                return f3958c;
            }
            int count = c1170b.f3956b.getCount() + 1;
            if (i < count) {
                return c1170b.f3956b.getItemViewType(i - 1) + i3;
            }
            i -= count;
            i3 = c1170b.f3956b.getViewTypeCount() + i3;
        }
        return -1;
    }

    public int getPositionForSection(int i) {
        return ((Integer) this.f3960b.get(i)).intValue();
    }

    public int getSectionForPosition(int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3959a.size(); i4++) {
            i2 += ((C1170b) this.f3959a.get(i4)).f3956b.getCount() + 1;
            if (i < i2) {
                break;
            }
            i3++;
        }
        return i3;
    }

    public Object[] getSections() {
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int sectionForPosition = getSectionForPosition(i);
        C1170b c1170b = (C1170b) this.f3959a.get(sectionForPosition);
        if (this.f3960b.contains(Integer.valueOf(i))) {
            return m4932a(c1170b.f3955a, this.f3960b.indexOf(Integer.valueOf(i)), view, viewGroup);
        }
        return c1170b.f3956b.getView((i - ((Integer) this.f3960b.get(sectionForPosition)).intValue()) - 1, view, viewGroup);
    }

    public int getViewTypeCount() {
        int i = 1;
        for (C1170b c1170b : this.f3959a) {
            i = c1170b.f3956b.getViewTypeCount() + i;
        }
        this.f3963f = i;
        Log.d("SectionedAdapter", "totalCount:" + this.f3963f);
        return i;
    }

    public boolean isEnabled(int i) {
        return getItemViewType(i) != f3958c;
    }

    public void notifyDataSetChanged() {
        m4931b();
        super.notifyDataSetChanged();
    }
}
