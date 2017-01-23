package com.miui.calculator.common.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.miui.calculator.CalculatorApplication;
import com.miui.support.internal.C0264R;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;

public class CalculatorUtils {
    private static HashMap<String, Typeface> f1522a;
    private static Typeface f1523b;
    private static Typeface f1524c;

    static {
        f1522a = new HashMap();
        f1523b = Typeface.create("miui-light", 0);
        f1524c = Typeface.create("miui", 0);
    }

    public static Typeface m2817a(Context context) {
        return m2819a() ? f1524c : f1523b;
    }

    public static boolean m2819a() {
        return Locale.TRADITIONAL_CHINESE.getCountry().equals(Locale.getDefault().getCountry());
    }

    public static boolean m2821b() {
        return CalculatorApplication.m2559b().getResources().getBoolean(C0264R.bool.is_international);
    }

    public static boolean m2823c() {
        try {
            Class cls = Class.forName("com.miui.support.os.Build");
            return cls.getField("IS_CTA_BUILD").getBoolean(cls);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static boolean m2824d() {
        return !m2821b() || Locale.TRADITIONAL_CHINESE.getLanguage().equals(Locale.getDefault().getLanguage()) || Locale.TRADITIONAL_CHINESE.getCountry().equals(Locale.getDefault().getCountry());
    }

    public static boolean m2826e() {
        return Locale.CHINA.getLanguage().equals(Locale.getDefault().getLanguage()) && Locale.CHINA.getCountry().equals(Locale.getDefault().getCountry());
    }

    public static boolean m2827f() {
        return Locale.CHINESE.getLanguage().equals(Locale.getDefault().getLanguage());
    }

    public static double m2813a(String str) {
        double d = 0.0d;
        if (!TextUtils.isEmpty(str)) {
            try {
                d = Double.parseDouble(str);
            } catch (Throwable e) {
                Log.e("utils", "parse double error:" + str, e);
            }
        }
        return d;
    }

    public static int m2828g() {
        return CalculatorApplication.m2559b().getResources().getDisplayMetrics().widthPixels;
    }

    public static String m2820b(String str) {
        Throwable e;
        Throwable th;
        String str2 = null;
        InputStream open;
        try {
            open = CalculatorApplication.m2559b().getAssets().open(str);
            try {
                StringBuilder stringBuilder = new StringBuilder();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr, 0, bArr.length);
                    if (read <= 0) {
                        break;
                    }
                    stringBuilder.append(new String(bArr, 0, read));
                }
                str2 = stringBuilder.toString();
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable e2) {
                        Log.e("Utils", "IOException", e2);
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    Log.e("Utils", "IOException", e2);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable e22) {
                            Log.e("Utils", "IOException", e22);
                        }
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable e222) {
                            Log.e("Utils", "IOException", e222);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e222 = e4;
            Object obj = str2;
            Log.e("Utils", "IOException", e222);
            if (open != null) {
                open.close();
            }
            return str2;
        } catch (Throwable e2222) {
            open = str2;
            th = e2222;
            if (open != null) {
                open.close();
            }
            throw th;
        }
        return str2;
    }

    public static int m2829h() {
        return m2822c("status_bar_height");
    }

    public static int m2816a(Activity activity) {
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            return actionBar.getHeight();
        }
        return 0;
    }

    public static int m2822c(String str) {
        int i = 0;
        Resources resources = CalculatorApplication.m2559b().getResources();
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            try {
                i = resources.getDimensionPixelSize(identifier);
            } catch (Throwable e) {
                Log.e("Utils", "getAndroidResouceDimen failed.", e);
            }
        }
        return i;
    }

    public static float m2815a(int i, float f, TextView... textViewArr) {
        if (textViewArr == null || textViewArr.length == 0) {
            return 0.0f;
        }
        int width;
        if (i <= 0) {
            width = ((View) textViewArr[0].getParent()).getWidth();
        } else {
            width = i;
        }
        if (width <= 0) {
            width = (int) (((float) m2828g()) * 0.85f);
        }
        for (TextView textView : textViewArr) {
            textView.setMaxWidth(width);
            textView.setSingleLine();
            textView.setGravity(8388613);
        }
        if (f <= 0.0f) {
            f = (float) CalculatorApplication.m2559b().getResources().getDimensionPixelSize(C0264R.dimen.cal_primary);
        }
        int length = width - (textViewArr[0].getText().toString().length() * 3);
        float f2 = f + 1.0f;
        float a;
        do {
            f2 -= 1.0f;
            a = m2814a(f2, textViewArr);
            if (length <= 0) {
                return f2;
            }
        } while (a >= ((float) length));
        return f2;
    }

    private static float m2814a(float f, TextView[] textViewArr) {
        int i = 0;
        for (TextView textView : textViewArr) {
            textView.setTextSize(0, f);
            i = (int) (((float) i) + textView.getPaint().measureText(textView.getText().toString()));
        }
        return (float) i;
    }

    public static void m2818a(Context context, CharSequence charSequence) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, charSequence));
        Toast.makeText(context, C0264R.string.cal_text_copied, 0).show();
    }

    public static boolean m2830i() {
        return m2825d("com.miui.gallery");
    }

    public static boolean m2825d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = CalculatorApplication.m2559b().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo == null || (applicationInfo.flags & 1) == 0) {
                return false;
            }
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
