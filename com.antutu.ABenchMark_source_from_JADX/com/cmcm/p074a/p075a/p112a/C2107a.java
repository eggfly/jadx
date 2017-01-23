package com.cmcm.p074a.p075a.p112a;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.cmcm.a.a.a.a */
public class C2107a {
    private final File f7404a;
    private final File f7405b;

    public C2107a(File file) {
        this.f7404a = file;
        this.f7405b = new File(file.getPath() + ".bak");
    }

    static boolean m7914c(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public void m7915a() {
        this.f7404a.delete();
        this.f7405b.delete();
    }

    public void m7916a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            C2107a.m7914c(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f7405b.delete();
            } catch (Throwable e) {
                Log.w("AtomicFile", "finishWrite: Got exception:", e);
            }
        }
    }

    public FileOutputStream m7917b() {
        if (this.f7404a.exists()) {
            if (this.f7405b.exists()) {
                this.f7404a.delete();
            } else if (!this.f7404a.renameTo(this.f7405b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.f7404a + " to backup file " + this.f7405b);
            }
        }
        try {
            return new FileOutputStream(this.f7404a);
        } catch (FileNotFoundException e) {
            if (this.f7404a.getParentFile().mkdir()) {
                try {
                    return new FileOutputStream(this.f7404a);
                } catch (FileNotFoundException e2) {
                    throw new IOException("Couldn't create " + this.f7404a);
                }
            }
            throw new IOException("Couldn't create directory " + this.f7404a);
        }
    }

    public void m7918b(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            C2107a.m7914c(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f7404a.delete();
                this.f7405b.renameTo(this.f7404a);
            } catch (Throwable e) {
                Log.w("AtomicFile", "failWrite: Got exception:", e);
            }
        }
    }

    public FileInputStream m7919c() {
        if (this.f7405b.exists()) {
            this.f7404a.delete();
            this.f7405b.renameTo(this.f7404a);
        }
        return new FileInputStream(this.f7404a);
    }
}
