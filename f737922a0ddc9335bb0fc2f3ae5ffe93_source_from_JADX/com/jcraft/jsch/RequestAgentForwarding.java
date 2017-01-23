package com.jcraft.jsch;

class RequestAgentForwarding extends Request {
    RequestAgentForwarding() {
    }

    public void j6(Session session, Channel channel) {
        int i = 0;
        super.j6(session, channel);
        j6(false);
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 98);
        buffer.j6(channel.j6());
        buffer.DW(Util.DW("auth-agent-req@openssh.com"));
        if (j6()) {
            i = 1;
        }
        buffer.j6((byte) i);
        j6(packet);
        session.FH = true;
    }
}
