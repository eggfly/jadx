import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.k;

public abstract class agi<T> {
    private T DW;
    private final String j6;

    protected agi(String str) {
        this.j6 = str;
    }

    protected abstract T DW(IBinder iBinder);

    protected final T j6(Context context) {
        if (this.DW == null) {
            b.j6((Object) context);
            Context v5 = k.v5(context);
            if (v5 == null) {
                throw new agi$a("Could not get remote context.");
            }
            try {
                this.DW = DW((IBinder) v5.getClassLoader().loadClass(this.j6).newInstance());
            } catch (Throwable e) {
                throw new agi$a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new agi$a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new agi$a("Could not access creator.", e22);
            }
        }
        return this.DW;
    }
}
