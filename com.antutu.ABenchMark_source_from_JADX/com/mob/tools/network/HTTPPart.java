package com.mob.tools.network;

import com.mob.tools.utils.ReflectHelper;
import java.io.InputStream;

public abstract class HTTPPart {
    private OnReadListener listener;
    private long offset;

    protected abstract InputStream getInputStream();

    public Object getInputStreamEntity() {
        InputStream toInputStream = toInputStream();
        long length = length() - this.offset;
        ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
        return ReflectHelper.newInstance("InputStreamEntity", toInputStream, Long.valueOf(length));
    }

    protected abstract long length();

    public void setOffset(long j) {
        this.offset = j;
    }

    public void setOnReadListener(OnReadListener onReadListener) {
        this.listener = onReadListener;
    }

    public InputStream toInputStream() {
        InputStream byteCounterInputStream = new ByteCounterInputStream(getInputStream());
        byteCounterInputStream.setOnInputStreamReadListener(this.listener);
        if (this.offset > 0) {
            byteCounterInputStream.skip(this.offset);
        }
        return byteCounterInputStream;
    }
}
