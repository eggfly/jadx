package android.support.v4.widget;

import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;

class SearchViewCompatHoneycomb {

    interface OnQueryTextListenerCompatBridge {
        boolean m2386a(String str);

        boolean m2387b(String str);
    }

    interface OnCloseListenerCompatBridge {
        boolean m2390a();
    }

    /* renamed from: android.support.v4.widget.SearchViewCompatHoneycomb.1 */
    final class C01181 implements OnQueryTextListener {
        final /* synthetic */ OnQueryTextListenerCompatBridge f1176a;

        C01181(OnQueryTextListenerCompatBridge onQueryTextListenerCompatBridge) {
            this.f1176a = onQueryTextListenerCompatBridge;
        }

        public boolean onQueryTextSubmit(String str) {
            return this.f1176a.m2386a(str);
        }

        public boolean onQueryTextChange(String str) {
            return this.f1176a.m2387b(str);
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompatHoneycomb.2 */
    final class C01192 implements OnCloseListener {
        final /* synthetic */ OnCloseListenerCompatBridge f1177a;

        C01192(OnCloseListenerCompatBridge onCloseListenerCompatBridge) {
            this.f1177a = onCloseListenerCompatBridge;
        }

        public boolean onClose() {
            return this.f1177a.m2390a();
        }
    }

    SearchViewCompatHoneycomb() {
    }

    public static Object m2400a(OnQueryTextListenerCompatBridge onQueryTextListenerCompatBridge) {
        return new C01181(onQueryTextListenerCompatBridge);
    }

    public static Object m2399a(OnCloseListenerCompatBridge onCloseListenerCompatBridge) {
        return new C01192(onCloseListenerCompatBridge);
    }
}
