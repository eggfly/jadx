package com.miui.support.internal.variable;

import android.graphics.drawable.Drawable;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class Android_Graphics_Drawable_Drawable_class {
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    private static final Map<Drawable, Integer> mIdField;

    public static class Factory extends AbsClassFactory {
        private Android_Graphics_Drawable_Drawable_class Android_Graphics_Drawable_Drawable_class;

        private static class Holder {
            static final Factory INSTANCE;

            private Holder() {
            }

            static {
                INSTANCE = new Factory();
            }
        }

        private Factory() {
            this.Android_Graphics_Drawable_Drawable_class = (Android_Graphics_Drawable_Drawable_class) create("Android_Graphics_Drawable_Drawable_class");
        }

        public static Factory getInstance() {
            return Holder.INSTANCE;
        }

        public Android_Graphics_Drawable_Drawable_class get() {
            return this.Android_Graphics_Drawable_Drawable_class;
        }
    }

    public abstract int getLayoutDirection(Drawable drawable);

    static {
        mIdField = new WeakHashMap();
    }

    public int getId(Drawable drawable) {
        Integer num = (Integer) mIdField.get(drawable);
        return num == null ? LAYOUT_DIRECTION_LTR : num.intValue();
    }

    public void setId(Drawable drawable, int i) {
        mIdField.put(drawable, Integer.valueOf(i));
    }
}
