package com.jcraft.jsch;

import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.net.Socket;
import java.util.Vector;

public class ChannelForwardedTCPIP extends Channel {
    private static Vector U2;
    private Socket a8;
    private ForwardedTCPIPDaemon lg;
    private Config rN;

    static abstract class Config {
        int DW;
        int FH;
        String Hw;
        Session j6;
        String v5;

        Config() {
        }
    }

    static class ConfigDaemon extends Config {
        Object[] Zo;

        ConfigDaemon() {
        }
    }

    static class ConfigLHost extends Config {
        SocketFactory VH;
        int Zo;

        ConfigLHost() {
        }
    }

    static {
        U2 = new Vector();
    }

    ChannelForwardedTCPIP() {
        this.a8 = null;
        this.lg = null;
        this.rN = null;
        FH(131072);
        Hw(131072);
        v5(16384);
        this.tp = new IO();
        this.Ws = true;
    }

    public void run() {
        try {
            if (this.rN instanceof ConfigDaemon) {
                ConfigDaemon configDaemon = (ConfigDaemon) this.rN;
                this.lg = (ForwardedTCPIPDaemon) Class.forName(configDaemon.v5).newInstance();
                OutputStream pipedOutputStream = new PipedOutputStream();
                this.tp.j6(new PassiveInputStream(this, pipedOutputStream, 32768), false);
                this.lg.j6(this, Hw(), pipedOutputStream);
                this.lg.j6(configDaemon.Zo);
                new Thread(this.lg).start();
            } else {
                Socket j6;
                ConfigLHost configLHost = (ConfigLHost) this.rN;
                if (configLHost.VH == null) {
                    j6 = Util.j6(configLHost.v5, configLHost.Zo, 10000);
                } else {
                    j6 = configLHost.VH.j6(configLHost.v5, configLHost.Zo);
                }
                this.a8 = j6;
                this.a8.setTcpNoDelay(true);
                this.tp.j6(this.a8.getInputStream());
                this.tp.j6(this.a8.getOutputStream());
            }
            J8();
            this.EQ = Thread.currentThread();
            Buffer buffer = new Buffer(this.u7);
            Packet packet = new Packet(buffer);
            try {
                Session J0 = J0();
                while (this.EQ != null && this.tp != null && this.tp.j6 != null) {
                    int read = this.tp.j6.read(buffer.DW, 14, (buffer.DW.length - 14) - 84);
                    if (read <= 0) {
                        gn();
                        break;
                    }
                    packet.j6();
                    buffer.j6((byte) 94);
                    buffer.j6(this.FH);
                    buffer.j6(read);
                    buffer.DW(read);
                    synchronized (this) {
                        if (this.J8) {
                            break;
                        } else {
                            J0.j6(packet, (Channel) this, read);
                        }
                    }
                }
            } catch (Exception e) {
            }
            tp();
        } catch (Exception e2) {
            gn(1);
            this.J8 = true;
            tp();
        }
    }

    void j6(Buffer buffer) {
        Session J0;
        j6(buffer.Hw());
        j6(buffer.v5());
        Zo(buffer.Hw());
        byte[] tp = buffer.tp();
        int Hw = buffer.Hw();
        buffer.tp();
        buffer.Hw();
        try {
            J0 = J0();
        } catch (JSchException e) {
            J0 = null;
        }
        this.rN = DW(J0, Util.DW(tp), Hw);
        if (this.rN == null) {
            this.rN = DW(J0, null, Hw);
        }
        if (this.rN == null && JSch.v5().j6(3)) {
            JSch.v5().j6(3, "ChannelForwardedTCPIP: " + Util.DW(tp) + ":" + Hw + " is not registered.");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.jcraft.jsch.ChannelForwardedTCPIP.Config DW(com.jcraft.jsch.Session r4, java.lang.String r5, int r6) {
        /*
        r2 = U2;
        monitor-enter(r2);
        r0 = 0;
        r1 = r0;
    L_0x0005:
        r0 = U2;	 Catch:{ all -> 0x0038 }
        r0 = r0.size();	 Catch:{ all -> 0x0038 }
        if (r1 < r0) goto L_0x0010;
    L_0x000d:
        monitor-exit(r2);	 Catch:{ all -> 0x0038 }
        r0 = 0;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = U2;	 Catch:{ all -> 0x0038 }
        r0 = r0.elementAt(r1);	 Catch:{ all -> 0x0038 }
        r0 = (com.jcraft.jsch.ChannelForwardedTCPIP.Config) r0;	 Catch:{ all -> 0x0038 }
        r3 = r0.j6;	 Catch:{ all -> 0x0038 }
        if (r3 == r4) goto L_0x0020;
    L_0x001c:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0005;
    L_0x0020:
        r3 = r0.DW;	 Catch:{ all -> 0x0038 }
        if (r3 == r6) goto L_0x002c;
    L_0x0024:
        r3 = r0.DW;	 Catch:{ all -> 0x0038 }
        if (r3 != 0) goto L_0x001c;
    L_0x0028:
        r3 = r0.FH;	 Catch:{ all -> 0x0038 }
        if (r3 != r6) goto L_0x001c;
    L_0x002c:
        if (r5 == 0) goto L_0x0036;
    L_0x002e:
        r3 = r0.Hw;	 Catch:{ all -> 0x0038 }
        r3 = r3.equals(r5);	 Catch:{ all -> 0x0038 }
        if (r3 == 0) goto L_0x001c;
    L_0x0036:
        monitor-exit(r2);	 Catch:{ all -> 0x0038 }
        goto L_0x000f;
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0038 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.ChannelForwardedTCPIP.DW(com.jcraft.jsch.Session, java.lang.String, int):com.jcraft.jsch.ChannelForwardedTCPIP$Config");
    }

    static String DW(String str) {
        if (str == null) {
            return "localhost";
        }
        if (str.length() == 0 || str.equals("*")) {
            return "";
        }
        return str;
    }

    static void j6(Session session, String str, int i, int i2, String str2, int i3, SocketFactory socketFactory) {
        String DW = DW(str);
        synchronized (U2) {
            if (DW(session, DW, i) != null) {
                throw new JSchException("PortForwardingR: remote port " + i + " is already registered.");
            }
            ConfigLHost configLHost = new ConfigLHost();
            configLHost.j6 = session;
            configLHost.DW = i;
            configLHost.FH = i2;
            configLHost.v5 = str2;
            configLHost.Zo = i3;
            configLHost.Hw = DW;
            configLHost.VH = socketFactory;
            U2.addElement(configLHost);
        }
    }

    static void j6(Session session, int i) {
        j6(session, null, i);
    }

    static void j6(Session session, String str, int i) {
        synchronized (U2) {
            Config DW = DW(session, DW(str), i);
            if (DW == null) {
                DW = DW(session, null, i);
            }
            if (DW == null) {
                return;
            }
            String str2;
            U2.removeElement(DW);
            if (str == null) {
                str2 = DW.Hw;
            } else {
                str2 = str;
            }
            if (str2 == null) {
                str2 = "0.0.0.0";
            }
            Buffer buffer = new Buffer(100);
            Packet packet = new Packet(buffer);
            try {
                packet.j6();
                buffer.j6((byte) 80);
                buffer.DW(Util.DW("cancel-tcpip-forward"));
                buffer.j6((byte) 0);
                buffer.DW(Util.DW(str2));
                buffer.j6(i);
                session.DW(packet);
            } catch (Exception e) {
            }
        }
    }

    static void FH(Session session) {
        int[] iArr = (int[]) null;
        synchronized (U2) {
            int[] iArr2 = new int[U2.size()];
            int i = 0;
            int i2 = 0;
            while (i < U2.size()) {
                int i3;
                Config config = (Config) U2.elementAt(i);
                if (config.j6 == session) {
                    int i4 = i2 + 1;
                    iArr2[i2] = config.DW;
                    i3 = i4;
                } else {
                    i3 = i2;
                }
                i++;
                i2 = i3;
            }
        }
        for (i3 = 0; i3 < i2; i3++) {
            j6(session, iArr2[i3]);
        }
    }
}
