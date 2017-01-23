package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.C0376d;
import android.support.v7.app.C0376d.C0373a;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.menu.C0441l.C0342a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* renamed from: android.support.v7.view.menu.g */
class C0448g implements OnClickListener, OnDismissListener, OnKeyListener, C0342a {
    C0446e f1229a;
    private C0447f f1230b;
    private C0376d f1231c;
    private C0342a f1232d;

    public C0448g(C0447f c0447f) {
        this.f1230b = c0447f;
    }

    public void m1431a() {
        if (this.f1231c != null) {
            this.f1231c.dismiss();
        }
    }

    public void m1432a(IBinder iBinder) {
        C0447f c0447f = this.f1230b;
        C0373a c0373a = new C0373a(c0447f.m1417e());
        this.f1229a = new C0446e(c0373a.m1055a(), C0417R.layout.abc_list_menu_item_layout);
        this.f1229a.m1372a((C0342a) this);
        this.f1230b.m1397a(this.f1229a);
        c0373a.m1059a(this.f1229a.m1369a(), this);
        View o = c0447f.m1427o();
        if (o != null) {
            c0373a.m1058a(o);
        } else {
            c0373a.m1057a(c0447f.m1426n()).m1060a(c0447f.m1425m());
        }
        c0373a.m1056a((OnKeyListener) this);
        this.f1231c = c0373a.m1061b();
        this.f1231c.setOnDismissListener(this);
        LayoutParams attributes = this.f1231c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION;
        this.f1231c.show();
    }

    public void m1433a(C0447f c0447f, boolean z) {
        if (z || c0447f == this.f1230b) {
            m1431a();
        }
        if (this.f1232d != null) {
            this.f1232d.m847a(c0447f, z);
        }
    }

    public boolean m1434a(C0447f c0447f) {
        return this.f1232d != null ? this.f1232d.m848a(c0447f) : false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1230b.m1403a((C0450h) this.f1229a.m1369a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1229a.m1371a(this.f1230b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f1231c.getWindow();
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
                window = this.f1231c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f1230b.m1401a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1230b.performShortcut(i, keyEvent, 0);
    }
}
