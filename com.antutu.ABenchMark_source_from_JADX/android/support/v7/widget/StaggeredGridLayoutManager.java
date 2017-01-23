package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView.C0491i;
import android.support.v7.widget.RecyclerView.C0493h;
import android.support.v7.widget.RecyclerView.C0493h.C0520a;
import android.support.v7.widget.RecyclerView.C0494q;
import android.support.v7.widget.RecyclerView.C0525n;
import android.support.v7.widget.RecyclerView.C0529r;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.handmark.pulltorefresh.library.C3628R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import org.android.spdy.SpdyProtocol;

public class StaggeredGridLayoutManager extends C0493h {
    as f1644a;
    as f1645b;
    boolean f1646c;
    int f1647d;
    int f1648e;
    LazySpanLookup f1649f;
    private int f1650g;
    private C0545c[] f1651h;
    private int f1652i;
    private int f1653j;
    private final am f1654k;
    private boolean f1655l;
    private BitSet f1656m;
    private int f1657n;
    private boolean f1658o;
    private boolean f1659p;
    private SavedState f1660q;
    private int f1661r;
    private final Rect f1662s;
    private final C0543a f1663t;
    private boolean f1664u;
    private boolean f1665v;
    private final Runnable f1666w;

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.1 */
    class C05391 implements Runnable {
        final /* synthetic */ StaggeredGridLayoutManager f1613a;

        C05391(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f1613a = staggeredGridLayoutManager;
        }

        public void run() {
            this.f1613a.m2059i();
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.2 */
    class C05402 extends ao {
        final /* synthetic */ StaggeredGridLayoutManager f1614a;

        C05402(StaggeredGridLayoutManager staggeredGridLayoutManager, Context context) {
            this.f1614a = staggeredGridLayoutManager;
            super(context);
        }

        public PointF computeScrollVectorForPosition(int i) {
            int a = this.f1614a.m2065l(i);
            return a == 0 ? null : this.f1614a.f1652i == 0 ? new PointF((float) a, 0.0f) : new PointF(0.0f, (float) a);
        }
    }

    static class LazySpanLookup {
        int[] f1619a;
        List<FullSpanItem> f1620b;

        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR;
            int f1615a;
            int f1616b;
            int[] f1617c;
            boolean f1618d;

            /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1 */
            static class C05411 implements Creator<FullSpanItem> {
                C05411() {
                }

                public FullSpanItem m1975a(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public FullSpanItem[] m1976a(int i) {
                    return new FullSpanItem[i];
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m1975a(parcel);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m1976a(i);
                }
            }

            static {
                CREATOR = new C05411();
            }

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.f1615a = parcel.readInt();
                this.f1616b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f1618d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f1617c = new int[readInt];
                    parcel.readIntArray(this.f1617c);
                }
            }

            int m1977a(int i) {
                return this.f1617c == null ? 0 : this.f1617c[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1615a + ", mGapDir=" + this.f1616b + ", mHasUnwantedGapAfter=" + this.f1618d + ", mGapPerSpan=" + Arrays.toString(this.f1617c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1615a);
                parcel.writeInt(this.f1616b);
                parcel.writeInt(this.f1618d ? 1 : 0);
                if (this.f1617c == null || this.f1617c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f1617c.length);
                parcel.writeIntArray(this.f1617c);
            }
        }

        LazySpanLookup() {
        }

        private void m1978c(int i, int i2) {
            if (this.f1620b != null) {
                int i3 = i + i2;
                for (int size = this.f1620b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f1620b.get(size);
                    if (fullSpanItem.f1615a >= i) {
                        if (fullSpanItem.f1615a < i3) {
                            this.f1620b.remove(size);
                        } else {
                            fullSpanItem.f1615a -= i2;
                        }
                    }
                }
            }
        }

        private void m1979d(int i, int i2) {
            if (this.f1620b != null) {
                for (int size = this.f1620b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f1620b.get(size);
                    if (fullSpanItem.f1615a >= i) {
                        fullSpanItem.f1615a += i2;
                    }
                }
            }
        }

        private int m1980g(int i) {
            if (this.f1620b == null) {
                return -1;
            }
            FullSpanItem f = m1992f(i);
            if (f != null) {
                this.f1620b.remove(f);
            }
            int size = this.f1620b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.f1620b.get(i2)).f1615a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (FullSpanItem) this.f1620b.get(i2);
            this.f1620b.remove(i2);
            return f.f1615a;
        }

        int m1981a(int i) {
            if (this.f1620b != null) {
                for (int size = this.f1620b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f1620b.get(size)).f1615a >= i) {
                        this.f1620b.remove(size);
                    }
                }
            }
            return m1987b(i);
        }

        public FullSpanItem m1982a(int i, int i2, int i3, boolean z) {
            if (this.f1620b == null) {
                return null;
            }
            int size = this.f1620b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1620b.get(i4);
                if (fullSpanItem.f1615a >= i2) {
                    return null;
                }
                if (fullSpanItem.f1615a >= i) {
                    if (i3 == 0 || fullSpanItem.f1616b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.f1618d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }

        void m1983a() {
            if (this.f1619a != null) {
                Arrays.fill(this.f1619a, -1);
            }
            this.f1620b = null;
        }

        void m1984a(int i, int i2) {
            if (this.f1619a != null && i < this.f1619a.length) {
                m1991e(i + i2);
                System.arraycopy(this.f1619a, i + i2, this.f1619a, i, (this.f1619a.length - i) - i2);
                Arrays.fill(this.f1619a, this.f1619a.length - i2, this.f1619a.length, -1);
                m1978c(i, i2);
            }
        }

        void m1985a(int i, C0545c c0545c) {
            m1991e(i);
            this.f1619a[i] = c0545c.f1641d;
        }

        public void m1986a(FullSpanItem fullSpanItem) {
            if (this.f1620b == null) {
                this.f1620b = new ArrayList();
            }
            int size = this.f1620b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f1620b.get(i);
                if (fullSpanItem2.f1615a == fullSpanItem.f1615a) {
                    this.f1620b.remove(i);
                }
                if (fullSpanItem2.f1615a >= fullSpanItem.f1615a) {
                    this.f1620b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f1620b.add(fullSpanItem);
        }

        int m1987b(int i) {
            if (this.f1619a == null || i >= this.f1619a.length) {
                return -1;
            }
            int g = m1980g(i);
            if (g == -1) {
                Arrays.fill(this.f1619a, i, this.f1619a.length, -1);
                return this.f1619a.length;
            }
            Arrays.fill(this.f1619a, i, g + 1, -1);
            return g + 1;
        }

        void m1988b(int i, int i2) {
            if (this.f1619a != null && i < this.f1619a.length) {
                m1991e(i + i2);
                System.arraycopy(this.f1619a, i, this.f1619a, i + i2, (this.f1619a.length - i) - i2);
                Arrays.fill(this.f1619a, i, i + i2, -1);
                m1979d(i, i2);
            }
        }

        int m1989c(int i) {
            return (this.f1619a == null || i >= this.f1619a.length) ? -1 : this.f1619a[i];
        }

        int m1990d(int i) {
            int length = this.f1619a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void m1991e(int i) {
            if (this.f1619a == null) {
                this.f1619a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f1619a, -1);
            } else if (i >= this.f1619a.length) {
                Object obj = this.f1619a;
                this.f1619a = new int[m1990d(i)];
                System.arraycopy(obj, 0, this.f1619a, 0, obj.length);
                Arrays.fill(this.f1619a, obj.length, this.f1619a.length, -1);
            }
        }

        public FullSpanItem m1992f(int i) {
            if (this.f1620b == null) {
                return null;
            }
            for (int size = this.f1620b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1620b.get(size);
                if (fullSpanItem.f1615a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        int f1621a;
        int f1622b;
        int f1623c;
        int[] f1624d;
        int f1625e;
        int[] f1626f;
        List<FullSpanItem> f1627g;
        boolean f1628h;
        boolean f1629i;
        boolean f1630j;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.SavedState.1 */
        static class C05421 implements Creator<SavedState> {
            C05421() {
            }

            public SavedState m1993a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m1994a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1993a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1994a(i);
            }
        }

        static {
            CREATOR = new C05421();
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.f1621a = parcel.readInt();
            this.f1622b = parcel.readInt();
            this.f1623c = parcel.readInt();
            if (this.f1623c > 0) {
                this.f1624d = new int[this.f1623c];
                parcel.readIntArray(this.f1624d);
            }
            this.f1625e = parcel.readInt();
            if (this.f1625e > 0) {
                this.f1626f = new int[this.f1625e];
                parcel.readIntArray(this.f1626f);
            }
            this.f1628h = parcel.readInt() == 1;
            this.f1629i = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f1630j = z;
            this.f1627g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f1623c = savedState.f1623c;
            this.f1621a = savedState.f1621a;
            this.f1622b = savedState.f1622b;
            this.f1624d = savedState.f1624d;
            this.f1625e = savedState.f1625e;
            this.f1626f = savedState.f1626f;
            this.f1628h = savedState.f1628h;
            this.f1629i = savedState.f1629i;
            this.f1630j = savedState.f1630j;
            this.f1627g = savedState.f1627g;
        }

        void m1995a() {
            this.f1624d = null;
            this.f1623c = 0;
            this.f1625e = 0;
            this.f1626f = null;
            this.f1627g = null;
        }

        void m1996b() {
            this.f1624d = null;
            this.f1623c = 0;
            this.f1621a = -1;
            this.f1622b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(this.f1621a);
            parcel.writeInt(this.f1622b);
            parcel.writeInt(this.f1623c);
            if (this.f1623c > 0) {
                parcel.writeIntArray(this.f1624d);
            }
            parcel.writeInt(this.f1625e);
            if (this.f1625e > 0) {
                parcel.writeIntArray(this.f1626f);
            }
            parcel.writeInt(this.f1628h ? 1 : 0);
            parcel.writeInt(this.f1629i ? 1 : 0);
            if (!this.f1630j) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.f1627g);
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.a */
    private class C0543a {
        int f1631a;
        int f1632b;
        boolean f1633c;
        boolean f1634d;
        final /* synthetic */ StaggeredGridLayoutManager f1635e;

        private C0543a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f1635e = staggeredGridLayoutManager;
        }

        void m1997a() {
            this.f1631a = -1;
            this.f1632b = LinearLayoutManager.INVALID_OFFSET;
            this.f1633c = false;
            this.f1634d = false;
        }

        void m1998a(int i) {
            if (this.f1633c) {
                this.f1632b = this.f1635e.f1644a.m2393d() - i;
            } else {
                this.f1632b = this.f1635e.f1644a.m2391c() + i;
            }
        }

        void m1999b() {
            this.f1632b = this.f1633c ? this.f1635e.f1644a.m2393d() : this.f1635e.f1644a.m2391c();
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.b */
    public static class C0544b extends C0491i {
        C0545c f1636e;
        boolean f1637f;

        public C0544b(int i, int i2) {
            super(i, i2);
        }

        public C0544b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0544b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0544b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean m2000a() {
            return this.f1637f;
        }

        public final int m2001b() {
            return this.f1636e == null ? -1 : this.f1636e.f1641d;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.c */
    class C0545c {
        int f1638a;
        int f1639b;
        int f1640c;
        final int f1641d;
        final /* synthetic */ StaggeredGridLayoutManager f1642e;
        private ArrayList<View> f1643f;

        private C0545c(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f1642e = staggeredGridLayoutManager;
            this.f1643f = new ArrayList();
            this.f1638a = LinearLayoutManager.INVALID_OFFSET;
            this.f1639b = LinearLayoutManager.INVALID_OFFSET;
            this.f1640c = 0;
            this.f1641d = i;
        }

        int m2003a(int i) {
            if (this.f1638a != LinearLayoutManager.INVALID_OFFSET) {
                return this.f1638a;
            }
            if (this.f1643f.size() == 0) {
                return i;
            }
            m2006a();
            return this.f1638a;
        }

        int m2004a(int i, int i2, boolean z) {
            int c = this.f1642e.f1644a.m2391c();
            int d = this.f1642e.f1644a.m2393d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.f1643f.get(i);
                int a = this.f1642e.f1644a.m2386a(view);
                int b = this.f1642e.f1644a.m2390b(view);
                if (a < d && b > c) {
                    if (!z) {
                        return this.f1642e.getPosition(view);
                    }
                    if (a >= c && b <= d) {
                        return this.f1642e.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        public View m2005a(int i, int i2) {
            View view = null;
            int size;
            View view2;
            if (i2 == -1) {
                size = this.f1643f.size();
                int i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.f1643f.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    if ((this.f1642e.getPosition(view2) > i) != this.f1642e.f1655l) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            size = this.f1643f.size() - 1;
            while (size >= 0) {
                view2 = (View) this.f1643f.get(size);
                if (!view2.isFocusable()) {
                    break;
                }
                if ((this.f1642e.getPosition(view2) > i ? 1 : null) != (!this.f1642e.f1655l ? 1 : null)) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }

        void m2006a() {
            View view = (View) this.f1643f.get(0);
            C0544b c = m2012c(view);
            this.f1638a = this.f1642e.f1644a.m2386a(view);
            if (c.f1637f) {
                FullSpanItem f = this.f1642e.f1649f.m1992f(c.m1703e());
                if (f != null && f.f1616b == -1) {
                    this.f1638a -= f.m1977a(this.f1641d);
                }
            }
        }

        void m2007a(View view) {
            C0544b c = m2012c(view);
            c.f1636e = this;
            this.f1643f.add(0, view);
            this.f1638a = LinearLayoutManager.INVALID_OFFSET;
            if (this.f1643f.size() == 1) {
                this.f1639b = LinearLayoutManager.INVALID_OFFSET;
            }
            if (c.m1701c() || c.m1702d()) {
                this.f1640c += this.f1642e.f1644a.m2392c(view);
            }
        }

        void m2008a(boolean z, int i) {
            int b = z ? m2010b((int) LinearLayoutManager.INVALID_OFFSET) : m2003a((int) LinearLayoutManager.INVALID_OFFSET);
            m2017e();
            if (b != LinearLayoutManager.INVALID_OFFSET) {
                if (z && b < this.f1642e.f1644a.m2393d()) {
                    return;
                }
                if (z || b <= this.f1642e.f1644a.m2391c()) {
                    if (i != LinearLayoutManager.INVALID_OFFSET) {
                        b += i;
                    }
                    this.f1639b = b;
                    this.f1638a = b;
                }
            }
        }

        int m2009b() {
            if (this.f1638a != LinearLayoutManager.INVALID_OFFSET) {
                return this.f1638a;
            }
            m2006a();
            return this.f1638a;
        }

        int m2010b(int i) {
            if (this.f1639b != LinearLayoutManager.INVALID_OFFSET) {
                return this.f1639b;
            }
            if (this.f1643f.size() == 0) {
                return i;
            }
            m2013c();
            return this.f1639b;
        }

        void m2011b(View view) {
            C0544b c = m2012c(view);
            c.f1636e = this;
            this.f1643f.add(view);
            this.f1639b = LinearLayoutManager.INVALID_OFFSET;
            if (this.f1643f.size() == 1) {
                this.f1638a = LinearLayoutManager.INVALID_OFFSET;
            }
            if (c.m1701c() || c.m1702d()) {
                this.f1640c += this.f1642e.f1644a.m2392c(view);
            }
        }

        C0544b m2012c(View view) {
            return (C0544b) view.getLayoutParams();
        }

        void m2013c() {
            View view = (View) this.f1643f.get(this.f1643f.size() - 1);
            C0544b c = m2012c(view);
            this.f1639b = this.f1642e.f1644a.m2390b(view);
            if (c.f1637f) {
                FullSpanItem f = this.f1642e.f1649f.m1992f(c.m1703e());
                if (f != null && f.f1616b == 1) {
                    this.f1639b = f.m1977a(this.f1641d) + this.f1639b;
                }
            }
        }

        void m2014c(int i) {
            this.f1638a = i;
            this.f1639b = i;
        }

        int m2015d() {
            if (this.f1639b != LinearLayoutManager.INVALID_OFFSET) {
                return this.f1639b;
            }
            m2013c();
            return this.f1639b;
        }

        void m2016d(int i) {
            if (this.f1638a != LinearLayoutManager.INVALID_OFFSET) {
                this.f1638a += i;
            }
            if (this.f1639b != LinearLayoutManager.INVALID_OFFSET) {
                this.f1639b += i;
            }
        }

        void m2017e() {
            this.f1643f.clear();
            m2018f();
            this.f1640c = 0;
        }

        void m2018f() {
            this.f1638a = LinearLayoutManager.INVALID_OFFSET;
            this.f1639b = LinearLayoutManager.INVALID_OFFSET;
        }

        void m2019g() {
            int size = this.f1643f.size();
            View view = (View) this.f1643f.remove(size - 1);
            C0544b c = m2012c(view);
            c.f1636e = null;
            if (c.m1701c() || c.m1702d()) {
                this.f1640c -= this.f1642e.f1644a.m2392c(view);
            }
            if (size == 1) {
                this.f1638a = LinearLayoutManager.INVALID_OFFSET;
            }
            this.f1639b = LinearLayoutManager.INVALID_OFFSET;
        }

        void m2020h() {
            View view = (View) this.f1643f.remove(0);
            C0544b c = m2012c(view);
            c.f1636e = null;
            if (this.f1643f.size() == 0) {
                this.f1639b = LinearLayoutManager.INVALID_OFFSET;
            }
            if (c.m1701c() || c.m1702d()) {
                this.f1640c -= this.f1642e.f1644a.m2392c(view);
            }
            this.f1638a = LinearLayoutManager.INVALID_OFFSET;
        }

        public int m2021i() {
            return this.f1640c;
        }

        public int m2022j() {
            return this.f1642e.f1655l ? m2004a(0, this.f1643f.size(), false) : m2004a(this.f1643f.size() - 1, -1, false);
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.f1650g = -1;
        this.f1655l = false;
        this.f1646c = false;
        this.f1647d = -1;
        this.f1648e = LinearLayoutManager.INVALID_OFFSET;
        this.f1649f = new LazySpanLookup();
        this.f1657n = 2;
        this.f1662s = new Rect();
        this.f1663t = new C0543a();
        this.f1664u = false;
        this.f1665v = true;
        this.f1666w = new C05391(this);
        this.f1652i = i2;
        m2073a(i);
        if (this.f1657n == 0) {
            z = false;
        }
        setAutoMeasureEnabled(z);
        this.f1654k = new am();
        m2057h();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        this.f1650g = -1;
        this.f1655l = false;
        this.f1646c = false;
        this.f1647d = -1;
        this.f1648e = LinearLayoutManager.INVALID_OFFSET;
        this.f1649f = new LazySpanLookup();
        this.f1657n = 2;
        this.f1662s = new Rect();
        this.f1663t = new C0543a();
        this.f1664u = false;
        this.f1665v = true;
        this.f1666w = new C05391(this);
        C0520a properties = C0493h.getProperties(context, attributeSet, i, i2);
        m2079b(properties.f1521a);
        m2073a(properties.f1522b);
        m2075a(properties.f1523c);
        if (this.f1657n == 0) {
            z = false;
        }
        setAutoMeasureEnabled(z);
        this.f1654k = new am();
        m2057h();
    }

    private int m2023a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == LinearLayoutManager.INVALID_OFFSET || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int m2024a(C0525n c0525n, am amVar, C0529r c0529r) {
        int i;
        this.f1656m.set(0, this.f1650g, true);
        int i2 = this.f1654k.f1827i ? amVar.f1823e == 1 ? Integer.MAX_VALUE : LinearLayoutManager.INVALID_OFFSET : amVar.f1823e == 1 ? amVar.f1825g + amVar.f1820b : amVar.f1824f - amVar.f1820b;
        m2028a(amVar.f1823e, i2);
        int d = this.f1646c ? this.f1644a.m2393d() : this.f1644a.m2391c();
        Object obj = null;
        while (amVar.m2325a(c0529r) && (this.f1654k.f1827i || !this.f1656m.isEmpty())) {
            C0545c c0545c;
            int c;
            int c2;
            View a = amVar.m2324a(c0525n);
            C0544b c0544b = (C0544b) a.getLayoutParams();
            int e = c0544b.m1703e();
            int c3 = this.f1649f.m1989c(e);
            Object obj2 = c3 == -1 ? 1 : null;
            if (obj2 != null) {
                C0545c a2 = c0544b.f1637f ? this.f1651h[0] : m2027a(amVar);
                this.f1649f.m1985a(e, a2);
                c0545c = a2;
            } else {
                c0545c = this.f1651h[c3];
            }
            c0544b.f1636e = c0545c;
            if (amVar.f1823e == 1) {
                addView(a);
            } else {
                addView(a, 0);
            }
            m2039a(a, c0544b, false);
            if (amVar.f1823e == 1) {
                i = c0544b.f1637f ? m2058i(d) : c0545c.m2010b(d);
                c = i + this.f1644a.m2392c(a);
                if (obj2 == null || !c0544b.f1637f) {
                    c3 = i;
                } else {
                    FullSpanItem e2 = m2053e(i);
                    e2.f1616b = -1;
                    e2.f1615a = e;
                    this.f1649f.m1986a(e2);
                    c3 = i;
                }
            } else {
                i = c0544b.f1637f ? m2056h(d) : c0545c.m2003a(d);
                c3 = i - this.f1644a.m2392c(a);
                if (obj2 != null && c0544b.f1637f) {
                    FullSpanItem f = m2054f(i);
                    f.f1616b = 1;
                    f.f1615a = e;
                    this.f1649f.m1986a(f);
                }
                c = i;
            }
            if (c0544b.f1637f && amVar.f1822d == -1) {
                if (obj2 != null) {
                    this.f1664u = true;
                } else {
                    obj = amVar.f1823e == 1 ? !m2085f() ? 1 : null : !m2086g() ? 1 : null;
                    if (obj != null) {
                        FullSpanItem f2 = this.f1649f.m1992f(e);
                        if (f2 != null) {
                            f2.f1618d = true;
                        }
                        this.f1664u = true;
                    }
                }
            }
            m2038a(a, c0544b, amVar);
            if (m2083d() && this.f1652i == 1) {
                i = c0544b.f1637f ? this.f1645b.m2393d() : this.f1645b.m2393d() - (((this.f1650g - 1) - c0545c.f1641d) * this.f1653j);
                c2 = i - this.f1645b.m2392c(a);
                e = i;
            } else {
                i = c0544b.f1637f ? this.f1645b.m2391c() : (c0545c.f1641d * this.f1653j) + this.f1645b.m2391c();
                e = i + this.f1645b.m2392c(a);
                c2 = i;
            }
            if (this.f1652i == 1) {
                m2036a(a, c2, c3, e, c);
            } else {
                m2036a(a, c3, c2, c, e);
            }
            if (c0544b.f1637f) {
                m2028a(this.f1654k.f1823e, i2);
            } else {
                m2034a(c0545c, this.f1654k.f1823e, i2);
            }
            m2032a(c0525n, this.f1654k);
            if (this.f1654k.f1826h && a.isFocusable()) {
                if (c0544b.f1637f) {
                    this.f1656m.clear();
                } else {
                    this.f1656m.set(c0545c.f1641d, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m2032a(c0525n, this.f1654k);
        }
        i = this.f1654k.f1823e == -1 ? this.f1644a.m2391c() - m2056h(this.f1644a.m2391c()) : m2058i(this.f1644a.m2393d()) - this.f1644a.m2393d();
        return i > 0 ? Math.min(amVar.f1820b, i) : 0;
    }

    private int m2025a(C0529r c0529r) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        as asVar = this.f1644a;
        View a = m2072a(!this.f1665v, true);
        if (!this.f1665v) {
            z = true;
        }
        return ay.m2460a(c0529r, asVar, a, m2078b(z, true), this, this.f1665v, this.f1646c);
    }

    private C0545c m2027a(am amVar) {
        int i;
        int i2;
        C0545c c0545c = null;
        int i3 = -1;
        if (m2063k(amVar.f1823e)) {
            i = this.f1650g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f1650g;
            i3 = 1;
        }
        int c;
        int i4;
        C0545c c0545c2;
        int b;
        C0545c c0545c3;
        if (amVar.f1823e == 1) {
            c = this.f1644a.m2391c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                c0545c2 = this.f1651h[i4];
                b = c0545c2.m2010b(c);
                if (b < i) {
                    c0545c3 = c0545c2;
                } else {
                    b = i;
                    c0545c3 = c0545c;
                }
                i4 += i3;
                c0545c = c0545c3;
                i = b;
            }
        } else {
            c = this.f1644a.m2393d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                c0545c2 = this.f1651h[i4];
                b = c0545c2.m2003a(c);
                if (b > i) {
                    c0545c3 = c0545c2;
                } else {
                    b = i;
                    c0545c3 = c0545c;
                }
                i4 += i3;
                c0545c = c0545c3;
                i = b;
            }
        }
        return c0545c;
    }

    private void m2028a(int i, int i2) {
        for (int i3 = 0; i3 < this.f1650g; i3++) {
            if (!this.f1651h[i3].f1643f.isEmpty()) {
                m2034a(this.f1651h[i3], i, i2);
            }
        }
    }

    private void m2029a(int i, C0529r c0529r) {
        int c;
        int i2;
        am amVar;
        boolean z = false;
        this.f1654k.f1820b = 0;
        this.f1654k.f1821c = i;
        if (isSmoothScrolling()) {
            c = c0529r.m1927c();
            if (c != -1) {
                if (this.f1646c == (c < i)) {
                    c = this.f1644a.m2396f();
                    i2 = 0;
                } else {
                    i2 = this.f1644a.m2396f();
                    c = 0;
                }
                if (getClipToPadding()) {
                    this.f1654k.f1825g = c + this.f1644a.m2395e();
                    this.f1654k.f1824f = -i2;
                } else {
                    this.f1654k.f1824f = this.f1644a.m2391c() - i2;
                    this.f1654k.f1825g = c + this.f1644a.m2393d();
                }
                this.f1654k.f1826h = false;
                this.f1654k.f1819a = true;
                amVar = this.f1654k;
                if (this.f1644a.m2398h() == 0 && this.f1644a.m2395e() == 0) {
                    z = true;
                }
                amVar.f1827i = z;
            }
        }
        c = 0;
        i2 = 0;
        if (getClipToPadding()) {
            this.f1654k.f1825g = c + this.f1644a.m2395e();
            this.f1654k.f1824f = -i2;
        } else {
            this.f1654k.f1824f = this.f1644a.m2391c() - i2;
            this.f1654k.f1825g = c + this.f1644a.m2393d();
        }
        this.f1654k.f1826h = false;
        this.f1654k.f1819a = true;
        amVar = this.f1654k;
        z = true;
        amVar.f1827i = z;
    }

    private void m2030a(C0525n c0525n, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f1644a.m2390b(childAt) <= i) {
                C0544b c0544b = (C0544b) childAt.getLayoutParams();
                if (c0544b.f1637f) {
                    int i2 = 0;
                    while (i2 < this.f1650g) {
                        if (this.f1651h[i2].f1643f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1650g; i2++) {
                        this.f1651h[i2].m2020h();
                    }
                } else if (c0544b.f1636e.f1643f.size() != 1) {
                    c0544b.f1636e.m2020h();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, c0525n);
            } else {
                return;
            }
        }
    }

    private void m2031a(C0525n c0525n, C0529r c0529r, boolean z) {
        C0543a c0543a = this.f1663t;
        c0543a.m1997a();
        if (!(this.f1660q == null && this.f1647d == -1) && c0529r.m1929e() == 0) {
            removeAndRecycleAllViews(c0525n);
            return;
        }
        boolean z2;
        if (this.f1660q != null) {
            m2033a(c0543a);
        } else {
            m2061j();
            c0543a.f1633c = this.f1646c;
        }
        m2074a(c0529r, c0543a);
        if (this.f1660q == null && !(c0543a.f1633c == this.f1658o && m2083d() == this.f1659p)) {
            this.f1649f.m1983a();
            c0543a.f1634d = true;
        }
        if (getChildCount() > 0 && (this.f1660q == null || this.f1660q.f1623c < 1)) {
            int i;
            if (c0543a.f1634d) {
                for (i = 0; i < this.f1650g; i++) {
                    this.f1651h[i].m2017e();
                    if (c0543a.f1632b != LinearLayoutManager.INVALID_OFFSET) {
                        this.f1651h[i].m2014c(c0543a.f1632b);
                    }
                }
            } else {
                for (i = 0; i < this.f1650g; i++) {
                    this.f1651h[i].m2008a(this.f1646c, c0543a.f1632b);
                }
            }
        }
        detachAndScrapAttachedViews(c0525n);
        this.f1654k.f1819a = false;
        this.f1664u = false;
        m2082c(this.f1645b.m2396f());
        m2029a(c0543a.f1631a, c0529r);
        if (c0543a.f1633c) {
            m2052d(-1);
            m2024a(c0525n, this.f1654k, c0529r);
            m2052d(1);
            this.f1654k.f1821c = c0543a.f1631a + this.f1654k.f1822d;
            m2024a(c0525n, this.f1654k, c0529r);
        } else {
            m2052d(1);
            m2024a(c0525n, this.f1654k, c0529r);
            m2052d(-1);
            this.f1654k.f1821c = c0543a.f1631a + this.f1654k.f1822d;
            m2024a(c0525n, this.f1654k, c0529r);
        }
        m2062k();
        if (getChildCount() > 0) {
            if (this.f1646c) {
                m2046b(c0525n, c0529r, true);
                m2049c(c0525n, c0529r, false);
            } else {
                m2049c(c0525n, c0529r, true);
                m2046b(c0525n, c0529r, false);
            }
        }
        if (!z || c0529r.m1925a()) {
            z2 = false;
        } else {
            z2 = this.f1657n != 0 && getChildCount() > 0 && (this.f1664u || m2071a() != null);
            if (z2) {
                removeCallbacks(this.f1666w);
                if (m2059i()) {
                    z2 = true;
                    this.f1647d = -1;
                    this.f1648e = LinearLayoutManager.INVALID_OFFSET;
                }
            }
            z2 = false;
            this.f1647d = -1;
            this.f1648e = LinearLayoutManager.INVALID_OFFSET;
        }
        this.f1658o = c0543a.f1633c;
        this.f1659p = m2083d();
        this.f1660q = null;
        if (z2) {
            m2031a(c0525n, c0529r, false);
        }
    }

    private void m2032a(C0525n c0525n, am amVar) {
        if (amVar.f1819a && !amVar.f1827i) {
            if (amVar.f1820b == 0) {
                if (amVar.f1823e == -1) {
                    m2045b(c0525n, amVar.f1825g);
                } else {
                    m2030a(c0525n, amVar.f1824f);
                }
            } else if (amVar.f1823e == -1) {
                r0 = amVar.f1824f - m2055g(amVar.f1824f);
                m2045b(c0525n, r0 < 0 ? amVar.f1825g : amVar.f1825g - Math.min(r0, amVar.f1820b));
            } else {
                r0 = m2060j(amVar.f1825g) - amVar.f1825g;
                m2030a(c0525n, r0 < 0 ? amVar.f1824f : Math.min(r0, amVar.f1820b) + amVar.f1824f);
            }
        }
    }

    private void m2033a(C0543a c0543a) {
        if (this.f1660q.f1623c > 0) {
            if (this.f1660q.f1623c == this.f1650g) {
                for (int i = 0; i < this.f1650g; i++) {
                    this.f1651h[i].m2017e();
                    int i2 = this.f1660q.f1624d[i];
                    if (i2 != LinearLayoutManager.INVALID_OFFSET) {
                        i2 = this.f1660q.f1629i ? i2 + this.f1644a.m2393d() : i2 + this.f1644a.m2391c();
                    }
                    this.f1651h[i].m2014c(i2);
                }
            } else {
                this.f1660q.m1995a();
                this.f1660q.f1621a = this.f1660q.f1622b;
            }
        }
        this.f1659p = this.f1660q.f1630j;
        m2075a(this.f1660q.f1628h);
        m2061j();
        if (this.f1660q.f1621a != -1) {
            this.f1647d = this.f1660q.f1621a;
            c0543a.f1633c = this.f1660q.f1629i;
        } else {
            c0543a.f1633c = this.f1646c;
        }
        if (this.f1660q.f1625e > 1) {
            this.f1649f.f1619a = this.f1660q.f1626f;
            this.f1649f.f1620b = this.f1660q.f1627g;
        }
    }

    private void m2034a(C0545c c0545c, int i, int i2) {
        int i3 = c0545c.m2021i();
        if (i == -1) {
            if (i3 + c0545c.m2009b() <= i2) {
                this.f1656m.set(c0545c.f1641d, false);
            }
        } else if (c0545c.m2015d() - i3 >= i2) {
            this.f1656m.set(c0545c.f1641d, false);
        }
    }

    private void m2035a(View view) {
        for (int i = this.f1650g - 1; i >= 0; i--) {
            this.f1651h[i].m2011b(view);
        }
    }

    private void m2036a(View view, int i, int i2, int i3, int i4) {
        C0544b c0544b = (C0544b) view.getLayoutParams();
        layoutDecorated(view, i + c0544b.leftMargin, i2 + c0544b.topMargin, i3 - c0544b.rightMargin, i4 - c0544b.bottomMargin);
    }

    private void m2037a(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.f1662s);
        C0544b c0544b = (C0544b) view.getLayoutParams();
        int a = m2023a(i, c0544b.leftMargin + this.f1662s.left, c0544b.rightMargin + this.f1662s.right);
        int a2 = m2023a(i2, c0544b.topMargin + this.f1662s.top, c0544b.bottomMargin + this.f1662s.bottom);
        if (z ? shouldReMeasureChild(view, a, a2, c0544b) : shouldMeasureChild(view, a, a2, c0544b)) {
            view.measure(a, a2);
        }
    }

    private void m2038a(View view, C0544b c0544b, am amVar) {
        if (amVar.f1823e == 1) {
            if (c0544b.f1637f) {
                m2035a(view);
            } else {
                c0544b.f1636e.m2011b(view);
            }
        } else if (c0544b.f1637f) {
            m2047b(view);
        } else {
            c0544b.f1636e.m2007a(view);
        }
    }

    private void m2039a(View view, C0544b c0544b, boolean z) {
        if (c0544b.f1637f) {
            if (this.f1652i == 1) {
                m2037a(view, this.f1661r, C0493h.getChildMeasureSpec(getHeight(), getHeightMode(), 0, c0544b.height, true), z);
            } else {
                m2037a(view, C0493h.getChildMeasureSpec(getWidth(), getWidthMode(), 0, c0544b.width, true), this.f1661r, z);
            }
        } else if (this.f1652i == 1) {
            m2037a(view, C0493h.getChildMeasureSpec(this.f1653j, getWidthMode(), 0, c0544b.width, false), C0493h.getChildMeasureSpec(getHeight(), getHeightMode(), 0, c0544b.height, true), z);
        } else {
            m2037a(view, C0493h.getChildMeasureSpec(getWidth(), getWidthMode(), 0, c0544b.width, true), C0493h.getChildMeasureSpec(this.f1653j, getHeightMode(), 0, c0544b.height, false), z);
        }
    }

    private boolean m2040a(C0545c c0545c) {
        boolean z = true;
        if (this.f1646c) {
            if (c0545c.m2015d() < this.f1644a.m2393d()) {
                return !c0545c.m2012c((View) c0545c.f1643f.get(c0545c.f1643f.size() + -1)).f1637f;
            }
        } else if (c0545c.m2009b() > this.f1644a.m2391c()) {
            if (c0545c.m2012c((View) c0545c.f1643f.get(0)).f1637f) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private int m2042b(C0529r c0529r) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        as asVar = this.f1644a;
        View a = m2072a(!this.f1665v, true);
        if (!this.f1665v) {
            z = true;
        }
        return ay.m2459a(c0529r, asVar, a, m2078b(z, true), this, this.f1665v);
    }

    private void m2044b(int i, int i2, int i3) {
        int i4;
        int i5;
        int l = this.f1646c ? m2064l() : m2066m();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f1649f.m1987b(i5);
        switch (i3) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f1649f.m1988b(i, i2);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f1649f.m1984a(i, i2);
                break;
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                this.f1649f.m1984a(i, 1);
                this.f1649f.m1988b(i2, 1);
                break;
        }
        if (i4 > l) {
            if (i5 <= (this.f1646c ? m2066m() : m2064l())) {
                requestLayout();
            }
        }
    }

    private void m2045b(C0525n c0525n, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f1644a.m2386a(childAt) >= i) {
                C0544b c0544b = (C0544b) childAt.getLayoutParams();
                if (c0544b.f1637f) {
                    int i2 = 0;
                    while (i2 < this.f1650g) {
                        if (this.f1651h[i2].f1643f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1650g; i2++) {
                        this.f1651h[i2].m2019g();
                    }
                } else if (c0544b.f1636e.f1643f.size() != 1) {
                    c0544b.f1636e.m2019g();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, c0525n);
                childCount--;
            } else {
                return;
            }
        }
    }

    private void m2046b(C0525n c0525n, C0529r c0529r, boolean z) {
        int i = m2058i(LinearLayoutManager.INVALID_OFFSET);
        if (i != LinearLayoutManager.INVALID_OFFSET) {
            i = this.f1644a.m2393d() - i;
            if (i > 0) {
                i -= -m2070a(-i, c0525n, c0529r);
                if (z && i > 0) {
                    this.f1644a.m2388a(i);
                }
            }
        }
    }

    private void m2047b(View view) {
        for (int i = this.f1650g - 1; i >= 0; i--) {
            this.f1651h[i].m2007a(view);
        }
    }

    private int m2048c(C0529r c0529r) {
        boolean z = false;
        if (getChildCount() == 0) {
            return 0;
        }
        as asVar = this.f1644a;
        View a = m2072a(!this.f1665v, true);
        if (!this.f1665v) {
            z = true;
        }
        return ay.m2461b(c0529r, asVar, a, m2078b(z, true), this, this.f1665v);
    }

    private void m2049c(C0525n c0525n, C0529r c0529r, boolean z) {
        int h = m2056h(Integer.MAX_VALUE);
        if (h != Integer.MAX_VALUE) {
            h -= this.f1644a.m2391c();
            if (h > 0) {
                h -= m2070a(h, c0525n, c0529r);
                if (z && h > 0) {
                    this.f1644a.m2388a(-h);
                }
            }
        }
    }

    private boolean m2050c(C0529r c0529r, C0543a c0543a) {
        c0543a.f1631a = this.f1658o ? m2068n(c0529r.m1929e()) : m2067m(c0529r.m1929e());
        c0543a.f1632b = LinearLayoutManager.INVALID_OFFSET;
        return true;
    }

    private void m2052d(int i) {
        int i2 = 1;
        this.f1654k.f1823e = i;
        am amVar = this.f1654k;
        if (this.f1646c != (i == -1)) {
            i2 = -1;
        }
        amVar.f1822d = i2;
    }

    private FullSpanItem m2053e(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f1617c = new int[this.f1650g];
        for (int i2 = 0; i2 < this.f1650g; i2++) {
            fullSpanItem.f1617c[i2] = i - this.f1651h[i2].m2010b(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem m2054f(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f1617c = new int[this.f1650g];
        for (int i2 = 0; i2 < this.f1650g; i2++) {
            fullSpanItem.f1617c[i2] = this.f1651h[i2].m2003a(i) - i;
        }
        return fullSpanItem;
    }

    private int m2055g(int i) {
        int a = this.f1651h[0].m2003a(i);
        for (int i2 = 1; i2 < this.f1650g; i2++) {
            int a2 = this.f1651h[i2].m2003a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int m2056h(int i) {
        int a = this.f1651h[0].m2003a(i);
        for (int i2 = 1; i2 < this.f1650g; i2++) {
            int a2 = this.f1651h[i2].m2003a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private void m2057h() {
        this.f1644a = as.m2384a(this, this.f1652i);
        this.f1645b = as.m2384a(this, 1 - this.f1652i);
    }

    private int m2058i(int i) {
        int b = this.f1651h[0].m2010b(i);
        for (int i2 = 1; i2 < this.f1650g; i2++) {
            int b2 = this.f1651h[i2].m2010b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private boolean m2059i() {
        if (getChildCount() == 0 || this.f1657n == 0 || !isAttachedToWindow()) {
            return false;
        }
        int l;
        int m;
        if (this.f1646c) {
            l = m2064l();
            m = m2066m();
        } else {
            l = m2066m();
            m = m2064l();
        }
        if (l == 0 && m2071a() != null) {
            this.f1649f.m1983a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.f1664u) {
            return false;
        } else {
            int i = this.f1646c ? -1 : 1;
            FullSpanItem a = this.f1649f.m1982a(l, m + 1, i, true);
            if (a == null) {
                this.f1664u = false;
                this.f1649f.m1981a(m + 1);
                return false;
            }
            FullSpanItem a2 = this.f1649f.m1982a(l, a.f1615a, i * -1, true);
            if (a2 == null) {
                this.f1649f.m1981a(a.f1615a);
            } else {
                this.f1649f.m1981a(a2.f1615a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    private int m2060j(int i) {
        int b = this.f1651h[0].m2010b(i);
        for (int i2 = 1; i2 < this.f1650g; i2++) {
            int b2 = this.f1651h[i2].m2010b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private void m2061j() {
        boolean z = true;
        if (this.f1652i == 1 || !m2083d()) {
            this.f1646c = this.f1655l;
            return;
        }
        if (this.f1655l) {
            z = false;
        }
        this.f1646c = z;
    }

    private void m2062k() {
        if (this.f1645b.m2398h() != 1073741824) {
            float f = 0.0f;
            int childCount = getChildCount();
            int i = 0;
            while (i < childCount) {
                float f2;
                View childAt = getChildAt(i);
                float c = (float) this.f1645b.m2392c(childAt);
                if (c < f) {
                    f2 = f;
                } else {
                    f2 = Math.max(f, ((C0544b) childAt.getLayoutParams()).m2000a() ? (1.0f * c) / ((float) this.f1650g) : c);
                }
                i++;
                f = f2;
            }
            i = this.f1653j;
            int round = Math.round(((float) this.f1650g) * f);
            if (this.f1645b.m2398h() == LinearLayoutManager.INVALID_OFFSET) {
                round = Math.min(round, this.f1645b.m2396f());
            }
            m2082c(round);
            if (this.f1653j != i) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt2 = getChildAt(i2);
                    C0544b c0544b = (C0544b) childAt2.getLayoutParams();
                    if (!c0544b.f1637f) {
                        if (m2083d() && this.f1652i == 1) {
                            childAt2.offsetLeftAndRight(((-((this.f1650g - 1) - c0544b.f1636e.f1641d)) * this.f1653j) - ((-((this.f1650g - 1) - c0544b.f1636e.f1641d)) * i));
                        } else {
                            int i3 = c0544b.f1636e.f1641d * this.f1653j;
                            round = c0544b.f1636e.f1641d * i;
                            if (this.f1652i == 1) {
                                childAt2.offsetLeftAndRight(i3 - round);
                            } else {
                                childAt2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean m2063k(int i) {
        if (this.f1652i == 0) {
            return (i == -1) != this.f1646c;
        } else {
            return ((i == -1) == this.f1646c) == m2083d();
        }
    }

    private int m2064l() {
        int childCount = getChildCount();
        return childCount == 0 ? 0 : getPosition(getChildAt(childCount - 1));
    }

    private int m2065l(int i) {
        int i2 = -1;
        if (getChildCount() == 0) {
            return this.f1646c ? 1 : -1;
        } else {
            if ((i < m2066m()) == this.f1646c) {
                i2 = 1;
            }
            return i2;
        }
    }

    private int m2066m() {
        return getChildCount() == 0 ? 0 : getPosition(getChildAt(0));
    }

    private int m2067m(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int m2068n(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int m2069o(int i) {
        int i2 = 1;
        int i3 = LinearLayoutManager.INVALID_OFFSET;
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return -1;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return 1;
            case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                return this.f1652i != 0 ? LinearLayoutManager.INVALID_OFFSET : -1;
            case jni.SID_CPU_MULTI /*33*/:
                return this.f1652i != 1 ? LinearLayoutManager.INVALID_OFFSET : -1;
            case C1692R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                if (this.f1652i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case SpdyProtocol.CDN /*130*/:
                if (this.f1652i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return LinearLayoutManager.INVALID_OFFSET;
        }
    }

    int m2070a(int i, C0525n c0525n, C0529r c0529r) {
        int l;
        int i2;
        if (i > 0) {
            l = m2064l();
            i2 = 1;
        } else {
            i2 = -1;
            l = m2066m();
        }
        this.f1654k.f1819a = true;
        m2029a(l, c0529r);
        m2052d(i2);
        this.f1654k.f1821c = this.f1654k.f1822d + l;
        int abs = Math.abs(i);
        this.f1654k.f1820b = abs;
        i2 = m2024a(c0525n, this.f1654k, c0529r);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.f1644a.m2388a(-i);
        this.f1658o = this.f1646c;
        return i;
    }

    View m2071a() {
        int i;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.f1650g);
        bitSet.set(0, this.f1650g, true);
        boolean z = (this.f1652i == 1 && m2083d()) ? true : true;
        if (this.f1646c) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        int i2 = childCount < i ? 1 : -1;
        int i3 = childCount;
        while (i3 != i) {
            View childAt = getChildAt(i3);
            C0544b c0544b = (C0544b) childAt.getLayoutParams();
            if (bitSet.get(c0544b.f1636e.f1641d)) {
                if (m2040a(c0544b.f1636e)) {
                    return childAt;
                }
                bitSet.clear(c0544b.f1636e.f1641d);
            }
            if (!(c0544b.f1637f || i3 + i2 == i)) {
                boolean z2;
                View childAt2 = getChildAt(i3 + i2);
                int b;
                if (this.f1646c) {
                    childCount = this.f1644a.m2390b(childAt);
                    b = this.f1644a.m2390b(childAt2);
                    if (childCount < b) {
                        return childAt;
                    }
                    if (childCount == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    childCount = this.f1644a.m2386a(childAt);
                    b = this.f1644a.m2386a(childAt2);
                    if (childCount > b) {
                        return childAt;
                    }
                    if (childCount == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if ((c0544b.f1636e.f1641d - ((C0544b) childAt2.getLayoutParams()).f1636e.f1641d < 0) != (z >= false)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    View m2072a(boolean z, boolean z2) {
        int c = this.f1644a.m2391c();
        int d = this.f1644a.m2393d();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int a = this.f1644a.m2386a(childAt);
            if (this.f1644a.m2390b(childAt) > c && a < d) {
                if (a >= c || !z) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public void m2073a(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.f1650g) {
            m2081c();
            this.f1650g = i;
            this.f1656m = new BitSet(this.f1650g);
            this.f1651h = new C0545c[this.f1650g];
            for (int i2 = 0; i2 < this.f1650g; i2++) {
                this.f1651h[i2] = new C0545c(i2, null);
            }
            requestLayout();
        }
    }

    void m2074a(C0529r c0529r, C0543a c0543a) {
        if (!m2080b(c0529r, c0543a) && !m2050c(c0529r, c0543a)) {
            c0543a.m1999b();
            c0543a.f1631a = 0;
        }
    }

    public void m2075a(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (!(this.f1660q == null || this.f1660q.f1628h == z)) {
            this.f1660q.f1628h = z;
        }
        this.f1655l = z;
        requestLayout();
    }

    public int[] m2076a(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f1650g];
        } else if (iArr.length < this.f1650g) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f1650g + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.f1650g; i++) {
            iArr[i] = this.f1651h[i].m2022j();
        }
        return iArr;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f1660q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public int m2077b() {
        return this.f1650g;
    }

    View m2078b(boolean z, boolean z2) {
        int c = this.f1644a.m2391c();
        int d = this.f1644a.m2393d();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int a = this.f1644a.m2386a(childAt);
            int b = this.f1644a.m2390b(childAt);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public void m2079b(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll(null);
            if (i != this.f1652i) {
                this.f1652i = i;
                as asVar = this.f1644a;
                this.f1644a = this.f1645b;
                this.f1645b = asVar;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    boolean m2080b(C0529r c0529r, C0543a c0543a) {
        boolean z = false;
        if (c0529r.m1925a() || this.f1647d == -1) {
            return false;
        }
        if (this.f1647d < 0 || this.f1647d >= c0529r.m1929e()) {
            this.f1647d = -1;
            this.f1648e = LinearLayoutManager.INVALID_OFFSET;
            return false;
        } else if (this.f1660q == null || this.f1660q.f1621a == -1 || this.f1660q.f1623c < 1) {
            View findViewByPosition = findViewByPosition(this.f1647d);
            if (findViewByPosition != null) {
                c0543a.f1631a = this.f1646c ? m2064l() : m2066m();
                if (this.f1648e != LinearLayoutManager.INVALID_OFFSET) {
                    if (c0543a.f1633c) {
                        c0543a.f1632b = (this.f1644a.m2393d() - this.f1648e) - this.f1644a.m2390b(findViewByPosition);
                        return true;
                    }
                    c0543a.f1632b = (this.f1644a.m2391c() + this.f1648e) - this.f1644a.m2386a(findViewByPosition);
                    return true;
                } else if (this.f1644a.m2392c(findViewByPosition) > this.f1644a.m2396f()) {
                    c0543a.f1632b = c0543a.f1633c ? this.f1644a.m2393d() : this.f1644a.m2391c();
                    return true;
                } else {
                    int a = this.f1644a.m2386a(findViewByPosition) - this.f1644a.m2391c();
                    if (a < 0) {
                        c0543a.f1632b = -a;
                        return true;
                    }
                    a = this.f1644a.m2393d() - this.f1644a.m2390b(findViewByPosition);
                    if (a < 0) {
                        c0543a.f1632b = a;
                        return true;
                    }
                    c0543a.f1632b = LinearLayoutManager.INVALID_OFFSET;
                    return true;
                }
            }
            c0543a.f1631a = this.f1647d;
            if (this.f1648e == LinearLayoutManager.INVALID_OFFSET) {
                if (m2065l(c0543a.f1631a) == 1) {
                    z = true;
                }
                c0543a.f1633c = z;
                c0543a.m1999b();
            } else {
                c0543a.m1998a(this.f1648e);
            }
            c0543a.f1634d = true;
            return true;
        } else {
            c0543a.f1632b = LinearLayoutManager.INVALID_OFFSET;
            c0543a.f1631a = this.f1647d;
            return true;
        }
    }

    public void m2081c() {
        this.f1649f.m1983a();
        requestLayout();
    }

    void m2082c(int i) {
        this.f1653j = i / this.f1650g;
        this.f1661r = MeasureSpec.makeMeasureSpec(i, this.f1645b.m2398h());
    }

    public boolean canScrollHorizontally() {
        return this.f1652i == 0;
    }

    public boolean canScrollVertically() {
        return this.f1652i == 1;
    }

    public boolean checkLayoutParams(C0491i c0491i) {
        return c0491i instanceof C0544b;
    }

    public int computeHorizontalScrollExtent(C0529r c0529r) {
        return m2042b(c0529r);
    }

    public int computeHorizontalScrollOffset(C0529r c0529r) {
        return m2025a(c0529r);
    }

    public int computeHorizontalScrollRange(C0529r c0529r) {
        return m2048c(c0529r);
    }

    public int computeVerticalScrollExtent(C0529r c0529r) {
        return m2042b(c0529r);
    }

    public int computeVerticalScrollOffset(C0529r c0529r) {
        return m2025a(c0529r);
    }

    public int computeVerticalScrollRange(C0529r c0529r) {
        return m2048c(c0529r);
    }

    boolean m2083d() {
        return getLayoutDirection() == 1;
    }

    int m2084e() {
        View b = this.f1646c ? m2078b(true, true) : m2072a(true, true);
        return b == null ? -1 : getPosition(b);
    }

    boolean m2085f() {
        int b = this.f1651h[0].m2010b((int) LinearLayoutManager.INVALID_OFFSET);
        for (int i = 1; i < this.f1650g; i++) {
            if (this.f1651h[i].m2010b((int) LinearLayoutManager.INVALID_OFFSET) != b) {
                return false;
            }
        }
        return true;
    }

    boolean m2086g() {
        int a = this.f1651h[0].m2003a((int) LinearLayoutManager.INVALID_OFFSET);
        for (int i = 1; i < this.f1650g; i++) {
            if (this.f1651h[i].m2003a((int) LinearLayoutManager.INVALID_OFFSET) != a) {
                return false;
            }
        }
        return true;
    }

    public C0491i generateDefaultLayoutParams() {
        return this.f1652i == 0 ? new C0544b(-2, -1) : new C0544b(-1, -2);
    }

    public C0491i generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new C0544b(context, attributeSet);
    }

    public C0491i generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0544b((MarginLayoutParams) layoutParams) : new C0544b(layoutParams);
    }

    public int getColumnCountForAccessibility(C0525n c0525n, C0529r c0529r) {
        return this.f1652i == 1 ? this.f1650g : super.getColumnCountForAccessibility(c0525n, c0529r);
    }

    public int getRowCountForAccessibility(C0525n c0525n, C0529r c0529r) {
        return this.f1652i == 0 ? this.f1650g : super.getRowCountForAccessibility(c0525n, c0529r);
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f1650g; i2++) {
            this.f1651h[i2].m2016d(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f1650g; i2++) {
            this.f1651h[i2].m2016d(i);
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, C0525n c0525n) {
        removeCallbacks(this.f1666w);
        for (int i = 0; i < this.f1650g; i++) {
            this.f1651h[i].m2017e();
        }
    }

    public View onFocusSearchFailed(View view, int i, C0525n c0525n, C0529r c0529r) {
        int i2 = 0;
        if (getChildCount() == 0) {
            return null;
        }
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        m2061j();
        int o = m2069o(i);
        if (o == LinearLayoutManager.INVALID_OFFSET) {
            return null;
        }
        View a;
        C0544b c0544b = (C0544b) findContainingItemView.getLayoutParams();
        boolean z = c0544b.f1637f;
        C0545c c0545c = c0544b.f1636e;
        int l = o == 1 ? m2064l() : m2066m();
        m2029a(l, c0529r);
        m2052d(o);
        this.f1654k.f1821c = this.f1654k.f1822d + l;
        this.f1654k.f1820b = (int) (0.33333334f * ((float) this.f1644a.m2396f()));
        this.f1654k.f1826h = true;
        this.f1654k.f1819a = false;
        m2024a(c0525n, this.f1654k, c0529r);
        this.f1658o = this.f1646c;
        if (!z) {
            a = c0545c.m2005a(l, o);
            if (!(a == null || a == findContainingItemView)) {
                return a;
            }
        }
        if (m2063k(o)) {
            for (int i3 = this.f1650g - 1; i3 >= 0; i3--) {
                View a2 = this.f1651h[i3].m2005a(l, o);
                if (a2 != null && a2 != findContainingItemView) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.f1650g) {
                a = this.f1651h[i2].m2005a(l, o);
                if (a != null && a != findContainingItemView) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            View a = m2072a(false, true);
            View b = m2078b(false, true);
            if (a != null && b != null) {
                int position = getPosition(a);
                int position2 = getPosition(b);
                if (position < position2) {
                    asRecord.setFromIndex(position);
                    asRecord.setToIndex(position2);
                    return;
                }
                asRecord.setFromIndex(position2);
                asRecord.setToIndex(position);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(C0525n c0525n, C0529r c0529r, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0544b) {
            C0544b c0544b = (C0544b) layoutParams;
            if (this.f1652i == 0) {
                accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(c0544b.m2001b(), c0544b.f1637f ? this.f1650g : 1, -1, -1, c0544b.f1637f, false));
                return;
            } else {
                accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(-1, -1, c0544b.m2001b(), c0544b.f1637f ? this.f1650g : 1, c0544b.f1637f, false));
                return;
            }
        }
        super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m2044b(i, i2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f1649f.m1983a();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m2044b(i, i2, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m2044b(i, i2, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        m2044b(i, i2, 4);
    }

    public void onLayoutChildren(C0525n c0525n, C0529r c0529r) {
        m2031a(c0525n, c0529r, true);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f1660q = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.f1660q != null) {
            return new SavedState(this.f1660q);
        }
        SavedState savedState = new SavedState();
        savedState.f1628h = this.f1655l;
        savedState.f1629i = this.f1658o;
        savedState.f1630j = this.f1659p;
        if (this.f1649f == null || this.f1649f.f1619a == null) {
            savedState.f1625e = 0;
        } else {
            savedState.f1626f = this.f1649f.f1619a;
            savedState.f1625e = savedState.f1626f.length;
            savedState.f1627g = this.f1649f.f1620b;
        }
        if (getChildCount() > 0) {
            savedState.f1621a = this.f1658o ? m2064l() : m2066m();
            savedState.f1622b = m2084e();
            savedState.f1623c = this.f1650g;
            savedState.f1624d = new int[this.f1650g];
            for (int i = 0; i < this.f1650g; i++) {
                int b;
                if (this.f1658o) {
                    b = this.f1651h[i].m2010b((int) LinearLayoutManager.INVALID_OFFSET);
                    if (b != LinearLayoutManager.INVALID_OFFSET) {
                        b -= this.f1644a.m2393d();
                    }
                } else {
                    b = this.f1651h[i].m2003a((int) LinearLayoutManager.INVALID_OFFSET);
                    if (b != LinearLayoutManager.INVALID_OFFSET) {
                        b -= this.f1644a.m2391c();
                    }
                }
                savedState.f1624d[i] = b;
            }
        } else {
            savedState.f1621a = -1;
            savedState.f1622b = -1;
            savedState.f1623c = 0;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            m2059i();
        }
    }

    public int scrollHorizontallyBy(int i, C0525n c0525n, C0529r c0529r) {
        return m2070a(i, c0525n, c0529r);
    }

    public void scrollToPosition(int i) {
        if (!(this.f1660q == null || this.f1660q.f1621a == i)) {
            this.f1660q.m1996b();
        }
        this.f1647d = i;
        this.f1648e = LinearLayoutManager.INVALID_OFFSET;
        requestLayout();
    }

    public int scrollVerticallyBy(int i, C0525n c0525n, C0529r c0529r) {
        return m2070a(i, c0525n, c0529r);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f1652i == 1) {
            paddingTop = C0493h.chooseSize(i2, paddingTop + rect.height(), getMinimumHeight());
            paddingRight = C0493h.chooseSize(i, paddingRight + (this.f1653j * this.f1650g), getMinimumWidth());
        } else {
            paddingRight = C0493h.chooseSize(i, paddingRight + rect.width(), getMinimumWidth());
            paddingTop = C0493h.chooseSize(i2, paddingTop + (this.f1653j * this.f1650g), getMinimumHeight());
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C0529r c0529r, int i) {
        C0494q c05402 = new C05402(this, recyclerView.getContext());
        c05402.setTargetPosition(i);
        startSmoothScroll(c05402);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f1660q == null;
    }
}
