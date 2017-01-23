package anet.channel.monitor;

/* renamed from: anet.channel.monitor.d */
class C0679d {
    private long f2252a;
    private double f2253b;
    private double f2254c;
    private double f2255d;
    private double f2256e;
    private double f2257f;
    private double f2258g;
    private double f2259h;
    private double f2260i;
    private double f2261j;
    private double f2262k;

    C0679d() {
        this.f2252a = 0;
        this.f2260i = 0.0d;
        this.f2261j = 0.0d;
        this.f2262k = 0.0d;
    }

    public double m2816a(double d, double d2) {
        double d3 = d / d2;
        if (d3 >= 8.0d) {
            if (this.f2252a == 0) {
                this.f2260i = d3;
                this.f2259h = this.f2260i;
                this.f2255d = this.f2259h * 0.1d;
                this.f2254c = this.f2259h * 0.02d;
                this.f2256e = (0.1d * this.f2259h) * this.f2259h;
            } else if (this.f2252a == 1) {
                this.f2261j = d3;
                this.f2259h = this.f2261j;
            } else {
                double d4 = d3 - this.f2261j;
                this.f2260i = this.f2261j;
                this.f2261j = d3;
                this.f2253b = d3 / 0.95d;
                this.f2258g = this.f2253b - (this.f2259h * 0.95d);
                int i = 0;
                double sqrt = Math.sqrt(this.f2255d);
                if (this.f2258g >= 4.0d * sqrt) {
                    i = 1;
                    this.f2258g = (sqrt * 2.0d) + (0.75d * this.f2258g);
                } else if (this.f2258g <= -4.0d * sqrt) {
                    i = 2;
                    this.f2258g = (sqrt * -1.0d) + (0.75d * this.f2258g);
                }
                this.f2255d = Math.min(Math.max(Math.abs((1.05d * this.f2255d) - ((0.0025d * this.f2258g) * this.f2258g)), 0.8d * this.f2255d), 1.25d * this.f2255d);
                this.f2257f = this.f2256e / (((0.95d * 0.95d) * this.f2256e) + this.f2255d);
                this.f2259h = ((d4 * (1.0d / 0.95d)) + this.f2259h) + (this.f2257f * this.f2258g);
                if (i == 1) {
                    this.f2259h = Math.min(this.f2259h, this.f2253b);
                } else if (i == 2) {
                    this.f2259h = Math.max(this.f2259h, this.f2253b);
                }
                this.f2256e = (1.0d - (0.95d * this.f2257f)) * (this.f2256e + this.f2254c);
            }
            if (this.f2259h < 0.0d) {
                this.f2262k = this.f2261j * 0.7d;
                this.f2259h = this.f2262k;
            } else {
                this.f2262k = this.f2259h;
            }
            return this.f2262k;
        } else if (this.f2252a != 0) {
            return this.f2262k;
        } else {
            this.f2262k = d3;
            return this.f2262k;
        }
    }

    public void m2817a() {
        this.f2252a = 0;
        this.f2262k = 0.0d;
    }
}
