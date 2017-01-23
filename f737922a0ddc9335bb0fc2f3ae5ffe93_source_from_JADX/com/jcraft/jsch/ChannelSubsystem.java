package com.jcraft.jsch;

public class ChannelSubsystem extends ChannelSession {
    String KD;
    boolean SI;
    boolean U2;
    boolean nw;

    public /* bridge */ /* synthetic */ void j6(boolean z) {
        super.j6(z);
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public ChannelSubsystem() {
        this.U2 = false;
        this.nw = false;
        this.SI = true;
        this.KD = "";
    }

    public void DW(boolean z) {
        this.nw = z;
    }

    public void FH() {
        Session J0 = J0();
        try {
            if (this.U2) {
                new RequestX11().j6(J0, this);
            }
            if (this.nw) {
                new RequestPtyReq().j6(J0, this);
            }
            new RequestSubsystem().j6(J0, this, this.KD, this.SI);
            if (this.tp.j6 != null) {
                this.EQ = new Thread(this);
                this.EQ.setName("Subsystem for " + J0.J0);
                if (J0.tp) {
                    this.EQ.setDaemon(J0.tp);
                }
                this.EQ.start();
            }
        } catch (Throwable e) {
            if (e instanceof JSchException) {
                throw ((JSchException) e);
            } else if (e instanceof Throwable) {
                throw new JSchException("ChannelSubsystem", e);
            } else {
                throw new JSchException("ChannelSubsystem");
            }
        }
    }

    void DW() {
        this.tp.j6(J0().Hw);
        this.tp.j6(J0().v5);
    }
}
