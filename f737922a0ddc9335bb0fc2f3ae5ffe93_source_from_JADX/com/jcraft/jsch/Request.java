package com.jcraft.jsch;

abstract class Request {
    private Session DW;
    private Channel FH;
    private boolean j6;

    Request() {
        this.j6 = false;
        this.DW = null;
        this.FH = null;
    }

    void j6(Session session, Channel channel) {
        this.DW = session;
        this.FH = channel;
        if (channel.j3 > 0) {
            j6(true);
        }
    }

    boolean j6() {
        return this.j6;
    }

    void j6(boolean z) {
        this.j6 = z;
    }

    void j6(Packet packet) {
        if (this.j6) {
            this.FH.aM = -1;
        }
        this.DW.DW(packet);
        if (this.j6) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = (long) this.FH.j3;
            while (this.FH.EQ() && this.FH.aM == -1) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
                if (j > 0 && System.currentTimeMillis() - currentTimeMillis > j) {
                    this.FH.aM = 0;
                    throw new JSchException("channel request: timeout");
                }
            }
            if (this.FH.aM == 0) {
                throw new JSchException("failed to send channel request");
            }
        }
    }
}
