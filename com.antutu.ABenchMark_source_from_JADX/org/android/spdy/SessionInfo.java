package org.android.spdy;

public class SessionInfo {
    private int connTimeoutMs;
    private String domain;
    private String host;
    private int mode;
    private int port;
    private String proxyHost;
    private int proxyPort;
    private int pubkey_seqnum;
    private SessionCb sessionCb;
    private Object sessionUserData;

    public SessionInfo(String str, int i, String str2, String str3, int i2, Object obj, SessionCb sessionCb, int i3) {
        this.host = str;
        this.port = i;
        this.domain = str2;
        this.proxyHost = str3;
        this.proxyPort = i2;
        this.sessionUserData = obj;
        this.sessionCb = sessionCb;
        this.mode = i3;
        this.pubkey_seqnum = 0;
        this.connTimeoutMs = -1;
    }

    String getAuthority() {
        return (this.proxyHost == null || this.proxyPort == 0) ? this.host + ":" + this.port : this.host + ":" + this.port + "/" + this.proxyHost + ":" + this.proxyPort;
    }

    int getConnectionTimeoutMs() {
        return this.connTimeoutMs;
    }

    String getDomain() {
        return this.domain;
    }

    int getMode() {
        return this.mode;
    }

    int getPubKeySeqNum() {
        return this.pubkey_seqnum;
    }

    SessionCb getSessionCb() {
        return this.sessionCb;
    }

    Object getSessonUserData() {
        return this.sessionUserData;
    }

    public void setConnectionTimeoutMs(int i) {
        this.connTimeoutMs = i;
    }

    public void setPubKeySeqNum(int i) {
        this.pubkey_seqnum = i;
    }
}
