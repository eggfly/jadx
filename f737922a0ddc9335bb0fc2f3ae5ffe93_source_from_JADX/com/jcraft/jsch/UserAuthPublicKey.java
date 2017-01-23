package com.jcraft.jsch;

class UserAuthPublicKey extends UserAuth {
    UserAuthPublicKey() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j6(com.jcraft.jsch.Session r14) {
        /*
        r13 = this;
        r7 = 5;
        r3 = 1;
        r1 = 0;
        r2 = 0;
        super.j6(r14);
        r0 = r14.tp();
        r9 = r0.j6();
        r0 = r1;
        r0 = (byte[]) r0;
        r1 = (byte[]) r1;
        monitor-enter(r9);
        r1 = r9.size();	 Catch:{ all -> 0x00d6 }
        if (r1 > 0) goto L_0x001e;
    L_0x001b:
        monitor-exit(r9);	 Catch:{ all -> 0x00d6 }
        r0 = r2;
    L_0x001d:
        return r0;
    L_0x001e:
        r1 = r13.Hw;	 Catch:{ all -> 0x00d6 }
        r10 = com.jcraft.jsch.Util.DW(r1);	 Catch:{ all -> 0x00d6 }
        r8 = r2;
        r1 = r0;
    L_0x0026:
        r0 = r9.size();	 Catch:{ all -> 0x00d6 }
        if (r8 < r0) goto L_0x002f;
    L_0x002c:
        monitor-exit(r9);	 Catch:{ all -> 0x00d6 }
        r0 = r2;
        goto L_0x001d;
    L_0x002f:
        r0 = r14.we;	 Catch:{ all -> 0x00d6 }
        r4 = r14.EQ;	 Catch:{ all -> 0x00d6 }
        if (r0 < r4) goto L_0x0038;
    L_0x0035:
        monitor-exit(r9);	 Catch:{ all -> 0x00d6 }
        r0 = r2;
        goto L_0x001d;
    L_0x0038:
        r0 = r9.elementAt(r8);	 Catch:{ all -> 0x00d6 }
        r0 = (com.jcraft.jsch.Identity) r0;	 Catch:{ all -> 0x00d6 }
        r4 = r0.j6();	 Catch:{ all -> 0x00d6 }
        if (r4 == 0) goto L_0x00d9;
    L_0x0044:
        r5 = r13.DW;	 Catch:{ all -> 0x00d6 }
        r5.j6();	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = 50;
        r5.j6(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5.DW(r10);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = "ssh-connection";
        r6 = com.jcraft.jsch.Util.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = "publickey";
        r6 = com.jcraft.jsch.Util.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = 0;
        r5.j6(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = r0.DW();	 Catch:{ all -> 0x00d6 }
        r6 = com.jcraft.jsch.Util.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5.DW(r4);	 Catch:{ all -> 0x00d6 }
        r5 = r13.DW;	 Catch:{ all -> 0x00d6 }
        r14.DW(r5);	 Catch:{ all -> 0x00d6 }
    L_0x008a:
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5 = r14.j6(r5);	 Catch:{ all -> 0x00d6 }
        r13.FH = r5;	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5 = r5.J8();	 Catch:{ all -> 0x00d6 }
        r5 = r5 & 255;
        r6 = 60;
        if (r5 != r6) goto L_0x00a6;
    L_0x009e:
        r6 = 60;
        if (r5 == r6) goto L_0x00d9;
    L_0x00a2:
        r0 = r8 + 1;
        r8 = r0;
        goto L_0x0026;
    L_0x00a6:
        r6 = 51;
        if (r5 == r6) goto L_0x009e;
    L_0x00aa:
        r6 = 53;
        if (r5 != r6) goto L_0x009e;
    L_0x00ae:
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5.Hw();	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5.VH();	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5.VH();	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5 = r5.tp();	 Catch:{ all -> 0x00d6 }
        r6 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6.tp();	 Catch:{ all -> 0x00d6 }
        r5 = com.jcraft.jsch.Util.DW(r5);	 Catch:{ all -> 0x00d6 }
        r6 = r13.j6;	 Catch:{ all -> 0x00d6 }
        if (r6 == 0) goto L_0x008a;
    L_0x00d0:
        r6 = r13.j6;	 Catch:{ all -> 0x00d6 }
        r6.Hw(r5);	 Catch:{ all -> 0x00d6 }
        goto L_0x008a;
    L_0x00d6:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00d6 }
        throw r0;
    L_0x00d9:
        r6 = r7;
        r5 = r1;
    L_0x00db:
        r1 = r0.Hw();	 Catch:{ all -> 0x00d6 }
        if (r1 == 0) goto L_0x0127;
    L_0x00e1:
        if (r5 != 0) goto L_0x0127;
    L_0x00e3:
        r1 = r13.j6;	 Catch:{ all -> 0x00d6 }
        if (r1 != 0) goto L_0x00f0;
    L_0x00e7:
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ all -> 0x00d6 }
        r1 = "USERAUTH fail";
        r0.<init>(r1);	 Catch:{ all -> 0x00d6 }
        throw r0;	 Catch:{ all -> 0x00d6 }
    L_0x00f0:
        r1 = r0.Hw();	 Catch:{ all -> 0x00d6 }
        if (r1 == 0) goto L_0x011b;
    L_0x00f6:
        r1 = r13.j6;	 Catch:{ all -> 0x00d6 }
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d6 }
        r12 = "Passphrase for ";
        r11.<init>(r12);	 Catch:{ all -> 0x00d6 }
        r12 = r0.FH();	 Catch:{ all -> 0x00d6 }
        r11 = r11.append(r12);	 Catch:{ all -> 0x00d6 }
        r11 = r11.toString();	 Catch:{ all -> 0x00d6 }
        r1 = r1.DW(r11);	 Catch:{ all -> 0x00d6 }
        if (r1 != 0) goto L_0x011b;
    L_0x0112:
        r0 = new com.jcraft.jsch.JSchAuthCancelException;	 Catch:{ all -> 0x00d6 }
        r1 = "publickey";
        r0.<init>(r1);	 Catch:{ all -> 0x00d6 }
        throw r0;	 Catch:{ all -> 0x00d6 }
    L_0x011b:
        r1 = r13.j6;	 Catch:{ all -> 0x00d6 }
        r1 = r1.j6();	 Catch:{ all -> 0x00d6 }
        if (r1 == 0) goto L_0x0127;
    L_0x0123:
        r5 = com.jcraft.jsch.Util.DW(r1);	 Catch:{ all -> 0x00d6 }
    L_0x0127:
        r1 = r0.Hw();	 Catch:{ all -> 0x00d6 }
        if (r1 == 0) goto L_0x012f;
    L_0x012d:
        if (r5 == 0) goto L_0x0201;
    L_0x012f:
        r1 = r0.j6(r5);	 Catch:{ all -> 0x00d6 }
        if (r1 == 0) goto L_0x0201;
    L_0x0135:
        if (r5 == 0) goto L_0x026e;
    L_0x0137:
        r1 = r14.tp();	 Catch:{ all -> 0x00d6 }
        r1 = r1 instanceof com.jcraft.jsch.IdentityRepository.Wrapper;	 Catch:{ all -> 0x00d6 }
        if (r1 == 0) goto L_0x026e;
    L_0x013f:
        r1 = r14.tp();	 Catch:{ all -> 0x00d6 }
        r1 = (com.jcraft.jsch.IdentityRepository.Wrapper) r1;	 Catch:{ all -> 0x00d6 }
        r1.FH();	 Catch:{ all -> 0x00d6 }
        r1 = r5;
    L_0x0149:
        com.jcraft.jsch.Util.Hw(r1);	 Catch:{ all -> 0x00d6 }
        r1 = 0;
        r1 = (byte[]) r1;	 Catch:{ all -> 0x00d6 }
        r5 = r0.Hw();	 Catch:{ all -> 0x00d6 }
        if (r5 != 0) goto L_0x00a2;
    L_0x0155:
        if (r4 != 0) goto L_0x015b;
    L_0x0157:
        r4 = r0.j6();	 Catch:{ all -> 0x00d6 }
    L_0x015b:
        if (r4 == 0) goto L_0x00a2;
    L_0x015d:
        r5 = r13.DW;	 Catch:{ all -> 0x00d6 }
        r5.j6();	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = 50;
        r5.j6(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5.DW(r10);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = "ssh-connection";
        r6 = com.jcraft.jsch.Util.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = "publickey";
        r6 = com.jcraft.jsch.Util.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = 1;
        r5.j6(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r6 = r0.DW();	 Catch:{ all -> 0x00d6 }
        r6 = com.jcraft.jsch.Util.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5.DW(r6);	 Catch:{ all -> 0x00d6 }
        r5 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r5.DW(r4);	 Catch:{ all -> 0x00d6 }
        r4 = r14.j6();	 Catch:{ all -> 0x00d6 }
        r5 = r4.length;	 Catch:{ all -> 0x00d6 }
        r6 = r5 + 4;
        r11 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r11 = r11.FH;	 Catch:{ all -> 0x00d6 }
        r6 = r6 + r11;
        r6 = r6 + -5;
        r6 = new byte[r6];	 Catch:{ all -> 0x00d6 }
        r11 = 0;
        r12 = r5 >>> 24;
        r12 = (byte) r12;	 Catch:{ all -> 0x00d6 }
        r6[r11] = r12;	 Catch:{ all -> 0x00d6 }
        r11 = 1;
        r12 = r5 >>> 16;
        r12 = (byte) r12;	 Catch:{ all -> 0x00d6 }
        r6[r11] = r12;	 Catch:{ all -> 0x00d6 }
        r11 = 2;
        r12 = r5 >>> 8;
        r12 = (byte) r12;	 Catch:{ all -> 0x00d6 }
        r6[r11] = r12;	 Catch:{ all -> 0x00d6 }
        r11 = 3;
        r12 = (byte) r5;	 Catch:{ all -> 0x00d6 }
        r6[r11] = r12;	 Catch:{ all -> 0x00d6 }
        r11 = 0;
        r12 = 4;
        java.lang.System.arraycopy(r4, r11, r6, r12, r5);	 Catch:{ all -> 0x00d6 }
        r4 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r4 = r4.DW;	 Catch:{ all -> 0x00d6 }
        r11 = 5;
        r5 = r5 + 4;
        r12 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r12 = r12.FH;	 Catch:{ all -> 0x00d6 }
        r12 = r12 + -5;
        java.lang.System.arraycopy(r4, r11, r6, r5, r12);	 Catch:{ all -> 0x00d6 }
        r0 = r0.DW(r6);	 Catch:{ all -> 0x00d6 }
        if (r0 == 0) goto L_0x002c;
    L_0x01df:
        r4 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r4.DW(r0);	 Catch:{ all -> 0x00d6 }
        r0 = r13.DW;	 Catch:{ all -> 0x00d6 }
        r14.DW(r0);	 Catch:{ all -> 0x00d6 }
    L_0x01e9:
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0 = r14.j6(r0);	 Catch:{ all -> 0x00d6 }
        r13.FH = r0;	 Catch:{ all -> 0x00d6 }
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0 = r0.J8();	 Catch:{ all -> 0x00d6 }
        r0 = r0 & 255;
        r4 = 52;
        if (r0 != r4) goto L_0x020f;
    L_0x01fd:
        monitor-exit(r9);	 Catch:{ all -> 0x00d6 }
        r0 = r3;
        goto L_0x001d;
    L_0x0201:
        com.jcraft.jsch.Util.Hw(r5);	 Catch:{ all -> 0x00d6 }
        r1 = 0;
        r1 = (byte[]) r1;	 Catch:{ all -> 0x00d6 }
        r5 = r6 + -1;
        if (r5 == 0) goto L_0x0149;
    L_0x020b:
        r6 = r5;
        r5 = r1;
        goto L_0x00db;
    L_0x020f:
        r4 = 53;
        if (r0 != r4) goto L_0x023b;
    L_0x0213:
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0.Hw();	 Catch:{ all -> 0x00d6 }
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0.VH();	 Catch:{ all -> 0x00d6 }
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0.VH();	 Catch:{ all -> 0x00d6 }
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0 = r0.tp();	 Catch:{ all -> 0x00d6 }
        r4 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r4.tp();	 Catch:{ all -> 0x00d6 }
        r0 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ all -> 0x00d6 }
        r4 = r13.j6;	 Catch:{ all -> 0x00d6 }
        if (r4 == 0) goto L_0x01e9;
    L_0x0235:
        r4 = r13.j6;	 Catch:{ all -> 0x00d6 }
        r4.Hw(r0);	 Catch:{ all -> 0x00d6 }
        goto L_0x01e9;
    L_0x023b:
        r4 = 51;
        if (r0 != r4) goto L_0x00a2;
    L_0x023f:
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0.Hw();	 Catch:{ all -> 0x00d6 }
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0.VH();	 Catch:{ all -> 0x00d6 }
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0.VH();	 Catch:{ all -> 0x00d6 }
        r0 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r0 = r0.tp();	 Catch:{ all -> 0x00d6 }
        r4 = r13.FH;	 Catch:{ all -> 0x00d6 }
        r4 = r4.VH();	 Catch:{ all -> 0x00d6 }
        if (r4 == 0) goto L_0x0266;
    L_0x025c:
        r1 = new com.jcraft.jsch.JSchPartialAuthException;	 Catch:{ all -> 0x00d6 }
        r0 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ all -> 0x00d6 }
        r1.<init>(r0);	 Catch:{ all -> 0x00d6 }
        throw r1;	 Catch:{ all -> 0x00d6 }
    L_0x0266:
        r0 = r14.we;	 Catch:{ all -> 0x00d6 }
        r0 = r0 + 1;
        r14.we = r0;	 Catch:{ all -> 0x00d6 }
        goto L_0x00a2;
    L_0x026e:
        r1 = r5;
        goto L_0x0149;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.UserAuthPublicKey.j6(com.jcraft.jsch.Session):boolean");
    }
}
