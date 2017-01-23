package com.jcraft.jsch;

class RequestExec extends Request {
    private byte[] j6;

    RequestExec(byte[] bArr) {
        this.j6 = new byte[0];
        this.j6 = bArr;
    }

    public void j6(Session session, Channel channel) {
        super.j6(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 98);
        buffer.j6(channel.j6());
        buffer.DW(Util.DW("exec"));
        buffer.j6((byte) (j6() ? 1 : 0));
        buffer.v5(this.j6.length + 4);
        buffer.DW(this.j6);
        j6(packet);
    }
}
