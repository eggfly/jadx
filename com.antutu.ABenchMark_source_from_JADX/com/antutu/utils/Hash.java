package com.antutu.utils;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import anet.channel.security.ISecurity;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.security.MessageDigest;

public class Hash {
    public static boolean checkFileHash(String str, String str2) {
        try {
            String fileToSHA1 = fileToSHA1(str);
            String stringSafe = jni.getStringSafe(str2, "hash");
            if (fileToSHA1 != null && fileToSHA1.toLowerCase().equals(stringSafe.toLowerCase())) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean checkFileHashF(String str, String str2) {
        return checkFileHash(str, getFileFirstLine(str2));
    }

    private static String convertHashToString(byte[] bArr) {
        String str = BuildConfig.FLAVOR;
        for (byte b : bArr) {
            str = str + Integer.toString((b & MotionEventCompat.ACTION_MASK) + AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 16).substring(1);
        }
        return str.toLowerCase();
    }

    public static String fileToHash(String str) {
        return jni.getDataSafe(fileToSHA1(str), "hash");
    }

    public static int fileToHashF(String str, String str2) {
        return Utils.writeStringToFile(fileToHash(str), str2);
    }

    public static String fileToMD5(String str) {
        InputStream fileInputStream;
        Throwable th;
        String str2 = null;
        int i = 0;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
                while (i != -1) {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        instance.update(bArr, 0, i);
                    }
                }
                str2 = convertHashToString(instance.digest());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            Object obj = str2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = str2;
            th = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str2;
    }

    public static String fileToSHA1(String str) {
        Throwable th;
        String str2 = null;
        int i = 0;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                while (i != -1) {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        instance.update(bArr, 0, i);
                    }
                }
                str2 = convertHashToString(instance.digest());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            Object obj = str2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = str2;
            th = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str2;
    }

    private static String getFileFirstLine(String str) {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
            String trim = lineNumberReader.readLine().trim();
            lineNumberReader.close();
            return trim;
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }
}
