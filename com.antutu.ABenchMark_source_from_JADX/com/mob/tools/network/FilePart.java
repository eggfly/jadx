package com.mob.tools.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FilePart extends HTTPPart {
    private File file;

    protected InputStream getInputStream() {
        return new FileInputStream(this.file);
    }

    protected long length() {
        return this.file.length();
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFile(String str) {
        this.file = new File(str);
    }

    public String toString() {
        return this.file.toString();
    }
}
