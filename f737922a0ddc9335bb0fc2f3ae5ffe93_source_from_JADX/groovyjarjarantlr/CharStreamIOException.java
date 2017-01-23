package groovyjarjarantlr;

import java.io.IOException;

public class CharStreamIOException extends CharStreamException {
    public IOException j6;

    public CharStreamIOException(IOException iOException) {
        super(iOException.getMessage());
        this.j6 = iOException;
    }
}
