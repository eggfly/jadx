package com.miui.support.internal.variable.hook;

import android.app.Activity;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_App_Activity_class extends ClassProxy<Activity> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_App_Activity_class Android_App_Activity_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_App_Activity_class.Factory.1 */
        final class C03251 extends SoftReferenceSingleton<Factory> {
            C03251() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03251();
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

    public Android_App_Activity_class() {
        super(Activity.class);
    }
}
