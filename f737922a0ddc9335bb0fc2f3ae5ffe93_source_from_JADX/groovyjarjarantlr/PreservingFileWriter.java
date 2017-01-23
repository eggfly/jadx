package groovyjarjarantlr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class PreservingFileWriter extends FileWriter {
    protected File DW;
    protected File j6;

    public void close() {
        Throwable th;
        Reader reader;
        Object obj = null;
        Writer writer = null;
        Writer writer2;
        try {
            super.close();
            char[] cArr = new char[1024];
            if (this.j6.length() == this.DW.length()) {
                char[] cArr2 = new char[1024];
                Reader bufferedReader = new BufferedReader(new FileReader(this.DW));
                try {
                    Reader bufferedReader2 = new BufferedReader(new FileReader(this.j6));
                    Object obj2 = 1;
                    while (obj2 != null) {
                        int read = bufferedReader.read(cArr, 0, 1024);
                        if (read != bufferedReader2.read(cArr2, 0, 1024)) {
                            break;
                        } else if (read == -1) {
                            obj = obj2;
                            break;
                        } else {
                            for (int i = 0; i < read; i++) {
                                if (cArr[i] != cArr2[i]) {
                                    obj2 = null;
                                    break;
                                }
                            }
                        }
                    }
                    obj = obj2;
                    bufferedReader.close();
                    bufferedReader2.close();
                    bufferedReader = null;
                    if (obj != null) {
                        if (null != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                            }
                        }
                        if (null != null) {
                            try {
                                writer.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (this.DW != null && this.DW.exists()) {
                            this.DW.delete();
                            this.DW = null;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    reader = bufferedReader;
                    writer2 = null;
                }
            }
            reader = new BufferedReader(new FileReader(this.DW));
            try {
                writer2 = new BufferedWriter(new FileWriter(this.j6));
                while (true) {
                    int read2 = reader.read(cArr, 0, 1024);
                    if (read2 == -1) {
                        break;
                    }
                    try {
                        writer2.write(cArr, 0, read2);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e3) {
                    }
                }
                if (writer2 != null) {
                    try {
                        writer2.close();
                    } catch (IOException e4) {
                    }
                }
                if (this.DW != null && this.DW.exists()) {
                    this.DW.delete();
                    this.DW = null;
                }
            } catch (Throwable th4) {
                th = th4;
                writer2 = null;
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e5) {
                    }
                }
                if (writer2 != null) {
                    try {
                        writer2.close();
                    } catch (IOException e6) {
                    }
                }
                this.DW.delete();
                this.DW = null;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            writer2 = null;
            reader = null;
            if (reader != null) {
                reader.close();
            }
            if (writer2 != null) {
                writer2.close();
            }
            if (this.DW != null && this.DW.exists()) {
                this.DW.delete();
                this.DW = null;
            }
            throw th;
        }
    }
}
