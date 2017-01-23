import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.aide.uidesigner.ProxyTextView;

public class v {
    private static final v$e j6;
    private final Object DW;

    static {
        if (VERSION.SDK_INT >= 22) {
            j6 = new v$c();
        } else if (VERSION.SDK_INT >= 21) {
            j6 = new v$b();
        } else if (VERSION.SDK_INT >= 19) {
            j6 = new v$i();
        } else if (VERSION.SDK_INT >= 18) {
            j6 = new v$h();
        } else if (VERSION.SDK_INT >= 17) {
            j6 = new v$g();
        } else if (VERSION.SDK_INT >= 16) {
            j6 = new v$f();
        } else if (VERSION.SDK_INT >= 14) {
            j6 = new v$d();
        } else {
            j6 = new v$j();
        }
    }

    static v j6(Object obj) {
        if (obj != null) {
            return new v(obj);
        }
        return null;
    }

    public v(Object obj) {
        this.DW = obj;
    }

    public Object j6() {
        return this.DW;
    }

    public static v j6(v vVar) {
        return j6(j6.j6(vVar.DW));
    }

    public void j6(View view) {
        j6.FH(this.DW, view);
    }

    public void DW(View view) {
        j6.j6(this.DW, view);
    }

    public int DW() {
        return j6.DW(this.DW);
    }

    public void j6(int i) {
        j6.j6(this.DW, i);
    }

    public boolean j6(v$a v_a) {
        return j6.j6(this.DW, v_a.lg);
    }

    public void DW(int i) {
        j6.DW(this.DW, i);
    }

    public int FH() {
        return j6.aM(this.DW);
    }

    public void FH(View view) {
        j6.DW(this.DW, view);
    }

    public void j6(Rect rect) {
        j6.j6(this.DW, rect);
    }

    public void DW(Rect rect) {
        j6.FH(this.DW, rect);
    }

    public void FH(Rect rect) {
        j6.DW(this.DW, rect);
    }

    public void Hw(Rect rect) {
        j6.Hw(this.DW, rect);
    }

    public boolean Hw() {
        return j6.VH(this.DW);
    }

    public boolean v5() {
        return j6.gn(this.DW);
    }

    public boolean Zo() {
        return j6.EQ(this.DW);
    }

    public void j6(boolean z) {
        j6.FH(this.DW, z);
    }

    public boolean VH() {
        return j6.we(this.DW);
    }

    public void DW(boolean z) {
        j6.Hw(this.DW, z);
    }

    public boolean gn() {
        return j6.j3(this.DW);
    }

    public void FH(boolean z) {
        j6.gn(this.DW, z);
    }

    public boolean u7() {
        return j6.Mr(this.DW);
    }

    public void Hw(boolean z) {
        j6.u7(this.DW, z);
    }

    public boolean tp() {
        return j6.QX(this.DW);
    }

    public void v5(boolean z) {
        j6.VH(this.DW, z);
    }

    public boolean EQ() {
        return j6.u7(this.DW);
    }

    public void Zo(boolean z) {
        j6.j6(this.DW, z);
    }

    public boolean we() {
        return j6.J0(this.DW);
    }

    public void VH(boolean z) {
        j6.v5(this.DW, z);
    }

    public boolean J0() {
        return j6.tp(this.DW);
    }

    public void gn(boolean z) {
        j6.DW(this.DW, z);
    }

    public boolean J8() {
        return j6.J8(this.DW);
    }

    public boolean Ws() {
        return j6.Ws(this.DW);
    }

    public void u7(boolean z) {
        j6.Zo(this.DW, z);
    }

    public CharSequence QX() {
        return j6.v5(this.DW);
    }

    public void j6(CharSequence charSequence) {
        j6.FH(this.DW, charSequence);
    }

    public CharSequence XL() {
        return j6.FH(this.DW);
    }

    public void DW(CharSequence charSequence) {
        j6.j6(this.DW, charSequence);
    }

    public CharSequence aM() {
        return j6.Zo(this.DW);
    }

    public CharSequence j3() {
        return j6.Hw(this.DW);
    }

    public void FH(CharSequence charSequence) {
        j6.DW(this.DW, charSequence);
    }

    public void Mr() {
        j6.XL(this.DW);
    }

    public String U2() {
        return j6.U2(this.DW);
    }

    public int hashCode() {
        return this.DW == null ? 0 : this.DW.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        if (this.DW == null) {
            if (vVar.DW != null) {
                return false;
            }
            return true;
        } else if (this.DW.equals(vVar.DW)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        j6(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        FH(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(QX());
        stringBuilder.append("; className: ").append(XL());
        stringBuilder.append("; text: ").append(aM());
        stringBuilder.append("; contentDescription: ").append(j3());
        stringBuilder.append("; viewId: ").append(U2());
        stringBuilder.append("; checkable: ").append(Hw());
        stringBuilder.append("; checked: ").append(v5());
        stringBuilder.append("; focusable: ").append(Zo());
        stringBuilder.append("; focused: ").append(VH());
        stringBuilder.append("; selected: ").append(tp());
        stringBuilder.append("; clickable: ").append(EQ());
        stringBuilder.append("; longClickable: ").append(we());
        stringBuilder.append("; enabled: ").append(J0());
        stringBuilder.append("; password: ").append(J8());
        stringBuilder.append("; scrollable: " + Ws());
        stringBuilder.append("; [");
        int DW = DW();
        while (DW != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(DW);
            DW &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(FH(numberOfTrailingZeros));
            if (DW != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String FH(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return "ACTION_FOCUS";
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
