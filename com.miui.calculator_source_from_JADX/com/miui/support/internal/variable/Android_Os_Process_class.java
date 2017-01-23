package com.miui.support.internal.variable;

import com.miui.support.util.SoftReferenceSingleton;

public interface Android_Os_Process_class {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Os_Process_class Android_Os_Process_class;

        /* renamed from: com.miui.support.internal.variable.Android_Os_Process_class.Factory.1 */
        final class C03181 extends SoftReferenceSingleton<Factory> {
            C03181() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03181();
        }

        private Factory() {
            this.Android_Os_Process_class = (Android_Os_Process_class) create("Android_Os_Process_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Os_Process_class get() {
            return this.Android_Os_Process_class;
        }
    }

    long getFreeMemory();

    long getTotalMemory();
}
