public abstract class bet implements beo {
    static final long[] u7;
    protected long DW;
    private int EQ;
    protected long FH;
    protected long Hw;
    private long J0;
    private long[] J8;
    protected long VH;
    private int Ws;
    protected long Zo;
    protected long gn;
    protected long j6;
    private byte[] tp;
    protected long v5;
    private long we;

    protected bet() {
        this.J8 = new long[80];
        this.tp = new byte[8];
        this.EQ = 0;
        FH();
    }

    public void j6(byte b) {
        byte[] bArr = this.tp;
        int i = this.EQ;
        this.EQ = i + 1;
        bArr[i] = b;
        if (this.EQ == this.tp.length) {
            DW(this.tp, 0);
            this.EQ = 0;
        }
        this.we++;
    }

    public void j6(byte[] bArr, int i, int i2) {
        while (this.EQ != 0 && i2 > 0) {
            j6(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.tp.length) {
            DW(bArr, i);
            i += this.tp.length;
            i2 -= this.tp.length;
            this.we += (long) this.tp.length;
        }
        while (i2 > 0) {
            j6(bArr[i]);
            i++;
            i2--;
        }
    }

    public void Hw() {
        Zo();
        long j = this.we << 3;
        long j2 = this.J0;
        j6(Byte.MIN_VALUE);
        while (this.EQ != 0) {
            j6((byte) 0);
        }
        j6(j, j2);
        v5();
    }

    public void FH() {
        int i = 0;
        this.we = 0;
        this.J0 = 0;
        this.EQ = 0;
        for (int i2 = 0; i2 < this.tp.length; i2++) {
            this.tp[i2] = (byte) 0;
        }
        this.Ws = 0;
        while (i != this.J8.length) {
            this.J8[i] = 0;
            i++;
        }
    }

    protected void DW(byte[] bArr, int i) {
        this.J8[this.Ws] = bfu.DW(bArr, i);
        int i2 = this.Ws + 1;
        this.Ws = i2;
        if (i2 == 16) {
            v5();
        }
    }

    private void Zo() {
        if (this.we > 2305843009213693951L) {
            this.J0 += this.we >>> 61;
            this.we &= 2305843009213693951L;
        }
    }

    protected void j6(long j, long j2) {
        if (this.Ws > 14) {
            v5();
        }
        this.J8[14] = j2;
        this.J8[15] = j;
    }

    protected void v5() {
        int i;
        Zo();
        for (i = 16; i <= 79; i++) {
            this.J8[i] = ((Hw(this.J8[i - 2]) + this.J8[i - 7]) + FH(this.J8[i - 15])) + this.J8[i - 16];
        }
        long j = this.j6;
        long j2 = this.DW;
        long j3 = this.FH;
        long j4 = this.Hw;
        long j5 = this.v5;
        long j6 = this.Zo;
        long j7 = this.VH;
        i = 0;
        long j8 = this.gn;
        long j9 = j;
        int i2 = 0;
        while (i < 10) {
            int i3 = i2 + 1;
            j8 += this.J8[i2] + ((DW(j5) + j6(j5, j6, j7)) + u7[i2]);
            j4 += j8;
            j = (DW(j9, j2, j3) + j6(j9)) + j8;
            int i4 = i3 + 1;
            long j62 = j7 + (((j6(j4, j5, j6) + DW(j4)) + u7[i3]) + this.J8[i3]);
            j8 = j3 + j62;
            j7 = (DW(j, j9, j2) + j6(j)) + j62;
            int i5 = i4 + 1;
            long j63 = j6 + (((j6(j8, j4, j5) + DW(j8)) + u7[i4]) + this.J8[i4]);
            j3 = j2 + j63;
            j6 = (DW(j7, j, j9) + j6(j7)) + j63;
            int i6 = i5 + 1;
            j63 = j5 + (((j6(j3, j8, j4) + DW(j3)) + u7[i5]) + this.J8[i5]);
            j2 = j9 + j63;
            j5 = (DW(j6, j7, j) + j6(j6)) + j63;
            i5 = i6 + 1;
            j4 += ((j6(j2, j3, j8) + DW(j2)) + u7[i6]) + this.J8[i6];
            j9 = j + j4;
            j4 += j6(j5) + DW(j5, j6, j7);
            i3 = i5 + 1;
            long j64 = j8 + (((j6(j9, j2, j3) + DW(j9)) + u7[i5]) + this.J8[i5]);
            j = j7 + j64;
            j8 = j64 + (j6(j4) + DW(j4, j5, j6));
            i4 = i3 + 1;
            long j65 = j3 + (((j6(j, j9, j2) + DW(j)) + u7[i3]) + this.J8[i3]);
            j7 = j6 + j65;
            j3 = j65 + (j6(j8) + DW(j8, j4, j5));
            int i7 = i4 + 1;
            j6 = (((j6(j7, j, j9) + DW(j7)) + u7[i4]) + this.J8[i4]) + j2;
            j5 += j6;
            j6 += DW(j3, j8, j4) + j6(j3);
            i++;
            j2 = j3;
            j3 = j8;
            j8 = j9;
            j9 = j6;
            j6 = j7;
            j7 = j;
            i2 = i7;
        }
        this.j6 += j9;
        this.DW += j2;
        this.FH += j3;
        this.Hw += j4;
        this.v5 += j5;
        this.Zo += j6;
        this.VH += j7;
        this.gn += j8;
        this.Ws = 0;
        for (i = 0; i < 16; i++) {
            this.J8[i] = 0;
        }
    }

    private long j6(long j, long j2, long j3) {
        return (j & j2) ^ ((-1 ^ j) & j3);
    }

    private long DW(long j, long j2, long j3) {
        return ((j & j2) ^ (j & j3)) ^ (j2 & j3);
    }

    private long j6(long j) {
        return (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34))) ^ ((j << 25) | (j >>> 39));
    }

    private long DW(long j) {
        return (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18))) ^ ((j << 23) | (j >>> 41));
    }

    private long FH(long j) {
        return (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8))) ^ (j >>> 7);
    }

    private long Hw(long j) {
        return (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61))) ^ (j >>> 6);
    }

    static {
        u7 = new long[]{4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    }
}
