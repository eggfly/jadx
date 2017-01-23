package anet.channel.entity;

import org.android.spdy.SpdyProtocol;

public enum ENV {
    ONLINE(0),
    PREPARE(1),
    TEST(2);
    
    private int envMode;

    private ENV(int i) {
        this.envMode = i;
    }

    public static ENV valueOf(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return PREPARE;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return TEST;
            default:
                return ONLINE;
        }
    }

    public int getEnvMode() {
        return this.envMode;
    }

    public void setEnvMode(int i) {
        this.envMode = i;
    }
}
