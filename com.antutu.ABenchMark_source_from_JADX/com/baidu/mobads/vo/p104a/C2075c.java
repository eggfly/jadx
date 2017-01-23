package com.baidu.mobads.vo.p104a;

import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.data.Message;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.baidu.mobads.vo.a.c */
public class C2075c extends C2073a {
    public long f7275A;
    public int f7276B;
    public int f7277C;
    public int f7278D;
    public int f7279E;
    public int f7280F;
    public int f7281G;
    public int f7282H;
    public String f7283n;
    public int f7284o;
    public int f7285p;
    public int f7286q;
    public AtomicInteger f7287r;
    public int f7288s;
    public int f7289t;
    public long f7290u;
    public int f7291v;
    public int f7292w;
    public int f7293x;
    public int f7294y;
    public long f7295z;

    public C2075c(XAdCommandExtraInfo xAdCommandExtraInfo) {
        super(xAdCommandExtraInfo);
        this.f7287r = new AtomicInteger(0);
        this.f7295z = 0;
        this.f7275A = 0;
        this.f7276B = 0;
        this.f7277C = 0;
        this.f7278D = 0;
        this.f7279E = 0;
        this.f7280F = 0;
        this.f7281G = 0;
        this.f7282H = 0;
    }

    protected HashMap<String, String> m7759b() {
        HashMap<String, String> hashMap = new HashMap();
        if (this.f7283n.length() > IXAdIOUtils.BUFFER_SIZE) {
            hashMap.put("obj", this.f7283n.substring(0, Message.EXT_HEADER_VALUE_MAX_LEN));
        } else {
            hashMap.put("obj", this.f7283n);
        }
        hashMap.put("order", BuildConfig.FLAVOR + this.f7284o);
        hashMap.put("height", BuildConfig.FLAVOR + this.f7285p);
        hashMap.put(NotificationCompatApi21.CATEGORY_PROGRESS, BuildConfig.FLAVOR + this.f7286q);
        hashMap.put("moves", BuildConfig.FLAVOR + this.f7287r.get());
        hashMap.put("clicks", BuildConfig.FLAVOR + this.f7288s);
        hashMap.put("urlclicks", BuildConfig.FLAVOR + this.f7288s);
        hashMap.put("lploadtime", BuildConfig.FLAVOR + this.f7289t);
        hashMap.put("duration", BuildConfig.FLAVOR + this.f7290u);
        hashMap.put("_lpWebStartLoad", BuildConfig.FLAVOR + this.f7295z);
        hashMap.put("_lpWebFinishLoad", BuildConfig.FLAVOR + this.f7275A);
        hashMap.put("e75", BuildConfig.FLAVOR + this.f7291v);
        hashMap.put("e75_3", BuildConfig.FLAVOR + this.f7292w);
        hashMap.put("from", BuildConfig.FLAVOR + this.f7293x);
        hashMap.put("maxTabs", BuildConfig.FLAVOR + this.f7294y);
        hashMap.put("b_cancel", BuildConfig.FLAVOR + this.f7280F);
        hashMap.put("b_refresh", BuildConfig.FLAVOR + this.f7278D);
        hashMap.put("b_copy", BuildConfig.FLAVOR + this.f7279E);
        hashMap.put("b_goback", BuildConfig.FLAVOR + this.f7276B);
        hashMap.put("b_threeP", BuildConfig.FLAVOR + this.f7277C);
        hashMap.put("b_home", BuildConfig.FLAVOR + this.f7282H);
        hashMap.put("b_osgoback", BuildConfig.FLAVOR + this.f7281G);
        return hashMap;
    }
}
