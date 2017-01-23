package com.taobao.accs.utl;

import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.taobao.accs.utl.c */
public class C4137c {
    public static final String TAG = "FileUtils";

    public static boolean m16918a(byte[] bArr, File file) {
        Throwable th;
        if (bArr == null || file == null) {
            ALog.m16906w(TAG, "byteToFile null", Constants.KEY_DATA, bArr, "file", file);
            return false;
        }
        if (file != null) {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ALog.m16902e(TAG, "byteToFile write file error", th, new Object[0]);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return false;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    return false;
                                }
                            }
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (fileOutputStream == null) {
                    return true;
                }
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e22) {
                    e22.printStackTrace();
                    return true;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
        return false;
    }

    public static byte[] m16919a(File file) {
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        if (file == null || !file.exists()) {
            ALog.m16906w(TAG, "filetoByte not exist", new Object[0]);
        } else {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = C4137c.m16920a((InputStream) fileInputStream);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        ALog.m16902e(TAG, "FileInputStream error", th, new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return bArr;
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                fileInputStream = bArr;
                th2 = th5;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th2;
            }
        }
        return bArr;
    }

    public static byte[] m16920a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        if (inputStream != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[Message.FLAG_RET];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        ALog.m16902e(TAG, "streamToByte error", th, new Object[0]);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e2) {
                            }
                        }
                        return bArr;
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                byteArrayOutputStream = bArr;
                th2 = th5;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th2;
            }
        }
        return bArr;
    }
}
