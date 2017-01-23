import com.aide.common.e;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class ol extends oe<ol> {
    public List<ol$a> DW;
    public Integer FH;
    public boolean Hw;
    public List<ol$a> j6;

    protected /* synthetic */ oe DW(String str) {
        return j6(str);
    }

    public static void j6(String str, String str2, String str3) {
        try {
            List<String> arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                ol$a FH = FH(readLine);
                if (FH == null || !str3.equals(FH.j6(str2))) {
                    arrayList.add(readLine);
                }
            }
            bufferedReader.close();
            FileWriter fileWriter = new FileWriter(str);
            for (String write : arrayList) {
                fileWriter.write(write);
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (Throwable e) {
            e.j6(e);
        }
    }

    public static void DW(String str, String str2, String str3) {
        try {
            FileWriter fileWriter = new FileWriter(str, true);
            fileWriter.write("\n");
            fileWriter.write("android.library.reference.1=" + qh.Zo(str2, str3));
            fileWriter.close();
        } catch (Throwable e) {
            e.j6(e);
        }
    }

    private static ol$a FH(String str) {
        if (str.startsWith("android.library.reference.")) {
            int lastIndexOf = str.lastIndexOf(61);
            if (lastIndexOf > 0) {
                return new ol$a(str.substring(lastIndexOf + 1, str.length()).trim(), true);
            }
        }
        return null;
    }

    protected ol j6(String str) {
        return new ol(str);
    }

    private ol(String str) {
        this.j6 = new ArrayList();
        this.DW = new ArrayList();
        this.Hw = false;
        this.FH = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                ol$a FH = FH(readLine);
                if (FH != null) {
                    this.j6.add(FH);
                } else {
                    try {
                        if (readLine.startsWith("source.dir=")) {
                            for (String ol_a : readLine.substring("source.dir=".length()).trim().split(";")) {
                                this.DW.add(new ol$a(ol_a, false));
                            }
                        } else if (readLine.startsWith("target=")) {
                            readLine = readLine.substring("target=".length()).trim();
                            if (readLine.startsWith("Google Inc.:Google APIs:")) {
                                this.Hw = true;
                                readLine = readLine.substring("Google Inc.:Google APIs:".length());
                            } else if (readLine.startsWith("android-")) {
                                this.Hw = false;
                                readLine = readLine.substring("android-".length());
                            } else {
                                readLine = null;
                            }
                            if (readLine != null) {
                                try {
                                    this.FH = Integer.valueOf(Integer.parseInt(readLine));
                                } catch (NumberFormatException e) {
                                }
                            }
                        } else {
                            continue;
                        }
                    } catch (Throwable e2) {
                        e.j6(e2);
                        return;
                    }
                }
            }
            bufferedReader.close();
            return;
        }
    }
}
