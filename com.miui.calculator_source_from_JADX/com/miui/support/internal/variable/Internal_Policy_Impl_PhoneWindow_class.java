package com.miui.support.internal.variable;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;

public abstract class Internal_Policy_Impl_PhoneWindow_class {
    private static final String PhoneWindow_ClassName;
    protected static final Class<? extends Object> TARGET_CLASS;

    public static class Factory extends AbsClassFactory {
        private Internal_Policy_Impl_PhoneWindow_class Internal_Policy_Impl_PhoneWindow_class;

        private static class Holder {
            static final Factory INSTANCE;

            private Holder() {
            }

            static {
                INSTANCE = new Factory();
            }
        }

        private Factory() {
            this.Internal_Policy_Impl_PhoneWindow_class = (Internal_Policy_Impl_PhoneWindow_class) create("Internal_Policy_Impl_PhoneWindow_class");
        }

        public static Factory getInstance() {
            return Holder.INSTANCE;
        }

        public Internal_Policy_Impl_PhoneWindow_class get() {
            return this.Internal_Policy_Impl_PhoneWindow_class;
        }
    }

    public abstract LayoutInflater replaceLayoutInflater(Window window);

    public abstract void restoreLayoutInflater(Window window, LayoutInflater layoutInflater);

    static {
        PhoneWindow_ClassName = VERSION.SDK_INT >= 23 ? "com.android.internal.policy.PhoneWindow" : "com.android.internal.policy.impl.PhoneWindow";
        TARGET_CLASS = getTargetClass();
    }

    private static Class<? extends Object> getTargetClass() {
        try {
            return Class.forName(PhoneWindow_ClassName);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow(PhoneWindow_ClassName, e);
            return null;
        }
    }
}
