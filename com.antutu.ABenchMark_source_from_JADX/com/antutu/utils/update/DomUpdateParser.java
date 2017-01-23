package com.antutu.utils.update;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomUpdateParser {
    static final String DOWNURL = "url";
    static final String ITEM = "updateinfo";
    static final String PKG = "pkg";
    static final String VERCODE = "versionCode";
    static final String VERSION = "version";
    private final URL xmlUrl;

    public DomUpdateParser(String str) {
        try {
            this.xmlUrl = new URL(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected InputStream getInputStream() {
        try {
            return this.xmlUrl.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    public UpdateInfo parse() {
        try {
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getInputStream()).getDocumentElement().getElementsByTagName(ITEM);
            UpdateInfo updateInfo = new UpdateInfo();
            elementsByTagName = elementsByTagName.item(0).getChildNodes();
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Node item = elementsByTagName.item(i);
                String nodeName = item.getNodeName();
                if (nodeName.equalsIgnoreCase(VERSION)) {
                    updateInfo.version = item.getFirstChild().getNodeValue();
                } else if (nodeName.equalsIgnoreCase(VERCODE)) {
                    updateInfo.versionCode = item.getFirstChild().getNodeValue();
                } else if (nodeName.equalsIgnoreCase(DOWNURL)) {
                    updateInfo.url = item.getFirstChild().getNodeValue();
                } else if (nodeName.equalsIgnoreCase(PKG)) {
                    updateInfo.pkg = item.getFirstChild().getNodeValue();
                }
            }
            return updateInfo;
        } catch (Exception e) {
            return null;
        }
    }
}
