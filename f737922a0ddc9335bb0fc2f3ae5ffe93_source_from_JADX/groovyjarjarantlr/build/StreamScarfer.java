package groovyjarjarantlr.build;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class StreamScarfer extends Thread {
    String DW;
    Tool FH;
    InputStream j6;

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.j6));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                if (this.DW == null || this.DW.equals("stdout")) {
                    this.FH.j6(readLine);
                } else {
                    this.FH.DW(readLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
