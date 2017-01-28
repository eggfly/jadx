import com.aide.common.e;
import com.aide.common.n;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class iv extends oe<iv> {
    private Document j6;

    protected /* synthetic */ oe DW(String str) {
        return j6(str);
    }

    private iv(String str) {
        InputStream fileInputStream = new FileInputStream(str);
        this.j6 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream);
        fileInputStream.close();
    }

    protected iv j6(String str) {
        return new iv(str);
    }

    public static String j6(String str, iw iwVar, String str2) {
        try {
            Document document = new iv(str).j6;
            j6(document, iwVar, str2);
            return j6(document);
        } catch (Throwable e) {
            e.j6(e);
            return "";
        }
    }

    public static int DW(String str, iw iwVar, String str2) {
        try {
            Document document = new iv(str).j6;
            j6(document, iwVar, str2);
            return Hw(document);
        } catch (Throwable e) {
            e.j6(e);
            return 1;
        }
    }

    private static String j6(Document document, String str, String str2) {
        NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile(str).evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node namedItem = nodeList.item(i).getAttributes().getNamedItem(str2);
            if (namedItem != null) {
                return namedItem.getNodeValue();
            }
        }
        return null;
    }

    private static String j6(Document document) {
        return j6(document, "//manifest", "package");
    }

    private static String DW(Document document) {
        return j6(document, "//manifest", "android:versionName");
    }

    private static String FH(Document document) {
        return j6(document, "//manifest", "android:versionCode");
    }

    private static int Hw(Document document) {
        String j6 = j6(document, "//manifest//uses-sdk", "android:minSdkVersion");
        if (j6 != null) {
            return Integer.parseInt(j6);
        }
        return 1;
    }

    public static boolean j6(String str, String str2, iw iwVar, String str3) {
        try {
            Document document = new iv(str).j6;
            j6(document, iwVar, str3);
            return jd.j6(str2, j6(document), FH(document), DW(document));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean j6(String str, String str2, iw iwVar, String str3, String str4) {
        try {
            Document document = new iv(str).j6;
            if (iwVar != null) {
                j6(document, iwVar, str4);
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new iy().j6(document, byteArrayOutputStream);
            String replace = byteArrayOutputStream.toString().replace("${applicationId}", str3).replace("${packageName}", str3);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new n(str2));
            outputStreamWriter.write(replace);
            outputStreamWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void j6(Document document, iw iwVar, String str) {
        if (iwVar != null) {
            Element j6 = j6(document, "manifest");
            j6(j6, "package", iwVar.Hw(str));
            j6(j6, "android:versionCode", iwVar.v5(str));
            j6(j6, "android:versionName", iwVar.VH(str));
            if (iwVar.J0 != null) {
                j6 = j6(document, "manifest/application/meta-data", true);
                j6.setAttribute("android:name", "com.google.android.wearable.beta.app");
                j6.setAttribute("android:resource", "@xml/wearable_app_desc");
            }
            j6 = j6(document, "manifest/uses-sdk");
            if (iwVar.FH(str) != null) {
                j6(j6, "android:minSdkVersion", iwVar.FH(str));
            } else if (!j6.hasAttribute("android:minSdkVersion")) {
                j6(j6, "android:minSdkVersion", "1");
            }
            if (iwVar.j6(str) != null) {
                j6(j6, "android:targetSdkVersion", iwVar.j6(str));
            } else if (!j6.hasAttribute("android:targetSdkVersion")) {
                j6(j6, "android:targetSdkVersion", "1");
            }
        }
    }

    private static void j6(Element element, String str, String str2) {
        if (str2 != null) {
            element.setAttribute(str, str2);
        }
    }

    private static Element j6(Document document, String str) {
        return j6(document, str, false);
    }

    private static Element j6(Document document, String str, boolean z) {
        String[] split = str.split("/");
        int i = 0;
        Node node = document;
        while (i < split.length) {
            Node item;
            NodeList childNodes = node.getChildNodes();
            Node node2 = null;
            int i2 = 0;
            while (i2 < childNodes.getLength()) {
                Element element;
                item = childNodes.item(i2);
                if (item instanceof Element) {
                    Element element2;
                    if (node2 == null) {
                        element2 = (Element) item;
                    } else {
                        Node node3 = node2;
                    }
                    if ((!z || i < split.length - 1) && split[i].equals(((Element) item).getNodeName())) {
                        break;
                    }
                    element = element2;
                } else {
                    item = node2;
                }
                i2++;
                Object obj = element;
            }
            if (node2 != null) {
                item = node.insertBefore(document.createElement(split[i]), node2);
            } else {
                item = node.appendChild(document.createElement(split[i]));
            }
            i++;
            node = item;
        }
        return (Element) node;
    }
}
