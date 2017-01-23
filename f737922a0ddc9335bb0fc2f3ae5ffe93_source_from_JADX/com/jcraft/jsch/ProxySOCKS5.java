package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProxySOCKS5 implements Proxy {
    private static int j6;
    private String DW;
    private int FH;
    private InputStream Hw;
    private String VH;
    private Socket Zo;
    private String gn;
    private OutputStream v5;

    static {
        j6 = 1080;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(com.jcraft.jsch.SocketFactory r8, java.lang.String r9, int r10, int r11) {
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        if (r8 != 0) goto L_0x0067;
    L_0x0004:
        r2 = r7.DW;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r7.FH;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = com.jcraft.jsch.Util.j6(r2, r3, r11);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r7.Zo = r2;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = r2.getInputStream();	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r7.Hw = r2;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = r2.getOutputStream();	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r7.v5 = r2;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
    L_0x001e:
        if (r11 <= 0) goto L_0x0025;
    L_0x0020:
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2.setSoTimeout(r11);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
    L_0x0025:
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = 1;
        r2.setTcpNoDelay(r3);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = 0;
        r4 = 1;
        r5 = 5;
        r2[r3] = r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = 2;
        r5 = 2;
        r2[r4] = r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r4 = 3;
        r5 = 0;
        r2[r3] = r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = 4;
        r5 = 2;
        r2[r4] = r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r4 = r7.v5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r5 = 0;
        r4.write(r2, r5, r3);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r7.Hw;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r4 = 2;
        r7.j6(r3, r2, r4);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = 1;
        r3 = r2[r3];	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r3 & 255;
        switch(r3) {
            case 0: goto L_0x0055;
            case 1: goto L_0x0054;
            case 2: goto L_0x00aa;
            default: goto L_0x0054;
        };
    L_0x0054:
        r0 = r1;
    L_0x0055:
        if (r0 != 0) goto L_0x0110;
    L_0x0057:
        r0 = r7.Zo;	 Catch:{ Exception -> 0x01a3, RuntimeException -> 0x0065 }
        r0.close();	 Catch:{ Exception -> 0x01a3, RuntimeException -> 0x0065 }
    L_0x005c:
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = "fail in SOCKS5 proxy";
        r0.<init>(r1);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        throw r0;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
    L_0x0065:
        r0 = move-exception;
        throw r0;
    L_0x0067:
        r2 = r7.DW;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r7.FH;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = r8.j6(r2, r3);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r7.Zo = r2;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = r8.j6(r2);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r7.Hw = r2;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = r7.Zo;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2 = r8.DW(r2);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r7.v5 = r2;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        goto L_0x001e;
    L_0x0082:
        r0 = move-exception;
        r1 = r7.Zo;	 Catch:{ Exception -> 0x019e }
        if (r1 == 0) goto L_0x008c;
    L_0x0087:
        r1 = r7.Zo;	 Catch:{ Exception -> 0x019e }
        r1.close();	 Catch:{ Exception -> 0x019e }
    L_0x008c:
        r1 = new java.lang.StringBuilder;
        r2 = "ProxySOCKS5: ";
        r1.<init>(r2);
        r2 = r0.toString();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = r0 instanceof java.lang.Throwable;
        if (r2 == 0) goto L_0x0198;
    L_0x00a4:
        r2 = new com.jcraft.jsch.JSchException;
        r2.<init>(r1, r0);
        throw r2;
    L_0x00aa:
        r3 = r7.VH;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        if (r3 == 0) goto L_0x0054;
    L_0x00ae:
        r3 = r7.gn;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        if (r3 != 0) goto L_0x00b4;
    L_0x00b2:
        r0 = r1;
        goto L_0x0055;
    L_0x00b4:
        r3 = 0;
        r4 = 1;
        r5 = 1;
        r2[r3] = r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = 2;
        r5 = r7.VH;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r5 = r5.length();	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r5 = (byte) r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2[r4] = r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r4 = r7.VH;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r4 = com.jcraft.jsch.Util.DW(r4);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r5 = 0;
        r6 = r7.VH;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r6 = r6.length();	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        java.lang.System.arraycopy(r4, r5, r2, r3, r6);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r7.VH;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r3.length();	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r3 + 2;
        r4 = r3 + 1;
        r5 = r7.gn;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r5 = r5.length();	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r5 = (byte) r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2[r3] = r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r7.gn;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = com.jcraft.jsch.Util.DW(r3);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r5 = 0;
        r6 = r7.gn;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r6 = r6.length();	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        java.lang.System.arraycopy(r3, r5, r2, r4, r6);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r7.gn;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r3.length();	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r3 + r4;
        r4 = r7.v5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r5 = 0;
        r4.write(r2, r5, r3);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r7.Hw;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r4 = 2;
        r7.j6(r3, r2, r4);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = 1;
        r3 = r2[r3];	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        if (r3 != 0) goto L_0x0054;
    L_0x010e:
        goto L_0x0055;
    L_0x0110:
        r0 = 0;
        r1 = 1;
        r3 = 5;
        r2[r0] = r3;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r0 = 2;
        r3 = 1;
        r2[r1] = r3;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = 3;
        r3 = 0;
        r2[r0] = r3;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r0 = com.jcraft.jsch.Util.DW(r9);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = r0.length;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r4 = 4;
        r5 = 3;
        r2[r1] = r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = 5;
        r5 = (byte) r3;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2[r4] = r5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r4 = 0;
        java.lang.System.arraycopy(r0, r4, r2, r1, r3);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r0 = r3 + 5;
        r1 = r0 + 1;
        r3 = r10 >>> 8;
        r3 = (byte) r3;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2[r0] = r3;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r0 = r1 + 1;
        r3 = r10 & 255;
        r3 = (byte) r3;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r2[r1] = r3;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = r7.v5;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = 0;
        r1.write(r2, r3, r0);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r0 = r7.Hw;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = 4;
        r7.j6(r0, r2, r1);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r0 = 1;
        r0 = r2[r0];	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        if (r0 == 0) goto L_0x016d;
    L_0x014f:
        r0 = r7.Zo;	 Catch:{ Exception -> 0x01a1, RuntimeException -> 0x0065 }
        r0.close();	 Catch:{ Exception -> 0x01a1, RuntimeException -> 0x0065 }
    L_0x0154:
        r0 = new com.jcraft.jsch.JSchException;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = "ProxySOCKS5: server returns ";
        r1.<init>(r3);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r3 = 1;
        r2 = r2[r3];	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = r1.append(r2);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = r1.toString();	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r0.<init>(r1);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        throw r0;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
    L_0x016d:
        r0 = 3;
        r0 = r2[r0];	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r0 = r0 & 255;
        switch(r0) {
            case 1: goto L_0x0176;
            case 2: goto L_0x0175;
            case 3: goto L_0x017d;
            case 4: goto L_0x0190;
            default: goto L_0x0175;
        };	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
    L_0x0175:
        return;
    L_0x0176:
        r0 = r7.Hw;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = 6;
        r7.j6(r0, r2, r1);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        goto L_0x0175;
    L_0x017d:
        r0 = r7.Hw;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = 1;
        r7.j6(r0, r2, r1);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r0 = r7.Hw;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = 0;
        r1 = r2[r1];	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = r1 & 255;
        r1 = r1 + 2;
        r7.j6(r0, r2, r1);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        goto L_0x0175;
    L_0x0190:
        r0 = r7.Hw;	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        r1 = 18;
        r7.j6(r0, r2, r1);	 Catch:{ RuntimeException -> 0x0065, Exception -> 0x0082 }
        goto L_0x0175;
    L_0x0198:
        r0 = new com.jcraft.jsch.JSchException;
        r0.<init>(r1);
        throw r0;
    L_0x019e:
        r1 = move-exception;
        goto L_0x008c;
    L_0x01a1:
        r0 = move-exception;
        goto L_0x0154;
    L_0x01a3:
        r0 = move-exception;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.ProxySOCKS5.j6(com.jcraft.jsch.SocketFactory, java.lang.String, int, int):void");
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

    private void j6(InputStream inputStream, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read <= 0) {
                throw new JSchException("ProxySOCKS5: stream is closed");
            }
            i2 += read;
        }
    }
}
