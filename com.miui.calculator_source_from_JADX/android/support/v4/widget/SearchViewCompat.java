package android.support.v4.widget;

import android.os.Build.VERSION;

public class SearchViewCompat {
    private static final SearchViewCompatImpl f1175a;

    public static abstract class OnCloseListenerCompat {
        final Object f1169a;

        public OnCloseListenerCompat() {
            this.f1169a = SearchViewCompat.f1175a.m2392a(this);
        }

        public boolean m2383a() {
            return false;
        }
    }

    public static abstract class OnQueryTextListenerCompat {
        final Object f1170a;

        public OnQueryTextListenerCompat() {
            this.f1170a = SearchViewCompat.f1175a.m2393a(this);
        }

        public boolean m2384a(String str) {
            return false;
        }

        public boolean m2385b(String str) {
            return false;
        }
    }

    interface SearchViewCompatImpl {
        Object m2392a(OnCloseListenerCompat onCloseListenerCompat);

        Object m2393a(OnQueryTextListenerCompat onQueryTextListenerCompat);
    }

    static class SearchViewCompatStubImpl implements SearchViewCompatImpl {
        SearchViewCompatStubImpl() {
        }

        public Object m2395a(OnQueryTextListenerCompat onQueryTextListenerCompat) {
            return null;
        }

        public Object m2394a(OnCloseListenerCompat onCloseListenerCompat) {
            return null;
        }
    }

    static class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl {

        /* renamed from: android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl.1 */
        class C01161 implements OnQueryTextListenerCompatBridge {
            final /* synthetic */ OnQueryTextListenerCompat f1171a;
            final /* synthetic */ SearchViewCompatHoneycombImpl f1172b;

            C01161(SearchViewCompatHoneycombImpl searchViewCompatHoneycombImpl, OnQueryTextListenerCompat onQueryTextListenerCompat) {
                this.f1172b = searchViewCompatHoneycombImpl;
                this.f1171a = onQueryTextListenerCompat;
            }

            public boolean m2388a(String str) {
                return this.f1171a.m2384a(str);
            }

            public boolean m2389b(String str) {
                return this.f1171a.m2385b(str);
            }
        }

        /* renamed from: android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl.2 */
        class C01172 implements OnCloseListenerCompatBridge {
            final /* synthetic */ OnCloseListenerCompat f1173a;
            final /* synthetic */ SearchViewCompatHoneycombImpl f1174b;

            C01172(SearchViewCompatHoneycombImpl searchViewCompatHoneycombImpl, OnCloseListenerCompat onCloseListenerCompat) {
                this.f1174b = searchViewCompatHoneycombImpl;
                this.f1173a = onCloseListenerCompat;
            }

            public boolean m2391a() {
                return this.f1173a.m2383a();
            }
        }

        SearchViewCompatHoneycombImpl() {
        }

        public Object m2397a(OnQueryTextListenerCompat onQueryTextListenerCompat) {
            return SearchViewCompatHoneycomb.m2400a(new C01161(this, onQueryTextListenerCompat));
        }

        public Object m2396a(OnCloseListenerCompat onCloseListenerCompat) {
            return SearchViewCompatHoneycomb.m2399a(new C01172(this, onCloseListenerCompat));
        }
    }

    static class SearchViewCompatIcsImpl extends SearchViewCompatHoneycombImpl {
        SearchViewCompatIcsImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f1175a = new SearchViewCompatIcsImpl();
        } else if (VERSION.SDK_INT >= 11) {
            f1175a = new SearchViewCompatHoneycombImpl();
        } else {
            f1175a = new SearchViewCompatStubImpl();
        }
    }
}
