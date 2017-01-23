package com.baidu.mobad.video;

import com.baidu.mobads.interfaces.IXAdEvent4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.openad.p079d.C1899b;
import java.util.HashMap;

public class XAdEvent4PDK extends C1899b implements IXAdEvent4PDK {
    private IXAdProd f6542a;

    public XAdEvent4PDK(String str, int i, IXAdProd iXAdProd) {
        super(str, i);
        this.f6542a = iXAdProd;
    }

    public XAdEvent4PDK(String str, int i, String str2, IXAdProd iXAdProd) {
        super(str, i, str2);
        this.f6542a = iXAdProd;
    }

    public XAdEvent4PDK(String str, int i, HashMap<String, Object> hashMap, IXAdProd iXAdProd) {
        super(str, i, (HashMap) hashMap);
        this.f6542a = iXAdProd;
    }

    public XAdEvent4PDK(String str, IXAdProd iXAdProd) {
        super(str);
        this.f6542a = iXAdProd;
    }

    public XAdEvent4PDK(String str, String str2, IXAdProd iXAdProd) {
        super(str, str2);
        this.f6542a = iXAdProd;
    }

    public XAdEvent4PDK(String str, HashMap<String, Object> hashMap, IXAdProd iXAdProd) {
        super(str, (HashMap) hashMap);
        this.f6542a = iXAdProd;
    }

    public IXAdProd getAdSlot() {
        return this.f6542a;
    }
}
