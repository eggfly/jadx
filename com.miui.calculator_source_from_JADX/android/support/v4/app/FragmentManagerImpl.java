package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory {
    static final Interpolator f212A;
    static final Interpolator f213B;
    static final Interpolator f214C;
    static boolean f215a;
    static final boolean f216b;
    static final Interpolator f217z;
    ArrayList<Runnable> f218c;
    Runnable[] f219d;
    boolean f220e;
    ArrayList<Fragment> f221f;
    ArrayList<Fragment> f222g;
    ArrayList<Integer> f223h;
    ArrayList<BackStackRecord> f224i;
    ArrayList<Fragment> f225j;
    ArrayList<BackStackRecord> f226k;
    ArrayList<Integer> f227l;
    ArrayList<OnBackStackChangedListener> f228m;
    int f229n;
    FragmentHostCallback f230o;
    FragmentContainer f231p;
    Fragment f232q;
    boolean f233r;
    boolean f234s;
    boolean f235t;
    String f236u;
    boolean f237v;
    Bundle f238w;
    SparseArray<Parcelable> f239x;
    Runnable f240y;

    /* renamed from: android.support.v4.app.FragmentManagerImpl.1 */
    class C00151 implements Runnable {
        final /* synthetic */ FragmentManagerImpl f199a;

        C00151(FragmentManagerImpl fragmentManagerImpl) {
            this.f199a = fragmentManagerImpl;
        }

        public void run() {
            this.f199a.m360e();
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl.2 */
    class C00162 implements Runnable {
        final /* synthetic */ FragmentManagerImpl f200a;

        public void run() {
            this.f200a.m341a(this.f200a.f230o.m243h(), null, -1, 0);
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl.3 */
    class C00173 implements Runnable {
        final /* synthetic */ String f201a;
        final /* synthetic */ int f202b;
        final /* synthetic */ FragmentManagerImpl f203c;

        public void run() {
            this.f203c.m341a(this.f203c.f230o.m243h(), this.f201a, -1, this.f202b);
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl.4 */
    class C00184 implements Runnable {
        final /* synthetic */ int f204a;
        final /* synthetic */ int f205b;
        final /* synthetic */ FragmentManagerImpl f206c;

        C00184(FragmentManagerImpl fragmentManagerImpl, int i, int i2) {
            this.f206c = fragmentManagerImpl;
            this.f204a = i;
            this.f205b = i2;
        }

        public void run() {
            this.f206c.m341a(this.f206c.f230o.m243h(), null, this.f204a, this.f205b);
        }
    }

    static class AnimateOnHWLayerIfNeededListener implements AnimationListener {
        private boolean f207a;
        private View f208b;

        public AnimateOnHWLayerIfNeededListener(View view, Animation animation) {
            this.f207a = false;
            if (view != null && animation != null) {
                this.f208b = view;
            }
        }

        @CallSuper
        public void onAnimationStart(Animation animation) {
            this.f207a = FragmentManagerImpl.m314a(this.f208b, animation);
            if (this.f207a) {
                ViewCompat.m1448a(this.f208b, 2, null);
            }
        }

        @CallSuper
        public void onAnimationEnd(Animation animation) {
            if (this.f207a) {
                ViewCompat.m1448a(this.f208b, 0, null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl.5 */
    class C00195 extends AnimateOnHWLayerIfNeededListener {
        final /* synthetic */ Fragment f209a;
        final /* synthetic */ FragmentManagerImpl f210b;

        C00195(FragmentManagerImpl fragmentManagerImpl, View view, Animation animation, Fragment fragment) {
            this.f210b = fragmentManagerImpl;
            this.f209a = fragment;
            super(view, animation);
        }

        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            if (this.f209a.f149l != null) {
                this.f209a.f149l = null;
                this.f210b.m336a(this.f209a, this.f209a.f150m, 0, 0, false);
            }
        }
    }

    static class FragmentTag {
        public static final int[] f211a;

        FragmentTag() {
        }

        static {
            f211a = new int[]{16842755, 16842960, 16842961};
        }
    }

    FragmentManagerImpl() {
        this.f229n = 0;
        this.f238w = null;
        this.f239x = null;
        this.f240y = new C00151(this);
    }

    static {
        boolean z = false;
        f215a = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f216b = z;
        f217z = new DecelerateInterpolator(2.5f);
        f212A = new DecelerateInterpolator(1.5f);
        f213B = new AccelerateInterpolator(2.5f);
        f214C = new AccelerateInterpolator(1.5f);
    }

    static boolean m315a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean m314a(View view, Animation animation) {
        return VERSION.SDK_INT >= 16 && ViewCompat.m1466e(view) == 0 && ViewCompat.m1473l(view) && m315a(animation);
    }

    private void m313a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        if (this.f230o != null) {
            try {
                this.f230o.m231a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m340a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public FragmentTransaction m324a() {
        return new BackStackRecord(this);
    }

    public boolean m350b() {
        return m360e();
    }

    public boolean m354c() {
        m319u();
        m350b();
        return m341a(this.f230o.m243h(), null, -1, 0);
    }

    public void m327a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m339a(new C00184(this, i, i2), false);
    }

    public void m332a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f153p < 0) {
            m313a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f153p);
    }

    public Fragment m322a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f221f.size()) {
            m313a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f221f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m313a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f232q != null) {
            DebugUtils.m1096a(this.f232q, stringBuilder);
        } else {
            DebugUtils.m1096a(this.f230o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m340a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f221f != null) {
            size = this.f221f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f221f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.m164a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f222g != null) {
            size = this.f222g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f222g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f225j != null) {
            size = this.f225j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f225j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f224i != null) {
            size = this.f224i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.f224i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.m127a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f226k != null) {
                int size2 = this.f226k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        backStackRecord = (BackStackRecord) this.f226k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(backStackRecord);
                    }
                }
            }
            if (this.f227l != null && this.f227l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f227l.toArray()));
            }
        }
        if (this.f218c != null) {
            i = this.f218c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f218c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f230o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f231p);
        if (this.f232q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f232q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f229n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f234s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f235t);
        if (this.f233r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f233r);
        }
        if (this.f236u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f236u);
        }
        if (this.f223h != null && this.f223h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f223h.toArray()));
        }
    }

    static Animation m312a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f217z);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f212A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation m311a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f212A);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation m326a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m151a(i, z, fragment.f138Q);
        if (a != null) {
            return a;
        }
        if (fragment.f138Q != 0) {
            a = AnimationUtils.loadAnimation(this.f230o.m242g(), fragment.f138Q);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = m316b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return m312a(this.f230o.m242g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return m312a(this.f230o.m242g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                return m312a(this.f230o.m242g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                return m312a(this.f230o.m242g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                return m311a(this.f230o.m242g(), 0.0f, 1.0f);
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                return m311a(this.f230o.m242g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f230o.m239d()) {
                    i2 = this.f230o.m240e();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m334a(Fragment fragment) {
        if (!fragment.f142U) {
            return;
        }
        if (this.f220e) {
            this.f237v = true;
            return;
        }
        fragment.f142U = false;
        m336a(fragment, this.f229n, 0, 0, false);
    }

    private void m317b(View view, Animation animation) {
        if (view != null && animation != null && m314a(view, animation)) {
            animation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(view, animation));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m336a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11.f159v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f132K;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f160w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f148k;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f148k;
    L_0x001a:
        r0 = r11.f142U;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f148k;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f148k;
        if (r0 >= r12) goto L_0x0274;
    L_0x0029:
        r0 = r11.f162y;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f163z;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f149l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f149l = r7;
        r2 = r11.f150m;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m336a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f148k;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x013e;
            case 2: goto L_0x020f;
            case 3: goto L_0x020f;
            case 4: goto L_0x0230;
            default: goto L_0x0045;
        };
    L_0x0045:
        r11.f148k = r12;
        goto L_0x0031;
    L_0x0048:
        r0 = f215a;
        if (r0 == 0) goto L_0x0064;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0064:
        r0 = r11.f151n;
        if (r0 == 0) goto L_0x00ac;
    L_0x0068:
        r0 = r11.f151n;
        r1 = r10.f230o;
        r1 = r1.m242g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f151n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f152o = r0;
        r0 = r11.f151n;
        r1 = "android:target_state";
        r0 = r10.m322a(r0, r1);
        r11.f156s = r0;
        r0 = r11.f156s;
        if (r0 == 0) goto L_0x0099;
    L_0x008f:
        r0 = r11.f151n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f158u = r0;
    L_0x0099:
        r0 = r11.f151n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f143V = r0;
        r0 = r11.f143V;
        if (r0 != 0) goto L_0x00ac;
    L_0x00a7:
        r11.f142U = r5;
        if (r12 <= r6) goto L_0x00ac;
    L_0x00ab:
        r12 = r6;
    L_0x00ac:
        r0 = r10.f230o;
        r11.f125D = r0;
        r0 = r10.f232q;
        r11.f127F = r0;
        r0 = r10.f232q;
        if (r0 == 0) goto L_0x00ec;
    L_0x00b8:
        r0 = r10.f232q;
        r0 = r0.f126E;
    L_0x00bc:
        r11.f124C = r0;
        r11.f137P = r3;
        r0 = r10.f230o;
        r0 = r0.m242g();
        r11.m157a(r0);
        r0 = r11.f137P;
        if (r0 != 0) goto L_0x00f3;
    L_0x00cd:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00ec:
        r0 = r10.f230o;
        r0 = r0.m244i();
        goto L_0x00bc;
    L_0x00f3:
        r0 = r11.f127F;
        if (r0 != 0) goto L_0x00fc;
    L_0x00f7:
        r0 = r10.f230o;
        r0.m236b(r11);
    L_0x00fc:
        r0 = r11.f134M;
        if (r0 != 0) goto L_0x0105;
    L_0x0100:
        r0 = r11.f151n;
        r11.m187h(r0);
    L_0x0105:
        r11.f134M = r3;
        r0 = r11.f162y;
        if (r0 == 0) goto L_0x013e;
    L_0x010b:
        r0 = r11.f151n;
        r0 = r11.m166b(r0);
        r1 = r11.f151n;
        r0 = r11.m167b(r0, r7, r1);
        r11.f140S = r0;
        r0 = r11.f140S;
        if (r0 == 0) goto L_0x0263;
    L_0x011d:
        r0 = r11.f140S;
        r11.f141T = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0259;
    L_0x0127:
        r0 = r11.f140S;
        android.support.v4.view.ViewCompat.m1455a(r0, r3);
    L_0x012c:
        r0 = r11.f131J;
        if (r0 == 0) goto L_0x0137;
    L_0x0130:
        r0 = r11.f140S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0137:
        r0 = r11.f140S;
        r1 = r11.f151n;
        r11.m163a(r0, r1);
    L_0x013e:
        if (r12 <= r5) goto L_0x020f;
    L_0x0140:
        r0 = f215a;
        if (r0 == 0) goto L_0x015c;
    L_0x0144:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x015c:
        r0 = r11.f162y;
        if (r0 != 0) goto L_0x01ff;
    L_0x0160:
        r0 = r11.f129H;
        if (r0 == 0) goto L_0x03d1;
    L_0x0164:
        r0 = r10.f231p;
        r1 = r11.f129H;
        r0 = r0.m221a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01b3;
    L_0x0170:
        r1 = r11.f122A;
        if (r1 != 0) goto L_0x01b3;
    L_0x0174:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "No view found for id 0x";
        r2 = r2.append(r4);
        r4 = r11.f129H;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.m186h();
        r8 = r11.f129H;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.m313a(r1);
    L_0x01b3:
        r11.f139R = r0;
        r1 = r11.f151n;
        r1 = r11.m166b(r1);
        r2 = r11.f151n;
        r1 = r11.m167b(r1, r0, r2);
        r11.f140S = r1;
        r1 = r11.f140S;
        if (r1 == 0) goto L_0x0271;
    L_0x01c7:
        r1 = r11.f140S;
        r11.f141T = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x0267;
    L_0x01d1:
        r1 = r11.f140S;
        android.support.v4.view.ViewCompat.m1455a(r1, r3);
    L_0x01d6:
        if (r0 == 0) goto L_0x01ed;
    L_0x01d8:
        r1 = r10.m326a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x01e8;
    L_0x01de:
        r2 = r11.f140S;
        r10.m317b(r2, r1);
        r2 = r11.f140S;
        r2.startAnimation(r1);
    L_0x01e8:
        r1 = r11.f140S;
        r0.addView(r1);
    L_0x01ed:
        r0 = r11.f131J;
        if (r0 == 0) goto L_0x01f8;
    L_0x01f1:
        r0 = r11.f140S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x01f8:
        r0 = r11.f140S;
        r1 = r11.f151n;
        r11.m163a(r0, r1);
    L_0x01ff:
        r0 = r11.f151n;
        r11.m189i(r0);
        r0 = r11.f140S;
        if (r0 == 0) goto L_0x020d;
    L_0x0208:
        r0 = r11.f151n;
        r11.m182f(r0);
    L_0x020d:
        r11.f151n = r7;
    L_0x020f:
        if (r12 <= r6) goto L_0x0230;
    L_0x0211:
        r0 = f215a;
        if (r0 == 0) goto L_0x022d;
    L_0x0215:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x022d:
        r11.m142C();
    L_0x0230:
        if (r12 <= r9) goto L_0x0045;
    L_0x0232:
        r0 = f215a;
        if (r0 == 0) goto L_0x024e;
    L_0x0236:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x024e:
        r11.f161x = r5;
        r11.m143D();
        r11.f151n = r7;
        r11.f152o = r7;
        goto L_0x0045;
    L_0x0259:
        r0 = r11.f140S;
        r0 = android.support.v4.app.NoSaveStateFrameLayout.m456a(r0);
        r11.f140S = r0;
        goto L_0x012c;
    L_0x0263:
        r11.f141T = r7;
        goto L_0x013e;
    L_0x0267:
        r1 = r11.f140S;
        r1 = android.support.v4.app.NoSaveStateFrameLayout.m456a(r1);
        r11.f140S = r1;
        goto L_0x01d6;
    L_0x0271:
        r11.f141T = r7;
        goto L_0x01ff;
    L_0x0274:
        r0 = r11.f148k;
        if (r0 <= r12) goto L_0x0045;
    L_0x0278:
        r0 = r11.f148k;
        switch(r0) {
            case 1: goto L_0x027f;
            case 2: goto L_0x02ff;
            case 3: goto L_0x02de;
            case 4: goto L_0x02bd;
            case 5: goto L_0x0299;
            default: goto L_0x027d;
        };
    L_0x027d:
        goto L_0x0045;
    L_0x027f:
        if (r12 >= r5) goto L_0x0045;
    L_0x0281:
        r0 = r10.f235t;
        if (r0 == 0) goto L_0x0290;
    L_0x0285:
        r0 = r11.f149l;
        if (r0 == 0) goto L_0x0290;
    L_0x0289:
        r0 = r11.f149l;
        r11.f149l = r7;
        r0.clearAnimation();
    L_0x0290:
        r0 = r11.f149l;
        if (r0 == 0) goto L_0x036e;
    L_0x0294:
        r11.f150m = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x0299:
        r0 = 5;
        if (r12 >= r0) goto L_0x02bd;
    L_0x029c:
        r0 = f215a;
        if (r0 == 0) goto L_0x02b8;
    L_0x02a0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b8:
        r11.m145F();
        r11.f161x = r3;
    L_0x02bd:
        if (r12 >= r9) goto L_0x02de;
    L_0x02bf:
        r0 = f215a;
        if (r0 == 0) goto L_0x02db;
    L_0x02c3:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02db:
        r11.m146G();
    L_0x02de:
        if (r12 >= r6) goto L_0x02ff;
    L_0x02e0:
        r0 = f215a;
        if (r0 == 0) goto L_0x02fc;
    L_0x02e4:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02fc:
        r11.m147H();
    L_0x02ff:
        r0 = 2;
        if (r12 >= r0) goto L_0x027f;
    L_0x0302:
        r0 = f215a;
        if (r0 == 0) goto L_0x031e;
    L_0x0306:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x031e:
        r0 = r11.f140S;
        if (r0 == 0) goto L_0x0331;
    L_0x0322:
        r0 = r10.f230o;
        r0 = r0.m234a(r11);
        if (r0 == 0) goto L_0x0331;
    L_0x032a:
        r0 = r11.f152o;
        if (r0 != 0) goto L_0x0331;
    L_0x032e:
        r10.m358e(r11);
    L_0x0331:
        r11.m148I();
        r0 = r11.f140S;
        if (r0 == 0) goto L_0x0366;
    L_0x0338:
        r0 = r11.f139R;
        if (r0 == 0) goto L_0x0366;
    L_0x033c:
        r0 = r10.f229n;
        if (r0 <= 0) goto L_0x03ce;
    L_0x0340:
        r0 = r10.f235t;
        if (r0 != 0) goto L_0x03ce;
    L_0x0344:
        r0 = r10.m326a(r11, r13, r3, r14);
    L_0x0348:
        if (r0 == 0) goto L_0x035f;
    L_0x034a:
        r1 = r11.f140S;
        r11.f149l = r1;
        r11.f150m = r12;
        r1 = r11.f140S;
        r2 = new android.support.v4.app.FragmentManagerImpl$5;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.f140S;
        r1.startAnimation(r0);
    L_0x035f:
        r0 = r11.f139R;
        r1 = r11.f140S;
        r0.removeView(r1);
    L_0x0366:
        r11.f139R = r7;
        r11.f140S = r7;
        r11.f141T = r7;
        goto L_0x027f;
    L_0x036e:
        r0 = f215a;
        if (r0 == 0) goto L_0x038a;
    L_0x0372:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x038a:
        r0 = r11.f134M;
        if (r0 != 0) goto L_0x0391;
    L_0x038e:
        r11.m149J();
    L_0x0391:
        r11.f137P = r3;
        r11.m168b();
        r0 = r11.f137P;
        if (r0 != 0) goto L_0x03b9;
    L_0x039a:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03b9:
        if (r15 != 0) goto L_0x0045;
    L_0x03bb:
        r0 = r11.f134M;
        if (r0 != 0) goto L_0x03c4;
    L_0x03bf:
        r10.m356d(r11);
        goto L_0x0045;
    L_0x03c4:
        r11.f125D = r7;
        r11.f127F = r7;
        r11.f124C = r7;
        r11.f126E = r7;
        goto L_0x0045;
    L_0x03ce:
        r0 = r7;
        goto L_0x0348;
    L_0x03d1:
        r0 = r7;
        goto L_0x01b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void m347b(Fragment fragment) {
        m336a(fragment, this.f229n, 0, 0, false);
    }

    void m330a(int i, boolean z) {
        m328a(i, 0, 0, z);
    }

    void m328a(int i, int i2, int i3, boolean z) {
        if (this.f230o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f229n != i) {
            this.f229n = i;
            if (this.f221f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f221f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f221f.get(i4);
                    if (fragment != null) {
                        m336a(fragment, i, i2, i3, false);
                        if (fragment.f144W != null) {
                            a = i5 | fragment.f144W.m448a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m355d();
                }
                if (this.f233r && this.f230o != null && this.f229n == 5) {
                    this.f230o.m238c();
                    this.f233r = false;
                }
            }
        }
    }

    void m355d() {
        if (this.f221f != null) {
            for (int i = 0; i < this.f221f.size(); i++) {
                Fragment fragment = (Fragment) this.f221f.get(i);
                if (fragment != null) {
                    m334a(fragment);
                }
            }
        }
    }

    void m352c(Fragment fragment) {
        if (fragment.f153p < 0) {
            if (this.f223h == null || this.f223h.size() <= 0) {
                if (this.f221f == null) {
                    this.f221f = new ArrayList();
                }
                fragment.m153a(this.f221f.size(), this.f232q);
                this.f221f.add(fragment);
            } else {
                fragment.m153a(((Integer) this.f223h.remove(this.f223h.size() - 1)).intValue(), this.f232q);
                this.f221f.set(fragment.f153p, fragment);
            }
            if (f215a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void m356d(Fragment fragment) {
        if (fragment.f153p >= 0) {
            if (f215a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f221f.set(fragment.f153p, null);
            if (this.f223h == null) {
                this.f223h = new ArrayList();
            }
            this.f223h.add(Integer.valueOf(fragment.f153p));
            this.f230o.m230a(fragment.f154q);
            fragment.m199r();
        }
    }

    public void m337a(Fragment fragment, boolean z) {
        if (this.f222g == null) {
            this.f222g = new ArrayList();
        }
        if (f215a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m352c(fragment);
        if (!fragment.f132K) {
            if (this.f222g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f222g.add(fragment);
            fragment.f159v = true;
            fragment.f160w = false;
            if (fragment.f135N && fragment.f136O) {
                this.f233r = true;
            }
            if (z) {
                m347b(fragment);
            }
        }
    }

    public void m335a(Fragment fragment, int i, int i2) {
        if (f215a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f123B);
        }
        boolean z = !fragment.m183f();
        if (!fragment.f132K || z) {
            int i3;
            if (this.f222g != null) {
                this.f222g.remove(fragment);
            }
            if (fragment.f135N && fragment.f136O) {
                this.f233r = true;
            }
            fragment.f159v = false;
            fragment.f160w = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m336a(fragment, i3, i, i2, false);
        }
    }

    public void m348b(Fragment fragment, int i, int i2) {
        if (f215a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f131J) {
            fragment.f131J = true;
            if (fragment.f140S != null) {
                Animation a = m326a(fragment, i, false, i2);
                if (a != null) {
                    m317b(fragment.f140S, a);
                    fragment.f140S.startAnimation(a);
                }
                fragment.f140S.setVisibility(8);
            }
            if (fragment.f159v && fragment.f135N && fragment.f136O) {
                this.f233r = true;
            }
            fragment.m170b(true);
        }
    }

    public void m353c(Fragment fragment, int i, int i2) {
        if (f215a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f131J) {
            fragment.f131J = false;
            if (fragment.f140S != null) {
                Animation a = m326a(fragment, i, true, i2);
                if (a != null) {
                    m317b(fragment.f140S, a);
                    fragment.f140S.startAnimation(a);
                }
                fragment.f140S.setVisibility(0);
            }
            if (fragment.f159v && fragment.f135N && fragment.f136O) {
                this.f233r = true;
            }
            fragment.m170b(false);
        }
    }

    public void m357d(Fragment fragment, int i, int i2) {
        if (f215a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f132K) {
            fragment.f132K = true;
            if (fragment.f159v) {
                if (this.f222g != null) {
                    if (f215a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f222g.remove(fragment);
                }
                if (fragment.f135N && fragment.f136O) {
                    this.f233r = true;
                }
                fragment.f159v = false;
                m336a(fragment, 1, i, i2, false);
            }
        }
    }

    public void m359e(Fragment fragment, int i, int i2) {
        if (f215a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f132K) {
            fragment.f132K = false;
            if (!fragment.f159v) {
                if (this.f222g == null) {
                    this.f222g = new ArrayList();
                }
                if (this.f222g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f215a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f222g.add(fragment);
                fragment.f159v = true;
                if (fragment.f135N && fragment.f136O) {
                    this.f233r = true;
                }
                m336a(fragment, this.f229n, i, i2, false);
            }
        }
    }

    public Fragment m321a(int i) {
        int size;
        Fragment fragment;
        if (this.f222g != null) {
            for (size = this.f222g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f222g.get(size);
                if (fragment != null && fragment.f128G == i) {
                    return fragment;
                }
            }
        }
        if (this.f221f != null) {
            for (size = this.f221f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f221f.get(size);
                if (fragment != null && fragment.f128G == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m323a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f222g == null || str == null)) {
            for (size = this.f222g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f222g.get(size);
                if (fragment != null && str.equals(fragment.f130I)) {
                    return fragment;
                }
            }
        }
        if (!(this.f221f == null || str == null)) {
            for (size = this.f221f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f221f.get(size);
                if (fragment != null && str.equals(fragment.f130I)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    private void m319u() {
        if (this.f234s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f236u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f236u);
        }
    }

    public void m339a(Runnable runnable, boolean z) {
        if (!z) {
            m319u();
        }
        synchronized (this) {
            if (this.f235t || this.f230o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f218c == null) {
                this.f218c = new ArrayList();
            }
            this.f218c.add(runnable);
            if (this.f218c.size() == 1) {
                this.f230o.m243h().removeCallbacks(this.f240y);
                this.f230o.m243h().post(this.f240y);
            }
        }
    }

    public int m320a(BackStackRecord backStackRecord) {
        int size;
        synchronized (this) {
            if (this.f227l == null || this.f227l.size() <= 0) {
                if (this.f226k == null) {
                    this.f226k = new ArrayList();
                }
                size = this.f226k.size();
                if (f215a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + backStackRecord);
                }
                this.f226k.add(backStackRecord);
            } else {
                size = ((Integer) this.f227l.remove(this.f227l.size() - 1)).intValue();
                if (f215a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + backStackRecord);
                }
                this.f226k.set(size, backStackRecord);
            }
        }
        return size;
    }

    public void m329a(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.f226k == null) {
                this.f226k = new ArrayList();
            }
            int size = this.f226k.size();
            if (i < size) {
                if (f215a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.f226k.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.f226k.add(null);
                    if (this.f227l == null) {
                        this.f227l = new ArrayList();
                    }
                    if (f215a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f227l.add(Integer.valueOf(size));
                    size++;
                }
                if (f215a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.f226k.add(backStackRecord);
            }
        }
    }

    public void m345b(int i) {
        synchronized (this) {
            this.f226k.set(i, null);
            if (this.f227l == null) {
                this.f227l = new ArrayList();
            }
            if (f215a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f227l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m360e() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f220e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f230o;
        r3 = r3.m243h();
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f218c;	 Catch:{ all -> 0x009d }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f218c;	 Catch:{ all -> 0x009d }
        r3 = r3.size();	 Catch:{ all -> 0x009d }
        if (r3 != 0) goto L_0x005e;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x009d }
        r0 = r6.f237v;
        if (r0 == 0) goto L_0x00ab;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.f221f;
        r0 = r0.size();
        if (r4 >= r0) goto L_0x00a4;
    L_0x0043:
        r0 = r6.f221f;
        r0 = r0.get(r4);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x00ac;
    L_0x004d:
        r5 = r0.f144W;
        if (r5 == 0) goto L_0x00ac;
    L_0x0051:
        r0 = r0.f144W;
        r0 = r0.m448a();
        r3 = r3 | r0;
        r0 = r3;
    L_0x0059:
        r3 = r4 + 1;
        r4 = r3;
        r3 = r0;
        goto L_0x003b;
    L_0x005e:
        r1 = r6.f218c;	 Catch:{ all -> 0x009d }
        r3 = r1.size();	 Catch:{ all -> 0x009d }
        r1 = r6.f219d;	 Catch:{ all -> 0x009d }
        if (r1 == 0) goto L_0x006d;
    L_0x0068:
        r1 = r6.f219d;	 Catch:{ all -> 0x009d }
        r1 = r1.length;	 Catch:{ all -> 0x009d }
        if (r1 >= r3) goto L_0x0071;
    L_0x006d:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x009d }
        r6.f219d = r1;	 Catch:{ all -> 0x009d }
    L_0x0071:
        r1 = r6.f218c;	 Catch:{ all -> 0x009d }
        r4 = r6.f219d;	 Catch:{ all -> 0x009d }
        r1.toArray(r4);	 Catch:{ all -> 0x009d }
        r1 = r6.f218c;	 Catch:{ all -> 0x009d }
        r1.clear();	 Catch:{ all -> 0x009d }
        r1 = r6.f230o;	 Catch:{ all -> 0x009d }
        r1 = r1.m243h();	 Catch:{ all -> 0x009d }
        r4 = r6.f240y;	 Catch:{ all -> 0x009d }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x009d }
        monitor-exit(r6);	 Catch:{ all -> 0x009d }
        r6.f220e = r0;
        r1 = r2;
    L_0x008c:
        if (r1 >= r3) goto L_0x00a0;
    L_0x008e:
        r4 = r6.f219d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f219d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x008c;
    L_0x009d:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x009d }
        throw r0;
    L_0x00a0:
        r6.f220e = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a4:
        if (r3 != 0) goto L_0x00ab;
    L_0x00a6:
        r6.f237v = r2;
        r6.m355d();
    L_0x00ab:
        return r1;
    L_0x00ac:
        r0 = r3;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.e():boolean");
    }

    void m362f() {
        if (this.f228m != null) {
            for (int i = 0; i < this.f228m.size(); i++) {
                ((OnBackStackChangedListener) this.f228m.get(i)).m303a();
            }
        }
    }

    void m346b(BackStackRecord backStackRecord) {
        if (this.f224i == null) {
            this.f224i = new ArrayList();
        }
        this.f224i.add(backStackRecord);
        m362f();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m341a(android.os.Handler r12, java.lang.String r13, int r14, int r15) {
        /*
        r11 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r11.f224i;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r3;
    L_0x0008:
        if (r13 != 0) goto L_0x0037;
    L_0x000a:
        if (r14 >= 0) goto L_0x0037;
    L_0x000c:
        r0 = r15 & 1;
        if (r0 != 0) goto L_0x0037;
    L_0x0010:
        r0 = r11.f224i;
        r0 = r0.size();
        r0 = r0 + -1;
        if (r0 < 0) goto L_0x0007;
    L_0x001a:
        r1 = r11.f224i;
        r0 = r1.remove(r0);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        r1 = new android.util.SparseArray;
        r1.<init>();
        r3 = new android.util.SparseArray;
        r3.<init>();
        r0.m126a(r1, r3);
        r0.m121a(r2, r4, r1, r3);
        r11.m362f();
    L_0x0035:
        r3 = r2;
        goto L_0x0007;
    L_0x0037:
        r0 = -1;
        if (r13 != 0) goto L_0x003c;
    L_0x003a:
        if (r14 < 0) goto L_0x008b;
    L_0x003c:
        r0 = r11.f224i;
        r0 = r0.size();
        r1 = r0 + -1;
    L_0x0044:
        if (r1 < 0) goto L_0x005a;
    L_0x0046:
        r0 = r11.f224i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        if (r13 == 0) goto L_0x0081;
    L_0x0050:
        r5 = r0.m132c();
        r5 = r13.equals(r5);
        if (r5 == 0) goto L_0x0081;
    L_0x005a:
        if (r1 < 0) goto L_0x0007;
    L_0x005c:
        r0 = r15 & 1;
        if (r0 == 0) goto L_0x008a;
    L_0x0060:
        r1 = r1 + -1;
    L_0x0062:
        if (r1 < 0) goto L_0x008a;
    L_0x0064:
        r0 = r11.f224i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        if (r13 == 0) goto L_0x0078;
    L_0x006e:
        r5 = r0.m132c();
        r5 = r13.equals(r5);
        if (r5 != 0) goto L_0x007e;
    L_0x0078:
        if (r14 < 0) goto L_0x008a;
    L_0x007a:
        r0 = r0.f102p;
        if (r14 != r0) goto L_0x008a;
    L_0x007e:
        r1 = r1 + -1;
        goto L_0x0062;
    L_0x0081:
        if (r14 < 0) goto L_0x0087;
    L_0x0083:
        r0 = r0.f102p;
        if (r14 == r0) goto L_0x005a;
    L_0x0087:
        r1 = r1 + -1;
        goto L_0x0044;
    L_0x008a:
        r0 = r1;
    L_0x008b:
        r1 = r11.f224i;
        r1 = r1.size();
        r1 = r1 + -1;
        if (r0 == r1) goto L_0x0007;
    L_0x0095:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r1 = r11.f224i;
        r1 = r1.size();
        r1 = r1 + -1;
    L_0x00a2:
        if (r1 <= r0) goto L_0x00b0;
    L_0x00a4:
        r5 = r11.f224i;
        r5 = r5.remove(r1);
        r6.add(r5);
        r1 = r1 + -1;
        goto L_0x00a2;
    L_0x00b0:
        r0 = r6.size();
        r7 = r0 + -1;
        r8 = new android.util.SparseArray;
        r8.<init>();
        r9 = new android.util.SparseArray;
        r9.<init>();
        r1 = r3;
    L_0x00c1:
        if (r1 > r7) goto L_0x00d0;
    L_0x00c3:
        r0 = r6.get(r1);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        r0.m126a(r8, r9);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00c1;
    L_0x00d0:
        r5 = r4;
        r4 = r3;
    L_0x00d2:
        if (r4 > r7) goto L_0x0108;
    L_0x00d4:
        r0 = f215a;
        if (r0 == 0) goto L_0x00f4;
    L_0x00d8:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = "Popping back stack state: ";
        r1 = r1.append(r10);
        r10 = r6.get(r4);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00f4:
        r0 = r6.get(r4);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        if (r4 != r7) goto L_0x0106;
    L_0x00fc:
        r1 = r2;
    L_0x00fd:
        r1 = r0.m121a(r1, r5, r8, r9);
        r0 = r4 + 1;
        r4 = r0;
        r5 = r1;
        goto L_0x00d2;
    L_0x0106:
        r1 = r3;
        goto L_0x00fd;
    L_0x0108:
        r11.m362f();
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.a(android.os.Handler, java.lang.String, int, int):boolean");
    }

    ArrayList<Fragment> m363g() {
        ArrayList<Fragment> arrayList = null;
        if (this.f221f != null) {
            for (int i = 0; i < this.f221f.size(); i++) {
                Fragment fragment = (Fragment) this.f221f.get(i);
                if (fragment != null && fragment.f133L) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.f134M = true;
                    fragment.f157t = fragment.f156s != null ? fragment.f156s.f153p : -1;
                    if (f215a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    void m358e(Fragment fragment) {
        if (fragment.f141T != null) {
            if (this.f239x == null) {
                this.f239x = new SparseArray();
            } else {
                this.f239x.clear();
            }
            fragment.f141T.saveHierarchyState(this.f239x);
            if (this.f239x.size() > 0) {
                fragment.f152o = this.f239x;
                this.f239x = null;
            }
        }
    }

    Bundle m361f(Fragment fragment) {
        Bundle bundle;
        if (this.f238w == null) {
            this.f238w = new Bundle();
        }
        fragment.m191j(this.f238w);
        if (this.f238w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f238w;
            this.f238w = null;
        }
        if (fragment.f140S != null) {
            m358e(fragment);
        }
        if (fragment.f152o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f152o);
        }
        if (!fragment.f143V) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f143V);
        }
        return bundle;
    }

    Parcelable m364h() {
        BackStackState[] backStackStateArr = null;
        m360e();
        if (f216b) {
            this.f234s = true;
        }
        if (this.f221f == null || this.f221f.size() <= 0) {
            return null;
        }
        int size = this.f221f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f221f.get(i);
            if (fragment != null) {
                if (fragment.f153p < 0) {
                    m313a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f153p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f148k <= 0 || fragmentState.f253j != null) {
                    fragmentState.f253j = fragment.f151n;
                } else {
                    fragmentState.f253j = m361f(fragment);
                    if (fragment.f156s != null) {
                        if (fragment.f156s.f153p < 0) {
                            m313a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f156s));
                        }
                        if (fragmentState.f253j == null) {
                            fragmentState.f253j = new Bundle();
                        }
                        m332a(fragmentState.f253j, "android:target_state", fragment.f156s);
                        if (fragment.f158u != 0) {
                            fragmentState.f253j.putInt("android:target_req_state", fragment.f158u);
                        }
                    }
                }
                if (f215a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f253j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f222g != null) {
                i = this.f222g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f222g.get(i2)).f153p;
                        if (iArr[i2] < 0) {
                            m313a(new IllegalStateException("Failure saving state: active " + this.f222g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f215a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f222g.get(i2));
                        }
                    }
                    if (this.f224i != null) {
                        i = this.f224i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((BackStackRecord) this.f224i.get(i2));
                                if (f215a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f224i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f241a = fragmentStateArr;
                    fragmentManagerState.f242b = iArr;
                    fragmentManagerState.f243c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f224i != null) {
                i = this.f224i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((BackStackRecord) this.f224i.get(i2));
                        if (f215a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f224i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f241a = fragmentStateArr;
            fragmentManagerState.f242b = iArr;
            fragmentManagerState.f243c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f215a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void m333a(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f241a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (f215a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f241a[fragment.f153p];
                        fragmentState.f254k = fragment;
                        fragment.f152o = null;
                        fragment.f123B = 0;
                        fragment.f163z = false;
                        fragment.f159v = false;
                        fragment.f156s = null;
                        if (fragmentState.f253j != null) {
                            fragmentState.f253j.setClassLoader(this.f230o.m242g().getClassLoader());
                            fragment.f152o = fragmentState.f253j.getSparseParcelableArray("android:view_state");
                            fragment.f151n = fragmentState.f253j;
                        }
                    }
                }
                this.f221f = new ArrayList(fragmentManagerState.f241a.length);
                if (this.f223h != null) {
                    this.f223h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.f241a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f241a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.m381a(this.f230o, this.f232q);
                        if (f215a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f221f.add(a);
                        fragmentState2.f254k = null;
                    } else {
                        this.f221f.add(null);
                        if (this.f223h == null) {
                            this.f223h = new ArrayList();
                        }
                        if (f215a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f223h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.f157t >= 0) {
                            if (fragment.f157t < this.f221f.size()) {
                                fragment.f156s = (Fragment) this.f221f.get(fragment.f157t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f157t);
                                fragment.f156s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f242b != null) {
                    this.f222g = new ArrayList(fragmentManagerState.f242b.length);
                    for (i = 0; i < fragmentManagerState.f242b.length; i++) {
                        fragment = (Fragment) this.f221f.get(fragmentManagerState.f242b[i]);
                        if (fragment == null) {
                            m313a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f242b[i]));
                        }
                        fragment.f159v = true;
                        if (f215a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.f222g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f222g.add(fragment);
                    }
                } else {
                    this.f222g = null;
                }
                if (fragmentManagerState.f243c != null) {
                    this.f224i = new ArrayList(fragmentManagerState.f243c.length);
                    for (i2 = 0; i2 < fragmentManagerState.f243c.length; i2++) {
                        BackStackRecord a2 = fragmentManagerState.f243c[i2].m135a(this);
                        if (f215a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f102p + "): " + a2);
                            a2.m128a("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
                        }
                        this.f224i.add(a2);
                        if (a2.f102p >= 0) {
                            m329a(a2.f102p, a2);
                        }
                    }
                    return;
                }
                this.f224i = null;
            }
        }
    }

    public void m338a(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.f230o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f230o = fragmentHostCallback;
        this.f231p = fragmentContainer;
        this.f232q = fragment;
    }

    public void m365i() {
        this.f234s = false;
    }

    public void m366j() {
        this.f234s = false;
        m330a(1, false);
    }

    public void m367k() {
        this.f234s = false;
        m330a(2, false);
    }

    public void m368l() {
        this.f234s = false;
        m330a(4, false);
    }

    public void m369m() {
        this.f234s = false;
        m330a(5, false);
    }

    public void m370n() {
        m330a(4, false);
    }

    public void m371o() {
        this.f234s = true;
        m330a(3, false);
    }

    public void m372p() {
        m330a(2, false);
    }

    public void m373q() {
        m330a(1, false);
    }

    public void m374r() {
        this.f235t = true;
        m360e();
        m330a(0, false);
        this.f230o = null;
        this.f231p = null;
        this.f232q = null;
    }

    public void m331a(Configuration configuration) {
        if (this.f222g != null) {
            for (int i = 0; i < this.f222g.size(); i++) {
                Fragment fragment = (Fragment) this.f222g.get(i);
                if (fragment != null) {
                    fragment.m159a(configuration);
                }
            }
        }
    }

    public void m375s() {
        if (this.f222g != null) {
            for (int i = 0; i < this.f222g.size(); i++) {
                Fragment fragment = (Fragment) this.f222g.get(i);
                if (fragment != null) {
                    fragment.m144E();
                }
            }
        }
    }

    public boolean m343a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f222g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f222g.size()) {
                fragment = (Fragment) this.f222g.get(i2);
                if (fragment != null && fragment.m171b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f225j != null) {
            while (i < this.f225j.size()) {
                fragment = (Fragment) this.f225j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m200s();
                }
                i++;
            }
        }
        this.f225j = arrayList;
        return z;
    }

    public boolean m342a(Menu menu) {
        if (this.f222g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f222g.size(); i++) {
            Fragment fragment = (Fragment) this.f222g.get(i);
            if (fragment != null && fragment.m174c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m344a(MenuItem menuItem) {
        if (this.f222g == null) {
            return false;
        }
        for (int i = 0; i < this.f222g.size(); i++) {
            Fragment fragment = (Fragment) this.f222g.get(i);
            if (fragment != null && fragment.m175c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean m351b(MenuItem menuItem) {
        if (this.f222g == null) {
            return false;
        }
        for (int i = 0; i < this.f222g.size(); i++) {
            Fragment fragment = (Fragment) this.f222g.get(i);
            if (fragment != null && fragment.m179d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m349b(Menu menu) {
        if (this.f222g != null) {
            for (int i = 0; i < this.f222g.size(); i++) {
                Fragment fragment = (Fragment) this.f222g.get(i);
                if (fragment != null) {
                    fragment.m178d(menu);
                }
            }
        }
    }

    public static int m318c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int m316b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View m325a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentTag.f211a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m139b(this.f230o.m242g(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment a = resourceId != -1 ? m321a(resourceId) : null;
        if (a == null && string2 != null) {
            a = m323a(string2);
        }
        if (a == null && id != -1) {
            a = m321a(id);
        }
        if (f215a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment a2 = Fragment.m137a(context, string);
            a2.f162y = true;
            a2.f128G = resourceId != 0 ? resourceId : id;
            a2.f129H = id;
            a2.f130I = string2;
            a2.f163z = true;
            a2.f124C = this;
            a2.m158a(this.f230o.m242g(), attributeSet, a2.f151n);
            m337a(a2, true);
            fragment = a2;
        } else if (a.f163z) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.f163z = true;
            if (!a.f134M) {
                a.m158a(this.f230o.m242g(), attributeSet, a.f151n);
            }
            fragment = a;
        }
        if (this.f229n >= 1 || !fragment.f162y) {
            m347b(fragment);
        } else {
            m336a(fragment, 1, 0, 0, false);
        }
        if (fragment.f140S == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f140S.setId(resourceId);
        }
        if (fragment.f140S.getTag() == null) {
            fragment.f140S.setTag(string2);
        }
        return fragment.f140S;
    }

    LayoutInflaterFactory m376t() {
        return this;
    }
}
