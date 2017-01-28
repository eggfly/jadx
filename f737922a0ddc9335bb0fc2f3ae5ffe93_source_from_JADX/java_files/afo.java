import android.util.Base64;

public final class afo {
    public static String DW(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 10);
    }

    public static String j6(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 0);
    }
}
