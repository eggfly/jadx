package com.miui.support.internal.variable.hook;

import android.widget.PopupWindow;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Widget_PopupWindow_class extends ClassProxy<PopupWindow> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Widget_PopupWindow_class Android_Widget_PopupWindow_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Widget_PopupWindow_class.Factory.1 */
        final class C03531 extends SoftReferenceSingleton<Factory> {
            C03531() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03531();
        }

        private Factory() {
            this.Android_Widget_PopupWindow_class = (Android_Widget_PopupWindow_class) create("Android_Widget_PopupWindow_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Widget_PopupWindow_class get() {
            return this.Android_Widget_PopupWindow_class;
        }
    }

    public Android_Widget_PopupWindow_class() {
        super(PopupWindow.class);
    }
}
