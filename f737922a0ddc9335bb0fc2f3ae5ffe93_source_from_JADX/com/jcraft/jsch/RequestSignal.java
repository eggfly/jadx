package com.jcraft.jsch;

class RequestSignal extends Request {
    private String j6;

    RequestSignal() {
        this.j6 = "KILL";
    }

    public void j6(Session session, Channel channel) {
        super.j6(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 98);
        buffer.j6(channel.j6());
        buffer.DW(Util.DW("signal"));
        buffer.j6((byte) (j6() ? 1 : 0));
        buffer.DW(Util.DW(this.j6));
        j6(packet);
    }
}
