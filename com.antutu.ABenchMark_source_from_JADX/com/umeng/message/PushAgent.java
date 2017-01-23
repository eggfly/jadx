package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anet.channel.AccsSessionManager;
import anet.channel.AccsSessionManager.Callback;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.client.AccsConfig.ACCS_GROUP;
import com.taobao.accs.client.AccsConfig.SECURITY_TYPE;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.message.UTrack.ICallBack;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.proguard.C4230g;
import com.umeng.message.tag.TagManager;
import java.util.Random;
import org.android.agoo.common.CallBack;
import org.android.spdy.SpdyAgent;

public class PushAgent {
    public static boolean DEBUG;
    private static PushAgent f14102a;
    private static boolean f14103d;
    private static final String f14104e;
    private TagManager f14105b;
    private Context f14106c;
    private UHandler f14107f;
    private UHandler f14108g;
    private boolean f14109h;
    private Handler f14110i;
    private IUmengRegisterCallback f14111j;
    private IUmengCallback f14112k;

    /* renamed from: com.umeng.message.PushAgent.1 */
    class C41901 extends Handler {
        final /* synthetic */ PushAgent f14097a;

        C41901(PushAgent pushAgent, Looper looper) {
            this.f14097a = pushAgent;
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* renamed from: com.umeng.message.PushAgent.2 */
    class C41912 implements Callback {
        final /* synthetic */ PushAgent f14098a;

        C41912(PushAgent pushAgent) {
            this.f14098a = pushAgent;
        }

        public int getSessionCount() {
            return 1;
        }

        public String getSessionKey(int i) {
            return "https://umengacs.m.taobao.com";
        }
    }

    /* renamed from: com.umeng.message.PushAgent.3 */
    class C41923 extends IRegister {
        final /* synthetic */ PushAgent f14099a;

        C41923(PushAgent pushAgent) {
            this.f14099a = pushAgent;
        }

        public void onFailure(String str, String str2) {
            UmLog.m17140i(PushAgent.f14104e, "register-->onFailure-->s:" + str + ",s1:" + str2);
            this.f14099a.m17097a(str, str2);
        }

        public void onSuccess(String str) {
            UmLog.m17140i(PushAgent.f14104e, "register-->onSuccess:" + str);
            this.f14099a.m17096a(str);
        }
    }

    /* renamed from: com.umeng.message.PushAgent.4 */
    class C41934 implements CallBack {
        final /* synthetic */ PushAgent f14100a;

        C41934(PushAgent pushAgent) {
            this.f14100a = pushAgent;
        }

        public void onFailure(String str, String str2) {
            UmLog.m17140i(PushAgent.f14104e, "bindAgoo-->onFailure-->s:" + str + ",s1:" + str2);
            Intent intent = new Intent();
            intent.setPackage(this.f14100a.f14106c.getPackageName());
            intent.setAction(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION);
            intent.putExtra(MsgConstant.KEY_STATUS, false);
            intent.putExtra("s", str);
            intent.putExtra("s1", str2);
            this.f14100a.f14106c.startService(intent);
        }

        public void onSuccess() {
            UmLog.m17140i(PushAgent.f14104e, "bindAgoo-->onSuccess");
            Intent intent = new Intent();
            intent.setPackage(this.f14100a.f14106c.getPackageName());
            intent.setAction(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION);
            intent.putExtra(MsgConstant.KEY_STATUS, true);
            this.f14100a.f14106c.startService(intent);
        }
    }

    /* renamed from: com.umeng.message.PushAgent.5 */
    class C41945 implements CallBack {
        final /* synthetic */ PushAgent f14101a;

        C41945(PushAgent pushAgent) {
            this.f14101a = pushAgent;
        }

        public void onFailure(String str, String str2) {
            UmLog.m17140i(PushAgent.f14104e, "onFailure-->s:" + str + ",s1:" + str2);
            Intent intent = new Intent();
            intent.setPackage(this.f14101a.f14106c.getPackageName());
            intent.setAction(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION);
            intent.putExtra(MsgConstant.KEY_STATUS, false);
            intent.putExtra("s", str);
            intent.putExtra("s1", str2);
            this.f14101a.f14106c.startService(intent);
        }

        public void onSuccess() {
            UmLog.m17140i(PushAgent.f14104e, "unBindAgoo-->onSuccess");
            Intent intent = new Intent();
            intent.setPackage(this.f14101a.f14106c.getPackageName());
            intent.setAction(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION);
            intent.putExtra(MsgConstant.KEY_STATUS, true);
            this.f14101a.f14106c.startService(intent);
        }
    }

    static {
        f14103d = false;
        DEBUG = false;
        f14104e = PushAgent.class.getName();
    }

    private PushAgent(Context context) {
        this.f14109h = false;
        try {
            this.f14106c = context;
            this.f14105b = TagManager.getInstance(context);
            this.f14107f = new UmengMessageHandler();
            this.f14108g = new UmengNotificationClickHandler();
        } catch (Exception e) {
            UmLog.m17138e(f14104e, e.getMessage());
        }
        this.f14110i = new C41901(this, context.getMainLooper());
    }

    private void m17096a(String str) {
        Intent intent = new Intent();
        intent.setPackage(this.f14106c.getPackageName());
        intent.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
        intent.putExtra(MsgConstant.KEY_REGISTRATION_ID, str);
        intent.putExtra(MsgConstant.KEY_STATUS, true);
        this.f14106c.startService(intent);
    }

    private void m17097a(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage(this.f14106c.getPackageName());
        intent.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
        intent.putExtra(MsgConstant.KEY_STATUS, false);
        intent.putExtra("s", str);
        intent.putExtra("s1", str2);
        this.f14106c.startService(intent);
    }

    private void m17098b() {
        try {
            if (VERSION.SDK_INT < 11) {
                UmLog.m17138e(f14104e, "Push SDK does not work for Android Verion < 11");
            } else if (C4230g.m17268a(this.f14106c, this.f14110i)) {
                UmLog.m17136d(f14104e, "The AndroidManifest config is right");
                C4230g.m17264a(this.f14106c, UmengMessageCallbackHandlerService.class);
                if (UmLog.LOG) {
                    C4230g.m17273b(this.f14106c, this.f14110i);
                }
                ALog.setUseTlog(false);
                anet.channel.util.ALog.setUseTlog(false);
                ACCSManager.setMode(this.f14106c, 0);
                AccsConfig.setGroup(ACCS_GROUP.OPEN);
                AccsConfig.setSecurityGuardOff(SECURITY_TYPE.SECURITY_OFF);
                AccsConfig.setTnetPubkey(11, 11);
                AccsSessionManager.getInstance().setCallback(new C41912(this));
                AccsConfig.setAccsCenterHosts("umengacs.m.taobao.com", "umengacs.m.taobao.com", "umengacs.m.taobao.com");
                AccsConfig.setAccsCenterIps(new String[]{"140.205.160.76"}, new String[]{"110.75.206.79"}, new String[]{"10.125.50.231"});
                AccsConfig.setChannelHosts("umengjmacs.m.taobao.com", "umengjmacs.m.taobao.com", "umengjmacs.m.taobao.com");
                AccsConfig.setChannelIps(new String[]{"140.205.163.94"}, new String[]{"110.75.206.79"}, new String[]{"10.125.50.231"});
                TaobaoRegister.setAgooMsgReceiveService("com.umeng.message.UmengIntentService");
                TaobaoRegister.register(this.f14106c, "umeng:" + getMessageAppkey(), getMessageSecret(), "android@umeng", new C41923(this));
            } else {
                UmLog.m17138e(f14104e, "Need to correct AndroidManifest config according to instruction from http://dev.umeng.com/push/android/integration");
            }
        } catch (Exception e) {
            UmLog.m17138e(f14104e, e.getMessage());
        }
    }

    private void m17099c() {
        TaobaoRegister.bindAgoo(this.f14106c, "umeng:" + getMessageAppkey(), "android@umeng", new C41934(this));
    }

    private void m17100d() {
        try {
            UmLog.m17140i(f14104e, "unBindAgoo");
            TaobaoRegister.unBindAgoo(this.f14106c, "umeng:" + getMessageAppkey(), "android@umeng", new C41945(this));
        } catch (Exception e) {
            UmLog.m17138e(f14104e, e.getMessage());
        }
    }

    public static synchronized PushAgent getInstance(Context context) {
        PushAgent pushAgent;
        synchronized (PushAgent.class) {
            if (f14102a == null) {
                f14102a = new PushAgent(context.getApplicationContext());
            }
            pushAgent = f14102a;
        }
        return pushAgent;
    }

    public static boolean isAppLaunchByMessage() {
        return f14103d;
    }

    public static void setAppLaunchByMessage() {
        f14103d = true;
    }

    public void addAlias(String str, String str2, ICallBack iCallBack) {
        UTrack.getInstance(this.f14106c).addAlias(str, str2, iCallBack);
    }

    public void addExclusiveAlias(String str, String str2, ICallBack iCallBack) {
        UTrack.getInstance(this.f14106c).addExclusiveAlias(str, str2, iCallBack);
    }

    public void disable(IUmengCallback iUmengCallback) {
        setCallback(iUmengCallback);
        m17100d();
    }

    public void enable(IUmengCallback iUmengCallback) {
        setCallback(iUmengCallback);
        m17099c();
    }

    public IUmengCallback getCallback() {
        return this.f14112k;
    }

    public int getDisplayNotificationNumber() {
        return MessageSharedPrefs.getInstance(this.f14106c).getDisplayNotificationNumber();
    }

    public int getLocationInterval() {
        return MessageSharedPrefs.getInstance(this.f14106c).getLocationInterval();
    }

    public String getMessageAppkey() {
        Object messageAppKey = MessageSharedPrefs.getInstance(this.f14106c).getMessageAppKey();
        return TextUtils.isEmpty(messageAppKey) ? UmengMessageDeviceConfig.getAppkey(this.f14106c) : messageAppKey;
    }

    public String getMessageChannel() {
        Object messageChannel = MessageSharedPrefs.getInstance(this.f14106c).getMessageChannel();
        return TextUtils.isEmpty(messageChannel) ? UmengMessageDeviceConfig.getChannel(this.f14106c) : messageChannel;
    }

    public UHandler getMessageHandler() {
        return this.f14107f;
    }

    public String getMessageSecret() {
        Object messageAppSecret = MessageSharedPrefs.getInstance(this.f14106c).getMessageAppSecret();
        return TextUtils.isEmpty(messageAppSecret) ? UmengMessageDeviceConfig.getMetaData(this.f14106c, "UMENG_MESSAGE_SECRET") : messageAppSecret;
    }

    public int getMuteDurationSeconds() {
        return MessageSharedPrefs.getInstance(this.f14106c).getMuteDuration();
    }

    public int getNoDisturbEndHour() {
        return MessageSharedPrefs.getInstance(this.f14106c).m17086c();
    }

    public int getNoDisturbEndMinute() {
        return MessageSharedPrefs.getInstance(this.f14106c).m17087d();
    }

    public int getNoDisturbStartHour() {
        return MessageSharedPrefs.getInstance(this.f14106c).m17082a();
    }

    public int getNoDisturbStartMinute() {
        return MessageSharedPrefs.getInstance(this.f14106c).m17085b();
    }

    public UHandler getNotificationClickHandler() {
        return this.f14108g;
    }

    public boolean getNotificationOnForeground() {
        return MessageSharedPrefs.getInstance(this.f14106c).getNotificaitonOnForeground();
    }

    public int getNotificationPlayLights() {
        return MessageSharedPrefs.getInstance(this.f14106c).getNotificationPlayLights();
    }

    public int getNotificationPlaySound() {
        return MessageSharedPrefs.getInstance(this.f14106c).getNotificationPlaySound();
    }

    public int getNotificationPlayVibrate() {
        return MessageSharedPrefs.getInstance(this.f14106c).getNotificationPlayVibrate();
    }

    public String getPushIntentServiceClass() {
        return MessageSharedPrefs.getInstance(this.f14106c).getPushIntentServiceClass();
    }

    public IUmengRegisterCallback getRegisterCallback() {
        return this.f14111j;
    }

    public String getRegistrationId() {
        return MessageSharedPrefs.getInstance(this.f14106c).getDeviceToken();
    }

    public String getResourcePackageName() {
        return MessageSharedPrefs.getInstance(this.f14106c).getResourcePackageName();
    }

    public TagManager getTagManager() {
        return this.f14105b;
    }

    public boolean isIncludesUmengUpdateSDK() {
        Class cls;
        try {
            cls = Class.forName("com.umeng.update.UmengUpdateAgent");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        return cls != null;
    }

    public boolean isPushCheck() {
        return this.f14109h;
    }

    public void onAppStart() {
        UTrack.getInstance(this.f14106c).sendAliasFailLog();
        UTrack.getInstance(this.f14106c).trackAppLaunch(10000);
        long j = 0;
        if (isAppLaunchByMessage()) {
            j = Math.abs(new Random().nextLong() % MsgConstant.f14088a);
        }
        UTrack.getInstance(this.f14106c).sendCachedMsgLog(j);
    }

    public void register(IUmengRegisterCallback iUmengRegisterCallback) {
        setRegisterCallback(iUmengRegisterCallback);
        m17098b();
    }

    public void removeAlias(String str, String str2, ICallBack iCallBack) {
        UTrack.getInstance(this.f14106c).removeAlias(str, str2, iCallBack);
    }

    public void setAppkeyAndSecret(String str, String str2) {
        if (C4230g.m17281d(this.f14106c)) {
            String messageAppKey = MessageSharedPrefs.getInstance(this.f14106c).getMessageAppKey();
            String messageAppSecret = MessageSharedPrefs.getInstance(this.f14106c).getMessageAppSecret();
            if (!(messageAppKey.equals(str) || messageAppSecret.equals(str2))) {
                MessageSharedPrefs.getInstance(this.f14106c).removeMessageAppKey();
                MessageSharedPrefs.getInstance(this.f14106c).removeMessageAppSecret();
            }
            MessageSharedPrefs.getInstance(this.f14106c).setMessageAppKey(str);
            MessageSharedPrefs.getInstance(this.f14106c).setMessageAppSecret(str2);
            UTrack.getInstance(this.f14106c).updateHeader();
        }
    }

    public void setCallback(IUmengCallback iUmengCallback) {
        this.f14112k = iUmengCallback;
    }

    public void setDebugMode(boolean z) {
        UmLog.LOG = z;
        ALog.setPrintLog(z);
        anet.channel.util.ALog.setPrintLog(z);
        SpdyAgent.enableDebug = z;
    }

    public void setDisplayNotificationNumber(int i) {
        if (C4230g.m17281d(this.f14106c) && i >= 0 && i <= 10) {
            MessageSharedPrefs.getInstance(this.f14106c).setDisplayNotificationNumber(i);
        }
    }

    public void setLocationInterval(int i) {
        MessageSharedPrefs.getInstance(this.f14106c).setLocationInterval(i);
    }

    public void setMessageChannel(String str) {
        if (C4230g.m17281d(this.f14106c)) {
            MessageSharedPrefs.getInstance(this.f14106c).setMessageChannel(str);
            UTrack.getInstance(this.f14106c).updateHeader();
        }
    }

    public void setMessageHandler(UHandler uHandler) {
        this.f14107f = uHandler;
    }

    public void setMuteDurationSeconds(int i) {
        if (C4230g.m17281d(this.f14106c)) {
            MessageSharedPrefs.getInstance(this.f14106c).setMuteDuration(i);
        }
    }

    public void setNoDisturbMode(int i, int i2, int i3, int i4) {
        if (C4230g.m17281d(this.f14106c)) {
            MessageSharedPrefs.getInstance(this.f14106c).m17083a(i, i2, i3, i4);
        }
    }

    public void setNotificaitonOnForeground(boolean z) {
        if (C4230g.m17281d(this.f14106c)) {
            MessageSharedPrefs.getInstance(this.f14106c).setNotificaitonOnForeground(z);
        }
    }

    public void setNotificationClickHandler(UHandler uHandler) {
        this.f14108g = uHandler;
    }

    public void setNotificationPlayLights(int i) {
        if (C4230g.m17281d(this.f14106c)) {
            MessageSharedPrefs.getInstance(this.f14106c).setNotificationPlayLights(i);
        }
    }

    public void setNotificationPlaySound(int i) {
        if (C4230g.m17281d(this.f14106c)) {
            MessageSharedPrefs.getInstance(this.f14106c).setNotificationPlaySound(i);
        }
    }

    public void setNotificationPlayVibrate(int i) {
        if (C4230g.m17281d(this.f14106c)) {
            MessageSharedPrefs.getInstance(this.f14106c).setNotificationPlayVibrate(i);
        }
    }

    public void setPushCheck(boolean z) {
        this.f14109h = z;
    }

    public <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        if (C4230g.m17281d(this.f14106c)) {
            MessageSharedPrefs.getInstance(this.f14106c).setPushIntentServiceClass(cls);
        }
    }

    public void setRegisterCallback(IUmengRegisterCallback iUmengRegisterCallback) {
        this.f14111j = iUmengRegisterCallback;
    }

    public void setResourcePackageName(String str) {
        if (C4230g.m17281d(this.f14106c)) {
            MessageSharedPrefs.getInstance(this.f14106c).setResourcePackageName(str);
        }
    }
}
