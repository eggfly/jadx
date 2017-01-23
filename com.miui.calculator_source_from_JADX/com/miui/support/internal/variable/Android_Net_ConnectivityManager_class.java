package com.miui.support.internal.variable;

import android.net.ConnectivityManager;
import com.miui.support.util.SoftReferenceSingleton;

public interface Android_Net_ConnectivityManager_class {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Net_ConnectivityManager_class Android_Net_ConnectivityManager_class;

        /* renamed from: com.miui.support.internal.variable.Android_Net_ConnectivityManager_class.Factory.1 */
        final class C03161 extends SoftReferenceSingleton<Factory> {
            C03161() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03161();
        }

        private Factory() {
            this.Android_Net_ConnectivityManager_class = (Android_Net_ConnectivityManager_class) create("Android_Net_ConnectivityManager_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Net_ConnectivityManager_class get() {
            return this.Android_Net_ConnectivityManager_class;
        }
    }

    boolean isNetworkSupported(ConnectivityManager connectivityManager, int i);
}
