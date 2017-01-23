package com.miui.support.internal.view.menu;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.view.menu.MenuPresenter.Callback;

public class MenuDialogHelper implements OnClickListener, OnDismissListener, OnKeyListener, Callback {
    private MenuBuilder f2606a;
    ListMenuPresenter f2607b;
    private AlertDialog f2608c;
    private Callback f2609d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f2606a = menuBuilder;
    }

    public void m4294a(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f2606a;
        Builder builder = new Builder(menuBuilder.m4436d());
        this.f2607b = new ListMenuPresenter(C0264R.layout.list_menu_item_layout, C0264R.style.Theme_MenuDialog_Light);
        this.f2607b.m4477a((Callback) this);
        this.f2606a.m4422a(this.f2607b);
        builder.setAdapter(this.f2607b.m4473a(), this);
        View m = menuBuilder.m4448m();
        if (m != null) {
            builder.setCustomTitle(m);
        } else {
            builder.setIcon(menuBuilder.m4447l()).setTitle(menuBuilder.m4446k());
        }
        builder.setOnKeyListener(this);
        this.f2608c = builder.create();
        this.f2608c.setOnDismissListener(this);
        LayoutParams attributes = this.f2608c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f2608c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f2608c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f2608c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f2606a.m4424a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f2606a.performShortcut(i, keyEvent, 0);
    }

    public void m4295a(Callback callback) {
        this.f2609d = callback;
    }

    public void m4293a() {
        if (this.f2608c != null) {
            this.f2608c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f2607b.m4476a(this.f2606a, true);
    }

    public void m4296b(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f2606a) {
            m4293a();
        }
        if (this.f2609d != null) {
            this.f2609d.m3612b(menuBuilder, z);
        }
    }

    public boolean m4297b(MenuBuilder menuBuilder) {
        return this.f2609d != null && this.f2609d.m3613b(menuBuilder);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2606a.m4426a((MenuItemImpl) this.f2607b.m4473a().getItem(i), 0);
    }
}
