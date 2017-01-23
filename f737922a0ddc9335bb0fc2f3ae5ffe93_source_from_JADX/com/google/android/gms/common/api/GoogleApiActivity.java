package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.a;
import com.google.android.gms.internal.gv;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    protected int j6;

    public GoogleApiActivity() {
        this.j6 = 0;
    }

    public static Intent DW(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    public static PendingIntent j6(Context context, PendingIntent pendingIntent, int i) {
        return j6(context, pendingIntent, i, true);
    }

    public static PendingIntent j6(Context context, PendingIntent pendingIntent, int i, boolean z) {
        return PendingIntent.getActivity(context, 0, DW(context, pendingIntent, i, z), 134217728);
    }

    private void j6() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.j6 = 1;
            } catch (Throwable e) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } else {
            a.j6().j6((Activity) this, num.intValue(), 2, (OnCancelListener) this);
            this.j6 = 1;
        }
    }

    private void j6(int i, gv gvVar) {
        switch (i) {
            case -1:
                gvVar.DW();
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                gvVar.DW(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
            default:
        }
    }

    protected void j6(int i) {
        setResult(i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.j6 = 0;
            gv j6 = gv.j6();
            j6(i2);
            if (booleanExtra) {
                j6(i2, j6);
            }
        } else if (i == 2) {
            this.j6 = 0;
            j6(i2);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.j6 = 0;
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.j6 = bundle.getInt("resolution");
        }
        if (this.j6 != 1) {
            j6();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.j6);
        super.onSaveInstanceState(bundle);
    }
}
