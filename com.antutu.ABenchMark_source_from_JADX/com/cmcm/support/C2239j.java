package com.cmcm.support;

/* renamed from: com.cmcm.support.j */
public class C2239j {
    private C2238a f7709a;

    /* renamed from: com.cmcm.support.j.a */
    class C2238a {
        final /* synthetic */ C2239j f7706a;
        private long f7707b;
        private byte[] f7708c;

        public C2238a(C2239j c2239j, long j, byte[] bArr) {
            this.f7706a = c2239j;
            this.f7707b = 0;
            this.f7708c = null;
            m8454a(j);
            m8455a(bArr);
        }

        public long m8453a() {
            return this.f7707b;
        }

        public void m8454a(long j) {
            this.f7707b = j;
        }

        public void m8455a(byte[] bArr) {
            this.f7708c = bArr;
        }

        public byte[] m8456b() {
            return this.f7708c;
        }
    }

    public C2239j() {
        this.f7709a = new C2238a(this, 0, new byte[]{(byte) 33, (byte) 116, (byte) 98, (byte) 70, (byte) 66, (byte) 107, (byte) 64, (byte) 36, (byte) 66, (byte) 80, (byte) 55, (byte) 105, (byte) 118, (byte) 118, (byte) 78, (byte) 103});
    }

    public synchronized C2238a m8457a() {
        return new C2238a(this, this.f7709a.m8453a(), this.f7709a.m8456b());
    }

    public synchronized void m8458a(long j, byte[] bArr) {
        if (bArr != null) {
            if (bArr.length == 16) {
                this.f7709a.m8454a(j);
                this.f7709a.m8455a(bArr);
            }
        }
    }
}
