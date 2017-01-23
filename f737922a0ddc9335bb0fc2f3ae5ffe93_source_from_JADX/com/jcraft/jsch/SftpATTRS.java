package com.jcraft.jsch;

import java.util.Date;

public class SftpATTRS {
    long DW;
    int FH;
    int Hw;
    int VH;
    int Zo;
    String[] gn;
    int j6;
    int v5;

    public String j6() {
        StringBuffer stringBuffer = new StringBuffer(10);
        if (Hw()) {
            stringBuffer.append('d');
        } else if (v5()) {
            stringBuffer.append('l');
        } else {
            stringBuffer.append('-');
        }
        if ((this.v5 & 256) != 0) {
            stringBuffer.append('r');
        } else {
            stringBuffer.append('-');
        }
        if ((this.v5 & 128) != 0) {
            stringBuffer.append('w');
        } else {
            stringBuffer.append('-');
        }
        if ((this.v5 & 2048) != 0) {
            stringBuffer.append('s');
        } else if ((this.v5 & 64) != 0) {
            stringBuffer.append('x');
        } else {
            stringBuffer.append('-');
        }
        if ((this.v5 & 32) != 0) {
            stringBuffer.append('r');
        } else {
            stringBuffer.append('-');
        }
        if ((this.v5 & 16) != 0) {
            stringBuffer.append('w');
        } else {
            stringBuffer.append('-');
        }
        if ((this.v5 & 1024) != 0) {
            stringBuffer.append('s');
        } else if ((this.v5 & 8) != 0) {
            stringBuffer.append('x');
        } else {
            stringBuffer.append('-');
        }
        if ((this.v5 & 4) != 0) {
            stringBuffer.append('r');
        } else {
            stringBuffer.append('-');
        }
        if ((this.v5 & 2) != 0) {
            stringBuffer.append('w');
        } else {
            stringBuffer.append('-');
        }
        if ((this.v5 & 1) != 0) {
            stringBuffer.append('x');
        } else {
            stringBuffer.append('-');
        }
        return stringBuffer.toString();
    }

    public String DW() {
        return new Date(((long) this.VH) * 1000).toString();
    }

    private SftpATTRS() {
        this.j6 = 0;
        this.gn = null;
    }

    static SftpATTRS j6(Buffer buffer) {
        SftpATTRS sftpATTRS = new SftpATTRS();
        sftpATTRS.j6 = buffer.Hw();
        if ((sftpATTRS.j6 & 1) != 0) {
            sftpATTRS.DW = buffer.FH();
        }
        if ((sftpATTRS.j6 & 2) != 0) {
            sftpATTRS.FH = buffer.Hw();
            sftpATTRS.Hw = buffer.Hw();
        }
        if ((sftpATTRS.j6 & 4) != 0) {
            sftpATTRS.v5 = buffer.Hw();
        }
        if ((sftpATTRS.j6 & 8) != 0) {
            sftpATTRS.Zo = buffer.Hw();
        }
        if ((sftpATTRS.j6 & 8) != 0) {
            sftpATTRS.VH = buffer.Hw();
        }
        if ((sftpATTRS.j6 & Integer.MIN_VALUE) != 0) {
            int Hw = buffer.Hw();
            if (Hw > 0) {
                sftpATTRS.gn = new String[(Hw * 2)];
                for (int i = 0; i < Hw; i++) {
                    sftpATTRS.gn[i * 2] = Util.DW(buffer.tp());
                    sftpATTRS.gn[(i * 2) + 1] = Util.DW(buffer.tp());
                }
            }
        }
        return sftpATTRS;
    }

    int FH() {
        int i = 4;
        if ((this.j6 & 1) != 0) {
            i = 12;
        }
        if ((this.j6 & 2) != 0) {
            i += 8;
        }
        if ((this.j6 & 4) != 0) {
            i += 4;
        }
        if ((this.j6 & 8) != 0) {
            i += 8;
        }
        if ((this.j6 & Integer.MIN_VALUE) != 0) {
            i += 4;
            int length = this.gn.length / 2;
            if (length > 0) {
                int i2 = 0;
                while (i2 < length) {
                    int length2 = this.gn[(i2 * 2) + 1].length() + (((i + 4) + this.gn[i2 * 2].length()) + 4);
                    i2++;
                    i = length2;
                }
            }
        }
        return i;
    }

    void DW(Buffer buffer) {
        buffer.j6(this.j6);
        if ((this.j6 & 1) != 0) {
            buffer.j6(this.DW);
        }
        if ((this.j6 & 2) != 0) {
            buffer.j6(this.FH);
            buffer.j6(this.Hw);
        }
        if ((this.j6 & 4) != 0) {
            buffer.j6(this.v5);
        }
        if ((this.j6 & 8) != 0) {
            buffer.j6(this.Zo);
        }
        if ((this.j6 & 8) != 0) {
            buffer.j6(this.VH);
        }
        if ((this.j6 & Integer.MIN_VALUE) != 0) {
            int length = this.gn.length / 2;
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    buffer.DW(Util.DW(this.gn[i * 2]));
                    buffer.DW(Util.DW(this.gn[(i * 2) + 1]));
                }
            }
        }
    }

    private boolean j6(int i) {
        return (this.j6 & 4) != 0 && (this.v5 & 61440) == i;
    }

    public boolean Hw() {
        return j6(16384);
    }

    public boolean v5() {
        return j6(40960);
    }

    public int Zo() {
        return this.j6;
    }

    public long VH() {
        return this.DW;
    }

    public int gn() {
        return this.FH;
    }

    public int u7() {
        return this.Hw;
    }

    public int tp() {
        return this.VH;
    }

    public String toString() {
        return j6() + " " + gn() + " " + u7() + " " + VH() + " " + DW();
    }
}
