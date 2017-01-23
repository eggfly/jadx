package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.C4290b;
import com.xiaomi.channel.commonutils.android.C4293e;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.string.C4329d;
import com.xiaomi.xmpush.thrift.C4513a;
import com.xiaomi.xmpush.thrift.C4523f;
import com.xiaomi.xmpush.thrift.C4548s;
import java.util.HashMap;
import org.android.agoo.common.C4575b;

/* renamed from: com.xiaomi.mipush.sdk.r */
final class C4363r implements Runnable {
    final /* synthetic */ Context f14833a;
    final /* synthetic */ boolean f14834b;

    C4363r(Context context, boolean z) {
        this.f14833a = context;
        this.f14834b = z;
    }

    public void run() {
        C4302b.m17649a("do sync info");
        C4548s c4548s = new C4548s(MiPushClient.generatePacketID(), false);
        C4343a a = C4343a.m17800a(this.f14833a);
        c4548s.m19061c(C4523f.SyncInfo.f15748z);
        c4548s.m19057b(a.m17810c());
        c4548s.m19063d(this.f14833a.getPackageName());
        c4548s.f16110h = new HashMap();
        C4362q.m17885b(c4548s.f16110h, C4575b.PROPERTY_APP_VERSION, C4290b.m17598a(this.f14833a, this.f14833a.getPackageName()));
        C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C4290b.m17599b(this.f14833a, this.f14833a.getPackageName())));
        C4362q.m17885b(c4548s.f16110h, "push_sdk_vn", "3_1_2");
        C4362q.m17885b(c4548s.f16110h, "push_sdk_vc", Integer.toString(30102));
        C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_TOKEN, a.m17811d());
        C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_IMEI_MD5, C4329d.m17742a(C4293e.m17611c(this.f14833a)));
        C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_REG_ID, a.m17812e());
        C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_REG_SECRET, a.m17813f());
        C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f14833a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f14834b) {
            C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_ALIASES_MD5, C4362q.m17886c(MiPushClient.getAllAlias(this.f14833a)));
            C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_TOPICS_MD5, C4362q.m17886c(MiPushClient.getAllTopic(this.f14833a)));
            C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_ACCOUNTS_MD5, C4362q.m17886c(MiPushClient.getAllUserAccount(this.f14833a)));
        } else {
            C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_ALIASES, C4362q.m17887d(MiPushClient.getAllAlias(this.f14833a)));
            C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_TOPICS, C4362q.m17887d(MiPushClient.getAllTopic(this.f14833a)));
            C4362q.m17885b(c4548s.f16110h, Constants.EXTRA_KEY_ACCOUNTS, C4362q.m17887d(MiPushClient.getAllUserAccount(this.f14833a)));
        }
        C4360o.m17853a(this.f14833a).m17869a(c4548s, C4513a.Notification, false, null);
    }
}
