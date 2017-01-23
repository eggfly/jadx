package com.miui.support.internal.view.menu;

import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.app.ActionBarDelegateImpl;
import com.miui.support.widget.ListPopupWindow;

public class PadImmersionMenuPopupWindow extends ListPopupWindow implements ImmersionMenuPopupWindow {
    private ActionBarDelegateImpl f2787b;
    private ImmersionMenuAdapter f2788c;
    private View f2789d;
    private ViewGroup f2790e;

    /* renamed from: com.miui.support.internal.view.menu.PadImmersionMenuPopupWindow.1 */
    class C03631 implements OnItemClickListener {
        final /* synthetic */ PadImmersionMenuPopupWindow f2759a;

        /* renamed from: com.miui.support.internal.view.menu.PadImmersionMenuPopupWindow.1.1 */
        class C03621 implements OnDismissListener {
            final /* synthetic */ SubMenu f2757a;
            final /* synthetic */ C03631 f2758b;

            C03621(C03631 c03631, SubMenu subMenu) {
                this.f2758b = c03631;
                this.f2757a = subMenu;
            }

            public void onDismiss() {
                this.f2758b.f2759a.m4519a(null);
                this.f2758b.f2759a.m4534a(this.f2757a);
                this.f2758b.f2759a.m4536b(this.f2758b.f2759a.f2789d, this.f2758b.f2759a.f2790e);
            }
        }

        C03631(PadImmersionMenuPopupWindow padImmersionMenuPopupWindow) {
            this.f2759a = padImmersionMenuPopupWindow;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MenuItem a = this.f2759a.f2788c.m4459a(i);
            if (a.hasSubMenu()) {
                this.f2759a.m4519a(new C03621(this, a.getSubMenu()));
            } else {
                this.f2759a.f2787b.m3608a(0, a);
            }
            this.f2759a.m4520a(true);
        }
    }

    public PadImmersionMenuPopupWindow(ActionBarDelegateImpl actionBarDelegateImpl, Menu menu) {
        super(actionBarDelegateImpl.m3636g());
        this.f2787b = actionBarDelegateImpl;
        this.f2788c = new ImmersionMenuAdapter(actionBarDelegateImpl.m3636g(), menu);
        m4518a(this.f2788c);
        m4522b(actionBarDelegateImpl.m3636g().getResources().getDimensionPixelSize(C0264R.dimen.immersion_menu_window_width));
        m4517a(new C03631(this));
    }

    public void m4534a(Menu menu) {
        this.f2788c.m4460a(menu);
    }

    public void m4535a(View view, ViewGroup viewGroup) {
        this.f2789d = view;
        this.f2790e = viewGroup;
        m4516a(view);
        m4524c();
    }

    public void m4536b(View view, ViewGroup viewGroup) {
        this.f2789d = view;
        this.f2790e = viewGroup;
        m4516a(view);
        m4521b();
    }
}
