package com.jcraft.jsch;

class RequestPtyReq extends Request {
    private int DW;
    private int FH;
    private int Hw;
    private byte[] Zo;
    private String j6;
    private int v5;

    RequestPtyReq() {
        this.j6 = "vt100";
        this.DW = 80;
        this.FH = 24;
        this.Hw = 640;
        this.v5 = 480;
        this.Zo = Util.j6;
    }

    void j6(String str) {
        this.j6 = str;
    }

    void j6(byte[] bArr) {
        this.Zo = bArr;
    }

    void j6(int i, int i2, int i3, int i4) {
        this.DW = i;
        this.FH = i2;
        this.Hw = i3;
        this.v5 = i4;
    }

    public void j6(Session session, Channel channel) {
        super.j6(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 98);
        buffer.j6(channel.j6());
        buffer.DW(Util.DW("pty-req"));
        buffer.j6((byte) (j6() ? 1 : 0));
        buffer.DW(Util.DW(this.j6));
        buffer.j6(this.DW);
        buffer.j6(this.FH);
        buffer.j6(this.Hw);
        buffer.j6(this.v5);
        buffer.DW(this.Zo);
        j6(packet);
    }
}
