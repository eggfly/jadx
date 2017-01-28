public class sr {
    public final sz j6(su suVar, int i, int i2, ti tiVar) {
        if (suVar == null) {
            throw new NullPointerException("cf == null");
        } else if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("bad context");
        } else {
            abe abe = null;
            try {
                acu j6 = suVar.j6();
                aai Zo = suVar.Zo();
                int Zo2 = j6.Zo(i2);
                int FH = j6.FH(i2 + 2);
                abe = (abe) Zo.j6(Zo2);
                if (tiVar != null) {
                    tiVar.j6(j6, i2, 2, "name: " + abe.Hw());
                    tiVar.j6(j6, i2 + 2, 4, "length: " + add.j6(FH));
                }
                return j6(suVar, i, abe.tp(), i2 + 6, FH, tiVar);
            } catch (th e) {
                th thVar = e;
                thVar.j6("...while parsing " + (abe != null ? abe.Hw() + " " : "") + "attribute at offset " + add.j6(i2));
                throw thVar;
            }
        }
    }

    protected sz j6(su suVar, int i, String str, int i2, int i3, ti tiVar) {
        acu j6 = suVar.j6();
        sz rqVar = new rq(str, j6, i2, i3, suVar.Zo());
        if (tiVar != null) {
            tiVar.j6(j6, i2, i3, "attribute data");
        }
        return rqVar;
    }
}
