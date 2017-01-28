import com.aide.ui.e;

class pf$3 implements Runnable {
    final /* synthetic */ pf j6;

    pf$3(pf pfVar) {
        this.j6 = pfVar;
    }

    public void run() {
        try {
            this.j6.QX();
            adu DW = this.j6.Ws();
            this.j6.VH("Requesting in-app purchases");
            if (this.j6.j6(DW.j6(3, e.j6, "inapp", null))) {
                DW = this.j6.Ws();
                this.j6.VH("Requesting subscription purchases");
            } else {
                DW = this.j6.Ws();
                this.j6.VH("Requesting subscription purchases");
            }
            if (this.j6.j6(DW.j6(3, e.j6, "subs", null))) {
            }
            synchronized (this.j6.J0) {
                this.j6.Ws = false;
            }
        } catch (Throwable e) {
            this.j6.j6(e);
            synchronized (this.j6.J0) {
            }
            this.j6.Ws = false;
        } catch (Throwable e2) {
            this.j6.j6(e2);
            synchronized (this.j6.J0) {
            }
            this.j6.Ws = false;
        } catch (Throwable e22) {
            this.j6.j6(e22);
            synchronized (this.j6.J0) {
            }
            this.j6.Ws = false;
        } catch (Throwable e222) {
            this.j6.j6(e222);
            synchronized (this.j6.J0) {
            }
            this.j6.Ws = false;
        } catch (Throwable th) {
            synchronized (this.j6.J0) {
            }
            this.j6.Ws = false;
        }
    }
}
