package android.support.v4.text;

public class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat f690a;
    public static final TextDirectionHeuristicCompat f691b;
    public static final TextDirectionHeuristicCompat f692c;
    public static final TextDirectionHeuristicCompat f693d;
    public static final TextDirectionHeuristicCompat f694e;
    public static final TextDirectionHeuristicCompat f695f;

    private interface TextDirectionAlgorithm {
    }

    private static class AnyStrong implements TextDirectionAlgorithm {
        public static final AnyStrong f683a;
        public static final AnyStrong f684b;
        private final boolean f685c;

        private AnyStrong(boolean z) {
            this.f685c = z;
        }

        static {
            f683a = new AnyStrong(true);
            f684b = new AnyStrong(false);
        }
    }

    private static class FirstStrong implements TextDirectionAlgorithm {
        public static final FirstStrong f686a;

        private FirstStrong() {
        }

        static {
            f686a = new FirstStrong();
        }
    }

    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm f687a;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f687a = textDirectionAlgorithm;
        }
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean f688a;

        private TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.f688a = z;
        }
    }

    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static final TextDirectionHeuristicLocale f689a;

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        static {
            f689a = new TextDirectionHeuristicLocale();
        }
    }

    static {
        f690a = new TextDirectionHeuristicInternal(false, null);
        f691b = new TextDirectionHeuristicInternal(true, null);
        f692c = new TextDirectionHeuristicInternal(false, null);
        f693d = new TextDirectionHeuristicInternal(true, null);
        f694e = new TextDirectionHeuristicInternal(false, null);
        f695f = TextDirectionHeuristicLocale.f689a;
    }
}
