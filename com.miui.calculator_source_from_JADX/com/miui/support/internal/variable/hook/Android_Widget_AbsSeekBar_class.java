package com.miui.support.internal.variable.hook;

import android.widget.AbsSeekBar;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Widget_AbsSeekBar_class extends ClassProxy<AbsSeekBar> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Widget_AbsSeekBar_class Android_Widget_AbsSeekBar_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Widget_AbsSeekBar_class.Factory.1 */
        final class C03431 extends SoftReferenceSingleton<Factory> {
            C03431() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03431();
        }

        private Factory() {
            this.Android_Widget_AbsSeekBar_class = (Android_Widget_AbsSeekBar_class) create("Android_Widget_AbsSeekBar_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Widget_AbsSeekBar_class get() {
            return this.Android_Widget_AbsSeekBar_class;
        }
    }

    public Android_Widget_AbsSeekBar_class() {
        super(AbsSeekBar.class);
    }
}
