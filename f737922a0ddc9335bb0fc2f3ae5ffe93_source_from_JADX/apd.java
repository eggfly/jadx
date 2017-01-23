import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class apd {
    private static final Map<Locale, Map<Class, apf>> j6;

    static {
        j6 = new HashMap();
    }

    static synchronized <T extends apf> T j6(Locale locale, Class<T> cls) {
        T t;
        synchronized (apd.class) {
            try {
                Map map;
                Map map2 = (Map) j6.get(locale);
                if (map2 == null) {
                    HashMap hashMap = new HashMap();
                    j6.put(locale, hashMap);
                    map = hashMap;
                } else {
                    map = map2;
                }
                t = (apf) map.get(cls);
                if (t == null) {
                    t = (apf) cls.newInstance();
                    t.j6(locale);
                    map.put(cls, t);
                }
            } catch (Throwable e) {
                throw new Error(e);
            } catch (Throwable e2) {
                throw new Error(e2);
            }
        }
        return t;
    }
}
