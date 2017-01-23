package okio;

import android.support.v4.view.MotionEventCompat;
import anet.channel.security.ISecurity;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString EMPTY;
    static final char[] HEX_DIGITS;
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        EMPTY = of(new byte[0]);
    }

    ByteString(byte[] bArr) {
        this.data = bArr;
    }

    static int codePointIndexToCharIndex(String str, int i) {
        int i2 = 0;
        int length = str.length();
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public static ByteString decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] decode = Base64.decode(str);
        return decode != null ? new ByteString(decode) : null;
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        } else {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i * 2)) << 4) + decodeHexDigit(str.charAt((i * 2) + 1)));
            }
            return of(bArr);
        }
    }

    private static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 65) + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    private ByteString digest(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new ByteString(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public static ByteString encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(Util.UTF_8));
        byteString.utf8 = str;
        return byteString;
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            return of(instance.doFinal(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static ByteString of(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new ByteString(bArr);
    }

    public static ByteString of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString of(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new ByteString(obj);
    }

    public static ByteString read(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        } else {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new ByteString(bArr);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ByteString read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField(Constants.KEY_DATA);
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public String base64() {
        return Base64.encode(this.data);
    }

    public String base64Url() {
        return Base64.encodeUrl(this.data);
    }

    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int min = Math.min(size, size2);
        int i = 0;
        while (i < min) {
            int i2 = getByte(i) & MotionEventCompat.ACTION_MASK;
            int i3 = byteString.getByte(i) & MotionEventCompat.ACTION_MASK;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            } else {
                i++;
            }
        }
        return size == size2 ? 0 : size >= size2 ? 1 : -1;
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = (obj instanceof ByteString) && ((ByteString) obj).size() == this.data.length && ((ByteString) obj).rangeEquals(0, this.data, 0, this.data.length);
        return z;
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.data);
        this.hashCode = i;
        return i;
    }

    public String hex() {
        int i = 0;
        char[] cArr = new char[(this.data.length * 2)];
        byte[] bArr = this.data;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = HEX_DIGITS[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = HEX_DIGITS[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.internalArray(), 0);
    }

    public final int indexOf(ByteString byteString, int i) {
        return indexOf(byteString.internalArray(), i);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public int indexOf(byte[] bArr, int i) {
        int length = this.data.length - bArr.length;
        for (int max = Math.max(i, 0); max <= length; max++) {
            if (Util.arrayRangeEquals(this.data, max, bArr, 0, bArr.length)) {
                return max;
            }
        }
        return -1;
    }

    byte[] internalArray() {
        return this.data;
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.internalArray(), size());
    }

    public final int lastIndexOf(ByteString byteString, int i) {
        return lastIndexOf(byteString.internalArray(), i);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public int lastIndexOf(byte[] bArr, int i) {
        for (int min = Math.min(i, this.data.length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(this.data, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public ByteString md5() {
        return digest(ISecurity.SIGN_ALGORITHM_MD5);
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        return byteString.rangeEquals(i2, this.data, i, i3);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.data.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.arrayRangeEquals(this.data, i, bArr, i2, i3);
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public int size() {
        return this.data.length;
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.data, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public ByteString substring(int i) {
        return substring(i, this.data.length);
    }

    public ByteString substring(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.data.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.data.length + C4233j.f14397t);
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.data.length) {
                return this;
            } else {
                Object obj = new byte[i3];
                System.arraycopy(this.data, i, obj, 0, i3);
                return new ByteString(obj);
            }
        }
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b = this.data[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b + 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b = this.data[i];
            if (b < (byte) 97 || b > (byte) 122) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b - 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 97 && b2 <= (byte) 122) {
                        bArr[i] = (byte) (b2 - 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String utf8 = utf8();
        int codePointIndexToCharIndex = codePointIndexToCharIndex(utf8, 64);
        if (codePointIndexToCharIndex == -1) {
            return this.data.length <= 64 ? "[hex=" + hex() + "]" : "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "\u2026]";
        } else {
            String replace = utf8.substring(0, codePointIndexToCharIndex).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            return codePointIndexToCharIndex < utf8.length() ? "[size=" + this.data.length + " text=" + replace + "\u2026]" : "[text=" + replace + "]";
        }
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        str = new String(this.data, Util.UTF_8);
        this.utf8 = str;
        return str;
    }

    public void write(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.data);
    }

    void write(Buffer buffer) {
        buffer.write(this.data, 0, this.data.length);
    }
}
