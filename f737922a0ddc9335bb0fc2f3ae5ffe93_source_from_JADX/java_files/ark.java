import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class ark {
    static final FilenameFilter j6;
    private final File DW;
    private final File FH;
    private boolean Hw;
    private boolean VH;
    private boolean Zo;
    private are gn;
    private final awp u7;
    private FileOutputStream v5;

    static File j6(File file) {
        return new File(file.getParentFile(), file.getName() + ".lock");
    }

    static {
        j6 = new ark$1();
    }

    public ark(File file, awp awp) {
        this.DW = file;
        this.FH = j6(this.DW);
        this.u7 = awp;
    }

    public boolean j6() {
        awv.DW(this.FH.getParentFile(), true);
        if (this.FH.createNewFile()) {
            this.Hw = true;
            try {
                this.v5 = new FileOutputStream(this.FH);
            } catch (IOException e) {
                Zo();
                throw e;
            }
        }
        return this.Hw;
    }

    public void j6(ans ans) {
        byte[] bArr = new byte[41];
        ans.FH(bArr, 0);
        bArr[40] = (byte) 10;
        j6(bArr);
    }

    public void j6(byte[] bArr) {
        VH();
        try {
            if (this.VH) {
                FileChannel channel = this.v5.getChannel();
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                while (wrap.remaining() > 0) {
                    channel.write(wrap);
                }
                channel.force(true);
            } else {
                this.v5.write(bArr);
            }
            this.v5.close();
            this.v5 = null;
        } catch (IOException e) {
            Zo();
            throw e;
        } catch (RuntimeException e2) {
            Zo();
            throw e2;
        } catch (Error e3) {
            Zo();
            throw e3;
        }
    }

    public OutputStream DW() {
        OutputStream newOutputStream;
        VH();
        if (this.VH) {
            newOutputStream = Channels.newOutputStream(this.v5.getChannel());
        } else {
            newOutputStream = this.v5;
        }
        return new ark$2(this, newOutputStream);
    }

    private void VH() {
        if (this.v5 == null) {
            Zo();
            throw new IllegalStateException(MessageFormat.format(JGitText.j6().lockOnNotHeld, new Object[]{this.DW}));
        }
    }

    public void j6(boolean z) {
        DW(z);
    }

    public void DW(boolean z) {
        this.Zo = z;
    }

    public void FH(boolean z) {
        this.VH = z;
    }

    public void FH() {
        are j6 = are.j6(this.DW);
        are j62 = are.j6(this.FH);
        while (j6.DW(j62)) {
            Thread.sleep(25);
            this.FH.setLastModified(System.currentTimeMillis());
            j62 = are.j6(this.FH);
        }
    }

    public boolean Hw() {
        if (this.v5 != null) {
            Zo();
            throw new IllegalStateException(MessageFormat.format(JGitText.j6().lockOnNotClosed, new Object[]{this.DW}));
        }
        tp();
        if (this.FH.renameTo(this.DW)) {
            return true;
        }
        if ((!this.DW.exists() || gn()) && u7()) {
            return true;
        }
        Zo();
        return false;
    }

    private boolean gn() {
        if (!this.u7.Hw()) {
            return this.DW.delete();
        }
        int i = 0;
        while (i < 10) {
            if (this.DW.delete()) {
                return true;
            }
            try {
                Thread.sleep(100);
                i++;
            } catch (InterruptedException e) {
                return false;
            }
        }
        return false;
    }

    private boolean u7() {
        if (!this.u7.Hw()) {
            return this.FH.renameTo(this.DW);
        }
        int i = 0;
        while (i < 10) {
            if (this.FH.renameTo(this.DW)) {
                return true;
            }
            try {
                Thread.sleep(100);
                i++;
            } catch (InterruptedException e) {
                return false;
            }
        }
        return false;
    }

    private void tp() {
        if (this.Zo) {
            this.gn = are.j6(this.FH);
        }
    }

    public are v5() {
        return this.gn;
    }

    public void Zo() {
        if (this.v5 != null) {
            try {
                this.v5.close();
            } catch (IOException e) {
            }
            this.v5 = null;
        }
        if (this.Hw) {
            this.Hw = false;
            try {
                awv.j6(this.FH, 2);
            } catch (IOException e2) {
            }
        }
    }

    public String toString() {
        return "LockFile[" + this.FH + ", haveLck=" + this.Hw + "]";
    }
}
