package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.es;
import com.google.android.gms.p146b.et;

public class AdActivity extends Activity {
    private et f9226a;

    private void m10266a() {
        if (this.f9226a != null) {
            try {
                this.f9226a.m11093l();
            } catch (Throwable e) {
                C2972b.m11584d("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f9226a != null) {
                z = this.f9226a.m11086e();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9226a = es.m12637a((Activity) this);
        if (this.f9226a == null) {
            C2972b.m11583d("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f9226a.m11083a(bundle);
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f9226a != null) {
                this.f9226a.m11092k();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.f9226a != null) {
                this.f9226a.m11090i();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f9226a != null) {
                this.f9226a.m11087f();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.f9226a != null) {
                this.f9226a.m11089h();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f9226a != null) {
                this.f9226a.m11084b(bundle);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.f9226a != null) {
                this.f9226a.m11088g();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.f9226a != null) {
                this.f9226a.m11091j();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        m10266a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m10266a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m10266a();
    }
}
