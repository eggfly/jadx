package com.antutu.benchmark.platform.p057h.p061d;

import android.util.Log;
import com.antutu.benchmark.platform.p057h.p060c.C1597a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.antutu.benchmark.platform.h.d.a */
public class C1598a {
    private static XmlPullParserFactory f5584a;

    static {
        try {
            f5584a = XmlPullParserFactory.newInstance();
            f5584a.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            Log.d("Pull Parser", "parse failed");
        }
    }

    public static List<C1597a> m6304a(InputStream inputStream) {
        C1597a c1597a = null;
        List<C1597a> arrayList = new ArrayList();
        try {
            XmlPullParser newPullParser = f5584a.newPullParser();
            newPullParser.setInput(inputStream, null);
            String str = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        str = BuildConfig.FLAVOR;
                        if (!newPullParser.getName().equalsIgnoreCase("person")) {
                            break;
                        }
                        c1597a = new C1597a();
                        String attributeValue = newPullParser.getAttributeValue(null, AgooConstants.MESSAGE_ID);
                        if (attributeValue == null) {
                            break;
                        }
                        c1597a.m6296a(Integer.parseInt(attributeValue));
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        if (!newPullParser.getName().equalsIgnoreCase("person")) {
                            if (!newPullParser.getName().equalsIgnoreCase("lastName")) {
                                if (!newPullParser.getName().equalsIgnoreCase("postCode")) {
                                    if (!newPullParser.getName().equalsIgnoreCase("address1")) {
                                        if (!newPullParser.getName().equalsIgnoreCase("address2")) {
                                            if (!newPullParser.getName().equalsIgnoreCase("firstName")) {
                                                if (!newPullParser.getName().equalsIgnoreCase("country")) {
                                                    if (!newPullParser.getName().equals("city")) {
                                                        break;
                                                    }
                                                    c1597a.m6303g(str);
                                                    break;
                                                }
                                                c1597a.m6302f(str);
                                                break;
                                            }
                                            c1597a.m6301e(str);
                                            break;
                                        }
                                        c1597a.m6300d(str);
                                        break;
                                    }
                                    c1597a.m6299c(str);
                                    break;
                                }
                                c1597a.m6298b(str);
                                break;
                            }
                            c1597a.m6297a(str);
                            break;
                        }
                        arrayList.add(c1597a);
                        break;
                    case SpdyProtocol.QUIC /*4*/:
                        str = newPullParser.getText();
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            Log.d("Pull Parser", "parse failed");
        }
        return arrayList;
    }
}
