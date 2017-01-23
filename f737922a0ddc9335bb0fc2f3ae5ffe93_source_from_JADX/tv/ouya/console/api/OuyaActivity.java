package tv.ouya.console.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class OuyaActivity extends Activity {
    private static final String j6;
    private int DW;
    private long FH;
    private long Hw;

    public OuyaActivity() {
        this.DW = 0;
    }

    static {
        j6 = OuyaActivity.class.getSimpleName();
    }

    protected void onCreate(Bundle bundle) {
        g.j6((Activity) this);
        g.j6((this.DW & 4) == 0);
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        g.DW(this);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        j6(this, this.DW);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        j6(this, this.DW);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        j6(this, this.DW);
    }

    public static void j6(Activity activity, int i) {
        if ((i & 1) == 0) {
            activity.takeKeyEvents(true);
        }
        if ((i & 2) == 0) {
            j6(activity);
        }
    }

    public static void j6(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(6);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if ((this.DW & 8) != 0 || !g.j6((InputEvent) keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        j6(false);
        return g.j6((Activity) this, keyEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((this.DW & 8) != 0 || !g.j6((InputEvent) motionEvent)) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        j6(true);
        return g.j6((Activity) this, motionEvent);
    }

    private void j6(boolean z) {
        long nanoTime = System.nanoTime() / 1000000;
        if (nanoTime - (z ? this.FH : this.Hw) >= 30000) {
            if (z) {
                this.FH = nanoTime;
            } else {
                this.Hw = nanoTime;
            }
            Intent intent = new Intent("tv.ouya.metrics.action.USER_INPUT");
            intent.putExtra("analog", z);
            sendBroadcast(intent);
        }
    }
}
