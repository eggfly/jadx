package com.mob.tools.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiPart extends HTTPPart {
    private ArrayList<HTTPPart> parts;

    public MultiPart() {
        this.parts = new ArrayList();
    }

    public MultiPart append(HTTPPart hTTPPart) {
        this.parts.add(hTTPPart);
        return this;
    }

    protected InputStream getInputStream() {
        InputStream multiPartInputStream = new MultiPartInputStream();
        Iterator it = this.parts.iterator();
        while (it.hasNext()) {
            multiPartInputStream.addInputStream(((HTTPPart) it.next()).getInputStream());
        }
        return multiPartInputStream;
    }

    protected long length() {
        Iterator it = this.parts.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ((HTTPPart) it.next()).length() + j;
        }
        return j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.parts.iterator();
        while (it.hasNext()) {
            stringBuilder.append(((HTTPPart) it.next()).toString());
        }
        return stringBuilder.toString();
    }
}
