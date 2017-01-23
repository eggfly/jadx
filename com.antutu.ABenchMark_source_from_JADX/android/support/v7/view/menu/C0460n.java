package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.view.menu.n */
public final class C0460n {
    public static Menu m1489a(Context context, SupportMenu supportMenu) {
        if (VERSION.SDK_INT >= 14) {
            return new C0461o(context, supportMenu);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m1490a(Context context, SupportMenuItem supportMenuItem) {
        if (VERSION.SDK_INT >= 16) {
            return new C0457j(context, supportMenuItem);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0455i(context, supportMenuItem);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m1491a(Context context, SupportSubMenu supportSubMenu) {
        if (VERSION.SDK_INT >= 14) {
            return new C0463q(context, supportSubMenu);
        }
        throw new UnsupportedOperationException();
    }
}
