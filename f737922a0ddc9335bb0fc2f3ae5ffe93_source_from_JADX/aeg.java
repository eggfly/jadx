import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class aeg extends aea {
    public int DW;
    public String FH;
    public String Hw;
    public Map<String, Object> Zo;
    public aeg$a j6;
    public String v5;

    public aeg(HttpResponse httpResponse) {
        fillInStackTrace();
        StatusLine statusLine = httpResponse.getStatusLine();
        this.DW = statusLine.getStatusCode();
        this.FH = statusLine.getReasonPhrase();
        this.Hw = j6(httpResponse, "server");
        this.v5 = j6(httpResponse, "location");
    }

    public aeg(HttpResponse httpResponse, Object obj) {
        this(httpResponse);
        if (obj != null && (obj instanceof Map)) {
            this.Zo = (Map) obj;
            this.j6 = new aeg$a(this.Zo);
        }
    }

    public String toString() {
        return "DropboxServerException (" + this.Hw + "): " + this.DW + " " + this.FH + " (" + this.j6.j6 + ")";
    }

    public static boolean j6(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 302) {
            String j6 = j6(httpResponse, "location");
            if (j6 != null) {
                int indexOf = j6.indexOf("://");
                if (indexOf > -1) {
                    j6 = j6.substring(indexOf + 3);
                    indexOf = j6.indexOf("/");
                    if (indexOf > -1 && j6.substring(0, indexOf).toLowerCase().contains("dropbox.com")) {
                        return true;
                    }
                }
            }
        } else if (statusCode == 304) {
            return true;
        }
        return false;
    }

    private static String j6(HttpResponse httpResponse, String str) {
        Header firstHeader = httpResponse.getFirstHeader(str);
        if (firstHeader != null) {
            return firstHeader.getValue();
        }
        return null;
    }
}
