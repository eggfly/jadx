import java.text.MessageFormat;

enum ain$a {
    PICK("pick");
    
    private final String DW;

    private ain$a(String str) {
        this.DW = str;
    }

    public String j6() {
        return this.DW;
    }

    static ain$a j6(String str) {
        if (str.equals("pick") || str.equals("p")) {
            return PICK;
        }
        throw new ajg(MessageFormat.format("Unknown or unsupported command \"{0}\", only  \"pick\" is allowed", new Object[]{str}));
    }
}
