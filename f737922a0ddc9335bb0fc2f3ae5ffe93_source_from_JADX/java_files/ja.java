import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ja extends oe<ja> {
    public List<String> j6;

    protected /* synthetic */ oe DW(String str) {
        return j6(str);
    }

    public ja() {
        this.j6 = new ArrayList();
    }

    protected ja j6(String str) {
        return new ja(str);
    }

    private ja(String str) {
        this.j6 = new ArrayList();
        try {
            InputStream fileInputStream = new FileInputStream(str);
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream);
            fileInputStream.close();
            Element element = (Element) parse.getElementsByTagName("versions").item(0);
            if (element != null) {
                NodeList elementsByTagName = element.getElementsByTagName("version");
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    this.j6.add(((Element) elementsByTagName.item(i)).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String FH(String str) {
        for (int size = this.j6.size() - 1; size >= 0; size--) {
            if (j6((String) this.j6.get(size), str)) {
                return (String) this.j6.get(size);
            }
        }
        return null;
    }

    public static boolean j6(String str, String str2) {
        if (str2 == null || str2.equals(str)) {
            return true;
        }
        return str2.contains("+") ? str.startsWith(str2.substring(0, str2.indexOf(43))) : false;
    }

    public static String j6(ArrayList<String> arrayList, String str) {
        Collections.sort(arrayList, new ja$1());
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (j6((String) arrayList.get(size), str)) {
                return (String) arrayList.get(size);
            }
        }
        return null;
    }
}
