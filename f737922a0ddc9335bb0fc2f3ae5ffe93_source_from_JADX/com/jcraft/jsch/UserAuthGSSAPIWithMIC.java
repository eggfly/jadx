package com.jcraft.jsch;

public class UserAuthGSSAPIWithMIC extends UserAuth {
    private static final String[] Zo;
    private static final byte[][] v5;

    static {
        v5 = new byte[][]{new byte[]{(byte) 6, (byte) 9, (byte) 42, (byte) -122, (byte) 72, (byte) -122, (byte) -9, (byte) 18, (byte) 1, (byte) 2, (byte) 2}};
        Zo = new String[]{"gssapi-with-mic.krb5"};
    }

    public boolean j6(Session session) {
        int J8;
        String DW;
        super.j6(session);
        byte[] DW2 = Util.DW(this.Hw);
        this.DW.j6();
        this.FH.j6((byte) 50);
        this.FH.DW(DW2);
        this.FH.DW(Util.DW("ssh-connection"));
        this.FH.DW(Util.DW("gssapi-with-mic"));
        this.FH.j6(v5.length);
        for (byte[] DW3 : v5) {
            this.FH.DW(DW3);
        }
        session.DW(this.DW);
        while (true) {
            this.FH = session.j6(this.FH);
            J8 = this.FH.J8() & 255;
            if (J8 == 51) {
                return false;
            }
            if (J8 == 60) {
                break;
            } else if (J8 != 53) {
                return false;
            } else {
                this.FH.Hw();
                this.FH.VH();
                this.FH.VH();
                byte[] tp = this.FH.tp();
                this.FH.tp();
                DW = Util.DW(tp);
                if (this.j6 != null) {
                    this.j6.Hw(DW);
                }
            }
        }
        this.FH.Hw();
        this.FH.VH();
        this.FH.VH();
        byte[] DW32 = this.FH.tp();
        for (J8 = 0; J8 < v5.length; J8++) {
            if (Util.DW(DW32, v5[J8])) {
                DW = Zo[J8];
                break;
            }
        }
        DW = null;
        if (DW == null) {
            return false;
        }
        try {
            GSSContext gSSContext = (GSSContext) Class.forName(session.v5(DW)).newInstance();
            try {
                gSSContext.j6(this.Hw, session.J0);
                byte[] bArr = new byte[0];
                while (!gSSContext.j6()) {
                    try {
                        bArr = gSSContext.j6(bArr, 0, bArr.length);
                        if (bArr != null) {
                            this.DW.j6();
                            this.FH.j6((byte) 61);
                            this.FH.DW(bArr);
                            session.DW(this.DW);
                        }
                        if (!gSSContext.j6()) {
                            this.FH = session.j6(this.FH);
                            int J82 = this.FH.J8() & 255;
                            if (J82 == 64) {
                                this.FH = session.j6(this.FH);
                                J82 = this.FH.J8() & 255;
                            } else if (J82 == 65) {
                                this.FH = session.j6(this.FH);
                                J82 = this.FH.J8() & 255;
                            }
                            if (J82 == 51) {
                                return false;
                            }
                            this.FH.Hw();
                            this.FH.VH();
                            this.FH.VH();
                            bArr = this.FH.tp();
                        }
                    } catch (JSchException e) {
                        return false;
                    }
                }
                Buffer buffer = new Buffer();
                buffer.DW(session.j6());
                buffer.j6((byte) 50);
                buffer.DW(DW2);
                buffer.DW(Util.DW("ssh-connection"));
                buffer.DW(Util.DW("gssapi-with-mic"));
                bArr = gSSContext.DW(buffer.DW, 0, buffer.j6());
                if (bArr == null) {
                    return false;
                }
                this.DW.j6();
                this.FH.j6((byte) 66);
                this.FH.DW(bArr);
                session.DW(this.DW);
                gSSContext.DW();
                this.FH = session.j6(this.FH);
                J8 = this.FH.J8() & 255;
                if (J8 == 52) {
                    return true;
                }
                if (J8 != 51) {
                    return false;
                }
                this.FH.Hw();
                this.FH.VH();
                this.FH.VH();
                tp = this.FH.tp();
                if (this.FH.VH() == 0) {
                    return false;
                }
                throw new JSchPartialAuthException(Util.DW(tp));
            } catch (JSchException e2) {
                return false;
            }
        } catch (Exception e3) {
            return false;
        }
    }
}
