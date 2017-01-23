package com.miui.support.internal.log.appender;

import com.miui.support.internal.log.Level;

public class LogcatAppender implements Appender {
    private ThreadLocal<StringBuilder> f2520a;

    /* renamed from: com.miui.support.internal.log.appender.LogcatAppender.1 */
    class C02841 extends ThreadLocal<StringBuilder> {
        final /* synthetic */ LogcatAppender f2518a;

        C02841(LogcatAppender logcatAppender) {
            this.f2518a = logcatAppender;
        }

        protected /* synthetic */ Object initialValue() {
            return m4202a();
        }

        protected StringBuilder m4202a() {
            return new StringBuilder();
        }
    }

    /* renamed from: com.miui.support.internal.log.appender.LogcatAppender.2 */
    /* synthetic */ class C02852 {
        static final /* synthetic */ int[] f2519a;

        static {
            f2519a = new int[Level.values().length];
            try {
                f2519a[Level.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2519a[Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2519a[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2519a[Level.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2519a[Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2519a[Level.FATAL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public LogcatAppender() {
        this.f2520a = new C02841(this);
    }
}
