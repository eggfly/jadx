package com.miui.support.internal.variable;

import android.graphics.drawable.Drawable;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Graphics_Drawable_AnimatedRotateDrawable_class extends Android_Graphics_Drawable_Drawable_class {
    public static final String NAME = "android.graphics.drawable.AnimatedRotateDrawable";

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Graphics_Drawable_AnimatedRotateDrawable_class Android_Graphics_Drawable_AnimatedRotateDrawable_class;

        /* renamed from: com.miui.support.internal.variable.Android_Graphics_Drawable_AnimatedRotateDrawable_class.Factory.1 */
        final class C03091 extends SoftReferenceSingleton<Factory> {
            C03091() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03091();
        }

        private Factory() {
            this.Android_Graphics_Drawable_AnimatedRotateDrawable_class = (Android_Graphics_Drawable_AnimatedRotateDrawable_class) create("Android_Graphics_Drawable_AnimatedRotateDrawable_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Graphics_Drawable_AnimatedRotateDrawable_class get() {
            return this.Android_Graphics_Drawable_AnimatedRotateDrawable_class;
        }
    }

    public abstract void setFramesCount(Drawable drawable, int i);

    public abstract void setFramesDuration(Drawable drawable, int i);

    public abstract void start(Drawable drawable);

    public abstract void stop(Drawable drawable);
}
