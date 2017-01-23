package com.antutu.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.model.C1523d;
import com.antutu.utils.widget.WebBrowserActivity;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.facebook.ads.AdError;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.pushsdk.C4459R;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import org.apache.http.entity.mime.MIME;

public class Methods {

    /* renamed from: com.antutu.utils.Methods.1 */
    static class C17981 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$idUrl;

        C17981(String str, Context context) {
            this.val$idUrl = str;
            this.val$context = context;
        }

        public void run() {
            try {
                char[] cArr = new char[SpdyProtocol.SLIGHTSSLV2];
                URLConnection openConnection = new URL(this.val$idUrl).openConnection();
                openConnection.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
                openConnection.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
                Object trim = new String(cArr).substring(0, new InputStreamReader(openConnection.getInputStream()).read(cArr)).trim();
                MLog.m6864d("@openZOL, id=" + trim);
                if (!TextUtils.isEmpty(trim)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("zol://product.detail/" + trim));
                    intent.setFlags(335544320);
                    this.val$context.startActivity(intent);
                }
            } catch (MalformedURLException e) {
            } catch (IOException e2) {
            }
        }
    }

    private static boolean Assets2File(Context context, String str, String str2) {
        try {
            File file = new File(str2);
            if (file.exists() && !file.delete()) {
                return false;
            }
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String convertStreamToString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream bufferedInputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    bufferedInputStream.close();
                    return byteArrayOutputStream.toString(HttpRequest.f14548a);
                }
            }
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            bufferedInputStream.close();
        }
    }

    public static void copy(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }

    public static Bitmap createImage(Object obj, byte[] bArr) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (Exception e) {
            recycleBitmap(bitmap);
        } catch (OutOfMemoryError e2) {
            recycleBitmap(bitmap);
        }
        return bitmap;
    }

    public static void downloadFromAmazon(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("amzn://apps/android?p=" + str)).setFlags(268435456));
        } catch (Exception e) {
        }
    }

    public static void downloadFromGP(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
            context.startActivity(intent);
        } catch (Exception e) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).setFlags(268435456));
        }
    }

    public static void editSharedPreferences(String str, long j) {
        try {
            PreferenceManager.getDefaultSharedPreferences(ABenchmarkApplication.getContext()).edit().putLong(str, j).commit();
        } catch (Exception e) {
        }
    }

    public static void editSharedPreferences(String str, String str2) {
        try {
            PreferenceManager.getDefaultSharedPreferences(ABenchmarkApplication.getContext()).edit().putString(str, str2).commit();
        } catch (Exception e) {
        }
    }

    public static void editSharedPreferences(String str, boolean z) {
        try {
            PreferenceManager.getDefaultSharedPreferences(ABenchmarkApplication.getContext()).edit().putBoolean(str, z).commit();
        } catch (Exception e) {
        }
    }

    private static boolean filterProcess(int i) {
        return (i & 1) != 0;
    }

    public static int getAvaliableMemSize(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return (int) (memoryInfo.availMem >> 20);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getRamUsage(Context context) {
        if (context == null) {
            return 0;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        try {
            int round = Math.round((1.0f - (((float) (memoryInfo.availMem >> 10)) / ((float) IO.getRamTotalSize()))) * 100.0f);
            try {
                MLog.m6870i("hzd, @getRamUsage, percent=" + round);
                return round;
            } catch (Exception e) {
                return round;
            }
        } catch (Exception e2) {
            return 0;
        }
    }

    public static String getRandomData(int i) {
        String str = BuildConfig.FLAVOR;
        Random random = new Random();
        int i2 = 0;
        while (i2 < i) {
            i2++;
            str = str + Math.abs(random.nextInt() % 10);
        }
        return str.substring(0, 1).equals(MessageService.MSG_DB_READY_REPORT) ? MessageService.MSG_DB_NOTIFY_REACHED + str.substring(1) : str;
    }

    public static boolean getSharedPreferencesBoolean(String str, boolean z) {
        try {
            z = PreferenceManager.getDefaultSharedPreferences(ABenchmarkApplication.getContext()).getBoolean(str, z);
        } catch (Exception e) {
        }
        return z;
    }

    public static long getSharedPreferencesLong(String str, long j) {
        try {
            j = PreferenceManager.getDefaultSharedPreferences(ABenchmarkApplication.getContext()).getLong(str, j);
        } catch (Exception e) {
        }
        return j;
    }

    public static String getSharedPreferencesString(String str, String str2) {
        try {
            str2 = PreferenceManager.getDefaultSharedPreferences(ABenchmarkApplication.getContext()).getString(str, str2);
        } catch (Exception e) {
        }
        return str2;
    }

    public static int getSpeedupPercent(Context context) {
        if (context == null) {
            return 0;
        }
        double d = 0.0d;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        PackageManager packageManager = context.getPackageManager();
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            int i = runningAppProcessInfo.pid;
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(runningAppProcessInfo.pkgList[0], 1);
                if (!(myPid == i || filterProcess(packageInfo.applicationInfo.flags))) {
                    d += (double) activityManager.getProcessMemoryInfo(new int[]{i})[0].getTotalPss();
                }
            } catch (Exception e) {
            }
        }
        double ramTotalSize = d / ((double) IO.getRamTotalSize());
        MLog.m6870i("hzd, @getSpeedupPercent, speedupPercent=" + ramTotalSize);
        return (int) (ramTotalSize * 100.0d);
    }

    public static boolean hasAssetFile(Context context, String str) {
        try {
            for (String contains : context.getAssets().list(BuildConfig.FLAVOR)) {
                if (contains.contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean hasInstalled(String str) {
        try {
            return ABenchmarkApplication.getContext().getPackageManager().getPackageInfo(str, 0) != null;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static void hideSoftKeyboard(Context context, View view) {
        if (view != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static String httpGet(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String str2 = BuildConfig.FLAVOR;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str2 = str2 + readLine + "\n";
            }
            bufferedReader.close();
            httpURLConnection.disconnect();
            return (responseCode != Constants.COMMAND_HANDSHAKE ? "http_error: " + responseCode : str2).trim();
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static String httpPost(String str, String str2) {
        return httpPost(str, str2, 10000);
    }

    public static String httpPost(String str, String str2, int i) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, HttpRequest.f14549b);
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(str2);
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String str3 = BuildConfig.FLAVOR;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str3 = str3 + readLine + "\n";
            }
            str3 = str3.trim();
            bufferedReader.close();
            httpURLConnection.disconnect();
            return (responseCode != Constants.COMMAND_HANDSHAKE ? "http_error: " + responseCode : str3).trim();
        } catch (Exception e) {
            MLog.m6867e(e.toString());
            return BuildConfig.FLAVOR;
        }
    }

    public static boolean installAssetApk(Context context, String str) {
        try {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/temp_apk.apk");
            if (Assets2File(context, str, file.getAbsolutePath())) {
                Intent flags = new Intent("android.intent.action.VIEW").setFlags(268435456);
                flags.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                context.startActivity(flags);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isChinese() {
        String b = C1523d.m6061b();
        return b != null && b.contains("zh");
    }

    public static boolean isMobileNetwork(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            if (activeNetworkInfo.getType() == 0) {
                MLog.m6864d("hzd, 2G/3G\u7f51\u7edc...");
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    public static boolean isServiceRunning(Context context, String str) {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (str.equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int isWifi(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                try {
                    Toast.makeText(context, C1082R.string.prompt_net, 0).show();
                } catch (Exception e) {
                }
                return 0;
            }
            int type = activeNetworkInfo.getType();
            return (type == 1 || type == 6) ? 1 : 0;
        } catch (Exception e2) {
            return 1;
        }
    }

    public static void openApp(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                if (launchIntentForPackage == null) {
                    throw new NameNotFoundException();
                }
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            } catch (NameNotFoundException e) {
            } catch (Exception e2) {
            }
        }
    }

    public static void openApp(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent();
                intent.setFlags(268435456);
                intent.setComponent(new ComponentName(str, str2));
                ABenchmarkApplication.getContext().startActivity(intent);
            } catch (Exception e) {
            }
        }
    }

    public static void openBrower(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e) {
            }
        }
    }

    public static void openZOL(Context context, String str, String str2) {
        MLog.m6864d("hzd, wapUrl=" + str);
        if (hasInstalled("com.zol.android".intern()) && !TextUtils.isEmpty(str2)) {
            new Thread(new C17981(str2, context)).start();
        } else if (!TextUtils.isEmpty(str)) {
            WebBrowserActivity.openURLInApp(context, str, context.getString(C4459R.string.app_name));
        }
    }

    public static void recycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public static void sendEmail(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Illegal params: context is null or mailto is empty.");
        } else if (NetUtils.isNetworkAvailable()) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:" + str));
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            context.startActivity(intent);
        } else {
            showToast(context, (int) C1082R.string.prompt_net, (int) AdError.NETWORK_ERROR_CODE);
        }
    }

    public static void sendInnerBroadcast(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static void setText(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            textView.setTypeface(Typeface.MONOSPACE, 3);
            textView.setText(str);
        }
    }

    public static void setTextBold(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            textView.getPaint().setFakeBoldText(true);
            textView.setText(str);
        }
    }

    public static void showSoftKeyboard(TextView textView) {
        if (textView != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInputFromInputMethod(textView.getWindowToken(), 0);
            }
        }
    }

    public static void showToast(Context context, int i, int i2) {
        if (i > 0) {
            try {
                Toast.makeText(context, i, i2).show();
            } catch (Exception e) {
            }
        }
    }

    public static void showToast(Context context, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Toast.makeText(context, str, i).show();
            } catch (Exception e) {
            }
        }
    }

    public static int writeToFile(byte[] bArr, String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            OutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(bArr, 0, bArr.length);
            fileOutputStream.close();
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }
}
