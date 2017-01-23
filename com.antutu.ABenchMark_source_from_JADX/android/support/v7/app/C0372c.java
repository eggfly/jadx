package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.v7.appcompat.C0417R;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: android.support.v7.app.c */
class C0372c {
    private TextView f920A;
    private TextView f921B;
    private View f922C;
    private ListAdapter f923D;
    private int f924E;
    private int f925F;
    private int f926G;
    private int f927H;
    private int f928I;
    private int f929J;
    private int f930K;
    private int f931L;
    private Handler f932M;
    private final OnClickListener f933N;
    private final Context f934a;
    private final C0375l f935b;
    private final Window f936c;
    private CharSequence f937d;
    private CharSequence f938e;
    private ListView f939f;
    private View f940g;
    private int f941h;
    private int f942i;
    private int f943j;
    private int f944k;
    private int f945l;
    private boolean f946m;
    private Button f947n;
    private CharSequence f948o;
    private Message f949p;
    private Button f950q;
    private CharSequence f951r;
    private Message f952s;
    private Button f953t;
    private CharSequence f954u;
    private Message f955v;
    private NestedScrollView f956w;
    private int f957x;
    private Drawable f958y;
    private ImageView f959z;

    /* renamed from: android.support.v7.app.c.1 */
    class C03591 implements OnClickListener {
        final /* synthetic */ C0372c f855a;

        C03591(C0372c c0372c) {
            this.f855a = c0372c;
        }

        public void onClick(View view) {
            Message obtain = (view != this.f855a.f947n || this.f855a.f949p == null) ? (view != this.f855a.f950q || this.f855a.f952s == null) ? (view != this.f855a.f953t || this.f855a.f955v == null) ? null : Message.obtain(this.f855a.f955v) : Message.obtain(this.f855a.f952s) : Message.obtain(this.f855a.f949p);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.f855a.f932M.obtainMessage(1, this.f855a.f935b).sendToTarget();
        }
    }

    /* renamed from: android.support.v7.app.c.2 */
    class C03602 implements OnScrollChangeListener {
        final /* synthetic */ View f856a;
        final /* synthetic */ View f857b;
        final /* synthetic */ C0372c f858c;

        C03602(C0372c c0372c, View view, View view2) {
            this.f858c = c0372c;
            this.f856a = view;
            this.f857b = view2;
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            C0372c.m1025b(nestedScrollView, this.f856a, this.f857b);
        }
    }

    /* renamed from: android.support.v7.app.c.3 */
    class C03613 implements Runnable {
        final /* synthetic */ View f859a;
        final /* synthetic */ View f860b;
        final /* synthetic */ C0372c f861c;

        C03613(C0372c c0372c, View view, View view2) {
            this.f861c = c0372c;
            this.f859a = view;
            this.f860b = view2;
        }

        public void run() {
            C0372c.m1025b(this.f861c.f956w, this.f859a, this.f860b);
        }
    }

    /* renamed from: android.support.v7.app.c.4 */
    class C03624 implements OnScrollListener {
        final /* synthetic */ View f862a;
        final /* synthetic */ View f863b;
        final /* synthetic */ C0372c f864c;

        C03624(C0372c c0372c, View view, View view2) {
            this.f864c = c0372c;
            this.f862a = view;
            this.f863b = view2;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            C0372c.m1025b(absListView, this.f862a, this.f863b);
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: android.support.v7.app.c.5 */
    class C03635 implements Runnable {
        final /* synthetic */ View f865a;
        final /* synthetic */ View f866b;
        final /* synthetic */ C0372c f867c;

        C03635(C0372c c0372c, View view, View view2) {
            this.f867c = c0372c;
            this.f865a = view;
            this.f866b = view2;
        }

        public void run() {
            C0372c.m1025b(this.f867c.f939f, this.f865a, this.f866b);
        }
    }

    /* renamed from: android.support.v7.app.c.a */
    public static class C0369a {
        public int f880A;
        public boolean f881B;
        public boolean[] f882C;
        public boolean f883D;
        public boolean f884E;
        public int f885F;
        public OnMultiChoiceClickListener f886G;
        public Cursor f887H;
        public String f888I;
        public String f889J;
        public OnItemSelectedListener f890K;
        public C0368a f891L;
        public boolean f892M;
        public final Context f893a;
        public final LayoutInflater f894b;
        public int f895c;
        public Drawable f896d;
        public int f897e;
        public CharSequence f898f;
        public View f899g;
        public CharSequence f900h;
        public CharSequence f901i;
        public DialogInterface.OnClickListener f902j;
        public CharSequence f903k;
        public DialogInterface.OnClickListener f904l;
        public CharSequence f905m;
        public DialogInterface.OnClickListener f906n;
        public boolean f907o;
        public OnCancelListener f908p;
        public OnDismissListener f909q;
        public OnKeyListener f910r;
        public CharSequence[] f911s;
        public ListAdapter f912t;
        public DialogInterface.OnClickListener f913u;
        public int f914v;
        public View f915w;
        public int f916x;
        public int f917y;
        public int f918z;

        /* renamed from: android.support.v7.app.c.a.1 */
        class C03641 extends ArrayAdapter<CharSequence> {
            final /* synthetic */ ListView f868a;
            final /* synthetic */ C0369a f869b;

            C03641(C0369a c0369a, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
                this.f869b = c0369a;
                this.f868a = listView;
                super(context, i, i2, charSequenceArr);
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (this.f869b.f882C != null && this.f869b.f882C[i]) {
                    this.f868a.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: android.support.v7.app.c.a.2 */
        class C03652 extends CursorAdapter {
            final /* synthetic */ ListView f870a;
            final /* synthetic */ C0372c f871b;
            final /* synthetic */ C0369a f872c;
            private final int f873d;
            private final int f874e;

            C03652(C0369a c0369a, Context context, Cursor cursor, boolean z, ListView listView, C0372c c0372c) {
                this.f872c = c0369a;
                this.f870a = listView;
                this.f871b = c0372c;
                super(context, cursor, z);
                Cursor cursor2 = getCursor();
                this.f873d = cursor2.getColumnIndexOrThrow(this.f872c.f888I);
                this.f874e = cursor2.getColumnIndexOrThrow(this.f872c.f889J);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f873d));
                this.f870a.setItemChecked(cursor.getPosition(), cursor.getInt(this.f874e) == 1);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return this.f872c.f894b.inflate(this.f871b.f928I, viewGroup, false);
            }
        }

        /* renamed from: android.support.v7.app.c.a.3 */
        class C03663 implements OnItemClickListener {
            final /* synthetic */ C0372c f875a;
            final /* synthetic */ C0369a f876b;

            C03663(C0369a c0369a, C0372c c0372c) {
                this.f876b = c0369a;
                this.f875a = c0372c;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.f876b.f913u.onClick(this.f875a.f935b, i);
                if (!this.f876b.f884E) {
                    this.f875a.f935b.dismiss();
                }
            }
        }

        /* renamed from: android.support.v7.app.c.a.4 */
        class C03674 implements OnItemClickListener {
            final /* synthetic */ ListView f877a;
            final /* synthetic */ C0372c f878b;
            final /* synthetic */ C0369a f879c;

            C03674(C0369a c0369a, ListView listView, C0372c c0372c) {
                this.f879c = c0369a;
                this.f877a = listView;
                this.f878b = c0372c;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.f879c.f882C != null) {
                    this.f879c.f882C[i] = this.f877a.isItemChecked(i);
                }
                this.f879c.f886G.onClick(this.f878b.f935b, i, this.f877a.isItemChecked(i));
            }
        }

        /* renamed from: android.support.v7.app.c.a.a */
        public interface C0368a {
            void m1011a(ListView listView);
        }

        public C0369a(Context context) {
            this.f895c = 0;
            this.f897e = 0;
            this.f881B = false;
            this.f885F = -1;
            this.f892M = true;
            this.f893a = context;
            this.f907o = true;
            this.f894b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void m1012b(C0372c c0372c) {
            ListAdapter simpleCursorAdapter;
            ListView listView = (ListView) this.f894b.inflate(c0372c.f927H, null);
            if (!this.f883D) {
                int m = this.f884E ? c0372c.f929J : c0372c.f930K;
                simpleCursorAdapter = this.f887H != null ? new SimpleCursorAdapter(this.f893a, m, this.f887H, new String[]{this.f888I}, new int[]{16908308}) : this.f912t != null ? this.f912t : new C0371c(this.f893a, m, 16908308, this.f911s);
            } else if (this.f887H == null) {
                simpleCursorAdapter = new C03641(this, this.f893a, c0372c.f928I, 16908308, this.f911s, listView);
            } else {
                Object c03652 = new C03652(this, this.f893a, this.f887H, false, listView, c0372c);
            }
            if (this.f891L != null) {
                this.f891L.m1011a(listView);
            }
            c0372c.f923D = simpleCursorAdapter;
            c0372c.f924E = this.f885F;
            if (this.f913u != null) {
                listView.setOnItemClickListener(new C03663(this, c0372c));
            } else if (this.f886G != null) {
                listView.setOnItemClickListener(new C03674(this, listView, c0372c));
            }
            if (this.f890K != null) {
                listView.setOnItemSelectedListener(this.f890K);
            }
            if (this.f884E) {
                listView.setChoiceMode(1);
            } else if (this.f883D) {
                listView.setChoiceMode(2);
            }
            c0372c.f939f = listView;
        }

        public void m1013a(C0372c c0372c) {
            if (this.f899g != null) {
                c0372c.m1050b(this.f899g);
            } else {
                if (this.f898f != null) {
                    c0372c.m1047a(this.f898f);
                }
                if (this.f896d != null) {
                    c0372c.m1045a(this.f896d);
                }
                if (this.f895c != 0) {
                    c0372c.m1049b(this.f895c);
                }
                if (this.f897e != 0) {
                    c0372c.m1049b(c0372c.m1053c(this.f897e));
                }
            }
            if (this.f900h != null) {
                c0372c.m1051b(this.f900h);
            }
            if (this.f901i != null) {
                c0372c.m1044a(-1, this.f901i, this.f902j, null);
            }
            if (this.f903k != null) {
                c0372c.m1044a(-2, this.f903k, this.f904l, null);
            }
            if (this.f905m != null) {
                c0372c.m1044a(-3, this.f905m, this.f906n, null);
            }
            if (!(this.f911s == null && this.f887H == null && this.f912t == null)) {
                m1012b(c0372c);
            }
            if (this.f915w != null) {
                if (this.f881B) {
                    c0372c.m1046a(this.f915w, this.f916x, this.f917y, this.f918z, this.f880A);
                    return;
                }
                c0372c.m1054c(this.f915w);
            } else if (this.f914v != 0) {
                c0372c.m1043a(this.f914v);
            }
        }
    }

    /* renamed from: android.support.v7.app.c.b */
    private static final class C0370b extends Handler {
        private WeakReference<DialogInterface> f919a;

        public C0370b(DialogInterface dialogInterface) {
            this.f919a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case TnetStatusCode.EASY_REQ_STATE_PROCESS_RSP_FAIL /*-3*/:
                case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f919a.get(), message.what);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    ((DialogInterface) message.obj).dismiss();
                default:
            }
        }
    }

    /* renamed from: android.support.v7.app.c.c */
    private static class C0371c extends ArrayAdapter<CharSequence> {
        public C0371c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public C0372c(Context context, C0375l c0375l, Window window) {
        this.f946m = false;
        this.f957x = 0;
        this.f924E = -1;
        this.f931L = 0;
        this.f933N = new C03591(this);
        this.f934a = context;
        this.f935b = c0375l;
        this.f936c = window;
        this.f932M = new C0370b(c0375l);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0417R.styleable.AlertDialog, C0417R.attr.alertDialogStyle, 0);
        this.f925F = obtainStyledAttributes.getResourceId(C0417R.styleable.AlertDialog_android_layout, 0);
        this.f926G = obtainStyledAttributes.getResourceId(C0417R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f927H = obtainStyledAttributes.getResourceId(C0417R.styleable.AlertDialog_listLayout, 0);
        this.f928I = obtainStyledAttributes.getResourceId(C0417R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f929J = obtainStyledAttributes.getResourceId(C0417R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f930K = obtainStyledAttributes.getResourceId(C0417R.styleable.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        c0375l.m1064a(1);
    }

    private ViewGroup m1015a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    private void m1020a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.f940g != null ? this.f940g : this.f941h != 0 ? LayoutInflater.from(this.f934a).inflate(this.f941h, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && C0372c.m1022a(inflate))) {
            this.f936c.setFlags(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION, AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f936c.findViewById(C0417R.id.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.f946m) {
                frameLayout.setPadding(this.f942i, this.f943j, this.f944k, this.f945l);
            }
            if (this.f939f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m1021a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f936c.findViewById(C0417R.id.scrollIndicatorUp);
        View findViewById2 = this.f936c.findViewById(C0417R.id.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f938e != null) {
                this.f956w.setOnScrollChangeListener(new C03602(this, findViewById, view2));
                this.f956w.post(new C03613(this, findViewById, view2));
            } else if (this.f939f != null) {
                this.f939f.setOnScrollListener(new C03624(this, findViewById, view2));
                this.f939f.post(new C03635(this, findViewById, view2));
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    static boolean m1022a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (C0372c.m1022a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int m1023b() {
        return this.f926G == 0 ? this.f925F : this.f931L == 1 ? this.f926G : this.f925F;
    }

    private static void m1025b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ViewCompat.canScrollVertically(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ViewCompat.canScrollVertically(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m1026b(ViewGroup viewGroup) {
        if (this.f922C != null) {
            viewGroup.addView(this.f922C, 0, new LayoutParams(-1, -2));
            this.f936c.findViewById(C0417R.id.title_template).setVisibility(8);
            return;
        }
        this.f959z = (ImageView) this.f936c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f937d) ? 1 : 0) != 0) {
            this.f920A = (TextView) this.f936c.findViewById(C0417R.id.alertTitle);
            this.f920A.setText(this.f937d);
            if (this.f957x != 0) {
                this.f959z.setImageResource(this.f957x);
                return;
            } else if (this.f958y != null) {
                this.f959z.setImageDrawable(this.f958y);
                return;
            } else {
                this.f920A.setPadding(this.f959z.getPaddingLeft(), this.f959z.getPaddingTop(), this.f959z.getPaddingRight(), this.f959z.getPaddingBottom());
                this.f959z.setVisibility(8);
                return;
            }
        }
        this.f936c.findViewById(C0417R.id.title_template).setVisibility(8);
        this.f959z.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void m1028c() {
        View findViewById = this.f936c.findViewById(C0417R.id.parentPanel);
        View findViewById2 = findViewById.findViewById(C0417R.id.topPanel);
        View findViewById3 = findViewById.findViewById(C0417R.id.contentPanel);
        View findViewById4 = findViewById.findViewById(C0417R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0417R.id.customPanel);
        m1020a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0417R.id.topPanel);
        View findViewById6 = viewGroup.findViewById(C0417R.id.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0417R.id.buttonPanel);
        ViewGroup a = m1015a(findViewById5, findViewById2);
        ViewGroup a2 = m1015a(findViewById6, findViewById3);
        ViewGroup a3 = m1015a(findViewById7, findViewById4);
        m1029c(a2);
        m1031d(a3);
        m1026b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById3 = a2.findViewById(C0417R.id.textSpacerNoButtons);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
        }
        if (z2 && this.f956w != null) {
            this.f956w.setClipToPadding(true);
        }
        if (!z) {
            findViewById3 = this.f939f != null ? this.f939f : this.f956w;
            if (findViewById3 != null) {
                m1021a(a2, findViewById3, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f939f;
        if (listView != null && this.f923D != null) {
            listView.setAdapter(this.f923D);
            int i = this.f924E;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    private void m1029c(ViewGroup viewGroup) {
        this.f956w = (NestedScrollView) this.f936c.findViewById(C0417R.id.scrollView);
        this.f956w.setFocusable(false);
        this.f956w.setNestedScrollingEnabled(false);
        this.f921B = (TextView) viewGroup.findViewById(16908299);
        if (this.f921B != null) {
            if (this.f938e != null) {
                this.f921B.setText(this.f938e);
                return;
            }
            this.f921B.setVisibility(8);
            this.f956w.removeView(this.f921B);
            if (this.f939f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f956w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f956w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f939f, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void m1031d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.f947n = (Button) viewGroup.findViewById(16908313);
        this.f947n.setOnClickListener(this.f933N);
        if (TextUtils.isEmpty(this.f948o)) {
            this.f947n.setVisibility(8);
            i = 0;
        } else {
            this.f947n.setText(this.f948o);
            this.f947n.setVisibility(0);
            i = 1;
        }
        this.f950q = (Button) viewGroup.findViewById(16908314);
        this.f950q.setOnClickListener(this.f933N);
        if (TextUtils.isEmpty(this.f951r)) {
            this.f950q.setVisibility(8);
        } else {
            this.f950q.setText(this.f951r);
            this.f950q.setVisibility(0);
            i |= 2;
        }
        this.f953t = (Button) viewGroup.findViewById(16908315);
        this.f953t.setOnClickListener(this.f933N);
        if (TextUtils.isEmpty(this.f954u)) {
            this.f953t.setVisibility(8);
        } else {
            this.f953t.setText(this.f954u);
            this.f953t.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void m1042a() {
        this.f935b.setContentView(m1023b());
        m1028c();
    }

    public void m1043a(int i) {
        this.f940g = null;
        this.f941h = i;
        this.f946m = false;
    }

    public void m1044a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f932M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_PROCESS_RSP_FAIL /*-3*/:
                this.f954u = charSequence;
                this.f955v = message;
            case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                this.f951r = charSequence;
                this.f952s = message;
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                this.f948o = charSequence;
                this.f949p = message;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m1045a(Drawable drawable) {
        this.f958y = drawable;
        this.f957x = 0;
        if (this.f959z == null) {
            return;
        }
        if (drawable != null) {
            this.f959z.setVisibility(0);
            this.f959z.setImageDrawable(drawable);
            return;
        }
        this.f959z.setVisibility(8);
    }

    public void m1046a(View view, int i, int i2, int i3, int i4) {
        this.f940g = view;
        this.f941h = 0;
        this.f946m = true;
        this.f942i = i;
        this.f943j = i2;
        this.f944k = i3;
        this.f945l = i4;
    }

    public void m1047a(CharSequence charSequence) {
        this.f937d = charSequence;
        if (this.f920A != null) {
            this.f920A.setText(charSequence);
        }
    }

    public boolean m1048a(int i, KeyEvent keyEvent) {
        return this.f956w != null && this.f956w.executeKeyEvent(keyEvent);
    }

    public void m1049b(int i) {
        this.f958y = null;
        this.f957x = i;
        if (this.f959z == null) {
            return;
        }
        if (i != 0) {
            this.f959z.setVisibility(0);
            this.f959z.setImageResource(this.f957x);
            return;
        }
        this.f959z.setVisibility(8);
    }

    public void m1050b(View view) {
        this.f922C = view;
    }

    public void m1051b(CharSequence charSequence) {
        this.f938e = charSequence;
        if (this.f921B != null) {
            this.f921B.setText(charSequence);
        }
    }

    public boolean m1052b(int i, KeyEvent keyEvent) {
        return this.f956w != null && this.f956w.executeKeyEvent(keyEvent);
    }

    public int m1053c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f934a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void m1054c(View view) {
        this.f940g = view;
        this.f941h = 0;
        this.f946m = false;
    }
}
