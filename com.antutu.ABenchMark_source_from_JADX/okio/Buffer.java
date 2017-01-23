package okio;

import android.support.v4.media.TransportMediator;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import anet.channel.security.ISecurity;
import com.igexin.download.Downloads;
import com.taobao.accs.data.Message;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.android.spdy.SpdyProtocol;

public final class Buffer implements Cloneable, BufferedSink, BufferedSource {
    private static final byte[] DIGITS;
    static final int REPLACEMENT_CHARACTER = 65533;
    Segment head;
    long size;

    /* renamed from: okio.Buffer.1 */
    class C45651 extends OutputStream {
        C45651() {
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return Buffer.this + ".outputStream()";
        }

        public void write(int i) {
            Buffer.this.writeByte((byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            Buffer.this.write(bArr, i, i2);
        }
    }

    /* renamed from: okio.Buffer.2 */
    class C45662 extends InputStream {
        C45662() {
        }

        public int available() {
            return (int) Math.min(Buffer.this.size, 2147483647L);
        }

        public void close() {
        }

        public int read() {
            return Buffer.this.size > 0 ? Buffer.this.readByte() & MotionEventCompat.ACTION_MASK : -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            return Buffer.this.read(bArr, i, i2);
        }

        public String toString() {
            return Buffer.this + ".inputStream()";
        }
    }

    static {
        DIGITS = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    }

    private ByteString digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            if (this.head != null) {
                instance.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                for (Segment segment = this.head.next; segment != this.head; segment = segment.next) {
                    instance.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return ByteString.of(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            if (this.head != null) {
                instance.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                for (Segment segment = this.head.next; segment != this.head; segment = segment.next) {
                    instance.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return ByteString.of(instance.doFinal());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        } catch (Throwable e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private boolean rangeEquals(Segment segment, int i, ByteString byteString, int i2, int i3) {
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        int i5 = i;
        Segment segment2 = segment;
        while (i2 < i3) {
            if (i5 == i4) {
                segment2 = segment2.next;
                bArr = segment2.data;
                i5 = segment2.pos;
                i4 = segment2.limit;
            }
            if (bArr[i5] != byteString.getByte(i2)) {
                return false;
            }
            i5++;
            i2++;
        }
        return true;
    }

    private void readFrom(InputStream inputStream, long j, boolean z) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j > 0 || z) {
                Segment writableSegment = writableSegment(1);
                int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, (long) (8192 - writableSegment.limit)));
                if (read == -1) {
                    break;
                }
                writableSegment.limit += read;
                this.size += (long) read;
                j -= (long) read;
            } else {
                return;
            }
        }
        if (!z) {
            throw new EOFException();
        }
    }

    public Buffer buffer() {
        return this;
    }

    public void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        buffer.head = new Segment(this.head);
        Segment segment = buffer.head;
        Segment segment2 = buffer.head;
        Segment segment3 = buffer.head;
        segment2.prev = segment3;
        segment.next = segment3;
        for (segment = this.head.next; segment != this.head; segment = segment.next) {
            buffer.head.prev.push(new Segment(segment));
        }
        buffer.size = this.size;
        return buffer;
    }

    public void close() {
    }

    public long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0;
        }
        Segment segment = this.head.prev;
        return (segment.limit >= SpdyProtocol.SLIGHTSSL_1_RTT_MODE || !segment.owner) ? j : j - ((long) (segment.limit - segment.pos));
    }

    public Buffer copyTo(OutputStream outputStream) {
        return copyTo(outputStream, 0, this.size);
    }

    public Buffer copyTo(OutputStream outputStream, long j, long j2) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 != 0) {
            Segment segment = this.head;
            while (j >= ((long) (segment.limit - segment.pos))) {
                j -= (long) (segment.limit - segment.pos);
                segment = segment.next;
            }
            while (j2 > 0) {
                int i = (int) (((long) segment.pos) + j);
                int min = (int) Math.min((long) (segment.limit - i), j2);
                outputStream.write(segment.data, i, min);
                j2 -= (long) min;
                segment = segment.next;
                j = 0;
            }
        }
        return this;
    }

    public Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 != 0) {
            buffer.size += j2;
            Segment segment = this.head;
            while (j >= ((long) (segment.limit - segment.pos))) {
                j -= (long) (segment.limit - segment.pos);
                segment = segment.next;
            }
            while (j2 > 0) {
                Segment segment2 = new Segment(segment);
                segment2.pos = (int) (((long) segment2.pos) + j);
                segment2.limit = Math.min(segment2.pos + ((int) j2), segment2.limit);
                if (buffer.head == null) {
                    segment2.prev = segment2;
                    segment2.next = segment2;
                    buffer.head = segment2;
                } else {
                    buffer.head.prev.push(segment2);
                }
                j2 -= (long) (segment2.limit - segment2.pos);
                segment = segment.next;
                j = 0;
            }
        }
        return this;
    }

    public BufferedSink emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (this.size != buffer.size) {
            return false;
        }
        if (this.size == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i = segment.pos;
        int i2 = segment2.pos;
        while (j < this.size) {
            long min = (long) Math.min(segment.limit - i, segment2.limit - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = segment.data[i];
                i = i2 + 1;
                if (b != segment2.data[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                i2 = segment2.pos;
            }
            j += min;
        }
        return true;
    }

    public boolean exhausted() {
        return this.size == 0;
    }

    public void flush() {
    }

    public byte getByte(long j) {
        Util.checkOffsetAndCount(this.size, j, 1);
        Segment segment = this.head;
        while (true) {
            int i = segment.limit - segment.pos;
            if (j < ((long) i)) {
                return segment.data[segment.pos + ((int) j)];
            }
            j -= (long) i;
            segment = segment.next;
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.pos;
            while (i2 < segment.limit) {
                int i3 = segment.data[i2] + (i * 31);
                i2++;
                i = i3;
            }
            segment = segment.next;
        } while (segment != this.head);
        return i;
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public long indexOf(byte b) {
        return indexOf(b, 0);
    }

    public long indexOf(byte b, long j) {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        Segment segment2;
        if (this.size - j >= j) {
            segment2 = segment;
            while (true) {
                long j3 = ((long) (segment2.limit - segment2.pos)) + j2;
                if (j3 >= j) {
                    break;
                }
                segment2 = segment2.next;
                j2 = j3;
            }
        } else {
            j2 = this.size;
            segment2 = segment;
            while (j2 > j) {
                segment2 = segment2.prev;
                j2 -= (long) (segment2.limit - segment2.pos);
            }
        }
        while (j2 < this.size) {
            byte[] bArr = segment2.data;
            int i = segment2.limit;
            for (int i2 = (int) ((((long) segment2.pos) + j) - j2); i2 < i; i2++) {
                if (bArr[i2] == b) {
                    return j2 + ((long) (i2 - segment2.pos));
                }
            }
            j2 += (long) (segment2.limit - segment2.pos);
            segment2 = segment2.next;
            j = j2;
        }
        return -1;
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j) {
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        } else if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        } else {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            long j2;
            Segment segment2;
            long j3;
            if (this.size - j >= j) {
                j2 = 0;
                segment2 = segment;
                while (true) {
                    j3 = ((long) (segment2.limit - segment2.pos)) + j2;
                    if (j3 >= j) {
                        break;
                    }
                    segment2 = segment2.next;
                    j2 = j3;
                }
            } else {
                j2 = this.size;
                segment2 = segment;
                while (j2 > j) {
                    segment2 = segment2.prev;
                    j2 -= (long) (segment2.limit - segment2.pos);
                }
            }
            byte b = byteString.getByte(0);
            int size = byteString.size();
            long j4 = (this.size - ((long) size)) + 1;
            long j5 = j2;
            Segment segment3 = segment2;
            while (j5 < j4) {
                byte[] bArr = segment3.data;
                int min = (int) Math.min((long) segment3.limit, (((long) segment3.pos) + j4) - j5);
                int i = (int) ((((long) segment3.pos) + j) - j5);
                while (i < min) {
                    if (bArr[i] == b && rangeEquals(segment3, i + 1, byteString, 1, size)) {
                        return ((long) (i - segment3.pos)) + j5;
                    }
                    i++;
                }
                j3 = ((long) (segment3.limit - segment3.pos)) + j5;
                segment3 = segment3.next;
                j5 = j3;
                j = j3;
            }
            return -1;
        }
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public long indexOfElement(ByteString byteString, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        long j2;
        Segment segment2;
        if (this.size - j >= j) {
            j2 = 0;
            segment2 = segment;
            while (true) {
                long j3 = ((long) (segment2.limit - segment2.pos)) + j2;
                if (j3 >= j) {
                    break;
                }
                segment2 = segment2.next;
                j2 = j3;
            }
        } else {
            j2 = this.size;
            segment2 = segment;
            while (j2 > j) {
                segment2 = segment2.prev;
                j2 -= (long) (segment2.limit - segment2.pos);
            }
        }
        byte[] bArr;
        int i;
        int i2;
        byte b;
        if (byteString.size() == 2) {
            byte b2 = byteString.getByte(0);
            byte b3 = byteString.getByte(1);
            while (j2 < this.size) {
                bArr = segment2.data;
                i = segment2.limit;
                for (i2 = (int) ((((long) segment2.pos) + j) - j2); i2 < i; i2++) {
                    b = bArr[i2];
                    if (b == b2 || b == b3) {
                        return j2 + ((long) (i2 - segment2.pos));
                    }
                }
                j2 += (long) (segment2.limit - segment2.pos);
                segment2 = segment2.next;
                j = j2;
            }
        } else {
            byte[] internalArray = byteString.internalArray();
            while (j2 < this.size) {
                bArr = segment2.data;
                i2 = (int) ((((long) segment2.pos) + j) - j2);
                i = segment2.limit;
                for (int i3 = i2; i3 < i; i3++) {
                    b = bArr[i3];
                    for (byte b4 : internalArray) {
                        if (b == b4) {
                            return j2 + ((long) (i3 - segment2.pos));
                        }
                    }
                }
                j2 += (long) (segment2.limit - segment2.pos);
                segment2 = segment2.next;
                j = j2;
            }
        }
        return -1;
    }

    public InputStream inputStream() {
        return new C45662();
    }

    public ByteString md5() {
        return digest(ISecurity.SIGN_ALGORITHM_MD5);
    }

    public OutputStream outputStream() {
        return new C45651();
    }

    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i, min);
        segment.pos += min;
        this.size -= (long) min;
        if (segment.pos != segment.limit) {
            return min;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return min;
    }

    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.size == 0) {
            return -1;
        } else {
            if (j > this.size) {
                j = this.size;
            }
            buffer.write(this, j);
            return j;
        }
    }

    public long readAll(Sink sink) {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public byte readByte() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        this.size--;
        if (i3 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b;
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] readByteArray(long j) {
        Util.checkOffsetAndCount(this.size, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        readFully(bArr);
        return bArr;
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    public ByteString readByteString(long j) {
        return new ByteString(readByteArray(j));
    }

    public long readDecimalLong() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        Object obj2 = null;
        long j2 = -7;
        do {
            Segment segment = this.head;
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            int i3 = segment.limit;
            while (i2 < i3) {
                int i4 = bArr[i2];
                if (i4 >= 48 && i4 <= 57) {
                    int i5 = 48 - i4;
                    if (j >= -922337203685477580L) {
                        if (j == -922337203685477580L) {
                            if (((long) i5) < j2) {
                            }
                        }
                        j = (j * 10) + ((long) i5);
                    }
                    Buffer writeByte = new Buffer().writeDecimalLong(j).writeByte(i4);
                    if (obj == null) {
                        writeByte.readByte();
                    }
                    throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                } else if (i4 != 45 || i != 0) {
                    if (i != 0) {
                        obj2 = 1;
                        if (i2 != i3) {
                            this.head = segment.pop();
                            SegmentPool.recycle(segment);
                        } else {
                            segment.pos = i2;
                        }
                        if (obj2 == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(i4));
                    }
                } else {
                    obj = 1;
                    j2--;
                }
                i2++;
                i++;
            }
            if (i2 != i3) {
                segment.pos = i2;
            } else {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            if (obj2 == null) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) i;
        return obj != null ? j : -j;
    }

    public Buffer readFrom(InputStream inputStream) {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public Buffer readFrom(InputStream inputStream, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        readFrom(inputStream, j, false);
        return this;
    }

    public void readFully(Buffer buffer, long j) {
        if (this.size < j) {
            buffer.write(this, this.size);
            throw new EOFException();
        } else {
            buffer.write(this, j);
        }
    }

    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    public long readHexadecimalUnsignedLong() {
        if (this.size == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        do {
            Segment segment = this.head;
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            int i3 = segment.limit;
            int i4 = i2;
            while (i4 < i3) {
                int i5 = bArr[i4];
                if (i5 >= 48 && i5 <= 57) {
                    i2 = i5 - 48;
                } else if (i5 >= 97 && i5 <= 102) {
                    i2 = (i5 - 97) + 10;
                } else if (i5 < 65 || i5 > 70) {
                    if (i != 0) {
                        obj = 1;
                        if (i4 != i3) {
                            this.head = segment.pop();
                            SegmentPool.recycle(segment);
                        } else {
                            segment.pos = i4;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i5));
                    }
                } else {
                    i2 = (i5 - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(j).writeByte(i5).readUtf8());
                }
                i++;
                i4++;
                j = ((long) i2) | (j << 4);
            }
            if (i4 != i3) {
                segment.pos = i4;
            } else {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            if (obj == null) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) i;
        return j;
    }

    public int readInt() {
        if (this.size < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((((readByte() & MotionEventCompat.ACTION_MASK) << 24) | ((readByte() & MotionEventCompat.ACTION_MASK) << 16)) | ((readByte() & MotionEventCompat.ACTION_MASK) << 8)) | (readByte() & MotionEventCompat.ACTION_MASK);
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & MotionEventCompat.ACTION_MASK) << 24) | ((bArr[i3] & MotionEventCompat.ACTION_MASK) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & MotionEventCompat.ACTION_MASK) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & MotionEventCompat.ACTION_MASK;
        this.size -= 4;
        if (i4 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return i;
        }
        segment.pos = i4;
        return i;
    }

    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    public long readLong() {
        if (this.size < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (((long) readInt()) & 4294967295L);
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        i = i3 + 1;
        long j2 = ((((long) bArr[i3]) & 255) << 48) | j;
        int i4 = i + 1;
        i = i4 + 1;
        j2 = (j2 | ((((long) bArr[i]) & 255) << 40)) | ((((long) bArr[i4]) & 255) << 32);
        i4 = i + 1;
        i = i4 + 1;
        j2 = (j2 | ((((long) bArr[i]) & 255) << 24)) | ((((long) bArr[i4]) & 255) << 16);
        i4 = i + 1;
        int i5 = i4 + 1;
        long j3 = (((long) bArr[i4]) & 255) | (j2 | ((((long) bArr[i]) & 255) << 8));
        this.size -= 8;
        if (i5 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return j3;
        }
        segment.pos = i5;
        return j3;
    }

    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    public short readShort() {
        if (this.size < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & MotionEventCompat.ACTION_MASK) << 8) | (readByte() & MotionEventCompat.ACTION_MASK));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & MotionEventCompat.ACTION_MASK) << 8) | (bArr[i3] & MotionEventCompat.ACTION_MASK);
        this.size -= 2;
        if (i4 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return (short) i;
    }

    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    public String readString(long j, Charset charset) {
        Util.checkOffsetAndCount(this.size, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return BuildConfig.FLAVOR;
        } else {
            Segment segment = this.head;
            if (((long) segment.pos) + j > ((long) segment.limit)) {
                return new String(readByteArray(j), charset);
            }
            String str = new String(segment.data, segment.pos, (int) j, charset);
            segment.pos = (int) (((long) segment.pos) + j);
            this.size -= j;
            if (segment.pos != segment.limit) {
                return str;
            }
            this.head = segment.pop();
            SegmentPool.recycle(segment);
            return str;
        }
    }

    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readUtf8(long j) {
        return readString(j, Util.UTF_8);
    }

    public int readUtf8CodePoint() {
        if (this.size == 0) {
            throw new EOFException();
        }
        int i;
        int i2;
        int i3;
        byte b = getByte(0);
        if ((b & SpdyProtocol.SLIGHTSSLV2) == 0) {
            i = 0;
            i2 = b & TransportMediator.KEYCODE_MEDIA_PAUSE;
            i3 = 1;
        } else if ((b & 224) == Downloads.STATUS_RUNNING) {
            i2 = b & 31;
            i3 = 2;
            i = 128;
        } else if ((b & 240) == 224) {
            i2 = b & 15;
            i3 = 3;
            i = Message.FLAG_RET;
        } else if ((b & 248) == 240) {
            i2 = b & 7;
            i3 = 4;
            i = AccessibilityNodeInfoCompat.ACTION_CUT;
        } else {
            skip(1);
            return REPLACEMENT_CHARACTER;
        }
        if (this.size < ((long) i3)) {
            throw new EOFException("size < " + i3 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b) + C4233j.f14397t);
        }
        int i4 = i2;
        i2 = 1;
        while (i2 < i3) {
            b = getByte((long) i2);
            if ((b & Downloads.STATUS_RUNNING) == SpdyProtocol.SLIGHTSSLV2) {
                i2++;
                i4 = (b & 63) | (i4 << 6);
            } else {
                skip((long) i2);
                return REPLACEMENT_CHARACTER;
            }
        }
        skip((long) i3);
        return i4 > 1114111 ? REPLACEMENT_CHARACTER : (i4 < 55296 || i4 > 57343) ? i4 < i ? REPLACEMENT_CHARACTER : i4 : REPLACEMENT_CHARACTER;
    }

    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        return indexOf == -1 ? this.size != 0 ? readUtf8(this.size) : null : readUtf8Line(indexOf);
    }

    String readUtf8Line(long j) {
        if (j <= 0 || getByte(j - 1) != 13) {
            String readUtf8 = readUtf8(j);
            skip(1);
            return readUtf8;
        }
        readUtf8 = readUtf8(j - 1);
        skip(2);
        return readUtf8;
    }

    public String readUtf8LineStrict() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0, Math.min(32, this.size));
        throw new EOFException("\\n not found: size=" + size() + " content=" + buffer.readByteString().hex() + "\u2026");
    }

    public boolean request(long j) {
        return this.size >= j;
    }

    public void require(long j) {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.head.limit - this.head.pos));
        for (Segment segment = this.head.next; segment != this.head; segment = segment.next) {
            arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        }
        return arrayList;
    }

    public int select(Options options) {
        Segment segment = this.head;
        if (segment == null) {
            return options.indexOf(ByteString.EMPTY);
        }
        ByteString[] byteStringArr = options.byteStrings;
        int length = byteStringArr.length;
        int i = 0;
        while (i < length) {
            ByteString byteString = byteStringArr[i];
            if (this.size < ((long) byteString.size()) || !rangeEquals(segment, segment.pos, byteString, 0, byteString.size())) {
                i++;
            } else {
                try {
                    skip((long) byteString.size());
                    return i;
                } catch (EOFException e) {
                    throw new AssertionError(e);
                }
            }
        }
        return -1;
    }

    int selectPrefix(Options options) {
        Segment segment = this.head;
        ByteString[] byteStringArr = options.byteStrings;
        int length = byteStringArr.length;
        for (int i = 0; i < length; i++) {
            ByteString byteString = byteStringArr[i];
            int min = (int) Math.min(this.size, (long) byteString.size());
            if (min == 0 || rangeEquals(segment, segment.pos, byteString, 0, min)) {
                return i;
            }
        }
        return -1;
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public long size() {
        return this.size;
    }

    public void skip(long j) {
        while (j > 0) {
            if (this.head == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.head.limit - this.head.pos));
            this.size -= (long) min;
            j -= (long) min;
            Segment segment = this.head;
            segment.pos = min + segment.pos;
            if (this.head.pos == this.head.limit) {
                Segment segment2 = this.head;
                this.head = segment2.pop();
                SegmentPool.recycle(segment2);
            }
        }
    }

    public ByteString snapshot() {
        if (this.size <= 2147483647L) {
            return snapshot((int) this.size);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public ByteString snapshot(int i) {
        return i == 0 ? ByteString.EMPTY : new SegmentedByteString(this, i);
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    Segment writableSegment(int i) {
        if (i < 1 || i > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
            throw new IllegalArgumentException();
        } else if (this.head == null) {
            this.head = SegmentPool.take();
            Segment segment = this.head;
            Segment segment2 = this.head;
            r0 = this.head;
            segment2.prev = r0;
            segment.next = r0;
            return r0;
        } else {
            r0 = this.head.prev;
            return (r0.limit + i > SpdyProtocol.SLIGHTSSL_1_RTT_MODE || !r0.owner) ? r0.push(SegmentPool.take()) : r0;
        }
    }

    public Buffer write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            Segment writableSegment = writableSegment(1);
            int min = Math.min(i3 - i, 8192 - writableSegment.limit);
            System.arraycopy(bArr, i, writableSegment.data, writableSegment.limit, min);
            i += min;
            writableSegment.limit = min + writableSegment.limit;
        }
        this.size += (long) i2;
        return this;
    }

    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            Util.checkOffsetAndCount(buffer.size, 0, j);
            while (j > 0) {
                Segment segment;
                if (j < ((long) (buffer.head.limit - buffer.head.pos))) {
                    segment = this.head != null ? this.head.prev : null;
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            buffer.head.writeTo(segment, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    buffer.head = buffer.head.split((int) j);
                }
                Segment segment2 = buffer.head;
                long j2 = (long) (segment2.limit - segment2.pos);
                buffer.head = segment2.pop();
                if (this.head == null) {
                    this.head = segment2;
                    segment2 = this.head;
                    segment = this.head;
                    Segment segment3 = this.head;
                    segment.prev = segment3;
                    segment2.next = segment3;
                } else {
                    this.head.prev.push(segment2).compact();
                }
                buffer.size -= j2;
                this.size += j2;
                j -= j2;
            }
        }
    }

    public long writeAll(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public Buffer writeByte(int i) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        writableSegment.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    public Buffer writeDecimalLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        Segment writableSegment = writableSegment(i);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = DIGITS[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        writableSegment.limit += i;
        this.size = ((long) i) + this.size;
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        for (int i2 = (writableSegment.limit + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size = ((long) numberOfTrailingZeros) + this.size;
        return this;
    }

    public Buffer writeInt(int i) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & MotionEventCompat.ACTION_MASK);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & MotionEventCompat.ACTION_MASK);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & MotionEventCompat.ACTION_MASK);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & MotionEventCompat.ACTION_MASK);
        writableSegment.limit = i2;
        this.size += 4;
        return this;
    }

    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytesInt(i));
    }

    public Buffer writeLong(long j) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 40) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 32) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 24) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 16) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 8) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) (j & 255));
        writableSegment.limit = i;
        this.size += 8;
        return this;
    }

    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    public Buffer writeShort(int i) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & MotionEventCompat.ACTION_MASK);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & MotionEventCompat.ACTION_MASK);
        writableSegment.limit = i2;
        this.size += 2;
        return this;
    }

    public Buffer writeShortLe(int i) {
        return writeShort(Util.reverseBytesShort((short) i));
    }

    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(Util.UTF_8)) {
            return writeUtf8(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeTo(OutputStream outputStream) {
        return writeTo(outputStream, this.size);
    }

    public Buffer writeTo(OutputStream outputStream, long j) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0, j);
        Segment segment = this.head;
        while (j > 0) {
            Segment pop;
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            outputStream.write(segment.data, segment.pos, min);
            segment.pos += min;
            this.size -= (long) min;
            j -= (long) min;
            if (segment.pos == segment.limit) {
                pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
            } else {
                pop = segment;
            }
            segment = pop;
        }
        return this;
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    public Buffer writeUtf8(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt < '\u0080') {
                    int i4;
                    Segment writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.data;
                    int i5 = writableSegment.limit - i;
                    int min = Math.min(i2, 8192 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '\u0080') {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - writableSegment.limit;
                    writableSegment.limit += i4;
                    this.size += (long) i4;
                } else if (charAt < '\u0800') {
                    writeByte((charAt >> 6) | Downloads.STATUS_RUNNING);
                    writeByte((charAt & 63) | SpdyProtocol.SLIGHTSSLV2);
                    i3 = i + 1;
                } else if (charAt < '\ud800' || charAt > '\udfff') {
                    writeByte((charAt >> 12) | 224);
                    writeByte(((charAt >> 6) & 63) | SpdyProtocol.SLIGHTSSLV2);
                    writeByte((charAt & 63) | SpdyProtocol.SLIGHTSSLV2);
                    i3 = i + 1;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '\udbff' || i3 < 56320 || i3 > 57343) {
                        writeByte(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + AccessibilityNodeInfoCompat.ACTION_CUT;
                        writeByte((i3 >> 18) | 240);
                        writeByte(((i3 >> 12) & 63) | SpdyProtocol.SLIGHTSSLV2);
                        writeByte(((i3 >> 6) & 63) | SpdyProtocol.SLIGHTSSLV2);
                        writeByte((i3 & 63) | SpdyProtocol.SLIGHTSSLV2);
                        i3 = i + 2;
                    }
                }
                i = i3;
            }
            return this;
        }
    }

    public Buffer writeUtf8CodePoint(int i) {
        if (i < SpdyProtocol.SLIGHTSSLV2) {
            writeByte(i);
        } else if (i < Message.FLAG_RET) {
            writeByte((i >> 6) | Downloads.STATUS_RUNNING);
            writeByte((i & 63) | SpdyProtocol.SLIGHTSSLV2);
        } else if (i < AccessibilityNodeInfoCompat.ACTION_CUT) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | SpdyProtocol.SLIGHTSSLV2);
                writeByte((i & 63) | SpdyProtocol.SLIGHTSSLV2);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | SpdyProtocol.SLIGHTSSLV2);
            writeByte(((i >> 6) & 63) | SpdyProtocol.SLIGHTSSLV2);
            writeByte((i & 63) | SpdyProtocol.SLIGHTSSLV2);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }
}
