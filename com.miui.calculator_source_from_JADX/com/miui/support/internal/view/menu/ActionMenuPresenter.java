package com.miui.support.internal.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.view.ActionBarPolicy;
import com.miui.support.internal.view.menu.ActionMenuView.ActionMenuChildView;
import com.miui.support.internal.view.menu.MenuBuilder.ItemInvoker;
import com.miui.support.internal.view.menu.MenuPresenter.Callback;
import com.miui.support.internal.view.menu.MenuView.ItemView;
import java.util.ArrayList;

public class ActionMenuPresenter extends BaseMenuPresenter {
    private ActionButtonSubMenu f2644A;
    private OpenOverflowRunnable f2645B;
    final PopupPresenterCallback f2646a;
    int f2647b;
    private View f2648i;
    private boolean f2649j;
    private boolean f2650k;
    private int f2651l;
    private int f2652m;
    private int f2653n;
    private int f2654o;
    private int f2655p;
    private boolean f2656q;
    private boolean f2657r;
    private boolean f2658s;
    private boolean f2659t;
    private int f2660u;
    private final SparseBooleanArray f2661v;
    private View f2662w;
    private OverflowMenu f2663x;
    private OverflowMenu f2664y;
    private MenuItemImpl f2665z;

    private class ActionButtonSubMenu extends MenuDialogHelper {
        final /* synthetic */ ActionMenuPresenter f2610a;

        public ActionButtonSubMenu(ActionMenuPresenter actionMenuPresenter, SubMenuBuilder subMenuBuilder) {
            this.f2610a = actionMenuPresenter;
            super(subMenuBuilder);
            actionMenuPresenter.m4348a(actionMenuPresenter.f2646a);
        }

        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            this.f2610a.f2644A = null;
            this.f2610a.f2647b = 0;
        }
    }

    private interface OverflowMenu {
        void m4298a(boolean z);

        boolean m4299a();

        void m4300b(MenuBuilder menuBuilder);

        boolean m4301b();
    }

    private class ListOverflowMenu implements OverflowMenu {
        final /* synthetic */ ActionMenuPresenter f2611a;
        private ListMenuPresenter f2612b;

        private ListOverflowMenu(ActionMenuPresenter actionMenuPresenter) {
            this.f2611a = actionMenuPresenter;
        }

        private ListMenuPresenter m4302c(MenuBuilder menuBuilder) {
            if (this.f2612b == null) {
                this.f2612b = new ListMenuPresenter(this.f2611a.d, this.f2611a.f2655p, this.f2611a.f2654o);
            }
            menuBuilder.m4422a(this.f2612b);
            return this.f2612b;
        }

        public View m4303a(MenuBuilder menuBuilder) {
            return (menuBuilder == null || menuBuilder.m4445j().size() <= 0) ? null : (View) m4302c(menuBuilder).m4474a((ViewGroup) this.f2611a.h);
        }

        public boolean m4305a() {
            return ((PhoneActionMenuView) this.f2611a.h).m4548d();
        }

        public boolean m4307b() {
            return ((PhoneActionMenuView) this.f2611a.h).m4549e();
        }

        public void m4304a(boolean z) {
            ((PhoneActionMenuView) this.f2611a.h).m4550f();
        }

        public void m4306b(MenuBuilder menuBuilder) {
            ((PhoneActionMenuView) this.f2611a.h).setOverflowMenuView(m4303a(menuBuilder));
        }
    }

    private class OpenOverflowRunnable implements Runnable {
        final /* synthetic */ ActionMenuPresenter f2613a;
        private OverflowMenu f2614b;

        public OpenOverflowRunnable(ActionMenuPresenter actionMenuPresenter, OverflowMenu overflowMenu) {
            this.f2613a = actionMenuPresenter;
            this.f2614b = overflowMenu;
        }

        public void run() {
            this.f2613a.e.m4440e();
            View view = (View) this.f2613a.h;
            if (!(view == null || view.getWindowToken() == null || !this.f2614b.m4299a())) {
                this.f2613a.f2663x = this.f2614b;
            }
            this.f2613a.f2645B = null;
        }
    }

    private class OverflowMenuButton extends Button implements ActionMenuChildView {
        final /* synthetic */ ActionMenuPresenter f2615a;

        public OverflowMenuButton(ActionMenuPresenter actionMenuPresenter, Context context) {
            this.f2615a = actionMenuPresenter;
            super(context, null, actionMenuPresenter.f2660u);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
        }

        private boolean m4308a() {
            View view;
            while (view != null && view.getVisibility() == 0) {
                View view2;
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    view2 = (ViewGroup) parent;
                } else {
                    view2 = null;
                }
                view = view2;
            }
            return view == null;
        }

        public boolean performClick() {
            if (!super.performClick() && m4308a()) {
                if (this.f2615a.e != null) {
                    this.f2615a.e.m4427a(this.f2615a.e.m4449n(), this.f2615a.m4366g());
                }
                playSoundEffect(0);
                if (isSelected()) {
                    this.f2615a.m4386e(true);
                } else {
                    this.f2615a.m4376a();
                }
            }
            return true;
        }
    }

    private class PopupOverflowMenu extends MenuPopupHelper implements OverflowMenu {
        final /* synthetic */ ActionMenuPresenter f2631a;

        public PopupOverflowMenu(ActionMenuPresenter actionMenuPresenter, Context context, MenuBuilder menuBuilder, View view, boolean z) {
            this.f2631a = actionMenuPresenter;
            super(context, menuBuilder, view, z);
            m4324a(actionMenuPresenter.f2646a);
            m4321a(C0264R.layout.overflow_popup_menu_item_layout);
        }

        public void onDismiss() {
            super.onDismiss();
            this.f2631a.e.close();
            this.f2631a.f2663x = null;
        }

        public void m4336b(MenuBuilder menuBuilder) {
        }

        public void m4335a(boolean z) {
            super.m4325a(z);
            if (this.f2631a.f2648i != null) {
                this.f2631a.f2648i.setSelected(false);
            }
        }
    }

    private class PopupPresenterCallback implements Callback {
        final /* synthetic */ ActionMenuPresenter f2632a;

        private PopupPresenterCallback(ActionMenuPresenter actionMenuPresenter) {
            this.f2632a = actionMenuPresenter;
        }

        public boolean m4338b(MenuBuilder menuBuilder) {
            if (menuBuilder != null) {
                this.f2632a.f2647b = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            }
            return false;
        }

        public void m4337b(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.m4449n().m4424a(false);
            }
        }
    }

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        public int f2633a;

        /* renamed from: com.miui.support.internal.view.menu.ActionMenuPresenter.SavedState.1 */
        final class C03601 implements Creator<SavedState> {
            C03601() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4339a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4340a(i);
            }

            public SavedState m4339a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m4340a(int i) {
                return new SavedState[i];
            }
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f2633a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2633a);
        }

        static {
            CREATOR = new C03601();
        }
    }

    public ActionMenuPresenter(Context context, int i, int i2, int i3, int i4) {
        super(context, i, i2);
        this.f2660u = 16843510;
        this.f2661v = new SparseBooleanArray();
        this.f2646a = new PopupPresenterCallback();
        this.f2655p = i3;
        this.f2654o = i4;
    }

    public void m4371a(Context context, MenuBuilder menuBuilder) {
        super.m4344a(context, menuBuilder);
        context.getResources();
        ActionBarPolicy a = ActionBarPolicy.m4264a(context);
        if (!this.f2650k) {
            this.f2649j = a.m4266b();
        }
        if (!this.f2658s) {
            this.f2651l = a.m4267c();
        }
        if (!this.f2656q) {
            this.f2653n = a.m4265a();
        }
        int i = this.f2651l;
        if (this.f2649j) {
            if (this.f2648i == null) {
                this.f2648i = m4367a(this.c);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f2648i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2648i.getMeasuredWidth();
        } else {
            this.f2648i = null;
        }
        this.f2652m = i;
        this.f2662w = null;
    }

    public void m4372a(Configuration configuration) {
        if (!this.f2656q) {
            this.f2653n = this.d.getResources().getInteger(C0264R.integer.abc_max_action_buttons);
        }
        if (this.e != null) {
            this.e.m4431b(true);
        }
    }

    public void m4370a(int i, boolean z) {
        this.f2651l = i;
        this.f2657r = z;
        this.f2658s = true;
    }

    public void m4375a(boolean z) {
        this.f2649j = z;
        this.f2650k = true;
    }

    public void m4379b(boolean z) {
        this.f2659t = z;
    }

    public void m4381c(boolean z) {
        if (z) {
            this.f2660u = C0264R.attr.actionModeOverflowButtonStyle;
        }
    }

    public MenuView m4369a(ViewGroup viewGroup) {
        MenuView a = super.m4342a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View m4368a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.m4503l()) {
            if (!(view instanceof ActionMenuItemView)) {
                view = null;
            }
            actionView = super.m4341a(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m4396a(layoutParams));
        }
        return actionView;
    }

    public void m4374a(MenuItemImpl menuItemImpl, ItemView itemView) {
        itemView.m4289a(menuItemImpl, 0);
        itemView.setItemInvoker((ItemInvoker) this.h);
    }

    public boolean m4377a(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.m4499h();
    }

    public void m4383d(boolean z) {
        int i = 1;
        int i2 = 0;
        super.m4354d(z);
        if (this.h != null) {
            ArrayList j = this.e != null ? this.e.m4445j() : null;
            if (this.f2649j && j != null) {
                int size = j.size();
                if (size == 1) {
                    int i3;
                    if (((MenuItemImpl) j.get(0)).isActionViewExpanded()) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    i2 = i3;
                } else {
                    if (size <= 0) {
                        i = 0;
                    }
                    i2 = i;
                }
            }
            if (i2 != 0) {
                if (this.f2648i == null) {
                    this.f2648i = m4367a(this.c);
                } else {
                    this.f2648i.setTranslationY(0.0f);
                }
                ViewGroup viewGroup = (ViewGroup) this.f2648i.getParent();
                if (viewGroup != this.h) {
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f2648i);
                    }
                    ActionMenuView actionMenuView = (ActionMenuView) this.h;
                    actionMenuView.addView(this.f2648i, actionMenuView.m4402b());
                }
            } else if (this.f2648i != null && this.f2648i.getParent() == this.h) {
                ((ViewGroup) this.h).removeView(this.f2648i);
            }
            ((ActionMenuView) this.h).setOverflowReserved(this.f2649j);
            if (!DeviceHelper.f2555g) {
                m4365f().m4300b(this.e);
            }
        }
    }

    public boolean m4378a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.m4589q() != this.e) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.m4589q();
        }
        if (m4357a(subMenuBuilder2.getItem()) == null) {
            if (this.f2648i == null) {
                return false;
            }
            View view = this.f2648i;
        }
        this.f2647b = subMenuBuilder.getItem().getItemId();
        this.f2644A = new ActionButtonSubMenu(this, subMenuBuilder);
        this.f2644A.m4294a(null);
        super.m4351a(subMenuBuilder);
        return true;
    }

    private View m4357a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.h;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ItemView) && ((ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean m4376a() {
        if (!this.f2649j || m4382c() || this.e == null || this.h == null || this.f2645B != null) {
            return false;
        }
        this.f2645B = new OpenOverflowRunnable(this, m4365f());
        ((View) this.h).post(this.f2645B);
        super.m4351a(null);
        this.f2648i.setSelected(true);
        return true;
    }

    private OverflowMenu m4365f() {
        if (DeviceHelper.f2555g) {
            return new PopupOverflowMenu(this, this.d, this.e, this.f2648i, true);
        }
        if (this.f2664y == null) {
            this.f2664y = new ListOverflowMenu();
        }
        return this.f2664y;
    }

    private MenuItemImpl m4366g() {
        if (this.f2665z == null) {
            this.f2665z = new MenuItemImpl(this.e, 0, C0264R.id.more, 0, 0, this.d.getString(C0264R.string.more), 0);
        }
        return this.f2665z;
    }

    public boolean m4386e(boolean z) {
        if (this.f2645B != null && this.h != null) {
            this.f2648i.setSelected(false);
            ((View) this.h).removeCallbacks(this.f2645B);
            this.f2645B = null;
            return true;
        } else if (this.f2663x == null) {
            return false;
        } else {
            boolean b = this.f2663x.m4301b();
            if (b) {
                this.f2648i.setSelected(false);
            }
            this.f2663x.m4298a(z);
            return b;
        }
    }

    public boolean m4387f(boolean z) {
        return m4386e(z);
    }

    public boolean m4380b() {
        if (this.f2644A == null) {
            return false;
        }
        this.f2644A.m4293a();
        return true;
    }

    public boolean m4382c() {
        return this.f2663x != null && this.f2663x.m4301b();
    }

    public boolean m4384d() {
        return this.f2649j;
    }

    public boolean m4385e() {
        ArrayList h = this.e.m4443h();
        int size = h.size();
        int i = 0;
        int i2 = this.f2653n < size ? this.f2653n - 1 : this.f2653n;
        while (i < size && i2 > 0) {
            boolean z;
            int i3;
            MenuItemImpl menuItemImpl = (MenuItemImpl) h.get(i);
            if (menuItemImpl.m4500i() || menuItemImpl.m4501j()) {
                z = true;
            } else {
                z = false;
            }
            menuItemImpl.m4494d(z);
            if (z) {
                i3 = i2 - 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        for (int i4 = i; i4 < size; i4++) {
            ((MenuItemImpl) h.get(i4)).m4494d(false);
        }
        return true;
    }

    public void m4373a(MenuBuilder menuBuilder, boolean z) {
        m4387f(true);
        super.m4346a(menuBuilder, z);
    }

    protected View m4367a(Context context) {
        return new OverflowMenuButton(this, context);
    }
}
