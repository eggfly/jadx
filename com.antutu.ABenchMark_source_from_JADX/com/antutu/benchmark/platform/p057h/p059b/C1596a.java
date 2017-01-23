package com.antutu.benchmark.platform.p057h.p059b;

import android.util.Log;
import com.antutu.benchmark.platform.p057h.p060c.C1597a;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.android.agoo.common.AgooConstants;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* renamed from: com.antutu.benchmark.platform.h.b.a */
public class C1596a {
    private static DocumentBuilderFactory f5575a;

    static {
        f5575a = DocumentBuilderFactory.newInstance();
        f5575a.setNamespaceAware(true);
    }

    public static List<C1597a> m6295a(InputStream inputStream) {
        List<C1597a> arrayList = new ArrayList();
        try {
            Element documentElement = f5575a.newDocumentBuilder().parse(inputStream).getDocumentElement();
            String namespaceURI = documentElement.getNamespaceURI();
            NodeList elementsByTagNameNS = documentElement.getElementsByTagNameNS(namespaceURI, "person");
            for (int i = 0; i < elementsByTagNameNS.getLength(); i++) {
                Element element = (Element) elementsByTagNameNS.item(i);
                C1597a c1597a = new C1597a();
                if (element.hasAttribute(AgooConstants.MESSAGE_ID)) {
                    c1597a.m6296a(Integer.parseInt(element.getAttribute(AgooConstants.MESSAGE_ID)));
                }
                c1597a.m6297a(element.getElementsByTagNameNS(namespaceURI, "lastName").item(0).getFirstChild().getNodeValue());
                c1597a.m6298b(element.getElementsByTagNameNS(namespaceURI, "postCode").item(0).getFirstChild().getNodeValue());
                c1597a.m6299c(element.getElementsByTagNameNS(namespaceURI, "address1").item(0).getFirstChild().getNodeValue());
                c1597a.m6300d(element.getElementsByTagNameNS(namespaceURI, "address2").item(0).getFirstChild().getNodeValue());
                c1597a.m6301e(element.getElementsByTagNameNS(namespaceURI, "firstName").item(0).getFirstChild().getNodeValue());
                c1597a.m6302f(element.getElementsByTagNameNS(namespaceURI, "country").item(0).getFirstChild().getNodeValue());
                c1597a.m6303g(element.getElementsByTagNameNS(namespaceURI, "city").item(0).getFirstChild().getNodeValue());
                arrayList.add(c1597a);
            }
        } catch (Exception e) {
            Log.d("DOM Parser", "parse failed");
        }
        return arrayList;
    }
}
