package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v7.p013a.p014a.C0331a;
import android.util.Log;
import com.handmark.pulltorefresh.library.C3628R;
import com.viewpagerindicator.C4273R;
import java.lang.reflect.Field;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class ak {
    public static final Rect f1817a;
    private static Class<?> f1818b;

    static {
        f1817a = new Rect();
        if (VERSION.SDK_INT >= 18) {
            try {
                f1818b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    static Mode m2319a(int i, Mode mode) {
        switch (i) {
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return Mode.SRC_OVER;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return Mode.SRC_IN;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return Mode.SRC_ATOP;
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                return Mode.MULTIPLY;
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return Mode.SCREEN;
            case SpdyProtocol.CUSTOM /*16*/:
                return VERSION.SDK_INT >= 11 ? Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }

    public static Rect m2320a(Drawable drawable) {
        if (f1818b != null) {
            try {
                Drawable unwrap = DrawableCompat.unwrap(drawable);
                Object invoke = unwrap.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(unwrap, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : f1818b.getFields()) {
                        String name = field.getName();
                        Object obj = -1;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    obj = null;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                                rect.left = field.getInt(invoke);
                                break;
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                                rect.top = field.getInt(invoke);
                                break;
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                                rect.right = field.getInt(invoke);
                                break;
                            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                                rect.bottom = field.getInt(invoke);
                                break;
                            default:
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception e) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f1817a;
    }

    static void m2321b(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m2323d(drawable);
        }
    }

    public static boolean m2322c(Drawable drawable) {
        if (drawable instanceof LayerDrawable) {
            return VERSION.SDK_INT >= 16;
        } else if (drawable instanceof InsetDrawable) {
            return VERSION.SDK_INT >= 14;
        } else {
            if (drawable instanceof StateListDrawable) {
                return VERSION.SDK_INT >= 8;
            } else {
                if (drawable instanceof GradientDrawable) {
                    return VERSION.SDK_INT >= 14;
                } else {
                    if (!(drawable instanceof DrawableContainer)) {
                        return drawable instanceof DrawableWrapper ? m2322c(((DrawableWrapper) drawable).getWrappedDrawable()) : drawable instanceof C0331a ? m2322c(((C0331a) drawable).m831a()) : drawable instanceof ScaleDrawable ? m2322c(((ScaleDrawable) drawable).getDrawable()) : true;
                    } else {
                        ConstantState constantState = drawable.getConstantState();
                        if (!(constantState instanceof DrawableContainerState)) {
                            return true;
                        }
                        for (Drawable c : ((DrawableContainerState) constantState).getChildren()) {
                            if (!m2322c(c)) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    private static void m2323d(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(bc.f1973e);
        } else {
            drawable.setState(bc.f1976h);
        }
        drawable.setState(state);
    }
}
