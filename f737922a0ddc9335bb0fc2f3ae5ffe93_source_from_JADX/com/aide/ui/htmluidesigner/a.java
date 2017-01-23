package com.aide.ui.htmluidesigner;

import android.webkit.MimeTypeMap;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    private static a j6;
    private String DW;

    class 1 implements Runnable {
        final /* synthetic */ a j6;

        1(a aVar) {
            this.j6 = aVar;
        }

        public void run() {
            this.j6.j6();
        }
    }

    public static void j6(String str) {
        if (j6 == null) {
            j6 = new a();
        }
        j6.DW(str);
    }

    private void DW(String str) {
        this.DW = str;
    }

    private a() {
        new Thread(new 1(this)).start();
    }

    private void j6() {
        try {
            ServerSocket serverSocket = new ServerSocket(8099);
            while (true) {
                try {
                    Socket accept = serverSocket.accept();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                    j6(bufferedReader.readLine(), new DataOutputStream(accept.getOutputStream()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void j6(String str, DataOutputStream dataOutputStream) {
        if (str.toUpperCase().startsWith("GET") || str.toUpperCase().startsWith("HEAD")) {
            String Hw = Hw(str);
            try {
                FileInputStream FH = FH(Hw);
                try {
                    dataOutputStream.writeBytes(j6(200, Hw));
                    if (!str.toUpperCase().startsWith("GET")) {
                        return;
                    }
                    if (v5(Hw).equals("text/html")) {
                        Writer outputStreamWriter = new OutputStreamWriter(dataOutputStream);
                        j6(outputStreamWriter, new BufferedReader(new InputStreamReader(FH)), Hw, new HashSet());
                        FH.close();
                        outputStreamWriter.close();
                        return;
                    }
                    j6(dataOutputStream, FH);
                    FH.close();
                    dataOutputStream.close();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            } catch (Exception e2) {
                j6(dataOutputStream, 404);
                return;
            }
        }
        j6(dataOutputStream, 501);
    }

    private FileInputStream FH(String str) {
        return new FileInputStream(new File(this.DW + str));
    }

    private void j6(Writer writer, BufferedReader bufferedReader, String str, Set<String> set) {
        if (!set.contains(str)) {
            set.add(str);
            Pattern compile = Pattern.compile("^\\s*<!--\\s*#include\\s+file\\s*=\\s*(?:\"|')(.*)(?:\"|')\\s*-->\\s*$");
            while (true) {
                Object readLine = bufferedReader.readLine();
                if (readLine != null) {
                    Matcher matcher = compile.matcher(readLine);
                    if (matcher.matches()) {
                        try {
                            String group = matcher.group(1);
                            if (!group.startsWith("/")) {
                                group = "/" + group;
                            }
                            InputStream FH = FH(group);
                            j6(writer, new BufferedReader(new InputStreamReader(FH)), group, set);
                            FH.close();
                        } catch (FileNotFoundException e) {
                        }
                    } else {
                        writer.write(readLine);
                        writer.write("\n");
                    }
                } else {
                    writer.flush();
                    return;
                }
            }
        }
    }

    private void j6(DataOutputStream dataOutputStream, FileInputStream fileInputStream) {
        byte[] bArr = new byte[2000];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                dataOutputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private void j6(DataOutputStream dataOutputStream, int i) {
        try {
            dataOutputStream.writeBytes(j6(i, null));
            dataOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String Hw(String str) {
        String[] split = str.split(" ");
        String str2 = "";
        if (split.length >= 2) {
            str2 = split[1];
        }
        if (str2.equals("/")) {
            return "/index.html";
        }
        return str2;
    }

    private String j6(int i, String str) {
        String str2 = "HTTP/1.0 ";
        switch (i) {
            case 200:
                str2 = str2 + "200 OK";
                break;
            case 400:
                str2 = str2 + "400 Bad Request";
                break;
            case 403:
                str2 = str2 + "403 Forbidden";
                break;
            case 404:
                str2 = str2 + "404 Not Found";
                break;
            case 500:
                str2 = str2 + "500 Internal Server Error";
                break;
            case 501:
                str2 = str2 + "501 Not Implemented";
                break;
        }
        str2 = ((str2 + "\r\n") + "Connection: close\r\n") + "Server: AIDE\r\n";
        if (str != null) {
            str2 = str2 + "Content-Type: " + v5(str) + "\r\n";
        }
        return str2 + "\r\n";
    }

    private String v5(String str) {
        String toLowerCase = str.substring(str.lastIndexOf(46) + 1, str.length()).toLowerCase();
        if (toLowerCase.equals("zip")) {
            toLowerCase = "application/x-zip-compressed";
        } else if (toLowerCase.equals("png")) {
            toLowerCase = "image/png";
        } else if (toLowerCase.equals("gif")) {
            toLowerCase = "image/gif";
        } else if (toLowerCase.equals("jpg") || toLowerCase.equals("jpeg")) {
            toLowerCase = "image/jpeg";
        } else if (toLowerCase.equals("html") || toLowerCase.equals("html")) {
            toLowerCase = "text/html";
        } else if (toLowerCase.equals("css")) {
            toLowerCase = "text/css";
        } else if (toLowerCase.equals("js")) {
            toLowerCase = "application/javascript";
        } else {
            toLowerCase = MimeTypeMap.getSingleton().getMimeTypeFromExtension(toLowerCase);
        }
        if (toLowerCase == null) {
            return "*/*";
        }
        return toLowerCase;
    }
}
