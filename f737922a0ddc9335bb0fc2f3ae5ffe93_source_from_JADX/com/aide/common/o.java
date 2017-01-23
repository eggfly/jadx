package com.aide.common;

import java.io.InputStream;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class o {

    static class 1 extends DefaultHandler {
        final /* synthetic */ Stack DW;
        final /* synthetic */ StringBuilder FH;
        private Locator Hw;
        final /* synthetic */ Document j6;

        1(Document document, Stack stack, StringBuilder stringBuilder) {
            this.j6 = document;
            this.DW = stack;
            this.FH = stringBuilder;
        }

        public void setDocumentLocator(Locator locator) {
            this.Hw = locator;
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            j6();
            Element createElement = this.j6.createElement(str3);
            for (int i = 0; i < attributes.getLength(); i++) {
                createElement.setAttribute(attributes.getQName(i), attributes.getValue(i));
            }
            createElement.setUserData("line", String.valueOf(this.Hw.getLineNumber()), null);
            createElement.setUserData("column", String.valueOf(this.Hw.getColumnNumber() + 1), null);
            this.DW.push(createElement);
        }

        public void endElement(String str, String str2, String str3) {
            j6();
            Element element = (Element) this.DW.pop();
            if (this.DW.isEmpty()) {
                this.j6.appendChild(element);
            } else {
                ((Element) this.DW.peek()).appendChild(element);
            }
        }

        public void characters(char[] cArr, int i, int i2) {
            this.FH.append(cArr, i, i2);
        }

        private void j6() {
            if (this.FH.length() > 0) {
                ((Element) this.DW.peek()).appendChild(this.j6.createTextNode(this.FH.toString()));
                this.FH.delete(0, this.FH.length());
            }
        }
    }

    public static Document j6(InputStream inputStream) {
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xMLReader.setFeature("http://xml.org/sax/features/namespaces", false);
            xMLReader.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
            Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            xMLReader.setContentHandler(new 1(newDocument, new Stack(), new StringBuilder()));
            xMLReader.parse(new InputSource(inputStream));
            return newDocument;
        } catch (Throwable e) {
            throw new RuntimeException("Can't create SAX parser / DOM builder.", e);
        }
    }
}
