package com.miui.support.internal.variable.hook;

import android.preference.Preference;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Preference_Preference_class extends ClassProxy<Preference> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Preference_Preference_class Android_Preference_Preference_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Preference_Preference_class.Factory.1 */
        final class C03371 extends SoftReferenceSingleton<Factory> {
            C03371() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03371();
        }

        private Factory() {
            this.Android_Preference_Preference_class = (Android_Preference_Preference_class) create("Android_Preference_Preference_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Preference_Preference_class get() {
            return this.Android_Preference_Preference_class;
        }
    }

    public Android_Preference_Preference_class() {
        super(Preference.class);
    }
}
