import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class apf {
    private Locale effectiveLocale;
    private ResourceBundle resourceBundle;

    void j6(Locale locale) {
        Class cls = getClass();
        try {
            this.resourceBundle = ResourceBundle.getBundle(cls.getName(), locale);
            this.effectiveLocale = this.resourceBundle.getLocale();
            for (Field field : cls.getFields()) {
                if (field.getType().equals(String.class)) {
                    try {
                        field.set(this, this.resourceBundle.getString(field.getName()));
                    } catch (Exception e) {
                        throw new ama(cls, locale, field.getName(), e);
                    } catch (Throwable e2) {
                        throw new Error(e2);
                    } catch (Throwable e22) {
                        throw new Error(e22);
                    }
                }
            }
        } catch (Exception e3) {
            throw new alz(cls, locale, e3);
        }
    }
}
