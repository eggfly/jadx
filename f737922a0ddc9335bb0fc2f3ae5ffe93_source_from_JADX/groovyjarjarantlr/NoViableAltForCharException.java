package groovyjarjarantlr;

public class NoViableAltForCharException extends RecognitionException {
    public char j6;

    public NoViableAltForCharException(char c, String str, int i, int i2) {
        super("NoViableAlt", str, i, i2);
        this.j6 = c;
    }

    public String getMessage() {
        String str = "unexpected char: ";
        if (this.j6 < ' ' || this.j6 > '~') {
            return new StringBuffer().append(str).append("0x").append(Integer.toHexString(this.j6).toUpperCase()).toString();
        }
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append('\'').toString()).append(this.j6).toString()).append('\'').toString();
    }
}
