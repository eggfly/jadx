package org.android.agoo.common;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.umeng.message.proguard.C4233j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MsgDO {
    public boolean agooFlag;
    public String body;
    public String dataId;
    public String errorCode;
    public String fromAppkey;
    public String fromPkg;
    public boolean isFromCache;
    public boolean isStartProc;
    public String messageSource;
    public String msgIds;
    public String msgStatus;
    public String pack;
    public String removePacks;
    public String reportStr;
    public String type;

    public MsgDO() {
        this.isStartProc = false;
        this.isFromCache = false;
    }

    public String getMsgInfo() {
        Map hashMap = new HashMap();
        hashMap.put("msgIds", this.msgIds);
        hashMap.put(C4156a.f13961w, this.body);
        hashMap.put(Constants.KEY_DATA_ID, this.dataId);
        hashMap.put("pack", this.pack);
        hashMap.put("messageSource", this.messageSource);
        if (!TextUtils.isEmpty(this.removePacks)) {
            hashMap.put("removePacks", this.removePacks);
        }
        if (!TextUtils.isEmpty(this.errorCode)) {
            hashMap.put(Constants.KEY_ERROR_CODE, this.errorCode);
        }
        if (!TextUtils.isEmpty(this.type)) {
            hashMap.put(C4233j.f14402y, this.type);
        }
        return new JSONObject(hashMap).toString();
    }
}
