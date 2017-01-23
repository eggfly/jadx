import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class aej$3 implements HttpRequestInterceptor {
    final /* synthetic */ aej j6;

    aej$3(aej aej) {
        this.j6 = aej;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip");
        }
    }
}
