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
import android.support.v4.view.i;
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
import n;
import r;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final r<String, Class<?>> j6;
    static final Object tp;
    int BT;
    int EQ;
    View I;
    int J0;
    Bundle J8;
    int KD;
    int Mr;
    View Mz;
    Object OW;
    m P8;
    int QX;
    u Qq;
    int SI;
    boolean Sf;
    int U2;
    SparseArray<Parcelable> Ws;
    Boolean XG;
    String XL;
    Object XX;
    boolean a8;
    Bundle aM;
    boolean aj;
    Object br;
    boolean ca;
    boolean cb;
    boolean cn;
    boolean dx;
    boolean ef;
    o ei;
    boolean er;
    aj et;
    ViewGroup g3;
    boolean gW;
    Fragment j3;
    Boolean jJ;
    Object kQ;
    boolean lg;
    Object lp;
    Fragment nw;
    boolean rN;
    String ro;
    boolean sG;
    boolean sh;
    boolean sy;
    int vJ;
    o vy;
    aj wc;
    View we;
    boolean x9;
    Object yO;
    boolean yS;

    class 1 extends k {
        final /* synthetic */ Fragment j6;

        1(Fragment fragment) {
            this.j6 = fragment;
        }

        public View j6(int i) {
            if (this.j6.Mz != null) {
                return this.j6.Mz.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public boolean j6() {
            return this.j6.Mz != null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        final Bundle j6;

        static class 1 implements Creator<SavedState> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public SavedState j6(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState[] j6(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Bundle bundle) {
            this.j6 = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.j6 = parcel.readBundle();
            if (classLoader != null && this.j6 != null) {
                this.j6.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.j6);
        }

        static {
            CREATOR = new 1();
        }
    }

    public static class a extends RuntimeException {
        public a(String str, Exception exception) {
            super(str, exception);
        }
    }

    static {
        j6 = new r();
        tp = new Object();
    }

    public Fragment() {
        this.EQ = 0;
        this.QX = -1;
        this.Mr = -1;
        this.ef = true;
        this.x9 = true;
        this.lp = null;
        this.OW = tp;
        this.br = null;
        this.XX = tp;
        this.kQ = null;
        this.yO = tp;
        this.wc = null;
        this.et = null;
    }

    public static Fragment j6(Context context, String str) {
        return j6(context, str, null);
    }

    public static Fragment j6(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) j6.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                j6.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.aM = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean DW(Context context, String str) {
        try {
            Class cls = (Class) j6.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                j6.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void Zo(Bundle bundle) {
        if (this.Ws != null) {
            this.I.restoreHierarchyState(this.Ws);
            this.Ws = null;
        }
        this.Sf = false;
        gn(bundle);
        if (!this.Sf) {
            throw new ak("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    final void j6(int i, Fragment fragment) {
        this.QX = i;
        if (fragment != null) {
            this.XL = fragment.XL + ":" + this.QX;
        } else {
            this.XL = "android:fragment:" + this.QX;
        }
    }

    final boolean Zo() {
        return this.BT > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        n.j6(this, stringBuilder);
        if (this.QX >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.QX);
        }
        if (this.SI != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.SI));
        }
        if (this.ro != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.ro);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void VH(Bundle bundle) {
        if (this.QX >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.aM = bundle;
    }

    public final Bundle VH() {
        return this.aM;
    }

    public void j6(SavedState savedState) {
        if (this.QX >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (savedState == null || savedState.j6 == null) ? null : savedState.j6;
        this.J8 = bundle;
    }

    public final FragmentActivity gn() {
        return this.P8 == null ? null : (FragmentActivity) this.P8.Zo();
    }

    public final Resources u7() {
        if (this.P8 != null) {
            return this.P8.VH().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final n tp() {
        return this.vy;
    }

    public final n EQ() {
        if (this.ei == null) {
            vy();
            if (this.EQ >= 5) {
                this.ei.J8();
            } else if (this.EQ >= 4) {
                this.ei.J0();
            } else if (this.EQ >= 2) {
                this.ei.we();
            } else if (this.EQ >= 1) {
                this.ei.EQ();
            }
        }
        return this.ei;
    }

    public final boolean we() {
        return this.P8 != null && this.a8;
    }

    public final boolean J0() {
        return this.sh;
    }

    public final boolean J8() {
        return this.cn;
    }

    public void FH(boolean z) {
    }

    public void Hw(boolean z) {
        if (this.ef != z) {
            this.ef = z;
            if (this.sG && we() && !J8()) {
                this.P8.FH();
            }
        }
    }

    public void v5(boolean z) {
        if (!this.x9 && z && this.EQ < 4) {
            this.vy.DW(this);
        }
        this.x9 = z;
        this.ca = !z;
    }

    public void j6(Intent intent, int i) {
        if (this.P8 == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.P8.j6(this, intent, i);
    }

    public void j6(int i, int i2, Intent intent) {
    }

    public void j6(int i, String[] strArr, int[] iArr) {
    }

    public LayoutInflater DW(Bundle bundle) {
        LayoutInflater DW = this.P8.DW();
        EQ();
        i.j6(DW, this.ei.U2());
        return DW;
    }

    public void j6(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.Sf = true;
        Activity Zo = this.P8 == null ? null : this.P8.Zo();
        if (Zo != null) {
            this.Sf = false;
            j6(Zo, attributeSet, bundle);
        }
    }

    @Deprecated
    public void j6(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.Sf = true;
    }

    public void j6(Context context) {
        this.Sf = true;
        Activity Zo = this.P8 == null ? null : this.P8.Zo();
        if (Zo != null) {
            this.Sf = false;
            j6(Zo);
        }
    }

    @Deprecated
    public void j6(Activity activity) {
        this.Sf = true;
    }

    public Animation j6(int i, boolean z, int i2) {
        return null;
    }

    public void j6(Bundle bundle) {
        this.Sf = true;
    }

    public View j6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void j6(View view, Bundle bundle) {
    }

    public View Ws() {
        return this.Mz;
    }

    public void Hw(Bundle bundle) {
        this.Sf = true;
    }

    public void gn(Bundle bundle) {
        this.Sf = true;
    }

    public void FH() {
        this.Sf = true;
        if (!this.sy) {
            this.sy = true;
            if (!this.aj) {
                this.aj = true;
                this.Qq = this.P8.j6(this.XL, this.sy, false);
            }
            if (this.Qq != null) {
                this.Qq.DW();
            }
        }
    }

    public void QX() {
        this.Sf = true;
    }

    public void v5(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.Sf = true;
    }

    public void XL() {
        this.Sf = true;
    }

    public void Hw() {
        this.Sf = true;
    }

    public void onLowMemory() {
        this.Sf = true;
    }

    public void v5() {
        this.Sf = true;
    }

    public void aM() {
        this.Sf = true;
        if (!this.aj) {
            this.aj = true;
            this.Qq = this.P8.j6(this.XL, this.sy, false);
        }
        if (this.Qq != null) {
            this.Qq.gn();
        }
    }

    void j3() {
        this.QX = -1;
        this.XL = null;
        this.a8 = false;
        this.lg = false;
        this.rN = false;
        this.er = false;
        this.yS = false;
        this.gW = false;
        this.BT = 0;
        this.vy = null;
        this.ei = null;
        this.P8 = null;
        this.SI = 0;
        this.KD = 0;
        this.ro = null;
        this.cn = false;
        this.sh = false;
        this.dx = false;
        this.Qq = null;
        this.sy = false;
        this.aj = false;
    }

    public void DW() {
        this.Sf = true;
    }

    public void j6(Menu menu, MenuInflater menuInflater) {
    }

    public void j6(Menu menu) {
    }

    public void Mr() {
    }

    public boolean j6(MenuItem menuItem) {
        return false;
    }

    public void DW(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        gn().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean DW(MenuItem menuItem) {
        return false;
    }

    public Object U2() {
        return this.lp;
    }

    public Object a8() {
        return this.OW == tp ? U2() : this.OW;
    }

    public Object lg() {
        return this.br;
    }

    public Object rN() {
        return this.XX == tp ? lg() : this.XX;
    }

    public Object er() {
        return this.kQ;
    }

    public Object yS() {
        return this.yO == tp ? er() : this.yO;
    }

    public boolean gW() {
        return this.jJ == null ? true : this.jJ.booleanValue();
    }

    public boolean BT() {
        return this.XG == null ? true : this.XG.booleanValue();
    }

    public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.SI));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.KD));
        printWriter.print(" mTag=");
        printWriter.println(this.ro);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.EQ);
        printWriter.print(" mIndex=");
        printWriter.print(this.QX);
        printWriter.print(" mWho=");
        printWriter.print(this.XL);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.BT);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.a8);
        printWriter.print(" mRemoving=");
        printWriter.print(this.lg);
        printWriter.print(" mResumed=");
        printWriter.print(this.rN);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.er);
        printWriter.print(" mInLayout=");
        printWriter.println(this.yS);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.cn);
        printWriter.print(" mDetached=");
        printWriter.print(this.sh);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.ef);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.sG);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.cb);
        printWriter.print(" mRetaining=");
        printWriter.print(this.dx);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.x9);
        if (this.vy != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.vy);
        }
        if (this.P8 != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.P8);
        }
        if (this.nw != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.nw);
        }
        if (this.aM != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.aM);
        }
        if (this.J8 != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.J8);
        }
        if (this.Ws != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.Ws);
        }
        if (this.j3 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.j3);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.U2);
        }
        if (this.vJ != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.vJ);
        }
        if (this.g3 != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.g3);
        }
        if (this.Mz != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.Mz);
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.Mz);
        }
        if (this.we != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.we);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.J0);
        }
        if (this.Qq != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.Qq.j6(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.ei != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.ei + ":");
            this.ei.j6(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void vy() {
        this.ei = new o();
        this.ei.j6(this.P8, new 1(this), this);
    }

    void u7(Bundle bundle) {
        if (this.ei != null) {
            this.ei.tp();
        }
        this.Sf = false;
        j6(bundle);
        if (!this.Sf) {
            throw new ak("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.ei == null) {
                    vy();
                }
                this.ei.j6(parcelable, null);
                this.ei.EQ();
            }
        }
    }

    View DW(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.ei != null) {
            this.ei.tp();
        }
        return j6(layoutInflater, viewGroup, bundle);
    }

    void tp(Bundle bundle) {
        if (this.ei != null) {
            this.ei.tp();
        }
        this.Sf = false;
        Hw(bundle);
        if (!this.Sf) {
            throw new ak("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.ei != null) {
            this.ei.we();
        }
    }

    void P8() {
        if (this.ei != null) {
            this.ei.tp();
            this.ei.Zo();
        }
        this.Sf = false;
        FH();
        if (this.Sf) {
            if (this.ei != null) {
                this.ei.J0();
            }
            if (this.Qq != null) {
                this.Qq.VH();
                return;
            }
            return;
        }
        throw new ak("Fragment " + this + " did not call through to super.onStart()");
    }

    void ei() {
        if (this.ei != null) {
            this.ei.tp();
            this.ei.Zo();
        }
        this.Sf = false;
        QX();
        if (!this.Sf) {
            throw new ak("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.ei != null) {
            this.ei.J8();
            this.ei.Zo();
        }
    }

    void j6(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.ei != null) {
            this.ei.j6(configuration);
        }
    }

    void nw() {
        onLowMemory();
        if (this.ei != null) {
            this.ei.Mr();
        }
    }

    boolean DW(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.cn) {
            return false;
        }
        if (this.sG && this.ef) {
            z = true;
            j6(menu, menuInflater);
        }
        if (this.ei != null) {
            return z | this.ei.j6(menu, menuInflater);
        }
        return z;
    }

    boolean FH(Menu menu) {
        boolean z = false;
        if (this.cn) {
            return false;
        }
        if (this.sG && this.ef) {
            z = true;
            j6(menu);
        }
        if (this.ei != null) {
            return z | this.ei.j6(menu);
        }
        return z;
    }

    boolean FH(MenuItem menuItem) {
        if (!this.cn) {
            if (this.sG && this.ef && j6(menuItem)) {
                return true;
            }
            if (this.ei != null && this.ei.j6(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean Hw(MenuItem menuItem) {
        if (!this.cn) {
            if (DW(menuItem)) {
                return true;
            }
            if (this.ei != null && this.ei.DW(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void Hw(Menu menu) {
        if (!this.cn) {
            if (this.sG && this.ef) {
                DW(menu);
            }
            if (this.ei != null) {
                this.ei.DW(menu);
            }
        }
    }

    void EQ(Bundle bundle) {
        v5(bundle);
        if (this.ei != null) {
            Parcelable u7 = this.ei.u7();
            if (u7 != null) {
                bundle.putParcelable("android:support:fragments", u7);
            }
        }
    }

    void SI() {
        if (this.ei != null) {
            this.ei.Ws();
        }
        this.Sf = false;
        XL();
        if (!this.Sf) {
            throw new ak("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void KD() {
        if (this.ei != null) {
            this.ei.QX();
        }
        this.Sf = false;
        Hw();
        if (!this.Sf) {
            throw new ak("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void ro() {
        if (this.ei != null) {
            this.ei.XL();
        }
        if (this.sy) {
            this.sy = false;
            if (!this.aj) {
                this.aj = true;
                this.Qq = this.P8.j6(this.XL, this.sy, false);
            }
            if (this.Qq == null) {
                return;
            }
            if (this.dx) {
                this.Qq.Hw();
            } else {
                this.Qq.FH();
            }
        }
    }

    void cn() {
        if (this.ei != null) {
            this.ei.aM();
        }
        this.Sf = false;
        v5();
        if (!this.Sf) {
            throw new ak("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.Qq != null) {
            this.Qq.Zo();
        }
    }

    void sh() {
        if (this.ei != null) {
            this.ei.j3();
        }
        this.Sf = false;
        aM();
        if (!this.Sf) {
            throw new ak("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
