import com.aide.analytics.a;
import com.aide.licensing.IAideLicensingService;
import com.aide.ui.e;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ob extends oa {
    public ob() {
        super("com.aide.premium.key", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkjXTkIvABlLJgyvluBm4h4Ytw87BbBrSRXohMVMvk0Eq2pYJKT1jYfC1W65/YY5GcFYwMiaemVlpH40h/h+rkm+GYYq04awtN8zv35+HymbrW6ztGgNv7gF7ksAOOb8swqQwlx6uzfZWzbny7r9kkKURlXWmpkcKpWUjfoQ1MIRFxuXoJ2owTjvdkezI2hjCxC+NJ57QCG8tBoWJo5jscDRylHuaXBGVX7fJx7NsWzlk9xTXUFE7F8J5OaPRpgCNwo+xC0pXSoA/yCv1dOy4v2tPr9L9rfB95nrTwRs1ob44LOY3UqYgVMC1wpy+nxU6UGch8g8/DfHXfaefBcsbfwIDAQAB", 106, IAideLicensingService.class.getName());
    }

    protected void j6(long j) {
        io.j6("Setting premium key valid until " + new Date(j).toString());
        e.Mr().j6(j);
        Map hashMap = new HashMap();
        hashMap.put("validDays", Long.toString((j - System.currentTimeMillis()) / 86400000));
        a.j6("Premium key valid", hashMap);
    }

    protected void j6(String str) {
        io.j6("Setting premium key not valid - " + str);
        e.Mr().we();
        Map hashMap = new HashMap();
        hashMap.put("reason", str);
        a.j6("Premium key not valid", hashMap);
    }

    protected void j6() {
        e.Mr().J0();
    }
}
