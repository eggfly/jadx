package com.miui.support.internal.variable.hook;

import android.app.AlertDialog.Builder;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_App_AlertDialog_Builder_class extends ClassProxy<Builder> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_App_AlertDialog_Builder_class Android_App_AlertDialog_Builder_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_App_AlertDialog_Builder_class.Factory.1 */
        final class C03271 extends SoftReferenceSingleton<Factory> {
            C03271() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03271();
        }

        private Factory() {
            this.Android_App_AlertDialog_Builder_class = (Android_App_AlertDialog_Builder_class) create("Android_App_AlertDialog_Builder_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_App_AlertDialog_Builder_class get() {
            return this.Android_App_AlertDialog_Builder_class;
        }
    }

    public Android_App_AlertDialog_Builder_class() {
        super(Builder.class);
    }
}
