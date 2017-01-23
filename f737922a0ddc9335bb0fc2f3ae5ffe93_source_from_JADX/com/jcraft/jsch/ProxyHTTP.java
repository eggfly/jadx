package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProxyHTTP implements Proxy {
    private static int j6;
    private String DW;
    private int FH;
    private InputStream Hw;
    private String VH;
    private Socket Zo;
    private String gn;
    private OutputStream v5;

    static {
        j6 = 80;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(com.jcraft.jsch.SocketFactory r11, java.lang.String r12, int r13, int r14) {
        /*
        r10 = this;
        r8 = 13;
        r7 = 10;
        r2 = 0;
        if (r11 != 0) goto L_0x00c7;
    L_0x0007:
        r0 = r10.DW;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r10.FH;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = com.jcraft.jsch.Util.j6(r0, r1, r14);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r10.Zo = r0;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r10.Zo;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r0.getInputStream();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r10.Hw = r0;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r10.Zo;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r0.getOutputStream();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r10.v5 = r0;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
    L_0x0021:
        if (r14 <= 0) goto L_0x0028;
    L_0x0023:
        r0 = r10.Zo;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.setSoTimeout(r14);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
    L_0x0028:
        r0 = r10.Zo;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = 1;
        r0.setTcpNoDelay(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r10.v5;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r3 = "CONNECT ";
        r1.<init>(r3);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r1.append(r12);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r3 = ":";
        r1 = r1.append(r3);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r1.append(r13);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r3 = " HTTP/1.0\r\n";
        r1 = r1.append(r3);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r1.toString();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = com.jcraft.jsch.Util.DW(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.write(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r10.VH;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        if (r0 == 0) goto L_0x00a4;
    L_0x005d:
        r0 = r10.gn;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        if (r0 == 0) goto L_0x00a4;
    L_0x0061:
        r0 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r10.VH;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.<init>(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = ":";
        r0 = r0.append(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r10.gn;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r0.append(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r0.toString();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = com.jcraft.jsch.Util.DW(r0);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = 0;
        r3 = r0.length;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = com.jcraft.jsch.Util.DW(r0, r1, r3);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r10.v5;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r3 = "Proxy-Authorization: Basic ";
        r3 = com.jcraft.jsch.Util.DW(r3);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1.write(r3);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r10.v5;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1.write(r0);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r10.v5;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = "\r\n";
        r1 = com.jcraft.jsch.Util.DW(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.write(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
    L_0x00a4:
        r0 = r10.v5;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = "\r\n";
        r1 = com.jcraft.jsch.Util.DW(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.write(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r10.v5;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.flush();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = new java.lang.StringBuffer;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.<init>();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r2;
    L_0x00bb:
        if (r1 >= 0) goto L_0x010b;
    L_0x00bd:
        if (r1 >= 0) goto L_0x0121;
    L_0x00bf:
        r0 = new java.io.IOException;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.<init>();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        throw r0;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
    L_0x00c5:
        r0 = move-exception;
        throw r0;
    L_0x00c7:
        r0 = r10.DW;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r10.FH;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r11.j6(r0, r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r10.Zo = r0;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r10.Zo;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r11.j6(r0);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r10.Hw = r0;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r10.Zo;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r11.DW(r0);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r10.v5 = r0;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        goto L_0x0021;
    L_0x00e3:
        r0 = move-exception;
        r1 = r10.Zo;	 Catch:{ Exception -> 0x0193 }
        if (r1 == 0) goto L_0x00ed;
    L_0x00e8:
        r1 = r10.Zo;	 Catch:{ Exception -> 0x0193 }
        r1.close();	 Catch:{ Exception -> 0x0193 }
    L_0x00ed:
        r1 = new java.lang.StringBuilder;
        r2 = "ProxyHTTP: ";
        r1.<init>(r2);
        r2 = r0.toString();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = r0 instanceof java.lang.Throwable;
        if (r2 == 0) goto L_0x018d;
    L_0x0105:
        r2 = new com.jcraft.jsch.JSchException;
        r2.<init>(r1, r0);
        throw r2;
    L_0x010b:
        r1 = r10.Hw;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r1.read();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        if (r1 == r8) goto L_0x0118;
    L_0x0113:
        r3 = (char) r1;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.append(r3);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        goto L_0x00bb;
    L_0x0118:
        r1 = r10.Hw;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r1.read();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        if (r1 == r7) goto L_0x00bd;
    L_0x0120:
        goto L_0x00bb;
    L_0x0121:
        r4 = r0.toString();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r3 = "Unknow reason";
        r0 = -1;
        r5 = 32;
        r1 = r4.indexOf(r5);	 Catch:{ Exception -> 0x0164, RuntimeException -> 0x00c5 }
        r5 = 32;
        r6 = r1 + 1;
        r5 = r4.indexOf(r5, r6);	 Catch:{ Exception -> 0x0164, RuntimeException -> 0x00c5 }
        r6 = r1 + 1;
        r6 = r4.substring(r6, r5);	 Catch:{ Exception -> 0x0164, RuntimeException -> 0x00c5 }
        r0 = java.lang.Integer.parseInt(r6);	 Catch:{ Exception -> 0x0164, RuntimeException -> 0x00c5 }
        r5 = r5 + 1;
        r3 = r4.substring(r5);	 Catch:{ Exception -> 0x0164, RuntimeException -> 0x00c5 }
        r9 = r0;
        r0 = r1;
        r1 = r9;
    L_0x014a:
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 == r4) goto L_0x0169;
    L_0x014e:
        r0 = new java.io.IOException;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r2 = "proxy error: ";
        r1.<init>(r2);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r1.append(r3);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r1 = r1.toString();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.<init>(r1);	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        throw r0;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
    L_0x0164:
        r4 = move-exception;
        r9 = r0;
        r0 = r1;
        r1 = r9;
        goto L_0x014a;
    L_0x0169:
        r1 = r2;
    L_0x016a:
        if (r0 >= 0) goto L_0x0174;
    L_0x016c:
        if (r0 >= 0) goto L_0x018a;
    L_0x016e:
        r0 = new java.io.IOException;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0.<init>();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        throw r0;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
    L_0x0174:
        r0 = r10.Hw;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r3 = r0.read();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        if (r3 == r8) goto L_0x0181;
    L_0x017c:
        r0 = r1 + 1;
        r1 = r0;
        r0 = r3;
        goto L_0x016a;
    L_0x0181:
        r0 = r10.Hw;	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        r0 = r0.read();	 Catch:{ RuntimeException -> 0x00c5, Exception -> 0x00e3 }
        if (r0 == r7) goto L_0x016c;
    L_0x0189:
        goto L_0x016a;
    L_0x018a:
        if (r1 != 0) goto L_0x0169;
    L_0x018c:
        return;
    L_0x018d:
        r0 = new com.jcraft.jsch.JSchException;
        r0.<init>(r1);
        throw r0;
    L_0x0193:
        r1 = move-exception;
        goto L_0x00ed;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.ProxyHTTP.j6(com.jcraft.jsch.SocketFactory, java.lang.String, int, int):void");
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
