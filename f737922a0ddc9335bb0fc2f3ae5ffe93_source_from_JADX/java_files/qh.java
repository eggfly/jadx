import android.os.Environment;
import com.aide.common.w;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class qh {
    private static fa j6;

    static {
        j6 = new fa();
    }

    public static void j6(String str) {
        File file = new File(str);
        if (file.exists() && !file.setLastModified(System.currentTimeMillis())) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                long length = randomAccessFile.length();
                randomAccessFile.setLength(1 + length);
                randomAccessFile.setLength(length);
            } finally {
                randomAccessFile.close();
            }
        }
    }

    public static boolean j6(long j, long j2) {
        long abs = Math.abs(j - j2);
        if (abs <= 1000) {
            return true;
        }
        if (abs % 3600000 <= 0) {
            if (abs > 46800000) {
                return false;
            }
            return true;
        } else if ((abs - 1000) % 3600000 == 0) {
            if (abs > 46800000) {
                return false;
            }
            return true;
        } else if ((abs + 1000) % 3600000 != 0) {
            return false;
        } else {
            if (abs > 46800000) {
                return false;
            }
            return true;
        }
    }

    public static boolean DW(String str) {
        if (gn(str)) {
            return false;
        }
        long length = new File(str).length();
        int i = 8000 < length ? 8000 : (int) length;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[i];
            new DataInputStream(fileInputStream).readFully(bArr);
            for (byte b : bArr) {
                if (b == null) {
                    fileInputStream.close();
                    return true;
                }
            }
            fileInputStream.close();
            return false;
        } catch (IOException e) {
            return false;
        } catch (Throwable th) {
            fileInputStream.close();
        }
    }

    public static Reader FH(String str) {
        if (J0(str)) {
            return new FileReader(str);
        }
        if (gn(str)) {
            return gW(str);
        }
        throw new IOException();
    }

    public static boolean j6(String str, String str2) {
        Reader FH;
        try {
            Pattern compile = Pattern.compile(str);
            FH = FH(str2);
            BufferedReader bufferedReader = new BufferedReader(FH);
            CharSequence readLine;
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    FH.close();
                    return false;
                }
            } while (!compile.matcher(readLine).find());
            FH.close();
            return true;
        } catch (IOException e) {
            return false;
        } catch (Throwable th) {
            FH.close();
        }
    }

    private static String er(String str) {
        if (yS(str)) {
            return str;
        }
        do {
            str = v5(str);
            if (str == null) {
                return null;
            }
        } while (!yS(str));
        return str;
    }

    private static boolean yS(String str) {
        return new File(str).isFile() && (str.endsWith(".jar") || str.endsWith(".zip"));
    }

    private static Reader gW(String str) {
        return new qh$1(j6.j6(er(str), BT(str), null));
    }

    private static String BT(String str) {
        String er = er(str);
        if (er.length() == str.length()) {
            return "";
        }
        return str.substring(er.length() + 1, str.length());
    }

    public static String j6(Reader reader) {
        char[] cArr = new char[4096];
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = reader.read(cArr);
            if (read <= 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(cArr, 0, read);
        }
    }

    public static void j6(String str, Reader reader) {
        FileWriter fileWriter = new FileWriter(str, false);
        fileWriter.append(j6(reader));
        fileWriter.close();
    }

    public static boolean Hw(String str) {
        return str.equals("/");
    }

    public static String v5(String str) {
        if (str.length() == 0 || str.equals("/")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf == 0) {
            return "/";
        }
        if (lastIndexOf != -1) {
            return str.substring(0, lastIndexOf);
        }
        return null;
    }

    public static String Zo(String str) {
        return str.substring(str.lastIndexOf(47) + 1);
    }

    public static boolean VH(String str) {
        return new File(str).exists() || gn(str);
    }

    public static boolean gn(String str) {
        return er(str) != null && j6.FH(str);
    }

    public static boolean u7(String str) {
        return (er(str) == null || j6.FH(str)) ? false : true;
    }

    public static boolean tp(String str) {
        return er(str) != null;
    }

    public static boolean EQ(String str) {
        return we(str) || u7(str);
    }

    public static boolean we(String str) {
        return new File(str).isDirectory();
    }

    public static boolean J0(String str) {
        return new File(str).isFile() && !yS(str);
    }

    public static boolean J8(String str) {
        return (J0(str) || gn(str)) && !yS(str);
    }

    public static List<String> Ws(String str) {
        List<String> arrayList = new ArrayList();
        for (String str2 : QX(str)) {
            if (EQ(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static List<String> QX(String str) {
        if (tp(str)) {
            List<String> j6 = j6.j6(er(str), BT(str));
            return j6 == null ? new ArrayList() : j6;
        } else {
            String[] list = new File(str).list();
            if (list == null) {
                return new ArrayList();
            }
            String[] strArr = new String[list.length];
            String str2 = str.equals("/") ? "/" : str + File.separator;
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = str2 + list[i];
            }
            return Arrays.asList(strArr);
        }
    }

    public static String DW(String str, String str2) {
        if (str.equals(str2)) {
            return "";
        }
        return str2.substring(str.length() + 1, str2.length());
    }

    public static boolean FH(String str, String str2) {
        return str2 != null && (str2.equals(str) || str2.startsWith(str + "/"));
    }

    public static String j6(String str, String str2, String str3) {
        return str3 + str.substring(str2.length(), str.length());
    }

    public static void Hw(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            throw new IOException(str2 + " already exists");
        } else if (!new File(str).renameTo(file)) {
            throw new IOException(str + " could not be renamed");
        }
    }

    public static void XL(String str) {
        if (!new File(str).mkdir()) {
            throw new IOException(str + " could not be created");
        }
    }

    public static void aM(String str) {
        if (new File(str).exists()) {
            throw new IOException(str + " already exists");
        }
        new File(str).createNewFile();
    }

    public static void v5(String str, String str2) {
        if (new File(str).exists()) {
            throw new IOException(str + " already exists");
        }
        FileWriter fileWriter = new FileWriter(str);
        fileWriter.write(str2);
        fileWriter.close();
    }

    public static void j3(String str) {
        DW(new File(str));
    }

    private static void DW(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String file2 : list) {
                    DW(new File(file, file2));
                }
            }
        }
        if (!file.delete()) {
            throw new IOException(file.getPath() + " could not be deleted");
        }
    }

    public static boolean Mr(String str) {
        return new File(str).mkdirs();
    }

    public static long U2(String str) {
        return new File(str).lastModified();
    }

    public static long a8(String str) {
        return new File(str).length();
    }

    public static String lg(String str) {
        String Zo = Zo(str);
        int lastIndexOf = Zo.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "";
        }
        return Zo.substring(lastIndexOf + 1, Zo.length());
    }

    public static String Zo(String str, String str2) {
        if (FH(str, str2)) {
            return str2.substring(str.length() + 1, str2.length());
        }
        return str2;
    }

    public static String VH(String str, String str2) {
        return u7(str, str2);
    }

    private static String u7(String str, String str2) {
        String replace = str2.replace("\\\\", "/").replace("\\", "/");
        if (!replace.contains("/")) {
            return str + "/" + replace;
        }
        if (replace.startsWith("/")) {
            replace = ".." + replace;
        }
        replace = j6(new File(str, replace));
        if (new File(replace).exists()) {
            return replace;
        }
        return str2;
    }

    public static String j6(File file) {
        List<String> arrayList = new ArrayList();
        String absolutePath = file.getAbsolutePath();
        for (String str : absolutePath.split("/|\\\\")) {
            if (!(str.length() == 0 || ".".equals(str))) {
                if (!"..".equals(str)) {
                    arrayList.add(str);
                } else if (arrayList.isEmpty()) {
                    return absolutePath;
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : arrayList) {
            stringBuilder.append("/");
            stringBuilder.append(str2);
        }
        if (absolutePath.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static String j6() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists()) {
            return externalStorageDirectory.getPath();
        }
        return "/mnt/sdcard";
    }

    public static String gn(String str, String str2) {
        for (String v5 = v5(str); v5 != null; v5 = v5(v5)) {
            if (Zo(v5).equals(str2)) {
                return v5;
            }
        }
        return null;
    }

    public static boolean rN(String str) {
        return str.startsWith("/") && we(v5(str));
    }

    public static int j6(String str, int i, String... strArr) {
        int i2;
        if (we(str)) {
            try {
                i2 = 0;
                for (String j6 : QX(str)) {
                    try {
                        int j62 = j6(j6, i, strArr) + i2;
                        if (j62 >= i) {
                            return j62;
                        }
                        i2 = j62;
                    } catch (IOException e) {
                        return i2;
                    }
                }
                return i2;
            } catch (IOException e2) {
                return 0;
            }
        } else if (!J0(str)) {
            return 0;
        } else {
            for (String endsWith : strArr) {
                if (str.endsWith(endsWith)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static void j6(InputStream inputStream, String str, boolean z) {
        InputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String str2 = str + File.separator + nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    new File(str2).mkdirs();
                } else if (z || !new File(str2).isFile()) {
                    new File(str2).getParentFile().mkdirs();
                    OutputStream fileOutputStream = new FileOutputStream(str2);
                    w.j6(zipInputStream, fileOutputStream, false);
                    fileOutputStream.close();
                }
            } else {
                return;
            }
        }
    }
}
