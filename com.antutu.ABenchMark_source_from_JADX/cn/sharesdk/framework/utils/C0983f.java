package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import android.util.Xml;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: cn.sharesdk.framework.utils.f */
public class C0983f {

    /* renamed from: cn.sharesdk.framework.utils.f.a */
    private static class C0982a extends DefaultHandler {
        private HashMap<String, Object> f3359a;
        private HashMap<String, Object> f3360b;

        public C0982a() {
            this.f3359a = new HashMap();
        }

        public HashMap<String, Object> m4394a() {
            return this.f3359a;
        }

        public void characters(char[] cArr, int i, int i2) {
            CharSequence trim = String.valueOf(cArr, i, i2).trim();
            if (!TextUtils.isEmpty(trim) && this.f3360b != null) {
                this.f3360b.put("value", trim);
            }
        }

        public void endElement(String str, String str2, String str3) {
            this.f3360b = null;
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (this.f3360b != null) {
                HashMap hashMap = new HashMap();
                this.f3360b.put(str2, hashMap);
                this.f3360b = hashMap;
            } else {
                this.f3360b = new HashMap();
                this.f3359a.put(str2, this.f3360b);
            }
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                this.f3360b.put(attributes.getLocalName(i), attributes.getValue(i));
            }
        }
    }

    public HashMap<String, Object> m4395a(String str) {
        Object c0982a = new C0982a();
        Xml.parse(str, c0982a);
        return c0982a.m4394a();
    }
}
