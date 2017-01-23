package com.baidu.mobads.command.p086b;

import com.baidu.mobads.command.C1921b;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.p080j.C1991m;

/* renamed from: com.baidu.mobads.command.b.a */
public class C1925a extends C1921b {
    private String f6756f;

    public C1925a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource, String str) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
        this.f6756f = null;
        this.f6756f = str;
    }

    public void m7261a() {
        C1991m.m7449a().m7464m().browserOutside(this.a, this.f6756f);
    }
}
