package com.google.ads.mediation;

import com.google.android.gms.ads.internal.util.client.C2972b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
/* renamed from: com.google.ads.mediation.h */
public abstract class C2661h {

    /* renamed from: com.google.ads.mediation.h.a */
    public static final class C2665a extends Exception {
        public C2665a(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.google.ads.mediation.h.b */
    protected @interface C2666b {
        String m10254a();

        boolean m10255b() default true;
    }

    protected void m10250a() {
    }

    public void m10251a(Map<String, String> map) {
        Map hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            C2666b c2666b = (C2666b) field.getAnnotation(C2666b.class);
            if (c2666b != null) {
                hashMap.put(c2666b.m10254a(), field);
            }
        }
        if (hashMap.isEmpty()) {
            C2972b.m11583d("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Entry entry : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    C2972b.m11583d("Server option \"" + ((String) entry.getKey()) + "\" could not be set: Illegal Access");
                } catch (IllegalArgumentException e2) {
                    C2972b.m11583d("Server option \"" + ((String) entry.getKey()) + "\" could not be set: Bad Type");
                }
            } else {
                C2972b.m11576a("Unexpected server option: " + ((String) entry.getKey()) + " = \"" + ((String) entry.getValue()) + "\"");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field22 : hashMap.values()) {
            if (((C2666b) field22.getAnnotation(C2666b.class)).m10255b()) {
                C2972b.m11583d("Required server option missing: " + ((C2666b) field22.getAnnotation(C2666b.class)).m10254a());
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((C2666b) field22.getAnnotation(C2666b.class)).m10254a());
            }
        }
        if (stringBuilder.length() > 0) {
            throw new C2665a("Required server option(s) missing: " + stringBuilder.toString());
        }
        m10250a();
    }
}
