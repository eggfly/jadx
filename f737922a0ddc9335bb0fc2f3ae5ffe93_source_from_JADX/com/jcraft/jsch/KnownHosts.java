package com.jcraft.jsch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Vector;

public class KnownHosts implements HostKeyRepository {
    private static final byte[] Zo;
    private static final byte[] v5;
    private String DW;
    private Vector FH;
    private MAC Hw;
    private JSch j6;

    class HashedHostKey extends HostKey {
        byte[] VH;
        byte[] Zo;
        final /* synthetic */ KnownHosts gn;
        private boolean u7;

        HashedHostKey(KnownHosts knownHosts, String str, byte[] bArr) {
            this(knownHosts, str, 0, bArr);
        }

        HashedHostKey(KnownHosts knownHosts, String str, int i, byte[] bArr) {
            this(knownHosts, "", str, i, bArr, null);
        }

        HashedHostKey(KnownHosts knownHosts, String str, String str2, int i, byte[] bArr, String str3) {
            this.gn = knownHosts;
            super(str, str2, i, bArr, str3);
            this.u7 = false;
            this.Zo = null;
            this.VH = null;
            if (this.DW.startsWith("|1|") && this.DW.substring("|1|".length()).indexOf("|") > 0) {
                String substring = this.DW.substring("|1|".length());
                String substring2 = substring.substring(0, substring.indexOf("|"));
                substring = substring.substring(substring.indexOf("|") + 1);
                this.Zo = Util.j6(Util.DW(substring2), 0, substring2.length());
                this.VH = Util.j6(Util.DW(substring), 0, substring.length());
                if (this.Zo.length == 20 && this.VH.length == 20) {
                    this.u7 = true;
                    return;
                }
                this.Zo = null;
                this.VH = null;
            }
        }

        boolean j6(String str) {
            if (!this.u7) {
                return super.j6(str);
            }
            MAC j6 = this.gn.FH();
            try {
                boolean DW;
                synchronized (j6) {
                    j6.j6(this.Zo);
                    byte[] DW2 = Util.DW(str);
                    j6.j6(DW2, 0, DW2.length);
                    DW2 = new byte[j6.j6()];
                    j6.j6(DW2, 0);
                    DW = Util.DW(this.VH, DW2);
                }
                return DW;
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }

        boolean Zo() {
            return this.u7;
        }

        void VH() {
            if (!this.u7) {
                MAC j6 = this.gn.FH();
                if (this.Zo == null) {
                    Random random = Session.Zo;
                    synchronized (random) {
                        this.Zo = new byte[j6.j6()];
                        random.j6(this.Zo, 0, this.Zo.length);
                    }
                }
                try {
                    synchronized (j6) {
                        j6.j6(this.Zo);
                        byte[] DW = Util.DW(this.DW);
                        j6.j6(DW, 0, DW.length);
                        this.VH = new byte[j6.j6()];
                        j6.j6(this.VH, 0);
                    }
                } catch (Exception e) {
                }
                this.DW = "|1|" + Util.DW(Util.DW(this.Zo, 0, this.Zo.length)) + "|" + Util.DW(Util.DW(this.VH, 0, this.VH.length));
                this.u7 = true;
            }
        }
    }

    KnownHosts(JSch jSch) {
        this.j6 = null;
        this.DW = null;
        this.FH = null;
        this.Hw = null;
        this.j6 = jSch;
        this.FH = new Vector();
    }

    void j6(String str) {
        try {
            this.DW = str;
            j6(new FileInputStream(Util.FH(str)));
        } catch (Throwable e) {
            throw new JSchException(e.toString(), e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(java.io.InputStream r11) {
        /*
        r10 = this;
        r0 = r10.FH;
        r0.removeAllElements();
        r8 = new java.lang.StringBuffer;
        r8.<init>();
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x01c8 }
    L_0x000e:
        r5 = 0;
        r7 = r0;
    L_0x0010:
        r1 = r11.read();	 Catch:{ Exception -> 0x01c8 }
        r0 = -1;
        if (r1 != r0) goto L_0x001d;
    L_0x0017:
        if (r5 != 0) goto L_0x0025;
    L_0x0019:
        r11.close();	 Catch:{ IOException -> 0x01f8 }
        return;
    L_0x001d:
        r0 = 13;
        if (r1 == r0) goto L_0x0010;
    L_0x0021:
        r0 = 10;
        if (r1 != r0) goto L_0x0034;
    L_0x0025:
        r0 = 0;
    L_0x0026:
        if (r0 < r5) goto L_0x004e;
    L_0x0028:
        if (r0 < r5) goto L_0x0069;
    L_0x002a:
        r0 = 0;
        r0 = com.jcraft.jsch.Util.FH(r7, r0, r5);	 Catch:{ Exception -> 0x01c8 }
        r10.FH(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r7;
        goto L_0x000e;
    L_0x0034:
        r0 = r7.length;	 Catch:{ Exception -> 0x01c8 }
        if (r0 > r5) goto L_0x0047;
    L_0x0037:
        r0 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        if (r5 > r0) goto L_0x0025;
    L_0x003b:
        r0 = r7.length;	 Catch:{ Exception -> 0x01c8 }
        r0 = r0 * 2;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x01c8 }
        r2 = 0;
        r3 = 0;
        r4 = r7.length;	 Catch:{ Exception -> 0x01c8 }
        java.lang.System.arraycopy(r7, r2, r0, r3, r4);	 Catch:{ Exception -> 0x01c8 }
        r7 = r0;
    L_0x0047:
        r0 = r5 + 1;
        r1 = (byte) r1;	 Catch:{ Exception -> 0x01c8 }
        r7[r5] = r1;	 Catch:{ Exception -> 0x01c8 }
        r5 = r0;
        goto L_0x0010;
    L_0x004e:
        r1 = r7[r0];	 Catch:{ Exception -> 0x01c8 }
        r2 = 32;
        if (r1 == r2) goto L_0x0058;
    L_0x0054:
        r2 = 9;
        if (r1 != r2) goto L_0x005b;
    L_0x0058:
        r0 = r0 + 1;
        goto L_0x0026;
    L_0x005b:
        r2 = 35;
        if (r1 != r2) goto L_0x0028;
    L_0x005f:
        r0 = 0;
        r0 = com.jcraft.jsch.Util.FH(r7, r0, r5);	 Catch:{ Exception -> 0x01c8 }
        r10.FH(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r7;
        goto L_0x000e;
    L_0x0069:
        r1 = 0;
        r8.setLength(r1);	 Catch:{ Exception -> 0x01c8 }
    L_0x006d:
        if (r0 < r5) goto L_0x0086;
    L_0x006f:
        r1 = r0;
    L_0x0070:
        r2 = r8.toString();	 Catch:{ Exception -> 0x01c8 }
        if (r1 >= r5) goto L_0x007c;
    L_0x0076:
        r0 = r2.length();	 Catch:{ Exception -> 0x01c8 }
        if (r0 != 0) goto L_0x00a4;
    L_0x007c:
        r0 = 0;
        r0 = com.jcraft.jsch.Util.FH(r7, r0, r5);	 Catch:{ Exception -> 0x01c8 }
        r10.FH(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r7;
        goto L_0x000e;
    L_0x0086:
        r1 = r0 + 1;
        r0 = r7[r0];	 Catch:{ Exception -> 0x01c8 }
        r2 = 32;
        if (r0 == r2) goto L_0x0070;
    L_0x008e:
        r2 = 9;
        if (r0 == r2) goto L_0x0070;
    L_0x0092:
        r0 = (char) r0;	 Catch:{ Exception -> 0x01c8 }
        r8.append(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r1;
        goto L_0x006d;
    L_0x0098:
        r0 = r7[r1];	 Catch:{ Exception -> 0x01c8 }
        r3 = 32;
        if (r0 == r3) goto L_0x00a2;
    L_0x009e:
        r3 = 9;
        if (r0 != r3) goto L_0x00a6;
    L_0x00a2:
        r1 = r1 + 1;
    L_0x00a4:
        if (r1 < r5) goto L_0x0098;
    L_0x00a6:
        r0 = "";
        r3 = 0;
        r3 = r2.charAt(r3);	 Catch:{ Exception -> 0x01c8 }
        r4 = 64;
        if (r3 != r4) goto L_0x0203;
    L_0x00b2:
        r0 = 0;
        r8.setLength(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r1;
    L_0x00b7:
        if (r0 < r5) goto L_0x00d1;
    L_0x00b9:
        r1 = r0;
    L_0x00ba:
        r3 = r8.toString();	 Catch:{ Exception -> 0x01c8 }
        if (r1 >= r5) goto L_0x00c6;
    L_0x00c0:
        r0 = r3.length();	 Catch:{ Exception -> 0x01c8 }
        if (r0 != 0) goto L_0x00ef;
    L_0x00c6:
        r0 = 0;
        r0 = com.jcraft.jsch.Util.FH(r7, r0, r5);	 Catch:{ Exception -> 0x01c8 }
        r10.FH(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r7;
        goto L_0x000e;
    L_0x00d1:
        r1 = r0 + 1;
        r0 = r7[r0];	 Catch:{ Exception -> 0x01c8 }
        r3 = 32;
        if (r0 == r3) goto L_0x00ba;
    L_0x00d9:
        r3 = 9;
        if (r0 == r3) goto L_0x00ba;
    L_0x00dd:
        r0 = (char) r0;	 Catch:{ Exception -> 0x01c8 }
        r8.append(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r1;
        goto L_0x00b7;
    L_0x00e3:
        r0 = r7[r1];	 Catch:{ Exception -> 0x01c8 }
        r4 = 32;
        if (r0 == r4) goto L_0x00ed;
    L_0x00e9:
        r4 = 9;
        if (r0 != r4) goto L_0x00f1;
    L_0x00ed:
        r1 = r1 + 1;
    L_0x00ef:
        if (r1 < r5) goto L_0x00e3;
    L_0x00f1:
        r0 = 0;
        r8.setLength(r0);	 Catch:{ Exception -> 0x01c8 }
        r4 = -1;
    L_0x00f6:
        if (r1 < r5) goto L_0x0114;
    L_0x00f8:
        r0 = r1;
    L_0x00f9:
        r1 = r8.toString();	 Catch:{ Exception -> 0x01c8 }
        r6 = "ssh-dss";
        r1 = r1.equals(r6);	 Catch:{ Exception -> 0x01c8 }
        if (r1 == 0) goto L_0x0126;
    L_0x0106:
        r4 = 1;
    L_0x0107:
        if (r0 < r5) goto L_0x0143;
    L_0x0109:
        r0 = 0;
        r0 = com.jcraft.jsch.Util.FH(r7, r0, r5);	 Catch:{ Exception -> 0x01c8 }
        r10.FH(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r7;
        goto L_0x000e;
    L_0x0114:
        r0 = r1 + 1;
        r1 = r7[r1];	 Catch:{ Exception -> 0x01c8 }
        r6 = 32;
        if (r1 == r6) goto L_0x00f9;
    L_0x011c:
        r6 = 9;
        if (r1 == r6) goto L_0x00f9;
    L_0x0120:
        r1 = (char) r1;	 Catch:{ Exception -> 0x01c8 }
        r8.append(r1);	 Catch:{ Exception -> 0x01c8 }
        r1 = r0;
        goto L_0x00f6;
    L_0x0126:
        r1 = r8.toString();	 Catch:{ Exception -> 0x01c8 }
        r6 = "ssh-rsa";
        r1 = r1.equals(r6);	 Catch:{ Exception -> 0x01c8 }
        if (r1 == 0) goto L_0x0135;
    L_0x0133:
        r4 = 2;
        goto L_0x0107;
    L_0x0135:
        r0 = r5;
        goto L_0x0107;
    L_0x0137:
        r1 = r7[r0];	 Catch:{ Exception -> 0x01c8 }
        r6 = 32;
        if (r1 == r6) goto L_0x0141;
    L_0x013d:
        r6 = 9;
        if (r1 != r6) goto L_0x0145;
    L_0x0141:
        r0 = r0 + 1;
    L_0x0143:
        if (r0 < r5) goto L_0x0137;
    L_0x0145:
        r1 = 0;
        r8.setLength(r1);	 Catch:{ Exception -> 0x01c8 }
        r1 = r0;
    L_0x014a:
        if (r1 < r5) goto L_0x0162;
    L_0x014c:
        r0 = r1;
    L_0x014d:
        r9 = r8.toString();	 Catch:{ Exception -> 0x01c8 }
        r1 = r9.length();	 Catch:{ Exception -> 0x01c8 }
        if (r1 != 0) goto L_0x018a;
    L_0x0157:
        r0 = 0;
        r0 = com.jcraft.jsch.Util.FH(r7, r0, r5);	 Catch:{ Exception -> 0x01c8 }
        r10.FH(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r7;
        goto L_0x000e;
    L_0x0162:
        r0 = r1 + 1;
        r1 = r7[r1];	 Catch:{ Exception -> 0x01c8 }
        r6 = 13;
        if (r1 != r6) goto L_0x016c;
    L_0x016a:
        r1 = r0;
        goto L_0x014a;
    L_0x016c:
        r6 = 10;
        if (r1 == r6) goto L_0x014d;
    L_0x0170:
        r6 = 32;
        if (r1 == r6) goto L_0x014d;
    L_0x0174:
        r6 = 9;
        if (r1 == r6) goto L_0x014d;
    L_0x0178:
        r1 = (char) r1;	 Catch:{ Exception -> 0x01c8 }
        r8.append(r1);	 Catch:{ Exception -> 0x01c8 }
        r1 = r0;
        goto L_0x014a;
    L_0x017e:
        r1 = r7[r0];	 Catch:{ Exception -> 0x01c8 }
        r6 = 32;
        if (r1 == r6) goto L_0x0188;
    L_0x0184:
        r6 = 9;
        if (r1 != r6) goto L_0x018c;
    L_0x0188:
        r0 = r0 + 1;
    L_0x018a:
        if (r0 < r5) goto L_0x017e;
    L_0x018c:
        r6 = 0;
        if (r0 >= r5) goto L_0x0199;
    L_0x018f:
        r1 = 0;
        r8.setLength(r1);	 Catch:{ Exception -> 0x01c8 }
    L_0x0193:
        if (r0 < r5) goto L_0x01b4;
    L_0x0195:
        r6 = r8.toString();	 Catch:{ Exception -> 0x01c8 }
    L_0x0199:
        r0 = new com.jcraft.jsch.KnownHosts$HashedHostKey;	 Catch:{ Exception -> 0x01c8 }
        r1 = com.jcraft.jsch.Util.DW(r9);	 Catch:{ Exception -> 0x01c8 }
        r5 = 0;
        r9 = r9.length();	 Catch:{ Exception -> 0x01c8 }
        r5 = com.jcraft.jsch.Util.j6(r1, r5, r9);	 Catch:{ Exception -> 0x01c8 }
        r1 = r10;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x01c8 }
        r1 = r10.FH;	 Catch:{ Exception -> 0x01c8 }
        r1.addElement(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r7;
        goto L_0x000e;
    L_0x01b4:
        r1 = r0 + 1;
        r0 = r7[r0];	 Catch:{ Exception -> 0x01c8 }
        r6 = 13;
        if (r0 != r6) goto L_0x01be;
    L_0x01bc:
        r0 = r1;
        goto L_0x0193;
    L_0x01be:
        r6 = 10;
        if (r0 == r6) goto L_0x0195;
    L_0x01c2:
        r0 = (char) r0;	 Catch:{ Exception -> 0x01c8 }
        r8.append(r0);	 Catch:{ Exception -> 0x01c8 }
        r0 = r1;
        goto L_0x0193;
    L_0x01c8:
        r0 = move-exception;
        r1 = r0 instanceof com.jcraft.jsch.JSchException;	 Catch:{ all -> 0x01d0 }
        if (r1 == 0) goto L_0x01d5;
    L_0x01cd:
        r0 = (com.jcraft.jsch.JSchException) r0;	 Catch:{ all -> 0x01d0 }
        throw r0;	 Catch:{ all -> 0x01d0 }
    L_0x01d0:
        r0 = move-exception;
        r11.close();	 Catch:{ IOException -> 0x01ed }
        throw r0;
    L_0x01d5:
        r1 = r0 instanceof java.lang.Throwable;	 Catch:{ all -> 0x01d0 }
        if (r1 == 0) goto L_0x01e3;
    L_0x01d9:
        r1 = new com.jcraft.jsch.JSchException;	 Catch:{ all -> 0x01d0 }
        r2 = r0.toString();	 Catch:{ all -> 0x01d0 }
        r1.<init>(r2, r0);	 Catch:{ all -> 0x01d0 }
        throw r1;	 Catch:{ all -> 0x01d0 }
    L_0x01e3:
        r1 = new com.jcraft.jsch.JSchException;	 Catch:{ all -> 0x01d0 }
        r0 = r0.toString();	 Catch:{ all -> 0x01d0 }
        r1.<init>(r0);	 Catch:{ all -> 0x01d0 }
        throw r1;	 Catch:{ all -> 0x01d0 }
    L_0x01ed:
        r0 = move-exception;
        r1 = new com.jcraft.jsch.JSchException;
        r2 = r0.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x01f8:
        r0 = move-exception;
        r1 = new com.jcraft.jsch.JSchException;
        r2 = r0.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x0203:
        r3 = r2;
        r2 = r0;
        goto L_0x00f1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.KnownHosts.j6(java.io.InputStream):void");
    }

    private void FH(String str) {
        this.FH.addElement(new HostKey(str, 3, null));
    }

    public String j6() {
        return this.DW;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int j6(java.lang.String r9, byte[] r10) {
        /*
        r8 = this;
        r3 = 0;
        r2 = 1;
        if (r9 != 0) goto L_0x0006;
    L_0x0004:
        r1 = r2;
    L_0x0005:
        return r1;
    L_0x0006:
        r5 = r8.j6(r10);
        r6 = r8.FH;
        monitor-enter(r6);
        r4 = r3;
        r1 = r2;
    L_0x000f:
        r0 = r8.FH;	 Catch:{ all -> 0x005f }
        r0 = r0.size();	 Catch:{ all -> 0x005f }
        if (r4 < r0) goto L_0x003c;
    L_0x0017:
        monitor-exit(r6);	 Catch:{ all -> 0x005f }
        if (r1 != r2) goto L_0x0005;
    L_0x001a:
        r0 = "[";
        r0 = r9.startsWith(r0);
        if (r0 == 0) goto L_0x0005;
    L_0x0023:
        r0 = "]:";
        r0 = r9.indexOf(r0);
        if (r0 <= r2) goto L_0x0005;
    L_0x002c:
        r0 = "]:";
        r0 = r9.indexOf(r0);
        r0 = r9.substring(r2, r0);
        r1 = r8.j6(r0, r10);
        goto L_0x0005;
    L_0x003c:
        r0 = r8.FH;	 Catch:{ all -> 0x005f }
        r0 = r0.elementAt(r4);	 Catch:{ all -> 0x005f }
        r0 = (com.jcraft.jsch.HostKey) r0;	 Catch:{ all -> 0x005f }
        r7 = r0.j6(r9);	 Catch:{ all -> 0x005f }
        if (r7 == 0) goto L_0x0062;
    L_0x004a:
        r7 = r0.FH;	 Catch:{ all -> 0x005f }
        if (r7 != r5) goto L_0x0062;
    L_0x004e:
        r0 = r0.Hw;	 Catch:{ all -> 0x005f }
        r0 = com.jcraft.jsch.Util.DW(r0, r10);	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x0059;
    L_0x0056:
        monitor-exit(r6);	 Catch:{ all -> 0x005f }
        r1 = r3;
        goto L_0x0005;
    L_0x0059:
        r0 = 2;
    L_0x005a:
        r1 = r4 + 1;
        r4 = r1;
        r1 = r0;
        goto L_0x000f;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x005f }
        throw r0;
    L_0x0062:
        r0 = r1;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.KnownHosts.j6(java.lang.String, byte[]):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(com.jcraft.jsch.HostKey r7, com.jcraft.jsch.UserInfo r8) {
        /*
        r6 = this;
        r1 = 0;
        r0 = r7.FH;
        r3 = r7.j6();
        r0 = r7.Hw;
        r4 = r6.FH;
        monitor-enter(r4);
        r2 = r1;
    L_0x000d:
        r0 = r6.FH;	 Catch:{ all -> 0x00c0 }
        r0 = r0.size();	 Catch:{ all -> 0x00c0 }
        if (r2 < r0) goto L_0x00ab;
    L_0x0015:
        monitor-exit(r4);	 Catch:{ all -> 0x00c0 }
        r0 = r6.FH;
        r0.addElement(r7);
        r2 = r6.j6();
        if (r2 == 0) goto L_0x00aa;
    L_0x0021:
        r0 = 1;
        r3 = new java.io.File;
        r4 = com.jcraft.jsch.Util.FH(r2);
        r3.<init>(r4);
        r4 = r3.exists();
        if (r4 != 0) goto L_0x00a5;
    L_0x0031:
        if (r8 == 0) goto L_0x00f2;
    L_0x0033:
        r0 = new java.lang.StringBuilder;
        r4 = java.lang.String.valueOf(r2);
        r0.<init>(r4);
        r4 = " does not exist.\n";
        r0 = r0.append(r4);
        r4 = "Are you sure you want to create it?";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r0 = r8.FH(r0);
        r3 = r3.getParentFile();
        if (r0 == 0) goto L_0x00a2;
    L_0x0058:
        if (r3 == 0) goto L_0x00a2;
    L_0x005a:
        r4 = r3.exists();
        if (r4 != 0) goto L_0x00a2;
    L_0x0060:
        r0 = new java.lang.StringBuilder;
        r4 = "The parent directory ";
        r0.<init>(r4);
        r0 = r0.append(r3);
        r4 = " does not exist.\n";
        r0 = r0.append(r4);
        r4 = "Are you sure you want to create it?";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r0 = r8.FH(r0);
        if (r0 == 0) goto L_0x00a2;
    L_0x0084:
        r4 = r3.mkdirs();
        if (r4 != 0) goto L_0x00c3;
    L_0x008a:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r3);
        r4 = " has not been created.";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r8.Hw(r0);
        r0 = r1;
    L_0x00a2:
        if (r3 != 0) goto L_0x00a5;
    L_0x00a4:
        r0 = r1;
    L_0x00a5:
        if (r0 == 0) goto L_0x00aa;
    L_0x00a7:
        r6.DW(r2);	 Catch:{ Exception -> 0x00db }
    L_0x00aa:
        return;
    L_0x00ab:
        r0 = r6.FH;	 Catch:{ all -> 0x00c0 }
        r0 = r0.elementAt(r2);	 Catch:{ all -> 0x00c0 }
        r0 = (com.jcraft.jsch.HostKey) r0;	 Catch:{ all -> 0x00c0 }
        r5 = r0.j6(r3);	 Catch:{ all -> 0x00c0 }
        if (r5 == 0) goto L_0x00bb;
    L_0x00b9:
        r0 = r0.FH;	 Catch:{ all -> 0x00c0 }
    L_0x00bb:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x000d;
    L_0x00c0:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00c0 }
        throw r0;
    L_0x00c3:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4 = r4.append(r3);
        r5 = " has been succesfully created.\nPlease check its access permission.";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r8.Hw(r4);
        goto L_0x00a2;
    L_0x00db:
        r0 = move-exception;
        r1 = java.lang.System.err;
        r2 = new java.lang.StringBuilder;
        r3 = "sync known_hosts: ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.println(r0);
        goto L_0x00aa;
    L_0x00f2:
        r0 = r1;
        goto L_0x00a5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.KnownHosts.j6(com.jcraft.jsch.HostKey, com.jcraft.jsch.UserInfo):void");
    }

    public HostKey[] j6(String str, String str2) {
        HostKey[] hostKeyArr;
        int i = 0;
        synchronized (this.FH) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.FH.size(); i2++) {
                HostKey hostKey = (HostKey) this.FH.elementAt(i2);
                if (hostKey.FH != 3 && (str == null || (hostKey.j6(str) && (str2 == null || hostKey.DW().equals(str2))))) {
                    arrayList.add(hostKey);
                }
            }
            Object obj = new HostKey[arrayList.size()];
            while (i < arrayList.size()) {
                obj[i] = (HostKey) arrayList.get(i);
                i++;
            }
            if (str != null && str.startsWith("[") && str.indexOf("]:") > 1) {
                Object j6 = j6(str.substring(1, str.indexOf("]:")), str2);
                if (j6.length > 0) {
                    hostKeyArr = new HostKey[(obj.length + j6.length)];
                    System.arraycopy(obj, 0, hostKeyArr, 0, obj.length);
                    System.arraycopy(j6, 0, hostKeyArr, obj.length, j6.length);
                }
            }
            Object obj2 = obj;
        }
        return hostKeyArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
        r6 = this;
        r1 = 0;
        r4 = r6.FH;
        monitor-enter(r4);
        r3 = r1;
        r2 = r1;
    L_0x0006:
        r1 = r6.FH;	 Catch:{ all -> 0x0065 }
        r1 = r1.size();	 Catch:{ all -> 0x0065 }
        if (r3 < r1) goto L_0x0015;
    L_0x000e:
        monitor-exit(r4);	 Catch:{ all -> 0x0065 }
        if (r2 == 0) goto L_0x0014;
    L_0x0011:
        r6.DW();	 Catch:{ Exception -> 0x0068 }
    L_0x0014:
        return;
    L_0x0015:
        r1 = r6.FH;	 Catch:{ all -> 0x0065 }
        r1 = r1.elementAt(r3);	 Catch:{ all -> 0x0065 }
        r1 = (com.jcraft.jsch.HostKey) r1;	 Catch:{ all -> 0x0065 }
        if (r7 == 0) goto L_0x003b;
    L_0x001f:
        r5 = r1.j6(r7);	 Catch:{ all -> 0x0065 }
        if (r5 == 0) goto L_0x006a;
    L_0x0025:
        if (r8 == 0) goto L_0x003b;
    L_0x0027:
        r5 = r1.DW();	 Catch:{ all -> 0x0065 }
        r5 = r5.equals(r8);	 Catch:{ all -> 0x0065 }
        if (r5 == 0) goto L_0x006a;
    L_0x0031:
        if (r9 == 0) goto L_0x003b;
    L_0x0033:
        r5 = r1.Hw;	 Catch:{ all -> 0x0065 }
        r5 = com.jcraft.jsch.Util.DW(r9, r5);	 Catch:{ all -> 0x0065 }
        if (r5 == 0) goto L_0x006a;
    L_0x003b:
        r5 = r1.j6();	 Catch:{ all -> 0x0065 }
        r2 = r5.equals(r7);	 Catch:{ all -> 0x0065 }
        if (r2 != 0) goto L_0x0053;
    L_0x0045:
        r2 = r1 instanceof com.jcraft.jsch.KnownHosts.HashedHostKey;	 Catch:{ all -> 0x0065 }
        if (r2 == 0) goto L_0x005e;
    L_0x0049:
        r0 = r1;
        r0 = (com.jcraft.jsch.KnownHosts.HashedHostKey) r0;	 Catch:{ all -> 0x0065 }
        r2 = r0;
        r2 = r2.Zo();	 Catch:{ all -> 0x0065 }
        if (r2 == 0) goto L_0x005e;
    L_0x0053:
        r2 = r6.FH;	 Catch:{ all -> 0x0065 }
        r2.removeElement(r1);	 Catch:{ all -> 0x0065 }
    L_0x0058:
        r1 = 1;
    L_0x0059:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r1;
        goto L_0x0006;
    L_0x005e:
        r2 = r6.DW(r5, r7);	 Catch:{ all -> 0x0065 }
        r1.DW = r2;	 Catch:{ all -> 0x0065 }
        goto L_0x0058;
    L_0x0065:
        r1 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0065 }
        throw r1;
    L_0x0068:
        r1 = move-exception;
        goto L_0x0014;
    L_0x006a:
        r1 = r2;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.KnownHosts.j6(java.lang.String, java.lang.String, byte[]):void");
    }

    protected void DW() {
        if (this.DW != null) {
            DW(this.DW);
        }
    }

    protected synchronized void DW(String str) {
        if (str != null) {
            OutputStream fileOutputStream = new FileOutputStream(Util.FH(str));
            j6(fileOutputStream);
            fileOutputStream.close();
        }
    }

    static {
        v5 = new byte[]{(byte) 32};
        Zo = Util.DW("\n");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(java.io.OutputStream r9) {
        /*
        r8 = this;
        r2 = r8.FH;	 Catch:{ Exception -> 0x008c }
        monitor-enter(r2);	 Catch:{ Exception -> 0x008c }
        r0 = 0;
        r1 = r0;
    L_0x0005:
        r0 = r8.FH;	 Catch:{ all -> 0x0089 }
        r0 = r0.size();	 Catch:{ all -> 0x0089 }
        if (r1 < r0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r2);	 Catch:{ all -> 0x0089 }
    L_0x000e:
        return;
    L_0x000f:
        r0 = r8.FH;	 Catch:{ all -> 0x0089 }
        r0 = r0.elementAt(r1);	 Catch:{ all -> 0x0089 }
        r0 = (com.jcraft.jsch.HostKey) r0;	 Catch:{ all -> 0x0089 }
        r3 = r0.v5();	 Catch:{ all -> 0x0089 }
        r4 = r0.j6();	 Catch:{ all -> 0x0089 }
        r5 = r0.DW();	 Catch:{ all -> 0x0089 }
        r6 = r0.Hw();	 Catch:{ all -> 0x0089 }
        r7 = "UNKNOWN";
        r7 = r5.equals(r7);	 Catch:{ all -> 0x0089 }
        if (r7 == 0) goto L_0x0040;
    L_0x0030:
        r0 = com.jcraft.jsch.Util.DW(r4);	 Catch:{ all -> 0x0089 }
        r9.write(r0);	 Catch:{ all -> 0x0089 }
        r0 = Zo;	 Catch:{ all -> 0x0089 }
        r9.write(r0);	 Catch:{ all -> 0x0089 }
    L_0x003c:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0005;
    L_0x0040:
        r7 = r3.length();	 Catch:{ all -> 0x0089 }
        if (r7 == 0) goto L_0x0052;
    L_0x0046:
        r3 = com.jcraft.jsch.Util.DW(r3);	 Catch:{ all -> 0x0089 }
        r9.write(r3);	 Catch:{ all -> 0x0089 }
        r3 = v5;	 Catch:{ all -> 0x0089 }
        r9.write(r3);	 Catch:{ all -> 0x0089 }
    L_0x0052:
        r3 = com.jcraft.jsch.Util.DW(r4);	 Catch:{ all -> 0x0089 }
        r9.write(r3);	 Catch:{ all -> 0x0089 }
        r3 = v5;	 Catch:{ all -> 0x0089 }
        r9.write(r3);	 Catch:{ all -> 0x0089 }
        r3 = com.jcraft.jsch.Util.DW(r5);	 Catch:{ all -> 0x0089 }
        r9.write(r3);	 Catch:{ all -> 0x0089 }
        r3 = v5;	 Catch:{ all -> 0x0089 }
        r9.write(r3);	 Catch:{ all -> 0x0089 }
        r0 = r0.FH();	 Catch:{ all -> 0x0089 }
        r0 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ all -> 0x0089 }
        r9.write(r0);	 Catch:{ all -> 0x0089 }
        if (r6 == 0) goto L_0x0083;
    L_0x0077:
        r0 = v5;	 Catch:{ all -> 0x0089 }
        r9.write(r0);	 Catch:{ all -> 0x0089 }
        r0 = com.jcraft.jsch.Util.DW(r6);	 Catch:{ all -> 0x0089 }
        r9.write(r0);	 Catch:{ all -> 0x0089 }
    L_0x0083:
        r0 = Zo;	 Catch:{ all -> 0x0089 }
        r9.write(r0);	 Catch:{ all -> 0x0089 }
        goto L_0x003c;
    L_0x0089:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0089 }
        throw r0;	 Catch:{ Exception -> 0x008c }
    L_0x008c:
        r0 = move-exception;
        r1 = java.lang.System.err;
        r1.println(r0);
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.KnownHosts.j6(java.io.OutputStream):void");
    }

    private int j6(byte[] bArr) {
        if (bArr[8] == 100) {
            return 1;
        }
        if (bArr[8] == 114) {
            return 2;
        }
        return 3;
    }

    private String DW(String str, String str2) {
        int length = str2.length();
        int length2 = str.length();
        int i = 0;
        while (i < length2) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                break;
            } else if (str2.equals(str.substring(i, indexOf))) {
                return str.substring(0, i) + str.substring(indexOf + 1);
            } else {
                i = indexOf + 1;
            }
        }
        if (!str.endsWith(str2) || length2 - i != length) {
            return str;
        }
        return str.substring(0, length == length2 ? 0 : (length2 - length) - 1);
    }

    private synchronized MAC FH() {
        if (this.Hw == null) {
            try {
                this.Hw = (MAC) Class.forName(JSch.DW("hmac-sha1")).newInstance();
            } catch (Exception e) {
                System.err.println("hmacsha1: " + e);
            }
        }
        return this.Hw;
    }

    HostKey DW(String str, byte[] bArr) {
        HostKey hashedHostKey = new HashedHostKey(this, str, bArr);
        hashedHostKey.VH();
        return hashedHostKey;
    }
}
