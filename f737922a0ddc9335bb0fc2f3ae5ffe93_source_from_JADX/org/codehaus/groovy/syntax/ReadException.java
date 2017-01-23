package org.codehaus.groovy.syntax;

import java.io.IOException;
import org.codehaus.groovy.GroovyException;

public class ReadException extends GroovyException {
    private final IOException j6;

    public String toString() {
        String message = super.getMessage();
        if (message == null || message.trim().equals("")) {
            return this.j6.getMessage();
        }
        return message;
    }

    public String getMessage() {
        return toString();
    }
}
