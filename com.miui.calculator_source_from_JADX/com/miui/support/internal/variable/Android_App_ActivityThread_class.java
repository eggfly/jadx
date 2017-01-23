package com.miui.support.internal.variable;

import android.app.Application;

public interface Android_App_ActivityThread_class {

    public static class Factory extends AbsClassFactory {
        private Android_App_ActivityThread_class Android_App_ActivityThread_class;

        private static class Holder {
            static final Factory INSTANCE;

            private Holder() {
            }

            static {
                INSTANCE = new Factory();
            }
        }

        private Factory() {
            this.Android_App_ActivityThread_class = (Android_App_ActivityThread_class) create("Android_App_ActivityThread_class");
        }

        public static Factory getInstance() {
            return Holder.INSTANCE;
        }

        public Android_App_ActivityThread_class get() {
            return this.Android_App_ActivityThread_class;
        }
    }

    Object currentActivityThread();

    Application currentApplication();

    Object getInitialLoadedApk(Object obj);

    String getInitialPackageName(Object obj);
}
