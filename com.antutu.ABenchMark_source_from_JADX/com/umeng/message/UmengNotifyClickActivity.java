package com.umeng.message;

import android.content.Intent;
import android.os.Bundle;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.umeng.analytics.C4156a;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class UmengNotifyClickActivity extends BaseNotifyClickActivity {
    private static final String f14193a;

    static {
        f14193a = UmengNotifyClickActivity.class.getName();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onMessage(Intent intent) {
        String stringExtra = intent.getStringExtra(C4156a.f13961w);
        UmLog.m17136d(f14193a, "onMessage():[" + stringExtra + "]");
        try {
            UMessage uMessage = new UMessage(new JSONObject(stringExtra));
            uMessage.message_id = intent.getStringExtra(AgooConstants.MESSAGE_ID);
            uMessage.task_id = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
            UTrack.getInstance(this).trackMiPushMsgClick(uMessage);
        } catch (JSONException e) {
            e.printStackTrace();
            UmLog.m17136d(f14193a, e.toString());
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    protected void onStart() {
        super.onStart();
    }
}
