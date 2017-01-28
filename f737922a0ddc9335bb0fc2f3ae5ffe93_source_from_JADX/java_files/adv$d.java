import java.io.FilterInputStream;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

public class adv$d extends FilterInputStream {
    private final adv$c DW;
    private final HttpUriRequest j6;

    public adv$d(HttpUriRequest httpUriRequest, HttpResponse httpResponse) {
        super(null);
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null) {
            throw new aea("Didn't get entity from HttpResponse");
        }
        try {
            this.in = entity.getContent();
            this.j6 = httpUriRequest;
            this.DW = new adv$c(null);
        } catch (IOException e) {
            throw new aeb(e);
        }
    }

    public void close() {
        this.j6.abort();
    }
}
