package com.igexin.push.extension;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.p158b.p159a.p160a.C3658a;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.config.C3742a;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.C3826f;
import com.igexin.push.core.p180c.C3844h;
import com.igexin.push.extension.stub.IPushExtension;
import com.igexin.push.util.C3926e;
import dalvik.system.DexClassLoader;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.igexin.push.extension.a */
public class C3910a {
    private static String f13163a;
    private static C3910a f13164c;
    private List f13165b;

    static {
        f13163a = C3910a.class.getName();
    }

    private C3910a() {
        this.f13165b = new ArrayList();
    }

    public static C3910a m16066a() {
        if (f13164c == null) {
            f13164c = new C3910a();
        }
        return f13164c;
    }

    private boolean m16067a(String str, String str2, boolean z) {
        File file;
        C3688a.m15097b(f13163a + "|rename file...");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String substring = C3700a.m15132a(str2).substring(12, 20);
        try {
            C3688a.m15097b(f13163a + "|rename file reverseName:" + substring + " isForward:" + z);
            File file2;
            if (z) {
                file = new File(str + "/" + str2 + ".dex");
                if (file.exists()) {
                    file2 = new File(str + "/" + substring);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    C3688a.m15097b(f13163a + "|rename file from " + file.getAbsolutePath() + " --> " + file2.getAbsolutePath());
                    file.renameTo(file2);
                    return true;
                }
            }
            file = new File(str + "/" + substring);
            if (file.exists()) {
                file2 = new File(str + "/" + str2 + ".dex");
                C3688a.m15097b(f13163a + "|rename file from " + file.getAbsolutePath() + " --> " + file2.getAbsolutePath());
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
                return true;
            }
        } catch (Throwable th) {
            C3688a.m15097b(f13163a + "|renameGenerateFile error:" + th.toString());
            File file3 = new File(str + "/" + str2 + ".dex");
            file = new File(str + "/" + substring);
            if (file3.exists()) {
                file3.delete();
            }
            if (file.exists()) {
                file.delete();
            }
        }
        return false;
    }

    public void m16068a(File file, File file2, String str) {
        FileInputStream fileInputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        Throwable th2;
        BufferedOutputStream bufferedOutputStream2 = null;
        FileOutputStream fileOutputStream2;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    try {
                        Object obj = new byte[IXAdIOUtils.BUFFER_SIZE];
                        while (true) {
                            int read = fileInputStream.read(obj);
                            if (read == -1) {
                                break;
                            }
                            Object obj2 = new byte[read];
                            System.arraycopy(obj, 0, obj2, 0, read);
                            bufferedOutputStream.write(C3658a.m14937c(obj2, str));
                        }
                        bufferedOutputStream.flush();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        fileOutputStream = fileOutputStream2;
                        fileInputStream2 = fileInputStream;
                        try {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e222) {
                                    e222.printStackTrace();
                                }
                            }
                            if (fileOutputStream == null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2222) {
                                    e2222.printStackTrace();
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = fileInputStream2;
                            fileOutputStream2 = fileOutputStream;
                            bufferedOutputStream2 = bufferedOutputStream;
                            th2 = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e62) {
                                    e62.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream2 = bufferedOutputStream;
                        th2 = th;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (bufferedOutputStream2 != null) {
                            bufferedOutputStream2.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th2;
                    }
                } catch (Exception e7) {
                    bufferedOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    fileInputStream2 = fileInputStream;
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (fileOutputStream == null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (bufferedOutputStream2 != null) {
                        bufferedOutputStream2.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th2;
                }
            } catch (Exception e8) {
                bufferedOutputStream = null;
                fileInputStream2 = fileInputStream;
                if (file2.exists()) {
                    file2.delete();
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th6) {
                th2 = th6;
                fileOutputStream2 = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th2;
            }
        } catch (Exception e9) {
            bufferedOutputStream = null;
            fileInputStream2 = null;
            if (file2.exists()) {
                file2.delete();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th7) {
            th2 = th7;
            fileOutputStream2 = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th2;
        }
    }

    public boolean m16069a(Context context) {
        try {
            if (C3754m.f12675s != null) {
                Map b = C3754m.f12675s.m15734b();
                List<Integer> arrayList = new ArrayList();
                for (Entry entry : b.entrySet()) {
                    int intValue = ((Integer) entry.getKey()).intValue();
                    C3826f c3826f = (C3826f) entry.getValue();
                    String str = C3855g.ac + "/" + c3826f.m15719c();
                    File file = new File(str);
                    if (file.exists()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (c3826f.m15728h() == 0 || c3826f.m15729i() + c3826f.m15728h() >= currentTimeMillis) {
                            if (m16070a(context, str, c3826f.m15721d(), c3826f.m15730j(), c3826f.m15719c()) && c3826f.m15729i() != 0) {
                                c3826f.m15717b(currentTimeMillis);
                            }
                            if (c3826f.m15727g()) {
                                C3926e.m16166b(c3826f.m15719c());
                                arrayList.add(Integer.valueOf(intValue));
                            }
                        } else {
                            C3926e.m16166b(c3826f.m15719c());
                            arrayList.add(Integer.valueOf(intValue));
                        }
                    } else {
                        File file2 = new File(C3855g.ab + "/" + c3826f.m15719c());
                        if (file2.exists() && c3826f.m15725f().equals(C3700a.m15131a(C3855g.f12969g, file2.getAbsolutePath()))) {
                            C3688a.m15097b(f13163a + "|public local file match the condition...");
                            if (file.createNewFile()) {
                                if (C3926e.m16161a(file2, file, c3826f.m15725f())) {
                                    C3688a.m15097b(f13163a + "|restart the service to load ext:" + file.getAbsolutePath());
                                    Process.killProcess(Process.myPid());
                                } else {
                                    C3688a.m15097b(f13163a + "|copy " + file2.getAbsolutePath() + " to " + file.getAbsolutePath() + " " + "failed...");
                                    C3926e.m16166b(c3826f.m15719c());
                                }
                            }
                        }
                        if (((ConnectivityManager) C3855g.f12969g.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
                            new Thread(new C3844h(C3855g.f12969g, c3826f, true)).start();
                        } else {
                            C3688a.m15097b(f13163a + "|init ext not exist, is wifi state = false");
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    for (Integer intValue2 : arrayList) {
                        b.remove(Integer.valueOf(intValue2.intValue()));
                    }
                    C3688a.m15097b(f13163a + "|save extension info data to db");
                    C3742a.m15382a().m15399g();
                }
                return true;
            }
            List<String> arrayList2 = new ArrayList();
            arrayList2.add("com.igexin.push.extension.distribution.basic.stub.PushExtension");
            arrayList2.add("com.igexin.push.extension.distribution.gbd.stub.PushExtension");
            arrayList2.add("com.igexin.push.extension.distribution.lbs.stub.PushExtension");
            arrayList2.add("com.igexin.push.extension.distribution.diagnosis.stub.PushExtension");
            for (String str2 : arrayList2) {
                try {
                    IPushExtension iPushExtension = (IPushExtension) context.getClassLoader().loadClass(str2).newInstance();
                    iPushExtension.init(C3855g.f12969g);
                    this.f13165b.add(iPushExtension);
                    C3688a.m15097b("[main] extension loaded(mock): " + str2);
                } catch (Exception e) {
                    C3688a.m15097b(f13163a + e.toString());
                }
            }
            return true;
        } catch (Exception e2) {
            C3688a.m15097b(f13163a + e2.toString());
        }
    }

    public boolean m16070a(Context context, String str, String str2, String str3, String str4) {
        Class cls = null;
        File file = new File(str);
        File file2 = new File(str + ".jar");
        m16067a(context.getFilesDir().getAbsolutePath(), str4, false);
        m16068a(file, file2, str3);
        if (file2.exists()) {
            try {
                cls = new DexClassLoader(file2.getAbsolutePath(), context.getFilesDir().getAbsolutePath(), null, context.getClassLoader()).loadClass(str2);
            } catch (Exception e) {
                C3688a.m15097b(f13163a + "|" + e.getMessage());
            } catch (Throwable th) {
                C3688a.m15097b(f13163a + "|" + th.getMessage());
                if (file2.exists()) {
                    file2.delete();
                }
            }
            file2.delete();
            m16067a(context.getFilesDir().getAbsolutePath(), str4, true);
            if (cls == null) {
                return false;
            }
            IPushExtension iPushExtension = (IPushExtension) cls.newInstance();
            if (iPushExtension != null) {
                try {
                    iPushExtension.init(C3855g.f12969g);
                    this.f13165b.add(iPushExtension);
                    C3688a.m15097b(f13163a + "| [main] extension loaded: " + str);
                    return true;
                } catch (Exception e2) {
                    C3688a.m15097b(f13163a + "|" + e2.getMessage());
                }
            }
        }
        return false;
    }

    public void m16071b() {
        for (IPushExtension onDestroy : this.f13165b) {
            onDestroy.onDestroy();
        }
    }

    public List m16072c() {
        return this.f13165b;
    }
}
