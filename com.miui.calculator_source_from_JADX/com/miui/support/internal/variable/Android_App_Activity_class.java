package com.miui.support.internal.variable;

import android.app.Activity;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_App_Activity_class {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_App_Activity_class Android_App_Activity_class;

        /* renamed from: com.miui.support.internal.variable.Android_App_Activity_class.Factory.1 */
        final class C02971 extends SoftReferenceSingleton<Factory> {
            C02971() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C02971();
        }

        private Factory() {
            this.Android_App_Activity_class = (Android_App_Activity_class) create("Android_App_Activity_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_App_Activity_class get() {
            return this.Android_App_Activity_class;
        }
    }

    public abstract void convertFromTranslucent(Activity activity);

    public abstract void convertToTranslucent(Activity activity);
}
