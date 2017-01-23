package com.miui.support.internal.variable;

import android.content.res.AssetManager;
import com.miui.support.util.SoftReferenceSingleton;

public interface Android_Content_Res_AssetManager_class {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Content_Res_AssetManager_class Android_Content_Res_AssetManager_class;

        /* renamed from: com.miui.support.internal.variable.Android_Content_Res_AssetManager_class.Factory.1 */
        final class C03031 extends SoftReferenceSingleton<Factory> {
            C03031() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03031();
        }

        private Factory() {
            this.Android_Content_Res_AssetManager_class = (Android_Content_Res_AssetManager_class) create("Android_Content_Res_AssetManager_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Content_Res_AssetManager_class get() {
            return this.Android_Content_Res_AssetManager_class;
        }
    }

    int addAssetPath(AssetManager assetManager, String str);

    AssetManager newInstance();
}
