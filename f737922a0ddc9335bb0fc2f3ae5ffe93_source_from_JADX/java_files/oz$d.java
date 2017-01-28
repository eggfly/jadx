import android.app.Activity;
import com.aide.ui.e;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class oz$d extends FutureTask<Void> {
    private Activity DW;
    final /* synthetic */ oz j6;

    public oz$d(oz ozVar, Activity activity, Callable<Void> callable) {
        this.j6 = ozVar;
        super(callable);
        this.DW = activity;
    }

    protected void done() {
        if (isCancelled()) {
            e.j6(new oz$d$4(this));
            return;
        }
        try {
            get();
            e.j6(new oz$d$1(this));
        } catch (Throwable e) {
            com.aide.common.e.j6(e);
            e.j6(new oz$d$2(this, e));
        } catch (Throwable e2) {
            com.aide.common.e.j6(e2);
            e.j6(new oz$d$3(this, e2));
        }
    }
}
