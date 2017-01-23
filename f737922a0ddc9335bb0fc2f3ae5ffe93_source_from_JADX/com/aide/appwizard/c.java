package com.aide.appwizard;

import com.aide.uidesigner.ProxyTextView;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class c {
    private String DW;
    private String FH;
    private String j6;

    public c() {
        this.j6 = "\t";
        this.DW = "\n";
        this.FH = "UTF8";
    }

    public String j6(Document document) {
        Writer stringWriter = new StringWriter();
        try {
            j6(document, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            return "";
        }
    }

    public void j6(Document document, Writer writer) {
        document.normalize();
        j6(document, writer, 0, "");
        writer.flush();
    }

    private void j6(Node node, Writer writer, int i, String str) {
        int i2 = 0;
        switch (node.getNodeType()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                String nodeName = node.getNodeName();
                writer.write(str + "<" + nodeName);
                String str2 = this.DW + str + this.j6;
                NamedNodeMap attributes = node.getAttributes();
                for (int i3 = 0; i3 < attributes.getLength(); i3++) {
                    Attr attr = (Attr) attributes.item(i3);
                    if (!"xmlns:android".equals(attr.getName())) {
                        writer.write(str2);
                        writer.write(attr.getNodeName());
                        writer.write("=\"");
                        j6(writer, attr.getNodeValue());
                        writer.write("\"");
                    }
                }
                NodeList childNodes = node.getChildNodes();
                if (childNodes == null || childNodes.getLength() <= 0) {
                    writer.write("/>");
                } else {
                    writer.write(">");
                    writer.write(this.DW);
                    writer.write(this.DW);
                    while (i2 < childNodes.getLength()) {
                        if (childNodes.item(i2).getNodeType() == (short) 1) {
                            j6(childNodes.item(i2), writer, i + 1, str + this.j6);
                        }
                        i2++;
                    }
                    writer.write(str);
                    writer.write("</" + nodeName + ">");
                }
                writer.write(this.DW);
                writer.write(this.DW);
            case (short) 9:
                Document document = (Document) node;
                writer.write("<?xml version=\"");
                writer.write(document.getXmlVersion());
                writer.write("\" encoding=\"utf-8\"");
                writer.write("?>");
                writer.write(this.DW);
                NodeList childNodes2 = node.getChildNodes();
                if (childNodes2 != null) {
                    for (int i4 = 0; i4 < childNodes2.getLength(); i4++) {
                        j6(childNodes2.item(i4), writer, 0, "");
                    }
                }
            default:
        }
    }

    private void j6(Writer writer, String str) {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                switch (charAt) {
                    case '\r':
                        writer.write("&#xD;");
                        break;
                    case '&':
                        writer.write("&amp;");
                        break;
                    case '<':
                        writer.write("&lt;");
                        break;
                    case '>':
                        writer.write("&gt;");
                        break;
                    default:
                        writer.write(charAt);
                        break;
                }
            }
        }
    }
}
