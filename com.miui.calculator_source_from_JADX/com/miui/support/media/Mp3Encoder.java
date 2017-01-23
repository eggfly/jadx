package com.miui.support.media;

public class Mp3Encoder {
    private long f3363a;
    private int f3364b;
    private int f3365c;
    private int f3366d;
    private int f3367e;
    private int f3368f;
    private int f3369g;
    private int f3370h;

    private native int lame_close(long j);

    private native int lame_encode(long j, short[] sArr, short[] sArr2, int i, byte[] bArr, int i2);

    private native int lame_encode_interleaved(long j, short[] sArr, int i, byte[] bArr, int i2);

    private native int lame_flush(long j, byte[] bArr, int i);

    private native long lame_init(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private native int lame_samples_to_encode(long j);

    private native int lame_write_vbr_header(long j, String str);

    public Mp3Encoder() {
        this.f3363a = -1;
        this.f3364b = 44100;
        this.f3365c = 44100;
        this.f3366d = 1;
        this.f3367e = 3;
        this.f3368f = 64;
        this.f3369g = 0;
        this.f3370h = -1;
    }

    static {
        System.loadLibrary("mp3lame");
    }

    public int m5046a(short[] sArr, short[] sArr2, int i, byte[] bArr, int i2) {
        return lame_encode(this.f3363a, sArr, sArr2, i, bArr, i2);
    }

    public int m5045a(short[] sArr, int i, byte[] bArr, int i2) {
        return lame_encode_interleaved(this.f3363a, sArr, i, bArr, i2);
    }

    protected void finalize() {
        super.finalize();
        if (this.f3363a > 0) {
            lame_close(this.f3363a);
        }
    }
}
