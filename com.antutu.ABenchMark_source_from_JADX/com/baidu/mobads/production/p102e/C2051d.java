package com.baidu.mobads.production.p102e;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.vo.C2031d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.e.d */
public class C2051d extends C2031d {
    public C2051d(Context context, SlotType slotType) {
        super(context, null, slotType);
        this.b = "http://mobads.baidu.com/cpro/ui/mads.php";
    }

    protected HashMap<String, String> m7720a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,HTML,MSSP");
        return hashMap;
    }

    public String m7721b() {
        return super.m7616b();
    }
}
