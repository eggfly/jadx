package com.miui.support.internal.variable.hook;

import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Widget_ListPopupWindow_class extends ClassProxy<ListPopupWindow> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Widget_ListPopupWindow_class Android_Widget_ListPopupWindow_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Widget_ListPopupWindow_class.Factory.1 */
        final class C03491 extends SoftReferenceSingleton<Factory> {
            C03491() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03491();
        }

        private Factory() {
            this.Android_Widget_ListPopupWindow_class = (Android_Widget_ListPopupWindow_class) create("Android_Widget_ListPopupWindow_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Widget_ListPopupWindow_class get() {
            return this.Android_Widget_ListPopupWindow_class;
        }
    }

    protected abstract void setPopupWindow(ListPopupWindow listPopupWindow, PopupWindow popupWindow);

    public Android_Widget_ListPopupWindow_class() {
        super(ListPopupWindow.class);
    }
}
