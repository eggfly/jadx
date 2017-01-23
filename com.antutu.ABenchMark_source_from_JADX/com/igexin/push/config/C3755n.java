package com.igexin.push.config;

import android.content.Context;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;
import com.igexin.push.util.C3926e;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: com.igexin.push.config.n */
public class C3755n {
    private static String f12683a;

    static {
        f12683a = "FileConfig";
    }

    public static void m15412a() {
        InputStream open;
        InputStream fileInputStream;
        BufferedReader bufferedReader;
        String readLine;
        String[] split;
        String trim;
        Throwable th;
        InputStream inputStream;
        BufferedReader bufferedReader2 = null;
        try {
            open = C3855g.f12969g.getResources().getAssets().open(C3855g.f12967e + ".properties");
            try {
                C3755n.m15414a(open);
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e3) {
                    }
                }
                if (!new File(C3855g.f12959W).exists()) {
                    try {
                        fileInputStream = new FileInputStream(C3855g.f12959W);
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, HttpRequest.f14548a));
                            while (true) {
                                try {
                                    readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        break;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e4) {
                                            }
                                        }
                                        if (fileInputStream == null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e5) {
                                                return;
                                            }
                                        }
                                    } else if (readLine.startsWith("#")) {
                                        split = readLine.split("=");
                                        if (split.length < 2) {
                                            trim = split[0].trim();
                                            readLine = split[1].trim();
                                            if (!trim.equals("sdk.debug")) {
                                                C3688a.f12438a = Boolean.valueOf(readLine).booleanValue();
                                            }
                                        }
                                    }
                                } catch (Exception e6) {
                                    bufferedReader2 = bufferedReader;
                                    open = fileInputStream;
                                } catch (Throwable th2) {
                                    r5 = th2;
                                    bufferedReader2 = bufferedReader;
                                    th = r5;
                                }
                            }
                        } catch (Exception e7) {
                            open = fileInputStream;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e8) {
                                }
                            }
                            if (open != null) {
                                try {
                                    open.close();
                                    return;
                                } catch (Exception e9) {
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e10) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e11) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e12) {
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (open != null) {
                            open.close();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        r5 = th4;
                        fileInputStream = open;
                        th = r5;
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th22) {
                Throwable th5;
                th5 = th22;
                inputStream = open;
                th = th5;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e13) {
                    }
                }
                throw th;
            }
        } catch (Exception e14) {
            open = null;
            if (open != null) {
                open.close();
            }
            if (!new File(C3855g.f12959W).exists()) {
                fileInputStream = new FileInputStream(C3855g.f12959W);
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, HttpRequest.f14548a));
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        break;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (fileInputStream == null) {
                            fileInputStream.close();
                        }
                    } else if (readLine.startsWith("#")) {
                        split = readLine.split("=");
                        if (split.length < 2) {
                            trim = split[0].trim();
                            readLine = split[1].trim();
                            if (!trim.equals("sdk.debug")) {
                                C3688a.f12438a = Boolean.valueOf(readLine).booleanValue();
                            }
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        if (!new File(C3855g.f12959W).exists()) {
            fileInputStream = new FileInputStream(C3855g.f12959W);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, HttpRequest.f14548a));
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    break;
                } else if (readLine.startsWith("#")) {
                    split = readLine.split("=");
                    if (split.length < 2) {
                        trim = split[0].trim();
                        readLine = split[1].trim();
                        if (!trim.equals("sdk.debug")) {
                            C3688a.f12438a = Boolean.valueOf(readLine).booleanValue();
                        }
                    }
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileInputStream == null) {
                fileInputStream.close();
            }
        }
    }

    public static void m15413a(Context context) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader2;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        C3755n.m15415b(context);
        try {
            inputStreamReader = new InputStreamReader(context.getResources().getAssets().open("green.cfg"));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("=");
                        if (split.length == 2) {
                            C3855g.m15893c().put(split[0].trim(), split[1].trim());
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        bufferedReader2 = bufferedReader;
                        th = th3;
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception e) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Exception e3) {
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    public static void m15414a(InputStream inputStream) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, HttpRequest.f14548a));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.startsWith("#")) {
                        String[] split = readLine.split("=");
                        if (split.length >= 2) {
                            String trim = split[0].trim();
                            readLine = split[1].trim();
                            if (trim.equals("sdk.cm_address")) {
                                SDKUrlConfig.setXfrAddressIps(readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
                            } else if (trim.equals("sdk.config_address")) {
                                SDKUrlConfig.CONFIG_ADDRESS_IPS = readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            } else if (trim.equals("sdk.bi_address")) {
                                SDKUrlConfig.BI_ADDRESS_IPS = readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            } else if (trim.equals("sdk.state_address")) {
                                SDKUrlConfig.STATE_ADDRESS_IPS = readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            } else if (trim.equals("sdk.log_address")) {
                                SDKUrlConfig.LOG_ADDRESS_IPS = readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            } else if (trim.equals("sdk.amp_address")) {
                                SDKUrlConfig.AMP_ADDRESS_IPS = readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            } else if (trim.equals("sdk.lbs_address")) {
                                SDKUrlConfig.LBS_ADDRESS_IPS = readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            } else if (trim.equals("sdk.cm_address_backup")) {
                                SDKUrlConfig.XFR_ADDRESS_BAK = readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            } else if (trim.equals("sdk.inc_address")) {
                                SDKUrlConfig.INC_ADDRESS_IPS = readLine.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            } else if (trim.equals("sdk.debug")) {
                                C3688a.f12438a = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.domainbackup.enable")) {
                                C3754m.f12662f = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.readlocalcell.enable")) {
                                C3754m.f12663g = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.uploadapplist.enable")) {
                                C3754m.f12664h = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.feature.sendmessage.enable")) {
                                C3754m.f12665i = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.feature.settag.enable")) {
                                C3754m.f12666j = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.feature.setsilenttime.enable")) {
                                C3754m.f12667k = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.snl.enable")) {
                                C3754m.f12670n = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.snl.maxactiveflow")) {
                                C3754m.f12671o = Long.valueOf(readLine).longValue();
                            } else if (trim.equals("sdk.feature.setheartbeatinterval.enable")) {
                                C3754m.f12668l = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.feature.setsockettimeout.enable")) {
                                C3754m.f12669m = Boolean.valueOf(readLine).booleanValue();
                            } else if (trim.equals("sdk.stay.backup.time")) {
                                C3754m.f12682z = Long.valueOf(readLine).longValue() * 1000;
                            } else if (trim.equals("sdk.enter.backup.detect.failed.cnt")) {
                                C3754m.f12647A = Integer.valueOf(readLine).intValue();
                            } else if (trim.equals("sdk.login.failed.cnt")) {
                                C3754m.f12648B = Integer.valueOf(readLine).intValue();
                            } else if (trim.equals("sdk.detect.ip.expired.time")) {
                                C3754m.f12649C = Long.valueOf(readLine).longValue() * 1000;
                            } else if (trim.equals("sdk.detect.interval.time")) {
                                C3754m.f12650D = Long.valueOf(readLine).longValue() * 1000;
                            } else if (trim.equals("sdk.reset.reconnect.delay")) {
                                C3754m.f12681y = Long.valueOf(readLine).longValue() * 1000;
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (Exception e) {
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    bufferedReader2 = bufferedReader;
                    th = th3;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void m15415b(Context context) {
        try {
            byte[] a = C3926e.m16162a(context.getFilesDir().getPath() + "/" + "conf_n.pid");
            if (a != null) {
                C3754m.f12679w = Boolean.valueOf(new String(a)).booleanValue();
            }
        } catch (Throwable th) {
            C3688a.m15097b(f12683a + "|load need confgi error = " + th.getMessage());
        }
    }
}
