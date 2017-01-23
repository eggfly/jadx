package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.View;

public class AccessibilityRecordCompat {
    private static final AccessibilityRecordImpl f957a;
    private final Object f958b;

    interface AccessibilityRecordImpl {
        Object m1915a();

        void m1916a(Object obj, int i);

        void m1917a(Object obj, View view, int i);

        void m1918a(Object obj, boolean z);

        void m1919b(Object obj, int i);

        void m1920c(Object obj, int i);

        void m1921d(Object obj, int i);

        void m1922e(Object obj, int i);

        void m1923f(Object obj, int i);

        void m1924g(Object obj, int i);
    }

    static class AccessibilityRecordStubImpl implements AccessibilityRecordImpl {
        AccessibilityRecordStubImpl() {
        }

        public Object m1925a() {
            return null;
        }

        public void m1926a(Object obj, int i) {
        }

        public void m1929b(Object obj, int i) {
        }

        public void m1933f(Object obj, int i) {
        }

        public void m1934g(Object obj, int i) {
        }

        public void m1930c(Object obj, int i) {
        }

        public void m1931d(Object obj, int i) {
        }

        public void m1928a(Object obj, boolean z) {
        }

        public void m1927a(Object obj, View view, int i) {
        }

        public void m1932e(Object obj, int i) {
        }
    }

    static class AccessibilityRecordIcsImpl extends AccessibilityRecordStubImpl {
        AccessibilityRecordIcsImpl() {
        }

        public Object m1935a() {
            return AccessibilityRecordCompatIcs.m1955a();
        }

        public void m1936a(Object obj, int i) {
            AccessibilityRecordCompatIcs.m1956a(obj, i);
        }

        public void m1938b(Object obj, int i) {
            AccessibilityRecordCompatIcs.m1958b(obj, i);
        }

        public void m1939c(Object obj, int i) {
            AccessibilityRecordCompatIcs.m1959c(obj, i);
        }

        public void m1940d(Object obj, int i) {
            AccessibilityRecordCompatIcs.m1960d(obj, i);
        }

        public void m1937a(Object obj, boolean z) {
            AccessibilityRecordCompatIcs.m1957a(obj, z);
        }

        public void m1941e(Object obj, int i) {
            AccessibilityRecordCompatIcs.m1961e(obj, i);
        }
    }

    static class AccessibilityRecordIcsMr1Impl extends AccessibilityRecordIcsImpl {
        AccessibilityRecordIcsMr1Impl() {
        }

        public void m1942f(Object obj, int i) {
            AccessibilityRecordCompatIcsMr1.m1962a(obj, i);
        }

        public void m1943g(Object obj, int i) {
            AccessibilityRecordCompatIcsMr1.m1963b(obj, i);
        }
    }

    static class AccessibilityRecordJellyBeanImpl extends AccessibilityRecordIcsMr1Impl {
        AccessibilityRecordJellyBeanImpl() {
        }

        public void m1944a(Object obj, View view, int i) {
            AccessibilityRecordCompatJellyBean.m1964a(obj, view, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f957a = new AccessibilityRecordJellyBeanImpl();
        } else if (VERSION.SDK_INT >= 15) {
            f957a = new AccessibilityRecordIcsMr1Impl();
        } else if (VERSION.SDK_INT >= 14) {
            f957a = new AccessibilityRecordIcsImpl();
        } else {
            f957a = new AccessibilityRecordStubImpl();
        }
    }

    public AccessibilityRecordCompat(Object obj) {
        this.f958b = obj;
    }

    public static AccessibilityRecordCompat m1945a() {
        return new AccessibilityRecordCompat(f957a.m1915a());
    }

    public void m1947a(View view, int i) {
        f957a.m1917a(this.f958b, view, i);
    }

    public void m1948a(boolean z) {
        f957a.m1918a(this.f958b, z);
    }

    public void m1946a(int i) {
        f957a.m1919b(this.f958b, i);
    }

    public void m1949b(int i) {
        f957a.m1916a(this.f958b, i);
    }

    public void m1950c(int i) {
        f957a.m1922e(this.f958b, i);
    }

    public void m1951d(int i) {
        f957a.m1920c(this.f958b, i);
    }

    public void m1952e(int i) {
        f957a.m1921d(this.f958b, i);
    }

    public void m1953f(int i) {
        f957a.m1923f(this.f958b, i);
    }

    public void m1954g(int i) {
        f957a.m1924g(this.f958b, i);
    }

    public int hashCode() {
        return this.f958b == null ? 0 : this.f958b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        if (this.f958b == null) {
            if (accessibilityRecordCompat.f958b != null) {
                return false;
            }
            return true;
        } else if (this.f958b.equals(accessibilityRecordCompat.f958b)) {
            return true;
        } else {
            return false;
        }
    }
}
