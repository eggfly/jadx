package com.jcraft.jsch;

public class RequestSubsystem extends Request {
    private String j6;

    public RequestSubsystem() {
        this.j6 = null;
    }

    public void j6(Session session, Channel channel, String str, boolean z) {
        j6(z);
        this.j6 = str;
        j6(session, channel);
    }

    public void j6(Session session, Channel channel) {
        super.j6(session, channel);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 98);
        buffer.j6(channel.j6());
        buffer.DW(Util.DW("subsystem"));
        buffer.j6((byte) (j6() ? 1 : 0));
        buffer.DW(Util.DW(this.j6));
        j6(packet);
    }
}
