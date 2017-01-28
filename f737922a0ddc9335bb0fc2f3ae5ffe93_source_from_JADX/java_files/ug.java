import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;

public final class ug extends adc {
    private final int j6;

    public static ug j6(ArrayList<uf> arrayList, int i) {
        int size = arrayList.size();
        ug ugVar = new ug(size, i);
        for (int i2 = 0; i2 < size; i2++) {
            ugVar.j6(i2, (uf) arrayList.get(i2));
        }
        ugVar.l_();
        return ugVar;
    }

    public ug(int i, int i2) {
        super(i);
        this.j6 = i2;
    }

    public uf j6(int i) {
        return (uf) v5(i);
    }

    public void j6(int i, uf ufVar) {
        j6(i, ufVar);
    }

    public int v5() {
        int m_ = m_();
        if (m_ == 0) {
            return 0;
        }
        return j6(m_ - 1).J8();
    }

    public void j6(acr acr) {
        uf ufVar;
        int i = 0;
        int VH = acr.VH();
        int m_ = m_();
        if (acr.j6()) {
            boolean DW = acr.DW();
            for (int i2 = 0; i2 < m_; i2++) {
                String j6;
                ufVar = (uf) v5(i2);
                int j62 = ufVar.j6() * 2;
                if (j62 != 0 || DW) {
                    j6 = ufVar.j6("  ", acr.Hw(), true);
                } else {
                    j6 = null;
                }
                if (j6 != null) {
                    acr.j6(j62, j6);
                } else if (j62 != 0) {
                    acr.j6(j62, "");
                }
            }
        }
        while (i < m_) {
            ufVar = (uf) v5(i);
            try {
                ufVar.j6(acr);
                i++;
            } catch (Throwable e) {
                throw ada.j6(e, "...while writing " + ufVar);
            }
        }
        int VH2 = (acr.VH() - VH) / 2;
        if (VH2 != v5()) {
            throw new RuntimeException("write length mismatch; expected " + v5() + " but actually wrote " + VH2);
        }
    }

    public int Zo() {
        return this.j6;
    }

    public int VH() {
        int m_ = m_();
        int i = 0;
        int i2 = 0;
        while (i < m_) {
            int DW;
            uf ufVar = (uf) v5(i);
            if (ufVar instanceof ud) {
                aah FH = ((ud) ufVar).FH();
                if (FH instanceof aal) {
                    DW = ((aal) FH).DW(ufVar.gn().DW() == ProxyTextView.INPUTTYPE_textPostalAddress);
                    if (DW <= i2) {
                        DW = i2;
                    }
                } else {
                    DW = i2;
                }
            } else {
                DW = i2;
            }
            i++;
            i2 = DW;
        }
        return i2;
    }
}
