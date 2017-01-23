package com.antutu.benchmark.p046j;

import com.antutu.benchmark.C1511h;
import java.io.InputStream;
import org.android.spdy.SpdyProtocol;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.antutu.benchmark.j.b */
public class C1514b {
    private static XmlPullParserFactory f5190a;

    static {
        try {
            f5190a = XmlPullParserFactory.newInstance();
            f5190a.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
        }
    }

    public static void m6006a(InputStream inputStream) {
        try {
            XmlPullParser newPullParser = f5190a.newPullParser();
            newPullParser.setInput(inputStream, null);
            C1511h c1511h = new C1511h();
            boolean z = true;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        if (!newPullParser.getName().equalsIgnoreCase("Show_Benchmark_Log")) {
                            if (!newPullParser.getName().equalsIgnoreCase("Save_Benchmark_Result")) {
                                for (eventType = 1; eventType <= 25; eventType++) {
                                    if (newPullParser.getName().equalsIgnoreCase(c1511h.m5995a(eventType))) {
                                        C1513a.m5999a(eventType, z);
                                        break;
                                    }
                                }
                                break;
                            }
                            C1513a.m6001a(z);
                            break;
                        }
                        C1513a.m6003b(z);
                        break;
                    case SpdyProtocol.QUIC /*4*/:
                        try {
                            if (Integer.valueOf(newPullParser.getText()).intValue() != 0) {
                                z = true;
                                break;
                            } else {
                                z = false;
                                break;
                            }
                        } catch (Exception e) {
                            z = true;
                            break;
                        }
                    default:
                        break;
                }
            }
        } catch (Exception e2) {
        }
    }
}
