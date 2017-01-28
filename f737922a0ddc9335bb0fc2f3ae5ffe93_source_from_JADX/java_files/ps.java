import android.accounts.Account;
import android.accounts.AccountManager;
import android.util.Base64;
import com.aide.ui.e;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ps {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public void j6() {
        /*
        r7 = this;
        r0 = com.aide.ui.e.gn();	 Catch:{ FileNotFoundException -> 0x003b, Exception -> 0x0041 }
        r1 = "sponsorship.json";
        r2 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x003b, Exception -> 0x0041 }
        r1 = 0;
        r0 = new aya;	 Catch:{ Throwable -> 0x0046, all -> 0x005d }
        r0.<init>();	 Catch:{ Throwable -> 0x0046, all -> 0x005d }
        r3 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x0046, all -> 0x005d }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x0046, all -> 0x005d }
        r0 = r0.DW(r3);	 Catch:{ Throwable -> 0x0046, all -> 0x005d }
        r0 = (axx) r0;	 Catch:{ Throwable -> 0x0046, all -> 0x005d }
        r0 = r7.j6(r0);	 Catch:{ Throwable -> 0x0046, all -> 0x005d }
        if (r0 == 0) goto L_0x002e;
    L_0x0022:
        r0 = com.aide.ui.e.Mr();	 Catch:{ Throwable -> 0x0046, all -> 0x005d }
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r0.j6(r4);	 Catch:{ Throwable -> 0x0046, all -> 0x005d }
    L_0x002e:
        if (r2 == 0) goto L_0x0035;
    L_0x0030:
        if (r1 == 0) goto L_0x003d;
    L_0x0032:
        r2.close();	 Catch:{ Throwable -> 0x0036 }
    L_0x0035:
        return;
    L_0x0036:
        r0 = move-exception;
        r1.addSuppressed(r0);	 Catch:{ FileNotFoundException -> 0x003b, Exception -> 0x0041 }
        goto L_0x0035;
    L_0x003b:
        r0 = move-exception;
        goto L_0x0035;
    L_0x003d:
        r2.close();	 Catch:{ FileNotFoundException -> 0x003b, Exception -> 0x0041 }
        goto L_0x0035;
    L_0x0041:
        r0 = move-exception;
        com.aide.common.e.j6(r0);
        goto L_0x0035;
    L_0x0046:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0048 }
    L_0x0048:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x004c:
        if (r2 == 0) goto L_0x0053;
    L_0x004e:
        if (r1 == 0) goto L_0x0059;
    L_0x0050:
        r2.close();	 Catch:{ Throwable -> 0x0054 }
    L_0x0053:
        throw r0;	 Catch:{ FileNotFoundException -> 0x003b, Exception -> 0x0041 }
    L_0x0054:
        r2 = move-exception;
        r1.addSuppressed(r2);	 Catch:{ FileNotFoundException -> 0x003b, Exception -> 0x0041 }
        goto L_0x0053;
    L_0x0059:
        r2.close();	 Catch:{ FileNotFoundException -> 0x003b, Exception -> 0x0041 }
        goto L_0x0053;
    L_0x005d:
        r0 = move-exception;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: ps.j6():void");
    }

    public void DW() {
    }

    public void j6(String str, ps$a ps_a) {
        j6("Intel", str, ps_a);
    }

    private void j6(String str, String str2, ps$a ps_a) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            axx axx = new axx();
            axx.put("packageName", e.j6);
            axx.put("googleAccountAddress", str2);
            axx.put("sponsoringProgram", str);
            HttpParams basicHttpParams = new BasicHttpParams();
            ConnManagerParams.setTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 50000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 50000);
            HttpUriRequest httpPost = new HttpPost("https://api.appfour.com/aideservices/sponsoring/v1/requestLicense");
            httpPost.setParams(basicHttpParams);
            httpPost.setEntity(new StringEntity(axx.toString()));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            String str3 = (String) defaultHttpClient.execute(httpPost, new BasicResponseHandler());
            axx axx2 = (axx) new aya().j6(str3);
            e.j6(new ps$1(this, j6(axx2), ps_a, ((Boolean) axx2.get("alreadyInDatabase")).booleanValue(), str3));
        } catch (Throwable e) {
            com.aide.common.e.j6(e);
            e.j6(new ps$2(this, ps_a, e));
        }
    }

    private boolean j6(axx axx) {
        if (!Boolean.TRUE.equals(axx.get("granted"))) {
            return false;
        }
        String str = (String) axx.get("data");
        String str2 = (String) axx.get("signature");
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4PX6yTLxZ2OSmBKIgeEZNnP6UFqdAqVmlHGJeJFSNPa1cQv6fjTBA0CB9V95Fz6rv16XDEvWk0ewcsWLWuf6y1+ajsWP9K7G5bCHJ0YwVaoqeXJz6149wDiQBzLtzVh5FdPZdCP5CXnRon2yOMYxTqaKmtz/Ou3FdYGqAmz4UXc5CVOV7C5KPbSAcWURKlbaCRi/X0htUHSHdwBuJ8QW2PExtG+0Ev65S39SXdYfz9QtZZt7BaL1aeTmDBi5FO27tFH6rFA/dnTV1e5A4aemhz4hHNn9BgOiws1NW5Zmy6pHi+2P9H7pCQte805/mOdidnm84uFS5sMSviDD55LwyQIDAQAB", 0)));
        Signature instance = Signature.getInstance("SHA1withRSA");
        instance.initVerify(generatePublic);
        instance.update(str.getBytes());
        if (!instance.verify(Base64.decode(str2, 0))) {
            return false;
        }
        axx axx2 = (axx) new aya().j6(str);
        if (!e.j6.equals(axx2.get("packageName"))) {
            return false;
        }
        if (!"Intel".equals(axx2.get("sponsoringProgram"))) {
            return false;
        }
        str = (String) axx2.get("googleAccountAddress");
        Account[] accountsByType = AccountManager.get(e.gn()).getAccountsByType("com.google");
        if (accountsByType != null) {
            for (Account account : accountsByType) {
                if (str.equals(account.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void j6(String str) {
        FileOutputStream openFileOutput;
        try {
            openFileOutput = e.gn().openFileOutput("sponsorship.json", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
        } catch (Throwable e) {
            com.aide.common.e.j6(e);
        } catch (Throwable th) {
            openFileOutput.close();
        }
    }
}
