package groovyjarjarantlr.collections.impl;

import java.util.Enumeration;
import java.util.NoSuchElementException;

final class LLEnumeration implements Enumeration {
    LLCell j6;

    public boolean hasMoreElements() {
        if (this.j6 != null) {
            return true;
        }
        return false;
    }

    public Object nextElement() {
        if (hasMoreElements()) {
            LLCell lLCell = this.j6;
            this.j6 = this.j6.DW;
            return lLCell.j6;
        }
        throw new NoSuchElementException();
    }
}
