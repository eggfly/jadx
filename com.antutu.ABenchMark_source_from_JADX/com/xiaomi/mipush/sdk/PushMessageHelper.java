package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.xmpush.thrift.C4529i;
import com.xiaomi.xmpush.thrift.C4558x;
import java.util.List;

public class PushMessageHelper {
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    static {
        pushMode = 0;
    }

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(C4558x c4558x, C4529i c4529i, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(c4558x.m19177c());
        if (!TextUtils.isEmpty(c4558x.m19184j())) {
            miPushMessage.setMessageType(PUSH_MODE_CALLBACK);
            miPushMessage.setAlias(c4558x.m19184j());
        } else if (!TextUtils.isEmpty(c4558x.m19182h())) {
            miPushMessage.setMessageType(PUSH_MODE_BROADCAST);
            miPushMessage.setTopic(c4558x.m19182h());
        } else if (TextUtils.isEmpty(c4558x.m19192r())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(MESSAGE_COMMAND);
            miPushMessage.setUserAccount(c4558x.m19192r());
        }
        miPushMessage.setCategory(c4558x.m19190p());
        if (c4558x.m19186l() != null) {
            miPushMessage.setContent(c4558x.m19186l().m18847f());
        }
        if (c4529i != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(c4529i.m18867b());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(c4529i.m18879f());
            }
            miPushMessage.setDescription(c4529i.m18883j());
            miPushMessage.setTitle(c4529i.m18881h());
            miPushMessage.setNotifyType(c4529i.m18885l());
            miPushMessage.setNotifyId(c4529i.m18890q());
            miPushMessage.setPassThrough(c4529i.m18888o());
            miPushMessage.setExtra(c4529i.m18892s());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            if (isUseCallbackPushMode(context)) {
                setPushMode(PUSH_MODE_CALLBACK);
            } else {
                setPushMode(PUSH_MODE_BROADCAST);
            }
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) ? false : true;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(MESSAGE_TYPE, MESSAGE_COMMAND);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(MESSAGE_TYPE, MESSAGE_QUIT);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }
}
