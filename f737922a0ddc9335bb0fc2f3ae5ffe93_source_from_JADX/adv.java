import java.io.InputStream;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.InputStreamEntity;

public class adv<SESS_T extends aem> {
    public static final String j6;
    protected final SESS_T DW;

    static {
        j6 = ady.j6();
    }

    public adv(SESS_T sess_t) {
        if (sess_t == null) {
            throw new IllegalArgumentException("Session must not be null.");
        }
        this.DW = sess_t;
    }

    public SESS_T j6() {
        return this.DW;
    }

    public adv$a DW() {
        FH();
        return new adv$a((Map) adx.j6(adx$a.GET, this.DW.EQ(), "/account/info", 1, new String[]{"locale", this.DW.VH().toString()}, this.DW));
    }

    public adv$d j6(String str, String str2) {
        FH();
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        HttpUriRequest httpGet = new HttpGet(adx.j6(this.DW.we(), 1, "/files/" + this.DW.Zo() + str, new String[]{"rev", str2, "locale", this.DW.VH().toString()}));
        this.DW.j6((HttpRequest) httpGet);
        return new adv$d(httpGet, adx.j6(this.DW, httpGet));
    }

    public adv$e j6(String str, InputStream inputStream, long j, String str2, adw adw) {
        return DW(str, inputStream, j, str2, adw).j6();
    }

    public adv$g DW(String str, InputStream inputStream, long j, String str2, adw adw) {
        return j6(str, inputStream, j, false, str2, adw);
    }

    public adv$e j6(String str, InputStream inputStream, long j, adw adw) {
        return DW(str, inputStream, j, adw).j6();
    }

    public adv$g DW(String str, InputStream inputStream, long j, adw adw) {
        return j6(str, inputStream, j, true, null, adw);
    }

    public adv$e j6(String str, int i, String str2, boolean z, String str3) {
        FH();
        if (i <= 0) {
            i = 25000;
        }
        String[] strArr = new String[]{"file_limit", String.valueOf(i), "hash", str2, "list", String.valueOf(z), "rev", str3, "locale", this.DW.VH().toString()};
        return new adv$e((Map) adx.j6(adx$a.GET, this.DW.EQ(), "/metadata/" + this.DW.Zo() + str, 1, strArr, this.DW));
    }

    public adv$e j6(String str) {
        FH();
        return new adv$e((Map) adx.j6(adx$a.POST, this.DW.EQ(), "/fileops/create_folder", 1, new String[]{"root", this.DW.Zo().toString(), "path", str, "locale", this.DW.VH().toString()}, this.DW));
    }

    public void DW(String str) {
        FH();
        adx.j6(adx$a.POST, this.DW.EQ(), "/fileops/delete", 1, new String[]{"root", this.DW.Zo().toString(), "path", str, "locale", this.DW.VH().toString()}, this.DW);
    }

    protected static boolean j6(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj == null || !(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    private adv$g j6(String str, InputStream inputStream, long j, boolean z, String str2, adw adw) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("path is null or empty.");
        }
        HttpEntity adw_a;
        FH();
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        String str3 = "/files_put/" + this.DW.Zo() + str;
        if (str2 == null) {
            str2 = "";
        }
        HttpRequest httpPut = new HttpPut(adx.j6(this.DW.we(), 1, str3, new String[]{"overwrite", String.valueOf(z), "parent_rev", str2, "locale", this.DW.VH().toString()}));
        this.DW.j6(httpPut);
        HttpEntity inputStreamEntity = new InputStreamEntity(inputStream, j);
        inputStreamEntity.setContentEncoding("application/octet-stream");
        inputStreamEntity.setChunked(false);
        if (adw != null) {
            adw_a = new adw$a(inputStreamEntity, adw);
        } else {
            adw_a = inputStreamEntity;
        }
        httpPut.setEntity(adw_a);
        return new adv$b(httpPut, this.DW);
    }

    protected void FH() {
        if (!this.DW.gn()) {
            throw new aeh();
        }
    }

    protected static long DW(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj != null) {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            if (obj instanceof String) {
                return Long.parseLong((String) obj, 16);
            }
        }
        return 0;
    }
}
