package com.ijinshan.cloudconfig.p189d;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import org.android.spdy.SpdyProtocol;
import org.json.JSONObject;

/* renamed from: com.ijinshan.cloudconfig.d.a */
public class C3953a {
    public static JSONObject m16253a(File file) {
        FileReader fileReader;
        Throwable th;
        JSONObject jSONObject = null;
        if (file != null) {
            BufferedReader bufferedReader;
            try {
                StringBuffer stringBuffer = new StringBuffer();
                fileReader = new FileReader(file);
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (Exception e) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (stringBuffer != null && stringBuffer.length() > 0) {
                        jSONObject = new JSONObject(stringBuffer.toString());
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Exception e4) {
                    bufferedReader = null;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                    return jSONObject;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    bufferedReader = null;
                    th = th4;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e7) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                bufferedReader = null;
                fileReader = null;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return jSONObject;
            } catch (Throwable th32) {
                fileReader = null;
                th = th32;
                bufferedReader = null;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        return jSONObject;
    }

    public static JSONObject m16254a(String str) {
        return TextUtils.isEmpty(str) ? null : C3953a.m16253a(new File(str));
    }

    public static boolean m16255a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e3) {
            }
            fileOutputStream.close();
        }
    }

    public static boolean m16256a(JSONObject jSONObject, File file) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.toString().getBytes());
        try {
            boolean a = C3953a.m16255a(byteArrayInputStream, file);
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e) {
                }
            }
            return a;
        } catch (Throwable th) {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e2) {
                }
            }
        }
    }

    public static boolean m16257a(JSONObject jSONObject, String str) {
        return C3953a.m16256a(jSONObject, new File(str));
    }
}
