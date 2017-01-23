package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.dp;

public class AdActivity extends Activity {
    private dp j6;

    private void j6() {
        if (this.j6 != null) {
            try {
                this.j6.we();
            } catch (Throwable e) {
                b.FH("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.j6.j6(i, i2, intent);
        } catch (Throwable e) {
            b.FH("Could not forward onActivityResult to ad overlay:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.j6 != null) {
                z = this.j6.v5();
            }
        } catch (Throwable e) {
            b.FH("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j6 = w.DW().DW((Activity) this);
        if (this.j6 == null) {
            b.Hw("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.j6.j6(bundle);
        } catch (Throwable e) {
            b.FH("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.j6 != null) {
                this.j6.EQ();
            }
        } catch (Throwable e) {
            b.FH("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.j6 != null) {
                this.j6.u7();
            }
        } catch (Throwable e) {
            b.FH("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.j6 != null) {
                this.j6.Zo();
            }
        } catch (Throwable e) {
            b.FH("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.j6 != null) {
                this.j6.gn();
            }
        } catch (Throwable e) {
            b.FH("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.j6 != null) {
                this.j6.DW(bundle);
            }
        } catch (Throwable e) {
            b.FH("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.j6 != null) {
                this.j6.VH();
            }
        } catch (Throwable e) {
            b.FH("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.j6 != null) {
                this.j6.tp();
            }
        } catch (Throwable e) {
            b.FH("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        j6();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        j6();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        j6();
    }
}
