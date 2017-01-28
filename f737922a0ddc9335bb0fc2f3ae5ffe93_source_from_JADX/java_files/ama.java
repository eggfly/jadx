import java.util.Locale;

public class ama extends aly {
    private final String j6;

    public ama(Class cls, Locale locale, String str, Exception exception) {
        super("Translation missing for [" + cls.getName() + ", " + locale.toString() + ", " + str + "]", cls, locale, exception);
        this.j6 = str;
    }
}
