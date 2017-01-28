import java.io.File;
import java.util.Map;

class avk extends avd implements auc {
    static final avl v5;
    private final File Zo;

    static {
        v5 = new avk$1();
    }

    avk(aoh aoh, avn avn, File file) {
        super(aoh, avn);
        this.Zo = file;
    }

    avo j6(aoh aoh) {
        return new avo(aoh);
    }

    aun DW(aoh aoh) {
        return new aun(aoh);
    }

    public atq QX() {
        String v5 = v5();
        if ("git-upload-pack".equals(v5) || "git upload-pack".equals(v5)) {
            return new avk$c(this);
        }
        return new avk$a(this);
    }

    public auj XL() {
        String u7 = u7();
        if ("git-receive-pack".equals(u7) || "git receive-pack".equals(u7)) {
            return new avk$d(this);
        }
        return new avk$b(this);
    }

    public void DW() {
    }

    protected Process FH(String str) {
        try {
            ProcessBuilder DW = this.FH.gn().DW(str, new String[]{"."});
            DW.directory(this.Zo);
            Map environment = DW.environment();
            environment.remove("GIT_ALTERNATE_OBJECT_DIRECTORIES");
            environment.remove("GIT_CONFIG");
            environment.remove("GIT_CONFIG_PARAMETERS");
            environment.remove("GIT_DIR");
            environment.remove("GIT_WORK_TREE");
            environment.remove("GIT_GRAFT_FILE");
            environment.remove("GIT_INDEX_FILE");
            environment.remove("GIT_NO_REPLACE_OBJECTS");
            return DW.start();
        } catch (Throwable e) {
            throw new amb(this.Hw, e.getMessage(), e);
        }
    }
}
