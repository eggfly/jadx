import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jgit.JGitText;

public class arc extends aoh {
    private final ara DW;
    private final ara FH;
    private final aoe Hw;
    private are Zo;
    private final ara j6;
    private final arl v5;

    public /* synthetic */ anr FH() {
        return rN();
    }

    public /* synthetic */ aol VH() {
        return er();
    }

    public arc(File file) {
        this(((ard) new ard().j6(file)).EQ());
    }

    public arc(anf anf) {
        super(anf);
        this.j6 = axi.FH().DW(null, gn());
        this.DW = axi.FH().j6(this.j6, gn());
        this.FH = new ara(this.DW, gn().j6(DW(), "config"), gn());
        yS();
        gW();
        BT();
        this.FH.j6(new arc$1(this));
        this.Hw = new ary(this);
        this.v5 = new arl(this.FH, anf.FH(), anf.Hw(), gn());
        if (this.v5.j6()) {
            if (!"0".equals(er().j6("core", null, "repositoryformatversion"))) {
                throw new IOException(MessageFormat.format(JGitText.j6().unknownRepositoryFormat2, new Object[]{r0}));
            }
        }
        if (!j3()) {
            this.Zo = are.j6(Ws());
        }
    }

    private void yS() {
        try {
            this.j6.VH();
        } catch (Throwable e) {
            IOException iOException = new IOException(MessageFormat.format(JGitText.j6().systemConfigFileInvalid, new Object[]{this.j6.Zo().getAbsolutePath(), e}));
            iOException.initCause(e);
            throw iOException;
        }
    }

    private void gW() {
        try {
            this.DW.VH();
        } catch (Throwable e) {
            IOException iOException = new IOException(MessageFormat.format(JGitText.j6().userConfigFileInvalid, new Object[]{this.DW.Zo().getAbsolutePath(), e}));
            iOException.initCause(e);
            throw iOException;
        }
    }

    private void BT() {
        try {
            this.FH.VH();
        } catch (Throwable e) {
            IOException iOException = new IOException(JGitText.j6().unknownRepositoryFormat);
            iOException.initCause(e);
            throw iOException;
        }
    }

    public void j6(boolean z) {
        boolean z2 = true;
        ara er = er();
        if (er.Zo().exists()) {
            throw new IllegalStateException(MessageFormat.format(JGitText.j6().repositoryAlreadyExists, new Object[]{DW()}));
        }
        boolean z3;
        awv.DW(DW(), true);
        this.Hw.j6();
        this.v5.DW();
        awv.DW(new File(DW(), "branches"));
        awv.DW(new File(DW(), "hooks"));
        aof j6 = j6("HEAD");
        j6.we();
        j6.DW("refs/heads/master");
        if (gn().DW()) {
            File createTempFile = File.createTempFile("try", "execute", DW());
            gn().j6(createTempFile, true);
            boolean j62 = gn().j6(createTempFile);
            gn().j6(createTempFile, false);
            boolean j63 = gn().j6(createTempFile);
            awv.j6(createTempFile);
            z3 = j62 && !j63;
        } else {
            z3 = false;
        }
        er.DW("core", null, "repositoryformatversion", 0);
        er.DW("core", null, "filemode", z3);
        if (z) {
            er.DW("core", null, "bare", true);
        }
        String str = "core";
        String str2 = "logallrefupdates";
        if (z) {
            z2 = false;
        }
        er.DW(str, null, str2, z2);
        er.DW("core", null, "autocrlf", false);
        er.v5();
    }

    public arl rN() {
        return this.v5;
    }

    public aoe Zo() {
        return this.Hw;
    }

    public ara er() {
        if (this.j6.gn()) {
            try {
                yS();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        if (this.DW.gn()) {
            try {
                gW();
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }
        if (this.FH.gn()) {
            try {
                BT();
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            }
        }
        return this.FH;
    }

    public Set<ans> J0() {
        Set hashSet = new HashSet();
        for (arb$a arb_a : this.v5.we()) {
            if (arb_a instanceof arb$b) {
                aoh aoh = ((arb$b) arb_a).DW;
                for (aoc aoc : aoh.J8().values()) {
                    if (aoc.v5() != null) {
                        hashSet.add(aoc.v5());
                    }
                    if (aoc.VH() != null) {
                        hashSet.add(aoc.VH());
                    }
                }
                hashSet.addAll(aoh.J0());
            }
        }
        return hashSet;
    }

    public void U2() {
        this.Zo = are.j6(Ws());
        j6(new amh());
    }
}
