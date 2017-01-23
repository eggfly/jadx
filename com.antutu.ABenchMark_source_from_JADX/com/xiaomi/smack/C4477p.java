package com.xiaomi.smack;

import com.xiaomi.smack.packet.C4486g;
import com.xiaomi.smack.packet.C4488h;
import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.xiaomi.smack.p */
public class C4477p extends Exception {
    private C4486g f15370a;
    private C4488h f15371b;
    private Throwable f15372c;

    public C4477p() {
        this.f15370a = null;
        this.f15371b = null;
        this.f15372c = null;
    }

    public C4477p(C4486g c4486g) {
        this.f15370a = null;
        this.f15371b = null;
        this.f15372c = null;
        this.f15370a = c4486g;
    }

    public C4477p(String str) {
        super(str);
        this.f15370a = null;
        this.f15371b = null;
        this.f15372c = null;
    }

    public C4477p(String str, Throwable th) {
        super(str);
        this.f15370a = null;
        this.f15371b = null;
        this.f15372c = null;
        this.f15372c = th;
    }

    public C4477p(Throwable th) {
        this.f15370a = null;
        this.f15371b = null;
        this.f15372c = null;
        this.f15372c = th;
    }

    public Throwable m18566a() {
        return this.f15372c;
    }

    public String getMessage() {
        String message = super.getMessage();
        return (message != null || this.f15371b == null) ? (message != null || this.f15370a == null) ? message : this.f15370a.toString() : this.f15371b.toString();
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f15372c != null) {
            printStream.println("Nested Exception: ");
            this.f15372c.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f15372c != null) {
            printWriter.println("Nested Exception: ");
            this.f15372c.printStackTrace(printWriter);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            stringBuilder.append(message).append(": ");
        }
        if (this.f15371b != null) {
            stringBuilder.append(this.f15371b);
        }
        if (this.f15370a != null) {
            stringBuilder.append(this.f15370a);
        }
        if (this.f15372c != null) {
            stringBuilder.append("\n  -- caused by: ").append(this.f15372c);
        }
        return stringBuilder.toString();
    }
}
