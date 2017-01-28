package org.android.spdy;

public enum SpdySessionKind {
    NONE_SESSION(0),
    WIFI_SESSION(1),
    THREE_G_SESSION(2),
    TWO_G_SESSION(3);
    
    private int code;

    private SpdySessionKind(int i) {
        this.code = i;
    }

    int getint() {
        return this.code;
    }
}
