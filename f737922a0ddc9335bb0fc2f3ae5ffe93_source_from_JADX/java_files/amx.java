import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class amx {
    private final List<amy> j6;

    public amx() {
        this.j6 = new ArrayList();
    }

    public amx(List<amy> list) {
        this.j6 = list;
    }

    public void j6(InputStream inputStream) {
        BufferedReader DW = DW(inputStream);
        while (true) {
            String readLine = DW.readLine();
            if (readLine != null) {
                readLine = readLine.trim();
                if (readLine.length() > 0 && !readLine.startsWith("#")) {
                    this.j6.add(new amy(readLine));
                }
            } else {
                return;
            }
        }
    }

    private static BufferedReader DW(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream, anj.DW));
    }

    public List<amy> j6() {
        return Collections.unmodifiableList(this.j6);
    }

    public amx$a j6(String str, boolean z) {
        if (this.j6.isEmpty()) {
            return amx$a.CHECK_PARENT;
        }
        int size = this.j6.size() - 1;
        while (size > -1) {
            amy amy = (amy) this.j6.get(size);
            if (!amy.j6(str, z)) {
                size--;
            } else if (amy.j6()) {
                return amx$a.IGNORED;
            } else {
                return amx$a.NOT_IGNORED;
            }
        }
        return amx$a.CHECK_PARENT;
    }
}
