package com.jcraft.jsch;

class RequestX11 extends Request {
    RequestX11() {
    }

    public void j6(Session session, Channel channel) {
        super.j6(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 98);
        buffer.j6(channel.j6());
        buffer.DW(Util.DW("x11-req"));
        buffer.j6((byte) (j6() ? 1 : 0));
        buffer.j6((byte) 0);
        buffer.DW(Util.DW("MIT-MAGIC-COOKIE-1"));
        buffer.DW(ChannelX11.FH(session));
        buffer.j6(0);
        j6(packet);
        session.DW = true;
    }
}
