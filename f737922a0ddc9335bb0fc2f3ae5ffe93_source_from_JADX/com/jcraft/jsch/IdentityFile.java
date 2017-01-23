package com.jcraft.jsch;

class IdentityFile implements Identity {
    private KeyPair DW;
    private String FH;
    private JSch j6;

    static IdentityFile j6(String str, String str2, JSch jSch) {
        return new IdentityFile(jSch, str, KeyPair.j6(jSch, str, str2));
    }

    static IdentityFile j6(String str, byte[] bArr, byte[] bArr2, JSch jSch) {
        return new IdentityFile(jSch, str, KeyPair.j6(jSch, bArr, bArr2));
    }

    private IdentityFile(JSch jSch, String str, KeyPair keyPair) {
        this.j6 = jSch;
        this.FH = str;
        this.DW = keyPair;
    }

    public boolean j6(byte[] bArr) {
        return this.DW.FH(bArr);
    }

    public byte[] j6() {
        return this.DW.Hw();
    }

    public byte[] DW(byte[] bArr) {
        return this.DW.j6(bArr);
    }

    public String DW() {
        return new String(this.DW.FH());
    }

    public String FH() {
        return this.FH;
    }

    public boolean Hw() {
        return this.DW.v5();
    }

    public void v5() {
        this.DW.Zo();
        this.DW = null;
    }

    public KeyPair Zo() {
        return this.DW;
    }
}
