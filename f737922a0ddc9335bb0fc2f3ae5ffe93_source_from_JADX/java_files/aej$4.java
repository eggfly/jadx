import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

class aej$4 implements HttpResponseInterceptor {
    final /* synthetic */ aej j6;

    aej$4(aej aej) {
        this.j6 = aej;
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                for (HeaderElement name : contentEncoding.getElements()) {
                    if (name.getName().equalsIgnoreCase("gzip")) {
                        httpResponse.setEntity(new aej$d(httpResponse.getEntity()));
                        return;
                    }
                }
            }
        }
    }
}
