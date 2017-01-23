import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.jgit.JGitText;

public abstract class atw extends aux {
    private JSch DW;
    private atz FH;
    private final Map<String, JSch> j6;

    protected abstract void j6(atz$a atz_a, Session session);

    public atw() {
        this.j6 = new HashMap();
    }

    public synchronized aut j6(avn avn, atn atn, awp awp, int i) {
        String DW;
        Session j6;
        int i2;
        String v5 = avn.v5();
        String Zo = avn.Zo();
        String j62 = avn.j6();
        int VH = avn.VH();
        atz$a j63;
        int i3;
        try {
            if (this.FH == null) {
                this.FH = atz.j6(awp);
            }
            j63 = this.FH.j6(j62);
            DW = j63.DW();
            if (VH <= 0) {
                VH = j63.FH();
            }
            if (v5 == null) {
                v5 = j63.v5();
            }
            j6 = j6(atn, awp, v5, Zo, DW, VH, j63);
            i3 = 0;
            while (!j6.Hw() && i3 < 3) {
                i2 = i3 + 1;
                j6.j6(i);
                i3 = i2;
            }
        } catch (JSchException e) {
            j6.DW();
            if (atn != null && e.getCause() == null && e.getMessage().equals("Auth fail")) {
                atn.j6(avn);
                j6 = j6(atn, awp, v5, Zo, DW, VH, j63);
                i3 = i2;
            } else {
                throw e;
            }
        } catch (Throwable e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof UnknownHostException) {
                throw new amb(avn, JGitText.j6().unknownHost);
            } else if (cause instanceof ConnectException) {
                throw new amb(avn, cause.getMessage());
            } else {
                throw new amb(avn, e2.getMessage(), e2);
            }
        }
        return new atx(j6, avn);
    }

    private Session j6(atn atn, awp awp, String str, String str2, String str3, int i, atz$a atz_a) {
        Session j6 = j6(atz_a, str, str3, i, awp);
        if (str2 != null) {
            j6.Hw(str2);
        }
        String j62 = atz_a.j6();
        if (j62 != null) {
            j6.j6("StrictHostKeyChecking", j62);
        }
        j62 = atz_a.Zo();
        if (j62 != null) {
            j6.j6("PreferredAuthentications", j62);
        }
        if (!(atn == null || (atz_a.VH() && atn.j6()))) {
            j6.j6(new ato(j6, atn));
        }
        j6(atz_a, j6);
        return j6;
    }

    protected Session j6(atz$a atz_a, String str, String str2, int i, awp awp) {
        return j6(atz_a, awp).j6(str, str2, i);
    }

    protected JSch j6(atz$a atz_a, awp awp) {
        if (this.DW == null) {
            this.DW = j6(awp);
            Iterator it = this.DW.Hw().iterator();
            while (it.hasNext()) {
                this.j6.put((String) it.next(), this.DW);
            }
        }
        File Hw = atz_a.Hw();
        if (Hw == null) {
            return this.DW;
        }
        String absolutePath = Hw.getAbsolutePath();
        JSch jSch = (JSch) this.j6.get(absolutePath);
        if (jSch != null) {
            return jSch;
        }
        jSch = new JSch();
        jSch.j6(this.DW.FH());
        jSch.j6(absolutePath);
        this.j6.put(absolutePath, jSch);
        return jSch;
    }

    protected JSch j6(awp awp) {
        JSch jSch = new JSch();
        j6(jSch, awp);
        DW(jSch, awp);
        return jSch;
    }

    private static void j6(JSch jSch, awp awp) {
        InputStream fileInputStream;
        File FH = awp.FH();
        if (FH != null) {
            try {
                fileInputStream = new FileInputStream(new File(new File(FH, ".ssh"), "known_hosts"));
                jSch.j6(fileInputStream);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            } catch (Throwable th) {
                fileInputStream.close();
            }
        }
    }

    private static void DW(JSch jSch, awp awp) {
        File FH = awp.FH();
        if (FH != null) {
            File file = new File(FH, ".ssh");
            if (file.isDirectory()) {
                j6(jSch, new File(file, "identity"));
                j6(jSch, new File(file, "id_rsa"));
                j6(jSch, new File(file, "id_dsa"));
            }
        }
    }

    private static void j6(JSch jSch, File file) {
        if (file.isFile()) {
            try {
                jSch.j6(file.getAbsolutePath());
            } catch (JSchException e) {
            }
        }
    }
}
