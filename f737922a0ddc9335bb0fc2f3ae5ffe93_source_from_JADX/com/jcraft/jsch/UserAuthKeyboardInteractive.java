package com.jcraft.jsch;

class UserAuthKeyboardInteractive extends UserAuth {
    UserAuthKeyboardInteractive() {
    }

    public boolean j6(Session session) {
        super.j6(session);
        if (this.j6 != null && !(this.j6 instanceof UIKeyboardInteractive)) {
            return false;
        }
        String str = this.Hw + "@" + session.J0;
        if (session.Ws != 22) {
            str = new StringBuilder(String.valueOf(str)).append(":").append(session.Ws).toString();
        }
        byte[] bArr = session.XL;
        byte[] bArr2 = (byte[]) null;
        byte[] DW = Util.DW(this.Hw);
        Object obj = null;
        byte[] bArr3 = bArr;
        while (session.we < session.EQ) {
            this.DW.j6();
            this.FH.j6((byte) 50);
            this.FH.DW(DW);
            this.FH.DW(Util.DW("ssh-connection"));
            this.FH.DW(Util.DW("keyboard-interactive"));
            this.FH.DW(Util.j6);
            this.FH.DW(Util.j6);
            session.DW(this.DW);
            Object obj2 = obj;
            byte[] bArr4 = bArr3;
            obj = 1;
            while (true) {
                this.FH = session.j6(this.FH);
                int J8 = this.FH.J8() & 255;
                if (J8 == 52) {
                    return true;
                }
                String DW2;
                if (J8 == 53) {
                    this.FH.Hw();
                    this.FH.VH();
                    this.FH.VH();
                    bArr3 = this.FH.tp();
                    this.FH.tp();
                    DW2 = Util.DW(bArr3);
                    if (this.j6 != null) {
                        this.j6.Hw(DW2);
                    }
                } else if (J8 == 51) {
                    break;
                } else if (J8 != 60) {
                    return false;
                } else {
                    int i;
                    this.FH.Hw();
                    this.FH.VH();
                    this.FH.VH();
                    DW2 = Util.DW(this.FH.tp());
                    String DW3 = Util.DW(this.FH.tp());
                    Util.DW(this.FH.tp());
                    int Hw = this.FH.Hw();
                    String[] strArr = new String[Hw];
                    boolean[] zArr = new boolean[Hw];
                    for (int i2 = 0; i2 < Hw; i2++) {
                        strArr[i2] = Util.DW(this.FH.tp());
                        zArr[i2] = this.FH.VH() != 0;
                    }
                    byte[][] bArr5 = (byte[][]) null;
                    if (bArr4 != null && strArr.length == 1 && !zArr[0] && strArr[0].toLowerCase().indexOf("password:") >= 0) {
                        bArr5 = new byte[][]{bArr4};
                        bArr4 = (byte[]) null;
                    } else if ((Hw > 0 || DW2.length() > 0 || DW3.length() > 0) && this.j6 != null) {
                        String[] j6 = ((UIKeyboardInteractive) this.j6).j6(str, DW2, DW3, strArr, zArr);
                        if (j6 != null) {
                            bArr5 = new byte[j6.length][];
                            for (i = 0; i < j6.length; i++) {
                                bArr5[i] = Util.DW(j6[i]);
                            }
                        }
                    }
                    this.DW.j6();
                    this.FH.j6((byte) 61);
                    if (Hw <= 0 || (bArr5 != null && Hw == bArr5.length)) {
                        this.FH.j6(Hw);
                        for (i = 0; i < Hw; i++) {
                            this.FH.DW(bArr5[i]);
                        }
                    } else {
                        if (bArr5 == null) {
                            this.FH.j6(Hw);
                            for (i = 0; i < Hw; i++) {
                                this.FH.DW(Util.j6);
                            }
                        } else {
                            this.FH.j6(0);
                        }
                        if (bArr5 == null) {
                            obj2 = 1;
                        }
                    }
                    session.DW(this.DW);
                    obj = null;
                }
            }
            this.FH.Hw();
            this.FH.VH();
            this.FH.VH();
            bArr3 = this.FH.tp();
            if (this.FH.VH() != 0) {
                throw new JSchPartialAuthException(Util.DW(bArr3));
            } else if (obj != null) {
                return false;
            } else {
                session.we++;
                if (obj2 != null) {
                    throw new JSchAuthCancelException("keyboard-interactive");
                }
                obj = obj2;
                bArr3 = bArr4;
            }
        }
        return false;
    }
}
