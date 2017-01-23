import com.aide.engine.SyntaxError;
import java.util.Comparator;

class pc$5 implements Comparator<SyntaxError> {
    final /* synthetic */ pc j6;

    pc$5(pc pcVar) {
        this.j6 = pcVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return j6((SyntaxError) obj, (SyntaxError) obj2);
    }

    public int j6(SyntaxError syntaxError, SyntaxError syntaxError2) {
        return this.j6.j6(syntaxError.FH, syntaxError.Hw, syntaxError2.FH, syntaxError2.Hw);
    }
}
