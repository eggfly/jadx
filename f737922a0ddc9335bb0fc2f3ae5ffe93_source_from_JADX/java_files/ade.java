import java.io.FilterWriter;
import java.io.Writer;

public final class ade extends FilterWriter {
    private final int DW;
    private final int FH;
    private int Hw;
    private int Zo;
    private final String j6;
    private boolean v5;

    public ade(Writer writer, int i, String str) {
        super(writer);
        if (writer == null) {
            throw new NullPointerException("out == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("width < 0");
        } else if (str == null) {
            throw new NullPointerException("prefix == null");
        } else {
            this.DW = i != 0 ? i : Integer.MAX_VALUE;
            this.FH = i >> 1;
            if (str.length() == 0) {
                str = null;
            }
            this.j6 = str;
            j6();
        }
    }

    public ade(Writer writer, int i) {
        this(writer, i, "");
    }

    public void write(int i) {
        synchronized (this.lock) {
            if (this.v5) {
                if (i == 32) {
                    this.Zo++;
                    if (this.Zo >= this.FH) {
                        this.Zo = this.FH;
                        this.v5 = false;
                    }
                } else {
                    this.v5 = false;
                }
            }
            if (this.Hw == this.DW && i != 10) {
                this.out.write(10);
                this.Hw = 0;
            }
            if (this.Hw == 0) {
                if (this.j6 != null) {
                    this.out.write(this.j6);
                }
                if (!this.v5) {
                    for (int i2 = 0; i2 < this.Zo; i2++) {
                        this.out.write(32);
                    }
                    this.Hw = this.Zo;
                }
            }
            this.out.write(i);
            if (i == 10) {
                j6();
            } else {
                this.Hw++;
            }
        }
    }

    public void write(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            while (i2 > 0) {
                write(cArr[i]);
                i++;
                i2--;
            }
        }
    }

    public void write(String str, int i, int i2) {
        synchronized (this.lock) {
            while (i2 > 0) {
                write(str.charAt(i));
                i++;
                i2--;
            }
        }
    }

    private void j6() {
        boolean z;
        this.Hw = 0;
        if (this.FH != 0) {
            z = true;
        } else {
            z = false;
        }
        this.v5 = z;
        this.Zo = 0;
    }
}
