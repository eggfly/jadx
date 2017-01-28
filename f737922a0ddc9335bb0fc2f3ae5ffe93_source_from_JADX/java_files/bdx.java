import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

public class bdx extends bdy {
    private List rN;

    public bdx() {
        this.rN = new ArrayList();
    }

    public bdw j6(String str, bds bds, boolean z, String str2, boolean z2) {
        return j6(str, bds, z, beb.j6(str2), z2);
    }

    public bdw j6(String str, bds bds, boolean z, Provider provider, boolean z2) {
        ayq ayq;
        if ((str == null ? 1 : null) != null) {
            ayq = null;
        } else {
            ayq = new ayq(str);
        }
        for (bdx$a j6 : this.rN) {
            try {
                this.U2.add(j6.j6(this.lg, provider, z2));
            } catch (Exception e) {
                throw new bdr("exception creating signerInf", e);
            } catch (Exception e2) {
                throw new bdr("exception encoding attributes", e2);
            } catch (Exception e22) {
                throw new bdr("error creating sid.", e22);
            }
        }
        this.rN.clear();
        return bds != null ? j6(new bdx$1(this, ayq, bds), z) : j6(new bdo(ayq), z);
    }

    public bdw j6(bea bea, boolean z) {
        if (this.rN.isEmpty()) {
            ayh azj;
            ayh j6;
            Object DW;
            ayy j62;
            ayy j63;
            ayi ayi = new ayi();
            ayi ayi2 = new ayi();
            this.a8.clear();
            for (beh beh : this.Mr) {
                ayi.j6(bdz.j6.j6(beh.j6()));
                ayi2.j6(beh.DW());
            }
            ayq j64 = bea.j6();
            if (bea != null) {
                OutputStream byteArrayOutputStream;
                if (z) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } else {
                    byteArrayOutputStream = null;
                }
                OutputStream j65 = beb.j6(beb.j6(this.U2, byteArrayOutputStream));
                try {
                    bea.j6(j65);
                    j65.close();
                    if (z) {
                        azj = new azj(byteArrayOutputStream.toByteArray());
                        for (bef bef : this.U2) {
                            j6 = bef.j6(j64);
                            ayi.j6(j6.Hw());
                            ayi2.j6(j6);
                            DW = bef.DW();
                            if (DW != null) {
                                this.a8.put(j6.Hw().FH().FH(), DW);
                            }
                        }
                        if (this.aM.size() == 0) {
                            j62 = beb.j6(this.aM);
                        } else {
                            j62 = null;
                        }
                        if (this.j3.size() == 0) {
                            j63 = beb.j6(this.j3);
                        } else {
                            j63 = null;
                        }
                        return new bdw(bea, new bbm(bbl.DW, new bbo(new ban(ayi), new bbm(j64, azj), j62, j63, new ban(ayi2))));
                    }
                } catch (Exception e) {
                    throw new bdr("data processing exception: " + e.getMessage(), e);
                }
            }
            azj = null;
            for (bef bef2 : this.U2) {
                j6 = bef2.j6(j64);
                ayi.j6(j6.Hw());
                ayi2.j6(j6);
                DW = bef2.DW();
                if (DW != null) {
                    this.a8.put(j6.Hw().FH().FH(), DW);
                }
            }
            if (this.aM.size() == 0) {
                j62 = null;
            } else {
                j62 = beb.j6(this.aM);
            }
            if (this.j3.size() == 0) {
                j63 = null;
            } else {
                j63 = beb.j6(this.j3);
            }
            return new bdw(bea, new bbm(bbl.DW, new bbo(new ban(ayi), new bbm(j64, azj), j62, j63, new ban(ayi2))));
        }
        throw new IllegalStateException("this method can only be used with SignerInfoGenerator");
    }
}
