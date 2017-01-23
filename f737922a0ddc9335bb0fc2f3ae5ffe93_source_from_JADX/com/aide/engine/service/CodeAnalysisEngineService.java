package com.aide.engine.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat.Builder;
import bd;
import bh;
import cc;
import com.aide.engine.EngineSolution;
import com.aide.engine.EngineSolutionProject;
import com.aide.engine.FileHighlightings;
import com.aide.engine.FindResult;
import com.aide.engine.Modification;
import com.aide.engine.SourceEntity;
import com.aide.engine.SyntaxError;
import com.aide.engine.aa;
import com.aide.engine.ab;
import com.aide.engine.ac;
import com.aide.engine.ad;
import com.aide.engine.af;
import com.aide.engine.b;
import com.aide.engine.c;
import com.aide.engine.d;
import com.aide.engine.e;
import com.aide.engine.f;
import com.aide.engine.g;
import com.aide.engine.service.b.a;
import com.aide.engine.x;
import com.aide.engine.z;
import com.aide.ui.MainActivity;
import ep;
import gf;
import hh;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CodeAnalysisEngineService extends Service {
    private h DW;
    private f FH;
    private c Hw;
    private final a Zo;
    private b j6;
    private e v5;

    class 1 extends ep {
        final /* synthetic */ CodeAnalysisEngineService j6;

        1(CodeAnalysisEngineService codeAnalysisEngineService) {
            this.j6 = codeAnalysisEngineService;
        }

        public String DW() {
            return this.j6.getPackageName();
        }

        public InputStream j6(String str) {
            return this.j6.getAssets().open(str);
        }
    }

    class 2 implements e {
        final /* synthetic */ CodeAnalysisEngineService j6;

        2(CodeAnalysisEngineService codeAnalysisEngineService) {
            this.j6 = codeAnalysisEngineService;
        }

        public long j6() {
            return 0;
        }

        public bh[] j6(cc ccVar, List<String> list) {
            return l.j6(ccVar, (List) list);
        }
    }

    class 3 implements c {
        final /* synthetic */ CodeAnalysisEngineService j6;

        3(CodeAnalysisEngineService codeAnalysisEngineService) {
            this.j6 = codeAnalysisEngineService;
        }

        public void DW() {
            com.aide.common.e.j6("Engine process killed after shutdown");
            Process.killProcess(Process.myPid());
        }

        public void j6() {
            com.aide.common.e.FH("Engine process killed after OOM");
            if (this.j6.v5 != null) {
                try {
                    this.j6.v5.j6();
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
            Process.killProcess(Process.myPid());
        }

        public void j6(Throwable th) {
            com.aide.common.e.j6(th);
            if (this.j6.v5 != null) {
                try {
                    this.j6.v5.DW();
                } catch (RemoteException e) {
                    com.aide.common.e.j6(th);
                }
            }
        }
    }

    class 4 implements ad {
        private List DW;
        final /* synthetic */ CodeAnalysisEngineService j6;

        4(CodeAnalysisEngineService codeAnalysisEngineService) {
            this.j6 = codeAnalysisEngineService;
            this.DW = new ArrayList();
        }

        public void j6(String str, int i, int i2, int i3, int i4, boolean z) {
        }

        public void DW(String str) {
            if (this.j6.FH != null) {
                try {
                    this.j6.FH.j6(str);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void j6(String str, List<SourceEntity> list) {
            if (this.j6.FH != null) {
                try {
                    this.j6.FH.j6(str, list);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void j6(String str, long j, int i, int i2, int i3, List<SourceEntity> list) {
        }

        public void j6(String str, long j, List<SourceEntity> list) {
        }

        public void DW(String str, long j, int i, int i2) {
        }

        public void j6(String str, long j, int i, int i2, int[] iArr, int[] iArr2, List<SourceEntity> list) {
        }

        public void Hw(String str) {
        }

        public void j6(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        }

        public void DW(String str, long j, int i, int i2, int i3, List<SourceEntity> list) {
        }

        public void j6(String str, long j, int i, int i2, SourceEntity sourceEntity) {
            if (this.j6.DW != null) {
                try {
                    this.j6.DW.j6(str, j, i, i2, sourceEntity);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void j6(SourceEntity sourceEntity) {
            if (this.j6.FH != null) {
                try {
                    this.j6.FH.j6(sourceEntity);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void j6(String str, long j, int i, int i2) {
            if (this.j6.DW != null) {
                try {
                    this.j6.DW.j6(str, j, i, i2);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void j6(String str, int i, int i2, ac acVar) {
        }

        public void FH(String str, long j, int i, int i2) {
            if (this.j6.Hw != null) {
                try {
                    this.j6.Hw.j6(str, j, i, i2);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void j6(String str, long j, int i, int i2, int i3, SourceEntity sourceEntity, List<SourceEntity> list, String str2) {
            if (this.j6.Hw != null) {
                try {
                    this.j6.Hw.j6();
                    this.DW.clear();
                    for (SourceEntity add : list) {
                        this.DW.add(add);
                        if (this.DW.size() > 100) {
                            this.j6.Hw.j6(this.DW);
                            this.DW.clear();
                        }
                    }
                    this.j6.Hw.j6(this.DW);
                    this.j6.Hw.j6(str, j, i, i2, i3, sourceEntity, str2);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void j6(String str, long j) {
        }

        public void FH(String str) {
            if (this.j6.FH != null) {
                try {
                    this.j6.FH.j6(str);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void DW(String str, List<SourceEntity> list) {
            if (this.j6.FH != null) {
                try {
                    this.j6.FH.j6(str, list);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void j6(String str) {
        }

        public void j6(List<SourceEntity> list) {
        }
    }

    class 5 extends a {
        private EngineSolution DW;
        final /* synthetic */ CodeAnalysisEngineService j6;

        class 1 implements z {
            final /* synthetic */ 5 DW;
            final /* synthetic */ i j6;

            1(5 5, i iVar) {
                this.DW = 5;
                this.j6 = iVar;
            }

            public void j6(long j) {
            }

            public long j6() {
                try {
                    return this.j6.j6();
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                    return 0;
                }
            }

            public void j6(aa aaVar) {
                try {
                    aaVar.FH = this.j6.DW();
                    aaVar.DW = this.j6.FH();
                    if (aaVar.j6 == null || aaVar.j6.length < aaVar.DW) {
                        aaVar.j6 = new char[((aaVar.DW * 5) / 4)];
                    }
                    int i = 0;
                    while (true) {
                        CharArray j6 = this.j6.j6(i);
                        if (j6.DW > 0) {
                            char[] cArr = aaVar.j6;
                            char[] cArr2 = j6.j6;
                            int i2 = j6.DW;
                            int i3 = i;
                            i = 0;
                            while (i < i2) {
                                int i4 = i3 + 1;
                                cArr[i3] = cArr2[i];
                                i++;
                                i3 = i4;
                            }
                            i = i3;
                        } else {
                            return;
                        }
                    }
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        class 2 implements d {
            final /* synthetic */ 5 DW;
            final /* synthetic */ d j6;

            2(5 5, d dVar) {
                this.DW = 5;
                this.j6 = dVar;
            }

            public void gn() {
            }

            public void u7() {
            }

            public void Zo() {
            }

            public void VH() {
            }

            public void v5() {
            }

            public void j6() {
            }

            public void j6(String str, SyntaxError[] syntaxErrorArr) {
            }

            public void DW() {
            }

            public void DW(String str) {
            }

            public void FH() {
                try {
                    this.j6.j6();
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            public void j6(String str) {
                try {
                    this.j6.j6(str);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            public void Hw() {
                try {
                    this.j6.DW();
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            public void j6(String str, SyntaxError[] syntaxErrorArr, boolean z) {
                try {
                    this.j6.j6(str, syntaxErrorArr, z);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            public void FH(String str) {
                try {
                    this.j6.DW(str);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        class 3 implements com.aide.engine.a {
            final /* synthetic */ 5 DW;
            final /* synthetic */ a j6;

            3(5 5, a aVar) {
                this.DW = 5;
                this.j6 = aVar;
            }

            public void j6(Set<String> set, Map<String, byte[]> map) {
            }

            public void j6() {
            }

            public void j6(Set<String> set, Set<String> set2, Map<String, String> map) {
            }

            public void j6(boolean z) {
                try {
                    this.j6.j6(z);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            public void j6(IOException iOException) {
                try {
                    this.j6.j6(iOException.getMessage());
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        class 4 implements g {
            final /* synthetic */ 5 DW;
            private FileHighlightings FH;
            final /* synthetic */ g j6;

            4(5 5, g gVar) {
                this.DW = 5;
                this.j6 = gVar;
                this.FH = new FileHighlightings();
            }

            public void j6(String str, int i, long j, f[] fVarArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i2) {
                try {
                    this.FH.j6 = str;
                    this.FH.DW = fVarArr;
                    this.FH.FH = iArr;
                    this.FH.Hw = iArr2;
                    this.FH.v5 = iArr3;
                    this.FH.Zo = iArr4;
                    this.FH.VH = i2;
                    this.FH.gn = i;
                    this.j6.j6(this.FH);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            public void DW(String str, int i, long j, f[] fVarArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i2) {
                try {
                    this.FH.j6 = str;
                    this.FH.DW = fVarArr;
                    this.FH.FH = iArr;
                    this.FH.Hw = iArr2;
                    this.FH.v5 = iArr3;
                    this.FH.Zo = iArr4;
                    this.FH.VH = i2;
                    this.j6.DW(this.FH);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        class 5 implements ab {
            final /* synthetic */ 5 DW;
            final /* synthetic */ j j6;

            5(5 5, j jVar) {
                this.DW = 5;
                this.j6 = jVar;
            }

            public void j6(String str, Set<? extends bd> set) {
                try {
                    List arrayList = new ArrayList();
                    for (bd j6 : set) {
                        arrayList.add(j6.j6());
                    }
                    this.j6.j6(str, arrayList);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            public void j6() {
                EQ("This feature is not available here");
            }

            public void j6(String str, String str2, boolean z, String str3, int i, int i2, int i3) {
                DW(str, str2);
            }

            public void j6(List<Modification> list, List<String> list2) {
                Ws(list);
            }

            public void j6(String str) {
                EQ(str);
            }

            public void j6(x xVar) {
            }

            public void DW(List<Modification> list, List<String> list2) {
                Ws(list);
            }

            public void DW(String str) {
                EQ(str);
            }

            public void DW(List<Modification> list) {
                Ws(list);
            }

            public void j6(String str, String str2) {
            }

            public void FH(String str) {
                EQ(str);
            }

            public void FH(List<Modification> list) {
                Ws(list);
            }

            public void Hw(String str) {
                EQ(str);
            }

            public void v5(String str) {
                EQ(str);
            }

            public void Hw(List<Modification> list) {
                Ws(list);
            }

            public void Zo(String str) {
                EQ(str);
            }

            public void v5(List<Modification> list) {
                Ws(list);
            }

            public void Zo(List<Modification> list) {
                Ws(list);
            }

            public void VH(String str) {
                EQ(str);
            }

            public void VH(List<Modification> list) {
                Ws(list);
            }

            public void gn(String str) {
                EQ(str);
            }

            public void gn(List<Modification> list) {
                Ws(list);
            }

            public void u7(String str) {
                EQ(str);
            }

            public void u7(List<Modification> list) {
                Ws(list);
            }

            public void j6(String str, Hashtable<String, String[]> hashtable) {
                DW(str, (Hashtable) hashtable);
            }

            public void tp(List<Modification> list) {
                Ws(list);
            }

            public void tp(String str) {
                EQ(str);
            }

            public void EQ(List<Modification> list) {
                Ws(list);
            }

            public void we(List<Modification> list) {
                Ws(list);
            }

            public void J0(List<Modification> list) {
                Ws(list);
            }

            public void J8(List<Modification> list) {
                Ws(list);
            }

            public void j6(List<Modification> list) {
                Ws(list);
            }

            private void DW(String str, Hashtable<String, String[]> hashtable) {
                try {
                    this.j6.j6(str, (Map) hashtable);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            private void DW(String str, String str2) {
                try {
                    this.j6.j6(str, str2);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            private void EQ(String str) {
                try {
                    this.j6.j6(str);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            private void Ws(List<Modification> list) {
                try {
                    this.j6.j6((List) list);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        class 6 implements af {
            final /* synthetic */ 5 DW;
            final /* synthetic */ k j6;

            6(5 5, k kVar) {
                this.DW = 5;
                this.j6 = kVar;
            }

            public void j6(String str) {
                try {
                    this.j6.j6(str);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            public void j6() {
                try {
                    this.j6.j6();
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }

            public void j6(List<FindResult> list) {
                try {
                    this.j6.j6((List) list);
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                }
            }
        }

        5(CodeAnalysisEngineService codeAnalysisEngineService) {
            this.j6 = codeAnalysisEngineService;
        }

        public void j6(String str) {
            this.j6.j6.DW(str);
        }

        public void j6() {
            this.j6.j6.Hw();
        }

        public void DW() {
            this.j6.j6.j6();
        }

        public void FH() {
            this.j6.j6.v5();
        }

        public void Hw() {
            this.j6.j6.FH();
        }

        public void v5() {
            this.j6.j6.DW();
        }

        public void Zo() {
            this.j6.j6.gn();
        }

        public void j6(String str, int i) {
            this.j6.j6.j6(str, (long) i);
        }

        public void j6(String str, i iVar) {
            this.j6.j6.j6(str, new 1(this, iVar));
        }

        public void j6(String str, String str2) {
            this.j6.j6.j6(str, str2);
        }

        public void DW(String str) {
            this.j6.j6.j6(str);
        }

        public void VH() {
            this.j6.j6.Zo();
        }

        public void gn() {
            this.j6.j6.VH();
        }

        public void u7() {
            this.j6.j6.tp();
        }

        public void tp() {
            this.j6.j6.u7();
        }

        public void j6(EngineSolution engineSolution) {
            this.DW = engineSolution;
        }

        public void j6(EngineSolutionProject engineSolutionProject) {
            if (this.DW != null) {
                this.DW.j6(engineSolutionProject);
            }
        }

        public void EQ() {
            if (this.DW != null) {
                this.j6.j6.j6(this.DW);
            }
            this.DW = null;
        }

        public List j6(String str, int i, int i2, int i3) {
            return this.j6.j6.FH(str, i, i2, i3);
        }

        public List j6(String str, int i, int i2, char c, int i3) {
            return this.j6.j6.j6(str, i, i2, c, i3);
        }

        public List DW(String str, int i, int i2, int i3) {
            return this.j6.j6.j6(str, i, i2, i3);
        }

        public List FH(String str, int i, int i2, int i3) {
            return this.j6.j6.Hw(str, i, i2, i3);
        }

        public void j6(String str, int i, int i2) {
            this.j6.j6.j6(str, i, i2);
        }

        public void j6(SyntaxError syntaxError, int i) {
            this.j6.j6.j6(syntaxError, i);
        }

        public void j6(String str, int i, int i2, int i3, int i4) {
            this.j6.j6.DW(str, i, i2, i3, i4);
        }

        public void DW(String str, int i, int i2, int i3, int i4) {
            this.j6.j6.j6(str, i, i2, i3, i4);
        }

        public void DW(String str, int i) {
            this.j6.j6.DW(str, i);
        }

        public void FH(String str, int i) {
            this.j6.j6.j6(str, i);
        }

        public void j6(SourceEntity sourceEntity) {
            this.j6.j6.j6(sourceEntity);
        }

        public void j6(String str, SourceEntity sourceEntity) {
            this.j6.j6.j6(str, sourceEntity);
        }

        public void FH(String str, int i, int i2, int i3, int i4) {
            this.j6.j6.Zo(str, i, i2, i3, i4);
        }

        public void Hw(String str, int i, int i2, int i3, int i4) {
            this.j6.j6.v5(str, i, i2, i3, i4);
        }

        public void j6(String str, int i, int i2, int i3, int i4, String str2, String str3) {
            this.j6.j6.j6(str, i, i2, i3, i4, str2, str3);
        }

        public void v5(String str, int i, int i2, int i3, int i4) {
            this.j6.j6.FH(str, i, i2, i3, i4);
        }

        public void Hw(String str, int i) {
            this.j6.j6.FH(str, i);
        }

        public void Hw(String str, int i, int i2, int i3) {
            this.j6.j6.DW(str, i, i2, i3);
        }

        public void DW(String str, int i, int i2) {
            this.j6.j6.FH(str, i, i2);
        }

        public void Zo(String str, int i, int i2, int i3, int i4) {
            this.j6.j6.Hw(str, i, i2, i3, i4);
        }

        public void j6(String str, String str2, int i, int i2, int i3, int i4) {
            this.j6.j6.j6(str, str2, i, i2, i3, i4);
        }

        public void j6(String str, Map map) {
            this.j6.j6.j6(str, new Hashtable(map));
        }

        public void FH(String str, int i, int i2) {
            this.j6.j6.v5(str, i, i2);
        }

        public void Hw(String str, int i, int i2) {
            this.j6.j6.Zo(str, i, i2);
        }

        public void DW(String str, String str2) {
            this.j6.j6.DW(str, str2);
        }

        public void v5(String str, int i, int i2) {
            this.j6.j6.Hw(str, i, i2);
        }

        public void j6(String str, int i, int i2, boolean z) {
            this.j6.j6.j6(str, i, i2, z);
        }

        public void Zo(String str, int i, int i2) {
            this.j6.j6.DW(str, i, i2);
        }

        public void FH(String str) {
            this.j6.j6.FH(str);
        }

        public void j6(String str, String str2, int i) {
            this.j6.j6.j6(str, str2, i);
        }

        public void j6(d dVar) {
            this.j6.j6.j6(new 2(this, dVar));
        }

        public void j6(a aVar) {
            this.j6.j6.j6(new 3(this, aVar));
        }

        public void j6(g gVar) {
            this.j6.j6.j6(new 4(this, gVar));
        }

        public void j6(j jVar) {
            this.j6.j6.j6(new 5(this, jVar));
        }

        public void j6(k kVar) {
            this.j6.j6.j6(new 6(this, kVar));
        }

        public void j6(h hVar) {
            this.j6.DW = hVar;
        }

        public void j6(c cVar) {
            this.j6.Hw = cVar;
        }

        public void j6(f fVar) {
            this.j6.FH = fVar;
        }

        public void j6(e eVar) {
            this.j6.v5 = eVar;
        }

        public void j6(int i, int i2, Map map, Map map2) {
            Map hashMap = new HashMap();
            Set hashSet = new HashSet();
            for (String valueOf : (List) map2.get("Java")) {
                hashSet.add(gf.valueOf(valueOf));
            }
            hashMap.put("Java", hashSet);
            hashSet = new HashSet();
            for (String valueOf2 : (List) map2.get("JavaScript")) {
                hashSet.add(hh.valueOf(valueOf2));
            }
            hashMap.put("JavaScript", hashSet);
            this.j6.j6.j6(false, false, false, false, i, "", new String[0], new boolean[0], i2, map, hashMap);
        }

        public void j6(String str, int i, int i2, SourceEntity sourceEntity) {
            this.j6.j6.j6(str, i, i2, sourceEntity);
        }
    }

    public void onDestroy() {
        com.aide.common.e.DW("Engine service destroyed - pid " + Process.myPid() + " id " + System.identityHashCode(this));
        this.j6.j6();
        this.j6 = null;
    }

    public IBinder onBind(Intent intent) {
        com.aide.common.e.DW("Engine service bound - pid " + Process.myPid() + " id " + System.identityHashCode(this));
        if (VERSION.RELEASE.startsWith("4.4.")) {
            startForeground(9973, new Builder(this).j6(System.currentTimeMillis()).j6(17301625).j6((CharSequence) "Code Analysis").DW((CharSequence) "Code analysis engine is active").j6(MainActivity.v5((Context) this)).Hw(-2).j6());
        }
        ep.j6(new 1(this));
        return this.Zo;
    }

    public void onCreate() {
        super.onCreate();
        Native.j6.init(this);
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        com.aide.common.e.DW("onTrimMemory - level: " + i);
    }

    public CodeAnalysisEngineService() {
        this.Zo = new 5(this);
        this.j6 = new b(new 2(this));
        this.j6.j6(new 3(this));
        this.j6.j6(new 4(this));
    }
}
