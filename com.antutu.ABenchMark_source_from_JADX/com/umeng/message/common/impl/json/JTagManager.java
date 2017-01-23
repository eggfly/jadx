package com.umeng.message.common.impl.json;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.common.inter.ITagManager.Result;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class JTagManager implements ITagManager {
    private static final String f14282a;
    private Context f14283b;

    static {
        f14282a = JTagManager.class.getSimpleName();
    }

    public JTagManager(Context context) {
        this.f14283b = context;
    }

    public Result add(JSONObject jSONObject, boolean z, String... strArr) {
        Result result = new Result(z ? JUtrack.sendRequest(jSONObject, MsgConstant.TAG_ENDPOINT + "/add") : JUtrack.sendRequest(jSONObject, (MsgConstant.TAG_ENDPOINT + "/add").replace(HttpConstant.HTTPS, HttpConstant.HTTP)));
        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.f14283b).addTags(strArr);
            MessageSharedPrefs.getInstance(this.f14283b).setTagRemain(result.remain);
        }
        return result;
    }

    public Result delete(JSONObject jSONObject, boolean z, String... strArr) {
        Result result = new Result(z ? JUtrack.sendRequest(jSONObject, MsgConstant.TAG_ENDPOINT + "/delete") : JUtrack.sendRequest(jSONObject, (MsgConstant.TAG_ENDPOINT + "/delete").replace(HttpConstant.HTTPS, HttpConstant.HTTP)));
        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.f14283b).removeTags(strArr);
            MessageSharedPrefs.getInstance(this.f14283b).setTagRemain(result.remain);
        }
        return result;
    }

    public List<String> list(JSONObject jSONObject, boolean z) {
        JSONObject sendRequest = z ? JUtrack.sendRequest(jSONObject, MsgConstant.TAG_ENDPOINT + "/get") : JUtrack.sendRequest(jSONObject, (MsgConstant.TAG_ENDPOINT + "/get").replace(HttpConstant.HTTPS, HttpConstant.HTTP));
        if (!TextUtils.equals(new Result(sendRequest).status, ITagManager.SUCCESS) || sendRequest.getString(MsgConstant.KEY_TAGS) == null) {
            return null;
        }
        UmLog.m17136d(f14282a, sendRequest.getString(MsgConstant.KEY_TAGS));
        return Arrays.asList(sendRequest.getString(MsgConstant.KEY_TAGS).split(Constants.ACCEPT_TIME_SEPARATOR_SP));
    }

    public Result reset(JSONObject jSONObject, boolean z) {
        Result result = new Result(z ? JUtrack.sendRequest(jSONObject, MsgConstant.TAG_ENDPOINT + "/reset") : JUtrack.sendRequest(jSONObject, (MsgConstant.TAG_ENDPOINT + "/reset").replace(HttpConstant.HTTPS, HttpConstant.HTTP)));
        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.f14283b).resetTags();
        }
        return result;
    }

    public Result update(JSONObject jSONObject, boolean z, String... strArr) {
        Result result = new Result(z ? JUtrack.sendRequest(jSONObject, MsgConstant.TAG_ENDPOINT + "/update") : JUtrack.sendRequest(jSONObject, (MsgConstant.TAG_ENDPOINT + "/update").replace(HttpConstant.HTTPS, HttpConstant.HTTP)));
        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.f14283b).resetTags();
            MessageSharedPrefs.getInstance(this.f14283b).addTags(strArr);
            MessageSharedPrefs.getInstance(this.f14283b).setTagRemain(result.remain);
        }
        return result;
    }
}
