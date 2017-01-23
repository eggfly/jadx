package com.miui.support.internal.variable.hook;

import android.view.ViewGroup;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;

public abstract class Android_View_ViewGroup_class extends ClassProxy<ViewGroup> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private Android_View_ViewGroup_class Android_View_ViewGroup_class;

        private static class Holder {
            static final Factory INSTANCE;

            private Holder() {
            }

            static {
                INSTANCE = new Factory();
            }
        }

        private Factory() {
            this.Android_View_ViewGroup_class = (Android_View_ViewGroup_class) create("Android_View_ViewGroup_class");
        }

        public static Factory getInstance() {
            return Holder.INSTANCE;
        }

        public Android_View_ViewGroup_class get() {
            return this.Android_View_ViewGroup_class;
        }
    }

    public Android_View_ViewGroup_class() {
        super(ViewGroup.class);
    }
}
