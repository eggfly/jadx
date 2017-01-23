package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final SimpleArrayMap<String, Class<?>> f120a;
    static final Object f121j;
    boolean f122A;
    int f123B;
    FragmentManagerImpl f124C;
    FragmentHostCallback f125D;
    FragmentManagerImpl f126E;
    Fragment f127F;
    int f128G;
    int f129H;
    String f130I;
    boolean f131J;
    boolean f132K;
    boolean f133L;
    boolean f134M;
    boolean f135N;
    boolean f136O;
    boolean f137P;
    int f138Q;
    ViewGroup f139R;
    View f140S;
    View f141T;
    boolean f142U;
    boolean f143V;
    LoaderManagerImpl f144W;
    boolean f145X;
    boolean f146Y;
    Object f147Z;
    Object aa;
    Object ab;
    Object ac;
    Object ad;
    Object ae;
    Boolean af;
    Boolean ag;
    SharedElementCallback ah;
    SharedElementCallback ai;
    int f148k;
    View f149l;
    int f150m;
    Bundle f151n;
    SparseArray<Parcelable> f152o;
    int f153p;
    String f154q;
    Bundle f155r;
    Fragment f156s;
    int f157t;
    int f158u;
    boolean f159v;
    boolean f160w;
    boolean f161x;
    boolean f162y;
    boolean f163z;

    /* renamed from: android.support.v4.app.Fragment.1 */
    class C00121 extends FragmentContainer {
        final /* synthetic */ Fragment f173a;

        C00121(Fragment fragment) {
            this.f173a = fragment;
        }

        @Nullable
        public View m223a(int i) {
            if (this.f173a.f140S != null) {
                return this.f173a.f140S.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public boolean m224a() {
            return this.f173a.f140S != null;
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exception) {
            super(str, exception);
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        final Bundle f174a;

        /* renamed from: android.support.v4.app.Fragment.SavedState.1 */
        final class C00131 implements Creator<SavedState> {
            C00131() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m225a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m226a(i);
            }

            public SavedState m225a(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState[] m226a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f174a = parcel.readBundle();
            if (classLoader != null && this.f174a != null) {
                this.f174a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f174a);
        }

        static {
            CREATOR = new C00131();
        }
    }

    static {
        f120a = new SimpleArrayMap();
        f121j = new Object();
    }

    public Fragment() {
        this.f148k = 0;
        this.f153p = -1;
        this.f157t = -1;
        this.f136O = true;
        this.f143V = true;
        this.f147Z = null;
        this.aa = f121j;
        this.ab = null;
        this.ac = f121j;
        this.ad = null;
        this.ae = f121j;
        this.ah = null;
        this.ai = null;
    }

    public static Fragment m137a(Context context, String str) {
        return m138a(context, str, null);
    }

    public static Fragment m138a(Context context, String str, @Nullable Bundle bundle) {
        try {
            Class cls = (Class) f120a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f120a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f155r = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m139b(Context context, String str) {
        try {
            Class cls = (Class) f120a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f120a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void m182f(Bundle bundle) {
        if (this.f152o != null) {
            this.f141T.restoreHierarchyState(this.f152o);
            this.f152o = null;
        }
        this.f137P = false;
        m185g(bundle);
        if (!this.f137P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    final void m153a(int i, Fragment fragment) {
        this.f153p = i;
        if (fragment != null) {
            this.f154q = fragment.f154q + ":" + this.f153p;
        } else {
            this.f154q = "android:fragment:" + this.f153p;
        }
    }

    final boolean m183f() {
        return this.f123B > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        DebugUtils.m1096a(this, stringBuilder);
        if (this.f153p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f153p);
        }
        if (this.f128G != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f128G));
        }
        if (this.f130I != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f130I);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final FragmentActivity m184g() {
        return this.f125D == null ? null : (FragmentActivity) this.f125D.m241f();
    }

    public final Resources m186h() {
        if (this.f125D != null) {
            return this.f125D.m242g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final FragmentManager m188i() {
        return this.f124C;
    }

    public final FragmentManager m190j() {
        if (this.f126E == null) {
            m141B();
            if (this.f148k >= 5) {
                this.f126E.m369m();
            } else if (this.f148k >= 4) {
                this.f126E.m368l();
            } else if (this.f148k >= 2) {
                this.f126E.m367k();
            } else if (this.f148k >= 1) {
                this.f126E.m366j();
            }
        }
        return this.f126E;
    }

    public final boolean m192k() {
        return this.f125D != null && this.f159v;
    }

    public final boolean m193l() {
        return this.f132K;
    }

    public final boolean m194m() {
        return this.f131J;
    }

    public void m170b(boolean z) {
    }

    public void m152a(int i, int i2, Intent intent) {
    }

    public void m154a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public LayoutInflater m166b(Bundle bundle) {
        LayoutInflater b = this.f125D.m235b();
        m190j();
        LayoutInflaterCompat.m1251a(b, this.f126E.m376t());
        return b;
    }

    public void m158a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f137P = true;
        Activity f = this.f125D == null ? null : this.f125D.m241f();
        if (f != null) {
            this.f137P = false;
            m156a(f, attributeSet, bundle);
        }
    }

    @Deprecated
    public void m156a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f137P = true;
    }

    public void m157a(Context context) {
        this.f137P = true;
        Activity f = this.f125D == null ? null : this.f125D.m241f();
        if (f != null) {
            this.f137P = false;
            m155a(f);
        }
    }

    @Deprecated
    public void m155a(Activity activity) {
        this.f137P = true;
    }

    public Animation m151a(int i, boolean z, int i2) {
        return null;
    }

    public void m160a(@Nullable Bundle bundle) {
        this.f137P = true;
    }

    @Nullable
    public View m150a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return null;
    }

    public void m163a(View view, @Nullable Bundle bundle) {
    }

    @Nullable
    public View m195n() {
        return this.f140S;
    }

    public void m177d(@Nullable Bundle bundle) {
        this.f137P = true;
    }

    public void m185g(@Nullable Bundle bundle) {
        this.f137P = true;
    }

    public void m173c() {
        this.f137P = true;
        if (!this.f145X) {
            this.f145X = true;
            if (!this.f146Y) {
                this.f146Y = true;
                this.f144W = this.f125D.m227a(this.f154q, this.f145X, false);
            }
            if (this.f144W != null) {
                this.f144W.m449b();
            }
        }
    }

    public void m196o() {
        this.f137P = true;
    }

    public void m181e(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f137P = true;
    }

    public void m197p() {
        this.f137P = true;
    }

    public void m176d() {
        this.f137P = true;
    }

    public void onLowMemory() {
        this.f137P = true;
    }

    public void m180e() {
        this.f137P = true;
    }

    public void m198q() {
        this.f137P = true;
        if (!this.f146Y) {
            this.f146Y = true;
            this.f144W = this.f125D.m227a(this.f154q, this.f145X, false);
        }
        if (this.f144W != null) {
            this.f144W.m455h();
        }
    }

    void m199r() {
        this.f153p = -1;
        this.f154q = null;
        this.f159v = false;
        this.f160w = false;
        this.f161x = false;
        this.f162y = false;
        this.f163z = false;
        this.f122A = false;
        this.f123B = 0;
        this.f124C = null;
        this.f126E = null;
        this.f125D = null;
        this.f128G = 0;
        this.f129H = 0;
        this.f130I = null;
        this.f131J = false;
        this.f132K = false;
        this.f134M = false;
        this.f144W = null;
        this.f145X = false;
        this.f146Y = false;
    }

    public void m168b() {
        this.f137P = true;
    }

    public void m162a(Menu menu, MenuInflater menuInflater) {
    }

    public void m161a(Menu menu) {
    }

    public void m200s() {
    }

    public boolean m165a(MenuItem menuItem) {
        return false;
    }

    public void m169b(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m184g().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean m172b(MenuItem menuItem) {
        return false;
    }

    public Object m201t() {
        return this.f147Z;
    }

    public Object m202u() {
        return this.aa == f121j ? m201t() : this.aa;
    }

    public Object m203v() {
        return this.ab;
    }

    public Object m204w() {
        return this.ac == f121j ? m203v() : this.ac;
    }

    public Object m205x() {
        return this.ad;
    }

    public Object m206y() {
        return this.ae == f121j ? m205x() : this.ae;
    }

    public boolean m207z() {
        return this.ag == null ? true : this.ag.booleanValue();
    }

    public boolean m140A() {
        return this.af == null ? true : this.af.booleanValue();
    }

    public void m164a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f128G));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f129H));
        printWriter.print(" mTag=");
        printWriter.println(this.f130I);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f148k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f153p);
        printWriter.print(" mWho=");
        printWriter.print(this.f154q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f123B);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f159v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f160w);
        printWriter.print(" mResumed=");
        printWriter.print(this.f161x);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f162y);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f163z);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f131J);
        printWriter.print(" mDetached=");
        printWriter.print(this.f132K);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f136O);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f135N);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f133L);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f134M);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f143V);
        if (this.f124C != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f124C);
        }
        if (this.f125D != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f125D);
        }
        if (this.f127F != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f127F);
        }
        if (this.f155r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f155r);
        }
        if (this.f151n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f151n);
        }
        if (this.f152o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f152o);
        }
        if (this.f156s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f156s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f158u);
        }
        if (this.f138Q != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f138Q);
        }
        if (this.f139R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f139R);
        }
        if (this.f140S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f140S);
        }
        if (this.f141T != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f140S);
        }
        if (this.f149l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f149l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f150m);
        }
        if (this.f144W != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f144W.m447a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f126E != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f126E + ":");
            this.f126E.m340a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void m141B() {
        this.f126E = new FragmentManagerImpl();
        this.f126E.m338a(this.f125D, new C00121(this), this);
    }

    void m187h(Bundle bundle) {
        if (this.f126E != null) {
            this.f126E.m365i();
        }
        this.f137P = false;
        m160a(bundle);
        if (!this.f137P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f126E == null) {
                    m141B();
                }
                this.f126E.m333a(parcelable, null);
                this.f126E.m366j();
            }
        }
    }

    View m167b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f126E != null) {
            this.f126E.m365i();
        }
        return m150a(layoutInflater, viewGroup, bundle);
    }

    void m189i(Bundle bundle) {
        if (this.f126E != null) {
            this.f126E.m365i();
        }
        this.f137P = false;
        m177d(bundle);
        if (!this.f137P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f126E != null) {
            this.f126E.m367k();
        }
    }

    void m142C() {
        if (this.f126E != null) {
            this.f126E.m365i();
            this.f126E.m360e();
        }
        this.f137P = false;
        m173c();
        if (this.f137P) {
            if (this.f126E != null) {
                this.f126E.m368l();
            }
            if (this.f144W != null) {
                this.f144W.m454g();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    void m143D() {
        if (this.f126E != null) {
            this.f126E.m365i();
            this.f126E.m360e();
        }
        this.f137P = false;
        m196o();
        if (!this.f137P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f126E != null) {
            this.f126E.m369m();
            this.f126E.m360e();
        }
    }

    void m159a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f126E != null) {
            this.f126E.m331a(configuration);
        }
    }

    void m144E() {
        onLowMemory();
        if (this.f126E != null) {
            this.f126E.m375s();
        }
    }

    boolean m171b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f131J) {
            return false;
        }
        if (this.f135N && this.f136O) {
            z = true;
            m162a(menu, menuInflater);
        }
        if (this.f126E != null) {
            return z | this.f126E.m343a(menu, menuInflater);
        }
        return z;
    }

    boolean m174c(Menu menu) {
        boolean z = false;
        if (this.f131J) {
            return false;
        }
        if (this.f135N && this.f136O) {
            z = true;
            m161a(menu);
        }
        if (this.f126E != null) {
            return z | this.f126E.m342a(menu);
        }
        return z;
    }

    boolean m175c(MenuItem menuItem) {
        if (!this.f131J) {
            if (this.f135N && this.f136O && m165a(menuItem)) {
                return true;
            }
            if (this.f126E != null && this.f126E.m344a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean m179d(MenuItem menuItem) {
        if (!this.f131J) {
            if (m172b(menuItem)) {
                return true;
            }
            if (this.f126E != null && this.f126E.m351b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m178d(Menu menu) {
        if (!this.f131J) {
            if (this.f135N && this.f136O) {
                m169b(menu);
            }
            if (this.f126E != null) {
                this.f126E.m349b(menu);
            }
        }
    }

    void m191j(Bundle bundle) {
        m181e(bundle);
        if (this.f126E != null) {
            Parcelable h = this.f126E.m364h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    void m145F() {
        if (this.f126E != null) {
            this.f126E.m370n();
        }
        this.f137P = false;
        m197p();
        if (!this.f137P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m146G() {
        if (this.f126E != null) {
            this.f126E.m371o();
        }
        this.f137P = false;
        m176d();
        if (!this.f137P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m147H() {
        if (this.f126E != null) {
            this.f126E.m372p();
        }
        if (this.f145X) {
            this.f145X = false;
            if (!this.f146Y) {
                this.f146Y = true;
                this.f144W = this.f125D.m227a(this.f154q, this.f145X, false);
            }
            if (this.f144W == null) {
                return;
            }
            if (this.f134M) {
                this.f144W.m451d();
            } else {
                this.f144W.m450c();
            }
        }
    }

    void m148I() {
        if (this.f126E != null) {
            this.f126E.m373q();
        }
        this.f137P = false;
        m180e();
        if (!this.f137P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f144W != null) {
            this.f144W.m453f();
        }
    }

    void m149J() {
        if (this.f126E != null) {
            this.f126E.m374r();
        }
        this.f137P = false;
        m198q();
        if (!this.f137P) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
