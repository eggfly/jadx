package com.jcraft.jsch;

public class HostKey {
    private static final byte[] VH;
    private static final byte[] Zo;
    protected String DW;
    protected int FH;
    protected byte[] Hw;
    protected String j6;
    protected String v5;

    static {
        Zo = Util.DW("ssh-dss");
        VH = Util.DW("ssh-rsa");
    }

    public HostKey(String str, byte[] bArr) {
        this(str, 0, bArr);
    }

    public HostKey(String str, int i, byte[] bArr) {
        this(str, i, bArr, null);
    }

    public HostKey(String str, int i, byte[] bArr, String str2) {
        this("", str, i, bArr, str2);
    }

    public HostKey(String str, String str2, int i, byte[] bArr, String str3) {
        this.j6 = str;
        this.DW = str2;
        if (i != 0) {
            this.FH = i;
        } else if (bArr[8] == 100) {
            this.FH = 1;
        } else if (bArr[8] == 114) {
            this.FH = 2;
        } else {
            throw new JSchException("invalid key type");
        }
        this.Hw = bArr;
        this.v5 = str3;
    }

    public String j6() {
        return this.DW;
    }

    public String DW() {
        if (this.FH == 1) {
            return Util.DW(Zo);
        }
        if (this.FH == 2) {
            return Util.DW(VH);
        }
        return "UNKNOWN";
    }

    public String FH() {
        return Util.DW(Util.DW(this.Hw, 0, this.Hw.length));
    }

    public String Hw() {
        return this.v5;
    }

    public String v5() {
        return this.j6;
    }

    boolean j6(String str) {
        return DW(str);
    }

    private boolean DW(String str) {
        String str2 = this.DW;
        int length = str2.length();
        int length2 = str.length();
        int i = 0;
        while (i < length) {
            int indexOf = str2.indexOf(44, i);
            if (indexOf == -1) {
                if (length2 == length - i) {
                    return str2.regionMatches(true, i, str, 0, length2);
                }
                return false;
            } else if (length2 == indexOf - i && str2.regionMatches(true, i, str, 0, length2)) {
                return true;
            } else {
                i = indexOf + 1;
            }
        }
        return false;
    }
}
