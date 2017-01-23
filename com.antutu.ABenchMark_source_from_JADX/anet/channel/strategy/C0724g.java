package anet.channel.strategy;

/* renamed from: anet.channel.strategy.g */
class C0724g implements Runnable {
    final /* synthetic */ String f2371a;
    final /* synthetic */ StrategyInfoHolder f2372b;

    C0724g(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f2372b = strategyInfoHolder;
        this.f2371a = str;
    }

    public void run() {
        this.f2372b.m2885a(StrategyInfoHolder.m2887b(this.f2371a), this.f2371a);
    }
}
