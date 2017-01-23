package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.facebook.ads.AdError;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.string.C4329d;
import com.xiaomi.mipush.sdk.PushMessageHandler.C4341a;
import com.xiaomi.push.service.C4436r;
import com.xiaomi.push.service.C4445v;
import com.xiaomi.push.service.C4446w;
import com.xiaomi.push.service.aa;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.xmpush.thrift.C4513a;
import com.xiaomi.xmpush.thrift.C4523f;
import com.xiaomi.xmpush.thrift.C4527h;
import com.xiaomi.xmpush.thrift.C4529i;
import com.xiaomi.xmpush.thrift.C4530j;
import com.xiaomi.xmpush.thrift.C4534l;
import com.xiaomi.xmpush.thrift.C4540o;
import com.xiaomi.xmpush.thrift.C4542p;
import com.xiaomi.xmpush.thrift.C4544q;
import com.xiaomi.xmpush.thrift.C4546r;
import com.xiaomi.xmpush.thrift.C4548s;
import com.xiaomi.xmpush.thrift.C4552u;
import com.xiaomi.xmpush.thrift.C4558x;
import com.xiaomi.xmpush.thrift.C4562z;
import com.xiaomi.xmpush.thrift.ab;
import com.xiaomi.xmpush.thrift.ad;
import com.xiaomi.xmpush.thrift.ae;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;
import org.android.agoo.common.C4575b;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;
import org.apache.thrift.C4597f;

/* renamed from: com.xiaomi.mipush.sdk.m */
public class C4357m {
    private static C4357m f14817a;
    private static Queue<String> f14818c;
    private static Object f14819d;
    private Context f14820b;

    static {
        f14817a = null;
        f14819d = new Object();
    }

    private C4357m(Context context) {
        this.f14820b = context.getApplicationContext();
        if (this.f14820b == null) {
            this.f14820b = context;
        }
    }

    public static Intent m17841a(Context context, String str, Map<String, String> map) {
        URISyntaxException e;
        MalformedURLException malformedURLException;
        if (map == null || !map.containsKey("notify_effect")) {
            return null;
        }
        Intent launchIntentForPackage;
        String str2 = (String) map.get("notify_effect");
        if (aa.f14977a.equals(str2)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                C4302b.m17654d("Cause: " + e2.getMessage());
                launchIntentForPackage = null;
            }
        } else {
            Intent intent;
            if (aa.f14978b.equals(str2)) {
                if (map.containsKey("intent_uri")) {
                    str2 = (String) map.get("intent_uri");
                    if (str2 != null) {
                        try {
                            launchIntentForPackage = Intent.parseUri(str2, 1);
                            try {
                                launchIntentForPackage.setPackage(str);
                            } catch (URISyntaxException e3) {
                                e = e3;
                                C4302b.m17654d("Cause: " + e.getMessage());
                                if (launchIntentForPackage == null) {
                                    return null;
                                }
                                launchIntentForPackage.addFlags(268435456);
                                try {
                                    return context.getPackageManager().resolveActivity(launchIntentForPackage, AccessibilityNodeInfoCompat.ACTION_CUT) != null ? launchIntentForPackage : null;
                                } catch (Exception e22) {
                                    C4302b.m17654d("Cause: " + e22.getMessage());
                                    return null;
                                }
                            }
                        } catch (URISyntaxException e4) {
                            e = e4;
                            launchIntentForPackage = null;
                            C4302b.m17654d("Cause: " + e.getMessage());
                            if (launchIntentForPackage == null) {
                                return null;
                            }
                            launchIntentForPackage.addFlags(268435456);
                            if (context.getPackageManager().resolveActivity(launchIntentForPackage, AccessibilityNodeInfoCompat.ACTION_CUT) != null) {
                            }
                        }
                    }
                    launchIntentForPackage = null;
                } else if (map.containsKey("class_name")) {
                    str2 = (String) map.get("class_name");
                    intent = new Intent();
                    intent.setComponent(new ComponentName(str, str2));
                    try {
                        if (map.containsKey("intent_flag")) {
                            intent.setFlags(Integer.parseInt((String) map.get("intent_flag")));
                        }
                    } catch (NumberFormatException e5) {
                        C4302b.m17654d("Cause by intent_flag: " + e5.getMessage());
                    }
                    launchIntentForPackage = intent;
                }
            } else if (aa.f14979c.equals(str2)) {
                str2 = (String) map.get("web_uri");
                if (str2 != null) {
                    str2 = str2.trim();
                    String str3 = (str2.startsWith("http://") || str2.startsWith("https://")) ? str2 : "http://" + str2;
                    try {
                        str2 = new URL(str3).getProtocol();
                        if (HttpConstant.HTTP.equals(str2) || HttpConstant.HTTPS.equals(str2)) {
                            launchIntentForPackage = new Intent("android.intent.action.VIEW");
                            try {
                                launchIntentForPackage.setData(Uri.parse(str3));
                            } catch (MalformedURLException e6) {
                                MalformedURLException malformedURLException2 = e6;
                                intent = launchIntentForPackage;
                                malformedURLException = malformedURLException2;
                                C4302b.m17654d("Cause: " + malformedURLException.getMessage());
                                launchIntentForPackage = intent;
                                if (launchIntentForPackage == null) {
                                    return null;
                                }
                                launchIntentForPackage.addFlags(268435456);
                                if (context.getPackageManager().resolveActivity(launchIntentForPackage, AccessibilityNodeInfoCompat.ACTION_CUT) != null) {
                                }
                            }
                        }
                        launchIntentForPackage = null;
                    } catch (MalformedURLException e7) {
                        malformedURLException = e7;
                        intent = null;
                        C4302b.m17654d("Cause: " + malformedURLException.getMessage());
                        launchIntentForPackage = intent;
                        if (launchIntentForPackage == null) {
                            return null;
                        }
                        launchIntentForPackage.addFlags(268435456);
                        if (context.getPackageManager().resolveActivity(launchIntentForPackage, AccessibilityNodeInfoCompat.ACTION_CUT) != null) {
                        }
                    }
                }
            }
            launchIntentForPackage = null;
        }
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.addFlags(268435456);
        if (context.getPackageManager().resolveActivity(launchIntentForPackage, AccessibilityNodeInfoCompat.ACTION_CUT) != null) {
        }
    }

    private C4341a m17842a(C4542p c4542p, boolean z, byte[] bArr) {
        C4341a c4341a = null;
        try {
            C4454a a = C4355k.m17837a(this.f14820b, c4542p);
            if (a == null) {
                C4302b.m17654d("receiving an un-recognized message. " + c4542p.f16041a);
                return null;
            }
            C4302b.m17653c("receive a message." + a);
            C4513a a2 = c4542p.m18999a();
            C4302b.m17649a("processing a message, action=" + a2);
            List list;
            switch (C4358n.f14821a[a2.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (!C4343a.m17800a(this.f14820b).m17819l() || z) {
                        C4558x c4558x = (C4558x) a;
                        C4527h l = c4558x.m19186l();
                        if (l == null) {
                            C4302b.m17654d("receive an empty message without push content, drop it");
                            return null;
                        }
                        String b;
                        if (z) {
                            if (C4436r.m18338b(c4542p)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f14820b, l.m18841b(), c4542p.m19025m(), c4542p.f16046f, l.m18845d());
                            } else {
                                MiPushClient.reportMessageClicked(this.f14820b, l.m18841b(), c4542p.m19025m(), l.m18845d());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(c4558x.m19184j()) && MiPushClient.aliasSetTime(this.f14820b, c4558x.m19184j()) < 0) {
                                MiPushClient.addAlias(this.f14820b, c4558x.m19184j());
                            } else if (!TextUtils.isEmpty(c4558x.m19182h()) && MiPushClient.topicSubscribedTime(this.f14820b, c4558x.m19182h()) < 0) {
                                MiPushClient.addTopic(this.f14820b, c4558x.m19182h());
                            }
                        }
                        CharSequence charSequence = (c4542p.f16048h == null || c4542p.f16048h.m18892s() == null) ? null : (String) c4542p.f16048h.f15848j.get("jobkey");
                        if (TextUtils.isEmpty(charSequence)) {
                            b = l.m18841b();
                        } else {
                            CharSequence charSequence2 = charSequence;
                        }
                        if (z || !C4357m.m17848a(this.f14820b, b)) {
                            Serializable generateMessage = PushMessageHelper.generateMessage(c4558x, c4542p.m19025m(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && C4436r.m18333a(generateMessage.getExtra())) {
                                C4436r.m18330a(this.f14820b, c4542p, bArr);
                                return null;
                            }
                            C4302b.m17649a("receive a message, msgid=" + l.m18841b() + ", jobkey=" + b);
                            if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                Map extra = generateMessage.getExtra();
                                String str = (String) extra.get("notify_effect");
                                if (C4436r.m18338b(c4542p)) {
                                    Intent a3 = C4357m.m17841a(this.f14820b, c4542p.f16046f, extra);
                                    if (a3 == null) {
                                        C4302b.m17649a("Getting Intent fail from ignore reg message. ");
                                        return null;
                                    }
                                    Object f = l.m18847f();
                                    if (!TextUtils.isEmpty(f)) {
                                        a3.putExtra("payload", f);
                                    }
                                    this.f14820b.startActivity(a3);
                                    return null;
                                }
                                Intent a4 = C4357m.m17841a(this.f14820b, this.f14820b.getPackageName(), extra);
                                if (a4 == null) {
                                    return null;
                                }
                                if (!str.equals(aa.f14979c)) {
                                    a4.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                }
                                this.f14820b.startActivity(a4);
                                return null;
                            }
                            Serializable serializable = generateMessage;
                        } else {
                            C4302b.m17649a("drop a duplicate message, key=" + b);
                        }
                        if (c4542p.m19025m() != null || z) {
                            return c4341a;
                        }
                        m17847a(c4558x, c4542p);
                        return c4341a;
                    }
                    C4302b.m17649a("receive a message in pause state. drop it");
                    return null;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    C4552u c4552u = (C4552u) a;
                    if (c4552u.f16222f == 0) {
                        C4343a.m17800a(this.f14820b).m17808b(c4552u.f16224h, c4552u.f16225i);
                    }
                    if (TextUtils.isEmpty(c4552u.f16224h)) {
                        list = null;
                    } else {
                        list = new ArrayList();
                        list.add(c4552u.f16224h);
                    }
                    c4341a = PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_REGISTER, list, c4552u.f16222f, c4552u.f16223g, null);
                    C4360o.m17853a(this.f14820b).m17876d();
                    return c4341a;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (((ab) a).f15587f == 0) {
                        C4343a.m17800a(this.f14820b).m17815h();
                        MiPushClient.clearExtras(this.f14820b);
                    }
                    PushMessageHandler.m17780a();
                    return null;
                case SpdyProtocol.QUIC /*4*/:
                    C4562z c4562z = (C4562z) a;
                    if (c4562z.f16384f == 0) {
                        MiPushClient.addTopic(this.f14820b, c4562z.m19226h());
                    }
                    if (TextUtils.isEmpty(c4562z.m19226h())) {
                        list = null;
                    } else {
                        list = new ArrayList();
                        list.add(c4562z.m19226h());
                    }
                    return PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_SUBSCRIBE_TOPIC, list, c4562z.f16384f, c4562z.f16385g, c4562z.m19229k());
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    ad adVar = (ad) a;
                    if (adVar.f15649f == 0) {
                        MiPushClient.removeTopic(this.f14820b, adVar.m18785h());
                    }
                    if (TextUtils.isEmpty(adVar.m18785h())) {
                        list = null;
                    } else {
                        list = new ArrayList();
                        list.add(adVar.m18785h());
                    }
                    return PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC, list, adVar.f15649f, adVar.f15650g, adVar.m18788k());
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    C4540o c4540o = (C4540o) a;
                    Object e = c4540o.m18987e();
                    List k = c4540o.m18993k();
                    if (c4540o.f16013g == 0) {
                        if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ACCEPT_TIME) && k != null && k.size() > 1) {
                            MiPushClient.addAcceptTime(this.f14820b, (String) k.get(0), (String) k.get(1));
                            if ("00:00".equals(k.get(0)) && "00:00".equals(k.get(1))) {
                                C4343a.m17800a(this.f14820b).m17805a(true);
                            } else {
                                C4343a.m17800a(this.f14820b).m17805a(false);
                            }
                            list = m17851a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), k);
                            return PushMessageHelper.generateCommandMessage(e, list, c4540o.f16013g, c4540o.f16014h, c4540o.m18995m());
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ALIAS) && k != null && k.size() > 0) {
                            MiPushClient.addAlias(this.f14820b, (String) k.get(0));
                            list = k;
                            return PushMessageHelper.generateCommandMessage(e, list, c4540o.f16013g, c4540o.f16014h, c4540o.m18995m());
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_UNSET_ALIAS) && k != null && k.size() > 0) {
                            MiPushClient.removeAlias(this.f14820b, (String) k.get(0));
                            list = k;
                            return PushMessageHelper.generateCommandMessage(e, list, c4540o.f16013g, c4540o.f16014h, c4540o.m18995m());
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ACCOUNT) && k != null && k.size() > 0) {
                            MiPushClient.addAccount(this.f14820b, (String) k.get(0));
                            list = k;
                            return PushMessageHelper.generateCommandMessage(e, list, c4540o.f16013g, c4540o.f16014h, c4540o.m18995m());
                        } else if (TextUtils.equals(e, MiPushClient.COMMAND_UNSET_ACCOUNT) && k != null && k.size() > 0) {
                            MiPushClient.removeAccount(this.f14820b, (String) k.get(0));
                        }
                    }
                    list = k;
                    return PushMessageHelper.generateCommandMessage(e, list, c4540o.f16013g, c4540o.f16014h, c4540o.m18995m());
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    C4548s c4548s = (C4548s) a;
                    if ("registration id expired".equalsIgnoreCase(c4548s.f16107e)) {
                        MiPushClient.reInitialize(this.f14820b, C4530j.RegIdExpired);
                        return null;
                    } else if ("client_info_update_ok".equalsIgnoreCase(c4548s.f16107e)) {
                        if (c4548s.m19068h() == null || !c4548s.m19068h().containsKey(C4575b.PROPERTY_APP_VERSION)) {
                            return null;
                        }
                        C4343a.m17800a(this.f14820b).m17803a((String) c4548s.m19068h().get(C4575b.PROPERTY_APP_VERSION));
                        return null;
                    } else if ("awake_app".equalsIgnoreCase(c4548s.f16107e)) {
                        if (c4548s.m19068h() == null || !c4548s.m19068h().containsKey("packages")) {
                            return null;
                        }
                        MiPushClient.awakeApps(this.f14820b, ((String) c4548s.m19068h().get("packages")).split(Constants.ACCEPT_TIME_SEPARATOR_SP));
                        return null;
                    } else if (C4523f.NormalClientConfigUpdate.f15748z.equalsIgnoreCase(c4548s.f16107e)) {
                        C4546r c4546r = new C4546r();
                        try {
                            ae.m18792a((C4454a) c4546r, c4548s.m19072l());
                            C4446w.m18382a(C4445v.m18368a(this.f14820b), c4546r);
                            return null;
                        } catch (Throwable e2) {
                            C4302b.m17651a(e2);
                            return null;
                        }
                    } else if (C4523f.CustomClientConfigUpdate.f15748z.equalsIgnoreCase(c4548s.f16107e)) {
                        C4544q c4544q = new C4544q();
                        try {
                            ae.m18792a((C4454a) c4544q, c4548s.m19072l());
                            C4446w.m18381a(C4445v.m18368a(this.f14820b), c4544q);
                            return null;
                        } catch (Throwable e22) {
                            C4302b.m17651a(e22);
                            return null;
                        }
                    } else if (C4523f.SyncInfoResult.f15748z.equalsIgnoreCase(c4548s.f16107e)) {
                        C4362q.m17881a(this.f14820b, c4548s);
                        return null;
                    } else if (!C4523f.ForceSync.f15748z.equalsIgnoreCase(c4548s.f16107e)) {
                        return null;
                    } else {
                        C4302b.m17649a("receive force sync notification");
                        C4362q.m17882a(this.f14820b, false);
                        return null;
                    }
                default:
                    return null;
            }
        } catch (Throwable e222) {
            C4302b.m17651a(e222);
            m17846a(c4542p);
            return null;
        } catch (Throwable e2222) {
            C4302b.m17651a(e2222);
            C4302b.m17654d("receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    private C4341a m17843a(C4542p c4542p, byte[] bArr) {
        String str = null;
        try {
            C4454a a = C4355k.m17837a(this.f14820b, c4542p);
            if (a == null) {
                C4302b.m17654d("message arrived: receiving an un-recognized message. " + c4542p.f16041a);
                return null;
            }
            C4302b.m17653c("message arrived: receive a message." + a);
            C4513a a2 = c4542p.m18999a();
            C4302b.m17649a("message arrived: processing an arrived message, action=" + a2);
            switch (C4358n.f14821a[a2.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    C4558x c4558x = (C4558x) a;
                    C4527h l = c4558x.m19186l();
                    if (l == null) {
                        C4302b.m17654d("message arrived: receive an empty message without push content, drop it");
                        return null;
                    }
                    if (!(c4542p.f16048h == null || c4542p.f16048h.m18892s() == null)) {
                        str = (String) c4542p.f16048h.f15848j.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(c4558x, c4542p.m19025m(), false);
                    generateMessage.setArrivedMessage(true);
                    C4302b.m17649a("message arrived: receive a message, msgid=" + l.m18841b() + ", jobkey=" + str);
                    return generateMessage;
                default:
                    return null;
            }
        } catch (Throwable e) {
            C4302b.m17651a(e);
            C4302b.m17654d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (Throwable e2) {
            C4302b.m17651a(e2);
            C4302b.m17654d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    public static C4357m m17844a(Context context) {
        if (f14817a == null) {
            f14817a = new C4357m(context);
        }
        return f14817a;
    }

    private void m17845a() {
        SharedPreferences sharedPreferences = this.f14820b.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0)) > 1800000) {
            MiPushClient.reInitialize(this.f14820b, C4530j.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    private void m17846a(C4542p c4542p) {
        C4302b.m17649a("receive a message but decrypt failed. report now.");
        C4454a c4548s = new C4548s(c4542p.m19025m().f15839a, false);
        c4548s.m19061c(C4523f.DecryptMessageFail.f15748z);
        c4548s.m19057b(c4542p.m19020h());
        c4548s.m19063d(c4542p.f16046f);
        c4548s.f16110h = new HashMap();
        c4548s.f16110h.put("regid", MiPushClient.getRegId(this.f14820b));
        C4360o.m17853a(this.f14820b).m17869a(c4548s, C4513a.Notification, false, null);
    }

    private void m17847a(C4558x c4558x, C4542p c4542p) {
        C4529i m = c4542p.m19025m();
        C4454a c4534l = new C4534l();
        c4534l.m18922b(c4558x.m19179e());
        c4534l.m18915a(c4558x.m19177c());
        c4534l.m18914a(c4558x.m19186l().m18849h());
        if (!TextUtils.isEmpty(c4558x.m19182h())) {
            c4534l.m18926c(c4558x.m19182h());
        }
        if (!TextUtils.isEmpty(c4558x.m19184j())) {
            c4534l.m18929d(c4558x.m19184j());
        }
        c4534l.m18916a(ae.m18791a(this.f14820b, c4542p.f16046f));
        C4360o.m17853a(this.f14820b).m17867a(c4534l, C4513a.AckMessage, m);
    }

    private static boolean m17848a(Context context, String str) {
        boolean z = false;
        synchronized (f14819d) {
            SharedPreferences j = C4343a.m17800a(context).m17817j();
            if (f14818c == null) {
                String[] split = j.getString("pref_msg_ids", BuildConfig.FLAVOR).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f14818c = new LinkedList();
                for (Object add : split) {
                    f14818c.add(add);
                }
            }
            if (f14818c.contains(str)) {
                z = true;
            } else {
                f14818c.add(str);
                if (f14818c.size() > 25) {
                    f14818c.poll();
                }
                String a = C4329d.m17743a(f14818c, Constants.ACCEPT_TIME_SEPARATOR_SP);
                Editor edit = j.edit();
                edit.putString("pref_msg_ids", a);
                edit.commit();
            }
        }
        return z;
    }

    private void m17849b(C4542p c4542p) {
        C4529i m = c4542p.m19025m();
        C4454a c4534l = new C4534l();
        c4534l.m18922b(c4542p.m19020h());
        c4534l.m18915a(m.m18867b());
        c4534l.m18914a(m.m18874d());
        if (!TextUtils.isEmpty(m.m18879f())) {
            c4534l.m18926c(m.m18879f());
        }
        c4534l.m18916a(ae.m18791a(this.f14820b, c4542p.f16046f));
        C4360o.m17853a(this.f14820b).m17869a(c4534l, C4513a.AckMessage, false, c4542p.m19025m());
    }

    public C4341a m17850a(Intent intent) {
        String action = intent.getAction();
        C4302b.m17649a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        byte[] byteArrayExtra;
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                C4302b.m17654d("receiving an empty message, drop");
                return null;
            }
            C4542p c4542p = new C4542p();
            try {
                ae.m18792a((C4454a) c4542p, byteArrayExtra);
                C4343a a = C4343a.m17800a(this.f14820b);
                C4529i m = c4542p.m19025m();
                if (!(c4542p.m18999a() != C4513a.SendMessage || m == null || a.m17819l() || booleanExtra)) {
                    if (m != null) {
                        c4542p.m19025m().m18860a("mrt", stringExtra);
                        c4542p.m19025m().m18860a("mat", Long.toString(System.currentTimeMillis()));
                    }
                    m17849b(c4542p);
                }
                if (c4542p.m18999a() == C4513a.SendMessage && !c4542p.m19014c()) {
                    if (!C4436r.m18338b(c4542p)) {
                        action = "drop an un-encrypted messages. %1$s, %2$s";
                        Object[] objArr = new Object[2];
                        objArr[0] = c4542p.m19022j();
                        objArr[1] = m != null ? m.m18867b() : BuildConfig.FLAVOR;
                        C4302b.m17649a(String.format(action, objArr));
                        return null;
                    } else if (!(booleanExtra && m.m18892s() != null && m.m18892s().containsKey("notify_effect"))) {
                        C4302b.m17649a(String.format("drop an un-encrypted messages. %1$s, %2$s", new Object[]{c4542p.m19022j(), m.m18867b()}));
                        return null;
                    }
                }
                if (a.m17816i() || c4542p.f16041a == C4513a.Registration) {
                    if (!a.m17816i() || !a.m17821n()) {
                        return m17842a(c4542p, booleanExtra, byteArrayExtra);
                    }
                    if (c4542p.f16041a == C4513a.UnRegistration) {
                        a.m17815h();
                        MiPushClient.clearExtras(this.f14820b);
                        PushMessageHandler.m17780a();
                    } else {
                        MiPushClient.unregisterPush(this.f14820b);
                    }
                } else if (C4436r.m18338b(c4542p)) {
                    return m17842a(c4542p, booleanExtra, byteArrayExtra);
                } else {
                    C4302b.m17654d("receive message without registration. need re-register!");
                    m17845a();
                }
            } catch (Throwable e) {
                C4302b.m17651a(e);
            } catch (Throwable e2) {
                C4302b.m17651a(e2);
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            C4341a miPushCommandMessage = new MiPushCommandMessage();
            C4454a c4542p2 = new C4542p();
            try {
                byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra != null) {
                    ae.m18792a(c4542p2, byteArrayExtra);
                }
            } catch (C4597f e3) {
            }
            miPushCommandMessage.setCommand(String.valueOf(c4542p2.m18999a()));
            miPushCommandMessage.setResultCode((long) intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            C4302b.m17654d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra2 == null) {
                C4302b.m17654d("message arrived: receiving an empty message, drop");
                return null;
            }
            C4542p c4542p3 = new C4542p();
            try {
                ae.m18792a((C4454a) c4542p3, byteArrayExtra2);
                C4343a a2 = C4343a.m17800a(this.f14820b);
                if (C4436r.m18338b(c4542p3)) {
                    C4302b.m17654d("message arrived: receive ignore reg message, ignore!");
                } else if (!a2.m17816i()) {
                    C4302b.m17654d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!a2.m17816i() || !a2.m17821n()) {
                    return m17843a(c4542p3, byteArrayExtra2);
                } else {
                    C4302b.m17654d("message arrived: app info is invalidated");
                }
            } catch (Throwable e22) {
                C4302b.m17651a(e22);
            } catch (Throwable e222) {
                C4302b.m17651a(e222);
            }
        }
        return null;
    }

    public List<String> m17851a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / AdError.NETWORK_ERROR_CODE) / 60);
        long parseLong = Long.parseLong(((String) list.get(0)).split(":")[0]);
        long parseLong2 = Long.parseLong(((String) list.get(0)).split(":")[1]);
        parseLong = ((((parseLong * 60) + parseLong2) - rawOffset) + 1440) % 1440;
        long parseLong3 = (((Long.parseLong(((String) list.get(1)).split(":")[1]) + (60 * Long.parseLong(((String) list.get(1)).split(":")[0]))) - rawOffset) + 1440) % 1440;
        List arrayList = new ArrayList();
        List list2 = arrayList;
        list2.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)}));
        list2 = arrayList;
        list2.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)}));
        return arrayList;
    }
}
