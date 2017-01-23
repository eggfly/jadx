package com.taobao.agoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.umeng.message.MsgConstant;
import java.util.HashSet;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;
import org.android.agoo.message.MessageService;

public class BaseNotifyClickActivity extends Activity {
    private static final String TAG = "accs.BaseNotifyClickActivity";
    private static final String TAOBAO_PACKAGE_NAME = "com.taobao.taobao";
    private static Set<INotifyListener> notifyListeners;
    private AgooFactory agooFactory;
    private String msgSource;
    private NotifManager notifyManager;

    public interface INotifyListener {
        String getMsgSource();

        String parseMsgFromIntent(Intent intent);
    }

    public static void addNotifyListener(INotifyListener iNotifyListener) {
        if (notifyListeners == null) {
            notifyListeners = new HashSet();
        }
        notifyListeners.add(iNotifyListener);
    }

    private void buildMessage(Intent intent) {
        new C4150a(this, intent).start();
    }

    private String parseMsgFromChannel(Intent intent) {
        Object e;
        String str;
        try {
            str = (String) Class.forName("com.xiaomi.mipush.sdk.PushMessageHelper").getField("KEY_MESSAGE").get(null);
            if (intent.getSerializableExtra(str) == null) {
                return null;
            }
            Class cls = Class.forName("com.xiaomi.mipush.sdk.MiPushMessage");
            str = (String) cls.getMethod("getContent", null).invoke(cls.cast(intent.getSerializableExtra(str)), new Object[0]);
            try {
                this.msgSource = MsgConstant.MESSAGE_SYSTEM_SOURCE_XIAOMI;
                return str;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str = null;
            e = exception;
            ALog.m16903e(TAG, "parseMsgFromChannel exception: " + e, new Object[0]);
            return str;
        }
    }

    private String parseMsgFromNotifyListener(Intent intent) {
        String str = null;
        if (notifyListeners == null || notifyListeners.size() <= 0) {
            ALog.m16903e(TAG, "cann't parse as notifyListeners is empty", new Object[0]);
            return null;
        }
        for (INotifyListener iNotifyListener : notifyListeners) {
            String parseMsgFromIntent = iNotifyListener.parseMsgFromIntent(intent);
            this.msgSource = iNotifyListener.getMsgSource();
            if (TextUtils.isEmpty(parseMsgFromIntent) || TextUtils.isEmpty(this.msgSource)) {
                str = parseMsgFromIntent;
            } else {
                ALog.m16904i(TAG, "result: " + parseMsgFromIntent + " msgSource: " + this.msgSource, new Object[0]);
                return parseMsgFromIntent;
            }
        }
        return str;
    }

    private void reportClickNotifyMsg(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_ID);
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_REPORT);
            MsgDO msgDO = new MsgDO();
            msgDO.msgIds = stringExtra;
            msgDO.messageSource = stringExtra2;
            msgDO.reportStr = stringExtra3;
            msgDO.msgStatus = MessageService.MSG_ACCS_NOTIFY_CLICK;
            ALog.m16904i(TAG, "reportClickNotifyMsg messageId:" + stringExtra + " source:" + stringExtra2 + " reportStr:" + stringExtra3 + " status:" + msgDO.msgStatus, new Object[0]);
            this.notifyManager.report(msgDO, null);
        } catch (Exception e) {
            ALog.m16903e(TAG, "reportClickNotifyMsg exception: " + e, new Object[0]);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ALog.m16904i(TAG, "onCreate", new Object[0]);
        buildMessage(getIntent());
    }

    public void onMessage(Intent intent) {
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ALog.m16904i(TAG, "onNewIntent", new Object[0]);
        buildMessage(intent);
    }

    protected void onStart() {
        super.onStart();
    }
}
