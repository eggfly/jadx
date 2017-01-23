import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class ahd {
    static Object DW;
    static Method FH;
    static agz Hw;
    static Method j6;

    static {
        j6 = null;
        DW = null;
        FH = null;
        Hw = null;
        Hw = aha.j6(ahd.class.getName());
        try {
            Class cls = Class.forName("android.util.Base64");
            j6 = cls.getMethod("encode", new Class[]{byte[].class, Integer.TYPE});
            Hw.FH(cls.getName() + " is available.");
        } catch (ClassNotFoundException e) {
        } catch (Throwable e2) {
            Hw.j6("Failed to initialize use of android.util.Base64", e2);
        }
        try {
            cls = Class.forName("org.bouncycastle.util.encoders.Base64Encoder");
            DW = cls.newInstance();
            FH = cls.getMethod("encode", new Class[]{byte[].class, Integer.TYPE, Integer.TYPE, OutputStream.class});
            Hw.FH(cls.getName() + " is available.");
        } catch (ClassNotFoundException e3) {
        } catch (Throwable e22) {
            Hw.j6("Failed to initialize use of org.bouncycastle.util.encoders.Base64Encoder", e22);
        }
        if (j6 == null && FH == null) {
            throw new IllegalStateException("No base64 encoder implementation is available.");
        }
    }

    public static String j6(byte[] bArr) {
        try {
            if (j6 != null) {
                return new String((byte[]) j6.invoke(null, new Object[]{bArr, Integer.valueOf(2)}));
            } else if (FH != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                FH.invoke(DW, new Object[]{bArr, Integer.valueOf(0), Integer.valueOf(bArr.length), byteArrayOutputStream});
                return new String(byteArrayOutputStream.toByteArray());
            } else {
                throw new IllegalStateException("No base64 encoder implementation is available.");
            }
        } catch (Exception e) {
            throw new IllegalStateException(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
