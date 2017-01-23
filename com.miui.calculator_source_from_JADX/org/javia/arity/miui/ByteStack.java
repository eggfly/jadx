package org.javia.arity.miui;

class ByteStack {
    private byte[] f4885a;
    private int f4886b;

    ByteStack() {
        this.f4885a = new byte[8];
        this.f4886b = 0;
    }

    void m6618a() {
        this.f4886b = 0;
    }

    void m6619a(byte b) {
        if (this.f4886b >= this.f4885a.length) {
            Object obj = new byte[(this.f4885a.length << 1)];
            System.arraycopy(this.f4885a, 0, obj, 0, this.f4885a.length);
            this.f4885a = obj;
        }
        byte[] bArr = this.f4885a;
        int i = this.f4886b;
        this.f4886b = i + 1;
        bArr[i] = b;
    }

    byte m6620b() {
        byte[] bArr = this.f4885a;
        int i = this.f4886b - 1;
        this.f4886b = i;
        return bArr[i];
    }

    byte[] m6621c() {
        Object obj = new byte[this.f4886b];
        System.arraycopy(this.f4885a, 0, obj, 0, this.f4886b);
        return obj;
    }
}
