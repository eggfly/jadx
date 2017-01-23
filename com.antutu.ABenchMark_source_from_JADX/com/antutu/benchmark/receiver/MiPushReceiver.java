package com.antutu.benchmark.receiver;

import android.content.Context;
import android.text.TextUtils;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.PushMessageUtil;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;

public class MiPushReceiver extends PushMessageReceiver {
    private static final String TAG;
    private String mAccount;
    private String mAlias;
    private String mEndTime;
    private String mRegId;
    private String mStartTime;
    private String mTopic;

    static {
        TAG = PushMessageReceiver.class.getSimpleName();
    }

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String str;
        String command = miPushCommandMessage.getCommand();
        List commandArguments = miPushCommandMessage.getCommandArguments();
        String str2 = (commandArguments == null || commandArguments.size() <= 0) ? null : (String) commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            str = (String) commandArguments.get(1);
        }
        str = "123";
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mRegId = str2;
                str = str + "Register push success.";
            } else {
                str = str + "Register push fail.";
            }
        }
        MLog.m6868e(TAG, str);
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.mTopic = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.mAlias = miPushMessage.getAlias();
        }
        String messageId = miPushMessage.getMessageId();
        String title = miPushMessage.getTitle();
        String description = miPushMessage.getDescription();
        String content = miPushMessage.getContent();
        InfocUtil.antutu_push(context, 1, title, "\u5c0f\u7c73");
        PushMessageUtil.openLiveService(context);
        MLog.m6874v(TAG, "MessageId:" + messageId + " Title: " + title + " Desc: " + description + " Content: " + content);
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.mTopic = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.mAlias = miPushMessage.getAlias();
        }
        MiPushClient.reportMessageClicked(context, miPushMessage);
        String messageId = miPushMessage.getMessageId();
        String title = miPushMessage.getTitle();
        String description = miPushMessage.getDescription();
        MLog.m6874v(TAG, "MessageId:" + messageId + " Title: " + title + " Desc: " + description + " Content: " + miPushMessage.getContent());
        PushMessageUtil.dealWithMessage(context, 3, miPushMessage);
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        super.onReceivePassThroughMessage(context, miPushMessage);
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        String command = miPushCommandMessage.getCommand();
        List commandArguments = miPushCommandMessage.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : (String) commandArguments.get(0);
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mRegId = str;
                str = "Atutu Register push success.";
            } else {
                str = "Register push fail.";
            }
            PushMessageUtil.openLiveService(context);
        } else {
            str = miPushCommandMessage.getReason();
        }
        MLog.m6868e(TAG, str);
    }
}
