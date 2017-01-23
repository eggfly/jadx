package com.miui.support.hybrid;

import java.util.Map;

public interface HybridFeature {

    public enum Mode {
        SYNC,
        ASYNC,
        CALLBACK
    }

    Response m3504a(Request request);

    void m3505a(Map<String, String> map);

    Mode m3506b(Request request);
}
