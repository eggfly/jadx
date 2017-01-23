package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class s {
    private ViewParent DW;
    private boolean FH;
    private int[] Hw;
    private final View j6;

    public s(View view) {
        this.j6 = view;
    }

    public void j6(boolean z) {
        if (this.FH) {
            z.J0(this.j6);
        }
        this.FH = z;
    }

    public boolean j6() {
        return this.FH;
    }

    public boolean DW() {
        return this.DW != null;
    }

    public boolean j6(int i) {
        if (DW()) {
            return true;
        }
        if (j6()) {
            View view = this.j6;
            for (ViewParent parent = this.j6.getParent(); parent != null; parent = parent.getParent()) {
                if (al.j6(parent, view, this.j6, i)) {
                    this.DW = parent;
                    al.DW(parent, view, this.j6, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void FH() {
        if (this.DW != null) {
            al.j6(this.DW, this.j6);
            this.DW = null;
        }
    }

    public boolean j6(int i, int i2, int i3, int i4, int[] iArr) {
        if (!j6() || this.DW == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.j6.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            al.j6(this.DW, this.j6, i, i2, i3, i4);
            if (iArr != null) {
                this.j6.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean j6(int i, int i2, int[] iArr, int[] iArr2) {
        if (!j6() || this.DW == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.j6.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.Hw == null) {
                    this.Hw = new int[2];
                }
                iArr = this.Hw;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            al.j6(this.DW, this.j6, i, i2, iArr);
            if (iArr2 != null) {
                this.j6.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean j6(float f, float f2, boolean z) {
        if (!j6() || this.DW == null) {
            return false;
        }
        return al.j6(this.DW, this.j6, f, f2, z);
    }

    public boolean j6(float f, float f2) {
        if (!j6() || this.DW == null) {
            return false;
        }
        return al.j6(this.DW, this.j6, f, f2);
    }
}
