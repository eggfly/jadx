class ani$a {
    String DW;
    String FH;
    String Hw;
    String Zo;
    String j6;
    String v5;

    private ani$a() {
    }

    ani$a j6(String str) {
        ani$a ani_a = new ani$a();
        ani_a.j6 = this.j6;
        ani_a.DW = this.DW;
        ani_a.FH = this.FH;
        ani_a.Hw = this.Hw;
        ani_a.v5 = str;
        ani_a.Zo = this.Zo;
        return ani_a;
    }

    boolean j6(String str, String str2, String str3) {
        return DW(this.DW, str) && FH(this.FH, str2) && DW(this.Hw, str3);
    }

    boolean j6(String str, String str2) {
        return DW(this.DW, str) && FH(this.FH, str2);
    }

    private static boolean DW(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return axh.j6(str, str2);
    }

    private static boolean FH(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public String toString() {
        if (this.DW == null) {
            return "<empty>";
        }
        StringBuilder stringBuilder = new StringBuilder(this.DW);
        if (this.FH != null) {
            stringBuilder.append(".").append(this.FH);
        }
        if (this.Hw != null) {
            stringBuilder.append(".").append(this.Hw);
        }
        if (this.v5 != null) {
            stringBuilder.append("=").append(this.v5);
        }
        return stringBuilder.toString();
    }
}
