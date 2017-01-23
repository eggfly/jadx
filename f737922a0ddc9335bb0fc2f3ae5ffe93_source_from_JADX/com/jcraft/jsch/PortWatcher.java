package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

class PortWatcher implements Runnable {
    private static InetAddress tp;
    private static Vector u7;
    int DW;
    int FH;
    String Hw;
    ServerSocket VH;
    Runnable Zo;
    int gn;
    Session j6;
    InetAddress v5;

    static {
        u7 = new Vector();
        tp = null;
        try {
            tp = InetAddress.getByName("0.0.0.0");
        } catch (UnknownHostException e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.jcraft.jsch.PortWatcher j6(com.jcraft.jsch.Session r6, java.lang.String r7, int r8) {
        /*
        r2 = java.net.InetAddress.getByName(r7);	 Catch:{ UnknownHostException -> 0x0014 }
        r3 = u7;
        monitor-enter(r3);
        r0 = 0;
        r1 = r0;
    L_0x0009:
        r0 = u7;	 Catch:{ all -> 0x005a }
        r0 = r0.size();	 Catch:{ all -> 0x005a }
        if (r1 < r0) goto L_0x0032;
    L_0x0011:
        monitor-exit(r3);	 Catch:{ all -> 0x005a }
        r0 = 0;
    L_0x0013:
        return r0;
    L_0x0014:
        r0 = move-exception;
        r1 = new com.jcraft.jsch.JSchException;
        r2 = new java.lang.StringBuilder;
        r3 = "PortForwardingL: invalid address ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r3 = " specified.";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x0032:
        r0 = u7;	 Catch:{ all -> 0x005a }
        r0 = r0.elementAt(r1);	 Catch:{ all -> 0x005a }
        r0 = (com.jcraft.jsch.PortWatcher) r0;	 Catch:{ all -> 0x005a }
        r4 = r0.j6;	 Catch:{ all -> 0x005a }
        if (r4 != r6) goto L_0x005d;
    L_0x003e:
        r4 = r0.DW;	 Catch:{ all -> 0x005a }
        if (r4 != r8) goto L_0x005d;
    L_0x0042:
        r4 = tp;	 Catch:{ all -> 0x005a }
        if (r4 == 0) goto L_0x0050;
    L_0x0046:
        r4 = r0.v5;	 Catch:{ all -> 0x005a }
        r5 = tp;	 Catch:{ all -> 0x005a }
        r4 = r4.equals(r5);	 Catch:{ all -> 0x005a }
        if (r4 != 0) goto L_0x0058;
    L_0x0050:
        r4 = r0.v5;	 Catch:{ all -> 0x005a }
        r4 = r4.equals(r2);	 Catch:{ all -> 0x005a }
        if (r4 == 0) goto L_0x005d;
    L_0x0058:
        monitor-exit(r3);	 Catch:{ all -> 0x005a }
        goto L_0x0013;
    L_0x005a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x005a }
        throw r0;
    L_0x005d:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.PortWatcher.j6(com.jcraft.jsch.Session, java.lang.String, int):com.jcraft.jsch.PortWatcher");
    }

    private static String j6(String str) {
        if (str == null) {
            return str;
        }
        if (str.length() == 0 || str.equals("*")) {
            return "0.0.0.0";
        }
        if (str.equals("localhost")) {
            return "127.0.0.1";
        }
        return str;
    }

    static PortWatcher j6(Session session, String str, int i, String str2, int i2, ServerSocketFactory serverSocketFactory) {
        String j6 = j6(str);
        if (j6(session, j6, i) != null) {
            throw new JSchException("PortForwardingL: local port " + j6 + ":" + i + " is already registered.");
        }
        PortWatcher portWatcher = new PortWatcher(session, j6, i, str2, i2, serverSocketFactory);
        u7.addElement(portWatcher);
        return portWatcher;
    }

    static void j6(Session session) {
        synchronized (u7) {
            int i;
            PortWatcher[] portWatcherArr = new PortWatcher[u7.size()];
            int i2 = 0;
            int i3 = 0;
            while (i2 < u7.size()) {
                PortWatcher portWatcher = (PortWatcher) u7.elementAt(i2);
                if (portWatcher.j6 == session) {
                    portWatcher.j6();
                    int i4 = i3 + 1;
                    portWatcherArr[i3] = portWatcher;
                    i = i4;
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            for (i = 0; i < i3; i++) {
                u7.removeElement(portWatcherArr[i]);
            }
        }
    }

    PortWatcher(Session session, String str, int i, String str2, int i2, ServerSocketFactory serverSocketFactory) {
        this.gn = 0;
        this.j6 = session;
        this.DW = i;
        this.Hw = str2;
        this.FH = i2;
        try {
            ServerSocket serverSocket;
            this.v5 = InetAddress.getByName(str);
            if (serverSocketFactory == null) {
                serverSocket = new ServerSocket(i, 0, this.v5);
            } else {
                serverSocket = serverSocketFactory.j6(i, 0, this.v5);
            }
            this.VH = serverSocket;
            if (i == 0) {
                int localPort = this.VH.getLocalPort();
                if (localPort != -1) {
                    this.DW = localPort;
                }
            }
        } catch (Throwable e) {
            String str3 = "PortForwardingL: local port " + str + ":" + i + " cannot be bound.";
            if (e instanceof Throwable) {
                throw new JSchException(str3, e);
            }
            throw new JSchException(str3);
        }
    }

    public void run() {
        this.Zo = this;
        while (this.Zo != null) {
            try {
                Socket accept = this.VH.accept();
                accept.setTcpNoDelay(true);
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();
                Channel channelDirectTCPIP = new ChannelDirectTCPIP();
                channelDirectTCPIP.DW();
                channelDirectTCPIP.j6(inputStream);
                channelDirectTCPIP.j6(outputStream);
                this.j6.j6(channelDirectTCPIP);
                channelDirectTCPIP.DW(this.Hw);
                channelDirectTCPIP.u7(this.FH);
                channelDirectTCPIP.FH(accept.getInetAddress().getHostAddress());
                channelDirectTCPIP.tp(accept.getPort());
                channelDirectTCPIP.DW(this.gn);
                int i = channelDirectTCPIP.XL;
            } catch (Exception e) {
            }
        }
        j6();
    }

    void j6() {
        this.Zo = null;
        try {
            if (this.VH != null) {
                this.VH.close();
            }
            this.VH = null;
        } catch (Exception e) {
        }
    }

    void j6(int i) {
        this.gn = i;
    }
}
