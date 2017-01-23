package android.support.v4.text;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.Locale;

public class TextUtilsCompat {
    public static final Locale f696a;
    private static final TextUtilsCompatImpl f697b;
    private static String f698c;
    private static String f699d;

    private static class TextUtilsCompatImpl {
        private TextUtilsCompatImpl() {
        }

        public int m1045a(@Nullable Locale locale) {
            if (!(locale == null || locale.equals(TextUtilsCompat.f696a))) {
                String a = ICUCompat.m1039a(locale);
                if (a == null) {
                    return m1044b(locale);
                }
                if (a.equalsIgnoreCase(TextUtilsCompat.f698c) || a.equalsIgnoreCase(TextUtilsCompat.f699d)) {
                    return 1;
                }
            }
            return 0;
        }

        private static int m1044b(@NonNull Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    private static class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl {
        private TextUtilsCompatJellybeanMr1Impl() {
            super();
        }

        public int m1046a(@Nullable Locale locale) {
            return TextUtilsCompatJellybeanMr1.m1050a(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f697b = new TextUtilsCompatJellybeanMr1Impl();
        } else {
            f697b = new TextUtilsCompatImpl();
        }
        f696a = new Locale("", "");
        f698c = "Arab";
        f699d = "Hebr";
    }

    public static int m1047a(@Nullable Locale locale) {
        return f697b.m1045a(locale);
    }
}
