package com.jcraft.jsch;

class RequestWindowChange extends Request {
    int DW;
    int FH;
    int Hw;
    int j6;

    RequestWindowChange() {
        this.j6 = 80;
        this.DW = 24;
        this.FH = 640;
        this.Hw = 480;
    }

    public void j6(Session session, Channel channel) {
        super.j6(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 98);
        buffer.j6(channel.j6());
        buffer.DW(Util.DW("window-change"));
        buffer.j6((byte) (j6() ? 1 : 0));
        buffer.j6(this.j6);
        buffer.j6(this.DW);
        buffer.j6(this.FH);
        buffer.j6(this.Hw);
        j6(packet);
    }
}
