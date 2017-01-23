package com.miui.support.hybrid;

import com.miui.support.internal.hybrid.HybridManager;

public class Callback {
    private HybridManager f2019a;
    private PageContext f2020b;
    private String f2021c;

    public Callback(HybridManager hybridManager, PageContext pageContext, String str) {
        this.f2019a = hybridManager;
        this.f2020b = pageContext;
        this.f2021c = str;
    }

    public void m3492a(Response response) {
        this.f2019a.m4042a(response, this.f2020b, this.f2021c);
    }
}
