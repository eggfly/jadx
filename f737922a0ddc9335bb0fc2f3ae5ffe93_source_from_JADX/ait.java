import java.util.ArrayList;
import java.util.Collection;

public class ait extends aiu<ait, Collection<String>> {
    private final Collection<String> Zo;
    private aob v5;

    public /* synthetic */ Object call() {
        return j6();
    }

    public ait(aoh aoh) {
        super(aoh);
        this.Zo = new ArrayList();
    }

    public ait j6(aob aob) {
        this.v5 = aob;
        return this;
    }

    public Collection<String> j6() {
        Zo();
        try {
            atd j6 = atd.j6(this.j6);
            if (!this.Zo.isEmpty()) {
                j6.j6(awj.j6(this.Zo));
            }
            Collection arrayList = new ArrayList();
            while (j6.DW()) {
                if (j6.v5() != null) {
                    String Zo = j6.Zo();
                    if (Zo != null) {
                        aoh tp = j6.tp();
                        if (tp == null) {
                            aiu j62 = aid.j6();
                            j6(j62);
                            j62.j6(Zo);
                            j62.j6(j6.j6());
                            if (this.v5 != null) {
                                j62.j6(this.v5);
                            }
                            tp = j62.j6().QX();
                        }
                        anb Zo2 = new aql(tp).Zo(j6.Hw());
                        String gn = j6.gn();
                        if ("merge".equals(gn)) {
                            aii aii = new aii(tp);
                            aii.j6(Zo2);
                            aii.j6();
                        } else if ("rebase".equals(gn)) {
                            ain ain = new ain(tp);
                            ain.DW(Zo2);
                            ain.j6();
                        } else {
                            akr akr = new akr(tp, tp.XL(), Zo2.u7());
                            akr.j6(true);
                            akr.v5();
                            aof j63 = tp.j6("HEAD", true);
                            j63.j6(Zo2);
                            j63.Ws();
                        }
                        arrayList.add(j6.FH());
                    } else {
                        continue;
                    }
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new ajg(e.getMessage(), e);
        } catch (Throwable e2) {
            throw new ajg(e2.getMessage(), e2);
        } catch (Throwable e22) {
            throw new ajg(e22.getMessage(), e22);
        }
    }
}
