import java.io.Writer;

class atr {
    boolean DW;
    String FH;
    avn Hw;
    ans j6;

    atr() {
    }

    void j6(Writer writer) {
        String str;
        String substring;
        if (this.FH.startsWith("refs/heads/")) {
            str = "branch";
            substring = this.FH.substring("refs/heads/".length());
        } else if (this.FH.startsWith("refs/tags/")) {
            str = "tag";
            substring = this.FH.substring("refs/tags/".length());
        } else if (this.FH.startsWith("refs/remotes/")) {
            str = "remote branch";
            substring = this.FH.substring("refs/remotes/".length());
        } else {
            str = "";
            substring = this.FH;
        }
        writer.write(this.j6.DW());
        writer.write(9);
        if (this.DW) {
            writer.write("not-for-merge");
        }
        writer.write(9);
        writer.write(str);
        writer.write(" '");
        writer.write(substring);
        writer.write("' of ");
        writer.write(this.Hw.toString());
        writer.write("\n");
    }
}
