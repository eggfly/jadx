package com.miui.support.internal.variable;

import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import com.miui.support.util.SoftReferenceSingleton;

public interface Android_App_LoadedApk_class {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_App_LoadedApk_class Android_App_LoadedApk_class;

        /* renamed from: com.miui.support.internal.variable.Android_App_LoadedApk_class.Factory.1 */
        final class C02991 extends SoftReferenceSingleton<Factory> {
            C02991() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C02991();
        }

        private Factory() {
            this.Android_App_LoadedApk_class = (Android_App_LoadedApk_class) create("Android_App_LoadedApk_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_App_LoadedApk_class get() {
            return this.Android_App_LoadedApk_class;
        }
    }

    ApplicationInfo getApplicationInfo(Object obj);

    Resources getResources(Object obj);
}
