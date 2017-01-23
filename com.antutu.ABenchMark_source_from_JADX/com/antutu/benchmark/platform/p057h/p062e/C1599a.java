package com.antutu.benchmark.platform.p057h.p062e;

import com.antutu.benchmark.platform.p057h.p060c.C1597a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: com.antutu.benchmark.platform.h.e.a */
public class C1599a extends DefaultHandler {
    private List<C1597a> f5585a;
    private String f5586b;
    private C1597a f5587c;

    public C1599a() {
        this.f5585a = new ArrayList();
    }

    public List<C1597a> m6305a() {
        return this.f5585a;
    }

    public void characters(char[] cArr, int i, int i2) {
        this.f5586b = new String(cArr, i, i2);
    }

    public void endElement(String str, String str2, String str3) {
        if (str2.equalsIgnoreCase("person")) {
            this.f5585a.add(this.f5587c);
        } else if (str2.equalsIgnoreCase("lastName")) {
            this.f5587c.m6297a(this.f5586b);
        } else if (str2.equalsIgnoreCase("postCode")) {
            this.f5587c.m6298b(this.f5586b);
        } else if (str2.equalsIgnoreCase("address1")) {
            this.f5587c.m6299c(this.f5586b);
        } else if (str2.equalsIgnoreCase("address2")) {
            this.f5587c.m6300d(this.f5586b);
        } else if (str2.equalsIgnoreCase("firstName")) {
            this.f5587c.m6301e(this.f5586b);
        } else if (str2.equalsIgnoreCase("country")) {
            this.f5587c.m6302f(this.f5586b);
        } else if (str2.equals("city")) {
            this.f5587c.m6303g(this.f5586b);
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f5586b = BuildConfig.FLAVOR;
        if (str2.equalsIgnoreCase("person")) {
            this.f5587c = new C1597a();
            String value = attributes.getValue(AgooConstants.MESSAGE_ID);
            if (value != null) {
                this.f5587c.m6296a(Integer.parseInt(value));
            }
        }
    }
}
