package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
    OutputStream DW;
    OutputStream FH;
    private boolean Hw;
    private boolean Zo;
    InputStream j6;
    private boolean v5;

    public IO() {
        this.Hw = false;
        this.v5 = false;
        this.Zo = false;
    }

    void j6(OutputStream outputStream) {
        this.DW = outputStream;
    }

    void j6(OutputStream outputStream, boolean z) {
        this.v5 = z;
        j6(outputStream);
    }

    void DW(OutputStream outputStream) {
        this.FH = outputStream;
    }

    void DW(OutputStream outputStream, boolean z) {
        this.Zo = z;
        DW(outputStream);
    }

    void j6(InputStream inputStream) {
        this.j6 = inputStream;
    }

    void j6(InputStream inputStream, boolean z) {
        this.Hw = z;
        j6(inputStream);
    }

    public void j6(Packet packet) {
        this.DW.write(packet.j6.DW, 0, packet.j6.FH);
        this.DW.flush();
    }

    void j6(byte[] bArr, int i, int i2) {
        this.DW.write(bArr, i, i2);
        this.DW.flush();
    }

    void DW(byte[] bArr, int i, int i2) {
        this.FH.write(bArr, i, i2);
        this.FH.flush();
    }

    int j6() {
        return this.j6.read();
    }

    void FH(byte[] bArr, int i, int i2) {
        do {
            int read = this.j6.read(bArr, i, i2);
            if (read < 0) {
                throw new IOException("End of IO Stream Read");
            }
            i += read;
            i2 -= read;
        } while (i2 > 0);
    }

    void DW() {
        try {
            if (!(this.DW == null || this.v5)) {
                this.DW.close();
            }
            this.DW = null;
        } catch (Exception e) {
        }
    }

    public void FH() {
        try {
            if (!(this.j6 == null || this.Hw)) {
                this.j6.close();
            }
            this.j6 = null;
        } catch (Exception e) {
        }
        DW();
        try {
            if (!(this.FH == null || this.Zo)) {
                this.FH.close();
            }
            this.FH = null;
        } catch (Exception e2) {
        }
    }
}
