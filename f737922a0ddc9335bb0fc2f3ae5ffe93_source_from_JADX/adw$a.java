import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class adw$a extends HttpEntityWrapper {
    private final long DW;
    private final adw j6;

    public adw$a(HttpEntity httpEntity, adw adw) {
        super(httpEntity);
        if (adw == null) {
            throw new IllegalArgumentException("'listener' is null");
        }
        this.j6 = adw;
        this.DW = httpEntity.getContentLength();
    }

    public void writeTo(OutputStream outputStream) {
        this.wrappedEntity.writeTo(new adw$a$a(this, outputStream));
    }
}
