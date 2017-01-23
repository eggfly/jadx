package com.miui.support.extension;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.miui.support.internal.C0264R;
import com.miui.support.util.ResourceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExtensionManager {
    private HashMap<String, ArrayList<Extension>> f1988a;

    private static class Holder {
        static final ExtensionManager f1987a;

        private Holder() {
        }

        static {
            f1987a = new ExtensionManager(null);
        }
    }

    public static ExtensionManager m3442a() {
        return Holder.f1987a;
    }

    private ExtensionManager(Context context) {
        this.f1988a = new HashMap();
        m3443a(context);
    }

    public void m3444a(String str, String str2, Object... objArr) {
        ArrayList arrayList = (ArrayList) this.f1988a.get(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Extension) it.next()).m3440a(str2, objArr);
            }
        }
    }

    private void m3443a(Context context) {
        XmlResourceParser a = ResourceHelper.m5438a(context, "com.miui.sdk.extension", "miui_extension", "com.miui.support.system");
        if (a != null) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(a);
            try {
                for (int next = a.next(); next != 1; next = a.next()) {
                    if (next == 2) {
                        if ("extension".equals(a.getName())) {
                            Extension a2 = m3441a(context, asAttributeSet);
                            String a3 = a2.m3439a();
                            ArrayList arrayList = (ArrayList) this.f1988a.get(a3);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                this.f1988a.put(a3, arrayList);
                            }
                            arrayList.add(a2);
                        }
                    }
                }
            } catch (Throwable e) {
                Log.e("ExtensionManager", "Fail to parse CTA config", e);
            } catch (Throwable e2) {
                Log.e("ExtensionManager", "Fail to parse CTA config", e2);
            } finally {
                a.close();
            }
        }
    }

    private Extension m3441a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.DynamicExtension);
        String string = obtainStyledAttributes.getString(C0264R.styleable.DynamicExtension_extensionTarget);
        String string2 = obtainStyledAttributes.getString(C0264R.styleable.DynamicExtension_extensionAction);
        String string3 = obtainStyledAttributes.getString(C0264R.styleable.DynamicExtension_extensionInvoker);
        obtainStyledAttributes.recycle();
        return new Extension(string, string2, string3);
    }
}
