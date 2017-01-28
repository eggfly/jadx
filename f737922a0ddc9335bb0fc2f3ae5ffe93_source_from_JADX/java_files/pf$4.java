import android.app.PendingIntent;
import android.os.Bundle;
import com.aide.ui.e;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Map;

class pf$4 implements Runnable {
    final /* synthetic */ boolean DW;
    final /* synthetic */ pf FH;
    final /* synthetic */ String j6;

    pf$4(pf pfVar, String str, boolean z) {
        this.FH = pfVar;
        this.j6 = str;
        this.DW = z;
    }

    public void run() {
        try {
            this.FH.QX();
            Map j6 = this.FH.j6(Collections.singleton(this.j6));
            this.FH.J8.set(Long.toString(new SecureRandom().nextLong()));
            Bundle j62 = this.FH.Ws().j6(3, e.j6, this.j6, this.DW ? "subs" : "inapp", (String) this.FH.J8.get());
            pf$f j63 = pf$f.DW(j62.getInt("RESPONSE_CODE"));
            this.FH.VH("resp code for intent getting: " + j63);
            if (j63 == pf$f.RESULT_OK) {
                this.FH.EQ.post(new pf$4$1(this, j6, (PendingIntent) j62.getParcelable("BUY_INTENT")));
            } else if (j63 == pf$f.RESULT_ITEM_ALREADY_OWNED) {
                this.FH.FH();
            } else {
                pf.DW(j63);
            }
        } catch (Throwable e) {
            this.FH.XL();
            this.FH.j6(e);
        } catch (Throwable e2) {
            this.FH.j6(e2);
        } catch (pf$c e3) {
        } catch (Throwable e22) {
            this.FH.j6(e22);
            this.FH.u7(e22.getMessage());
        } catch (Throwable e222) {
            this.FH.j6(e222);
        } catch (Throwable e2222) {
            this.FH.j6(e2222);
        }
    }
}
