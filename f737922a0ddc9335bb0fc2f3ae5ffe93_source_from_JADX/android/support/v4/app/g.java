package android.support.v4.app;

import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.aide.uidesigner.ProxyTextView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import l;
import o;

final class g extends q implements Runnable {
    static final boolean j6;
    final o DW;
    int EQ;
    a FH;
    a Hw;
    boolean J0;
    String J8;
    CharSequence Mr;
    int QX;
    ArrayList<String> U2;
    int VH;
    boolean Ws;
    int XL;
    int Zo;
    ArrayList<String> a8;
    CharSequence aM;
    int gn;
    int j3;
    int tp;
    int u7;
    int v5;
    boolean we;

    class 1 implements android.support.v4.app.r.b {
        final /* synthetic */ g DW;
        final /* synthetic */ Fragment j6;

        1(g gVar, Fragment fragment) {
            this.DW = gVar;
            this.j6 = fragment;
        }

        public View j6() {
            return this.j6.Ws();
        }
    }

    class 2 implements OnPreDrawListener {
        final /* synthetic */ Object DW;
        final /* synthetic */ ArrayList FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ Fragment VH;
        final /* synthetic */ Fragment Zo;
        final /* synthetic */ g gn;
        final /* synthetic */ View j6;
        final /* synthetic */ boolean v5;

        2(g gVar, View view, Object obj, ArrayList arrayList, b bVar, boolean z, Fragment fragment, Fragment fragment2) {
            this.gn = gVar;
            this.j6 = view;
            this.DW = obj;
            this.FH = arrayList;
            this.Hw = bVar;
            this.v5 = z;
            this.Zo = fragment;
            this.VH = fragment2;
        }

        public boolean onPreDraw() {
            this.j6.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.DW != null) {
                r.j6(this.DW, this.FH);
                this.FH.clear();
                l j6 = this.gn.j6(this.Hw, this.v5, this.Zo);
                r.j6(this.DW, this.Hw.Hw, (Map) j6, this.FH);
                this.gn.j6(j6, this.Hw);
                this.gn.j6(this.Hw, this.Zo, this.VH, this.v5, j6);
            }
            return true;
        }
    }

    class 3 implements OnPreDrawListener {
        final /* synthetic */ b DW;
        final /* synthetic */ int FH;
        final /* synthetic */ Object Hw;
        final /* synthetic */ View j6;
        final /* synthetic */ g v5;

        3(g gVar, View view, b bVar, int i, Object obj) {
            this.v5 = gVar;
            this.j6 = view;
            this.DW = bVar;
            this.FH = i;
            this.Hw = obj;
        }

        public boolean onPreDraw() {
            this.j6.getViewTreeObserver().removeOnPreDrawListener(this);
            this.v5.j6(this.DW, this.FH, this.Hw);
            return true;
        }
    }

    static final class a {
        a DW;
        int FH;
        Fragment Hw;
        int VH;
        int Zo;
        int gn;
        a j6;
        ArrayList<Fragment> u7;
        int v5;

        a() {
        }
    }

    public class b {
        public ArrayList<View> DW;
        public android.support.v4.app.r.a FH;
        public View Hw;
        public l<String, String> j6;
        final /* synthetic */ g v5;

        public b(g gVar) {
            this.v5 = gVar;
            this.j6 = new l();
            this.DW = new ArrayList();
            this.FH = new android.support.v4.app.r.a();
        }
    }

    static {
        j6 = VERSION.SDK_INT >= 21;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.QX >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.QX);
        }
        if (this.J8 != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.J8);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        j6(str, printWriter, true);
    }

    public void j6(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.J8);
            printWriter.print(" mIndex=");
            printWriter.print(this.QX);
            printWriter.print(" mCommitted=");
            printWriter.println(this.Ws);
            if (this.tp != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.tp));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.EQ));
            }
            if (!(this.Zo == 0 && this.VH == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.Zo));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.VH));
            }
            if (!(this.gn == 0 && this.u7 == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.gn));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.u7));
            }
            if (!(this.XL == 0 && this.aM == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.XL));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.aM);
            }
            if (!(this.j3 == 0 && this.Mr == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.j3));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.Mr);
            }
        }
        if (this.FH != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            a aVar = this.FH;
            while (aVar != null) {
                String str3;
                switch (aVar.FH) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        str3 = "NULL";
                        break;
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        str3 = "ADD";
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        str3 = "REPLACE";
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        str3 = "REMOVE";
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + aVar.FH;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(aVar.Hw);
                if (z) {
                    if (!(aVar.v5 == 0 && aVar.Zo == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.v5));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.Zo));
                    }
                    if (!(aVar.VH == 0 && aVar.gn == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.VH));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.gn));
                    }
                }
                if (aVar.u7 != null && aVar.u7.size() > 0) {
                    for (int i2 = 0; i2 < aVar.u7.size(); i2++) {
                        printWriter.print(str2);
                        if (aVar.u7.size() == 1) {
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
                        printWriter.println(aVar.u7.get(i2));
                    }
                }
                aVar = aVar.j6;
                i++;
            }
        }
    }

    public g(o oVar) {
        this.J0 = true;
        this.QX = -1;
        this.DW = oVar;
    }

    void j6(a aVar) {
        if (this.FH == null) {
            this.Hw = aVar;
            this.FH = aVar;
        } else {
            aVar.DW = this.Hw;
            this.Hw.j6 = aVar;
            this.Hw = aVar;
        }
        aVar.v5 = this.Zo;
        aVar.Zo = this.VH;
        aVar.VH = this.gn;
        aVar.gn = this.u7;
        this.v5++;
    }

    public q j6(Fragment fragment, String str) {
        j6(0, fragment, str, 1);
        return this;
    }

    public q j6(int i, Fragment fragment) {
        j6(i, fragment, null, 1);
        return this;
    }

    public q j6(int i, Fragment fragment, String str) {
        j6(i, fragment, str, 1);
        return this;
    }

    private void j6(int i, Fragment fragment, String str, int i2) {
        fragment.vy = this.DW;
        if (str != null) {
            if (fragment.ro == null || str.equals(fragment.ro)) {
                fragment.ro = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.ro + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.SI == 0 || fragment.SI == i) {
                fragment.SI = i;
                fragment.KD = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.SI + " now " + i);
            }
        }
        a aVar = new a();
        aVar.FH = i2;
        aVar.Hw = fragment;
        j6(aVar);
    }

    public q DW(int i, Fragment fragment) {
        return DW(i, fragment, null);
    }

    public q DW(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        j6(i, fragment, str, 2);
        return this;
    }

    public q j6(Fragment fragment) {
        a aVar = new a();
        aVar.FH = 3;
        aVar.Hw = fragment;
        j6(aVar);
        return this;
    }

    public q DW(Fragment fragment) {
        a aVar = new a();
        aVar.FH = 6;
        aVar.Hw = fragment;
        j6(aVar);
        return this;
    }

    public q FH(Fragment fragment) {
        a aVar = new a();
        aVar.FH = 7;
        aVar.Hw = fragment;
        j6(aVar);
        return this;
    }

    void j6(int i) {
        if (this.we) {
            if (o.j6) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (a aVar = this.FH; aVar != null; aVar = aVar.j6) {
                Fragment fragment;
                if (aVar.Hw != null) {
                    fragment = aVar.Hw;
                    fragment.BT += i;
                    if (o.j6) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.Hw + " to " + aVar.Hw.BT);
                    }
                }
                if (aVar.u7 != null) {
                    for (int size = aVar.u7.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) aVar.u7.get(size);
                        fragment.BT += i;
                        if (o.j6) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.BT);
                        }
                    }
                }
            }
        }
    }

    public int j6() {
        return j6(false);
    }

    public int DW() {
        return j6(true);
    }

    int j6(boolean z) {
        if (this.Ws) {
            throw new IllegalStateException("commit already called");
        }
        if (o.j6) {
            Log.v("FragmentManager", "Commit: " + this);
            j6("  ", null, new PrintWriter(new o("FragmentManager")), null);
        }
        this.Ws = true;
        if (this.we) {
            this.QX = this.DW.j6(this);
        } else {
            this.QX = -1;
        }
        this.DW.j6((Runnable) this, z);
        return this.QX;
    }

    public void run() {
        if (o.j6) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.we || this.QX >= 0) {
            b j6;
            j6(1);
            if (j6) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                DW(sparseArray, sparseArray2);
                j6 = j6(sparseArray, sparseArray2, false);
            } else {
                j6 = null;
            }
            int i = j6 != null ? 0 : this.EQ;
            int i2 = j6 != null ? 0 : this.tp;
            a aVar = this.FH;
            while (aVar != null) {
                int i3 = j6 != null ? 0 : aVar.v5;
                int i4 = j6 != null ? 0 : aVar.Zo;
                Fragment fragment;
                switch (aVar.FH) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        fragment = aVar.Hw;
                        fragment.vJ = i3;
                        this.DW.j6(fragment, false);
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        Fragment fragment2;
                        Fragment fragment3 = aVar.Hw;
                        int i5 = fragment3.KD;
                        if (this.DW.VH != null) {
                            fragment2 = fragment3;
                            for (int i6 = 0; i6 < this.DW.VH.size(); i6++) {
                                fragment = (Fragment) this.DW.VH.get(i6);
                                if (o.j6) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.KD == i5) {
                                    if (fragment == fragment2) {
                                        fragment2 = null;
                                        aVar.Hw = null;
                                    } else {
                                        if (aVar.u7 == null) {
                                            aVar.u7 = new ArrayList();
                                        }
                                        aVar.u7.add(fragment);
                                        fragment.vJ = i4;
                                        if (this.we) {
                                            fragment.BT++;
                                            if (o.j6) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.BT);
                                            }
                                        }
                                        this.DW.j6(fragment, i2, i);
                                    }
                                }
                            }
                        } else {
                            fragment2 = fragment3;
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.vJ = i3;
                        this.DW.j6(fragment2, false);
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        fragment = aVar.Hw;
                        fragment.vJ = i4;
                        this.DW.j6(fragment, i2, i);
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        fragment = aVar.Hw;
                        fragment.vJ = i4;
                        this.DW.DW(fragment, i2, i);
                        break;
                    case 5:
                        fragment = aVar.Hw;
                        fragment.vJ = i3;
                        this.DW.FH(fragment, i2, i);
                        break;
                    case 6:
                        fragment = aVar.Hw;
                        fragment.vJ = i4;
                        this.DW.Hw(fragment, i2, i);
                        break;
                    case 7:
                        fragment = aVar.Hw;
                        fragment.vJ = i3;
                        this.DW.v5(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.FH);
                }
                aVar = aVar.j6;
            }
            this.DW.j6(this.DW.J8, i2, i, true);
            if (this.we) {
                this.DW.DW(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void j6(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.KD;
            if (i != 0 && !fragment.J8() && fragment.we() && fragment.Ws() != null && sparseArray.get(i) == null) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void DW(SparseArray<Fragment> sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.KD;
            if (i != 0) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void DW(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.DW.QX.j6()) {
            for (a aVar = this.FH; aVar != null; aVar = aVar.j6) {
                switch (aVar.FH) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        DW((SparseArray) sparseArray2, aVar.Hw);
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        Fragment fragment;
                        Fragment fragment2 = aVar.Hw;
                        if (this.DW.VH != null) {
                            fragment = fragment2;
                            for (int i = 0; i < this.DW.VH.size(); i++) {
                                Fragment fragment3 = (Fragment) this.DW.VH.get(i);
                                if (fragment == null || fragment3.KD == fragment.KD) {
                                    if (fragment3 == fragment) {
                                        fragment = null;
                                    } else {
                                        j6((SparseArray) sparseArray, fragment3);
                                    }
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        DW((SparseArray) sparseArray2, fragment);
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        j6((SparseArray) sparseArray, aVar.Hw);
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        j6((SparseArray) sparseArray, aVar.Hw);
                        break;
                    case 5:
                        DW((SparseArray) sparseArray2, aVar.Hw);
                        break;
                    case 6:
                        j6((SparseArray) sparseArray, aVar.Hw);
                        break;
                    case 7:
                        DW((SparseArray) sparseArray2, aVar.Hw);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void j6(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.DW.QX.j6()) {
            for (a aVar = this.FH; aVar != null; aVar = aVar.j6) {
                switch (aVar.FH) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        j6((SparseArray) sparseArray, aVar.Hw);
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        if (aVar.u7 != null) {
                            for (int size = aVar.u7.size() - 1; size >= 0; size--) {
                                DW((SparseArray) sparseArray2, (Fragment) aVar.u7.get(size));
                            }
                        }
                        j6((SparseArray) sparseArray, aVar.Hw);
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        DW((SparseArray) sparseArray2, aVar.Hw);
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        DW((SparseArray) sparseArray2, aVar.Hw);
                        break;
                    case 5:
                        j6((SparseArray) sparseArray, aVar.Hw);
                        break;
                    case 6:
                        DW((SparseArray) sparseArray2, aVar.Hw);
                        break;
                    case 7:
                        j6((SparseArray) sparseArray, aVar.Hw);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public b j6(boolean z, b bVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (o.j6) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            j6("  ", null, new PrintWriter(new o("FragmentManager")), null);
        }
        if (j6) {
            if (bVar == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    bVar = j6((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                j6(bVar, this.a8, this.U2);
            }
        }
        j6(-1);
        int i = bVar != null ? 0 : this.EQ;
        int i2 = bVar != null ? 0 : this.tp;
        a aVar = this.Hw;
        while (aVar != null) {
            int i3 = bVar != null ? 0 : aVar.VH;
            int i4 = bVar != null ? 0 : aVar.gn;
            Fragment fragment;
            Fragment fragment2;
            switch (aVar.FH) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    fragment = aVar.Hw;
                    fragment.vJ = i4;
                    this.DW.j6(fragment, o.FH(i2), i);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    fragment = aVar.Hw;
                    if (fragment != null) {
                        fragment.vJ = i4;
                        this.DW.j6(fragment, o.FH(i2), i);
                    }
                    if (aVar.u7 == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < aVar.u7.size(); i5++) {
                        fragment2 = (Fragment) aVar.u7.get(i5);
                        fragment2.vJ = i3;
                        this.DW.j6(fragment2, false);
                    }
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    fragment2 = aVar.Hw;
                    fragment2.vJ = i3;
                    this.DW.j6(fragment2, false);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    fragment2 = aVar.Hw;
                    fragment2.vJ = i3;
                    this.DW.FH(fragment2, o.FH(i2), i);
                    break;
                case 5:
                    fragment = aVar.Hw;
                    fragment.vJ = i4;
                    this.DW.DW(fragment, o.FH(i2), i);
                    break;
                case 6:
                    fragment2 = aVar.Hw;
                    fragment2.vJ = i3;
                    this.DW.v5(fragment2, o.FH(i2), i);
                    break;
                case 7:
                    fragment2 = aVar.Hw;
                    fragment2.vJ = i3;
                    this.DW.Hw(fragment2, o.FH(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.FH);
            }
            aVar = aVar.DW;
        }
        if (z) {
            this.DW.j6(this.DW.J8, o.FH(i2), i, true);
            bVar = null;
        }
        if (this.QX >= 0) {
            this.DW.DW(this.QX);
            this.QX = -1;
        }
        return bVar;
    }

    public String FH() {
        return this.J8;
    }

    private b j6(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        b bVar = new b(this);
        bVar.Hw = new View(this.DW.Ws.VH());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (j6(sparseArray.keyAt(i2), bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && j6(i4, bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return bVar;
    }

    private static Object j6(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return r.j6(z ? fragment.rN() : fragment.U2());
    }

    private static Object DW(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return r.j6(z ? fragment.a8() : fragment.lg());
    }

    private static Object j6(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return r.DW(z ? fragment2.yS() : fragment.er());
    }

    private static Object j6(Object obj, Fragment fragment, ArrayList<View> arrayList, l<String, View> lVar, View view) {
        if (obj != null) {
            return r.j6(obj, fragment.Ws(), arrayList, lVar, view);
        }
        return obj;
    }

    private l<String, View> j6(b bVar, Fragment fragment, boolean z) {
        l lVar = new l();
        if (this.U2 != null) {
            r.j6((Map) lVar, fragment.Ws());
            if (z) {
                lVar.j6(this.a8);
            } else {
                lVar = j6(this.U2, this.a8, lVar);
            }
        }
        if (z) {
            if (fragment.wc != null) {
                fragment.wc.j6(this.a8, lVar);
            }
            j6(bVar, lVar, false);
        } else {
            if (fragment.et != null) {
                fragment.et.j6(this.a8, lVar);
            }
            DW(bVar, lVar, false);
        }
        return lVar;
    }

    private boolean j6(int i, b bVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.DW.QX.j6(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object j6;
        View view2;
        android.support.v4.app.r.b 1;
        ArrayList arrayList2;
        Map lVar;
        boolean z2;
        Object j62;
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object j63 = j6(fragment, z);
        Object j64 = j6(fragment, fragment2, z);
        Object DW = DW(fragment2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (j64 != null) {
            map = j6(bVar, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (j63 != null && obj == null && DW == null) {
                    return false;
                }
                arrayList = new ArrayList();
                j6 = j6(DW, fragment2, arrayList, (l) map, bVar.Hw);
                if (!(this.a8 == null || map == null)) {
                    view2 = (View) map.get(this.a8.get(0));
                    if (view2 != null) {
                        if (j6 != null) {
                            r.j6(j6, view2);
                        }
                        if (obj != null) {
                            r.j6(obj, view2);
                        }
                    }
                }
                1 = new 1(this, fragment);
                arrayList2 = new ArrayList();
                lVar = new l();
                z2 = true;
                if (fragment != null) {
                    z2 = z ? fragment.BT() : fragment.gW();
                }
                j62 = r.j6(j63, j6, obj, z2);
                if (j62 != null) {
                    r.j6(j63, obj, view, 1, bVar.Hw, bVar.FH, bVar.j6, arrayList2, map, lVar, arrayList3);
                    j6(view, bVar, i, j62);
                    r.j6(j62, bVar.Hw, true);
                    j6(bVar, i, j62);
                    r.j6((ViewGroup) view, j62);
                    r.j6(view, bVar.Hw, j63, arrayList2, j6, arrayList, obj, arrayList3, j62, bVar.DW, lVar);
                }
                if (j62 == null) {
                    return true;
                }
                return false;
            }
            aj ajVar = z ? fragment2.wc : fragment.wc;
            if (ajVar != null) {
                ajVar.j6(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
            }
            j6(bVar, view, j64, fragment, fragment2, z, arrayList3);
        }
        obj = j64;
        if (j63 != null) {
        }
        arrayList = new ArrayList();
        j6 = j6(DW, fragment2, arrayList, (l) map, bVar.Hw);
        view2 = (View) map.get(this.a8.get(0));
        if (view2 != null) {
            if (j6 != null) {
                r.j6(j6, view2);
            }
            if (obj != null) {
                r.j6(obj, view2);
            }
        }
        1 = new 1(this, fragment);
        arrayList2 = new ArrayList();
        lVar = new l();
        z2 = true;
        if (fragment != null) {
            if (z) {
            }
        }
        j62 = r.j6(j63, j6, obj, z2);
        if (j62 != null) {
            r.j6(j63, obj, view, 1, bVar.Hw, bVar.FH, bVar.j6, arrayList2, map, lVar, arrayList3);
            j6(view, bVar, i, j62);
            r.j6(j62, bVar.Hw, true);
            j6(bVar, i, j62);
            r.j6((ViewGroup) view, j62);
            r.j6(view, bVar.Hw, j63, arrayList2, j6, arrayList, obj, arrayList3, j62, bVar.DW, lVar);
        }
        if (j62 == null) {
            return false;
        }
        return true;
    }

    private void j6(b bVar, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new 2(this, view, obj, arrayList, bVar, z, fragment, fragment2));
    }

    private void j6(b bVar, Fragment fragment, Fragment fragment2, boolean z, l<String, View> lVar) {
        aj ajVar = z ? fragment2.wc : fragment.wc;
        if (ajVar != null) {
            ajVar.DW(new ArrayList(lVar.keySet()), new ArrayList(lVar.values()), null);
        }
    }

    private void j6(l<String, View> lVar, b bVar) {
        if (this.a8 != null && !lVar.isEmpty()) {
            View view = (View) lVar.get(this.a8.get(0));
            if (view != null) {
                bVar.FH.j6 = view;
            }
        }
    }

    private l<String, View> j6(b bVar, boolean z, Fragment fragment) {
        l DW = DW(bVar, fragment, z);
        if (z) {
            if (fragment.et != null) {
                fragment.et.j6(this.a8, DW);
            }
            j6(bVar, DW, true);
        } else {
            if (fragment.wc != null) {
                fragment.wc.j6(this.a8, DW);
            }
            DW(bVar, DW, true);
        }
        return DW;
    }

    private static l<String, View> j6(ArrayList<String> arrayList, ArrayList<String> arrayList2, l<String, View> lVar) {
        if (lVar.isEmpty()) {
            return lVar;
        }
        l<String, View> lVar2 = new l();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) lVar.get(arrayList.get(i));
            if (view != null) {
                lVar2.put(arrayList2.get(i), view);
            }
        }
        return lVar2;
    }

    private l<String, View> DW(b bVar, Fragment fragment, boolean z) {
        l lVar = new l();
        View Ws = fragment.Ws();
        if (Ws == null || this.U2 == null) {
            return lVar;
        }
        r.j6((Map) lVar, Ws);
        if (z) {
            return j6(this.U2, this.a8, lVar);
        }
        lVar.j6(this.a8);
        return lVar;
    }

    private void j6(View view, b bVar, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new 3(this, view, bVar, i, obj));
    }

    private void j6(b bVar, int i, Object obj) {
        if (this.DW.VH != null) {
            for (int i2 = 0; i2 < this.DW.VH.size(); i2++) {
                Fragment fragment = (Fragment) this.DW.VH.get(i2);
                if (!(fragment.Mz == null || fragment.g3 == null || fragment.KD != i)) {
                    if (!fragment.cn) {
                        r.j6(obj, fragment.Mz, false);
                        bVar.DW.remove(fragment.Mz);
                    } else if (!bVar.DW.contains(fragment.Mz)) {
                        r.j6(obj, fragment.Mz, true);
                        bVar.DW.add(fragment.Mz);
                    }
                }
            }
        }
    }

    private static void j6(l<String, String> lVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < lVar.size(); i++) {
                if (str.equals(lVar.FH(i))) {
                    lVar.j6(i, (Object) str2);
                    return;
                }
            }
            lVar.put(str, str2);
        }
    }

    private static void j6(b bVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                j6(bVar.j6, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void j6(b bVar, l<String, View> lVar, boolean z) {
        int size = this.a8 == null ? 0 : this.a8.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.U2.get(i);
            View view = (View) lVar.get((String) this.a8.get(i));
            if (view != null) {
                String j6 = r.j6(view);
                if (z) {
                    j6(bVar.j6, str, j6);
                } else {
                    j6(bVar.j6, j6, str);
                }
            }
        }
    }

    private void DW(b bVar, l<String, View> lVar, boolean z) {
        int size = lVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) lVar.DW(i);
            String j6 = r.j6((View) lVar.FH(i));
            if (z) {
                j6(bVar.j6, str, j6);
            } else {
                j6(bVar.j6, j6, str);
            }
        }
    }
}
