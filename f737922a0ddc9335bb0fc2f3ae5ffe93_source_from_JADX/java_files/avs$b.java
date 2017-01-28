import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

class avs$b extends avs {
    private static int DW;
    private static byte[] FH;
    private final String Hw;
    private final PBEParameterSpec Zo;
    private final SecretKey v5;

    static {
        DW = 5000;
        FH = new byte[]{(byte) -92, (byte) 11, (byte) -56, (byte) 52, (byte) -42, (byte) -107, (byte) -13, (byte) 19};
    }

    avs$b(String str, String str2) {
        this.Hw = str;
        this.v5 = SecretKeyFactory.getInstance(str).generateSecret(new PBEKeySpec(str2.toCharArray(), FH, DW, 32));
        this.Zo = new PBEParameterSpec(FH, DW);
    }

    void j6(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty(new StringBuilder(String.valueOf(str)).append("jets3t-crypto-ver").toString(), "2");
        httpURLConnection.setRequestProperty(new StringBuilder(String.valueOf(str)).append("jets3t-crypto-alg").toString(), this.Hw);
    }

    void DW(HttpURLConnection httpURLConnection, String str) {
        j6(httpURLConnection, str, "2", this.Hw);
    }

    OutputStream j6(OutputStream outputStream) {
        try {
            Cipher instance = Cipher.getInstance(this.Hw);
            instance.init(1, this.v5, this.Zo);
            return new CipherOutputStream(outputStream, instance);
        } catch (Throwable e) {
            throw j6(e);
        } catch (Throwable e2) {
            throw j6(e2);
        } catch (Throwable e22) {
            throw j6(e22);
        } catch (Throwable e222) {
            throw j6(e222);
        }
    }

    InputStream j6(InputStream inputStream) {
        try {
            Cipher instance = Cipher.getInstance(this.Hw);
            instance.init(2, this.v5, this.Zo);
            return new CipherInputStream(inputStream, instance);
        } catch (Throwable e) {
            throw j6(e);
        } catch (Throwable e2) {
            throw j6(e2);
        } catch (Throwable e22) {
            throw j6(e22);
        } catch (Throwable e222) {
            throw j6(e222);
        }
    }
}
