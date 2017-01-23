package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0424d;
import android.support.v7.widget.C0476p;
import android.support.v7.widget.C0534f;
import android.support.v7.widget.C0607h;
import android.support.v7.widget.C0608i;
import android.support.v7.widget.C0609j;
import android.support.v7.widget.C0617m;
import android.support.v7.widget.C0618n;
import android.support.v7.widget.C0620q;
import android.support.v7.widget.C0624t;
import android.support.v7.widget.C0625u;
import android.support.v7.widget.C0626v;
import android.support.v7.widget.C0634x;
import android.support.v7.widget.aa;
import android.support.v7.widget.be;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: android.support.v7.app.m */
class C0388m {
    private static final Class<?>[] f978a;
    private static final int[] f979b;
    private static final String[] f980c;
    private static final Map<String, Constructor<? extends View>> f981d;
    private final Object[] f982e;

    /* renamed from: android.support.v7.app.m.a */
    private static class C0387a implements OnClickListener {
        private final View f974a;
        private final String f975b;
        private Method f976c;
        private Context f977d;

        public C0387a(View view, String str) {
            this.f974a = view;
            this.f975b = str;
        }

        private void m1080a(Context context, String str) {
            for (Context context2 = context; context2 != null; context2 = context2 instanceof ContextWrapper ? ((ContextWrapper) context2).getBaseContext() : null) {
                try {
                    if (!context2.isRestricted()) {
                        Method method = context2.getClass().getMethod(this.f975b, new Class[]{View.class});
                        if (method != null) {
                            this.f976c = method;
                            this.f977d = context2;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
            }
            int id = this.f974a.getId();
            throw new IllegalStateException("Could not find method " + this.f975b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f974a.getClass() + (id == -1 ? BuildConfig.FLAVOR : " with id '" + this.f974a.getContext().getResources().getResourceEntryName(id) + "'"));
        }

        public void onClick(View view) {
            if (this.f976c == null) {
                m1080a(this.f974a.getContext(), this.f975b);
            }
            try {
                this.f976c.invoke(this.f977d, new Object[]{view});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    static {
        f978a = new Class[]{Context.class, AttributeSet.class};
        f979b = new int[]{16843375};
        f980c = new String[]{"android.widget.", "android.view.", "android.webkit."};
        f981d = new ArrayMap();
    }

    C0388m() {
        this.f982e = new Object[2];
    }

    private static Context m1081a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0417R.styleable.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0417R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0417R.styleable.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        return i != 0 ? ((context instanceof C0424d) && ((C0424d) context).getThemeResId() == i) ? context : new C0424d(context, i) : context;
    }

    private View m1082a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f982e[0] = context;
            this.f982e[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                for (String a2 : f980c) {
                    a = m1083a(context, str, a2);
                    if (a != null) {
                        return a;
                    }
                }
                this.f982e[0] = null;
                this.f982e[1] = null;
                return null;
            }
            a = m1083a(context, str, null);
            this.f982e[0] = null;
            this.f982e[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f982e[0] = null;
            this.f982e[1] = null;
        }
    }

    private View m1083a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f981d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f978a);
                f981d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f982e);
    }

    private void m1084a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || ViewCompat.hasOnClickListeners(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f979b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0387a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final View m1085a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = C0388m.m1081a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = be.m2498a(context2);
        }
        View view2 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                view2 = new aa(context2, attributeSet);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                view2 = new C0476p(context2, attributeSet);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                view2 = new C0607h(context2, attributeSet);
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                view2 = new C0617m(context2, attributeSet);
                break;
            case SpdyProtocol.QUIC /*4*/:
                view2 = new C0634x(context2, attributeSet);
                break;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                view2 = new C0618n(context2, attributeSet);
                break;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                view2 = new C0608i(context2, attributeSet);
                break;
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                view2 = new C0624t(context2, attributeSet);
                break;
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                view2 = new C0609j(context2, attributeSet);
                break;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                view2 = new C0534f(context2, attributeSet);
                break;
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                view2 = new C0620q(context2, attributeSet);
                break;
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                view2 = new C0625u(context2, attributeSet);
                break;
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                view2 = new C0626v(context2, attributeSet);
                break;
        }
        View a = (view2 != null || context == context2) ? view2 : m1082a(context2, str, attributeSet);
        if (a != null) {
            m1084a(a, attributeSet);
        }
        return a;
    }
}
