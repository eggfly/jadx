package com.miui.support.internal.variable.hook;

import android.preference.EditTextPreference;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public class Android_Preference_EditTextPreference_class extends ClassProxy<EditTextPreference> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Preference_EditTextPreference_class Android_Preference_EditTextPreference_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Preference_EditTextPreference_class.Factory.1 */
        final class C03351 extends SoftReferenceSingleton<Factory> {
            C03351() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03351();
        }

        private Factory() {
            this.Android_Preference_EditTextPreference_class = new Android_Preference_EditTextPreference_class();
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Preference_EditTextPreference_class get() {
            return this.Android_Preference_EditTextPreference_class;
        }
    }

    public Android_Preference_EditTextPreference_class() {
        super(EditTextPreference.class);
    }

    public void buildProxy() {
        attachMethod("onAddEditTextToDialogView", "(Landroid/view/View;Landroid/widget/EditText;)V");
    }

    protected void handle() {
        handleOnAddEditTextToDialogView(0, null, null, null);
    }

    protected void handleOnAddEditTextToDialogView(long j, EditTextPreference editTextPreference, View view, EditText editText) {
        originalOnAddEditTextToDialogView(j, editTextPreference, view, editText);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(C0264R.id.edittext_container);
        if (viewGroup != null) {
            viewGroup.addView(editText, -1, -2);
        }
    }

    protected void originalOnAddEditTextToDialogView(long j, EditTextPreference editTextPreference, View view, EditText editText) {
        throw new IllegalStateException("com.miui.internal.variable.hook.Android_Preference_EditTextPreference_class.originalOnAddEditTextToDialogView(long, EditTextPreference, View, EditText)");
    }
}
