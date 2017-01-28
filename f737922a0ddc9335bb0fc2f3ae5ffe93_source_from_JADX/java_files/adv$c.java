import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public final class adv$c {
    private long DW;
    private String FH;
    private adv$e Hw;
    private String j6;

    private adv$c(HttpResponse httpResponse) {
        this.j6 = null;
        this.DW = -1;
        this.FH = null;
        this.Hw = null;
        this.Hw = j6(httpResponse);
        if (this.Hw == null) {
            throw new aec("Error parsing metadata.");
        }
        this.DW = j6(httpResponse, this.Hw);
        if (this.DW == -1) {
            throw new aec("Error determining file size.");
        }
        Header firstHeader = httpResponse.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (value != null) {
                String[] split = value.split(";");
                if (split.length > 0) {
                    this.j6 = split[0].trim();
                }
                if (split.length > 1) {
                    split = split[1].split("=");
                    if (split.length > 1) {
                        this.FH = split[1].trim();
                    }
                }
            }
        }
    }

    private static adv$e j6(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return null;
        }
        Header firstHeader = httpResponse.getFirstHeader("X-Dropbox-Metadata");
        if (firstHeader == null) {
            return null;
        }
        Object j6 = axy.j6(firstHeader.getValue());
        if (j6 == null) {
            return null;
        }
        return new adv$e((Map) j6);
    }

    private static long j6(HttpResponse httpResponse, adv$e adv_e) {
        long contentLength = httpResponse.getEntity().getContentLength();
        if (contentLength >= 0) {
            return contentLength;
        }
        if (adv_e != null) {
            return adv_e.j6;
        }
        return -1;
    }
}
