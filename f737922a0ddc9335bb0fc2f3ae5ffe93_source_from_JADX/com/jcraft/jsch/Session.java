package com.jcraft.jsch;

import com.jcraft.jsch.ConfigRepository.Config;
import com.jcraft.jsch.IdentityRepository.Wrapper;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Vector;

public class Session implements Runnable {
    private static final byte[] Eq;
    private static final byte[] Xa;
    static Random Zo;
    private byte[] BT;
    private GlobalRequestReply CU;
    boolean DW;
    int EQ;
    boolean FH;
    InputStream Hw;
    private volatile boolean I;
    String J0;
    String J8;
    private int KD;
    int[] Mr;
    private int Mz;
    private String OW;
    private byte[] P8;
    String QX;
    private Object Qq;
    private int SI;
    private Compression Sf;
    Runnable U2;
    Buffer VH;
    int Ws;
    private long XG;
    byte[] XL;
    private int XX;
    private byte[] a8;
    JSch aM;
    private Proxy aj;
    private int br;
    private boolean ca;
    private MAC cb;
    private Cipher cn;
    private byte[] dx;
    private Compression ef;
    private byte[] ei;
    private byte[] er;
    private int et;
    private Socket g3;
    private byte[] gW;
    Packet gn;
    private HostKey hz;
    int[] j3;
    String[] j6;
    private boolean jJ;
    private IdentityRepository kQ;
    private byte[] lg;
    private UserInfo lp;
    private byte[] nw;
    private byte[] rN;
    private Cipher ro;
    private byte[] sG;
    private MAC sh;
    private Hashtable sy;
    protected boolean tp;
    SocketFactory u7;
    OutputStream v5;
    private IO vJ;
    private byte[] vy;
    private int wc;
    int we;
    private Thread x9;
    private HostKeyRepository yO;
    private byte[] yS;

    private class Forwarding {
        int DW;
        String FH;
        int Hw;
        String j6;
        final /* synthetic */ Session v5;

        private Forwarding(Session session) {
            this.v5 = session;
            this.j6 = null;
            this.DW = -1;
            this.FH = null;
            this.Hw = -1;
        }
    }

    private class GlobalRequestReply {
        private Thread DW;
        private int FH;
        private int Hw;
        final /* synthetic */ Session j6;

        private GlobalRequestReply(Session session) {
            this.j6 = session;
            this.DW = null;
            this.FH = -1;
            this.Hw = 0;
        }

        void j6(Thread thread) {
            this.DW = thread;
            this.FH = -1;
        }

        Thread j6() {
            return this.DW;
        }

        void j6(int i) {
            this.FH = i;
        }

        int DW() {
            return this.FH;
        }

        int FH() {
            return this.Hw;
        }

        void DW(int i) {
            this.Hw = i;
        }
    }

    Session(JSch jSch, String str, String str2, int i) {
        this.lg = Util.DW("SSH-2.0-JSCH-0.1.51");
        this.SI = 0;
        this.KD = 0;
        this.j6 = null;
        this.Mz = 0;
        this.I = false;
        this.ca = false;
        this.x9 = null;
        this.Qq = new Object();
        this.DW = false;
        this.FH = false;
        this.Hw = null;
        this.v5 = null;
        this.u7 = null;
        this.sy = null;
        this.aj = null;
        this.OW = null;
        this.br = 0;
        this.XX = 1;
        this.kQ = null;
        this.yO = null;
        this.tp = false;
        this.XG = 0;
        this.EQ = 6;
        this.we = 0;
        this.J0 = "127.0.0.1";
        this.J8 = "127.0.0.1";
        this.Ws = 22;
        this.QX = null;
        this.XL = null;
        this.jJ = false;
        this.j3 = new int[1];
        this.Mr = new int[1];
        this.wc = 8;
        this.et = 8;
        this.CU = new GlobalRequestReply();
        this.hz = null;
        this.aM = jSch;
        this.VH = new Buffer();
        this.gn = new Packet(this.VH);
        this.QX = str;
        this.J0 = str2;
        this.J8 = str2;
        this.Ws = i;
        J8();
        if (this.QX == null) {
            try {
                this.QX = (String) System.getProperties().get("user.name");
            } catch (SecurityException e) {
            }
        }
        if (this.QX == null) {
            throw new JSchException("username is not given.");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(int r14) {
        /*
        r13 = this;
        r0 = r13.I;
        if (r0 == 0) goto L_0x000d;
    L_0x0004:
        r0 = new com.jcraft.jsch.JSchException;
        r1 = "session is already connected";
        r0.<init>(r1);
        throw r0;
    L_0x000d:
        r0 = new com.jcraft.jsch.IO;
        r0.<init>();
        r13.vJ = r0;
        r0 = Zo;
        if (r0 != 0) goto L_0x002b;
    L_0x0018:
        r0 = "random";
        r0 = r13.v5(r0);	 Catch:{ Exception -> 0x014c }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x014c }
        r0 = r0.newInstance();	 Catch:{ Exception -> 0x014c }
        r0 = (com.jcraft.jsch.Random) r0;	 Catch:{ Exception -> 0x014c }
        Zo = r0;	 Catch:{ Exception -> 0x014c }
    L_0x002b:
        r0 = Zo;
        com.jcraft.jsch.Packet.j6(r0);
        r0 = com.jcraft.jsch.JSch.v5();
        r1 = 1;
        r0 = r0.j6(r1);
        if (r0 == 0) goto L_0x0062;
    L_0x003b:
        r0 = com.jcraft.jsch.JSch.v5();
        r1 = 1;
        r2 = new java.lang.StringBuilder;
        r3 = "Connecting to ";
        r2.<init>(r3);
        r3 = r13.J0;
        r2 = r2.append(r3);
        r3 = " port ";
        r2 = r2.append(r3);
        r3 = r13.Ws;
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.j6(r1, r2);
    L_0x0062:
        r0 = r13.aj;	 Catch:{ Exception -> 0x00ef }
        if (r0 != 0) goto L_0x0175;
    L_0x0066:
        r0 = r13.u7;	 Catch:{ Exception -> 0x00ef }
        if (r0 != 0) goto L_0x0157;
    L_0x006a:
        r0 = r13.J0;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.Ws;	 Catch:{ Exception -> 0x00ef }
        r0 = com.jcraft.jsch.Util.j6(r0, r1, r14);	 Catch:{ Exception -> 0x00ef }
        r13.g3 = r0;	 Catch:{ Exception -> 0x00ef }
        r0 = r13.g3;	 Catch:{ Exception -> 0x00ef }
        r1 = r0.getInputStream();	 Catch:{ Exception -> 0x00ef }
        r0 = r13.g3;	 Catch:{ Exception -> 0x00ef }
        r0 = r0.getOutputStream();	 Catch:{ Exception -> 0x00ef }
    L_0x0080:
        r2 = r13.g3;	 Catch:{ Exception -> 0x00ef }
        r3 = 1;
        r2.setTcpNoDelay(r3);	 Catch:{ Exception -> 0x00ef }
        r2 = r13.vJ;	 Catch:{ Exception -> 0x00ef }
        r2.j6(r1);	 Catch:{ Exception -> 0x00ef }
        r1 = r13.vJ;	 Catch:{ Exception -> 0x00ef }
        r1.j6(r0);	 Catch:{ Exception -> 0x00ef }
    L_0x0090:
        if (r14 <= 0) goto L_0x009b;
    L_0x0092:
        r0 = r13.g3;	 Catch:{ Exception -> 0x00ef }
        if (r0 == 0) goto L_0x009b;
    L_0x0096:
        r0 = r13.g3;	 Catch:{ Exception -> 0x00ef }
        r0.setSoTimeout(r14);	 Catch:{ Exception -> 0x00ef }
    L_0x009b:
        r0 = 1;
        r13.I = r0;	 Catch:{ Exception -> 0x00ef }
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r1 = 1;
        r0 = r0.j6(r1);	 Catch:{ Exception -> 0x00ef }
        if (r0 == 0) goto L_0x00b4;
    L_0x00a9:
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r1 = 1;
        r2 = "Connection established";
        r0.j6(r1, r2);	 Catch:{ Exception -> 0x00ef }
    L_0x00b4:
        r0 = r13.aM;	 Catch:{ Exception -> 0x00ef }
        r0.j6(r13);	 Catch:{ Exception -> 0x00ef }
        r0 = r13.lg;	 Catch:{ Exception -> 0x00ef }
        r0 = r0.length;	 Catch:{ Exception -> 0x00ef }
        r0 = r0 + 1;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x00ef }
        r1 = r13.lg;	 Catch:{ Exception -> 0x00ef }
        r2 = 0;
        r3 = 0;
        r4 = r13.lg;	 Catch:{ Exception -> 0x00ef }
        r4 = r4.length;	 Catch:{ Exception -> 0x00ef }
        java.lang.System.arraycopy(r1, r2, r0, r3, r4);	 Catch:{ Exception -> 0x00ef }
        r1 = r0.length;	 Catch:{ Exception -> 0x00ef }
        r1 = r1 + -1;
        r2 = 10;
        r0[r1] = r2;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.vJ;	 Catch:{ Exception -> 0x00ef }
        r2 = 0;
        r3 = r0.length;	 Catch:{ Exception -> 0x00ef }
        r1.j6(r0, r2, r3);	 Catch:{ Exception -> 0x00ef }
    L_0x00d8:
        r1 = 0;
        r0 = 0;
    L_0x00da:
        r2 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r2 = r2.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = r2.length;	 Catch:{ Exception -> 0x00ef }
        if (r1 < r2) goto L_0x01a7;
    L_0x00e1:
        r12 = r0;
        r0 = r1;
        r1 = r12;
    L_0x00e4:
        if (r1 >= 0) goto L_0x01c6;
    L_0x00e6:
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r1 = "connection is closed by foreign host";
        r0.<init>(r1);	 Catch:{ Exception -> 0x00ef }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x00ef:
        r0 = move-exception;
        r1 = 0;
        r13.jJ = r1;	 Catch:{ all -> 0x0142 }
        r1 = r13.I;	 Catch:{ Exception -> 0x0641 }
        if (r1 == 0) goto L_0x0135;
    L_0x00f7:
        r1 = r0.toString();	 Catch:{ Exception -> 0x0641 }
        r2 = r13.gn;	 Catch:{ Exception -> 0x0641 }
        r2.j6();	 Catch:{ Exception -> 0x0641 }
        r2 = r13.VH;	 Catch:{ Exception -> 0x0641 }
        r3 = r1.length();	 Catch:{ Exception -> 0x0641 }
        r3 = r3 + 13;
        r3 = r3 + 2;
        r3 = r3 + 84;
        r2.v5(r3);	 Catch:{ Exception -> 0x0641 }
        r2 = r13.VH;	 Catch:{ Exception -> 0x0641 }
        r3 = 1;
        r2.j6(r3);	 Catch:{ Exception -> 0x0641 }
        r2 = r13.VH;	 Catch:{ Exception -> 0x0641 }
        r3 = 3;
        r2.j6(r3);	 Catch:{ Exception -> 0x0641 }
        r2 = r13.VH;	 Catch:{ Exception -> 0x0641 }
        r1 = com.jcraft.jsch.Util.DW(r1);	 Catch:{ Exception -> 0x0641 }
        r2.DW(r1);	 Catch:{ Exception -> 0x0641 }
        r1 = r13.VH;	 Catch:{ Exception -> 0x0641 }
        r2 = "en";
        r2 = com.jcraft.jsch.Util.DW(r2);	 Catch:{ Exception -> 0x0641 }
        r1.DW(r2);	 Catch:{ Exception -> 0x0641 }
        r1 = r13.gn;	 Catch:{ Exception -> 0x0641 }
        r13.DW(r1);	 Catch:{ Exception -> 0x0641 }
    L_0x0135:
        r13.DW();	 Catch:{ Exception -> 0x063e }
    L_0x0138:
        r1 = 0;
        r13.I = r1;	 Catch:{ all -> 0x0142 }
        r1 = r0 instanceof java.lang.RuntimeException;	 Catch:{ all -> 0x0142 }
        if (r1 == 0) goto L_0x062e;
    L_0x013f:
        r0 = (java.lang.RuntimeException) r0;	 Catch:{ all -> 0x0142 }
        throw r0;	 Catch:{ all -> 0x0142 }
    L_0x0142:
        r0 = move-exception;
        r1 = r13.XL;
        com.jcraft.jsch.Util.Hw(r1);
        r1 = 0;
        r13.XL = r1;
        throw r0;
    L_0x014c:
        r0 = move-exception;
        r1 = new com.jcraft.jsch.JSchException;
        r2 = r0.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x0157:
        r0 = r13.u7;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.J0;	 Catch:{ Exception -> 0x00ef }
        r2 = r13.Ws;	 Catch:{ Exception -> 0x00ef }
        r0 = r0.j6(r1, r2);	 Catch:{ Exception -> 0x00ef }
        r13.g3 = r0;	 Catch:{ Exception -> 0x00ef }
        r0 = r13.u7;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.g3;	 Catch:{ Exception -> 0x00ef }
        r1 = r0.j6(r1);	 Catch:{ Exception -> 0x00ef }
        r0 = r13.u7;	 Catch:{ Exception -> 0x00ef }
        r2 = r13.g3;	 Catch:{ Exception -> 0x00ef }
        r0 = r0.DW(r2);	 Catch:{ Exception -> 0x00ef }
        goto L_0x0080;
    L_0x0175:
        r1 = r13.aj;	 Catch:{ Exception -> 0x00ef }
        monitor-enter(r1);	 Catch:{ Exception -> 0x00ef }
        r0 = r13.aj;	 Catch:{ all -> 0x01a4 }
        r2 = r13.u7;	 Catch:{ all -> 0x01a4 }
        r3 = r13.J0;	 Catch:{ all -> 0x01a4 }
        r4 = r13.Ws;	 Catch:{ all -> 0x01a4 }
        r0.j6(r2, r3, r4, r14);	 Catch:{ all -> 0x01a4 }
        r0 = r13.vJ;	 Catch:{ all -> 0x01a4 }
        r2 = r13.aj;	 Catch:{ all -> 0x01a4 }
        r2 = r2.j6();	 Catch:{ all -> 0x01a4 }
        r0.j6(r2);	 Catch:{ all -> 0x01a4 }
        r0 = r13.vJ;	 Catch:{ all -> 0x01a4 }
        r2 = r13.aj;	 Catch:{ all -> 0x01a4 }
        r2 = r2.DW();	 Catch:{ all -> 0x01a4 }
        r0.j6(r2);	 Catch:{ all -> 0x01a4 }
        r0 = r13.aj;	 Catch:{ all -> 0x01a4 }
        r0 = r0.FH();	 Catch:{ all -> 0x01a4 }
        r13.g3 = r0;	 Catch:{ all -> 0x01a4 }
        monitor-exit(r1);	 Catch:{ all -> 0x01a4 }
        goto L_0x0090;
    L_0x01a4:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01a4 }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x01a7:
        r0 = r13.vJ;	 Catch:{ Exception -> 0x00ef }
        r0 = r0.j6();	 Catch:{ Exception -> 0x00ef }
        if (r0 >= 0) goto L_0x01b4;
    L_0x01af:
        r12 = r0;
        r0 = r1;
        r1 = r12;
        goto L_0x00e4;
    L_0x01b4:
        r2 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r2 = r2.DW;	 Catch:{ Exception -> 0x00ef }
        r3 = (byte) r0;	 Catch:{ Exception -> 0x00ef }
        r2[r1] = r3;	 Catch:{ Exception -> 0x00ef }
        r1 = r1 + 1;
        r2 = 10;
        if (r0 != r2) goto L_0x00da;
    L_0x01c1:
        r12 = r0;
        r0 = r1;
        r1 = r12;
        goto L_0x00e4;
    L_0x01c6:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = r0 + -1;
        r1 = r1[r2];	 Catch:{ Exception -> 0x00ef }
        r2 = 10;
        if (r1 != r2) goto L_0x01e4;
    L_0x01d2:
        r0 = r0 + -1;
        if (r0 <= 0) goto L_0x01e4;
    L_0x01d6:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = r0 + -1;
        r1 = r1[r2];	 Catch:{ Exception -> 0x00ef }
        r2 = 13;
        if (r1 != r2) goto L_0x01e4;
    L_0x01e2:
        r0 = r0 + -1;
    L_0x01e4:
        r1 = 3;
        if (r0 <= r1) goto L_0x00d8;
    L_0x01e7:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.length;	 Catch:{ Exception -> 0x00ef }
        if (r0 == r1) goto L_0x021a;
    L_0x01ee:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = 0;
        r1 = r1[r2];	 Catch:{ Exception -> 0x00ef }
        r2 = 83;
        if (r1 != r2) goto L_0x00d8;
    L_0x01f9:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = 1;
        r1 = r1[r2];	 Catch:{ Exception -> 0x00ef }
        r2 = 83;
        if (r1 != r2) goto L_0x00d8;
    L_0x0204:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = 2;
        r1 = r1[r2];	 Catch:{ Exception -> 0x00ef }
        r2 = 72;
        if (r1 != r2) goto L_0x00d8;
    L_0x020f:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = 3;
        r1 = r1[r2];	 Catch:{ Exception -> 0x00ef }
        r2 = 45;
        if (r1 != r2) goto L_0x00d8;
    L_0x021a:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.length;	 Catch:{ Exception -> 0x00ef }
        if (r0 == r1) goto L_0x023a;
    L_0x0221:
        r1 = 7;
        if (r0 < r1) goto L_0x023a;
    L_0x0224:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = 4;
        r1 = r1[r2];	 Catch:{ Exception -> 0x00ef }
        r2 = 49;
        if (r1 != r2) goto L_0x0243;
    L_0x022f:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = 6;
        r1 = r1[r2];	 Catch:{ Exception -> 0x00ef }
        r2 = 57;
        if (r1 == r2) goto L_0x0243;
    L_0x023a:
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r1 = "invalid server's version string";
        r0.<init>(r1);	 Catch:{ Exception -> 0x00ef }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x0243:
        r1 = new byte[r0];	 Catch:{ Exception -> 0x00ef }
        r13.a8 = r1;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.DW;	 Catch:{ Exception -> 0x00ef }
        r2 = 0;
        r3 = r13.a8;	 Catch:{ Exception -> 0x00ef }
        r4 = 0;
        java.lang.System.arraycopy(r1, r2, r3, r4, r0);	 Catch:{ Exception -> 0x00ef }
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r1 = 1;
        r0 = r0.j6(r1);	 Catch:{ Exception -> 0x00ef }
        if (r0 == 0) goto L_0x0299;
    L_0x025d:
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r1 = 1;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r3 = "Remote version string: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ef }
        r3 = r13.a8;	 Catch:{ Exception -> 0x00ef }
        r3 = com.jcraft.jsch.Util.DW(r3);	 Catch:{ Exception -> 0x00ef }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00ef }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ef }
        r0.j6(r1, r2);	 Catch:{ Exception -> 0x00ef }
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r1 = 1;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r3 = "Local version string: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ef }
        r3 = r13.lg;	 Catch:{ Exception -> 0x00ef }
        r3 = com.jcraft.jsch.Util.DW(r3);	 Catch:{ Exception -> 0x00ef }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00ef }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ef }
        r0.j6(r1, r2);	 Catch:{ Exception -> 0x00ef }
    L_0x0299:
        r13.we();	 Catch:{ Exception -> 0x00ef }
        r0 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r0 = r13.j6(r0);	 Catch:{ Exception -> 0x00ef }
        r13.VH = r0;	 Catch:{ Exception -> 0x00ef }
        r0 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r0 = r0.J8();	 Catch:{ Exception -> 0x00ef }
        r1 = 20;
        if (r0 == r1) goto L_0x02cd;
    L_0x02ae:
        r0 = 0;
        r13.jJ = r0;	 Catch:{ Exception -> 0x00ef }
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r2 = "invalid protocol: ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00ef }
        r2 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r2 = r2.J8();	 Catch:{ Exception -> 0x00ef }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ef }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00ef }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00ef }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x02cd:
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r1 = 1;
        r0 = r0.j6(r1);	 Catch:{ Exception -> 0x00ef }
        if (r0 == 0) goto L_0x02e3;
    L_0x02d8:
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r1 = 1;
        r2 = "SSH_MSG_KEXINIT received";
        r0.j6(r1, r2);	 Catch:{ Exception -> 0x00ef }
    L_0x02e3:
        r0 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r0 = r13.DW(r0);	 Catch:{ Exception -> 0x00ef }
    L_0x02e9:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.j6(r1);	 Catch:{ Exception -> 0x00ef }
        r13.VH = r1;	 Catch:{ Exception -> 0x00ef }
        r1 = r0.DW();	 Catch:{ Exception -> 0x00ef }
        r2 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r2 = r2.J8();	 Catch:{ Exception -> 0x00ef }
        if (r1 != r2) goto L_0x0324;
    L_0x02fd:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00ef }
        r13.XG = r2;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r0.j6(r1);	 Catch:{ Exception -> 0x00ef }
        if (r1 != 0) goto L_0x0343;
    L_0x030b:
        r0 = 0;
        r13.jJ = r0;	 Catch:{ Exception -> 0x00ef }
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r3 = "verify: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ef }
        r1 = r2.append(r1);	 Catch:{ Exception -> 0x00ef }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00ef }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00ef }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x0324:
        r0 = 0;
        r13.jJ = r0;	 Catch:{ Exception -> 0x00ef }
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r2 = "invalid protocol(kex): ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00ef }
        r2 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r2 = r2.J8();	 Catch:{ Exception -> 0x00ef }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ef }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00ef }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00ef }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x0343:
        r1 = r0.DW();	 Catch:{ Exception -> 0x00ef }
        if (r1 != 0) goto L_0x02e9;
    L_0x0349:
        r1 = r13.J0;	 Catch:{ JSchException -> 0x040e }
        r2 = r13.Ws;	 Catch:{ JSchException -> 0x040e }
        r13.j6(r1, r2, r0);	 Catch:{ JSchException -> 0x040e }
        r13.J0();	 Catch:{ Exception -> 0x00ef }
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.j6(r1);	 Catch:{ Exception -> 0x00ef }
        r13.VH = r1;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r1 = r1.J8();	 Catch:{ Exception -> 0x00ef }
        r2 = 21;
        if (r1 != r2) goto L_0x0413;
    L_0x0365:
        r1 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r2 = 1;
        r1 = r1.j6(r2);	 Catch:{ Exception -> 0x00ef }
        if (r1 == 0) goto L_0x037b;
    L_0x0370:
        r1 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r2 = 1;
        r3 = "SSH_MSG_NEWKEYS received";
        r1.j6(r2, r3);	 Catch:{ Exception -> 0x00ef }
    L_0x037b:
        r1 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r13.j6(r1, r0);	 Catch:{ Exception -> 0x00ef }
        r0 = "MaxAuthTries";
        r0 = r13.v5(r0);	 Catch:{ NumberFormatException -> 0x0432 }
        if (r0 == 0) goto L_0x038f;
    L_0x0389:
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0432 }
        r13.EQ = r0;	 Catch:{ NumberFormatException -> 0x0432 }
    L_0x038f:
        r3 = 0;
        r0 = "userauth.none";
        r0 = r13.v5(r0);	 Catch:{ Exception -> 0x0450 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0450 }
        r0 = r0.newInstance();	 Catch:{ Exception -> 0x0450 }
        r0 = (com.jcraft.jsch.UserAuth) r0;	 Catch:{ Exception -> 0x0450 }
        r4 = r0.j6(r13);	 Catch:{ Exception -> 0x00ef }
        r1 = "PreferredAuthentications";
        r2 = r13.v5(r1);	 Catch:{ Exception -> 0x00ef }
        r1 = ",";
        r7 = com.jcraft.jsch.Util.j6(r2, r1);	 Catch:{ Exception -> 0x00ef }
        r1 = 0;
        if (r4 != 0) goto L_0x065f;
    L_0x03b6:
        r0 = (com.jcraft.jsch.UserAuthNone) r0;	 Catch:{ Exception -> 0x00ef }
        r0 = r0.j6();	 Catch:{ Exception -> 0x00ef }
        if (r0 == 0) goto L_0x03c2;
    L_0x03be:
        r2 = r0.toLowerCase();	 Catch:{ Exception -> 0x00ef }
    L_0x03c2:
        r0 = ",";
        r0 = com.jcraft.jsch.Util.j6(r2, r0);	 Catch:{ Exception -> 0x00ef }
        r1 = 0;
        r5 = r0;
        r6 = r2;
        r0 = r1;
        r2 = r4;
    L_0x03ce:
        if (r2 != 0) goto L_0x0652;
    L_0x03d0:
        if (r7 == 0) goto L_0x0652;
    L_0x03d2:
        r1 = r7.length;	 Catch:{ Exception -> 0x00ef }
        if (r0 < r1) goto L_0x045b;
    L_0x03d5:
        r0 = r3;
    L_0x03d6:
        if (r2 != 0) goto L_0x05ce;
    L_0x03d8:
        r1 = r13.we;	 Catch:{ Exception -> 0x00ef }
        r2 = r13.EQ;	 Catch:{ Exception -> 0x00ef }
        if (r1 < r2) goto L_0x0403;
    L_0x03de:
        r1 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r2 = 1;
        r1 = r1.j6(r2);	 Catch:{ Exception -> 0x00ef }
        if (r1 == 0) goto L_0x0403;
    L_0x03e9:
        r1 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r2 = 1;
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r4 = "Login trials exceeds ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00ef }
        r4 = r13.EQ;	 Catch:{ Exception -> 0x00ef }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00ef }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00ef }
        r1.j6(r2, r3);	 Catch:{ Exception -> 0x00ef }
    L_0x0403:
        if (r0 == 0) goto L_0x05c5;
    L_0x0405:
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r1 = "Auth cancel";
        r0.<init>(r1);	 Catch:{ Exception -> 0x00ef }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x040e:
        r0 = move-exception;
        r1 = 0;
        r13.jJ = r1;	 Catch:{ Exception -> 0x00ef }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x0413:
        r0 = 0;
        r13.jJ = r0;	 Catch:{ Exception -> 0x00ef }
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r2 = "invalid protocol(newkyes): ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00ef }
        r2 = r13.VH;	 Catch:{ Exception -> 0x00ef }
        r2 = r2.J8();	 Catch:{ Exception -> 0x00ef }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00ef }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00ef }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00ef }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x0432:
        r0 = move-exception;
        r1 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r3 = "MaxAuthTries: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ef }
        r3 = "MaxAuthTries";
        r3 = r13.v5(r3);	 Catch:{ Exception -> 0x00ef }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00ef }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ef }
        r1.<init>(r2, r0);	 Catch:{ Exception -> 0x00ef }
        throw r1;	 Catch:{ Exception -> 0x00ef }
    L_0x0450:
        r0 = move-exception;
        r1 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r2 = r0.toString();	 Catch:{ Exception -> 0x00ef }
        r1.<init>(r2, r0);	 Catch:{ Exception -> 0x00ef }
        throw r1;	 Catch:{ Exception -> 0x00ef }
    L_0x045b:
        r1 = r0 + 1;
        r8 = r7[r0];	 Catch:{ Exception -> 0x00ef }
        r0 = 0;
        r4 = 0;
    L_0x0461:
        r9 = r5.length;	 Catch:{ Exception -> 0x00ef }
        if (r4 < r9) goto L_0x0469;
    L_0x0464:
        if (r0 != 0) goto L_0x0476;
    L_0x0466:
        r0 = r1;
        goto L_0x03ce;
    L_0x0469:
        r9 = r5[r4];	 Catch:{ Exception -> 0x00ef }
        r9 = r9.equals(r8);	 Catch:{ Exception -> 0x00ef }
        if (r9 == 0) goto L_0x0473;
    L_0x0471:
        r0 = 1;
        goto L_0x0464;
    L_0x0473:
        r4 = r4 + 1;
        goto L_0x0461;
    L_0x0476:
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r4 = 1;
        r0 = r0.j6(r4);	 Catch:{ Exception -> 0x00ef }
        if (r0 == 0) goto L_0x04ac;
    L_0x0481:
        r4 = "Authentications that can continue: ";
        r0 = r1 + -1;
        r12 = r0;
        r0 = r4;
        r4 = r12;
    L_0x0489:
        r9 = r7.length;	 Catch:{ Exception -> 0x00ef }
        if (r4 < r9) goto L_0x0518;
    L_0x048c:
        r4 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r9 = 1;
        r4.j6(r9, r0);	 Catch:{ Exception -> 0x00ef }
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r4 = 1;
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r10 = "Next authentication method: ";
        r9.<init>(r10);	 Catch:{ Exception -> 0x00ef }
        r9 = r9.append(r8);	 Catch:{ Exception -> 0x00ef }
        r9 = r9.toString();	 Catch:{ Exception -> 0x00ef }
        r0.j6(r4, r9);	 Catch:{ Exception -> 0x00ef }
    L_0x04ac:
        r4 = 0;
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0548 }
        r9 = "userauth.";
        r0.<init>(r9);	 Catch:{ Exception -> 0x0548 }
        r0 = r0.append(r8);	 Catch:{ Exception -> 0x0548 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0548 }
        r0 = r13.v5(r0);	 Catch:{ Exception -> 0x0548 }
        if (r0 == 0) goto L_0x0573;
    L_0x04c3:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0548 }
        r9 = "userauth.";
        r0.<init>(r9);	 Catch:{ Exception -> 0x0548 }
        r0 = r0.append(r8);	 Catch:{ Exception -> 0x0548 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0548 }
        r0 = r13.v5(r0);	 Catch:{ Exception -> 0x0548 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0548 }
        r0 = r0.newInstance();	 Catch:{ Exception -> 0x0548 }
        r0 = (com.jcraft.jsch.UserAuth) r0;	 Catch:{ Exception -> 0x0548 }
    L_0x04e1:
        if (r0 == 0) goto L_0x065c;
    L_0x04e3:
        r3 = 0;
        r0 = r0.j6(r13);	 Catch:{ JSchAuthCancelException -> 0x0576, JSchPartialAuthException -> 0x057d, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x059a }
        if (r0 == 0) goto L_0x0658;
    L_0x04ea:
        r2 = com.jcraft.jsch.JSch.v5();	 Catch:{ JSchAuthCancelException -> 0x064f, JSchPartialAuthException -> 0x0649, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x0644 }
        r4 = 1;
        r2 = r2.j6(r4);	 Catch:{ JSchAuthCancelException -> 0x064f, JSchPartialAuthException -> 0x0649, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x0644 }
        if (r2 == 0) goto L_0x0658;
    L_0x04f5:
        r2 = com.jcraft.jsch.JSch.v5();	 Catch:{ JSchAuthCancelException -> 0x064f, JSchPartialAuthException -> 0x0649, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x0644 }
        r4 = 1;
        r9 = new java.lang.StringBuilder;	 Catch:{ JSchAuthCancelException -> 0x064f, JSchPartialAuthException -> 0x0649, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x0644 }
        r10 = "Authentication succeeded (";
        r9.<init>(r10);	 Catch:{ JSchAuthCancelException -> 0x064f, JSchPartialAuthException -> 0x0649, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x0644 }
        r8 = r9.append(r8);	 Catch:{ JSchAuthCancelException -> 0x064f, JSchPartialAuthException -> 0x0649, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x0644 }
        r9 = ").";
        r8 = r8.append(r9);	 Catch:{ JSchAuthCancelException -> 0x064f, JSchPartialAuthException -> 0x0649, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x0644 }
        r8 = r8.toString();	 Catch:{ JSchAuthCancelException -> 0x064f, JSchPartialAuthException -> 0x0649, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x0644 }
        r2.j6(r4, r8);	 Catch:{ JSchAuthCancelException -> 0x064f, JSchPartialAuthException -> 0x0649, RuntimeException -> 0x0596, JSchException -> 0x0598, Exception -> 0x0644 }
        r2 = r0;
        r0 = r1;
        goto L_0x03ce;
    L_0x0518:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x00ef }
        r9.<init>(r0);	 Catch:{ Exception -> 0x00ef }
        r0 = r7[r4];	 Catch:{ Exception -> 0x00ef }
        r0 = r9.append(r0);	 Catch:{ Exception -> 0x00ef }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00ef }
        r9 = r4 + 1;
        r10 = r7.length;	 Catch:{ Exception -> 0x00ef }
        if (r9 >= r10) goto L_0x0544;
    L_0x0530:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x00ef }
        r9.<init>(r0);	 Catch:{ Exception -> 0x00ef }
        r0 = ",";
        r0 = r9.append(r0);	 Catch:{ Exception -> 0x00ef }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00ef }
    L_0x0544:
        r4 = r4 + 1;
        goto L_0x0489;
    L_0x0548:
        r0 = move-exception;
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r9 = 2;
        r0 = r0.j6(r9);	 Catch:{ Exception -> 0x00ef }
        if (r0 == 0) goto L_0x0573;
    L_0x0554:
        r0 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r9 = 2;
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r11 = "failed to load ";
        r10.<init>(r11);	 Catch:{ Exception -> 0x00ef }
        r10 = r10.append(r8);	 Catch:{ Exception -> 0x00ef }
        r11 = " method";
        r10 = r10.append(r11);	 Catch:{ Exception -> 0x00ef }
        r10 = r10.toString();	 Catch:{ Exception -> 0x00ef }
        r0.j6(r9, r10);	 Catch:{ Exception -> 0x00ef }
    L_0x0573:
        r0 = r4;
        goto L_0x04e1;
    L_0x0576:
        r0 = move-exception;
        r0 = r2;
    L_0x0578:
        r3 = 1;
        r2 = r0;
        r0 = r1;
        goto L_0x03ce;
    L_0x057d:
        r0 = move-exception;
    L_0x057e:
        r4 = r0.j6();	 Catch:{ Exception -> 0x00ef }
        r0 = ",";
        r3 = com.jcraft.jsch.Util.j6(r4, r0);	 Catch:{ Exception -> 0x00ef }
        r0 = r6.equals(r4);	 Catch:{ Exception -> 0x00ef }
        if (r0 != 0) goto L_0x0655;
    L_0x058f:
        r0 = 0;
    L_0x0590:
        r1 = 0;
        r5 = r3;
        r6 = r4;
        r3 = r1;
        goto L_0x03ce;
    L_0x0596:
        r0 = move-exception;
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x0598:
        r0 = move-exception;
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x059a:
        r0 = move-exception;
    L_0x059b:
        r1 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r4 = 2;
        r1 = r1.j6(r4);	 Catch:{ Exception -> 0x00ef }
        if (r1 == 0) goto L_0x0652;
    L_0x05a6:
        r1 = com.jcraft.jsch.JSch.v5();	 Catch:{ Exception -> 0x00ef }
        r4 = 2;
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r6 = "an exception during authentication\n";
        r5.<init>(r6);	 Catch:{ Exception -> 0x00ef }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00ef }
        r0 = r5.append(r0);	 Catch:{ Exception -> 0x00ef }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00ef }
        r1.j6(r4, r0);	 Catch:{ Exception -> 0x00ef }
        r0 = r3;
        goto L_0x03d6;
    L_0x05c5:
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x00ef }
        r1 = "Auth fail";
        r0.<init>(r1);	 Catch:{ Exception -> 0x00ef }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x05ce:
        r0 = r13.g3;	 Catch:{ Exception -> 0x00ef }
        if (r0 == 0) goto L_0x05df;
    L_0x05d2:
        if (r14 > 0) goto L_0x05d8;
    L_0x05d4:
        r0 = r13.Mz;	 Catch:{ Exception -> 0x00ef }
        if (r0 <= 0) goto L_0x05df;
    L_0x05d8:
        r0 = r13.g3;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.Mz;	 Catch:{ Exception -> 0x00ef }
        r0.setSoTimeout(r1);	 Catch:{ Exception -> 0x00ef }
    L_0x05df:
        r0 = 1;
        r13.ca = r0;	 Catch:{ Exception -> 0x00ef }
        r1 = r13.Qq;	 Catch:{ Exception -> 0x00ef }
        monitor-enter(r1);	 Catch:{ Exception -> 0x00ef }
        r0 = r13.I;	 Catch:{ all -> 0x062b }
        if (r0 == 0) goto L_0x0621;
    L_0x05e9:
        r0 = new java.lang.Thread;	 Catch:{ all -> 0x062b }
        r0.<init>(r13);	 Catch:{ all -> 0x062b }
        r13.x9 = r0;	 Catch:{ all -> 0x062b }
        r0 = r13.x9;	 Catch:{ all -> 0x062b }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x062b }
        r3 = "Connect thread ";
        r2.<init>(r3);	 Catch:{ all -> 0x062b }
        r3 = r13.J0;	 Catch:{ all -> 0x062b }
        r2 = r2.append(r3);	 Catch:{ all -> 0x062b }
        r3 = " session";
        r2 = r2.append(r3);	 Catch:{ all -> 0x062b }
        r2 = r2.toString();	 Catch:{ all -> 0x062b }
        r0.setName(r2);	 Catch:{ all -> 0x062b }
        r0 = r13.tp;	 Catch:{ all -> 0x062b }
        if (r0 == 0) goto L_0x0619;
    L_0x0612:
        r0 = r13.x9;	 Catch:{ all -> 0x062b }
        r2 = r13.tp;	 Catch:{ all -> 0x062b }
        r0.setDaemon(r2);	 Catch:{ all -> 0x062b }
    L_0x0619:
        r0 = r13.x9;	 Catch:{ all -> 0x062b }
        r0.start();	 Catch:{ all -> 0x062b }
        r13.Ws();	 Catch:{ all -> 0x062b }
    L_0x0621:
        monitor-exit(r1);	 Catch:{ all -> 0x062b }
        r0 = r13.XL;
        com.jcraft.jsch.Util.Hw(r0);
        r0 = 0;
        r13.XL = r0;
        return;
    L_0x062b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x062b }
        throw r0;	 Catch:{ Exception -> 0x00ef }
    L_0x062e:
        r1 = r0 instanceof com.jcraft.jsch.JSchException;	 Catch:{ all -> 0x0142 }
        if (r1 == 0) goto L_0x0635;
    L_0x0632:
        r0 = (com.jcraft.jsch.JSchException) r0;	 Catch:{ all -> 0x0142 }
        throw r0;	 Catch:{ all -> 0x0142 }
    L_0x0635:
        r1 = new com.jcraft.jsch.JSchException;	 Catch:{ all -> 0x0142 }
        r2 = "Session.connect";
        r1.<init>(r2, r0);	 Catch:{ all -> 0x0142 }
        throw r1;	 Catch:{ all -> 0x0142 }
    L_0x063e:
        r1 = move-exception;
        goto L_0x0138;
    L_0x0641:
        r1 = move-exception;
        goto L_0x0135;
    L_0x0644:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x059b;
    L_0x0649:
        r2 = move-exception;
        r12 = r2;
        r2 = r0;
        r0 = r12;
        goto L_0x057e;
    L_0x064f:
        r2 = move-exception;
        goto L_0x0578;
    L_0x0652:
        r0 = r3;
        goto L_0x03d6;
    L_0x0655:
        r0 = r1;
        goto L_0x0590;
    L_0x0658:
        r2 = r0;
        r0 = r1;
        goto L_0x03ce;
    L_0x065c:
        r0 = r1;
        goto L_0x03ce;
    L_0x065f:
        r2 = r1;
        goto L_0x03c2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.j6(int):void");
    }

    private KeyExchange DW(Buffer buffer) {
        int Hw = buffer.Hw();
        if (Hw != buffer.j6()) {
            buffer.VH();
            this.er = new byte[(buffer.FH - 5)];
        } else {
            this.er = new byte[((Hw - 1) - buffer.VH())];
        }
        System.arraycopy(buffer.DW, buffer.Hw, this.er, 0, this.er.length);
        if (!this.jJ) {
            we();
        }
        this.j6 = KeyExchange.j6(this.er, this.rN);
        if (this.j6 == null) {
            throw new JSchException("Algorithm negotiation fail");
        } else if (this.ca || !(this.j6[2].equals("none") || this.j6[3].equals("none"))) {
            try {
                KeyExchange keyExchange = (KeyExchange) Class.forName(v5(this.j6[0])).newInstance();
                keyExchange.j6(this, this.a8, this.lg, this.er, this.rN);
                return keyExchange;
            } catch (Throwable e) {
                throw new JSchException(e.toString(), e);
            }
        } else {
            throw new JSchException("NONE Cipher should not be chosen before authentification is successed.");
        }
    }

    private void we() {
        if (!this.jJ) {
            String v5 = v5("cipher.c2s");
            String v52 = v5("cipher.s2c");
            String[] EQ = EQ(v5("CheckCiphers"));
            if (EQ != null && EQ.length > 0) {
                v5 = Util.j6(v5, EQ);
                v52 = Util.j6(v52, EQ);
                if (v5 == null || v52 == null) {
                    throw new JSchException("There are not any available ciphers.");
                }
            }
            String v53 = v5("kex");
            String[] we = we(v5("CheckKexes"));
            if (we != null && we.length > 0) {
                v53 = Util.j6(v53, we);
                if (v53 == null) {
                    throw new JSchException("There are not any available kexes.");
                }
            }
            this.jJ = true;
            this.XG = System.currentTimeMillis();
            Buffer buffer = new Buffer();
            Packet packet = new Packet(buffer);
            packet.j6();
            buffer.j6((byte) 20);
            synchronized (Zo) {
                Zo.j6(buffer.DW, buffer.FH, 16);
                buffer.DW(16);
            }
            buffer.DW(Util.DW(v53));
            buffer.DW(Util.DW(v5("server_host_key")));
            buffer.DW(Util.DW(v5));
            buffer.DW(Util.DW(v52));
            buffer.DW(Util.DW(v5("mac.c2s")));
            buffer.DW(Util.DW(v5("mac.s2c")));
            buffer.DW(Util.DW(v5("compression.c2s")));
            buffer.DW(Util.DW(v5("compression.s2c")));
            buffer.DW(Util.DW(v5("lang.c2s")));
            buffer.DW(Util.DW(v5("lang.s2c")));
            buffer.j6((byte) 0);
            buffer.j6(0);
            buffer.FH(5);
            this.rN = new byte[buffer.j6()];
            buffer.Hw(this.rN);
            DW(packet);
            if (JSch.v5().j6(1)) {
                JSch.v5().j6(1, "SSH_MSG_KEXINIT sent");
            }
        }
    }

    private void J0() {
        this.gn.j6();
        this.VH.j6((byte) 21);
        DW(this.gn);
        if (JSch.v5().j6(1)) {
            JSch.v5().j6(1, "SSH_MSG_NEWKEYS sent");
        }
    }

    private void j6(String str, int i, KeyExchange keyExchange) {
        int i2;
        int i3;
        int i4 = 0;
        String v5 = v5("StrictHostKeyChecking");
        if (this.OW != null) {
            str = this.OW;
        }
        byte[] VH = keyExchange.VH();
        String j6 = keyExchange.j6();
        String FH = keyExchange.FH();
        if (this.OW == null && i != 22) {
            str = "[" + str + "]:" + i;
        }
        HostKeyRepository EQ = EQ();
        if (v5("HashKnownHosts").equals("yes") && (EQ instanceof KnownHosts)) {
            this.hz = ((KnownHosts) EQ).DW(str, VH);
        } else {
            this.hz = new HostKey(str, VH);
        }
        synchronized (EQ) {
            int j62 = EQ.j6(str, VH);
        }
        if ((v5.equals("ask") || v5.equals("yes")) && j62 == 2) {
            String j63;
            boolean FH2;
            synchronized (EQ) {
                j63 = EQ.j6();
            }
            if (j63 == null) {
                j63 = "known_hosts";
            }
            if (this.lp != null) {
                j63 = "WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!\nIT IS POSSIBLE THAT SOMEONE IS DOING SOMETHING NASTY!\nSomeone could be eavesdropping on you right now (man-in-the-middle attack)!\nIt is also possible that the " + j6 + " host key has just been changed.\n" + "The fingerprint for the " + j6 + " key sent by the remote host is\n" + FH + ".\n" + "Please contact your system administrator.\n" + "Add correct host key in " + j63 + " to get rid of this message.";
                if (v5.equals("ask")) {
                    FH2 = this.lp.FH(new StringBuilder(String.valueOf(j63)).append("\nDo you want to delete the old key and insert the new key?").toString());
                    if (FH2) {
                        throw new JSchException("HostKey has been changed: " + str);
                    }
                    synchronized (EQ) {
                        EQ.j6(str, j6.equals("DSA") ? "ssh-dss" : "ssh-rsa", null);
                    }
                    i2 = 1;
                } else {
                    this.lp.Hw(j63);
                }
            }
            FH2 = false;
            if (FH2) {
                synchronized (EQ) {
                    if (j6.equals("DSA")) {
                    }
                    EQ.j6(str, j6.equals("DSA") ? "ssh-dss" : "ssh-rsa", null);
                }
                i2 = 1;
            } else {
                throw new JSchException("HostKey has been changed: " + str);
            }
        }
        i2 = 0;
        if ((v5.equals("ask") || v5.equals("yes")) && j62 != 0 && r0 == 0) {
            if (v5.equals("yes")) {
                throw new JSchException("reject HostKey: " + this.J0);
            } else if (this.lp != null) {
                if (this.lp.FH("The authenticity of host '" + this.J0 + "' can't be established.\n" + j6 + " key fingerprint is " + FH + ".\n" + "Are you sure you want to continue connecting?")) {
                    i2 = 1;
                } else {
                    throw new JSchException("reject HostKey: " + this.J0);
                }
            } else if (j62 == 1) {
                throw new JSchException("UnknownHostKey: " + this.J0 + ". " + j6 + " key fingerprint is " + FH);
            } else {
                throw new JSchException("HostKey has been changed: " + this.J0);
            }
        }
        if (v5.equals("no") && 1 == j62) {
            i3 = 1;
        } else {
            i3 = i2;
        }
        if (j62 == 0) {
            HostKey[] j64 = EQ.j6(str, j6.equals("DSA") ? "ssh-dss" : "ssh-rsa");
            String DW = Util.DW(Util.DW(VH, 0, VH.length));
            while (i4 < j64.length) {
                if (j64[j62].FH().equals(DW) && j64[i4].v5().equals("@revoked")) {
                    if (this.lp != null) {
                        this.lp.Hw("The " + j6 + " host key for " + this.J0 + " is marked as revoked.\n" + "This could mean that a stolen key is being used to " + "impersonate this host.");
                    }
                    if (JSch.v5().j6(1)) {
                        JSch.v5().j6(1, "Host '" + this.J0 + "' has provided revoked key.");
                    }
                    throw new JSchException("revoked HostKey: " + this.J0);
                }
                i4++;
            }
        }
        if (j62 == 0 && JSch.v5().j6(1)) {
            JSch.v5().j6(1, "Host '" + this.J0 + "' is known and mathces the " + j6 + " host key");
        }
        if (i3 != 0 && JSch.v5().j6(2)) {
            JSch.v5().j6(2, "Permanently added '" + this.J0 + "' (" + j6 + ") to the list of known hosts.");
        }
        if (i3 != 0) {
            synchronized (EQ) {
                EQ.j6(this.hz, this.lp);
            }
        }
    }

    public Channel j6(String str) {
        if (this.I) {
            try {
                Channel j6 = Channel.j6(str);
                j6(j6);
                j6.DW();
                if (!(j6 instanceof ChannelSession)) {
                    return j6;
                }
                j6((ChannelSession) j6);
                return j6;
            } catch (Exception e) {
                return null;
            }
        }
        throw new JSchException("session is down");
    }

    public void j6(Packet packet) {
        if (this.ef != null) {
            this.Mr[0] = packet.j6.FH;
            packet.j6.DW = this.ef.j6(packet.j6.DW, 5, this.Mr);
            packet.j6.FH = this.Mr[0];
        }
        if (this.cn != null) {
            packet.j6(this.et);
            byte b = packet.j6.DW[4];
            synchronized (Zo) {
                Zo.j6(packet.j6.DW, packet.j6.FH - b, b);
            }
        } else {
            packet.j6(8);
        }
        if (this.cb != null) {
            this.cb.j6(this.KD);
            this.cb.j6(packet.j6.DW, 0, packet.j6.FH);
            this.cb.j6(packet.j6.DW, packet.j6.FH);
        }
        if (this.cn != null) {
            byte[] bArr = packet.j6.DW;
            this.cn.j6(bArr, 0, packet.j6.FH, bArr, 0);
        }
        if (this.cb != null) {
            packet.j6.DW(this.cb.j6());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.jcraft.jsch.Buffer j6(com.jcraft.jsch.Buffer r12) {
        /*
        r11 = this;
    L_0x0000:
        r12.EQ();
        r0 = r11.vJ;
        r1 = r12.DW;
        r2 = r12.FH;
        r3 = r11.wc;
        r0.FH(r1, r2, r3);
        r0 = r12.FH;
        r1 = r11.wc;
        r0 = r0 + r1;
        r12.FH = r0;
        r0 = r11.ro;
        if (r0 == 0) goto L_0x0026;
    L_0x0019:
        r0 = r11.ro;
        r1 = r12.DW;
        r2 = 0;
        r3 = r11.wc;
        r4 = r12.DW;
        r5 = 0;
        r0.j6(r1, r2, r3, r4, r5);
    L_0x0026:
        r0 = r12.DW;
        r1 = 0;
        r0 = r0[r1];
        r0 = r0 << 24;
        r1 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r0 = r0 & r1;
        r1 = r12.DW;
        r2 = 1;
        r1 = r1[r2];
        r1 = r1 << 16;
        r2 = 16711680; // 0xff0000 float:2.3418052E-38 double:8.256667E-317;
        r1 = r1 & r2;
        r0 = r0 | r1;
        r1 = r12.DW;
        r2 = 2;
        r1 = r1[r2];
        r1 = r1 << 8;
        r2 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r1 = r1 & r2;
        r0 = r0 | r1;
        r1 = r12.DW;
        r2 = 3;
        r1 = r1[r2];
        r1 = r1 & 255;
        r4 = r0 | r1;
        r0 = 5;
        if (r4 < r0) goto L_0x0057;
    L_0x0053:
        r0 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        if (r4 <= r0) goto L_0x0062;
    L_0x0057:
        r2 = r11.ro;
        r3 = r11.sh;
        r5 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r0 = r11;
        r1 = r12;
        r0.j6(r1, r2, r3, r4, r5);
    L_0x0062:
        r0 = r4 + 4;
        r1 = r11.wc;
        r8 = r0 - r1;
        r0 = r12.FH;
        r0 = r0 + r8;
        r1 = r12.DW;
        r1 = r1.length;
        if (r0 <= r1) goto L_0x0080;
    L_0x0070:
        r0 = r12.FH;
        r0 = r0 + r8;
        r0 = new byte[r0];
        r1 = r12.DW;
        r2 = 0;
        r3 = 0;
        r5 = r12.FH;
        java.lang.System.arraycopy(r1, r2, r0, r3, r5);
        r12.DW = r0;
    L_0x0080:
        r0 = r11.wc;
        r0 = r8 % r0;
        if (r0 == 0) goto L_0x00b8;
    L_0x0086:
        r0 = new java.lang.StringBuilder;
        r1 = "Bad packet length ";
        r0.<init>(r1);
        r0 = r0.append(r8);
        r0 = r0.toString();
        r1 = com.jcraft.jsch.JSch.v5();
        r2 = 4;
        r1 = r1.j6(r2);
        if (r1 == 0) goto L_0x00a9;
    L_0x00a1:
        r1 = com.jcraft.jsch.JSch.v5();
        r2 = 4;
        r1.j6(r2, r0);
    L_0x00a9:
        r2 = r11.ro;
        r3 = r11.sh;
        r0 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r1 = r11.wc;
        r5 = r0 - r1;
        r0 = r11;
        r1 = r12;
        r0.j6(r1, r2, r3, r4, r5);
    L_0x00b8:
        if (r8 <= 0) goto L_0x00d9;
    L_0x00ba:
        r0 = r11.vJ;
        r1 = r12.DW;
        r2 = r12.FH;
        r0.FH(r1, r2, r8);
        r0 = r12.FH;
        r0 = r0 + r8;
        r12.FH = r0;
        r0 = r11.ro;
        if (r0 == 0) goto L_0x00d9;
    L_0x00cc:
        r5 = r11.ro;
        r6 = r12.DW;
        r7 = r11.wc;
        r9 = r12.DW;
        r10 = r11.wc;
        r5.j6(r6, r7, r8, r9, r10);
    L_0x00d9:
        r0 = r11.sh;
        if (r0 == 0) goto L_0x0127;
    L_0x00dd:
        r0 = r11.sh;
        r1 = r11.SI;
        r0.j6(r1);
        r0 = r11.sh;
        r1 = r12.DW;
        r2 = 0;
        r3 = r12.FH;
        r0.j6(r1, r2, r3);
        r0 = r11.sh;
        r1 = r11.dx;
        r2 = 0;
        r0.j6(r1, r2);
        r0 = r11.vJ;
        r1 = r11.sG;
        r2 = 0;
        r3 = r11.sG;
        r3 = r3.length;
        r0.FH(r1, r2, r3);
        r0 = r11.dx;
        r1 = r11.sG;
        r0 = java.util.Arrays.equals(r0, r1);
        if (r0 != 0) goto L_0x0127;
    L_0x010b:
        r0 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        if (r8 <= r0) goto L_0x0118;
    L_0x010f:
        r0 = new java.io.IOException;
        r1 = "MAC Error";
        r0.<init>(r1);
        throw r0;
    L_0x0118:
        r2 = r11.ro;
        r3 = r11.sh;
        r0 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r5 = r0 - r8;
        r0 = r11;
        r1 = r12;
        r0.j6(r1, r2, r3, r4, r5);
        goto L_0x0000;
    L_0x0127:
        r0 = r11.SI;
        r0 = r0 + 1;
        r11.SI = r0;
        r0 = r11.Sf;
        if (r0 == 0) goto L_0x0159;
    L_0x0131:
        r0 = r12.DW;
        r1 = 4;
        r0 = r0[r1];
        r1 = r11.j3;
        r2 = 0;
        r3 = r12.FH;
        r3 = r3 + -5;
        r0 = r3 - r0;
        r1[r2] = r0;
        r0 = r11.Sf;
        r1 = r12.DW;
        r2 = 5;
        r3 = r11.j3;
        r0 = r0.DW(r1, r2, r3);
        if (r0 == 0) goto L_0x01ab;
    L_0x014e:
        r12.DW = r0;
        r0 = r11.j3;
        r1 = 0;
        r0 = r0[r1];
        r0 = r0 + 5;
        r12.FH = r0;
    L_0x0159:
        r0 = r12.J8();
        r0 = r0 & 255;
        r1 = 1;
        if (r0 != r1) goto L_0x01b7;
    L_0x0162:
        r12.J0();
        r12.Hw();
        r12.Zo();
        r0 = r12.Hw();
        r1 = r12.tp();
        r2 = r12.tp();
        r3 = new com.jcraft.jsch.JSchException;
        r4 = new java.lang.StringBuilder;
        r5 = "SSH_MSG_DISCONNECT: ";
        r4.<init>(r5);
        r0 = r4.append(r0);
        r4 = " ";
        r0 = r0.append(r4);
        r1 = com.jcraft.jsch.Util.DW(r1);
        r0 = r0.append(r1);
        r1 = " ";
        r0 = r0.append(r1);
        r1 = com.jcraft.jsch.Util.DW(r2);
        r0 = r0.append(r1);
        r0 = r0.toString();
        r3.<init>(r0);
        throw r3;
    L_0x01ab:
        r0 = java.lang.System.err;
        r1 = "fail in inflater";
        r0.println(r1);
    L_0x01b3:
        r12.J0();
        return r12;
    L_0x01b7:
        r1 = 2;
        if (r0 == r1) goto L_0x0000;
    L_0x01ba:
        r1 = 3;
        if (r0 != r1) goto L_0x01ef;
    L_0x01bd:
        r12.J0();
        r12.Hw();
        r12.Zo();
        r0 = r12.Hw();
        r1 = com.jcraft.jsch.JSch.v5();
        r2 = 1;
        r1 = r1.j6(r2);
        if (r1 == 0) goto L_0x0000;
    L_0x01d5:
        r1 = com.jcraft.jsch.JSch.v5();
        r2 = 1;
        r3 = new java.lang.StringBuilder;
        r4 = "Received SSH_MSG_UNIMPLEMENTED for ";
        r3.<init>(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r1.j6(r2, r0);
        goto L_0x0000;
    L_0x01ef:
        r1 = 4;
        if (r0 != r1) goto L_0x01fd;
    L_0x01f2:
        r12.J0();
        r12.Hw();
        r12.Zo();
        goto L_0x0000;
    L_0x01fd:
        r1 = 93;
        if (r0 != r1) goto L_0x021d;
    L_0x0201:
        r12.J0();
        r12.Hw();
        r12.Zo();
        r0 = r12.Hw();
        r0 = com.jcraft.jsch.Channel.j6(r0, r11);
        if (r0 == 0) goto L_0x0000;
    L_0x0214:
        r2 = r12.v5();
        r0.DW(r2);
        goto L_0x0000;
    L_0x021d:
        r1 = 52;
        if (r0 != r1) goto L_0x01b3;
    L_0x0221:
        r0 = 1;
        r11.ca = r0;
        r0 = r11.Sf;
        if (r0 != 0) goto L_0x01b3;
    L_0x0228:
        r0 = r11.ef;
        if (r0 != 0) goto L_0x01b3;
    L_0x022c:
        r0 = r11.j6;
        r1 = 6;
        r0 = r0[r1];
        r11.u7(r0);
        r0 = r11.j6;
        r1 = 7;
        r0 = r0[r1];
        r11.tp(r0);
        goto L_0x01b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.j6(com.jcraft.jsch.Buffer):com.jcraft.jsch.Buffer");
    }

    private void j6(Buffer buffer, Cipher cipher, MAC mac, int i, int i2) {
        if (cipher.FH()) {
            if (i == 262144 || mac == null) {
                mac = null;
            }
            int i3 = i2 - buffer.FH;
            while (i3 > 0) {
                buffer.EQ();
                int length = i3 > buffer.DW.length ? buffer.DW.length : i3;
                this.vJ.FH(buffer.DW, 0, length);
                if (mac != null) {
                    mac.j6(buffer.DW, 0, length);
                }
                i3 -= length;
            }
            if (mac != null) {
                mac.j6(buffer.DW, 0);
            }
            throw new JSchException("Packet corrupt");
        }
        throw new JSchException("Packet corrupt");
    }

    byte[] j6() {
        return this.yS;
    }

    private void j6(Buffer buffer, KeyExchange keyExchange) {
        j6(keyExchange);
        this.jJ = false;
    }

    private void j6(KeyExchange keyExchange) {
        byte[] Hw = keyExchange.Hw();
        byte[] v5 = keyExchange.v5();
        HASH Zo = keyExchange.Zo();
        if (this.yS == null) {
            this.yS = new byte[v5.length];
            System.arraycopy(v5, 0, this.yS, 0, v5.length);
        }
        this.VH.EQ();
        this.VH.FH(Hw);
        this.VH.j6(v5);
        this.VH.j6((byte) 65);
        this.VH.j6(this.yS);
        Zo.j6(this.VH.DW, 0, this.VH.FH);
        this.gW = Zo.FH();
        int length = (this.VH.FH - this.yS.length) - 1;
        byte[] bArr = this.VH.DW;
        bArr[length] = (byte) (bArr[length] + 1);
        Zo.j6(this.VH.DW, 0, this.VH.FH);
        this.BT = Zo.FH();
        bArr = this.VH.DW;
        bArr[length] = (byte) (bArr[length] + 1);
        Zo.j6(this.VH.DW, 0, this.VH.FH);
        this.vy = Zo.FH();
        bArr = this.VH.DW;
        bArr[length] = (byte) (bArr[length] + 1);
        Zo.j6(this.VH.DW, 0, this.VH.FH);
        this.P8 = Zo.FH();
        bArr = this.VH.DW;
        bArr[length] = (byte) (bArr[length] + 1);
        Zo.j6(this.VH.DW, 0, this.VH.FH);
        this.ei = Zo.FH();
        bArr = this.VH.DW;
        bArr[length] = (byte) (bArr[length] + 1);
        Zo.j6(this.VH.DW, 0, this.VH.FH);
        this.nw = Zo.FH();
        try {
            Object FH;
            Object obj;
            this.ro = (Cipher) Class.forName(v5(this.j6[3])).newInstance();
            while (this.ro.DW() > this.P8.length) {
                this.VH.EQ();
                this.VH.FH(Hw);
                this.VH.j6(v5);
                this.VH.j6(this.P8);
                Zo.j6(this.VH.DW, 0, this.VH.FH);
                FH = Zo.FH();
                obj = new byte[(this.P8.length + FH.length)];
                System.arraycopy(this.P8, 0, obj, 0, this.P8.length);
                System.arraycopy(FH, 0, obj, this.P8.length, FH.length);
                this.P8 = obj;
            }
            this.ro.j6(1, this.P8, this.BT);
            this.wc = this.ro.j6();
            this.sh = (MAC) Class.forName(v5(this.j6[5])).newInstance();
            this.nw = j6(this.VH, Hw, v5, this.nw, Zo, this.sh.j6());
            this.sh.j6(this.nw);
            this.dx = new byte[this.sh.j6()];
            this.sG = new byte[this.sh.j6()];
            this.cn = (Cipher) Class.forName(v5(this.j6[2])).newInstance();
            while (this.cn.DW() > this.vy.length) {
                this.VH.EQ();
                this.VH.FH(Hw);
                this.VH.j6(v5);
                this.VH.j6(this.vy);
                Zo.j6(this.VH.DW, 0, this.VH.FH);
                FH = Zo.FH();
                obj = new byte[(this.vy.length + FH.length)];
                System.arraycopy(this.vy, 0, obj, 0, this.vy.length);
                System.arraycopy(FH, 0, obj, this.vy.length, FH.length);
                this.vy = obj;
            }
            this.cn.j6(0, this.vy, this.gW);
            this.et = this.cn.j6();
            this.cb = (MAC) Class.forName(v5(this.j6[4])).newInstance();
            this.ei = j6(this.VH, Hw, v5, this.ei, Zo, this.cb.j6());
            this.cb.j6(this.ei);
            u7(this.j6[6]);
            tp(this.j6[7]);
        } catch (Throwable e) {
            if (e instanceof JSchException) {
                throw e;
            }
            throw new JSchException(e.toString(), e);
        }
    }

    private byte[] j6(Buffer buffer, byte[] bArr, byte[] bArr2, byte[] bArr3, HASH hash, int i) {
        int DW = hash.DW();
        while (bArr3.length < i) {
            buffer.EQ();
            buffer.FH(bArr);
            buffer.j6(bArr2);
            buffer.j6(bArr3);
            hash.j6(buffer.DW, 0, buffer.FH);
            Object obj = new byte[(bArr3.length + DW)];
            System.arraycopy(bArr3, 0, obj, 0, bArr3.length);
            System.arraycopy(hash.FH(), 0, obj, bArr3.length, DW);
            Util.Hw(bArr3);
            Object obj2 = obj;
        }
        return bArr3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(com.jcraft.jsch.Packet r13, com.jcraft.jsch.Channel r14, int r15) {
        /*
        r12 = this;
        r10 = 0;
        r2 = 0;
        r0 = r12.v5();
        r6 = (long) r0;
    L_0x0008:
        r0 = r12.jJ;
        if (r0 == 0) goto L_0x002c;
    L_0x000c:
        r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r0 <= 0) goto L_0x0024;
    L_0x0010:
        r0 = java.lang.System.currentTimeMillis();
        r4 = r12.XG;
        r0 = r0 - r4;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x0024;
    L_0x001b:
        r0 = new com.jcraft.jsch.JSchException;
        r1 = "timeout in wating for rekeying process.";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r0 = 10;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x002a }
        goto L_0x0008;
    L_0x002a:
        r0 = move-exception;
        goto L_0x0008;
    L_0x002c:
        monitor-enter(r14);
        r0 = r14.gn;	 Catch:{ all -> 0x005f }
        r4 = (long) r15;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x0045;
    L_0x0034:
        r0 = r14.Mr;	 Catch:{ InterruptedException -> 0x0057, all -> 0x0062 }
        r0 = r0 + 1;
        r14.Mr = r0;	 Catch:{ InterruptedException -> 0x0057, all -> 0x0062 }
        r0 = 100;
        r14.wait(r0);	 Catch:{ InterruptedException -> 0x0057, all -> 0x0062 }
        r0 = r14.Mr;	 Catch:{ all -> 0x005f }
        r0 = r0 + -1;
        r14.Mr = r0;	 Catch:{ all -> 0x005f }
    L_0x0045:
        r0 = r14.gn;	 Catch:{ all -> 0x005f }
        r4 = (long) r15;	 Catch:{ all -> 0x005f }
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x006a;
    L_0x004c:
        r0 = r14.gn;	 Catch:{ all -> 0x005f }
        r2 = (long) r15;	 Catch:{ all -> 0x005f }
        r0 = r0 - r2;
        r14.gn = r0;	 Catch:{ all -> 0x005f }
        monitor-exit(r14);	 Catch:{ all -> 0x005f }
    L_0x0053:
        r12.FH(r13);
    L_0x0056:
        return;
    L_0x0057:
        r0 = move-exception;
        r0 = r14.Mr;	 Catch:{ all -> 0x005f }
        r0 = r0 + -1;
        r14.Mr = r0;	 Catch:{ all -> 0x005f }
        goto L_0x0045;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x005f }
        throw r0;
    L_0x0062:
        r0 = move-exception;
        r1 = r14.Mr;	 Catch:{ all -> 0x005f }
        r1 = r1 + -1;
        r14.Mr = r1;	 Catch:{ all -> 0x005f }
        throw r0;	 Catch:{ all -> 0x005f }
    L_0x006a:
        monitor-exit(r14);	 Catch:{ all -> 0x005f }
        r0 = r14.J8;
        if (r0 != 0) goto L_0x0075;
    L_0x006f:
        r0 = r14.EQ();
        if (r0 != 0) goto L_0x007e;
    L_0x0075:
        r0 = new java.io.IOException;
        r1 = "channel is broken";
        r0.<init>(r1);
        throw r0;
    L_0x007e:
        r0 = -1;
        monitor-enter(r14);
        r4 = r14.gn;	 Catch:{ all -> 0x00da }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 <= 0) goto L_0x00f4;
    L_0x0086:
        r0 = r14.gn;	 Catch:{ all -> 0x00da }
        r4 = (long) r15;	 Catch:{ all -> 0x00da }
        r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r3 <= 0) goto L_0x00f2;
    L_0x008d:
        r0 = (long) r15;	 Catch:{ all -> 0x00da }
        r4 = r0;
    L_0x008f:
        r0 = (long) r15;	 Catch:{ all -> 0x00da }
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x00f0;
    L_0x0094:
        r3 = (int) r4;	 Catch:{ all -> 0x00da }
        r0 = r12.cn;	 Catch:{ all -> 0x00da }
        if (r0 == 0) goto L_0x00d4;
    L_0x0099:
        r0 = r12.et;	 Catch:{ all -> 0x00da }
        r1 = r0;
    L_0x009c:
        r0 = r12.cb;	 Catch:{ all -> 0x00da }
        if (r0 == 0) goto L_0x00d8;
    L_0x00a0:
        r0 = r12.cb;	 Catch:{ all -> 0x00da }
        r0 = r0.j6();	 Catch:{ all -> 0x00da }
    L_0x00a6:
        r3 = r13.j6(r3, r1, r0);	 Catch:{ all -> 0x00da }
    L_0x00aa:
        r0 = r13.j6;	 Catch:{ all -> 0x00da }
        r1 = r0.J8();	 Catch:{ all -> 0x00da }
        r0 = r14.j6();	 Catch:{ all -> 0x00da }
        r8 = (long) r15;	 Catch:{ all -> 0x00da }
        r8 = r8 - r4;
        r15 = (int) r8;	 Catch:{ all -> 0x00da }
        r8 = r14.gn;	 Catch:{ all -> 0x00da }
        r4 = r8 - r4;
        r14.gn = r4;	 Catch:{ all -> 0x00da }
        r4 = 1;
    L_0x00be:
        monitor-exit(r14);	 Catch:{ all -> 0x00da }
        if (r4 == 0) goto L_0x00c9;
    L_0x00c1:
        r12.FH(r13);
        if (r15 == 0) goto L_0x0056;
    L_0x00c6:
        r13.j6(r1, r0, r3, r15);
    L_0x00c9:
        monitor-enter(r14);
        r0 = r12.jJ;	 Catch:{ all -> 0x00d1 }
        if (r0 == 0) goto L_0x00dd;
    L_0x00ce:
        monitor-exit(r14);	 Catch:{ all -> 0x00d1 }
        goto L_0x0008;
    L_0x00d1:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x00d1 }
        throw r0;
    L_0x00d4:
        r0 = 8;
        r1 = r0;
        goto L_0x009c;
    L_0x00d8:
        r0 = r2;
        goto L_0x00a6;
    L_0x00da:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x00da }
        throw r0;
    L_0x00dd:
        r0 = r14.gn;	 Catch:{ all -> 0x00d1 }
        r4 = (long) r15;	 Catch:{ all -> 0x00d1 }
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x00ed;
    L_0x00e4:
        r0 = r14.gn;	 Catch:{ all -> 0x00d1 }
        r2 = (long) r15;	 Catch:{ all -> 0x00d1 }
        r0 = r0 - r2;
        r14.gn = r0;	 Catch:{ all -> 0x00d1 }
        monitor-exit(r14);	 Catch:{ all -> 0x00d1 }
        goto L_0x0053;
    L_0x00ed:
        monitor-exit(r14);	 Catch:{ all -> 0x00d1 }
        goto L_0x0008;
    L_0x00f0:
        r3 = r2;
        goto L_0x00aa;
    L_0x00f2:
        r4 = r0;
        goto L_0x008f;
    L_0x00f4:
        r1 = r2;
        r3 = r2;
        r4 = r2;
        goto L_0x00be;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.j6(com.jcraft.jsch.Packet, com.jcraft.jsch.Channel, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void DW(com.jcraft.jsch.Packet r8) {
        /*
        r7 = this;
        r6 = 31;
        r0 = r7.v5();
        r0 = (long) r0;
    L_0x0007:
        r2 = r7.jJ;
        if (r2 != 0) goto L_0x000f;
    L_0x000b:
        r7.FH(r8);
        return;
    L_0x000f:
        r2 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0029;
    L_0x0015:
        r2 = java.lang.System.currentTimeMillis();
        r4 = r7.XG;
        r2 = r2 - r4;
        r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0029;
    L_0x0020:
        r0 = new com.jcraft.jsch.JSchException;
        r1 = "timeout in wating for rekeying process.";
        r0.<init>(r1);
        throw r0;
    L_0x0029:
        r2 = r8.j6;
        r2 = r2.J8();
        r3 = 20;
        if (r2 == r3) goto L_0x000b;
    L_0x0033:
        r3 = 21;
        if (r2 == r3) goto L_0x000b;
    L_0x0037:
        r3 = 30;
        if (r2 == r3) goto L_0x000b;
    L_0x003b:
        if (r2 == r6) goto L_0x000b;
    L_0x003d:
        if (r2 == r6) goto L_0x000b;
    L_0x003f:
        r3 = 32;
        if (r2 == r3) goto L_0x000b;
    L_0x0043:
        r3 = 33;
        if (r2 == r3) goto L_0x000b;
    L_0x0047:
        r3 = 34;
        if (r2 == r3) goto L_0x000b;
    L_0x004b:
        r3 = 1;
        if (r2 == r3) goto L_0x000b;
    L_0x004e:
        r2 = 10;
        java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x0054 }
        goto L_0x0007;
    L_0x0054:
        r2 = move-exception;
        goto L_0x0007;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.DW(com.jcraft.jsch.Packet):void");
    }

    private void FH(Packet packet) {
        synchronized (this.Qq) {
            j6(packet);
            if (this.vJ != null) {
                this.vJ.j6(packet);
                this.KD++;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r14 = this;
        r5 = 0;
        r13 = 81;
        r1 = 1;
        r2 = 0;
        r14.U2 = r14;
        r0 = new com.jcraft.jsch.Buffer;
        r0.<init>();
        r7 = new com.jcraft.jsch.Packet;
        r7.<init>(r0);
        r8 = new int[r1];
        r9 = new int[r1];
        r4 = r5;
        r3 = r0;
        r0 = r2;
    L_0x0018:
        r6 = r14.I;	 Catch:{ Exception -> 0x005a }
        if (r6 == 0) goto L_0x0020;
    L_0x001c:
        r6 = r14.U2;	 Catch:{ Exception -> 0x005a }
        if (r6 != 0) goto L_0x0026;
    L_0x0020:
        r14.DW();	 Catch:{ NullPointerException -> 0x03ba, Exception -> 0x03bd }
    L_0x0023:
        r14.I = r2;
        return;
    L_0x0026:
        r6 = r14.j6(r3);	 Catch:{ InterruptedIOException -> 0x0083 }
        r0 = r6.J8();	 Catch:{ Exception -> 0x005a }
        r3 = r0 & 255;
        if (r4 == 0) goto L_0x009f;
    L_0x0032:
        r0 = r4.DW();	 Catch:{ Exception -> 0x005a }
        if (r0 != r3) goto L_0x009f;
    L_0x0038:
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x005a }
        r14.XG = r10;	 Catch:{ Exception -> 0x005a }
        r0 = r4.j6(r6);	 Catch:{ Exception -> 0x005a }
        if (r0 != 0) goto L_0x03c0;
    L_0x0044:
        r3 = new com.jcraft.jsch.JSchException;	 Catch:{ Exception -> 0x005a }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005a }
        r5 = "verify: ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x005a }
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r0.toString();	 Catch:{ Exception -> 0x005a }
        r3.<init>(r0);	 Catch:{ Exception -> 0x005a }
        throw r3;	 Catch:{ Exception -> 0x005a }
    L_0x005a:
        r0 = move-exception;
        r14.jJ = r2;
        r3 = com.jcraft.jsch.JSch.v5();
        r3 = r3.j6(r1);
        if (r3 == 0) goto L_0x0020;
    L_0x0067:
        r3 = com.jcraft.jsch.JSch.v5();
        r4 = new java.lang.StringBuilder;
        r5 = "Caught an exception, leaving main loop due to ";
        r4.<init>(r5);
        r0 = r0.getMessage();
        r0 = r4.append(r0);
        r0 = r0.toString();
        r3.j6(r1, r0);
        goto L_0x0020;
    L_0x0083:
        r6 = move-exception;
        r10 = r14.jJ;	 Catch:{ Exception -> 0x005a }
        if (r10 != 0) goto L_0x0092;
    L_0x0088:
        r10 = r14.XX;	 Catch:{ Exception -> 0x005a }
        if (r0 >= r10) goto L_0x0092;
    L_0x008c:
        r14.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r0 + 1;
        goto L_0x0018;
    L_0x0092:
        r10 = r14.jJ;	 Catch:{ Exception -> 0x005a }
        if (r10 == 0) goto L_0x009e;
    L_0x0096:
        r10 = r14.XX;	 Catch:{ Exception -> 0x005a }
        if (r0 >= r10) goto L_0x009e;
    L_0x009a:
        r0 = r0 + 1;
        goto L_0x0018;
    L_0x009e:
        throw r6;	 Catch:{ Exception -> 0x005a }
    L_0x009f:
        switch(r3) {
            case 20: goto L_0x00b8;
            case 21: goto L_0x00c1;
            case 80: goto L_0x0365;
            case 81: goto L_0x0388;
            case 82: goto L_0x0388;
            case 90: goto L_0x0298;
            case 91: goto L_0x01fc;
            case 92: goto L_0x0228;
            case 93: goto L_0x01af;
            case 94: goto L_0x00cc;
            case 95: goto L_0x0144;
            case 96: goto L_0x01ce;
            case 97: goto L_0x01e5;
            case 98: goto L_0x024d;
            case 99: goto L_0x032f;
            case 100: goto L_0x034a;
            default: goto L_0x00a2;
        };	 Catch:{ Exception -> 0x005a }
    L_0x00a2:
        r0 = new java.io.IOException;	 Catch:{ Exception -> 0x005a }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005a }
        r5 = "Unknown SSH message type ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x005a }
        r3 = r4.append(r3);	 Catch:{ Exception -> 0x005a }
        r3 = r3.toString();	 Catch:{ Exception -> 0x005a }
        r0.<init>(r3);	 Catch:{ Exception -> 0x005a }
        throw r0;	 Catch:{ Exception -> 0x005a }
    L_0x00b8:
        r0 = r14.DW(r6);	 Catch:{ Exception -> 0x005a }
        r4 = r0;
        r3 = r6;
        r0 = r2;
        goto L_0x0018;
    L_0x00c1:
        r14.J0();	 Catch:{ Exception -> 0x005a }
        r14.j6(r6, r4);	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r4 = r5;
        r3 = r6;
        goto L_0x0018;
    L_0x00cc:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.VH();	 Catch:{ Exception -> 0x005a }
        r6.VH();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r3 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        r0 = r6.j6(r8, r9);	 Catch:{ Exception -> 0x005a }
        if (r3 != 0) goto L_0x00e7;
    L_0x00e3:
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x00e7:
        r10 = 0;
        r10 = r9[r10];	 Catch:{ Exception -> 0x005a }
        if (r10 != 0) goto L_0x00f0;
    L_0x00ec:
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x00f0:
        r10 = 0;
        r10 = r8[r10];	 Catch:{ Exception -> 0x0134 }
        r11 = 0;
        r11 = r9[r11];	 Catch:{ Exception -> 0x0134 }
        r3.j6(r0, r10, r11);	 Catch:{ Exception -> 0x0134 }
        r0 = 0;
        r0 = r9[r0];	 Catch:{ Exception -> 0x005a }
        r10 = r3.Zo;	 Catch:{ Exception -> 0x005a }
        r0 = r10 - r0;
        r3.Hw(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r3.Zo;	 Catch:{ Exception -> 0x005a }
        r10 = r3.v5;	 Catch:{ Exception -> 0x005a }
        r10 = r10 / 2;
        if (r0 >= r10) goto L_0x03c0;
    L_0x010b:
        r7.j6();	 Catch:{ Exception -> 0x005a }
        r0 = 93;
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r3.j6();	 Catch:{ Exception -> 0x005a }
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r3.v5;	 Catch:{ Exception -> 0x005a }
        r10 = r3.Zo;	 Catch:{ Exception -> 0x005a }
        r0 = r0 - r10;
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        monitor-enter(r3);	 Catch:{ Exception -> 0x005a }
        r0 = r3.J8;	 Catch:{ all -> 0x0141 }
        if (r0 != 0) goto L_0x012a;
    L_0x0127:
        r14.DW(r7);	 Catch:{ all -> 0x0141 }
    L_0x012a:
        monitor-exit(r3);	 Catch:{ all -> 0x0141 }
        r0 = r3.v5;	 Catch:{ Exception -> 0x005a }
        r3.Hw(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x0134:
        r0 = move-exception;
        r3.tp();	 Catch:{ Exception -> 0x013c }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x013c:
        r0 = move-exception;
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x0141:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0141 }
        throw r0;	 Catch:{ Exception -> 0x005a }
    L_0x0144:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r3 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0 = r6.j6(r8, r9);	 Catch:{ Exception -> 0x005a }
        if (r3 != 0) goto L_0x015f;
    L_0x015b:
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x015f:
        r10 = 0;
        r10 = r9[r10];	 Catch:{ Exception -> 0x005a }
        if (r10 != 0) goto L_0x0168;
    L_0x0164:
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x0168:
        r10 = 0;
        r10 = r8[r10];	 Catch:{ Exception -> 0x005a }
        r11 = 0;
        r11 = r9[r11];	 Catch:{ Exception -> 0x005a }
        r3.DW(r0, r10, r11);	 Catch:{ Exception -> 0x005a }
        r0 = 0;
        r0 = r9[r0];	 Catch:{ Exception -> 0x005a }
        r10 = r3.Zo;	 Catch:{ Exception -> 0x005a }
        r0 = r10 - r0;
        r3.Hw(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r3.Zo;	 Catch:{ Exception -> 0x005a }
        r10 = r3.v5;	 Catch:{ Exception -> 0x005a }
        r10 = r10 / 2;
        if (r0 >= r10) goto L_0x03c0;
    L_0x0183:
        r7.j6();	 Catch:{ Exception -> 0x005a }
        r0 = 93;
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r3.j6();	 Catch:{ Exception -> 0x005a }
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r3.v5;	 Catch:{ Exception -> 0x005a }
        r10 = r3.Zo;	 Catch:{ Exception -> 0x005a }
        r0 = r0 - r10;
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        monitor-enter(r3);	 Catch:{ Exception -> 0x005a }
        r0 = r3.J8;	 Catch:{ all -> 0x01ac }
        if (r0 != 0) goto L_0x01a2;
    L_0x019f:
        r14.DW(r7);	 Catch:{ all -> 0x01ac }
    L_0x01a2:
        monitor-exit(r3);	 Catch:{ all -> 0x01ac }
        r0 = r3.v5;	 Catch:{ Exception -> 0x005a }
        r3.Hw(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x01ac:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x01ac }
        throw r0;	 Catch:{ Exception -> 0x005a }
    L_0x01af:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        if (r0 != 0) goto L_0x01c3;
    L_0x01bf:
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x01c3:
        r10 = r6.v5();	 Catch:{ Exception -> 0x005a }
        r0.DW(r10);	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x01ce:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        if (r0 == 0) goto L_0x03c0;
    L_0x01de:
        r0.VH();	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x01e5:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        if (r0 == 0) goto L_0x03c0;
    L_0x01f5:
        r0.tp();	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x01fc:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        r3 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r10 = r6.v5();	 Catch:{ Exception -> 0x005a }
        r12 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        if (r0 == 0) goto L_0x03c0;
    L_0x0218:
        r0.j6(r10);	 Catch:{ Exception -> 0x005a }
        r0.Zo(r12);	 Catch:{ Exception -> 0x005a }
        r10 = 1;
        r0.QX = r10;	 Catch:{ Exception -> 0x005a }
        r0.j6(r3);	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x0228:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        if (r0 == 0) goto L_0x03c0;
    L_0x0238:
        r3 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0.VH(r3);	 Catch:{ Exception -> 0x005a }
        r3 = 1;
        r0.J8 = r3;	 Catch:{ Exception -> 0x005a }
        r3 = 1;
        r0.J0 = r3;	 Catch:{ Exception -> 0x005a }
        r3 = 0;
        r0.j6(r3);	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x024d:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r10 = r6.tp();	 Catch:{ Exception -> 0x005a }
        r3 = r6.VH();	 Catch:{ Exception -> 0x005a }
        if (r3 == 0) goto L_0x0296;
    L_0x0261:
        r3 = r1;
    L_0x0262:
        r11 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        if (r11 == 0) goto L_0x03c0;
    L_0x0268:
        r0 = 100;
        r10 = com.jcraft.jsch.Util.DW(r10);	 Catch:{ Exception -> 0x005a }
        r12 = "exit-status";
        r10 = r10.equals(r12);	 Catch:{ Exception -> 0x005a }
        if (r10 == 0) goto L_0x0280;
    L_0x0277:
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r11.VH(r0);	 Catch:{ Exception -> 0x005a }
        r0 = 99;
    L_0x0280:
        if (r3 == 0) goto L_0x03c0;
    L_0x0282:
        r7.j6();	 Catch:{ Exception -> 0x005a }
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r11.j6();	 Catch:{ Exception -> 0x005a }
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r14.DW(r7);	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x0296:
        r3 = r2;
        goto L_0x0262;
    L_0x0298:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.tp();	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ Exception -> 0x005a }
        r3 = "forwarded-tcpip";
        r3 = r3.equals(r0);	 Catch:{ Exception -> 0x005a }
        if (r3 != 0) goto L_0x02ed;
    L_0x02af:
        r3 = "x11";
        r3 = r3.equals(r0);	 Catch:{ Exception -> 0x005a }
        if (r3 == 0) goto L_0x02bc;
    L_0x02b8:
        r3 = r14.DW;	 Catch:{ Exception -> 0x005a }
        if (r3 != 0) goto L_0x02ed;
    L_0x02bc:
        r3 = "auth-agent@openssh.com";
        r3 = r3.equals(r0);	 Catch:{ Exception -> 0x005a }
        if (r3 == 0) goto L_0x02c9;
    L_0x02c5:
        r3 = r14.FH;	 Catch:{ Exception -> 0x005a }
        if (r3 != 0) goto L_0x02ed;
    L_0x02c9:
        r7.j6();	 Catch:{ Exception -> 0x005a }
        r0 = 92;
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r0 = 1;
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Util.j6;	 Catch:{ Exception -> 0x005a }
        r6.DW(r0);	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Util.j6;	 Catch:{ Exception -> 0x005a }
        r6.DW(r0);	 Catch:{ Exception -> 0x005a }
        r14.DW(r7);	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x02ed:
        r3 = com.jcraft.jsch.Channel.j6(r0);	 Catch:{ Exception -> 0x005a }
        r14.j6(r3);	 Catch:{ Exception -> 0x005a }
        r3.j6(r6);	 Catch:{ Exception -> 0x005a }
        r3.DW();	 Catch:{ Exception -> 0x005a }
        r10 = new java.lang.Thread;	 Catch:{ Exception -> 0x005a }
        r10.<init>(r3);	 Catch:{ Exception -> 0x005a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005a }
        r11 = "Channel ";
        r3.<init>(r11);	 Catch:{ Exception -> 0x005a }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x005a }
        r3 = " ";
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x005a }
        r3 = r14.J0;	 Catch:{ Exception -> 0x005a }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x005a }
        r0 = r0.toString();	 Catch:{ Exception -> 0x005a }
        r10.setName(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r14.tp;	 Catch:{ Exception -> 0x005a }
        if (r0 == 0) goto L_0x0328;
    L_0x0323:
        r0 = r14.tp;	 Catch:{ Exception -> 0x005a }
        r10.setDaemon(r0);	 Catch:{ Exception -> 0x005a }
    L_0x0328:
        r10.start();	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x032f:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        if (r0 != 0) goto L_0x0343;
    L_0x033f:
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x0343:
        r3 = 1;
        r0.aM = r3;	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x034a:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0 = com.jcraft.jsch.Channel.j6(r0, r14);	 Catch:{ Exception -> 0x005a }
        if (r0 != 0) goto L_0x035e;
    L_0x035a:
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x035e:
        r3 = 0;
        r0.aM = r3;	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x0365:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r6.tp();	 Catch:{ Exception -> 0x005a }
        r0 = r6.VH();	 Catch:{ Exception -> 0x005a }
        if (r0 == 0) goto L_0x0386;
    L_0x0374:
        r0 = r1;
    L_0x0375:
        if (r0 == 0) goto L_0x03c0;
    L_0x0377:
        r7.j6();	 Catch:{ Exception -> 0x005a }
        r0 = 82;
        r6.j6(r0);	 Catch:{ Exception -> 0x005a }
        r14.DW(r7);	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x0386:
        r0 = r2;
        goto L_0x0375;
    L_0x0388:
        r0 = r14.CU;	 Catch:{ Exception -> 0x005a }
        r10 = r0.j6();	 Catch:{ Exception -> 0x005a }
        if (r10 == 0) goto L_0x03c0;
    L_0x0390:
        r11 = r14.CU;	 Catch:{ Exception -> 0x005a }
        if (r3 != r13) goto L_0x03b8;
    L_0x0394:
        r0 = r1;
    L_0x0395:
        r11.j6(r0);	 Catch:{ Exception -> 0x005a }
        if (r3 != r13) goto L_0x03b1;
    L_0x039a:
        r0 = r14.CU;	 Catch:{ Exception -> 0x005a }
        r0 = r0.FH();	 Catch:{ Exception -> 0x005a }
        if (r0 != 0) goto L_0x03b1;
    L_0x03a2:
        r6.Hw();	 Catch:{ Exception -> 0x005a }
        r6.Zo();	 Catch:{ Exception -> 0x005a }
        r0 = r14.CU;	 Catch:{ Exception -> 0x005a }
        r3 = r6.Hw();	 Catch:{ Exception -> 0x005a }
        r0.DW(r3);	 Catch:{ Exception -> 0x005a }
    L_0x03b1:
        r10.interrupt();	 Catch:{ Exception -> 0x005a }
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
    L_0x03b8:
        r0 = r2;
        goto L_0x0395;
    L_0x03ba:
        r0 = move-exception;
        goto L_0x0023;
    L_0x03bd:
        r0 = move-exception;
        goto L_0x0023;
    L_0x03c0:
        r0 = r2;
        r3 = r6;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.run():void");
    }

    public void DW() {
        if (this.I) {
            if (JSch.v5().j6(1)) {
                JSch.v5().j6(1, "Disconnecting from " + this.J0 + " port " + this.Ws);
            }
            Channel.j6(this);
            this.I = false;
            PortWatcher.j6(this);
            ChannelForwardedTCPIP.FH(this);
            ChannelX11.Hw(this);
            synchronized (this.Qq) {
                if (this.x9 != null) {
                    Thread.yield();
                    this.x9.interrupt();
                    this.x9 = null;
                }
            }
            this.U2 = null;
            try {
                if (this.vJ != null) {
                    if (this.vJ.j6 != null) {
                        this.vJ.j6.close();
                    }
                    if (this.vJ.DW != null) {
                        this.vJ.DW.close();
                    }
                    if (this.vJ.FH != null) {
                        this.vJ.FH.close();
                    }
                }
                if (this.aj != null) {
                    synchronized (this.aj) {
                        this.aj.Hw();
                    }
                    this.aj = null;
                } else if (this.g3 != null) {
                    this.g3.close();
                }
            } catch (Exception e) {
            }
            this.vJ = null;
            this.g3 = null;
            this.aM.DW(this);
        }
    }

    public int j6(String str, int i, String str2, int i2) {
        return j6(str, i, str2, i2, null);
    }

    public int j6(String str, int i, String str2, int i2, ServerSocketFactory serverSocketFactory) {
        return j6(str, i, str2, i2, serverSocketFactory, 0);
    }

    public int j6(String str, int i, String str2, int i2, ServerSocketFactory serverSocketFactory, int i3) {
        Object j6 = PortWatcher.j6(this, str, i, str2, i2, serverSocketFactory);
        j6.j6(i3);
        Thread thread = new Thread(j6);
        thread.setName("PortWatcher Thread for " + str2);
        if (this.tp) {
            thread.setDaemon(this.tp);
        }
        thread.start();
        return j6.DW;
    }

    private Forwarding gn(String str) {
        int i = 0;
        String[] split = str.split(" ");
        if (split.length > 1) {
            Vector vector = new Vector();
            for (int i2 = 0; i2 < split.length; i2++) {
                if (split[i2].length() != 0) {
                    vector.addElement(split[i2].trim());
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (i < vector.size()) {
                stringBuffer.append((String) vector.elementAt(i));
                if (i + 1 < vector.size()) {
                    stringBuffer.append(":");
                }
                i++;
            }
            str = stringBuffer.toString();
        }
        Forwarding forwarding = new Forwarding();
        try {
            if (str.lastIndexOf(":") == -1) {
                throw new JSchException("parseForwarding: " + str);
            }
            forwarding.Hw = Integer.parseInt(str.substring(str.lastIndexOf(":") + 1));
            String substring = str.substring(0, str.lastIndexOf(":"));
            if (substring.lastIndexOf(":") == -1) {
                throw new JSchException("parseForwarding: " + str);
            }
            forwarding.FH = substring.substring(substring.lastIndexOf(":") + 1);
            substring = substring.substring(0, substring.lastIndexOf(":"));
            if (substring.lastIndexOf(":") != -1) {
                forwarding.DW = Integer.parseInt(substring.substring(substring.lastIndexOf(":") + 1));
                substring = substring.substring(0, substring.lastIndexOf(":"));
                if (substring.length() == 0 || substring.equals("*")) {
                    substring = "0.0.0.0";
                }
                if (substring.equals("localhost")) {
                    substring = "127.0.0.1";
                }
                forwarding.j6 = substring;
            } else {
                forwarding.DW = Integer.parseInt(substring);
                forwarding.j6 = "127.0.0.1";
            }
            return forwarding;
        } catch (NumberFormatException e) {
            throw new JSchException("parseForwarding: " + e.toString());
        }
    }

    public int DW(String str) {
        Forwarding gn = gn(str);
        return j6(gn.j6, gn.DW, gn.FH, gn.Hw);
    }

    public int FH(String str) {
        Forwarding gn = gn(str);
        int j6 = j6(gn.j6, gn.DW);
        ChannelForwardedTCPIP.j6(this, gn.j6, gn.DW, j6, gn.FH, gn.Hw, null);
        return j6;
    }

    private int j6(String str, int i) {
        int DW;
        synchronized (this.CU) {
            Buffer buffer = new Buffer(100);
            Packet packet = new Packet(buffer);
            String DW2 = ChannelForwardedTCPIP.DW(str);
            this.CU.j6(Thread.currentThread());
            this.CU.DW(i);
            try {
                packet.j6();
                buffer.j6((byte) 80);
                buffer.DW(Util.DW("tcpip-forward"));
                buffer.j6((byte) 1);
                buffer.DW(Util.DW(DW2));
                buffer.j6(i);
                DW(packet);
                int i2 = 0;
                DW = this.CU.DW();
                while (i2 < 10 && DW == -1) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    i2++;
                    DW = this.CU.DW();
                }
                this.CU.j6(null);
                if (DW != 1) {
                    throw new JSchException("remote port forwarding failed for listen port " + i);
                }
                DW = this.CU.FH();
            } catch (Throwable e2) {
                this.CU.j6(null);
                if (e2 instanceof Throwable) {
                    throw new JSchException(e2.toString(), e2);
                }
                throw new JSchException(e2.toString());
            }
        }
        return DW;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u7(java.lang.String r4) {
        /*
        r3 = this;
        r0 = "none";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = 0;
        r3.ef = r0;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r3.v5(r4);
        if (r0 == 0) goto L_0x000c;
    L_0x0013:
        r1 = "zlib";
        r1 = r4.equals(r1);
        if (r1 != 0) goto L_0x0029;
    L_0x001c:
        r1 = r3.ca;
        if (r1 == 0) goto L_0x000c;
    L_0x0020:
        r1 = "zlib@openssh.com";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x000c;
    L_0x0029:
        r0 = java.lang.Class.forName(r0);	 Catch:{ NoClassDefFoundError -> 0x0048, Exception -> 0x0053 }
        r0 = r0.newInstance();	 Catch:{ NoClassDefFoundError -> 0x0048, Exception -> 0x0053 }
        r0 = (com.jcraft.jsch.Compression) r0;	 Catch:{ NoClassDefFoundError -> 0x0048, Exception -> 0x0053 }
        r3.ef = r0;	 Catch:{ NoClassDefFoundError -> 0x0048, Exception -> 0x0053 }
        r0 = 6;
        r1 = "compression_level";
        r1 = r3.v5(r1);	 Catch:{ Exception -> 0x005e, NoClassDefFoundError -> 0x0048 }
        r0 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x005e, NoClassDefFoundError -> 0x0048 }
    L_0x0041:
        r1 = r3.ef;	 Catch:{ NoClassDefFoundError -> 0x0048, Exception -> 0x0053 }
        r2 = 1;
        r1.j6(r2, r0);	 Catch:{ NoClassDefFoundError -> 0x0048, Exception -> 0x0053 }
        goto L_0x000c;
    L_0x0048:
        r0 = move-exception;
        r1 = new com.jcraft.jsch.JSchException;
        r2 = r0.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x0053:
        r0 = move-exception;
        r1 = new com.jcraft.jsch.JSchException;
        r2 = r0.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x005e:
        r1 = move-exception;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.u7(java.lang.String):void");
    }

    private void tp(String str) {
        if (str.equals("none")) {
            this.Sf = null;
            return;
        }
        String v5 = v5(str);
        if (v5 == null) {
            return;
        }
        if (str.equals("zlib") || (this.ca && str.equals("zlib@openssh.com"))) {
            try {
                this.Sf = (Compression) Class.forName(v5).newInstance();
                this.Sf.j6(0, 0);
            } catch (Throwable e) {
                throw new JSchException(e.toString(), e);
            }
        }
    }

    void j6(Channel channel) {
        channel.DW(this);
    }

    public void j6(UserInfo userInfo) {
        this.lp = userInfo;
    }

    public UserInfo FH() {
        return this.lp;
    }

    public void Hw(String str) {
        if (str != null) {
            this.XL = Util.DW(str);
        }
    }

    public void j6(String str, String str2) {
        synchronized (this.Qq) {
            if (this.sy == null) {
                this.sy = new Hashtable();
            }
            this.sy.put(str, str2);
        }
    }

    public String v5(String str) {
        if (this.sy != null) {
            Object obj = this.sy.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        String DW = JSch.DW(str);
        if (DW instanceof String) {
            return DW;
        }
        return null;
    }

    public boolean Hw() {
        return this.I;
    }

    public int v5() {
        return this.Mz;
    }

    public void DW(int i) {
        if (this.g3 != null) {
            try {
                this.g3.setSoTimeout(i);
                this.Mz = i;
            } catch (Throwable e) {
                if (e instanceof Throwable) {
                    throw new JSchException(e.toString(), e);
                }
                throw new JSchException(e.toString());
            }
        } else if (i < 0) {
            throw new JSchException("invalid timeout value");
        } else {
            this.Mz = i;
        }
    }

    static {
        Xa = Util.DW("keepalive@jcraft.com");
        Eq = Util.DW("no-more-sessions@openssh.com");
    }

    public void Zo() {
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.j6();
        buffer.j6((byte) 80);
        buffer.DW(Xa);
        buffer.j6((byte) 1);
        DW(packet);
    }

    public String VH() {
        return this.J0;
    }

    public String gn() {
        return this.QX;
    }

    public int u7() {
        return this.Ws;
    }

    public void Zo(String str) {
        this.OW = str;
    }

    public void FH(int i) {
        DW(i);
        this.br = i;
    }

    private String[] EQ(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (JSch.v5().j6(1)) {
            JSch.v5().j6(1, "CheckCiphers: " + str);
        }
        String v5 = v5("cipher.c2s");
        String v52 = v5("cipher.s2c");
        Vector vector = new Vector();
        String[] j6 = Util.j6(str, ",");
        for (String str2 : j6) {
            if (!((v52.indexOf(str2) == -1 && v5.indexOf(str2) == -1) || VH(v5(str2)))) {
                vector.addElement(str2);
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        String[] strArr = new String[vector.size()];
        System.arraycopy(vector.toArray(), 0, strArr, 0, vector.size());
        if (!JSch.v5().j6(1)) {
            return strArr;
        }
        while (i < strArr.length) {
            JSch.v5().j6(1, strArr[i] + " is not available.");
            i++;
        }
        return strArr;
    }

    static boolean VH(String str) {
        try {
            Cipher cipher = (Cipher) Class.forName(str).newInstance();
            cipher.j6(0, new byte[cipher.DW()], new byte[cipher.j6()]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String[] we(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (JSch.v5().j6(1)) {
            JSch.v5().j6(1, "CheckKexes: " + str);
        }
        Vector vector = new Vector();
        String[] j6 = Util.j6(str, ",");
        for (int i2 = 0; i2 < j6.length; i2++) {
            if (!j6(this, v5(j6[i2]))) {
                vector.addElement(j6[i2]);
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        String[] strArr = new String[vector.size()];
        System.arraycopy(vector.toArray(), 0, strArr, 0, vector.size());
        if (!JSch.v5().j6(1)) {
            return strArr;
        }
        while (i < strArr.length) {
            JSch.v5().j6(1, strArr[i] + " is not available.");
            i++;
        }
        return strArr;
    }

    static boolean j6(Session session, String str) {
        try {
            ((KeyExchange) Class.forName(str).newInstance()).j6(session, null, null, null, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void j6(IdentityRepository identityRepository) {
        this.kQ = identityRepository;
    }

    IdentityRepository tp() {
        if (this.kQ == null) {
            return this.aM.j6();
        }
        return this.kQ;
    }

    public void j6(HostKeyRepository hostKeyRepository) {
        this.yO = hostKeyRepository;
    }

    public HostKeyRepository EQ() {
        if (this.yO == null) {
            return this.aM.FH();
        }
        return this.yO;
    }

    private void J8() {
        ConfigRepository DW = this.aM.DW();
        if (DW != null) {
            Config j6 = DW.j6(this.J8);
            String DW2 = j6.DW();
            if (DW2 != null) {
                this.QX = DW2;
            }
            DW2 = j6.j6();
            if (DW2 != null) {
                this.J0 = DW2;
            }
            int FH = j6.FH();
            if (FH != -1) {
                this.Ws = FH;
            }
            j6(j6, "kex");
            j6(j6, "server_host_key");
            j6(j6, "cipher.c2s");
            j6(j6, "cipher.s2c");
            j6(j6, "mac.c2s");
            j6(j6, "mac.s2c");
            j6(j6, "compression.c2s");
            j6(j6, "compression.s2c");
            j6(j6, "compression_level");
            j6(j6, "StrictHostKeyChecking");
            j6(j6, "HashKnownHosts");
            j6(j6, "PreferredAuthentications");
            j6(j6, "MaxAuthTries");
            j6(j6, "ClearAllForwardings");
            DW2 = j6.j6("HostKeyAlias");
            if (DW2 != null) {
                Zo(DW2);
            }
            DW2 = j6.j6("UserKnownHostsFile");
            if (DW2 != null) {
                HostKeyRepository knownHosts = new KnownHosts(this.aM);
                knownHosts.j6(DW2);
                j6(knownHosts);
            }
            String[] DW3 = j6.DW("IdentityFile");
            if (DW3 != null) {
                String[] strArr;
                String[] DW4 = DW.j6("").DW("IdentityFile");
                if (DW4 != null) {
                    for (String j62 : DW4) {
                        this.aM.j6(j62);
                    }
                    strArr = DW4;
                } else {
                    strArr = new String[0];
                }
                if (DW3.length - strArr.length > 0) {
                    IdentityRepository wrapper = new Wrapper(this.aM.j6(), true);
                    for (String j622 : DW3) {
                        String str;
                        for (Object equals : strArr) {
                            if (j622.equals(equals)) {
                                str = null;
                                break;
                            }
                        }
                        str = j622;
                        if (str != null) {
                            wrapper.j6(IdentityFile.j6(str, null, this.aM));
                        }
                    }
                    j6(wrapper);
                }
            }
            String j63 = j6.j6("ServerAliveInterval");
            if (j63 != null) {
                try {
                    FH(Integer.parseInt(j63));
                } catch (NumberFormatException e) {
                }
            }
            j63 = j6.j6("ConnectTimeout");
            if (j63 != null) {
                try {
                    DW(Integer.parseInt(j63));
                } catch (NumberFormatException e2) {
                }
            }
            j63 = j6.j6("MaxAuthTries");
            if (j63 != null) {
                j6("MaxAuthTries", j63);
            }
            j63 = j6.j6("ClearAllForwardings");
            if (j63 != null) {
                j6("ClearAllForwardings", j63);
            }
        }
    }

    private void j6(ChannelSession channelSession) {
        ConfigRepository DW = this.aM.DW();
        if (DW != null) {
            Config j6 = DW.j6(this.J8);
            String j62 = j6.j6("ForwardAgent");
            if (j62 != null) {
                channelSession.j6(j62.equals("yes"));
            }
            String j63 = j6.j6("RequestTTY");
            if (j63 != null) {
                channelSession.DW(j63.equals("yes"));
            }
        }
    }

    private void Ws() {
        int i = 0;
        if (!v5("ClearAllForwardings").equals("yes")) {
            ConfigRepository DW = this.aM.DW();
            if (DW != null) {
                Config j6 = DW.j6(this.J8);
                String[] DW2 = j6.DW("LocalForward");
                if (DW2 != null) {
                    for (String DW3 : DW2) {
                        DW(DW3);
                    }
                }
                String[] DW4 = j6.DW("RemoteForward");
                if (DW4 != null) {
                    while (i < DW4.length) {
                        FH(DW4[i]);
                        i++;
                    }
                }
            }
        }
    }

    private void j6(Config config, String str) {
        String j6 = config.j6(str);
        if (j6 != null) {
            j6(str, j6);
        }
    }
}
