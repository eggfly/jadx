import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class asl$a extends SoftReference<byte[]> {
    final int j6;

    asl$a(byte[] bArr, ReferenceQueue<byte[]> referenceQueue) {
        super(bArr, referenceQueue);
        this.j6 = bArr.length;
    }
}
