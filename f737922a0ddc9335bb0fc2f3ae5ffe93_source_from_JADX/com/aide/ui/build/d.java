package com.aide.ui.build;

import com.aide.common.e;
import com.aide.common.w;
import com.aide.engine.SyntaxError;
import com.aide.ui.build.android.g;
import com.aide.ui.build.android.m;
import com.aide.ui.h;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import qd;
import qe;
import qh;

public class d {
    private b DW;
    private g FH;
    private final ExecutorService j6;

    private class a implements Callable<Map<String, List<SyntaxError>>> {
        final /* synthetic */ d DW;
        private final boolean FH;
        private final boolean Hw;
        public final List<String> j6;

        public /* synthetic */ Object call() {
            return j6();
        }

        public a(d dVar, boolean z, boolean z2, List<String> list) {
            this.DW = dVar;
            this.FH = z;
            this.Hw = z2;
            this.j6 = list;
        }

        public Map<String, List<SyntaxError>> j6() {
            if (!m.Zo()) {
                return null;
            }
            if (this.FH) {
                Map<String, List<SyntaxError>> j6 = j6("clean", false);
                if (j6 != null) {
                    return j6;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, List<SyntaxError>> j62 = j6(null, this.Hw);
            e.j6("NDK build elapsed " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            return j62;
        }

        private Map<String, List<SyntaxError>> j6(String str, boolean z) {
            for (String str2 : this.j6) {
                if (com.aide.ui.e.a8().gW(str2)) {
                    List j6 = m.j6(str, z ? 4 : 1);
                    Map v5 = m.v5();
                    j6(j6, str2);
                    qd j62 = qe.j6(j6, str2, v5, true, null, null);
                    if (j62.j6() != 0) {
                        return this.DW.j6(str2, j6(j62.DW(), j62.j6()));
                    }
                }
            }
            return null;
        }

        private String j6(byte[] bArr, int i) {
            String str = "";
            try {
                str = w.j6(new InputStreamReader(new ByteArrayInputStream(bArr)));
            } catch (IOException e) {
            }
            str = str.trim();
            if (str.length() == 0) {
                return "ndk-build exited with code " + i;
            }
            return str;
        }

        private void j6(List<String> list, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Running ndk-build [" + str + "] ");
            for (int i = 0; i < list.size(); i++) {
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

    private class b extends FutureTask<Map<String, List<SyntaxError>>> {
        private a DW;
        final /* synthetic */ d j6;

        public b(d dVar, a aVar) {
            this.j6 = dVar;
            super(aVar);
            this.DW = aVar;
        }

        protected void done() {
            if (!isCancelled()) {
                boolean z = false;
                try {
                    for (String gW : this.DW.j6) {
                        boolean z2;
                        if (com.aide.ui.e.a8().gW(gW)) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    }
                    Map map = (Map) get();
                    if (map == null) {
                        this.j6.DW(z);
                    } else {
                        this.j6.j6(map);
                    }
                } catch (InterruptedException e) {
                    this.j6.j6();
                } catch (ExecutionException e2) {
                    this.j6.j6(e2.getCause());
                }
            }
        }
    }

    public d() {
        this.j6 = Executors.newSingleThreadExecutor();
    }

    public void j6(boolean z) {
        if (this.DW != null) {
            this.DW.cancel(true);
            this.DW = null;
        }
        this.DW = new b(this, new a(this, z, h.Zo(), com.aide.ui.e.a8().we()));
        this.j6.execute(this.DW);
    }

    private void DW(boolean z) {
        if (this.FH != null) {
            this.FH.j6(z);
        }
    }

    private void j6(Map<String, List<SyntaxError>> map) {
        if (this.FH != null) {
            this.FH.j6((Map) map);
        }
    }

    private void j6() {
        if (this.FH != null) {
            this.FH.j6();
        }
    }

    private void j6(Throwable th) {
        e.j6(th);
        if (this.FH != null) {
            this.FH.DW();
        }
    }

    private Map<String, List<SyntaxError>> j6(String str, String str2) {
        Map hashMap = new HashMap();
        for (String trim : str2.split("\n")) {
            String trim2 = trim.trim();
            if (trim2.length() > 0) {
                try {
                    int indexOf = trim2.indexOf(58);
                    if (indexOf > 0) {
                        String path = new File(str, trim2.substring(0, indexOf)).getPath();
                        if (qh.J8(path)) {
                            int indexOf2 = trim2.indexOf(58, indexOf + 1);
                            int indexOf3;
                            String trim3;
                            SyntaxError j6;
                            if (indexOf2 >= 0) {
                                if (indexOf2 >= 0) {
                                    indexOf3 = trim2.indexOf(32, indexOf + 1);
                                } else {
                                    indexOf3 = indexOf2;
                                }
                                if (indexOf3 > 0) {
                                    try {
                                        indexOf2 = Integer.parseInt(trim2.substring(indexOf + 1, indexOf3));
                                    } catch (NumberFormatException e) {
                                        indexOf2 = 1;
                                    }
                                    indexOf = trim2.indexOf(58, indexOf3 + 1);
                                    if (indexOf > 0) {
                                        try {
                                            Integer.parseInt(trim2.substring(indexOf3 + 1, indexOf));
                                        } catch (NumberFormatException e2) {
                                        }
                                    }
                                    trim3 = trim2.substring(indexOf + 1, trim2.length()).trim();
                                    if (trim3.startsWith("error:")) {
                                        j6 = j6("NDK", indexOf2, 1, trim3.substring(6, trim3.length()).trim());
                                        if (!hashMap.containsKey(path)) {
                                            hashMap.put(path, new ArrayList());
                                        }
                                        ((List) hashMap.get(path)).add(j6);
                                    }
                                }
                            } else {
                                if (indexOf2 >= 0) {
                                    indexOf3 = indexOf2;
                                } else {
                                    indexOf3 = trim2.indexOf(32, indexOf + 1);
                                }
                                if (indexOf3 > 0) {
                                    indexOf2 = Integer.parseInt(trim2.substring(indexOf + 1, indexOf3));
                                    indexOf = trim2.indexOf(58, indexOf3 + 1);
                                    if (indexOf > 0) {
                                        Integer.parseInt(trim2.substring(indexOf3 + 1, indexOf));
                                    }
                                    trim3 = trim2.substring(indexOf + 1, trim2.length()).trim();
                                    if (trim3.startsWith("error:")) {
                                        j6 = j6("NDK", indexOf2, 1, trim3.substring(6, trim3.length()).trim());
                                        if (hashMap.containsKey(path)) {
                                            hashMap.put(path, new ArrayList());
                                        }
                                        ((List) hashMap.get(path)).add(j6);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable e3) {
                    e.j6(e3);
                }
                if (!hashMap.containsKey(str)) {
                    hashMap.put(str, new ArrayList());
                }
                ((List) hashMap.get(str)).add(j6("NDK", 1, 1, trim2));
            }
        }
        return hashMap;
    }

    private SyntaxError j6(String str, int i, int i2, String str2) {
        SyntaxError syntaxError = new SyntaxError();
        syntaxError.FH = i;
        syntaxError.Hw = i2;
        syntaxError.v5 = i;
        syntaxError.Zo = 1000;
        syntaxError.VH = str + ": " + str2;
        return syntaxError;
    }

    public void j6(g gVar) {
        this.FH = gVar;
    }
}
