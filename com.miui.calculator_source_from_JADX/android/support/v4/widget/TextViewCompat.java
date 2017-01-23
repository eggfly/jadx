package android.support.v4.widget;

import android.os.Build.VERSION;

public class TextViewCompat {
    static final TextViewCompatImpl f1271a;

    interface TextViewCompatImpl {
    }

    static class BaseTextViewCompatImpl implements TextViewCompatImpl {
        BaseTextViewCompatImpl() {
        }
    }

    static class JbMr1TextViewCompatImpl extends BaseTextViewCompatImpl {
        JbMr1TextViewCompatImpl() {
        }
    }

    static class JbMr2TextViewCompatImpl extends JbMr1TextViewCompatImpl {
        JbMr2TextViewCompatImpl() {
        }
    }

    private TextViewCompat() {
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            f1271a = new JbMr2TextViewCompatImpl();
        } else if (i >= 17) {
            f1271a = new JbMr1TextViewCompatImpl();
        } else {
            f1271a = new BaseTextViewCompatImpl();
        }
    }
}
