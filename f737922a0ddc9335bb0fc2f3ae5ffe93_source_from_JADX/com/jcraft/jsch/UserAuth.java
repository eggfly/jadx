package com.jcraft.jsch;

public abstract class UserAuth {
    protected Packet DW;
    protected Buffer FH;
    protected String Hw;
    protected UserInfo j6;

    public boolean j6(Session session) {
        this.j6 = session.FH();
        this.DW = session.gn;
        this.FH = this.DW.DW();
        this.Hw = session.gn();
        return true;
    }
}
