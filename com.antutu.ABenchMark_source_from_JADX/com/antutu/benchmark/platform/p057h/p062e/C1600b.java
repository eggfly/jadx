package com.antutu.benchmark.platform.p057h.p062e;

import android.util.Log;
import com.antutu.benchmark.platform.p057h.p060c.C1597a;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/* renamed from: com.antutu.benchmark.platform.h.e.b */
public class C1600b {
    public static List<C1597a> m6306a(InputStream inputStream) {
        List<C1597a> list = null;
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            Object c1599a = new C1599a();
            xMLReader.setContentHandler(c1599a);
            xMLReader.parse(new InputSource(inputStream));
            list = c1599a.m6305a();
        } catch (Exception e) {
            Log.d("SAX Parser", "parse failed");
        }
        return list;
    }
}
