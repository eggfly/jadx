import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashSet;

public class tw {
    private static HashSet<String> DW;
    private static boolean FH;
    private static HashSet<String> j6;

    public static void j6(String str, String str2) {
        if (!FH) {
            if (str == null || str2 == null) {
                if (str != null) {
                    j6 = DW(str);
                }
                if (str2 != null) {
                    DW = DW(str2);
                }
                FH = true;
                return;
            }
            throw new RuntimeException("optimize and don't optimize lists  are mutually exclusive.");
        }
    }

    private static HashSet<String> DW(String str) {
        HashSet<String> hashSet = new HashSet();
        try {
            Reader fileReader = new FileReader(str);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    hashSet.add(readLine);
                } else {
                    fileReader.close();
                    return hashSet;
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException("Error with optimize list: " + str, e);
        }
    }

    public static boolean j6(String str) {
        if (j6 != null) {
            return j6.contains(str);
        }
        if (DW == null || !DW.contains(str)) {
            return true;
        }
        return false;
    }
}
