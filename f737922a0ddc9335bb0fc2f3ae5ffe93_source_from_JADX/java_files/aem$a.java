public enum aem$a {
    DROPBOX("dropbox"),
    APP_FOLDER("sandbox"),
    AUTO("auto");
    
    private final String Hw;

    private aem$a(String str) {
        this.Hw = str;
    }

    public String toString() {
        return this.Hw;
    }
}
