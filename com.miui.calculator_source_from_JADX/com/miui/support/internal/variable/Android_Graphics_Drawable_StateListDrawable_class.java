package com.miui.support.internal.variable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Graphics_Drawable_StateListDrawable_class extends Android_Graphics_Drawable_Drawable_class {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Graphics_Drawable_StateListDrawable_class Android_Graphics_Drawable_StateListDrawable_class;

        /* renamed from: com.miui.support.internal.variable.Android_Graphics_Drawable_StateListDrawable_class.Factory.1 */
        final class C03121 extends SoftReferenceSingleton<Factory> {
            C03121() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03121();
        }

        private Factory() {
            this.Android_Graphics_Drawable_StateListDrawable_class = (Android_Graphics_Drawable_StateListDrawable_class) create("Android_Graphics_Drawable_StateListDrawable_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Graphics_Drawable_StateListDrawable_class get() {
            return this.Android_Graphics_Drawable_StateListDrawable_class;
        }
    }

    public abstract int getStateCount(StateListDrawable stateListDrawable);

    public abstract Drawable getStateDrawable(StateListDrawable stateListDrawable, int i);

    public abstract int[] getStateSet(StateListDrawable stateListDrawable, int i);
}
