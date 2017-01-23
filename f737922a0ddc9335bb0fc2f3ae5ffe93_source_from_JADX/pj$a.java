public class pj$a {
    public int DW;
    public int FH;
    public String Hw;
    public String VH;
    public String Zo;
    private int gn;
    public String j6;
    private int u7;
    public String v5;

    public pj$a(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        this.j6 = str;
        this.DW = i;
        this.FH = i2;
        this.Hw = str2;
        this.v5 = str3;
        this.Zo = str4;
        this.VH = str5;
    }

    public CharSequence j6() {
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append(this.j6);
        stringBuilder.append(" ");
        stringBuilder.append(this.DW);
        stringBuilder.append(" ");
        stringBuilder.append(this.FH);
        stringBuilder.append(" ");
        stringBuilder.append(this.Hw);
        stringBuilder.append(" ");
        while (stringBuilder.length() < 35) {
            stringBuilder.append(" ");
        }
        this.gn = stringBuilder.length();
        stringBuilder.append(this.v5);
        stringBuilder.append(" ");
        stringBuilder.append(this.Zo);
        this.u7 = stringBuilder.length();
        stringBuilder.append("     ");
        while (stringBuilder.length() < 80) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(this.VH);
        return stringBuilder;
    }

    public boolean DW() {
        return "E".equals(this.Hw);
    }

    public boolean FH() {
        return "I".equals(this.Hw);
    }

    public boolean Hw() {
        return "W".equals(this.Hw);
    }

    public boolean j6(int i) {
        return i >= this.gn && i <= this.u7;
    }

    public boolean j6(String str) {
        return this.Zo.equals(str) || (this.Zo.startsWith(str) && this.Zo.charAt(str.length()) == ':');
    }
}
