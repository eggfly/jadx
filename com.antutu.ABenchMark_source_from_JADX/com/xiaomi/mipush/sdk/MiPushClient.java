package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.umeng.analytics.C4156a;
import com.xiaomi.channel.commonutils.android.C4290b;
import com.xiaomi.channel.commonutils.android.C4293e;
import com.xiaomi.channel.commonutils.android.C4294f;
import com.xiaomi.channel.commonutils.android.C4295g;
import com.xiaomi.channel.commonutils.android.C4297i;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4308d;
import com.xiaomi.channel.commonutils.string.C4329d;
import com.xiaomi.push.service.C4445v;
import com.xiaomi.xmpush.thrift.C4513a;
import com.xiaomi.xmpush.thrift.C4518b;
import com.xiaomi.xmpush.thrift.C4529i;
import com.xiaomi.xmpush.thrift.C4530j;
import com.xiaomi.xmpush.thrift.C4538n;
import com.xiaomi.xmpush.thrift.C4548s;
import com.xiaomi.xmpush.thrift.C4550t;
import com.xiaomi.xmpush.thrift.C4560y;
import com.xiaomi.xmpush.thrift.aa;
import com.xiaomi.xmpush.thrift.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.android.agoo.common.C4575b;
import org.apache.thrift.C4454a;

public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId;

    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        protected String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    static {
        sCurMsgId = System.currentTimeMillis();
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getLong("account_" + str, -1);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2).commit();
        }
    }

    static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("last_pull_notification", System.currentTimeMillis()).commit();
    }

    private static void addRegRequestTime(Context context) {
        context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("last_reg_request", System.currentTimeMillis()).commit();
    }

    static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getLong("alias_" + str, -1);
    }

    public static void awakeApps(Context context, String[] strArr) {
        new Thread(new C4353i(strArr, context)).start();
    }

    private static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        context.startService(intent);
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    protected static void clearExtras(Context context) {
        Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        C4360o.m17853a(context).m17877e();
    }

    public static void clearNotification(Context context) {
        C4360o.m17853a(context).m17864a(-1);
    }

    public static void clearNotification(Context context, int i) {
        C4360o.m17853a(context).m17864a(i);
    }

    protected static synchronized String generatePacketID() {
        String str;
        synchronized (MiPushClient.class) {
            str = C4329d.m17741a(4) + sCurMsgId;
            sCurMsgId++;
        }
        return str;
    }

    protected static String getAcceptTime(Context context) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        List<String> arrayList = new ArrayList();
        for (String str : context.getSharedPreferences(PREF_EXTRA, 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring("alias_".length()));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        List<String> arrayList = new ArrayList();
        for (String str : context.getSharedPreferences(PREF_EXTRA, 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring("topic_".length()));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        List<String> arrayList = new ArrayList();
        for (String str : context.getSharedPreferences(PREF_EXTRA, 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring("account_".length()));
            }
        }
        return arrayList;
    }

    private static boolean getDefaultSwitch() {
        return C4294f.m17618b();
    }

    public static String getRegId(Context context) {
        return C4343a.m17800a(context).m17816i() ? C4343a.m17800a(context).m17812e() : null;
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        boolean z = false;
        checkNotNull(context, "context");
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        try {
            sContext = context.getApplicationContext();
            if (sContext == null) {
                sContext = context;
            }
            if (miPushClientCallback != null) {
                PushMessageHandler.m17786a(miPushClientCallback);
            }
            if (C4297i.m17627b(context)) {
                C4348d.m17823a(context);
            }
            if (C4343a.m17800a(sContext).m17820m() != Constants.m17777a()) {
                z = true;
            }
            if (z || shouldSendRegRequest(sContext)) {
                if (z || !C4343a.m17800a(sContext).m17807a(str, str2) || C4343a.m17800a(sContext).m17821n()) {
                    String a = C4329d.m17741a(6);
                    C4343a.m17800a(sContext).m17815h();
                    C4343a.m17800a(sContext).m17802a(Constants.m17777a());
                    C4343a.m17800a(sContext).m17804a(str, str2, a);
                    clearExtras(sContext);
                    C4550t c4550t = new C4550t();
                    c4550t.m19078a(generatePacketID());
                    c4550t.m19085b(str);
                    c4550t.m19096e(str2);
                    c4550t.m19093d(context.getPackageName());
                    c4550t.m19098f(a);
                    c4550t.m19090c(C4290b.m17598a(context, context.getPackageName()));
                    c4550t.m19084b(C4290b.m17599b(context, context.getPackageName()));
                    c4550t.m19100g("3_1_2");
                    c4550t.m19076a(30102);
                    c4550t.m19102h(C4293e.m17610b(sContext));
                    c4550t.m19077a(C4530j.Init);
                    a = C4293e.m17612d(sContext);
                    if (!TextUtils.isEmpty(a)) {
                        if (C4294f.m17618b()) {
                            c4550t.m19104i(a);
                        }
                        c4550t.m19108k(C4329d.m17742a(a));
                    }
                    c4550t.m19106j(C4293e.m17607a());
                    int b = C4293e.m17609b();
                    if (b >= 0) {
                        c4550t.m19089c(b);
                    }
                    C4360o.m17853a(sContext).m17866a(c4550t, z);
                } else {
                    if (1 == PushMessageHelper.getPushMode(context)) {
                        checkNotNull(miPushClientCallback, "callback");
                        miPushClientCallback.onInitializeResult(0, null, C4343a.m17800a(context).m17812e());
                    } else {
                        List arrayList = new ArrayList();
                        arrayList.add(C4343a.m17800a(context).m17812e());
                        PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(COMMAND_REGISTER, arrayList, 0, null, null));
                    }
                    C4360o.m17853a(context).m17863a();
                    if (C4343a.m17800a(sContext).m17806a()) {
                        C4454a c4548s = new C4548s();
                        c4548s.m19057b(C4343a.m17800a(context).m17810c());
                        c4548s.m19061c("client_info_update");
                        c4548s.m19048a(generatePacketID());
                        c4548s.f16110h = new HashMap();
                        c4548s.f16110h.put(C4575b.PROPERTY_APP_VERSION, C4290b.m17598a(sContext, sContext.getPackageName()));
                        c4548s.f16110h.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C4290b.m17599b(sContext, sContext.getPackageName())));
                        c4548s.f16110h.put("push_sdk_vn", "3_1_2");
                        c4548s.f16110h.put("push_sdk_vc", Integer.toString(30102));
                        CharSequence g = C4343a.m17800a(sContext).m17814g();
                        if (!TextUtils.isEmpty(g)) {
                            c4548s.f16110h.put("deviceid", g);
                        }
                        C4360o.m17853a(context).m17869a(c4548s, C4513a.Notification, false, null);
                    }
                    if (!C4295g.m17621a(sContext, "update_devId", false)) {
                        updateIMEI();
                        C4295g.m17622b(sContext, "update_devId", true);
                    }
                    if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                        C4454a c4548s2 = new C4548s();
                        c4548s2.m19057b(C4343a.m17800a(sContext).m17810c());
                        c4548s2.m19061c("pull");
                        c4548s2.m19048a(generatePacketID());
                        c4548s2.m19051a(false);
                        C4360o.m17853a(sContext).m17870a(c4548s2, C4513a.Notification, false, null, false);
                        addPullNotificationTime(sContext);
                    }
                }
                addRegRequestTime(sContext);
                scheduleOcVersionCheckJob();
                loadPlugin();
                C4362q.m17880a(sContext);
                return;
            }
            C4360o.m17853a(context).m17863a();
            C4302b.m17649a("Could not send  register message within 5s repeatly .");
        } catch (Throwable th) {
            C4302b.m17651a(th);
        }
    }

    private static void loadPlugin() {
        if (C4445v.m18368a(sContext).m18375a(C4518b.DataCollectionSwitch.m18794a(), getDefaultSwitch())) {
            C4308d.m17667a(sContext).m17671a(new C4351g(), 10);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context, C4530j c4530j) {
        if (C4343a.m17800a(context).m17816i()) {
            String a = C4329d.m17741a(6);
            String c = C4343a.m17800a(context).m17810c();
            String d = C4343a.m17800a(context).m17811d();
            C4343a.m17800a(context).m17815h();
            C4343a.m17800a(context).m17804a(c, d, a);
            C4550t c4550t = new C4550t();
            c4550t.m19078a(generatePacketID());
            c4550t.m19085b(c);
            c4550t.m19096e(d);
            c4550t.m19098f(a);
            c4550t.m19093d(context.getPackageName());
            c4550t.m19090c(C4290b.m17598a(context, context.getPackageName()));
            c4550t.m19077a(c4530j);
            C4360o.m17853a(context).m17866a(c4550t, false);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        new Thread(new C4350f(context, str, str2)).start();
    }

    static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().remove(Constants.EXTRA_KEY_ACCEPT_TIME).commit();
        }
    }

    static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().remove("account_" + str).commit();
        }
    }

    static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().remove("alias_" + str).commit();
        }
    }

    static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAccount : getAllUserAccount(context)) {
                removeAccount(context, removeAccount);
            }
        }
    }

    static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAlias : getAllAlias(context)) {
                removeAlias(context, removeAlias);
            }
        }
    }

    static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeTopic : getAllTopic(context)) {
                removeTopic(context, removeTopic);
            }
        }
    }

    static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().remove("topic_" + str).commit();
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, C4529i c4529i, String str2, String str3) {
        C4454a c4548s = new C4548s();
        if (TextUtils.isEmpty(str3)) {
            C4302b.m17654d("do not report clicked message");
            return;
        }
        c4548s.m19057b(str3);
        c4548s.m19061c("bar:click");
        c4548s.m19048a(str);
        c4548s.m19051a(false);
        C4360o.m17853a(context).m17872a(c4548s, C4513a.Notification, false, true, c4529i, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        C4529i c4529i = new C4529i();
        c4529i.m18858a(miPushMessage.getMessageId());
        c4529i.m18866b(miPushMessage.getTopic());
        c4529i.m18875d(miPushMessage.getDescription());
        c4529i.m18871c(miPushMessage.getTitle());
        c4529i.m18870c(miPushMessage.getNotifyId());
        c4529i.m18857a(miPushMessage.getNotifyType());
        c4529i.m18865b(miPushMessage.getPassThrough());
        c4529i.m18859a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), c4529i, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    static void reportMessageClicked(Context context, String str, C4529i c4529i, String str2) {
        Object c4548s = new C4548s();
        if (!TextUtils.isEmpty(str2)) {
            c4548s.m19057b(str2);
        } else if (C4343a.m17800a(context).m17809b()) {
            c4548s.m19057b(C4343a.m17800a(context).m17810c());
        } else {
            C4302b.m17654d("do not report clicked message");
            return;
        }
        c4548s.m19061c("bar:click");
        c4548s.m19048a(str);
        c4548s.m19051a(false);
        C4360o.m17853a(context).m17869a(c4548s, C4513a.Notification, false, c4529i);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleOcVersionCheckJob() {
        C4308d.m17667a(sContext).m17672a(new C4354j(sContext), C4445v.m18368a(sContext).m18372a(C4518b.OcVersionCheckFrequency.m18794a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / AdError.NETWORK_ERROR_CODE) / 60);
        long j = ((((long) ((i * 60) + i2)) + rawOffset) + 1440) % 1440;
        rawOffset = ((rawOffset + ((long) ((i3 * 60) + i4))) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(rawOffset / 60), Long.valueOf(rawOffset % 60)}));
        List arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, COMMAND_SET_ACCEPT_TIME, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.m17785a(context, str, COMMAND_SET_ACCEPT_TIME, 0, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SET_ACCEPT_TIME, arrayList2, 0, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ALIAS, str, str2);
        }
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!COMMAND_SET_ALIAS.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) >= C4156a.f13949k) {
            if (COMMAND_UNSET_ALIAS.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
                C4302b.m17649a("Don't cancel alias for " + arrayList + " is unseted");
            } else if (!COMMAND_SET_ACCOUNT.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) >= C4156a.f13949k) {
                if (!COMMAND_UNSET_ACCOUNT.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                    setCommand(context, str, arrayList, str3);
                } else {
                    C4302b.m17649a("Don't cancel account for " + arrayList + " is unseted");
                }
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m17785a(context, str3, str, 0, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SET_ACCOUNT, arrayList, 0, null, null));
            }
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.m17785a(context, str3, str, 0, null, arrayList);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SET_ALIAS, arrayList, 0, null, null));
        }
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(C4343a.m17800a(context).m17810c())) {
            C4454a c4538n = new C4538n();
            c4538n.m18958a(generatePacketID());
            c4538n.m18963b(C4343a.m17800a(context).m17810c());
            c4538n.m18966c(str);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c4538n.m18968d((String) it.next());
            }
            c4538n.m18972f(str2);
            c4538n.m18970e(context.getPackageName());
            C4360o.m17853a(context).m17867a(c4538n, C4513a.Command, null);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        C4360o.m17853a(context).m17873b(i & -1);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ACCOUNT, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences(PREF_EXTRA, 0).getLong("last_pull_notification", -1)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences(PREF_EXTRA, 0).getLong("last_reg_request", -1)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return C4360o.m17853a(context).m17874b();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(C4343a.m17800a(context).m17810c()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > C4156a.f13948j) {
                C4454a c4560y = new C4560y();
                c4560y.m19196a(generatePacketID());
                c4560y.m19201b(C4343a.m17800a(context).m17810c());
                c4560y.m19204c(str);
                c4560y.m19206d(context.getPackageName());
                c4560y.m19208e(str2);
                C4360o.m17853a(context).m17867a(c4560y, C4513a.Subscription, null);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m17784a(context, str2, 0, null, str);
            } else {
                List arrayList = new ArrayList();
                arrayList.add(str);
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SUBSCRIBE_TOPIC, arrayList, 0, null, null));
            }
        }
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getLong("topic_" + str, -1);
    }

    public static void unregisterPush(Context context) {
        if (C4343a.m17800a(context).m17809b()) {
            aa aaVar = new aa();
            aaVar.m18719a(generatePacketID());
            aaVar.m18724b(C4343a.m17800a(context).m17810c());
            aaVar.m18727c(C4343a.m17800a(context).m17812e());
            aaVar.m18731e(C4343a.m17800a(context).m17811d());
            aaVar.m18729d(context.getPackageName());
            C4360o.m17853a(context).m17865a(aaVar);
            PushMessageHandler.m17780a();
            C4343a.m17800a(context).m17818k();
            clearExtras(context);
            clearLocalNotificationType(context);
            clearNotification(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ALIAS, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ACCOUNT, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (!C4343a.m17800a(context).m17809b()) {
            return;
        }
        if (topicSubscribedTime(context, str) < 0) {
            C4302b.m17649a("Don't cancel subscribe for " + str + " is unsubscribed");
            return;
        }
        C4454a acVar = new ac();
        acVar.m18755a(generatePacketID());
        acVar.m18760b(C4343a.m17800a(context).m17810c());
        acVar.m18763c(str);
        acVar.m18765d(context.getPackageName());
        acVar.m18767e(str2);
        C4360o.m17853a(context).m17867a(acVar, C4513a.UnSubscription, null);
    }

    private static void updateIMEI() {
        new Thread(new C4352h()).start();
    }
}
