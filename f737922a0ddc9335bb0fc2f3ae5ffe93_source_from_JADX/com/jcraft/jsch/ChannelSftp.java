package com.jcraft.jsch;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.Hashtable;
import java.util.Vector;

public class ChannelSftp extends ChannelSession {
    private static final String I;
    private static final char ca;
    private static boolean x9;
    private Buffer KD;
    private boolean Mz;
    private boolean OW;
    private String Qq;
    private int[] SI;
    private InputStream Sf;
    private boolean U2;
    private String aj;
    private RequestQueue br;
    private int cb;
    private Buffer cn;
    private int dx;
    private Hashtable ef;
    private boolean g3;
    private String lp;
    private int nw;
    private Packet ro;
    private String sG;
    private Packet sh;
    private String sy;
    private boolean vJ;

    class 1 extends OutputStream {
        final /* synthetic */ ChannelSftp DW;
        private final /* synthetic */ byte[] EQ;
        private boolean FH;
        private boolean Hw;
        private final /* synthetic */ SftpProgressMonitor J0;
        private int VH;
        private int Zo;
        private int gn;
        byte[] j6;
        private Header tp;
        private int u7;
        private int[] v5;
        private final /* synthetic */ long[] we;

        1(ChannelSftp channelSftp, byte[] bArr, long[] jArr, SftpProgressMonitor sftpProgressMonitor) {
            this.DW = channelSftp;
            this.EQ = bArr;
            this.we = jArr;
            this.J0 = sftpProgressMonitor;
            this.FH = true;
            this.Hw = false;
            this.v5 = new int[1];
            this.Zo = 0;
            this.VH = 0;
            this.gn = 0;
            this.u7 = 0;
            this.tp = new Header(channelSftp);
            this.j6 = new byte[1];
        }

        public void write(byte[] bArr) {
            write(bArr, 0, bArr.length);
        }

        public void write(byte[] bArr, int i, int i2) {
            if (this.FH) {
                this.Zo = this.DW.nw;
                this.VH = this.DW.nw;
                this.FH = false;
            }
            if (this.Hw) {
                throw new IOException("stream already closed");
            }
            int i3 = i2;
            int i4 = i;
            while (i3 > 0) {
                int j6 = this.DW.j6(this.EQ, this.we[0], bArr, i4, i3);
                this.u7++;
                long[] jArr = this.we;
                jArr[0] = jArr[0] + ((long) j6);
                i4 += j6;
                i3 -= j6;
                if (this.DW.nw - 1 == this.Zo || this.DW.Sf.available() >= 1024) {
                    while (this.DW.Sf.available() > 0 && this.DW.j6(this.v5, this.tp)) {
                        this.VH = this.v5[0];
                        if (this.Zo > this.VH || this.VH > this.DW.nw - 1) {
                            throw new SftpException(4, "");
                        }
                        try {
                            this.gn++;
                        } catch (IOException e) {
                            throw e;
                        } catch (Exception e2) {
                            throw new IOException(e2.toString());
                        }
                    }
                }
            }
            if (this.J0 != null && !this.J0.j6((long) i2)) {
                close();
                throw new IOException("canceled");
            }
        }

        public void write(int i) {
            this.j6[0] = (byte) i;
            write(this.j6, 0, 1);
        }

        public void flush() {
            if (this.Hw) {
                throw new IOException("stream already closed");
            } else if (!this.FH) {
                while (this.u7 > this.gn && this.DW.j6(null, this.tp)) {
                    try {
                        this.gn++;
                    } catch (SftpException e) {
                        throw new IOException(e.toString());
                    }
                }
            }
        }

        public void close() {
            if (!this.Hw) {
                flush();
                if (this.J0 != null) {
                    this.J0.j6();
                }
                try {
                    this.DW.j6(this.EQ, this.tp);
                    this.Hw = true;
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new IOException(e2.toString());
                }
            }
        }
    }

    class 2 extends InputStream {
        boolean DW;
        private final /* synthetic */ byte[] EQ;
        int FH;
        byte[] Hw;
        int VH;
        Header Zo;
        long gn;
        long j6;
        private final /* synthetic */ SftpProgressMonitor tp;
        final /* synthetic */ ChannelSftp u7;
        byte[] v5;

        2(ChannelSftp channelSftp, long j, SftpProgressMonitor sftpProgressMonitor, byte[] bArr) {
            this.u7 = channelSftp;
            this.tp = sftpProgressMonitor;
            this.EQ = bArr;
            this.j6 = j;
            this.DW = false;
            this.FH = 0;
            this.Hw = new byte[1];
            this.v5 = new byte[1024];
            this.Zo = new Header(channelSftp);
            this.VH = 1;
            this.gn = this.j6;
        }

        public int read() {
            if (this.DW || read(this.Hw, 0, 1) == -1) {
                return -1;
            }
            return this.Hw[0] & 255;
        }

        public int read(byte[] bArr) {
            if (this.DW) {
                return -1;
            }
            return read(bArr, 0, bArr.length);
        }

        public int read(byte[] bArr, int i, int i2) {
            int i3 = 0;
            if (this.DW) {
                return -1;
            }
            if (bArr == null) {
                throw new NullPointerException();
            } else if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException();
            } else if (i2 == 0) {
                return 0;
            } else {
                int i4;
                if (this.FH > 0) {
                    i4 = this.FH;
                    if (i4 <= i2) {
                        i2 = i4;
                    }
                    System.arraycopy(this.v5, 0, bArr, i, i2);
                    if (i2 != this.FH) {
                        System.arraycopy(this.v5, i2, this.v5, 0, this.FH - i2);
                    }
                    if (this.tp == null || this.tp.j6((long) i2)) {
                        this.FH -= i2;
                        return i2;
                    }
                    close();
                    return -1;
                }
                int length;
                if (this.u7.KD.DW.length - 13 < i2) {
                    i2 = this.u7.KD.DW.length - 13;
                }
                if (this.u7.dx == 0 && r15 > 1024) {
                    i2 = 1024;
                }
                if (this.u7.br.DW() == 0) {
                    length = this.u7.KD.DW.length - 13;
                    if (this.u7.dx == 0) {
                        length = 1024;
                    }
                    while (this.u7.br.DW() < this.VH) {
                        try {
                            this.u7.j6(this.EQ, this.gn, length, this.u7.br);
                            this.gn += (long) length;
                        } catch (Exception e) {
                            throw new IOException("error");
                        }
                    }
                }
                this.Zo = this.u7.j6(this.u7.KD, this.Zo);
                this.FH = this.Zo.j6;
                i4 = this.Zo.DW;
                int i5 = this.Zo.FH;
                try {
                    Request j6 = this.u7.br.j6(this.Zo.FH);
                    if (i4 != 101 && i4 != 103) {
                        throw new IOException("error");
                    } else if (i4 == 101) {
                        this.u7.DW(this.u7.KD, this.FH);
                        i4 = this.u7.KD.Hw();
                        this.FH = 0;
                        if (i4 == 1) {
                            close();
                            return -1;
                        }
                        throw new IOException("error");
                    } else {
                        this.u7.KD.J0();
                        this.u7.FH(this.u7.KD.DW, 0, 4);
                        length = this.u7.KD.Hw();
                        this.FH -= 4;
                        i5 = this.FH - length;
                        this.j6 += (long) length;
                        if (length <= 0) {
                            return 0;
                        }
                        if (length <= i2) {
                            i2 = length;
                        }
                        i2 = this.u7.Sf.read(bArr, i, i2);
                        if (i2 < 0) {
                            return -1;
                        }
                        i4 = length - i2;
                        this.FH = i4;
                        if (i4 > 0) {
                            if (this.v5.length < i4) {
                                this.v5 = new byte[i4];
                            }
                            while (i4 > 0) {
                                int read = this.u7.Sf.read(this.v5, i3, i4);
                                if (read <= 0) {
                                    break;
                                }
                                i3 += read;
                                i4 -= read;
                            }
                        }
                        if (i5 > 0) {
                            this.u7.Sf.skip((long) i5);
                        }
                        if (((long) length) < j6.FH) {
                            this.u7.br.j6(this.Zo, this.u7.KD);
                            try {
                                this.u7.j6(this.EQ, j6.DW + ((long) length), (int) (j6.FH - ((long) length)), this.u7.br);
                                this.gn = j6.DW + j6.FH;
                            } catch (Exception e2) {
                                throw new IOException("error");
                            }
                        }
                        if (this.VH < this.u7.br.FH()) {
                            this.VH++;
                        }
                        if (this.tp == null || this.tp.j6((long) i2)) {
                            return i2;
                        }
                        close();
                        return -1;
                    }
                } catch (OutOfOrderException e3) {
                    this.gn = e3.j6;
                    skip((long) this.Zo.j6);
                    this.u7.br.j6(this.Zo, this.u7.KD);
                    return 0;
                } catch (SftpException e4) {
                    throw new IOException("error: " + e4.toString());
                }
            }
        }

        public void close() {
            if (!this.DW) {
                this.DW = true;
                if (this.tp != null) {
                    this.tp.j6();
                }
                this.u7.br.j6(this.Zo, this.u7.KD);
                try {
                    this.u7.j6(this.EQ, this.Zo);
                } catch (Exception e) {
                    throw new IOException("error");
                }
            }
        }
    }

    public interface LsEntrySelector {
        int j6(LsEntry lsEntry);
    }

    class 3 implements LsEntrySelector {
        private final /* synthetic */ Vector DW;
        final /* synthetic */ ChannelSftp j6;

        3(ChannelSftp channelSftp, Vector vector) {
            this.j6 = channelSftp;
            this.DW = vector;
        }

        public int j6(LsEntry lsEntry) {
            this.DW.addElement(lsEntry);
            return 0;
        }
    }

    class Header {
        int DW;
        int FH;
        final /* synthetic */ ChannelSftp Hw;
        int j6;

        Header(ChannelSftp channelSftp) {
            this.Hw = channelSftp;
        }
    }

    public class LsEntry implements Comparable {
        private String DW;
        private String FH;
        private SftpATTRS Hw;
        final /* synthetic */ ChannelSftp j6;

        LsEntry(ChannelSftp channelSftp, String str, String str2, SftpATTRS sftpATTRS) {
            this.j6 = channelSftp;
            j6(str);
            DW(str2);
            j6(sftpATTRS);
        }

        public String j6() {
            return this.DW;
        }

        void j6(String str) {
            this.DW = str;
        }

        void DW(String str) {
            this.FH = str;
        }

        public SftpATTRS DW() {
            return this.Hw;
        }

        void j6(SftpATTRS sftpATTRS) {
            this.Hw = sftpATTRS;
        }

        public String toString() {
            return this.FH;
        }

        public int compareTo(Object obj) {
            if (obj instanceof LsEntry) {
                return this.DW.compareTo(((LsEntry) obj).j6());
            }
            throw new ClassCastException("a decendent of LsEntry must be given.");
        }
    }

    private class RequestQueue {
        int DW;
        int FH;
        final /* synthetic */ ChannelSftp Hw;
        Request[] j6;

        class OutOfOrderException extends Exception {
            final /* synthetic */ RequestQueue DW;
            long j6;

            OutOfOrderException(RequestQueue requestQueue, long j) {
                this.DW = requestQueue;
                this.j6 = j;
            }
        }

        class Request {
            long DW;
            long FH;
            final /* synthetic */ RequestQueue Hw;
            int j6;

            Request(RequestQueue requestQueue) {
                this.Hw = requestQueue;
            }
        }

        RequestQueue(ChannelSftp channelSftp, int i) {
            this.Hw = channelSftp;
            this.j6 = null;
            this.j6 = new Request[i];
            for (int i2 = 0; i2 < this.j6.length; i2++) {
                this.j6[i2] = new Request(this);
            }
            j6();
        }

        void j6() {
            this.FH = 0;
            this.DW = 0;
        }

        void j6(int i, long j, int i2) {
            if (this.FH == 0) {
                this.DW = 0;
            }
            int i3 = this.DW + this.FH;
            if (i3 >= this.j6.length) {
                i3 -= this.j6.length;
            }
            this.j6[i3].j6 = i;
            this.j6[i3].DW = j;
            this.j6[i3].FH = (long) i2;
            this.FH++;
        }

        Request j6(int i) {
            int i2 = 0;
            this.FH--;
            int i3 = this.DW;
            this.DW++;
            if (this.DW == this.j6.length) {
                this.DW = 0;
            }
            if (this.j6[i3].j6 != i) {
                long Hw = Hw();
                for (i3 = 0; i3 < this.j6.length; i3++) {
                    if (this.j6[i3].j6 == i) {
                        this.j6[i3].j6 = 0;
                        i2 = 1;
                        break;
                    }
                }
                if (i2 != 0) {
                    throw new OutOfOrderException(this, Hw);
                }
                throw new SftpException(4, "RequestQueue: unknown request id " + i);
            }
            this.j6[i3].j6 = 0;
            return this.j6[i3];
        }

        int DW() {
            return this.FH;
        }

        int FH() {
            return this.j6.length;
        }

        void j6(Header header, Buffer buffer) {
            int i = this.FH;
            for (int i2 = 0; i2 < i; i2++) {
                header = this.Hw.j6(buffer, header);
                int i3 = header.j6;
                for (int i4 = 0; i4 < this.j6.length; i4++) {
                    if (this.j6[i4].j6 == header.FH) {
                        this.j6[i4].j6 = 0;
                        break;
                    }
                }
                this.Hw.FH((long) i3);
            }
            j6();
        }

        long Hw() {
            long j = Long.MAX_VALUE;
            int i = 0;
            while (i < this.j6.length) {
                if (this.j6[i].j6 != 0 && j > this.j6[i].DW) {
                    j = this.j6[i].DW;
                }
                i++;
            }
            return j;
        }
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    static {
        boolean z;
        I = File.separator;
        ca = File.separatorChar;
        if (((byte) File.separatorChar) == 92) {
            z = true;
        } else {
            z = false;
        }
        x9 = z;
    }

    public ChannelSftp() {
        this.U2 = false;
        this.nw = 1;
        this.SI = new int[1];
        this.cb = 3;
        this.dx = 3;
        this.sG = String.valueOf(this.cb);
        this.ef = null;
        this.Sf = null;
        this.vJ = false;
        this.g3 = false;
        this.Mz = false;
        this.lp = "UTF-8";
        this.OW = true;
        this.br = new RequestQueue(this, 16);
        FH(2097152);
        Hw(2097152);
        v5(32768);
    }

    void DW() {
    }

    public void FH() {
        try {
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            this.tp.j6((OutputStream) pipedOutputStream);
            this.tp.j6(new MyPipedInputStream((Channel) this, pipedOutputStream, this.u7));
            this.Sf = this.tp.j6;
            if (this.Sf == null) {
                throw new JSchException("channel is down");
            }
            new RequestSftp().j6(J0(), this);
            this.KD = new Buffer(this.VH);
            this.ro = new Packet(this.KD);
            this.cn = new Buffer(this.u7);
            this.sh = new Packet(this.cn);
            U2();
            Header j6 = j6(this.KD, new Header(this));
            int i = j6.j6;
            if (i > 262144) {
                throw new SftpException(4, "Received message is too long: " + i);
            }
            int i2 = j6.DW;
            this.dx = j6.FH;
            this.ef = new Hashtable();
            if (i > 0) {
                DW(this.KD, i);
                byte[] bArr = (byte[]) null;
                bArr = (byte[]) null;
                int i3 = i;
                while (i3 > 0) {
                    byte[] tp = this.KD.tp();
                    i3 -= tp.length + 4;
                    byte[] tp2 = this.KD.tp();
                    i3 -= tp2.length + 4;
                    this.ef.put(Util.DW(tp), Util.DW(tp2));
                }
            }
            if (this.ef.get("posix-rename@openssh.com") != null && this.ef.get("posix-rename@openssh.com").equals("1")) {
                this.vJ = true;
            }
            if (this.ef.get("statvfs@openssh.com") != null && this.ef.get("statvfs@openssh.com").equals("2")) {
                this.g3 = true;
            }
            if (this.ef.get("hardlink@openssh.com") != null && this.ef.get("hardlink@openssh.com").equals("1")) {
                this.Mz = true;
            }
            this.aj = new File(".").getCanonicalPath();
        } catch (Throwable e) {
            if (e instanceof JSchException) {
                throw ((JSchException) e);
            } else if (e instanceof Throwable) {
                throw new JSchException(e.toString(), e);
            } else {
                throw new JSchException(e.toString());
            }
        }
    }

    public void DW(String str) {
        try {
            ((MyPipedInputStream) this.Sf).j6();
            String aM = aM(XL(str));
            byte[] J0 = J0(aM);
            SftpATTRS j6 = j6(J0);
            if ((j6.Zo() & 4) == 0) {
                throw new SftpException(4, "Can't change directory: " + aM);
            } else if (j6.Hw()) {
                J8(Util.j6(J0, this.lp));
            } else {
                throw new SftpException(4, "Can't change directory: " + aM);
            }
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    public OutputStream FH(String str) {
        return j6(str, null, 0);
    }

    public OutputStream j6(String str, SftpProgressMonitor sftpProgressMonitor, int i) {
        return j6(str, sftpProgressMonitor, i, 0);
    }

    public OutputStream j6(String str, SftpProgressMonitor sftpProgressMonitor, int i, long j) {
        try {
            ((MyPipedInputStream) this.Sf).j6();
            String aM = aM(XL(str));
            if (tp(aM)) {
                throw new SftpException(4, new StringBuilder(String.valueOf(aM)).append(" is a directory").toString());
            }
            byte[] DW = Util.DW(aM, this.lp);
            long j2 = 0;
            if (i == 1 || i == 2) {
                try {
                    j2 = j6(DW).VH();
                } catch (Exception e) {
                }
            }
            if (i == 0) {
                EQ(DW);
            } else {
                we(DW);
            }
            Header j6 = j6(this.KD, new Header(this));
            int i2 = j6.j6;
            int i3 = j6.DW;
            DW(this.KD, i2);
            if (i3 == 101 || i3 == 102) {
                if (i3 == 101) {
                    j6(this.KD, this.KD.Hw());
                }
                DW = this.KD.tp();
                if (i == 1 || i == 2) {
                    j += j2;
                }
                return new 1(this, DW, new long[]{j}, sftpProgressMonitor);
            }
            throw new SftpException(4, "");
        } catch (Throwable e2) {
            if (e2 instanceof SftpException) {
                throw ((SftpException) e2);
            } else if (e2 instanceof Throwable) {
                throw new SftpException(4, "", e2);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    public InputStream Hw(String str) {
        return j6(str, null, 0);
    }

    public InputStream j6(String str, SftpProgressMonitor sftpProgressMonitor, long j) {
        try {
            ((MyPipedInputStream) this.Sf).j6();
            String aM = aM(XL(str));
            byte[] DW = Util.DW(aM, this.lp);
            SftpATTRS j6 = j6(DW);
            if (sftpProgressMonitor != null) {
                long VH = j6.VH();
                sftpProgressMonitor.j6(1, aM, "??", VH);
            }
            tp(DW);
            Header j62 = j6(this.KD, new Header(this));
            int i = j62.j6;
            int i2 = j62.DW;
            DW(this.KD, i);
            if (i2 == 101 || i2 == 102) {
                if (i2 == 101) {
                    j6(this.KD, this.KD.Hw());
                }
                byte[] tp = this.KD.tp();
                this.br.j6();
                return new 2(this, j, sftpProgressMonitor, tp);
            }
            throw new SftpException(4, "");
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    public Vector v5(String str) {
        Vector vector = new Vector();
        j6(str, new 3(this, vector));
        return vector;
    }

    public void j6(String str, LsEntrySelector lsEntrySelector) {
        try {
            byte[] bArr;
            String j6;
            ((MyPipedInputStream) this.Sf).j6();
            String XL = XL(str);
            byte[] bArr2 = (byte[]) null;
            Vector vector = new Vector();
            int lastIndexOf = XL.lastIndexOf(47);
            String substring = XL.substring(0, lastIndexOf == 0 ? 1 : lastIndexOf);
            String substring2 = XL.substring(lastIndexOf + 1);
            substring = Util.j6(substring);
            byte[][] bArr3 = new byte[1][];
            boolean j62 = j6(substring2, bArr3);
            if (j62) {
                bArr = bArr3[0];
            } else {
                j6 = Util.j6(XL);
                if (EQ(j6).Hw()) {
                    bArr = (byte[]) null;
                    substring = j6;
                } else if (this.OW) {
                    bArr = Util.j6(bArr3[0]);
                } else {
                    bArr = Util.DW(Util.j6(substring2), this.lp);
                }
            }
            VH(Util.DW(substring, this.lp));
            Header j63 = j6(this.KD, new Header(this));
            lastIndexOf = j63.j6;
            int i = j63.DW;
            DW(this.KD, lastIndexOf);
            if (i == 101 || i == 102) {
                if (i == 101) {
                    j6(this.KD, this.KD.Hw());
                }
                lastIndexOf = 0;
                byte[] tp = this.KD.tp();
                while (lastIndexOf == 0) {
                    gn(tp);
                    Header j64 = j6(this.KD, j63);
                    int i2 = j64.j6;
                    int i3 = j64.DW;
                    if (i3 == 101 || i3 == 104) {
                        if (i3 == 101) {
                            DW(this.KD, i2);
                            i3 = this.KD.Hw();
                            if (i3 == 1) {
                                j63 = j64;
                                break;
                            }
                            j6(this.KD, i3);
                        }
                        this.KD.J0();
                        FH(this.KD.DW, 0, 4);
                        int i4 = i2 - 4;
                        i2 = this.KD.Hw();
                        this.KD.EQ();
                        int i5 = i2;
                        i2 = i4;
                        while (i5 > 0) {
                            byte[] tp2;
                            if (i2 > 0) {
                                this.KD.we();
                                if (this.KD.DW.length > this.KD.FH + i2) {
                                    i3 = i2;
                                } else {
                                    i3 = this.KD.DW.length - this.KD.FH;
                                }
                                i3 = FH(this.KD.DW, this.KD.FH, i3);
                                Buffer buffer = this.KD;
                                buffer.FH += i3;
                                i4 = i2 - i3;
                            } else {
                                i4 = i2;
                            }
                            byte[] tp3 = this.KD.tp();
                            bArr2 = (byte[]) null;
                            if (this.dx <= 3) {
                                tp2 = this.KD.tp();
                            } else {
                                tp2 = bArr2;
                            }
                            SftpATTRS j65 = SftpATTRS.j6(this.KD);
                            if (lastIndexOf == 1) {
                                i5--;
                                i2 = i4;
                            } else {
                                boolean z;
                                substring = null;
                                if (bArr == null) {
                                    z = true;
                                } else if (j62) {
                                    byte[] bArr4;
                                    if (this.OW) {
                                        bArr4 = tp3;
                                    } else {
                                        substring2 = Util.j6(tp3, this.lp);
                                        substring = substring2;
                                        bArr4 = Util.DW(substring2, "UTF-8");
                                    }
                                    z = Util.j6(bArr, bArr4);
                                } else {
                                    z = Util.DW(bArr, tp3);
                                }
                                if (z) {
                                    if (substring == null) {
                                        j6 = Util.j6(tp3, this.lp);
                                    } else {
                                        j6 = substring;
                                    }
                                    if (tp2 == null) {
                                        substring = j65.toString() + " " + j6;
                                    } else {
                                        substring = Util.j6(tp2, this.lp);
                                    }
                                    i2 = lsEntrySelector.j6(new LsEntry(this, j6, substring, j65));
                                } else {
                                    i2 = lastIndexOf;
                                }
                                i5--;
                                lastIndexOf = i2;
                                i2 = i4;
                            }
                        }
                        j63 = j64;
                    } else {
                        throw new SftpException(4, "");
                    }
                }
                j6(tp, j63);
                return;
            }
            throw new SftpException(4, "");
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    public void j6(String str, String str2) {
        if (this.dx < 2) {
            throw new SftpException(8, "The remote sshd is too old to support rename operation.");
        }
        try {
            ((MyPipedInputStream) this.Sf).j6();
            String XL = XL(str);
            String XL2 = XL(str2);
            String aM = aM(XL);
            Vector Ws = Ws(XL2);
            int size = Ws.size();
            if (size >= 2) {
                throw new SftpException(4, Ws.toString());
            }
            if (size == 1) {
                XL = (String) Ws.elementAt(0);
            } else if (QX(XL2)) {
                throw new SftpException(4, XL2);
            } else {
                XL = Util.j6(XL2);
            }
            j6(Util.DW(aM, this.lp), Util.DW(XL, this.lp));
            Header j6 = j6(this.KD, new Header(this));
            int i = j6.j6;
            int i2 = j6.DW;
            DW(this.KD, i);
            if (i2 != 101) {
                throw new SftpException(4, "");
            }
            i2 = this.KD.Hw();
            if (i2 != 0) {
                j6(this.KD, i2);
            }
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    public void Zo(String str) {
        try {
            ((MyPipedInputStream) this.Sf).j6();
            Vector Ws = Ws(XL(str));
            int size = Ws.size();
            Header header = new Header(this);
            for (int i = 0; i < size; i++) {
                v5(Util.DW((String) Ws.elementAt(i), this.lp));
                header = j6(this.KD, header);
                int i2 = header.j6;
                int i3 = header.DW;
                DW(this.KD, i2);
                if (i3 != 101) {
                    throw new SftpException(4, "");
                }
                i2 = this.KD.Hw();
                if (i2 != 0) {
                    j6(this.KD, i2);
                }
            }
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    private boolean tp(String str) {
        boolean z = false;
        try {
            FH(Util.DW(str, this.lp));
            Header j6 = j6(this.KD, new Header(this));
            int i = j6.j6;
            int i2 = j6.DW;
            DW(this.KD, i);
            if (i2 == 105) {
                z = SftpATTRS.j6(this.KD).Hw();
            }
        } catch (Exception e) {
        }
        return z;
    }

    public void VH(String str) {
        try {
            ((MyPipedInputStream) this.Sf).j6();
            Vector Ws = Ws(XL(str));
            int size = Ws.size();
            Header header = new Header(this);
            for (int i = 0; i < size; i++) {
                Zo(Util.DW((String) Ws.elementAt(i), this.lp));
                header = j6(this.KD, header);
                int i2 = header.j6;
                int i3 = header.DW;
                DW(this.KD, i2);
                if (i3 != 101) {
                    throw new SftpException(4, "");
                }
                i2 = this.KD.Hw();
                if (i2 != 0) {
                    j6(this.KD, i2);
                }
            }
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    public void gn(String str) {
        try {
            ((MyPipedInputStream) this.Sf).j6();
            j6(Util.DW(XL(str), this.lp), null);
            Header j6 = j6(this.KD, new Header(this));
            int i = j6.j6;
            int i2 = j6.DW;
            DW(this.KD, i);
            if (i2 != 101) {
                throw new SftpException(4, "");
            }
            i2 = this.KD.Hw();
            if (i2 != 0) {
                j6(this.KD, i2);
            }
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    private SftpATTRS j6(byte[] bArr) {
        try {
            FH(bArr);
            Header j6 = j6(this.KD, new Header(this));
            int i = j6.j6;
            int i2 = j6.DW;
            DW(this.KD, i);
            if (i2 == 105) {
                return SftpATTRS.j6(this.KD);
            }
            if (i2 == 101) {
                j6(this.KD, this.KD.Hw());
            }
            throw new SftpException(4, "");
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    private SftpATTRS EQ(String str) {
        return j6(Util.DW(str, this.lp));
    }

    public SftpATTRS u7(String str) {
        try {
            ((MyPipedInputStream) this.Sf).j6();
            return we(aM(XL(str)));
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    private SftpATTRS we(String str) {
        try {
            Hw(Util.DW(str, this.lp));
            Header j6 = j6(this.KD, new Header(this));
            int i = j6.j6;
            int i2 = j6.DW;
            DW(this.KD, i);
            if (i2 == 105) {
                return SftpATTRS.j6(this.KD);
            }
            if (i2 == 101) {
                j6(this.KD, this.KD.Hw());
            }
            throw new SftpException(4, "");
        } catch (Throwable e) {
            if (e instanceof SftpException) {
                throw ((SftpException) e);
            } else if (e instanceof Throwable) {
                throw new SftpException(4, "", e);
            } else {
                throw new SftpException(4, "");
            }
        }
    }

    private byte[] J0(String str) {
        DW(Util.DW(str, this.lp));
        Header j6 = j6(this.KD, new Header(this));
        int i = j6.j6;
        int i2 = j6.DW;
        DW(this.KD, i);
        if (i2 == 101 || i2 == 104) {
            if (i2 == 101) {
                j6(this.KD, this.KD.Hw());
            }
            i = this.KD.Hw();
            byte[] bArr = (byte[]) null;
            while (true) {
                int i3 = i - 1;
                if (i <= 0) {
                    return bArr;
                }
                bArr = this.KD.tp();
                if (this.dx <= 3) {
                    this.KD.tp();
                }
                SftpATTRS.j6(this.KD);
                i = i3;
            }
        } else {
            throw new SftpException(4, "");
        }
    }

    public String XL() {
        return Mr();
    }

    public String j3() {
        if (this.sy == null) {
            try {
                ((MyPipedInputStream) this.Sf).j6();
                this.sy = Util.j6(J0(""), this.lp);
            } catch (Throwable e) {
                if (e instanceof SftpException) {
                    throw ((SftpException) e);
                } else if (e instanceof Throwable) {
                    throw new SftpException(4, "", e);
                } else {
                    throw new SftpException(4, "");
                }
            }
        }
        return this.sy;
    }

    private String Mr() {
        if (this.Qq == null) {
            this.Qq = j3();
        }
        return this.Qq;
    }

    private void J8(String str) {
        this.Qq = str;
    }

    private boolean j6(int[] iArr, Header header) {
        Header j6 = j6(this.KD, header);
        int i = j6.j6;
        int i2 = j6.DW;
        if (iArr != null) {
            iArr[0] = j6.FH;
        }
        DW(this.KD, i);
        if (i2 != 101) {
            throw new SftpException(4, "");
        }
        int Hw = this.KD.Hw();
        if (Hw != 0) {
            j6(this.KD, Hw);
        }
        return true;
    }

    private boolean j6(byte[] bArr, Header header) {
        u7(bArr);
        return j6(null, header);
    }

    private void U2() {
        this.ro.j6();
        j6((byte) 1, 5);
        this.KD.j6(3);
        J0().j6(this.ro, (Channel) this, 9);
    }

    private void DW(byte[] bArr) {
        j6((byte) 16, bArr);
    }

    private void FH(byte[] bArr) {
        j6((byte) 17, bArr);
    }

    private void Hw(byte[] bArr) {
        j6((byte) 7, bArr);
    }

    private void v5(byte[] bArr) {
        j6((byte) 13, bArr);
    }

    private void j6(byte[] bArr, SftpATTRS sftpATTRS) {
        int i = 4;
        this.ro.j6();
        j6((byte) 14, (sftpATTRS != null ? sftpATTRS.FH() : 4) + (bArr.length + 9));
        Buffer buffer = this.KD;
        int i2 = this.nw;
        this.nw = i2 + 1;
        buffer.j6(i2);
        this.KD.DW(bArr);
        if (sftpATTRS != null) {
            sftpATTRS.DW(this.KD);
        } else {
            this.KD.j6(0);
        }
        Session J0 = J0();
        Packet packet = this.ro;
        int length = bArr.length + 9;
        if (sftpATTRS != null) {
            i = sftpATTRS.FH();
        }
        J0.j6(packet, (Channel) this, (i + length) + 4);
    }

    private void Zo(byte[] bArr) {
        j6((byte) 15, bArr);
    }

    private void VH(byte[] bArr) {
        j6((byte) 11, bArr);
    }

    private void gn(byte[] bArr) {
        j6((byte) 12, bArr);
    }

    private void j6(byte[] bArr, byte[] bArr2) {
        j6((byte) 18, bArr, bArr2, this.vJ ? "posix-rename@openssh.com" : null);
    }

    private void u7(byte[] bArr) {
        j6((byte) 4, bArr);
    }

    private void tp(byte[] bArr) {
        j6(bArr, 1);
    }

    private void EQ(byte[] bArr) {
        j6(bArr, 26);
    }

    private void we(byte[] bArr) {
        j6(bArr, 10);
    }

    private void j6(byte[] bArr, int i) {
        this.ro.j6();
        j6((byte) 3, bArr.length + 17);
        Buffer buffer = this.KD;
        int i2 = this.nw;
        this.nw = i2 + 1;
        buffer.j6(i2);
        this.KD.DW(bArr);
        this.KD.j6(i);
        this.KD.j6(0);
        J0().j6(this.ro, (Channel) this, (bArr.length + 17) + 4);
    }

    private void j6(byte b, byte[] bArr) {
        j6(b, bArr, null);
    }

    private void j6(byte b, byte[] bArr, String str) {
        this.ro.j6();
        int length = bArr.length + 9;
        Buffer buffer;
        int i;
        if (str == null) {
            j6(b, length);
            buffer = this.KD;
            i = this.nw;
            this.nw = i + 1;
            buffer.j6(i);
        } else {
            length += str.length() + 4;
            j6((byte) -56, length);
            buffer = this.KD;
            i = this.nw;
            this.nw = i + 1;
            buffer.j6(i);
            this.KD.DW(Util.DW(str));
        }
        this.KD.DW(bArr);
        J0().j6(this.ro, (Channel) this, length + 4);
    }

    private void j6(byte b, byte[] bArr, byte[] bArr2, String str) {
        this.ro.j6();
        int length = (bArr.length + 13) + bArr2.length;
        Buffer buffer;
        int i;
        if (str == null) {
            j6(b, length);
            buffer = this.KD;
            i = this.nw;
            this.nw = i + 1;
            buffer.j6(i);
        } else {
            length += str.length() + 4;
            j6((byte) -56, length);
            buffer = this.KD;
            i = this.nw;
            this.nw = i + 1;
            buffer.j6(i);
            this.KD.DW(Util.DW(str));
        }
        this.KD.DW(bArr);
        this.KD.DW(bArr2);
        J0().j6(this.ro, (Channel) this, length + 4);
    }

    private int j6(byte[] bArr, long j, byte[] bArr2, int i, int i2) {
        this.sh.j6();
        if (this.cn.DW.length < ((((this.cn.FH + 13) + 21) + bArr.length) + i2) + 84) {
            i2 = this.cn.DW.length - ((((this.cn.FH + 13) + 21) + bArr.length) + 84);
        }
        j6(this.cn, (byte) 6, (bArr.length + 21) + i2);
        Buffer buffer = this.cn;
        int i3 = this.nw;
        this.nw = i3 + 1;
        buffer.j6(i3);
        this.cn.DW(bArr);
        this.cn.j6(j);
        if (this.cn.DW != bArr2) {
            this.cn.DW(bArr2, i, i2);
        } else {
            this.cn.j6(i2);
            this.cn.DW(i2);
        }
        J0().j6(this.sh, (Channel) this, ((bArr.length + 21) + i2) + 4);
        return i2;
    }

    private void j6(byte[] bArr, long j, int i, RequestQueue requestQueue) {
        this.ro.j6();
        j6((byte) 5, bArr.length + 21);
        Buffer buffer = this.KD;
        int i2 = this.nw;
        this.nw = i2 + 1;
        buffer.j6(i2);
        this.KD.DW(bArr);
        this.KD.j6(j);
        this.KD.j6(i);
        J0().j6(this.ro, (Channel) this, (bArr.length + 21) + 4);
        if (requestQueue != null) {
            requestQueue.j6(this.nw - 1, j, i);
        }
    }

    private void j6(Buffer buffer, byte b, int i) {
        buffer.j6((byte) 94);
        buffer.j6(this.FH);
        buffer.j6(i + 4);
        buffer.j6(i);
        buffer.j6(b);
    }

    private void j6(byte b, int i) {
        j6(this.KD, b, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Vector Ws(java.lang.String r13) {
        /*
        r12 = this;
        r7 = new java.util.Vector;
        r7.<init>();
        r0 = 47;
        r1 = r13.lastIndexOf(r0);
        if (r1 >= 0) goto L_0x0016;
    L_0x000d:
        r0 = com.jcraft.jsch.Util.j6(r13);
        r7.addElement(r0);
        r0 = r7;
    L_0x0015:
        return r0;
    L_0x0016:
        r2 = 0;
        if (r1 != 0) goto L_0x006b;
    L_0x0019:
        r0 = 1;
    L_0x001a:
        r0 = r13.substring(r2, r0);
        r1 = r1 + 1;
        r2 = r13.substring(r1);
        r1 = com.jcraft.jsch.Util.j6(r0);
        r0 = 0;
        r0 = (byte[]) r0;
        r0 = 1;
        r0 = new byte[r0][];
        r3 = r12.j6(r2, r0);
        if (r3 != 0) goto L_0x006d;
    L_0x0034:
        r0 = "/";
        r0 = r1.equals(r0);
        if (r0 != 0) goto L_0x01b3;
    L_0x003d:
        r0 = new java.lang.StringBuilder;
        r1 = java.lang.String.valueOf(r1);
        r0.<init>(r1);
        r1 = "/";
        r0 = r0.append(r1);
        r0 = r0.toString();
    L_0x0051:
        r1 = new java.lang.StringBuilder;
        r0 = java.lang.String.valueOf(r0);
        r1.<init>(r0);
        r0 = com.jcraft.jsch.Util.j6(r2);
        r0 = r1.append(r0);
        r0 = r0.toString();
        r7.addElement(r0);
        r0 = r7;
        goto L_0x0015;
    L_0x006b:
        r0 = r1;
        goto L_0x001a;
    L_0x006d:
        r2 = 0;
        r9 = r0[r2];
        r0 = r12.lp;
        r0 = com.jcraft.jsch.Util.DW(r1, r0);
        r12.VH(r0);
        r0 = new com.jcraft.jsch.ChannelSftp$Header;
        r0.<init>(r12);
        r2 = r12.KD;
        r2 = r12.j6(r2, r0);
        r0 = r2.j6;
        r3 = r2.DW;
        r4 = r12.KD;
        r12.DW(r4, r0);
        r0 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r3 == r0) goto L_0x009f;
    L_0x0091:
        r0 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r3 == r0) goto L_0x009f;
    L_0x0095:
        r0 = new com.jcraft.jsch.SftpException;
        r1 = 4;
        r2 = "";
        r0.<init>(r1, r2);
        throw r0;
    L_0x009f:
        r0 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r3 != r0) goto L_0x00ae;
    L_0x00a3:
        r0 = r12.KD;
        r0 = r0.Hw();
        r3 = r12.KD;
        r12.j6(r3, r0);
    L_0x00ae:
        r0 = r12.KD;
        r10 = r0.tp();
        r0 = 0;
    L_0x00b5:
        r12.gn(r10);
        r3 = r12.KD;
        r4 = r12.j6(r3, r2);
        r2 = r4.j6;
        r3 = r4.DW;
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r3 == r5) goto L_0x00d4;
    L_0x00c6:
        r5 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        if (r3 == r5) goto L_0x00d4;
    L_0x00ca:
        r0 = new com.jcraft.jsch.SftpException;
        r1 = 4;
        r2 = "";
        r0.<init>(r1, r2);
        throw r0;
    L_0x00d4:
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r3 != r5) goto L_0x00e6;
    L_0x00d8:
        r0 = r12.KD;
        r12.DW(r0, r2);
        r0 = r12.j6(r10, r4);
        if (r0 == 0) goto L_0x01ac;
    L_0x00e3:
        r0 = r7;
        goto L_0x0015;
    L_0x00e6:
        r3 = r12.KD;
        r3.J0();
        r3 = r12.KD;
        r3 = r3.DW;
        r5 = 0;
        r6 = 4;
        r12.FH(r3, r5, r6);
        r3 = r2 + -4;
        r2 = r12.KD;
        r2 = r2.Hw();
        r5 = r12.KD;
        r5.EQ();
        r8 = r2;
    L_0x0102:
        if (r8 > 0) goto L_0x0106;
    L_0x0104:
        r2 = r4;
        goto L_0x00b5;
    L_0x0106:
        if (r3 <= 0) goto L_0x013f;
    L_0x0108:
        r2 = r12.KD;
        r2.we();
        r2 = r12.KD;
        r2 = r2.DW;
        r2 = r2.length;
        r5 = r12.KD;
        r5 = r5.FH;
        r5 = r5 + r3;
        if (r2 <= r5) goto L_0x012c;
    L_0x0119:
        r2 = r3;
    L_0x011a:
        r5 = r12.Sf;
        r6 = r12.KD;
        r6 = r6.DW;
        r11 = r12.KD;
        r11 = r11.FH;
        r2 = r5.read(r6, r11, r2);
        if (r2 > 0) goto L_0x0137;
    L_0x012a:
        r2 = r4;
        goto L_0x00b5;
    L_0x012c:
        r2 = r12.KD;
        r2 = r2.DW;
        r2 = r2.length;
        r5 = r12.KD;
        r5 = r5.FH;
        r2 = r2 - r5;
        goto L_0x011a;
    L_0x0137:
        r5 = r12.KD;
        r6 = r5.FH;
        r6 = r6 + r2;
        r5.FH = r6;
        r3 = r3 - r2;
    L_0x013f:
        r2 = r12.KD;
        r6 = r2.tp();
        r2 = r12.dx;
        r5 = 3;
        if (r2 > r5) goto L_0x014f;
    L_0x014a:
        r2 = r12.KD;
        r2.tp();
    L_0x014f:
        r2 = r12.KD;
        com.jcraft.jsch.SftpATTRS.j6(r2);
        r2 = 0;
        r5 = r12.OW;
        if (r5 != 0) goto L_0x01af;
    L_0x0159:
        r2 = r12.lp;
        r2 = com.jcraft.jsch.Util.j6(r6, r2);
        r5 = "UTF-8";
        r5 = com.jcraft.jsch.Util.DW(r2, r5);
    L_0x0166:
        r5 = com.jcraft.jsch.Util.j6(r9, r5);
        if (r5 == 0) goto L_0x01a7;
    L_0x016c:
        if (r2 != 0) goto L_0x0174;
    L_0x016e:
        r2 = r12.lp;
        r2 = com.jcraft.jsch.Util.j6(r6, r2);
    L_0x0174:
        if (r0 != 0) goto L_0x0193;
    L_0x0176:
        r0 = "/";
        r0 = r1.endsWith(r0);
        if (r0 != 0) goto L_0x01b1;
    L_0x017f:
        r0 = new java.lang.StringBuilder;
        r5 = java.lang.String.valueOf(r1);
        r0.<init>(r5);
        r5 = "/";
        r0 = r0.append(r5);
        r0 = r0.toString();
    L_0x0193:
        r5 = new java.lang.StringBuilder;
        r6 = java.lang.String.valueOf(r0);
        r5.<init>(r6);
        r2 = r5.append(r2);
        r2 = r2.toString();
        r7.addElement(r2);
    L_0x01a7:
        r2 = r8 + -1;
        r8 = r2;
        goto L_0x0102;
    L_0x01ac:
        r0 = 0;
        goto L_0x0015;
    L_0x01af:
        r5 = r6;
        goto L_0x0166;
    L_0x01b1:
        r0 = r1;
        goto L_0x0193;
    L_0x01b3:
        r0 = r1;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.ChannelSftp.Ws(java.lang.String):java.util.Vector");
    }

    private boolean J0(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            if (bArr[i] == 42 || bArr[i] == 63) {
                return true;
            }
            if (bArr[i] == 92 && i + 1 < length) {
                i++;
            }
            i++;
        }
        return false;
    }

    private void j6(Buffer buffer, int i) {
        if (this.dx < 3 || buffer.j6() < 4) {
            throw new SftpException(i, "Failure");
        }
        throw new SftpException(i, Util.j6(buffer.tp(), "UTF-8"));
    }

    public void tp() {
        super.tp();
    }

    private boolean j6(String str, byte[][] bArr) {
        byte[] DW = Util.DW(str, "UTF-8");
        if (bArr != null) {
            bArr[0] = DW;
        }
        return J0(DW);
    }

    private boolean QX(String str) {
        return j6(str, null);
    }

    private void DW(Buffer buffer, int i) {
        buffer.EQ();
        FH(buffer.DW, 0, i);
        buffer.DW(i);
    }

    private int FH(byte[] bArr, int i, int i2) {
        int i3 = i;
        while (i2 > 0) {
            int read = this.Sf.read(bArr, i3, i2);
            if (read <= 0) {
                throw new IOException("inputstream is closed");
            }
            i3 += read;
            i2 -= read;
        }
        return i3 - i;
    }

    private void FH(long j) {
        while (j > 0) {
            long skip = this.Sf.skip(j);
            if (skip > 0) {
                j -= skip;
            } else {
                return;
            }
        }
    }

    private Header j6(Buffer buffer, Header header) {
        buffer.J0();
        FH(buffer.DW, 0, 9);
        header.j6 = buffer.Hw() - 5;
        header.DW = buffer.VH() & 255;
        header.FH = buffer.Hw();
        return header;
    }

    private String XL(String str) {
        if (str.charAt(0) == '/') {
            return str;
        }
        String Mr = Mr();
        if (Mr.endsWith("/")) {
            return new StringBuilder(String.valueOf(Mr)).append(str).toString();
        }
        return new StringBuilder(String.valueOf(Mr)).append("/").append(str).toString();
    }

    private String aM(String str) {
        Vector Ws = Ws(str);
        if (Ws.size() == 1) {
            return (String) Ws.elementAt(0);
        }
        throw new SftpException(4, new StringBuilder(String.valueOf(str)).append(" is not unique: ").append(Ws.toString()).toString());
    }
}
