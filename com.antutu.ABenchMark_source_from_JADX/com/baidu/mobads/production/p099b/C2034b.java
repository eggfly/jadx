package com.baidu.mobads.production.p099b;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.vo.C2031d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.b.b */
public class C2034b extends C2031d {
    public C2034b(Context context, Activity activity, SlotType slotType) {
        super(context, activity, slotType);
        this.b = "http://mobads.baidu.com/cpro/ui/mads.php";
        m7614a("androidfeed");
    }

    protected HashMap<String, String> m7649a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
        return hashMap;
    }

    public String m7650b() {
        return super.m7616b();
    }
}
