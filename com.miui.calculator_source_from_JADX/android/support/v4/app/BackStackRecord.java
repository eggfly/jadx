package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransitionCompat21.EpicenterView;
import android.support.v4.app.FragmentTransitionCompat21.ViewRetriever;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class BackStackRecord extends FragmentTransaction implements BackStackEntry, Runnable {
    static final boolean f87a;
    final FragmentManagerImpl f88b;
    Op f89c;
    Op f90d;
    int f91e;
    int f92f;
    int f93g;
    int f94h;
    int f95i;
    int f96j;
    int f97k;
    boolean f98l;
    boolean f99m;
    String f100n;
    boolean f101o;
    int f102p;
    int f103q;
    CharSequence f104r;
    int f105s;
    CharSequence f106t;
    ArrayList<String> f107u;
    ArrayList<String> f108v;

    /* renamed from: android.support.v4.app.BackStackRecord.1 */
    class C00081 implements ViewRetriever {
        final /* synthetic */ Fragment f58a;
        final /* synthetic */ BackStackRecord f59b;

        C00081(BackStackRecord backStackRecord, Fragment fragment) {
            this.f59b = backStackRecord;
            this.f58a = fragment;
        }

        public View m85a() {
            return this.f58a.m195n();
        }
    }

    /* renamed from: android.support.v4.app.BackStackRecord.2 */
    class C00092 implements OnPreDrawListener {
        final /* synthetic */ View f60a;
        final /* synthetic */ Object f61b;
        final /* synthetic */ ArrayList f62c;
        final /* synthetic */ TransitionState f63d;
        final /* synthetic */ boolean f64e;
        final /* synthetic */ Fragment f65f;
        final /* synthetic */ Fragment f66g;
        final /* synthetic */ BackStackRecord f67h;

        C00092(BackStackRecord backStackRecord, View view, Object obj, ArrayList arrayList, TransitionState transitionState, boolean z, Fragment fragment, Fragment fragment2) {
            this.f67h = backStackRecord;
            this.f60a = view;
            this.f61b = obj;
            this.f62c = arrayList;
            this.f63d = transitionState;
            this.f64e = z;
            this.f65f = fragment;
            this.f66g = fragment2;
        }

        public boolean onPreDraw() {
            this.f60a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f61b != null) {
                FragmentTransitionCompat21.m402a(this.f61b, this.f62c);
                this.f62c.clear();
                ArrayMap a = this.f67h.m94a(this.f63d, this.f64e, this.f65f);
                FragmentTransitionCompat21.m399a(this.f61b, this.f63d.f85d, (Map) a, this.f62c);
                this.f67h.m109a(a, this.f63d);
                this.f67h.m102a(this.f63d, this.f65f, this.f66g, this.f64e, a);
            }
            return true;
        }
    }

    /* renamed from: android.support.v4.app.BackStackRecord.3 */
    class C00103 implements OnPreDrawListener {
        final /* synthetic */ View f68a;
        final /* synthetic */ TransitionState f69b;
        final /* synthetic */ int f70c;
        final /* synthetic */ Object f71d;
        final /* synthetic */ BackStackRecord f72e;

        C00103(BackStackRecord backStackRecord, View view, TransitionState transitionState, int i, Object obj) {
            this.f72e = backStackRecord;
            this.f68a = view;
            this.f69b = transitionState;
            this.f70c = i;
            this.f71d = obj;
        }

        public boolean onPreDraw() {
            this.f68a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f72e.m101a(this.f69b, this.f70c, this.f71d);
            return true;
        }
    }

    static final class Op {
        Op f73a;
        Op f74b;
        int f75c;
        Fragment f76d;
        int f77e;
        int f78f;
        int f79g;
        int f80h;
        ArrayList<Fragment> f81i;

        Op() {
        }
    }

    public class TransitionState {
        public ArrayMap<String, String> f82a;
        public ArrayList<View> f83b;
        public EpicenterView f84c;
        public View f85d;
        final /* synthetic */ BackStackRecord f86e;

        public TransitionState(BackStackRecord backStackRecord) {
            this.f86e = backStackRecord;
            this.f82a = new ArrayMap();
            this.f83b = new ArrayList();
            this.f84c = new EpicenterView();
        }
    }

    static {
        f87a = VERSION.SDK_INT >= 21;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f102p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f102p);
        }
        if (this.f100n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f100n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m127a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m128a(str, printWriter, true);
    }

    public void m128a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f100n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f102p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f101o);
            if (this.f96j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f96j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f97k));
            }
            if (!(this.f92f == 0 && this.f93g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f92f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f93g));
            }
            if (!(this.f94h == 0 && this.f95i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f94h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f95i));
            }
            if (!(this.f103q == 0 && this.f104r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f103q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f104r);
            }
            if (!(this.f105s == 0 && this.f106t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f105s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f106t);
            }
        }
        if (this.f89c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            Op op = this.f89c;
            while (op != null) {
                String str3;
                switch (op.f75c) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                        str3 = "NULL";
                        break;
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        str3 = "ADD";
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        str3 = "REPLACE";
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        str3 = "REMOVE";
                        break;
                    case C0264R.styleable.Window_windowDisablePreview /*4*/:
                        str3 = "HIDE";
                        break;
                    case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                        str3 = "SHOW";
                        break;
                    case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                        str3 = "DETACH";
                        break;
                    case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + op.f75c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(op.f76d);
                if (z) {
                    if (!(op.f77e == 0 && op.f78f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.f77e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.f78f));
                    }
                    if (!(op.f79g == 0 && op.f80h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.f79g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.f80h));
                    }
                }
                if (op.f81i != null && op.f81i.size() > 0) {
                    for (int i2 = 0; i2 < op.f81i.size(); i2++) {
                        printWriter.print(str2);
                        if (op.f81i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(op.f81i.get(i2));
                    }
                }
                op = op.f73a;
                i++;
            }
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.f99m = true;
        this.f102p = -1;
        this.f88b = fragmentManagerImpl;
    }

    void m125a(Op op) {
        if (this.f89c == null) {
            this.f90d = op;
            this.f89c = op;
        } else {
            op.f74b = this.f90d;
            this.f90d.f73a = op;
            this.f90d = op;
        }
        op.f77e = this.f92f;
        op.f78f = this.f93g;
        op.f79g = this.f94h;
        op.f80h = this.f95i;
        this.f91e++;
    }

    public FragmentTransaction m122a(int i, Fragment fragment, String str) {
        m100a(i, fragment, str, 1);
        return this;
    }

    private void m100a(int i, Fragment fragment, String str, int i2) {
        fragment.f124C = this.f88b;
        if (str != null) {
            if (fragment.f130I == null || str.equals(fragment.f130I)) {
                fragment.f130I = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f130I + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f128G == 0 || fragment.f128G == i) {
                fragment.f128G = i;
                fragment.f129H = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f128G + " now " + i);
            }
        }
        Op op = new Op();
        op.f75c = i2;
        op.f76d = fragment;
        m125a(op);
    }

    public FragmentTransaction m123a(Fragment fragment) {
        Op op = new Op();
        op.f75c = 3;
        op.f76d = fragment;
        m125a(op);
        return this;
    }

    public FragmentTransaction m130b(Fragment fragment) {
        Op op = new Op();
        op.f75c = 6;
        op.f76d = fragment;
        m125a(op);
        return this;
    }

    public FragmentTransaction m131c(Fragment fragment) {
        Op op = new Op();
        op.f75c = 7;
        op.f76d = fragment;
        m125a(op);
        return this;
    }

    void m124a(int i) {
        if (this.f98l) {
            if (FragmentManagerImpl.f215a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (Op op = this.f89c; op != null; op = op.f73a) {
                Fragment fragment;
                if (op.f76d != null) {
                    fragment = op.f76d;
                    fragment.f123B += i;
                    if (FragmentManagerImpl.f215a) {
                        Log.v("FragmentManager", "Bump nesting of " + op.f76d + " to " + op.f76d.f123B);
                    }
                }
                if (op.f81i != null) {
                    for (int size = op.f81i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) op.f81i.get(size);
                        fragment.f123B += i;
                        if (FragmentManagerImpl.f215a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f123B);
                        }
                    }
                }
            }
        }
    }

    public int m119a() {
        return m120a(false);
    }

    public int m129b() {
        return m120a(true);
    }

    int m120a(boolean z) {
        if (this.f101o) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.f215a) {
            Log.v("FragmentManager", "Commit: " + this);
            m127a("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
        }
        this.f101o = true;
        if (this.f98l) {
            this.f102p = this.f88b.m320a(this);
        } else {
            this.f102p = -1;
        }
        this.f88b.m339a((Runnable) this, z);
        return this.f102p;
    }

    public void run() {
        if (FragmentManagerImpl.f215a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f98l || this.f102p >= 0) {
            TransitionState a;
            m124a(1);
            if (f87a) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m118b(sparseArray, sparseArray2);
                a = m92a(sparseArray, sparseArray2, false);
            } else {
                a = null;
            }
            int i = a != null ? 0 : this.f97k;
            int i2 = a != null ? 0 : this.f96j;
            Op op = this.f89c;
            while (op != null) {
                int i3 = a != null ? 0 : op.f77e;
                int i4 = a != null ? 0 : op.f78f;
                Fragment fragment;
                switch (op.f75c) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        fragment = op.f76d;
                        fragment.f138Q = i3;
                        this.f88b.m337a(fragment, false);
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        Fragment fragment2;
                        Fragment fragment3 = op.f76d;
                        int i5 = fragment3.f129H;
                        if (this.f88b.f222g != null) {
                            fragment2 = fragment3;
                            for (int i6 = 0; i6 < this.f88b.f222g.size(); i6++) {
                                fragment = (Fragment) this.f88b.f222g.get(i6);
                                if (FragmentManagerImpl.f215a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.f129H == i5) {
                                    if (fragment == fragment2) {
                                        fragment2 = null;
                                        op.f76d = null;
                                    } else {
                                        if (op.f81i == null) {
                                            op.f81i = new ArrayList();
                                        }
                                        op.f81i.add(fragment);
                                        fragment.f138Q = i4;
                                        if (this.f98l) {
                                            fragment.f123B++;
                                            if (FragmentManagerImpl.f215a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f123B);
                                            }
                                        }
                                        this.f88b.m335a(fragment, i2, i);
                                    }
                                }
                            }
                        } else {
                            fragment2 = fragment3;
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.f138Q = i3;
                        this.f88b.m337a(fragment2, false);
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        fragment = op.f76d;
                        fragment.f138Q = i4;
                        this.f88b.m335a(fragment, i2, i);
                        break;
                    case C0264R.styleable.Window_windowDisablePreview /*4*/:
                        fragment = op.f76d;
                        fragment.f138Q = i4;
                        this.f88b.m348b(fragment, i2, i);
                        break;
                    case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                        fragment = op.f76d;
                        fragment.f138Q = i3;
                        this.f88b.m353c(fragment, i2, i);
                        break;
                    case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                        fragment = op.f76d;
                        fragment.f138Q = i4;
                        this.f88b.m357d(fragment, i2, i);
                        break;
                    case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                        fragment = op.f76d;
                        fragment.f138Q = i3;
                        this.f88b.m359e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.f75c);
                }
                op = op.f73a;
            }
            this.f88b.m328a(this.f88b.f229n, i2, i, true);
            if (this.f98l) {
                this.f88b.m346b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void m111a(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f129H;
            if (i != 0 && !fragment.m194m() && fragment.m192k() && fragment.m195n() != null && sparseArray.get(i) == null) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void m117b(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f129H;
            if (i != 0) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void m118b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f88b.f231p.m222a()) {
            for (Op op = this.f89c; op != null; op = op.f73a) {
                switch (op.f75c) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        m117b((SparseArray) sparseArray2, op.f76d);
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        Fragment fragment;
                        Fragment fragment2 = op.f76d;
                        if (this.f88b.f222g != null) {
                            fragment = fragment2;
                            for (int i = 0; i < this.f88b.f222g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.f88b.f222g.get(i);
                                if (fragment == null || fragment3.f129H == fragment.f129H) {
                                    if (fragment3 == fragment) {
                                        fragment = null;
                                    } else {
                                        m111a((SparseArray) sparseArray, fragment3);
                                    }
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        m117b((SparseArray) sparseArray2, fragment);
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        m111a((SparseArray) sparseArray, op.f76d);
                        break;
                    case C0264R.styleable.Window_windowDisablePreview /*4*/:
                        m111a((SparseArray) sparseArray, op.f76d);
                        break;
                    case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                        m117b((SparseArray) sparseArray2, op.f76d);
                        break;
                    case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                        m111a((SparseArray) sparseArray, op.f76d);
                        break;
                    case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                        m117b((SparseArray) sparseArray2, op.f76d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m126a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f88b.f231p.m222a()) {
            for (Op op = this.f89c; op != null; op = op.f73a) {
                switch (op.f75c) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        m111a((SparseArray) sparseArray, op.f76d);
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        if (op.f81i != null) {
                            for (int size = op.f81i.size() - 1; size >= 0; size--) {
                                m117b((SparseArray) sparseArray2, (Fragment) op.f81i.get(size));
                            }
                        }
                        m111a((SparseArray) sparseArray, op.f76d);
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        m117b((SparseArray) sparseArray2, op.f76d);
                        break;
                    case C0264R.styleable.Window_windowDisablePreview /*4*/:
                        m117b((SparseArray) sparseArray2, op.f76d);
                        break;
                    case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                        m111a((SparseArray) sparseArray, op.f76d);
                        break;
                    case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                        m117b((SparseArray) sparseArray2, op.f76d);
                        break;
                    case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                        m111a((SparseArray) sparseArray, op.f76d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public TransitionState m121a(boolean z, TransitionState transitionState, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (FragmentManagerImpl.f215a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m127a("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
        }
        if (f87a) {
            if (transitionState == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    transitionState = m92a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                m105a(transitionState, this.f108v, this.f107u);
            }
        }
        m124a(-1);
        int i = transitionState != null ? 0 : this.f97k;
        int i2 = transitionState != null ? 0 : this.f96j;
        Op op = this.f90d;
        while (op != null) {
            int i3 = transitionState != null ? 0 : op.f79g;
            int i4 = transitionState != null ? 0 : op.f80h;
            Fragment fragment;
            Fragment fragment2;
            switch (op.f75c) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    fragment = op.f76d;
                    fragment.f138Q = i4;
                    this.f88b.m335a(fragment, FragmentManagerImpl.m318c(i2), i);
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    fragment = op.f76d;
                    if (fragment != null) {
                        fragment.f138Q = i4;
                        this.f88b.m335a(fragment, FragmentManagerImpl.m318c(i2), i);
                    }
                    if (op.f81i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < op.f81i.size(); i5++) {
                        fragment2 = (Fragment) op.f81i.get(i5);
                        fragment2.f138Q = i3;
                        this.f88b.m337a(fragment2, false);
                    }
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    fragment2 = op.f76d;
                    fragment2.f138Q = i3;
                    this.f88b.m337a(fragment2, false);
                    break;
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    fragment2 = op.f76d;
                    fragment2.f138Q = i3;
                    this.f88b.m353c(fragment2, FragmentManagerImpl.m318c(i2), i);
                    break;
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    fragment = op.f76d;
                    fragment.f138Q = i4;
                    this.f88b.m348b(fragment, FragmentManagerImpl.m318c(i2), i);
                    break;
                case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                    fragment2 = op.f76d;
                    fragment2.f138Q = i3;
                    this.f88b.m359e(fragment2, FragmentManagerImpl.m318c(i2), i);
                    break;
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    fragment2 = op.f76d;
                    fragment2.f138Q = i3;
                    this.f88b.m357d(fragment2, FragmentManagerImpl.m318c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f75c);
            }
            op = op.f74b;
        }
        if (z) {
            this.f88b.m328a(this.f88b.f229n, FragmentManagerImpl.m318c(i2), i, true);
            transitionState = null;
        }
        if (this.f102p >= 0) {
            this.f88b.m345b(this.f102p);
            this.f102p = -1;
        }
        return transitionState;
    }

    public String m132c() {
        return this.f100n;
    }

    private TransitionState m92a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        TransitionState transitionState = new TransitionState(this);
        transitionState.f85d = new View(this.f88b.f230o.m242g());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (m113a(sparseArray.keyAt(i2), transitionState, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m113a(i4, transitionState, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return transitionState;
    }

    private static Object m98a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.m391a(z ? fragment.m204w() : fragment.m201t());
    }

    private static Object m115b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.m391a(z ? fragment.m202u() : fragment.m203v());
    }

    private static Object m97a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return FragmentTransitionCompat21.m410b(z ? fragment2.m206y() : fragment.m205x());
    }

    private static Object m99a(Object obj, Fragment fragment, ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, View view) {
        if (obj != null) {
            return FragmentTransitionCompat21.m392a(obj, fragment.m195n(), arrayList, arrayMap, view);
        }
        return obj;
    }

    private ArrayMap<String, View> m93a(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        if (this.f107u != null) {
            FragmentTransitionCompat21.m405a((Map) arrayMap, fragment.m195n());
            if (z) {
                arrayMap.m1090a(this.f108v);
            } else {
                arrayMap = m96a(this.f107u, this.f108v, arrayMap);
            }
        }
        if (z) {
            if (fragment.ah != null) {
                fragment.ah.m489a(this.f108v, (Map) arrayMap);
            }
            m103a(transitionState, arrayMap, false);
        } else {
            if (fragment.ai != null) {
                fragment.ai.m489a(this.f108v, (Map) arrayMap);
            }
            m116b(transitionState, arrayMap, false);
        }
        return arrayMap;
    }

    private boolean m113a(int i, TransitionState transitionState, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.f88b.f231p.m221a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        ViewRetriever c00081;
        ArrayList arrayList2;
        Map arrayMap;
        boolean z2;
        Object a2;
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a3 = m98a(fragment, z);
        Object a4 = m97a(fragment, fragment2, z);
        Object b = m115b(fragment2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m93a(transitionState, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = m99a(b, fragment2, arrayList, (ArrayMap) map, transitionState.f85d);
                if (!(this.f108v == null || map == null)) {
                    view2 = (View) map.get(this.f108v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            FragmentTransitionCompat21.m398a(a, view2);
                        }
                        if (obj != null) {
                            FragmentTransitionCompat21.m398a(obj, view2);
                        }
                    }
                }
                c00081 = new C00081(this, fragment);
                arrayList2 = new ArrayList();
                arrayMap = new ArrayMap();
                z2 = true;
                if (fragment != null) {
                    z2 = z ? fragment.m140A() : fragment.m207z();
                }
                a2 = FragmentTransitionCompat21.m393a(a3, a, obj, z2);
                if (a2 != null) {
                    FragmentTransitionCompat21.m401a(a3, obj, view, c00081, transitionState.f85d, transitionState.f84c, transitionState.f82a, arrayList2, map, arrayMap, arrayList3);
                    m112a(view, transitionState, i, a2);
                    FragmentTransitionCompat21.m400a(a2, transitionState.f85d, true);
                    m101a(transitionState, i, a2);
                    FragmentTransitionCompat21.m397a((ViewGroup) view, a2);
                    FragmentTransitionCompat21.m396a(view, transitionState.f85d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, transitionState.f83b, arrayMap);
                }
                if (a2 == null) {
                    return true;
                }
                return false;
            }
            SharedElementCallback sharedElementCallback = z ? fragment2.ah : fragment.ah;
            if (sharedElementCallback != null) {
                sharedElementCallback.m488a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
            }
            m104a(transitionState, view, a4, fragment, fragment2, z, arrayList3);
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = m99a(b, fragment2, arrayList, (ArrayMap) map, transitionState.f85d);
        view2 = (View) map.get(this.f108v.get(0));
        if (view2 != null) {
            if (a != null) {
                FragmentTransitionCompat21.m398a(a, view2);
            }
            if (obj != null) {
                FragmentTransitionCompat21.m398a(obj, view2);
            }
        }
        c00081 = new C00081(this, fragment);
        arrayList2 = new ArrayList();
        arrayMap = new ArrayMap();
        z2 = true;
        if (fragment != null) {
            if (z) {
            }
        }
        a2 = FragmentTransitionCompat21.m393a(a3, a, obj, z2);
        if (a2 != null) {
            FragmentTransitionCompat21.m401a(a3, obj, view, c00081, transitionState.f85d, transitionState.f84c, transitionState.f82a, arrayList2, map, arrayMap, arrayList3);
            m112a(view, transitionState, i, a2);
            FragmentTransitionCompat21.m400a(a2, transitionState.f85d, true);
            m101a(transitionState, i, a2);
            FragmentTransitionCompat21.m397a((ViewGroup) view, a2);
            FragmentTransitionCompat21.m396a(view, transitionState.f85d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, transitionState.f83b, arrayMap);
        }
        if (a2 == null) {
            return false;
        }
        return true;
    }

    private void m104a(TransitionState transitionState, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new C00092(this, view, obj, arrayList, transitionState, z, fragment, fragment2));
    }

    private void m102a(TransitionState transitionState, Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap) {
        SharedElementCallback sharedElementCallback = z ? fragment2.ah : fragment.ah;
        if (sharedElementCallback != null) {
            sharedElementCallback.m490b(new ArrayList(arrayMap.keySet()), new ArrayList(arrayMap.values()), null);
        }
    }

    private void m109a(ArrayMap<String, View> arrayMap, TransitionState transitionState) {
        if (this.f108v != null && !arrayMap.isEmpty()) {
            View view = (View) arrayMap.get(this.f108v.get(0));
            if (view != null) {
                transitionState.f84c.f289a = view;
            }
        }
    }

    private ArrayMap<String, View> m94a(TransitionState transitionState, boolean z, Fragment fragment) {
        ArrayMap b = m114b(transitionState, fragment, z);
        if (z) {
            if (fragment.ai != null) {
                fragment.ai.m489a(this.f108v, (Map) b);
            }
            m103a(transitionState, b, true);
        } else {
            if (fragment.ah != null) {
                fragment.ah.m489a(this.f108v, (Map) b);
            }
            m116b(transitionState, b, true);
        }
        return b;
    }

    private static ArrayMap<String, View> m96a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayMap<String, View> arrayMap) {
        if (arrayMap.isEmpty()) {
            return arrayMap;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayMap.get(arrayList.get(i));
            if (view != null) {
                arrayMap2.put(arrayList2.get(i), view);
            }
        }
        return arrayMap2;
    }

    private ArrayMap<String, View> m114b(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        View n = fragment.m195n();
        if (n == null || this.f107u == null) {
            return arrayMap;
        }
        FragmentTransitionCompat21.m405a((Map) arrayMap, n);
        if (z) {
            return m96a(this.f107u, this.f108v, arrayMap);
        }
        arrayMap.m1090a(this.f108v);
        return arrayMap;
    }

    private void m112a(View view, TransitionState transitionState, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new C00103(this, view, transitionState, i, obj));
    }

    private void m101a(TransitionState transitionState, int i, Object obj) {
        if (this.f88b.f222g != null) {
            for (int i2 = 0; i2 < this.f88b.f222g.size(); i2++) {
                Fragment fragment = (Fragment) this.f88b.f222g.get(i2);
                if (!(fragment.f140S == null || fragment.f139R == null || fragment.f129H != i)) {
                    if (!fragment.f131J) {
                        FragmentTransitionCompat21.m400a(obj, fragment.f140S, false);
                        transitionState.f83b.remove(fragment.f140S);
                    } else if (!transitionState.f83b.contains(fragment.f140S)) {
                        FragmentTransitionCompat21.m400a(obj, fragment.f140S, true);
                        transitionState.f83b.add(fragment.f140S);
                    }
                }
            }
        }
    }

    private static void m110a(ArrayMap<String, String> arrayMap, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < arrayMap.size(); i++) {
                if (str.equals(arrayMap.m1087c(i))) {
                    arrayMap.m1083a(i, (Object) str2);
                    return;
                }
            }
            arrayMap.put(str, str2);
        }
    }

    private static void m105a(TransitionState transitionState, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                m110a(transitionState.f82a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m103a(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = this.f108v == null ? 0 : this.f108v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f107u.get(i);
            View view = (View) arrayMap.get((String) this.f108v.get(i));
            if (view != null) {
                String a = FragmentTransitionCompat21.m394a(view);
                if (z) {
                    m110a(transitionState.f82a, str, a);
                } else {
                    m110a(transitionState.f82a, a, str);
                }
            }
        }
    }

    private void m116b(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayMap.m1086b(i);
            String a = FragmentTransitionCompat21.m394a((View) arrayMap.m1087c(i));
            if (z) {
                m110a(transitionState.f82a, str, a);
            } else {
                m110a(transitionState.f82a, a, str);
            }
        }
    }
}
