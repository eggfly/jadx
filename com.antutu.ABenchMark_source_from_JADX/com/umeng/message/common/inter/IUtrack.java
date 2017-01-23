package com.umeng.message.common.inter;

import com.umeng.message.UTrack.ICallBack;
import org.json.JSONObject;

public interface IUtrack {
    void addAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z);

    void addExclusiveAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z);

    void removeAlias(String str, String str2, JSONObject jSONObject, ICallBack iCallBack, boolean z);

    void sendAliasFailLog(JSONObject jSONObject);

    void sendMsgLog(JSONObject jSONObject, String str, int i, long j, boolean z);

    void trackAppLaunch(JSONObject jSONObject, boolean z);

    void trackLocation(JSONObject jSONObject, boolean z);

    void trackRegister(JSONObject jSONObject, boolean z);
}
