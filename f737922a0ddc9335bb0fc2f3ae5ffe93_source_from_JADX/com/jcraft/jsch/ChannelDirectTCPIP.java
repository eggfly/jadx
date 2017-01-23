package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;

public class ChannelDirectTCPIP extends Channel {
    private static final byte[] er;
    String U2;
    int a8;
    String lg;
    int rN;

    static {
        er = Util.DW("direct-tcpip");
    }

    ChannelDirectTCPIP() {
        this.lg = "127.0.0.1";
        this.rN = 0;
        this.Hw = er;
        FH(131072);
        Hw(131072);
        v5(16384);
    }

    void DW() {
        this.tp = new IO();
    }

    public void DW(int i) {
        this.j3 = i;
        try {
            Session J0 = J0();
            if (!J0.Hw()) {
                throw new JSchException("session is down");
            } else if (this.tp.j6 != null) {
                this.EQ = new Thread(this);
                this.EQ.setName("DirectTCPIP thread " + J0.VH());
                if (J0.tp) {
                    this.EQ.setDaemon(J0.tp);
                }
                this.EQ.start();
            } else {
                QX();
            }
        } catch (Exception e) {
            this.tp.FH();
            this.tp = null;
            Channel.j6((Channel) this);
            if (e instanceof JSchException) {
                throw ((JSchException) e);
            }
        }
    }

    public void run() {
        try {
            QX();
            Buffer buffer = new Buffer(this.u7);
            Packet packet = new Packet(buffer);
            Session J0 = J0();
            while (EQ() && this.EQ != null && this.tp != null && this.tp.j6 != null) {
                int read = this.tp.j6.read(buffer.DW, 14, (buffer.DW.length - 14) - 84);
                if (read <= 0) {
                    gn();
                    break;
                }
                packet.j6();
                buffer.j6((byte) 94);
                buffer.j6(this.FH);
                buffer.j6(read);
                buffer.DW(read);
                synchronized (this) {
                    if (this.J8) {
                        break;
                    } else {
                        J0.j6(packet, (Channel) this, read);
                    }
                }
            }
            gn();
            tp();
        } catch (Exception e) {
            if (!this.Ws) {
                this.Ws = true;
            }
            tp();
        }
    }

    public void j6(InputStream inputStream) {
        this.tp.j6(inputStream);
    }

    public void j6(OutputStream outputStream) {
        this.tp.j6(outputStream);
    }

    public void DW(String str) {
        this.U2 = str;
    }

    public void u7(int i) {
        this.a8 = i;
    }

    public void FH(String str) {
        this.lg = str;
    }

    public void tp(int i) {
        this.rN = i;
    }

    protected Packet Ws() {
        Buffer buffer = new Buffer(((this.U2.length() + 50) + this.lg.length()) + 84);
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 90);
        buffer.DW(this.Hw);
        buffer.j6(this.DW);
        buffer.j6(this.Zo);
        buffer.j6(this.VH);
        buffer.DW(Util.DW(this.U2));
        buffer.j6(this.a8);
        buffer.DW(Util.DW(this.lg));
        buffer.j6(this.rN);
        return packet;
    }
}
