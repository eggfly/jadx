package com.miui.support.internal.variable.hook;

import android.content.res.AssetManager;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Content_Res_AssetManager_class extends ClassProxy<AssetManager> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Content_Res_AssetManager_class Android_Content_Res_AssetManager_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Content_Res_AssetManager_class.Factory.1 */
        final class C03311 extends SoftReferenceSingleton<Factory> {
            C03311() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03311();
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

    public Android_Content_Res_AssetManager_class() {
        super(AssetManager.class);
    }
}
