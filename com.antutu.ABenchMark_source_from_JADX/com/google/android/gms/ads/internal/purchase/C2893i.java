package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gz;
import org.json.JSONException;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.ads.internal.purchase.i */
public class C2893i {

    /* renamed from: com.google.android.gms.ads.internal.purchase.i.1 */
    class C28921 implements ServiceConnection {
        final /* synthetic */ Context f9793a;
        final /* synthetic */ C2893i f9794b;

        C28921(C2893i c2893i, Context context) {
            this.f9794b = c2893i;
            this.f9793a = context;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z = false;
            C2880b c2880b = new C2880b(this.f9793a.getApplicationContext(), false);
            c2880b.m11204a(iBinder);
            int a = c2880b.m11200a(3, this.f9793a.getPackageName(), "inapp");
            gz h = C2968s.m11528h();
            if (a == 0) {
                z = true;
            }
            h.m12944b(z);
            this.f9793a.unbindService(this);
            c2880b.m11203a();
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public int m11253a(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            C2972b.m11583d("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            C2972b.m11583d("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public int m11254a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            C2972b.m11583d("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            C2972b.m11583d("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public String m11255a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                C2972b.m11583d("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public void m11256a(Context context) {
        ServiceConnection c28921 = new C28921(this, context);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        context.bindService(intent, c28921, 1);
    }

    public void m11257a(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        GInAppPurchaseManagerInfoParcel.m11192a(intent, gInAppPurchaseManagerInfoParcel);
        C2968s.m11525e().m13033a(context, intent);
    }

    public String m11258b(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public String m11259b(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("purchaseToken");
            } catch (JSONException e) {
                C2972b.m11583d("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public String m11260c(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }
}
