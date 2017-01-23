import com.aide.uidesigner.ProxyTextView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class fa {
    private boolean BT;
    private Hashtable<String, ZipFile> DW;
    private int[] EQ;
    private Hashtable<ZipFile, List<ZipEntry>> FH;
    private boolean Hw;
    private fa$a I;
    private int[] J0;
    private float[] J8;
    private fa$a KD;
    private char[] Mr;
    private fa$a Mz;
    private fa$a OW;
    private boolean P8;
    private double[] QX;
    private fa$a Qq;
    private fa$a SI;
    private fa$a Sf;
    private int U2;
    private int VH;
    private long[] Ws;
    private int[] XL;
    private String[][] XX;
    private byte[] Zo;
    private int a8;
    private char[] aM;
    private fa$a aj;
    private fa$a br;
    private fa$a ca;
    private fa$a cb;
    private fa$a cn;
    private fa$a dx;
    private fa$a ef;
    private dg ei;
    private int er;
    private fa$a g3;
    private boolean gW;
    private int gn;
    private int j3;
    private boolean j6;
    private String lg;
    private fa$a lp;
    private fa$a nw;
    private boolean rN;
    private fa$a ro;
    private fa$a sG;
    private fa$a sh;
    private fa$a sy;
    private int[] tp;
    private int[] u7;
    private byte[] v5;
    private fa$a vJ;
    private boolean vy;
    private int[] we;
    private fa$a x9;
    private boolean yS;

    public fa() {
        this.DW = new Hashtable();
        this.FH = new Hashtable();
        this.Hw = true;
        this.j3 = 0;
        this.U2 = 0;
        r0 = new String[18][];
        r0[0] = new String[]{"java/lang/Boolean", "parseBoolean", "(Ljava/lang/String;)Z"};
        r0[1] = new String[]{"java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;"};
        r0[2] = new String[]{"java/lang/Character", "valueOf", "(C)Ljava/lang/Character;"};
        r0[3] = new String[]{"java/lang/Double", "valueOf", "(D)Ljava/lang/Double;"};
        r0[4] = new String[]{"java/lang/Float", "valueOf", "(F)Ljava/lang/Float;"};
        r0[5] = new String[]{"java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;"};
        r0[6] = new String[]{"java/lang/Long", "valueOf", "(J)Ljava/lang/Long;"};
        r0[7] = new String[]{"java/lang/Short", "valueOf", "(S)Ljava/lang/Short;"};
        r0[8] = new String[]{"java/lang/String", "contains", "(Ljava/lang/String;)Z"};
        r0[9] = new String[]{"java/lang/StringBuffer", "<init>", "(Ljava/lang/CharSequence;)V"};
        r0[10] = new String[]{"java/lang/StringBuffer", "append", "(Ljava/lang/CharSequence;)Ljava/lang/StringBuffer;"};
        r0[11] = new String[]{"java/lang/StringBuffer", "append", "(Ljava/lang/CharSequence;II)Ljava/lang/StringBuffer;"};
        r0[12] = new String[]{"java/lang/StringBuffer", "insert", "(ILjava/lang/CharSequence;)Ljava/lang/StringBuffer;"};
        r0[13] = new String[]{"java/lang/StringBuffer", "insert", "(ILjava/lang/CharSequence;II)Ljava/lang/StringBuffer;"};
        r0[14] = new String[]{"java/lang/StringBuffer", "trimToSize", "()V"};
        r0[15] = new String[]{"java/util/Collections", "emptyList", "()Ljava/util/List;"};
        r0[16] = new String[]{"java/util/Collections", "emptyMap", "()Ljava/util/Map;"};
        r0[17] = new String[]{"java/util/Collections", "emptySet", "()Ljava/util/Set;"};
        this.XX = r0;
    }

    public void j6() {
        if (this.j6) {
            for (Entry value : this.DW.entrySet()) {
                try {
                    ((ZipFile) value.getValue()).close();
                } catch (IOException e) {
                }
            }
            this.DW.clear();
            this.FH.clear();
        }
    }

    public long j6(String str) {
        if (!this.j6) {
            FH();
        }
        if (!new File(str).isDirectory()) {
            return new File(str).lastModified();
        }
        Vector vector = new Vector();
        j6(str, "", vector);
        Iterator it = vector.iterator();
        long j = 0;
        while (it.hasNext()) {
            j *= 37;
            j = new File(str + File.separator + ((String) it.next())).lastModified() ^ j;
        }
        return j;
    }

    public String[] DW(String str) {
        if (!this.j6) {
            FH();
        }
        Vector vector = new Vector();
        try {
            if (str.toUpperCase().endsWith(".CLASS")) {
                if (str.lastIndexOf(File.separator) != -1) {
                    str = str.substring(str.lastIndexOf(File.separator) + 1, str.length());
                }
                if (str.indexOf("$") == -1) {
                    vector.add(str);
                }
            } else if (new File(str).isDirectory()) {
                j6(str, "", vector);
            } else {
                Enumeration entries = Hw(str).entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String name = zipEntry.getName();
                    if (!zipEntry.isDirectory() && name.lastIndexOf(36) == -1 && name.endsWith(".class")) {
                        vector.add(name);
                    } else if (!zipEntry.isDirectory() && name.endsWith(".java")) {
                        Object substring;
                        if (name.startsWith("src/") || name.startsWith("src\\")) {
                            substring = name.substring(4, name.length());
                        } else {
                            String str2 = name;
                        }
                        vector.add(substring);
                    }
                }
            }
        } catch (IOException e) {
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    private void j6(String str, String str2, Vector<String> vector) {
        if (str2.length() > 0) {
            str2 = str2 + File.separator;
        }
        String[] list = new File(str + File.separatorChar).list();
        if (list != null) {
            for (String str3 : list) {
                String str4 = str + File.separatorChar + str3;
                if (new File(str4).isDirectory()) {
                    j6(str4, str2 + str3, (Vector) vector);
                } else if (str3.lastIndexOf(36) == -1 && str3.endsWith(".class")) {
                    vector.add(str2 + str3);
                } else if (str3.endsWith(".java")) {
                    vector.add(str2 + str3);
                }
            }
        }
    }

    public Reader j6(String str, String str2, String str3) {
        if (!this.j6) {
            FH();
        }
        try {
            if (str.toUpperCase().endsWith(".CLASS")) {
                FH(str.lastIndexOf(File.separator) == -1 ? str : str.substring(0, str.lastIndexOf(File.separator) + 1), str.lastIndexOf(File.separator) == -1 ? str : str.substring(str.lastIndexOf(File.separator) + 1, str.length()));
                v5(str);
                return this.nw.v5();
            } else if (new File(str).isDirectory()) {
                if (str2.endsWith(".java")) {
                    InputStream fileInputStream = new FileInputStream(str + File.separator + str2);
                    if (str3 == null) {
                        return new InputStreamReader(fileInputStream);
                    }
                    return new InputStreamReader(fileInputStream, str3);
                }
                FH(str, str2);
                v5(str);
                return this.nw.v5();
            } else if (str2.endsWith(".java")) {
                ZipFile Hw = Hw(str);
                ZipEntry entry = Hw.getEntry(str2);
                if (entry == null) {
                    entry = Hw.getEntry("src/" + str2);
                }
                if (entry == null) {
                    entry = Hw.getEntry("src\\" + str2);
                }
                InputStream fa_b = new fa$b(Hw.getInputStream(entry), entry.getSize());
                if (str3 == null) {
                    return new InputStreamReader(fa_b);
                }
                return new InputStreamReader(fa_b, str3);
            } else {
                DW(str, str2);
                v5(str);
                return this.nw.v5();
            }
        } catch (Throwable th) {
            System.out.println(th);
            th.printStackTrace(System.out);
            RuntimeException runtimeException = new RuntimeException(th.toString() + " " + str + " " + str2, th);
        }
    }

    private void FH() {
        this.j6 = true;
        this.v5 = new byte[10000];
        this.Zo = new byte[20000];
        this.u7 = new int[10000];
        this.tp = new int[10000];
        this.EQ = new int[10000];
        this.we = new int[10000];
        this.J0 = new int[10000];
        this.J8 = new float[10000];
        this.Ws = new long[10000];
        this.QX = new double[10000];
        this.XL = new int[10000];
        this.ei = new dg();
        this.aM = new char[1000];
        this.Mr = new char[1000];
        this.nw = new fa$a();
        this.SI = new fa$a();
        this.KD = new fa$a();
        this.ro = new fa$a();
        this.cn = new fa$a();
        this.sh = new fa$a();
        this.cb = new fa$a();
        this.dx = new fa$a();
        this.sG = new fa$a();
        this.ef = new fa$a();
        this.Sf = new fa$a();
        this.vJ = new fa$a();
        this.g3 = new fa$a();
        this.Mz = new fa$a();
        this.I = new fa$a();
        this.ca = new fa$a();
        this.x9 = new fa$a();
        this.Qq = new fa$a();
        this.sy = new fa$a();
        this.aj = new fa$a();
        this.lp = new fa$a();
        this.OW = new fa$a();
        this.br = new fa$a();
    }

    protected void DW() {
        if (this.j6) {
            FH();
        }
    }

    private List<ZipEntry> j6(ZipFile zipFile) {
        if (this.FH.containsKey(zipFile)) {
            return (List) this.FH.get(zipFile);
        }
        List<ZipEntry> arrayList = new ArrayList();
        Enumeration entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (!(zipEntry.isDirectory() || zipEntry.getName().lastIndexOf(36) == -1)) {
                arrayList.add(zipEntry);
            }
        }
        this.FH.put(zipFile, arrayList);
        return arrayList;
    }

    private ZipFile Hw(String str) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        if (this.DW.containsKey(str)) {
            return (ZipFile) this.DW.get(str);
        }
        ZipFile zipFile = new ZipFile(str);
        this.DW.put(str, zipFile);
        return zipFile;
    }

    private void DW(String str, String str2) {
        ZipFile Hw = Hw(str);
        ZipEntry entry = Hw.getEntry(str2);
        List<ZipEntry> arrayList = new ArrayList();
        arrayList.add(entry);
        String name = entry.getName();
        if (name.lastIndexOf(46) != -1) {
            name = name.substring(0, name.lastIndexOf(46));
        }
        String str3 = name + '$';
        for (ZipEntry entry2 : j6(Hw)) {
            String name2 = entry2.getName();
            if (!entry2.isDirectory() && name2.startsWith(str3) && name2.endsWith(".class")) {
                int i = 0;
                do {
                    i = name2.indexOf(36, i);
                    if (i == -1) {
                        arrayList.add(entry2);
                        break;
                    }
                    i++;
                } while (!Character.isDigit(name2.charAt(i)));
            }
        }
        j6((List) arrayList, 0, arrayList.size() - 1);
        this.gn = 0;
        this.VH = 0;
        for (ZipEntry entry22 : arrayList) {
            InputStream fa_b = new fa$b(Hw.getInputStream(entry22), entry22.getSize());
            int read = fa_b.read(this.v5);
            while (read != -1) {
                if (this.VH + read >= this.Zo.length) {
                    Object obj = new byte[((this.Zo.length * 2) + 1)];
                    System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
                    this.Zo = obj;
                }
                System.arraycopy(this.v5, 0, this.Zo, this.VH, read);
                this.VH = read + this.VH;
                read = fa_b.read(this.v5);
            }
            fa_b.close();
        }
    }

    private void FH(String str, String str2) {
        int read;
        List<File> arrayList = new ArrayList();
        File file = new File(str + File.separator + str2);
        arrayList.add(file);
        String name = file.getName();
        if (name.lastIndexOf(46) != -1) {
            name = name.substring(0, name.lastIndexOf(46));
        }
        String str3 = name + '$';
        String path = file.getParentFile().getPath();
        String[] list = file.getParentFile().list();
        if (list != null) {
            for (String str4 : list) {
                File file2 = new File(path + File.separatorChar + str4);
                if (!file2.isDirectory() && str4.startsWith(str3) && str4.endsWith(".class")) {
                    int i = 0;
                    do {
                        i = str4.indexOf(36, i);
                        if (i == -1) {
                            arrayList.add(file2);
                            break;
                        }
                        i++;
                    } while (!Character.isDigit(str4.charAt(i)));
                }
            }
        }
        DW(arrayList, 0, arrayList.size() - 1);
        this.gn = 0;
        this.VH = 0;
        for (File fileInputStream : arrayList) {
            InputStream fileInputStream2 = new FileInputStream(fileInputStream);
            read = fileInputStream2.read(this.v5);
            while (read != -1) {
                if (this.VH + read >= this.Zo.length) {
                    Object obj = new byte[((this.Zo.length * 2) + 1)];
                    System.arraycopy(this.Zo, 0, obj, 0, this.Zo.length);
                    this.Zo = obj;
                }
                System.arraycopy(this.v5, 0, this.Zo, this.VH, read);
                this.VH = read + this.VH;
                read = fileInputStream2.read(this.v5);
            }
            fileInputStream2.close();
        }
    }

    private void v5(String str) {
        this.nw.DW();
        this.er = -1;
        int i = 0;
        while (this.gn < this.VH) {
            Hw();
            this.sh.DW();
            this.cb.DW();
            this.dx.DW();
            this.sG.DW();
            this.ef.DW();
            this.Sf.DW();
            this.vJ.DW();
            this.g3.DW();
            this.SI.DW();
            this.KD.DW();
            this.ro.DW();
            this.cn.DW();
            int i2 = this.er;
            v5();
            Zo();
            VH();
            if (!this.gW || this.er > r0 + 1) {
                this.er = i2;
            } else {
                int i3 = this.er;
                if (this.nw.Hw() == 0) {
                    this.nw.j6(this.sh);
                }
                for (i = i2; i >= this.er; i--) {
                    for (i2 = 0; i2 < i; i2++) {
                        this.nw.DW("    ");
                    }
                    this.nw.DW("}\n\n");
                }
                this.nw.DW("\n");
                this.nw.j6(this.cb);
                this.nw.j6(this.dx);
                this.nw.j6(this.vJ);
                this.nw.j6(this.sG);
                this.nw.j6(this.ef);
                this.nw.j6(this.Sf);
                this.nw.DW("\n");
                for (i = 0; i < this.er; i++) {
                    this.nw.DW("    ");
                }
                this.nw.DW("{\n");
                if (this.BT) {
                    this.nw.j6(this.cn);
                    this.nw.j6(this.Mz);
                    this.nw.DW(";\n\n");
                }
                if (!this.P8 && "java/lang/Enum".equals(this.lg)) {
                    this.SI.j6(this.Mz);
                    this.SI.DW("public final String name() {}\n\n");
                    this.SI.j6(this.Mz);
                    this.SI.DW("public final int ordinal() {}\n\n");
                }
                this.nw.j6(this.SI);
                if (this.yS) {
                    this.nw.j6(this.ro);
                    i = i3;
                } else {
                    this.nw.j6(this.KD);
                    i = i3;
                }
            }
        }
        for (i2 = this.er; i2 >= 0; i2--) {
            for (i = 0; i < i2; i++) {
                this.nw.DW("    ");
            }
            this.nw.DW("}\n\n");
        }
    }

    private void j6(List<ZipEntry> list, int i, int i2) {
        if (i < i2) {
            String name = ((ZipEntry) list.get(((i2 - i) / 2) + i)).getName();
            int i3 = i2;
            int i4 = i;
            while (i4 <= i3) {
                int i5 = i4;
                while (Hw(((ZipEntry) list.get(i5)).getName(), name) == -1) {
                    i5++;
                }
                while (Hw(name, ((ZipEntry) list.get(i3)).getName()) == -1) {
                    i3--;
                }
                if (i5 <= i3) {
                    ZipEntry zipEntry = (ZipEntry) list.get(i3);
                    list.set(i3, list.get(i5));
                    list.set(i5, zipEntry);
                    i4 = i5 + 1;
                    i3--;
                } else {
                    i4 = i5;
                }
            }
            j6((List) list, i, i3);
            j6((List) list, i4, i2);
        }
    }

    private void DW(List<File> list, int i, int i2) {
        if (i < i2) {
            String name = ((File) list.get(((i2 - i) / 2) + i)).getName();
            int i3 = i2;
            int i4 = i;
            while (i4 <= i3) {
                int i5 = i4;
                while (Hw(((File) list.get(i5)).getName(), name) == -1) {
                    i5++;
                }
                while (Hw(name, ((File) list.get(i3)).getName()) == -1) {
                    i3--;
                }
                if (i5 <= i3) {
                    File file = (File) list.get(i3);
                    list.set(i3, list.get(i5));
                    list.set(i5, file);
                    i4 = i5 + 1;
                    i3--;
                } else {
                    i4 = i5;
                }
            }
            DW(list, i, i3);
            DW(list, i4, i2);
        }
    }

    private int Hw(String str, String str2) {
        int length = str.length() - 6;
        int length2 = str2.length() - 6;
        int i = length < length2 ? length : length2;
        for (int i2 = 0; i2 < i; i2++) {
            char charAt = str.charAt(i2);
            char charAt2 = str2.charAt(i2);
            if (charAt == '$' && charAt != charAt2) {
                return -1;
            }
            if (charAt2 == '$' && charAt != charAt2) {
                return 1;
            }
            if (charAt == '+' && charAt != charAt2) {
                return -1;
            }
            if (charAt2 == '+' && charAt != charAt2) {
                return 1;
            }
            int i3 = charAt - charAt2;
            if (i3 < 0) {
                return -1;
            }
            if (i3 > 0) {
                return 1;
            }
        }
        if (length < length2) {
            return -1;
        }
        return length > length2 ? 1 : 0;
    }

    private boolean j6(fa$a fa_a) {
        return "java/lang/Enum".equals(this.lg) && fa_a.j6("name") && Zo("()Ljava/lang/String;");
    }

    private boolean DW(fa$a fa_a) {
        return fa_a.j6("values") && Zo("()[L" + this.lg + ";");
    }

    private boolean FH(fa$a fa_a) {
        return fa_a.j6("valueOf") && Zo("(Ljava/lang/String;)L" + this.lg + ";");
    }

    private boolean Hw(fa$a fa_a) {
        int i = 0;
        while (i < this.XX.length) {
            if (this.XX[i][0].equals(this.lg) && fa_a.j6(this.XX[i][1]) && Zo(this.XX[i][2])) {
                return true;
            }
            i++;
        }
        return false;
    }

    private void Hw() {
        Ws();
        QX();
        QX();
        int J0 = J0() - 1;
        if (J0 >= this.tp.length) {
            this.tp = new int[J0];
            this.EQ = new int[J0];
            this.we = new int[J0];
        }
        int i = 0;
        while (i < J0) {
            int J8 = J8();
            this.u7[i] = J8;
            switch (J8) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    J8 = J0();
                    this.tp[i] = J8;
                    this.EQ[i] = this.gn;
                    this.gn = J8 + this.gn;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.J0[i] = tp();
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    this.J8[i] = EQ();
                    break;
                case 5:
                    this.Ws[i] = gn();
                    i++;
                    break;
                case 6:
                    this.QX[i] = u7();
                    i++;
                    break;
                case 7:
                    this.we[i] = J0();
                    break;
                case 8:
                    this.XL[i] = J0();
                    break;
                case 9:
                case 10:
                case 11:
                    QX();
                    QX();
                    break;
                case 12:
                    QX();
                    QX();
                    break;
                default:
                    throw new RuntimeException("Invalid constant trees tag: " + J8);
            }
            i++;
        }
    }

    private void v5() {
        boolean z = true;
        int i = 0;
        int J0 = J0();
        this.vy = false;
        if (this.Hw && (J0 & 8192) != 0) {
            this.vy = true;
        }
        this.BT = false;
        this.P8 = false;
        if (this.Hw && (J0 & 16384) != 0) {
            this.BT = true;
        }
        this.yS = false;
        this.gW = true;
        if ((J0 & 512) != 0) {
            z = false;
        }
        this.rN = z;
        FH(this.we[J0() - 1]);
        this.lg = new String(this.aM, 0, this.j3);
        this.er = 0;
        this.a8 = 0;
        int i2 = 0;
        while (this.a8 < this.j3) {
            if (this.aM[this.a8] == '/') {
                if (this.sh.Hw() == 0) {
                    this.sh.DW("package ");
                } else {
                    this.sh.DW(".");
                }
                this.sh.j6(this.aM, i2, this.a8 - i2);
                i2 = this.a8 + 1;
            } else if (this.aM[this.a8] == '$') {
                this.er++;
                i2 = this.a8 + 1;
            } else if (this.aM[this.a8] == '+') {
                this.er++;
                i2 = this.a8 + 1;
            }
            this.a8++;
        }
        if (this.sh.Hw() != 0) {
            this.sh.DW(";\n");
        }
        for (int i3 = 0; i3 < this.er; i3++) {
            this.dx.DW("    ");
        }
        j6(J0 & 3615, this.sG);
        if (this.BT) {
            this.ef.DW("enum ");
        } else if (this.vy) {
            this.ef.DW("@interface ");
        } else if (this.rN) {
            this.ef.DW("class ");
        } else {
            this.ef.DW("interface ");
        }
        this.ef.j6(this.aM, i2, this.j3 - i2);
        this.g3.j6(this.aM, i2, this.j3 - i2);
        this.Mz.DW();
        for (i2 = 0; i2 < this.er + 1; i2++) {
            this.Mz.DW("    ");
        }
        i2 = J0();
        if (!(this.BT || !this.rN || i2 == 0)) {
            FH(this.we[i2 - 1]);
            if (!Zo("java/lang/Object")) {
                this.Sf.DW(" extends ");
                u7(this.Sf);
            }
        }
        i2 = J0();
        if (i2 > 0) {
            if (this.rN) {
                this.Sf.DW(" implements ");
                while (i < i2) {
                    if (i != 0) {
                        this.Sf.DW(", ");
                    }
                    FH(this.we[J0() - 1]);
                    u7(this.Sf);
                    i++;
                }
            } else {
                this.Sf.DW(" extends ");
                while (i < i2) {
                    if (i != 0) {
                        this.Sf.DW(", ");
                    }
                    FH(this.we[J0() - 1]);
                    u7(this.Sf);
                    i++;
                }
            }
        }
        if (this.vy) {
            this.Sf.DW();
        }
    }

    private void Zo() {
        int i;
        int J0;
        int J02 = J0();
        for (i = 0; i < J02; i++) {
            int i2;
            this.OW.DW();
            int J03 = J0();
            Object obj = (!this.Hw || (J03 & 16384) == 0) ? null : 1;
            this.x9.DW();
            j6(J03, this.x9);
            FH(J0());
            this.I.DW();
            this.I.j6(this.aM, 0, this.j3);
            FH(J0());
            this.a8 = 0;
            boolean Hw = Hw(this.I);
            this.a8 = 0;
            this.ca.DW();
            EQ(this.ca);
            Object obj2 = null;
            if (this.Hw && (J03 & 4096) != 0) {
                obj2 = 1;
            }
            boolean j6 = j6(J03);
            int J04 = J0();
            Object obj3 = obj2;
            obj2 = null;
            for (i2 = 0; i2 < J04; i2++) {
                FH(J0());
                if (this.Hw && Zo("RuntimeVisibleAnnotations")) {
                    we();
                    v5(this.OW);
                } else if (this.Hw && Zo("RuntimeInvisibleAnnotations")) {
                    we();
                    v5(this.OW);
                } else if (Zo("ConstantValue")) {
                    we();
                    J0 = J0() - 1;
                    switch (this.u7[J0]) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            this.I.DW(" = ");
                            this.I.DW(Integer.toString(this.J0[J0]));
                            break;
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            this.I.DW(" = ");
                            this.I.DW(Float.toString(this.J8[J0]));
                            this.I.DW("f");
                            break;
                        case 5:
                            this.I.DW(" = ");
                            this.I.DW(Long.toString(this.Ws[J0]));
                            this.I.DW("l");
                            break;
                        case 6:
                            this.I.DW(" = ");
                            this.I.DW(Double.toString(this.QX[J0]));
                            break;
                        case 8:
                            this.I.DW(" = \"");
                            FH(this.XL[J0]);
                            this.I.DW(this.aM, 0, this.j3);
                            this.I.DW("\"");
                            break;
                        default:
                            break;
                    }
                } else if (Zo("Synthetic")) {
                    obj3 = 1;
                    DW(we());
                } else if (Zo("Deprecated")) {
                    obj2 = 1;
                    DW(we());
                } else if (this.Hw && Zo("Signature") && this.lg.indexOf("SunJCE_") == -1) {
                    we();
                    FH(J0());
                    this.a8 = 0;
                    this.ca.DW();
                    EQ(this.ca);
                } else {
                    DW(we());
                }
            }
            if (obj3 == null && j6) {
                if (obj != null) {
                    this.cn.j6(this.Mz);
                    this.cn.j6(this.OW);
                    this.cn.j6(this.I);
                    this.cn.DW(",\n\n");
                } else {
                    if (obj2 != null || Hw) {
                        this.SI.j6(this.Mz);
                        this.SI.DW("/** ");
                        if (obj2 != null) {
                            this.SI.DW("@deprecated ");
                        }
                        if (Hw) {
                            this.SI.DW("@since 1.5 ");
                        }
                        this.SI.DW("*/\n");
                    }
                    this.SI.j6(this.Mz);
                    this.SI.j6(this.OW);
                    this.SI.j6(this.x9);
                    this.SI.j6(this.ca);
                    this.SI.DW(" ");
                    this.SI.j6(this.I);
                    this.SI.DW(";\n\n");
                }
            }
        }
        int J05 = J0();
        for (int i3 = 0; i3 < J05; i3++) {
            Object obj4;
            Object obj5;
            int i4;
            this.OW.DW();
            this.br.DW();
            i2 = J0();
            this.x9.DW();
            j6(i2, this.x9);
            Object obj6 = (i2 & 1024) != 0 ? 1 : null;
            Object obj7 = (i2 & 256) != 0 ? 1 : null;
            boolean z = (i2 & 8) != 0;
            FH(J0());
            boolean Zo = Zo("<clinit>");
            boolean Zo2 = Zo("<init>");
            this.I.DW();
            this.I.j6(this.aM, 0, this.j3);
            J02 = J0();
            this.ei.j6();
            boolean j62 = j6(i2);
            obj2 = null;
            if (this.Hw && (i2 & 4096) != 0) {
                obj2 = 1;
            }
            if (this.Hw && (i2 & 64) != 0) {
                obj2 = 1;
            }
            obj3 = null;
            if (this.Hw && (i2 & 128) != 0) {
                obj3 = 1;
            }
            this.Qq.DW();
            int J06 = J0();
            J0 = 0;
            Object obj8 = null;
            Object obj9 = obj2;
            obj2 = null;
            Object obj10 = null;
            while (J0 < J06) {
                Object obj11;
                FH(J0());
                if (this.Hw && Zo("RuntimeVisibleAnnotations")) {
                    we();
                    v5(this.OW);
                    obj11 = obj3;
                    obj3 = obj8;
                    obj8 = obj9;
                    i = J02;
                    obj4 = obj2;
                    obj2 = obj11;
                } else if (this.Hw && Zo("RuntimeInvisibleAnnotations")) {
                    we();
                    v5(this.OW);
                    obj11 = obj3;
                    obj3 = obj8;
                    obj8 = obj9;
                    i = J02;
                    obj4 = obj2;
                    obj2 = obj11;
                } else if (this.Hw && Zo("AnnotationDefault")) {
                    we();
                    obj10 = 1;
                    VH(this.br);
                    obj11 = obj3;
                    obj3 = obj8;
                    obj8 = obj9;
                    i = J02;
                    obj4 = obj2;
                    obj2 = obj11;
                } else if (this.Hw && Zo("Varargs")) {
                    DW(we());
                    obj3 = obj8;
                    obj8 = obj9;
                    i = J02;
                    obj4 = obj2;
                    int i5 = 1;
                } else if (Zo("Synthetic")) {
                    DW(we());
                    obj11 = obj3;
                    obj3 = obj8;
                    i2 = 1;
                    i = J02;
                    obj4 = obj2;
                    obj2 = obj11;
                } else if (Zo("Deprecated")) {
                    DW(we());
                    obj11 = obj3;
                    J03 = 1;
                    obj8 = obj9;
                    i = J02;
                    obj4 = obj2;
                    obj2 = obj11;
                } else if (this.Hw && Zo("Signature") && this.lg.indexOf("SunJCE_") == -1) {
                    we();
                    obj11 = obj3;
                    obj3 = obj8;
                    obj8 = obj9;
                    i = J0();
                    obj4 = obj2;
                    obj2 = obj11;
                } else if (Zo("Exceptions") && this.Qq.FH()) {
                    we();
                    J04 = J0();
                    this.Qq.DW(" throws ");
                    for (r11 = 0; r11 < J04; r11++) {
                        FH(this.we[J0() - 1]);
                        if (r11 != 0) {
                            this.Qq.DW(", ");
                        }
                        u7(this.Qq);
                    }
                    obj11 = obj3;
                    obj3 = obj8;
                    obj8 = obj9;
                    i = J02;
                    obj4 = obj2;
                    obj2 = obj11;
                } else if (Zo("ParameterTable")) {
                    we();
                    J04 = J0();
                    for (r11 = 0; r11 < J04; r11++) {
                        J0();
                        J0();
                        r22 = J0();
                        J0();
                        this.ei.j6(J0(), r22);
                    }
                    obj11 = obj3;
                    obj3 = obj8;
                    obj8 = obj9;
                    i = J02;
                    obj4 = obj2;
                    obj2 = obj11;
                } else if (Zo("Code")) {
                    if (!this.rN) {
                        obj2 = 1;
                    }
                    we();
                    J0();
                    J0();
                    DW(we());
                    DW(J0() * 8);
                    r22 = J0();
                    for (J04 = 0; J04 < r22; J04++) {
                        FH(J0());
                        if (Zo("LocalVariableTable")) {
                            we();
                            int J07 = J0();
                            for (r11 = 0; r11 < J07; r11++) {
                                J0();
                                J0();
                                int J08 = J0();
                                J0();
                                this.ei.j6(J0(), J08);
                            }
                        } else {
                            DW(we());
                        }
                    }
                    obj11 = obj3;
                    obj3 = obj8;
                    obj8 = obj9;
                    i = J02;
                    obj4 = obj2;
                    obj2 = obj11;
                } else {
                    DW(we());
                    obj11 = obj3;
                    obj3 = obj8;
                    obj8 = obj9;
                    i = J02;
                    obj4 = obj2;
                    obj2 = obj11;
                }
                J0++;
                obj11 = obj2;
                obj2 = obj4;
                J02 = i;
                obj9 = obj8;
                obj8 = obj3;
                obj3 = obj11;
            }
            FH(J02);
            this.a8 = 0;
            boolean Hw2 = Hw(this.I);
            if (j6(this.I)) {
                this.P8 = true;
            }
            if (this.BT) {
                if (FH(this.I)) {
                    obj4 = 1;
                    if (this.BT) {
                        if (DW(this.I)) {
                            obj5 = 1;
                            this.a8 = 0;
                            if (this.aM[0] == '<') {
                                tp(this.x9);
                                this.x9.DW(" ");
                            }
                            this.sy.DW();
                            this.aj.DW();
                            j6(this.sy, this.aj, Zo2, z);
                            this.ca.DW();
                            EQ(this.ca);
                            this.ca.DW(" ");
                            if (this.a8 < this.j3 && this.aM[this.a8] == '^') {
                                this.Qq.DW();
                                this.Qq.DW(" throws ");
                                i4 = 0;
                                while (true) {
                                    J0 = this.a8;
                                    J06 = this.j3;
                                    if (J0 >= r0) {
                                        if (this.aM[this.a8] != '^') {
                                            this.a8++;
                                            if (i4 == 0) {
                                                this.Qq.DW(", ");
                                            }
                                            EQ(this.Qq);
                                            i4++;
                                        }
                                    }
                                }
                            }
                            if (obj3 != null) {
                                this.sy.j6();
                                this.aj.j6();
                            }
                            if (obj9 == null && r9 == null && r11 == null && j62) {
                                if (!Zo2) {
                                    if (obj8 != null || Hw2) {
                                        this.KD.j6(this.Mz);
                                        this.KD.DW("/** ");
                                        if (obj8 != null) {
                                            this.KD.DW("@deprecated ");
                                        }
                                        if (Hw2) {
                                            this.KD.DW("@since 1.5 ");
                                        }
                                        this.KD.DW("*/\n");
                                    }
                                    this.KD.j6(this.Mz);
                                    this.KD.j6(this.OW);
                                    this.KD.j6(this.x9);
                                    this.KD.j6(this.g3);
                                    this.KD.j6(this.sy);
                                    this.KD.DW(")");
                                    this.KD.j6(this.Qq);
                                    this.KD.DW(" {}\n\n");
                                    this.ro.j6(this.Mz);
                                    this.ro.j6(this.OW);
                                    this.ro.j6(this.x9);
                                    this.ro.j6(this.g3);
                                    this.ro.j6(this.aj);
                                    this.ro.DW(")");
                                    this.ro.j6(this.Qq);
                                    this.ro.DW(" {}\n\n");
                                } else if (!Zo) {
                                    if (obj8 != null || Hw2) {
                                        this.SI.j6(this.Mz);
                                        this.SI.DW("/** ");
                                        if (obj8 != null) {
                                            this.SI.DW("@deprecated ");
                                        }
                                        if (Hw2) {
                                            this.SI.DW("@since 1.5 ");
                                        }
                                        this.SI.DW("*/\n");
                                    }
                                    this.SI.j6(this.Mz);
                                    if (obj2 != null) {
                                        this.SI.DW("//");
                                    }
                                    this.SI.j6(this.OW);
                                    this.SI.j6(this.x9);
                                    this.SI.j6(this.ca);
                                    this.SI.j6(this.I);
                                    this.SI.j6(this.sy);
                                    this.SI.DW(")");
                                    this.SI.j6(this.Qq);
                                    if (obj10 == null) {
                                        this.SI.DW(" default ");
                                        this.SI.j6(this.br);
                                        this.SI.DW(";\n\n");
                                    } else if (obj6 == null || obj7 != null) {
                                        this.SI.DW(";\n\n");
                                    } else {
                                        this.SI.DW(" {}\n\n");
                                    }
                                }
                            }
                        }
                    }
                    obj5 = null;
                    this.a8 = 0;
                    if (this.aM[0] == '<') {
                        tp(this.x9);
                        this.x9.DW(" ");
                    }
                    this.sy.DW();
                    this.aj.DW();
                    j6(this.sy, this.aj, Zo2, z);
                    this.ca.DW();
                    EQ(this.ca);
                    this.ca.DW(" ");
                    this.Qq.DW();
                    this.Qq.DW(" throws ");
                    i4 = 0;
                    while (true) {
                        J0 = this.a8;
                        J06 = this.j3;
                        if (J0 >= r0) {
                            if (this.aM[this.a8] != '^') {
                                this.a8++;
                                if (i4 == 0) {
                                    this.Qq.DW(", ");
                                }
                                EQ(this.Qq);
                                i4++;
                            }
                        }
                        if (obj3 != null) {
                            this.sy.j6();
                            this.aj.j6();
                        }
                        if (!Zo2) {
                            this.KD.j6(this.Mz);
                            this.KD.DW("/** ");
                            if (obj8 != null) {
                                this.KD.DW("@deprecated ");
                            }
                            if (Hw2) {
                                this.KD.DW("@since 1.5 ");
                            }
                            this.KD.DW("*/\n");
                            this.KD.j6(this.Mz);
                            this.KD.j6(this.OW);
                            this.KD.j6(this.x9);
                            this.KD.j6(this.g3);
                            this.KD.j6(this.sy);
                            this.KD.DW(")");
                            this.KD.j6(this.Qq);
                            this.KD.DW(" {}\n\n");
                            this.ro.j6(this.Mz);
                            this.ro.j6(this.OW);
                            this.ro.j6(this.x9);
                            this.ro.j6(this.g3);
                            this.ro.j6(this.aj);
                            this.ro.DW(")");
                            this.ro.j6(this.Qq);
                            this.ro.DW(" {}\n\n");
                        } else if (!Zo) {
                            this.SI.j6(this.Mz);
                            this.SI.DW("/** ");
                            if (obj8 != null) {
                                this.SI.DW("@deprecated ");
                            }
                            if (Hw2) {
                                this.SI.DW("@since 1.5 ");
                            }
                            this.SI.DW("*/\n");
                            this.SI.j6(this.Mz);
                            if (obj2 != null) {
                                this.SI.DW("//");
                            }
                            this.SI.j6(this.OW);
                            this.SI.j6(this.x9);
                            this.SI.j6(this.ca);
                            this.SI.j6(this.I);
                            this.SI.j6(this.sy);
                            this.SI.DW(")");
                            this.SI.j6(this.Qq);
                            if (obj10 == null) {
                                if (obj6 == null) {
                                }
                                this.SI.DW(";\n\n");
                            } else {
                                this.SI.DW(" default ");
                                this.SI.j6(this.br);
                                this.SI.DW(";\n\n");
                            }
                        }
                    }
                }
            }
            obj4 = null;
            if (this.BT) {
                if (DW(this.I)) {
                    obj5 = 1;
                    this.a8 = 0;
                    if (this.aM[0] == '<') {
                        tp(this.x9);
                        this.x9.DW(" ");
                    }
                    this.sy.DW();
                    this.aj.DW();
                    j6(this.sy, this.aj, Zo2, z);
                    this.ca.DW();
                    EQ(this.ca);
                    this.ca.DW(" ");
                    this.Qq.DW();
                    this.Qq.DW(" throws ");
                    i4 = 0;
                    while (true) {
                        J0 = this.a8;
                        J06 = this.j3;
                        if (J0 >= r0) {
                            if (this.aM[this.a8] != '^') {
                                this.a8++;
                                if (i4 == 0) {
                                    this.Qq.DW(", ");
                                }
                                EQ(this.Qq);
                                i4++;
                            }
                        }
                        if (obj3 != null) {
                            this.sy.j6();
                            this.aj.j6();
                        }
                        if (!Zo2) {
                            this.KD.j6(this.Mz);
                            this.KD.DW("/** ");
                            if (obj8 != null) {
                                this.KD.DW("@deprecated ");
                            }
                            if (Hw2) {
                                this.KD.DW("@since 1.5 ");
                            }
                            this.KD.DW("*/\n");
                            this.KD.j6(this.Mz);
                            this.KD.j6(this.OW);
                            this.KD.j6(this.x9);
                            this.KD.j6(this.g3);
                            this.KD.j6(this.sy);
                            this.KD.DW(")");
                            this.KD.j6(this.Qq);
                            this.KD.DW(" {}\n\n");
                            this.ro.j6(this.Mz);
                            this.ro.j6(this.OW);
                            this.ro.j6(this.x9);
                            this.ro.j6(this.g3);
                            this.ro.j6(this.aj);
                            this.ro.DW(")");
                            this.ro.j6(this.Qq);
                            this.ro.DW(" {}\n\n");
                        } else if (!Zo) {
                            this.SI.j6(this.Mz);
                            this.SI.DW("/** ");
                            if (obj8 != null) {
                                this.SI.DW("@deprecated ");
                            }
                            if (Hw2) {
                                this.SI.DW("@since 1.5 ");
                            }
                            this.SI.DW("*/\n");
                            this.SI.j6(this.Mz);
                            if (obj2 != null) {
                                this.SI.DW("//");
                            }
                            this.SI.j6(this.OW);
                            this.SI.j6(this.x9);
                            this.SI.j6(this.ca);
                            this.SI.j6(this.I);
                            this.SI.j6(this.sy);
                            this.SI.DW(")");
                            this.SI.j6(this.Qq);
                            if (obj10 == null) {
                                this.SI.DW(" default ");
                                this.SI.j6(this.br);
                                this.SI.DW(";\n\n");
                            } else {
                                if (obj6 == null) {
                                }
                                this.SI.DW(";\n\n");
                            }
                        }
                    }
                }
            }
            obj5 = null;
            this.a8 = 0;
            if (this.aM[0] == '<') {
                tp(this.x9);
                this.x9.DW(" ");
            }
            this.sy.DW();
            this.aj.DW();
            j6(this.sy, this.aj, Zo2, z);
            this.ca.DW();
            EQ(this.ca);
            this.ca.DW(" ");
            this.Qq.DW();
            this.Qq.DW(" throws ");
            i4 = 0;
            while (true) {
                J0 = this.a8;
                J06 = this.j3;
                if (J0 >= r0) {
                    if (this.aM[this.a8] != '^') {
                        this.a8++;
                        if (i4 == 0) {
                            this.Qq.DW(", ");
                        }
                        EQ(this.Qq);
                        i4++;
                    }
                }
                if (obj3 != null) {
                    this.sy.j6();
                    this.aj.j6();
                }
                if (!Zo2) {
                    this.KD.j6(this.Mz);
                    this.KD.DW("/** ");
                    if (obj8 != null) {
                        this.KD.DW("@deprecated ");
                    }
                    if (Hw2) {
                        this.KD.DW("@since 1.5 ");
                    }
                    this.KD.DW("*/\n");
                    this.KD.j6(this.Mz);
                    this.KD.j6(this.OW);
                    this.KD.j6(this.x9);
                    this.KD.j6(this.g3);
                    this.KD.j6(this.sy);
                    this.KD.DW(")");
                    this.KD.j6(this.Qq);
                    this.KD.DW(" {}\n\n");
                    this.ro.j6(this.Mz);
                    this.ro.j6(this.OW);
                    this.ro.j6(this.x9);
                    this.ro.j6(this.g3);
                    this.ro.j6(this.aj);
                    this.ro.DW(")");
                    this.ro.j6(this.Qq);
                    this.ro.DW(" {}\n\n");
                } else if (!Zo) {
                    this.SI.j6(this.Mz);
                    this.SI.DW("/** ");
                    if (obj8 != null) {
                        this.SI.DW("@deprecated ");
                    }
                    if (Hw2) {
                        this.SI.DW("@since 1.5 ");
                    }
                    this.SI.DW("*/\n");
                    this.SI.j6(this.Mz);
                    if (obj2 != null) {
                        this.SI.DW("//");
                    }
                    this.SI.j6(this.OW);
                    this.SI.j6(this.x9);
                    this.SI.j6(this.ca);
                    this.SI.j6(this.I);
                    this.SI.j6(this.sy);
                    this.SI.DW(")");
                    this.SI.j6(this.Qq);
                    if (obj10 == null) {
                        if (obj6 == null) {
                        }
                        this.SI.DW(";\n\n");
                    } else {
                        this.SI.DW(" default ");
                        this.SI.j6(this.br);
                        this.SI.DW(";\n\n");
                    }
                }
            }
        }
    }

    private boolean j6(int i) {
        if ((i & 2) != 0) {
            return false;
        }
        return true;
    }

    private void VH() {
        int J0 = J0();
        int i = 0;
        int i2 = 0;
        while (i < J0) {
            int i3;
            FH(J0());
            if (this.Hw && Zo("RuntimeVisibleAnnotations")) {
                we();
                v5(this.vJ);
                i3 = i2;
            } else if (this.Hw && Zo("RuntimeInvisibleAnnotations")) {
                we();
                v5(this.vJ);
                i3 = i2;
            } else if (this.Hw && Zo("Enum")) {
                DW(we());
                i3 = i2;
            } else if (this.Hw && Zo("Signature") && this.lg.indexOf("SunJCE_") == -1) {
                we();
                FH(J0());
                this.Sf.DW();
                this.a8 = 0;
                if (this.aM[0] == '<') {
                    tp(this.Sf);
                }
                if (this.rN) {
                    this.Sf.DW(" extends ");
                    EQ(this.Sf);
                    i3 = 0;
                    while (this.a8 < this.j3) {
                        if (i3 == 0) {
                            this.Sf.DW(" implements ");
                        } else {
                            this.Sf.DW(", ");
                        }
                        EQ(this.Sf);
                        i3++;
                    }
                } else {
                    EQ(this.I);
                    i3 = 0;
                    while (this.a8 < this.j3) {
                        if (i3 == 0) {
                            this.Sf.DW(" extends ");
                        } else {
                            this.Sf.DW(", ");
                        }
                        EQ(this.Sf);
                        i3++;
                    }
                }
                if (this.BT || this.vy) {
                    this.Sf.DW();
                }
                i3 = i2;
            } else if (Zo("Deprecated")) {
                DW(we());
                for (i3 = 0; i3 < this.er; i3++) {
                    this.cb.DW("    ");
                }
                this.cb.DW("/** @deprecated */\n");
                i3 = i2;
            } else if (Zo("InnerClasses")) {
                we();
                int J02 = J0();
                i3 = i2;
                for (i2 = 0; i2 < J02; i2++) {
                    int J03 = J0() - 1;
                    if (J03 != -1) {
                        FH(this.we[J03]);
                        String str = new String(this.aM, 0, this.j3);
                        int J04 = J0() - 1;
                        if (J04 != -1) {
                            FH(this.we[J04]);
                            i3++;
                            FH(J0());
                            J04 = J0();
                            if (str.equals(this.lg)) {
                                if ((J04 & 8) == 0) {
                                    this.yS = true;
                                }
                                this.gW = j6(J04);
                                this.sG.DW();
                                j6(J04, this.sG);
                            }
                        } else {
                            QX();
                            QX();
                        }
                    } else {
                        QX();
                        QX();
                        QX();
                    }
                }
            } else {
                DW(we());
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
    }

    private void v5(fa$a fa_a) {
        int J0 = J0();
        for (int i = 0; i < J0; i++) {
            Zo(fa_a);
            fa_a.DW("\n");
            fa_a.j6(this.Mz);
        }
    }

    private void Zo(fa$a fa_a) {
        fa_a.DW("@");
        FH(J0());
        gn(fa_a);
        fa_a.DW("(");
        int J0 = J0();
        for (int i = 0; i < J0; i++) {
            if (i > 0) {
                fa_a.DW(",");
            }
            FH(J0());
            fa_a.j6(this.aM, 0, this.j3);
            fa_a.DW("=");
            VH(fa_a);
        }
        fa_a.DW(")");
    }

    private void VH(fa$a fa_a) {
        int i = 0;
        switch (J8()) {
            case 64:
                Zo(fa_a);
            case 66:
            case 67:
            case 68:
            case 70:
            case 73:
            case 74:
            case 83:
            case 90:
                i = J0() - 1;
                switch (this.u7[i]) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        fa_a.DW(Integer.toString(this.J0[i]));
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        fa_a.DW(Float.toString(this.J8[i]));
                        fa_a.DW("f");
                    case 5:
                        fa_a.DW(Long.toString(this.Ws[i]));
                        fa_a.DW("l");
                    case 6:
                        fa_a.DW(Double.toString(this.QX[i]));
                    default:
                }
            case 91:
                fa_a.DW("{");
                int J0 = J0();
                while (i < J0) {
                    VH(fa_a);
                    fa_a.DW(",");
                    i++;
                }
                fa_a.DW("}");
            case 99:
                FH(J0());
                gn(fa_a);
                fa_a.DW(".class");
            case 101:
                FH(J0());
                gn(fa_a);
                fa_a.DW(".");
                FH(J0());
                fa_a.j6(this.aM, 0, this.j3);
            case 115:
                fa_a.DW("\"");
                FH(J0());
                fa_a.DW(this.aM, 0, this.j3);
                fa_a.DW("\"");
            default:
        }
    }

    private long gn() {
        return (((((((((long) J8()) << 56) + (((long) J8()) << 48)) + (((long) J8()) << 40)) + (((long) J8()) << 32)) + (((long) J8()) << 24)) + (((long) J8()) << 16)) + (((long) J8()) << 8)) + (((long) J8()) << null);
    }

    private double u7() {
        long J8 = (((((((((long) J8()) << 56) + (((long) J8()) << 48)) + (((long) J8()) << 40)) + (((long) J8()) << 32)) + (((long) J8()) << 24)) + (((long) J8()) << 16)) + (((long) J8()) << 8)) + (((long) J8()) << null);
        if (J8 == 9218868437227405312L) {
            return Double.POSITIVE_INFINITY;
        }
        if (J8 == -4503599627370496L) {
            return Double.NEGATIVE_INFINITY;
        }
        if (J8 >= 9218868437227405312L && J8 <= Long.MAX_VALUE) {
            return Double.NaN;
        }
        if (J8 >= -4503599627370496L && J8 <= -1) {
            return Double.NaN;
        }
        int i = (int) ((J8 >> 52) & 2047);
        return ((double) ((i == 0 ? (J8 & 4503599627370495L) << 1 : (J8 & 4503599627370495L) | 4503599627370496L) * ((long) ((J8 >> 63) == 0 ? 1 : -1)))) * Math.pow(2.0d, (double) (i - 1075));
    }

    private int tp() {
        return (((J8() << 24) + (J8() << 16)) + (J8() << 8)) + (J8() << 0);
    }

    private float EQ() {
        int i = -1;
        int J8 = (((J8() << 24) + (J8() << 16)) + (J8() << 8)) + (J8() << 0);
        if (J8 == 2139095040) {
            return Float.POSITIVE_INFINITY;
        }
        if (J8 == -8388608) {
            return Float.NEGATIVE_INFINITY;
        }
        if (J8 >= 2139095041 && J8 <= Integer.MAX_VALUE) {
            return Float.NaN;
        }
        if (J8 >= -8388607 && J8 <= -1) {
            return Float.NaN;
        }
        if ((J8 >> 31) == 0) {
            i = 1;
        }
        int i2 = (J8 >> 23) & 255;
        return ((float) ((i2 == 0 ? (J8 & 8388607) << 1 : (J8 & 8388607) | 8388608) * i)) * ((float) Math.pow(2.0d, (double) (i2 - 150)));
    }

    private int we() {
        return (((J8() << 24) + (J8() << 16)) + (J8() << 8)) + (J8() << 0);
    }

    private int J0() {
        return (J8() << 8) + (J8() << 0);
    }

    private int J8() {
        byte[] bArr = this.Zo;
        int i = this.gn;
        this.gn = i + 1;
        byte b = bArr[i];
        return b >= null ? b : b + 256;
    }

    private void Ws() {
        this.gn += 4;
    }

    private void QX() {
        this.gn += 2;
    }

    private void DW(int i) {
        this.gn += i;
    }

    private void FH(int i) {
        int i2 = 0;
        this.j3 = 0;
        if (i != 0) {
            int i3 = this.EQ[i - 1];
            int i4 = this.tp[i - 1];
            if (i4 >= this.aM.length) {
                this.aM = new char[i4];
            }
            int i5 = i3;
            while (i2 < i4) {
                i3 = i5 + 1;
                byte b = this.Zo[i5];
                int i6;
                switch (b >> 4) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                    case 7:
                        i2++;
                        char[] cArr = this.aM;
                        i6 = this.j3;
                        this.j3 = i6 + 1;
                        cArr[i6] = (char) b;
                        break;
                    case 12:
                    case 13:
                        i2 += 2;
                        i5 = i3 + 1;
                        byte b2 = this.Zo[i3];
                        char[] cArr2 = this.aM;
                        int i7 = this.j3;
                        this.j3 = i7 + 1;
                        cArr2[i7] = (char) ((b2 & 63) | ((b & 31) << 6));
                        i3 = i5;
                        break;
                    case 14:
                        i2 += 3;
                        i6 = i3 + 1;
                        byte b3 = this.Zo[i3];
                        i3 = i6 + 1;
                        byte b4 = this.Zo[i6];
                        char[] cArr3 = this.aM;
                        int i8 = this.j3;
                        this.j3 = i8 + 1;
                        cArr3[i8] = (char) ((((b3 & 63) << 6) | ((b & 15) << 12)) | ((b4 & 63) << 0));
                        break;
                    default:
                        i2++;
                        break;
                }
                i5 = i3;
            }
        }
    }

    private void Hw(int i) {
        int i2 = 0;
        this.U2 = 0;
        if (i != 0) {
            int i3 = this.EQ[i - 1];
            int i4 = this.tp[i - 1];
            if (i4 >= this.Mr.length) {
                this.Mr = new char[i4];
            }
            int i5 = i3;
            while (i2 < i4) {
                i3 = i5 + 1;
                byte b = this.Zo[i5];
                int i6;
                switch (b >> 4) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                    case 7:
                        i2++;
                        char[] cArr = this.Mr;
                        i6 = this.U2;
                        this.U2 = i6 + 1;
                        cArr[i6] = (char) b;
                        break;
                    case 12:
                    case 13:
                        i2 += 2;
                        i5 = i3 + 1;
                        byte b2 = this.Zo[i3];
                        char[] cArr2 = this.Mr;
                        int i7 = this.U2;
                        this.U2 = i7 + 1;
                        cArr2[i7] = (char) ((b2 & 63) | ((b & 31) << 6));
                        i3 = i5;
                        break;
                    case 14:
                        i2 += 3;
                        i6 = i3 + 1;
                        byte b3 = this.Zo[i3];
                        i3 = i6 + 1;
                        byte b4 = this.Zo[i6];
                        char[] cArr3 = this.Mr;
                        int i8 = this.U2;
                        this.U2 = i8 + 1;
                        cArr3[i8] = (char) ((((b3 & 63) << 6) | ((b & 15) << 12)) | ((b4 & 63) << 0));
                        break;
                    default:
                        i2++;
                        break;
                }
                i5 = i3;
            }
        }
    }

    private boolean Zo(String str) {
        if (this.j3 != str.length()) {
            return false;
        }
        for (int i = 0; i < this.j3; i++) {
            if (this.aM[i] != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void gn(fa$a fa_a) {
        int i = 0;
        if (this.j3 == 1 && this.aM[0] == 'V') {
            fa_a.DW("void");
        } else if (this.j3 == 1 && this.aM[0] == 'I') {
            fa_a.DW("int");
        } else if (this.j3 == 1 && this.aM[0] == 'B') {
            fa_a.DW("byte");
        } else if (this.j3 == 1 && this.aM[0] == 'C') {
            fa_a.DW("char");
        } else if (this.j3 == 1 && this.aM[0] == 'F') {
            fa_a.DW("float");
        } else if (this.j3 == 1 && this.aM[0] == 'D') {
            fa_a.DW("double");
        } else if (this.j3 == 1 && this.aM[0] == 'J') {
            fa_a.DW("long");
        } else if (this.j3 == 1 && this.aM[0] == 'S') {
            fa_a.DW("short");
        } else if (this.j3 == 1 && this.aM[0] == 'Z') {
            fa_a.DW("boolean");
        } else {
            while (i < this.j3) {
                if (this.aM[i] == '/') {
                    this.aM[i] = '.';
                }
                if (this.aM[i] == '$') {
                    this.aM[i] = '.';
                }
                i++;
            }
            fa_a.j6(this.aM, 1, this.j3 - 2);
        }
    }

    private void j6(fa$a fa_a, fa$a fa_a2, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        if (z) {
            fa_a.DW("(");
            fa_a2.DW("(");
            this.a8++;
            i = 1;
            i2 = 0;
            while (this.aM[this.a8] != ')') {
                if (i2 != 0) {
                    fa_a.DW(", ");
                }
                if (i2 > 1) {
                    fa_a2.DW(", ");
                }
                this.lp.DW();
                switch (this.aM[this.a8]) {
                    case 'D':
                    case 'J':
                        i3 = 1;
                        break;
                    default:
                        i3 = 0;
                        break;
                }
                EQ(this.lp);
                fa_a.j6(this.lp);
                if (i2 != 0) {
                    fa_a2.j6(this.lp);
                }
                if (this.ei.DW(i)) {
                    fa_a.DW(" ");
                    Hw(this.ei.FH(i));
                    fa_a.j6(this.Mr, 0, this.U2);
                } else {
                    fa_a.DW(" p");
                    fa_a.j6(i2 + 1);
                }
                if (i2 != 0) {
                    if (this.ei.DW(i)) {
                        fa_a2.DW(" ");
                        Hw(this.ei.FH(i));
                        fa_a2.j6(this.Mr, 0, this.U2);
                    } else {
                        fa_a2.DW(" p");
                        fa_a2.j6(i2 + 1);
                    }
                }
                if (i3 != 0) {
                    i += 2;
                } else {
                    i++;
                }
                i2++;
            }
            this.a8++;
            return;
        }
        fa_a.DW("(");
        this.a8++;
        if (z2) {
            i = 0;
            i2 = 0;
        } else {
            i = 1;
            i2 = 0;
        }
        while (this.aM[this.a8] != ')') {
            if (i2 != 0) {
                fa_a.DW(", ");
            }
            switch (this.aM[this.a8]) {
                case 'D':
                case 'J':
                    i3 = 1;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            EQ(fa_a);
            if (this.ei.DW(i)) {
                fa_a.DW(" ");
                Hw(this.ei.FH(i));
                fa_a.j6(this.Mr, 0, this.U2);
            } else {
                fa_a.DW(" p");
                fa_a.j6(i2 + 1);
            }
            if (i3 != 0) {
                i += 2;
            } else {
                i++;
            }
            i2++;
        }
        this.a8++;
    }

    private void u7(fa$a fa_a) {
        int i = 0;
        this.a8 = 0;
        int i2 = this.a8;
        while (true) {
            if (this.a8 >= this.j3 || this.aM[this.a8] == '/' || this.aM[this.a8] == '$' || this.aM[this.a8] == '+') {
                if (i > 0) {
                    fa_a.DW(".");
                }
                fa_a.j6(this.aM, i2, this.a8 - i2);
                i++;
                this.a8++;
                i2 = this.a8;
            }
            if (this.a8 < this.j3) {
                this.a8++;
            } else {
                return;
            }
        }
    }

    private void tp(fa$a fa_a) {
        this.a8++;
        int i = 0;
        fa_a.DW("<");
        while (this.aM[this.a8] != '>') {
            int i2 = this.a8;
            while (this.aM[this.a8] != ':') {
                this.a8++;
            }
            if (i > 0) {
                fa_a.DW(", ");
            }
            fa_a.j6(this.aM, i2, this.a8 - i2);
            this.a8++;
            while (this.aM[this.a8] == ':') {
                this.a8++;
            }
            fa_a.DW(" extends ");
            EQ(fa_a);
            while (this.aM[this.a8] == ':') {
                this.a8++;
                fa_a.DW(" & ");
                EQ(fa_a);
            }
            i++;
        }
        this.a8++;
        fa_a.DW(">");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void EQ(fa$a r11) {
        /*
        r10 = this;
        r9 = 91;
        r8 = 62;
        r7 = 42;
        r6 = 59;
        r1 = 0;
        r3 = r10.a8;
    L_0x000b:
        r0 = r10.aM;
        r2 = r10.a8;
        r0 = r0[r2];
        if (r0 != r9) goto L_0x002a;
    L_0x0013:
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r10.aM;
        r2 = r10.a8;
        r0 = r0[r2];
        switch(r0) {
            case 43: goto L_0x0023;
            case 45: goto L_0x0023;
            case 61: goto L_0x0023;
            default: goto L_0x0022;
        };
    L_0x0022:
        goto L_0x000b;
    L_0x0023:
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        goto L_0x000b;
    L_0x002a:
        r0 = r10.aM;
        r2 = r10.a8;
        r0 = r0[r2];
        switch(r0) {
            case 66: goto L_0x0066;
            case 67: goto L_0x0074;
            case 68: goto L_0x0082;
            case 69: goto L_0x0033;
            case 70: goto L_0x0090;
            case 71: goto L_0x0033;
            case 72: goto L_0x0033;
            case 73: goto L_0x0058;
            case 74: goto L_0x009e;
            case 75: goto L_0x0033;
            case 76: goto L_0x00f2;
            case 77: goto L_0x0033;
            case 78: goto L_0x0033;
            case 79: goto L_0x0033;
            case 80: goto L_0x0033;
            case 81: goto L_0x0033;
            case 82: goto L_0x0033;
            case 83: goto L_0x00ac;
            case 84: goto L_0x00ca;
            case 85: goto L_0x0033;
            case 86: goto L_0x004a;
            case 87: goto L_0x0033;
            case 88: goto L_0x0033;
            case 89: goto L_0x0033;
            case 90: goto L_0x00bb;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = r3;
    L_0x0034:
        r1 = r10.aM;
        r1 = r1[r0];
        if (r1 != r9) goto L_0x02c1;
    L_0x003a:
        r0 = r0 + 1;
        r1 = r10.aM;
        r1 = r1[r0];
        switch(r1) {
            case 43: goto L_0x02a3;
            case 45: goto L_0x02ad;
            case 61: goto L_0x02b7;
            default: goto L_0x0043;
        };
    L_0x0043:
        r1 = "[]";
        r11.DW(r1);
        goto L_0x0034;
    L_0x004a:
        r0 = "void";
        r11.DW(r0);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x0058:
        r0 = "int";
        r11.DW(r0);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x0066:
        r0 = "byte";
        r11.DW(r0);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x0074:
        r0 = "char";
        r11.DW(r0);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x0082:
        r0 = "double";
        r11.DW(r0);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x0090:
        r0 = "float";
        r11.DW(r0);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x009e:
        r0 = "long";
        r11.DW(r0);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x00ac:
        r0 = "short";
        r11.DW(r0);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x00bb:
        r0 = "boolean";
        r11.DW(r0);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x00ca:
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r10.a8;
    L_0x00d2:
        r1 = r10.aM;
        r2 = r10.a8;
        r1 = r1[r2];
        if (r1 == r6) goto L_0x00e1;
    L_0x00da:
        r1 = r10.a8;
        r1 = r1 + 1;
        r10.a8 = r1;
        goto L_0x00d2;
    L_0x00e1:
        r1 = r10.aM;
        r2 = r10.a8;
        r2 = r2 - r0;
        r11.j6(r1, r0, r2);
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x00f2:
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r10.a8;
        r2 = r0;
        r0 = r1;
    L_0x00fc:
        r4 = r10.aM;
        r5 = r10.a8;
        r4 = r4[r5];
        switch(r4) {
            case 36: goto L_0x010c;
            case 43: goto L_0x010c;
            case 47: goto L_0x010c;
            case 59: goto L_0x0127;
            case 60: goto L_0x0144;
            default: goto L_0x0105;
        };
    L_0x0105:
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
        goto L_0x00fc;
    L_0x010c:
        if (r0 == 0) goto L_0x0114;
    L_0x010e:
        r4 = ".";
        r11.DW(r4);
    L_0x0114:
        r4 = r10.aM;
        r5 = r10.a8;
        r5 = r5 - r2;
        r11.j6(r4, r2, r5);
        r0 = r0 + 1;
        r2 = r10.a8;
        r2 = r2 + 1;
        r10.a8 = r2;
        r2 = r10.a8;
        goto L_0x00fc;
    L_0x0127:
        if (r0 == 0) goto L_0x012f;
    L_0x0129:
        r1 = ".";
        r11.DW(r1);
    L_0x012f:
        r1 = r10.aM;
        r4 = r10.a8;
        r4 = r4 - r2;
        r11.j6(r1, r2, r4);
        r0 = r0 + 1;
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r10.a8;
        r0 = r3;
        goto L_0x0034;
    L_0x0144:
        if (r0 == 0) goto L_0x014c;
    L_0x0146:
        r4 = ".";
        r11.DW(r4);
    L_0x014c:
        r4 = r10.aM;
        r5 = r10.a8;
        r5 = r5 - r2;
        r11.j6(r4, r2, r5);
        r2 = r0 + 1;
        r0 = r10.a8;
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = "<";
        r11.DW(r0);
        r0 = r1;
    L_0x0165:
        r4 = r10.aM;
        r5 = r10.a8;
        r4 = r4[r5];
        if (r4 == r8) goto L_0x01ba;
    L_0x016d:
        if (r0 == 0) goto L_0x0175;
    L_0x016f:
        r4 = ", ";
        r11.DW(r4);
    L_0x0175:
        r4 = r10.aM;
        r5 = r10.a8;
        r4 = r4[r5];
        if (r4 != r7) goto L_0x018c;
    L_0x017d:
        r4 = "?";
        r11.DW(r4);
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
    L_0x0189:
        r0 = r0 + 1;
        goto L_0x0165;
    L_0x018c:
        r4 = r10.aM;
        r5 = r10.a8;
        r4 = r4[r5];
        switch(r4) {
            case 43: goto L_0x0199;
            case 45: goto L_0x01a6;
            case 61: goto L_0x01b3;
            default: goto L_0x0195;
        };
    L_0x0195:
        r10.EQ(r11);
        goto L_0x0189;
    L_0x0199:
        r4 = "? extends ";
        r11.DW(r4);
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
        goto L_0x0195;
    L_0x01a6:
        r4 = "? super ";
        r11.DW(r4);
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
        goto L_0x0195;
    L_0x01b3:
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
        goto L_0x0195;
    L_0x01ba:
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = ">";
        r11.DW(r0);
        r0 = r10.aM;
        r4 = r10.a8;
        r0 = r0[r4];
        if (r0 != r6) goto L_0x01d4;
    L_0x01ce:
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
    L_0x01d4:
        r0 = r2;
    L_0x01d5:
        r2 = r10.a8;
        r4 = r10.j3;
        if (r2 >= r4) goto L_0x0292;
    L_0x01db:
        r2 = r10.aM;
        r4 = r10.a8;
        r2 = r2[r4];
        r4 = 46;
        if (r2 != r4) goto L_0x0292;
    L_0x01e5:
        r2 = r10.a8;
        r2 = r2 + 1;
        r10.a8 = r2;
        r2 = r10.a8;
    L_0x01ed:
        r4 = r10.aM;
        r5 = r10.a8;
        r4 = r4[r5];
        switch(r4) {
            case 36: goto L_0x01fd;
            case 43: goto L_0x01fd;
            case 59: goto L_0x0206;
            case 60: goto L_0x0206;
            default: goto L_0x01f6;
        };
    L_0x01f6:
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
        goto L_0x01ed;
    L_0x01fd:
        r2 = r10.a8;
        r2 = r2 + 1;
        r10.a8 = r2;
        r2 = r10.a8;
        goto L_0x01ed;
    L_0x0206:
        if (r0 == 0) goto L_0x020e;
    L_0x0208:
        r4 = ".";
        r11.DW(r4);
    L_0x020e:
        r4 = r10.aM;
        r5 = r10.a8;
        r5 = r5 - r2;
        r11.j6(r4, r2, r5);
        r2 = r10.aM;
        r4 = r10.a8;
        r2 = r2[r4];
        r4 = 60;
        if (r2 != r4) goto L_0x028e;
    L_0x0220:
        r2 = r10.a8;
        r2 = r2 + 1;
        r10.a8 = r2;
        r2 = "<";
        r11.DW(r2);
        r2 = r1;
    L_0x022d:
        r4 = r10.aM;
        r5 = r10.a8;
        r4 = r4[r5];
        if (r4 == r8) goto L_0x0282;
    L_0x0235:
        if (r2 == 0) goto L_0x023d;
    L_0x0237:
        r4 = ", ";
        r11.DW(r4);
    L_0x023d:
        r4 = r10.aM;
        r5 = r10.a8;
        r4 = r4[r5];
        if (r4 != r7) goto L_0x0254;
    L_0x0245:
        r4 = "?";
        r11.DW(r4);
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
    L_0x0251:
        r2 = r2 + 1;
        goto L_0x022d;
    L_0x0254:
        r4 = r10.aM;
        r5 = r10.a8;
        r4 = r4[r5];
        switch(r4) {
            case 43: goto L_0x0261;
            case 45: goto L_0x026e;
            case 61: goto L_0x027b;
            default: goto L_0x025d;
        };
    L_0x025d:
        r10.EQ(r11);
        goto L_0x0251;
    L_0x0261:
        r4 = "? extends ";
        r11.DW(r4);
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
        goto L_0x025d;
    L_0x026e:
        r4 = "? super ";
        r11.DW(r4);
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
        goto L_0x025d;
    L_0x027b:
        r4 = r10.a8;
        r4 = r4 + 1;
        r10.a8 = r4;
        goto L_0x025d;
    L_0x0282:
        r2 = r10.a8;
        r2 = r2 + 1;
        r10.a8 = r2;
        r2 = ">";
        r11.DW(r2);
    L_0x028e:
        r0 = r0 + 2;
        goto L_0x01d5;
    L_0x0292:
        r0 = r10.aM;
        r1 = r10.a8;
        r0 = r0[r1];
        if (r0 != r6) goto L_0x0033;
    L_0x029a:
        r0 = r10.a8;
        r0 = r0 + 1;
        r10.a8 = r0;
        r0 = r3;
        goto L_0x0034;
    L_0x02a3:
        r1 = "[]";
        r11.DW(r1);
        r0 = r0 + 1;
        goto L_0x0034;
    L_0x02ad:
        r1 = "[]";
        r11.DW(r1);
        r0 = r0 + 1;
        goto L_0x0034;
    L_0x02b7:
        r1 = "[]";
        r11.DW(r1);
        r0 = r0 + 1;
        goto L_0x0034;
    L_0x02c1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: fa.EQ(fa$a):void");
    }

    private void j6(int i, fa$a fa_a) {
        if ((i & 1) != 0) {
            fa_a.DW("public ");
        }
        if ((i & 2) != 0) {
            fa_a.DW("private ");
        }
        if ((i & 4) != 0) {
            fa_a.DW("protected ");
        }
        if ((i & 8) != 0) {
            fa_a.DW("static ");
        }
        if ((i & 16) != 0) {
            fa_a.DW("final ");
        }
        if ((i & 64) != 0) {
            fa_a.DW("volatile ");
        }
        if ((i & 32) != 0) {
            fa_a.DW("synchronized ");
        }
        if ((i & 128) != 0) {
            fa_a.DW("transient ");
        }
        if ((i & 256) != 0) {
            fa_a.DW("native ");
        }
        if ((i & 1024) != 0) {
            fa_a.DW("abstract ");
        }
        if ((i & 2048) != 0) {
            fa_a.DW("strictfp ");
        }
    }

    public boolean FH(String str) {
        return str.endsWith(".class") || str.endsWith(".java");
    }

    public List<String> j6(String str, String str2) {
        List arrayList = new ArrayList();
        Enumeration entries = Hw(str).entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            String name = zipEntry.getName();
            if (name.endsWith("/")) {
                name = name.substring(0, name.length() - 1);
            }
            if (name.startsWith(str2) && !name.equals(str2) && name.indexOf(47, str2.length() + 1) == -1) {
                if (zipEntry.isDirectory()) {
                    arrayList.add(str + '/' + name);
                } else if (!zipEntry.isDirectory() && name.lastIndexOf(36) == -1 && name.endsWith(".class")) {
                    arrayList.add(str + '/' + name);
                } else if (!zipEntry.isDirectory() && name.endsWith(".java")) {
                    if (name.startsWith("src/") || name.startsWith("src\\")) {
                        name = name.substring(4, name.length());
                    }
                    arrayList.add(str + '/' + name);
                }
            }
        }
        j6();
        return arrayList;
    }
}
