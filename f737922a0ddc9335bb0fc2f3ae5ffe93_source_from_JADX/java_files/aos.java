import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class aos {
    public void j6(OutputStream outputStream, aou<ake> aou_ake, List<String> list, String str) {
        Object obj = aou_ake.j6().size() == 3 ? 1 : null;
        Iterator it = aou_ake.iterator();
        String str2 = null;
        while (it.hasNext()) {
            aor aor = (aor) it.next();
            ake ake = (ake) aou_ake.j6().get(aor.j6());
            if (!(str2 == null || aor.Hw() == aor$a.NEXT_CONFLICTING_RANGE)) {
                outputStream.write((">>>>>>> " + str2 + "\n").getBytes(str));
                str2 = null;
            }
            if (aor.Hw() == aor$a.FIRST_CONFLICTING_RANGE) {
                outputStream.write(("<<<<<<< " + ((String) list.get(aor.j6())) + "\n").getBytes(str));
                str2 = (String) list.get(aor.j6());
            } else if (aor.Hw() == aor$a.NEXT_CONFLICTING_RANGE) {
                String str3;
                str2 = (String) list.get(aor.j6());
                if (obj != null) {
                    str3 = "=======\n";
                } else {
                    str3 = "======= " + str2 + "\n";
                }
                outputStream.write(str3.getBytes(str));
            }
            for (int DW = aor.DW(); DW < aor.FH(); DW++) {
                ake.j6(outputStream, DW);
                outputStream.write(10);
            }
        }
        if (str2 != null) {
            outputStream.write((">>>>>>> " + str2 + "\n").getBytes(str));
        }
    }
}
