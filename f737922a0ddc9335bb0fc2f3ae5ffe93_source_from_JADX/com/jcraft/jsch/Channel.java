package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Vector;

public abstract class Channel implements Runnable {
    private static Vector U2;
    static int j6;
    int DW;
    Thread EQ;
    volatile int FH;
    protected byte[] Hw;
    volatile boolean J0;
    volatile boolean J8;
    int Mr;
    volatile boolean QX;
    volatile int VH;
    volatile boolean Ws;
    volatile int XL;
    volatile int Zo;
    private Session a8;
    volatile int aM;
    volatile long gn;
    volatile int j3;
    IO tp;
    volatile int u7;
    volatile int v5;
    volatile boolean we;

    class 1 extends OutputStream {
        final /* synthetic */ Channel DW;
        private int FH;
        private Buffer Hw;
        private final /* synthetic */ Channel VH;
        private boolean Zo;
        byte[] j6;
        private Packet v5;

        1(Channel channel, Channel channel2) {
            this.DW = channel;
            this.VH = channel2;
            this.FH = 0;
            this.Hw = null;
            this.v5 = null;
            this.Zo = false;
            this.j6 = new byte[1];
        }

        private synchronized void j6() {
            this.Hw = new Buffer(this.DW.u7);
            this.v5 = new Packet(this.Hw);
            if ((this.Hw.DW.length - 14) - 84 <= 0) {
                this.Hw = null;
                this.v5 = null;
                throw new IOException("failed to initialize the channel.");
            }
        }

        public void write(int i) {
            this.j6[0] = (byte) i;
            write(this.j6, 0, 1);
        }

        public void write(byte[] bArr, int i, int i2) {
            if (this.v5 == null) {
                j6();
            }
            if (this.Zo) {
                throw new IOException("Already closed");
            }
            Object obj = this.Hw.DW;
            int length = obj.length;
            int i3 = i2;
            while (i3 > 0) {
                int i4;
                if (i3 > (length - (this.FH + 14)) - 84) {
                    i4 = (length - (this.FH + 14)) - 84;
                } else {
                    i4 = i3;
                }
                if (i4 <= 0) {
                    flush();
                } else {
                    System.arraycopy(bArr, i, obj, this.FH + 14, i4);
                    this.FH += i4;
                    i += i4;
                    i3 -= i4;
                }
            }
        }

        public void flush() {
            if (this.Zo) {
                throw new IOException("Already closed");
            } else if (this.FH != 0) {
                this.v5.j6();
                this.Hw.j6((byte) 94);
                this.Hw.j6(this.DW.FH);
                this.Hw.j6(this.FH);
                this.Hw.DW(this.FH);
                try {
                    int i = this.FH;
                    this.FH = 0;
                    synchronized (this.VH) {
                        if (!this.VH.J8) {
                            this.DW.J0().j6(this.v5, this.VH, i);
                        }
                    }
                } catch (Exception e) {
                    close();
                    throw new IOException(e.toString());
                }
            }
        }

        public void close() {
            if (this.v5 == null) {
                try {
                    j6();
                } catch (IOException e) {
                    return;
                }
            }
            if (!this.Zo) {
                if (this.FH > 0) {
                    flush();
                }
                this.VH.gn();
                this.Zo = true;
            }
        }
    }

    class MyPipedInputStream extends PipedInputStream {
        private int DW;
        private int FH;
        final /* synthetic */ Channel j6;

        MyPipedInputStream(Channel channel, int i) {
            this.j6 = channel;
            this.DW = 1024;
            this.FH = this.DW;
            this.buffer = new byte[i];
            this.DW = i;
            this.FH = i;
        }

        MyPipedInputStream(Channel channel, int i, int i2) {
            this(channel, i);
            this.FH = i2;
        }

        MyPipedInputStream(Channel channel, PipedOutputStream pipedOutputStream, int i) {
            this.j6 = channel;
            super(pipedOutputStream);
            this.DW = 1024;
            this.FH = this.DW;
            this.buffer = new byte[i];
            this.DW = i;
        }

        public synchronized void j6() {
            if (available() == 0) {
                this.in = 0;
                this.out = 0;
                byte[] bArr = this.buffer;
                int i = this.in;
                this.in = i + 1;
                bArr[i] = (byte) 0;
                read();
            }
        }

        private int DW() {
            if (this.out < this.in) {
                return this.buffer.length - this.in;
            }
            if (this.in >= this.out) {
                return 0;
            }
            if (this.in == -1) {
                return this.buffer.length;
            }
            return this.out - this.in;
        }

        synchronized void j6(int i) {
            int DW = DW();
            if (DW < i) {
                int length = this.buffer.length - DW;
                DW = this.buffer.length;
                while (DW - length < i) {
                    DW *= 2;
                }
                if (DW > this.FH) {
                    DW = this.FH;
                }
                if (DW - length >= i) {
                    Object obj = new byte[DW];
                    if (this.out < this.in) {
                        System.arraycopy(this.buffer, 0, obj, 0, this.buffer.length);
                    } else if (this.in < this.out) {
                        if (this.in != -1) {
                            System.arraycopy(this.buffer, 0, obj, 0, this.in);
                            System.arraycopy(this.buffer, this.out, obj, obj.length - (this.buffer.length - this.out), this.buffer.length - this.out);
                            this.out = obj.length - (this.buffer.length - this.out);
                        }
                    } else if (this.in == this.out) {
                        System.arraycopy(this.buffer, 0, obj, 0, this.buffer.length);
                        this.in = this.buffer.length;
                    }
                    this.buffer = obj;
                }
            } else if (this.buffer.length == DW && DW > this.DW) {
                DW /= 2;
                if (DW < this.DW) {
                    DW = this.DW;
                }
                this.buffer = new byte[DW];
            }
        }
    }

    class PassiveInputStream extends MyPipedInputStream {
        PipedOutputStream DW;
        final /* synthetic */ Channel FH;

        PassiveInputStream(Channel channel, PipedOutputStream pipedOutputStream, int i) {
            this.FH = channel;
            super(channel, pipedOutputStream, i);
            this.DW = pipedOutputStream;
        }

        public void close() {
            if (this.DW != null) {
                this.DW.close();
            }
            this.DW = null;
        }
    }

    class PassiveOutputStream extends PipedOutputStream {
        private MyPipedInputStream DW;
        final /* synthetic */ Channel j6;

        PassiveOutputStream(Channel channel, PipedInputStream pipedInputStream, boolean z) {
            this.j6 = channel;
            super(pipedInputStream);
            this.DW = null;
            if (z && (pipedInputStream instanceof MyPipedInputStream)) {
                this.DW = (MyPipedInputStream) pipedInputStream;
            }
        }

        public void write(int i) {
            if (this.DW != null) {
                this.DW.j6(1);
            }
            super.write(i);
        }

        public void write(byte[] bArr, int i, int i2) {
            if (this.DW != null) {
                this.DW.j6(i2);
            }
            super.write(bArr, i, i2);
        }
    }

    static {
        j6 = 0;
        U2 = new Vector();
    }

    static Channel j6(String str) {
        if (str.equals("session")) {
            return new ChannelSession();
        }
        if (str.equals("shell")) {
            return new ChannelShell();
        }
        if (str.equals("exec")) {
            return new ChannelExec();
        }
        if (str.equals("x11")) {
            return new ChannelX11();
        }
        if (str.equals("auth-agent@openssh.com")) {
            return new ChannelAgentForwarding();
        }
        if (str.equals("direct-tcpip")) {
            return new ChannelDirectTCPIP();
        }
        if (str.equals("forwarded-tcpip")) {
            return new ChannelForwardedTCPIP();
        }
        if (str.equals("sftp")) {
            return new ChannelSftp();
        }
        if (str.equals("subsystem")) {
            return new ChannelSubsystem();
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.jcraft.jsch.Channel j6(int r4, com.jcraft.jsch.Session r5) {
        /*
        r2 = U2;
        monitor-enter(r2);
        r0 = 0;
        r1 = r0;
    L_0x0005:
        r0 = U2;	 Catch:{ all -> 0x0022 }
        r0 = r0.size();	 Catch:{ all -> 0x0022 }
        if (r1 < r0) goto L_0x0010;
    L_0x000d:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        r0 = 0;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = U2;	 Catch:{ all -> 0x0022 }
        r0 = r0.elementAt(r1);	 Catch:{ all -> 0x0022 }
        r0 = (com.jcraft.jsch.Channel) r0;	 Catch:{ all -> 0x0022 }
        r3 = r0.DW;	 Catch:{ all -> 0x0022 }
        if (r3 != r4) goto L_0x0025;
    L_0x001c:
        r3 = r0.a8;	 Catch:{ all -> 0x0022 }
        if (r3 != r5) goto L_0x0025;
    L_0x0020:
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        goto L_0x000f;
    L_0x0022:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0022 }
        throw r0;
    L_0x0025:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Channel.j6(int, com.jcraft.jsch.Session):com.jcraft.jsch.Channel");
    }

    static void j6(Channel channel) {
        synchronized (U2) {
            U2.removeElement(channel);
        }
    }

    Channel() {
        this.FH = -1;
        this.Hw = Util.DW("foo");
        this.v5 = 1048576;
        this.Zo = this.v5;
        this.VH = 16384;
        this.gn = 0;
        this.u7 = 0;
        this.tp = null;
        this.EQ = null;
        this.we = false;
        this.J0 = false;
        this.J8 = false;
        this.Ws = false;
        this.QX = false;
        this.XL = -1;
        this.aM = 0;
        this.j3 = 0;
        this.Mr = 0;
        synchronized (U2) {
            int i = j6;
            j6 = i + 1;
            this.DW = i;
            U2.addElement(this);
        }
    }

    synchronized void j6(int i) {
        this.FH = i;
        if (this.Mr > 0) {
            notifyAll();
        }
    }

    int j6() {
        return this.FH;
    }

    void DW() {
    }

    public void DW(int i) {
        this.j3 = i;
        try {
            QX();
            FH();
        } catch (Throwable e) {
            this.Ws = false;
            tp();
            if (e instanceof JSchException) {
                throw ((JSchException) e);
            }
            throw new JSchException(e.toString(), e);
        }
    }

    public void FH() {
    }

    void j6(Buffer buffer) {
        j6(buffer.Hw());
        j6(buffer.v5());
        Zo(buffer.Hw());
    }

    public void j6(InputStream inputStream) {
        this.tp.j6(inputStream, false);
    }

    public void j6(OutputStream outputStream) {
        this.tp.j6(outputStream, false);
    }

    public InputStream Hw() {
        int parseInt;
        boolean z;
        try {
            parseInt = Integer.parseInt(J0().v5("max_input_buffer_size"));
        } catch (Exception e) {
            parseInt = 32768;
        }
        InputStream myPipedInputStream = new MyPipedInputStream(this, 32768, parseInt);
        if (32768 < parseInt) {
            z = true;
        } else {
            z = false;
        }
        this.tp.j6(new PassiveOutputStream(this, myPipedInputStream, z), false);
        return myPipedInputStream;
    }

    public InputStream v5() {
        int parseInt;
        boolean z;
        try {
            parseInt = Integer.parseInt(J0().v5("max_input_buffer_size"));
        } catch (Exception e) {
            parseInt = 32768;
        }
        InputStream myPipedInputStream = new MyPipedInputStream(this, 32768, parseInt);
        if (32768 < parseInt) {
            z = true;
        } else {
            z = false;
        }
        this.tp.DW(new PassiveOutputStream(this, myPipedInputStream, z), false);
        return myPipedInputStream;
    }

    public OutputStream Zo() {
        return new 1(this, this);
    }

    void FH(int i) {
        this.v5 = i;
    }

    void Hw(int i) {
        this.Zo = i;
    }

    void v5(int i) {
        this.VH = i;
    }

    synchronized void j6(long j) {
        this.gn = j;
    }

    synchronized void DW(long j) {
        this.gn += j;
        if (this.Mr > 0) {
            notifyAll();
        }
    }

    void Zo(int i) {
        this.u7 = i;
    }

    public void run() {
    }

    void j6(byte[] bArr, int i, int i2) {
        try {
            this.tp.j6(bArr, i, i2);
        } catch (NullPointerException e) {
        }
    }

    void DW(byte[] bArr, int i, int i2) {
        try {
            this.tp.DW(bArr, i, i2);
        } catch (NullPointerException e) {
        }
    }

    void VH() {
        this.J0 = true;
        try {
            this.tp.DW();
        } catch (NullPointerException e) {
        }
    }

    void gn() {
        if (!this.we) {
            this.we = true;
            int j6 = j6();
            if (j6 != -1) {
                try {
                    Buffer buffer = new Buffer(100);
                    Packet packet = new Packet(buffer);
                    packet.j6();
                    buffer.j6((byte) 96);
                    buffer.j6(j6);
                    synchronized (this) {
                        if (!this.J8) {
                            J0().DW(packet);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    void u7() {
        if (!this.J8) {
            this.J8 = true;
            this.J0 = true;
            this.we = true;
            int j6 = j6();
            if (j6 != -1) {
                try {
                    Buffer buffer = new Buffer(100);
                    Packet packet = new Packet(buffer);
                    packet.j6();
                    buffer.j6((byte) 97);
                    buffer.j6(j6);
                    synchronized (this) {
                        J0().DW(packet);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    static void j6(Session session) {
        int i;
        Channel[] channelArr = (Channel[]) null;
        synchronized (U2) {
            Channel[] channelArr2 = new Channel[U2.size()];
            int i2 = 0;
            int i3 = 0;
            while (i2 < U2.size()) {
                try {
                    Channel channel = (Channel) U2.elementAt(i2);
                    if (channel.a8 == session) {
                        int i4 = i3 + 1;
                        try {
                            channelArr2[i3] = channel;
                            i = i4;
                        } catch (Exception e) {
                            i = i4;
                        }
                    } else {
                        i = i3;
                    }
                } catch (Exception e2) {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
        for (i = 0; i < i3; i++) {
            channelArr2[i].tp();
        }
    }

    public void tp() {
        try {
            synchronized (this) {
                if (this.Ws) {
                    this.Ws = false;
                    u7();
                    this.we = true;
                    this.J0 = true;
                    this.EQ = null;
                    try {
                        if (this.tp != null) {
                            this.tp.FH();
                        }
                    } catch (Exception e) {
                    }
                    j6(this);
                    return;
                }
            }
        } finally {
            j6(this);
        }
    }

    public boolean EQ() {
        Session session = this.a8;
        if (session != null && session.Hw() && this.Ws) {
            return true;
        }
        return false;
    }

    void VH(int i) {
        this.XL = i;
    }

    public int we() {
        return this.XL;
    }

    void DW(Session session) {
        this.a8 = session;
    }

    public Session J0() {
        Session session = this.a8;
        if (session != null) {
            return session;
        }
        throw new JSchException("session is not available");
    }

    protected void J8() {
        Buffer buffer = new Buffer(100);
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 91);
        buffer.j6(j6());
        buffer.j6(this.DW);
        buffer.j6(this.Zo);
        buffer.j6(this.VH);
        J0().DW(packet);
    }

    protected void gn(int i) {
        try {
            Buffer buffer = new Buffer(100);
            Packet packet = new Packet(buffer);
            packet.j6();
            buffer.j6((byte) 92);
            buffer.j6(j6());
            buffer.j6(i);
            buffer.DW(Util.DW("open failed"));
            buffer.DW(Util.j6);
            J0().DW(packet);
        } catch (Exception e) {
        }
    }

    protected Packet Ws() {
        Buffer buffer = new Buffer(100);
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 90);
        buffer.DW(this.Hw);
        buffer.j6(this.DW);
        buffer.j6(this.Zo);
        buffer.j6(this.VH);
        return packet;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void QX() {
        /*
        r14 = this;
        r11 = -1;
        r12 = 0;
        r1 = 1;
        r6 = 0;
        r7 = r14.J0();
        r0 = r7.Hw();
        if (r0 != 0) goto L_0x0018;
    L_0x000f:
        r0 = new com.jcraft.jsch.JSchException;
        r1 = "session is down";
        r0.<init>(r1);
        throw r0;
    L_0x0018:
        r0 = r14.Ws();
        r7.DW(r0);
        r0 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r8 = java.lang.System.currentTimeMillis();
        r2 = r14.j3;
        r4 = (long) r2;
        r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
        if (r2 == 0) goto L_0x002d;
    L_0x002c:
        r0 = r1;
    L_0x002d:
        monitor-enter(r14);
    L_0x002e:
        r2 = r14.j6();	 Catch:{ all -> 0x0074 }
        if (r2 != r11) goto L_0x003c;
    L_0x0034:
        r2 = r7.Hw();	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x003c;
    L_0x003a:
        if (r0 > 0) goto L_0x004c;
    L_0x003c:
        monitor-exit(r14);	 Catch:{ all -> 0x0074 }
        r0 = r7.Hw();
        if (r0 != 0) goto L_0x007c;
    L_0x0043:
        r0 = new com.jcraft.jsch.JSchException;
        r1 = "session is down";
        r0.<init>(r1);
        throw r0;
    L_0x004c:
        r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
        if (r2 <= 0) goto L_0x005b;
    L_0x0050:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0074 }
        r2 = r2 - r8;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x005b;
    L_0x0059:
        r0 = r6;
        goto L_0x002e;
    L_0x005b:
        r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
        if (r2 != 0) goto L_0x006d;
    L_0x005f:
        r2 = 10;
    L_0x0061:
        r10 = 1;
        r14.Mr = r10;	 Catch:{ InterruptedException -> 0x006f, all -> 0x0077 }
        r14.wait(r2);	 Catch:{ InterruptedException -> 0x006f, all -> 0x0077 }
        r2 = 0;
        r14.Mr = r2;	 Catch:{ all -> 0x0074 }
    L_0x006a:
        r0 = r0 + -1;
        goto L_0x002e;
    L_0x006d:
        r2 = r4;
        goto L_0x0061;
    L_0x006f:
        r2 = move-exception;
        r2 = 0;
        r14.Mr = r2;	 Catch:{ all -> 0x0074 }
        goto L_0x006a;
    L_0x0074:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0074 }
        throw r0;
    L_0x0077:
        r0 = move-exception;
        r1 = 0;
        r14.Mr = r1;	 Catch:{ all -> 0x0074 }
        throw r0;	 Catch:{ all -> 0x0074 }
    L_0x007c:
        r0 = r14.j6();
        if (r0 != r11) goto L_0x008b;
    L_0x0082:
        r0 = new com.jcraft.jsch.JSchException;
        r1 = "channel is not opened.";
        r0.<init>(r1);
        throw r0;
    L_0x008b:
        r0 = r14.QX;
        if (r0 != 0) goto L_0x0098;
    L_0x008f:
        r0 = new com.jcraft.jsch.JSchException;
        r1 = "channel is not opened.";
        r0.<init>(r1);
        throw r0;
    L_0x0098:
        r14.Ws = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Channel.QX():void");
    }
}
