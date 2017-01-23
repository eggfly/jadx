package com.dropbox.client2.android;

import adx;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;

public class AuthActivity extends Activity {
    private static final String DW;
    private static a FH;
    private static final Object Hw;
    private static final String[] J8;
    private static String VH;
    private static String Zo;
    private static String gn;
    public static Intent j6;
    private static String v5;
    private String EQ;
    private String J0;
    private String tp;
    private String u7;
    private String we;

    public interface a {
        SecureRandom j6();
    }

    static class 1 implements a {
        1() {
        }

        public SecureRandom j6() {
            return new SecureRandom();
        }
    }

    static class 2 implements OnClickListener {
        2() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public AuthActivity() {
        this.J0 = null;
    }

    static {
        DW = AuthActivity.class.getName();
        FH = new 1();
        Hw = new Object();
        j6 = null;
        VH = "www.dropbox.com";
        J8 = new String[]{"308202223082018b02044bd207bd300d06092a864886f70d01010405003058310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130744726f70626f783112301006035504031309546f6d204d65796572301e170d3130303432333230343930315a170d3430303431353230343930315a3058310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130744726f70626f783112301006035504031309546f6d204d6579657230819f300d06092a864886f70d010101050003818d0030818902818100ac1595d0ab278a9577f0ca5a14144f96eccde75f5616f36172c562fab0e98c48ad7d64f1091c6cc11ce084a4313d522f899378d312e112a748827545146a779defa7c31d8c00c2ed73135802f6952f59798579859e0214d4e9c0554b53b26032a4d2dfc2f62540d776df2ea70e2a6152945fb53fef5bac5344251595b729d4810203010001300d06092a864886f70d01010405000381810055c425d94d036153203dc0bbeb3516f94563b102fff39c3d4ed91278db24fc4424a244c2e59f03bbfea59404512b8bf74662f2a32e37eafa2ac904c31f99cfc21c9ff375c977c432d3b6ec22776f28767d0f292144884538c3d5669b568e4254e4ed75d9054f75229ac9d4ccd0b7c3c74a34f07b7657083b2aa76225c0c56ffc", "308201e53082014ea00302010202044e17e115300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3131303730393035303331375a170d3431303730313035303331375a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d003081890281810096759fe5abea6a0757039b92adc68d672efa84732c3f959408e12efa264545c61f23141026a6d01eceeeaa13ec7087087e5894a3363da8bf5c69ed93657a6890738a80998e4ca22dc94848f30e2d0e1890000ae2cddf543b20c0c3828deca6c7944b5ecd21a9d18c988b2b3e54517dafbc34b48e801bb1321e0fa49e4d575d7f0203010001300d06092a864886f70d0101050500038181002b6d4b65bcfa6ec7bac97ae6d878064d47b3f9f8da654995b8ef4c385bc4fbfbb7a987f60783ef0348760c0708acd4b7e63f0235c35a4fbcd5ec41b3b4cb295feaa7d5c27fa562a02562b7e1f4776b85147be3e295714986c4a9a07183f48ea09ae4d3ea31b88d0016c65b93526b9c45f2967c3d28dee1aff5a5b29b9c2c8639"};
    }

    static void j6(String str, String str2) {
        j6(str, str2, null, null);
    }

    static void j6(String str, String str2, String str3, String str4) {
        v5 = str;
        Zo = str2;
        if (str3 == null) {
            str3 = "www.dropbox.com";
        }
        VH = str3;
        gn = str4;
    }

    public static boolean j6(Context context, String str, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        String str2 = "db-" + str;
        intent.setData(Uri.parse(str2 + "://" + 1 + "/connect"));
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
            throw new IllegalStateException("URI scheme in your app's manifest is not set up correctly. You should have a " + AuthActivity.class.getName() + " with the " + "scheme: " + str2);
        } else if (queryIntentActivities.size() <= 1) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(0);
            if (resolveInfo != null && resolveInfo.activityInfo != null && context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            throw new IllegalStateException("There must be a " + AuthActivity.class.getName() + " within your app's package " + "registered for your URI scheme (" + str2 + "). However, " + "it appears that an activity in a different package is " + "registered for that scheme instead. If you have " + "multiple apps that all want to use the same access" + "token pair, designate one of them to do " + "authentication and have the other apps launch it " + "and then retrieve the token pair from it.");
        } else if (z) {
            Builder builder = new Builder(context);
            builder.setTitle("Security alert");
            builder.setMessage("Another app on your phone may be trying to pose as the app you are currently using. The malicious app can't access your account, but linking to Dropbox has been disabled as a precaution. Please contact support@dropbox.com.");
            builder.setPositiveButton("OK", new 2());
            builder.show();
            return false;
        } else {
            Log.w(DW, "There are multiple apps registered for the AuthActivity URI scheme (" + str2 + ").  Another app may be trying to " + " impersonate this app, so authentication will be disabled.");
            return false;
        }
    }

    private static a j6() {
        a aVar;
        synchronized (Hw) {
            aVar = FH;
        }
        return aVar;
    }

    private static SecureRandom DW() {
        a j6 = j6();
        if (j6 != null) {
            return j6.j6();
        }
        return new SecureRandom();
    }

    protected void onCreate(Bundle bundle) {
        if (bundle == null) {
            j6 = null;
            this.J0 = null;
            this.u7 = v5;
            this.tp = Zo;
            this.EQ = VH;
            this.we = gn;
        } else {
            this.J0 = bundle.getString("SIS_KEY_AUTH_STATE_NONCE");
        }
        j6(null, null);
        setTheme(16973840);
        super.onCreate(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("SIS_KEY_AUTH_STATE_NONCE", this.J0);
    }

    protected void onResume() {
        super.onResume();
        if (!isFinishing()) {
            if (this.J0 != null || this.u7 == null) {
                j6(null);
                return;
            }
            j6 = null;
            String Hw = Hw();
            Intent intent = new Intent();
            intent.setPackage("com.dropbox.android");
            intent.setAction("com.dropbox.android.AUTHENTICATE_V2");
            intent.putExtra("CONSUMER_KEY", this.u7);
            intent.putExtra("CONSUMER_SIG", FH());
            intent.putExtra("CALLING_PACKAGE", getPackageName());
            intent.putExtra("CALLING_CLASS", getClass().getName());
            intent.putExtra("AUTH_STATE", Hw);
            if (DW(intent)) {
                startActivity(intent);
            } else {
                j6(Hw);
            }
            this.J0 = Hw;
        }
    }

    protected void onNewIntent(Intent intent) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        String stringExtra4;
        Intent intent2 = null;
        if (this.J0 == null) {
            j6(null);
            return;
        }
        if (intent.hasExtra("ACCESS_TOKEN")) {
            stringExtra = intent.getStringExtra("ACCESS_TOKEN");
            stringExtra2 = intent.getStringExtra("ACCESS_SECRET");
            stringExtra3 = intent.getStringExtra("UID");
            stringExtra4 = intent.getStringExtra("AUTH_STATE");
        } else {
            Uri data = intent.getData();
            if (data != null) {
                if ("/connect".equals(data.getPath())) {
                    try {
                        stringExtra2 = data.getQueryParameter("oauth_token");
                        try {
                            stringExtra3 = data.getQueryParameter("oauth_token_secret");
                            try {
                                stringExtra4 = data.getQueryParameter("uid");
                            } catch (UnsupportedOperationException e) {
                                stringExtra4 = null;
                                stringExtra = stringExtra2;
                                stringExtra2 = stringExtra3;
                                stringExtra3 = stringExtra4;
                                stringExtra4 = null;
                                if (this.J0.equals(stringExtra4)) {
                                    intent2 = new Intent();
                                    intent2.putExtra("ACCESS_TOKEN", stringExtra);
                                    intent2.putExtra("ACCESS_SECRET", stringExtra2);
                                    intent2.putExtra("UID", stringExtra3);
                                    j6(intent2);
                                }
                                j6(null);
                                return;
                            }
                            try {
                                String queryParameter = data.getQueryParameter("state");
                                stringExtra = stringExtra2;
                                stringExtra2 = stringExtra3;
                                stringExtra3 = stringExtra4;
                                stringExtra4 = queryParameter;
                            } catch (UnsupportedOperationException e2) {
                                stringExtra = stringExtra2;
                                stringExtra2 = stringExtra3;
                                stringExtra3 = stringExtra4;
                                stringExtra4 = null;
                                if (this.J0.equals(stringExtra4)) {
                                    intent2 = new Intent();
                                    intent2.putExtra("ACCESS_TOKEN", stringExtra);
                                    intent2.putExtra("ACCESS_SECRET", stringExtra2);
                                    intent2.putExtra("UID", stringExtra3);
                                    j6(intent2);
                                }
                                j6(null);
                                return;
                            }
                        } catch (UnsupportedOperationException e3) {
                            stringExtra4 = null;
                            stringExtra3 = null;
                            stringExtra = stringExtra2;
                            stringExtra2 = stringExtra3;
                            stringExtra3 = stringExtra4;
                            stringExtra4 = null;
                            if (this.J0.equals(stringExtra4)) {
                                intent2 = new Intent();
                                intent2.putExtra("ACCESS_TOKEN", stringExtra);
                                intent2.putExtra("ACCESS_SECRET", stringExtra2);
                                intent2.putExtra("UID", stringExtra3);
                                j6(intent2);
                            }
                            j6(null);
                            return;
                        }
                    } catch (UnsupportedOperationException e4) {
                        stringExtra4 = null;
                        stringExtra3 = null;
                        stringExtra2 = null;
                        stringExtra = stringExtra2;
                        stringExtra2 = stringExtra3;
                        stringExtra3 = stringExtra4;
                        stringExtra4 = null;
                        if (this.J0.equals(stringExtra4)) {
                            j6(null);
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("ACCESS_TOKEN", stringExtra);
                        intent2.putExtra("ACCESS_SECRET", stringExtra2);
                        intent2.putExtra("UID", stringExtra3);
                        j6(intent2);
                    }
                }
            }
            stringExtra4 = null;
            stringExtra3 = null;
            stringExtra2 = null;
            stringExtra = null;
        }
        if (!(stringExtra == null || stringExtra.equals("") || ((stringExtra2 != null && stringExtra2.equals("")) || stringExtra3 == null || stringExtra3.equals("") || stringExtra4 == null || stringExtra4.equals("")))) {
            if (this.J0.equals(stringExtra4)) {
                j6(null);
                return;
            }
            intent2 = new Intent();
            intent2.putExtra("ACCESS_TOKEN", stringExtra);
            intent2.putExtra("ACCESS_SECRET", stringExtra2);
            intent2.putExtra("UID", stringExtra3);
        }
        j6(intent2);
    }

    private void j6(Intent intent) {
        j6 = intent;
        this.J0 = null;
        finish();
    }

    private String FH() {
        if (this.tp == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(this.tp.getBytes(), 0, this.tp.length());
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            return String.format("%1$040X", new Object[]{bigInteger}).substring(32);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private boolean DW(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || 1 != queryIntentActivities.size()) {
            return false;
        }
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            for (Signature signature : packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures) {
                for (String equals : J8) {
                    if (equals.equals(signature.toCharsString())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void j6(String str) {
        Locale locale = Locale.getDefault();
        String[] strArr = new String[]{"locale", locale.getLanguage() + "_" + locale.getCountry(), "k", this.u7, "s", FH(), "api", this.we, "state", str};
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(adx.j6(this.EQ, 1, "/connect", strArr))));
    }

    private String Hw() {
        DW().nextBytes(new byte[16]);
        StringBuilder stringBuilder = new StringBuilder();
        if (this.tp == null) {
            stringBuilder.append("oauth2:");
        }
        for (int i = 0; i < 16; i++) {
            stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(r2[i] & 255)}));
        }
        return stringBuilder.toString();
    }
}
