package com.jcraft.jsch;

public class ChannelShell extends ChannelSession {
    public /* bridge */ /* synthetic */ void DW(boolean z) {
        super.DW(z);
    }

    public /* bridge */ /* synthetic */ void j6(boolean z) {
        super.j6(z);
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    ChannelShell() {
        this.er = true;
    }

    public void FH() {
        Session J0 = J0();
        try {
            aM();
            new RequestShell().j6(J0, this);
            if (this.tp.j6 != null) {
                this.EQ = new Thread(this);
                this.EQ.setName("Shell for " + J0.J0);
                if (J0.tp) {
                    this.EQ.setDaemon(J0.tp);
                }
                this.EQ.start();
            }
        } catch (Throwable e) {
            if (e instanceof JSchException) {
                throw ((JSchException) e);
            } else if (e instanceof Throwable) {
                throw new JSchException("ChannelShell", e);
            } else {
                throw new JSchException("ChannelShell");
            }
        }
    }

    void DW() {
        this.tp.j6(J0().Hw);
        this.tp.j6(J0().v5);
    }
}
