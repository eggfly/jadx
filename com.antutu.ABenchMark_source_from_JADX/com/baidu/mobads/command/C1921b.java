package com.baidu.mobads.command;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p080j.C1991m;

/* renamed from: com.baidu.mobads.command.b */
public abstract class C1921b {
    protected Context f6721a;
    protected IXNonLinearAdSlot f6722b;
    protected IXAdInstanceInfo f6723c;
    protected IXAdResource f6724d;
    protected IXAdLogger f6725e;

    public C1921b(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        this.f6725e = C1991m.m7449a().m7457f();
        this.f6722b = iXNonLinearAdSlot;
        this.f6721a = iXNonLinearAdSlot.getApplicationContext();
        this.f6723c = iXAdInstanceInfo;
        this.f6724d = iXAdResource;
    }
}
