package com.miui.support.internal.component.plugin;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PluginManifestParser {
    public Plugin m3959a(InputStream inputStream) {
        Plugin plugin = new Plugin();
        try {
            m3954a(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement(), plugin);
            return plugin;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new PluginParseException();
        } catch (SAXException e2) {
            e2.printStackTrace();
            throw new PluginParseException();
        } catch (Exception e3) {
            e3.printStackTrace();
            throw new PluginParseException();
        }
    }

    private String m3953a(Element element, String str, boolean z, String str2) {
        String attribute = element.getAttribute(str);
        if (attribute != null && !"".equals(attribute)) {
            return attribute;
        }
        if (!z) {
            return str2;
        }
        throw new PluginParseException("missing attribute " + str + " in element " + element.getTagName());
    }

    private String m3951a(Element element, String str) {
        return m3953a(element, str, true, null);
    }

    private String m3952a(Element element, String str, String str2) {
        return m3953a(element, str, false, str2);
    }

    private boolean m3955a(Element element, String str, boolean z) {
        return Boolean.parseBoolean(m3952a(element, str, String.valueOf(z)));
    }

    private int m3948a(Element element, String str, int i) {
        return Integer.parseInt(m3952a(element, str, String.valueOf(i)));
    }

    private Demand m3950a(Element element, String str, Demand demand) {
        return Demand.valueOf(m3952a(element, str, demand.name()).toUpperCase());
    }

    private AccessPermission m3949a(Element element, String str, AccessPermission accessPermission) {
        return AccessPermission.valueOf(m3952a(element, str, accessPermission.name()).toUpperCase());
    }

    private void m3954a(Element element, Plugin plugin) {
        plugin.m3929a(m3951a(element, "name"));
        plugin.m3932b(m3952a(element, "group", plugin.m3922a()));
        plugin.m3923a(m3948a(element, "versionCode", 0));
        plugin.m3935c(m3952a(element, "versionName", String.valueOf(plugin.m3930b())));
        plugin.m3931b(m3948a(element, "level", plugin.m3930b()));
        plugin.m3934c(m3948a(element, "minCapatibleLevel", plugin.m3933c()));
        plugin.m3924a(m3949a(element, "resources", AccessPermission.PRIVATE));
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == (short) 1) {
                Element element2 = (Element) item;
                String tagName = element2.getTagName();
                if ("dependencies".equals(tagName)) {
                    m3956b(element2, plugin);
                } else if ("extensions".equals(tagName)) {
                    m3957c(element2, plugin);
                } else if ("outlets".equals(tagName)) {
                    m3958d(element2, plugin);
                }
            }
        }
    }

    private void m3956b(Element element, Plugin plugin) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == (short) 1) {
                Element element2 = (Element) item;
                if ("dependency".equals(element2.getTagName())) {
                    boolean z;
                    Dependency dependency = new Dependency();
                    dependency.m3912a(m3951a(element2, "name"));
                    if (m3950a(element2, "resources", Demand.PROHIBITED) == Demand.REQUIRED) {
                        z = true;
                    } else {
                        z = false;
                    }
                    dependency.m3913a(z);
                    dependency.m3915b(m3955a(element2, "optional", false));
                    dependency.m3911a(m3948a(element2, "minLevel", 0));
                    dependency.m3914b(m3948a(element2, "targetLevel", 0));
                    plugin.m3925a(dependency);
                }
            }
        }
    }

    private void m3957c(Element element, Plugin plugin) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == (short) 1) {
                Element element2 = (Element) item;
                String tagName = element2.getTagName();
                if ("activity-extension".equals(tagName) || "function-extension".equals(tagName)) {
                    Extension extension = new Extension();
                    extension.m3917a(m3951a(element2, "name"));
                    extension.m3918b(m3951a(element2, "location"));
                    plugin.m3926a(extension);
                }
            }
        }
    }

    private void m3958d(Element element, Plugin plugin) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == (short) 1) {
                Element element2 = (Element) item;
                String tagName = element2.getTagName();
                if ("activity-outlet".equals(tagName) || "function-outlet".equals(tagName)) {
                    Outlet outlet = new Outlet();
                    outlet.m3921a(m3951a(element2, "name"));
                    outlet.m3920a(m3949a(element, "visibility", AccessPermission.PUBLIC));
                    plugin.m3927a(outlet);
                }
            }
        }
    }
}
