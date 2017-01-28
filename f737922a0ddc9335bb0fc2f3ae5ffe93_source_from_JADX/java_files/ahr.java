import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ahr {
    static DateFormat j6;

    static {
        j6 = new SimpleDateFormat("MM-dd-yy HH:mm");
    }

    public static void j6(agz agz) {
        agz.Hw(" Length   Method    Size  Ratio   Date   Time   CRC-32    Name");
        agz.Hw("--------  ------  ------- -----   ----   ----   ------    ----");
    }

    public static void j6(agz agz, ahn ahn) {
        int we;
        if (ahn.we() > 0) {
            we = ((ahn.we() - ahn.EQ()) * 100) / ahn.we();
        } else {
            we = 0;
        }
        String str = "%8d  %6s %8d %4d%% %s  %08x  %s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(ahn.we());
        objArr[1] = ahn.u7() == (short) 0 ? "Stored" : "Defl:N";
        objArr[2] = Integer.valueOf(ahn.EQ());
        objArr[3] = Integer.valueOf(we);
        objArr[4] = j6.format(new Date(ahn.Zo()));
        objArr[5] = Integer.valueOf(ahn.tp());
        objArr[6] = ahn.gn();
        agz.Hw(String.format(str, objArr));
    }
}
