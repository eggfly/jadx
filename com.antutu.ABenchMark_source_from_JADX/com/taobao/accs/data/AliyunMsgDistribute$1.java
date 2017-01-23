package com.taobao.accs.data;

import com.taobao.accs.client.GlobalClientInfo;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;

final class AliyunMsgDistribute$1 extends HashMap<String, String> {
    AliyunMsgDistribute$1() {
        put(GlobalClientInfo.AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }
}
