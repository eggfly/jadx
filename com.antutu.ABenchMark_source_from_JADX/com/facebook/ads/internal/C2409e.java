package com.facebook.ads.internal;

import com.taobao.accs.common.Constants;

/* renamed from: com.facebook.ads.internal.e */
public enum C2409e {
    UNKNOWN(0),
    WEBVIEW_BANNER_LEGACY(4),
    WEBVIEW_BANNER_50(5),
    WEBVIEW_BANNER_90(6),
    WEBVIEW_BANNER_250(7),
    WEBVIEW_INTERSTITIAL_UNKNOWN(100),
    WEBVIEW_INTERSTITIAL_HORIZONTAL(Constants.COMMAND_RECEIVE_DATA),
    WEBVIEW_INTERSTITIAL_VERTICAL(Constants.COMMAND_SEND_STATIST),
    WEBVIEW_INTERSTITIAL_TABLET(Constants.COMMAND_CONNECT_INFO),
    NATIVE_UNKNOWN(Constants.COMMAND_HANDSHAKE),
    NATIVE_250(Constants.COMMAND_PING);
    
    private final int f8341l;

    private C2409e(int i) {
        this.f8341l = i;
    }

    public int m9262a() {
        return this.f8341l;
    }
}
