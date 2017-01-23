package com.google.android.gms.p151a;

import android.os.IBinder;
import com.google.android.gms.p151a.C2687a.C2689a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.a.b */
public final class C2690b<T> extends C2689a {
    private final T f9223a;

    private C2690b(T t) {
        this.f9223a = t;
    }

    public static <T> C2687a m10262a(T t) {
        return new C2690b(t);
    }

    public static <T> T m10263a(C2687a c2687a) {
        if (c2687a instanceof C2690b) {
            return ((C2690b) c2687a).f9223a;
        }
        IBinder asBinder = c2687a.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
