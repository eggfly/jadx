package anet.channel.strategy;

import java.io.File;

/* renamed from: anet.channel.strategy.f */
class C0723f implements Runnable {
    final /* synthetic */ String f2369a;
    final /* synthetic */ StrategyInfoHolder f2370b;

    C0723f(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f2370b = strategyInfoHolder;
        this.f2369a = str;
    }

    public void run() {
        int i = 0;
        try {
            File[] c = C0732l.m2947c();
            if (c != null) {
                for (int i2 = 0; i2 < c.length && i < 2; i2++) {
                    String name = c[i2].getName();
                    if (!(name.equals(this.f2369a) || name.equals("config"))) {
                        this.f2370b.m2885a(name, null);
                        i++;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
