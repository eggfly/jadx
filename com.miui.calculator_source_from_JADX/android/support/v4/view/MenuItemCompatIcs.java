package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemCompatIcs {

    interface SupportActionExpandProxy {
        boolean m1256a(MenuItem menuItem);

        boolean m1257b(MenuItem menuItem);
    }

    static class OnActionExpandListenerWrapper implements OnActionExpandListener {
        private SupportActionExpandProxy f779a;

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f779a.m1256a(menuItem);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f779a.m1257b(menuItem);
        }
    }

    MenuItemCompatIcs() {
    }
}
