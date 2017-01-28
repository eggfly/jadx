import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class atz {
    private final File DW;
    private long FH;
    private Map<String, atz$a> Hw;
    private final File j6;

    public static atz j6(awp awp) {
        File FH = awp.FH();
        if (FH == null) {
            FH = new File(".").getAbsoluteFile();
        }
        atz atz = new atz(FH, new File(new File(FH, ".ssh"), "config"));
        atz.DW();
        return atz;
    }

    atz(File file, File file2) {
        this.j6 = file;
        this.DW = file2;
        this.Hw = Collections.emptyMap();
    }

    public atz$a j6(String str) {
        atz$a atz_a;
        Map DW = DW();
        atz$a atz_a2 = (atz$a) DW.get(str);
        if (atz_a2 == null) {
            atz_a = new atz$a();
        } else {
            atz_a = atz_a2;
        }
        if (!atz_a.j6) {
            for (Entry entry : DW.entrySet()) {
                if (DW((String) entry.getKey()) && j6((String) entry.getKey(), str)) {
                    atz_a.j6((atz$a) entry.getValue());
                }
            }
            if (atz_a.DW == null) {
                atz_a.DW = str;
            }
            if (atz_a.v5 == null) {
                atz_a.v5 = j6();
            }
            if (atz_a.FH == 0) {
                atz_a.FH = 22;
            }
            atz_a.j6 = true;
        }
        return atz_a;
    }

    private synchronized Map<String, atz$a> DW() {
        long lastModified = this.DW.lastModified();
        if (lastModified != this.FH) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(this.DW);
                this.Hw = j6(fileInputStream);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                this.Hw = Collections.emptyMap();
            } catch (IOException e2) {
                this.Hw = Collections.emptyMap();
            } catch (Throwable th) {
                fileInputStream.close();
            }
            this.FH = lastModified;
        }
        return this.Hw;
    }

    private Map<String, atz$a> j6(InputStream inputStream) {
        Map<String, atz$a> linkedHashMap = new LinkedHashMap();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<atz$a> arrayList = new ArrayList(4);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return linkedHashMap;
            }
            readLine = readLine.trim();
            if (!(readLine.length() == 0 || readLine.startsWith("#"))) {
                String[] split = readLine.split("[ \t]*[= \t]", 2);
                String trim = split[0].trim();
                String trim2 = split[1].trim();
                int parseInt;
                if (axh.j6("Host", trim)) {
                    arrayList.clear();
                    for (String readLine2 : trim2.split("[ \t]")) {
                        String FH = FH(readLine2);
                        Object obj = (atz$a) linkedHashMap.get(FH);
                        if (obj == null) {
                            obj = new atz$a();
                            linkedHashMap.put(FH, obj);
                        }
                        arrayList.add(obj);
                    }
                } else if (!arrayList.isEmpty()) {
                    if (axh.j6("HostName", trim)) {
                        for (atz$a atz_a : arrayList) {
                            if (atz_a.DW == null) {
                                atz_a.DW = FH(trim2);
                            }
                        }
                    } else if (axh.j6("User", trim)) {
                        for (atz$a atz_a2 : arrayList) {
                            if (atz_a2.v5 == null) {
                                atz_a2.v5 = FH(trim2);
                            }
                        }
                    } else if (axh.j6("Port", trim)) {
                        try {
                            parseInt = Integer.parseInt(FH(trim2));
                            for (atz$a atz_a22 : arrayList) {
                                if (atz_a22.FH == 0) {
                                    atz_a22.FH = parseInt;
                                }
                            }
                        } catch (NumberFormatException e) {
                        }
                    } else if (axh.j6("IdentityFile", trim)) {
                        for (atz$a atz_a222 : arrayList) {
                            if (atz_a222.Hw == null) {
                                atz_a222.Hw = Zo(FH(trim2));
                            }
                        }
                    } else if (axh.j6("PreferredAuthentications", trim)) {
                        for (atz$a atz_a2222 : arrayList) {
                            if (atz_a2222.Zo == null) {
                                atz_a2222.Zo = Hw(FH(trim2));
                            }
                        }
                    } else if (axh.j6("BatchMode", trim)) {
                        for (atz$a atz_a22222 : arrayList) {
                            if (atz_a22222.VH == null) {
                                atz_a22222.VH = v5(FH(trim2));
                            }
                        }
                    } else if (axh.j6("StrictHostKeyChecking", trim)) {
                        trim = FH(trim2);
                        for (atz$a atz_a222222 : arrayList) {
                            if (atz_a222222.gn == null) {
                                atz_a222222.gn = trim;
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean DW(String str) {
        return str.indexOf(42) >= 0 || str.indexOf(63) >= 0;
    }

    private static boolean j6(String str, String str2) {
        try {
            amr amr = new amr(str, null);
            amr.j6(str2);
            return amr.DW();
        } catch (ale e) {
            return false;
        }
    }

    private static String FH(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    private static String Hw(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isSpaceChar(str.charAt(i))) {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private static Boolean v5(String str) {
        if (axh.j6("yes", str)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private File Zo(String str) {
        if (str.startsWith("~/")) {
            return new File(this.j6, str.substring(2));
        }
        File file = new File(str);
        return !file.isAbsolute() ? new File(this.j6, str) : file;
    }

    static String j6() {
        return (String) AccessController.doPrivileged(new atz$1());
    }
}
