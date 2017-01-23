package com.jcraft.jsch;

import com.aide.uidesigner.ProxyTextView;

public class DHGEX256 extends KeyExchange {
    static int DW;
    static int FH;
    static int j6;
    private byte[] BT;
    DH Hw;
    byte[] VH;
    byte[] Zo;
    private int a8;
    private Packet er;
    private byte[] gW;
    byte[] gn;
    private int lg;
    private Buffer rN;
    byte[] v5;
    private byte[] yS;

    public DHGEX256() {
        this.a8 = 0;
    }

    static {
        j6 = 1024;
        DW = 1024;
        FH = 1024;
    }

    public void j6(Session session, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.XL = session;
        this.v5 = bArr;
        this.Zo = bArr2;
        this.VH = bArr3;
        this.gn = bArr4;
        try {
            this.aM = (HASH) Class.forName(session.v5("sha-256")).newInstance();
            this.aM.j6();
        } catch (Exception e) {
            System.err.println(e);
        }
        this.rN = new Buffer();
        this.er = new Packet(this.rN);
        try {
            this.Hw = (DH) Class.forName(session.v5("dh")).newInstance();
            this.Hw.j6();
            this.er.j6();
            this.rN.j6((byte) 34);
            this.rN.j6(j6);
            this.rN.j6(DW);
            this.rN.j6(FH);
            session.DW(this.er);
            if (JSch.v5().j6(1)) {
                JSch.v5().j6(1, "SSH_MSG_KEX_DH_GEX_REQUEST(" + j6 + "<" + DW + "<" + FH + ") sent");
                JSch.v5().j6(1, "expecting SSH_MSG_KEX_DH_GEX_GROUP");
            }
            this.lg = 31;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public boolean j6(Buffer buffer) {
        Object obj;
        Object obj2;
        SignatureRSA signatureRSA;
        Object e;
        boolean DW;
        Exception exception;
        SignatureDSA signatureDSA;
        int VH;
        switch (this.lg) {
            case 31:
                buffer.Hw();
                buffer.VH();
                VH = buffer.VH();
                if (VH != 31) {
                    System.err.println("type: must be SSH_MSG_KEX_DH_GEX_GROUP " + VH);
                    return false;
                }
                this.yS = buffer.gn();
                this.gW = buffer.gn();
                this.Hw.j6(this.yS);
                this.Hw.DW(this.gW);
                this.BT = this.Hw.DW();
                this.er.j6();
                this.rN.j6((byte) 32);
                this.rN.FH(this.BT);
                this.XL.DW(this.er);
                if (JSch.v5().j6(1)) {
                    JSch.v5().j6(1, "SSH_MSG_KEX_DH_GEX_INIT sent");
                    JSch.v5().j6(1, "expecting SSH_MSG_KEX_DH_GEX_REPLY");
                }
                this.lg = 33;
                return true;
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                buffer.Hw();
                buffer.VH();
                VH = buffer.VH();
                if (VH != 33) {
                    System.err.println("type: must be SSH_MSG_KEX_DH_GEX_REPLY " + VH);
                    return false;
                }
                this.U2 = buffer.tp();
                byte[] gn = buffer.gn();
                byte[] tp = buffer.tp();
                this.Hw.FH(gn);
                this.j3 = j6(this.Hw.FH());
                this.rN.EQ();
                this.rN.DW(this.Zo);
                this.rN.DW(this.v5);
                this.rN.DW(this.gn);
                this.rN.DW(this.VH);
                this.rN.DW(this.U2);
                this.rN.j6(j6);
                this.rN.j6(DW);
                this.rN.j6(FH);
                this.rN.FH(this.yS);
                this.rN.FH(this.gW);
                this.rN.FH(this.BT);
                this.rN.FH(gn);
                this.rN.FH(this.j3);
                gn = new byte[this.rN.j6()];
                this.rN.Hw(gn);
                this.aM.j6(gn, 0, gn.length);
                this.Mr = this.aM.FH();
                VH = ((((this.U2[0] << 24) & -16777216) | ((this.U2[1] << 16) & 16711680)) | ((this.U2[2] << 8) & 65280)) | (this.U2[3] & 255);
                String FH = Util.FH(this.U2, 4, VH);
                int i = VH + 4;
                int i2;
                int i3;
                int i4;
                if (FH.equals("ssh-rsa")) {
                    this.a8 = 0;
                    i2 = i + 1;
                    i3 = i2 + 1;
                    i = i3 + 1;
                    i3 = i + 1;
                    VH = ((((this.U2[i] << 24) & -16777216) | ((this.U2[i2] << 16) & 16711680)) | ((this.U2[i3] << 8) & 65280)) | (this.U2[i] & 255);
                    obj = new byte[VH];
                    System.arraycopy(this.U2, i3, obj, 0, VH);
                    VH += i3;
                    i3 = VH + 1;
                    i4 = i3 + 1;
                    i3 = i4 + 1;
                    i4 = i3 + 1;
                    VH = ((((this.U2[VH] << 24) & -16777216) | ((this.U2[i3] << 16) & 16711680)) | ((this.U2[i4] << 8) & 65280)) | (this.U2[i3] & 255);
                    obj2 = new byte[VH];
                    System.arraycopy(this.U2, i4, obj2, 0, VH);
                    VH += i4;
                    try {
                        signatureRSA = (SignatureRSA) Class.forName(this.XL.v5("signature.rsa")).newInstance();
                        try {
                            signatureRSA.j6();
                        } catch (Exception e2) {
                            e = e2;
                            System.err.println(e);
                            signatureRSA.j6(obj, obj2);
                            signatureRSA.j6(this.Mr);
                            DW = signatureRSA.DW(tp);
                            if (JSch.v5().j6(1)) {
                                JSch.v5().j6(1, "ssh_rsa_verify: signature " + DW);
                            }
                            this.lg = 0;
                            return DW;
                        }
                    } catch (Exception e3) {
                        exception = e3;
                        signatureRSA = null;
                        e = exception;
                        System.err.println(e);
                        signatureRSA.j6(obj, obj2);
                        signatureRSA.j6(this.Mr);
                        DW = signatureRSA.DW(tp);
                        if (JSch.v5().j6(1)) {
                            JSch.v5().j6(1, "ssh_rsa_verify: signature " + DW);
                        }
                        this.lg = 0;
                        return DW;
                    }
                    signatureRSA.j6(obj, obj2);
                    signatureRSA.j6(this.Mr);
                    DW = signatureRSA.DW(tp);
                    if (JSch.v5().j6(1)) {
                        JSch.v5().j6(1, "ssh_rsa_verify: signature " + DW);
                    }
                } else if (FH.equals("ssh-dss")) {
                    gn = (byte[]) null;
                    this.a8 = 1;
                    i2 = i + 1;
                    i3 = i2 + 1;
                    i = i3 + 1;
                    i3 = i + 1;
                    VH = ((((this.U2[i] << 24) & -16777216) | ((this.U2[i2] << 16) & 16711680)) | ((this.U2[i3] << 8) & 65280)) | (this.U2[i] & 255);
                    e = new byte[VH];
                    System.arraycopy(this.U2, i3, e, 0, VH);
                    VH += i3;
                    this.yS = e;
                    i = VH + 1;
                    i3 = i + 1;
                    i = i3 + 1;
                    i3 = i + 1;
                    VH = ((((this.U2[VH] << 24) & -16777216) | ((this.U2[i] << 16) & 16711680)) | ((this.U2[i3] << 8) & 65280)) | (this.U2[i] & 255);
                    obj = new byte[VH];
                    System.arraycopy(this.U2, i3, obj, 0, VH);
                    VH += i3;
                    i3 = VH + 1;
                    i4 = i3 + 1;
                    i3 = i4 + 1;
                    i4 = i3 + 1;
                    VH = ((((this.U2[VH] << 24) & -16777216) | ((this.U2[i3] << 16) & 16711680)) | ((this.U2[i4] << 8) & 65280)) | (this.U2[i3] & 255);
                    e = new byte[VH];
                    System.arraycopy(this.U2, i4, e, 0, VH);
                    VH += i4;
                    this.gW = e;
                    i3 = VH + 1;
                    i4 = i3 + 1;
                    i3 = i4 + 1;
                    i4 = i3 + 1;
                    VH = ((((this.U2[VH] << 24) & -16777216) | ((this.U2[i3] << 16) & 16711680)) | ((this.U2[i4] << 8) & 65280)) | (this.U2[i3] & 255);
                    obj2 = new byte[VH];
                    System.arraycopy(this.U2, i4, obj2, 0, VH);
                    VH += i4;
                    try {
                        signatureDSA = (SignatureDSA) Class.forName(this.XL.v5("signature.dss")).newInstance();
                        try {
                            signatureDSA.j6();
                        } catch (Exception e4) {
                            e = e4;
                            System.err.println(e);
                            signatureDSA.j6(obj2, this.yS, obj, this.gW);
                            signatureDSA.j6(this.Mr);
                            DW = signatureDSA.DW(tp);
                            if (JSch.v5().j6(1)) {
                                JSch.v5().j6(1, "ssh_dss_verify: signature " + DW);
                            }
                            this.lg = 0;
                            return DW;
                        }
                    } catch (Exception e32) {
                        exception = e32;
                        signatureDSA = null;
                        e = exception;
                        System.err.println(e);
                        signatureDSA.j6(obj2, this.yS, obj, this.gW);
                        signatureDSA.j6(this.Mr);
                        DW = signatureDSA.DW(tp);
                        if (JSch.v5().j6(1)) {
                            JSch.v5().j6(1, "ssh_dss_verify: signature " + DW);
                        }
                        this.lg = 0;
                        return DW;
                    }
                    signatureDSA.j6(obj2, this.yS, obj, this.gW);
                    signatureDSA.j6(this.Mr);
                    DW = signatureDSA.DW(tp);
                    if (JSch.v5().j6(1)) {
                        JSch.v5().j6(1, "ssh_dss_verify: signature " + DW);
                    }
                } else {
                    System.err.println("unknown alg");
                    DW = false;
                }
                this.lg = 0;
                return DW;
            default:
                return false;
        }
    }

    public String j6() {
        if (this.a8 == 1) {
            return "DSA";
        }
        return "RSA";
    }

    public int DW() {
        return this.lg;
    }
}
