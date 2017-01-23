package com.miui.support.internal.variable;

import android.view.Window;
import com.miui.support.reflect.Method;

public abstract class Android_View_Window_class {
    protected static Method setExtraFlags;

    public static class Factory extends AbsClassFactory {
        private Android_View_Window_class Android_View_Window_class;

        private static final class Holder {
            static final Factory INSTANCE;

            private Holder() {
            }

            static {
                INSTANCE = new Factory();
            }
        }

        private Factory() {
            this.Android_View_Window_class = (Android_View_Window_class) create("Android_View_Window_class");
        }

        public static Factory getInstance() {
            return Holder.INSTANCE;
        }

        public Android_View_Window_class get() {
            return this.Android_View_Window_class;
        }
    }

    public abstract boolean setTranslucentStatus(Window window, int i);

    static {
        try {
            setExtraFlags = Method.of(Window.class, "setExtraFlags", "(II)V");
        } catch (Exception e) {
            setExtraFlags = null;
        }
    }
}
