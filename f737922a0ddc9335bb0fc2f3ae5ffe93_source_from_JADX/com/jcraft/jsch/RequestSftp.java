package com.jcraft.jsch;

public class RequestSftp extends Request {
    RequestSftp() {
        j6(true);
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
        buffer.DW(Util.DW("sftp"));
        j6(packet);
    }
}
