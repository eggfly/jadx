import com.google.android.gms.analytics.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class afj {
    Map<String, String> j6;

    public Map<String, String> j6() {
        return new HashMap(this.j6);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.j6.entrySet()) {
            if (((String) entry.getKey()).startsWith("&")) {
                hashMap.put(((String) entry.getKey()).substring(1), (String) entry.getValue());
            } else {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return n.j6(hashMap);
    }
}
