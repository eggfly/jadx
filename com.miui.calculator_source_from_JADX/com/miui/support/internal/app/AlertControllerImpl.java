package com.miui.support.internal.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.miui.support.C0234R;
import com.miui.support.app.ActionBar;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.AlertControllerWrapper.AlertParams.ActionItem;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.internal.view.menu.MenuBuilder.Callback;
import com.miui.support.internal.view.menu.MenuPresenter;
import com.miui.support.internal.widget.ActionBarContainer;
import com.miui.support.internal.widget.ActionBarContextView;
import com.miui.support.internal.widget.ActionBarView;
import com.miui.support.widget.EditableListViewWrapper;
import com.miui.support.widget.ProgressBar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class AlertControllerImpl implements Callback {
    private CharSequence f2180A;
    private Message f2181B;
    private Button f2182C;
    private CharSequence f2183D;
    private Message f2184E;
    private Handler f2185F;
    private ScrollView f2186G;
    private DialogInterface f2187H;
    private ListAdapter f2188I;
    private Context f2189J;
    private ActionBar f2190K;
    private ActionBarView f2191L;
    private OnClickListener f2192M;
    private int f2193N;
    private boolean[] f2194O;
    private MenuBuilder f2195P;
    private boolean f2196Q;
    private final Runnable f2197R;
    private MenuPresenter.Callback f2198S;
    private Window.Callback f2199T;
    private final int f2200a;
    private final int f2201b;
    private final int f2202c;
    private final int f2203d;
    private final int f2204e;
    private final Window f2205f;
    private ViewGroup f2206g;
    private Drawable f2207h;
    private int f2208i;
    private CharSequence f2209j;
    private CharSequence f2210k;
    private ListView f2211l;
    private EditableListViewWrapper f2212m;
    private TextView f2213n;
    private TextView f2214o;
    private View f2215p;
    private View f2216q;
    private boolean f2217r;
    private CharSequence f2218s;
    private ArrayList<ActionItem> f2219t;
    private DialogInterface.OnClickListener f2220u;
    private Button f2221v;
    private Button f2222w;
    private CharSequence f2223x;
    private Message f2224y;
    private Button f2225z;

    /* renamed from: com.miui.support.internal.app.AlertControllerImpl.1 */
    class C02721 implements OnClickListener {
        final /* synthetic */ AlertControllerImpl f2170a;

        C02721(AlertControllerImpl alertControllerImpl) {
            this.f2170a = alertControllerImpl;
        }

        public void onClick(View view) {
            Message message = null;
            if (view == this.f2170a.f2222w && this.f2170a.f2224y != null) {
                message = Message.obtain(this.f2170a.f2224y);
            } else if (view == this.f2170a.f2225z && this.f2170a.f2181B != null) {
                message = Message.obtain(this.f2170a.f2181B);
            } else if (view == this.f2170a.f2182C && this.f2170a.f2184E != null) {
                message = Message.obtain(this.f2170a.f2184E);
            }
            if (message != null) {
                message.sendToTarget();
            }
            this.f2170a.f2185F.obtainMessage(1, this.f2170a.f2187H).sendToTarget();
        }
    }

    /* renamed from: com.miui.support.internal.app.AlertControllerImpl.2 */
    class C02732 implements Runnable {
        final /* synthetic */ AlertControllerImpl f2171a;

        C02732(AlertControllerImpl alertControllerImpl) {
            this.f2171a = alertControllerImpl;
        }

        public void run() {
            MenuBuilder b = this.f2171a.m3766b();
            if (this.f2171a.m3737b(b) && this.f2171a.m3742d(b)) {
                this.f2171a.m3729a(b);
            } else {
                this.f2171a.m3729a(null);
            }
        }
    }

    /* renamed from: com.miui.support.internal.app.AlertControllerImpl.3 */
    class C02743 implements OnClickListener {
        final /* synthetic */ AlertControllerImpl f2172a;

        C02743(AlertControllerImpl alertControllerImpl) {
            this.f2172a = alertControllerImpl;
        }

        public void onClick(View view) {
            this.f2172a.f2187H.dismiss();
        }
    }

    /* renamed from: com.miui.support.internal.app.AlertControllerImpl.4 */
    class C02754 implements OnClickListener {
        final /* synthetic */ Button f2173a;
        final /* synthetic */ AlertControllerImpl f2174b;

        C02754(AlertControllerImpl alertControllerImpl, Button button) {
            this.f2174b = alertControllerImpl;
            this.f2173a = button;
        }

        public void onClick(View view) {
            boolean a = this.f2174b.f2212m.m5865a();
            this.f2174b.f2212m.m5864a(!a);
            this.f2173a.setText(a ? C0234R.string.select_all : C0234R.string.deselect_all);
        }
    }

    /* renamed from: com.miui.support.internal.app.AlertControllerImpl.5 */
    class C02765 implements OnItemClickListener {
        final /* synthetic */ OnItemClickListener f2175a;
        final /* synthetic */ AlertControllerImpl f2176b;

        C02765(AlertControllerImpl alertControllerImpl, OnItemClickListener onItemClickListener) {
            this.f2176b = alertControllerImpl;
            this.f2175a = onItemClickListener;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f2175a.onItemClick(adapterView, view, i, j);
            this.f2176b.f2221v.setText(this.f2176b.f2212m.m5865a() ? C0234R.string.deselect_all : C0234R.string.select_all);
        }
    }

    /* renamed from: com.miui.support.internal.app.AlertControllerImpl.6 */
    class C02776 implements MenuPresenter.Callback {
        final /* synthetic */ AlertControllerImpl f2177a;

        C02776(AlertControllerImpl alertControllerImpl) {
            this.f2177a = alertControllerImpl;
        }

        public void m3724b(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean m3725b(MenuBuilder menuBuilder) {
            return false;
        }
    }

    /* renamed from: com.miui.support.internal.app.AlertControllerImpl.7 */
    class C02787 implements Window.Callback {
        final /* synthetic */ AlertControllerImpl f2178a;

        C02787(AlertControllerImpl alertControllerImpl) {
            this.f2178a = alertControllerImpl;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return false;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return false;
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public View onCreatePanelView(int i) {
            return null;
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            return false;
        }

        public boolean onMenuItemSelected(int i, MenuItem menuItem) {
            return false;
        }

        public void onWindowAttributesChanged(LayoutParams layoutParams) {
        }

        public void onContentChanged() {
        }

        public void onWindowFocusChanged(boolean z) {
        }

        public void onAttachedToWindow() {
        }

        public void onDetachedFromWindow() {
        }

        public void onPanelClosed(int i, Menu menu) {
        }

        public boolean onSearchRequested() {
            return false;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public void onActionModeStarted(ActionMode actionMode) {
        }

        public void onActionModeFinished(ActionMode actionMode) {
        }
    }

    private static final class ButtonHandler extends Handler {
        private WeakReference<DialogInterface> f2179a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f2179a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f2179a.get(), message.what);
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    ((DialogInterface) message.obj).dismiss();
                default:
            }
        }
    }

    public AlertControllerImpl(Context context, DialogInterface dialogInterface, Window window) {
        this.f2208i = 0;
        this.f2192M = new C02721(this);
        this.f2193N = -1;
        this.f2197R = new C02732(this);
        this.f2198S = new C02776(this);
        this.f2199T = new C02787(this);
        this.f2189J = context;
        this.f2187H = dialogInterface;
        this.f2205f = window;
        this.f2185F = new ButtonHandler(dialogInterface);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0264R.styleable.AlertDialog, 16842845, 0);
        this.f2204e = obtainStyledAttributes.getResourceId(C0264R.styleable.AlertDialog_layout, C0264R.layout.alert_dialog);
        this.f2200a = obtainStyledAttributes.getResourceId(C0264R.styleable.AlertDialog_listLayout, C0264R.layout.select_dialog);
        this.f2201b = obtainStyledAttributes.getResourceId(C0264R.styleable.AlertDialog_multiChoiceItemLayout, C0264R.layout.select_dialog_multichoice);
        this.f2202c = obtainStyledAttributes.getResourceId(C0264R.styleable.AlertDialog_singleChoiceItemLayout, C0234R.layout.select_dialog_singlechoice);
        this.f2203d = obtainStyledAttributes.getResourceId(C0264R.styleable.AlertDialog_listItemLayout, C0264R.layout.select_dialog_item);
        obtainStyledAttributes.recycle();
    }

    static boolean m3730a(View view) {
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
            if (m3730a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void m3753a() {
        this.f2205f.requestFeature(1);
        if (this.f2216q == null || !m3730a(this.f2216q)) {
            this.f2205f.setFlags(131072, 131072);
        }
        m3749l();
        this.f2206g = (ViewGroup) this.f2205f.findViewById(C0264R.id.parentPanel);
        m3750m();
    }

    private void m3749l() {
        if (this.f2219t != null) {
            View inflate = View.inflate(this.f2189J, C0264R.layout.screen_action_bar, null);
            this.f2191L = (ActionBarView) inflate.findViewById(C0264R.id.action_bar);
            this.f2191L.setWindowCallback(this.f2199T);
            ActionBarContainer actionBarContainer = (ActionBarContainer) inflate.findViewById(C0264R.id.split_action_bar);
            if (actionBarContainer != null) {
                this.f2191L.setSplitView(actionBarContainer);
                this.f2191L.setSplitActionBar(true);
                this.f2191L.setSplitWhenNarrow(true);
                ActionBarContextView actionBarContextView = (ActionBarContextView) inflate.findViewById(C0264R.id.action_context_bar);
                actionBarContextView.setSplitView(actionBarContainer);
                actionBarContextView.setSplitActionBar(true);
                actionBarContextView.setSplitWhenNarrow(true);
            }
            View.inflate(this.f2189J, this.f2204e, (ViewGroup) inflate.findViewById(16908290));
            this.f2205f.setContentView(inflate);
            this.f2205f.getDecorView().post(this.f2197R);
            this.f2190K = new ActionBarImpl((Dialog) this.f2187H);
            this.f2190K.setDisplayOptions(0);
            this.f2191L.setCollapsable(true);
            return;
        }
        this.f2205f.setContentView(this.f2204e);
        if (!DeviceHelper.f2555g) {
            this.f2205f.setGravity(80);
            this.f2205f.setLayout(-1, -2);
        }
    }

    private void m3729a(MenuBuilder menuBuilder) {
        if (menuBuilder != this.f2195P) {
            this.f2195P = menuBuilder;
            if (this.f2191L != null) {
                this.f2191L.m4750a((Menu) menuBuilder, this.f2198S);
            }
        }
    }

    MenuBuilder m3766b() {
        MenuBuilder menuBuilder = new MenuBuilder(this.f2189J);
        menuBuilder.m4420a((Callback) this);
        return menuBuilder;
    }

    private boolean m3737b(MenuBuilder menuBuilder) {
        Iterator it = this.f2219t.iterator();
        while (it.hasNext()) {
            ActionItem actionItem = (ActionItem) it.next();
            menuBuilder.add(0, actionItem.id, 0, actionItem.label).setIcon(actionItem.icon).setShowAsAction(2);
        }
        return true;
    }

    private boolean m3742d(MenuBuilder menuBuilder) {
        return true;
    }

    public boolean m3764a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f2220u != null) {
            this.f2220u.onClick(this.f2187H, menuItem.getItemId());
        }
        return true;
    }

    public void m3773c(MenuBuilder menuBuilder) {
    }

    public void m3756a(Drawable drawable) {
        this.f2207h = drawable;
        this.f2208i = 0;
    }

    public void m3754a(int i) {
        this.f2208i = i;
        this.f2207h = null;
    }

    public void m3759a(CharSequence charSequence) {
        this.f2209j = charSequence;
        if (this.f2213n != null) {
            this.f2213n.setText(charSequence);
        }
    }

    public void m3767b(View view) {
        this.f2215p = view;
    }

    public void m3768b(CharSequence charSequence) {
        this.f2210k = charSequence;
        if (this.f2214o != null) {
            this.f2214o.setText(charSequence);
        }
    }

    public void m3772c(View view) {
        this.f2216q = view;
    }

    public void m3761a(boolean z, CharSequence charSequence) {
        this.f2217r = z;
        this.f2218s = charSequence;
    }

    public void m3755a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f2185F.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f2183D = charSequence;
                this.f2184E = message;
            case -2:
                this.f2180A = charSequence;
                this.f2181B = message;
            case -1:
                this.f2223x = charSequence;
                this.f2224y = message;
            default:
                throw new IllegalStateException("Button does not exist");
        }
    }

    public void m3760a(ArrayList<ActionItem> arrayList, DialogInterface.OnClickListener onClickListener) {
        this.f2219t = arrayList;
        this.f2220u = onClickListener;
    }

    public ListView m3770c() {
        return this.f2211l;
    }

    public void m3758a(ListView listView) {
        this.f2211l = listView;
    }

    public int m3774d() {
        return this.f2200a;
    }

    public int m3775e() {
        return this.f2203d;
    }

    public int m3776f() {
        return this.f2202c;
    }

    public int m3777g() {
        return this.f2201b;
    }

    public TextView m3778h() {
        return this.f2214o;
    }

    public void m3762a(boolean[] zArr) {
        this.f2194O = zArr;
    }

    public boolean[] m3779i() {
        return this.f2194O;
    }

    public boolean m3780j() {
        boolean isChecked = ((CheckBox) this.f2206g.findViewById(16908289)).isChecked();
        this.f2217r = isChecked;
        return isChecked;
    }

    public DialogInterface m3781k() {
        return this.f2187H;
    }

    public Button m3765b(int i) {
        switch (i) {
            case -3:
                return this.f2182C;
            case -2:
                return this.f2225z;
            case -1:
                return this.f2222w;
            default:
                return null;
        }
    }

    public void m3757a(ListAdapter listAdapter) {
        this.f2188I = listAdapter;
    }

    public void m3771c(int i) {
        this.f2193N = i;
    }

    public boolean m3763a(int i, KeyEvent keyEvent) {
        return this.f2186G != null && this.f2186G.executeKeyEvent(keyEvent);
    }

    public boolean m3769b(int i, KeyEvent keyEvent) {
        return this.f2186G != null && this.f2186G.executeKeyEvent(keyEvent);
    }

    private void m3750m() {
        ViewGroup viewGroup = (ViewGroup) this.f2206g.findViewById(C0264R.id.topPanel);
        if (viewGroup != null) {
            m3727a(viewGroup);
        }
        viewGroup = (ViewGroup) this.f2206g.findViewById(C0264R.id.contentPanel);
        if (viewGroup != null) {
            m3734b(viewGroup);
        }
        FrameLayout frameLayout = (FrameLayout) this.f2206g.findViewById(C0234R.id.customPanel);
        if (frameLayout != null) {
            m3728a(frameLayout);
        }
        frameLayout = (FrameLayout) this.f2206g.findViewById(C0264R.id.checkboxPanel);
        if (frameLayout != null) {
            m3735b(frameLayout);
        }
        viewGroup = (ViewGroup) this.f2206g.findViewById(C0264R.id.buttonPanel);
        if (viewGroup != null) {
            m3739c(viewGroup);
        }
    }

    private void m3727a(ViewGroup viewGroup) {
        if (this.f2215p != null) {
            viewGroup.addView(this.f2215p, 0, new LinearLayout.LayoutParams(-1, -2));
            int dimensionPixelSize = this.f2189J.getResources().getDimensionPixelSize(C0264R.dimen.dialog_title_vertical_padding);
            if (this.f2215p.getPaddingTop() != 0) {
                dimensionPixelSize = this.f2215p.getPaddingTop();
            }
            int dimensionPixelSize2 = this.f2189J.getResources().getDimensionPixelSize(C0264R.dimen.dialog_title_horizontal_padding);
            int paddingLeft = this.f2215p.getPaddingLeft() != 0 ? this.f2215p.getPaddingLeft() : dimensionPixelSize2;
            if (this.f2215p.getPaddingRight() != 0) {
                dimensionPixelSize2 = this.f2215p.getPaddingRight();
            }
            this.f2215p.setPadding(paddingLeft, dimensionPixelSize, dimensionPixelSize2, 0);
            viewGroup.removeView(this.f2206g.findViewById(C0264R.id.alertTitle));
            return;
        }
        if ((!TextUtils.isEmpty(this.f2209j) ? 1 : 0) != 0) {
            this.f2213n = (TextView) viewGroup.findViewById(C0264R.id.alertTitle);
            this.f2213n.setText(this.f2209j);
            if (this.f2207h != null) {
                this.f2213n.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f2207h, null, null, null);
            }
            if (this.f2208i != 0) {
                this.f2213n.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f2208i, 0, 0, 0);
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m3734b(ViewGroup viewGroup) {
        this.f2186G = (ScrollView) this.f2206g.findViewById(C0264R.id.scrollView);
        this.f2186G.setFocusable(false);
        this.f2214o = (TextView) this.f2206g.findViewById(C0234R.id.message);
        if (this.f2214o != null) {
            if (this.f2210k != null) {
                this.f2214o.setText(this.f2210k);
                View findViewById = this.f2206g.findViewById(C0264R.id.topPanel);
                if (findViewById != null && findViewById.getVisibility() == 8) {
                    viewGroup.setPadding(viewGroup.getPaddingLeft(), this.f2189J.getResources().getDimensionPixelSize(C0264R.dimen.dialog_message_without_title_vertical_padding), viewGroup.getRight(), viewGroup.getPaddingBottom());
                    return;
                }
                return;
            }
            this.f2214o.setVisibility(8);
            this.f2186G.removeView(this.f2214o);
            if (this.f2211l != null) {
                m3751n();
                viewGroup.removeView(this.f2186G);
                viewGroup.addView(this.f2211l, new LinearLayout.LayoutParams(-1, -1));
                viewGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
                viewGroup.setPadding(0, 0, 0, 0);
                m3752o();
                if (DeviceHelper.f2555g && this.f2215p == null && this.f2213n != null) {
                    this.f2213n.setPadding(0, 0, 0, 0);
                    try {
                        this.f2206g.findViewById(C0264R.id.topPanel).setBackground(this.f2189J.getResources().getDrawable(C0264R.drawable.dialog_title_bg_light));
                    } catch (NotFoundException e) {
                    }
                    viewGroup.setPadding(viewGroup.getPaddingLeft(), 0, viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
                    return;
                }
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void m3751n() {
        int choiceMode = this.f2211l.getChoiceMode();
        if (this.f2188I != null) {
            if (choiceMode == 2) {
                Button button = (Button) this.f2206g.findViewById(C0264R.id.cancel);
                if (button != null) {
                    button.setOnClickListener(new C02743(this));
                }
                button = (Button) this.f2206g.findViewById(C0264R.id.select);
                if (button != null) {
                    this.f2221v = button;
                    button.setOnClickListener(new C02754(this, button));
                }
                if (this.f2221v != null) {
                    this.f2212m = new EditableListViewWrapper(this.f2211l);
                    this.f2211l.setChoiceMode(choiceMode);
                    this.f2212m.m5863a(this.f2188I);
                    this.f2211l.setOnItemClickListener(new C02765(this, this.f2211l.getOnItemClickListener()));
                    if (this.f2194O != null) {
                        for (int i = 0; i < this.f2194O.length; i++) {
                            this.f2212m.m5860a(i, this.f2194O[i]);
                        }
                    }
                    this.f2221v.setText(this.f2212m.m5865a() ? C0234R.string.deselect_all : C0234R.string.select_all);
                } else {
                    this.f2211l.setAdapter(this.f2188I);
                }
            } else {
                this.f2211l.setAdapter(this.f2188I);
            }
        }
        if (this.f2193N > -1) {
            this.f2211l.setItemChecked(this.f2193N, true);
            this.f2211l.setSelection(this.f2193N);
        }
    }

    private void m3728a(FrameLayout frameLayout) {
        if (this.f2216q != null) {
            ((FrameLayout) this.f2206g.findViewById(16908331)).addView(this.f2216q, new ViewGroup.LayoutParams(-1, -1));
            if (this.f2211l != null) {
                ((LinearLayout.LayoutParams) frameLayout.getLayoutParams()).weight = 0.0f;
            }
            if (this.f2216q instanceof ViewGroup) {
                int paddingLeft;
                ViewGroup viewGroup = (ViewGroup) this.f2216q;
                int dimensionPixelSize = this.f2189J.getResources().getDimensionPixelSize(C0264R.dimen.dialog_custom_vertical_padding);
                if (viewGroup.getPaddingTop() != 0) {
                    dimensionPixelSize = viewGroup.getPaddingTop();
                }
                this.f2196Q = viewGroup.getPaddingBottom() != 0;
                int dimensionPixelSize2 = this.f2189J.getResources().getDimensionPixelSize(C0264R.dimen.dialog_custom_horizontal_padding);
                if (viewGroup.getPaddingLeft() != 0) {
                    paddingLeft = viewGroup.getPaddingLeft();
                } else {
                    paddingLeft = dimensionPixelSize2;
                }
                if (viewGroup.getPaddingRight() != 0) {
                    dimensionPixelSize2 = viewGroup.getPaddingRight();
                }
                View findViewById = viewGroup.findViewById(16908301);
                if (findViewById != null && !(findViewById instanceof ProgressBar)) {
                    frameLayout.setPadding(0, 0, 0, 0);
                    this.f2196Q = true;
                    return;
                } else if (viewGroup.findViewById(C0264R.id.datePicker) == null && viewGroup.findViewById(C0264R.id.timePicker) == null && viewGroup.findViewById(C0264R.id.dateTimePicker) == null) {
                    frameLayout.setPadding(paddingLeft, dimensionPixelSize, dimensionPixelSize2, viewGroup.getPaddingBottom());
                    viewGroup.setPadding(0, 0, 0, 0);
                    return;
                } else {
                    frameLayout.setPadding(0, 0, 0, 0);
                    m3752o();
                    this.f2196Q = true;
                    return;
                }
            }
            return;
        }
        frameLayout.setVisibility(8);
    }

    private void m3752o() {
        if (this.f2213n != null) {
            int dimensionPixelSize = this.f2189J.getResources().getDimensionPixelSize(C0264R.dimen.dialog_title_average_vertical_padding);
            this.f2213n.setPadding(this.f2213n.getPaddingLeft(), dimensionPixelSize, this.f2213n.getPaddingRight(), dimensionPixelSize);
        }
    }

    private void m3735b(FrameLayout frameLayout) {
        if (this.f2218s != null) {
            frameLayout.setVisibility(0);
            CheckBox checkBox = (CheckBox) frameLayout.findViewById(16908289);
            checkBox.setChecked(this.f2217r);
            checkBox.setText(this.f2218s);
            return;
        }
        frameLayout.setVisibility(8);
    }

    private void m3739c(ViewGroup viewGroup) {
        int i;
        boolean z;
        int i2;
        this.f2222w = (Button) viewGroup.findViewById(16908313);
        if (this.f2222w != null) {
            this.f2222w.setOnClickListener(this.f2192M);
            if (TextUtils.isEmpty(this.f2223x)) {
                this.f2222w.setVisibility(8);
                i = 0;
                z = false;
                i2 = 0;
            } else {
                this.f2222w.setText(this.f2223x);
                this.f2222w.setVisibility(0);
                i = 1;
                z = m3731a(this.f2222w);
                i2 = 1;
            }
        } else {
            i = 0;
            z = false;
            i2 = 0;
        }
        this.f2225z = (Button) viewGroup.findViewById(16908314);
        if (this.f2225z != null) {
            this.f2225z.setOnClickListener(this.f2192M);
            if (TextUtils.isEmpty(this.f2180A)) {
                this.f2225z.setVisibility(8);
            } else {
                this.f2225z.setText(this.f2180A);
                this.f2225z.setVisibility(0);
                z = m3731a(this.f2225z);
                i++;
                i2 = 1;
            }
        }
        this.f2182C = (Button) viewGroup.findViewById(16908315);
        if (this.f2182C != null) {
            this.f2182C.setOnClickListener(this.f2192M);
            if (TextUtils.isEmpty(this.f2183D)) {
                this.f2182C.setVisibility(8);
            } else {
                this.f2182C.setText(this.f2183D);
                this.f2182C.setVisibility(0);
                z = m3731a(this.f2182C);
                i++;
                i2 = 1;
            }
        }
        if (i2 != 0) {
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(C0264R.id.buttonGroup);
            if (z || r1 > 2) {
                ViewGroup.LayoutParams layoutParams;
                linearLayout.setOrientation(1);
                linearLayout.removeAllViews();
                if (this.f2222w != null) {
                    layoutParams = this.f2222w.getLayoutParams();
                    layoutParams.width = -1;
                    linearLayout.addView(this.f2222w, layoutParams);
                }
                if (this.f2182C != null) {
                    layoutParams = this.f2182C.getLayoutParams();
                    layoutParams.width = -1;
                    linearLayout.addView(this.f2182C, layoutParams);
                }
                if (this.f2225z != null) {
                    layoutParams = this.f2225z.getLayoutParams();
                    layoutParams.width = -1;
                    linearLayout.addView(this.f2225z, layoutParams);
                }
            }
            if (this.f2196Q || this.f2211l != null || this.f2218s != null) {
                linearLayout.setPadding(linearLayout.getPaddingLeft(), 0, linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private boolean m3731a(TextView textView) {
        Layout layout = textView.getLayout();
        if (layout == null || layout.getLineCount() <= 0 || layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
            return false;
        }
        return true;
    }
}
