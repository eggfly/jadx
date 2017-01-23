package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView.C0491i;
import android.support.v7.widget.RecyclerView.C0493h;
import android.support.v7.widget.RecyclerView.C0493h.C0520a;
import android.support.v7.widget.RecyclerView.C0494q;
import android.support.v7.widget.RecyclerView.C0525n;
import android.support.v7.widget.RecyclerView.C0529r;
import android.support.v7.widget.RecyclerView.C0532u;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.handmark.pulltorefresh.library.C3628R;
import java.util.List;
import org.android.spdy.SpdyProtocol;

public class LinearLayoutManager extends C0493h {
    private static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final C0497a mAnchorInfo;
    private boolean mLastStackFromEnd;
    private C0499c mLayoutState;
    int mOrientation;
    as mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    /* renamed from: android.support.v7.widget.LinearLayoutManager.1 */
    class C04951 extends ao {
        final /* synthetic */ LinearLayoutManager f1480a;

        C04951(LinearLayoutManager linearLayoutManager, Context context) {
            this.f1480a = linearLayoutManager;
            super(context);
        }

        public PointF computeScrollVectorForPosition(int i) {
            return this.f1480a.computeScrollVectorForPosition(i);
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        int f1481a;
        int f1482b;
        boolean f1483c;

        /* renamed from: android.support.v7.widget.LinearLayoutManager.SavedState.1 */
        static class C04961 implements Creator<SavedState> {
            C04961() {
            }

            public SavedState m1726a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m1727a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1726a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1727a(i);
            }
        }

        static {
            CREATOR = new C04961();
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.f1481a = parcel.readInt();
            this.f1482b = parcel.readInt();
            if (parcel.readInt() != LinearLayoutManager.VERTICAL) {
                z = LinearLayoutManager.DEBUG;
            }
            this.f1483c = z;
        }

        public SavedState(SavedState savedState) {
            this.f1481a = savedState.f1481a;
            this.f1482b = savedState.f1482b;
            this.f1483c = savedState.f1483c;
        }

        boolean m1728a() {
            return this.f1481a >= 0 ? true : LinearLayoutManager.DEBUG;
        }

        void m1729b() {
            this.f1481a = -1;
        }

        public int describeContents() {
            return LinearLayoutManager.HORIZONTAL;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1481a);
            parcel.writeInt(this.f1482b);
            parcel.writeInt(this.f1483c ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager.a */
    class C0497a {
        int f1484a;
        int f1485b;
        boolean f1486c;
        final /* synthetic */ LinearLayoutManager f1487d;

        C0497a(LinearLayoutManager linearLayoutManager) {
            this.f1487d = linearLayoutManager;
        }

        private boolean m1731a(View view, C0529r c0529r) {
            C0491i c0491i = (C0491i) view.getLayoutParams();
            return (c0491i.m1701c() || c0491i.m1703e() < 0 || c0491i.m1703e() >= c0529r.m1929e()) ? LinearLayoutManager.DEBUG : true;
        }

        void m1732a() {
            this.f1484a = -1;
            this.f1485b = LinearLayoutManager.INVALID_OFFSET;
            this.f1486c = LinearLayoutManager.DEBUG;
        }

        public void m1733a(View view) {
            int b = this.f1487d.mOrientationHelper.m2389b();
            if (b >= 0) {
                m1735b(view);
                return;
            }
            this.f1484a = this.f1487d.getPosition(view);
            int c;
            if (this.f1486c) {
                b = (this.f1487d.mOrientationHelper.m2393d() - b) - this.f1487d.mOrientationHelper.m2390b(view);
                this.f1485b = this.f1487d.mOrientationHelper.m2393d() - b;
                if (b > 0) {
                    c = this.f1485b - this.f1487d.mOrientationHelper.m2392c(view);
                    int c2 = this.f1487d.mOrientationHelper.m2391c();
                    c -= c2 + Math.min(this.f1487d.mOrientationHelper.m2386a(view) - c2, LinearLayoutManager.HORIZONTAL);
                    if (c < 0) {
                        this.f1485b = Math.min(b, -c) + this.f1485b;
                        return;
                    }
                    return;
                }
                return;
            }
            c = this.f1487d.mOrientationHelper.m2386a(view);
            c2 = c - this.f1487d.mOrientationHelper.m2391c();
            this.f1485b = c;
            if (c2 > 0) {
                b = (this.f1487d.mOrientationHelper.m2393d() - Math.min(LinearLayoutManager.HORIZONTAL, (this.f1487d.mOrientationHelper.m2393d() - b) - this.f1487d.mOrientationHelper.m2390b(view))) - (c + this.f1487d.mOrientationHelper.m2392c(view));
                if (b < 0) {
                    this.f1485b -= Math.min(c2, -b);
                }
            }
        }

        void m1734b() {
            this.f1485b = this.f1486c ? this.f1487d.mOrientationHelper.m2393d() : this.f1487d.mOrientationHelper.m2391c();
        }

        public void m1735b(View view) {
            if (this.f1486c) {
                this.f1485b = this.f1487d.mOrientationHelper.m2390b(view) + this.f1487d.mOrientationHelper.m2389b();
            } else {
                this.f1485b = this.f1487d.mOrientationHelper.m2386a(view);
            }
            this.f1484a = this.f1487d.getPosition(view);
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1484a + ", mCoordinate=" + this.f1485b + ", mLayoutFromEnd=" + this.f1486c + '}';
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager.b */
    protected static class C0498b {
        public int f1488a;
        public boolean f1489b;
        public boolean f1490c;
        public boolean f1491d;

        protected C0498b() {
        }

        void m1736a() {
            this.f1488a = LinearLayoutManager.HORIZONTAL;
            this.f1489b = LinearLayoutManager.DEBUG;
            this.f1490c = LinearLayoutManager.DEBUG;
            this.f1491d = LinearLayoutManager.DEBUG;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager.c */
    static class C0499c {
        boolean f1492a;
        int f1493b;
        int f1494c;
        int f1495d;
        int f1496e;
        int f1497f;
        int f1498g;
        int f1499h;
        boolean f1500i;
        int f1501j;
        List<C0532u> f1502k;
        boolean f1503l;

        C0499c() {
            this.f1492a = true;
            this.f1499h = LinearLayoutManager.HORIZONTAL;
            this.f1500i = LinearLayoutManager.DEBUG;
            this.f1502k = null;
        }

        private View m1737b() {
            int size = this.f1502k.size();
            for (int i = LinearLayoutManager.HORIZONTAL; i < size; i += LinearLayoutManager.VERTICAL) {
                View view = ((C0532u) this.f1502k.get(i)).itemView;
                C0491i c0491i = (C0491i) view.getLayoutParams();
                if (!c0491i.m1701c() && this.f1495d == c0491i.m1703e()) {
                    m1740a(view);
                    return view;
                }
            }
            return null;
        }

        View m1738a(C0525n c0525n) {
            if (this.f1502k != null) {
                return m1737b();
            }
            View c = c0525n.m1877c(this.f1495d);
            this.f1495d += this.f1496e;
            return c;
        }

        public void m1739a() {
            m1740a(null);
        }

        public void m1740a(View view) {
            View b = m1742b(view);
            if (b == null) {
                this.f1495d = -1;
            } else {
                this.f1495d = ((C0491i) b.getLayoutParams()).m1703e();
            }
        }

        boolean m1741a(C0529r c0529r) {
            return (this.f1495d < 0 || this.f1495d >= c0529r.m1929e()) ? LinearLayoutManager.DEBUG : true;
        }

        public View m1742b(View view) {
            int size = this.f1502k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            int i2 = LinearLayoutManager.HORIZONTAL;
            while (i2 < size) {
                int i3;
                View view3;
                View view4 = ((C0532u) this.f1502k.get(i2)).itemView;
                C0491i c0491i = (C0491i) view4.getLayoutParams();
                if (view4 != view) {
                    if (c0491i.m1701c()) {
                        i3 = i;
                        view3 = view2;
                    } else {
                        i3 = (c0491i.m1703e() - this.f1495d) * this.f1496e;
                        if (i3 < 0) {
                            i3 = i;
                            view3 = view2;
                        } else if (i3 < i) {
                            if (i3 == 0) {
                                return view4;
                            }
                            view3 = view4;
                        }
                    }
                    i2 += LinearLayoutManager.VERTICAL;
                    view2 = view3;
                    i = i3;
                }
                i3 = i;
                view3 = view2;
                i2 += LinearLayoutManager.VERTICAL;
                view2 = view3;
                i = i3;
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, VERTICAL, DEBUG);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mReverseLayout = DEBUG;
        this.mShouldReverseLayout = DEBUG;
        this.mStackFromEnd = DEBUG;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0497a(this);
        setOrientation(i);
        setReverseLayout(z);
        setAutoMeasureEnabled(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mReverseLayout = DEBUG;
        this.mShouldReverseLayout = DEBUG;
        this.mStackFromEnd = DEBUG;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0497a(this);
        C0520a properties = C0493h.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f1521a);
        setReverseLayout(properties.f1523c);
        setStackFromEnd(properties.f1524d);
        setAutoMeasureEnabled(true);
    }

    private int computeScrollExtent(C0529r c0529r) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return HORIZONTAL;
        }
        ensureLayoutState();
        as asVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled ? true : DEBUG, true);
        if (!this.mSmoothScrollbarEnabled) {
            z = true;
        }
        return ay.m2459a(c0529r, asVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(z, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(C0529r c0529r) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return HORIZONTAL;
        }
        ensureLayoutState();
        as asVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled ? true : DEBUG, true);
        if (!this.mSmoothScrollbarEnabled) {
            z = true;
        }
        return ay.m2460a(c0529r, asVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(z, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(C0529r c0529r) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return HORIZONTAL;
        }
        ensureLayoutState();
        as asVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled ? true : DEBUG, true);
        if (!this.mSmoothScrollbarEnabled) {
            z = true;
        }
        return ay.m2461b(c0529r, asVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(z, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstReferenceChild(C0525n c0525n, C0529r c0529r) {
        return findReferenceChild(c0525n, c0529r, HORIZONTAL, getChildCount(), c0529r.m1929e());
    }

    private View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(HORIZONTAL, getChildCount(), z, z2) : findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z, z2) : findOneVisibleChild(HORIZONTAL, getChildCount(), z, z2);
    }

    private View findLastReferenceChild(C0525n c0525n, C0529r c0529r) {
        return findReferenceChild(c0525n, c0529r, getChildCount() - 1, -1, c0529r.m1929e());
    }

    private View findReferenceChildClosestToEnd(C0525n c0525n, C0529r c0529r) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(c0525n, c0529r) : findLastReferenceChild(c0525n, c0529r);
    }

    private View findReferenceChildClosestToStart(C0525n c0525n, C0529r c0529r) {
        return this.mShouldReverseLayout ? findLastReferenceChild(c0525n, c0529r) : findFirstReferenceChild(c0525n, c0529r);
    }

    private int fixLayoutEndGap(int i, C0525n c0525n, C0529r c0529r, boolean z) {
        int d = this.mOrientationHelper.m2393d() - i;
        if (d <= 0) {
            return HORIZONTAL;
        }
        d = -scrollBy(-d, c0525n, c0529r);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.mOrientationHelper.m2393d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.mOrientationHelper.m2388a(i2);
        return d + i2;
    }

    private int fixLayoutStartGap(int i, C0525n c0525n, C0529r c0529r, boolean z) {
        int c = i - this.mOrientationHelper.m2391c();
        if (c <= 0) {
            return HORIZONTAL;
        }
        c = -scrollBy(c, c0525n, c0529r);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.mOrientationHelper.m2391c();
        if (i2 <= 0) {
            return c;
        }
        this.mOrientationHelper.m2388a(-i2);
        return c - i2;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? HORIZONTAL : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : HORIZONTAL);
    }

    private void layoutForPredictiveAnimations(C0525n c0525n, C0529r c0529r, int i, int i2) {
        if (c0529r.m1926b() && getChildCount() != 0 && !c0529r.m1925a() && supportsPredictiveItemAnimations()) {
            int i3 = HORIZONTAL;
            int i4 = HORIZONTAL;
            List b = c0525n.m1872b();
            int size = b.size();
            int position = getPosition(getChildAt(HORIZONTAL));
            int i5 = HORIZONTAL;
            while (i5 < size) {
                int i6;
                int i7;
                C0532u c0532u = (C0532u) b.get(i5);
                if (c0532u.isRemoved()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((c0532u.getLayoutPosition() < position ? true : DEBUG) != this.mShouldReverseLayout ? -1 : VERTICAL) == -1) {
                        i7 = this.mOrientationHelper.m2392c(c0532u.itemView) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.mOrientationHelper.m2392c(c0532u.itemView) + i4;
                        i7 = i3;
                    }
                }
                i5 += VERTICAL;
                i3 = i7;
                i4 = i6;
            }
            this.mLayoutState.f1502k = b;
            if (i3 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
                this.mLayoutState.f1499h = i3;
                this.mLayoutState.f1494c = HORIZONTAL;
                this.mLayoutState.m1739a();
                fill(c0525n, this.mLayoutState, c0529r, DEBUG);
            }
            if (i4 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
                this.mLayoutState.f1499h = i4;
                this.mLayoutState.f1494c = HORIZONTAL;
                this.mLayoutState.m1739a();
                fill(c0525n, this.mLayoutState, c0529r, DEBUG);
            }
            this.mLayoutState.f1502k = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = HORIZONTAL; i < getChildCount(); i += VERTICAL) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.m2386a(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(C0525n c0525n, C0499c c0499c) {
        if (c0499c.f1492a && !c0499c.f1503l) {
            if (c0499c.f1497f == -1) {
                recycleViewsFromEnd(c0525n, c0499c.f1498g);
            } else {
                recycleViewsFromStart(c0525n, c0499c.f1498g);
            }
        }
    }

    private void recycleChildren(C0525n c0525n, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, c0525n);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, c0525n);
                i--;
            }
        }
    }

    private void recycleViewsFromEnd(C0525n c0525n, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int e = this.mOrientationHelper.m2395e() - i;
            int i2;
            if (this.mShouldReverseLayout) {
                for (i2 = HORIZONTAL; i2 < childCount; i2 += VERTICAL) {
                    if (this.mOrientationHelper.m2386a(getChildAt(i2)) < e) {
                        recycleChildren(c0525n, HORIZONTAL, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = childCount - 1; i2 >= 0; i2--) {
                if (this.mOrientationHelper.m2386a(getChildAt(i2)) < e) {
                    recycleChildren(c0525n, childCount - 1, i2);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStart(C0525n c0525n, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            int i2;
            if (this.mShouldReverseLayout) {
                for (i2 = childCount - 1; i2 >= 0; i2--) {
                    if (this.mOrientationHelper.m2390b(getChildAt(i2)) > i) {
                        recycleChildren(c0525n, childCount - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = HORIZONTAL; i2 < childCount; i2 += VERTICAL) {
                if (this.mOrientationHelper.m2390b(getChildAt(i2)) > i) {
                    recycleChildren(c0525n, HORIZONTAL, i2);
                    return;
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        boolean z = true;
        if (this.mOrientation == VERTICAL || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
            return;
        }
        if (this.mReverseLayout) {
            z = DEBUG;
        }
        this.mShouldReverseLayout = z;
    }

    private boolean updateAnchorFromChildren(C0525n c0525n, C0529r c0529r, C0497a c0497a) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return DEBUG;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && c0497a.m1731a(focusedChild, c0529r)) {
            c0497a.m1733a(focusedChild);
            return true;
        } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return DEBUG;
        } else {
            focusedChild = c0497a.f1486c ? findReferenceChildClosestToEnd(c0525n, c0529r) : findReferenceChildClosestToStart(c0525n, c0529r);
            if (focusedChild == null) {
                return DEBUG;
            }
            c0497a.m1735b(focusedChild);
            if (!c0529r.m1925a() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.m2386a(focusedChild) >= this.mOrientationHelper.m2393d() || this.mOrientationHelper.m2390b(focusedChild) < this.mOrientationHelper.m2391c()) {
                    z = true;
                }
                if (z) {
                    c0497a.f1485b = c0497a.f1486c ? this.mOrientationHelper.m2393d() : this.mOrientationHelper.m2391c();
                }
            }
            return true;
        }
    }

    private boolean updateAnchorFromPendingData(C0529r c0529r, C0497a c0497a) {
        boolean z = DEBUG;
        if (c0529r.m1925a() || this.mPendingScrollPosition == -1) {
            return DEBUG;
        }
        if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= c0529r.m1929e()) {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = INVALID_OFFSET;
            return DEBUG;
        }
        c0497a.f1484a = this.mPendingScrollPosition;
        if (this.mPendingSavedState != null && this.mPendingSavedState.m1728a()) {
            c0497a.f1486c = this.mPendingSavedState.f1483c;
            if (c0497a.f1486c) {
                c0497a.f1485b = this.mOrientationHelper.m2393d() - this.mPendingSavedState.f1482b;
                return true;
            }
            c0497a.f1485b = this.mOrientationHelper.m2391c() + this.mPendingSavedState.f1482b;
            return true;
        } else if (this.mPendingScrollPositionOffset == INVALID_OFFSET) {
            View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
            if (findViewByPosition == null) {
                if (getChildCount() > 0) {
                    if ((this.mPendingScrollPosition < getPosition(getChildAt(HORIZONTAL)) ? true : DEBUG) == this.mShouldReverseLayout) {
                        z = true;
                    }
                    c0497a.f1486c = z;
                }
                c0497a.m1734b();
                return true;
            } else if (this.mOrientationHelper.m2392c(findViewByPosition) > this.mOrientationHelper.m2396f()) {
                c0497a.m1734b();
                return true;
            } else if (this.mOrientationHelper.m2386a(findViewByPosition) - this.mOrientationHelper.m2391c() < 0) {
                c0497a.f1485b = this.mOrientationHelper.m2391c();
                c0497a.f1486c = DEBUG;
                return true;
            } else if (this.mOrientationHelper.m2393d() - this.mOrientationHelper.m2390b(findViewByPosition) < 0) {
                c0497a.f1485b = this.mOrientationHelper.m2393d();
                c0497a.f1486c = true;
                return true;
            } else {
                c0497a.f1485b = c0497a.f1486c ? this.mOrientationHelper.m2390b(findViewByPosition) + this.mOrientationHelper.m2389b() : this.mOrientationHelper.m2386a(findViewByPosition);
                return true;
            }
        } else {
            c0497a.f1486c = this.mShouldReverseLayout;
            if (this.mShouldReverseLayout) {
                c0497a.f1485b = this.mOrientationHelper.m2393d() - this.mPendingScrollPositionOffset;
                return true;
            }
            c0497a.f1485b = this.mOrientationHelper.m2391c() + this.mPendingScrollPositionOffset;
            return true;
        }
    }

    private void updateAnchorInfoForLayout(C0525n c0525n, C0529r c0529r, C0497a c0497a) {
        if (!updateAnchorFromPendingData(c0529r, c0497a) && !updateAnchorFromChildren(c0525n, c0529r, c0497a)) {
            c0497a.m1734b();
            c0497a.f1484a = this.mStackFromEnd ? c0529r.m1929e() - 1 : HORIZONTAL;
        }
    }

    private void updateLayoutState(int i, int i2, boolean z, C0529r c0529r) {
        int i3 = -1;
        int i4 = VERTICAL;
        this.mLayoutState.f1503l = resolveIsInfinite();
        this.mLayoutState.f1499h = getExtraLayoutSpace(c0529r);
        this.mLayoutState.f1497f = i;
        View childClosestToEnd;
        C0499c c0499c;
        if (i == VERTICAL) {
            C0499c c0499c2 = this.mLayoutState;
            c0499c2.f1499h += this.mOrientationHelper.m2397g();
            childClosestToEnd = getChildClosestToEnd();
            c0499c = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i3 = VERTICAL;
            }
            c0499c.f1496e = i3;
            this.mLayoutState.f1495d = getPosition(childClosestToEnd) + this.mLayoutState.f1496e;
            this.mLayoutState.f1493b = this.mOrientationHelper.m2390b(childClosestToEnd);
            i3 = this.mOrientationHelper.m2390b(childClosestToEnd) - this.mOrientationHelper.m2393d();
        } else {
            childClosestToEnd = getChildClosestToStart();
            c0499c = this.mLayoutState;
            c0499c.f1499h += this.mOrientationHelper.m2391c();
            c0499c = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i4 = -1;
            }
            c0499c.f1496e = i4;
            this.mLayoutState.f1495d = getPosition(childClosestToEnd) + this.mLayoutState.f1496e;
            this.mLayoutState.f1493b = this.mOrientationHelper.m2386a(childClosestToEnd);
            i3 = (-this.mOrientationHelper.m2386a(childClosestToEnd)) + this.mOrientationHelper.m2391c();
        }
        this.mLayoutState.f1494c = i2;
        if (z) {
            C0499c c0499c3 = this.mLayoutState;
            c0499c3.f1494c -= i3;
        }
        this.mLayoutState.f1498g = i3;
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.f1494c = this.mOrientationHelper.m2393d() - i2;
        this.mLayoutState.f1496e = this.mShouldReverseLayout ? -1 : VERTICAL;
        this.mLayoutState.f1495d = i;
        this.mLayoutState.f1497f = VERTICAL;
        this.mLayoutState.f1493b = i2;
        this.mLayoutState.f1498g = INVALID_OFFSET;
    }

    private void updateLayoutStateToFillEnd(C0497a c0497a) {
        updateLayoutStateToFillEnd(c0497a.f1484a, c0497a.f1485b);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.f1494c = i2 - this.mOrientationHelper.m2391c();
        this.mLayoutState.f1495d = i;
        this.mLayoutState.f1496e = this.mShouldReverseLayout ? VERTICAL : -1;
        this.mLayoutState.f1497f = -1;
        this.mLayoutState.f1493b = i2;
        this.mLayoutState.f1498g = INVALID_OFFSET;
    }

    private void updateLayoutStateToFillStart(C0497a c0497a) {
        updateLayoutStateToFillStart(c0497a.f1484a, c0497a.f1485b);
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0 ? true : DEBUG;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == VERTICAL ? true : DEBUG;
    }

    public int computeHorizontalScrollExtent(C0529r c0529r) {
        return computeScrollExtent(c0529r);
    }

    public int computeHorizontalScrollOffset(C0529r c0529r) {
        return computeScrollOffset(c0529r);
    }

    public int computeHorizontalScrollRange(C0529r c0529r) {
        return computeScrollRange(c0529r);
    }

    public PointF computeScrollVectorForPosition(int i) {
        int i2 = VERTICAL;
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return null;
        }
        if (i < getPosition(getChildAt(HORIZONTAL))) {
            z = VERTICAL;
        }
        if (z != this.mShouldReverseLayout) {
            i2 = -1;
        }
        return this.mOrientation == 0 ? new PointF((float) i2, 0.0f) : new PointF(0.0f, (float) i2);
    }

    public int computeVerticalScrollExtent(C0529r c0529r) {
        return computeScrollExtent(c0529r);
    }

    public int computeVerticalScrollOffset(C0529r c0529r) {
        return computeScrollOffset(c0529r);
    }

    public int computeVerticalScrollRange(C0529r c0529r) {
        return computeScrollRange(c0529r);
    }

    int convertFocusDirectionToLayoutDirection(int i) {
        int i2 = VERTICAL;
        int i3 = INVALID_OFFSET;
        switch (i) {
            case VERTICAL /*1*/:
                return -1;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return VERTICAL;
            case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                return this.mOrientation != 0 ? INVALID_OFFSET : -1;
            case jni.SID_CPU_MULTI /*33*/:
                return this.mOrientation != VERTICAL ? INVALID_OFFSET : -1;
            case C1692R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                if (this.mOrientation != 0) {
                    i2 = INVALID_OFFSET;
                }
                return i2;
            case SpdyProtocol.CDN /*130*/:
                if (this.mOrientation == VERTICAL) {
                    i3 = VERTICAL;
                }
                return i3;
            default:
                return INVALID_OFFSET;
        }
    }

    C0499c createLayoutState() {
        return new C0499c();
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
        if (this.mOrientationHelper == null) {
            this.mOrientationHelper = as.m2384a(this, this.mOrientation);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int fill(android.support.v7.widget.RecyclerView.C0525n r8, android.support.v7.widget.LinearLayoutManager.C0499c r9, android.support.v7.widget.RecyclerView.C0529r r10, boolean r11) {
        /*
        r7 = this;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r1 = r9.f1494c;
        r0 = r9.f1498g;
        if (r0 == r6) goto L_0x0016;
    L_0x0008:
        r0 = r9.f1494c;
        if (r0 >= 0) goto L_0x0013;
    L_0x000c:
        r0 = r9.f1498g;
        r2 = r9.f1494c;
        r0 = r0 + r2;
        r9.f1498g = r0;
    L_0x0013:
        r7.recycleByLayoutState(r8, r9);
    L_0x0016:
        r0 = r9.f1494c;
        r2 = r9.f1499h;
        r0 = r0 + r2;
        r2 = new android.support.v7.widget.LinearLayoutManager$b;
        r2.<init>();
    L_0x0020:
        r3 = r9.f1503l;
        if (r3 != 0) goto L_0x0026;
    L_0x0024:
        if (r0 <= 0) goto L_0x0036;
    L_0x0026:
        r3 = r9.m1741a(r10);
        if (r3 == 0) goto L_0x0036;
    L_0x002c:
        r2.m1736a();
        r7.layoutChunk(r8, r10, r9, r2);
        r3 = r2.f1489b;
        if (r3 == 0) goto L_0x003b;
    L_0x0036:
        r0 = r9.f1494c;
        r0 = r1 - r0;
        return r0;
    L_0x003b:
        r3 = r9.f1493b;
        r4 = r2.f1488a;
        r5 = r9.f1497f;
        r4 = r4 * r5;
        r3 = r3 + r4;
        r9.f1493b = r3;
        r3 = r2.f1490c;
        if (r3 == 0) goto L_0x0055;
    L_0x0049:
        r3 = r7.mLayoutState;
        r3 = r3.f1502k;
        if (r3 != 0) goto L_0x0055;
    L_0x004f:
        r3 = r10.m1925a();
        if (r3 != 0) goto L_0x005f;
    L_0x0055:
        r3 = r9.f1494c;
        r4 = r2.f1488a;
        r3 = r3 - r4;
        r9.f1494c = r3;
        r3 = r2.f1488a;
        r0 = r0 - r3;
    L_0x005f:
        r3 = r9.f1498g;
        if (r3 == r6) goto L_0x0078;
    L_0x0063:
        r3 = r9.f1498g;
        r4 = r2.f1488a;
        r3 = r3 + r4;
        r9.f1498g = r3;
        r3 = r9.f1494c;
        if (r3 >= 0) goto L_0x0075;
    L_0x006e:
        r3 = r9.f1498g;
        r4 = r9.f1494c;
        r3 = r3 + r4;
        r9.f1498g = r3;
    L_0x0075:
        r7.recycleByLayoutState(r8, r9);
    L_0x0078:
        if (r11 == 0) goto L_0x0020;
    L_0x007a:
        r3 = r2.f1491d;
        if (r3 == 0) goto L_0x0020;
    L_0x007e:
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.fill(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.LinearLayoutManager$c, android.support.v7.widget.RecyclerView$r, boolean):int");
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(HORIZONTAL, getChildCount(), true, DEBUG);
        return findOneVisibleChild == null ? -1 : getPosition(findOneVisibleChild);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(HORIZONTAL, getChildCount(), DEBUG, true);
        return findOneVisibleChild == null ? -1 : getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, DEBUG);
        return findOneVisibleChild == null ? -1 : getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, DEBUG, true);
        return findOneVisibleChild == null ? -1 : getPosition(findOneVisibleChild);
    }

    View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int c = this.mOrientationHelper.m2391c();
        int d = this.mOrientationHelper.m2393d();
        int i3 = i2 > i ? VERTICAL : -1;
        View view = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int a = this.mOrientationHelper.m2386a(childAt);
            int b = this.mOrientationHelper.m2390b(childAt);
            if (a < d && b > c) {
                if (!z) {
                    return childAt;
                }
                if (a >= c && b <= d) {
                    return childAt;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = childAt;
                }
            }
            childAt = view;
            i += i3;
            view = childAt;
        }
        return view;
    }

    View findReferenceChild(C0525n c0525n, C0529r c0529r, int i, int i2, int i3) {
        View view = null;
        ensureLayoutState();
        int c = this.mOrientationHelper.m2391c();
        int d = this.mOrientationHelper.m2393d();
        int i4 = i2 > i ? VERTICAL : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((C0491i) childAt.getLayoutParams()).m1701c()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.m2386a(childAt) < d && this.mOrientationHelper.m2390b(childAt) >= c) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                        i += i4;
                        view = view3;
                        view2 = childAt;
                    }
                }
            }
            view3 = view;
            childAt = view2;
            i += i4;
            view = view3;
            view2 = childAt;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(HORIZONTAL));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    public C0491i generateDefaultLayoutParams() {
        return new C0491i(-2, -2);
    }

    protected int getExtraLayoutSpace(C0529r c0529r) {
        return c0529r.m1928d() ? this.mOrientationHelper.m2396f() : HORIZONTAL;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    protected boolean isLayoutRTL() {
        return getLayoutDirection() == VERTICAL ? true : DEBUG;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(C0525n c0525n, C0529r c0529r, C0499c c0499c, C0498b c0498b) {
        View a = c0499c.m1738a(c0525n);
        if (a == null) {
            c0498b.f1489b = true;
            return;
        }
        int width;
        int d;
        int i;
        int i2;
        C0491i c0491i = (C0491i) a.getLayoutParams();
        if (c0499c.f1502k == null) {
            if (this.mShouldReverseLayout == (c0499c.f1497f == -1 ? true : HORIZONTAL)) {
                addView(a);
            } else {
                addView(a, HORIZONTAL);
            }
        } else {
            if (this.mShouldReverseLayout == (c0499c.f1497f == -1 ? true : HORIZONTAL)) {
                addDisappearingView(a);
            } else {
                addDisappearingView(a, HORIZONTAL);
            }
        }
        measureChildWithMargins(a, HORIZONTAL, HORIZONTAL);
        c0498b.f1488a = this.mOrientationHelper.m2392c(a);
        if (this.mOrientation == VERTICAL) {
            if (isLayoutRTL()) {
                width = getWidth() - getPaddingRight();
                d = width - this.mOrientationHelper.m2394d(a);
            } else {
                d = getPaddingLeft();
                width = this.mOrientationHelper.m2394d(a) + d;
            }
            if (c0499c.f1497f == -1) {
                i = c0499c.f1493b - c0498b.f1488a;
                i2 = width;
                width = c0499c.f1493b;
            } else {
                i = c0499c.f1493b;
                i2 = width;
                width = c0499c.f1493b + c0498b.f1488a;
            }
        } else {
            i = getPaddingTop();
            width = this.mOrientationHelper.m2394d(a) + i;
            if (c0499c.f1497f == -1) {
                d = c0499c.f1493b - c0498b.f1488a;
                i2 = c0499c.f1493b;
            } else {
                d = c0499c.f1493b;
                i2 = c0499c.f1493b + c0498b.f1488a;
            }
        }
        layoutDecorated(a, d + c0491i.leftMargin, i + c0491i.topMargin, i2 - c0491i.rightMargin, width - c0491i.bottomMargin);
        if (c0491i.m1701c() || c0491i.m1702d()) {
            c0498b.f1490c = true;
        }
        c0498b.f1491d = a.isFocusable();
    }

    void onAnchorReady(C0525n c0525n, C0529r c0529r, C0497a c0497a, int i) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, C0525n c0525n) {
        super.onDetachedFromWindow(recyclerView, c0525n);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(c0525n);
            c0525n.m1862a();
        }
    }

    public View onFocusSearchFailed(View view, int i, C0525n c0525n, C0529r c0529r) {
        resolveShouldLayoutReverse();
        if (getChildCount() == 0) {
            return null;
        }
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
        if (convertFocusDirectionToLayoutDirection == INVALID_OFFSET) {
            return null;
        }
        ensureLayoutState();
        View findReferenceChildClosestToStart = convertFocusDirectionToLayoutDirection == -1 ? findReferenceChildClosestToStart(c0525n, c0529r) : findReferenceChildClosestToEnd(c0525n, c0529r);
        if (findReferenceChildClosestToStart == null) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (MAX_SCROLL_FACTOR * ((float) this.mOrientationHelper.m2396f())), DEBUG, c0529r);
        this.mLayoutState.f1498g = INVALID_OFFSET;
        this.mLayoutState.f1492a = DEBUG;
        fill(c0525n, this.mLayoutState, c0529r, true);
        View childClosestToStart = convertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        return (childClosestToStart == findReferenceChildClosestToStart || !childClosestToStart.isFocusable()) ? null : childClosestToStart;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setFromIndex(findFirstVisibleItemPosition());
            asRecord.setToIndex(findLastVisibleItemPosition());
        }
    }

    public void onLayoutChildren(C0525n c0525n, C0529r c0529r) {
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && c0529r.m1929e() == 0) {
            removeAndRecycleAllViews(c0525n);
            return;
        }
        int i;
        int d;
        if (this.mPendingSavedState != null && this.mPendingSavedState.m1728a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f1481a;
        }
        ensureLayoutState();
        this.mLayoutState.f1492a = DEBUG;
        resolveShouldLayoutReverse();
        this.mAnchorInfo.m1732a();
        this.mAnchorInfo.f1486c = this.mShouldReverseLayout ^ this.mStackFromEnd;
        updateAnchorInfoForLayout(c0525n, c0529r, this.mAnchorInfo);
        int extraLayoutSpace = getExtraLayoutSpace(c0529r);
        if (this.mLayoutState.f1501j >= 0) {
            i = HORIZONTAL;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = HORIZONTAL;
        }
        i += this.mOrientationHelper.m2391c();
        extraLayoutSpace += this.mOrientationHelper.m2397g();
        if (!(!c0529r.m1925a() || this.mPendingScrollPosition == -1 || this.mPendingScrollPositionOffset == INVALID_OFFSET)) {
            View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
            if (findViewByPosition != null) {
                d = this.mShouldReverseLayout ? (this.mOrientationHelper.m2393d() - this.mOrientationHelper.m2390b(findViewByPosition)) - this.mPendingScrollPositionOffset : this.mPendingScrollPositionOffset - (this.mOrientationHelper.m2386a(findViewByPosition) - this.mOrientationHelper.m2391c());
                if (d > 0) {
                    i += d;
                } else {
                    extraLayoutSpace -= d;
                }
            }
        }
        d = this.mAnchorInfo.f1486c ? this.mShouldReverseLayout ? VERTICAL : -1 : this.mShouldReverseLayout ? -1 : VERTICAL;
        onAnchorReady(c0525n, c0529r, this.mAnchorInfo, d);
        detachAndScrapAttachedViews(c0525n);
        this.mLayoutState.f1503l = resolveIsInfinite();
        this.mLayoutState.f1500i = c0529r.m1925a();
        int i2;
        if (this.mAnchorInfo.f1486c) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.f1499h = i;
            fill(c0525n, this.mLayoutState, c0529r, DEBUG);
            i = this.mLayoutState.f1493b;
            i2 = this.mLayoutState.f1495d;
            if (this.mLayoutState.f1494c > 0) {
                extraLayoutSpace += this.mLayoutState.f1494c;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.f1499h = extraLayoutSpace;
            C0499c c0499c = this.mLayoutState;
            c0499c.f1495d += this.mLayoutState.f1496e;
            fill(c0525n, this.mLayoutState, c0529r, DEBUG);
            d = this.mLayoutState.f1493b;
            if (this.mLayoutState.f1494c > 0) {
                extraLayoutSpace = this.mLayoutState.f1494c;
                updateLayoutStateToFillStart(i2, i);
                this.mLayoutState.f1499h = extraLayoutSpace;
                fill(c0525n, this.mLayoutState, c0529r, DEBUG);
                extraLayoutSpace = this.mLayoutState.f1493b;
            } else {
                extraLayoutSpace = i;
            }
            i = extraLayoutSpace;
            extraLayoutSpace = d;
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.f1499h = extraLayoutSpace;
            fill(c0525n, this.mLayoutState, c0529r, DEBUG);
            extraLayoutSpace = this.mLayoutState.f1493b;
            d = this.mLayoutState.f1495d;
            if (this.mLayoutState.f1494c > 0) {
                i += this.mLayoutState.f1494c;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.f1499h = i;
            C0499c c0499c2 = this.mLayoutState;
            c0499c2.f1495d += this.mLayoutState.f1496e;
            fill(c0525n, this.mLayoutState, c0529r, DEBUG);
            i = this.mLayoutState.f1493b;
            if (this.mLayoutState.f1494c > 0) {
                i2 = this.mLayoutState.f1494c;
                updateLayoutStateToFillEnd(d, extraLayoutSpace);
                this.mLayoutState.f1499h = i2;
                fill(c0525n, this.mLayoutState, c0529r, DEBUG);
                extraLayoutSpace = this.mLayoutState.f1493b;
            }
        }
        if (getChildCount() > 0) {
            int fixLayoutStartGap;
            if ((this.mShouldReverseLayout ^ this.mStackFromEnd) != 0) {
                d = fixLayoutEndGap(extraLayoutSpace, c0525n, c0529r, true);
                i += d;
                extraLayoutSpace += d;
                fixLayoutStartGap = fixLayoutStartGap(i, c0525n, c0529r, DEBUG);
                i += fixLayoutStartGap;
                extraLayoutSpace += fixLayoutStartGap;
            } else {
                d = fixLayoutStartGap(i, c0525n, c0529r, true);
                i += d;
                extraLayoutSpace += d;
                fixLayoutStartGap = fixLayoutEndGap(extraLayoutSpace, c0525n, c0529r, DEBUG);
                i += fixLayoutStartGap;
                extraLayoutSpace += fixLayoutStartGap;
            }
        }
        layoutForPredictiveAnimations(c0525n, c0529r, i, extraLayoutSpace);
        if (!c0529r.m1925a()) {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = INVALID_OFFSET;
            this.mOrientationHelper.m2387a();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
        this.mPendingSavedState = null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.f1483c = z;
            View childClosestToEnd;
            if (z) {
                childClosestToEnd = getChildClosestToEnd();
                savedState.f1482b = this.mOrientationHelper.m2393d() - this.mOrientationHelper.m2390b(childClosestToEnd);
                savedState.f1481a = getPosition(childClosestToEnd);
                return savedState;
            }
            childClosestToEnd = getChildClosestToStart();
            savedState.f1481a = getPosition(childClosestToEnd);
            savedState.f1482b = this.mOrientationHelper.m2386a(childClosestToEnd) - this.mOrientationHelper.m2391c();
            return savedState;
        }
        savedState.m1729b();
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            Object obj = VERTICAL;
        } else {
            position = -1;
        }
        if (this.mShouldReverseLayout) {
            if (obj == VERTICAL) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.m2393d() - (this.mOrientationHelper.m2386a(view2) + this.mOrientationHelper.m2392c(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.m2393d() - this.mOrientationHelper.m2390b(view2));
            }
        } else if (obj == -1) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.m2386a(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.m2390b(view2) - this.mOrientationHelper.m2392c(view));
        }
    }

    boolean resolveIsInfinite() {
        return (this.mOrientationHelper.m2398h() == 0 && this.mOrientationHelper.m2395e() == 0) ? true : DEBUG;
    }

    int scrollBy(int i, C0525n c0525n, C0529r c0529r) {
        if (getChildCount() == 0 || i == 0) {
            return HORIZONTAL;
        }
        this.mLayoutState.f1492a = true;
        ensureLayoutState();
        int i2 = i > 0 ? VERTICAL : -1;
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, c0529r);
        int fill = this.mLayoutState.f1498g + fill(c0525n, this.mLayoutState, c0529r, DEBUG);
        if (fill < 0) {
            return HORIZONTAL;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.m2388a(-i);
        this.mLayoutState.f1501j = i;
        return i;
    }

    public int scrollHorizontallyBy(int i, C0525n c0525n, C0529r c0529r) {
        return this.mOrientation == VERTICAL ? HORIZONTAL : scrollBy(i, c0525n, c0529r);
    }

    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.m1729b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.m1729b();
        }
        requestLayout();
    }

    public int scrollVerticallyBy(int i, C0525n c0525n, C0529r c0529r) {
        return this.mOrientation == 0 ? HORIZONTAL : scrollBy(i, c0525n, c0529r);
    }

    public void setOrientation(int i) {
        if (i == 0 || i == VERTICAL) {
            assertNotInLayoutOrScroll(null);
            if (i != this.mOrientation) {
                this.mOrientation = i;
                this.mOrientationHelper = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.mReverseLayout) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != z) {
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? DEBUG : true;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C0529r c0529r, int i) {
        C0494q c04951 = new C04951(this, recyclerView.getContext());
        c04951.setTargetPosition(i);
        startSmoothScroll(c04951);
    }

    public boolean supportsPredictiveItemAnimations() {
        return (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) ? true : DEBUG;
    }

    void validateChildOrder() {
        boolean z = true;
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() >= VERTICAL) {
            int position = getPosition(getChildAt(HORIZONTAL));
            int a = this.mOrientationHelper.m2386a(getChildAt(HORIZONTAL));
            int i;
            View childAt;
            int position2;
            int a2;
            StringBuilder append;
            if (this.mShouldReverseLayout) {
                i = VERTICAL;
                while (i < getChildCount()) {
                    childAt = getChildAt(i);
                    position2 = getPosition(childAt);
                    a2 = this.mOrientationHelper.m2386a(childAt);
                    if (position2 < position) {
                        logChildren();
                        append = new StringBuilder().append("detected invalid position. loc invalid? ");
                        if (a2 >= a) {
                            z = DEBUG;
                        }
                        throw new RuntimeException(append.append(z).toString());
                    } else if (a2 > a) {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    } else {
                        i += VERTICAL;
                    }
                }
                return;
            }
            i = VERTICAL;
            while (i < getChildCount()) {
                childAt = getChildAt(i);
                position2 = getPosition(childAt);
                a2 = this.mOrientationHelper.m2386a(childAt);
                if (position2 < position) {
                    logChildren();
                    append = new StringBuilder().append("detected invalid position. loc invalid? ");
                    if (a2 >= a) {
                        z = DEBUG;
                    }
                    throw new RuntimeException(append.append(z).toString());
                } else if (a2 < a) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                } else {
                    i += VERTICAL;
                }
            }
        }
    }
}
