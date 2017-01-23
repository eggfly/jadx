package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.m;
import android.support.v4.view.z;
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
import com.aide.uidesigner.ProxyTextView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import n;

final class o extends n implements m {
    static final Interpolator BT;
    static final boolean DW;
    static final Interpolator gW;
    static boolean j6;
    static final Interpolator vy;
    static final Interpolator yS;
    ArrayList<g> EQ;
    ArrayList<Runnable> FH;
    Runnable[] Hw;
    ArrayList<android.support.v4.app.n.a> J0;
    int J8;
    boolean Mr;
    k QX;
    String U2;
    ArrayList<Fragment> VH;
    m Ws;
    Fragment XL;
    ArrayList<Fragment> Zo;
    boolean a8;
    boolean aM;
    Runnable er;
    ArrayList<Integer> gn;
    boolean j3;
    Bundle lg;
    SparseArray<Parcelable> rN;
    ArrayList<Fragment> tp;
    ArrayList<g> u7;
    boolean v5;
    ArrayList<Integer> we;

    class 1 implements Runnable {
        final /* synthetic */ o j6;

        1(o oVar) {
            this.j6 = oVar;
        }

        public void run() {
            this.j6.Zo();
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ int DW;
        final /* synthetic */ o FH;
        final /* synthetic */ int j6;

        2(o oVar, int i, int i2) {
            this.FH = oVar;
            this.j6 = i;
            this.DW = i2;
        }

        public void run() {
            this.FH.j6(this.FH.Ws.gn(), null, this.j6, this.DW);
        }
    }

    static class a implements AnimationListener {
        private View DW;
        private boolean j6;

        public a(View view, Animation animation) {
            this.j6 = false;
            if (view != null && animation != null) {
                this.DW = view;
            }
        }

        public void onAnimationStart(Animation animation) {
            this.j6 = o.j6(this.DW, animation);
            if (this.j6) {
                z.j6(this.DW, 2, null);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.j6) {
                z.j6(this.DW, 0, null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    class 3 extends a {
        final /* synthetic */ o DW;
        final /* synthetic */ Fragment j6;

        3(o oVar, View view, Animation animation, Fragment fragment) {
            this.DW = oVar;
            this.j6 = fragment;
            super(view, animation);
        }

        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            if (this.j6.we != null) {
                this.j6.we = null;
                this.DW.j6(this.j6, this.j6.J0, 0, 0, false);
            }
        }
    }

    static class b {
        public static final int[] j6;

        static {
            j6 = new int[]{16842755, 16842960, 16842961};
        }
    }

    o() {
        this.J8 = 0;
        this.lg = null;
        this.rN = null;
        this.er = new 1(this);
    }

    static {
        boolean z = false;
        j6 = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        DW = z;
        yS = new DecelerateInterpolator(2.5f);
        gW = new DecelerateInterpolator(1.5f);
        BT = new AccelerateInterpolator(2.5f);
        vy = new AccelerateInterpolator(1.5f);
    }

    static boolean j6(Animation animation) {
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

    static boolean j6(View view, Animation animation) {
        return z.Hw(view) == 0 && z.EQ(view) && j6(animation);
    }

    private void j6(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new o("FragmentManager"));
        if (this.Ws != null) {
            try {
                this.Ws.j6("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                j6("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public q j6() {
        return new g(this);
    }

    public boolean DW() {
        return Zo();
    }

    public boolean FH() {
        a8();
        DW();
        return j6(this.Ws.gn(), null, -1, 0);
    }

    public void j6(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        j6(new 2(this, i, i2), false);
    }

    public void j6(Bundle bundle, String str, Fragment fragment) {
        if (fragment.QX < 0) {
            j6(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.QX);
    }

    public Fragment j6(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.Zo.size()) {
            j6(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.Zo.get(i);
        if (fragment != null) {
            return fragment;
        }
        j6(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public List<Fragment> Hw() {
        return this.Zo;
    }

    public SavedState j6(Fragment fragment) {
        if (fragment.QX < 0) {
            j6(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.EQ <= 0) {
            return null;
        }
        Bundle VH = VH(fragment);
        if (VH != null) {
            return new SavedState(VH);
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.XL != null) {
            n.j6(this.XL, stringBuilder);
        } else {
            n.j6(this.Ws, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.Zo != null) {
            size = this.Zo.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.Zo.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.j6(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.VH != null) {
            size = this.VH.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.VH.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.tp != null) {
            size = this.tp.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.tp.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.u7 != null) {
            size = this.u7.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    g gVar = (g) this.u7.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(gVar.toString());
                    gVar.j6(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.EQ != null) {
                int size2 = this.EQ.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        gVar = (g) this.EQ.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(gVar);
                    }
                }
            }
            if (this.we != null && this.we.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.we.toArray()));
            }
        }
        if (this.FH != null) {
            i = this.FH.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.FH.get(i2);
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
        printWriter.println(this.Ws);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.QX);
        if (this.XL != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.XL);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.J8);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.j3);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.Mr);
        if (this.aM) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.aM);
        }
        if (this.U2 != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.U2);
        }
        if (this.gn != null && this.gn.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.gn.toArray()));
        }
    }

    static Animation j6(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(yS);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(gW);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation j6(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(gW);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation j6(Fragment fragment, int i, boolean z, int i2) {
        Animation j6 = fragment.j6(i, z, fragment.vJ);
        if (j6 != null) {
            return j6;
        }
        if (fragment.vJ != 0) {
            j6 = AnimationUtils.loadAnimation(this.Ws.VH(), fragment.vJ);
            if (j6 != null) {
                return j6;
            }
        }
        if (i == 0) {
            return null;
        }
        int DW = DW(i, z);
        if (DW < 0) {
            return null;
        }
        switch (DW) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return j6(this.Ws.VH(), 1.125f, 1.0f, 0.0f, 1.0f);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return j6(this.Ws.VH(), 1.0f, 0.975f, 1.0f, 0.0f);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return j6(this.Ws.VH(), 0.975f, 1.0f, 0.0f, 1.0f);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return j6(this.Ws.VH(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return j6(this.Ws.VH(), 0.0f, 1.0f);
            case 6:
                return j6(this.Ws.VH(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.Ws.Hw()) {
                    i2 = this.Ws.v5();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void DW(Fragment fragment) {
        if (!fragment.ca) {
            return;
        }
        if (this.v5) {
            this.a8 = true;
            return;
        }
        fragment.ca = false;
        j6(fragment, this.J8, 0, 0, false);
    }

    private void DW(View view, Animation animation) {
        if (view != null && animation != null && j6(view, animation)) {
            animation.setAnimationListener(new a(view, animation));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11.a8;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.sh;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.lg;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.EQ;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.EQ;
    L_0x001a:
        r0 = r11.ca;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.EQ;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.EQ;
        if (r0 >= r12) goto L_0x0285;
    L_0x0029:
        r0 = r11.er;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.yS;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.we;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.we = r7;
        r2 = r11.J0;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.j6(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.EQ;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0146;
            case 2: goto L_0x021c;
            case 3: goto L_0x021c;
            case 4: goto L_0x023f;
            default: goto L_0x0045;
        };
    L_0x0045:
        r11.EQ = r12;
        goto L_0x0031;
    L_0x0048:
        r0 = j6;
        if (r0 == 0) goto L_0x0066;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0066:
        r0 = r11.J8;
        if (r0 == 0) goto L_0x00b2;
    L_0x006a:
        r0 = r11.J8;
        r1 = r10.Ws;
        r1 = r1.VH();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.J8;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.Ws = r0;
        r0 = r11.J8;
        r1 = "android:target_state";
        r0 = r10.j6(r0, r1);
        r11.j3 = r0;
        r0 = r11.j3;
        if (r0 == 0) goto L_0x009e;
    L_0x0093:
        r0 = r11.J8;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.U2 = r0;
    L_0x009e:
        r0 = r11.J8;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.x9 = r0;
        r0 = r11.x9;
        if (r0 != 0) goto L_0x00b2;
    L_0x00ad:
        r11.ca = r5;
        if (r12 <= r6) goto L_0x00b2;
    L_0x00b1:
        r12 = r6;
    L_0x00b2:
        r0 = r10.Ws;
        r11.P8 = r0;
        r0 = r10.XL;
        r11.nw = r0;
        r0 = r10.XL;
        if (r0 == 0) goto L_0x00f4;
    L_0x00be:
        r0 = r10.XL;
        r0 = r0.ei;
    L_0x00c2:
        r11.vy = r0;
        r11.Sf = r3;
        r0 = r10.Ws;
        r0 = r0.VH();
        r11.j6(r0);
        r0 = r11.Sf;
        if (r0 != 0) goto L_0x00fb;
    L_0x00d3:
        r0 = new android.support.v4.app.ak;
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
    L_0x00f4:
        r0 = r10.Ws;
        r0 = r0.u7();
        goto L_0x00c2;
    L_0x00fb:
        r0 = r11.nw;
        if (r0 != 0) goto L_0x0104;
    L_0x00ff:
        r0 = r10.Ws;
        r0.DW(r11);
    L_0x0104:
        r0 = r11.dx;
        if (r0 != 0) goto L_0x010d;
    L_0x0108:
        r0 = r11.J8;
        r11.u7(r0);
    L_0x010d:
        r11.dx = r3;
        r0 = r11.er;
        if (r0 == 0) goto L_0x0146;
    L_0x0113:
        r0 = r11.J8;
        r0 = r11.DW(r0);
        r1 = r11.J8;
        r0 = r11.DW(r0, r7, r1);
        r11.Mz = r0;
        r0 = r11.Mz;
        if (r0 == 0) goto L_0x0274;
    L_0x0125:
        r0 = r11.Mz;
        r11.I = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x026a;
    L_0x012f:
        r0 = r11.Mz;
        android.support.v4.view.z.j6(r0, r3);
    L_0x0134:
        r0 = r11.cn;
        if (r0 == 0) goto L_0x013f;
    L_0x0138:
        r0 = r11.Mz;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x013f:
        r0 = r11.Mz;
        r1 = r11.J8;
        r11.j6(r0, r1);
    L_0x0146:
        if (r12 <= r5) goto L_0x021c;
    L_0x0148:
        r0 = j6;
        if (r0 == 0) goto L_0x0166;
    L_0x014c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0166:
        r0 = r11.er;
        if (r0 != 0) goto L_0x020c;
    L_0x016a:
        r0 = r11.KD;
        if (r0 == 0) goto L_0x03ee;
    L_0x016e:
        r0 = r10.QX;
        r1 = r11.KD;
        r0 = r0.j6(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01c0;
    L_0x017a:
        r1 = r11.gW;
        if (r1 != 0) goto L_0x01c0;
    L_0x017e:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "No view found for id 0x";
        r2 = r2.append(r4);
        r4 = r11.KD;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.u7();
        r8 = r11.KD;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.j6(r1);
    L_0x01c0:
        r11.g3 = r0;
        r1 = r11.J8;
        r1 = r11.DW(r1);
        r2 = r11.J8;
        r1 = r11.DW(r1, r0, r2);
        r11.Mz = r1;
        r1 = r11.Mz;
        if (r1 == 0) goto L_0x0282;
    L_0x01d4:
        r1 = r11.Mz;
        r11.I = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x0278;
    L_0x01de:
        r1 = r11.Mz;
        android.support.v4.view.z.j6(r1, r3);
    L_0x01e3:
        if (r0 == 0) goto L_0x01fa;
    L_0x01e5:
        r1 = r10.j6(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x01f5;
    L_0x01eb:
        r2 = r11.Mz;
        r10.DW(r2, r1);
        r2 = r11.Mz;
        r2.startAnimation(r1);
    L_0x01f5:
        r1 = r11.Mz;
        r0.addView(r1);
    L_0x01fa:
        r0 = r11.cn;
        if (r0 == 0) goto L_0x0205;
    L_0x01fe:
        r0 = r11.Mz;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0205:
        r0 = r11.Mz;
        r1 = r11.J8;
        r11.j6(r0, r1);
    L_0x020c:
        r0 = r11.J8;
        r11.tp(r0);
        r0 = r11.Mz;
        if (r0 == 0) goto L_0x021a;
    L_0x0215:
        r0 = r11.J8;
        r11.Zo(r0);
    L_0x021a:
        r11.J8 = r7;
    L_0x021c:
        if (r12 <= r6) goto L_0x023f;
    L_0x021e:
        r0 = j6;
        if (r0 == 0) goto L_0x023c;
    L_0x0222:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x023c:
        r11.P8();
    L_0x023f:
        if (r12 <= r9) goto L_0x0045;
    L_0x0241:
        r0 = j6;
        if (r0 == 0) goto L_0x025f;
    L_0x0245:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x025f:
        r11.rN = r5;
        r11.ei();
        r11.J8 = r7;
        r11.Ws = r7;
        goto L_0x0045;
    L_0x026a:
        r0 = r11.Mz;
        r0 = android.support.v4.app.NoSaveStateFrameLayout.j6(r0);
        r11.Mz = r0;
        goto L_0x0134;
    L_0x0274:
        r11.I = r7;
        goto L_0x0146;
    L_0x0278:
        r1 = r11.Mz;
        r1 = android.support.v4.app.NoSaveStateFrameLayout.j6(r1);
        r11.Mz = r1;
        goto L_0x01e3;
    L_0x0282:
        r11.I = r7;
        goto L_0x020c;
    L_0x0285:
        r0 = r11.EQ;
        if (r0 <= r12) goto L_0x0045;
    L_0x0289:
        r0 = r11.EQ;
        switch(r0) {
            case 1: goto L_0x0290;
            case 2: goto L_0x0316;
            case 3: goto L_0x02f3;
            case 4: goto L_0x02d0;
            case 5: goto L_0x02aa;
            default: goto L_0x028e;
        };
    L_0x028e:
        goto L_0x0045;
    L_0x0290:
        if (r12 >= r5) goto L_0x0045;
    L_0x0292:
        r0 = r10.Mr;
        if (r0 == 0) goto L_0x02a1;
    L_0x0296:
        r0 = r11.we;
        if (r0 == 0) goto L_0x02a1;
    L_0x029a:
        r0 = r11.we;
        r11.we = r7;
        r0.clearAnimation();
    L_0x02a1:
        r0 = r11.we;
        if (r0 == 0) goto L_0x0387;
    L_0x02a5:
        r11.J0 = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x02aa:
        r0 = 5;
        if (r12 >= r0) goto L_0x02d0;
    L_0x02ad:
        r0 = j6;
        if (r0 == 0) goto L_0x02cb;
    L_0x02b1:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02cb:
        r11.SI();
        r11.rN = r3;
    L_0x02d0:
        if (r12 >= r9) goto L_0x02f3;
    L_0x02d2:
        r0 = j6;
        if (r0 == 0) goto L_0x02f0;
    L_0x02d6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02f0:
        r11.KD();
    L_0x02f3:
        if (r12 >= r6) goto L_0x0316;
    L_0x02f5:
        r0 = j6;
        if (r0 == 0) goto L_0x0313;
    L_0x02f9:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0313:
        r11.ro();
    L_0x0316:
        r0 = 2;
        if (r12 >= r0) goto L_0x0290;
    L_0x0319:
        r0 = j6;
        if (r0 == 0) goto L_0x0337;
    L_0x031d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0337:
        r0 = r11.Mz;
        if (r0 == 0) goto L_0x034a;
    L_0x033b:
        r0 = r10.Ws;
        r0 = r0.j6(r11);
        if (r0 == 0) goto L_0x034a;
    L_0x0343:
        r0 = r11.Ws;
        if (r0 != 0) goto L_0x034a;
    L_0x0347:
        r10.Zo(r11);
    L_0x034a:
        r11.cn();
        r0 = r11.Mz;
        if (r0 == 0) goto L_0x037f;
    L_0x0351:
        r0 = r11.g3;
        if (r0 == 0) goto L_0x037f;
    L_0x0355:
        r0 = r10.J8;
        if (r0 <= 0) goto L_0x03eb;
    L_0x0359:
        r0 = r10.Mr;
        if (r0 != 0) goto L_0x03eb;
    L_0x035d:
        r0 = r10.j6(r11, r13, r3, r14);
    L_0x0361:
        if (r0 == 0) goto L_0x0378;
    L_0x0363:
        r1 = r11.Mz;
        r11.we = r1;
        r11.J0 = r12;
        r1 = r11.Mz;
        r2 = new android.support.v4.app.o$3;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.Mz;
        r1.startAnimation(r0);
    L_0x0378:
        r0 = r11.g3;
        r1 = r11.Mz;
        r0.removeView(r1);
    L_0x037f:
        r11.g3 = r7;
        r11.Mz = r7;
        r11.I = r7;
        goto L_0x0290;
    L_0x0387:
        r0 = j6;
        if (r0 == 0) goto L_0x03a5;
    L_0x038b:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03a5:
        r0 = r11.dx;
        if (r0 != 0) goto L_0x03ac;
    L_0x03a9:
        r11.sh();
    L_0x03ac:
        r11.Sf = r3;
        r11.DW();
        r0 = r11.Sf;
        if (r0 != 0) goto L_0x03d6;
    L_0x03b5:
        r0 = new android.support.v4.app.ak;
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
    L_0x03d6:
        if (r15 != 0) goto L_0x0045;
    L_0x03d8:
        r0 = r11.dx;
        if (r0 != 0) goto L_0x03e1;
    L_0x03dc:
        r10.v5(r11);
        goto L_0x0045;
    L_0x03e1:
        r11.P8 = r7;
        r11.nw = r7;
        r11.vy = r7;
        r11.ei = r7;
        goto L_0x0045;
    L_0x03eb:
        r0 = r7;
        goto L_0x0361;
    L_0x03ee:
        r0 = r7;
        goto L_0x01c0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.o.j6(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void FH(Fragment fragment) {
        j6(fragment, this.J8, 0, 0, false);
    }

    void j6(int i, boolean z) {
        j6(i, 0, 0, z);
    }

    void j6(int i, int i2, int i3, boolean z) {
        if (this.Ws == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.J8 != i) {
            this.J8 = i;
            if (this.Zo != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.Zo.size()) {
                    int j6;
                    Fragment fragment = (Fragment) this.Zo.get(i4);
                    if (fragment != null) {
                        j6(fragment, i, i2, i3, false);
                        if (fragment.Qq != null) {
                            j6 = i5 | fragment.Qq.j6();
                            i4++;
                            i5 = j6;
                        }
                    }
                    j6 = i5;
                    i4++;
                    i5 = j6;
                }
                if (i5 == 0) {
                    v5();
                }
                if (this.aM && this.Ws != null && this.J8 == 5) {
                    this.Ws.FH();
                    this.aM = false;
                }
            }
        }
    }

    void v5() {
        if (this.Zo != null) {
            for (int i = 0; i < this.Zo.size(); i++) {
                Fragment fragment = (Fragment) this.Zo.get(i);
                if (fragment != null) {
                    DW(fragment);
                }
            }
        }
    }

    void Hw(Fragment fragment) {
        if (fragment.QX < 0) {
            if (this.gn == null || this.gn.size() <= 0) {
                if (this.Zo == null) {
                    this.Zo = new ArrayList();
                }
                fragment.j6(this.Zo.size(), this.XL);
                this.Zo.add(fragment);
            } else {
                fragment.j6(((Integer) this.gn.remove(this.gn.size() - 1)).intValue(), this.XL);
                this.Zo.set(fragment.QX, fragment);
            }
            if (j6) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void v5(Fragment fragment) {
        if (fragment.QX >= 0) {
            if (j6) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.Zo.set(fragment.QX, null);
            if (this.gn == null) {
                this.gn = new ArrayList();
            }
            this.gn.add(Integer.valueOf(fragment.QX));
            this.Ws.j6(fragment.XL);
            fragment.j3();
        }
    }

    public void j6(Fragment fragment, boolean z) {
        if (this.VH == null) {
            this.VH = new ArrayList();
        }
        if (j6) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        Hw(fragment);
        if (!fragment.sh) {
            if (this.VH.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.VH.add(fragment);
            fragment.a8 = true;
            fragment.lg = false;
            if (fragment.sG && fragment.ef) {
                this.aM = true;
            }
            if (z) {
                FH(fragment);
            }
        }
    }

    public void j6(Fragment fragment, int i, int i2) {
        if (j6) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.BT);
        }
        boolean z = !fragment.Zo();
        if (!fragment.sh || z) {
            int i3;
            if (this.VH != null) {
                this.VH.remove(fragment);
            }
            if (fragment.sG && fragment.ef) {
                this.aM = true;
            }
            fragment.a8 = false;
            fragment.lg = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            j6(fragment, i3, i, i2, false);
        }
    }

    public void DW(Fragment fragment, int i, int i2) {
        if (j6) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.cn) {
            fragment.cn = true;
            if (fragment.Mz != null) {
                Animation j6 = j6(fragment, i, false, i2);
                if (j6 != null) {
                    DW(fragment.Mz, j6);
                    fragment.Mz.startAnimation(j6);
                }
                fragment.Mz.setVisibility(8);
            }
            if (fragment.a8 && fragment.sG && fragment.ef) {
                this.aM = true;
            }
            fragment.FH(true);
        }
    }

    public void FH(Fragment fragment, int i, int i2) {
        if (j6) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.cn) {
            fragment.cn = false;
            if (fragment.Mz != null) {
                Animation j6 = j6(fragment, i, true, i2);
                if (j6 != null) {
                    DW(fragment.Mz, j6);
                    fragment.Mz.startAnimation(j6);
                }
                fragment.Mz.setVisibility(0);
            }
            if (fragment.a8 && fragment.sG && fragment.ef) {
                this.aM = true;
            }
            fragment.FH(false);
        }
    }

    public void Hw(Fragment fragment, int i, int i2) {
        if (j6) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.sh) {
            fragment.sh = true;
            if (fragment.a8) {
                if (this.VH != null) {
                    if (j6) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.VH.remove(fragment);
                }
                if (fragment.sG && fragment.ef) {
                    this.aM = true;
                }
                fragment.a8 = false;
                j6(fragment, 1, i, i2, false);
            }
        }
    }

    public void v5(Fragment fragment, int i, int i2) {
        if (j6) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.sh) {
            fragment.sh = false;
            if (!fragment.a8) {
                if (this.VH == null) {
                    this.VH = new ArrayList();
                }
                if (this.VH.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (j6) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.VH.add(fragment);
                fragment.a8 = true;
                if (fragment.sG && fragment.ef) {
                    this.aM = true;
                }
                j6(fragment, this.J8, i, i2, false);
            }
        }
    }

    public Fragment j6(int i) {
        int size;
        Fragment fragment;
        if (this.VH != null) {
            for (size = this.VH.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.VH.get(size);
                if (fragment != null && fragment.SI == i) {
                    return fragment;
                }
            }
        }
        if (this.Zo != null) {
            for (size = this.Zo.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.Zo.get(size);
                if (fragment != null && fragment.SI == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment j6(String str) {
        int size;
        Fragment fragment;
        if (!(this.VH == null || str == null)) {
            for (size = this.VH.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.VH.get(size);
                if (fragment != null && str.equals(fragment.ro)) {
                    return fragment;
                }
            }
        }
        if (!(this.Zo == null || str == null)) {
            for (size = this.Zo.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.Zo.get(size);
                if (fragment != null && str.equals(fragment.ro)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    private void a8() {
        if (this.j3) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.U2 != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.U2);
        }
    }

    public void j6(Runnable runnable, boolean z) {
        if (!z) {
            a8();
        }
        synchronized (this) {
            if (this.Mr || this.Ws == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.FH == null) {
                this.FH = new ArrayList();
            }
            this.FH.add(runnable);
            if (this.FH.size() == 1) {
                this.Ws.gn().removeCallbacks(this.er);
                this.Ws.gn().post(this.er);
            }
        }
    }

    public int j6(g gVar) {
        int size;
        synchronized (this) {
            if (this.we == null || this.we.size() <= 0) {
                if (this.EQ == null) {
                    this.EQ = new ArrayList();
                }
                size = this.EQ.size();
                if (j6) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + gVar);
                }
                this.EQ.add(gVar);
            } else {
                size = ((Integer) this.we.remove(this.we.size() - 1)).intValue();
                if (j6) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + gVar);
                }
                this.EQ.set(size, gVar);
            }
        }
        return size;
    }

    public void j6(int i, g gVar) {
        synchronized (this) {
            if (this.EQ == null) {
                this.EQ = new ArrayList();
            }
            int size = this.EQ.size();
            if (i < size) {
                if (j6) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + gVar);
                }
                this.EQ.set(i, gVar);
            } else {
                while (size < i) {
                    this.EQ.add(null);
                    if (this.we == null) {
                        this.we = new ArrayList();
                    }
                    if (j6) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.we.add(Integer.valueOf(size));
                    size++;
                }
                if (j6) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + gVar);
                }
                this.EQ.add(gVar);
            }
        }
    }

    public void DW(int i) {
        synchronized (this) {
            this.EQ.set(i, null);
            if (this.we == null) {
                this.we = new ArrayList();
            }
            if (j6) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.we.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean Zo() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.v5;
        if (r1 == 0) goto L_0x000f;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000f:
        r1 = android.os.Looper.myLooper();
        r3 = r6.Ws;
        r3 = r3.gn();
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0028;
    L_0x001f:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0028:
        r1 = r2;
    L_0x0029:
        monitor-enter(r6);
        r3 = r6.FH;	 Catch:{ all -> 0x009d }
        if (r3 == 0) goto L_0x0036;
    L_0x002e:
        r3 = r6.FH;	 Catch:{ all -> 0x009d }
        r3 = r3.size();	 Catch:{ all -> 0x009d }
        if (r3 != 0) goto L_0x005e;
    L_0x0036:
        monitor-exit(r6);	 Catch:{ all -> 0x009d }
        r0 = r6.a8;
        if (r0 == 0) goto L_0x00ab;
    L_0x003b:
        r3 = r2;
        r4 = r2;
    L_0x003d:
        r0 = r6.Zo;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x00a4;
    L_0x0045:
        r0 = r6.Zo;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x005a;
    L_0x004f:
        r5 = r0.Qq;
        if (r5 == 0) goto L_0x005a;
    L_0x0053:
        r0 = r0.Qq;
        r0 = r0.j6();
        r4 = r4 | r0;
    L_0x005a:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003d;
    L_0x005e:
        r1 = r6.FH;	 Catch:{ all -> 0x009d }
        r3 = r1.size();	 Catch:{ all -> 0x009d }
        r1 = r6.Hw;	 Catch:{ all -> 0x009d }
        if (r1 == 0) goto L_0x006d;
    L_0x0068:
        r1 = r6.Hw;	 Catch:{ all -> 0x009d }
        r1 = r1.length;	 Catch:{ all -> 0x009d }
        if (r1 >= r3) goto L_0x0071;
    L_0x006d:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x009d }
        r6.Hw = r1;	 Catch:{ all -> 0x009d }
    L_0x0071:
        r1 = r6.FH;	 Catch:{ all -> 0x009d }
        r4 = r6.Hw;	 Catch:{ all -> 0x009d }
        r1.toArray(r4);	 Catch:{ all -> 0x009d }
        r1 = r6.FH;	 Catch:{ all -> 0x009d }
        r1.clear();	 Catch:{ all -> 0x009d }
        r1 = r6.Ws;	 Catch:{ all -> 0x009d }
        r1 = r1.gn();	 Catch:{ all -> 0x009d }
        r4 = r6.er;	 Catch:{ all -> 0x009d }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x009d }
        monitor-exit(r6);	 Catch:{ all -> 0x009d }
        r6.v5 = r0;
        r1 = r2;
    L_0x008c:
        if (r1 >= r3) goto L_0x00a0;
    L_0x008e:
        r4 = r6.Hw;
        r4 = r4[r1];
        r4.run();
        r4 = r6.Hw;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x008c;
    L_0x009d:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x009d }
        throw r0;
    L_0x00a0:
        r6.v5 = r2;
        r1 = r0;
        goto L_0x0029;
    L_0x00a4:
        if (r4 != 0) goto L_0x00ab;
    L_0x00a6:
        r6.a8 = r2;
        r6.v5();
    L_0x00ab:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.o.Zo():boolean");
    }

    void VH() {
        if (this.J0 != null) {
            for (int i = 0; i < this.J0.size(); i++) {
                ((android.support.v4.app.n.a) this.J0.get(i)).j6();
            }
        }
    }

    void DW(g gVar) {
        if (this.u7 == null) {
            this.u7 = new ArrayList();
        }
        this.u7.add(gVar);
        VH();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean j6(android.os.Handler r12, java.lang.String r13, int r14, int r15) {
        /*
        r11 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r11.u7;
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
        r0 = r11.u7;
        r0 = r0.size();
        r0 = r0 + -1;
        if (r0 < 0) goto L_0x0007;
    L_0x001a:
        r1 = r11.u7;
        r0 = r1.remove(r0);
        r0 = (android.support.v4.app.g) r0;
        r1 = new android.util.SparseArray;
        r1.<init>();
        r3 = new android.util.SparseArray;
        r3.<init>();
        r0.j6(r1, r3);
        r0.j6(r2, r4, r1, r3);
        r11.VH();
    L_0x0035:
        r3 = r2;
        goto L_0x0007;
    L_0x0037:
        r0 = -1;
        if (r13 != 0) goto L_0x003c;
    L_0x003a:
        if (r14 < 0) goto L_0x008b;
    L_0x003c:
        r0 = r11.u7;
        r0 = r0.size();
        r1 = r0 + -1;
    L_0x0044:
        if (r1 < 0) goto L_0x005a;
    L_0x0046:
        r0 = r11.u7;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.g) r0;
        if (r13 == 0) goto L_0x0081;
    L_0x0050:
        r5 = r0.FH();
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
        r0 = r11.u7;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.g) r0;
        if (r13 == 0) goto L_0x0078;
    L_0x006e:
        r5 = r0.FH();
        r5 = r13.equals(r5);
        if (r5 != 0) goto L_0x007e;
    L_0x0078:
        if (r14 < 0) goto L_0x008a;
    L_0x007a:
        r0 = r0.QX;
        if (r14 != r0) goto L_0x008a;
    L_0x007e:
        r1 = r1 + -1;
        goto L_0x0062;
    L_0x0081:
        if (r14 < 0) goto L_0x0087;
    L_0x0083:
        r0 = r0.QX;
        if (r14 == r0) goto L_0x005a;
    L_0x0087:
        r1 = r1 + -1;
        goto L_0x0044;
    L_0x008a:
        r0 = r1;
    L_0x008b:
        r1 = r11.u7;
        r1 = r1.size();
        r1 = r1 + -1;
        if (r0 == r1) goto L_0x0007;
    L_0x0095:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r1 = r11.u7;
        r1 = r1.size();
        r1 = r1 + -1;
    L_0x00a2:
        if (r1 <= r0) goto L_0x00b0;
    L_0x00a4:
        r5 = r11.u7;
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
        r0 = (android.support.v4.app.g) r0;
        r0.j6(r8, r9);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00c1;
    L_0x00d0:
        r5 = r4;
        r4 = r3;
    L_0x00d2:
        if (r4 > r7) goto L_0x010a;
    L_0x00d4:
        r0 = j6;
        if (r0 == 0) goto L_0x00f6;
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
    L_0x00f6:
        r0 = r6.get(r4);
        r0 = (android.support.v4.app.g) r0;
        if (r4 != r7) goto L_0x0108;
    L_0x00fe:
        r1 = r2;
    L_0x00ff:
        r1 = r0.j6(r1, r5, r8, r9);
        r0 = r4 + 1;
        r4 = r0;
        r5 = r1;
        goto L_0x00d2;
    L_0x0108:
        r1 = r3;
        goto L_0x00ff;
    L_0x010a:
        r11.VH();
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.o.j6(android.os.Handler, java.lang.String, int, int):boolean");
    }

    ArrayList<Fragment> gn() {
        ArrayList<Fragment> arrayList = null;
        if (this.Zo != null) {
            for (int i = 0; i < this.Zo.size(); i++) {
                Fragment fragment = (Fragment) this.Zo.get(i);
                if (fragment != null && fragment.cb) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.dx = true;
                    fragment.Mr = fragment.j3 != null ? fragment.j3.QX : -1;
                    if (j6) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    void Zo(Fragment fragment) {
        if (fragment.I != null) {
            if (this.rN == null) {
                this.rN = new SparseArray();
            } else {
                this.rN.clear();
            }
            fragment.I.saveHierarchyState(this.rN);
            if (this.rN.size() > 0) {
                fragment.Ws = this.rN;
                this.rN = null;
            }
        }
    }

    Bundle VH(Fragment fragment) {
        Bundle bundle;
        if (this.lg == null) {
            this.lg = new Bundle();
        }
        fragment.EQ(this.lg);
        if (this.lg.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.lg;
            this.lg = null;
        }
        if (fragment.Mz != null) {
            Zo(fragment);
        }
        if (fragment.Ws != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.Ws);
        }
        if (!fragment.x9) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.x9);
        }
        return bundle;
    }

    Parcelable u7() {
        BackStackState[] backStackStateArr = null;
        Zo();
        if (DW) {
            this.j3 = true;
        }
        if (this.Zo == null || this.Zo.size() <= 0) {
            return null;
        }
        int size = this.Zo.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.Zo.get(i);
            if (fragment != null) {
                if (fragment.QX < 0) {
                    j6(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.QX));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.EQ <= 0 || fragmentState.tp != null) {
                    fragmentState.tp = fragment.J8;
                } else {
                    fragmentState.tp = VH(fragment);
                    if (fragment.j3 != null) {
                        if (fragment.j3.QX < 0) {
                            j6(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.j3));
                        }
                        if (fragmentState.tp == null) {
                            fragmentState.tp = new Bundle();
                        }
                        j6(fragmentState.tp, "android:target_state", fragment.j3);
                        if (fragment.U2 != 0) {
                            fragmentState.tp.putInt("android:target_req_state", fragment.U2);
                        }
                    }
                }
                if (j6) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.tp);
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
            if (this.VH != null) {
                i = this.VH.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.VH.get(i2)).QX;
                        if (iArr[i2] < 0) {
                            j6(new IllegalStateException("Failure saving state: active " + this.VH.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (j6) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.VH.get(i2));
                        }
                    }
                    if (this.u7 != null) {
                        i = this.u7.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((g) this.u7.get(i2));
                                if (j6) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.u7.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.j6 = fragmentStateArr;
                    fragmentManagerState.DW = iArr;
                    fragmentManagerState.FH = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.u7 != null) {
                i = this.u7.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((g) this.u7.get(i2));
                        if (j6) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.u7.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.j6 = fragmentStateArr;
            fragmentManagerState.DW = iArr;
            fragmentManagerState.FH = backStackStateArr;
            return fragmentManagerState;
        } else if (!j6) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void j6(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.j6 != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (j6) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.j6[fragment.QX];
                        fragmentState.EQ = fragment;
                        fragment.Ws = null;
                        fragment.BT = 0;
                        fragment.yS = false;
                        fragment.a8 = false;
                        fragment.j3 = null;
                        if (fragmentState.tp != null) {
                            fragmentState.tp.setClassLoader(this.Ws.VH().getClassLoader());
                            fragment.Ws = fragmentState.tp.getSparseParcelableArray("android:view_state");
                            fragment.J8 = fragmentState.tp;
                        }
                    }
                }
                this.Zo = new ArrayList(fragmentManagerState.j6.length);
                if (this.gn != null) {
                    this.gn.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.j6.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.j6[i2];
                    if (fragmentState2 != null) {
                        Fragment j6 = fragmentState2.j6(this.Ws, this.XL);
                        if (j6) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + j6);
                        }
                        this.Zo.add(j6);
                        fragmentState2.EQ = null;
                    } else {
                        this.Zo.add(null);
                        if (this.gn == null) {
                            this.gn = new ArrayList();
                        }
                        if (j6) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.gn.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.Mr >= 0) {
                            if (fragment.Mr < this.Zo.size()) {
                                fragment.j3 = (Fragment) this.Zo.get(fragment.Mr);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.Mr);
                                fragment.j3 = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.DW != null) {
                    this.VH = new ArrayList(fragmentManagerState.DW.length);
                    for (i = 0; i < fragmentManagerState.DW.length; i++) {
                        fragment = (Fragment) this.Zo.get(fragmentManagerState.DW[i]);
                        if (fragment == null) {
                            j6(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.DW[i]));
                        }
                        fragment.a8 = true;
                        if (j6) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.VH.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.VH.add(fragment);
                    }
                } else {
                    this.VH = null;
                }
                if (fragmentManagerState.FH != null) {
                    this.u7 = new ArrayList(fragmentManagerState.FH.length);
                    for (i2 = 0; i2 < fragmentManagerState.FH.length; i2++) {
                        g j62 = fragmentManagerState.FH[i2].j6(this);
                        if (j6) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + j62.QX + "): " + j62);
                            j62.j6("  ", new PrintWriter(new o("FragmentManager")), false);
                        }
                        this.u7.add(j62);
                        if (j62.QX >= 0) {
                            j6(j62.QX, j62);
                        }
                    }
                    return;
                }
                this.u7 = null;
            }
        }
    }

    public void j6(m mVar, k kVar, Fragment fragment) {
        if (this.Ws != null) {
            throw new IllegalStateException("Already attached");
        }
        this.Ws = mVar;
        this.QX = kVar;
        this.XL = fragment;
    }

    public void tp() {
        this.j3 = false;
    }

    public void EQ() {
        this.j3 = false;
        j6(1, false);
    }

    public void we() {
        this.j3 = false;
        j6(2, false);
    }

    public void J0() {
        this.j3 = false;
        j6(4, false);
    }

    public void J8() {
        this.j3 = false;
        j6(5, false);
    }

    public void Ws() {
        j6(4, false);
    }

    public void QX() {
        this.j3 = true;
        j6(3, false);
    }

    public void XL() {
        j6(2, false);
    }

    public void aM() {
        j6(1, false);
    }

    public void j3() {
        this.Mr = true;
        Zo();
        j6(0, false);
        this.Ws = null;
        this.QX = null;
        this.XL = null;
    }

    public void j6(Configuration configuration) {
        if (this.VH != null) {
            for (int i = 0; i < this.VH.size(); i++) {
                Fragment fragment = (Fragment) this.VH.get(i);
                if (fragment != null) {
                    fragment.j6(configuration);
                }
            }
        }
    }

    public void Mr() {
        if (this.VH != null) {
            for (int i = 0; i < this.VH.size(); i++) {
                Fragment fragment = (Fragment) this.VH.get(i);
                if (fragment != null) {
                    fragment.nw();
                }
            }
        }
    }

    public boolean j6(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.VH != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.VH.size()) {
                fragment = (Fragment) this.VH.get(i2);
                if (fragment != null && fragment.DW(menu, menuInflater)) {
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
        if (this.tp != null) {
            while (i < this.tp.size()) {
                fragment = (Fragment) this.tp.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.Mr();
                }
                i++;
            }
        }
        this.tp = arrayList;
        return z;
    }

    public boolean j6(Menu menu) {
        if (this.VH == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.VH.size(); i++) {
            Fragment fragment = (Fragment) this.VH.get(i);
            if (fragment != null && fragment.FH(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean j6(MenuItem menuItem) {
        if (this.VH == null) {
            return false;
        }
        for (int i = 0; i < this.VH.size(); i++) {
            Fragment fragment = (Fragment) this.VH.get(i);
            if (fragment != null && fragment.FH(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean DW(MenuItem menuItem) {
        if (this.VH == null) {
            return false;
        }
        for (int i = 0; i < this.VH.size(); i++) {
            Fragment fragment = (Fragment) this.VH.get(i);
            if (fragment != null && fragment.Hw(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void DW(Menu menu) {
        if (this.VH != null) {
            for (int i = 0; i < this.VH.size(); i++) {
                Fragment fragment = (Fragment) this.VH.get(i);
                if (fragment != null) {
                    fragment.Hw(menu);
                }
            }
        }
    }

    public static int FH(int i) {
        switch (i) {
            case ProxyTextView.INPUTTYPE_textCapCharacters /*4097*/:
                return ProxyTextView.INPUTTYPE_numberDecimal;
            case 4099:
                return 4099;
            case ProxyTextView.INPUTTYPE_numberDecimal /*8194*/:
                return ProxyTextView.INPUTTYPE_textCapCharacters;
            default:
                return 0;
        }
    }

    public static int DW(int i, boolean z) {
        switch (i) {
            case ProxyTextView.INPUTTYPE_textCapCharacters /*4097*/:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case ProxyTextView.INPUTTYPE_numberDecimal /*8194*/:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View j6(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j6);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.DW(this.Ws.VH(), string)) {
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
        Fragment j6 = resourceId != -1 ? j6(resourceId) : null;
        if (j6 == null && string2 != null) {
            j6 = j6(string2);
        }
        if (j6 == null && id != -1) {
            j6 = j6(id);
        }
        if (j6) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + j6);
        }
        if (j6 == null) {
            Fragment j62 = Fragment.j6(context, string);
            j62.er = true;
            j62.SI = resourceId != 0 ? resourceId : id;
            j62.KD = id;
            j62.ro = string2;
            j62.yS = true;
            j62.vy = this;
            j62.j6(this.Ws.VH(), attributeSet, j62.J8);
            j6(j62, true);
            fragment = j62;
        } else if (j6.yS) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            j6.yS = true;
            if (!j6.dx) {
                j6.j6(this.Ws.VH(), attributeSet, j6.J8);
            }
            fragment = j6;
        }
        if (this.J8 >= 1 || !fragment.er) {
            FH(fragment);
        } else {
            j6(fragment, 1, 0, 0, false);
        }
        if (fragment.Mz == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.Mz.setId(resourceId);
        }
        if (fragment.Mz.getTag() == null) {
            fragment.Mz.setTag(string2);
        }
        return fragment.Mz;
    }

    m U2() {
        return this;
    }
}
