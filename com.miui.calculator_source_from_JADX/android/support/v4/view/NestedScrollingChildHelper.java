package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
    private final View f781a;
    private ViewParent f782b;
    private boolean f783c;
    private int[] f784d;

    public NestedScrollingChildHelper(View view) {
        this.f781a = view;
    }

    public void m1299a(boolean z) {
        if (this.f783c) {
            ViewCompat.m1475n(this.f781a);
        }
        this.f783c = z;
    }

    public boolean m1300a() {
        return this.f783c;
    }

    public boolean m1306b() {
        return this.f782b != null;
    }

    public boolean m1303a(int i) {
        if (m1306b()) {
            return true;
        }
        if (m1300a()) {
            View view = this.f781a;
            for (ViewParent parent = this.f781a.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.m1604a(parent, view, this.f781a, i)) {
                    this.f782b = parent;
                    ViewParentCompat.m1606b(parent, view, this.f781a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void m1307c() {
        if (this.f782b != null) {
            ViewParentCompat.m1599a(this.f782b, this.f781a);
            this.f782b = null;
        }
    }

    public boolean m1304a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m1300a() || this.f782b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f781a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            ViewParentCompat.m1600a(this.f782b, this.f781a, i, i2, i3, i4);
            if (iArr != null) {
                this.f781a.getLocationInWindow(iArr);
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

    public boolean m1305a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m1300a() || this.f782b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f781a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f784d == null) {
                    this.f784d = new int[2];
                }
                iArr = this.f784d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParentCompat.m1601a(this.f782b, this.f781a, i, i2, iArr);
            if (iArr2 != null) {
                this.f781a.getLocationInWindow(iArr2);
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

    public boolean m1302a(float f, float f2, boolean z) {
        if (!m1300a() || this.f782b == null) {
            return false;
        }
        return ViewParentCompat.m1603a(this.f782b, this.f781a, f, f2, z);
    }

    public boolean m1301a(float f, float f2) {
        if (!m1300a() || this.f782b == null) {
            return false;
        }
        return ViewParentCompat.m1602a(this.f782b, this.f781a, f, f2);
    }
}
