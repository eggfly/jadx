package tv.ouya.console.api;

import android.util.Base64;
import bia;
import java.security.Key;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
    public List<Receipt> j6(JSONObject jSONObject, PublicKey publicKey) {
        if (jSONObject.has("key") && jSONObject.has("iv") && jSONObject.has("blob")) {
            byte[] decode = Base64.decode(jSONObject.getString("key").trim(), 0);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            instance.init(2, publicKey);
            Key secretKeySpec = new SecretKeySpec(instance.doFinal(decode), "AES");
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(Base64.decode(jSONObject.getString("iv").trim(), 0));
            decode = Base64.decode(jSONObject.getString("blob").trim(), 0);
            Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance2.init(2, secretKeySpec, ivParameterSpec);
            return j6(new JSONObject(new String(instance2.doFinal(decode), "UTF-8")).getJSONArray("purchases"));
        }
        throw new RuntimeException("Invalid response from server");
    }

    public String DW(JSONObject jSONObject, PublicKey publicKey) {
        if (jSONObject.has("key") && jSONObject.has("iv") && jSONObject.has("blob")) {
            byte[] decode = Base64.decode(jSONObject.getString("key"), 0);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            instance.init(2, publicKey);
            Key secretKeySpec = new SecretKeySpec(instance.doFinal(decode), "AES");
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(Base64.decode(jSONObject.getString("iv"), 0));
            decode = Base64.decode(jSONObject.getString("blob"), 0);
            Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance2.init(2, secretKeySpec, ivParameterSpec);
            JSONObject jSONObject2 = new JSONObject(new String(instance2.doFinal(decode), "UTF-8"));
            if (jSONObject2.has("uuid")) {
                return jSONObject2.getString("uuid");
            }
            return null;
        }
        throw new RuntimeException("Invalid response from server");
    }

    public List<Receipt> j6(JSONArray jSONArray) {
        List arrayList = new ArrayList(jSONArray.length());
        bia bia = new bia();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(j6(bia, jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private Receipt j6(bia bia, JSONObject jSONObject) {
        Date date;
        Date date2;
        String str = "purchaseDate";
        if (jSONObject.has(str)) {
            date = new Date(jSONObject.getLong(str));
        } else {
            date = bia.parse(jSONObject.getString("date"));
        }
        str = "generateDate";
        if (jSONObject.has(str)) {
            date2 = new Date(jSONObject.getLong(str));
        } else {
            date2 = new Date();
            date2.setTime(0);
        }
        String optString = jSONObject.optString("identifier");
        if (optString.isEmpty()) {
            optString = jSONObject.getString("sku");
        }
        return new Receipt(optString, jSONObject.optInt("priceInCents", 0), date, date2, jSONObject.getString("gamer"), jSONObject.getString("uuid"), jSONObject.optDouble("localPrice", 0.0d), jSONObject.optString("currency", "USD"));
    }
}
