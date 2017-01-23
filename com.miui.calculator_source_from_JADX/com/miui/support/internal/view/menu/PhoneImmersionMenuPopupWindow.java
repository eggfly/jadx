package com.miui.support.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.miui.support.C0234R;
import com.miui.support.internal.app.ActionBarDelegateImpl;
import com.miui.support.util.AttributeResolver;
import com.miui.support.widget.ImmersionListPopupWindow;

public class PhoneImmersionMenuPopupWindow extends ImmersionListPopupWindow implements ImmersionMenuPopupWindow {
    private ActionBarDelegateImpl f2826a;
    private ImmersionMenuAdapter f2827b;
    private View f2828c;
    private ViewGroup f2829d;
    private Drawable f2830e;

    /* renamed from: com.miui.support.internal.view.menu.PhoneImmersionMenuPopupWindow.1 */
    class C03661 implements OnItemClickListener {
        final /* synthetic */ PhoneImmersionMenuPopupWindow f2814a;

        /* renamed from: com.miui.support.internal.view.menu.PhoneImmersionMenuPopupWindow.1.1 */
        class C03651 implements OnDismissListener {
            final /* synthetic */ SubMenu f2812a;
            final /* synthetic */ C03661 f2813b;

            C03651(C03661 c03661, SubMenu subMenu) {
                this.f2813b = c03661;
                this.f2812a = subMenu;
            }

            public void onDismiss() {
                this.f2813b.f2814a.setOnDismissListener(null);
                this.f2813b.f2814a.m4580a(this.f2812a);
                this.f2813b.f2814a.m4573b(this.f2813b.f2814a.f2828c, this.f2813b.f2814a.f2829d);
            }
        }

        C03661(PhoneImmersionMenuPopupWindow phoneImmersionMenuPopupWindow) {
            this.f2814a = phoneImmersionMenuPopupWindow;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MenuItem a = this.f2814a.f2827b.m4459a(i);
            if (a.hasSubMenu()) {
                this.f2814a.setOnDismissListener(new C03651(this, a.getSubMenu()));
            } else {
                this.f2814a.f2826a.m3608a(0, a);
            }
            this.f2814a.m4571a(true);
        }
    }

    public PhoneImmersionMenuPopupWindow(ActionBarDelegateImpl actionBarDelegateImpl, Menu menu) {
        super(actionBarDelegateImpl.m3642m());
        Context m = actionBarDelegateImpl.m3642m();
        this.f2826a = actionBarDelegateImpl;
        this.f2827b = new ImmersionMenuAdapter(m, menu);
        m4570a(this.f2827b);
        m4569a(new C03661(this));
        this.f2830e = AttributeResolver.m5320b(m, C0234R.attr.immersionWindowBackground);
    }

    public void m4580a(Menu menu) {
        this.f2827b.m4460a(menu);
    }

    public void m4581a(View view, ViewGroup viewGroup) {
        this.f2828c = view;
        this.f2829d = viewGroup;
        super.m4568a(view, viewGroup);
    }

    protected Drawable m4579a(Context context, View view) {
        if (this.f2830e != null) {
            return this.f2830e;
        }
        return super.m4566a(context, view);
    }
}
