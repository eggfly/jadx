package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ViewPropertyAnimatorCompat {
    static final ViewPropertyAnimatorCompatImpl f907a;
    private Runnable f908b;
    private Runnable f909c;
    private int f910d;

    interface ViewPropertyAnimatorCompatImpl {
    }

    static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Runnable> f904a;

        class Starter implements Runnable {
            WeakReference<View> f901a;
            ViewPropertyAnimatorCompat f902b;
            final /* synthetic */ BaseViewPropertyAnimatorCompatImpl f903c;

            public void run() {
                View view = (View) this.f901a.get();
                if (view != null) {
                    this.f903c.m1616a(this.f902b, view);
                }
            }
        }

        BaseViewPropertyAnimatorCompatImpl() {
            this.f904a = null;
        }

        private void m1616a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener;
            Object tag = view.getTag(2113929216);
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            } else {
                viewPropertyAnimatorListener = null;
            }
            Runnable a = viewPropertyAnimatorCompat.f908b;
            Runnable b = viewPropertyAnimatorCompat.f909c;
            if (a != null) {
                a.run();
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.m1617a(view);
                viewPropertyAnimatorListener.m1618b(view);
            }
            if (b != null) {
                b.run();
            }
            if (this.f904a != null) {
                this.f904a.remove(view);
            }
        }
    }

    static class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Integer> f906b;

        static class MyVpaListener implements ViewPropertyAnimatorListener {
            ViewPropertyAnimatorCompat f905a;

            public void m1620a(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                if (this.f905a.f910d >= 0) {
                    ViewCompat.m1448a(view, 2, null);
                }
                if (this.f905a.f908b != null) {
                    this.f905a.f908b.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.m1617a(view);
                }
            }

            public void m1621b(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                if (this.f905a.f910d >= 0) {
                    ViewCompat.m1448a(view, this.f905a.f910d, null);
                    this.f905a.f910d = -1;
                }
                if (this.f905a.f909c != null) {
                    this.f905a.f909c.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.m1618b(view);
                }
            }

            public void m1622c(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.m1619c(view);
                }
            }
        }

        ICSViewPropertyAnimatorCompatImpl() {
            this.f906b = null;
        }
    }

    static class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
        JBViewPropertyAnimatorCompatImpl() {
        }
    }

    static class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
        }
    }

    static class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl {
        KitKatViewPropertyAnimatorCompatImpl() {
        }
    }

    static class LollipopViewPropertyAnimatorCompatImpl extends KitKatViewPropertyAnimatorCompatImpl {
        LollipopViewPropertyAnimatorCompatImpl() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f907a = new LollipopViewPropertyAnimatorCompatImpl();
        } else if (i >= 19) {
            f907a = new KitKatViewPropertyAnimatorCompatImpl();
        } else if (i >= 18) {
            f907a = new JBMr2ViewPropertyAnimatorCompatImpl();
        } else if (i >= 16) {
            f907a = new JBViewPropertyAnimatorCompatImpl();
        } else if (i >= 14) {
            f907a = new ICSViewPropertyAnimatorCompatImpl();
        } else {
            f907a = new BaseViewPropertyAnimatorCompatImpl();
        }
    }
}
