package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.n;
import android.support.v4.view.x;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.aide.uidesigner.ProxyTextView;
import java.util.Arrays;

public class j {
    private static final Interpolator a8;
    private int DW;
    private int EQ;
    private int FH;
    private float[] Hw;
    private float J0;
    private float J8;
    private boolean Mr;
    private int QX;
    private final ViewGroup U2;
    private float[] VH;
    private int Ws;
    private g XL;
    private float[] Zo;
    private final a aM;
    private int[] gn;
    private View j3;
    private int j6;
    private final Runnable lg;
    private int[] tp;
    private int[] u7;
    private float[] v5;
    private VelocityTracker we;

    public static abstract class a {
        public abstract boolean j6(View view, int i);

        public void j6(int i) {
        }

        public void j6(View view, int i, int i2, int i3, int i4) {
        }

        public void DW(View view, int i) {
        }

        public void j6(View view, float f, float f2) {
        }

        public void j6(int i, int i2) {
        }

        public boolean DW(int i) {
            return false;
        }

        public void DW(int i, int i2) {
        }

        public int FH(int i) {
            return i;
        }

        public int j6(View view) {
            return 0;
        }

        public int DW(View view) {
            return 0;
        }

        public int j6(View view, int i, int i2) {
            return 0;
        }

        public int DW(View view, int i, int i2) {
            return 0;
        }
    }

    static class 1 implements Interpolator {
        1() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ j j6;

        2(j jVar) {
            this.j6 = jVar;
        }

        public void run() {
            this.j6.FH(0);
        }
    }

    static {
        a8 = new 1();
    }

    public static j j6(ViewGroup viewGroup, a aVar) {
        return new j(viewGroup.getContext(), viewGroup, aVar);
    }

    public static j j6(ViewGroup viewGroup, float f, a aVar) {
        j j6 = j6(viewGroup, aVar);
        j6.DW = (int) (((float) j6.DW) * (1.0f / f));
        return j6;
    }

    private j(Context context, ViewGroup viewGroup, a aVar) {
        this.FH = -1;
        this.lg = new 2(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.U2 = viewGroup;
            this.aM = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.Ws = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.DW = viewConfiguration.getScaledTouchSlop();
            this.J0 = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.J8 = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.XL = g.j6(context, a8);
        }
    }

    public void j6(float f) {
        this.J8 = f;
    }

    public int j6() {
        return this.j6;
    }

    public void j6(int i) {
        this.QX = i;
    }

    public int DW() {
        return this.Ws;
    }

    public void j6(View view, int i) {
        if (view.getParent() != this.U2) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.U2 + ")");
        }
        this.j3 = view;
        this.FH = i;
        this.aM.DW(view, i);
        FH(1);
    }

    public View FH() {
        return this.j3;
    }

    public int Hw() {
        return this.DW;
    }

    public void v5() {
        this.FH = -1;
        VH();
        if (this.we != null) {
            this.we.recycle();
            this.we = null;
        }
    }

    public void Zo() {
        v5();
        if (this.j6 == 2) {
            int DW = this.XL.DW();
            int FH = this.XL.FH();
            this.XL.gn();
            int DW2 = this.XL.DW();
            int FH2 = this.XL.FH();
            this.aM.j6(this.j3, DW2, FH2, DW2 - DW, FH2 - FH);
        }
        FH(0);
    }

    public boolean j6(View view, int i, int i2) {
        this.j3 = view;
        this.FH = -1;
        boolean j6 = j6(i, i2, 0, 0);
        if (!(j6 || this.j6 != 0 || this.j3 == null)) {
            this.j3 = null;
        }
        return j6;
    }

    public boolean j6(int i, int i2) {
        if (this.Mr) {
            return j6(i, i2, (int) x.j6(this.we, this.FH), (int) x.DW(this.we, this.FH));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean j6(int i, int i2, int i3, int i4) {
        int left = this.j3.getLeft();
        int top = this.j3.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.XL.gn();
            FH(0);
            return false;
        }
        this.XL.j6(left, top, i5, i6, j6(this.j3, i5, i6, i3, i4));
        FH(2);
        return true;
    }

    private int j6(View view, int i, int i2, int i3, int i4) {
        int DW = DW(i3, (int) this.J8, (int) this.J0);
        int DW2 = DW(i4, (int) this.J8, (int) this.J0);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(DW);
        int abs4 = Math.abs(DW2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((DW2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) j6(i2, DW2, this.aM.DW(view)))) + ((DW != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) j6(i, DW, this.aM.j6(view)))));
    }

    private int j6(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.U2.getWidth();
        int i4 = width / 2;
        float DW = (DW(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(DW / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private int DW(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private float j6(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private float DW(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean j6(boolean z) {
        if (this.j6 == 2) {
            int i;
            boolean VH = this.XL.VH();
            int DW = this.XL.DW();
            int FH = this.XL.FH();
            int left = DW - this.j3.getLeft();
            int top = FH - this.j3.getTop();
            if (left != 0) {
                this.j3.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.j3.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.aM.j6(this.j3, DW, FH, left, top);
            }
            if (VH && DW == this.XL.Hw() && FH == this.XL.v5()) {
                this.XL.gn();
                i = 0;
            } else {
                boolean z2 = VH;
            }
            if (i == 0) {
                if (z) {
                    this.U2.post(this.lg);
                } else {
                    FH(0);
                }
            }
        }
        return this.j6 == 2;
    }

    private void j6(float f, float f2) {
        this.Mr = true;
        this.aM.j6(this.j3, f, f2);
        this.Mr = false;
        if (this.j6 == 1) {
            FH(0);
        }
    }

    private void VH() {
        if (this.Hw != null) {
            Arrays.fill(this.Hw, 0.0f);
            Arrays.fill(this.v5, 0.0f);
            Arrays.fill(this.Zo, 0.0f);
            Arrays.fill(this.VH, 0.0f);
            Arrays.fill(this.gn, 0);
            Arrays.fill(this.u7, 0);
            Arrays.fill(this.tp, 0);
            this.EQ = 0;
        }
    }

    private void v5(int i) {
        if (this.Hw != null) {
            this.Hw[i] = 0.0f;
            this.v5[i] = 0.0f;
            this.Zo[i] = 0.0f;
            this.VH[i] = 0.0f;
            this.gn[i] = 0;
            this.u7[i] = 0;
            this.tp[i] = 0;
            this.EQ &= (1 << i) ^ -1;
        }
    }

    private void Zo(int i) {
        if (this.Hw == null || this.Hw.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.Hw != null) {
                System.arraycopy(this.Hw, 0, obj, 0, this.Hw.length);
                System.arraycopy(this.v5, 0, obj2, 0, this.v5.length);
                System.arraycopy(this.Zo, 0, obj3, 0, this.Zo.length);
                System.arraycopy(this.VH, 0, obj4, 0, this.VH.length);
                System.arraycopy(this.gn, 0, obj5, 0, this.gn.length);
                System.arraycopy(this.u7, 0, obj6, 0, this.u7.length);
                System.arraycopy(this.tp, 0, obj7, 0, this.tp.length);
            }
            this.Hw = obj;
            this.v5 = obj2;
            this.Zo = obj3;
            this.VH = obj4;
            this.gn = obj5;
            this.u7 = obj6;
            this.tp = obj7;
        }
    }

    private void j6(float f, float f2, int i) {
        Zo(i);
        float[] fArr = this.Hw;
        this.Zo[i] = f;
        fArr[i] = f;
        fArr = this.v5;
        this.VH[i] = f2;
        fArr[i] = f2;
        this.gn[i] = v5((int) f, (int) f2);
        this.EQ |= 1 << i;
    }

    private void FH(MotionEvent motionEvent) {
        int FH = n.FH(motionEvent);
        for (int i = 0; i < FH; i++) {
            int DW = n.DW(motionEvent, i);
            float FH2 = n.FH(motionEvent, i);
            float Hw = n.Hw(motionEvent, i);
            this.Zo[DW] = FH2;
            this.VH[DW] = Hw;
        }
    }

    public boolean DW(int i) {
        return (this.EQ & (1 << i)) != 0;
    }

    void FH(int i) {
        this.U2.removeCallbacks(this.lg);
        if (this.j6 != i) {
            this.j6 = i;
            this.aM.j6(i);
            if (this.j6 == 0) {
                this.j3 = null;
            }
        }
    }

    boolean DW(View view, int i) {
        if (view == this.j3 && this.FH == i) {
            return true;
        }
        if (view == null || !this.aM.j6(view, i)) {
            return false;
        }
        this.FH = i;
        j6(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j6(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.n.j6(r14);
        r1 = android.support.v4.view.n.DW(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.v5();
    L_0x000d:
        r2 = r13.we;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.we = r2;
    L_0x0017:
        r2 = r13.we;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0121;
            case 2: goto L_0x0092;
            case 3: goto L_0x0121;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x0118;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.j6;
        r1 = 1;
        if (r0 != r1) goto L_0x0126;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.n.DW(r14, r2);
        r13.j6(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.Hw(r0, r1);
        r1 = r13.j3;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.j6;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.DW(r0, r2);
    L_0x0048:
        r0 = r13.gn;
        r0 = r0[r2];
        r1 = r13.QX;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.aM;
        r3 = r13.QX;
        r0 = r0 & r3;
        r1.j6(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.view.n.DW(r14, r1);
        r2 = android.support.v4.view.n.FH(r14, r1);
        r1 = android.support.v4.view.n.Hw(r14, r1);
        r13.j6(r2, r1, r0);
        r3 = r13.j6;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.gn;
        r1 = r1[r0];
        r2 = r13.QX;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.aM;
        r3 = r13.QX;
        r1 = r1 & r3;
        r2.j6(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.j6;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.Hw(r2, r1);
        r2 = r13.j3;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.DW(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.Hw;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.v5;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.view.n.FH(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x00fd;
    L_0x00a2:
        r3 = android.support.v4.view.n.DW(r14, r1);
        r0 = android.support.v4.view.n.FH(r14, r1);
        r4 = android.support.v4.view.n.Hw(r14, r1);
        r5 = r13.Hw;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.v5;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.Hw(r0, r4);
        if (r4 == 0) goto L_0x0102;
    L_0x00c2:
        r0 = r13.j6(r4, r5, r6);
        if (r0 == 0) goto L_0x0102;
    L_0x00c8:
        r0 = 1;
    L_0x00c9:
        if (r0 == 0) goto L_0x0104;
    L_0x00cb:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.aM;
        r10 = (int) r5;
        r8 = r9.j6(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.aM;
        r12 = (int) r6;
        r10 = r11.DW(r4, r10, r12);
        r11 = r13.aM;
        r11 = r11.j6(r4);
        r12 = r13.aM;
        r12 = r12.DW(r4);
        if (r11 == 0) goto L_0x00f7;
    L_0x00f3:
        if (r11 <= 0) goto L_0x0104;
    L_0x00f5:
        if (r8 != r7) goto L_0x0104;
    L_0x00f7:
        if (r12 == 0) goto L_0x00fd;
    L_0x00f9:
        if (r12 <= 0) goto L_0x0104;
    L_0x00fb:
        if (r10 != r9) goto L_0x0104;
    L_0x00fd:
        r13.FH(r14);
        goto L_0x001f;
    L_0x0102:
        r0 = 0;
        goto L_0x00c9;
    L_0x0104:
        r13.DW(r5, r6, r3);
        r5 = r13.j6;
        r6 = 1;
        if (r5 == r6) goto L_0x00fd;
    L_0x010c:
        if (r0 == 0) goto L_0x0114;
    L_0x010e:
        r0 = r13.DW(r4, r3);
        if (r0 != 0) goto L_0x00fd;
    L_0x0114:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x0118:
        r0 = android.support.v4.view.n.DW(r14, r1);
        r13.v5(r0);
        goto L_0x001f;
    L_0x0121:
        r13.v5();
        goto L_0x001f;
    L_0x0126:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.j.j6(android.view.MotionEvent):boolean");
    }

    public void DW(MotionEvent motionEvent) {
        int i = 0;
        int j6 = n.j6(motionEvent);
        int DW = n.DW(motionEvent);
        if (j6 == 0) {
            v5();
        }
        if (this.we == null) {
            this.we = VelocityTracker.obtain();
        }
        this.we.addMovement(motionEvent);
        float x;
        float y;
        View Hw;
        int i2;
        switch (j6) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = n.DW(motionEvent, 0);
                Hw = Hw((int) x, (int) y);
                j6(x, y, i);
                DW(Hw, i);
                i2 = this.gn[i];
                if ((this.QX & i2) != 0) {
                    this.aM.j6(i2 & this.QX, i);
                }
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (this.j6 == 1) {
                    gn();
                }
                v5();
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                if (this.j6 == 1) {
                    i = n.j6(motionEvent, this.FH);
                    x = n.FH(motionEvent, i);
                    i2 = (int) (x - this.Zo[this.FH]);
                    i = (int) (n.Hw(motionEvent, i) - this.VH[this.FH]);
                    DW(this.j3.getLeft() + i2, this.j3.getTop() + i, i2, i);
                    FH(motionEvent);
                    return;
                }
                i2 = n.FH(motionEvent);
                while (i < i2) {
                    j6 = n.DW(motionEvent, i);
                    float FH = n.FH(motionEvent, i);
                    float Hw2 = n.Hw(motionEvent, i);
                    float f = FH - this.Hw[j6];
                    float f2 = Hw2 - this.v5[j6];
                    DW(f, f2, j6);
                    if (this.j6 != 1) {
                        Hw = Hw((int) FH, (int) Hw2);
                        if (!j6(Hw, f, f2) || !DW(Hw, j6)) {
                            i++;
                        }
                    }
                    FH(motionEvent);
                }
                FH(motionEvent);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                if (this.j6 == 1) {
                    j6(0.0f, 0.0f);
                }
                v5();
            case 5:
                i = n.DW(motionEvent, DW);
                x = n.FH(motionEvent, DW);
                y = n.Hw(motionEvent, DW);
                j6(x, y, i);
                if (this.j6 == 0) {
                    DW(Hw((int) x, (int) y), i);
                    i2 = this.gn[i];
                    if ((this.QX & i2) != 0) {
                        this.aM.j6(i2 & this.QX, i);
                    }
                } else if (FH((int) x, (int) y)) {
                    DW(this.j3, i);
                }
            case 6:
                j6 = n.DW(motionEvent, DW);
                if (this.j6 == 1 && j6 == this.FH) {
                    DW = n.FH(motionEvent);
                    while (i < DW) {
                        int DW2 = n.DW(motionEvent, i);
                        if (DW2 != this.FH) {
                            if (Hw((int) n.FH(motionEvent, i), (int) n.Hw(motionEvent, i)) == this.j3 && DW(this.j3, DW2)) {
                                i = this.FH;
                                if (i == -1) {
                                    gn();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        gn();
                    }
                }
                v5(j6);
            default:
        }
    }

    private void DW(float f, float f2, int i) {
        int i2 = 1;
        if (!j6(f, f2, i, 1)) {
            i2 = 0;
        }
        if (j6(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (j6(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (j6(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.u7;
            iArr[i] = iArr[i] | i2;
            this.aM.DW(i2, i);
        }
    }

    private boolean j6(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.gn[i] & i2) != i2 || (this.QX & i2) == 0 || (this.tp[i] & i2) == i2 || (this.u7[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.DW) && abs2 <= ((float) this.DW)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.aM.DW(i2)) {
            int[] iArr = this.tp;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.u7[i] & i2) != 0 || abs <= ((float) this.DW)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean j6(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.aM.j6(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.aM.DW(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) <= ((float) (this.DW * this.DW))) {
                return false;
            }
            return true;
        } else if (z) {
            if (Math.abs(f) <= ((float) this.DW)) {
                return false;
            }
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.DW)) {
                return false;
            }
            return true;
        }
    }

    public boolean Hw(int i) {
        int length = this.Hw.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (DW(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean DW(int i, int i2) {
        if (!DW(i2)) {
            return false;
        }
        boolean z;
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.Zo[i2] - this.Hw[i2];
        float f2 = this.VH[i2] - this.v5[i2];
        if (z2 && z) {
            if ((f * f) + (f2 * f2) <= ((float) (this.DW * this.DW))) {
                return false;
            }
            return true;
        } else if (z2) {
            if (Math.abs(f) <= ((float) this.DW)) {
                return false;
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            if (Math.abs(f2) <= ((float) this.DW)) {
                return false;
            }
            return true;
        }
    }

    private void gn() {
        this.we.computeCurrentVelocity(1000, this.J0);
        j6(j6(x.j6(this.we, this.FH), this.J8, this.J0), j6(x.DW(this.we, this.FH), this.J8, this.J0));
    }

    private void DW(int i, int i2, int i3, int i4) {
        int j6;
        int DW;
        int left = this.j3.getLeft();
        int top = this.j3.getTop();
        if (i3 != 0) {
            j6 = this.aM.j6(this.j3, i, i3);
            this.j3.offsetLeftAndRight(j6 - left);
        } else {
            j6 = i;
        }
        if (i4 != 0) {
            DW = this.aM.DW(this.j3, i2, i4);
            this.j3.offsetTopAndBottom(DW - top);
        } else {
            DW = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.aM.j6(this.j3, j6, DW, j6 - left, DW - top);
        }
    }

    public boolean FH(int i, int i2) {
        return DW(this.j3, i, i2);
    }

    public boolean DW(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View Hw(int i, int i2) {
        for (int childCount = this.U2.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.U2.getChildAt(this.aM.FH(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int v5(int i, int i2) {
        int i3 = 0;
        if (i < this.U2.getLeft() + this.Ws) {
            i3 = 1;
        }
        if (i2 < this.U2.getTop() + this.Ws) {
            i3 |= 4;
        }
        if (i > this.U2.getRight() - this.Ws) {
            i3 |= 2;
        }
        if (i2 > this.U2.getBottom() - this.Ws) {
            return i3 | 8;
        }
        return i3;
    }
}
