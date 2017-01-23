package com.jcraft.jsch;

import java.io.IOException;
import java.net.Socket;
import java.util.Hashtable;

class ChannelX11 extends Channel {
    private static byte[] BT;
    static byte[] U2;
    private static String a8;
    private static byte[] er;
    private static Hashtable gW;
    private static int lg;
    private static Hashtable yS;
    private byte[] P8;
    private boolean rN;
    private Socket vy;

    static {
        a8 = "127.0.0.1";
        lg = 6000;
        U2 = null;
        er = null;
        yS = new Hashtable();
        gW = new Hashtable();
        BT = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    }

    static byte[] FH(Session session) {
        byte[] bArr;
        synchronized (gW) {
            bArr = (byte[]) gW.get(session);
            if (bArr == null) {
                Random random = Session.Zo;
                Object obj = new byte[16];
                synchronized (random) {
                    random.j6(obj, 0, 16);
                }
                yS.put(session, obj);
                bArr = new byte[32];
                for (int i = 0; i < 16; i++) {
                    bArr[i * 2] = BT[(obj[i] >>> 4) & 15];
                    bArr[(i * 2) + 1] = BT[obj[i] & 15];
                }
                gW.put(session, bArr);
            }
        }
        return bArr;
    }

    static void Hw(Session session) {
        synchronized (gW) {
            gW.remove(session);
            yS.remove(session);
        }
    }

    ChannelX11() {
        this.rN = true;
        this.vy = null;
        this.P8 = new byte[0];
        FH(131072);
        Hw(131072);
        v5(16384);
        this.Hw = Util.DW("x11");
        this.Ws = true;
    }

    public void run() {
        try {
            this.vy = Util.j6(a8, lg, 10000);
            this.vy.setTcpNoDelay(true);
            this.tp = new IO();
            this.tp.j6(this.vy.getInputStream());
            this.tp.j6(this.vy.getOutputStream());
            J8();
            this.EQ = Thread.currentThread();
            Buffer buffer = new Buffer(this.u7);
            Packet packet = new Packet(buffer);
            while (this.EQ != null && this.tp != null && this.tp.j6 != null) {
                try {
                    int read = this.tp.j6.read(buffer.DW, 14, (buffer.DW.length - 14) - 84);
                    if (read > 0) {
                        if (this.J8) {
                            break;
                        }
                        packet.j6();
                        buffer.j6((byte) 94);
                        buffer.j6(this.FH);
                        buffer.j6(read);
                        buffer.DW(read);
                        J0().j6(packet, (Channel) this, read);
                    } else {
                        gn();
                        break;
                    }
                } catch (Exception e) {
                }
            }
            tp();
        } catch (Exception e2) {
            gn(1);
            this.J8 = true;
            tp();
        }
    }

    private byte[] FH(byte[] bArr, int i, int i2) {
        Object obj = new byte[(this.P8.length + i2)];
        System.arraycopy(bArr, i, obj, this.P8.length, i2);
        if (this.P8.length > 0) {
            System.arraycopy(this.P8, 0, obj, 0, this.P8.length);
        }
        this.P8 = obj;
        return this.P8;
    }

    void j6(byte[] bArr, int i, int i2) {
        if (this.rN) {
            try {
                Session J0 = J0();
                Object FH = FH(bArr, i, i2);
                int length = FH.length;
                if (length >= 9) {
                    int i3;
                    int i4 = (FH[7] & 255) + ((FH[6] & 255) * 256);
                    int i5 = ((FH[8] & 255) * 256) + (FH[9] & 255);
                    if ((FH[0] & 255) == 66 || (FH[0] & 255) != 108) {
                        i3 = i4;
                        i4 = i5;
                    } else {
                        i3 = ((i4 << 8) & 65280) | ((i4 >>> 8) & 255);
                        i4 = ((i5 << 8) & 65280) | ((i5 >>> 8) & 255);
                    }
                    if (length >= ((i3 + 12) + ((-i3) & 3)) + i4) {
                        Object obj = new byte[i4];
                        System.arraycopy(FH, (i3 + 12) + ((-i3) & 3), obj, 0, i4);
                        byte[] bArr2 = null;
                        synchronized (yS) {
                            bArr2 = (byte[]) yS.get(J0);
                        }
                        if (!j6(obj, bArr2)) {
                            this.EQ = null;
                            gn();
                            this.tp.FH();
                            tp();
                        } else if (U2 != null) {
                            System.arraycopy(U2, 0, FH, ((-i3) & 3) + (i3 + 12), i4);
                        }
                        this.rN = false;
                        this.tp.j6(FH, 0, length);
                        this.P8 = null;
                        return;
                    }
                    return;
                }
                return;
            } catch (JSchException e) {
                throw new IOException(e.toString());
            }
        }
        this.tp.j6(bArr, i, i2);
    }

    private static boolean j6(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
