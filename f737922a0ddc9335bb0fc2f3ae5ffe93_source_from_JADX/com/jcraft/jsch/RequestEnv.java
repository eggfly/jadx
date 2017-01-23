package com.jcraft.jsch;

class RequestEnv extends Request {
    byte[] DW;
    byte[] j6;

    RequestEnv() {
        this.j6 = new byte[0];
        this.DW = new byte[0];
    }

    void j6(byte[] bArr, byte[] bArr2) {
        this.j6 = bArr;
        this.DW = bArr2;
    }

    public void j6(Session session, Channel channel) {
        super.j6(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 98);
        buffer.j6(channel.j6());
        buffer.DW(Util.DW("env"));
        buffer.j6((byte) (j6() ? 1 : 0));
        buffer.DW(this.j6);
        buffer.DW(this.DW);
        j6(packet);
    }
}
