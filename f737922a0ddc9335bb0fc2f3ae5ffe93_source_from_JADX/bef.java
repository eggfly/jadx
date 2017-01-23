import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bef {
    private final bdq DW;
    private final bdq FH;
    private final bgq Hw;
    private final bdv VH;
    private final bgt Zo;
    private byte[] gn;
    private final bbp j6;
    private bdl u7;
    private final bgu v5;

    bef(bbp bbp, bgq bgq, bgv bgv, bdv bdv) {
        this(bbp, bgq, bgv, bdv, false);
    }

    bef(bbp bbp, bgq bgq, bgv bgv, bdv bdv, boolean z) {
        this.Zo = new bgr();
        this.gn = null;
        this.j6 = bbp;
        this.Hw = bgq;
        if (bgv != null) {
            this.v5 = bgv.j6(this.Zo.j6(bgq.j6()));
        } else {
            this.v5 = null;
        }
        if (z) {
            this.DW = null;
            this.FH = null;
        } else {
            this.DW = new bed();
            this.FH = null;
        }
        this.VH = bdv;
    }

    public bef(bef bef, bdq bdq, bdq bdq2) {
        this.Zo = new bgr();
        this.gn = null;
        this.j6 = bef.j6;
        this.Hw = bef.Hw;
        this.v5 = bef.v5;
        this.VH = bef.VH;
        this.DW = bdq;
        this.FH = bdq2;
    }

    bef(bbp bbp, bgq bgq, bgv bgv, bdv bdv, bdq bdq, bdq bdq2) {
        this.Zo = new bgr();
        this.gn = null;
        this.j6 = bbp;
        this.Hw = bgq;
        if (bgv != null) {
            this.v5 = bgv.j6(this.Zo.j6(bgq.j6()));
        } else {
            this.v5 = null;
        }
        this.DW = bdq;
        this.FH = bdq2;
        this.VH = bdv;
    }

    public OutputStream j6() {
        if (this.v5 == null) {
            return this.Hw.DW();
        }
        if (this.DW == null) {
            return new bhq(this.v5.DW(), this.Hw.DW());
        }
        return this.v5.DW();
    }

    public bbq j6(ayq ayq) {
        ayy ayy = null;
        try {
            bcp j6;
            ayy j62;
            if (this.DW != null) {
                j6 = this.v5.j6();
                this.gn = this.v5.FH();
                j62 = j6(this.DW.j6(Collections.unmodifiableMap(j6(ayq, this.v5.j6(), this.gn))));
                OutputStream DW = this.Hw.DW();
                DW.write(j62.j6("DER"));
                DW.close();
            } else if (this.v5 != null) {
                j6 = this.v5.j6();
                this.gn = this.v5.FH();
                j62 = null;
            } else {
                j6 = this.Zo.j6(this.Hw.j6());
                this.gn = null;
                j62 = null;
            }
            Object FH = this.Hw.FH();
            if (this.FH != null) {
                Map j63 = j6(ayq, j6, this.gn);
                j63.put("encryptedDigest", FH.clone());
                ayy = j6(this.FH.j6(Collections.unmodifiableMap(j63)));
            }
            return new bbq(this.j6, j6, j62, this.VH.j6(this.Hw.j6()), new bah(FH), ayy);
        } catch (Exception e) {
            throw new bdr("encoding error.", e);
        }
    }

    void j6(bdl bdl) {
        this.u7 = bdl;
    }

    private ayy j6(bbj bbj) {
        if (bbj != null) {
            return new ban(bbj.j6());
        }
        return null;
    }

    private Map j6(bag bag, bcp bcp, byte[] bArr) {
        Map hashMap = new HashMap();
        if (bag != null) {
            hashMap.put("contentType", bag);
        }
        hashMap.put("digestAlgID", bcp);
        hashMap.put("digest", bArr.clone());
        return hashMap;
    }

    public byte[] DW() {
        if (this.gn != null) {
            return (byte[]) this.gn.clone();
        }
        return null;
    }
}
