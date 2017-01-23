import java.util.Locale;

public class alz extends aly {
    public alz(Class cls, Locale locale, Exception exception) {
        super("Loading of translation bundle failed for [" + cls.getName() + ", " + locale.toString() + "]", cls, locale, exception);
    }
}
