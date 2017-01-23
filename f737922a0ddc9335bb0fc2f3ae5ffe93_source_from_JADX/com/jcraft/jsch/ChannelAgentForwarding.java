package com.jcraft.jsch;

class ChannelAgentForwarding extends Channel {
    private final byte BT;
    private final byte KD;
    private final byte P8;
    private final byte SI;
    private Buffer Sf;
    boolean U2;
    private final byte a8;
    private final byte cb;
    private final byte cn;
    private Buffer dx;
    private Packet ef;
    private final byte ei;
    private final byte er;
    private final byte gW;
    private final byte lg;
    private final byte nw;
    private final byte rN;
    private final byte ro;
    private Buffer sG;
    private final byte sh;
    private final byte vy;
    private final byte yS;

    ChannelAgentForwarding() {
        this.a8 = (byte) 1;
        this.lg = (byte) 2;
        this.rN = (byte) 3;
        this.er = (byte) 4;
        this.yS = (byte) 5;
        this.gW = (byte) 6;
        this.BT = (byte) 7;
        this.vy = (byte) 8;
        this.P8 = (byte) 9;
        this.ei = (byte) 11;
        this.nw = (byte) 12;
        this.SI = (byte) 13;
        this.KD = (byte) 14;
        this.ro = (byte) 17;
        this.cn = (byte) 18;
        this.sh = (byte) 19;
        this.cb = (byte) 30;
        this.U2 = true;
        this.dx = null;
        this.sG = null;
        this.ef = null;
        this.Sf = null;
        FH(131072);
        Hw(131072);
        v5(16384);
        this.Hw = Util.DW("auth-agent@openssh.com");
        this.dx = new Buffer();
        this.dx.EQ();
        this.Sf = new Buffer();
        this.Ws = true;
    }

    public void run() {
        try {
            J8();
        } catch (Exception e) {
            this.J8 = true;
            tp();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(byte[] r10, int r11, int r12) {
        /*
        r9 = this;
        r1 = 0;
        r2 = 5;
        r0 = 6;
        r3 = 0;
        r4 = r9.ef;
        if (r4 != 0) goto L_0x001a;
    L_0x0008:
        r4 = new com.jcraft.jsch.Buffer;
        r5 = r9.u7;
        r4.<init>(r5);
        r9.sG = r4;
        r4 = new com.jcraft.jsch.Packet;
        r5 = r9.sG;
        r4.<init>(r5);
        r9.ef = r4;
    L_0x001a:
        r4 = r9.dx;
        r4.we();
        r4 = r9.dx;
        r4 = r4.DW;
        r4 = r4.length;
        r5 = r9.dx;
        r5 = r5.FH;
        r5 = r5 + r12;
        if (r4 >= r5) goto L_0x0042;
    L_0x002b:
        r4 = r9.dx;
        r4 = r4.Hw;
        r4 = r4 + r12;
        r4 = new byte[r4];
        r5 = r9.dx;
        r5 = r5.DW;
        r6 = r9.dx;
        r6 = r6.DW;
        r6 = r6.length;
        java.lang.System.arraycopy(r5, r3, r4, r3, r6);
        r5 = r9.dx;
        r5.DW = r4;
    L_0x0042:
        r4 = r9.dx;
        r4.j6(r10, r11, r12);
        r4 = r9.dx;
        r4 = r4.Hw();
        r5 = r9.dx;
        r5 = r5.j6();
        if (r4 <= r5) goto L_0x005e;
    L_0x0055:
        r0 = r9.dx;
        r1 = r0.Hw;
        r1 = r1 + -4;
        r0.Hw = r1;
    L_0x005d:
        return;
    L_0x005e:
        r4 = r9.dx;
        r4 = r4.VH();
        r5 = r9.J0();	 Catch:{ JSchException -> 0x00aa }
        r6 = r5.tp();
        r5 = r5.FH();
        r7 = r9.Sf;
        r7.EQ();
        r7 = 11;
        if (r4 != r7) goto L_0x00e7;
    L_0x0079:
        r0 = r9.Sf;
        r1 = 12;
        r0.j6(r1);
        r4 = r6.j6();
        monitor-enter(r4);
        r2 = r3;
        r1 = r3;
    L_0x0087:
        r0 = r4.size();	 Catch:{ all -> 0x00e4 }
        if (r2 < r0) goto L_0x00b5;
    L_0x008d:
        r0 = r9.Sf;	 Catch:{ all -> 0x00e4 }
        r0.j6(r1);	 Catch:{ all -> 0x00e4 }
    L_0x0092:
        r0 = r4.size();	 Catch:{ all -> 0x00e4 }
        if (r3 < r0) goto L_0x00c8;
    L_0x0098:
        monitor-exit(r4);	 Catch:{ all -> 0x00e4 }
    L_0x0099:
        r0 = r9.Sf;
        r0 = r0.j6();
        r0 = new byte[r0];
        r1 = r9.Sf;
        r1.Hw(r0);
        r9.j6(r0);
        goto L_0x005d;
    L_0x00aa:
        r0 = move-exception;
        r1 = new java.io.IOException;
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x00b5:
        r0 = r4.elementAt(r2);	 Catch:{ all -> 0x00e4 }
        r0 = (com.jcraft.jsch.Identity) r0;	 Catch:{ all -> 0x00e4 }
        r0 = r0.j6();	 Catch:{ all -> 0x00e4 }
        if (r0 == 0) goto L_0x01fd;
    L_0x00c1:
        r0 = r1 + 1;
    L_0x00c3:
        r1 = r2 + 1;
        r2 = r1;
        r1 = r0;
        goto L_0x0087;
    L_0x00c8:
        r0 = r4.elementAt(r3);	 Catch:{ all -> 0x00e4 }
        r0 = (com.jcraft.jsch.Identity) r0;	 Catch:{ all -> 0x00e4 }
        r0 = r0.j6();	 Catch:{ all -> 0x00e4 }
        if (r0 != 0) goto L_0x00d7;
    L_0x00d4:
        r3 = r3 + 1;
        goto L_0x0092;
    L_0x00d7:
        r1 = r9.Sf;	 Catch:{ all -> 0x00e4 }
        r1.DW(r0);	 Catch:{ all -> 0x00e4 }
        r0 = r9.Sf;	 Catch:{ all -> 0x00e4 }
        r1 = com.jcraft.jsch.Util.j6;	 Catch:{ all -> 0x00e4 }
        r0.DW(r1);	 Catch:{ all -> 0x00e4 }
        goto L_0x00d4;
    L_0x00e4:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00e4 }
        throw r0;
    L_0x00e7:
        r7 = 1;
        if (r4 != r7) goto L_0x00f6;
    L_0x00ea:
        r0 = r9.Sf;
        r1 = 2;
        r0.j6(r1);
        r0 = r9.Sf;
        r0.j6(r3);
        goto L_0x0099;
    L_0x00f6:
        r7 = 13;
        if (r4 != r7) goto L_0x0199;
    L_0x00fa:
        r0 = r9.dx;
        r4 = r0.tp();
        r0 = r9.dx;
        r7 = r0.tp();
        r0 = r9.dx;
        r0.Hw();
        r6 = r6.j6();
        monitor-enter(r6);
        r2 = r3;
    L_0x0111:
        r0 = r6.size();	 Catch:{ all -> 0x0188 }
        if (r2 < r0) goto L_0x012d;
    L_0x0117:
        r2 = r1;
    L_0x0118:
        monitor-exit(r6);	 Catch:{ all -> 0x0188 }
        r0 = r1;
        r0 = (byte[]) r0;
        if (r2 == 0) goto L_0x0122;
    L_0x011e:
        r0 = r2.DW(r7);
    L_0x0122:
        if (r0 != 0) goto L_0x018b;
    L_0x0124:
        r0 = r9.Sf;
        r1 = 30;
        r0.j6(r1);
        goto L_0x0099;
    L_0x012d:
        r0 = r6.elementAt(r2);	 Catch:{ all -> 0x0188 }
        r0 = (com.jcraft.jsch.Identity) r0;	 Catch:{ all -> 0x0188 }
        r3 = r0.j6();	 Catch:{ all -> 0x0188 }
        if (r3 != 0) goto L_0x013d;
    L_0x0139:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0111;
    L_0x013d:
        r3 = r0.j6();	 Catch:{ all -> 0x0188 }
        r3 = com.jcraft.jsch.Util.DW(r4, r3);	 Catch:{ all -> 0x0188 }
        if (r3 == 0) goto L_0x0139;
    L_0x0147:
        r3 = r0.Hw();	 Catch:{ all -> 0x0188 }
        if (r3 == 0) goto L_0x0155;
    L_0x014d:
        if (r5 == 0) goto L_0x0139;
    L_0x014f:
        r3 = r0.Hw();	 Catch:{ all -> 0x0188 }
        if (r3 != 0) goto L_0x015d;
    L_0x0155:
        r3 = r0.Hw();	 Catch:{ all -> 0x0188 }
        if (r3 != 0) goto L_0x0139;
    L_0x015b:
        r2 = r0;
        goto L_0x0118;
    L_0x015d:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0188 }
        r8 = "Passphrase for ";
        r3.<init>(r8);	 Catch:{ all -> 0x0188 }
        r8 = r0.FH();	 Catch:{ all -> 0x0188 }
        r3 = r3.append(r8);	 Catch:{ all -> 0x0188 }
        r3 = r3.toString();	 Catch:{ all -> 0x0188 }
        r3 = r5.DW(r3);	 Catch:{ all -> 0x0188 }
        if (r3 == 0) goto L_0x0155;
    L_0x0177:
        r3 = r5.j6();	 Catch:{ all -> 0x0188 }
        if (r3 == 0) goto L_0x0155;
    L_0x017d:
        r3 = com.jcraft.jsch.Util.DW(r3);	 Catch:{ all -> 0x0188 }
        r3 = r0.j6(r3);	 Catch:{ JSchException -> 0x01fa }
        if (r3 == 0) goto L_0x014f;
    L_0x0187:
        goto L_0x0155;
    L_0x0188:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0188 }
        throw r0;
    L_0x018b:
        r1 = r9.Sf;
        r2 = 14;
        r1.j6(r2);
        r1 = r9.Sf;
        r1.DW(r0);
        goto L_0x0099;
    L_0x0199:
        r1 = 18;
        if (r4 != r1) goto L_0x01ad;
    L_0x019d:
        r1 = r9.dx;
        r1 = r1.tp();
        r6.DW(r1);
        r1 = r9.Sf;
        r1.j6(r0);
        goto L_0x0099;
    L_0x01ad:
        r1 = 9;
        if (r4 != r1) goto L_0x01b8;
    L_0x01b1:
        r1 = r9.Sf;
        r1.j6(r0);
        goto L_0x0099;
    L_0x01b8:
        r1 = 19;
        if (r4 != r1) goto L_0x01c6;
    L_0x01bc:
        r6.DW();
        r1 = r9.Sf;
        r1.j6(r0);
        goto L_0x0099;
    L_0x01c6:
        r1 = 17;
        if (r4 != r1) goto L_0x01e6;
    L_0x01ca:
        r1 = r9.dx;
        r1 = r1.j6();
        r1 = new byte[r1];
        r3 = r9.dx;
        r3.Hw(r1);
        r1 = r6.j6(r1);
        r3 = r9.Sf;
        if (r1 == 0) goto L_0x01e4;
    L_0x01df:
        r3.j6(r0);
        goto L_0x0099;
    L_0x01e4:
        r0 = r2;
        goto L_0x01df;
    L_0x01e6:
        r0 = r9.dx;
        r1 = r9.dx;
        r1 = r1.j6();
        r1 = r1 + -1;
        r0.DW(r1);
        r0 = r9.Sf;
        r0.j6(r2);
        goto L_0x0099;
    L_0x01fa:
        r3 = move-exception;
        goto L_0x0155;
    L_0x01fd:
        r0 = r1;
        goto L_0x00c3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.ChannelAgentForwarding.j6(byte[], int, int):void");
    }

    private void j6(byte[] bArr) {
        this.ef.j6();
        this.sG.j6((byte) 94);
        this.sG.j6(this.FH);
        this.sG.j6(bArr.length + 4);
        this.sG.DW(bArr);
        try {
            J0().j6(this.ef, (Channel) this, bArr.length + 4);
        } catch (Exception e) {
        }
    }

    void VH() {
        super.VH();
        gn();
    }
}
