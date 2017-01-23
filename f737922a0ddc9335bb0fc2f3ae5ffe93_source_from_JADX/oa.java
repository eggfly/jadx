import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.aide.licensing.IAideLicensingService;
import com.aide.licensing.c;
import com.aide.licensing.c.a;
import com.aide.ui.e;
import com.aide.uidesigner.ProxyTextView;

public abstract class oa {
    private ServiceConnection DW;
    private boolean FH;
    private oa$a Hw;
    private int VH;
    private String Zo;
    private String gn;
    private IAideLicensingService j6;
    private String v5;

    protected abstract void j6();

    protected abstract void j6(long j);

    protected abstract void j6(String str);

    public oa(String str, String str2, int i, String str3) {
        this.Hw = new oa$a();
        this.v5 = str;
        this.Zo = str2;
        this.VH = i;
        this.gn = str3;
    }

    public void DW() {
    }

    public void FH() {
        if (this.j6 != null) {
            DW("Unbinding license service");
            e.gn().unbindService(this.DW);
            this.DW = null;
            this.FH = false;
        }
    }

    public boolean Hw() {
        return e.gn().getPackageManager().checkSignatures(this.v5, "com.aide.ui") == 0;
    }

    public void v5() {
        Object obj = null;
        if (!e.j6.equals("com.aide.phonegap")) {
            PackageManager packageManager = e.gn().getPackageManager();
            boolean Hw = Hw();
            if (Hw) {
                try {
                    if (packageManager.getPackageInfo(this.v5, 0).versionCode >= this.VH) {
                        obj = 1;
                    }
                } catch (NameNotFoundException e) {
                }
            }
            if (Hw && r0 != null) {
                Zo();
            } else if (Hw && r0 == null) {
                j6();
            }
        }
    }

    private void Zo() {
        if (this.j6 != null) {
            VH();
        } else if (this.FH) {
            DW("Licensing service bind already pending");
        } else {
            this.DW = new oa$1(this);
            DW("Binding to " + IAideLicensingService.class.getName());
            boolean z = false;
            try {
                Intent intent = new Intent(this.gn);
                intent.setPackage(this.v5);
                z = e.gn().bindService(intent, this.DW, 1);
            } catch (Exception e) {
            }
            if (z) {
                this.FH = z;
            } else {
                DW("Licensing service could not be bound");
            }
        }
    }

    private void VH() {
        try {
            DW("Requesting license check");
            this.j6.j6(this.Hw);
        } catch (Exception e) {
            j6(e);
        }
    }

    private void j6(String str, String str2) {
        a j6 = c.j6(e.gn(), -1, -1, -1, this.v5, str, str2, this.Zo);
        switch (oa$2.j6[j6.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                j6(c.j6(str, str2, this.Zo).u7);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j6("OVER_GRACE_PERIOD");
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                j6("NOT_LICENSED");
            case 5:
                j6("TEMPORARY_ERROR");
            default:
                throw new RuntimeException("Unknown LicenseVerificationResult " + j6);
        }
    }

    private void DW(String str) {
        io.j6("(" + this.v5 + ") " + str);
    }

    private void FH(String str) {
        io.DW("(" + this.v5 + ") " + str);
    }

    private void j6(Exception exception) {
        io.j6("(" + this.v5 + ")", exception);
    }
}
