package com.jcraft.jsch;

public class SftpException extends Exception {
    private Throwable DW;
    public int j6;

    public SftpException(int i, String str) {
        super(str);
        this.DW = null;
        this.j6 = i;
    }

    public SftpException(int i, String str, Throwable th) {
        super(str);
        this.DW = null;
        this.j6 = i;
        this.DW = th;
    }

    public String toString() {
        return this.j6 + ": " + getMessage();
    }

    public Throwable getCause() {
        return this.DW;
    }
}
