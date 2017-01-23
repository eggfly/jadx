package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class AccessibilityNodeInfoCompat {
    private static final AccessibilityNodeInfoImpl f947a;
    private final Object f948b;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat f924a;
        public static final AccessibilityActionCompat f925b;
        public static final AccessibilityActionCompat f926c;
        public static final AccessibilityActionCompat f927d;
        public static final AccessibilityActionCompat f928e;
        public static final AccessibilityActionCompat f929f;
        public static final AccessibilityActionCompat f930g;
        public static final AccessibilityActionCompat f931h;
        public static final AccessibilityActionCompat f932i;
        public static final AccessibilityActionCompat f933j;
        public static final AccessibilityActionCompat f934k;
        public static final AccessibilityActionCompat f935l;
        public static final AccessibilityActionCompat f936m;
        public static final AccessibilityActionCompat f937n;
        public static final AccessibilityActionCompat f938o;
        public static final AccessibilityActionCompat f939p;
        public static final AccessibilityActionCompat f940q;
        public static final AccessibilityActionCompat f941r;
        public static final AccessibilityActionCompat f942s;
        public static final AccessibilityActionCompat f943t;
        public static final AccessibilityActionCompat f944u;
        public static final AccessibilityActionCompat f945v;
        private final Object f946w;

        static {
            f924a = new AccessibilityActionCompat(1, null);
            f925b = new AccessibilityActionCompat(2, null);
            f926c = new AccessibilityActionCompat(4, null);
            f927d = new AccessibilityActionCompat(8, null);
            f928e = new AccessibilityActionCompat(16, null);
            f929f = new AccessibilityActionCompat(32, null);
            f930g = new AccessibilityActionCompat(64, null);
            f931h = new AccessibilityActionCompat(128, null);
            f932i = new AccessibilityActionCompat(256, null);
            f933j = new AccessibilityActionCompat(512, null);
            f934k = new AccessibilityActionCompat(1024, null);
            f935l = new AccessibilityActionCompat(2048, null);
            f936m = new AccessibilityActionCompat(4096, null);
            f937n = new AccessibilityActionCompat(8192, null);
            f938o = new AccessibilityActionCompat(16384, null);
            f939p = new AccessibilityActionCompat(32768, null);
            f940q = new AccessibilityActionCompat(65536, null);
            f941r = new AccessibilityActionCompat(131072, null);
            f942s = new AccessibilityActionCompat(262144, null);
            f943t = new AccessibilityActionCompat(524288, null);
            f944u = new AccessibilityActionCompat(1048576, null);
            f945v = new AccessibilityActionCompat(2097152, null);
        }

        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(AccessibilityNodeInfoCompat.f947a.m1648a(i, charSequence));
        }

        private AccessibilityActionCompat(Object obj) {
            this.f946w = obj;
        }
    }

    interface AccessibilityNodeInfoImpl {
        Object m1647a();

        Object m1648a(int i, CharSequence charSequence);

        Object m1649a(View view);

        Object m1650a(Object obj);

        void m1651a(Object obj, int i);

        void m1652a(Object obj, Rect rect);

        void m1653a(Object obj, View view);

        void m1654a(Object obj, View view, int i);

        void m1655a(Object obj, CharSequence charSequence);

        void m1656a(Object obj, boolean z);

        boolean m1657a(Object obj, Object obj2);

        int m1658b(Object obj);

        void m1659b(Object obj, int i);

        void m1660b(Object obj, Rect rect);

        void m1661b(Object obj, View view);

        void m1662b(Object obj, View view, int i);

        void m1663b(Object obj, CharSequence charSequence);

        void m1664b(Object obj, boolean z);

        CharSequence m1665c(Object obj);

        void m1666c(Object obj, Rect rect);

        void m1667c(Object obj, View view);

        void m1668c(Object obj, CharSequence charSequence);

        void m1669c(Object obj, boolean z);

        CharSequence m1670d(Object obj);

        void m1671d(Object obj, Rect rect);

        void m1672d(Object obj, boolean z);

        CharSequence m1673e(Object obj);

        void m1674e(Object obj, boolean z);

        CharSequence m1675f(Object obj);

        void m1676f(Object obj, boolean z);

        void m1677g(Object obj, boolean z);

        boolean m1678g(Object obj);

        void m1679h(Object obj, boolean z);

        boolean m1680h(Object obj);

        void m1681i(Object obj, boolean z);

        boolean m1682i(Object obj);

        boolean m1683j(Object obj);

        boolean m1684k(Object obj);

        boolean m1685l(Object obj);

        boolean m1686m(Object obj);

        boolean m1687n(Object obj);

        boolean m1688o(Object obj);

        boolean m1689p(Object obj);

        void m1690q(Object obj);

        int m1691r(Object obj);

        boolean m1692s(Object obj);

        boolean m1693t(Object obj);

        String m1694u(Object obj);
    }

    static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        AccessibilityNodeInfoStubImpl() {
        }

        public Object m1696a(int i, CharSequence charSequence) {
            return null;
        }

        public Object m1695a() {
            return null;
        }

        public Object m1697a(View view) {
            return null;
        }

        public Object m1698a(Object obj) {
            return null;
        }

        public void m1699a(Object obj, int i) {
        }

        public boolean m1705a(Object obj, Object obj2) {
            return false;
        }

        public void m1701a(Object obj, View view) {
        }

        public void m1710b(Object obj, View view, int i) {
        }

        public int m1706b(Object obj) {
            return 0;
        }

        public void m1700a(Object obj, Rect rect) {
        }

        public void m1708b(Object obj, Rect rect) {
        }

        public CharSequence m1713c(Object obj) {
            return null;
        }

        public CharSequence m1718d(Object obj) {
            return null;
        }

        public CharSequence m1721e(Object obj) {
            return null;
        }

        public CharSequence m1723f(Object obj) {
            return null;
        }

        public boolean m1726g(Object obj) {
            return false;
        }

        public boolean m1728h(Object obj) {
            return false;
        }

        public boolean m1730i(Object obj) {
            return false;
        }

        public boolean m1731j(Object obj) {
            return false;
        }

        public boolean m1732k(Object obj) {
            return false;
        }

        public boolean m1733l(Object obj) {
            return false;
        }

        public boolean m1740s(Object obj) {
            return false;
        }

        public boolean m1741t(Object obj) {
            return false;
        }

        public boolean m1734m(Object obj) {
            return false;
        }

        public boolean m1735n(Object obj) {
            return false;
        }

        public boolean m1736o(Object obj) {
            return false;
        }

        public boolean m1737p(Object obj) {
            return false;
        }

        public void m1707b(Object obj, int i) {
        }

        public int m1739r(Object obj) {
            return 0;
        }

        public void m1714c(Object obj, Rect rect) {
        }

        public void m1719d(Object obj, Rect rect) {
        }

        public void m1703a(Object obj, CharSequence charSequence) {
        }

        public void m1704a(Object obj, boolean z) {
        }

        public void m1711b(Object obj, CharSequence charSequence) {
        }

        public void m1712b(Object obj, boolean z) {
        }

        public void m1717c(Object obj, boolean z) {
        }

        public void m1720d(Object obj, boolean z) {
        }

        public void m1727h(Object obj, boolean z) {
        }

        public void m1729i(Object obj, boolean z) {
        }

        public void m1722e(Object obj, boolean z) {
        }

        public void m1716c(Object obj, CharSequence charSequence) {
        }

        public void m1709b(Object obj, View view) {
        }

        public void m1724f(Object obj, boolean z) {
        }

        public void m1725g(Object obj, boolean z) {
        }

        public void m1715c(Object obj, View view) {
        }

        public void m1702a(Object obj, View view, int i) {
        }

        public void m1738q(Object obj) {
        }

        public String m1742u(Object obj) {
            return null;
        }
    }

    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        AccessibilityNodeInfoIcsImpl() {
        }

        public Object m1743a() {
            return AccessibilityNodeInfoCompatIcs.m1844a();
        }

        public Object m1744a(View view) {
            return AccessibilityNodeInfoCompatIcs.m1845a(view);
        }

        public Object m1745a(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1846a(obj);
        }

        public void m1746a(Object obj, int i) {
            AccessibilityNodeInfoCompatIcs.m1847a(obj, i);
        }

        public void m1748a(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.m1849a(obj, view);
        }

        public int m1751b(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1852b(obj);
        }

        public void m1747a(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.m1848a(obj, rect);
        }

        public void m1752b(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.m1853b(obj, rect);
        }

        public CharSequence m1756c(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1857c(obj);
        }

        public CharSequence m1761d(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1862d(obj);
        }

        public CharSequence m1764e(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1865e(obj);
        }

        public CharSequence m1766f(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1867f(obj);
        }

        public boolean m1769g(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1870g(obj);
        }

        public boolean m1770h(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1871h(obj);
        }

        public boolean m1771i(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1872i(obj);
        }

        public boolean m1772j(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1873j(obj);
        }

        public boolean m1773k(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1874k(obj);
        }

        public boolean m1774l(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1875l(obj);
        }

        public boolean m1775m(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1876m(obj);
        }

        public boolean m1776n(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1877n(obj);
        }

        public boolean m1777o(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1878o(obj);
        }

        public boolean m1778p(Object obj) {
            return AccessibilityNodeInfoCompatIcs.m1879p(obj);
        }

        public void m1757c(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.m1858c(obj, rect);
        }

        public void m1762d(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.m1863d(obj, rect);
        }

        public void m1749a(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.m1850a(obj, charSequence);
        }

        public void m1750a(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m1851a(obj, z);
        }

        public void m1754b(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.m1855b(obj, charSequence);
        }

        public void m1755b(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m1856b(obj, z);
        }

        public void m1760c(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m1861c(obj, z);
        }

        public void m1763d(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m1864d(obj, z);
        }

        public void m1765e(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m1866e(obj, z);
        }

        public void m1759c(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.m1860c(obj, charSequence);
        }

        public void m1753b(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.m1854b(obj, view);
        }

        public void m1767f(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m1868f(obj, z);
        }

        public void m1768g(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.m1869g(obj, z);
        }

        public void m1758c(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.m1859c(obj, view);
        }

        public void m1779q(Object obj) {
            AccessibilityNodeInfoCompatIcs.m1880q(obj);
        }
    }

    static class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl {
        AccessibilityNodeInfoJellybeanImpl() {
        }

        public void m1782b(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.m1882a(obj, view, i);
        }

        public void m1780a(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.m1886b(obj, view, i);
        }

        public boolean m1786s(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.m1884a(obj);
        }

        public void m1783h(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.m1883a(obj, z);
        }

        public boolean m1787t(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.m1888c(obj);
        }

        public void m1784i(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.m1887b(obj, z);
        }

        public void m1781b(Object obj, int i) {
            AccessibilityNodeInfoCompatJellyBean.m1881a(obj, i);
        }

        public int m1785r(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.m1885b(obj);
        }
    }

    static class AccessibilityNodeInfoJellybeanMr1Impl extends AccessibilityNodeInfoJellybeanImpl {
        AccessibilityNodeInfoJellybeanMr1Impl() {
        }
    }

    static class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoJellybeanMr1Impl {
        AccessibilityNodeInfoJellybeanMr2Impl() {
        }

        public String m1788u(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.m1889a(obj);
        }
    }

    static class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoJellybeanMr2Impl {
        AccessibilityNodeInfoKitKatImpl() {
        }
    }

    static class AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoKitKatImpl {
        AccessibilityNodeInfoApi21Impl() {
        }

        public Object m1789a(int i, CharSequence charSequence) {
            return AccessibilityNodeInfoCompatApi21.m1842a(i, charSequence);
        }

        public boolean m1790a(Object obj, Object obj2) {
            return AccessibilityNodeInfoCompatApi21.m1843a(obj, obj2);
        }
    }

    static class AccessibilityNodeInfoApi22Impl extends AccessibilityNodeInfoApi21Impl {
        AccessibilityNodeInfoApi22Impl() {
        }
    }

    public static class CollectionInfoCompat {
    }

    public static class CollectionItemInfoCompat {
    }

    public static class RangeInfoCompat {
    }

    static {
        if (VERSION.SDK_INT >= 22) {
            f947a = new AccessibilityNodeInfoApi22Impl();
        } else if (VERSION.SDK_INT >= 21) {
            f947a = new AccessibilityNodeInfoApi21Impl();
        } else if (VERSION.SDK_INT >= 19) {
            f947a = new AccessibilityNodeInfoKitKatImpl();
        } else if (VERSION.SDK_INT >= 18) {
            f947a = new AccessibilityNodeInfoJellybeanMr2Impl();
        } else if (VERSION.SDK_INT >= 17) {
            f947a = new AccessibilityNodeInfoJellybeanMr1Impl();
        } else if (VERSION.SDK_INT >= 16) {
            f947a = new AccessibilityNodeInfoJellybeanImpl();
        } else if (VERSION.SDK_INT >= 14) {
            f947a = new AccessibilityNodeInfoIcsImpl();
        } else {
            f947a = new AccessibilityNodeInfoStubImpl();
        }
    }

    static AccessibilityNodeInfoCompat m1793a(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat(Object obj) {
        this.f948b = obj;
    }

    public Object m1797a() {
        return this.f948b;
    }

    public static AccessibilityNodeInfoCompat m1792a(View view) {
        return m1793a(f947a.m1649a(view));
    }

    public static AccessibilityNodeInfoCompat m1794b() {
        return m1793a(f947a.m1647a());
    }

    public static AccessibilityNodeInfoCompat m1791a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return m1793a(f947a.m1650a(accessibilityNodeInfoCompat.f948b));
    }

    public void m1806b(View view) {
        f947a.m1667c(this.f948b, view);
    }

    public void m1800a(View view, int i) {
        f947a.m1654a(this.f948b, view, i);
    }

    public void m1812c(View view) {
        f947a.m1653a(this.f948b, view);
    }

    public void m1807b(View view, int i) {
        f947a.m1662b(this.f948b, view, i);
    }

    public int m1810c() {
        return f947a.m1658b(this.f948b);
    }

    public void m1798a(int i) {
        f947a.m1651a(this.f948b, i);
    }

    public boolean m1803a(AccessibilityActionCompat accessibilityActionCompat) {
        return f947a.m1657a(this.f948b, accessibilityActionCompat.f946w);
    }

    public void m1804b(int i) {
        f947a.m1659b(this.f948b, i);
    }

    public int m1815d() {
        return f947a.m1691r(this.f948b);
    }

    public void m1817d(View view) {
        f947a.m1661b(this.f948b, view);
    }

    public void m1799a(Rect rect) {
        f947a.m1652a(this.f948b, rect);
    }

    public void m1805b(Rect rect) {
        f947a.m1666c(this.f948b, rect);
    }

    public void m1811c(Rect rect) {
        f947a.m1660b(this.f948b, rect);
    }

    public void m1816d(Rect rect) {
        f947a.m1671d(this.f948b, rect);
    }

    public boolean m1820e() {
        return f947a.m1678g(this.f948b);
    }

    public boolean m1822f() {
        return f947a.m1680h(this.f948b);
    }

    public boolean m1824g() {
        return f947a.m1684k(this.f948b);
    }

    public void m1802a(boolean z) {
        f947a.m1669c(this.f948b, z);
    }

    public boolean m1826h() {
        return f947a.m1685l(this.f948b);
    }

    public void m1809b(boolean z) {
        f947a.m1672d(this.f948b, z);
    }

    public boolean m1828i() {
        return f947a.m1692s(this.f948b);
    }

    public void m1814c(boolean z) {
        f947a.m1679h(this.f948b, z);
    }

    public boolean m1829j() {
        return f947a.m1693t(this.f948b);
    }

    public void m1818d(boolean z) {
        f947a.m1681i(this.f948b, z);
    }

    public boolean m1830k() {
        return f947a.m1689p(this.f948b);
    }

    public void m1819e(boolean z) {
        f947a.m1677g(this.f948b, z);
    }

    public boolean m1831l() {
        return f947a.m1682i(this.f948b);
    }

    public void m1821f(boolean z) {
        f947a.m1656a(this.f948b, z);
    }

    public boolean m1832m() {
        return f947a.m1686m(this.f948b);
    }

    public void m1823g(boolean z) {
        f947a.m1674e(this.f948b, z);
    }

    public boolean m1833n() {
        return f947a.m1683j(this.f948b);
    }

    public void m1825h(boolean z) {
        f947a.m1664b(this.f948b, z);
    }

    public boolean m1834o() {
        return f947a.m1687n(this.f948b);
    }

    public boolean m1835p() {
        return f947a.m1688o(this.f948b);
    }

    public void m1827i(boolean z) {
        f947a.m1676f(this.f948b, z);
    }

    public CharSequence m1836q() {
        return f947a.m1673e(this.f948b);
    }

    public void m1801a(CharSequence charSequence) {
        f947a.m1668c(this.f948b, charSequence);
    }

    public CharSequence m1837r() {
        return f947a.m1665c(this.f948b);
    }

    public void m1808b(CharSequence charSequence) {
        f947a.m1655a(this.f948b, charSequence);
    }

    public CharSequence m1838s() {
        return f947a.m1675f(this.f948b);
    }

    public CharSequence m1839t() {
        return f947a.m1670d(this.f948b);
    }

    public void m1813c(CharSequence charSequence) {
        f947a.m1663b(this.f948b, charSequence);
    }

    public void m1840u() {
        f947a.m1690q(this.f948b);
    }

    public String m1841v() {
        return f947a.m1694u(this.f948b);
    }

    public int hashCode() {
        return this.f948b == null ? 0 : this.f948b.hashCode();
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
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        if (this.f948b == null) {
            if (accessibilityNodeInfoCompat.f948b != null) {
                return false;
            }
            return true;
        } else if (this.f948b.equals(accessibilityNodeInfoCompat.f948b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m1799a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m1811c(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m1836q());
        stringBuilder.append("; className: ").append(m1837r());
        stringBuilder.append("; text: ").append(m1838s());
        stringBuilder.append("; contentDescription: ").append(m1839t());
        stringBuilder.append("; viewId: ").append(m1841v());
        stringBuilder.append("; checkable: ").append(m1820e());
        stringBuilder.append("; checked: ").append(m1822f());
        stringBuilder.append("; focusable: ").append(m1824g());
        stringBuilder.append("; focused: ").append(m1826h());
        stringBuilder.append("; selected: ").append(m1830k());
        stringBuilder.append("; clickable: ").append(m1831l());
        stringBuilder.append("; longClickable: ").append(m1832m());
        stringBuilder.append("; enabled: ").append(m1833n());
        stringBuilder.append("; password: ").append(m1834o());
        stringBuilder.append("; scrollable: " + m1835p());
        stringBuilder.append("; [");
        int c = m1810c();
        while (c != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(c);
            c &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(m1795c(numberOfTrailingZeros));
            if (c != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m1795c(int i) {
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return "ACTION_FOCUS";
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                return "ACTION_SELECT";
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
