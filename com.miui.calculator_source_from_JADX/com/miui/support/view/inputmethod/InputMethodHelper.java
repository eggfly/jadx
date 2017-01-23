package com.miui.support.view.inputmethod;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.miui.support.util.AppConstants;
import com.miui.support.util.SoftReferenceSingleton;

public class InputMethodHelper {
    private static final SoftReferenceSingleton<InputMethodHelper> f3934a;
    private InputMethodManager f3935b;

    /* renamed from: com.miui.support.view.inputmethod.InputMethodHelper.1 */
    final class C04501 extends SoftReferenceSingleton<InputMethodHelper> {
        C04501() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5660a();
        }

        protected InputMethodHelper m5660a() {
            return new InputMethodHelper();
        }
    }

    static {
        f3934a = new C04501();
    }

    private InputMethodHelper() {
        this.f3935b = (InputMethodManager) AppConstants.m4227a().getSystemService("input_method");
    }

    public static InputMethodHelper m5661a() {
        return (InputMethodHelper) f3934a.get();
    }

    public InputMethodManager m5663b() {
        return this.f3935b;
    }

    public void m5662a(EditText editText) {
        editText.requestFocus();
        this.f3935b.viewClicked(editText);
        this.f3935b.showSoftInput(editText, 0);
    }

    public void m5664b(EditText editText) {
        this.f3935b.hideSoftInputFromInputMethod(editText.getWindowToken(), 0);
    }
}
