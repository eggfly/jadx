package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;

public class ViewCompat {
    static final ViewCompatImpl f829a;

    @Retention(RetentionPolicy.SOURCE)
    private @interface AccessibilityLiveRegion {
    }

    interface ViewCompatImpl {
        int m1346a(View view);

        void m1347a(View view, float f);

        void m1348a(View view, int i, int i2, int i3, int i4);

        void m1349a(View view, int i, Paint paint);

        void m1350a(View view, Paint paint);

        void m1351a(View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat);

        void m1352a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void m1353a(View view, AccessibilityEvent accessibilityEvent);

        void m1354a(View view, Runnable runnable);

        void m1355a(View view, Runnable runnable, long j);

        void m1356a(View view, boolean z);

        void m1357a(ViewGroup viewGroup, boolean z);

        boolean m1358a(View view, int i);

        boolean m1359a(View view, int i, Bundle bundle);

        void m1360b(View view);

        void m1361b(View view, float f);

        boolean m1362b(View view, int i);

        int m1363c(View view);

        void m1364c(View view, float f);

        void m1365c(View view, int i);

        float m1366d(View view);

        int m1367e(View view);

        int m1368f(View view);

        ViewParent m1369g(View view);

        boolean m1370h(View view);

        boolean m1371i(View view);

        float m1372j(View view);

        float m1373k(View view);

        boolean m1374l(View view);

        boolean m1375m(View view);

        void m1376n(View view);
    }

    static class BaseViewCompatImpl implements ViewCompatImpl {
        WeakHashMap<View, ViewPropertyAnimatorCompat> f827a;

        BaseViewCompatImpl() {
            this.f827a = null;
        }

        public boolean m1392a(View view, int i) {
            return (view instanceof ScrollingView) && m1377a((ScrollingView) view, i);
        }

        public boolean m1396b(View view, int i) {
            return (view instanceof ScrollingView) && m1378b((ScrollingView) view, i);
        }

        public int m1379a(View view) {
            return 2;
        }

        public void m1385a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        }

        public void m1387a(View view, AccessibilityEvent accessibilityEvent) {
        }

        public void m1386a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public void m1394b(View view) {
            view.invalidate();
        }

        public void m1382a(View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }

        public void m1388a(View view, Runnable runnable) {
            view.postDelayed(runnable, m1380a());
        }

        public void m1389a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, m1380a() + j);
        }

        long m1380a() {
            return 10;
        }

        public int m1397c(View view) {
            return 0;
        }

        public void m1399c(View view, int i) {
        }

        public boolean m1393a(View view, int i, Bundle bundle) {
            return false;
        }

        public float m1400d(View view) {
            return 1.0f;
        }

        public void m1383a(View view, int i, Paint paint) {
        }

        public int m1401e(View view) {
            return 0;
        }

        public void m1384a(View view, Paint paint) {
        }

        public int m1402f(View view) {
            return 0;
        }

        public ViewParent m1403g(View view) {
            return view.getParent();
        }

        public boolean m1404h(View view) {
            Drawable background = view.getBackground();
            if (background == null || background.getOpacity() != -1) {
                return false;
            }
            return true;
        }

        public boolean m1405i(View view) {
            return true;
        }

        public float m1406j(View view) {
            return 0.0f;
        }

        public void m1381a(View view, float f) {
        }

        public void m1395b(View view, float f) {
        }

        public void m1398c(View view, float f) {
        }

        public float m1407k(View view) {
            return 0.0f;
        }

        public void m1391a(ViewGroup viewGroup, boolean z) {
        }

        public boolean m1408l(View view) {
            return false;
        }

        public void m1390a(View view, boolean z) {
        }

        public boolean m1409m(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).isNestedScrollingEnabled();
            }
            return false;
        }

        private boolean m1377a(ScrollingView scrollingView, int i) {
            int b = scrollingView.m1331b();
            int a = scrollingView.m1330a() - scrollingView.m1332c();
            if (a == 0) {
                return false;
            }
            if (i < 0) {
                if (b <= 0) {
                    return false;
                }
                return true;
            } else if (b >= a - 1) {
                return false;
            } else {
                return true;
            }
        }

        private boolean m1378b(ScrollingView scrollingView, int i) {
            int e = scrollingView.m1334e();
            int d = scrollingView.m1333d() - scrollingView.m1335f();
            if (d == 0) {
                return false;
            }
            if (i < 0) {
                if (e <= 0) {
                    return false;
                }
                return true;
            } else if (e >= d - 1) {
                return false;
            } else {
                return true;
            }
        }

        public void m1410n(View view) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }
    }

    static class EclairMr1ViewCompatImpl extends BaseViewCompatImpl {
        EclairMr1ViewCompatImpl() {
        }

        public boolean m1412h(View view) {
            return ViewCompatEclairMr1.m1477a(view);
        }

        public void m1411a(ViewGroup viewGroup, boolean z) {
            ViewCompatEclairMr1.m1476a(viewGroup, z);
        }
    }

    static class GBViewCompatImpl extends EclairMr1ViewCompatImpl {
        GBViewCompatImpl() {
        }

        public int m1413a(View view) {
            return ViewCompatGingerbread.m1478a(view);
        }
    }

    static class HCViewCompatImpl extends GBViewCompatImpl {
        HCViewCompatImpl() {
        }

        long m1414a() {
            return ViewCompatHC.m1480a();
        }

        public float m1420d(View view) {
            return ViewCompatHC.m1479a(view);
        }

        public void m1416a(View view, int i, Paint paint) {
            ViewCompatHC.m1482a(view, i, paint);
        }

        public int m1421e(View view) {
            return ViewCompatHC.m1484b(view);
        }

        public void m1417a(View view, Paint paint) {
            m1416a(view, m1421e(view), paint);
            view.invalidate();
        }

        public void m1415a(View view, float f) {
            ViewCompatHC.m1481a(view, f);
        }

        public void m1419b(View view, float f) {
            ViewCompatHC.m1485b(view, f);
        }

        public float m1422j(View view) {
            return ViewCompatHC.m1486c(view);
        }

        public void m1418a(View view, boolean z) {
            ViewCompatHC.m1483a(view, z);
        }
    }

    static class ICSViewCompatImpl extends HCViewCompatImpl {
        static boolean f828b;

        ICSViewCompatImpl() {
        }

        static {
            f828b = false;
        }

        public boolean m1426a(View view, int i) {
            return ViewCompatICS.m1489a(view, i);
        }

        public boolean m1427b(View view, int i) {
            return ViewCompatICS.m1491b(view, i);
        }

        public void m1425a(View view, AccessibilityEvent accessibilityEvent) {
            ViewCompatICS.m1487a(view, accessibilityEvent);
        }

        public void m1424a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewCompatICS.m1490b(view, accessibilityNodeInfoCompat.m1797a());
        }

        public void m1423a(View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
            ViewCompatICS.m1488a(view, accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.m1190a());
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ImportantForAccessibility {
    }

    static class JBViewCompatImpl extends ICSViewCompatImpl {
        JBViewCompatImpl() {
        }

        public void m1432b(View view) {
            ViewCompatJB.m1492a(view);
        }

        public void m1428a(View view, int i, int i2, int i3, int i4) {
            ViewCompatJB.m1494a(view, i, i2, i3, i4);
        }

        public void m1429a(View view, Runnable runnable) {
            ViewCompatJB.m1495a(view, runnable);
        }

        public void m1430a(View view, Runnable runnable, long j) {
            ViewCompatJB.m1496a(view, runnable, j);
        }

        public int m1433c(View view) {
            return ViewCompatJB.m1498b(view);
        }

        public void m1434c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            ViewCompatJB.m1493a(view, i);
        }

        public boolean m1431a(View view, int i, Bundle bundle) {
            return ViewCompatJB.m1497a(view, i, bundle);
        }

        public ViewParent m1435g(View view) {
            return ViewCompatJB.m1499c(view);
        }

        public boolean m1437l(View view) {
            return ViewCompatJB.m1500d(view);
        }

        public boolean m1436i(View view) {
            return ViewCompatJB.m1501e(view);
        }
    }

    static class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        JbMr1ViewCompatImpl() {
        }

        public void m1438a(View view, Paint paint) {
            ViewCompatJellybeanMr1.m1503a(view, paint);
        }

        public int m1439f(View view) {
            return ViewCompatJellybeanMr1.m1502a(view);
        }
    }

    static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
        JbMr2ViewCompatImpl() {
        }
    }

    static class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
        KitKatViewCompatImpl() {
        }

        public void m1440c(View view, int i) {
            ViewCompatJB.m1493a(view, i);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface LayerType {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface LayoutDirectionMode {
    }

    static class LollipopViewCompatImpl extends KitKatViewCompatImpl {
        LollipopViewCompatImpl() {
        }

        public void m1441c(View view, float f) {
            ViewCompatLollipop.m1505a(view, f);
        }

        public float m1442k(View view) {
            return ViewCompatLollipop.m1504a(view);
        }

        public boolean m1443m(View view) {
            return ViewCompatLollipop.m1506b(view);
        }

        public void m1444n(View view) {
            ViewCompatLollipop.m1507c(view);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface OverScroll {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ResolvedLayoutDirectionMode {
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f829a = new LollipopViewCompatImpl();
        } else if (i >= 19) {
            f829a = new KitKatViewCompatImpl();
        } else if (i >= 17) {
            f829a = new JbMr1ViewCompatImpl();
        } else if (i >= 16) {
            f829a = new JBViewCompatImpl();
        } else if (i >= 14) {
            f829a = new ICSViewCompatImpl();
        } else if (i >= 11) {
            f829a = new HCViewCompatImpl();
        } else if (i >= 9) {
            f829a = new GBViewCompatImpl();
        } else if (i >= 7) {
            f829a = new EclairMr1ViewCompatImpl();
        } else {
            f829a = new BaseViewCompatImpl();
        }
    }

    public static boolean m1457a(View view, int i) {
        return f829a.m1358a(view, i);
    }

    public static boolean m1461b(View view, int i) {
        return f829a.m1362b(view, i);
    }

    public static int m1445a(View view) {
        return f829a.m1346a(view);
    }

    public static void m1452a(View view, AccessibilityEvent accessibilityEvent) {
        f829a.m1353a(view, accessibilityEvent);
    }

    public static void m1451a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f829a.m1352a(view, accessibilityNodeInfoCompat);
    }

    public static void m1450a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        f829a.m1351a(view, accessibilityDelegateCompat);
    }

    public static void m1459b(View view) {
        f829a.m1360b(view);
    }

    public static void m1447a(View view, int i, int i2, int i3, int i4) {
        f829a.m1348a(view, i, i2, i3, i4);
    }

    public static void m1453a(View view, Runnable runnable) {
        f829a.m1354a(view, runnable);
    }

    public static void m1454a(View view, Runnable runnable, long j) {
        f829a.m1355a(view, runnable, j);
    }

    public static int m1462c(View view) {
        return f829a.m1363c(view);
    }

    public static void m1464c(View view, int i) {
        f829a.m1365c(view, i);
    }

    public static boolean m1458a(View view, int i, Bundle bundle) {
        return f829a.m1359a(view, i, bundle);
    }

    public static float m1465d(View view) {
        return f829a.m1366d(view);
    }

    public static void m1448a(View view, int i, Paint paint) {
        f829a.m1349a(view, i, paint);
    }

    public static int m1466e(View view) {
        return f829a.m1367e(view);
    }

    public static void m1449a(View view, Paint paint) {
        f829a.m1350a(view, paint);
    }

    public static int m1467f(View view) {
        return f829a.m1368f(view);
    }

    public static ViewParent m1468g(View view) {
        return f829a.m1369g(view);
    }

    public static boolean m1469h(View view) {
        return f829a.m1370h(view);
    }

    public static void m1446a(View view, float f) {
        f829a.m1347a(view, f);
    }

    public static void m1460b(View view, float f) {
        f829a.m1361b(view, f);
    }

    public static float m1470i(View view) {
        return f829a.m1372j(view);
    }

    public static void m1463c(View view, float f) {
        f829a.m1364c(view, f);
    }

    public static float m1471j(View view) {
        return f829a.m1373k(view);
    }

    public static void m1456a(ViewGroup viewGroup, boolean z) {
        f829a.m1357a(viewGroup, z);
    }

    public static boolean m1472k(View view) {
        return f829a.m1374l(view);
    }

    public static void m1455a(View view, boolean z) {
        f829a.m1356a(view, z);
    }

    public static boolean m1473l(View view) {
        return f829a.m1371i(view);
    }

    public static boolean m1474m(View view) {
        return f829a.m1375m(view);
    }

    public static void m1475n(View view) {
        f829a.m1376n(view);
    }
}
