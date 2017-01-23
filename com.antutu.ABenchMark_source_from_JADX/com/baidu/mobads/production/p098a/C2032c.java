package com.baidu.mobads.production.p098a;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.vo.C2031d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.a.c */
public class C2032c extends C2031d {
    public C2032c(Context context, Activity activity, SlotType slotType) {
        super(context, activity, slotType);
        this.b = "http://mobads.baidu.com/ads/index.htm";
    }

    protected HashMap<String, String> m7628a() {
        return new HashMap();
    }

    public String m7629b() {
        return "http://127.0.0.1";
    }
}
