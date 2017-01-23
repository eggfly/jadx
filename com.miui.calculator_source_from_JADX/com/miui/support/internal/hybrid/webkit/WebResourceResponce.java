package com.miui.support.internal.hybrid.webkit;

import android.webkit.WebResourceResponse;
import com.miui.support.hybrid.HybridResourceResponse;

public class WebResourceResponce extends WebResourceResponse {
    public WebResourceResponce(HybridResourceResponse hybridResourceResponse) {
        super(hybridResourceResponse.m3512a(), hybridResourceResponse.m3513b(), hybridResourceResponse.m3514c());
    }
}
