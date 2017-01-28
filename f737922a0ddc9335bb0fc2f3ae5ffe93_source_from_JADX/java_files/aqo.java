import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

class aqo extends apv {
    private final aql j6;

    aqo(aql aql) {
        this.j6 = aql;
    }

    int DW() {
        return 0;
    }

    aqc j6() {
        boolean z = true;
        aql aql = this.j6;
        aqt J0 = aql.J0();
        awl J8 = aql.J8();
        apj apj = this.j6.VH;
        aql.DW.j6(aql, aql.Zo);
        apv app;
        if (J0 != aqt.v5) {
            apv apv;
            int i;
            apv apq;
            boolean DW = apj.DW(4);
            boolean DW2 = this.j6.DW(aqi.BOUNDARY);
            if (DW2 || !(this.j6 instanceof apy)) {
                z = DW2;
            }
            if (!z || DW) {
                DW2 = z;
            } else {
                DW2 = false;
            }
            if (apj instanceof apo) {
                apv = (apo) apj;
            } else {
                apv = new apo(apj);
            }
            if (J8 != awl.FH) {
                J0 = aqq.j6(J0, new aqn(aql, J8));
                i = 6;
            } else {
                i = 0;
            }
            this.j6.VH = apj;
            if (this.j6 instanceof apr) {
                apq = new apq((apr) this.j6, apv);
            } else {
                apq = new apz(aql, apv, J0, i);
                if (DW2) {
                    ((apz) apq).j6 = false;
                }
            }
            if ((apq.DW() & 4) != 0) {
                apq = new aqm(new aps(apq));
            }
            if (this.j6.DW(aqi.TOPO) && (apq.DW() & 8) == 0) {
                apq = new aqp(apq);
            }
            if (this.j6.DW(aqi.REVERSE)) {
                apq = new apw(apq);
            }
            if (DW2) {
                apq = new apn(aql, apq);
            } else if (DW) {
                if (apv.FH() != null) {
                    app = new app(apq);
                } else {
                    app = apq;
                }
                apq = new apt(app);
            }
            aql.gn = apq;
            return apq.j6();
        } else if (J8 != awl.FH) {
            throw new IllegalStateException(MessageFormat.format(JGitText.j6().cannotCombineTreeFilterWithRevFilter, new Object[]{J8, J0}));
        } else {
            app = new apx(aql);
            this.j6.gn = app;
            this.j6.VH = apj.j6;
            app.j6(apj);
            return app.j6();
        }
    }
}
