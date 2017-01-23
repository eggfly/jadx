package anet.channel.strategy;

public class StrategyCenter {
    private static volatile IStrategyInstance instance;

    static {
        instance = null;
    }

    private StrategyCenter() {
    }

    public static IStrategyInstance getInstance() {
        if (instance == null) {
            synchronized (StrategyCenter.class) {
                if (instance == null) {
                    instance = new C0726i();
                }
            }
        }
        return instance;
    }

    public static void setInstance(IStrategyInstance iStrategyInstance) {
        instance = iStrategyInstance;
    }
}
