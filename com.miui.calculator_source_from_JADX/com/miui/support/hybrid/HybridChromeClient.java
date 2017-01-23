package com.miui.support.hybrid;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.net.Uri;
import android.view.KeyEvent;
import com.miui.support.app.AlertDialog.Builder;
import com.miui.support.hybrid.GeolocationPermissions.Callback;
import com.miui.support.internal.hybrid.HybridManager;

public class HybridChromeClient {
    private HybridManager f2037a;

    /* renamed from: com.miui.support.hybrid.HybridChromeClient.1 */
    class C02511 implements OnKeyListener {
        final /* synthetic */ JsResult f2023a;
        final /* synthetic */ HybridChromeClient f2024b;

        C02511(HybridChromeClient hybridChromeClient, JsResult jsResult) {
            this.f2024b = hybridChromeClient;
            this.f2023a = jsResult;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return true;
            }
            this.f2023a.m3535a();
            return false;
        }
    }

    /* renamed from: com.miui.support.hybrid.HybridChromeClient.2 */
    class C02522 implements OnCancelListener {
        final /* synthetic */ JsResult f2025a;
        final /* synthetic */ HybridChromeClient f2026b;

        C02522(HybridChromeClient hybridChromeClient, JsResult jsResult) {
            this.f2026b = hybridChromeClient;
            this.f2025a = jsResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f2025a.m3536b();
        }
    }

    /* renamed from: com.miui.support.hybrid.HybridChromeClient.3 */
    class C02533 implements OnClickListener {
        final /* synthetic */ JsResult f2027a;
        final /* synthetic */ HybridChromeClient f2028b;

        C02533(HybridChromeClient hybridChromeClient, JsResult jsResult) {
            this.f2028b = hybridChromeClient;
            this.f2027a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f2027a.m3535a();
        }
    }

    /* renamed from: com.miui.support.hybrid.HybridChromeClient.4 */
    class C02544 implements OnKeyListener {
        final /* synthetic */ JsResult f2029a;
        final /* synthetic */ HybridChromeClient f2030b;

        C02544(HybridChromeClient hybridChromeClient, JsResult jsResult) {
            this.f2030b = hybridChromeClient;
            this.f2029a = jsResult;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return true;
            }
            this.f2029a.m3535a();
            return false;
        }
    }

    /* renamed from: com.miui.support.hybrid.HybridChromeClient.5 */
    class C02555 implements OnCancelListener {
        final /* synthetic */ JsResult f2031a;
        final /* synthetic */ HybridChromeClient f2032b;

        C02555(HybridChromeClient hybridChromeClient, JsResult jsResult) {
            this.f2032b = hybridChromeClient;
            this.f2031a = jsResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f2031a.m3536b();
        }
    }

    /* renamed from: com.miui.support.hybrid.HybridChromeClient.6 */
    class C02566 implements OnClickListener {
        final /* synthetic */ JsResult f2033a;
        final /* synthetic */ HybridChromeClient f2034b;

        C02566(HybridChromeClient hybridChromeClient, JsResult jsResult) {
            this.f2034b = hybridChromeClient;
            this.f2033a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f2033a.m3536b();
        }
    }

    /* renamed from: com.miui.support.hybrid.HybridChromeClient.7 */
    class C02577 implements OnClickListener {
        final /* synthetic */ JsResult f2035a;
        final /* synthetic */ HybridChromeClient f2036b;

        C02577(HybridChromeClient hybridChromeClient, JsResult jsResult) {
            this.f2036b = hybridChromeClient;
            this.f2035a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f2035a.m3535a();
        }
    }

    public void m3500a(HybridManager hybridManager) {
        this.f2037a = hybridManager;
    }

    public boolean m3502a(HybridView hybridView, String str, String str2, JsResult jsResult) {
        new Builder(this.f2037a.m4044b()).m3271b((CharSequence) str2).m3262a(17039370, new C02533(this, jsResult)).m3263a(new C02522(this, jsResult)).m3264a(new C02511(this, jsResult)).m3272b();
        return true;
    }

    public boolean m3503b(HybridView hybridView, String str, String str2, JsResult jsResult) {
        new Builder(this.f2037a.m4044b()).m3271b((CharSequence) str2).m3262a(17039370, new C02577(this, jsResult)).m3270b(17039360, new C02566(this, jsResult)).m3263a(new C02555(this, jsResult)).m3264a(new C02544(this, jsResult)).m3272b();
        return true;
    }

    public void m3501a(String str, Callback callback) {
    }

    public void m3497a(HybridView hybridView, int i) {
        hybridView.setProgress(i);
    }

    public void m3498a(HybridView hybridView, String str) {
    }

    public void m3499a(ValueCallback<Uri> valueCallback, String str, String str2) {
        valueCallback.m3562a(null);
    }
}
