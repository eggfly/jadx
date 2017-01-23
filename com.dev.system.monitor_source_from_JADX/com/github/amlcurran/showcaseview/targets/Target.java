package com.github.amlcurran.showcaseview.targets;

import android.graphics.Point;

public interface Target {
    public static final Target NONE;

    /* renamed from: com.github.amlcurran.showcaseview.targets.Target.1 */
    static class C02471 implements Target {
        C02471() {
        }

        public Point getPoint() {
            return new Point(1000000, 1000000);
        }
    }

    Point getPoint();

    static {
        NONE = new C02471();
    }
}
