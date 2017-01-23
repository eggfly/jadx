package com.xiaomi.push.service;

import com.xiaomi.smack.packet.C4479a;
import com.xiaomi.smack.provider.C4408b;
import com.xiaomi.smack.provider.C4490c;
import com.xiaomi.smack.util.C4496g;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.xiaomi.push.service.c */
public class C4409c implements C4408b {
    public static C4479a m18190a(XmlPullParser xmlPullParser) {
        List list = null;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String[] strArr;
        String[] strArr2;
        int i;
        String str;
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            strArr = new String[xmlPullParser.getAttributeCount()];
            strArr2 = new String[xmlPullParser.getAttributeCount()];
            for (i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                strArr[i] = xmlPullParser.getAttributeName(i);
                strArr2[i] = C4496g.m18651b(xmlPullParser.getAttributeValue(i));
            }
            str = null;
        } else {
            str = null;
            strArr2 = null;
            strArr = null;
        }
        while (true) {
            i = xmlPullParser.next();
            if (i == 3) {
                return new C4479a(name, namespace, strArr, strArr2, str, list);
            }
            if (i == 4) {
                str = xmlPullParser.getText().trim();
            } else if (i == 2) {
                if (list == null) {
                    list = new ArrayList();
                }
                C4479a a = C4409c.m18190a(xmlPullParser);
                if (a != null) {
                    list.add(a);
                }
            }
        }
    }

    public void m18191a() {
        C4490c.m18623a().m18627a("all", "xm:chat", this);
    }

    public C4479a m18192b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        return eventType == 2 ? C4409c.m18190a(xmlPullParser) : null;
    }
}
