class sj$a {
    int j6;

    sj$a(int i) {
        this.j6 = i;
    }

    int j6() {
        int i = this.j6;
        this.j6 = i + 1;
        return i;
    }
}
