package android.support.p012b;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import org.android.spdy.SpdyProtocol;

/* renamed from: android.support.b.d */
final class C0172d {

    /* renamed from: android.support.b.d.a */
    static class C0171a {
        long f757a;
        long f758b;

        C0171a() {
        }
    }

    static long m813a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long a = C0172d.m814a(randomAccessFile, C0172d.m815a(randomAccessFile));
            return a;
        } finally {
            randomAccessFile.close();
        }
    }

    static long m814a(RandomAccessFile randomAccessFile, C0171a c0171a) {
        CRC32 crc32 = new CRC32();
        long j = c0171a.f758b;
        randomAccessFile.seek(c0171a.f757a);
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_L7E];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        }
        return crc32.getValue();
    }

    static C0171a m815a(RandomAccessFile randomAccessFile) {
        long j = 0;
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        j2 = length;
        do {
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                C0171a c0171a = new C0171a();
                c0171a.f758b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                c0171a.f757a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return c0171a;
            }
            j2--;
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }
}
