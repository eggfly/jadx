package com.xiaomi.market.sdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.xiaomi.market.sdk.Connection.NetworkError;
import com.xiaomi.market.sdk.Connection.Parameter;
import com.xiaomi.market.sdk.Constants.UpdateMethod;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class XiaomiUpdateAgent {
    private static boolean f4623a;
    private static boolean f4624b;
    private static WeakReference<Context> f4625c;
    private static boolean f4626d;
    private static boolean f4627e;
    private static boolean f4628f;
    private static LocalAppInfo f4629g;
    private static UpdateInfo f4630h;
    private static XiaomiUpdateListener f4631i;
    private static UpdateMethod f4632j;
    private static boolean f4633k;

    private static class CheckUpdateTask extends AsyncTask<Void, Void, Integer> {

        /* renamed from: com.xiaomi.market.sdk.XiaomiUpdateAgent.CheckUpdateTask.1 */
        final class C05191 implements OnClickListener {
            C05191() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                XiaomiUpdateAgent.m6221b();
            }
        }

        private static class CheckDownloadTask extends AsyncTask<Void, Void, Boolean> {
            private CheckDownloadTask() {
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m6205a((Void[]) objArr);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                m6206a((Boolean) obj);
            }

            protected Boolean m6205a(Void... voidArr) {
                Context context = (Context) XiaomiUpdateAgent.f4625c.get();
                if (context == null) {
                    return Boolean.valueOf(false);
                }
                return Boolean.valueOf(DownloadInstallManager.m6178a(context).m6190a(XiaomiUpdateAgent.f4629g));
            }

            protected void m6206a(Boolean bool) {
                if (!bool.booleanValue()) {
                    CheckUpdateTask.m6210c();
                }
            }
        }

        private CheckUpdateTask() {
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6211a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6212a((Integer) obj);
        }

        protected void onPreExecute() {
            Log.d("MarketUpdateAgent", "start to check update");
            if (!XiaomiUpdateAgent.f4628f) {
                XiaomiUpdateAgent.f4628f = Patcher.m6193a();
            }
        }

        protected Integer m6211a(Void... voidArr) {
            Context context = (Context) XiaomiUpdateAgent.f4625c.get();
            if (context == null) {
                return Integer.valueOf(4);
            }
            if (!Utils.m6203b(context)) {
                return Integer.valueOf(3);
            }
            if (!Utils.m6204c(context) && XiaomiUpdateAgent.f4627e) {
                return Integer.valueOf(2);
            }
            XiaomiUpdateAgent.f4629g = XiaomiUpdateAgent.m6220b(context);
            if (XiaomiUpdateAgent.f4629g == null) {
                return Integer.valueOf(5);
            }
            Connection connection = new Connection(Constants.f4573a);
            connection.getClass();
            Parameter parameter = new Parameter(connection);
            parameter.m6155a("info", m6209b());
            parameter.m6155a("packageName", XiaomiUpdateAgent.f4629g.f4593a);
            parameter.m6155a("versionCode", XiaomiUpdateAgent.f4629g.f4595c + "");
            parameter.m6155a("apkHash", XiaomiUpdateAgent.f4629g.f4599g);
            parameter.m6155a("signature", XiaomiUpdateAgent.f4629g.f4597e);
            parameter.m6155a("clientId", Client.f4538n);
            parameter.m6155a("sdk", String.valueOf(Client.f4534j));
            parameter.m6155a("os", Client.f4535k);
            parameter.m6155a("la", Client.f4539o);
            parameter.m6155a("co", Client.f4540p);
            parameter.m6155a("xiaomiSDKVersion", "0");
            parameter.m6155a("debug", XiaomiUpdateAgent.f4633k ? "1" : "0");
            if (NetworkError.OK == connection.m6167b()) {
                XiaomiUpdateAgent.f4630h = m6207a(connection.m6165a());
                if (XiaomiUpdateAgent.f4630h != null) {
                    int i;
                    Log.i("MarketUpdateAgent", XiaomiUpdateAgent.f4630h.toString());
                    if (XiaomiUpdateAgent.f4630h.f4613c == 0) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    return Integer.valueOf(i);
                }
            }
            return Integer.valueOf(4);
        }

        protected void m6212a(Integer num) {
            XiaomiUpdateAgent.f4624b = false;
            if (XiaomiUpdateAgent.f4626d) {
                switch (num.intValue()) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                        new CheckDownloadTask().execute(new Void[0]);
                        return;
                    default:
                        return;
                }
            }
            UpdateResponse updateResponse = new UpdateResponse();
            if (num.intValue() == 0) {
                updateResponse.f4602a = XiaomiUpdateAgent.f4630h.f4614d;
                updateResponse.f4604c = XiaomiUpdateAgent.f4630h.f4615e;
                updateResponse.f4603b = XiaomiUpdateAgent.f4630h.f4616f;
                updateResponse.f4606e = XiaomiUpdateAgent.f4630h.f4619i;
                updateResponse.f4607f = XiaomiUpdateAgent.f4630h.f4618h;
                updateResponse.f4608g = XiaomiUpdateAgent.f4630h.f4622l;
                updateResponse.f4605d = Connection.m6159a(XiaomiUpdateAgent.f4630h.f4611a, XiaomiUpdateAgent.f4630h.f4617g);
            }
            if (XiaomiUpdateAgent.f4631i != null) {
                XiaomiUpdateAgent.f4631i.m2687a(num.intValue(), updateResponse);
            }
        }

        private String m6209b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("screenSize", Client.f4525a + "*" + Client.f4526b);
                jSONObject.put("resolution", Client.f4527c);
                jSONObject.put("density", Client.f4528d);
                jSONObject.put("touchScreen", Client.f4529e);
                jSONObject.put("glEsVersion", Client.f4530f);
                jSONObject.put("feature", Client.f4531g);
                jSONObject.put("library", Client.f4532h);
                jSONObject.put("glExtension", Client.f4533i);
                jSONObject.put("sdk", Client.f4534j);
                jSONObject.put("version", Client.f4535k);
                jSONObject.put("release", Client.f4536l);
                jSONObject.put("deviceId", Coder.m6150a(Client.f4537m));
                return jSONObject.toString();
            } catch (JSONException e) {
                return "";
            }
        }

        private UpdateInfo m6207a(JSONObject jSONObject) {
            if (jSONObject == null) {
                Log.e("MarketUpdateAgent", "update info json obj null");
                return null;
            }
            if (Utils.f4609a) {
                Log.d("MarketUpdateAgent", "updateInfo : " + jSONObject.toString());
            }
            UpdateInfo updateInfo = new UpdateInfo();
            try {
                updateInfo.f4611a = jSONObject.getString("host");
                updateInfo.f4613c = jSONObject.getInt("fitness");
                updateInfo.f4612b = jSONObject.getInt("source");
                updateInfo.f4614d = jSONObject.getString("updateLog");
                updateInfo.f4615e = jSONObject.getInt("versionCode");
                updateInfo.f4616f = jSONObject.getString("versionName");
                updateInfo.f4617g = jSONObject.getString("apk");
                updateInfo.f4618h = jSONObject.getString("apkHash");
                updateInfo.f4619i = jSONObject.getLong("apkSize");
                if (XiaomiUpdateAgent.f4628f) {
                    updateInfo.f4620j = jSONObject.getString("diffFile");
                    updateInfo.f4621k = jSONObject.getString("diffFileHash");
                    updateInfo.f4622l = jSONObject.getLong("diffFileSize");
                }
                return updateInfo;
            } catch (JSONException e) {
                Log.e("MarketUpdateAgent", "get update info failed : " + e.toString());
                Log.e("MarketUpdateAgent", "original content : " + jSONObject.toString());
                return null;
            }
        }

        private static void m6210c() {
            Context context = (Context) XiaomiUpdateAgent.f4625c.get();
            if (context != null) {
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    Log.e("MarketUpdateAgent", "activity not running!");
                    return;
                }
                CharSequence string;
                Builder title = new Builder(context).setTitle(context.getString(Utils.m6198a(context.getPackageName(), "string", "xiaomi_update_dialog_title"), new Object[]{XiaomiUpdateAgent.f4629g.f4594b}));
                if (TextUtils.isEmpty(XiaomiUpdateAgent.f4630h.f4620j)) {
                    string = context.getString(Utils.m6198a(context.getPackageName(), "string", "xiaomi_update_dialog_message"), new Object[]{XiaomiUpdateAgent.f4630h.f4616f, Utils.m6199a(XiaomiUpdateAgent.f4630h.f4619i, context)});
                } else {
                    string = context.getString(Utils.m6198a(context.getPackageName(), "string", "xiaomi_update_dialog_message_diff"), new Object[]{XiaomiUpdateAgent.f4630h.f4616f, Utils.m6199a(XiaomiUpdateAgent.f4630h.f4622l, context)});
                }
                title.setMessage(string).setNegativeButton(17039360, null).setPositiveButton(17039370, new C05191()).show();
            }
        }
    }

    static class UpdateInfo {
        String f4611a;
        int f4612b;
        int f4613c;
        String f4614d;
        int f4615e;
        String f4616f;
        String f4617g;
        String f4618h;
        long f4619i;
        String f4620j;
        String f4621k;
        long f4622l;

        UpdateInfo() {
            this.f4620j = "";
            this.f4621k = "";
        }

        public String toString() {
            return "UpdateInfo:\nhost = " + this.f4611a + "\nfitness = " + this.f4613c + "\nupdateLog = " + this.f4614d + "\nversionCode = " + this.f4615e + "\nversionName = " + this.f4616f + "\napkUrl = " + this.f4617g + "\napkHash = " + this.f4618h + "\napkSize = " + this.f4619i + "\ndiffUrl = " + this.f4620j + "\ndiffHash = " + this.f4621k + "\ndiffSize = " + this.f4622l;
        }
    }

    static {
        f4623a = false;
        f4624b = false;
        f4625c = new WeakReference(null);
        f4626d = true;
        f4627e = false;
        f4628f = false;
        f4632j = Utils.m6200a() ? UpdateMethod.DOWNLOAD_MANAGER : UpdateMethod.MARKET;
    }

    public static synchronized void m6216a(Context context) {
        synchronized (XiaomiUpdateAgent.class) {
            boolean z;
            try {
                Class cls = Class.forName(context.getPackageName() + ".BuildConfig");
                z = cls.getDeclaredField("DEBUG").getBoolean(cls);
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            m6217a(context, z);
        }
    }

    public static synchronized void m6217a(Context context, boolean z) {
        synchronized (XiaomiUpdateAgent.class) {
            if (context != null) {
                if (!f4624b) {
                    f4633k = z;
                    f4624b = true;
                    Client.m6136a(context);
                    f4625c = new WeakReference(context);
                    if (!f4623a) {
                        f4629g = null;
                        f4630h = null;
                        Constants.m6168a();
                        f4623a = true;
                    }
                    new CheckUpdateTask().execute(new Void[0]);
                }
            }
        }
    }

    public static void m6219a(boolean z) {
        f4626d = z;
    }

    public static void m6218a(XiaomiUpdateListener xiaomiUpdateListener) {
        f4631i = xiaomiUpdateListener;
    }

    static Context m6213a() {
        return (Context) f4625c.get();
    }

    static LocalAppInfo m6220b(Context context) {
        PackageInfo packageInfo;
        LocalAppInfo a = LocalAppInfo.m6191a(context.getPackageName());
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(a.f4593a, 64);
        } catch (NameNotFoundException e) {
            Log.e("MarketUpdateAgent", "get package info failed");
            packageInfo = null;
        }
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return null;
        }
        a.f4594b = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
        a.f4595c = packageInfo.versionCode;
        a.f4596d = packageInfo.versionName;
        a.f4597e = Coder.m6150a(String.valueOf(packageInfo.signatures[0].toChars()));
        a.f4598f = packageInfo.applicationInfo.sourceDir;
        a.f4599g = Coder.m6149a(new File(a.f4598f));
        return a;
    }

    static void m6221b() {
        Context context = (Context) f4625c.get();
        if (context != null && f4630h != null && f4629g != null) {
            if (f4632j.equals(UpdateMethod.MARKET) && f4630h.f4612b != 1 && Utils.m6201a(context)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?back=true&id=" + f4629g.f4593a));
                intent.setClassName("com.xiaomi.market", "com.xiaomi.market.ui.AppDetailActivity");
                List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities != null && queryIntentActivities.size() == 1) {
                    ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(0);
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.exported && resolveInfo.activityInfo.enabled) {
                        context.startActivity(intent);
                        return;
                    }
                }
            }
            DownloadInstallManager.m6178a(context).m6189a(f4629g, f4630h);
        }
    }
}
