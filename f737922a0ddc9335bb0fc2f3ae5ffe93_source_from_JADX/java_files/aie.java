import java.text.MessageFormat;
import java.util.concurrent.Callable;
import org.eclipse.jgit.JGitText;

public abstract class aie<T> implements Callable<T> {
    private boolean DW;
    protected final aoh j6;

    protected aie(aoh aoh) {
        this.DW = true;
        this.j6 = aoh;
    }

    public aoh v5() {
        return this.j6;
    }

    protected void DW(boolean z) {
        this.DW = z;
    }

    protected void Zo() {
        if (!this.DW) {
            throw new IllegalStateException(MessageFormat.format(JGitText.j6().commandWasCalledInTheWrongState, new Object[]{getClass().getName()}));
        }
    }
}
