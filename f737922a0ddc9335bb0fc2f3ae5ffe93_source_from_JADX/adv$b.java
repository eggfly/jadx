import java.util.Map;
import org.apache.http.client.methods.HttpUriRequest;

protected final class adv$b implements adv$g {
    private final aem DW;
    private final HttpUriRequest j6;

    public adv$b(HttpUriRequest httpUriRequest, aem aem) {
        this.j6 = httpUriRequest;
        this.DW = aem;
    }

    public adv$e j6() {
        try {
            return new adv$e((Map) adx.j6(adx.j6(this.DW, this.j6, 180000)));
        } catch (aeb e) {
            if (this.j6.isAborted()) {
                throw new aed(-1);
            }
            throw e;
        }
    }
}
