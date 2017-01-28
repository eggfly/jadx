import java.util.Hashtable;

public class bcn implements bcm {
    public static final ayq BT;
    public static final ayq DW;
    public static final ayq EQ;
    public static final ayq FH;
    public static final ayq Hw;
    public static final ayq J0;
    public static final ayq J8;
    public static final ayq KD;
    public static final ayq Mr;
    public static final ayq P8;
    public static final ayq QX;
    public static final ayq SI;
    public static final ayq U2;
    public static final ayq VH;
    public static final ayq Ws;
    public static final ayq XL;
    public static final ayq Zo;
    public static final ayq a8;
    public static final ayq aM;
    private static final Hashtable cb;
    public static final ayq cn;
    public static final ayq ei;
    public static final ayq er;
    public static final ayq gW;
    public static final ayq gn;
    public static final ayq j3;
    public static final bcm j6;
    public static final ayq lg;
    public static final ayq nw;
    public static final ayq rN;
    public static final ayq ro;
    private static final Hashtable sh;
    public static final ayq tp;
    public static final ayq u7;
    public static final ayq v5;
    public static final ayq vy;
    public static final ayq we;
    public static final ayq yS;

    static {
        j6 = new bcn();
        DW = new ayq("2.5.4.6");
        FH = new ayq("2.5.4.10");
        Hw = new ayq("2.5.4.11");
        v5 = new ayq("2.5.4.12");
        Zo = new ayq("2.5.4.3");
        VH = new ayq("2.5.4.5");
        gn = new ayq("2.5.4.9");
        u7 = VH;
        tp = new ayq("2.5.4.7");
        EQ = new ayq("2.5.4.8");
        we = new ayq("2.5.4.4");
        J0 = new ayq("2.5.4.42");
        J8 = new ayq("2.5.4.43");
        Ws = new ayq("2.5.4.44");
        QX = new ayq("2.5.4.45");
        XL = new ayq("2.5.4.15");
        aM = new ayq("2.5.4.17");
        j3 = new ayq("2.5.4.46");
        Mr = new ayq("2.5.4.65");
        U2 = new ayq("1.3.6.1.5.5.7.9.1");
        a8 = new ayq("1.3.6.1.5.5.7.9.2");
        lg = new ayq("1.3.6.1.5.5.7.9.3");
        rN = new ayq("1.3.6.1.5.5.7.9.4");
        er = new ayq("1.3.6.1.5.5.7.9.5");
        yS = new ayq("1.3.36.8.3.14");
        gW = new ayq("2.5.4.16");
        BT = new ayq("2.5.4.54");
        vy = bdg.VH;
        P8 = bdg.q_;
        ei = bce.I;
        nw = bce.ca;
        SI = bce.OW;
        KD = ei;
        ro = new ayq("0.9.2342.19200300.100.1.25");
        cn = new ayq("0.9.2342.19200300.100.1.1");
        sh = new Hashtable();
        cb = new Hashtable();
        sh.put(DW, "C");
        sh.put(FH, "O");
        sh.put(v5, "T");
        sh.put(Hw, "OU");
        sh.put(Zo, "CN");
        sh.put(tp, "L");
        sh.put(EQ, "ST");
        sh.put(VH, "SERIALNUMBER");
        sh.put(ei, "E");
        sh.put(ro, "DC");
        sh.put(cn, "UID");
        sh.put(gn, "STREET");
        sh.put(we, "SURNAME");
        sh.put(J0, "GIVENNAME");
        sh.put(J8, "INITIALS");
        sh.put(Ws, "GENERATION");
        sh.put(SI, "unstructuredAddress");
        sh.put(nw, "unstructuredName");
        sh.put(QX, "UniqueIdentifier");
        sh.put(j3, "DN");
        sh.put(Mr, "Pseudonym");
        sh.put(gW, "PostalAddress");
        sh.put(yS, "NameAtBirth");
        sh.put(rN, "CountryOfCitizenship");
        sh.put(er, "CountryOfResidence");
        sh.put(lg, "Gender");
        sh.put(a8, "PlaceOfBirth");
        sh.put(U2, "DateOfBirth");
        sh.put(aM, "PostalCode");
        sh.put(XL, "BusinessCategory");
        sh.put(vy, "TelephoneNumber");
        sh.put(P8, "Name");
        cb.put("c", DW);
        cb.put("o", FH);
        cb.put("t", v5);
        cb.put("ou", Hw);
        cb.put("cn", Zo);
        cb.put("l", tp);
        cb.put("st", EQ);
        cb.put("sn", VH);
        cb.put("serialnumber", VH);
        cb.put("street", gn);
        cb.put("emailaddress", KD);
        cb.put("dc", ro);
        cb.put("e", KD);
        cb.put("uid", cn);
        cb.put("surname", we);
        cb.put("givenname", J0);
        cb.put("initials", J8);
        cb.put("generation", Ws);
        cb.put("unstructuredaddress", SI);
        cb.put("unstructuredname", nw);
        cb.put("uniqueidentifier", QX);
        cb.put("dn", j3);
        cb.put("pseudonym", Mr);
        cb.put("postaladdress", gW);
        cb.put("nameofbirth", yS);
        cb.put("countryofcitizenship", rN);
        cb.put("countryofresidence", er);
        cb.put("gender", lg);
        cb.put("placeofbirth", a8);
        cb.put("dateofbirth", U2);
        cb.put("postalcode", aM);
        cb.put("businesscategory", XL);
        cb.put("telephonenumber", vy);
        cb.put("name", P8);
    }

    protected bcn() {
    }

    public boolean j6(bcl bcl, bcl bcl2) {
        bck[] FH = bcl.FH();
        bck[] FH2 = bcl2.FH();
        if (FH.length != FH2.length) {
            return false;
        }
        boolean z = (FH[0].Hw() == null || FH2[0].Hw() == null) ? false : !FH[0].Hw().FH().equals(FH2[0].Hw().FH());
        for (int i = 0; i != FH.length; i++) {
            if (!j6(z, FH[i], FH2)) {
                return false;
            }
        }
        return true;
    }

    private boolean j6(boolean z, bck bck, bck[] bckArr) {
        int length;
        if (z) {
            length = bckArr.length - 1;
            while (length >= 0) {
                if (bckArr[length] == null || !j6(bck, bckArr[length])) {
                    length--;
                } else {
                    bckArr[length] = null;
                    return true;
                }
            }
            return false;
        }
        length = 0;
        while (length != bckArr.length) {
            if (bckArr[length] == null || !j6(bck, bckArr[length])) {
                length++;
            } else {
                bckArr[length] = null;
                return true;
            }
        }
        return false;
    }

    protected boolean j6(bck bck, bck bck2) {
        if (bck.FH()) {
            if (!bck2.FH()) {
                return false;
            }
            bcj[] v5 = bck.v5();
            bcj[] v52 = bck2.v5();
            if (v5.length != v52.length) {
                return false;
            }
            for (int i = 0; i != v5.length; i++) {
                if (!j6(v5[i], v52[i])) {
                    return false;
                }
            }
            return true;
        } else if (bck2.FH()) {
            return false;
        } else {
            return j6(bck.Hw(), bck2.Hw());
        }
    }

    private boolean j6(bcj bcj, bcj bcj2) {
        if (bcj == bcj2) {
            return true;
        }
        if (bcj == null) {
            return false;
        }
        if (bcj2 == null) {
            return false;
        }
        if (!bcj.FH().equals(bcj2.FH())) {
            return false;
        }
        if (bco.j6(bco.j6(bcj.Hw())).equals(bco.j6(bco.j6(bcj2.Hw())))) {
            return true;
        }
        return false;
    }

    public int j6(bcl bcl) {
        bck[] FH = bcl.FH();
        int i = 0;
        for (int i2 = 0; i2 != FH.length; i2++) {
            if (FH[i2].FH()) {
                bcj[] v5 = FH[i2].v5();
                int i3 = i;
                for (i = 0; i != v5.length; i++) {
                    i3 = (i3 ^ v5[i].FH().hashCode()) ^ j6(v5[i].Hw());
                }
                i = i3;
            } else {
                i = (i ^ FH[i2].Hw().FH().hashCode()) ^ j6(FH[i2].Hw().Hw());
            }
        }
        return i;
    }

    private int j6(ayh ayh) {
        return bco.j6(bco.j6(ayh)).hashCode();
    }

    public String DW(bcl bcl) {
        StringBuffer stringBuffer = new StringBuffer();
        bck[] FH = bcl.FH();
        Object obj = 1;
        for (int i = 0; i < FH.length; i++) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuffer.append(',');
            }
            if (FH[i].FH()) {
                bcj[] v5 = FH[i].v5();
                Object obj2 = 1;
                for (int i2 = 0; i2 != v5.length; i2++) {
                    if (obj2 != null) {
                        obj2 = null;
                    } else {
                        stringBuffer.append('+');
                    }
                    bco.j6(stringBuffer, v5[i2], sh);
                }
            } else {
                bco.j6(stringBuffer, FH[i].Hw(), sh);
            }
        }
        return stringBuffer.toString();
    }
}
