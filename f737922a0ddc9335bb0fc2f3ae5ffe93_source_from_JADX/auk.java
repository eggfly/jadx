import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jgit.JGitText;

class auk {
    static final String j6;
    private final avd DW;
    private auj FH;
    private final Map<String, aus> Hw;
    private final aql v5;

    static {
        j6 = JGitText.j6().openingConnection;
    }

    auk(avd avd, Collection<aus> collection) {
        this.v5 = new aql(avd.FH);
        this.DW = avd;
        this.Hw = new HashMap();
        for (aus aus : collection) {
            if (this.Hw.put(aus.v5(), aus) != null) {
                throw new amb(MessageFormat.format(JGitText.j6().duplicateRemoteRefUpdateIsIllegal, new Object[]{aus.v5()}));
            }
        }
    }

    aul j6(aob aob) {
        aul aul;
        try {
            aob.j6(j6, 0);
            aul = new aul();
            this.FH = this.DW.XL();
            aul.j6(this.DW.Hw(), this.FH.j6());
            aul.j6(this.Hw);
            aob.DW();
            Map j6 = j6();
            if (this.DW.we()) {
                DW();
            } else if (!j6.isEmpty()) {
                this.FH.j6(aob, j6);
            }
            this.FH.u7();
            aul.DW(this.FH.FH());
            if (!this.DW.we()) {
                FH();
            }
            for (aus Zo : this.Hw.values()) {
                avb Zo2 = Zo.Zo();
                if (Zo2 != null) {
                    aul.j6(Zo2);
                }
            }
            this.v5.we();
            return aul;
        } catch (Throwable th) {
            this.v5.we();
        }
    }

    private Map<String, aus> j6() {
        Map<String, aus> hashMap = new HashMap();
        for (aus aus : this.Hw.values()) {
            aoc j6 = this.FH.j6(aus.v5());
            anb Zo = j6 == null ? ans.Zo() : j6.v5();
            if (aus.FH().DW(Zo)) {
                if (aus.Hw()) {
                    aus.j6(aus$a.NON_EXISTING);
                } else {
                    aus.j6(aus$a.UP_TO_DATE);
                }
            } else if (aus.DW() && !aus.j6().DW(Zo)) {
                aus.j6(aus$a.REJECTED_REMOTE_CHANGED);
            } else if (Zo.DW(ans.Zo()) || aus.Hw()) {
                aus.j6(true);
                hashMap.put(aus.v5(), aus);
            } else {
                boolean z;
                try {
                    aqg gn = this.v5.gn(Zo);
                    aqg gn2 = this.v5.gn(aus.FH());
                    if ((gn instanceof aqc) && (gn2 instanceof aqc) && this.v5.j6((aqc) gn, (aqc) gn2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } catch (ali e) {
                    z = false;
                } catch (Throwable e2) {
                    throw new amb(this.DW.Hw(), MessageFormat.format(JGitText.j6().readingObjectsFromLocalRepositoryFailed, new Object[]{e2.getMessage()}), e2);
                }
                aus.j6(z);
                if (z || aus.gn()) {
                    hashMap.put(aus.v5(), aus);
                } else {
                    aus.j6(aus$a.REJECTED_NONFASTFORWARD);
                }
            }
        }
        return hashMap;
    }

    private void DW() {
        for (aus aus : this.Hw.values()) {
            if (aus.u7() == aus$a.NOT_ATTEMPTED) {
                aus.j6(aus$a.OK);
            }
        }
    }

    private void FH() {
        for (aus aus : this.Hw.values()) {
            aus$a u7 = aus.u7();
            if (aus.VH() && (u7 == aus$a.UP_TO_DATE || u7 == aus$a.OK)) {
                try {
                    aus.j6(this.v5);
                } catch (IOException e) {
                }
            }
        }
    }
}
