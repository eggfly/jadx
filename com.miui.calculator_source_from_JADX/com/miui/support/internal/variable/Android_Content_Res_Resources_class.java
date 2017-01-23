package com.miui.support.internal.variable;

import android.content.res.AssetManager;
import android.content.res.Resources;
import com.miui.support.util.SoftReferenceSingleton;

public interface Android_Content_Res_Resources_class {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Content_Res_Resources_class Android_Content_Res_Resources_class;

        /* renamed from: com.miui.support.internal.variable.Android_Content_Res_Resources_class.Factory.1 */
        final class C03051 extends SoftReferenceSingleton<Factory> {
            C03051() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03051();
        }

        private Factory() {
            this.Android_Content_Res_Resources_class = (Android_Content_Res_Resources_class) create("Android_Content_Res_Resources_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Content_Res_Resources_class get() {
            return this.Android_Content_Res_Resources_class;
        }
    }

    void setAssetManager(Resources resources, AssetManager assetManager);
}
