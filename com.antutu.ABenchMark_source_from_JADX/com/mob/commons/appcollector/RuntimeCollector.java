package com.mob.commons.appcollector;

import android.content.Context;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.facebook.ads.AdError;
import com.mob.commons.C3972a;
import com.mob.commons.C3986c;
import com.mob.commons.C3987d;
import com.mob.commons.C3991e;
import com.mob.tools.MobLog;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.ReflectHelper;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.umeng.message.proguard.C4233j;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RuntimeCollector {
    private static final String f13323a;
    private static RuntimeCollector f13324b;
    private Context f13325c;

    /* renamed from: com.mob.commons.appcollector.RuntimeCollector.1 */
    class C39781 extends Thread {
        final /* synthetic */ RuntimeCollector f13322a;

        /* renamed from: com.mob.commons.appcollector.RuntimeCollector.1.1 */
        class C39771 implements Runnable {
            final /* synthetic */ C39781 f13321a;

            C39771(C39781 c39781) {
                this.f13321a = c39781;
            }

            public void run() {
                if (!C3987d.m16426a(this.f13321a.f13322a.f13325c, "comm/tags/.rcTag")) {
                    this.f13321a.f13322a.m16389b();
                }
            }
        }

        C39781(RuntimeCollector runtimeCollector) {
            this.f13322a = runtimeCollector;
        }

        public void run() {
            C3991e.m16442a(new File(C4021R.getCacheRoot(this.f13322a.f13325c), "comm/locks/.rc_lock"), new C39771(this));
        }
    }

    static {
        f13323a = VERSION.SDK_INT >= 16 ? "^u\\d+_a\\d+" : "^app_\\d+";
    }

    private RuntimeCollector(Context context) {
        this.f13325c = context.getApplicationContext();
    }

    private ArrayList<HashMap<String, Object>> m16381a(HashMap<String, String>[][] hashMapArr, ArrayList<long[]> arrayList) {
        ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList(hashMapArr.length);
        for (HashMap<String, String>[] hashMapArr2 : hashMapArr) {
            HashMap hashMap = new HashMap();
            hashMap.put("runtimes", Long.valueOf(0));
            hashMap.put("fg", Integer.valueOf(0));
            hashMap.put("bg", Integer.valueOf(0));
            hashMap.put("empty", Integer.valueOf(0));
            arrayList2.add(hashMap);
            int length = hashMapArr2.length - 1;
            while (length >= 0) {
                if (hashMapArr2[length] != null) {
                    hashMap.put("runtimes", Long.valueOf((length == 0 ? 0 : ((long[]) arrayList.get(length))[1]) + ((Long) C4021R.forceCast(hashMap.get("runtimes"), Long.valueOf(0))).longValue()));
                    if ("fg".equals(hashMapArr2[length].get("pcy"))) {
                        hashMap.put("fg", Integer.valueOf(((Integer) C4021R.forceCast(hashMap.get("fg"), Integer.valueOf(0))).intValue() + 1));
                    } else if ("bg".equals(hashMapArr2[length].get("pcy"))) {
                        hashMap.put("bg", Integer.valueOf(((Integer) C4021R.forceCast(hashMap.get("bg"), Integer.valueOf(0))).intValue() + 1));
                    } else {
                        hashMap.put("empty", Integer.valueOf(((Integer) C4021R.forceCast(hashMap.get("empty"), Integer.valueOf(0))).intValue() + 1));
                    }
                    hashMap.put(Constants.KEY_ELECTION_PKG, hashMapArr2[length].get(Constants.KEY_ELECTION_PKG));
                    hashMap.put("name", hashMapArr2[length].get("name"));
                    hashMap.put(Constants.SP_KEY_VERSION, hashMapArr2[length].get(Constants.SP_KEY_VERSION));
                }
                length--;
            }
        }
        return arrayList2;
    }

    private HashMap<String, Integer> m16382a(ArrayList<ArrayList<HashMap<String, String>>> arrayList) {
        HashMap<String, Integer> hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            int i2 = i;
            while (it2.hasNext()) {
                HashMap hashMap2 = (HashMap) it2.next();
                String str = ((String) hashMap2.get(Constants.KEY_ELECTION_PKG)) + ":" + ((String) hashMap2.get(Constants.SP_KEY_VERSION));
                if (!hashMap.containsKey(str)) {
                    hashMap.put(str, Integer.valueOf(i2));
                    i2++;
                }
            }
            i = i2;
        }
        return hashMap;
    }

    private void m16383a() {
        Thread c39781 = new C39781(this);
        c39781.setPriority(1);
        c39781.start();
    }

    private void m16384a(String str, ArrayList<ArrayList<HashMap<String, String>>> arrayList, ArrayList<long[]> arrayList2) {
        try {
            HashMap e = m16394e();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "utf-8"));
            String readLine = bufferedReader.readLine();
            for (int i = 0; i < 7; i++) {
                readLine = bufferedReader.readLine();
            }
            ArrayList arrayList3 = new ArrayList();
            for (readLine = 
            /* Method generation error in method: com.mob.commons.appcollector.RuntimeCollector.a(java.lang.String, java.util.ArrayList, java.util.ArrayList):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_2 'readLine' java.lang.String) = (r1_1 'readLine' java.lang.String), (r1_3 'readLine' java.lang.String) binds: {(r1_1 'readLine' java.lang.String)=B:2:?, (r1_3 'readLine' java.lang.String)=B:4:0x001e} in method: com.mob.commons.appcollector.RuntimeCollector.a(java.lang.String, java.util.ArrayList, java.util.ArrayList):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:225)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:277)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:177)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:324)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:263)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:116)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: jadx.core.utils.exceptions.CodegenException: Unknown instruction: PHI in method: com.mob.commons.appcollector.RuntimeCollector.a(java.lang.String, java.util.ArrayList, java.util.ArrayList):void
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:512)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:219)
	... 20 more
 */

            private void m16385a(String str, HashMap<String, String[]> hashMap, ArrayList<HashMap<String, String>> arrayList) {
                String[] split = str.replaceAll(" +", " ").split(" ");
                if (split != null && split.length >= 10) {
                    Object obj = split[split.length - 1];
                    if (split[split.length - 2].matches(f13323a) && !"top".equals(obj)) {
                        String[] strArr = (String[]) hashMap.get(obj);
                        if (strArr != null) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(Constants.KEY_ELECTION_PKG, obj);
                            hashMap2.put("name", strArr[0]);
                            hashMap2.put(Constants.SP_KEY_VERSION, strArr[1]);
                            hashMap2.put("pcy", split[split.length - 3]);
                            arrayList.add(hashMap2);
                        }
                    }
                }
            }

            private void m16386a(ArrayList<HashMap<String, Object>> arrayList, ArrayList<long[]> arrayList2) {
                HashMap hashMap = new HashMap();
                hashMap.put(C4233j.f14402y, "APP_RUNTIMES");
                hashMap.put("list", arrayList);
                hashMap.put("datatime", Long.valueOf(C3972a.m16336a(this.f13325c)));
                hashMap.put("recordat", Long.valueOf(((long[]) arrayList2.get(0))[0]));
                long j = 0;
                for (int i = 1; i < arrayList2.size(); i++) {
                    j += ((long[]) arrayList2.get(i))[1];
                }
                hashMap.put("sdk_runtime_len", Long.valueOf(j));
                hashMap.put("top_count", Integer.valueOf(arrayList2.size()));
                C3986c.m16412a(this.f13325c).m16425a(C3972a.m16336a(this.f13325c), hashMap);
            }

            private boolean m16387a(String str) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                m16384a(str, arrayList, arrayList2);
                m16386a(m16381a(m16388a(m16382a(arrayList), arrayList), arrayList2), arrayList2);
                return m16391b(str);
            }

            private HashMap<String, String>[][] m16388a(HashMap<String, Integer> hashMap, ArrayList<ArrayList<HashMap<String, String>>> arrayList) {
                HashMap[][] hashMapArr = (HashMap[][]) Array.newInstance(HashMap.class, new int[]{hashMap.size(), arrayList.size()});
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ArrayList arrayList2 = (ArrayList) arrayList.get(i);
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        HashMap hashMap2 = (HashMap) arrayList2.get(i2);
                        hashMapArr[((Integer) hashMap.get(((String) hashMap2.get(Constants.KEY_ELECTION_PKG)) + ":" + ((String) hashMap2.get(Constants.SP_KEY_VERSION)))).intValue()][i] = hashMap2;
                    }
                }
                return hashMapArr;
            }

            private void m16389b() {
                Process exec;
                Process process;
                Throwable th;
                Object obj;
                OutputStream outputStream;
                long j;
                String str;
                Object obj2;
                long d;
                OutputStream outputStream2;
                Object obj3;
                OutputStream outputStream3 = null;
                File file = new File(C4021R.getCacheRoot(this.f13325c), "comm/dbs/.plst");
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                String absolutePath = file.getAbsolutePath();
                long c = m16392c();
                C3987d.m16427b(this.f13325c, "comm/tags/.rcTag");
                try {
                    exec = Runtime.getRuntime().exec(IXAdRequestInfo.SCREEN_HEIGHT);
                    try {
                        outputStream3 = exec.getOutputStream();
                        process = exec;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            MobLog.getInstance().m4388w(th);
                            process = exec;
                            C3987d.m16428c(this.f13325c, "comm/tags/.rcTag");
                            obj = 1;
                            outputStream = outputStream3;
                            j = c;
                            while (true) {
                                try {
                                    if (C3972a.m16342b(this.f13325c)) {
                                        if (!file.exists()) {
                                            file.createNewFile();
                                        }
                                        c = C3972a.m16336a(this.f13325c);
                                        outputStream.write(("top -d 0 -n 1 | grep -E -v 'root|shell|system' >> " + absolutePath + " && echo \"" + "======================" + "\" >> " + absolutePath + "\n").getBytes("ascii"));
                                        if (obj != null) {
                                            str = "echo \"" + c + "_" + C3972a.m16343c(this.f13325c) + "\" >> " + absolutePath + "\n";
                                        } else {
                                            str = "echo \"" + c + "_0\" >> " + absolutePath + "\n";
                                            obj = null;
                                        }
                                        outputStream.write(str.getBytes("ascii"));
                                        outputStream.flush();
                                        if (c >= j) {
                                            outputStream.write("exit\n".getBytes("ascii"));
                                            outputStream.flush();
                                            outputStream.close();
                                            process.waitFor();
                                            process.destroy();
                                            if (m16387a(absolutePath)) {
                                                c = j;
                                                obj2 = obj;
                                            } else {
                                                d = m16393d();
                                                if (d <= 0) {
                                                    d = j;
                                                }
                                                obj2 = 1;
                                                c = d;
                                            }
                                            try {
                                                C3987d.m16427b(this.f13325c, "comm/tags/.rcTag");
                                                try {
                                                    exec = Runtime.getRuntime().exec(IXAdRequestInfo.SCREEN_HEIGHT);
                                                    try {
                                                        process = exec;
                                                        outputStream2 = exec.getOutputStream();
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        try {
                                                            MobLog.getInstance().m4388w(th);
                                                            process = exec;
                                                            outputStream2 = outputStream;
                                                            C3987d.m16428c(this.f13325c, "comm/tags/.rcTag");
                                                            obj3 = obj2;
                                                            outputStream3 = outputStream2;
                                                            obj = obj3;
                                                            Thread.sleep((long) (C3972a.m16343c(this.f13325c) * AdError.NETWORK_ERROR_CODE));
                                                            outputStream = outputStream3;
                                                            j = c;
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            process = exec;
                                                            obj = obj2;
                                                            outputStream3 = outputStream;
                                                            MobLog.getInstance().m4376d(th);
                                                            outputStream = outputStream3;
                                                            j = c;
                                                        }
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    exec = process;
                                                    MobLog.getInstance().m4388w(th);
                                                    process = exec;
                                                    outputStream2 = outputStream;
                                                    C3987d.m16428c(this.f13325c, "comm/tags/.rcTag");
                                                    obj3 = obj2;
                                                    outputStream3 = outputStream2;
                                                    obj = obj3;
                                                    Thread.sleep((long) (C3972a.m16343c(this.f13325c) * AdError.NETWORK_ERROR_CODE));
                                                    outputStream = outputStream3;
                                                    j = c;
                                                }
                                                try {
                                                    C3987d.m16428c(this.f13325c, "comm/tags/.rcTag");
                                                    obj3 = obj2;
                                                    outputStream3 = outputStream2;
                                                    obj = obj3;
                                                    Thread.sleep((long) (C3972a.m16343c(this.f13325c) * AdError.NETWORK_ERROR_CODE));
                                                    outputStream = outputStream3;
                                                    j = c;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    obj3 = obj2;
                                                    outputStream3 = outputStream2;
                                                    obj = obj3;
                                                    MobLog.getInstance().m4376d(th);
                                                    outputStream = outputStream3;
                                                    j = c;
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                                obj = obj2;
                                                outputStream3 = outputStream;
                                                MobLog.getInstance().m4376d(th);
                                                outputStream = outputStream3;
                                                j = c;
                                            }
                                        }
                                    }
                                    c = j;
                                    outputStream3 = outputStream;
                                    try {
                                        Thread.sleep((long) (C3972a.m16343c(this.f13325c) * AdError.NETWORK_ERROR_CODE));
                                        outputStream = outputStream3;
                                        j = c;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        MobLog.getInstance().m4376d(th);
                                        outputStream = outputStream3;
                                        j = c;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    c = j;
                                    outputStream3 = outputStream;
                                    MobLog.getInstance().m4376d(th);
                                    outputStream = outputStream3;
                                    j = c;
                                }
                            }
                        } catch (Throwable th10) {
                            return;
                        }
                    }
                } catch (Throwable th11) {
                    th = th11;
                    exec = outputStream3;
                    MobLog.getInstance().m4388w(th);
                    process = exec;
                    C3987d.m16428c(this.f13325c, "comm/tags/.rcTag");
                    obj = 1;
                    outputStream = outputStream3;
                    j = c;
                    while (true) {
                        if (C3972a.m16342b(this.f13325c)) {
                            if (file.exists()) {
                                file.createNewFile();
                            }
                            c = C3972a.m16336a(this.f13325c);
                            outputStream.write(("top -d 0 -n 1 | grep -E -v 'root|shell|system' >> " + absolutePath + " && echo \"" + "======================" + "\" >> " + absolutePath + "\n").getBytes("ascii"));
                            if (obj != null) {
                                str = "echo \"" + c + "_0\" >> " + absolutePath + "\n";
                                obj = null;
                            } else {
                                str = "echo \"" + c + "_" + C3972a.m16343c(this.f13325c) + "\" >> " + absolutePath + "\n";
                            }
                            outputStream.write(str.getBytes("ascii"));
                            outputStream.flush();
                            if (c >= j) {
                                outputStream.write("exit\n".getBytes("ascii"));
                                outputStream.flush();
                                outputStream.close();
                                process.waitFor();
                                process.destroy();
                                if (m16387a(absolutePath)) {
                                    d = m16393d();
                                    if (d <= 0) {
                                        d = j;
                                    }
                                    obj2 = 1;
                                    c = d;
                                } else {
                                    c = j;
                                    obj2 = obj;
                                }
                                C3987d.m16427b(this.f13325c, "comm/tags/.rcTag");
                                exec = Runtime.getRuntime().exec(IXAdRequestInfo.SCREEN_HEIGHT);
                                process = exec;
                                outputStream2 = exec.getOutputStream();
                                C3987d.m16428c(this.f13325c, "comm/tags/.rcTag");
                                obj3 = obj2;
                                outputStream3 = outputStream2;
                                obj = obj3;
                                Thread.sleep((long) (C3972a.m16343c(this.f13325c) * AdError.NETWORK_ERROR_CODE));
                                outputStream = outputStream3;
                                j = c;
                            }
                        }
                        c = j;
                        outputStream3 = outputStream;
                        Thread.sleep((long) (C3972a.m16343c(this.f13325c) * AdError.NETWORK_ERROR_CODE));
                        outputStream = outputStream3;
                        j = c;
                    }
                }
                C3987d.m16428c(this.f13325c, "comm/tags/.rcTag");
                obj = 1;
                outputStream = outputStream3;
                j = c;
                while (true) {
                    if (C3972a.m16342b(this.f13325c)) {
                        if (file.exists()) {
                            file.createNewFile();
                        }
                        c = C3972a.m16336a(this.f13325c);
                        outputStream.write(("top -d 0 -n 1 | grep -E -v 'root|shell|system' >> " + absolutePath + " && echo \"" + "======================" + "\" >> " + absolutePath + "\n").getBytes("ascii"));
                        if (obj != null) {
                            str = "echo \"" + c + "_0\" >> " + absolutePath + "\n";
                            obj = null;
                        } else {
                            str = "echo \"" + c + "_" + C3972a.m16343c(this.f13325c) + "\" >> " + absolutePath + "\n";
                        }
                        outputStream.write(str.getBytes("ascii"));
                        outputStream.flush();
                        if (c >= j) {
                            outputStream.write("exit\n".getBytes("ascii"));
                            outputStream.flush();
                            outputStream.close();
                            process.waitFor();
                            process.destroy();
                            if (m16387a(absolutePath)) {
                                d = m16393d();
                                if (d <= 0) {
                                    d = j;
                                }
                                obj2 = 1;
                                c = d;
                            } else {
                                c = j;
                                obj2 = obj;
                            }
                            C3987d.m16427b(this.f13325c, "comm/tags/.rcTag");
                            exec = Runtime.getRuntime().exec(IXAdRequestInfo.SCREEN_HEIGHT);
                            process = exec;
                            outputStream2 = exec.getOutputStream();
                            C3987d.m16428c(this.f13325c, "comm/tags/.rcTag");
                            obj3 = obj2;
                            outputStream3 = outputStream2;
                            obj = obj3;
                            Thread.sleep((long) (C3972a.m16343c(this.f13325c) * AdError.NETWORK_ERROR_CODE));
                            outputStream = outputStream3;
                            j = c;
                        }
                    }
                    c = j;
                    outputStream3 = outputStream;
                    Thread.sleep((long) (C3972a.m16343c(this.f13325c) * AdError.NETWORK_ERROR_CODE));
                    outputStream = outputStream3;
                    j = c;
                }
            }

            private boolean m16391b(String str) {
                try {
                    File file = new File(str);
                    file.delete();
                    file.createNewFile();
                    return true;
                } catch (Throwable th) {
                    MobLog.getInstance().m4376d(th);
                    return false;
                }
            }

            private long m16392c() {
                long a = C3972a.m16336a(this.f13325c);
                try {
                    File file = new File(C4021R.getCacheRoot(this.f13325c), "comm/dbs/.nulplt");
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (file.exists()) {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        long readLong = dataInputStream.readLong();
                        dataInputStream.close();
                        return readLong;
                    }
                    file.createNewFile();
                    m16393d();
                    return a + C4156a.f13948j;
                } catch (Throwable th) {
                    MobLog.getInstance().m4376d(th);
                    return a + C4156a.f13948j;
                }
            }

            private long m16393d() {
                long a = C3972a.m16336a(this.f13325c) + C4156a.f13948j;
                try {
                    File file = new File(C4021R.getCacheRoot(this.f13325c), "comm/dbs/.nulplt");
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
                    dataOutputStream.writeLong(a);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    return a;
                } catch (Throwable th) {
                    MobLog.getInstance().m4376d(th);
                    return 0;
                }
            }

            private HashMap<String, String[]> m16394e() {
                ArrayList arrayList;
                try {
                    Object[] objArr = new Object[]{Boolean.valueOf(false)};
                    arrayList = (ArrayList) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f13325c), "getInstalledApp", objArr);
                } catch (Throwable th) {
                    MobLog.getInstance().m4388w(th);
                    arrayList = new ArrayList();
                }
                HashMap<String, String[]> hashMap = new HashMap();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    hashMap.put((String) ((HashMap) it.next()).get(Constants.KEY_ELECTION_PKG), new String[]{(String) r0.get("name"), (String) ((HashMap) it.next()).get(Constants.SP_KEY_VERSION)});
                }
                return hashMap;
            }

            public static synchronized void startCollector(Context context) {
                synchronized (RuntimeCollector.class) {
                    if (f13324b == null) {
                        f13324b = new RuntimeCollector(context);
                        f13324b.m16383a();
                    }
                }
            }

            public static synchronized void startCollector(Context context, String str) {
                synchronized (RuntimeCollector.class) {
                    startCollector(context);
                }
            }
        }
