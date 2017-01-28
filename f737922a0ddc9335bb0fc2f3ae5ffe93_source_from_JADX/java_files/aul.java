import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class aul extends aua {
    private Map<String, aus> v5;

    public aul() {
        this.v5 = Collections.emptyMap();
    }

    public Collection<aus> FH() {
        return Collections.unmodifiableCollection(this.v5.values());
    }

    void j6(Map<String, aus> map) {
        this.v5 = map;
    }
}
