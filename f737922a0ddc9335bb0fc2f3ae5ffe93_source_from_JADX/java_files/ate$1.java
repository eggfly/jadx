import java.security.MessageDigest;

class ate$1 extends axj$d {
    private final /* synthetic */ String DW;
    private final /* synthetic */ String FH;
    private final /* synthetic */ MessageDigest Hw;
    private final /* synthetic */ String Zo;
    final /* synthetic */ ate j6;
    private final /* synthetic */ aob v5;

    ate$1(ate ate, String str, String str2, MessageDigest messageDigest, aob aob, String str3) {
        this.j6 = ate;
        this.DW = str;
        this.FH = str2;
        this.Hw = messageDigest;
        this.v5 = aob;
        this.Zo = str3;
    }

    public void close() {
        super.close();
        try {
            this.j6.j6(this.DW, this.FH, this.Hw.digest(), this, this.v5, this.Zo);
        } finally {
            Zo();
        }
    }
}
