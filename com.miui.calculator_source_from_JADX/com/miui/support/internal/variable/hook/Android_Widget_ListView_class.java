package com.miui.support.internal.variable.hook;

import android.widget.ListView;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Widget_ListView_class extends ClassProxy<ListView> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Widget_ListView_class Android_Widget_ListView_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Widget_ListView_class.Factory.1 */
        final class C03511 extends SoftReferenceSingleton<Factory> {
            C03511() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03511();
        }

        private Factory() {
            this.Android_Widget_ListView_class = (Android_Widget_ListView_class) create("Android_Widget_ListView_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Widget_ListView_class get() {
            return this.Android_Widget_ListView_class;
        }
    }

    public Android_Widget_ListView_class() {
        super(ListView.class);
    }
}
