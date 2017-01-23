package com.jcraft.jsch;

class UserAuthPassword extends UserAuth {
    private final int v5;

    UserAuthPassword() {
        this.v5 = 60;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j6(com.jcraft.jsch.Session r13) {
        /*
        r12 = this;
        r7 = 1;
        r8 = 0;
        r6 = 0;
        super.j6(r13);
        r2 = r13.XL;
        r0 = new java.lang.StringBuilder;
        r1 = r12.Hw;
        r1 = java.lang.String.valueOf(r1);
        r0.<init>(r1);
        r1 = "@";
        r0 = r0.append(r1);
        r1 = r13.J0;
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = r13.Ws;
        r3 = 22;
        if (r0 == r3) goto L_0x0044;
    L_0x002a:
        r0 = new java.lang.StringBuilder;
        r1 = java.lang.String.valueOf(r1);
        r0.<init>(r1);
        r1 = ":";
        r0 = r0.append(r1);
        r1 = r13.Ws;
        r0 = r0.append(r1);
        r1 = r0.toString();
    L_0x0044:
        r0 = r13.we;	 Catch:{ all -> 0x007b }
        r3 = r13.EQ;	 Catch:{ all -> 0x007b }
        if (r0 < r3) goto L_0x0054;
    L_0x004a:
        if (r2 == 0) goto L_0x0052;
    L_0x004c:
        com.jcraft.jsch.Util.Hw(r2);
        r0 = r6;
        r0 = (byte[]) r0;
    L_0x0052:
        r0 = r8;
    L_0x0053:
        return r0;
    L_0x0054:
        if (r2 != 0) goto L_0x0224;
    L_0x0056:
        r0 = r12.j6;	 Catch:{ all -> 0x007b }
        if (r0 == 0) goto L_0x004a;
    L_0x005a:
        r0 = r12.j6;	 Catch:{ all -> 0x007b }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007b }
        r4 = "Password for ";
        r3.<init>(r4);	 Catch:{ all -> 0x007b }
        r3 = r3.append(r1);	 Catch:{ all -> 0x007b }
        r3 = r3.toString();	 Catch:{ all -> 0x007b }
        r0 = r0.j6(r3);	 Catch:{ all -> 0x007b }
        if (r0 != 0) goto L_0x0085;
    L_0x0072:
        r0 = new com.jcraft.jsch.JSchAuthCancelException;	 Catch:{ all -> 0x007b }
        r1 = "password";
        r0.<init>(r1);	 Catch:{ all -> 0x007b }
        throw r0;	 Catch:{ all -> 0x007b }
    L_0x007b:
        r0 = move-exception;
        r1 = r2;
    L_0x007d:
        if (r1 == 0) goto L_0x0084;
    L_0x007f:
        com.jcraft.jsch.Util.Hw(r1);
        r6 = (byte[]) r6;
    L_0x0084:
        throw r0;
    L_0x0085:
        r0 = r12.j6;	 Catch:{ all -> 0x007b }
        r0 = r0.DW();	 Catch:{ all -> 0x007b }
        if (r0 != 0) goto L_0x0096;
    L_0x008d:
        r0 = new com.jcraft.jsch.JSchAuthCancelException;	 Catch:{ all -> 0x007b }
        r1 = "password";
        r0.<init>(r1);	 Catch:{ all -> 0x007b }
        throw r0;	 Catch:{ all -> 0x007b }
    L_0x0096:
        r9 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ all -> 0x007b }
    L_0x009a:
        r0 = 0;
        r0 = (byte[]) r0;	 Catch:{ all -> 0x0126 }
        r0 = r12.Hw;	 Catch:{ all -> 0x0126 }
        r10 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ all -> 0x0126 }
        r0 = r12.DW;	 Catch:{ all -> 0x0126 }
        r0.j6();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r2 = 50;
        r0.j6(r2);	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.DW(r10);	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r2 = "ssh-connection";
        r2 = com.jcraft.jsch.Util.DW(r2);	 Catch:{ all -> 0x0126 }
        r0.DW(r2);	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r2 = "password";
        r2 = com.jcraft.jsch.Util.DW(r2);	 Catch:{ all -> 0x0126 }
        r0.DW(r2);	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r2 = 0;
        r0.j6(r2);	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.DW(r9);	 Catch:{ all -> 0x0126 }
        r0 = r12.DW;	 Catch:{ all -> 0x0126 }
        r13.DW(r0);	 Catch:{ all -> 0x0126 }
    L_0x00dc:
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0 = r13.j6(r0);	 Catch:{ all -> 0x0126 }
        r12.FH = r0;	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0 = r0.J8();	 Catch:{ all -> 0x0126 }
        r0 = r0 & 255;
        r2 = 52;
        if (r0 != r2) goto L_0x00fa;
    L_0x00f0:
        if (r9 == 0) goto L_0x00f7;
    L_0x00f2:
        com.jcraft.jsch.Util.Hw(r9);
        r6 = (byte[]) r6;
    L_0x00f7:
        r0 = r7;
        goto L_0x0053;
    L_0x00fa:
        r2 = 53;
        if (r0 != r2) goto L_0x012a;
    L_0x00fe:
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.Hw();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.VH();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.VH();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0 = r0.tp();	 Catch:{ all -> 0x0126 }
        r2 = r12.FH;	 Catch:{ all -> 0x0126 }
        r2.tp();	 Catch:{ all -> 0x0126 }
        r0 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ all -> 0x0126 }
        r2 = r12.j6;	 Catch:{ all -> 0x0126 }
        if (r2 == 0) goto L_0x00dc;
    L_0x0120:
        r2 = r12.j6;	 Catch:{ all -> 0x0126 }
        r2.Hw(r0);	 Catch:{ all -> 0x0126 }
        goto L_0x00dc;
    L_0x0126:
        r0 = move-exception;
        r1 = r9;
        goto L_0x007d;
    L_0x012a:
        r2 = 60;
        if (r0 != r2) goto L_0x01db;
    L_0x012e:
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.Hw();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.VH();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.VH();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r3 = r0.tp();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.tp();	 Catch:{ all -> 0x0126 }
        r0 = r12.j6;	 Catch:{ all -> 0x0126 }
        if (r0 == 0) goto L_0x0152;
    L_0x014c:
        r0 = r12.j6;	 Catch:{ all -> 0x0126 }
        r0 = r0 instanceof com.jcraft.jsch.UIKeyboardInteractive;	 Catch:{ all -> 0x0126 }
        if (r0 != 0) goto L_0x0168;
    L_0x0152:
        r0 = r12.j6;	 Catch:{ all -> 0x0126 }
        if (r0 == 0) goto L_0x015e;
    L_0x0156:
        r0 = r12.j6;	 Catch:{ all -> 0x0126 }
        r1 = "Password must be changed.";
        r0.Hw(r1);	 Catch:{ all -> 0x0126 }
    L_0x015e:
        if (r9 == 0) goto L_0x0165;
    L_0x0160:
        com.jcraft.jsch.Util.Hw(r9);
        r6 = (byte[]) r6;
    L_0x0165:
        r0 = r8;
        goto L_0x0053;
    L_0x0168:
        r0 = r12.j6;	 Catch:{ all -> 0x0126 }
        r0 = (com.jcraft.jsch.UIKeyboardInteractive) r0;	 Catch:{ all -> 0x0126 }
        r2 = "Password Change Required";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0126 }
        r5 = 0;
        r11 = "New Password: ";
        r4[r5] = r11;	 Catch:{ all -> 0x0126 }
        r5 = 1;
        r5 = new boolean[r5];	 Catch:{ all -> 0x0126 }
        r3 = com.jcraft.jsch.Util.DW(r3);	 Catch:{ all -> 0x0126 }
        r0 = r0.j6(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0126 }
        if (r0 != 0) goto L_0x018e;
    L_0x0185:
        r0 = new com.jcraft.jsch.JSchAuthCancelException;	 Catch:{ all -> 0x0126 }
        r1 = "password";
        r0.<init>(r1);	 Catch:{ all -> 0x0126 }
        throw r0;	 Catch:{ all -> 0x0126 }
    L_0x018e:
        r2 = 0;
        r0 = r0[r2];	 Catch:{ all -> 0x0126 }
        r0 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ all -> 0x0126 }
        r2 = r12.DW;	 Catch:{ all -> 0x0126 }
        r2.j6();	 Catch:{ all -> 0x0126 }
        r2 = r12.FH;	 Catch:{ all -> 0x0126 }
        r3 = 50;
        r2.j6(r3);	 Catch:{ all -> 0x0126 }
        r2 = r12.FH;	 Catch:{ all -> 0x0126 }
        r2.DW(r10);	 Catch:{ all -> 0x0126 }
        r2 = r12.FH;	 Catch:{ all -> 0x0126 }
        r3 = "ssh-connection";
        r3 = com.jcraft.jsch.Util.DW(r3);	 Catch:{ all -> 0x0126 }
        r2.DW(r3);	 Catch:{ all -> 0x0126 }
        r2 = r12.FH;	 Catch:{ all -> 0x0126 }
        r3 = "password";
        r3 = com.jcraft.jsch.Util.DW(r3);	 Catch:{ all -> 0x0126 }
        r2.DW(r3);	 Catch:{ all -> 0x0126 }
        r2 = r12.FH;	 Catch:{ all -> 0x0126 }
        r3 = 1;
        r2.j6(r3);	 Catch:{ all -> 0x0126 }
        r2 = r12.FH;	 Catch:{ all -> 0x0126 }
        r2.DW(r9);	 Catch:{ all -> 0x0126 }
        r2 = r12.FH;	 Catch:{ all -> 0x0126 }
        r2.DW(r0);	 Catch:{ all -> 0x0126 }
        com.jcraft.jsch.Util.Hw(r0);	 Catch:{ all -> 0x0126 }
        r0 = 0;
        r0 = (java.lang.String[]) r0;	 Catch:{ all -> 0x0126 }
        r0 = r12.DW;	 Catch:{ all -> 0x0126 }
        r13.DW(r0);	 Catch:{ all -> 0x0126 }
        goto L_0x00dc;
    L_0x01db:
        r2 = 51;
        if (r0 != r2) goto L_0x0217;
    L_0x01df:
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.Hw();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.VH();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0.VH();	 Catch:{ all -> 0x0126 }
        r0 = r12.FH;	 Catch:{ all -> 0x0126 }
        r0 = r0.tp();	 Catch:{ all -> 0x0126 }
        r2 = r12.FH;	 Catch:{ all -> 0x0126 }
        r2 = r2.VH();	 Catch:{ all -> 0x0126 }
        if (r2 == 0) goto L_0x0206;
    L_0x01fc:
        r1 = new com.jcraft.jsch.JSchPartialAuthException;	 Catch:{ all -> 0x0126 }
        r0 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ all -> 0x0126 }
        r1.<init>(r0);	 Catch:{ all -> 0x0126 }
        throw r1;	 Catch:{ all -> 0x0126 }
    L_0x0206:
        r0 = r13.we;	 Catch:{ all -> 0x0126 }
        r0 = r0 + 1;
        r13.we = r0;	 Catch:{ all -> 0x0126 }
        if (r9 == 0) goto L_0x0221;
    L_0x020e:
        com.jcraft.jsch.Util.Hw(r9);	 Catch:{ all -> 0x0126 }
        r0 = 0;
        r0 = (byte[]) r0;	 Catch:{ all -> 0x0126 }
        r2 = r0;
        goto L_0x0044;
    L_0x0217:
        if (r9 == 0) goto L_0x021e;
    L_0x0219:
        com.jcraft.jsch.Util.Hw(r9);
        r6 = (byte[]) r6;
    L_0x021e:
        r0 = r8;
        goto L_0x0053;
    L_0x0221:
        r2 = r9;
        goto L_0x0044;
    L_0x0224:
        r9 = r2;
        goto L_0x009a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.UserAuthPassword.j6(com.jcraft.jsch.Session):boolean");
    }
}
