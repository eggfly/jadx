import com.aide.common.e;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class od extends oe<od> {
    public List<od$a> j6;

    protected /* synthetic */ oe DW(String str) {
        return j6(str);
    }

    protected od j6(String str) {
        return new od(str);
    }

    public static void j6(String str, List<od$a> list) {
        try {
            Node newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Object createElement = newDocument.createElement("classpath");
            newDocument.appendChild(createElement);
            for (od$a od_a : list) {
                Node createElement2 = newDocument.createElement("classpathentry");
                if (od_a.v5) {
                    createElement2.setAttribute("exported", "true");
                }
                createElement2.setAttribute("kind", od_a.FH);
                createElement2.setAttribute("path", od_a.Hw);
                createElement.appendChild(createElement2);
            }
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.transform(new DOMSource(newDocument), new StreamResult(new FileOutputStream(str)));
        } catch (Throwable e) {
            e.j6(e);
        }
    }

    public od() {
        this.j6 = new ArrayList();
    }

    private od(String str) {
        this.j6 = new ArrayList();
        try {
            this.j6 = new ArrayList();
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//classpathentry").evaluate(newInstance.newDocumentBuilder().parse(new File(str).toURI().toString()), XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node item = nodeList.item(i);
                Node namedItem = item.getAttributes().getNamedItem("kind");
                Node namedItem2 = item.getAttributes().getNamedItem("path");
                item = item.getAttributes().getNamedItem("exported");
                if (!(namedItem == null || namedItem2 == null)) {
                    boolean z;
                    String nodeValue = namedItem.getNodeValue();
                    String nodeValue2 = namedItem2.getNodeValue();
                    if (item == null || !"true".equals(item.getNodeValue())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.j6.add(new od$a(nodeValue, nodeValue2, z));
                }
            }
        } catch (Throwable e) {
            e.j6(e);
        }
    }
}
