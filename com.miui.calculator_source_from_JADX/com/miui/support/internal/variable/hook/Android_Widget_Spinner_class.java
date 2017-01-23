package com.miui.support.internal.variable.hook;

import android.widget.Spinner;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;
import com.miui.support.widget.ArrowPopupWindow;

public abstract class Android_Widget_Spinner_class extends ClassProxy<Spinner> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Widget_Spinner_class Android_Widget_Spinner_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Widget_Spinner_class.Factory.1 */
        final class C03571 extends SoftReferenceSingleton<Factory> {
            C03571() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03571();
        }

        private Factory() {
            this.Android_Widget_Spinner_class = (Android_Widget_Spinner_class) create("Android_Widget_Spinner_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Widget_Spinner_class get() {
            return this.Android_Widget_Spinner_class;
        }
    }

    protected abstract ArrowPopupWindow getArrowPopupWindow(Spinner spinner);

    public Android_Widget_Spinner_class() {
        super(Spinner.class);
    }

    public void buildProxy() {
        attachMethod("setPrompt", "(Ljava/lang/CharSequence;)V");
    }

    protected void handle() {
        handleSetPrompt(0, null, null);
    }

    protected void handleSetPrompt(long j, Spinner spinner, CharSequence charSequence) {
        ArrowPopupWindow arrowPopupWindow = getArrowPopupWindow(spinner);
        if (arrowPopupWindow != null) {
            arrowPopupWindow.m5690a(charSequence);
        } else {
            originalSetPrompt(j, spinner, charSequence);
        }
    }

    protected void originalSetPrompt(long j, Spinner spinner, CharSequence charSequence) {
        throw new IllegalStateException("com.miui.internal.variable.hook.Android_Widget_Spinner_class.originalSetPrompt(long, Spinner, CharSequence)");
    }
}
