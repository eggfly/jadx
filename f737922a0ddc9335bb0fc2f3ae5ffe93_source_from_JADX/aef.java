import java.io.IOException;
import javax.net.ssl.SSLException;

public class aef extends aeb {
    public aef(SSLException sSLException) {
        super((IOException) sSLException);
    }
}
