package android.support.v7.widget;

class ax {
    private int f1920a;
    private int f1921b;
    private int f1922c;
    private int f1923d;
    private int f1924e;
    private int f1925f;
    private boolean f1926g;
    private boolean f1927h;

    ax() {
        this.f1920a = 0;
        this.f1921b = 0;
        this.f1922c = LinearLayoutManager.INVALID_OFFSET;
        this.f1923d = LinearLayoutManager.INVALID_OFFSET;
        this.f1924e = 0;
        this.f1925f = 0;
        this.f1926g = false;
        this.f1927h = false;
    }

    public int m2452a() {
        return this.f1920a;
    }

    public void m2453a(int i, int i2) {
        this.f1922c = i;
        this.f1923d = i2;
        this.f1927h = true;
        if (this.f1926g) {
            if (i2 != LinearLayoutManager.INVALID_OFFSET) {
                this.f1920a = i2;
            }
            if (i != LinearLayoutManager.INVALID_OFFSET) {
                this.f1921b = i;
                return;
            }
            return;
        }
        if (i != LinearLayoutManager.INVALID_OFFSET) {
            this.f1920a = i;
        }
        if (i2 != LinearLayoutManager.INVALID_OFFSET) {
            this.f1921b = i2;
        }
    }

    public void m2454a(boolean z) {
        if (z != this.f1926g) {
            this.f1926g = z;
            if (!this.f1927h) {
                this.f1920a = this.f1924e;
                this.f1921b = this.f1925f;
            } else if (z) {
                this.f1920a = this.f1923d != LinearLayoutManager.INVALID_OFFSET ? this.f1923d : this.f1924e;
                this.f1921b = this.f1922c != LinearLayoutManager.INVALID_OFFSET ? this.f1922c : this.f1925f;
            } else {
                this.f1920a = this.f1922c != LinearLayoutManager.INVALID_OFFSET ? this.f1922c : this.f1924e;
                this.f1921b = this.f1923d != LinearLayoutManager.INVALID_OFFSET ? this.f1923d : this.f1925f;
            }
        }
    }

    public int m2455b() {
        return this.f1921b;
    }

    public void m2456b(int i, int i2) {
        this.f1927h = false;
        if (i != LinearLayoutManager.INVALID_OFFSET) {
            this.f1924e = i;
            this.f1920a = i;
        }
        if (i2 != LinearLayoutManager.INVALID_OFFSET) {
            this.f1925f = i2;
            this.f1921b = i2;
        }
    }

    public int m2457c() {
        return this.f1926g ? this.f1921b : this.f1920a;
    }

    public int m2458d() {
        return this.f1926g ? this.f1920a : this.f1921b;
    }
}
