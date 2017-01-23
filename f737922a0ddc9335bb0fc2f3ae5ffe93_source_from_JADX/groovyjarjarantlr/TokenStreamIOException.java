package groovyjarjarantlr;

import java.io.IOException;

public class TokenStreamIOException extends TokenStreamException {
    public IOException j6;

    public TokenStreamIOException(IOException iOException) {
        super(iOException.getMessage());
        this.j6 = iOException;
    }
}
