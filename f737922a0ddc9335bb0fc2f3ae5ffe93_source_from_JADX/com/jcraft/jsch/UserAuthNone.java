package com.jcraft.jsch;

class UserAuthNone extends UserAuth {
    private String v5;

    UserAuthNone() {
        this.v5 = null;
    }

    public boolean j6(Session session) {
        super.j6(session);
        this.DW.j6();
        this.FH.j6((byte) 5);
        this.FH.DW(Util.DW("ssh-userauth"));
        session.DW(this.DW);
        if (JSch.v5().j6(1)) {
            JSch.v5().j6(1, "SSH_MSG_SERVICE_REQUEST sent");
        }
        this.FH = session.j6(this.FH);
        if (this.FH.J8() == 6) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (JSch.v5().j6(1)) {
            JSch.v5().j6(1, "SSH_MSG_SERVICE_ACCEPT received");
        }
        if (i == 0) {
            return false;
        }
        byte[] bArr = (byte[]) null;
        bArr = Util.DW(this.Hw);
        this.DW.j6();
        this.FH.j6((byte) 50);
        this.FH.DW(bArr);
        this.FH.DW(Util.DW("ssh-connection"));
        this.FH.DW(Util.DW("none"));
        session.DW(this.DW);
        while (true) {
            this.FH = session.j6(this.FH);
            i = this.FH.J8() & 255;
            if (i != 52) {
                if (i != 53) {
                    break;
                }
                this.FH.Hw();
                this.FH.VH();
                this.FH.VH();
                bArr = this.FH.tp();
                this.FH.tp();
                String DW = Util.DW(bArr);
                if (this.j6 != null) {
                    try {
                        this.j6.Hw(DW);
                    } catch (RuntimeException e) {
                    }
                }
            } else {
                return true;
            }
        }
        if (i == 51) {
            this.FH.Hw();
            this.FH.VH();
            this.FH.VH();
            bArr = this.FH.tp();
            this.FH.VH();
            this.v5 = Util.DW(bArr);
            return false;
        }
        throw new JSchException("USERAUTH fail (" + i + ")");
    }

    String j6() {
        return this.v5;
    }
}
