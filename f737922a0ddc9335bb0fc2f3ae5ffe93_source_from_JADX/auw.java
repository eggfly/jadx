import java.io.IOException;
import java.io.OutputStream;

class auw extends ang {
    private final OutputStream DW;
    private boolean FH;

    auw(OutputStream outputStream) {
        this.DW = outputStream;
        this.FH = true;
    }

    protected void DW(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        j6(stringBuilder, str, i);
        stringBuilder.append("   \r");
        j6(stringBuilder);
    }

    protected void FH(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        j6(stringBuilder, str, i);
        stringBuilder.append(", done\n");
        j6(stringBuilder);
    }

    private void j6(StringBuilder stringBuilder, String str, int i) {
        stringBuilder.append(str);
        stringBuilder.append(": ");
        stringBuilder.append(i);
    }

    protected void j6(String str, int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        j6(stringBuilder, str, i, i2, i3);
        stringBuilder.append("   \r");
        j6(stringBuilder);
    }

    protected void DW(String str, int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder();
        j6(stringBuilder, str, i, i2, i3);
        stringBuilder.append("\n");
        j6(stringBuilder);
    }

    private void j6(StringBuilder stringBuilder, String str, int i, int i2, int i3) {
        stringBuilder.append(str);
        stringBuilder.append(": ");
        if (i3 < 100) {
            stringBuilder.append(' ');
        }
        if (i3 < 10) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(i3);
        stringBuilder.append("% (");
        stringBuilder.append(i);
        stringBuilder.append("/");
        stringBuilder.append(i2);
        stringBuilder.append(")");
    }

    private void j6(StringBuilder stringBuilder) {
        if (this.FH) {
            try {
                this.DW.write(anj.DW(stringBuilder.toString()));
                this.DW.flush();
            } catch (IOException e) {
                this.FH = false;
            }
        }
    }
}
