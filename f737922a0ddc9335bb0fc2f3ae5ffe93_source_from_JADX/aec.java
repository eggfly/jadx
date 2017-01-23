import java.io.BufferedReader;
import java.io.IOException;

public class aec extends aea {
    public aec(BufferedReader bufferedReader) {
        super("failed to parse: " + j6(bufferedReader));
    }

    public static String j6(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.reset();
            } catch (IOException e) {
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            } catch (IOException e2) {
            }
        }
        return stringBuffer.toString();
    }

    public aec(String str) {
        super(str);
    }
}
