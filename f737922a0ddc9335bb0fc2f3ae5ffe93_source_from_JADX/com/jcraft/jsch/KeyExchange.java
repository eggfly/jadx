package com.jcraft.jsch;

public abstract class KeyExchange {
    static String EQ;
    static String J0;
    static String J8;
    static String QX;
    static String Ws;
    static String tp;
    static String u7;
    static String we;
    protected byte[] Mr;
    protected byte[] U2;
    protected Session XL;
    protected HASH aM;
    protected byte[] j3;

    public abstract int DW();

    public abstract String j6();

    public abstract void j6(Session session, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public abstract boolean j6(Buffer buffer);

    public KeyExchange() {
        this.XL = null;
        this.aM = null;
        this.j3 = null;
        this.Mr = null;
        this.U2 = null;
    }

    static {
        u7 = "diffie-hellman-group1-sha1";
        tp = "ssh-rsa,ssh-dss";
        EQ = "blowfish-cbc";
        we = "blowfish-cbc";
        J0 = "hmac-md5";
        J8 = "hmac-md5";
        Ws = "";
        QX = "";
    }

    protected static String[] j6(byte[] bArr, byte[] bArr2) {
        int i;
        String[] strArr = new String[10];
        Buffer buffer = new Buffer(bArr);
        buffer.FH(17);
        Buffer buffer2 = new Buffer(bArr2);
        buffer2.FH(17);
        if (JSch.v5().j6(1)) {
            for (i = 0; i < 10; i++) {
                JSch.v5().j6(1, "kex: server: " + Util.DW(buffer.tp()));
            }
            for (i = 0; i < 10; i++) {
                JSch.v5().j6(1, "kex: client: " + Util.DW(buffer2.tp()));
            }
            buffer.FH(17);
            buffer2.FH(17);
        }
        for (int i2 = 0; i2 < 10; i2++) {
            byte[] tp = buffer.tp();
            byte[] tp2 = buffer2.tp();
            int i3 = 0;
            i = 0;
            while (i3 < tp2.length) {
                while (i3 < tp2.length && tp2[i3] != 44) {
                    i3++;
                }
                if (i == i3) {
                    return null;
                }
                String FH = Util.FH(tp2, i, i3 - i);
                int i4 = 0;
                i = 0;
                while (i4 < tp.length) {
                    while (i4 < tp.length && tp[i4] != 44) {
                        i4++;
                    }
                    if (i == i4) {
                        return null;
                    }
                    if (FH.equals(Util.FH(tp, i, i4 - i))) {
                        strArr[i2] = FH;
                        break;
                    }
                    i = i4 + 1;
                    i4 = i;
                }
                i = i3 + 1;
                i3 = i;
            }
            if (i3 == 0) {
                strArr[i2] = "";
            } else if (strArr[i2] == null) {
                return null;
            }
        }
        if (JSch.v5().j6(1)) {
            JSch.v5().j6(1, "kex: server->client " + strArr[3] + " " + strArr[5] + " " + strArr[7]);
            JSch.v5().j6(1, "kex: client->server " + strArr[2] + " " + strArr[4] + " " + strArr[6]);
        }
        return strArr;
    }

    public String FH() {
        HASH hash;
        try {
            hash = (HASH) Class.forName(this.XL.v5("md5")).newInstance();
        } catch (Exception e) {
            System.err.println("getFingerPrint: " + e);
            hash = null;
        }
        return Util.j6(hash, VH());
    }

    byte[] Hw() {
        return this.j3;
    }

    byte[] v5() {
        return this.Mr;
    }

    HASH Zo() {
        return this.aM;
    }

    byte[] VH() {
        return this.U2;
    }

    protected byte[] j6(byte[] bArr) {
        if (bArr.length <= 1 || bArr[0] != null || (bArr[1] & 128) != 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[(bArr.length - 1)];
        System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
        return j6(bArr2);
    }
}
