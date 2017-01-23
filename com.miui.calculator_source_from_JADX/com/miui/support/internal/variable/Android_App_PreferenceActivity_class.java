package com.miui.support.internal.variable;

import android.app.Activity;
import android.os.Bundle;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_App_PreferenceActivity_class {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_App_PreferenceActivity_class Android_App_PreferenceActivity_class;

        /* renamed from: com.miui.support.internal.variable.Android_App_PreferenceActivity_class.Factory.1 */
        final class C03011 extends SoftReferenceSingleton<Factory> {
            C03011() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03011();
        }

        private Factory() {
            this.Android_App_PreferenceActivity_class = (Android_App_PreferenceActivity_class) create("Android_App_PreferenceActivity_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_App_PreferenceActivity_class get() {
            return this.Android_App_PreferenceActivity_class;
        }
    }

    public abstract void onCreate(Activity activity, Bundle bundle);
}
