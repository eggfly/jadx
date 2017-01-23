package com.jcraft.jsch;

public class JSchException extends Exception {
    private Throwable j6;

    public JSchException() {
        this.j6 = null;
    }

    public JSchException(String str) {
        super(str);
        this.j6 = null;
    }

    public JSchException(String str, Throwable th) {
        super(str);
        this.j6 = null;
        this.j6 = th;
    }

    public Throwable getCause() {
        return this.j6;
    }
}
