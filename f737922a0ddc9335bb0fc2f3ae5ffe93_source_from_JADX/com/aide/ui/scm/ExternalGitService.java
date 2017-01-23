package com.aide.ui.scm;

import aht;
import ahu;
import ahv$a;
import ahy;
import ahz;
import aia;
import aia$a;
import aid;
import aig$a;
import aij;
import aij$a;
import aik;
import ail;
import aim;
import aip;
import aiw;
import alk;
import ame;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import ani;
import aob;
import aoc;
import aoh;
import aol;
import aql;
import ara;
import arc;
import atb;
import atm;
import atm$a;
import atm$b;
import atm$d;
import atm$f;
import atn;
import aul;
import aus;
import aus$a;
import aux;
import avn;
import awc;
import awp;
import axi;
import com.aide.common.e;
import com.aide.common.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import qh;

public class ExternalGitService extends Service {
    private a j6;

    private static class b extends axi {
        private axi j6;

        public b(axi axi) {
            this.j6 = axi;
        }

        public String j6() {
            return this.j6.j6();
        }

        public String j6(String str) {
            return this.j6.j6(str);
        }

        public String DW(String str) {
            return this.j6.DW(str);
        }

        public ara j6(ani ani, awp awp) {
            return this.j6.j6(ani, awp);
        }

        public ara DW(ani ani, awp awp) {
            return this.j6.DW(ani, awp);
        }

        public long DW() {
            return this.j6.DW();
        }

        public int j6(long j) {
            return this.j6.j6(j);
        }
    }

    private class a extends com.aide.ui.scm.c.a {
        private Object DW;
        private boolean FH;
        private Object Hw;
        private String VH;
        private String Zo;
        final /* synthetic */ ExternalGitService j6;
        private String v5;

        class 1 extends b {
            final /* synthetic */ a DW;
            final /* synthetic */ ExternalGitService j6;

            1(a aVar, axi axi, ExternalGitService externalGitService) {
                this.DW = aVar;
                this.j6 = externalGitService;
                super(axi);
            }

            public ara j6(ani ani, awp awp) {
                return new ara(ani, new File(this.DW.j6.getCacheDir(), ".gitconfig"), awp);
            }
        }

        class 2 extends atn {
            final /* synthetic */ a DW;
            final /* synthetic */ d j6;

            2(a aVar, d dVar) {
                this.DW = aVar;
                this.j6 = dVar;
            }

            public boolean j6() {
                return true;
            }

            public boolean j6(atm[] atmArr) {
                for (atm j6 : atmArr) {
                    if (!j6(j6)) {
                        return false;
                    }
                }
                return true;
            }

            public boolean j6(avn avn, atm[] atmArr) {
                for (atm j6 : atmArr) {
                    if (!j6(avn, j6)) {
                        return false;
                    }
                }
                return true;
            }

            private boolean j6(avn avn, atm atm) {
                String DW;
                if (atm instanceof atm$d) {
                    try {
                        DW = this.j6.DW(atm.j6());
                        if (DW == null) {
                            return false;
                        }
                        ((atm$d) atm).j6(DW);
                        return true;
                    } catch (Throwable e) {
                        e.j6(e);
                        return false;
                    }
                } else if (atm instanceof atm$a) {
                    try {
                        DW = this.j6.DW(atm.j6());
                        if (DW == null) {
                            return false;
                        }
                        ((atm$a) atm).j6(DW.toCharArray());
                        return true;
                    } catch (Throwable e2) {
                        e.j6(e2);
                        return false;
                    }
                } else if (atm instanceof atm$b) {
                    try {
                        this.j6.v5(atm.j6());
                        return true;
                    } catch (Throwable e22) {
                        e.j6(e22);
                        return false;
                    }
                } else if (atm instanceof atm$f) {
                    try {
                        DW = this.j6.Hw(atm.j6());
                        if (DW == null) {
                            return false;
                        }
                        ((atm$f) atm).j6(Boolean.parseBoolean(DW));
                        return true;
                    } catch (Throwable e222) {
                        e.j6(e222);
                        return false;
                    }
                } else {
                    throw new ame(avn, "Unsupported CredentialItem: " + atm.getClass().getName());
                }
            }

            private boolean j6(atm atm) {
                return (atm instanceof atm$d) || (atm instanceof atm$a) || (atm instanceof atm$b) || (atm instanceof atm$f);
            }
        }

        private class a implements aob {
            private d DW;
            private int FH;
            final /* synthetic */ a j6;

            public a(a aVar, d dVar) {
                this.j6 = aVar;
                this.DW = dVar;
            }

            public void j6(int i) {
                try {
                    this.FH += i;
                    this.DW.DW(this.FH);
                } catch (Throwable e) {
                    e.j6(e);
                }
            }

            public void DW(int i) {
                try {
                    this.DW.j6(i);
                } catch (Throwable e) {
                    e.j6(e);
                }
            }

            public boolean j6() {
                boolean DW;
                synchronized (this.j6.DW) {
                    DW = this.j6.FH;
                }
                return DW;
            }

            public void DW() {
                try {
                    this.DW.FH();
                } catch (Throwable e) {
                    e.j6(e);
                }
            }

            public void j6(String str, int i) {
                try {
                    this.FH = 0;
                    this.DW.j6(str, i);
                } catch (Throwable e) {
                    e.j6(e);
                }
            }
        }

        public a(ExternalGitService externalGitService) {
            this.j6 = externalGitService;
            this.DW = new Object();
            this.Hw = new Object();
            this.v5 = qh.j6();
            awp.j6.DW(new File(this.v5));
            axi.j6(new 1(this, axi.FH(), externalGitService));
        }

        public void j6(GitConfiguration gitConfiguration, String str, String str2, List<String> list, d dVar) {
            try {
                j6(gitConfiguration);
                new File(str).mkdirs();
                aoh arc = new arc(new File(str, ".git"));
                arc.j6();
                arc.tp();
                FileWriter fileWriter = new FileWriter(new File(str, ".gitignore"));
                for (String str3 : list) {
                    fileWriter.write(str3 + "\n");
                }
                fileWriter.close();
                GitStatus j6 = j6(str, dVar);
                if (j6.DW.size() > 0) {
                    j6(str, j6.DW, str2, dVar);
                }
                DW(dVar);
            } catch (Throwable th) {
                j6(dVar, "Git create", th);
            }
        }

        public void j6(GitConfiguration gitConfiguration, String str, String str2, String str3, d dVar) {
            try {
                j6(gitConfiguration);
                ((ahy) aid.j6().j6(new File(str, str2)).j6(true).j6(j6(dVar))).j6(new a(this, dVar)).j6(str3).j6().QX().tp();
                DW(dVar);
                if (!gitConfiguration.Hw) {
                    aux.j6(null);
                }
            } catch (Throwable th) {
                if (!gitConfiguration.Hw) {
                    aux.j6(null);
                }
            }
        }

        private void j6(GitConfiguration gitConfiguration) {
            FileWriter fileWriter;
            Throwable e;
            synchronized (this.Hw) {
                if (gitConfiguration.FH != null && gitConfiguration.FH.endsWith(".ssh")) {
                    String substring = gitConfiguration.FH.substring(0, gitConfiguration.FH.length() - ".ssh".length());
                    if (!substring.equals(this.v5)) {
                        this.v5 = substring;
                        awp.j6.DW(new File(this.v5));
                        aux.j6(null);
                    }
                }
                if (gitConfiguration.j6 == null || gitConfiguration.j6.length() == 0 || gitConfiguration.DW == null || gitConfiguration.DW.length() == 0) {
                    new File(this.j6.getCacheDir(), ".gitconfig").delete();
                } else if (!(gitConfiguration.j6.equals(this.Zo) && gitConfiguration.DW.equals(this.VH))) {
                    try {
                        fileWriter = new FileWriter(new File(this.j6.getCacheDir(), ".gitconfig"));
                        try {
                            PrintWriter printWriter = new PrintWriter(fileWriter);
                            printWriter.println("[user]");
                            printWriter.println("\tname = " + gitConfiguration.j6.trim());
                            printWriter.println("\temail = " + gitConfiguration.DW.trim());
                            this.Zo = gitConfiguration.j6;
                            this.VH = gitConfiguration.DW;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (Throwable e2) {
                                    e.j6(e2);
                                }
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            try {
                                e.j6(e2);
                                if (fileWriter != null) {
                                    try {
                                        fileWriter.close();
                                    } catch (Throwable e22) {
                                        e.j6(e22);
                                    }
                                }
                            } catch (Throwable th) {
                                e22 = th;
                                if (fileWriter != null) {
                                    try {
                                        fileWriter.close();
                                    } catch (Throwable e4) {
                                        e.j6(e4);
                                    }
                                }
                                throw e22;
                            }
                        }
                    } catch (IOException e5) {
                        e22 = e5;
                        fileWriter = null;
                        e.j6(e22);
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th2) {
                        e22 = th2;
                        fileWriter = null;
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        throw e22;
                    }
                }
            }
        }

        public void j6(GitConfiguration gitConfiguration, String str, d dVar) {
            aid j6;
            try {
                j6(gitConfiguration);
                j6 = aid.j6(new File(str));
                ail j62 = ((aik) j6.Zo().j6(j6(dVar))).j6(new a(this, dVar)).j6();
                if (j62.DW()) {
                    if (!gitConfiguration.Hw) {
                        aux.j6(null);
                    }
                    j6.QX().tp();
                    DW(dVar);
                } else if (j62.j6() == null || j62.j6().j6() != aij$a.CONFLICTING) {
                    throw new Exception(j62.toString());
                } else {
                    throw new Exception(j62.j6().toString());
                }
            } catch (aiw e) {
                DW(dVar);
            } catch (Throwable th) {
                j6(dVar, "Git pull", th);
            }
        }

        public void DW(GitConfiguration gitConfiguration, String str, d dVar) {
            aid j6;
            try {
                j6(gitConfiguration);
                j6 = aid.j6(new File(str));
                for (aul aul : ((aim) j6.EQ().j6(j6(dVar))).j6(new a(this, dVar)).j6()) {
                    for (aus aus : aul.FH()) {
                        if (aus.u7() != aus$a.OK && aus.u7() != aus$a.UP_TO_DATE) {
                            throw new Exception("Messages: " + aul.DW() + " Status: " + aus.u7());
                        }
                    }
                }
                if (!gitConfiguration.Hw) {
                    aux.j6(null);
                }
                j6.QX().tp();
                DW(dVar);
            } catch (Throwable th) {
                if (th.getCause() instanceof alk) {
                    String FH = dVar.FH("Please specifiy a valid remote repository url:");
                    if (FH != null) {
                        v5(str, FH, dVar);
                        DW(gitConfiguration, str, dVar);
                        return;
                    }
                    return;
                }
                j6(dVar, "Git push", th);
            }
        }

        private void v5(String str, String str2, d dVar) {
            aid j6;
            try {
                j6 = aid.j6(new File(str));
                aol VH = j6.QX().VH();
                VH.j6("remote", "origin", "url", str2);
                VH.v5();
                j6.QX().tp();
            } catch (Throwable th) {
                j6(dVar, "Git push", th);
            }
        }

        public GitStatus j6(String str, d dVar) {
            aid j6;
            try {
                j6 = aid.j6(new File(str));
                aip j62 = j6.J8().j6();
                Map j63 = j6.Ws().j6();
                DW(dVar);
                GitStatus j64 = j6(str, j6, j62, j63);
                j6.QX().tp();
                return j64;
            } catch (Throwable th) {
                j6(dVar, "Git status", th);
                return null;
            }
        }

        public void j6(GitConfiguration gitConfiguration, String str, List<ModifiedFile> list, String str2, d dVar) {
            try {
                j6(gitConfiguration);
                j6(str, (List) list, str2, dVar);
                DW(dVar);
            } catch (Throwable th) {
                j6(dVar, "Git commit", th);
            }
        }

        private void j6(String str, List<ModifiedFile> list, String str2, d dVar) {
            Object obj = null;
            aid j6 = aid.j6(new File(str));
            try {
                aht tp = j6.tp();
                for (ModifiedFile modifiedFile : list) {
                    Object obj2;
                    if (modifiedFile.Hw() || modifiedFile.Zo() || modifiedFile.v5() || modifiedFile.VH()) {
                        tp.j6(j6(str, modifiedFile.j6));
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                }
                if (obj != null) {
                    tp.j6();
                }
                DW(dVar);
                ahz j62 = j6.FH().j6(false).j6(str2);
                for (ModifiedFile modifiedFile2 : list) {
                    j62.DW(j6(str, modifiedFile2.j6));
                }
                j62.j6();
            } finally {
                j6.QX().tp();
            }
        }

        public void j6(String str, List<ModifiedFile> list, d dVar) {
            aid j6;
            try {
                j6 = aid.j6(new File(str));
                ahu FH = j6.J0().j6(true).FH("HEAD");
                for (ModifiedFile modifiedFile : list) {
                    FH.j6(j6(str, modifiedFile.j6));
                }
                FH.j6();
                if (FH.FH().j6() != ahv$a.OK) {
                    throw new Exception("Git checkout failed: " + FH.FH().j6());
                }
                for (ModifiedFile modifiedFile2 : list) {
                    if (!modifiedFile2.j6()) {
                        if (modifiedFile2.Zo()) {
                        }
                    }
                    File file = new File(modifiedFile2.j6);
                    if (file.exists() && !file.delete()) {
                        throw new IOException("Could not delete " + modifiedFile2.j6);
                    }
                }
                j6.QX().tp();
                DW(dVar);
            } catch (Throwable th) {
                j6(dVar, "Git discard", th);
            }
        }

        public String j6(String str, String str2, d dVar) {
            try {
                aid j6 = aid.j6(new File(str));
                OutputStream fileOutputStream;
                try {
                    File createTempFile = File.createTempFile("gitcontent", ".txt", this.j6.getExternalCacheDir());
                    fileOutputStream = new FileOutputStream(createTempFile);
                    j6(j6, j6(str, str2), fileOutputStream);
                    fileOutputStream.close();
                    DW(dVar);
                    String path = createTempFile.getPath();
                    j6.QX().tp();
                    return path;
                } catch (Throwable th) {
                    j6.QX().tp();
                }
            } catch (Throwable th2) {
                j6(dVar, "Git get base file content", th2);
                return null;
            }
        }

        public String DW(String str, d dVar) {
            aid j6;
            try {
                j6 = aid.j6(new File(str));
                String we = j6.QX().we();
                j6.QX().tp();
                return we;
            } catch (Throwable th) {
                j6(dVar, "Git get branches", th);
                return null;
            }
        }

        public List<String> FH(String str, d dVar) {
            aid j6;
            try {
                j6 = aid.j6(new File(str));
                List<aoc> j62 = j6.u7().j6(aig$a.ALL).j6();
                ArrayList arrayList = new ArrayList();
                for (aoc j63 : j62) {
                    arrayList.add(j63.j6());
                }
                j6.QX().tp();
                return arrayList;
            } catch (Throwable th) {
                j6(dVar, "Git get branches", th);
                return null;
            }
        }

        public void DW(String str, String str2, d dVar) {
            aid j6;
            try {
                j6 = aid.j6(new File(str));
                j6.gn().j6(str2).j6();
                j6.QX().tp();
            } catch (Throwable th) {
                j6(dVar, "Git delete branch", th);
            }
        }

        public void FH(String str, String str2, d dVar) {
            aid j6;
            try {
                j6 = aid.j6(new File(str));
                aij j62 = j6.v5().j6(j6.QX().DW(str2)).j6();
                if (j62.j6() == aij$a.FAILED) {
                    throw new Exception("Git merge failed: " + j62.j6().toString());
                }
                j6.QX().tp();
            } catch (Throwable th) {
                j6(dVar, "Git merge", th);
            }
        }

        public void Hw(String str, String str2, d dVar) {
            aid j6;
            try {
                j6 = aid.j6(new File(str));
                ahu DW = j6.J0().DW(str2);
                DW.j6();
                if (DW.FH().j6() != ahv$a.OK) {
                    throw new Exception("Git checkout failed: " + DW.FH().j6());
                }
                j6.QX().tp();
            } catch (Throwable th) {
                j6(dVar, "Git checkout", th);
            }
        }

        public void j6(String str, String str2, String str3, d dVar) {
            aid j6;
            try {
                j6 = aid.j6(new File(str));
                aia j62 = j6.VH().j6(str2);
                if (str3 != null) {
                    j62.DW(str3).j6(aia$a.TRACK);
                }
                j62.j6();
                ahu DW = j6.J0().DW(str2);
                DW.j6();
                if (DW.FH().j6() != ahv$a.OK) {
                    throw new Exception("Git checkout failed: " + DW.FH().j6());
                }
                j6.QX().tp();
            } catch (Throwable th) {
                j6(dVar, "Git checkout", th);
            }
        }

        private String j6(String str, String str2) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            if (str2.startsWith(str)) {
                return str2.substring(str.length());
            }
            throw new IllegalArgumentException(str2 + " not in repository " + str);
        }

        private GitStatus j6(String str, aid aid, aip aip, Map<String, atb> map) {
            Set keySet = map.keySet();
            Collection arrayList = new ArrayList();
            j6(str, arrayList, aip.j6(), 1, null, false);
            j6(str, arrayList, aip.DW(), 2, null, true);
            j6(str, arrayList, aip.VH(), 64, null, true);
            j6(str, arrayList, aip.Hw(), 8, keySet, true);
            j6(str, arrayList, aip.v5(), 16, null, true);
            j6(str, arrayList, aip.FH(), 4, null, true);
            j6(str, arrayList, aip.Zo(), 32, null, false);
            return new GitStatus(str, arrayList);
        }

        private void j6(String str, List<ModifiedFile> list, Iterable<String> iterable, int i, Set<String> set, boolean z) {
            for (String str2 : iterable) {
                if (set == null || !set.contains(str2)) {
                    list.add(new ModifiedFile(new File(str, str2).getPath(), i));
                }
            }
        }

        private void j6(aid aid, String str, OutputStream outputStream) {
            InputStream FH = aid.QX().j6(awc.j6(aid.QX(), str, new aql(aid.QX()).Zo(aid.QX().DW("HEAD")).u7()).FH(0), 3).FH();
            try {
                w.j6(FH, outputStream);
            } finally {
                FH.close();
            }
        }

        public void j6() {
            synchronized (this.DW) {
                this.FH = true;
            }
        }

        private atn j6(d dVar) {
            return new 2(this, dVar);
        }

        private void DW(d dVar) {
            synchronized (this.DW) {
                if (this.FH) {
                    this.FH = false;
                    try {
                        dVar.Hw();
                        return;
                    } catch (Throwable e) {
                        e.j6(e);
                        return;
                    }
                }
            }
        }

        private void j6(d dVar, String str, Throwable th) {
            e.j6(th);
            if (dVar == null) {
                return;
            }
            if (th instanceof OutOfMemoryError) {
                try {
                    dVar.v5();
                } catch (Throwable e) {
                    e.j6(e);
                }
                e.j6("Git service process killed after OOM");
                Process.killProcess(Process.myPid());
                return;
            }
            try {
                String j6 = j6(th);
                if (j6 == null) {
                    j6 = "";
                }
                dVar.j6(str + " failed: " + j6);
            } catch (Throwable e2) {
                e.j6(e2);
            }
        }

        private String j6(Throwable th) {
            return j6(th, 0, 100);
        }

        private String j6(Throwable th, int i, int i2) {
            if (i < i2 && th.getCause() != null) {
                String j6 = j6(th.getCause(), i + 1, i2);
                if (j6 != null) {
                    return j6;
                }
            }
            return th.getMessage();
        }
    }

    public ExternalGitService() {
        this.j6 = new a(this);
    }

    public IBinder onBind(Intent intent) {
        e.DW("ExternalGitService bound - pid " + Process.myPid() + " id " + System.identityHashCode(this));
        return this.j6;
    }

    public void onDestroy() {
        e.DW("ExternalGitService shutdown - pid " + Process.myPid() + " id " + System.identityHashCode(this));
        this.j6 = null;
    }
}
