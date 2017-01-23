import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.protocol.HttpContext;

class aej$b extends DefaultConnectionReuseStrategy {
    private aej$b() {
    }

    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        boolean z = true;
        if (httpResponse == null) {
            throw new IllegalArgumentException("HTTP response may not be null.");
        } else if (httpContext == null) {
            throw new IllegalArgumentException("HTTP context may not be null.");
        } else {
            ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
            Header firstHeader = httpResponse.getFirstHeader("Transfer-Encoding");
            if (firstHeader == null) {
                Header[] headers = httpResponse.getHeaders("Content-Length");
                if (headers == null || headers.length != 1) {
                    return false;
                }
                try {
                    if (Integer.parseInt(headers[0].getValue()) < 0) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            } else if (!"chunked".equalsIgnoreCase(firstHeader.getValue())) {
                return false;
            }
            HeaderIterator headerIterator = httpResponse.headerIterator("Connection");
            if (!headerIterator.hasNext()) {
                headerIterator = httpResponse.headerIterator("Proxy-Connection");
            }
            if (headerIterator.hasNext()) {
                try {
                    TokenIterator createTokenIterator = createTokenIterator(headerIterator);
                    boolean z2 = false;
                    while (createTokenIterator.hasNext()) {
                        String nextToken = createTokenIterator.nextToken();
                        if ("Close".equalsIgnoreCase(nextToken)) {
                            return false;
                        }
                        if ("Keep-Alive".equalsIgnoreCase(nextToken)) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        return true;
                    }
                } catch (ParseException e2) {
                    return false;
                }
            }
            if (protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                z = false;
            }
            return z;
        }
    }
}
