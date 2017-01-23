package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class AccessibilityWindowInfoCompat {
    private static final AccessibilityWindowInfoImpl f959a;
    private Object f960b;

    private interface AccessibilityWindowInfoImpl {
        int m1965a(Object obj);

        void m1966a(Object obj, Rect rect);

        int m1967b(Object obj);

        Object m1968c(Object obj);

        int m1969d(Object obj);

        boolean m1970e(Object obj);

        boolean m1971f(Object obj);

        int m1972g(Object obj);
    }

    private static class AccessibilityWindowInfoStubImpl implements AccessibilityWindowInfoImpl {
        private AccessibilityWindowInfoStubImpl() {
        }

        public int m1973a(Object obj) {
            return -1;
        }

        public int m1975b(Object obj) {
            return -1;
        }

        public Object m1976c(Object obj) {
            return null;
        }

        public int m1977d(Object obj) {
            return -1;
        }

        public void m1974a(Object obj, Rect rect) {
        }

        public boolean m1978e(Object obj) {
            return true;
        }

        public boolean m1979f(Object obj) {
            return true;
        }

        public int m1980g(Object obj) {
            return 0;
        }
    }

    private static class AccessibilityWindowInfoApi21Impl extends AccessibilityWindowInfoStubImpl {
        private AccessibilityWindowInfoApi21Impl() {
            super();
        }

        public int m1981a(Object obj) {
            return AccessibilityWindowInfoCompatApi21.m1999a(obj);
        }

        public int m1983b(Object obj) {
            return AccessibilityWindowInfoCompatApi21.m2001b(obj);
        }

        public Object m1984c(Object obj) {
            return AccessibilityWindowInfoCompatApi21.m2002c(obj);
        }

        public int m1985d(Object obj) {
            return AccessibilityWindowInfoCompatApi21.m2003d(obj);
        }

        public void m1982a(Object obj, Rect rect) {
            AccessibilityWindowInfoCompatApi21.m2000a(obj, rect);
        }

        public boolean m1986e(Object obj) {
            return AccessibilityWindowInfoCompatApi21.m2004e(obj);
        }

        public boolean m1987f(Object obj) {
            return AccessibilityWindowInfoCompatApi21.m2005f(obj);
        }

        public int m1988g(Object obj) {
            return AccessibilityWindowInfoCompatApi21.m2006g(obj);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f959a = new AccessibilityWindowInfoApi21Impl();
        } else {
            f959a = new AccessibilityWindowInfoStubImpl();
        }
    }

    static AccessibilityWindowInfoCompat m1989a(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.f960b = obj;
    }

    public int m1991a() {
        return f959a.m1965a(this.f960b);
    }

    public int m1993b() {
        return f959a.m1967b(this.f960b);
    }

    public AccessibilityWindowInfoCompat m1994c() {
        return m1989a(f959a.m1968c(this.f960b));
    }

    public int m1995d() {
        return f959a.m1969d(this.f960b);
    }

    public void m1992a(Rect rect) {
        f959a.m1966a(this.f960b, rect);
    }

    public boolean m1996e() {
        return f959a.m1970e(this.f960b);
    }

    public boolean m1997f() {
        return f959a.m1971f(this.f960b);
    }

    public int m1998g() {
        return f959a.m1972g(this.f960b);
    }

    public int hashCode() {
        return this.f960b == null ? 0 : this.f960b.hashCode();
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
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        if (this.f960b == null) {
            if (accessibilityWindowInfoCompat.f960b != null) {
                return false;
            }
            return true;
        } else if (this.f960b.equals(accessibilityWindowInfoCompat.f960b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        boolean z;
        boolean z2 = true;
        StringBuilder stringBuilder = new StringBuilder();
        Rect rect = new Rect();
        m1992a(rect);
        stringBuilder.append("AccessibilityWindowInfo[");
        stringBuilder.append("id=").append(m1995d());
        stringBuilder.append(", type=").append(m1990a(m1991a()));
        stringBuilder.append(", layer=").append(m1993b());
        stringBuilder.append(", bounds=").append(rect);
        stringBuilder.append(", focused=").append(m1997f());
        stringBuilder.append(", active=").append(m1996e());
        StringBuilder append = stringBuilder.append(", hasParent=");
        if (m1994c() != null) {
            z = true;
        } else {
            z = false;
        }
        append.append(z);
        StringBuilder append2 = stringBuilder.append(", hasChildren=");
        if (m1998g() <= 0) {
            z2 = false;
        }
        append2.append(z2);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private static String m1990a(int i) {
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return "TYPE_APPLICATION";
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return "TYPE_INPUT_METHOD";
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                return "TYPE_SYSTEM";
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                return "TYPE_ACCESSIBILITY_OVERLAY";
            default:
                return "<UNKNOWN>";
        }
    }
}
