package com.miui.support.internal.variable.hook;

import android.widget.GridView;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Widget_GridView_class extends ClassProxy<GridView> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Widget_GridView_class Android_Widget_GridView_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Widget_GridView_class.Factory.1 */
        final class C03471 extends SoftReferenceSingleton<Factory> {
            C03471() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03471();
        }

        private Factory() {
            this.Android_Widget_GridView_class = (Android_Widget_GridView_class) create("Android_Widget_GridView_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Widget_GridView_class get() {
            return this.Android_Widget_GridView_class;
        }
    }

    public Android_Widget_GridView_class() {
        super(GridView.class);
    }
}
