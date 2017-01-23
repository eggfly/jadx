package com.cmcm.support.p117b;

/* renamed from: com.cmcm.support.b.c */
public class C2202c implements Cloneable {
    private byte[] f7596a;
    private byte[] f7597b;
    private String f7598c;
    private String f7599d;

    public C2202c() {
        this.f7596a = null;
        this.f7597b = null;
        this.f7598c = null;
        this.f7599d = null;
    }

    private int m8268e() {
        return this.f7596a == null ? 0 : this.f7596a.length;
    }

    public String m8269a() {
        return this.f7599d;
    }

    public void m8270a(String str) {
        this.f7599d = str;
    }

    public void m8271a(byte[] bArr) {
        this.f7596a = bArr;
    }

    public void m8272b(String str) {
        this.f7598c = str;
    }

    public void m8273b(byte[] bArr) {
        this.f7597b = bArr;
    }

    public byte[] m8274b() {
        return this.f7596a;
    }

    public byte[] m8275c() {
        return this.f7597b;
    }

    public Object clone() {
        try {
            return (C2202c) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String m8276d() {
        return this.f7598c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" KHttpData : ").append("\n");
        stringBuilder.append("  * tname  : ").append(m8276d()).append("\n");
        stringBuilder.append("  * dsize  : ").append(m8268e()).append("\n");
        return super.toString();
    }
}
