public class amy {
    private boolean DW;
    private boolean FH;
    private boolean Hw;
    private String j6;
    private amr v5;

    public amy(String str) {
        this.j6 = str;
        this.DW = false;
        this.FH = false;
        this.Hw = false;
        this.v5 = null;
        DW();
    }

    private void DW() {
        int i = 0;
        int length = this.j6.length();
        if (this.j6.startsWith("!")) {
            this.DW = true;
            i = 1;
        }
        if (this.j6.endsWith("/")) {
            length--;
            this.Hw = true;
        }
        this.j6 = this.j6.substring(i, length);
        if (!this.j6.contains("/")) {
            this.FH = true;
        } else if (!this.j6.startsWith("/")) {
            this.j6 = "/" + this.j6;
        }
        if (this.j6.contains("*") || this.j6.contains("?") || this.j6.contains("[")) {
            try {
                this.v5 = new amr(this.j6, Character.valueOf('/'));
            } catch (ale e) {
            }
        }
    }

    public boolean j6(String str, boolean z) {
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        String[] split;
        int i;
        if (this.v5 != null) {
            this.v5.j6(str);
            if (this.v5.DW()) {
                return true;
            }
            split = str.split("/");
            String str2;
            if (this.FH) {
                i = 0;
                while (i < split.length) {
                    str2 = split[i];
                    this.v5.j6();
                    this.v5.j6(str2);
                    if (this.v5.DW() && j6(z, i, split.length)) {
                        return true;
                    }
                    i++;
                }
                return false;
            }
            this.v5.j6();
            i = 0;
            while (i < split.length) {
                str2 = split[i];
                if (str2.length() > 0) {
                    this.v5.j6("/" + str2);
                }
                if (this.v5.DW() && j6(z, i, split.length)) {
                    return true;
                }
                i++;
            }
            return false;
        } else if (str.equals(this.j6)) {
            if (!this.Hw || z) {
                return true;
            }
            return false;
        } else if (str.startsWith(this.j6 + "/")) {
            return true;
        } else {
            if (!this.FH) {
                return false;
            }
            split = str.split("/");
            i = 0;
            while (i < split.length) {
                if (split[i].equals(this.j6) && j6(z, i, split.length)) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    public boolean j6() {
        return !this.DW;
    }

    private boolean j6(boolean z, int i, int i2) {
        if (i >= i2 - 1 && this.Hw && !z) {
            return false;
        }
        return true;
    }
}
