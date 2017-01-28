public enum zd implements adq {
    RUNTIME("runtime"),
    BUILD("build"),
    SYSTEM("system"),
    EMBEDDED("embedded");
    
    private final String v5;

    private zd(String str) {
        this.v5 = str;
    }

    public String Hw() {
        return this.v5;
    }
}
