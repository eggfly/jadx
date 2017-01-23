package com.miui.support.internal.variable;

import android.widget.PopupWindow;
import com.miui.support.reflect.Method;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Widget_PopupWindow_class {
    protected static Method setLayoutInScreenEnabled;
    protected static Method setLayoutInsetDecor;

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Widget_PopupWindow_class Android_Widget_PopupWindow_class;

        /* renamed from: com.miui.support.internal.variable.Android_Widget_PopupWindow_class.Factory.1 */
        final class C03221 extends SoftReferenceSingleton<Factory> {
            C03221() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03221();
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

    public abstract void setFitsSystemWindows(PopupWindow popupWindow);

    public abstract void setLayoutInScreenEnabled(PopupWindow popupWindow, boolean z);

    public abstract void setLayoutInsetDecor(PopupWindow popupWindow, boolean z);

    static {
        try {
            setLayoutInScreenEnabled = Method.of(PopupWindow.class, "setLayoutInScreenEnabled", "(Z)V");
            setLayoutInsetDecor = Method.of(PopupWindow.class, "setLayoutInsetDecor", "(Z)V");
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("no such method", e);
        }
    }
}
