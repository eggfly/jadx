package com.miui.support.internal.variable.hook;

import android.app.AlertDialog;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_App_AlertDialog_class extends ClassProxy<AlertDialog> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_App_AlertDialog_class Android_App_AlertDialog_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_App_AlertDialog_class.Factory.1 */
        final class C03291 extends SoftReferenceSingleton<Factory> {
            C03291() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03291();
        }

        private Factory() {
            this.Android_App_AlertDialog_class = (Android_App_AlertDialog_class) create("Android_App_AlertDialog_class");
            com.miui.support.internal.variable.hook.Android_App_AlertDialog_Builder_class.Factory.getInstance().getClass();
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_App_AlertDialog_class get() {
            return this.Android_App_AlertDialog_class;
        }
    }

    public Android_App_AlertDialog_class() {
        super(AlertDialog.class);
    }
}
