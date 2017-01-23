package okio;

import android.support.v4.view.MotionEventCompat;
import cn.sharesdk.framework.Platform;
import com.antutu.utils.widget.SystemBarTintManager;
import com.umeng.message.util.HttpRequest;
import java.nio.charset.Charset;

final class Util {
    public static final Charset UTF_8;

    static {
        UTF_8 = Charset.forName(HttpRequest.f14548a);
    }

    private Util() {
    }

    public static boolean arrayRangeEquals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    public static int reverseBytesInt(int i) {
        return ((((SystemBarTintManager.DEFAULT_TINT_COLOR & i) >>> 24) | ((16711680 & i) >>> 8)) | ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) << 8)) | ((i & MotionEventCompat.ACTION_MASK) << 24);
    }

    public static long reverseBytesLong(long j) {
        return ((((((((-72057594037927936L & j) >>> 56) | ((71776119061217280L & j) >>> 40)) | ((280375465082880L & j) >>> 24)) | ((1095216660480L & j) >>> 8)) | ((4278190080L & j) << 8)) | ((16711680 & j) << 24)) | ((65280 & j) << 40)) | ((255 & j) << 56);
    }

    public static short reverseBytesShort(short s) {
        int i = Platform.CUSTOMER_ACTION_MASK & s;
        return (short) (((i & MotionEventCompat.ACTION_MASK) << 8) | ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >>> 8));
    }

    public static void sneakyRethrow(Throwable th) {
        sneakyThrow2(th);
    }

    private static <T extends Throwable> void sneakyThrow2(Throwable th) {
        throw th;
    }
}
