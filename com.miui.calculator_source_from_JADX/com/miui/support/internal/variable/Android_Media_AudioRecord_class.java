package com.miui.support.internal.variable;

import android.media.AudioRecord;
import com.miui.support.util.SoftReferenceSingleton;

public interface Android_Media_AudioRecord_class {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Media_AudioRecord_class Android_Media_AudioRecord_class;

        /* renamed from: com.miui.support.internal.variable.Android_Media_AudioRecord_class.Factory.1 */
        final class C03141 extends SoftReferenceSingleton<Factory> {
            C03141() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03141();
        }

        private Factory() {
            this.Android_Media_AudioRecord_class = (Android_Media_AudioRecord_class) create("Android_Media_AudioRecord_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Media_AudioRecord_class get() {
            return this.Android_Media_AudioRecord_class;
        }
    }

    boolean isExtraParamSupported();

    int setParameters(AudioRecord audioRecord, String str);
}
