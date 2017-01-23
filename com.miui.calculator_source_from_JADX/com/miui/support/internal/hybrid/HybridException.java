package com.miui.support.internal.hybrid;

import com.miui.support.hybrid.Response;

public class HybridException extends Exception {
    private Response f2434a;

    public HybridException() {
        super(new Response(200).toString());
        this.f2434a = new Response(200);
    }

    public HybridException(int i, String str) {
        super(new Response(i, str).toString());
        this.f2434a = new Response(i, str);
    }

    public Response m4021a() {
        return this.f2434a;
    }
}
