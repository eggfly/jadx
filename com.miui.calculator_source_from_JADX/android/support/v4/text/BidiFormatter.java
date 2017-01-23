package android.support.v4.text;

import java.util.Locale;

public final class BidiFormatter {
    private static TextDirectionHeuristicCompat f671a;
    private static final String f672b;
    private static final String f673c;
    private static final BidiFormatter f674d;
    private static final BidiFormatter f675e;
    private final boolean f676f;
    private final int f677g;
    private final TextDirectionHeuristicCompat f678h;

    public static final class Builder {
        private boolean f667a;
        private int f668b;
        private TextDirectionHeuristicCompat f669c;

        public Builder() {
            m1031a(BidiFormatter.m1034b(Locale.getDefault()));
        }

        private void m1031a(boolean z) {
            this.f667a = z;
            this.f669c = BidiFormatter.f671a;
            this.f668b = 2;
        }
    }

    private static class DirectionalityEstimator {
        private static final byte[] f670a;

        static {
            f670a = new byte[1792];
            for (int i = 0; i < 1792; i++) {
                f670a[i] = Character.getDirectionality(i);
            }
        }
    }

    static {
        f671a = TextDirectionHeuristicsCompat.f692c;
        f672b = Character.toString('\u200e');
        f673c = Character.toString('\u200f');
        f674d = new BidiFormatter(false, 2, f671a);
        f675e = new BidiFormatter(true, 2, f671a);
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f676f = z;
        this.f677g = i;
        this.f678h = textDirectionHeuristicCompat;
    }

    private static boolean m1034b(Locale locale) {
        return TextUtilsCompat.m1047a(locale) == 1;
    }
}
