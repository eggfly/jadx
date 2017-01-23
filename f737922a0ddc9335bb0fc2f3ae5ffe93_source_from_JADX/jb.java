import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class jb extends oe<jb> {
    public List<iw$g> j6;

    protected /* synthetic */ oe DW(String str) {
        return j6(str);
    }

    public jb() {
        this.j6 = new ArrayList();
    }

    protected jb j6(String str) {
        return new jb(str);
    }

    private jb(String str) {
        this.j6 = new ArrayList();
        try {
            InputStream fileInputStream = new FileInputStream(str);
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream);
            fileInputStream.close();
            NodeList elementsByTagName = parse.getElementsByTagName("dependency");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                try {
                    Element element = (Element) elementsByTagName.item(i);
                    String j6 = j6(element, "groupId");
                    String j62 = j6(element, "artifactId");
                    String j63 = j6(element, "version");
                    String j64 = j6(element, "scope");
                    if (!(j6.length() <= 0 || j62.length() <= 0 || j6.contains("$") || j62.contains("$") || "test".equals(j64) || "provided".equals(j64) || "system".equals(j64))) {
                        if (j63.length() == 0 || j63.contains("$")) {
                            j64 = "+";
                        } else {
                            j64 = j63;
                        }
                        iw$g iw_g = new iw$g(1);
                        this.j6.add(iw_g);
                        iw_g.j6 = j6;
                        iw_g.DW = j62;
                        iw_g.Hw = j64;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String j6(Element element, String str) {
        Node item = element.getElementsByTagName(str).item(0);
        if (item == null) {
            return "";
        }
        return item.getTextContent();
    }
}
