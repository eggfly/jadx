import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import tv.ouya.console.api.h;

public class bhx<T> {
    private h<T> j6;

    public bhx(h<T> hVar) {
        this.j6 = hVar;
    }

    public void j6(T t) {
        new Handler(Looper.getMainLooper()).post(new bhx$1(this, t));
    }

    public void j6(int i, String str, Bundle bundle) {
        new Handler(Looper.getMainLooper()).post(new bhx$2(this, i, str, bundle));
    }

    public void j6() {
        new Handler(Looper.getMainLooper()).post(new bhx$3(this));
    }
}
