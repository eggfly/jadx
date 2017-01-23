import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.jgit.JGitText;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

final class ate$a extends DefaultHandler {
    boolean DW;
    final /* synthetic */ ate FH;
    private final String Hw;
    private StringBuilder Zo;
    final List<String> j6;
    private final String v5;

    ate$a(ate ate, String str, String str2) {
        this.FH = ate;
        this.j6 = new ArrayList();
        this.Hw = str;
        this.v5 = str2;
    }

    void j6() {
        Map treeMap = new TreeMap();
        if (this.v5.length() > 0) {
            treeMap.put("prefix", this.v5);
        }
        if (!this.j6.isEmpty()) {
            treeMap.put("marker", this.v5 + ((String) this.j6.get(this.j6.size() - 1)));
        }
        int i = 0;
        while (i < this.FH.Zo) {
            HttpURLConnection j6 = this.FH.j6("GET", this.Hw, "", treeMap);
            this.FH.j6(j6);
            switch (aww.j6(j6)) {
                case 200:
                    this.DW = false;
                    this.Zo = null;
                    try {
                        XMLReader createXMLReader = XMLReaderFactory.createXMLReader();
                        createXMLReader.setContentHandler(this);
                        InputStream inputStream = j6.getInputStream();
                        try {
                            createXMLReader.parse(new InputSource(inputStream));
                            inputStream.close();
                            return;
                        } catch (Throwable e) {
                            IOException iOException = new IOException(MessageFormat.format(JGitText.j6().errorListing, new Object[]{this.v5}));
                            iOException.initCause(e);
                            throw iOException;
                        } catch (Throwable th) {
                            inputStream.close();
                        }
                    } catch (SAXException e2) {
                        throw new IOException(JGitText.j6().noXMLParserAvailable);
                    }
                case 500:
                    i++;
                default:
                    throw this.FH.j6("Listing", this.v5, j6);
            }
        }
        throw this.FH.Hw("Listing", this.v5);
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if ("Key".equals(str2) || "IsTruncated".equals(str2)) {
            this.Zo = new StringBuilder();
        }
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        if (this.Zo != null) {
            this.Zo.append(cArr, i, i2);
        }
    }

    public void characters(char[] cArr, int i, int i2) {
        if (this.Zo != null) {
            this.Zo.append(cArr, i, i2);
        }
    }

    public void endElement(String str, String str2, String str3) {
        if ("Key".equals(str2)) {
            this.j6.add(this.Zo.toString().substring(this.v5.length()));
        } else if ("IsTruncated".equals(str2)) {
            this.DW = axh.j6("true", this.Zo.toString());
        }
        this.Zo = null;
    }
}
