package com.igexin.push.p182d.p185c;

/* renamed from: com.igexin.push.d.c.l */
public class C3887l extends C3876e {
    public byte f13098a;
    public Object f13099b;

    public void m15983a(byte[] bArr) {
    }

    public byte[] m15984d() {
        Object bytes = this.f13098a == (byte) 1 ? ((String) this.f13099b).getBytes() : this.f13098a == (byte) 2 ? ((String) this.f13099b).getBytes() : this.f13098a == 3 ? null : this.f13098a == 4 ? ((String) this.f13099b).getBytes() : null;
        if (bytes == null) {
            return null;
        }
        Object obj = new byte[(bytes.length + 2)];
        obj[0] = this.f13098a;
        obj[1] = (byte) bytes.length;
        System.arraycopy(bytes, 0, obj, 2, bytes.length);
        return obj;
    }
}
