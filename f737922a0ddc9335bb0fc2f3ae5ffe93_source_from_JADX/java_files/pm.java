import android.util.Base64;
import com.aide.common.d;
import com.aide.ui.R;
import com.aide.ui.e;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
import tv.ouya.console.api.Purchasable;
import tv.ouya.console.api.f;
import tv.ouya.console.api.h;

public class pm {
    private PublicKey DW;
    private boolean FH;
    private boolean j6;

    public void j6() {
        if (d.j6() && f.j6().v5() && v5()) {
            this.j6 = true;
        }
    }

    public void DW() {
        if (this.j6) {
            f.j6().DW();
            this.j6 = false;
        }
    }

    public void FH() {
        if (this.j6 && !this.FH) {
            this.FH = true;
            f.j6().j6(new pm$1(this));
        }
    }

    private boolean v5() {
        try {
            InputStream openRawResource = e.u7().getResources().openRawResource(R.e.ouya_key);
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            openRawResource.close();
            this.DW = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
            return true;
        } catch (Throwable e) {
            com.aide.common.e.j6("Unable to read OUYA encryption key", e);
            return false;
        }
    }

    public void Hw() {
        if (this.j6) {
            h pm_2 = new pm$2(this);
            try {
                SecureRandom instance = SecureRandom.getInstance("SHA1PRNG");
                String toHexString = Long.toHexString(instance.nextLong());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uuid", toHexString);
                jSONObject.put("identifier", "aide_full_30");
                jSONObject.put("testing", "true");
                toHexString = jSONObject.toString();
                byte[] bArr = new byte[16];
                instance.nextBytes(bArr);
                Key secretKeySpec = new SecretKeySpec(bArr, "AES");
                byte[] bArr2 = new byte[16];
                instance.nextBytes(bArr2);
                AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
                instance2.init(1, secretKeySpec, ivParameterSpec);
                byte[] doFinal = instance2.doFinal(toHexString.getBytes("UTF-8"));
                Cipher instance3 = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
                instance3.init(1, this.DW);
                f.j6().j6(new Purchasable("aide_full_30", Base64.encodeToString(instance3.doFinal(bArr), 2), Base64.encodeToString(bArr2, 2), Base64.encodeToString(doFinal, 2)), pm_2);
            } catch (Throwable e) {
                com.aide.common.e.j6("Ouya purchase request failed", e);
            }
        }
    }
}
