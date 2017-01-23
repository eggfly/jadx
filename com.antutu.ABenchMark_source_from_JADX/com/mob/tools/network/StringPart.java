package com.mob.tools.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StringPart extends HTTPPart {
    private StringBuilder sb;

    public StringPart() {
        this.sb = new StringBuilder();
    }

    public StringPart append(String str) {
        this.sb.append(str);
        return this;
    }

    protected InputStream getInputStream() {
        return new ByteArrayInputStream(this.sb.toString().getBytes("utf-8"));
    }

    protected long length() {
        return (long) this.sb.toString().getBytes("utf-8").length;
    }

    public String toString() {
        return this.sb.toString();
    }
}
