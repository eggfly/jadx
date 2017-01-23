package com.miui.support.internal.log.util;

import java.util.Formatter;
import java.util.Locale;

public class AppendableFormatter {
    private Formatter f2540a;
    private AppendableWrapper f2541b;

    private static class AppendableWrapper implements Appendable {
        private Appendable f2539a;

        private AppendableWrapper() {
        }

        public Appendable append(char c) {
            this.f2539a.append(c);
            return this;
        }

        public Appendable append(CharSequence charSequence) {
            this.f2539a.append(charSequence);
            return this;
        }

        public Appendable append(CharSequence charSequence, int i, int i2) {
            this.f2539a.append(charSequence, i, i2);
            return this;
        }
    }

    public AppendableFormatter() {
        this(Locale.US);
    }

    public AppendableFormatter(Locale locale) {
        this.f2541b = new AppendableWrapper();
        this.f2540a = new Formatter(this.f2541b, locale);
    }
}
