package com.miui.support.internal.log.format;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Calendar;

public class SimpleFormatter implements Formatter {
    private ThreadLocal<ThreadCache> f2531a;

    /* renamed from: com.miui.support.internal.log.format.SimpleFormatter.1 */
    class C02861 extends ThreadLocal<ThreadCache> {
        final /* synthetic */ SimpleFormatter f2524a;

        C02861(SimpleFormatter simpleFormatter) {
            this.f2524a = simpleFormatter;
        }

        protected /* synthetic */ Object initialValue() {
            return m4206a();
        }

        protected ThreadCache m4206a() {
            return new ThreadCache();
        }
    }

    private static class CachedDateFormat {
        private StringBuilder f2525a;
        private Calendar f2526b;

        private CachedDateFormat() {
            this.f2525a = new StringBuilder();
            this.f2526b = Calendar.getInstance();
        }
    }

    private static class StringBuilderWriter extends Writer {
        private StringBuilder f2527a;

        public StringBuilderWriter(StringBuilder stringBuilder) {
            this.f2527a = stringBuilder;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(char[] cArr, int i, int i2) {
            m4207a(cArr.length, i, i2);
            if (i2 != 0) {
                this.f2527a.append(cArr, i, i2);
            }
        }

        private static void m4207a(int i, int i2, int i3) {
            if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
                throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + i2 + "; regionLength=" + i3);
            }
        }
    }

    private static class ThreadCache {
        CachedDateFormat f2528a;
        StringBuilder f2529b;
        PrintWriter f2530c;

        ThreadCache() {
            this.f2528a = new CachedDateFormat();
            this.f2529b = new StringBuilder();
            this.f2530c = new PrintWriter(new StringBuilderWriter(this.f2529b));
        }
    }

    public SimpleFormatter() {
        this.f2531a = new C02861(this);
    }
}
