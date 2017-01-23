package com.aide.ui.build.android;

import com.aide.common.e;
import com.aide.common.w;
import com.aide.engine.SyntaxError;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import ok;
import oy;
import qd;
import qe;
import qh;

public class a {
    private static boolean j6;
    private final ExecutorService DW;
    private c FH;
    private f Hw;

    private class a implements Callable<Map<String, List<SyntaxError>>> {
        private List<b> DW;
        final /* synthetic */ a j6;

        public /* synthetic */ Object call() {
            return j6();
        }

        public a(a aVar, List<b> list) {
            this.j6 = aVar;
            this.DW = list;
        }

        public Map<String, List<SyntaxError>> j6() {
            for (b bVar : this.DW) {
                String j6 = bVar.j6();
                if (j6 != null) {
                    return this.j6.j6(bVar.DW, j6);
                }
            }
            return null;
        }
    }

    private class b {
        private final String DW;
        private final String FH;
        private final String Hw;
        private final boolean VH;
        private final List<String> Zo;
        final /* synthetic */ a j6;
        private final Map<String, List<String>> v5;

        public b(a aVar, String str, String str2, String str3, Map<String, List<String>> map, List<String> list, boolean z) {
            this.j6 = aVar;
            this.DW = str2;
            this.FH = str;
            this.Hw = str3;
            this.v5 = map;
            this.Zo = list;
            this.VH = z;
        }

        public String j6() {
            for (String str : this.v5.keySet()) {
                String str2;
                if (!new File(str2).exists()) {
                    new File(str2).mkdirs();
                }
            }
            DW();
            for (String str22 : this.v5.keySet()) {
                if (!new File(str22).exists()) {
                    new File(str22).mkdirs();
                }
            }
            String str3;
            if (this.Zo != null) {
                for (String str222 : this.Zo) {
                    for (Entry entry : this.v5.entrySet()) {
                        str3 = (String) entry.getKey();
                        List<String> list = (List) entry.getValue();
                        for (String str4 : list) {
                            if (str222.startsWith(str4) && j6(str4, str3, new File(str222))) {
                                str222 = j6(str222, (List) list, str4, str3);
                                if (str222 != null) {
                                    return str222;
                                }
                            }
                        }
                    }
                    return "No source dir found for " + str222;
                }
            }
            for (Entry entry2 : this.v5.entrySet()) {
                String str5 = (String) entry2.getKey();
                List<String> list2 = (List) entry2.getValue();
                for (String str32 : list2) {
                    str32 = j6(str32, (List) list2, str5, new File(str32));
                    if (str32 != null) {
                        return str32;
                    }
                }
            }
            return null;
        }

        private void DW() {
            qd j6;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (!a.j6) {
                try {
                    j6 = qe.j6(Arrays.asList(new String[]{"/system/bin/chmod", "777", this.FH}), null, null, true, null, null);
                    if (j6.j6() != 0) {
                        throw new IOException("Could not make " + this.FH + " executable - exit code " + j6.j6());
                    }
                } catch (IOException e) {
                    j6 = qe.j6(Arrays.asList(new String[]{"/system/xbin/chmod", "777", this.FH}), null, null, true, null, null);
                    if (j6.j6() != 0) {
                        throw new IOException("Could not make " + this.FH + " executable - exit code " + j6.j6());
                    }
                }
                a.j6 = true;
            }
        }

        private String j6(String str, List<String> list, String str2, File file) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    String j6;
                    if (file2.isDirectory()) {
                        j6 = j6(str, (List) list, str2, file2);
                        if (j6 != null) {
                            return j6;
                        }
                    } else if (file2.isFile()) {
                        String path = file2.getPath();
                        if (path.toLowerCase().endsWith(".aidl") && j6(str, str2, file2)) {
                            j6 = j6(path, (List) list, str, str2);
                            if (j6 != null) {
                                return j6;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }

        private boolean j6(String str, String str2, File file) {
            if (!this.VH) {
                File file2 = new File(j6(file.getPath(), str, str2));
                if (file2.isFile() && file2.lastModified() >= file.lastModified()) {
                    return false;
                }
            }
            return true;
        }

        private String j6(String str, String str2, String str3) {
            if (!str2.endsWith(File.separator)) {
                str2 = str2 + File.separator;
            }
            if (str.startsWith(str2)) {
                return new File(str3, str.substring(str2.length(), str.length() - ".aidl".length()) + ".java").getPath();
            }
            throw new IllegalArgumentException();
        }

        private String j6(byte[] bArr, int i) {
            String str = "";
            try {
                str = w.j6(new InputStreamReader(new ByteArrayInputStream(bArr)));
            } catch (IOException e) {
            }
            str = str.trim();
            if (str.length() == 0) {
                return "aidl exited with code " + i;
            }
            return str;
        }

        private String j6(String str, List<String> list, String str2, String str3) {
            List arrayList = new ArrayList();
            arrayList.add(this.FH);
            arrayList.add("-p" + this.Hw);
            for (String str4 : list) {
                arrayList.add("-I" + str4);
            }
            arrayList.add("-I" + str3);
            arrayList.add(str);
            String j6 = j6(str, str2, str3);
            File file = new File(qh.v5(j6));
            if (!file.exists() && !file.mkdirs()) {
                return "Could not create directory " + qh.v5(j6);
            }
            arrayList.add(j6);
            j6(arrayList);
            qd j62 = qe.j6(arrayList, null, null, true, null, null);
            if (j62.j6() != 0) {
                if (j62.j6() != 11) {
                    return j6(j62.DW(), j62.j6());
                }
                e.j6("aidl exited with code 11");
            }
            if (!new File(j6).exists()) {
                try {
                    new FileOutputStream(j6).close();
                    return null;
                } catch (IOException e) {
                    return "Could not create " + j6 + ": " + e.getMessage();
                }
            } else if (!j6(str2, str3, new File(str))) {
                return null;
            } else {
                qh.j6(j6);
                return null;
            }
        }

        private void j6(List<String> list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Running aidl ");
            for (int i = 1; i < list.size(); i++) {
                stringBuilder.append('\"');
                stringBuilder.append((String) list.get(i));
                stringBuilder.append('\"');
                if (i != list.size() - 1) {
                    stringBuilder.append(" ");
                }
            }
            e.j6(stringBuilder.toString());
        }
    }

    private class c extends FutureTask<Map<String, List<SyntaxError>>> {
        private a DW;
        final /* synthetic */ a j6;

        public c(a aVar, a aVar2) {
            this.j6 = aVar;
            super(aVar2);
            this.DW = aVar2;
        }

        protected void done() {
            if (!isCancelled()) {
                try {
                    Map map = (Map) get();
                    if (map == null) {
                        this.j6.DW();
                    } else {
                        this.j6.j6(map);
                    }
                } catch (InterruptedException e) {
                    this.j6.FH();
                } catch (ExecutionException e2) {
                    this.j6.j6(e2.getCause());
                }
            }
        }
    }

    public a() {
        this.DW = Executors.newSingleThreadExecutor();
    }

    public void j6(List<String> list) {
        String j6 = oy.j6("aidl", false);
        if (this.FH != null) {
            this.FH.cancel(true);
            this.FH = null;
        }
        List arrayList = new ArrayList();
        for (String j62 : com.aide.ui.e.a8().tp()) {
            arrayList.add(j6(j62, list, false, j6));
        }
        ExecutorService executorService = this.DW;
        Runnable cVar = new c(this, new a(this, arrayList));
        this.FH = cVar;
        executorService.execute(cVar);
    }

    public void j6(String str, boolean z, boolean z2) {
        String j6 = oy.j6("aidl", false);
        if (this.FH != null) {
            this.FH.cancel(true);
            this.FH = null;
        }
        List arrayList = new ArrayList();
        if (z2) {
            for (String str2 : com.aide.ui.e.a8().tp()) {
                if (!str.equals(str2)) {
                    arrayList.add(j6(str2, null, false, j6));
                }
            }
        }
        arrayList.add(j6(str, null, z, j6));
        ExecutorService executorService = this.DW;
        Runnable cVar = new c(this, new a(this, arrayList));
        this.FH = cVar;
        executorService.execute(cVar);
    }

    private b j6(String str, List<String> list, boolean z, String str2) {
        return new b(this, str2, str, com.aide.ui.e.Ws().Zo(), ok.DW(com.aide.ui.e.a8().EQ(str), com.aide.ui.e.a8().v5()), list, z);
    }

    private void DW() {
        if (this.Hw != null) {
            this.Hw.FH();
        }
    }

    private void j6(Map<String, List<SyntaxError>> map) {
        if (this.Hw != null) {
            this.Hw.j6(map);
        }
    }

    private void FH() {
        if (this.Hw != null) {
            this.Hw.j6();
        }
    }

    private void j6(Throwable th) {
        e.j6(th);
        if (this.Hw != null) {
            this.Hw.DW();
        }
    }

    private Map<String, List<SyntaxError>> j6(String str, String str2) {
        Map hashMap = new HashMap();
        for (String trim : str2.split("\n")) {
            String trim2;
            String trim3 = trim2.trim();
            if (trim3.length() > 0) {
                try {
                    int indexOf = trim3.indexOf(58);
                    if (indexOf > 0) {
                        String substring = trim3.substring(0, indexOf);
                        if (qh.J8(substring)) {
                            int indexOf2;
                            int indexOf3 = trim3.indexOf(58, indexOf + 1);
                            if (indexOf3 < 0) {
                                indexOf2 = trim3.indexOf(32, indexOf + 1);
                            } else {
                                indexOf2 = indexOf3;
                            }
                            if (indexOf2 > 0) {
                                try {
                                    indexOf = Integer.parseInt(trim3.substring(indexOf + 1, indexOf2));
                                } catch (NumberFormatException e) {
                                    indexOf = 1;
                                }
                                trim2 = trim3.substring(indexOf2 + 1, trim3.length()).trim();
                                while (trim2.toLowerCase().startsWith("error:")) {
                                    trim2 = trim2.substring(6, trim2.length()).trim();
                                }
                                SyntaxError j6 = j6("aapt", indexOf, trim2);
                                if (!hashMap.containsKey(substring)) {
                                    hashMap.put(substring, new ArrayList());
                                }
                                ((List) hashMap.get(substring)).add(j6);
                            }
                        }
                    }
                } catch (Throwable e2) {
                    e.j6(e2);
                }
                if (!hashMap.containsKey(str)) {
                    hashMap.put(str, new ArrayList());
                }
                ((List) hashMap.get(str)).add(j6("aapt", 1, trim3));
            }
        }
        return hashMap;
    }

    private SyntaxError j6(String str, int i, String str2) {
        SyntaxError syntaxError = new SyntaxError();
        syntaxError.FH = i;
        syntaxError.Hw = 1;
        syntaxError.v5 = i;
        syntaxError.Zo = 1000;
        syntaxError.VH = str + ": " + str2;
        return syntaxError;
    }

    public void j6(f fVar) {
        this.Hw = fVar;
    }
}
