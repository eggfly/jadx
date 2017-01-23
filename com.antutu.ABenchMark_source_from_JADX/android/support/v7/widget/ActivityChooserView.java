package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import anet.channel.p017a.C0646b;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class ActivityChooserView extends ViewGroup {
    ActionProvider f1433a;
    private final C0486a f1434b;
    private final C0487b f1435c;
    private final an f1436d;
    private final FrameLayout f1437e;
    private final ImageView f1438f;
    private final FrameLayout f1439g;
    private final int f1440h;
    private final DataSetObserver f1441i;
    private final OnGlobalLayoutListener f1442j;
    private ap f1443k;
    private OnDismissListener f1444l;
    private boolean f1445m;
    private int f1446n;
    private boolean f1447o;
    private int f1448p;

    public static class InnerLayout extends an {
        private static final int[] f1425a;

        static {
            f1425a = new int[]{16842964};
        }

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            bh a = bh.m2501a(context, attributeSet, f1425a);
            setBackgroundDrawable(a.m2505a(0));
            a.m2506a();
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView.a */
    private class C0486a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView f1426a;
        private C0603d f1427b;
        private int f1428c;
        private boolean f1429d;
        private boolean f1430e;
        private boolean f1431f;

        public int m1647a() {
            int i = 0;
            int i2 = this.f1428c;
            this.f1428c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.f1428c = i2;
            return i3;
        }

        public void m1648a(int i) {
            if (this.f1428c != i) {
                this.f1428c = i;
                notifyDataSetChanged();
            }
        }

        public void m1649a(C0603d c0603d) {
            C0603d d = this.f1426a.f1434b.m1654d();
            if (d != null && this.f1426a.isShown()) {
                d.unregisterObserver(this.f1426a.f1441i);
            }
            this.f1427b = c0603d;
            if (c0603d != null && this.f1426a.isShown()) {
                c0603d.registerObserver(this.f1426a.f1441i);
            }
            notifyDataSetChanged();
        }

        public void m1650a(boolean z) {
            if (this.f1431f != z) {
                this.f1431f = z;
                notifyDataSetChanged();
            }
        }

        public void m1651a(boolean z, boolean z2) {
            if (this.f1429d != z || this.f1430e != z2) {
                this.f1429d = z;
                this.f1430e = z2;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo m1652b() {
            return this.f1427b.m2613b();
        }

        public int m1653c() {
            return this.f1427b.m2609a();
        }

        public C0603d m1654d() {
            return this.f1427b;
        }

        public boolean m1655e() {
            return this.f1429d;
        }

        public int getCount() {
            int a = this.f1427b.m2609a();
            if (!(this.f1429d || this.f1427b.m2613b() == null)) {
                a--;
            }
            a = Math.min(a, this.f1428c);
            return this.f1431f ? a + 1 : a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    if (!(this.f1429d || this.f1427b.m2613b() == null)) {
                        i++;
                    }
                    return this.f1427b.m2611a(i);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (this.f1431f && i == getCount() - 1) ? 1 : 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    if (view == null || view.getId() != C0417R.id.list_item) {
                        view = LayoutInflater.from(this.f1426a.getContext()).inflate(C0417R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1426a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0417R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0417R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1429d && i == 0 && this.f1430e) {
                        ViewCompat.setActivated(view, true);
                        return view;
                    }
                    ViewCompat.setActivated(view, false);
                    return view;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.f1426a.getContext()).inflate(C0417R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(C0417R.id.title)).setText(this.f1426a.getContext().getString(C0417R.string.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView.b */
    private class C0487b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView f1432a;

        private void m1656a() {
            if (this.f1432a.f1444l != null) {
                this.f1432a.f1444l.onDismiss();
            }
        }

        public void onClick(View view) {
            if (view == this.f1432a.f1439g) {
                this.f1432a.m1668b();
                Intent b = this.f1432a.f1434b.m1654d().m2612b(this.f1432a.f1434b.m1654d().m2610a(this.f1432a.f1434b.m1652b()));
                if (b != null) {
                    b.addFlags(C0646b.MAX_POOL_SIZE);
                    this.f1432a.getContext().startActivity(b);
                }
            } else if (view == this.f1432a.f1437e) {
                this.f1432a.f1445m = false;
                this.f1432a.m1658a(this.f1432a.f1446n);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            m1656a();
            if (this.f1432a.f1433a != null) {
                this.f1432a.f1433a.subUiVisibilityChanged(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0486a) adapterView.getAdapter()).getItemViewType(i)) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    this.f1432a.m1668b();
                    if (!this.f1432a.f1445m) {
                        if (!this.f1432a.f1434b.m1655e()) {
                            i++;
                        }
                        Intent b = this.f1432a.f1434b.m1654d().m2612b(i);
                        if (b != null) {
                            b.addFlags(C0646b.MAX_POOL_SIZE);
                            this.f1432a.getContext().startActivity(b);
                        }
                    } else if (i > 0) {
                        this.f1432a.f1434b.m1654d().m2614c(i);
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.f1432a.m1658a(Integer.MAX_VALUE);
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f1432a.f1439g) {
                if (this.f1432a.f1434b.getCount() > 0) {
                    this.f1432a.f1445m = true;
                    this.f1432a.m1658a(this.f1432a.f1446n);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    private void m1658a(int i) {
        if (this.f1434b.m1654d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1442j);
        boolean z = this.f1439g.getVisibility() == 0;
        int c = this.f1434b.m1653c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.f1434b.m1650a(false);
            this.f1434b.m1648a(i);
        } else {
            this.f1434b.m1650a(true);
            this.f1434b.m1648a(i - 1);
        }
        ap listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.m2371k()) {
            if (this.f1445m || !z) {
                this.f1434b.m1651a(true, z);
            } else {
                this.f1434b.m1651a(false, false);
            }
            listPopupWindow.m2364f(Math.min(this.f1434b.m1647a(), this.f1440h));
            listPopupWindow.m2357c();
            if (this.f1433a != null) {
                this.f1433a.subUiVisibilityChanged(true);
            }
            listPopupWindow.m2373m().setContentDescription(getContext().getString(C0417R.string.abc_activitychooserview_choose_application));
        }
    }

    private ap getListPopupWindow() {
        if (this.f1443k == null) {
            this.f1443k = new ap(getContext());
            this.f1443k.m2353a(this.f1434b);
            this.f1443k.m2351a((View) this);
            this.f1443k.m2355a(true);
            this.f1443k.m2352a(this.f1435c);
            this.f1443k.m2354a(this.f1435c);
        }
        return this.f1443k;
    }

    public boolean m1667a() {
        if (m1669c() || !this.f1447o) {
            return false;
        }
        this.f1445m = false;
        m1658a(this.f1446n);
        return true;
    }

    public boolean m1668b() {
        if (m1669c()) {
            getListPopupWindow().m2369i();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1442j);
            }
        }
        return true;
    }

    public boolean m1669c() {
        return getListPopupWindow().m2371k();
    }

    public C0603d getDataModel() {
        return this.f1434b.m1654d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0603d d = this.f1434b.m1654d();
        if (d != null) {
            d.registerObserver(this.f1441i);
        }
        this.f1447o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0603d d = this.f1434b.m1654d();
        if (d != null) {
            d.unregisterObserver(this.f1441i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1442j);
        }
        if (m1669c()) {
            m1668b();
        }
        this.f1447o = false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1436d.layout(0, 0, i3 - i, i4 - i2);
        if (!m1669c()) {
            m1668b();
        }
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1436d;
        if (this.f1439g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0603d c0603d) {
        this.f1434b.m1649a(c0603d);
        if (m1669c()) {
            m1668b();
            m1667a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1448p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1438f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1438f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f1446n = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1444l = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f1433a = actionProvider;
    }
}
