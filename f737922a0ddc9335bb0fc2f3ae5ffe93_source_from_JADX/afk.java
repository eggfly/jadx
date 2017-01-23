import com.google.android.gms.analytics.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class afk {
    Map<String, String> j6;

    public afk() {
        this.j6 = new HashMap();
    }

    public Map<String, String> j6(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.j6.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return n.j6(this.j6);
    }
}
