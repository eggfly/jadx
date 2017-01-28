import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;

public class anh {
    private static final byte[] DW;
    private static final byte[] FH;
    private static final byte[] Hw;
    private static final byte[] Zo;
    private static final ans[] j6;
    private static final byte[] v5;
    private String EQ;
    private ans VH;
    private ans[] gn;
    private aoa tp;
    private aoa u7;
    private Charset we;

    static {
        j6 = new ans[0];
        DW = anj.j6("tree");
        FH = anj.j6("parent");
        Hw = anj.j6("author");
        v5 = anj.j6("committer");
        Zo = anj.j6("encoding");
    }

    public anh() {
        this.gn = j6;
        this.we = anj.DW;
    }

    public ans j6() {
        return this.VH;
    }

    public void j6(anb anb) {
        this.VH = anb.Hw();
    }

    public aoa DW() {
        return this.u7;
    }

    public void j6(aoa aoa) {
        this.u7 = aoa;
    }

    public aoa FH() {
        return this.tp;
    }

    public void DW(aoa aoa) {
        this.tp = aoa;
    }

    public ans[] Hw() {
        return this.gn;
    }

    public void j6(List<? extends anb> list) {
        this.gn = new ans[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.gn[i] = ((anb) list.get(i)).Hw();
        }
    }

    public String v5() {
        return this.EQ;
    }

    public void j6(String str) {
        this.EQ = str;
    }

    public Charset Zo() {
        return this.we;
    }

    public byte[] VH() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, Zo());
        try {
            byteArrayOutputStream.write(DW);
            byteArrayOutputStream.write(32);
            j6().DW(byteArrayOutputStream);
            byteArrayOutputStream.write(10);
            for (ans ans : Hw()) {
                byteArrayOutputStream.write(FH);
                byteArrayOutputStream.write(32);
                ans.DW(byteArrayOutputStream);
                byteArrayOutputStream.write(10);
            }
            byteArrayOutputStream.write(Hw);
            byteArrayOutputStream.write(32);
            outputStreamWriter.write(DW().Hw());
            outputStreamWriter.flush();
            byteArrayOutputStream.write(10);
            byteArrayOutputStream.write(v5);
            byteArrayOutputStream.write(32);
            outputStreamWriter.write(FH().Hw());
            outputStreamWriter.flush();
            byteArrayOutputStream.write(10);
            if (Zo() != anj.DW) {
                byteArrayOutputStream.write(Zo);
                byteArrayOutputStream.write(32);
                byteArrayOutputStream.write(anj.j6(Zo().name()));
                byteArrayOutputStream.write(10);
            }
            byteArrayOutputStream.write(10);
            if (v5() != null) {
                outputStreamWriter.write(v5());
                outputStreamWriter.flush();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Commit");
        stringBuilder.append("={\n");
        stringBuilder.append("tree ");
        stringBuilder.append(this.VH != null ? this.VH.DW() : "NOT_SET");
        stringBuilder.append("\n");
        for (ans ans : this.gn) {
            stringBuilder.append("parent ");
            stringBuilder.append(ans.DW());
            stringBuilder.append("\n");
        }
        stringBuilder.append("author ");
        stringBuilder.append(this.u7 != null ? this.u7.toString() : "NOT_SET");
        stringBuilder.append("\n");
        stringBuilder.append("committer ");
        stringBuilder.append(this.tp != null ? this.tp.toString() : "NOT_SET");
        stringBuilder.append("\n");
        if (!(this.we == null || this.we == anj.DW)) {
            stringBuilder.append("encoding ");
            stringBuilder.append(this.we.name());
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append(this.EQ != null ? this.EQ : "");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
