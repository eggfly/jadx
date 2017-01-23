package com.jcraft.jsch;

import java.io.InputStream;

public class ChannelExec extends ChannelSession {
    byte[] U2;

    public /* bridge */ /* synthetic */ void j6(boolean z) {
        super.j6(z);
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public ChannelExec() {
        this.U2 = new byte[0];
    }

    public void FH() {
        Session J0 = J0();
        try {
            aM();
            new RequestExec(this.U2).j6(J0, this);
            if (this.tp.j6 != null) {
                this.EQ = new Thread(this);
                this.EQ.setName("Exec thread " + J0.VH());
                if (J0.tp) {
                    this.EQ.setDaemon(J0.tp);
                }
                this.EQ.start();
            }
        } catch (Throwable e) {
            if (e instanceof JSchException) {
                throw ((JSchException) e);
            } else if (e instanceof Throwable) {
                throw new JSchException("ChannelExec", e);
            } else {
                throw new JSchException("ChannelExec");
            }
        }
    }

    public void DW(String str) {
        this.U2 = Util.DW(str);
    }

    void DW() {
        this.tp.j6(J0().Hw);
        this.tp.j6(J0().v5);
    }

    public InputStream XL() {
        return v5();
    }
}
