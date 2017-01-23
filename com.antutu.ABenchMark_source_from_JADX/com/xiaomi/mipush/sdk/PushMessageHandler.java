package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PushMessageHandler extends IntentService {
    private static List<MiPushClientCallback> f14789a;

    /* renamed from: com.xiaomi.mipush.sdk.PushMessageHandler.a */
    interface C4341a extends Serializable {
    }

    static {
        f14789a = new ArrayList();
    }

    public PushMessageHandler() {
        super("mipush message handler");
    }

    protected static void m17780a() {
        synchronized (f14789a) {
            f14789a.clear();
        }
    }

    public static void m17781a(long j, String str, String str2) {
        synchronized (f14789a) {
            for (MiPushClientCallback onInitializeResult : f14789a) {
                onInitializeResult.onInitializeResult(j, str, str2);
            }
        }
    }

    public static void m17782a(Context context, MiPushMessage miPushMessage) {
        synchronized (f14789a) {
            for (MiPushClientCallback miPushClientCallback : f14789a) {
                if (m17787a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void m17783a(Context context, C4341a c4341a) {
        String str = null;
        if (c4341a instanceof MiPushMessage) {
            m17782a(context, (MiPushMessage) c4341a);
        } else if (c4341a instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) c4341a;
            String command = miPushCommandMessage.getCommand();
            List commandArguments;
            if (MiPushClient.COMMAND_REGISTER.equals(command)) {
                commandArguments = miPushCommandMessage.getCommandArguments();
                if (!(commandArguments == null || commandArguments.isEmpty())) {
                    str = (String) commandArguments.get(0);
                }
                m17781a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command) || MiPushClient.COMMAND_UNSET_ALIAS.equals(command) || MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
                m17785a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
                commandArguments = miPushCommandMessage.getCommandArguments();
                r5 = (commandArguments == null || commandArguments.isEmpty()) ? null : (String) commandArguments.get(0);
                m17784a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), r5);
            } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
                commandArguments = miPushCommandMessage.getCommandArguments();
                r5 = (commandArguments == null || commandArguments.isEmpty()) ? null : (String) commandArguments.get(0);
                m17788b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), r5);
            }
        }
    }

    protected static void m17784a(Context context, String str, long j, String str2, String str3) {
        synchronized (f14789a) {
            for (MiPushClientCallback miPushClientCallback : f14789a) {
                if (m17787a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    protected static void m17785a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (f14789a) {
            for (MiPushClientCallback miPushClientCallback : f14789a) {
                if (m17787a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    protected static void m17786a(MiPushClientCallback miPushClientCallback) {
        synchronized (f14789a) {
            if (!f14789a.contains(miPushClientCallback)) {
                f14789a.add(miPushClientCallback);
            }
        }
    }

    protected static boolean m17787a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    protected static void m17788b(Context context, String str, long j, String str2, String str3) {
        synchronized (f14789a) {
            for (MiPushClientCallback miPushClientCallback : f14789a) {
                if (m17787a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    public static boolean m17789b() {
        return f14789a.isEmpty();
    }

    protected void onHandleIntent(Intent intent) {
        try {
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                if (C4343a.m17800a((Context) this).m17816i()) {
                    C4360o.m17853a((Context) this).m17863a();
                }
            } else if (1 != PushMessageHelper.getPushMode(this)) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(getPackageName());
                intent2.putExtras(intent);
                List<ResolveInfo> queryBroadcastReceivers = getPackageManager().queryBroadcastReceivers(intent2, 32);
                if (queryBroadcastReceivers != null) {
                    for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                        if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(getPackageName())) {
                            break;
                        }
                    }
                }
                ResolveInfo resolveInfo2 = null;
                if (resolveInfo2 != null) {
                    ((PushMessageReceiver) Class.forName(resolveInfo2.activityInfo.name).newInstance()).onReceive(getApplicationContext(), intent2);
                } else {
                    C4302b.m17654d("cannot find the receiver to handler this message, check your manifest");
                }
            } else if (m17789b()) {
                C4302b.m17654d("receive a message before application calling initialize");
            } else {
                C4341a a = C4357m.m17844a((Context) this).m17850a(intent);
                if (a != null) {
                    m17783a((Context) this, a);
                }
            }
        } catch (Throwable e) {
            C4302b.m17651a(e);
        } catch (Throwable e2) {
            C4302b.m17651a(e2);
        }
    }
}
