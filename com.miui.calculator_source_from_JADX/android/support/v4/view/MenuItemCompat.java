package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MenuItem;

public class MenuItemCompat {
    static final MenuVersionImpl f778a;

    interface MenuVersionImpl {
    }

    static class BaseMenuVersionImpl implements MenuVersionImpl {
        BaseMenuVersionImpl() {
        }
    }

    static class HoneycombMenuVersionImpl implements MenuVersionImpl {
        HoneycombMenuVersionImpl() {
        }
    }

    static class IcsMenuVersionImpl extends HoneycombMenuVersionImpl {

        /* renamed from: android.support.v4.view.MenuItemCompat.IcsMenuVersionImpl.1 */
        class C00831 implements SupportActionExpandProxy {
            final /* synthetic */ OnActionExpandListener f777a;

            public boolean m1258a(MenuItem menuItem) {
                return this.f777a.m1260a(menuItem);
            }

            public boolean m1259b(MenuItem menuItem) {
                return this.f777a.m1261b(menuItem);
            }
        }

        IcsMenuVersionImpl() {
        }
    }

    public interface OnActionExpandListener {
        boolean m1260a(MenuItem menuItem);

        boolean m1261b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f778a = new IcsMenuVersionImpl();
        } else if (i >= 11) {
            f778a = new HoneycombMenuVersionImpl();
        } else {
            f778a = new BaseMenuVersionImpl();
        }
    }
}
