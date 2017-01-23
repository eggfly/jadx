package com.aide.engine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.engine.EngineSolution;
import com.aide.engine.EngineSolutionProject;
import com.aide.engine.SourceEntity;
import com.aide.engine.SyntaxError;
import com.aide.uidesigner.ProxyTextView;
import java.util.List;
import java.util.Map;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        private static class a implements b {
            private IBinder j6;

            a(IBinder iBinder) {
                this.j6 = iBinder;
            }

            public IBinder asBinder() {
                return this.j6;
            }

            public void j6(e eVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (eVar != null) {
                        iBinder = eVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(EngineSolution engineSolution) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (engineSolution != null) {
                        obtain.writeInt(1);
                        engineSolution.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(EngineSolutionProject engineSolutionProject) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (engineSolutionProject != null) {
                        obtain.writeInt(1);
                        engineSolutionProject.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void EQ() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(int i, int i2, Map map, Map map2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeMap(map);
                    obtain.writeMap(map2);
                    this.j6.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void VH() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gn() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void u7() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void tp() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void FH() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Hw() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void v5() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Zo() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    this.j6.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.j6.transact(16, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.j6.transact(17, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, i iVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    if (iVar != null) {
                        iBinder = iVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(18, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    this.j6.transact(19, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(d dVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (dVar != null) {
                        iBinder = dVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(20, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(a aVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(21, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(j jVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (jVar != null) {
                        iBinder = jVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(22, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(g gVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (gVar != null) {
                        iBinder = gVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(23, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(k kVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (kVar != null) {
                        iBinder = kVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(24, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(h hVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (hVar != null) {
                        iBinder = hVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(25, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(c cVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(26, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(f fVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (fVar != null) {
                        iBinder = fVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.j6.transact(27, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Hw(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.j6.transact(28, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public List j6(String str, int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.j6.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List j6(String str, int i, int i2, char c, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(c);
                    obtain.writeInt(i3);
                    this.j6.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List DW(String str, int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.j6.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List FH(String str, int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.j6.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j6(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.j6.transact(33, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(SyntaxError syntaxError, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (syntaxError != null) {
                        obtain.writeInt(1);
                        syntaxError.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.j6.transact(34, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, int i, int i2, int i3, int i4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.j6.transact(35, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW(String str, int i, int i2, int i3, int i4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.j6.transact(36, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.j6.transact(37, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void FH(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.j6.transact(38, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(SourceEntity sourceEntity) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (sourceEntity != null) {
                        obtain.writeInt(1);
                        sourceEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(39, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void FH(String str, int i, int i2, int i3, int i4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.j6.transact(40, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Hw(String str, int i, int i2, int i3, int i4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.j6.transact(41, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void v5(String str, int i, int i2, int i3, int i4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.j6.transact(42, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, int i, int i2, int i3, int i4, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.j6.transact(43, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Hw(String str, int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.j6.transact(44, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.j6.transact(45, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Zo(String str, int i, int i2, int i3, int i4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.j6.transact(46, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, Map map) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.j6.transact(47, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, String str2, int i, int i2, int i3, int i4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.j6.transact(48, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void FH(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.j6.transact(49, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Hw(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.j6.transact(50, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void DW(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.j6.transact(51, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void v5(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.j6.transact(52, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, int i, int i2, boolean z) {
                int i3 = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!z) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.j6.transact(53, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    this.j6.transact(54, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Zo(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.j6.transact(55, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void FH(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    this.j6.transact(56, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, String str2, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.j6.transact(57, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, SourceEntity sourceEntity) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    if (sourceEntity != null) {
                        obtain.writeInt(1);
                        sourceEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(58, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void j6(String str, int i, int i2, SourceEntity sourceEntity) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.aide.engine.service.ICodeAnalysisEngineService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (sourceEntity != null) {
                        obtain.writeInt(1);
                        sourceEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.j6.transact(59, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.aide.engine.service.ICodeAnalysisEngineService");
        }

        public static b j6(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.aide.engine.service.ICodeAnalysisEngineService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            SourceEntity sourceEntity = null;
            List j6;
            String readString;
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(com.aide.engine.service.e.a.j6(parcel.readStrongBinder()));
                    return true;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    EngineSolution engineSolution;
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (parcel.readInt() != 0) {
                        engineSolution = (EngineSolution) EngineSolution.CREATOR.createFromParcel(parcel);
                    }
                    j6(engineSolution);
                    return true;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    EngineSolutionProject engineSolutionProject;
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (parcel.readInt() != 0) {
                        engineSolutionProject = (EngineSolutionProject) EngineSolutionProject.CREATOR.createFromParcel(parcel);
                    }
                    j6(engineSolutionProject);
                    return true;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    EQ();
                    return true;
                case 5:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    int readInt = parcel.readInt();
                    int readInt2 = parcel.readInt();
                    ClassLoader classLoader = getClass().getClassLoader();
                    j6(readInt, readInt2, parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
                    return true;
                case 6:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    VH();
                    return true;
                case 7:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    gn();
                    return true;
                case 8:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    u7();
                    return true;
                case 9:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    tp();
                    return true;
                case 10:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6();
                    return true;
                case 11:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    DW();
                    return true;
                case 12:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    FH();
                    return true;
                case 13:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    Hw();
                    return true;
                case 14:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    v5();
                    return true;
                case 15:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    Zo();
                    return true;
                case 16:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), parcel.readInt());
                    return true;
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), parcel.readString());
                    return true;
                case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), com.aide.engine.service.i.a.j6(parcel.readStrongBinder()));
                    return true;
                case 19:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    DW(parcel.readString());
                    return true;
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(com.aide.engine.service.d.a.j6(parcel.readStrongBinder()));
                    return true;
                case 21:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(com.aide.engine.service.a.a.j6(parcel.readStrongBinder()));
                    return true;
                case 22:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(com.aide.engine.service.j.a.j6(parcel.readStrongBinder()));
                    return true;
                case 23:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(com.aide.engine.service.g.a.j6(parcel.readStrongBinder()));
                    return true;
                case 24:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(com.aide.engine.service.k.a.j6(parcel.readStrongBinder()));
                    return true;
                case 25:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(com.aide.engine.service.h.a.j6(parcel.readStrongBinder()));
                    return true;
                case 26:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(com.aide.engine.service.c.a.j6(parcel.readStrongBinder()));
                    return true;
                case 27:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(com.aide.engine.service.f.a.j6(parcel.readStrongBinder()));
                    return true;
                case 28:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    Hw(parcel.readString(), parcel.readInt());
                    return true;
                case 29:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6 = j6(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeList(j6);
                    return true;
                case 30:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6 = j6(parcel.readString(), parcel.readInt(), parcel.readInt(), (char) parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeList(j6);
                    return true;
                case 31:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6 = DW(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeList(j6);
                    return true;
                case 32:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6 = FH(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeList(j6);
                    return true;
                case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), parcel.readInt(), parcel.readInt());
                    return true;
                case 34:
                    SyntaxError syntaxError;
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (parcel.readInt() != 0) {
                        syntaxError = (SyntaxError) SyntaxError.CREATOR.createFromParcel(parcel);
                    }
                    j6(syntaxError, parcel.readInt());
                    return true;
                case 35:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case ProxyTextView.INPUTTYPE_time /*36*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    DW(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 37:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    DW(parcel.readString(), parcel.readInt());
                    return true;
                case 38:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    FH(parcel.readString(), parcel.readInt());
                    return true;
                case 39:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    if (parcel.readInt() != 0) {
                        sourceEntity = (SourceEntity) SourceEntity.CREATOR.createFromParcel(parcel);
                    }
                    j6(sourceEntity);
                    return true;
                case 40:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    FH(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 41:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    Hw(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 42:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    v5(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 43:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                    return true;
                case 44:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    Hw(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 45:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    DW(parcel.readString(), parcel.readInt(), parcel.readInt());
                    return true;
                case 46:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    Zo(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 47:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    return true;
                case 48:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    FH(parcel.readString(), parcel.readInt(), parcel.readInt());
                    return true;
                case 50:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    Hw(parcel.readString(), parcel.readInt(), parcel.readInt());
                    return true;
                case 51:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    DW(parcel.readString(), parcel.readString());
                    return true;
                case 52:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    v5(parcel.readString(), parcel.readInt(), parcel.readInt());
                    return true;
                case 53:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case 54:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString());
                    return true;
                case 55:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    Zo(parcel.readString(), parcel.readInt(), parcel.readInt());
                    return true;
                case 56:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    FH(parcel.readString());
                    return true;
                case 57:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    j6(parcel.readString(), parcel.readString(), parcel.readInt());
                    return true;
                case 58:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        sourceEntity = (SourceEntity) SourceEntity.CREATOR.createFromParcel(parcel);
                    }
                    j6(readString, sourceEntity);
                    return true;
                case 59:
                    parcel.enforceInterface("com.aide.engine.service.ICodeAnalysisEngineService");
                    readString = parcel.readString();
                    int readInt3 = parcel.readInt();
                    int readInt4 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        sourceEntity = (SourceEntity) SourceEntity.CREATOR.createFromParcel(parcel);
                    }
                    j6(readString, readInt3, readInt4, sourceEntity);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.aide.engine.service.ICodeAnalysisEngineService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    List DW(String str, int i, int i2, int i3);

    void DW();

    void DW(String str);

    void DW(String str, int i);

    void DW(String str, int i, int i2);

    void DW(String str, int i, int i2, int i3, int i4);

    void DW(String str, String str2);

    void EQ();

    List FH(String str, int i, int i2, int i3);

    void FH();

    void FH(String str);

    void FH(String str, int i);

    void FH(String str, int i, int i2);

    void FH(String str, int i, int i2, int i3, int i4);

    void Hw();

    void Hw(String str, int i);

    void Hw(String str, int i, int i2);

    void Hw(String str, int i, int i2, int i3);

    void Hw(String str, int i, int i2, int i3, int i4);

    void VH();

    void Zo();

    void Zo(String str, int i, int i2);

    void Zo(String str, int i, int i2, int i3, int i4);

    void gn();

    List j6(String str, int i, int i2, char c, int i3);

    List j6(String str, int i, int i2, int i3);

    void j6();

    void j6(int i, int i2, Map map, Map map2);

    void j6(EngineSolution engineSolution);

    void j6(EngineSolutionProject engineSolutionProject);

    void j6(SourceEntity sourceEntity);

    void j6(SyntaxError syntaxError, int i);

    void j6(a aVar);

    void j6(c cVar);

    void j6(d dVar);

    void j6(e eVar);

    void j6(f fVar);

    void j6(g gVar);

    void j6(h hVar);

    void j6(j jVar);

    void j6(k kVar);

    void j6(String str);

    void j6(String str, int i);

    void j6(String str, int i, int i2);

    void j6(String str, int i, int i2, int i3, int i4);

    void j6(String str, int i, int i2, int i3, int i4, String str2, String str3);

    void j6(String str, int i, int i2, SourceEntity sourceEntity);

    void j6(String str, int i, int i2, boolean z);

    void j6(String str, SourceEntity sourceEntity);

    void j6(String str, i iVar);

    void j6(String str, String str2);

    void j6(String str, String str2, int i);

    void j6(String str, String str2, int i, int i2, int i3, int i4);

    void j6(String str, Map map);

    void tp();

    void u7();

    void v5();

    void v5(String str, int i, int i2);

    void v5(String str, int i, int i2, int i3, int i4);
}
