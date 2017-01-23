package com.xiaomi.smack.util;

import android.text.TextUtils;
import com.antutu.utils.PointMark;
import com.qq.p035e.comm.pi.ACTD;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.C4409c;
import com.xiaomi.push.service.C4450y;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.push.service.ae;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.smack.C4461a;
import com.xiaomi.smack.C4472k.C4471b;
import com.xiaomi.smack.C4472k.C4471b.C4470a;
import com.xiaomi.smack.C4477p;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.packet.C4479a;
import com.xiaomi.smack.packet.C4481b;
import com.xiaomi.smack.packet.C4481b.C4480a;
import com.xiaomi.smack.packet.C4482c;
import com.xiaomi.smack.packet.C4485f;
import com.xiaomi.smack.packet.C4485f.C4483a;
import com.xiaomi.smack.packet.C4485f.C4484b;
import com.xiaomi.smack.packet.C4486g;
import com.xiaomi.smack.packet.C4488h;
import com.xiaomi.smack.packet.C4488h.C4487a;
import com.xiaomi.smack.provider.C4490c;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.smack.util.c */
public class C4493c {
    private static XmlPullParser f15458a;

    static {
        f15458a = null;
    }

    public static C4479a m18634a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a = C4490c.m18623a().m18626a("all", "xm:chat");
        return (a == null || !(a instanceof C4409c)) ? null : ((C4409c) a).m18192b(xmlPullParser);
    }

    public static C4481b m18635a(XmlPullParser xmlPullParser, C4461a c4461a) {
        int i;
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, AgooConstants.MESSAGE_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "to");
        String attributeValue3 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "from");
        String attributeValue4 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "chid");
        C4480a a = C4480a.m18579a(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, C4233j.f14402y));
        Map hashMap = new HashMap();
        for (i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, attributeName));
        }
        Object obj = null;
        C4488h c4488h = null;
        C4481b c4481b = null;
        while (obj == null) {
            Object obj2;
            C4481b c4481b2;
            C4488h c4488h2;
            Object obj3;
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(C4233j.f14375B)) {
                    c4488h = C4493c.m18641e(xmlPullParser);
                } else {
                    c4481b = new C4481b();
                    c4481b.m18511a(C4493c.m18634a(name, namespace, xmlPullParser));
                }
                obj2 = obj;
                c4481b2 = c4481b;
                c4488h2 = c4488h;
                obj3 = obj2;
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                c4481b2 = c4481b;
                c4488h2 = c4488h;
                i = 1;
            } else {
                obj2 = obj;
                c4481b2 = c4481b;
                c4488h2 = c4488h;
                obj3 = obj2;
            }
            obj2 = obj3;
            c4488h = c4488h2;
            c4481b = c4481b2;
            obj = obj2;
        }
        if (c4481b == null) {
            if (C4480a.f15379a == a || C4480a.f15380b == a) {
                C4468d c4494d = new C4494d();
                c4494d.m18516k(attributeValue);
                c4494d.m18520m(attributeValue3);
                c4494d.m18522n(attributeValue2);
                c4494d.m18582a(C4480a.f15382d);
                c4494d.m18518l(attributeValue4);
                c4494d.m18512a(new C4488h(C4487a.f15424e));
                c4461a.m18460a(c4494d);
                C4302b.m17654d("iq usage error. send packet in packet parser.");
                return null;
            }
            c4481b = new C4495e();
        }
        c4481b.m18516k(attributeValue);
        c4481b.m18520m(attributeValue2);
        c4481b.m18518l(attributeValue4);
        c4481b.m18522n(attributeValue3);
        c4481b.m18582a(a);
        c4481b.m18512a(c4488h);
        c4481b.m18584a(hashMap);
        return c4481b;
    }

    public static C4468d m18636a(XmlPullParser xmlPullParser) {
        String attributeValue;
        boolean z;
        if (MessageService.MSG_DB_NOTIFY_REACHED.equals(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "s"))) {
            attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, AgooConstants.MESSAGE_ID);
            String attributeValue3 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "from");
            String attributeValue4 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "to");
            String attributeValue5 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, C4233j.f14402y);
            C4448b b = C4450y.m18390a().m18398b(attributeValue, attributeValue4);
            C4448b b2 = b == null ? C4450y.m18390a().m18398b(attributeValue, attributeValue3) : b;
            if (b2 == null) {
                throw new C4477p("the channel id is wrong while receiving a encrypted message");
            }
            z = false;
            C4468d c4468d = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!"s".equals(xmlPullParser.getName())) {
                        throw new C4477p("error while receiving a encrypted message with wrong format");
                    } else if (xmlPullParser.next() != 4) {
                        throw new C4477p("error while receiving a encrypted message with wrong format");
                    } else {
                        String text = xmlPullParser.getText();
                        if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                            c4468d = new C4482c();
                            c4468d.m18518l(attributeValue);
                            c4468d.m18594b(true);
                            c4468d.m18522n(attributeValue3);
                            c4468d.m18520m(attributeValue4);
                            c4468d.m18516k(attributeValue2);
                            c4468d.m18602f(attributeValue5);
                            C4479a c4479a = new C4479a("s", null, (String[]) null, (String[]) null);
                            c4479a.m18574b(text);
                            c4468d.m18511a(c4479a);
                            return c4468d;
                        }
                        C4493c.m18637a(ae.m18127b(ae.m18124a(b2.f15177i, attributeValue2), text));
                        f15458a.next();
                        c4468d = C4493c.m18636a(f15458a);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(C4233j.f14376C)) {
                    z = true;
                }
            }
            if (c4468d != null) {
                return c4468d;
            }
            throw new C4477p("error while receiving a encrypted message with wrong format");
        }
        Object attributeValue6;
        Object attributeValue7;
        C4468d c4482c = new C4482c();
        String attributeValue8 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, AgooConstants.MESSAGE_ID);
        if (attributeValue8 == null) {
            attributeValue8 = "ID_NOT_AVAILABLE";
        }
        c4482c.m18516k(attributeValue8);
        c4482c.m18520m(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "to"));
        c4482c.m18522n(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "from"));
        c4482c.m18518l(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "chid"));
        c4482c.m18589a(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, ACTD.APPID_KEY));
        try {
            attributeValue6 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "transient");
        } catch (Exception e) {
            attributeValue6 = null;
        }
        try {
            attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "seq");
            if (!TextUtils.isEmpty(attributeValue)) {
                c4482c.m18593b(attributeValue);
            }
        } catch (Exception e2) {
        }
        try {
            attributeValue7 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "mseq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                c4482c.m18596c(attributeValue7);
            }
        } catch (Exception e3) {
        }
        try {
            attributeValue7 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "fseq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                c4482c.m18598d(attributeValue7);
            }
        } catch (Exception e4) {
        }
        try {
            attributeValue7 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, MsgConstant.KEY_STATUS);
            if (!TextUtils.isEmpty(attributeValue7)) {
                c4482c.m18600e(attributeValue7);
            }
        } catch (Exception e5) {
        }
        z = !TextUtils.isEmpty(attributeValue6) && attributeValue6.equalsIgnoreCase("true");
        c4482c.m18591a(z);
        c4482c.m18602f(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, C4233j.f14402y));
        attributeValue8 = C4493c.m18643g(xmlPullParser);
        if (attributeValue8 == null || BuildConfig.FLAVOR.equals(attributeValue8.trim())) {
            C4468d.m18509u();
        } else {
            c4482c.m18609j(attributeValue8);
        }
        attributeValue8 = null;
        boolean z2 = false;
        while (!z2) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                attributeValue = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (attributeValue.equals("subject")) {
                    if (C4493c.m18643g(xmlPullParser) == null) {
                        c4482c.m18604g(C4493c.m18642f(xmlPullParser));
                    } else {
                        c4482c.m18604g(C4493c.m18642f(xmlPullParser));
                    }
                } else if (attributeValue.equals(C4156a.f13961w)) {
                    Object attributeValue9 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "encode");
                    attributeValue = C4493c.m18642f(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue9)) {
                        c4482c.m18606h(attributeValue);
                    } else {
                        c4482c.m18590a(attributeValue, attributeValue9);
                    }
                } else if (attributeValue.equals("thread")) {
                    if (attributeValue8 == null) {
                        attributeValue8 = xmlPullParser.nextText();
                    }
                } else if (attributeValue.equals(C4233j.f14375B)) {
                    c4482c.m18512a(C4493c.m18641e(xmlPullParser));
                } else {
                    c4482c.m18511a(C4493c.m18634a(attributeValue, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals(C4233j.f14376C)) {
                z2 = true;
            }
        }
        c4482c.m18608i(attributeValue8);
        return c4482c;
    }

    private static void m18637a(byte[] bArr) {
        if (f15458a == null) {
            try {
                f15458a = XmlPullParserFactory.newInstance().newPullParser();
                f15458a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        f15458a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    public static C4485f m18638b(XmlPullParser xmlPullParser) {
        C4484b c4484b = C4484b.available;
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, C4233j.f14402y);
        if (!(attributeValue == null || attributeValue.equals(BuildConfig.FLAVOR))) {
            try {
                c4484b = C4484b.valueOf(attributeValue);
            } catch (IllegalArgumentException e) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        C4485f c4485f = new C4485f(c4484b);
        c4485f.m18520m(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "to"));
        c4485f.m18522n(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "from"));
        c4485f.m18518l(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, AgooConstants.MESSAGE_ID);
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        c4485f.m18516k(attributeValue2);
        int i = 0;
        while (i == 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(MsgConstant.KEY_STATUS)) {
                    c4485f.m18614a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        c4485f.m18611a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException e2) {
                    } catch (IllegalArgumentException e3) {
                        c4485f.m18611a(0);
                    }
                } else if (name.equals("show")) {
                    name = xmlPullParser.nextText();
                    try {
                        c4485f.m18612a(C4483a.valueOf(name));
                    } catch (IllegalArgumentException e4) {
                        System.err.println("Found invalid presence mode " + name);
                    }
                } else if (name.equals(C4233j.f14375B)) {
                    c4485f.m18512a(C4493c.m18641e(xmlPullParser));
                } else {
                    c4485f.m18511a(C4493c.m18634a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                i = 1;
            }
        }
        return c4485f;
    }

    public static C4471b m18639c(XmlPullParser xmlPullParser) {
        C4471b c4471b = new C4471b();
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, AgooConstants.MESSAGE_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "to");
        String attributeValue3 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "from");
        String attributeValue4 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "chid");
        C4470a a = C4470a.m18533a(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, C4233j.f14402y));
        c4471b.m18516k(attributeValue);
        c4471b.m18520m(attributeValue2);
        c4471b.m18522n(attributeValue3);
        c4471b.m18518l(attributeValue4);
        c4471b.m18535a(a);
        Object obj = null;
        C4488h c4488h = null;
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals(C4233j.f14375B)) {
                    c4488h = C4493c.m18641e(xmlPullParser);
                }
            } else if (next == 3 && xmlPullParser.getName().equals("bind")) {
                obj = 1;
            }
        }
        c4471b.m18512a(c4488h);
        return c4471b;
    }

    public static C4486g m18640d(XmlPullParser xmlPullParser) {
        C4486g c4486g = null;
        Object obj = null;
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                c4486g = new C4486g(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals(C4233j.f14375B)) {
                obj = 1;
            }
        }
        return c4486g;
    }

    public static C4488h m18641e(XmlPullParser xmlPullParser) {
        String attributeValue;
        String attributeValue2;
        String str = "urn:ietf:params:xml:ns:xmpp-stanzas";
        List arrayList = new ArrayList();
        String str2 = null;
        String str3 = null;
        String str4 = "-1";
        int i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            attributeValue = xmlPullParser.getAttributeName(i).equals(Constants.KEY_HTTP_CODE) ? xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, Constants.KEY_HTTP_CODE) : str4;
            attributeValue2 = xmlPullParser.getAttributeName(i).equals(C4233j.f14402y) ? xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, C4233j.f14402y) : str3;
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "reason");
            }
            i++;
            str3 = attributeValue2;
            str4 = attributeValue;
        }
        Object obj = null;
        attributeValue2 = null;
        attributeValue = null;
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    attributeValue = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        attributeValue2 = name;
                    } else {
                        arrayList.add(C4493c.m18634a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(C4233j.f14375B)) {
                    obj = 1;
                }
            } else if (next == 4) {
                attributeValue = xmlPullParser.getText();
            }
        }
        return new C4488h(Integer.parseInt(str4), str3 == null ? "cancel" : str3, str2, attributeValue2, attributeValue, arrayList);
    }

    private static String m18642f(XmlPullParser xmlPullParser) {
        String str = BuildConfig.FLAVOR;
        int depth = xmlPullParser.getDepth();
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static String m18643g(XmlPullParser xmlPullParser) {
        int i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || (PointMark.T_LANG.equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
            i++;
        }
        return null;
    }
}
