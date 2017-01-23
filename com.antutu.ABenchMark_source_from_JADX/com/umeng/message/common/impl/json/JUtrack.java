package com.umeng.message.common.impl.json;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack.ICallBack;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.common.inter.IUtrack;
import com.umeng.message.entity.Alias;
import com.umeng.message.entity.Ucode;
import com.umeng.message.proguard.C4215b;
import com.umeng.message.proguard.C4230g;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.proguard.C4239k;
import com.umeng.message.provider.C4243a;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

public class JUtrack implements IUtrack {
    private static final String f14286a;
    private Context f14287b;

    /* renamed from: com.umeng.message.common.impl.json.JUtrack.1 */
    class C42121 implements Runnable {
        final /* synthetic */ List f14284a;
        final /* synthetic */ JUtrack f14285b;

        C42121(JUtrack jUtrack, List list) {
            this.f14285b = jUtrack;
            this.f14284a = list;
        }

        public void run() {
            try {
                Thread.sleep(10000);
                for (int i = 0; i < this.f14284a.size(); i++) {
                    Ucode ucode = (Ucode) this.f14284a.get(i);
                    ucode.f14300b = UmengMessageDeviceConfig.getDataData(ucode.f14302p);
                }
                MessageSharedPrefs.getInstance(this.f14285b.f14287b).setKeyAndValue("ucode", C4230g.m17263a(this.f14284a));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        f14286a = JUtrack.class.getSimpleName();
    }

    public JUtrack(Context context) {
        this.f14287b = context;
    }

    private void m17191a(JSONObject jSONObject, String str, long j) {
        try {
            if (!str.equals(BuildConfig.FLAVOR)) {
                jSONObject.put(MsgConstant.KEY_ALIAS_FAIL_LOG, str);
                JSONObject sendRequest = sendRequest(jSONObject, MsgConstant.ALIAS_LOG);
                if (sendRequest != null && TextUtils.equals(sendRequest.optString(MsgConstant.KEY_SUCCESS, BuildConfig.FLAVOR), ITagManager.SUCCESS)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(C4233j.f14375B, MessageService.MSG_DB_NOTIFY_DISMISS);
                    String[] strArr = new String[]{j + BuildConfig.FLAVOR};
                    ContentResolver contentResolver = this.f14287b.getContentResolver();
                    C4243a.m17332a(this.f14287b);
                    contentResolver.update(C4243a.f14477d, contentValues, "time=?", strArr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject sendRequest(JSONObject jSONObject, String str) {
        String b = HttpRequest.m17396c((CharSequence) str).m17423H().m17522r(HttpRequest.f14550c).m17502i(jSONObject.toString()).m17474b(HttpRequest.f14548a);
        UmLog.m17136d(f14286a, "sendRequest() url=" + str + "\n request = " + jSONObject + "\n response = " + b);
        return new JSONObject(b);
    }

    public void addAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z) {
        String optString = jSONObject.optString(ITagManager.FAIL, BuildConfig.FLAVOR);
        String optString2 = jSONObject.optString(MsgConstant.KEY_SUCCESS, BuildConfig.FLAVOR);
        UmLog.m17140i(f14286a, "keyfail:" + optString + ",keysuccess:" + optString2);
        if (optString.equals(BuildConfig.FLAVOR) && optString2.equals(BuildConfig.FLAVOR)) {
            JSONObject sendRequest = z ? sendRequest(jSONObject, MsgConstant.ALIAS_ENDPOINT) : sendRequest(jSONObject, MsgConstant.ALIAS_ENDPOINT.replace(HttpConstant.HTTPS, HttpConstant.HTTP));
            if (sendRequest == null || !TextUtils.equals(sendRequest.optString(MsgConstant.KEY_SUCCESS, BuildConfig.FLAVOR), ITagManager.SUCCESS)) {
                MessageSharedPrefs.getInstance(this.f14287b).addAlias(str, str2, 0, 1, "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25alias:" + str + ",type:" + str2 + ",devicetoken:" + MessageSharedPrefs.getInstance(this.f14287b).getDeviceToken());
                iCallBack.onMessage(false, "alias:" + str + "\u6dfb\u52a0\u5931\u8d25");
                return;
            }
            MessageSharedPrefs.getInstance(this.f14287b).addAlias(str, str2, 0, 0, BuildConfig.FLAVOR);
            iCallBack.onMessage(true, "alias:" + str + "\u6dfb\u52a0\u6210\u529f");
            return;
        }
        if (!optString.equals(BuildConfig.FLAVOR)) {
            iCallBack.onMessage(false, "alias:" + str + "\u6dfb\u52a0\u5931\u8d25");
            MessageSharedPrefs.getInstance(this.f14287b).addAlias(str, str2, 0, 1, optString);
        }
        if (!optString2.equals(BuildConfig.FLAVOR)) {
            iCallBack.onMessage(true, "alias:" + str + "\u5df2\u7ecf\u6dfb\u52a0");
            MessageSharedPrefs.getInstance(this.f14287b).addAlias(str, str2, 0, 2, optString2);
        }
    }

    public void addExclusiveAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z) {
        String optString = jSONObject.optString(ITagManager.FAIL, BuildConfig.FLAVOR);
        String optString2 = jSONObject.optString(MsgConstant.KEY_SUCCESS, BuildConfig.FLAVOR);
        if (optString.equals(BuildConfig.FLAVOR) && optString2.equals(BuildConfig.FLAVOR)) {
            JSONObject sendRequest = z ? sendRequest(jSONObject, MsgConstant.ALIAS_EXCLUSIVE_ENDPOINT) : sendRequest(jSONObject, MsgConstant.ALIAS_EXCLUSIVE_ENDPOINT.replace(HttpConstant.HTTPS, HttpConstant.HTTP));
            if (sendRequest == null || !TextUtils.equals(sendRequest.optString(MsgConstant.KEY_SUCCESS, BuildConfig.FLAVOR), ITagManager.SUCCESS)) {
                MessageSharedPrefs.getInstance(this.f14287b).addAlias(str, str2, 1, 1, "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25alias:" + str + ",type:" + str2 + ",devicetoken:" + MessageSharedPrefs.getInstance(this.f14287b).getDeviceToken());
                iCallBack.onMessage(false, "alias:" + str + "\u6dfb\u52a0\u5931\u8d25");
                return;
            }
            MessageSharedPrefs.getInstance(this.f14287b).addAlias(str, str2, 1, 0, BuildConfig.FLAVOR);
            iCallBack.onMessage(true, "alias:" + str + "\u6dfb\u52a0\u6210\u529f");
            return;
        }
        if (!optString.equals(BuildConfig.FLAVOR)) {
            iCallBack.onMessage(false, "alias:" + str + "\u6dfb\u52a0\u5931\u8d25");
            MessageSharedPrefs.getInstance(this.f14287b).addAlias(str, str2, 1, 1, optString);
        }
        if (!optString2.equals(BuildConfig.FLAVOR)) {
            iCallBack.onMessage(true, "alias:" + str + "\u5df2\u7ecf\u6dfb\u52a0");
            MessageSharedPrefs.getInstance(this.f14287b).addAlias(str, str2, 1, 2, optString2);
        }
    }

    public void removeAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z) {
        JSONObject sendRequest = z ? sendRequest(jSONObject, MsgConstant.DELETE_ALIAS_ENDPOINT) : sendRequest(jSONObject, MsgConstant.DELETE_ALIAS_ENDPOINT.replace(HttpConstant.HTTPS, HttpConstant.HTTP));
        if (sendRequest != null && TextUtils.equals(sendRequest.getString(MsgConstant.KEY_SUCCESS), ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.f14287b).removeAlias(0, str, str2);
            iCallBack.onMessage(true, "alias:" + str + ",type:" + str2 + "\u5220\u9664\u6210\u529f");
        }
    }

    public void sendAliasFailLog(JSONObject jSONObject) {
        try {
            String[] strArr = new String[]{MessageService.MSG_DB_NOTIFY_REACHED};
            String str = BuildConfig.FLAVOR;
            ContentResolver contentResolver = this.f14287b.getContentResolver();
            C4243a.m17332a(this.f14287b);
            Cursor query = contentResolver.query(C4243a.f14477d, new String[]{C4233j.f14376C, C4233j.f14377D}, "error=?", strArr, null);
            if (query != null) {
                List<Alias> arrayList = new ArrayList();
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    String string = query.getString(query.getColumnIndex(C4233j.f14376C));
                    long j = query.getLong(query.getColumnIndex(C4233j.f14377D));
                    Alias alias = new Alias();
                    alias.aliasMessage = string;
                    alias.aliasTime = j;
                    arrayList.add(alias);
                    query.moveToNext();
                }
                if (query != null) {
                    query.close();
                }
                for (Alias alias2 : arrayList) {
                    m17191a(jSONObject, alias2.aliasMessage, alias2.aliasTime);
                }
            }
        } catch (Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsgLog(JSONObject jSONObject, String str, int i, long j, boolean z) {
        JSONObject sendRequest = z ? sendRequest(jSONObject, MsgConstant.LOG_ENDPOINT) : sendRequest(jSONObject, MsgConstant.LOG_ENDPOINT.replace(HttpConstant.HTTPS, HttpConstant.HTTP));
        if (sendRequest != null && TextUtils.equals(sendRequest.getString(MsgConstant.KEY_SUCCESS), ITagManager.SUCCESS)) {
            C4239k.m17301a(this.f14287b).m17310a(str, i);
            if (i != 0) {
                C4239k.m17301a(this.f14287b).m17317b(str);
            }
        }
    }

    public void trackAppLaunch(JSONObject jSONObject, boolean z) {
        JSONObject sendRequest = z ? sendRequest(jSONObject, MsgConstant.LAUNCH_ENDPOINT) : sendRequest(jSONObject, MsgConstant.LAUNCH_ENDPOINT.replace(HttpConstant.HTTPS, HttpConstant.HTTP));
        if (sendRequest != null && TextUtils.equals(sendRequest.getString(MsgConstant.KEY_SUCCESS), ITagManager.SUCCESS)) {
            C4239k.m17301a(this.f14287b).m17308a(System.currentTimeMillis());
            int i = sendRequest.getInt("launch_policy");
            UmLog.m17136d(f14286a, "launch_policy:" + i);
            int i2 = sendRequest.getInt("tag_policy");
            UmLog.m17136d(f14286a, "tag_policy:" + i2);
            if (i > 0) {
                MessageSharedPrefs.getInstance(this.f14287b).setAppLaunchLogSendPolicy(i);
            }
            if (i2 > 0) {
                MessageSharedPrefs.getInstance(this.f14287b).setTagSendPolicy(i2);
            }
            JSONArray jSONArray = new JSONArray(C4215b.m17210b(sendRequest.optString("ucode"), "utf-8"));
            List arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.getJSONObject(i3).optString("p");
                int optInt = jSONArray.getJSONObject(i3).optInt("f");
                Ucode ucode = new Ucode();
                ucode.f14302p = optString;
                ucode.f14301f = (long) optInt;
                ucode.f14300b = false;
                arrayList.add(ucode);
            }
            new Thread(new C42121(this, arrayList)).start();
        }
    }

    public void trackLocation(JSONObject jSONObject, boolean z) {
        if (z) {
            try {
                JSONObject sendRequest = sendRequest(jSONObject, MsgConstant.LBS_ENDPOINT);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        sendRequest = sendRequest(jSONObject, MsgConstant.LBS_ENDPOINT.replace(HttpConstant.HTTPS, HttpConstant.HTTP));
        if (sendRequest != null && TextUtils.equals(sendRequest.getString(MsgConstant.KEY_SUCCESS), ITagManager.SUCCESS)) {
            UmLog.m17136d(f14286a, "location track success");
        }
    }

    public void trackRegister(JSONObject jSONObject, boolean z) {
        JSONObject sendRequest = z ? sendRequest(jSONObject, MsgConstant.REGISTER_ENDPOINT) : sendRequest(jSONObject, MsgConstant.REGISTER_ENDPOINT.replace(HttpConstant.HTTPS, HttpConstant.HTTP));
        if (sendRequest != null && TextUtils.equals(sendRequest.getString(MsgConstant.KEY_SUCCESS), ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.f14287b).setHasResgister(true);
            if (TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.f14287b).getDeviceToken())) {
                UmLog.m17138e(f14286a, "setRegisteredToUmeng: empty registration id");
            }
        }
    }
}
