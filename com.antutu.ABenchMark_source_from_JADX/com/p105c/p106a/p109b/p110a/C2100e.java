package com.p105c.p106a.p109b.p110a;

import android.support.v4.view.MotionEventCompat;
import android.util.Xml;
import com.google.analytics.tracking.android.ModelFields;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.c.a.b.a.e */
class C2100e {
    public static final Object m7870a(XmlPullParser xmlPullParser, String[] strArr) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
            } else if (eventType == 4) {
                throw new XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
            } else {
                try {
                    eventType = xmlPullParser.next();
                    if (eventType == 1) {
                        throw new XmlPullParserException("Unexpected end of document");
                    }
                } catch (Exception e) {
                    throw new XmlPullParserException("Unexpected call next(): " + xmlPullParser.getName());
                }
            }
        }
        return C2100e.m7879b(xmlPullParser, strArr);
    }

    public static final HashMap m7871a(InputStream inputStream) {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (HashMap) C2100e.m7870a(newPullParser, new String[1]);
    }

    public static final HashMap m7872a(XmlPullParser xmlPullParser, String str, String[] strArr) {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                Object b = C2100e.m7879b(xmlPullParser, strArr);
                if (strArr[0] != null) {
                    hashMap.put(strArr[0], b);
                } else {
                    throw new XmlPullParserException("Map value without name attribute: " + xmlPullParser.getName());
                }
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final void m7873a(Object obj, String str, XmlSerializer xmlSerializer) {
        if (obj == null) {
            xmlSerializer.startTag(null, "null");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.endTag(null, "null");
        } else if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, "string");
        } else {
            String str2;
            if (obj instanceof Integer) {
                str2 = "int";
            } else if (obj instanceof Long) {
                str2 = "long";
            } else if (obj instanceof Float) {
                str2 = "float";
            } else if (obj instanceof Double) {
                str2 = "double";
            } else if (obj instanceof Boolean) {
                str2 = "boolean";
            } else if (obj instanceof byte[]) {
                C2100e.m7877a((byte[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof int[]) {
                C2100e.m7878a((int[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof Map) {
                C2100e.m7876a((Map) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof List) {
                C2100e.m7874a((List) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof CharSequence) {
                xmlSerializer.startTag(null, "string");
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag(null, "string");
                return;
            } else {
                throw new RuntimeException("writeValueXml: unable to write value " + obj);
            }
            xmlSerializer.startTag(null, str2);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.attribute(null, "value", obj.toString());
            xmlSerializer.endTag(null, str2);
        }
    }

    public static final void m7874a(List list, String str, XmlSerializer xmlSerializer) {
        if (list == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "list");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C2100e.m7873a(list.get(i), null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "list");
    }

    public static final void m7875a(Map map, OutputStream outputStream) {
        XmlSerializer c2092a = new C2092a();
        c2092a.setOutput(outputStream, "utf-8");
        c2092a.startDocument(null, Boolean.valueOf(true));
        c2092a.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        C2100e.m7876a(map, null, c2092a);
        c2092a.endDocument();
    }

    public static final void m7876a(Map map, String str, XmlSerializer xmlSerializer) {
        if (map == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        for (Entry entry : map.entrySet()) {
            C2100e.m7873a(entry.getValue(), (String) entry.getKey(), xmlSerializer);
        }
        xmlSerializer.endTag(null, "map");
    }

    public static final void m7877a(byte[] bArr, String str, XmlSerializer xmlSerializer) {
        if (bArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r2));
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b >> 4;
            stringBuilder.append(i >= 10 ? (i + 97) - 10 : i + 48);
            i = b & MotionEventCompat.ACTION_MASK;
            stringBuilder.append(i >= 10 ? (i + 97) - 10 : i + 48);
        }
        xmlSerializer.text(stringBuilder.toString());
        xmlSerializer.endTag(null, "byte-array");
    }

    public static final void m7878a(int[] iArr, String str, XmlSerializer xmlSerializer) {
        if (iArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "int-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r1));
        for (int num : iArr) {
            xmlSerializer.startTag(null, ModelFields.ITEM);
            xmlSerializer.attribute(null, "value", Integer.toString(num));
            xmlSerializer.endTag(null, ModelFields.ITEM);
        }
        xmlSerializer.endTag(null, "int-array");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.Object m7879b(org.xmlpull.v1.XmlPullParser r9, java.lang.String[] r10) {
        /*
        r8 = 3;
        r7 = 2;
        r6 = 1;
        r5 = 0;
        r0 = 0;
        r1 = "name";
        r2 = r9.getAttributeValue(r0, r1);
        r3 = r9.getName();
        r1 = "null";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x002c;
    L_0x0017:
        r1 = r9.next();
        if (r1 == r6) goto L_0x01e8;
    L_0x001d:
        if (r1 != r8) goto L_0x0195;
    L_0x001f:
        r1 = r9.getName();
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x016e;
    L_0x0029:
        r10[r5] = r2;
    L_0x002b:
        return r0;
    L_0x002c:
        r1 = "string";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x00aa;
    L_0x0034:
        r0 = "";
    L_0x0036:
        r1 = r9.next();
        if (r1 == r6) goto L_0x00a2;
    L_0x003c:
        if (r1 != r8) goto L_0x006a;
    L_0x003e:
        r1 = r9.getName();
        r3 = "string";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x004d;
    L_0x004a:
        r10[r5] = r2;
        goto L_0x002b;
    L_0x004d:
        r0 = new org.xmlpull.v1.XmlPullParserException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unexpected end tag in <string>: ";
        r1 = r1.append(r2);
        r2 = r9.getName();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x006a:
        r3 = 4;
        if (r1 != r3) goto L_0x0083;
    L_0x006d:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = r1.append(r0);
        r1 = r9.getText();
        r0 = r0.append(r1);
        r0 = r0.toString();
        goto L_0x0036;
    L_0x0083:
        if (r1 != r7) goto L_0x0036;
    L_0x0085:
        r0 = new org.xmlpull.v1.XmlPullParserException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unexpected start tag in <string>: ";
        r1 = r1.append(r2);
        r2 = r9.getName();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00a2:
        r0 = new org.xmlpull.v1.XmlPullParserException;
        r1 = "Unexpected end of document in <string>";
        r0.<init>(r1);
        throw r0;
    L_0x00aa:
        r1 = "int";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x00c2;
    L_0x00b2:
        r1 = "value";
        r0 = r9.getAttributeValue(r0, r1);
        r0 = java.lang.Integer.parseInt(r0);
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x0017;
    L_0x00c2:
        r1 = "long";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x00d6;
    L_0x00ca:
        r1 = "value";
        r0 = r9.getAttributeValue(r0, r1);
        r0 = java.lang.Long.valueOf(r0);
        goto L_0x0017;
    L_0x00d6:
        r1 = "float";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x00ec;
    L_0x00de:
        r1 = new java.lang.Float;
        r4 = "value";
        r0 = r9.getAttributeValue(r0, r4);
        r1.<init>(r0);
        r0 = r1;
        goto L_0x0017;
    L_0x00ec:
        r1 = "double";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0102;
    L_0x00f4:
        r1 = new java.lang.Double;
        r4 = "value";
        r0 = r9.getAttributeValue(r0, r4);
        r1.<init>(r0);
        r0 = r1;
        goto L_0x0017;
    L_0x0102:
        r1 = "boolean";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0116;
    L_0x010a:
        r1 = "value";
        r0 = r9.getAttributeValue(r0, r1);
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0017;
    L_0x0116:
        r0 = "int-array";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x012b;
    L_0x011e:
        r9.next();
        r0 = "int-array";
        r0 = com.p105c.p106a.p109b.p110a.C2100e.m7881c(r9, r0, r10);
        r10[r5] = r2;
        goto L_0x002b;
    L_0x012b:
        r0 = "map";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0140;
    L_0x0133:
        r9.next();
        r0 = "map";
        r0 = com.p105c.p106a.p109b.p110a.C2100e.m7872a(r9, r0, r10);
        r10[r5] = r2;
        goto L_0x002b;
    L_0x0140:
        r0 = "list";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0155;
    L_0x0148:
        r9.next();
        r0 = "list";
        r0 = com.p105c.p106a.p109b.p110a.C2100e.m7880b(r9, r0, r10);
        r10[r5] = r2;
        goto L_0x002b;
    L_0x0155:
        r0 = new org.xmlpull.v1.XmlPullParserException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unknown tag: ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x016e:
        r0 = new org.xmlpull.v1.XmlPullParserException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unexpected end tag in <";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = ">: ";
        r1 = r1.append(r2);
        r2 = r9.getName();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0195:
        r4 = 4;
        if (r1 != r4) goto L_0x01bf;
    L_0x0198:
        r0 = new org.xmlpull.v1.XmlPullParserException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unexpected text in <";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = ">: ";
        r1 = r1.append(r2);
        r2 = r9.getName();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x01bf:
        if (r1 != r7) goto L_0x0017;
    L_0x01c1:
        r0 = new org.xmlpull.v1.XmlPullParserException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unexpected start tag in <";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = ">: ";
        r1 = r1.append(r2);
        r2 = r9.getName();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x01e8:
        r0 = new org.xmlpull.v1.XmlPullParserException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unexpected end of document in <";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = ">";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.b.a.e.b(org.xmlpull.v1.XmlPullParser, java.lang.String[]):java.lang.Object");
    }

    public static final ArrayList m7880b(XmlPullParser xmlPullParser, String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(C2100e.m7879b(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final int[] m7881c(XmlPullParser xmlPullParser, String str, String[] strArr) {
        try {
            int[] iArr = new int[Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"))];
            int i = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals(ModelFields.ITEM)) {
                        try {
                            iArr[i] = Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                        } catch (NullPointerException e) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException e2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    }
                    throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return iArr;
                    }
                    if (xmlPullParser.getName().equals(ModelFields.ITEM)) {
                        i++;
                    } else {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException e3) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        } catch (NumberFormatException e4) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }
}
