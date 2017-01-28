import android.os.Binder;
import android.os.Process;
import com.aide.licensing.d.a;
import com.aide.ui.e;

class oa$a extends a {
    final /* synthetic */ oa j6;

    private oa$a(oa oaVar) {
        this.j6 = oaVar;
    }

    public void j6() {
        this.j6.DW("licenseNotVerified");
        if (Binder.getCallingUid() != Process.myUid()) {
            this.j6.FH("UID mismatch - my uid: " + Process.myUid() + " calling uid: " + Binder.getCallingUid());
        } else {
            e.j6(new oa$a$1(this));
        }
    }

    public void j6(String str, String str2) {
        this.j6.DW("licenseVerified: " + str);
        if (Binder.getCallingUid() != Process.myUid()) {
            this.j6.FH("UID mismatch - my uid: " + Process.myUid() + " calling uid: " + Binder.getCallingUid());
        } else {
            e.j6(new oa$a$2(this, str, str2));
        }
    }
}
