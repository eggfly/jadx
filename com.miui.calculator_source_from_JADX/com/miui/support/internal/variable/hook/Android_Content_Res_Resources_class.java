package com.miui.support.internal.variable.hook;

import android.content.res.Resources;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Content_Res_Resources_class extends ClassProxy<Resources> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Content_Res_Resources_class Android_Content_Res_Resources_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Content_Res_Resources_class.Factory.1 */
        final class C03331 extends SoftReferenceSingleton<Factory> {
            C03331() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03331();
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

    public Android_Content_Res_Resources_class() {
        super(Resources.class);
    }
}
