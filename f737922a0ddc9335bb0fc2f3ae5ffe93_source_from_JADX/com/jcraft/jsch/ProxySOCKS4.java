package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProxySOCKS4 implements Proxy {
    private static int j6;
    private String DW;
    private int FH;
    private InputStream Hw;
    private String VH;
    private Socket Zo;
    private OutputStream v5;

    static {
        j6 = 1080;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(com.jcraft.jsch.SocketFactory r8, java.lang.String r9, int r10, int r11) {
        /*
        r7 = this;
        r1 = 4;
        r0 = 0;
        if (r8 != 0) goto L_0x0099;
    L_0x0004:
        r2 = r7.DW;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r3 = r7.FH;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = com.jcraft.jsch.Util.j6(r2, r3, r11);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r7.Zo = r2;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r2.getInputStream();	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r7.Hw = r2;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r2.getOutputStream();	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r7.v5 = r2;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
    L_0x001e:
        if (r11 <= 0) goto L_0x0025;
    L_0x0020:
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2.setSoTimeout(r11);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
    L_0x0025:
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r3 = 1;
        r2.setTcpNoDelay(r3);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r2];	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = 0;
        r3 = 1;
        r5 = 4;
        r4[r2] = r5;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = 2;
        r5 = 1;
        r4[r3] = r5;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r3 = 3;
        r5 = r10 >>> 8;
        r5 = (byte) r5;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r4[r2] = r5;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r10 & 255;
        r2 = (byte) r2;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r4[r3] = r2;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = java.net.InetAddress.getByName(r9);	 Catch:{ UnknownHostException -> 0x00e5 }
        r5 = r2.getAddress();	 Catch:{ UnknownHostException -> 0x00e5 }
        r2 = r0;
    L_0x004c:
        r3 = r5.length;	 Catch:{ UnknownHostException -> 0x00e5 }
        if (r2 < r3) goto L_0x00d9;
    L_0x004f:
        r2 = r7.VH;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        if (r2 == 0) goto L_0x006a;
    L_0x0053:
        r2 = r7.VH;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = com.jcraft.jsch.Util.DW(r2);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r3 = 0;
        r5 = r7.VH;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r5 = r5.length();	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        java.lang.System.arraycopy(r2, r3, r4, r1, r5);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r7.VH;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r2.length();	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = r1 + r2;
    L_0x006a:
        r2 = r1 + 1;
        r3 = 0;
        r4[r1] = r3;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = r7.v5;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r3 = 0;
        r1.write(r4, r3, r2);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = 8;
    L_0x0077:
        if (r0 < r1) goto L_0x0100;
    L_0x0079:
        r0 = 0;
        r0 = r4[r0];	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        if (r0 == 0) goto L_0x0116;
    L_0x007e:
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = "ProxySOCKS4: server returns VN ";
        r1.<init>(r2);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = 0;
        r2 = r4[r2];	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = r1.append(r2);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = r1.toString();	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r0.<init>(r1);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        throw r0;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
    L_0x0097:
        r0 = move-exception;
        throw r0;
    L_0x0099:
        r2 = r7.DW;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r3 = r7.FH;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r8.j6(r2, r3);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r7.Zo = r2;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r8.j6(r2);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r7.Hw = r2;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r8.DW(r2);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r7.v5 = r2;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        goto L_0x001e;
    L_0x00b5:
        r0 = move-exception;
        r1 = r7.Zo;	 Catch:{ Exception -> 0x013c }
        if (r1 == 0) goto L_0x00bf;
    L_0x00ba:
        r1 = r7.Zo;	 Catch:{ Exception -> 0x013c }
        r1.close();	 Catch:{ Exception -> 0x013c }
    L_0x00bf:
        r1 = new com.jcraft.jsch.JSchException;
        r2 = new java.lang.StringBuilder;
        r3 = "ProxySOCKS4: ";
        r2.<init>(r3);
        r0 = r0.toString();
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x00d9:
        r3 = r1 + 1;
        r6 = r5[r2];	 Catch:{ UnknownHostException -> 0x00e5 }
        r4[r1] = r6;	 Catch:{ UnknownHostException -> 0x00e5 }
        r1 = r2 + 1;
        r2 = r1;
        r1 = r3;
        goto L_0x004c;
    L_0x00e5:
        r0 = move-exception;
        r1 = new com.jcraft.jsch.JSchException;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r3 = "ProxySOCKS4: ";
        r2.<init>(r3);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r3 = r0.toString();	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r2.append(r3);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r2 = r2.toString();	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1.<init>(r2, r0);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        throw r1;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
    L_0x0100:
        r2 = r7.Hw;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r3 = r1 - r0;
        r2 = r2.read(r4, r0, r3);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        if (r2 > 0) goto L_0x0113;
    L_0x010a:
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = "ProxySOCKS4: stream is closed";
        r0.<init>(r1);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        throw r0;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
    L_0x0113:
        r0 = r0 + r2;
        goto L_0x0077;
    L_0x0116:
        r0 = 1;
        r0 = r4[r0];	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = 90;
        if (r0 == r1) goto L_0x013b;
    L_0x011d:
        r0 = r7.Zo;	 Catch:{ Exception -> 0x013e, RuntimeException -> 0x0097 }
        r0.close();	 Catch:{ Exception -> 0x013e, RuntimeException -> 0x0097 }
    L_0x0122:
        r0 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = "ProxySOCKS4: server returns CD ";
        r0.<init>(r1);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = 1;
        r1 = r4[r1];	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r0 = r0.append(r1);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r0 = r0.toString();	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1 = new com.jcraft.jsch.JSchException;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        r1.<init>(r0);	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
        throw r1;	 Catch:{ RuntimeException -> 0x0097, Exception -> 0x00b5 }
    L_0x013b:
        return;
    L_0x013c:
        r1 = move-exception;
        goto L_0x00bf;
    L_0x013e:
        r0 = move-exception;
        goto L_0x0122;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.ProxySOCKS4.j6(com.jcraft.jsch.SocketFactory, java.lang.String, int, int):void");
    }

    public InputStream j6() {
        return this.Hw;
    }

    public OutputStream DW() {
        return this.v5;
    }

    public Socket FH() {
        return this.Zo;
    }

    public void Hw() {
        try {
            if (this.Hw != null) {
                this.Hw.close();
            }
            if (this.v5 != null) {
                this.v5.close();
            }
            if (this.Zo != null) {
                this.Zo.close();
            }
        } catch (Exception e) {
        }
        this.Hw = null;
        this.v5 = null;
        this.Zo = null;
    }
}
