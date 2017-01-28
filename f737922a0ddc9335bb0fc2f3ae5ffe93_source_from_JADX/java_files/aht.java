import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import org.eclipse.jgit.JGitText;

public class aht extends aie<ako> {
    private Collection<String> DW;
    private awd FH;
    private boolean Hw;

    public /* synthetic */ Object call() {
        return j6();
    }

    public aht(aoh aoh) {
        super(aoh);
        this.Hw = false;
        this.DW = new LinkedList();
    }

    public aht j6(String str) {
        Zo();
        this.DW.add(str);
        return this;
    }

    public ako j6() {
        ako XL;
        InputStream aM;
        Throwable e;
        ako ako;
        Object obj = null;
        Object obj2 = 1;
        if (this.DW.isEmpty()) {
            throw new aji(JGitText.j6().atLeastOnePatternIsRequired);
        }
        Zo();
        if (!this.DW.contains(".")) {
            obj2 = null;
        }
        anw Hw = this.j6.Hw();
        try {
            XL = this.j6.XL();
            try {
                akq DW = XL.DW();
                awc awc = new awc(this.j6);
                awc.j6(new akp(DW));
                if (this.FH == null) {
                    this.FH = new awa(this.j6);
                }
                awc.j6(this.FH);
                awc.j6(true);
                if (obj2 == null) {
                    awc.j6(awj.j6(this.DW));
                }
                while (awc.EQ()) {
                    String we = awc.we();
                    awd awd = (awd) awc.j6(1, awd.class);
                    if (!((awc.j6(0, aku.class) == null && awd != null && awd.j3()) || we.equals(r3))) {
                        if (!this.Hw || awc.j6(0, aku.class) != null) {
                            aku aku = (aku) awc.j6(0, aku.class);
                            if (awd != null) {
                                long QX = awd.QX();
                                akt akt = new akt(we);
                                if (aku == null || aku.tp() == null || !aku.tp().v5()) {
                                    anl j6 = awd.j6(aku);
                                    akt.j6(j6);
                                    if (anl.v5 != j6) {
                                        akt.DW(QX);
                                        akt.j6(awd.XL());
                                        aM = awd.aM();
                                        akt.j6(Hw.j6(3, QX, aM));
                                        aM.close();
                                        DW.DW(akt);
                                        obj = we;
                                    } else {
                                        anb DW2 = aid.j6(new File(this.j6.Mr(), we)).QX().DW("HEAD");
                                        if (DW2 != null) {
                                            akt.j6(DW2);
                                            DW.DW(akt);
                                            obj = we;
                                        }
                                    }
                                } else {
                                    DW.DW(aku.tp());
                                }
                            } else if (!this.Hw) {
                                DW.DW(aku.tp());
                            }
                        }
                    }
                }
                Hw.FH();
                DW.Hw();
                DW(false);
                Hw.Hw();
                if (XL != null) {
                    XL.u7();
                }
                return XL;
            } catch (IOException e2) {
                e = e2;
                ako = XL;
            } catch (Throwable th) {
                e = th;
            }
        } catch (IOException e3) {
            e = e3;
            ako = null;
            try {
                throw new ajg(JGitText.j6().exceptionCaughtDuringExecutionOfAddCommand, e);
            } catch (Throwable th2) {
                e = th2;
                XL = ako;
                Hw.Hw();
                if (XL != null) {
                    XL.u7();
                }
                throw e;
            }
        } catch (Throwable th3) {
            e = th3;
            XL = null;
            Hw.Hw();
            if (XL != null) {
                XL.u7();
            }
            throw e;
        }
    }

    public aht j6(boolean z) {
        this.Hw = z;
        return this;
    }
}
