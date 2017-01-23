package com.antutu.utils.process;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Shell {
    public static void execCmd(String str) {
        Process exec = Runtime.getRuntime().exec(str + "\n");
        exec.waitFor();
        exec.destroy();
    }

    public static void execCmdWithDefaultEnv(String str) {
        execCmd(String.format("export LD_LIBRARY_PATH=%s\n%s", new Object[]{getLdLibrary(), str}));
    }

    public static String execInNewProcess(String[] strArr) {
        Process start;
        Process process;
        Throwable th;
        InputStream inputStream = null;
        String str = BuildConfig.FLAVOR;
        ProcessBuilder processBuilder = new ProcessBuilder(strArr);
        InputStream errorStream;
        InputStream inputStream2;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            start = processBuilder.start();
            try {
                errorStream = start.getErrorStream();
                while (true) {
                    try {
                        int read = errorStream.read();
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(read);
                    } catch (IOException e) {
                        inputStream2 = errorStream;
                        process = start;
                    } catch (Exception e2) {
                    } catch (Throwable th2) {
                        inputStream2 = null;
                        th = th2;
                    }
                }
                byteArrayOutputStream.write(10);
                inputStream2 = start.getInputStream();
                while (true) {
                    try {
                        int read2 = inputStream2.read();
                        if (read2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(read2);
                    } catch (IOException e3) {
                        inputStream = inputStream2;
                        inputStream2 = errorStream;
                        process = start;
                    } catch (Exception e4) {
                        inputStream = inputStream2;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                String str2 = new String(byteArrayOutputStream.toByteArray());
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException e5) {
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e6) {
                    }
                }
                if (start == null) {
                    return str2;
                }
                start.destroy();
                return str2;
            } catch (IOException e7) {
                inputStream2 = null;
                process = start;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e8) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e9) {
                    }
                }
                if (process != null) {
                    process.destroy();
                    return str;
                }
                return str;
            } catch (Exception e10) {
                errorStream = null;
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException e11) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e12) {
                    }
                }
                if (start != null) {
                    start.destroy();
                    return str;
                }
                return str;
            } catch (Throwable th22) {
                inputStream2 = null;
                errorStream = null;
                th = th22;
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException e13) {
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e14) {
                    }
                }
                if (start != null) {
                    start.destroy();
                }
                throw th;
            }
        } catch (IOException e15) {
            inputStream2 = null;
            process = null;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (process != null) {
                process.destroy();
                return str;
            }
            return str;
        } catch (Exception e16) {
            errorStream = null;
            start = null;
            if (errorStream != null) {
                errorStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (start != null) {
                start.destroy();
                return str;
            }
            return str;
        } catch (Throwable th222) {
            inputStream2 = null;
            errorStream = null;
            start = null;
            th = th222;
            if (errorStream != null) {
                errorStream.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (start != null) {
                start.destroy();
            }
            throw th;
        }
    }

    public static String getLdLibrary() {
        String str = System.getenv("LD_LIBRARY_PATH");
        if (str == null) {
            return "/vendor/lib:/system/lib";
        }
        if (!str.contains("/vendor/lib")) {
            str = str + ":/vendor/lib";
        }
        return !str.contains("/system/lib") ? str + ":/system/lib" : str;
    }

    public static Process newShellProcess() {
        return new ProcessBuilder(new String[]{IXAdRequestInfo.SCREEN_HEIGHT}).redirectErrorStream(false).start();
    }

    public static Process newShellProcessWithDeaultEnv() {
        ProcessBuilder redirectErrorStream = new ProcessBuilder(new String[]{IXAdRequestInfo.SCREEN_HEIGHT}).redirectErrorStream(false);
        redirectErrorStream.environment().put("LD_LIBRARY_PATH", getLdLibrary());
        return redirectErrorStream.start();
    }
}
