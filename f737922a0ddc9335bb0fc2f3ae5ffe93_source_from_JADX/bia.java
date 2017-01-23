import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class bia extends SimpleDateFormat {
    public bia() {
        super("yyy-MM-dd'T'HH:mm:ss'Z'");
        setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
