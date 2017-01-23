package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.google.analytics.tracking.android.ModelFields;
import com.umeng.analytics.C4156a;
import com.umeng.analytics.C4163b;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.game.C4167b.C4166a;
import com.umeng.message.MsgConstant;
import com.umeng.message.util.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import p023b.p024a.C0888r;
import p023b.p024a.ao;
import p023b.p024a.ap;
import p023b.p024a.aq;
import p023b.p024a.as;

/* renamed from: com.umeng.analytics.game.c */
class C4170c implements ao {
    private C4163b f14014a;
    private C4167b f14015b;
    private final int f14016c;
    private final int f14017d;
    private final int f14018e;
    private final int f14019f;
    private final int f14020g;
    private final String f14021h;
    private final String f14022i;
    private final String f14023j;
    private final String f14024k;
    private final String f14025l;
    private final String f14026m;
    private final String f14027n;
    private final String f14028o;
    private final String f14029p;
    private final String f14030q;
    private final String f14031r;
    private final String f14032s;
    private final String f14033t;
    private final String f14034u;
    private final String f14035v;
    private final String f14036w;
    private final String f14037x;
    private final String f14038y;
    private Context f14039z;

    /* renamed from: com.umeng.analytics.game.c.1 */
    class C41681 extends as {
        final /* synthetic */ String f14009a;
        final /* synthetic */ C4170c f14010b;

        C41681(C4170c c4170c, String str) {
            this.f14010b = c4170c;
            this.f14009a = str;
        }

        public void m17027a() {
            this.f14010b.f14015b.m17023a(this.f14009a);
            HashMap hashMap = new HashMap();
            hashMap.put("level", this.f14009a);
            hashMap.put(MsgConstant.KEY_STATUS, Integer.valueOf(0));
            if (this.f14010b.f14015b.f14002b != null) {
                hashMap.put("user_level", this.f14010b.f14015b.f14002b);
            }
            this.f14010b.f14014a.m16983a(this.f14010b.f14039z, "level", hashMap);
        }
    }

    /* renamed from: com.umeng.analytics.game.c.2 */
    class C41692 extends as {
        final /* synthetic */ String f14011a;
        final /* synthetic */ int f14012b;
        final /* synthetic */ C4170c f14013c;

        C41692(C4170c c4170c, String str, int i) {
            this.f14013c = c4170c;
            this.f14011a = str;
            this.f14012b = i;
        }

        public void m17028a() {
            C4166a b = this.f14013c.f14015b.m17025b(this.f14011a);
            if (b != null) {
                long e = b.m17021e();
                if (e <= 0) {
                    ap.m3381a("level duration is 0");
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("level", this.f14011a);
                hashMap.put(MsgConstant.KEY_STATUS, Integer.valueOf(this.f14012b));
                hashMap.put("duration", Long.valueOf(e));
                if (this.f14013c.f14015b.f14002b != null) {
                    hashMap.put("user_level", this.f14013c.f14015b.f14002b);
                }
                this.f14013c.f14014a.m16983a(this.f14013c.f14039z, "level", hashMap);
                return;
            }
            ap.m3389c(String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
        }
    }

    public C4170c() {
        this.f14014a = MobclickAgent.getAgent();
        this.f14015b = null;
        this.f14016c = 100;
        this.f14017d = 1;
        this.f14018e = 0;
        this.f14019f = -1;
        this.f14020g = 1;
        this.f14021h = "level";
        this.f14022i = "pay";
        this.f14023j = "buy";
        this.f14024k = "use";
        this.f14025l = "bonus";
        this.f14026m = ModelFields.ITEM;
        this.f14027n = "cash";
        this.f14028o = "coin";
        this.f14029p = AgooConstants.MESSAGE_FROM_PKG;
        this.f14030q = "amount";
        this.f14031r = "user_level";
        this.f14032s = "bonus_source";
        this.f14033t = "level";
        this.f14034u = MsgConstant.KEY_STATUS;
        this.f14035v = "duration";
        this.f14036w = "curtype";
        this.f14037x = "orderid";
        this.f14038y = "UMGameAgent.init(Context) should be called before any game api";
        C4165a.f13996a = true;
    }

    private void m17030a(String str, int i) {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
        } else {
            aq.m3394a(new C41692(this, str, i));
        }
    }

    public void m17033a() {
        ap.m3381a("App resume from background");
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
        } else if (C4165a.f13996a) {
            this.f14015b.m17026b();
        }
    }

    void m17034a(double d, double d2, int i) {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cash", Long.valueOf((long) (d * 100.0d)));
        hashMap.put("coin", Long.valueOf((long) (d2 * 100.0d)));
        hashMap.put(AgooConstants.MESSAGE_FROM_PKG, Integer.valueOf(i));
        if (this.f14015b.f14002b != null) {
            hashMap.put("user_level", this.f14015b.f14002b);
        }
        if (this.f14015b.f14001a != null) {
            hashMap.put("level", this.f14015b.f14001a);
        }
        this.f14014a.m16983a(this.f14039z, "pay", hashMap);
    }

    void m17035a(double d, int i) {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("coin", Long.valueOf((long) (100.0d * d)));
        hashMap.put("bonus_source", Integer.valueOf(i));
        if (this.f14015b.f14002b != null) {
            hashMap.put("user_level", this.f14015b.f14002b);
        }
        if (this.f14015b.f14001a != null) {
            hashMap.put("level", this.f14015b.f14001a);
        }
        this.f14014a.m16983a(this.f14039z, "bonus", hashMap);
    }

    void m17036a(double d, String str, double d2, int i, String str2) {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
        } else if (d >= 0.0d && d2 >= 0.0d) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && str.length() > 0 && str.length() <= 3) {
                hashMap.put("curtype", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    int length = str2.getBytes(HttpRequest.f14548a).length;
                    if (length > 0 && length <= IXAdIOUtils.BUFFER_SIZE) {
                        hashMap.put("orderid", str2);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            hashMap.put("cash", Long.valueOf((long) (d * 100.0d)));
            hashMap.put("coin", Long.valueOf((long) (d2 * 100.0d)));
            hashMap.put(AgooConstants.MESSAGE_FROM_PKG, Integer.valueOf(i));
            if (this.f14015b.f14002b != null) {
                hashMap.put("user_level", this.f14015b.f14002b);
            }
            if (this.f14015b.f14001a != null) {
                hashMap.put("level", this.f14015b.f14001a);
            }
            this.f14014a.m16983a(this.f14039z, "pay", hashMap);
        }
    }

    void m17037a(double d, String str, int i, double d2, int i2) {
        m17034a(d, d2 * ((double) i), i2);
        m17040a(str, i, d2);
    }

    void m17038a(Context context) {
        if (context == null) {
            ap.m3391d("Context is null, can't init GameAgent");
            return;
        }
        this.f14039z = context.getApplicationContext();
        this.f14014a.m16989a((ao) this);
        this.f14015b = new C4167b(this.f14039z);
        this.f14014a.m16978a(context, 1);
    }

    void m17039a(String str) {
        this.f14015b.f14002b = str;
        SharedPreferences a = C0888r.m3932a(this.f14039z);
        if (a != null) {
            Editor edit = a.edit();
            edit.putString(C4156a.f13938A, str);
            edit.commit();
        }
    }

    void m17040a(String str, int i, double d) {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ModelFields.ITEM, str);
        hashMap.put("amount", Integer.valueOf(i));
        hashMap.put("coin", Long.valueOf((long) ((((double) i) * d) * 100.0d)));
        if (this.f14015b.f14002b != null) {
            hashMap.put("user_level", this.f14015b.f14002b);
        }
        if (this.f14015b.f14001a != null) {
            hashMap.put("level", this.f14015b.f14001a);
        }
        this.f14014a.m16983a(this.f14039z, "buy", hashMap);
    }

    void m17041a(String str, int i, double d, int i2) {
        m17035a(((double) i) * d, i2);
        m17040a(str, i, d);
    }

    void m17042a(boolean z) {
        ap.m3381a(String.format("Trace sleep time : %b", new Object[]{Boolean.valueOf(z)}));
        C4165a.f13996a = z;
    }

    public void m17043b() {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
        } else if (C4165a.f13996a) {
            this.f14015b.m17024a();
        }
    }

    void m17044b(String str) {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        this.f14015b.f14001a = str;
        aq.m3394a(new C41681(this, str));
    }

    void m17045b(String str, int i, double d) {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ModelFields.ITEM, str);
        hashMap.put("amount", Integer.valueOf(i));
        hashMap.put("coin", Long.valueOf((long) ((((double) i) * d) * 100.0d)));
        if (this.f14015b.f14002b != null) {
            hashMap.put("user_level", this.f14015b.f14002b);
        }
        if (this.f14015b.f14001a != null) {
            hashMap.put("level", this.f14015b.f14001a);
        }
        this.f14014a.m16983a(this.f14039z, "use", hashMap);
    }

    void m17046c(String str) {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
        } else {
            m17030a(str, 1);
        }
    }

    void m17047d(String str) {
        if (this.f14039z == null) {
            ap.m3391d("UMGameAgent.init(Context) should be called before any game api");
        } else {
            m17030a(str, -1);
        }
    }
}
