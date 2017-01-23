package com.jcraft.jsch;

import java.util.Enumeration;
import java.util.Hashtable;

class ChannelSession extends Channel {
    private static byte[] U2;
    protected int BT;
    protected int P8;
    protected boolean a8;
    protected byte[] ei;
    protected boolean er;
    protected int gW;
    protected boolean lg;
    protected Hashtable rN;
    protected int vy;
    protected String yS;

    static {
        U2 = Util.DW("session");
    }

    ChannelSession() {
        this.a8 = false;
        this.lg = false;
        this.rN = null;
        this.er = false;
        this.yS = "vt100";
        this.gW = 80;
        this.BT = 24;
        this.vy = 640;
        this.P8 = 480;
        this.ei = null;
        this.Hw = U2;
        this.tp = new IO();
    }

    public void j6(boolean z) {
        this.a8 = z;
    }

    public void DW(boolean z) {
        this.er = z;
    }

    protected void aM() {
        Request requestPtyReq;
        Session J0 = J0();
        if (this.a8) {
            new RequestAgentForwarding().j6(J0, this);
        }
        if (this.lg) {
            new RequestX11().j6(J0, this);
        }
        if (this.er) {
            requestPtyReq = new RequestPtyReq();
            ((RequestPtyReq) requestPtyReq).j6(this.yS);
            ((RequestPtyReq) requestPtyReq).j6(this.gW, this.BT, this.vy, this.P8);
            if (this.ei != null) {
                ((RequestPtyReq) requestPtyReq).j6(this.ei);
            }
            requestPtyReq.j6(J0, this);
        }
        if (this.rN != null) {
            Enumeration keys = this.rN.keys();
            while (keys.hasMoreElements()) {
                Object nextElement = keys.nextElement();
                Object obj = this.rN.get(nextElement);
                requestPtyReq = new RequestEnv();
                ((RequestEnv) requestPtyReq).j6(j6(nextElement), j6(obj));
                requestPtyReq.j6(J0, this);
            }
        }
    }

    private byte[] j6(Object obj) {
        if (obj instanceof String) {
            return Util.DW((String) obj);
        }
        return (byte[]) obj;
    }

    public void run() {
        Buffer buffer = new Buffer(this.u7);
        Packet packet = new Packet(buffer);
        while (EQ() && this.EQ != null && this.tp != null && this.tp.j6 != null) {
            try {
                int read = this.tp.j6.read(buffer.DW, 14, (buffer.DW.length - 14) - 84);
                if (read != 0) {
                    if (read != -1) {
                        if (this.J8) {
                            break;
                        }
                        packet.j6();
                        buffer.j6((byte) 94);
                        buffer.j6(this.FH);
                        buffer.j6(read);
                        buffer.DW(read);
                        J0().j6(packet, (Channel) this, read);
                    } else {
                        gn();
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        Thread thread = this.EQ;
        if (thread != null) {
            synchronized (thread) {
                thread.notifyAll();
            }
        }
        this.EQ = null;
    }
}
