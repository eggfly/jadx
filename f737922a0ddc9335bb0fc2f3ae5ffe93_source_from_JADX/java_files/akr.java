import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.JGitText;

public class akr {
    private HashMap<String, ans> DW;
    private boolean EQ;
    private ArrayList<String> FH;
    private ArrayList<String> Hw;
    private akq VH;
    private ako Zo;
    private awb gn;
    private aoh j6;
    private awd tp;
    private ans u7;
    private ans v5;
    private ArrayList<String> we;

    public List<String> j6() {
        return this.FH;
    }

    public List<String> DW() {
        return this.we;
    }

    public akr(aoh aoh, ans ans, ako ako, ans ans2, awd awd) {
        this.DW = new HashMap();
        this.FH = new ArrayList();
        this.Hw = new ArrayList();
        this.EQ = true;
        this.we = new ArrayList();
        this.j6 = aoh;
        this.Zo = ako;
        this.u7 = ans;
        this.v5 = ans2;
        this.tp = awd;
    }

    public akr(aoh aoh, ans ans, ako ako, ans ans2) {
        this(aoh, ans, ako, ans2, new awa(aoh));
    }

    public akr(aoh aoh, ako ako, ans ans) {
        this(aoh, null, ako, ans, new awa(aoh));
    }

    public void FH() {
        this.Hw.clear();
        this.DW.clear();
        this.FH.clear();
        this.gn = new awb(this.j6);
        this.VH = this.Zo.DW();
        j6(this.gn, this.u7);
        j6(this.gn, this.v5);
        this.gn.j6(new akp(this.VH));
        this.gn.j6(this.tp);
        while (this.gn.EQ()) {
            j6(this.gn.j6(0, avy.class), this.gn.j6(1, avy.class), (akp) this.gn.j6(2, akp.class), (awd) this.gn.j6(3, awd.class));
            if (this.gn.Ws()) {
                this.gn.QX();
            }
        }
    }

    private void j6(awc awc, ans ans) {
        if (ans == null) {
            awc.j6(new avz());
        } else {
            awc.DW((anb) ans);
        }
    }

    public void Hw() {
        this.Hw.clear();
        this.DW.clear();
        this.FH.clear();
        this.VH = this.Zo.DW();
        this.gn = new awb(this.j6);
        this.gn.DW(this.v5);
        this.gn.j6(new akp(this.VH));
        this.gn.j6(this.tp);
        while (this.gn.EQ()) {
            j6((avy) this.gn.j6(0, avy.class), (akp) this.gn.j6(1, akp.class), (awd) this.gn.j6(2, awd.class));
            if (this.gn.Ws()) {
                this.gn.QX();
            }
        }
        this.FH.removeAll(this.Hw);
    }

    void j6(avy avy, akp akp, awd awd) {
        if (avy != null) {
            if (akp == null) {
                if (awd == null || anl.j6.equals(awd.we()) || awd.j3()) {
                    j6(avy.J8(), avy.EQ(), avy.we());
                } else {
                    this.FH.add(this.gn.we());
                }
            } else if (awd == null || !avy.DW((avx) akp)) {
                j6(avy.J8(), avy.EQ(), avy.we());
            } else if (akp.tp() == null) {
                j6(akp.tp());
            } else if (awd.j6(akp.tp(), true) || akp.tp().VH() != 0) {
                j6(avy.J8(), avy.EQ(), avy.we());
            } else {
                j6(akp.tp());
            }
        } else if (awd == null) {
        } else {
            if (this.gn.Hw()) {
                this.FH.add(this.gn.we());
            } else if (akp != null) {
                j6(akp.J8());
                this.FH.remove(akp.J8());
            }
        }
    }

    public boolean v5() {
        try {
            boolean Zo = Zo();
            return Zo;
        } finally {
            this.Zo.u7();
        }
    }

    private boolean Zo() {
        this.we.clear();
        any Hw = this.j6.FH().Hw();
        try {
            String str;
            if (this.u7 != null) {
                FH();
            } else {
                Hw();
            }
            if (!this.FH.isEmpty()) {
                if (this.EQ) {
                    throw new akx((String[]) this.FH.toArray(new String[this.FH.size()]));
                }
                VH();
            }
            this.VH.DW();
            String str2 = "";
            File file = null;
            int size = this.Hw.size() - 1;
            while (size >= 0) {
                str = (String) this.Hw.get(size);
                File file2 = new File(this.j6.Mr(), str);
                if (file2.delete() || !file2.exists()) {
                    if (!j6(str, str2)) {
                        j6(new File(this.j6.Mr(), str2));
                    }
                } else if (file2.isDirectory()) {
                    str = str2;
                } else {
                    this.we.add(str);
                    str = str2;
                }
                size--;
                str2 = str;
                file = file2;
            }
            if (file != null) {
                j6(file);
            }
            for (String str3 : this.DW.keySet()) {
                File file3 = new File(this.j6.Mr(), str3);
                file3.getParentFile().mkdirs();
                akt DW = this.Zo.DW(str3);
                if (!anl.v5.DW(DW.u7())) {
                    j6(this.j6, file3, DW, Hw);
                }
            }
            if (this.VH.Hw()) {
                return this.we.size() == 0;
            } else {
                throw new alc();
            }
        } finally {
            Hw.FH();
        }
    }

    private static boolean j6(String str, String str2) {
        return str.substring(0, str.lastIndexOf(47) + 1).equals(str2.substring(0, str2.lastIndexOf(47) + 1));
    }

    private void j6(File file) {
        File parentFile = file.getParentFile();
        while (!parentFile.equals(this.j6.Mr()) && parentFile.delete()) {
            parentFile = parentFile.getParentFile();
        }
    }

    private boolean j6(ans ans, anl anl, ans ans2, anl anl2) {
        if (!anl.equals(anl2)) {
            return false;
        }
        if (ans != null) {
            return ans.DW((anb) ans2);
        }
        if (ans2 == null) {
            return true;
        }
        return false;
    }

    void j6(avx avx, avx avx2, akp akp, awd awd) {
        String we = this.gn.we();
        if (akp != null || avx2 != null || avx != null) {
            anl anl;
            int i;
            ans EQ = akp == null ? null : akp.EQ();
            ans EQ2 = avx2 == null ? null : avx2.EQ();
            ans EQ3 = avx == null ? null : avx.EQ();
            anl we2 = akp == null ? null : akp.we();
            anl we3 = avx2 == null ? null : avx2.we();
            if (avx == null) {
                anl = null;
            } else {
                anl = avx.we();
            }
            int i2 = 0;
            if (avx != null) {
                i2 = anl.j6.equals(avx.we()) ? 3328 : 3840;
            }
            if (akp != null) {
                if (anl.j6.equals(akp.we())) {
                    i = 208;
                } else {
                    i = 240;
                }
                i2 |= i;
            }
            if (avx2 != null) {
                if (anl.j6.equals(avx2.we())) {
                    i = 13;
                } else {
                    i = 15;
                }
                i |= i2;
            } else {
                i = i2;
            }
            akt tp;
            if ((i & 546) != 0 && ((i & 15) == 13 || (i & 240) == 208 || (i & 3840) == 3328)) {
                switch (i) {
                    case 223:
                        if (DW(we)) {
                            j6(we, akp.tp(), avx, avx2);
                        } else {
                            j6(we, EQ2, avx2.we());
                        }
                    case 253:
                    case 3568:
                        j6(we, akp != null ? akp.tp() : null, avx, avx2);
                    case 3343:
                        j6(we, EQ2, avx2.we());
                    case 3551:
                        if (DW(we)) {
                            j6(we, akp.tp(), avx, avx2);
                        } else {
                            j6(we, avx2.EQ(), avx2.we());
                        }
                    case 3581:
                        j6(we);
                    case 3583:
                    case 4061:
                    case 3853:
                        j6(we);
                    case 4048:
                        j6(akp.tp());
                    case 4063:
                        if (j6(EQ3, anl, EQ2, we3)) {
                            if (DW(we)) {
                                j6(we, akp.tp(), avx, avx2);
                            } else {
                                j6(we, EQ2, avx2.we());
                            }
                        } else if (DW(we)) {
                            j6(we, akp.tp(), avx, avx2);
                        } else {
                            j6(we, EQ2, avx2.we());
                        }
                    case 4093:
                        if (j6(EQ3, anl, EQ, we2)) {
                            tp = akp.tp();
                            if (awd == null || awd.j6(tp, true)) {
                                j6(we, tp, avx, avx2);
                                return;
                            } else {
                                j6(we);
                                return;
                            }
                        }
                        j6(we, akp.tp(), avx, avx2);
                    default:
                        j6(akp.tp());
                }
            } else if ((i & 546) != 0) {
                if (i == 15 && awd != null && anl.j6.equals(awd.we())) {
                    j6(we, null, avx, avx2);
                }
                if (akp != null) {
                    tp = akp.tp();
                    if (avx == null) {
                        if (avx2 != null && !j6(EQ2, we3, EQ, we2)) {
                            j6(we, tp, avx, avx2);
                        } else if (avx2 != null || !this.gn.Hw()) {
                            j6(tp);
                        } else if (tp == null || !(awd == null || awd.j6(tp, true))) {
                            j6(we);
                        } else {
                            j6(we, tp, avx, avx2);
                        }
                    } else if (avx2 == null) {
                        if (tp.tp() == anl.v5) {
                            j6(we);
                        } else if (!j6(EQ3, anl, EQ, we2)) {
                            j6(we, tp, avx, avx2);
                        } else if (awd == null || awd.j6(tp, true)) {
                            j6(we, tp, avx, avx2);
                        } else {
                            j6(we);
                        }
                    } else if (!j6(EQ3, anl, EQ2, we3) && !j6(EQ3, anl, EQ, we2) && !j6(EQ2, we3, EQ, we2)) {
                        j6(we, tp, avx, avx2);
                    } else if (!j6(EQ3, anl, EQ, we2) || j6(EQ2, we3, EQ, we2)) {
                        j6(tp);
                    } else if (tp != null && anl.v5.equals(tp.tp())) {
                        j6(we, EQ2, avx2.we());
                    } else if (tp == null || !(awd == null || awd.j6(tp, true))) {
                        j6(we, EQ2, avx2.we());
                    } else {
                        j6(we, tp, avx, avx2);
                    }
                } else if (awd != null && !anl.v5.equals(avx2.we()) && (EQ2 == null || !j6(EQ2, we3, awd.EQ(), awd.we()))) {
                    j6(we, null, avx, avx2);
                } else if (avx == null) {
                    j6(we, EQ2, avx2.we());
                } else if (avx2 == null) {
                    j6(we);
                } else {
                    j6(we, EQ2, avx2.we());
                }
            }
        } else if (this.gn.Hw()) {
            j6(we, null, null, null);
        }
    }

    private void j6(String str, akt akt, avx avx, avx avx2) {
        this.FH.add(str);
        if (akt != null) {
            akt akt2 = new akt(akt.J8(), 1);
            akt2.j6(akt);
            this.VH.DW(akt2);
        }
        if (!(avx == null || anl.j6.equals(avx.we()))) {
            akt2 = new akt(avx.J8(), 2);
            akt2.j6(avx.we());
            akt2.j6(avx.EQ());
            this.VH.DW(akt2);
        }
        if (avx2 != null && !anl.j6.equals(avx2.we())) {
            akt2 = new akt(avx2.J8(), 3);
            akt2.j6(avx2.we());
            akt2.j6(avx2.EQ());
            this.VH.DW(akt2);
        }
    }

    private void j6(akt akt) {
        if (akt != null && !anl.j6.equals(akt.tp())) {
            this.VH.DW(akt);
        }
    }

    private void j6(String str) {
        this.Hw.add(str);
    }

    private void j6(String str, ans ans, anl anl) {
        if (!anl.j6.equals(anl)) {
            this.DW.put(str, ans);
            akt akt = new akt(str, 0);
            akt.j6((anb) ans);
            akt.j6(anl);
            this.VH.DW(akt);
        }
    }

    public void j6(boolean z) {
        this.EQ = z;
    }

    private void VH() {
        Iterator it = this.FH.iterator();
        while (it.hasNext()) {
            File file = new File(this.j6.Mr(), (String) it.next());
            if (file.delete()) {
                j6(file);
            } else {
                throw new akx(MessageFormat.format(JGitText.j6().cannotDeleteFile, new Object[]{r0}));
            }
        }
        it = this.Hw.iterator();
        while (it.hasNext()) {
            file = new File(this.j6.Mr(), (String) it.next());
            if (file.delete()) {
                j6(file);
            } else {
                throw new akx(MessageFormat.format(JGitText.j6().cannotDeleteFile, new Object[]{file.getAbsolutePath()}));
            }
        }
    }

    private boolean DW(String str) {
        awb awb = new awb(this.j6);
        awb.j6(new aku(this.Zo));
        awb.j6(new awa(this.j6));
        awb.j6(true);
        awb.j6(awi.j6(str));
        while (awb.EQ()) {
            aku aku = (aku) awb.j6(0, aku.class);
            awd awd = (awd) awb.j6(1, awd.class);
            if (aku == null || awd == null) {
                return true;
            }
            if (awd.j6(aku.tp(), true)) {
                return true;
            }
        }
        return false;
    }

    public static void j6(aoh aoh, File file, akt akt, any any) {
        OutputStream axk;
        anx FH = any.FH(akt.J0());
        File createTempFile = File.createTempFile("._" + file.getName(), null, file.getParentFile());
        awe awe = (awe) aoh.VH().j6(awe.j6);
        OutputStream fileOutputStream = new FileOutputStream(createTempFile);
        if (awe.DW() == ank$a.TRUE) {
            axk = new axk(fileOutputStream);
        } else {
            axk = fileOutputStream;
        }
        try {
            FH.j6(axk);
            awp gn = aoh.gn();
            if (awe.j6() && gn.DW()) {
                if (anl.Hw.DW(akt.u7())) {
                    if (!gn.j6(createTempFile)) {
                        gn.j6(createTempFile, true);
                    }
                } else if (gn.j6(createTempFile)) {
                    gn.j6(createTempFile, false);
                }
            }
            if (!createTempFile.renameTo(file)) {
                awv.j6(file);
                if (!createTempFile.renameTo(file)) {
                    throw new IOException(MessageFormat.format(JGitText.j6().couldNotWriteFile, new Object[]{createTempFile.getPath(), file.getPath()}));
                }
            }
            akt.j6(file.lastModified());
            if (awe.DW() != ank$a.FALSE) {
                akt.DW(file.length());
            } else {
                akt.j6((int) FH.j6());
            }
        } finally {
            axk.close();
        }
    }
}
