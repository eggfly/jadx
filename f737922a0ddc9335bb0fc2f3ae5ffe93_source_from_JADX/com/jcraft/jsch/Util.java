package com.jcraft.jsch;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Vector;

class Util {
    private static final byte[] DW;
    private static String[] FH;
    static final byte[] j6;

    class 1 implements Runnable {
        private final /* synthetic */ String DW;
        private final /* synthetic */ int FH;
        private final /* synthetic */ Exception[] Hw;
        private final /* synthetic */ Socket[] j6;

        1(Socket[] socketArr, String str, int i, Exception[] exceptionArr) {
            this.j6 = socketArr;
            this.DW = str;
            this.FH = i;
            this.Hw = exceptionArr;
        }

        public void run() {
            this.j6[0] = null;
            try {
                this.j6[0] = new Socket(this.DW, this.FH);
            } catch (Exception e) {
                this.Hw[0] = e;
                if (this.j6[0] != null && this.j6[0].isConnected()) {
                    try {
                        this.j6[0].close();
                    } catch (Exception e2) {
                    }
                }
                this.j6[0] = null;
            }
        }
    }

    Util() {
    }

    static {
        DW = DW("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=");
        FH = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        j6 = DW("");
    }

    private static byte j6(byte b) {
        if (b == 61) {
            return (byte) 0;
        }
        for (int i = 0; i < DW.length; i++) {
            if (b == DW[i]) {
                return (byte) i;
            }
        }
        return (byte) 0;
    }

    static byte[] j6(byte[] bArr, int i, int i2) {
        int i3 = 0;
        try {
            Object obj = new byte[i2];
            int i4 = i;
            while (i4 < i + i2) {
                obj[i3] = (byte) ((j6(bArr[i4]) << 2) | ((j6(bArr[i4 + 1]) & 48) >>> 4));
                if (bArr[i4 + 2] == (byte) 61) {
                    i3++;
                    break;
                }
                obj[i3 + 1] = (byte) (((j6(bArr[i4 + 1]) & 15) << 4) | ((j6(bArr[i4 + 2]) & 60) >>> 2));
                if (bArr[i4 + 3] == (byte) 61) {
                    i3 += 2;
                    break;
                }
                obj[i3 + 2] = (byte) (((j6(bArr[i4 + 2]) & 3) << 6) | (j6(bArr[i4 + 3]) & 63));
                i4 += 4;
                i3 += 3;
            }
            Object obj2 = new byte[i3];
            System.arraycopy(obj, 0, obj2, 0, i3);
            return obj2;
        } catch (Throwable e) {
            throw new JSchException("fromBase64: invalid base64 data", e);
        }
    }

    static byte[] DW(byte[] bArr, int i, int i2) {
        int i3;
        Object obj = new byte[(i2 * 2)];
        int i4 = ((i2 / 3) * 3) + i;
        int i5 = i;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = i6 + 1;
            obj[i6] = DW[(bArr[i5] >>> 2) & 63];
            i3 = i7 + 1;
            obj[i7] = DW[((bArr[i5] & 3) << 4) | ((bArr[i5 + 1] >>> 4) & 15)];
            i7 = i3 + 1;
            obj[i3] = DW[((bArr[i5 + 1] & 15) << 2) | ((bArr[i5 + 2] >>> 6) & 3)];
            i3 = i7 + 1;
            obj[i7] = DW[bArr[i5 + 2] & 63];
            i5 += 3;
            i6 = i3;
        }
        i3 = (i + i2) - i4;
        if (i3 == 1) {
            i4 = i6 + 1;
            obj[i6] = DW[(bArr[i5] >>> 2) & 63];
            i6 = ((bArr[i5] & 3) << 4) & 63;
            i5 = i4 + 1;
            obj[i4] = DW[i6];
            i3 = i5 + 1;
            obj[i5] = 61;
            i6 = i3 + 1;
            obj[i3] = 61;
        } else if (i3 == 2) {
            i4 = i6 + 1;
            obj[i6] = DW[(bArr[i5] >>> 2) & 63];
            i3 = i4 + 1;
            obj[i4] = DW[((bArr[i5] & 3) << 4) | ((bArr[i5 + 1] >>> 4) & 15)];
            i6 = ((bArr[i5 + 1] & 15) << 2) & 63;
            i5 = i3 + 1;
            obj[i3] = DW[i6];
            i6 = i5 + 1;
            obj[i5] = 61;
        }
        Object obj2 = new byte[i6];
        System.arraycopy(obj, 0, obj2, 0, i6);
        return obj2;
    }

    static String[] j6(String str, String str2) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] DW = DW(str);
        Vector vector = new Vector();
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i2);
            if (indexOf < 0) {
                break;
            }
            vector.addElement(FH(DW, i2, indexOf - i2));
            i2 = indexOf + 1;
        }
        vector.addElement(FH(DW, i2, DW.length - i2));
        String[] strArr = new String[vector.size()];
        while (i < strArr.length) {
            strArr[i] = (String) vector.elementAt(i);
            i++;
        }
        return strArr;
    }

    static boolean j6(byte[] bArr, byte[] bArr2) {
        return j6(bArr, 0, bArr2, 0);
    }

    private static boolean j6(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length <= 0 || bArr2[0] != (byte) 46) {
            return DW(bArr, i, bArr2, i2);
        }
        if (bArr.length <= 0 || bArr[0] != (byte) 46) {
            return false;
        }
        if (bArr.length == 2 && bArr[1] == 42) {
            return true;
        }
        return DW(bArr, i + 1, bArr2, i2 + 1);
    }

    private static boolean DW(byte[] bArr, int i, byte[] bArr2, int i2) {
        int length = bArr.length;
        if (length == 0) {
            return false;
        }
        int i3;
        int length2 = bArr2.length;
        int i4 = i2;
        int i5 = i;
        while (i5 < length && i4 < length2) {
            if (bArr[i5] == (byte) 92) {
                if (i5 + 1 == length) {
                    return false;
                }
                i5++;
                if (bArr[i5] != bArr2[i4]) {
                    return false;
                }
                i5 += DW(bArr[i5]);
                i4 += DW(bArr2[i4]);
            } else if (bArr[i5] == (byte) 42) {
                while (i5 < length && bArr[i5] == (byte) 42) {
                    i5++;
                }
                if (length == i5) {
                    return true;
                }
                byte b = bArr[i5];
                if (b == (byte) 63) {
                    while (i4 < length2) {
                        if (DW(bArr, i5, bArr2, i4)) {
                            return true;
                        }
                        i4 += DW(bArr2[i4]);
                    }
                    return false;
                } else if (b != (byte) 92) {
                    while (i4 < length2) {
                        if (b == bArr2[i4] && DW(bArr, i5, bArr2, i4)) {
                            return true;
                        }
                        i4 += DW(bArr2[i4]);
                    }
                    return false;
                } else if (i5 + 1 == length) {
                    return false;
                } else {
                    i5++;
                    byte b2 = bArr[i5];
                    while (i4 < length2) {
                        if (b2 == bArr2[i4] && DW(bArr, DW(b2) + i5, bArr2, DW(bArr2[i4]) + i4)) {
                            return true;
                        }
                        i4 += DW(bArr2[i4]);
                    }
                    return false;
                }
            } else if (bArr[i5] == (byte) 63) {
                i5++;
                i4 += DW(bArr2[i4]);
            } else if (bArr[i5] != bArr2[i4]) {
                return false;
            } else {
                i5 += DW(bArr[i5]);
                i4 += DW(bArr2[i4]);
                if (i4 < length2) {
                    continue;
                } else if (i5 >= length) {
                    return true;
                } else {
                    if (bArr[i5] == (byte) 42) {
                        i3 = i4;
                        i4 = i5;
                        i5 = i3;
                        break;
                    }
                }
            }
        }
        i3 = i4;
        i4 = i5;
        i5 = i3;
        if (i4 == length && i5 == length2) {
            return true;
        }
        if (i5 < length2 || bArr[i4] != (byte) 42) {
            return false;
        }
        while (i4 < length) {
            i5 = i4 + 1;
            if (bArr[i4] != (byte) 42) {
                return false;
            }
            i4 = i5;
        }
        return true;
    }

    static String j6(String str) {
        byte[] DW = DW(str);
        byte[] j6 = j6(DW);
        return DW.length == j6.length ? str : DW(j6);
    }

    static byte[] j6(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            if (bArr[i] == 92) {
                if (i + 1 == length) {
                    break;
                }
                System.arraycopy(bArr, i + 1, bArr, i, bArr.length - (i + 1));
                length--;
                i++;
            } else {
                i++;
            }
        }
        if (length == bArr.length) {
            return bArr;
        }
        Object obj = new byte[length];
        System.arraycopy(bArr, 0, obj, 0, length);
        return obj;
    }

    static String j6(HASH hash, byte[] bArr) {
        try {
            hash.j6();
            hash.j6(bArr, 0, bArr.length);
            byte[] FH = hash.FH();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < FH.length; i++) {
                int i2 = FH[i] & 255;
                stringBuffer.append(FH[(i2 >>> 4) & 15]);
                stringBuffer.append(FH[i2 & 15]);
                if (i + 1 < FH.length) {
                    stringBuffer.append(":");
                }
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return "???";
        }
    }

    static boolean DW(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    static Socket j6(String str, int i, int i2) {
        if (i2 == 0) {
            try {
                return new Socket(str, i);
            } catch (Throwable e) {
                String exception = e.toString();
                if (e instanceof Throwable) {
                    throw new JSchException(exception, e);
                }
                throw new JSchException(exception);
            }
        }
        Socket[] socketArr = new Socket[1];
        Exception[] exceptionArr = new Exception[1];
        Object obj = "";
        Thread thread = new Thread(new 1(socketArr, str, i, exceptionArr));
        thread.setName("Opening Socket " + str);
        thread.start();
        try {
            thread.join((long) i2);
            obj = "timeout: ";
        } catch (InterruptedException e2) {
        }
        if (socketArr[0] != null && socketArr[0].isConnected()) {
            return socketArr[0];
        }
        String stringBuilder = new StringBuilder(String.valueOf(obj)).append("socket is not established").toString();
        if (exceptionArr[0] != null) {
            stringBuilder = exceptionArr[0].toString();
        }
        thread.interrupt();
        throw new JSchException(stringBuilder, exceptionArr[0]);
    }

    static byte[] DW(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    static byte[] DW(String str) {
        return DW(str, "UTF-8");
    }

    static String j6(byte[] bArr, String str) {
        return j6(bArr, 0, bArr.length, str);
    }

    static String j6(byte[] bArr, int i, int i2, String str) {
        try {
            return new String(bArr, i, i2, str);
        } catch (UnsupportedEncodingException e) {
            return new String(bArr, i, i2);
        }
    }

    static String DW(byte[] bArr) {
        return j6(bArr, 0, bArr.length, "UTF-8");
    }

    static String FH(byte[] bArr, int i, int i2) {
        return j6(bArr, i, i2, "UTF-8");
    }

    static String FH(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            String toHexString = Integer.toHexString(bArr[i] & 255);
            stringBuffer.append("0x" + (toHexString.length() == 1 ? "0" : "") + toHexString);
            if (i + 1 < bArr.length) {
                stringBuffer.append(":");
            }
        }
        return stringBuffer.toString();
    }

    static void Hw(byte[] bArr) {
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) 0;
            }
        }
    }

    static String j6(String str, String[] strArr) {
        String[] j6 = j6(str, ",");
        String str2 = null;
        for (int i = 0; i < j6.length; i++) {
            for (Object equals : strArr) {
                if (j6[i].equals(equals)) {
                    break;
                }
            }
            if (str2 == null) {
                str2 = j6[i];
            } else {
                str2 = new StringBuilder(String.valueOf(str2)).append(",").append(j6[i]).toString();
            }
        }
        return str2;
    }

    static String FH(String str) {
        try {
            if (str.startsWith("~")) {
                str = str.replace("~", System.getProperty("user.home"));
            }
        } catch (SecurityException e) {
        }
        return str;
    }

    private static int DW(byte b) {
        if (((byte) (b & 128)) == null) {
            return 1;
        }
        if (((byte) (b & 224)) == -64) {
            return 2;
        }
        if (((byte) (b & 240)) == -32) {
            return 3;
        }
        return 1;
    }

    static byte[] Hw(String str) {
        String FH = FH(str);
        byte[] file = new File(FH);
        FileInputStream fileInputStream = new FileInputStream(FH);
        try {
            file = new byte[((int) file.length())];
            int i = 0;
            while (true) {
                int read = fileInputStream.read(file, i, file.length - i);
                if (read <= 0) {
                    break;
                }
                i += read;
            }
            fileInputStream.close();
            return file;
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }
}
