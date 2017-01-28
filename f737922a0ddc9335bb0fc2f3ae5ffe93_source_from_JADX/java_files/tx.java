import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;

public final class tx extends va {
    private final ArrayList<aah> DW;
    private final aah FH;
    private final int Hw;
    private final uc j6;
    private final int v5;

    public tx(aac aac, uc ucVar, ArrayList<aah> arrayList, aah aah) {
        super(aac, zx.j6);
        if (ucVar == null) {
            throw new NullPointerException("user == null");
        } else if (arrayList == null) {
            throw new NullPointerException("values == null");
        } else if (arrayList.size() <= 0) {
            throw new IllegalArgumentException("Illegal number of init values");
        } else {
            this.FH = aah;
            if (aah == abf.we || aah == abf.EQ) {
                this.Hw = 1;
            } else if (aah == abf.aM || aah == abf.J0) {
                this.Hw = 2;
            } else if (aah == abf.XL || aah == abf.Ws) {
                this.Hw = 4;
            } else if (aah == abf.QX || aah == abf.J8) {
                this.Hw = 8;
            } else {
                throw new IllegalArgumentException("Unexpected constant type");
            }
            this.j6 = ucVar;
            this.DW = arrayList;
            this.v5 = arrayList.size();
        }
    }

    public int j6() {
        return (((this.v5 * this.Hw) + 1) / 2) + 4;
    }

    public void j6(acr acr) {
        int size = this.DW.size();
        acr.DW(768);
        acr.DW(this.Hw);
        acr.Hw(this.v5);
        int i;
        switch (this.Hw) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                for (i = 0; i < size; i++) {
                    acr.FH((byte) ((aaw) ((aah) this.DW.get(i))).tp());
                }
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                for (i = 0; i < size; i++) {
                    acr.DW((short) ((aaw) ((aah) this.DW.get(i))).tp());
                }
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                for (i = 0; i < size; i++) {
                    acr.Hw(((aaw) ((aah) this.DW.get(i))).tp());
                }
                break;
            case 8:
                for (i = 0; i < size; i++) {
                    acr.j6(((aax) ((aah) this.DW.get(i))).EQ());
                }
                break;
        }
        if (this.Hw == 1 && size % 2 != 0) {
            acr.FH(0);
        }
    }

    public uf j6(zx zxVar) {
        return new tx(u7(), this.j6, this.DW, this.FH);
    }

    protected String DW() {
        StringBuffer stringBuffer = new StringBuffer(100);
        int size = this.DW.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("\n    ");
            stringBuffer.append(i);
            stringBuffer.append(": ");
            stringBuffer.append(((aah) this.DW.get(i)).Hw());
        }
        return stringBuffer.toString();
    }

    protected String j6(boolean z) {
        int VH = this.j6.VH();
        StringBuffer stringBuffer = new StringBuffer(100);
        int size = this.DW.size();
        stringBuffer.append("fill-array-data-payload // for fill-array-data @ ");
        stringBuffer.append(add.FH(VH));
        for (int i = 0; i < size; i++) {
            stringBuffer.append("\n  ");
            stringBuffer.append(i);
            stringBuffer.append(": ");
            stringBuffer.append(((aah) this.DW.get(i)).Hw());
        }
        return stringBuffer.toString();
    }
}
