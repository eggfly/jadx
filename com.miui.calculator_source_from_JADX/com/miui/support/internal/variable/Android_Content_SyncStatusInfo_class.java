package com.miui.support.internal.variable;

import com.miui.support.util.SoftReferenceSingleton;

public interface Android_Content_SyncStatusInfo_class {
    public static final String NAME = "android.content.SyncStatusInfo";

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Content_SyncStatusInfo_class Android_Content_SyncStatusInfo_class;

        /* renamed from: com.miui.support.internal.variable.Android_Content_SyncStatusInfo_class.Factory.1 */
        final class C03071 extends SoftReferenceSingleton<Factory> {
            C03071() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03071();
        }

        private Factory() {
            this.Android_Content_SyncStatusInfo_class = (Android_Content_SyncStatusInfo_class) create("Android_Content_SyncStatusInfo_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Content_SyncStatusInfo_class get() {
            return this.Android_Content_SyncStatusInfo_class;
        }
    }

    boolean getInitialize(Object obj);

    int getLastFailureMesgAsInt(Object obj, int i);

    long getLastFailureTime(Object obj);

    long getLastSuccessTime(Object obj);

    boolean getPending(Object obj);
}
