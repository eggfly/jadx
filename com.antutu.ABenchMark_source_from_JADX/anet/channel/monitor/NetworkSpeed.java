package anet.channel.monitor;

public enum NetworkSpeed {
    Slow("\u5f31\u7f51\u7edc", 1),
    Fast("\u5f3a\u7f51\u7edc", 5);
    
    private final String f2232a;
    private final int f2233b;

    private NetworkSpeed(String str, int i) {
        this.f2232a = str;
        this.f2233b = i;
    }

    public static NetworkSpeed valueOfCode(int i) {
        return i == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.f2233b;
    }

    public String getDesc() {
        return this.f2232a;
    }
}
