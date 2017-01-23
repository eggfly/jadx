package com.miui.support.internal.variable.hook;

import android.widget.AbsSpinner;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Widget_AbsSpinner_class extends ClassProxy<AbsSpinner> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Widget_AbsSpinner_class Android_Widget_AbsSpinner_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Widget_AbsSpinner_class.Factory.1 */
        final class C03451 extends SoftReferenceSingleton<Factory> {
            C03451() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03451();
        }

        private Factory() {
            this.Android_Widget_AbsSpinner_class = (Android_Widget_AbsSpinner_class) create("Android_Widget_AbsSpinner_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Widget_AbsSpinner_class get() {
            return this.Android_Widget_AbsSpinner_class;
        }
    }

    public Android_Widget_AbsSpinner_class() {
        super(AbsSpinner.class);
    }
}
