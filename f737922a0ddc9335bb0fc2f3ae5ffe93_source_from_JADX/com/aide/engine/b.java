package com.aide.engine;

import ba;
import bd;
import bh;
import bj;
import bl;
import bp;
import bq;
import br;
import bs;
import bv;
import bz;
import cj;
import cm;
import co;
import com.aide.common.e;
import com.aide.engine.FindResult.Highlighting;
import com.aide.uidesigner.ProxyTextView;
import cp;
import cq;
import cr;
import cs;
import ct;
import cu;
import cv;
import cw;
import cx;
import cy;
import cz;
import da;
import db;
import dc;
import dd;
import de;
import df;
import dh;
import dj;
import ea;
import eb;
import ee;
import ef;
import ej;
import eq;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class b {
    private static final boolean j6;
    private String AE;
    private int AL;
    private Stack<Integer> AR;
    private int Ak;
    private int An;
    private String BR;
    private boolean BT;
    private String[] Bx;
    private String CU;
    private SyntaxError Cz;
    private HashMap<String, String> DW;
    private List<v> E4;
    private g EQ;
    private Stack<l> Ej;
    private int Eq;
    private boolean Ev;
    private af FH;
    private boolean FN;
    private List<k> Fd;
    private k GK;
    private String GT;
    private String Gj;
    private int Hl;
    private ab Hw;
    private boolean I;
    private int IS;
    private j J0;
    private boolean J8;
    private int Jl;
    private x Jm;
    private boolean KD;
    private HashMap<String, List<Object>> Lz;
    private SourceEntity MP;
    private EngineSolution Mr;
    private boolean Mz;
    private String N0;
    private int Nh;
    private boolean OW;
    private boolean[] Od;
    private List<Modification> Of;
    private boolean P8;
    private v PH;
    private Stack<String> PT;
    private int Pa;
    private String Q6;
    private String QO;
    private long QX;
    private boolean Qq;
    private boolean SI;
    private boolean Sf;
    private bq T6;
    private Stack<Reader> TI;
    private Hashtable<String, z> U2;
    private ad VH;
    private String WB;
    private String Ws;
    private boolean XG;
    private Object XL;
    private boolean XX;
    private int Xa;
    private v Yi;
    private int Z1;
    private int Za;
    private d Zo;
    private int a5;
    private boolean a8;
    private Object aM;
    private c aX;
    private boolean aj;
    private boolean aq;
    private String b;
    private Stack<String> b1;
    private int ba;
    private boolean br;
    private String cT;
    private boolean ca;
    private boolean cb;
    private String[] cc;
    private int ce;
    private boolean cn;
    private List<v> ct;
    private String d8;
    private k dW;
    private boolean dx;
    private int e3;
    private String e9;
    private List<String> eN;
    private int eU;
    private boolean ef;
    private boolean ei;
    private int er;
    private String et;
    private int fN;
    private Map<String, String> fP;
    private int fY;
    private e fh;
    private boolean g3;
    private int gG;
    private boolean gW;
    private y gn;
    private String hK;
    private List<List<w>> hp;
    private int hz;
    private boolean iK;
    private String iW;
    private Object j3;
    private boolean jJ;
    private boolean jO;
    private String jw;
    private int k1;
    private a k2;
    private boolean kQ;
    private int kf;
    private boolean ko;
    private boolean lg;
    private boolean lp;
    private boolean mb;
    private SourceEntity n5;
    private int nl;
    private boolean nw;
    private boolean oY;
    private String oa;
    private String oh;
    private int om;
    private List<String> oy;
    private int pN;
    private int pO;
    private int pl;
    private int q7;
    private Hashtable<String, String> qP;
    private int qp;
    private boolean rN;
    private boolean ro;
    private int sE;
    private boolean sG;
    private String sM;
    private List<v> sT;
    private int sg;
    private boolean sh;
    private boolean sy;
    private int ti;
    private ae tp;
    private a u7;
    private int u9;
    private c v5;
    private boolean vJ;
    private boolean vy;
    private int w9;
    private int wE;
    private boolean wc;
    private i we;
    private boolean x9;
    private List<k> xg;
    private boolean yO;
    private boolean yS;
    private boolean ye;
    private int ys;
    private List<SourceEntity> zf;
    private a zh;

    static /* synthetic */ class 1 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[c.values().length];
            try {
                j6[c.AUTOFORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[c.AUTOINDENTAFTERPASTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                j6[c.LEARN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                j6[c.INDENT_AFTER_ENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                j6[c.INDENT_AFTER_TYPING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                j6[c.OUTCOMMENT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                j6[c.AUTOFORMAT_ASYNC.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                j6[c.UNOUTCOMMENT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private enum a {
        MEMBERS,
        UPDATE_MEMBERS_AFTER_EVENT,
        UPDATE_MEMBERS_AFTER_CHAREVENT,
        PARAMETERS,
        PARAMETERS_AFTER_EVENT,
        PARAMETERS_AFTER_CHAREVENT,
        EXPRESSION_MEMBERS,
        UPDATE_EXPRESSION_MEMBERS_AFTER_EVENT,
        UPDATE_EXPRESSION_MEMBERS_AFTER_CHAREVENT,
        FULL_TYPE,
        SUPER_METHODS
    }

    private class b implements Runnable {
        private EngineSolution DW;
        private p EQ;
        private ba FH;
        private h Hw;
        private a J0;
        private d J8;
        private boolean Mr;
        private n QX;
        private boolean U2;
        private e VH;
        private o Ws;
        private f XL;
        private k Zo;
        private int a8;
        private g aM;
        private eb er;
        private boolean gW;
        private l gn;
        private m j3;
        final /* synthetic */ b j6;
        private eb lg;
        private eb rN;
        private i tp;
        private b u7;
        private j v5;
        private c we;
        private dh yS;

        private class a implements cq {
            private ArrayList<SourceEntity> DW;
            final /* synthetic */ b j6;

            private a(b bVar) {
                this.j6 = bVar;
            }

            public void j6(bs bsVar) {
                SourceEntity sourceEntity = new SourceEntity(this.j6.FH, bsVar);
                sourceEntity.DW(this.j6.FH);
                this.DW.add(sourceEntity);
            }

            public void DW() {
                this.DW = new ArrayList();
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.j6("");
                }
            }

            public void j6(String str) {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.j6(str);
                }
            }

            public void j6() {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.j6(this.DW);
                }
                this.DW = null;
            }
        }

        private class b implements cr {
            private ArrayList<SourceEntity> DW;
            private boolean EQ;
            private ArrayList<SourceEntity> FH;
            private bs Hw;
            private long J0;
            private Map<bp, SourceEntity> J8;
            private boolean VH;
            private ArrayList<SourceEntity> Zo;
            private bp gn;
            final /* synthetic */ b j6;
            private ArrayList<SourceEntity> tp;
            private long u7;
            private String v5;
            private bp we;

            private b(b bVar) {
                this.j6 = bVar;
                this.DW = new ArrayList();
                this.FH = new ArrayList();
                this.Zo = new ArrayList();
                this.tp = new ArrayList();
                this.J8 = new HashMap();
            }

            public void j6(bs bsVar, co coVar) {
                SourceEntity sourceEntity = new SourceEntity(this.j6.FH, bsVar);
                sourceEntity.j6(this.j6.FH, coVar);
                sourceEntity.j6();
                j6(sourceEntity);
            }

            public void j6(bv bvVar, int i, int i2) {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.FH(bvVar.er(), bvVar.aM(), i, i2);
                }
            }

            public void j6(bs bsVar, boolean z) {
                j6(new SourceEntity(this.j6.FH, bsVar, z));
            }

            private void j6(SourceEntity sourceEntity) {
                if (this.EQ) {
                    this.tp.add(sourceEntity);
                }
                if (this.VH) {
                    this.Zo.add(sourceEntity);
                }
                this.FH.add(sourceEntity);
            }

            public void j6(bs bsVar, String str) {
                j6(new SourceEntity(this.j6.FH, bsVar, str));
            }

            public void j6(bp bpVar) {
                SourceEntity sourceEntity;
                if (bpVar.tp().J8()) {
                    sourceEntity = (SourceEntity) this.J8.get(bpVar);
                    if (sourceEntity == null) {
                        sourceEntity = new SourceEntity(this.j6.FH, (bs) bpVar);
                        sourceEntity.j6(this.j6.FH);
                        this.J8.put(bpVar, sourceEntity);
                    }
                    j6(sourceEntity);
                    return;
                }
                sourceEntity = new SourceEntity(this.j6.FH, (bs) bpVar);
                sourceEntity.j6(this.j6.FH);
                j6(sourceEntity);
            }

            public void DW(bs bsVar) {
                j6(new SourceEntity(this.j6.FH, bsVar));
            }

            public void j6(bs bsVar) {
                this.Hw = bsVar;
            }

            public void DW(String str) {
                this.v5 = str;
            }

            public void j6(bs bsVar, co coVar, boolean z) {
                SourceEntity sourceEntity = new SourceEntity(this.j6.FH, bsVar, z);
                sourceEntity.j6(this.j6.FH, coVar);
                j6(sourceEntity);
            }

            public void j6(cp cpVar) {
                j6(new SourceEntity(this.j6.FH, false, cpVar));
            }

            public void j6(String str) {
                j6(new SourceEntity(str, true));
            }

            public void FH(String str) {
                j6(new SourceEntity(str));
            }

            public void j6(bv bvVar) {
                String er = bvVar.er();
                long aM = bvVar.aM();
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.j6(er, aM);
                }
            }

            public void j6() {
                this.Hw = null;
                this.v5 = null;
                this.FH = new ArrayList();
                DW();
            }

            private void DW() {
                this.EQ = false;
                this.VH = false;
            }

            public void j6(bv bvVar, bj bjVar, int i, int i2, int i3, boolean z, boolean z2) {
                String er = bvVar.er();
                long aM = bvVar.aM();
                if (this.FH.size() != 0) {
                    SourceEntity sourceEntity = null;
                    if (this.Hw != null) {
                        sourceEntity = new SourceEntity(this.j6.FH, this.Hw);
                    } else if (this.v5 != null) {
                        sourceEntity = new SourceEntity(this.v5);
                    }
                    if (this.j6.j6.VH == null) {
                        return;
                    }
                    if (z) {
                        this.j6.j6.VH.j6(er, aM, i, i2, i3, this.FH);
                    } else if (z2) {
                        this.j6.j6.VH.DW(er, aM, i, i2, i3, this.FH);
                    } else {
                        this.j6.j6.VH.j6(er, aM, i, i2, i3, sourceEntity, this.FH, bjVar.j6());
                    }
                } else if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.FH(er, aM, i, i2);
                }
            }

            public void j6(co coVar) {
                this.DW.add(new SourceEntity(this.j6.FH, (bs) coVar));
            }

            public void j6(List<cp> list) {
                this.DW.add(new SourceEntity(this.j6.FH, (List) list));
            }

            public void DW(bs bsVar, co coVar) {
                SourceEntity sourceEntity = new SourceEntity(this.j6.FH, bsVar);
                sourceEntity.DW(this.j6.FH, coVar);
                this.DW.add(sourceEntity);
            }

            public void j6(bv bvVar, int i, int i2, int[] iArr, int[] iArr2) {
                if (this.DW.size() == 0) {
                    if (this.j6.j6.VH != null) {
                        this.j6.j6.VH.DW(bvVar.er(), bvVar.aM(), i, i2);
                    }
                } else if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.j6(bvVar.er(), bvVar.aM(), i, i2, iArr, iArr2, this.DW);
                }
                this.DW = new ArrayList();
            }

            public void DW(bv bvVar, int i, int i2) {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.DW(bvVar.er(), bvVar.aM(), i, i2);
                }
            }

            public boolean DW(cj cjVar, bp bpVar) {
                DW();
                if (this.we != null && this.we == bpVar && this.J0 == cjVar.v5()) {
                    this.FH.addAll(this.tp);
                    return false;
                }
                this.we = bpVar;
                this.J0 = cjVar.v5();
                this.tp.clear();
                this.EQ = true;
                return true;
            }

            public boolean j6(cj cjVar, bp bpVar) {
                DW();
                if (this.gn != null && this.gn == bpVar && this.u7 == cjVar.v5()) {
                    this.FH.addAll(this.Zo);
                    return false;
                }
                this.gn = bpVar;
                this.u7 = cjVar.v5();
                this.Zo.clear();
                this.VH = true;
                return true;
            }
        }

        private class c implements cs {
            final /* synthetic */ b j6;

            private c(b bVar) {
                this.j6 = bVar;
            }

            public void DW(bv bvVar, long j, int i, int i2, int i3, int i4, int i5, int i6) {
                this.j6.j6.gn.DW(bvVar.er(), j, i, i2, i3, i4, i5, i6);
            }

            public void j6(long j, int i, int i2, int i3, int i4, int i5, int i6) {
                this.j6.j6.gn.j6(j, i, i2, i3, i4, i5, i6);
            }

            public void j6(bv bvVar, long j, int i, int i2, int i3, int i4, int i5, int i6) {
                this.j6.j6.gn.j6(bvVar.er(), j, i, i2, i3, i4, i5, i6);
            }

            public void j6() {
                this.j6.j6.gn.j6();
            }
        }

        private class d implements ct {
            final /* synthetic */ b j6;

            private d(b bVar) {
                this.j6 = bVar;
            }

            public void j6(boolean z, String str, String str2, String str3, int i) {
                List arrayList = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(0, this.j6.j6.Ej.pop());
                }
                this.j6.j6.Ej.push(new r(z, str, str2, str3, arrayList, (l) this.j6.j6.Ej.pop()));
            }

            public void DW() {
                this.j6.j6.Ej.push(new n((l) this.j6.j6.Ej.pop()));
            }

            public void j6(Class cls, Class cls2) {
                this.j6.j6.Ej.push(new s((l) this.j6.j6.Ej.pop(), cls, cls2));
            }

            public void DW(String str) {
                l lVar = (l) this.j6.j6.Ej.pop();
                this.j6.j6.Ej.push(new o(lVar, (l) this.j6.j6.Ej.pop(), str));
            }

            public void j6() {
                l lVar = (l) this.j6.j6.Ej.pop();
                this.j6.j6.Ej.push(new m(lVar, (l) this.j6.j6.Ej.pop()));
            }

            public void j6(String str) {
                this.j6.j6.Ej.push(new t((l) this.j6.j6.Ej.pop(), str));
            }

            public void j6(Object obj) {
                this.j6.j6.Ej.push(new p(obj));
            }

            public void FH(String str) {
                this.j6.j6.Ej.push(new u(str));
            }

            public void j6(boolean z, boolean z2, String str, String str2) {
                this.j6.j6.Ej.push(new q(z, z2, str, str2, (l) this.j6.j6.Ej.pop()));
            }
        }

        private class e implements cu {
            private int DW;
            private f[] FH;
            private int[] Hw;
            private int[] VH;
            private int[] Zo;
            final /* synthetic */ b j6;
            private int[] v5;

            private e(b bVar) {
                this.j6 = bVar;
                this.FH = new f[10000];
                this.Hw = new int[10000];
                this.v5 = new int[10000];
                this.Zo = new int[10000];
                this.VH = new int[10000];
            }

            public void j6() {
                this.DW = 0;
            }

            public void j6(bj bjVar, cm cmVar) {
                int i = 0;
                j6(this.DW + cmVar.u7);
                System.arraycopy(cmVar.FH, 0, this.Hw, this.DW, cmVar.u7);
                System.arraycopy(cmVar.Hw, 0, this.Zo, this.DW, cmVar.u7);
                System.arraycopy(cmVar.v5, 0, this.v5, this.DW, cmVar.u7);
                System.arraycopy(cmVar.Zo, 0, this.VH, this.DW, cmVar.u7);
                bl Hw = bjVar.Hw();
                while (i < cmVar.u7) {
                    int i2 = cmVar.j6[i];
                    if (cmVar.FH[i] <= 0 || cmVar.Hw[i] <= 0) {
                        this.FH[this.DW] = null;
                    } else {
                        this.FH[this.DW] = this.j6.j6(Hw, i2);
                    }
                    this.DW++;
                    i++;
                }
            }

            public void j6(bv bvVar, int i) {
                if (this.j6.j6.EQ != null) {
                    this.j6.j6.EQ.j6(bvVar.er(), i, bvVar.aM(), this.FH, this.Hw, this.v5, this.Zo, this.VH, this.DW);
                }
            }

            private void j6(int i) {
                if (this.FH.length <= i) {
                    int i2 = (i * 5) / 4;
                    Object obj = new f[i2];
                    System.arraycopy(this.FH, 0, obj, 0, this.DW);
                    this.FH = obj;
                    obj = new int[i2];
                    System.arraycopy(this.Hw, 0, obj, 0, this.DW);
                    this.Hw = obj;
                    obj = new int[i2];
                    System.arraycopy(this.Zo, 0, obj, 0, this.DW);
                    this.Zo = obj;
                    obj = new int[i2];
                    System.arraycopy(this.v5, 0, obj, 0, this.DW);
                    this.v5 = obj;
                    Object obj2 = new int[i2];
                    System.arraycopy(this.VH, 0, obj2, 0, this.DW);
                    this.VH = obj2;
                }
            }

            public void DW() {
                this.DW = 0;
            }

            private void j6(f fVar, int i, int i2, int i3, int i4) {
                j6(this.DW + 1);
                if (i > 0) {
                    this.FH[this.DW] = fVar;
                    this.Hw[this.DW] = i;
                    this.v5[this.DW] = i2;
                    this.Zo[this.DW] = i3;
                    this.VH[this.DW] = i4;
                    this.DW++;
                }
            }

            public void j6(bj bjVar, int i, int i2, int i3, int i4) {
                j6(f.DELEGATE_IDENTIFIER, i, i2, i3, i4);
            }

            public void DW(bj bjVar, int i, int i2, int i3, int i4) {
                j6(f.KEYWORD, i, i2, i3, i4);
            }

            public void FH(bj bjVar, int i, int i2, int i3, int i4) {
                j6(f.IDENTIFIER, i, i2, i3, i4);
            }

            public void Hw(bj bjVar, int i, int i2, int i3, int i4) {
                j6(f.NAMESPACE_IDENTIFIER, i, i2, i3, i4);
            }

            public void v5(bj bjVar, int i, int i2, int i3, int i4) {
                j6(f.TYPE_IDENTIFIER, i, i2, i3, i4);
            }

            public void j6(bv bvVar) {
                if (this.j6.j6.EQ != null) {
                    this.j6.j6.EQ.DW(bvVar.er(), 0, bvVar.aM(), this.FH, this.Hw, this.v5, this.Zo, this.VH, this.DW);
                }
            }
        }

        private class f implements cv {
            final /* synthetic */ b j6;

            private f(b bVar) {
                this.j6 = bVar;
            }

            public void j6(bv bvVar, String str) {
                if (this.j6.j6.we != null) {
                    this.j6.j6.we.j6(bvVar.er(), str);
                }
            }
        }

        private class g implements cw {
            final /* synthetic */ b j6;

            private g(b bVar) {
                this.j6 = bVar;
            }

            public Reader j6(InputStream inputStream, String str) {
                if (this.j6.j6.J0 != null) {
                    return this.j6.j6.J0.j6(inputStream, str);
                }
                String str2;
                InputStream pushbackInputStream = new PushbackInputStream(inputStream, 4);
                byte[] bArr = new byte[4];
                int i = 0;
                while (i < 4) {
                    int read = pushbackInputStream.read(bArr, i, 4 - i);
                    if (read == -1) {
                        break;
                    }
                    i = read + i;
                }
                String str3 = null;
                if (i == 4) {
                    if ((bArr[0] & 255) == 0 && (bArr[1] & 255) == 0 && (bArr[2] & 255) == 254 && (bArr[3] & 255) == 255) {
                        str3 = "UTF-32BE";
                    } else if ((bArr[0] & 255) == 255 && (bArr[1] & 255) == 254 && (bArr[2] & 255) == 0 && (bArr[3] & 255) == 0) {
                        str3 = "UTF-32LE";
                    }
                }
                if (str3 == null && i >= 3 && (bArr[0] & 255) == 239 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191) {
                    str3 = b.j6 ? "UTF8" : "UTF-8";
                    pushbackInputStream.unread(bArr, 3, i - 3);
                }
                if (str3 == null && i >= 2) {
                    if ((bArr[0] & 255) == 254 && (bArr[1] & 255) == 255) {
                        str2 = b.j6 ? "Cp1201" : "UTF-16BE";
                        if (str2 == null) {
                            return new InputStreamReader(pushbackInputStream, str2);
                        }
                        pushbackInputStream.unread(bArr, 0, i);
                        if (str == null) {
                            return new InputStreamReader(pushbackInputStream, str);
                        }
                        return new InputStreamReader(pushbackInputStream);
                    } else if ((bArr[0] & 255) == 255 && (bArr[1] & 255) == 254) {
                        str3 = b.j6 ? "Cp1200" : "UTF-16LE";
                        pushbackInputStream.unread(bArr, 2, i - 2);
                    }
                }
                str2 = str3;
                if (str2 == null) {
                    return new InputStreamReader(pushbackInputStream, str2);
                }
                pushbackInputStream.unread(bArr, 0, i);
                if (str == null) {
                    return new InputStreamReader(pushbackInputStream);
                }
                return new InputStreamReader(pushbackInputStream, str);
            }
        }

        private class h implements cx {
            private Hashtable<String, z> DW;
            private Hashtable<String, z> FH;
            private eb Hw;
            private dj<z> VH;
            private dj<aa> Zo;
            final /* synthetic */ b j6;
            private eb v5;

            private h(b bVar) {
                this.j6 = bVar;
                this.DW = new Hashtable();
                this.FH = new Hashtable();
                this.Zo = new dj();
                this.VH = new dj();
            }

            public void j6(Hashtable<String, z> hashtable) {
                this.FH = this.DW;
                this.DW = new Hashtable();
                Enumeration keys = hashtable.keys();
                while (keys.hasMoreElements()) {
                    String str = (String) keys.nextElement();
                    this.DW.put(str, (z) hashtable.get(str));
                }
            }

            public void j6() {
                Hw();
                this.Zo.j6.j6();
                while (this.Zo.j6.DW()) {
                    bv gn = this.j6.FH.cn.gn(this.Zo.j6.FH());
                    aa aaVar = (aa) this.Zo.j6.Hw();
                    if (aaVar.FH == 0) {
                        ((z) this.VH.FH(gn.vy())).j6(gn.XL());
                    }
                    if (aaVar.FH != ((z) this.VH.FH(gn.vy())).j6()) {
                        try {
                            ((z) this.VH.FH(gn.vy())).j6(aaVar);
                        } catch (IOException e) {
                            aaVar.DW = 0;
                            aaVar.FH = 0;
                        }
                    }
                }
            }

            public boolean DW() {
                this.Zo.j6.j6();
                while (this.Zo.j6.DW()) {
                    if (((aa) this.Zo.j6.Hw()).FH != ((z) this.VH.FH(this.j6.FH.cn.gn(this.Zo.j6.FH()).vy())).j6()) {
                        return false;
                    }
                }
                return true;
            }

            public Reader j6(bv bvVar) {
                Hw();
                aa aaVar = (aa) this.Zo.FH(bvVar.vy());
                return new CharArrayReader(aaVar.j6, 0, aaVar.DW);
            }

            public long DW(bv bvVar) {
                Hw();
                return ((aa) this.Zo.FH(bvVar.vy())).FH;
            }

            public long FH(bv bvVar) {
                Hw();
                return (long) ((aa) this.Zo.FH(bvVar.vy())).DW;
            }

            public boolean Hw(bv bvVar) {
                Hw();
                return this.Zo.j6(bvVar.vy());
            }

            public eb FH() {
                Hw();
                return this.v5;
            }

            private void Hw() {
                if (this.v5 == null) {
                    this.v5 = new eb(this.j6.FH.cn);
                }
                if (this.Hw == null) {
                    this.Hw = new eb(this.j6.FH.cn);
                }
                if (this.FH != null) {
                    if (!this.FH.equals(this.DW)) {
                        dj djVar = new dj();
                        this.VH.j6();
                        this.v5.j6();
                        Enumeration keys = this.DW.keys();
                        while (keys.hasMoreElements()) {
                            String str = (String) keys.nextElement();
                            z zVar = (z) this.DW.get(str);
                            bv DW = this.j6.FH.cn.DW(str);
                            this.v5.j6(DW);
                            this.VH.j6(DW.vy(), zVar);
                            DW.ei();
                            if (this.Zo.j6(DW.vy())) {
                                djVar.j6(DW.vy(), this.Zo.FH(DW.vy()));
                            } else {
                                djVar.j6(DW.vy(), new aa());
                            }
                        }
                        this.Zo = djVar;
                        this.Hw.j6();
                        this.VH.j6.j6();
                        while (this.VH.j6.DW()) {
                            this.Hw.j6(this.j6.FH.cn.gn(this.VH.j6.FH()).u7());
                        }
                    }
                    this.FH = null;
                }
            }
        }

        private class i implements cy {
            private x DW;
            private ArrayList<Modification> FH;
            private ArrayList<String> Hw;
            final /* synthetic */ b j6;

            private i(b bVar) {
                this.j6 = bVar;
            }

            public void FH() {
                this.j6.j6.Hw.j6(this.FH);
                this.FH = null;
            }

            public void aM() {
                this.j6.j6.Hw.J0(this.FH);
                this.FH = null;
            }

            public void j3() {
                this.j6.j6.Hw.J8(this.FH);
                this.FH = null;
            }

            public void j6(bj bjVar, Set<? extends bd> set) {
                this.j6.j6.Hw.j6(bjVar.j6(), (Set) set);
            }

            public void Zo(String str) {
                this.j6.j6.Hw.gn(str);
            }

            public void tp() {
                this.j6.j6.Hw.gn(this.FH);
                this.FH = null;
            }

            public void VH(String str) {
                this.j6.j6.Hw.tp(str);
            }

            public void EQ() {
                this.j6.j6.Hw.EQ(this.FH);
                this.FH = null;
            }

            public void gn(String str) {
                this.j6.j6.Hw.v5(str);
            }

            public void we() {
                this.j6.j6.Hw.Hw(this.FH);
                this.FH = null;
            }

            public void J0() {
                this.j6.j6.Hw.v5(this.FH);
                this.FH = null;
            }

            public void J8() {
                this.j6.j6.Hw.Zo(this.FH);
                this.FH = null;
            }

            public void u7(String str) {
                this.j6.j6.Hw.Zo(str);
            }

            public void j6(String str, Hashtable<String, String[]> hashtable) {
                this.j6.j6.Hw.j6(str, (Hashtable) hashtable);
            }

            public void Ws() {
                this.j6.j6.Hw.tp(this.FH);
                this.FH = null;
            }

            public void v5() {
                this.j6.j6.Hw.DW(this.FH);
                this.FH = null;
            }

            public void j6(bv bvVar, int i, int i2, List<Integer> list, List<String> list2, List<String> list3, List<String> list4) {
                this.j6.j6.e9 = bvVar.er();
                this.j6.j6.a5 = i;
                this.j6.j6.ys = i2;
                this.DW.FH = list3;
                this.DW.DW = list2;
                this.DW.Hw = list4;
                this.DW.j6 = list;
                this.j6.j6.Hw.j6(this.DW);
            }

            public void QX() {
                this.j6.j6.Hw.DW(this.FH, this.Hw);
                this.FH = null;
                this.Hw = null;
            }

            public void tp(String str) {
                this.j6.j6.Hw.DW(str);
            }

            public void EQ(String str) {
                this.j6.j6.Hw.VH(str);
            }

            public void XL() {
                this.j6.j6.Hw.VH(this.FH);
            }

            public void v5(String str) {
                this.j6.j6.Hw.u7(str);
            }

            public void u7() {
                this.j6.j6.Hw.u7(this.FH);
                this.FH = null;
            }

            public void Hw() {
                this.j6.j6.Hw.j6(this.FH, this.Hw);
            }

            public void DW(String str) {
                this.j6.j6.Hw.j6(str);
            }

            public void j6() {
                this.j6.j6.Hw.j6();
            }

            public void j6(String str) {
                this.Hw.add(str);
            }

            public void j6(String str, String str2) {
                this.j6.j6.Hw.j6(str, str2);
            }

            public void FH(String str) {
                this.j6.j6.Hw.FH(str);
            }

            public void j6(String str, String str2, boolean z, String str3, int i, int i2, int i3) {
                this.j6.j6.Hw.j6(str, str2, z, str3, i, i2, i3);
            }

            public void Hw(String str) {
                this.j6.j6.Hw.Hw(str);
            }

            public void Zo() {
                this.j6.j6.Hw.FH(this.FH);
                this.FH = null;
            }

            public void j6(bv bvVar, int i, int i2) {
                this.FH.add(new Modification(i, i2, bvVar.er(), true));
            }

            public void j6(bv bvVar, int i, int i2, int i3, int i4) {
                this.FH.add(new Modification(i, i2, i3, i4, bvVar.er(), true));
            }

            public void DW(bv bvVar, int i, int i2, int i3, int i4) {
            }

            public void FH(bv bvVar, int i, int i2, int i3, int i4) {
                this.FH.add(new Modification(i, i2, i3, i4, bvVar.er()));
            }

            public void j6(bv bvVar, int i, int i2, int i3) {
                this.FH.add(new Modification(bvVar.er(), i, i2, i3));
            }

            public void j6(bv bvVar, int i, int i2, int i3, int i4, String str) {
                if (i > 0 && i3 >= 0) {
                    this.FH.add(new Modification(i, i2, i3, i4, bvVar.er(), str, true));
                }
            }

            public void DW(bv bvVar, int i, int i2, int i3, int i4, String str) {
                this.FH.add(new Modification(i, i2, i3, i4, bvVar.er(), str, false));
            }

            public void DW(bv bvVar, String str) {
                this.FH.add(new Modification(bvVar.er(), str, 0));
            }

            public void DW(bv bvVar, int i, int i2) {
                this.FH.add(new Modification(i, i2, bvVar.er()));
            }

            public void gn() {
                this.j6.j6.Hw.we(this.FH);
                this.FH = null;
            }

            public void VH() {
                this.j6.j6.Of = this.FH;
                this.FH = null;
                synchronized (this.j6.j6.j3) {
                    this.j6.j6.j3.notify();
                }
            }

            public void DW() {
                this.FH = new ArrayList();
                this.Hw = new ArrayList();
                this.DW = new x();
            }

            public void j6(bv bvVar, int i, int i2, int i3, int i4, int i5, int i6) {
                this.FH.add(new Modification(i, i2, i3, i4, bvVar.er(), i5, i6));
            }

            public void DW(bv bvVar, int i, int i2, int i3, int i4, int i5, int i6) {
                this.FH.add(new Modification(i, i2, i3, i4, bvVar.er(), i5, i6, true));
            }

            public void j6(bv bvVar, String str) {
                this.FH.add(new Modification(bvVar.er(), str));
            }

            public void j6(bv bvVar, bv bvVar2) {
                this.FH.add(new Modification(bvVar.er(), bvVar2.er(), true));
            }
        }

        private class j implements cz {
            final /* synthetic */ b j6;

            private j(b bVar) {
                this.j6 = bVar;
            }

            public boolean VH() {
                return this.j6.j6.nw || this.j6.j6.gW || this.j6.j6.kQ || this.j6.j6.yO || this.j6.j6.cb || this.j6.j6.ro || this.j6.j6.P8 || this.j6.j6.XG || this.j6.j6.jJ || this.j6.j6.wc || this.j6.j6.cn || this.j6.j6.Sf || this.j6.j6.vy || this.j6.j6.g3 || this.j6.j6.Mz || this.j6.j6.dx || this.j6.j6.sG || this.j6.j6.ef || this.j6.j6.ei || this.j6.j6.er > 0 || this.j6.j6.vJ;
            }

            public boolean j6() {
                return this.j6.j6.Mz || this.j6.j6.g3;
            }

            public boolean DW() {
                return this.j6.j6.SI;
            }

            public boolean FH() {
                return this.j6.j6.lg;
            }

            public boolean Hw() {
                return this.j6.j6.rN;
            }

            public boolean v5() {
                return this.j6.j6.a8 || this.j6.j6.cb;
            }

            public boolean Zo() {
                return this.j6.j6.nw || this.j6.j6.cn || this.j6.j6.kQ || this.j6.j6.yO || this.j6.j6.XG || this.j6.j6.jJ || this.j6.j6.cb;
            }

            public boolean gn() {
                return VH();
            }
        }

        private class k implements da {
            private ArrayList<SourceEntity> DW;
            final /* synthetic */ b j6;

            private k(b bVar) {
                this.j6 = bVar;
                this.DW = new ArrayList();
            }

            public void j6() {
                this.DW.clear();
            }

            public void j6(String str, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                int i9;
                List arrayList = new ArrayList(i8);
                for (i9 = 0; i9 < i8; i9++) {
                    arrayList.add(this.DW.get((this.DW.size() - i8) + i9));
                }
                for (i9 = 0; i9 < i8; i9++) {
                    this.DW.remove(this.DW.size() - 1);
                }
                this.DW.add(new SourceEntity(this.j6.FH, str, z, i, i2, i3, i4, i5, i6, i7, arrayList));
            }

            public void j6(bj bjVar, int i) {
                int i2 = 0;
                List arrayList = new ArrayList(i);
                for (int i3 = 0; i3 < i; i3++) {
                    arrayList.add(this.DW.get((this.DW.size() - i) + i3));
                }
                while (i2 < i) {
                    this.DW.remove(this.DW.size() - 1);
                    i2++;
                }
                this.DW.add(new SourceEntity(this.j6.FH, bjVar, arrayList));
            }

            public void j6(bs bsVar, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
                this.DW.add(new SourceEntity(this.j6.FH, bsVar, i, i2, i3, i4, i5, i6, i7));
            }

            public void j6(bs bsVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                int i9;
                List arrayList = new ArrayList(i8);
                for (i9 = 0; i9 < i8; i9++) {
                    arrayList.add(this.DW.get((this.DW.size() - i8) + i9));
                }
                for (i9 = 0; i9 < i8; i9++) {
                    this.DW.remove(this.DW.size() - 1);
                }
                this.DW.add(new SourceEntity(this.j6.FH, bsVar, i, i2, i3, i4, i5, i6, i7, arrayList));
            }

            public void j6(bv bvVar, int i) {
                List arrayList = new ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(this.DW.get((this.DW.size() - i) + i2));
                }
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.j6(bvVar.er(), bvVar.aM(), arrayList);
                }
                this.DW.clear();
            }
        }

        private class l implements db {
            private ArrayList<SourceEntity> DW;
            private String FH;
            final /* synthetic */ b j6;

            private l(b bVar) {
                this.j6 = bVar;
            }

            public void FH() {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.DW(this.FH, this.DW);
                }
            }

            public void Hw() {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.FH(this.FH);
                }
            }

            public void DW() {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.DW(this.FH);
                }
            }

            public void j6(String str) {
                this.DW = new ArrayList();
                this.FH = str;
            }

            public void j6(bs bsVar) {
                SourceEntity sourceEntity = new SourceEntity(this.j6.FH, bsVar);
                sourceEntity.DW(this.j6.FH);
                this.DW.add(sourceEntity);
            }

            public void j6() {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.j6(this.FH, this.DW);
                }
            }

            public void j6(bv bvVar) {
                this.DW.add(new SourceEntity(this.j6.FH, bvVar));
            }
        }

        private class m implements dc {
            final /* synthetic */ b j6;

            private m(b bVar) {
                this.j6 = bVar;
            }
        }

        private class n implements dd {
            final /* synthetic */ b j6;

            private n(b bVar) {
                this.j6 = bVar;
            }

            public void j6(bv bvVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.j6(bvVar.er(), i, i2, i3, i4, i5, i6, i7, i8);
                }
            }

            public void j6(bj bjVar, int i, int i2, int i3, int i4, boolean z) {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.j6(bjVar.j6(), i, i2, i3, i4, z);
                }
            }

            public void j6(bv bvVar) {
                if (this.j6.j6.VH != null) {
                    this.j6.j6.VH.Hw(bvVar.er());
                }
            }
        }

        private class o implements de {
            private List<SourceEntity> DW;
            final /* synthetic */ b j6;

            private o(b bVar) {
                this.j6 = bVar;
            }

            public void j6() {
                this.DW = new ArrayList();
            }

            public void j6(bs bsVar) {
                Object sourceEntity;
                if (bsVar.cT()) {
                    sourceEntity = new SourceEntity(this.j6.FH, bsVar, 0);
                } else {
                    sourceEntity = new SourceEntity(this.j6.FH, bsVar);
                }
                this.DW.add(sourceEntity);
            }

            public void j6(cp cpVar) {
                this.DW.add(new SourceEntity(this.j6.FH, false, cpVar));
            }

            public void j6(String str) {
                this.DW.add(new SourceEntity(str, true));
            }

            public void DW() {
                this.j6.j6.zf = this.DW;
                this.DW = null;
            }
        }

        private class p implements df {
            private List<FindResult> DW;
            private bv FH;
            private Map<bj, cm> Hw;
            final /* synthetic */ b j6;
            private List<String> v5;

            private p(b bVar) {
                this.j6 = bVar;
                this.Hw = new HashMap();
            }

            public void j6() {
                this.DW = new ArrayList();
                this.j6.j6.FH.j6();
                FH();
            }

            private void FH() {
                if (this.FH != null) {
                    for (bj bjVar : this.FH.BT().Zo()) {
                        this.j6.FH.ef.j6((cm) this.Hw.get(bjVar));
                    }
                    this.FH = null;
                    this.Hw = null;
                    this.v5 = null;
                }
            }

            private void j6(bv bvVar) {
                if (bvVar != this.FH) {
                    FH();
                    this.FH = bvVar;
                    Reader rN;
                    try {
                        this.v5 = bvVar.lg();
                        this.Hw = new HashMap();
                        if (bvVar.BT() != null) {
                            rN = bvVar.rN();
                            for (bj put : bvVar.BT().Zo()) {
                                this.Hw.put(put, this.j6.FH.ef.DW());
                            }
                            bvVar.BT().j6(bvVar, rN, this.Hw);
                            rN.close();
                        }
                    } catch (IOException e) {
                    } catch (Throwable th) {
                        rN.close();
                    }
                }
            }

            private String j6(int i) {
                if (i < 0 || i > this.v5.size()) {
                    return "";
                }
                String str = (String) this.v5.get(i);
                if (str.length() > 200) {
                    return str.substring(0, 200);
                }
                return str;
            }

            private List<Highlighting> j6(int i, int i2) {
                List<Highlighting> arrayList = new ArrayList();
                if (this.FH.BT() != null) {
                    for (bj bjVar : this.FH.BT().Zo()) {
                        cm cmVar = (cm) this.Hw.get(bjVar);
                        bl Hw = bjVar.Hw();
                        int i3 = 0;
                        while (i3 < cmVar.u7) {
                            if (cmVar.Zo[i3] <= 200 && cmVar.FH[i3] <= i && cmVar.Hw[i3] >= i2) {
                                f j6 = this.j6.j6(Hw, cmVar.j6[i3]);
                                if (j6 != null) {
                                    arrayList.add(new Highlighting(j6, cmVar.FH[i3], cmVar.v5[i3], cmVar.Hw[i3], cmVar.Zo[i3]));
                                }
                            }
                            i3++;
                        }
                        this.j6.FH.ef.j6(cmVar);
                    }
                }
                return arrayList;
            }

            public void j6(String str) {
                this.j6.j6.FH.j6(str);
            }

            public void j6(bv bvVar, int i, int i2, int i3, int i4) {
                if (i > 0 && i == i3) {
                    j6(bvVar);
                    this.DW.add(new FindResult(bvVar.er(), j6(i), j6(i, i3), i, i2, i4));
                }
            }

            public void DW() {
                this.j6.j6.FH.j6(this.DW);
                FH();
            }
        }

        public b(b bVar, boolean z) {
            this.j6 = bVar;
        }

        private void j6(String str) {
            if (this.j6.J8 && new File(this.j6.Ws).exists()) {
                long j;
                do {
                    int i = 0;
                    j = 0;
                    long j2 = Long.MAX_VALUE;
                    String str2 = "";
                    String[] list = new File(this.j6.Ws).list();
                    if (list != null) {
                        int i2 = 0;
                        while (i2 < list.length) {
                            String str3;
                            int i3;
                            long j3;
                            if (list[i2].endsWith(FH())) {
                                str3 = this.j6.Ws + File.separator + list[i2];
                                if (new File(str3).exists() && new File(str3).isFile()) {
                                    int i4 = i + 1;
                                    long length = new File(str3).length() + j;
                                    j = new File(str3).lastModified();
                                    if (j >= j2 || str3.equals(str)) {
                                        str3 = str2;
                                        j = j2;
                                        j2 = length;
                                        i3 = i4;
                                        i2++;
                                        i = i3;
                                        str2 = str3;
                                        j3 = j2;
                                        j2 = j;
                                        j = j3;
                                    } else {
                                        j2 = length;
                                        i3 = i4;
                                        i2++;
                                        i = i3;
                                        str2 = str3;
                                        j3 = j2;
                                        j2 = j;
                                        j = j3;
                                    }
                                }
                            }
                            str3 = str2;
                            i3 = i;
                            j3 = j;
                            j = j2;
                            j2 = j3;
                            i2++;
                            i = i3;
                            str2 = str3;
                            j3 = j2;
                            j2 = j;
                            j = j3;
                        }
                        if (str2.length() > 0 && j > this.j6.QX) {
                            System.out.println("Deleted " + str2);
                            new File(str2).delete();
                        }
                    }
                    if (str2.length() <= 0) {
                        return;
                    }
                } while (j > this.j6.QX);
            }
        }

        private String FH() {
            return ".cgc";
        }

        private String Hw() {
            return this.j6.Ws + File.separator + ".xxxxxxxxxxxx" + FH();
        }

        private String v5() {
            return this.j6.Ws + File.separator + "." + Long.toHexString(this.DW.j6() ^ this.j6.fh.j6()) + FH();
        }

        private void Zo() {
            if (this.DW != null && !new File(v5()).exists()) {
                this.FH.Hw();
                gn();
            }
        }

        private void VH() {
            if (this.DW != null && this.j6.J8) {
                new File(v5()).delete();
            }
        }

        private void gn() {
            Throwable th;
            Object obj = 1;
            if (this.DW != null) {
                Object obj2 = null;
                String v5 = v5();
                try {
                    if (this.j6.J8) {
                        ef efVar;
                        try {
                            this.j6.Zo.gn();
                            if (!this.Mr) {
                                efVar = new ef(Hw(), new Deflater(1));
                                efVar.writeUTF("3.0_35");
                                this.FH.j6(efVar);
                                efVar.close();
                                if (new File(v5).exists() && !new File(v5).delete()) {
                                    throw new IOException("Delete of " + v5 + " failed.");
                                } else if (new File(Hw()).renameTo(new File(v5))) {
                                    System.out.println("Model stored " + v5);
                                    j6(v5);
                                    this.Mr = true;
                                } else {
                                    throw new IOException("Rename from " + Hw() + " to " + v5 + " failed.");
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace(System.out);
                            if (obj == null) {
                                this.j6.Zo.u7();
                            }
                        }
                        if (obj == null) {
                            this.j6.Zo.u7();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = obj2;
                    th.printStackTrace(System.out);
                    if (obj == null) {
                        this.j6.Zo.u7();
                    }
                }
            }
        }

        private void u7() {
            Throwable th;
            boolean z = true;
            this.Mr = true;
            boolean z2 = false;
            try {
                if (!this.j6.J8) {
                    throw new IOException("No persistence mode");
                } else if (this.DW == null) {
                    throw new IOException("No solution");
                } else {
                    ee eeVar;
                    try {
                        this.j6.Zo.Zo();
                        String v5 = v5();
                        if (new File(v5).exists()) {
                            tp();
                            eeVar = new ee(v5, new Inflater());
                            if (eeVar.readUTF().equals("3.0_35")) {
                                this.FH.j6(eeVar);
                                System.out.println("Model loaded " + v5);
                                eeVar.close();
                                j6();
                                DW();
                                this.U2 = true;
                                if (!z) {
                                    this.j6.Zo.VH();
                                }
                            }
                            eeVar.close();
                            throw new IOException();
                        }
                        throw new IOException("Cache file does not exist: " + v5);
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = true;
                        th.printStackTrace(System.out);
                        this.j6.Zo.FH();
                        VH();
                        tp();
                        j6();
                        DW();
                        z = z2;
                        if (!z) {
                            this.j6.Zo.VH();
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace(System.out);
                this.j6.Zo.FH();
                VH();
                tp();
                j6();
                DW();
                z = z2;
                if (!z) {
                    this.j6.Zo.VH();
                }
            }
        }

        private void tp() {
            EQ();
            we();
            this.U2 = false;
            this.j6.Lz = new HashMap();
            b bVar = this;
            this.Hw = new h();
            bVar = this;
            this.v5 = new j();
            bVar = this;
            this.VH = new e();
            bVar = this;
            this.Zo = new k();
            bVar = this;
            this.gn = new l();
            bVar = this;
            this.u7 = new b();
            bVar = this;
            this.tp = new i();
            bVar = this;
            this.EQ = new p();
            bVar = this;
            this.we = new c();
            bVar = this;
            this.J0 = new a();
            bVar = this;
            this.J8 = new d();
            bVar = this;
            this.Ws = new o();
            bVar = this;
            this.QX = new n();
            bVar = this;
            this.XL = new f();
            bVar = this;
            this.aM = new g();
            bVar = this;
            this.j3 = new m();
            this.FH = new ba(this.Hw, this.v5, this.Zo, this.VH, this.gn, this.u7, this.tp, this.EQ, this.we, this.J0, this.J8, this.Ws, this.QX, this.XL, this.j3, this.aM);
            this.lg = new eb(this.FH.cn);
            this.rN = new eb(this.FH.cn);
            this.er = new eb(this.FH.cn);
            this.yS = new dh();
        }

        public void j6() {
            this.FH.j6(this.j6.fh.j6(this.FH, this.DW != null ? this.DW.DW : new ArrayList()));
        }

        public void DW() {
            this.FH.j6(this.j6.T6, this.j6.cc, this.j6.Od);
            if (this.DW != null) {
                this.DW.j6(this.FH);
            } else {
                this.FH.j6();
            }
        }

        private void j6(boolean z) {
            this.FH.j6(z);
            if (z) {
                this.j6.Lz.clear();
            }
        }

        private void EQ() {
            this.j6.Lz = null;
            this.lg = null;
            this.rN = null;
            this.er = null;
            this.FH = null;
            this.Hw = null;
            this.v5 = null;
            this.u7 = null;
            this.tp = null;
            this.VH = null;
            this.Zo = null;
            this.gn = null;
            this.EQ = null;
            this.we = null;
            this.J0 = null;
            this.J8 = null;
            this.Ws = null;
            this.QX = null;
            this.XL = null;
            this.aM = null;
            this.j3 = null;
        }

        private void we() {
            if (((float) Runtime.getRuntime().totalMemory()) - ((float) Runtime.getRuntime().freeMemory()) > 4.0E7f) {
                int i = 0;
                while (i < 5) {
                    System.gc();
                    float totalMemory = (float) Runtime.getRuntime().totalMemory();
                    if ((totalMemory - ((float) Runtime.getRuntime().freeMemory())) / totalMemory <= 0.3f) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r11 = this;
            r1 = 0;
            r0 = r11.j6;
            r2 = r0.XL;
            monitor-enter(r2);
        L_0x0008:
            r0 = r11.j6;	 Catch:{ InterruptedException -> 0x001c }
            r0 = r0.er;	 Catch:{ InterruptedException -> 0x001c }
            if (r0 <= 0) goto L_0x001d;
        L_0x0010:
            r0 = r11.j6;	 Catch:{ InterruptedException -> 0x001c }
            r0 = r0.XL;	 Catch:{ InterruptedException -> 0x001c }
            r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            r0.wait(r4);	 Catch:{ InterruptedException -> 0x001c }
            goto L_0x0008;
        L_0x001c:
            r0 = move-exception;
        L_0x001d:
            monitor-exit(r2);	 Catch:{ all -> 0x015d }
            r11.u7();
        L_0x0021:
            r0 = r11.j6;
            r5 = r0.XL;
            monitor-enter(r5);
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x015a }
        L_0x002c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.gW;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0034:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.cb;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x003c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.vy;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0044:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.nw;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x004c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.I;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0054:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.ca;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x005c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.x9;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0064:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.Qq;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x006c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.sy;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0074:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.cn;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x007c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.sh;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0084:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.g3;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x008c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.Mz;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0094:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.KD;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x009c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.P8;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00a4:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.yS;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00ac:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.kQ;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00b4:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.yO;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00bc:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.wc;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00c4:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.XX;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00cc:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.XG;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00d4:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.jJ;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00dc:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.lp;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00e4:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.aj;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00ec:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.OW;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00f4:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.br;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x00fc:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.dx;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0104:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.sG;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x010c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.ef;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0114:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.ei;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x011c:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.vJ;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x0124:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.BT;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x0160;
        L_0x012c:
            r0 = r11.j6;	 Catch:{ InterruptedException -> 0x0249 }
            r0 = r0.XL;	 Catch:{ InterruptedException -> 0x0249 }
            r6 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
            r0.wait(r6);	 Catch:{ InterruptedException -> 0x0249 }
        L_0x0137:
            r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x015a }
            r6 = r6 - r2;
            r0 = r11.FH;	 Catch:{ all -> 0x015a }
            r0 = r0.P8;	 Catch:{ all -> 0x015a }
            r0 = r0.VH();	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x002c;
        L_0x0146:
            r0 = r11.Mr;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x002c;
        L_0x014a:
            r8 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
            r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
            if (r0 <= 0) goto L_0x002c;
        L_0x0151:
            r0 = 1;
            r11.j6(r0);	 Catch:{ all -> 0x015a }
            r11.gn();	 Catch:{ all -> 0x015a }
            goto L_0x002c;
        L_0x015a:
            r0 = move-exception;
            monitor-exit(r5);	 Catch:{ all -> 0x015a }
            throw r0;
        L_0x015d:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x015d }
            throw r0;
        L_0x0160:
            r0 = r11.j6;	 Catch:{ InterruptedException -> 0x0174 }
            r0 = r0.er;	 Catch:{ InterruptedException -> 0x0174 }
            if (r0 <= 0) goto L_0x0175;
        L_0x0168:
            r0 = r11.j6;	 Catch:{ InterruptedException -> 0x0174 }
            r0 = r0.XL;	 Catch:{ InterruptedException -> 0x0174 }
            r2 = 50;
            r0.wait(r2);	 Catch:{ InterruptedException -> 0x0174 }
            goto L_0x0160;
        L_0x0174:
            r0 = move-exception;
        L_0x0175:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.gW;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x01fe;
        L_0x017d:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r0 = r0.cb;	 Catch:{ all -> 0x015a }
            if (r0 != 0) goto L_0x01fe;
        L_0x0185:
            r0 = r1;
            r2 = r1;
            r3 = r1;
            r4 = r1;
        L_0x0189:
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r6 = r6.cn;	 Catch:{ all -> 0x015a }
            r3 = r3 | r6;
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r6 = r6.sG;	 Catch:{ all -> 0x015a }
            r2 = r2 | r6;
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r6 = r6.nw;	 Catch:{ all -> 0x015a }
            r4 = r4 | r6;
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r6 = r6.BT;	 Catch:{ all -> 0x015a }
            r0 = r0 | r6;
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r7 = r11.j6;	 Catch:{ all -> 0x015a }
            r8 = r11.j6;	 Catch:{ all -> 0x015a }
            r9 = r11.j6;	 Catch:{ all -> 0x015a }
            r10 = 0;
            r9 = r9.BT = r10;	 Catch:{ all -> 0x015a }
            r8 = r8.sG = r9;	 Catch:{ all -> 0x015a }
            r7 = r7.cn = r8;	 Catch:{ all -> 0x015a }
            r6.nw = r7;	 Catch:{ all -> 0x015a }
            if (r3 == 0) goto L_0x021d;
        L_0x01bf:
            r6 = r11.j6;	 Catch:{ InterruptedException -> 0x022b }
            r6 = r6.XL;	 Catch:{ InterruptedException -> 0x022b }
            r8 = 20;
            r6.wait(r8);	 Catch:{ InterruptedException -> 0x022b }
        L_0x01ca:
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r6 = r6.nw;	 Catch:{ all -> 0x015a }
            if (r6 != 0) goto L_0x0189;
        L_0x01d2:
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r6 = r6.cn;	 Catch:{ all -> 0x015a }
            if (r6 != 0) goto L_0x0189;
        L_0x01da:
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r6 = r6.sG;	 Catch:{ all -> 0x015a }
            if (r6 != 0) goto L_0x0189;
        L_0x01e2:
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r6 = r6.BT;	 Catch:{ all -> 0x015a }
            if (r6 != 0) goto L_0x0189;
        L_0x01ea:
            r6 = r11.j6;	 Catch:{ all -> 0x015a }
            r6.nw = r4;	 Catch:{ all -> 0x015a }
            r4 = r11.j6;	 Catch:{ all -> 0x015a }
            r4.cn = r3;	 Catch:{ all -> 0x015a }
            r3 = r11.j6;	 Catch:{ all -> 0x015a }
            r3.sG = r2;	 Catch:{ all -> 0x015a }
            r2 = r11.j6;	 Catch:{ all -> 0x015a }
            r2.BT = r0;	 Catch:{ all -> 0x015a }
        L_0x01fe:
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r2 = 0;
            r0.a8 = r2;	 Catch:{ all -> 0x015a }
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r2 = 0;
            r0.lg = r2;	 Catch:{ all -> 0x015a }
            r0 = r11.j6;	 Catch:{ all -> 0x015a }
            r2 = 0;
            r0.rN = r2;	 Catch:{ all -> 0x015a }
            monitor-exit(r5);	 Catch:{ all -> 0x015a }
            r11.J0();
            r0 = r11.j6;
            r0 = r0.P8;
            if (r0 == 0) goto L_0x0021;
        L_0x021c:
            return;
        L_0x021d:
            if (r4 == 0) goto L_0x022d;
        L_0x021f:
            r6 = r11.j6;	 Catch:{ InterruptedException -> 0x022b }
            r6 = r6.XL;	 Catch:{ InterruptedException -> 0x022b }
            r8 = 50;
            r6.wait(r8);	 Catch:{ InterruptedException -> 0x022b }
            goto L_0x01ca;
        L_0x022b:
            r6 = move-exception;
            goto L_0x01ca;
        L_0x022d:
            if (r2 == 0) goto L_0x023b;
        L_0x022f:
            r6 = r11.j6;	 Catch:{ InterruptedException -> 0x022b }
            r6 = r6.XL;	 Catch:{ InterruptedException -> 0x022b }
            r8 = 50;
            r6.wait(r8);	 Catch:{ InterruptedException -> 0x022b }
            goto L_0x01ca;
        L_0x023b:
            if (r0 == 0) goto L_0x01ca;
        L_0x023d:
            r6 = r11.j6;	 Catch:{ InterruptedException -> 0x022b }
            r6 = r6.XL;	 Catch:{ InterruptedException -> 0x022b }
            r8 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
            r6.wait(r8);	 Catch:{ InterruptedException -> 0x022b }
            goto L_0x01ca;
        L_0x0249:
            r0 = move-exception;
            goto L_0x0137;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aide.engine.b.b.run():void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void J0() {
            /*
            r32 = this;
            r0 = r32;
            r2 = r0.FH;	 Catch:{ InterruptedException -> 0x00d0 }
            r2 = r2.cn;	 Catch:{ InterruptedException -> 0x00d0 }
            r2 = r2.VH();	 Catch:{ InterruptedException -> 0x00d0 }
            if (r2 != 0) goto L_0x0026;
        L_0x000c:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ InterruptedException -> 0x00d0 }
            r3 = r2.XL;	 Catch:{ InterruptedException -> 0x00d0 }
            monitor-enter(r3);	 Catch:{ InterruptedException -> 0x00d0 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x00cd }
            r4 = 1;
            r2.vy = r4;	 Catch:{ all -> 0x00cd }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x00cd }
            r4 = 1;
            r2.nw = r4;	 Catch:{ all -> 0x00cd }
            monitor-exit(r3);	 Catch:{ all -> 0x00cd }
        L_0x0026:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ InterruptedException -> 0x00d0 }
            r3 = r2.XL;	 Catch:{ InterruptedException -> 0x00d0 }
            monitor-enter(r3);	 Catch:{ InterruptedException -> 0x00d0 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x00d3 }
            r4 = 0;
            r2.BT = r4;	 Catch:{ all -> 0x00d3 }
            monitor-exit(r3);	 Catch:{ all -> 0x00d3 }
        L_0x0038:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0106 }
            r6 = r2.nw;	 Catch:{ all -> 0x0106 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0106 }
            r7 = r2.I;	 Catch:{ all -> 0x0106 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0106 }
            r8 = r2.Qq;	 Catch:{ all -> 0x0106 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0106 }
            r9 = r2.sy;	 Catch:{ all -> 0x0106 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0106 }
            r10 = r2.ca;	 Catch:{ all -> 0x0106 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0106 }
            r11 = r2.x9;	 Catch:{ all -> 0x0106 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0106 }
            r4 = 0;
            r2.SI = r4;	 Catch:{ all -> 0x0106 }
            monitor-exit(r3);	 Catch:{ all -> 0x0106 }
            if (r7 != 0) goto L_0x007e;
        L_0x007c:
            if (r8 == 0) goto L_0x0093;
        L_0x007e:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.u7;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0093;
        L_0x0088:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.u7;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x0093:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0109 }
            r2 = r2.P8;	 Catch:{ all -> 0x0109 }
            monitor-exit(r3);	 Catch:{ all -> 0x0109 }
            if (r2 == 0) goto L_0x010c;
        L_0x00a7:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            r32.gn();	 Catch:{ Throwable -> 0x00d6 }
            r32.EQ();	 Catch:{ Throwable -> 0x00d6 }
            r32.we();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x00cc;
        L_0x00c1:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2.DW();	 Catch:{ Throwable -> 0x00d6 }
        L_0x00cc:
            return;
        L_0x00cd:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00cd }
            throw r2;	 Catch:{ InterruptedException -> 0x00d0 }
        L_0x00d0:
            r2 = move-exception;
            goto L_0x0038;
        L_0x00d3:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00d3 }
            throw r2;	 Catch:{ InterruptedException -> 0x00d0 }
        L_0x00d6:
            r2 = move-exception;
            r0 = r32;
            r3 = r0.j6;
            r3 = r3.v5;
            if (r3 == 0) goto L_0x00f0;
        L_0x00e1:
            r3 = r2 instanceof java.lang.OutOfMemoryError;
            if (r3 == 0) goto L_0x18d5;
        L_0x00e5:
            r0 = r32;
            r2 = r0.j6;
            r2 = r2.v5;
            r2.j6();
        L_0x00f0:
            r0 = r32;
            r2 = r0.j6;
            r3 = r2.XL;
            monitor-enter(r3);
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0103 }
            r4 = 1;
            r2.nw = r4;	 Catch:{ all -> 0x0103 }
            monitor-exit(r3);	 Catch:{ all -> 0x0103 }
            goto L_0x00cc;
        L_0x0103:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0103 }
            throw r2;
        L_0x0106:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0106 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0109:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0109 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x010c:
            r2 = 0;
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r12 = r3.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r12);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ all -> 0x0194 }
            r3 = r3.ro;	 Catch:{ all -> 0x0194 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ all -> 0x0194 }
            r5 = 0;
            r4.ro = r5;	 Catch:{ all -> 0x0194 }
            if (r3 == 0) goto L_0x014f;
        L_0x0128:
            r0 = r32;
            r4 = r0.j6;	 Catch:{ all -> 0x0194 }
            r4 = r4.fh;	 Catch:{ all -> 0x0194 }
            r4 = r4.j6();	 Catch:{ all -> 0x0194 }
            r0 = r32;
            r13 = r0.j6;	 Catch:{ all -> 0x0194 }
            r13 = r13.Mr;	 Catch:{ all -> 0x0194 }
            r14 = r13.j6();	 Catch:{ all -> 0x0194 }
            r14 = r14 ^ r4;
            r0 = r32;
            r13 = r0.DW;	 Catch:{ all -> 0x0194 }
            if (r13 != 0) goto L_0x0189;
        L_0x0147:
            r4 = 0;
        L_0x0149:
            r4 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1));
            if (r4 != 0) goto L_0x014f;
        L_0x014d:
            r3 = 0;
            r2 = 1;
        L_0x014f:
            monitor-exit(r12);	 Catch:{ all -> 0x0194 }
            if (r2 == 0) goto L_0x019a;
        L_0x0152:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0197 }
            r2 = r2.Mr;	 Catch:{ all -> 0x0197 }
            r0 = r32;
            r0.DW = r2;	 Catch:{ all -> 0x0197 }
            monitor-exit(r3);	 Catch:{ all -> 0x0197 }
            r32.DW();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2.v5();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0186 }
            r4 = 0;
            r2.yS = r4;	 Catch:{ all -> 0x0186 }
            monitor-exit(r3);	 Catch:{ all -> 0x0186 }
            goto L_0x00cc;
        L_0x0186:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0186 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0189:
            r0 = r32;
            r13 = r0.DW;	 Catch:{ all -> 0x0194 }
            r16 = r13.j6();	 Catch:{ all -> 0x0194 }
            r4 = r4 ^ r16;
            goto L_0x0149;
        L_0x0194:
            r2 = move-exception;
            monitor-exit(r12);	 Catch:{ all -> 0x0194 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0197:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0197 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x019a:
            if (r3 == 0) goto L_0x0209;
        L_0x019c:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x01b1;
        L_0x01a6:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo;	 Catch:{ Throwable -> 0x00d6 }
            r2.FH();	 Catch:{ Throwable -> 0x00d6 }
        L_0x01b1:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x01c6;
        L_0x01bb:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo;	 Catch:{ Throwable -> 0x00d6 }
            r2.Hw();	 Catch:{ Throwable -> 0x00d6 }
        L_0x01c6:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            r32.gn();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0206 }
            r2 = r2.Mr;	 Catch:{ all -> 0x0206 }
            r0 = r32;
            r0.DW = r2;	 Catch:{ all -> 0x0206 }
            monitor-exit(r3);	 Catch:{ all -> 0x0206 }
            r32.u7();	 Catch:{ Throwable -> 0x00d6 }
            r32.QX();	 Catch:{ Throwable -> 0x00d6 }
            r32.XL();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0203 }
            r4 = 0;
            r2.yS = r4;	 Catch:{ all -> 0x0203 }
            monitor-exit(r3);	 Catch:{ all -> 0x0203 }
            goto L_0x00cc;
        L_0x0203:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0203 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0206:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0206 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0209:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x02bc }
            r2 = r2.KD;	 Catch:{ all -> 0x02bc }
            monitor-exit(r3);	 Catch:{ all -> 0x02bc }
            if (r2 == 0) goto L_0x0267;
        L_0x021d:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x02bf }
            r4 = 0;
            r2.KD = r4;	 Catch:{ all -> 0x02bf }
            monitor-exit(r3);	 Catch:{ all -> 0x02bf }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo;	 Catch:{ Throwable -> 0x00d6 }
            r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo;	 Catch:{ Throwable -> 0x00d6 }
            r2.Hw();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo;	 Catch:{ Throwable -> 0x00d6 }
            r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo;	 Catch:{ Throwable -> 0x00d6 }
            r2.v5();	 Catch:{ Throwable -> 0x00d6 }
            r32.VH();	 Catch:{ Throwable -> 0x00d6 }
            r32.tp();	 Catch:{ Throwable -> 0x00d6 }
            r32.j6();	 Catch:{ Throwable -> 0x00d6 }
            r32.DW();	 Catch:{ Throwable -> 0x00d6 }
        L_0x0267:
            if (r10 == 0) goto L_0x0306;
        L_0x0269:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x02c2 }
            r4 = 0;
            r2.ca = r4;	 Catch:{ all -> 0x02c2 }
            monitor-exit(r3);	 Catch:{ all -> 0x02c2 }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.cn;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.Hw();	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x029c:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x02c5;
        L_0x02a8:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.dx;	 Catch:{ Throwable -> 0x00d6 }
            r3.DW(r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x029c;
        L_0x02bc:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x02bc }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x02bf:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x02bf }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x02c2:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x02c2 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x02c5:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.cn;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.Zo();	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x02e6:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0306;
        L_0x02f2:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.dx;	 Catch:{ Throwable -> 0x00d6 }
            r3.v5(r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x02e6;
        L_0x0306:
            if (r8 != 0) goto L_0x030a;
        L_0x0308:
            if (r11 == 0) goto L_0x03a1;
        L_0x030a:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x035d }
            r4 = 0;
            r2.x9 = r4;	 Catch:{ all -> 0x035d }
            monitor-exit(r3);	 Catch:{ all -> 0x035d }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.cn;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.Hw();	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x033d:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0360;
        L_0x0349:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.dx;	 Catch:{ Throwable -> 0x00d6 }
            r3.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x033d;
        L_0x035d:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x035d }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0360:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.cn;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.Zo();	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x0381:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x03a1;
        L_0x038d:
            r0 = r32;
            r2 = r0.lg;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.dx;	 Catch:{ Throwable -> 0x00d6 }
            r3.Hw(r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x0381;
        L_0x03a1:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x053f }
            r2 = r2.gW;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ all -> 0x053f }
            r4 = r4.cb;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ all -> 0x053f }
            r5 = r5.cn;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r10 = r0.j6;	 Catch:{ all -> 0x053f }
            r10 = r10.g3;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r11 = r0.j6;	 Catch:{ all -> 0x053f }
            r11 = r11.Mz;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r12 = r0.j6;	 Catch:{ all -> 0x053f }
            r12 = r12.sh;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r13 = r0.j6;	 Catch:{ all -> 0x053f }
            r13 = r13.dx;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r14 = r0.j6;	 Catch:{ all -> 0x053f }
            r14 = r14.sG;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r15 = r0.j6;	 Catch:{ all -> 0x053f }
            r15 = r15.ef;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r16 = r0;
            r16 = r16.ei;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r17 = r0;
            r17 = r17.vJ;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r18 = r0;
            r18 = r18.vy;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r19 = r0;
            r19 = r19.aj;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r20 = r0;
            r20 = r20.lp;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r21 = r0;
            r21 = r21.OW;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r22 = r0;
            r22 = r22.br;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r23 = r0;
            r23 = r23.XX;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r24 = r0;
            r24 = r24.kQ;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r25 = r0;
            r25 = r25.wc;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r26 = r0;
            r26 = r26.yO;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r27 = r0;
            r27 = r27.XG;	 Catch:{ all -> 0x053f }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x053f }
            r28 = r0;
            r28 = r28.jJ;	 Catch:{ all -> 0x053f }
            monitor-exit(r3);	 Catch:{ all -> 0x053f }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x0542 }
            r29 = r0;
            r30 = 0;
            r29.vy = r30;	 Catch:{ all -> 0x0542 }
            monitor-exit(r3);	 Catch:{ all -> 0x0542 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ all -> 0x0545 }
            r29 = r0;
            r30 = 0;
            r29.Sf = r30;	 Catch:{ all -> 0x0545 }
            monitor-exit(r3);	 Catch:{ all -> 0x0545 }
            r0 = r32;
            r3 = r0.Hw;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r0 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r29 = r0;
            r29 = r29.U2;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r29;
            r3.j6(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r3.DW(r0);	 Catch:{ Throwable -> 0x00d6 }
            if (r27 == 0) goto L_0x054b;
        L_0x04bd:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0548 }
            r4 = 0;
            r2.XG = r4;	 Catch:{ all -> 0x0548 }
            monitor-exit(r3);	 Catch:{ all -> 0x0548 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.AE;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.Za;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.An;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.Pa;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.ce;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
        L_0x050a:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2.Hw();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.yS;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x00cc;
        L_0x051b:
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x0525:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x18d2 }
            r4 = 0;
            r2.yS = r4;	 Catch:{ all -> 0x18d2 }
            monitor-exit(r3);	 Catch:{ all -> 0x18d2 }
            r2 = 1;
            r0 = r32;
            r0.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x00cc;
        L_0x053f:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x053f }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0542:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0542 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0545:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0545 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0548:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0548 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x054b:
            if (r26 == 0) goto L_0x05f7;
        L_0x054d:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x0560:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x05f1 }
            r4 = 0;
            r2.yO = r4;	 Catch:{ all -> 0x05f1 }
            monitor-exit(r3);	 Catch:{ all -> 0x05f1 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.d8;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r2 = r7.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x050a;
        L_0x058a:
            r2 = r7.BT();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x050a;
        L_0x0590:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Ws;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fP;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.b;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.ba;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.u9;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r8 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r8 = r8.om;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r9 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r9 = r9.wE;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r4 = new java.util.HashMap;	 Catch:{ all -> 0x05f4 }
            r4.<init>();	 Catch:{ all -> 0x05f4 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ all -> 0x05f4 }
            r5 = r5.fP;	 Catch:{ all -> 0x05f4 }
            r4.putAll(r5);	 Catch:{ all -> 0x05f4 }
            monitor-exit(r3);	 Catch:{ all -> 0x05f4 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.tp;	 Catch:{ Throwable -> 0x00d6 }
            r3.j6(r4, r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x05f1:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x05f1 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x05f4:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x05f4 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x05f7:
            if (r25 == 0) goto L_0x0659;
        L_0x05f9:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0656 }
            r4 = 0;
            r2.wc = r4;	 Catch:{ all -> 0x0656 }
            monitor-exit(r3);	 Catch:{ all -> 0x0656 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.d8;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r2 = r3.BT();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x050a;
        L_0x0623:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.k1;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.ti;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.nl;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.Ak;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r8 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r8 = r8.iK;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x0656:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0656 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0659:
            if (r24 == 0) goto L_0x070a;
        L_0x065b:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x066e:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0707 }
            r4 = 0;
            r2.kQ = r4;	 Catch:{ all -> 0x0707 }
            monitor-exit(r3);	 Catch:{ all -> 0x0707 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.d8;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r2 = r4.BT();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x06ed;
        L_0x0698:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.om;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.wE;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH(r4, r3, r5);	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.v5();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x06ed;
        L_0x06bc:
            r2 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.nw;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.om;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.wE;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.N0;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r8 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r8 = r8.eN;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x00d6 }
        L_0x06ed:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.j3;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0704 }
            r2 = r2.j3;	 Catch:{ all -> 0x0704 }
            r2.notify();	 Catch:{ all -> 0x0704 }
            monitor-exit(r3);	 Catch:{ all -> 0x0704 }
            goto L_0x050a;
        L_0x0704:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0704 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0707:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0707 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x070a:
            if (r12 == 0) goto L_0x0856;
        L_0x070c:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x071f:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.cT;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x07a0;
        L_0x0737:
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.zh;	 Catch:{ Throwable -> 0x00d6 }
            r4 = com.aide.engine.b.a.PARAMETERS;	 Catch:{ Throwable -> 0x00d6 }
            if (r3 != r4) goto L_0x07b7;
        L_0x0743:
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.q7;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Z1;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.FH(r2, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x0787;
        L_0x075f:
            r4 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.v5();	 Catch:{ Throwable -> 0x00d6 }
            if (r4 == 0) goto L_0x0787;
        L_0x0769:
            r3 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.v5();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.q7;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Z1;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.FH(r2, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 != 0) goto L_0x07a0;
        L_0x0787:
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.lg;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.q7;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Z1;	 Catch:{ Throwable -> 0x00d6 }
            r3.DW(r2, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
        L_0x07a0:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x07b4 }
            r4 = 0;
            r2.sh = r4;	 Catch:{ all -> 0x07b4 }
            monitor-exit(r3);	 Catch:{ all -> 0x07b4 }
            goto L_0x050a;
        L_0x07b4:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x07b4 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x07b7:
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.zh;	 Catch:{ Throwable -> 0x00d6 }
            r4 = com.aide.engine.b.a.PARAMETERS_AFTER_EVENT;	 Catch:{ Throwable -> 0x00d6 }
            if (r3 != r4) goto L_0x0806;
        L_0x07c3:
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.q7;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Z1;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.FH(r2, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x07a0;
        L_0x07df:
            r4 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.v5();	 Catch:{ Throwable -> 0x00d6 }
            if (r4 == 0) goto L_0x07a0;
        L_0x07e9:
            r3 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.v5();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.q7;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Z1;	 Catch:{ Throwable -> 0x00d6 }
            r6 = 0;
            r3.j6(r2, r4, r5, r6);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x07a0;
        L_0x0806:
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.zh;	 Catch:{ Throwable -> 0x00d6 }
            r4 = com.aide.engine.b.a.PARAMETERS_AFTER_CHAREVENT;	 Catch:{ Throwable -> 0x00d6 }
            if (r3 != r4) goto L_0x07a0;
        L_0x0812:
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.q7;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Z1;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.FH(r2, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x07a0;
        L_0x082e:
            r4 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.v5();	 Catch:{ Throwable -> 0x00d6 }
            if (r4 == 0) goto L_0x07a0;
        L_0x0838:
            r3 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.v5();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.q7;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Z1;	 Catch:{ Throwable -> 0x00d6 }
            r6 = 1;
            r3.j6(r2, r4, r5, r6);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x07a0;
        L_0x0856:
            if (r5 == 0) goto L_0x0be9;
        L_0x0858:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x086b:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x08f6 }
            r4 = 0;
            r2.cn = r4;	 Catch:{ all -> 0x08f6 }
            monitor-exit(r3);	 Catch:{ all -> 0x08f6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.jw;	 Catch:{ Throwable -> 0x00d6 }
            r10 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.k2;	 Catch:{ Throwable -> 0x00d6 }
            r3 = com.aide.engine.b.a.UPDATE_MEMBERS_AFTER_EVENT;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != r3) goto L_0x08f9;
        L_0x089b:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.j6(r10, r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x08eb;
        L_0x08b7:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.u7();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x08c7;
        L_0x08c1:
            r2 = r10.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x08eb;
        L_0x08c7:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.qp;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.w9;	 Catch:{ Throwable -> 0x00d6 }
            r7 = 0;
            r2.j6(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
        L_0x08eb:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.J8;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r10);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x08f6:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x08f6 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x08f9:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.k2;	 Catch:{ Throwable -> 0x00d6 }
            r3 = com.aide.engine.b.a.UPDATE_MEMBERS_AFTER_CHAREVENT;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != r3) goto L_0x0956;
        L_0x0905:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.j6(r10, r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x08eb;
        L_0x0921:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.u7();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0931;
        L_0x092b:
            r2 = r10.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x08eb;
        L_0x0931:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.qp;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.w9;	 Catch:{ Throwable -> 0x00d6 }
            r7 = 1;
            r2.j6(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x08eb;
        L_0x0956:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.k2;	 Catch:{ Throwable -> 0x00d6 }
            r3 = com.aide.engine.b.a.UPDATE_EXPRESSION_MEMBERS_AFTER_EVENT;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != r3) goto L_0x09c8;
        L_0x0962:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.j6(r10, r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x08eb;
        L_0x097e:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.u7();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x098e;
        L_0x0988:
            r2 = r10.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x08eb;
        L_0x098e:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.we();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.qp;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.hK;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.AL;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r8 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r8 = r8.w9;	 Catch:{ Throwable -> 0x00d6 }
            r9 = 0;
            r2.j6(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x08eb;
        L_0x09c8:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.k2;	 Catch:{ Throwable -> 0x00d6 }
            r3 = com.aide.engine.b.a.UPDATE_EXPRESSION_MEMBERS_AFTER_CHAREVENT;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != r3) goto L_0x0a3a;
        L_0x09d4:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.j6(r10, r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x08eb;
        L_0x09f0:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.u7();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0a00;
        L_0x09fa:
            r2 = r10.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x08eb;
        L_0x0a00:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.we();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.qp;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.hK;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.AL;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r8 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r8 = r8.w9;	 Catch:{ Throwable -> 0x00d6 }
            r9 = 1;
            r2.j6(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x08eb;
        L_0x0a3a:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.k2;	 Catch:{ Throwable -> 0x00d6 }
            r3 = com.aide.engine.b.a.SUPER_METHODS;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != r3) goto L_0x0a93;
        L_0x0a46:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6(r10, r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x08eb;
        L_0x0a62:
            r3 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.u7();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x0a72;
        L_0x0a6c:
            r3 = r10.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x08eb;
        L_0x0a72:
            r3 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.v5();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.we();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.qp;	 Catch:{ Throwable -> 0x00d6 }
            r3.v5(r2, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x08eb;
        L_0x0a93:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.k2;	 Catch:{ Throwable -> 0x00d6 }
            r3 = com.aide.engine.b.a.FULL_TYPE;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != r3) goto L_0x0aec;
        L_0x0a9f:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6(r10, r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x08eb;
        L_0x0abb:
            r3 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.u7();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x0acb;
        L_0x0ac5:
            r3 = r10.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x08eb;
        L_0x0acb:
            r3 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.v5();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.we();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.qp;	 Catch:{ Throwable -> 0x00d6 }
            r3.Hw(r2, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x08eb;
        L_0x0aec:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.k2;	 Catch:{ Throwable -> 0x00d6 }
            r3 = com.aide.engine.b.a.EXPRESSION_MEMBERS;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != r3) goto L_0x0b55;
        L_0x0af8:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.j6(r10, r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x08eb;
        L_0x0b14:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.u7();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0b24;
        L_0x0b1e:
            r2 = r10.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x08eb;
        L_0x0b24:
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.we();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.qp;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.hK;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.AL;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x08eb;
        L_0x0b55:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.k2;	 Catch:{ Throwable -> 0x00d6 }
            r3 = com.aide.engine.b.a.MEMBERS;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != r3) goto L_0x08eb;
        L_0x0b61:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.j6(r10, r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            r5 = 0;
            if (r3 == 0) goto L_0x0baa;
        L_0x0b7e:
            r5 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
        L_0x0b82:
            if (r5 == 0) goto L_0x0bd0;
        L_0x0b84:
            r2 = r5.v5();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0bd0;
        L_0x0b8a:
            r2 = r10.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0bd0;
        L_0x0b90:
            r2 = r5.v5();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r4.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r10;
            r2.j6(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x08eb;
        L_0x0baa:
            r2 = r10.BT();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0b82;
        L_0x0bb0:
            r2 = r10.BT();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.size();	 Catch:{ Throwable -> 0x00d6 }
            r4 = 1;
            if (r2 != r4) goto L_0x0b82;
        L_0x0bbf:
            r2 = r10.BT();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo();	 Catch:{ Throwable -> 0x00d6 }
            r4 = 0;
            r2 = r2.get(r4);	 Catch:{ Throwable -> 0x00d6 }
            r2 = (bj) r2;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r2;
            goto L_0x0b82;
        L_0x0bd0:
            r0 = r32;
            r2 = r0.u7;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.fY;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.qp;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r10, r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x08eb;
        L_0x0be9:
            if (r10 == 0) goto L_0x0c2e;
        L_0x0beb:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x0bfe:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0c2b }
            r4 = 0;
            r2.g3 = r4;	 Catch:{ all -> 0x0c2b }
            monitor-exit(r3);	 Catch:{ all -> 0x0c2b }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.CU;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.Xa;	 Catch:{ Throwable -> 0x00d6 }
            r2.DW(r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x0c2b:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0c2b }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0c2e:
            if (r11 == 0) goto L_0x0c73;
        L_0x0c30:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x0c43:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0c70 }
            r4 = 0;
            r2.Mz = r4;	 Catch:{ all -> 0x0c70 }
            monitor-exit(r3);	 Catch:{ all -> 0x0c70 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.CU;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.Xa;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x0c70:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0c70 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0c73:
            if (r13 == 0) goto L_0x0e6a;
        L_0x0c75:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x0c88:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.Q6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r2 = r4.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0e3b;
        L_0x0ca0:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r9 = r2.FH(r4, r3, r5);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r9.j6(r2, r3, r5, r6);	 Catch:{ Throwable -> 0x00d6 }
            r3 = -1;
            if (r2 == r3) goto L_0x0cf6;
        L_0x0ce1:
            r3 = r9.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.u7();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x0cf6;
        L_0x0ceb:
            r3 = r9.tp();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.u7();	 Catch:{ Throwable -> 0x00d6 }
            r3.DW(r9, r2);	 Catch:{ Throwable -> 0x00d6 }
        L_0x0cf6:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.j6(r9, r3, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x0d9e;
        L_0x0d12:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW(r9, r5, r6);	 Catch:{ Throwable -> 0x00d6 }
            r5 = r3.qp();	 Catch:{ Throwable -> 0x00d6 }
            if (r5 == 0) goto L_0x0d33;
        L_0x0d32:
            r2 = 1;
        L_0x0d33:
            r8 = new com.aide.engine.SourceEntity;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r8.<init>(r5, r2, r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.cb;	 Catch:{ Throwable -> 0x00d6 }
            r8.j6(r2, r3, r5);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0d7e;
        L_0x0d5b:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r4.er();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.aM();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r6, r7, r8);	 Catch:{ Throwable -> 0x00d6 }
        L_0x0d7e:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r9);	 Catch:{ Throwable -> 0x00d6 }
        L_0x0d87:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x0d9b }
            r4 = 0;
            r2.dx = r4;	 Catch:{ all -> 0x0d9b }
            monitor-exit(r3);	 Catch:{ all -> 0x0d9b }
            goto L_0x050a;
        L_0x0d9b:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0d9b }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0d9e:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5(r9, r3, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0e0c;
        L_0x0dba:
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.v5;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.FH(r9, r5, r6);	 Catch:{ Throwable -> 0x00d6 }
            r8 = new com.aide.engine.SourceEntity;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r8.<init>(r5, r3, r2);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0d7e;
        L_0x0de7:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r4.er();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.aM();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r6, r7, r8);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x0d7e;
        L_0x0e0c:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0d7e;
        L_0x0e16:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r4.er();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.aM();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x0d7e;
        L_0x0e3b:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0d87;
        L_0x0e45:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r4.er();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.aM();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.kf;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.Jl;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x0d87;
        L_0x0e6a:
            if (r14 == 0) goto L_0x10e7;
        L_0x0e6c:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x0e7f:
            r11 = new com.aide.engine.ac;	 Catch:{ Throwable -> 0x00d6 }
            r11.<init>();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r2.eU;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r2.e3;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r2.sE;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r2.sg;	 Catch:{ Throwable -> 0x00d6 }
            if (r4 > r6) goto L_0x0eaa;
        L_0x0ea6:
            if (r4 != r6) goto L_0x0eca;
        L_0x0ea8:
            if (r5 <= r7) goto L_0x0eca;
        L_0x0eaa:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r2.sE;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r2.sg;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r2.eU;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r2.e3;	 Catch:{ Throwable -> 0x00d6 }
        L_0x0eca:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.iW;	 Catch:{ Throwable -> 0x00d6 }
            r12 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r2 = r12.FH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x10b1;
        L_0x0ee2:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.FH(r12, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            r2 = r3.j6(r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            r8 = -1;
            if (r2 == r8) goto L_0x0f08;
        L_0x0ef3:
            r8 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r8 = r8.u7();	 Catch:{ Throwable -> 0x00d6 }
            if (r8 == 0) goto L_0x0f08;
        L_0x0efd:
            r8 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r8 = r8.u7();	 Catch:{ Throwable -> 0x00d6 }
            r8.DW(r3, r2);	 Catch:{ Throwable -> 0x00d6 }
        L_0x0f08:
            r2 = r12.DW();	 Catch:{ Throwable -> 0x00d6 }
            r11.j6 = r2;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6();	 Catch:{ Throwable -> 0x00d6 }
            r11.aM = r2;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            r11.XL = r2;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            r11.gn = r2;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            r8 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r11.we = r8;	 Catch:{ Throwable -> 0x00d6 }
            r8 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r11.J0 = r8;	 Catch:{ Throwable -> 0x00d6 }
            r8 = r2.DW;	 Catch:{ Throwable -> 0x00d6 }
            r11.J8 = r8;	 Catch:{ Throwable -> 0x00d6 }
            r8 = r2.FH;	 Catch:{ Throwable -> 0x00d6 }
            r11.Ws = r8;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Hw;	 Catch:{ Throwable -> 0x00d6 }
            r11.QX = r2;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            r11.EQ = r2;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            r11.u7 = r2;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Hw(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            r11.tp = r2;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x101e;
        L_0x0f7e:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r2.Hw(r3, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r6 == 0) goto L_0x1066;
        L_0x0f8a:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW(r3, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            r7 = 1;
            r11.DW = r7;	 Catch:{ Throwable -> 0x00d6 }
            r11.FH = r2;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r6.cT();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x0faf;
        L_0x0f9f:
            r2 = r6.zh();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x105b;
        L_0x0fa5:
            r0 = r6;
            r0 = (bz) r0;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r0;
            r2 = r2.sy();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x105b;
        L_0x0faf:
            r2 = 1;
        L_0x0fb0:
            r11.Zo = r2;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r6.zh();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x105e;
        L_0x0fb8:
            r0 = r6;
            r0 = (bz) r0;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r0;
            r2 = r2.gn();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0fcc;
        L_0x0fc2:
            r0 = r6;
            r0 = (bz) r0;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r0;
            r2 = r2.sy();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x0fe0;
        L_0x0fcc:
            r0 = r6;
            r0 = (bz) r0;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r0;
            r2 = r2.J0();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x0fe0;
        L_0x0fd6:
            r0 = r6;
            r0 = (bz) r0;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r0;
            r2 = r2.we();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x105e;
        L_0x0fe0:
            r2 = 1;
        L_0x0fe1:
            r11.v5 = r2;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r6.tp();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x1060;
        L_0x0fe9:
            r2 = r6.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x1060;
        L_0x0ff3:
            r2 = 1;
        L_0x0ff4:
            r11.VH = r2;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r6.qp();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x101e;
        L_0x0ffc:
            r2 = 1;
            r11.FH = r2;	 Catch:{ Throwable -> 0x00d6 }
            r6 = (ce) r6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r6.u7();	 Catch:{ Throwable -> 0x00d6 }
            r6 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x100a:
            r6 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r6 == 0) goto L_0x1062;
        L_0x1012:
            r6 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.FH();	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r6 != 0) goto L_0x100a;
        L_0x101e:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.we;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6(r12, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x10a8;
        L_0x102a:
            r4 = 1;
            r11.j3 = r4;	 Catch:{ Throwable -> 0x00d6 }
            r4 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00d6 }
            r4.<init>();	 Catch:{ Throwable -> 0x00d6 }
            r11.Mr = r4;	 Catch:{ Throwable -> 0x00d6 }
            r13 = r2.iterator();	 Catch:{ Throwable -> 0x00d6 }
        L_0x1038:
            r2 = r13.hasNext();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x10a8;
        L_0x103e:
            r2 = r13.next();	 Catch:{ Throwable -> 0x00d6 }
            r2 = (au$a) r2;	 Catch:{ Throwable -> 0x00d6 }
            r14 = r11.Mr;	 Catch:{ Throwable -> 0x00d6 }
            r4 = new com.aide.engine.ac$a;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r2.DW;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r2.FH;	 Catch:{ Throwable -> 0x00d6 }
            r8 = r2.Hw;	 Catch:{ Throwable -> 0x00d6 }
            r9 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r10 = r2.Zo;	 Catch:{ Throwable -> 0x00d6 }
            r4.<init>(r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x00d6 }
            r14.add(r4);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x1038;
        L_0x105b:
            r2 = 0;
            goto L_0x0fb0;
        L_0x105e:
            r2 = 0;
            goto L_0x0fe1;
        L_0x1060:
            r2 = 0;
            goto L_0x0ff4;
        L_0x1062:
            r2 = 1;
            r11.VH = r2;	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x101e;
        L_0x1066:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.Zo(r3, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x1088;
        L_0x1072:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH(r3, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            r6 = 1;
            r11.DW = r6;	 Catch:{ Throwable -> 0x00d6 }
            r11.FH = r2;	 Catch:{ Throwable -> 0x00d6 }
            r2 = 1;
            r11.VH = r2;	 Catch:{ Throwable -> 0x00d6 }
            r2 = 1;
            r11.Hw = r2;	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x101e;
        L_0x1088:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH(r3, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x101e;
        L_0x1094:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH(r3, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            r6 = 1;
            r11.DW = r6;	 Catch:{ Throwable -> 0x00d6 }
            r11.FH = r2;	 Catch:{ Throwable -> 0x00d6 }
            r2 = 1;
            r11.VH = r2;	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x101e;
        L_0x10a8:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sh;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3);	 Catch:{ Throwable -> 0x00d6 }
        L_0x10b1:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r12.er();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.eU;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.e3;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r5, r11);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x10e4 }
            r4 = 0;
            r2.sG = r4;	 Catch:{ all -> 0x10e4 }
            monitor-exit(r3);	 Catch:{ all -> 0x10e4 }
            goto L_0x050a;
        L_0x10e4:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x10e4 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x10e7:
            if (r15 == 0) goto L_0x1145;
        L_0x10e9:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x10fc:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x1142 }
            r2 = r2.n5;	 Catch:{ all -> 0x1142 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ all -> 0x1142 }
            r5 = 0;
            r4.ef = r5;	 Catch:{ all -> 0x1142 }
            monitor-exit(r3);	 Catch:{ all -> 0x1142 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.sh;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.cb;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.VH;	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x050a;
        L_0x1135:
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.VH;	 Catch:{ Throwable -> 0x00d6 }
            r3.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x1142:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x1142 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x1145:
            if (r4 == 0) goto L_0x114c;
        L_0x1147:
            r32.Ws();	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x114c:
            if (r2 == 0) goto L_0x117b;
        L_0x114e:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x1161:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x1178 }
            r4 = 0;
            r2.gW = r4;	 Catch:{ all -> 0x1178 }
            monitor-exit(r3);	 Catch:{ all -> 0x1178 }
            r32.J8();	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x1178:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x1178 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x117b:
            if (r16 == 0) goto L_0x11f4;
        L_0x117d:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x1190:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x11f1 }
            r4 = 0;
            r2.ei = r4;	 Catch:{ all -> 0x11f1 }
            monitor-exit(r3);	 Catch:{ all -> 0x11f1 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.Cz;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.J8;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.sG;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Cz;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.EQ;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.gn(r5);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Cz;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.J0;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.Cz;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.we;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r7 = r7.pN;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x11f1:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x11f1 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x11f4:
            if (r17 == 0) goto L_0x1231;
        L_0x11f6:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x1209:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x122e }
            r4 = 0;
            r2.vJ = r4;	 Catch:{ all -> 0x122e }
            monitor-exit(r3);	 Catch:{ all -> 0x122e }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.oy;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6(r3);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x122e:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x122e }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x1231:
            if (r22 == 0) goto L_0x12fb;
        L_0x1233:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x1246:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = 0;
            r2.GK = r3;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.PH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.FH();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.BT();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x12cc;
        L_0x126a:
            r3 = r2.BT();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x12cc;
        L_0x1274:
            r3 = r2.BT();	 Catch:{ ej -> 0x18e2 }
            r3 = r3.tp();	 Catch:{ ej -> 0x18e2 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ ej -> 0x18e2 }
            r4 = r4.PH;	 Catch:{ ej -> 0x18e2 }
            r4 = r4.j6();	 Catch:{ ej -> 0x18e2 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ ej -> 0x18e2 }
            r5 = r5.PH;	 Catch:{ ej -> 0x18e2 }
            r5 = r5.DW();	 Catch:{ ej -> 0x18e2 }
            r3 = r3.j6(r2, r4, r5);	 Catch:{ ej -> 0x18e2 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ ej -> 0x18e2 }
            r5 = new com.aide.engine.k;	 Catch:{ ej -> 0x18e2 }
            r6 = r2.BT();	 Catch:{ ej -> 0x18e2 }
            r6 = r6.tp();	 Catch:{ ej -> 0x18e2 }
            r7 = r3.Xa();	 Catch:{ ej -> 0x18e2 }
            r6 = r6.j6(r7);	 Catch:{ ej -> 0x18e2 }
            r7 = r2.BT();	 Catch:{ ej -> 0x18e2 }
            r7 = r7.tp();	 Catch:{ ej -> 0x18e2 }
            r7 = r7.DW(r3);	 Catch:{ ej -> 0x18e2 }
            r2 = r2.BT();	 Catch:{ ej -> 0x18e2 }
            r2 = r2.tp();	 Catch:{ ej -> 0x18e2 }
            r2 = r2.j6(r3);	 Catch:{ ej -> 0x18e2 }
            r5.<init>(r6, r7, r2);	 Catch:{ ej -> 0x18e2 }
            r4.GK = r5;	 Catch:{ ej -> 0x18e2 }
        L_0x12cc:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x12f8 }
            r4 = 0;
            r2.br = r4;	 Catch:{ all -> 0x12f8 }
            monitor-exit(r3);	 Catch:{ all -> 0x12f8 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.aM;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x12f5 }
            r2 = r2.aM;	 Catch:{ all -> 0x12f5 }
            r2.notify();	 Catch:{ all -> 0x12f5 }
            monitor-exit(r3);	 Catch:{ all -> 0x12f5 }
            goto L_0x050a;
        L_0x12f5:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x12f5 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x12f8:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x12f8 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x12fb:
            if (r21 == 0) goto L_0x13e3;
        L_0x12fd:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x1310:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = 0;
            r2.Yi = r3;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r3.length;	 Catch:{ Throwable -> 0x00d6 }
            r2 = 0;
        L_0x1324:
            if (r2 >= r4) goto L_0x1366;
        L_0x1326:
            r5 = r3[r2];	 Catch:{ Throwable -> 0x00d6 }
            r6 = r5.tp();	 Catch:{ Throwable -> 0x00d6 }
            if (r6 == 0) goto L_0x13dc;
        L_0x132e:
            r0 = r32;
            r6 = r0.j6;	 Catch:{ ej -> 0x13db }
            r6 = r6.dW;	 Catch:{ ej -> 0x13db }
            r6 = r6.DW();	 Catch:{ ej -> 0x13db }
            if (r6 != 0) goto L_0x1392;
        L_0x133c:
            r5 = r5.tp();	 Catch:{ ej -> 0x13db }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ ej -> 0x13db }
            r6 = r6.dW;	 Catch:{ ej -> 0x13db }
            r6 = r6.j6();	 Catch:{ ej -> 0x13db }
            r5 = r5.j6(r6);	 Catch:{ ej -> 0x13db }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ ej -> 0x13db }
            r7 = new com.aide.engine.v;	 Catch:{ ej -> 0x13db }
            r5 = r5.tp();	 Catch:{ ej -> 0x13db }
            r5 = r5.er();	 Catch:{ ej -> 0x13db }
            r8 = 1;
            r9 = 1;
            r7.<init>(r5, r8, r9);	 Catch:{ ej -> 0x13db }
            r6.Yi = r7;	 Catch:{ ej -> 0x13db }
        L_0x1366:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x13e0 }
            r4 = 0;
            r2.OW = r4;	 Catch:{ all -> 0x13e0 }
            monitor-exit(r3);	 Catch:{ all -> 0x13e0 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.aM;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x138f }
            r2 = r2.aM;	 Catch:{ all -> 0x138f }
            r2.notify();	 Catch:{ all -> 0x138f }
            monitor-exit(r3);	 Catch:{ all -> 0x138f }
            goto L_0x050a;
        L_0x138f:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x138f }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x1392:
            r5 = r5.tp();	 Catch:{ ej -> 0x13db }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ ej -> 0x13db }
            r6 = r6.dW;	 Catch:{ ej -> 0x13db }
            r6 = r6.j6();	 Catch:{ ej -> 0x13db }
            r0 = r32;
            r7 = r0.j6;	 Catch:{ ej -> 0x13db }
            r7 = r7.dW;	 Catch:{ ej -> 0x13db }
            r7 = r7.DW();	 Catch:{ ej -> 0x13db }
            r0 = r32;
            r8 = r0.j6;	 Catch:{ ej -> 0x13db }
            r8 = r8.dW;	 Catch:{ ej -> 0x13db }
            r8 = r8.FH();	 Catch:{ ej -> 0x13db }
            r5 = r5.j6(r6, r7, r8);	 Catch:{ ej -> 0x13db }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ ej -> 0x13db }
            r7 = new com.aide.engine.v;	 Catch:{ ej -> 0x13db }
            r8 = r5.tp();	 Catch:{ ej -> 0x13db }
            r8 = r8.er();	 Catch:{ ej -> 0x13db }
            r9 = r5.er();	 Catch:{ ej -> 0x13db }
            r5 = r5.gW();	 Catch:{ ej -> 0x13db }
            r7.<init>(r8, r9, r5);	 Catch:{ ej -> 0x13db }
            r6.Yi = r7;	 Catch:{ ej -> 0x13db }
            goto L_0x1366;
        L_0x13db:
            r5 = move-exception;
        L_0x13dc:
            r2 = r2 + 1;
            goto L_0x1324;
        L_0x13e0:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x13e0 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x13e3:
            if (r23 == 0) goto L_0x1482;
        L_0x13e5:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x13f8:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = new java.util.Stack;	 Catch:{ Throwable -> 0x00d6 }
            r3.<init>();	 Catch:{ Throwable -> 0x00d6 }
            r2.Ej = r3;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.oh;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.BT();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x1449;
        L_0x141c:
            r3 = r2.BT();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.tp();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x1449;
        L_0x1426:
            r3 = r2.BT();	 Catch:{ ej -> 0x1475 }
            r3 = r3.tp();	 Catch:{ ej -> 0x1475 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ ej -> 0x1475 }
            r4 = r4.pl;	 Catch:{ ej -> 0x1475 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ ej -> 0x1475 }
            r5 = r5.Hl;	 Catch:{ ej -> 0x1475 }
            r0 = r32;
            r6 = r0.j6;	 Catch:{ ej -> 0x1475 }
            r6 = r6.GT;	 Catch:{ ej -> 0x1475 }
            r3.j6(r2, r4, r5, r6);	 Catch:{ ej -> 0x1475 }
        L_0x1449:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x147f }
            r4 = 0;
            r2.XX = r4;	 Catch:{ all -> 0x147f }
            monitor-exit(r3);	 Catch:{ all -> 0x147f }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.aM;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x1472 }
            r2 = r2.aM;	 Catch:{ all -> 0x1472 }
            r2.notify();	 Catch:{ all -> 0x1472 }
            monitor-exit(r3);	 Catch:{ all -> 0x1472 }
            goto L_0x050a;
        L_0x1472:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x1472 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x1475:
            r2 = move-exception;
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = 0;
            r2.Ej = r3;	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x1449;
        L_0x147f:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x147f }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x1482:
            if (r28 == 0) goto L_0x14cc;
        L_0x1484:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x14c9 }
            r4 = 0;
            r2.jJ = r4;	 Catch:{ all -> 0x14c9 }
            monitor-exit(r3);	 Catch:{ all -> 0x14c9 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.cn;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.Gj;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW(r3);	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.BT();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x050a;
        L_0x14ae:
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.XL;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.pO;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.fN;	 Catch:{ Throwable -> 0x00d6 }
            r3.FH(r2, r4, r5);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x050a;
        L_0x14c9:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x14c9 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x14cc:
            if (r6 != 0) goto L_0x14d8;
        L_0x14ce:
            if (r7 != 0) goto L_0x14d8;
        L_0x14d0:
            if (r8 != 0) goto L_0x14d8;
        L_0x14d2:
            if (r9 != 0) goto L_0x14d8;
        L_0x14d4:
            if (r20 != 0) goto L_0x14d8;
        L_0x14d6:
            if (r19 == 0) goto L_0x050a;
        L_0x14d8:
            r0 = r32;
            r2 = r0.Hw;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x14e5:
            r0 = r32;
            r2 = r0.Hw;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x150d;
        L_0x14f5:
            r0 = r32;
            r2 = r0.Hw;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.J8;	 Catch:{ Throwable -> 0x00d6 }
            r3.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x14e5;
        L_0x150d:
            r2 = 0;
            r5 = r2;
        L_0x150f:
            r4 = 0;
            r2 = 0;
            r3 = 0;
            r0 = r32;
            r6 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r6);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r10 = r0.j6;	 Catch:{ all -> 0x174e }
            r10 = r10.b1;	 Catch:{ all -> 0x174e }
            r10 = r10.isEmpty();	 Catch:{ all -> 0x174e }
            if (r10 != 0) goto L_0x155c;
        L_0x1529:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x174e }
            r2 = r2.b1;	 Catch:{ all -> 0x174e }
            r2 = r2.pop();	 Catch:{ all -> 0x174e }
            r2 = (java.lang.String) r2;	 Catch:{ all -> 0x174e }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ all -> 0x174e }
            r3 = r3.AR;	 Catch:{ all -> 0x174e }
            r3 = r3.pop();	 Catch:{ all -> 0x174e }
            r3 = (java.lang.Integer) r3;	 Catch:{ all -> 0x174e }
            r4 = r3.intValue();	 Catch:{ all -> 0x174e }
            r0 = r32;
            r3 = r0.j6;	 Catch:{ all -> 0x174e }
            r3 = r3.TI;	 Catch:{ all -> 0x174e }
            r3 = r3.pop();	 Catch:{ all -> 0x174e }
            r3 = (java.io.Reader) r3;	 Catch:{ all -> 0x174e }
            r31 = r4;
            r4 = r2;
            r2 = r31;
        L_0x155c:
            monitor-exit(r6);	 Catch:{ all -> 0x174e }
            if (r4 != 0) goto L_0x1751;
        L_0x155f:
            if (r5 != 0) goto L_0x00cc;
        L_0x1561:
            r2 = 0;
            r0 = r32;
            r3 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ all -> 0x178a }
            r4 = r4.PT;	 Catch:{ all -> 0x178a }
            r4 = r4.isEmpty();	 Catch:{ all -> 0x178a }
            if (r4 != 0) goto L_0x1587;
        L_0x1579:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x178a }
            r2 = r2.PT;	 Catch:{ all -> 0x178a }
            r2 = r2.pop();	 Catch:{ all -> 0x178a }
            r2 = (java.lang.String) r2;	 Catch:{ all -> 0x178a }
        L_0x1587:
            monitor-exit(r3);	 Catch:{ all -> 0x178a }
            if (r2 != 0) goto L_0x178d;
        L_0x158a:
            r0 = r32;
            r2 = r0.gW;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x15b6;
        L_0x1590:
            r2 = 0;
            r0 = r32;
            r0.gW = r2;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x17b4 }
            r2 = r2.XL;	 Catch:{ all -> 0x17b4 }
            r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
            r2.wait(r4);	 Catch:{ all -> 0x17b4 }
            monitor-exit(r3);	 Catch:{ all -> 0x17b4 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.VH();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x15b6:
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r18;
            r2.FH(r0);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.v5;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x00cc;
        L_0x15c9:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x17b7 }
            r4 = 0;
            r2.nw = r4;	 Catch:{ all -> 0x17b7 }
            monitor-exit(r3);	 Catch:{ all -> 0x17b7 }
            r0 = r32;
            r1 = r20;
            r0.j6(r7, r8, r9, r1);	 Catch:{ Throwable -> 0x00d6 }
            if (r19 == 0) goto L_0x050a;
        L_0x15e4:
            java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x17ba }
            r2 = r2.xg;	 Catch:{ all -> 0x17ba }
            r0 = r32;
            r4 = r0.j6;	 Catch:{ all -> 0x17ba }
            r4 = r4.sT;	 Catch:{ all -> 0x17ba }
            r0 = r32;
            r5 = r0.j6;	 Catch:{ all -> 0x17ba }
            r5 = r5.E4;	 Catch:{ all -> 0x17ba }
            monitor-exit(r3);	 Catch:{ all -> 0x17ba }
            r0 = r32;
            r3 = r0.j6(r4, r2);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW;	 Catch:{ Throwable -> 0x00d6 }
            r4 = 2;
            r4 = r2.DW(r3, r4);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW;	 Catch:{ Throwable -> 0x00d6 }
            r6 = 2;
            r2 = r2.j6(r4, r6);	 Catch:{ Throwable -> 0x00d6 }
            r4.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW;	 Catch:{ Throwable -> 0x00d6 }
            r6 = 3;
            r2 = r2.j6(r3, r6);	 Catch:{ Throwable -> 0x00d6 }
            r4.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW;	 Catch:{ Throwable -> 0x00d6 }
            r6 = 15;
            r2 = r2.DW(r3, r6);	 Catch:{ Throwable -> 0x00d6 }
            r4.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW;	 Catch:{ Throwable -> 0x00d6 }
            r2.Hw();	 Catch:{ Throwable -> 0x00d6 }
            r2 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00d6 }
            r2.<init>();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6(r5, r2);	 Catch:{ Throwable -> 0x00d6 }
            r3.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            r4.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            if (r2 != 0) goto L_0x16a5;
        L_0x1669:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r5 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00d6 }
            r5.<init>();	 Catch:{ Throwable -> 0x00d6 }
            r2.hp = r5;	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            r5 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00d6 }
            r5.<init>();	 Catch:{ Throwable -> 0x00d6 }
            r2.add(r5);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            r5 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00d6 }
            r5.<init>();	 Catch:{ Throwable -> 0x00d6 }
            r2.add(r5);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            r5 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00d6 }
            r5.<init>();	 Catch:{ Throwable -> 0x00d6 }
            r2.add(r5);	 Catch:{ Throwable -> 0x00d6 }
        L_0x16a5:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            r5 = 0;
            r2 = r2.get(r5);	 Catch:{ Throwable -> 0x00d6 }
            r2 = (java.util.List) r2;	 Catch:{ Throwable -> 0x00d6 }
            r2.clear();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            r5 = 1;
            r2 = r2.get(r5);	 Catch:{ Throwable -> 0x00d6 }
            r2 = (java.util.List) r2;	 Catch:{ Throwable -> 0x00d6 }
            r2.clear();	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            r5 = 2;
            r2 = r2.get(r5);	 Catch:{ Throwable -> 0x00d6 }
            r2 = (java.util.List) r2;	 Catch:{ Throwable -> 0x00d6 }
            r2.clear();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r4.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x16e0:
            r2 = r4.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x17bd;
        L_0x16e8:
            r2 = r4.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r5 == 0) goto L_0x16e0;
        L_0x16f8:
            r5 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.BT();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.tp();	 Catch:{ Throwable -> 0x00d6 }
            if (r5 == 0) goto L_0x16e0;
        L_0x1706:
            r0 = r32;
            r5 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.cn;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Hw(r6);	 Catch:{ Throwable -> 0x00d6 }
            if (r5 == 0) goto L_0x16e0;
        L_0x1716:
            r5 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.BT();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.FH(r2);	 Catch:{ Throwable -> 0x00d6 }
            r6 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.BT();	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r6.Hw(r2);	 Catch:{ Throwable -> 0x00d6 }
            r6 = new com.aide.engine.w;	 Catch:{ Throwable -> 0x00d6 }
            r6.<init>(r5, r2);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            r5 = 0;
            r2 = r2.get(r5);	 Catch:{ Throwable -> 0x00d6 }
            r2 = (java.util.List) r2;	 Catch:{ Throwable -> 0x00d6 }
            r2.add(r6);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x16e0;
        L_0x174e:
            r2 = move-exception;
            monitor-exit(r6);	 Catch:{ all -> 0x174e }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x1751:
            r0 = r32;
            r5 = r0.FH;	 Catch:{ all -> 0x1780 }
            r5 = r5.cn;	 Catch:{ all -> 0x1780 }
            r4 = r5.DW(r4);	 Catch:{ all -> 0x1780 }
            r5 = r4.BT();	 Catch:{ all -> 0x1780 }
            if (r5 == 0) goto L_0x1774;
        L_0x1761:
            r0 = r32;
            r5 = r0.FH;	 Catch:{ all -> 0x1780 }
            r5 = r5.cn;	 Catch:{ all -> 0x1780 }
            r3 = r5.j6(r3);	 Catch:{ all -> 0x1780 }
            r0 = r32;
            r5 = r0.FH;	 Catch:{ all -> 0x1780 }
            r5 = r5.J8;	 Catch:{ all -> 0x1780 }
            r5.j6(r4, r2, r3);	 Catch:{ all -> 0x1780 }
        L_0x1774:
            r3.close();	 Catch:{ IOException -> 0x177b }
        L_0x1777:
            r2 = 1;
            r5 = r2;
            goto L_0x150f;
        L_0x177b:
            r2 = move-exception;
            com.aide.common.e.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x1777;
        L_0x1780:
            r2 = move-exception;
            r3.close();	 Catch:{ IOException -> 0x1785 }
        L_0x1784:
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x1785:
            r3 = move-exception;
            com.aide.common.e.j6(r3);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x1784;
        L_0x178a:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x178a }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x178d:
            r0 = r32;
            r3 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.cn;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r3.DW(r2);	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.BT();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x1561;
        L_0x179d:
            r3 = r2.BT();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.EQ();	 Catch:{ Throwable -> 0x00d6 }
            if (r3 == 0) goto L_0x1561;
        L_0x17a7:
            r3 = r2.BT();	 Catch:{ Throwable -> 0x00d6 }
            r3 = r3.EQ();	 Catch:{ Throwable -> 0x00d6 }
            r3.j6(r2);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x1561;
        L_0x17b4:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x17b4 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x17b7:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x17b7 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x17ba:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x17ba }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x17bd:
            r2 = r4.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x17c2:
            r2 = r4.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x1830;
        L_0x17ca:
            r2 = r4.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r5 == 0) goto L_0x17c2;
        L_0x17da:
            r5 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.BT();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.tp();	 Catch:{ Throwable -> 0x00d6 }
            if (r5 == 0) goto L_0x17c2;
        L_0x17e8:
            r0 = r32;
            r5 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.cn;	 Catch:{ Throwable -> 0x00d6 }
            r6 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.Hw(r6);	 Catch:{ Throwable -> 0x00d6 }
            if (r5 == 0) goto L_0x17c2;
        L_0x17f8:
            r5 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.BT();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.FH(r2);	 Catch:{ Throwable -> 0x00d6 }
            r6 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.BT();	 Catch:{ Throwable -> 0x00d6 }
            r6 = r6.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r6.Hw(r2);	 Catch:{ Throwable -> 0x00d6 }
            r6 = new com.aide.engine.w;	 Catch:{ Throwable -> 0x00d6 }
            r6.<init>(r5, r2);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            r5 = 1;
            r2 = r2.get(r5);	 Catch:{ Throwable -> 0x00d6 }
            r2 = (java.util.List) r2;	 Catch:{ Throwable -> 0x00d6 }
            r2.add(r6);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x17c2;
        L_0x1830:
            r2 = r3.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2.j6();	 Catch:{ Throwable -> 0x00d6 }
        L_0x1835:
            r2 = r3.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r2 == 0) goto L_0x18a3;
        L_0x183d:
            r2 = r3.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.FH();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.DW();	 Catch:{ Throwable -> 0x00d6 }
            if (r4 == 0) goto L_0x1835;
        L_0x184d:
            r4 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.BT();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.tp();	 Catch:{ Throwable -> 0x00d6 }
            if (r4 == 0) goto L_0x1835;
        L_0x185b:
            r0 = r32;
            r4 = r0.FH;	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.cn;	 Catch:{ Throwable -> 0x00d6 }
            r5 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.Hw(r5);	 Catch:{ Throwable -> 0x00d6 }
            if (r4 == 0) goto L_0x1835;
        L_0x186b:
            r4 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.BT();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.tp();	 Catch:{ Throwable -> 0x00d6 }
            r4 = r4.FH(r2);	 Catch:{ Throwable -> 0x00d6 }
            r5 = r2.tp();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.BT();	 Catch:{ Throwable -> 0x00d6 }
            r5 = r5.tp();	 Catch:{ Throwable -> 0x00d6 }
            r2 = r5.Hw(r2);	 Catch:{ Throwable -> 0x00d6 }
            r5 = new com.aide.engine.w;	 Catch:{ Throwable -> 0x00d6 }
            r5.<init>(r4, r2);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r2 = r2.hp;	 Catch:{ Throwable -> 0x00d6 }
            r4 = 2;
            r2 = r2.get(r4);	 Catch:{ Throwable -> 0x00d6 }
            r2 = (java.util.List) r2;	 Catch:{ Throwable -> 0x00d6 }
            r2.add(r5);	 Catch:{ Throwable -> 0x00d6 }
            goto L_0x1835;
        L_0x18a3:
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.XL;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x18cf }
            r4 = 0;
            r2.aj = r4;	 Catch:{ all -> 0x18cf }
            monitor-exit(r3);	 Catch:{ all -> 0x18cf }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ Throwable -> 0x00d6 }
            r3 = r2.aM;	 Catch:{ Throwable -> 0x00d6 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x00d6 }
            r0 = r32;
            r2 = r0.j6;	 Catch:{ all -> 0x18cc }
            r2 = r2.aM;	 Catch:{ all -> 0x18cc }
            r2.notify();	 Catch:{ all -> 0x18cc }
            monitor-exit(r3);	 Catch:{ all -> 0x18cc }
            goto L_0x050a;
        L_0x18cc:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x18cc }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x18cf:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x18cf }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x18d2:
            r2 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x18d2 }
            throw r2;	 Catch:{ Throwable -> 0x00d6 }
        L_0x18d5:
            r0 = r32;
            r3 = r0.j6;
            r3 = r3.v5;
            r3.j6(r2);
            goto L_0x00f0;
        L_0x18e2:
            r2 = move-exception;
            goto L_0x12cc;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aide.engine.b.b.J0():void");
        }

        private void J8() {
            if (this.j6.ye) {
                this.FH.Zo.j6(this.j6.WB);
                return;
            }
            bv DW = this.FH.cn.DW(this.j6.et);
            if (!DW.FH() || !DW.j6()) {
                return;
            }
            if (this.j6.FN) {
                this.FH.Zo.j6(DW, this.j6.aq);
            } else if (this.j6.Ev) {
                this.FH.gn.Hw(DW, this.j6.Eq, this.j6.hz, true);
            } else if (this.j6.mb) {
                this.FH.gn.j6(DW, this.j6.Eq, this.j6.hz);
            } else if (this.j6.jO) {
                this.FH.gn.j6(DW, this.j6.Eq, this.j6.hz, true);
            } else if (this.j6.ko) {
                this.FH.gn.FH(DW, this.j6.Eq, this.j6.hz, true);
            } else if (this.j6.oY) {
                this.FH.gn.DW(DW, this.j6.Eq, this.j6.hz, true);
            } else {
                this.FH.Zo.j6(DW, this.j6.Eq, this.j6.hz, this.j6.aq);
            }
        }

        private void Ws() {
            switch (1.j6[this.j6.aX.ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    this.FH.FH(this.j6.vy);
                    if (this.v5.DW()) {
                        return;
                    }
                    break;
            }
            synchronized (this.j6.XL) {
                this.j6.cb = false;
            }
            synchronized (this.j6.XL) {
                c ct = this.j6.aX;
                this.j6.aX = null;
            }
            if (this.j6.a5 > this.j6.IS || (this.j6.a5 == this.j6.IS && this.j6.ys > this.j6.gG)) {
                int Fd = this.j6.a5;
                this.j6.a5 = this.j6.IS;
                this.j6.IS = Fd;
                Fd = this.j6.ys;
                this.j6.ys = this.j6.gG;
                this.j6.gG = Fd;
            }
            if (ct == c.RENAME_FILE) {
                this.FH.u7.j6(this.FH.cn.DW(this.j6.e9), this.j6.QO);
            } else if (ct == c.MOVE) {
                List arrayList = new ArrayList();
                for (String DW : this.j6.Bx) {
                    arrayList.add(this.FH.cn.DW(DW));
                }
                this.FH.tp.j6(arrayList, this.FH.cn.DW(this.j6.oa));
            } else if (ct == c.CONVERT_PROJECT) {
                this.FH.rN.DW();
                eb ebVar = new eb(this.FH.cn);
                ebVar.j6(this.FH.cn.Hw());
                ebVar.j6.j6();
                while (ebVar.j6.DW()) {
                    this.FH.j3.j6(ebVar.j6.FH(), this.j6.BR);
                }
                this.FH.rN.aM();
            } else {
                bv DW2 = this.FH.cn.DW(this.j6.e9);
                switch (1.j6[ct.ordinal()]) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    case 5:
                    case 6:
                    case 8:
                        if (DW2.BT() == null) {
                            this.j6.Of = null;
                            synchronized (this.j6.j3) {
                                this.j6.j3.notify();
                                break;
                            }
                            return;
                        }
                        break;
                    default:
                        if (!DW2.j6()) {
                            this.FH.rN.j6();
                            return;
                        }
                        break;
                }
                if (ct == c.INIT_RENAME) {
                    this.FH.u7.j6(DW2, this.j6.a5, this.j6.ys);
                } else if (ct == c.DO_RENAME) {
                    this.FH.u7.j6(DW2, this.j6.a5, this.j6.ys, this.j6.QO);
                } else if (ct == c.INIT_MOVE) {
                    this.FH.tp.j6(DW2, this.j6.a5, this.j6.ys);
                } else if (ct == c.DO_MOVE) {
                    this.FH.tp.j6(DW2, this.j6.a5, this.j6.ys, this.j6.QO);
                } else if (ct == c.INIT_CHANGE_SIGNATURE) {
                    this.FH.we.DW(DW2, this.j6.a5, this.j6.ys);
                } else if (ct == c.DO_CHANGE_SIGNATURE) {
                    this.FH.we.j6(DW2, this.j6.a5, this.j6.ys, this.j6.Jm.j6, this.j6.Jm.DW, this.j6.Jm.FH, this.j6.Jm.Hw);
                } else if (ct == c.ORGANIZE) {
                    this.FH.J0.j6(DW2, this.j6.qP);
                } else if (ct == c.ADD_IMPORT) {
                    this.FH.J0.j6(DW2, (co) this.FH.cb.FH(this.j6.MP.VH()));
                } else if (ct == c.SURROUND_WITH_TRYCATCH) {
                    this.FH.j3.v5(DW2, this.j6.a5, this.j6.ys, this.j6.IS, this.j6.gG);
                } else if (ct == c.REPLACE_TEXT) {
                    this.FH.u7.j6(DW2, this.j6.a5, this.j6.ys, this.j6.IS, this.j6.gG, this.j6.sM, this.j6.QO);
                } else if (ct == c.DO_EXTRACT_RESOURCES) {
                    this.FH.j3.j6(DW2, this.FH.cn.DW(this.j6.oa), this.j6.a5, this.j6.ys, this.j6.IS, this.j6.gG);
                } else if (ct == c.DO_EXTRACT) {
                    if (this.j6.a5 > this.j6.IS || (this.j6.a5 == this.j6.IS && this.j6.ys > this.j6.gG)) {
                        r0 = this.j6.a5;
                        r2 = this.j6.ys;
                        this.j6.a5 = this.j6.IS;
                        this.j6.ys = this.j6.gG;
                        this.j6.IS = r0;
                        this.j6.gG = r2;
                    }
                    this.FH.j3.Hw(DW2, this.j6.a5, this.j6.ys, this.j6.IS, this.j6.gG);
                } else if (ct == c.DOCUMENTIZE) {
                    this.FH.j3.Hw(DW2, this.j6.a5, this.j6.ys);
                } else if (ct == c.DOCUMENTIZE_FILE) {
                    this.FH.j3.FH(DW2, this.j6.a5, this.j6.ys);
                } else if (ct == c.CREATE_PROPERTY) {
                    if (this.j6.a5 > this.j6.IS || (this.j6.a5 == this.j6.IS && this.j6.ys > this.j6.gG)) {
                        r0 = this.j6.a5;
                        r2 = this.j6.ys;
                        this.j6.a5 = this.j6.IS;
                        this.j6.ys = this.j6.gG;
                        this.j6.IS = r0;
                        this.j6.gG = r2;
                    }
                    this.FH.j3.FH(DW2, this.j6.a5, this.j6.ys, this.j6.IS, this.j6.gG);
                } else if (ct == c.CREATE_CONSTRUCTOR) {
                    if (this.j6.a5 > this.j6.IS || (this.j6.a5 == this.j6.IS && this.j6.ys > this.j6.gG)) {
                        r0 = this.j6.a5;
                        r2 = this.j6.ys;
                        this.j6.a5 = this.j6.IS;
                        this.j6.ys = this.j6.gG;
                        this.j6.IS = r0;
                        this.j6.gG = r2;
                    }
                    this.FH.j3.DW(DW2, this.j6.a5, this.j6.ys, this.j6.IS, this.j6.gG);
                } else if (ct == c.IMPLEMENT) {
                    this.FH.j3.DW(DW2, this.j6.a5, this.j6.ys);
                } else if (ct == c.OVERRIDE) {
                    this.FH.j3.j6(DW2, this.j6.a5, this.j6.ys, (bz) this.FH.cb.FH(this.j6.n5.VH()));
                } else if (ct == c.INLINE_VARIABLE) {
                    this.FH.j3.j6(DW2, this.j6.a5, this.j6.ys);
                } else if (ct == c.INLINE_METHOD) {
                    this.FH.EQ.j6(DW2, this.j6.a5, this.j6.ys);
                } else if (ct == c.INIT_INTRODUCE_VARIABLE) {
                    if (this.j6.a5 > this.j6.IS || (this.j6.a5 == this.j6.IS && this.j6.ys > this.j6.gG)) {
                        r0 = this.j6.a5;
                        r2 = this.j6.ys;
                        this.j6.a5 = this.j6.IS;
                        this.j6.ys = this.j6.gG;
                        this.j6.IS = r0;
                        this.j6.gG = r2;
                    }
                    this.FH.j3.j6(DW2, this.j6.a5, this.j6.ys, this.j6.IS, this.j6.gG);
                } else if (ct == c.AUTOFORMAT) {
                    this.FH.QX.Hw(DW2, this.j6.a5, this.j6.IS, this.j6.Nh);
                } else if (ct == c.AUTOFORMAT_ASYNC) {
                    this.FH.QX.FH(DW2, this.j6.a5, this.j6.IS, this.j6.Nh);
                } else if (ct == c.AUTOINDENTAFTERPASTE) {
                    this.FH.QX.v5(DW2, this.j6.a5, this.j6.IS, this.j6.Nh);
                } else if (ct == c.LEARN) {
                    this.FH.QX.j6(DW2, this.j6.Nh);
                } else if (ct == c.INDENT_AFTER_ENTER) {
                    this.gW = true;
                    this.FH.QX.DW(DW2, this.j6.a5, this.j6.ys, this.j6.Nh);
                } else if (ct == c.INDENT_AFTER_TYPING) {
                    this.FH.QX.j6(DW2, this.j6.a5, this.j6.ys, this.j6.Nh);
                } else if (ct == c.OUTCOMMENT) {
                    this.FH.XL.j6(DW2, this.j6.a5, this.j6.IS);
                } else if (ct == c.UNOUTCOMMENT) {
                    this.FH.XL.DW(DW2, this.j6.a5, this.j6.IS);
                } else if (ct == c.CONVERT_FILE) {
                    this.FH.rN.DW();
                    this.FH.j3.j6(DW2, this.j6.BR);
                    this.FH.rN.j3();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void j6(boolean r14, boolean r15, boolean r16, boolean r17) {
            /*
            r13 = this;
            r8 = new do;	 Catch:{ ei -> 0x0032 }
            r8.<init>();	 Catch:{ ei -> 0x0032 }
            r0 = r13.Hw;	 Catch:{ ei -> 0x0032 }
            r0 = r0.FH();	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0.j6();	 Catch:{ ei -> 0x0032 }
        L_0x0010:
            r0 = r13.Hw;	 Catch:{ ei -> 0x0032 }
            r0 = r0.FH();	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.DW();	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x003a;
        L_0x001e:
            r0 = r13.Hw;	 Catch:{ ei -> 0x0032 }
            r0 = r0.FH();	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.FH();	 Catch:{ ei -> 0x0032 }
            r0 = r0.vy();	 Catch:{ ei -> 0x0032 }
            r8.DW(r0);	 Catch:{ ei -> 0x0032 }
            goto L_0x0010;
        L_0x0032:
            r0 = move-exception;
            r1 = r13.j6;
            r2 = 1;
            r1.nw = r2;
            throw r0;
        L_0x003a:
            r2 = 0;
        L_0x003b:
            r0 = r8.Hw();	 Catch:{ ei -> 0x0032 }
            if (r2 >= r0) goto L_0x0083;
        L_0x0041:
            r1 = r2 + 1;
            r0 = r2;
        L_0x0044:
            r3 = r8.Hw();	 Catch:{ ei -> 0x0032 }
            if (r1 >= r3) goto L_0x0072;
        L_0x004a:
            r3 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r3 = r3.cn;	 Catch:{ ei -> 0x0032 }
            r4 = r8.FH(r0);	 Catch:{ ei -> 0x0032 }
            r3 = r3.gn(r4);	 Catch:{ ei -> 0x0032 }
            r4 = r3.aM();	 Catch:{ ei -> 0x0032 }
            r3 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r3 = r3.cn;	 Catch:{ ei -> 0x0032 }
            r6 = r8.FH(r1);	 Catch:{ ei -> 0x0032 }
            r3 = r3.gn(r6);	 Catch:{ ei -> 0x0032 }
            r6 = r3.aM();	 Catch:{ ei -> 0x0032 }
            r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r3 >= 0) goto L_0x006f;
        L_0x006e:
            r0 = r1;
        L_0x006f:
            r1 = r1 + 1;
            goto L_0x0044;
        L_0x0072:
            r1 = r8.FH(r2);	 Catch:{ ei -> 0x0032 }
            r3 = r8.FH(r0);	 Catch:{ ei -> 0x0032 }
            r8.j6(r2, r3);	 Catch:{ ei -> 0x0032 }
            r8.j6(r0, r1);	 Catch:{ ei -> 0x0032 }
            r2 = r2 + 1;
            goto L_0x003b;
        L_0x0083:
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r0.j6();	 Catch:{ ei -> 0x0032 }
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r1 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r1 = r1.cn;	 Catch:{ ei -> 0x0032 }
            r1 = r1.Hw();	 Catch:{ ei -> 0x0032 }
            r0.j6(r1);	 Catch:{ ei -> 0x0032 }
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r1 = r13.Hw;	 Catch:{ ei -> 0x0032 }
            r1 = r1.FH();	 Catch:{ ei -> 0x0032 }
            r0.j6(r1);	 Catch:{ ei -> 0x0032 }
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r0.XL;	 Catch:{ ei -> 0x0032 }
            monitor-enter(r1);	 Catch:{ ei -> 0x0032 }
            r0 = r13.j6;	 Catch:{ all -> 0x00f2 }
            r0 = r0.Fd;	 Catch:{ all -> 0x00f2 }
            r2 = r13.j6;	 Catch:{ all -> 0x00f2 }
            r2 = r2.ct;	 Catch:{ all -> 0x00f2 }
            monitor-exit(r1);	 Catch:{ all -> 0x00f2 }
            r1 = r13.rN;	 Catch:{ ei -> 0x0032 }
            r1.j6();	 Catch:{ ei -> 0x0032 }
            if (r17 == 0) goto L_0x00fc;
        L_0x00bb:
            r0 = r13.DW(r2, r0);	 Catch:{ ei -> 0x0032 }
            r1 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r1.j6();	 Catch:{ ei -> 0x0032 }
        L_0x00c4:
            r1 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.DW();	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x00f5;
        L_0x00cc:
            r1 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.FH();	 Catch:{ ei -> 0x0032 }
            r2 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r2 = r2.cn;	 Catch:{ ei -> 0x0032 }
            r2 = r2.Hw(r1);	 Catch:{ ei -> 0x0032 }
            if (r2 == 0) goto L_0x00c4;
        L_0x00dc:
            r2 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r2 = r2.Lz;	 Catch:{ ei -> 0x0032 }
            r3 = r1.er();	 Catch:{ ei -> 0x0032 }
            r2 = r2.containsKey(r3);	 Catch:{ ei -> 0x0032 }
            if (r2 != 0) goto L_0x00c4;
        L_0x00ec:
            r2 = r13.rN;	 Catch:{ ei -> 0x0032 }
            r2.j6(r1);	 Catch:{ ei -> 0x0032 }
            goto L_0x00c4;
        L_0x00f2:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00f2 }
            throw r0;	 Catch:{ ei -> 0x0032 }
        L_0x00f5:
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r1 = r13.rN;	 Catch:{ ei -> 0x0032 }
            r0.j6(r1);	 Catch:{ ei -> 0x0032 }
        L_0x00fc:
            r0 = new ec;	 Catch:{ ei -> 0x0032 }
            r0.<init>();	 Catch:{ ei -> 0x0032 }
            r1 = r13.yS;	 Catch:{ ei -> 0x0032 }
            r1 = r1.j6;	 Catch:{ ei -> 0x0032 }
            r1.j6();	 Catch:{ ei -> 0x0032 }
        L_0x0108:
            r1 = r13.yS;	 Catch:{ ei -> 0x0032 }
            r1 = r1.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.DW();	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x012c;
        L_0x0112:
            r1 = r13.yS;	 Catch:{ ei -> 0x0032 }
            r1 = r1.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.FH();	 Catch:{ ei -> 0x0032 }
            r2 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r2 = r2.cn;	 Catch:{ ei -> 0x0032 }
            r2 = r2.gn(r1);	 Catch:{ ei -> 0x0032 }
            r2 = r2.j3();	 Catch:{ ei -> 0x0032 }
            if (r2 != 0) goto L_0x0108;
        L_0x0128:
            r0.j6(r1);	 Catch:{ ei -> 0x0032 }
            goto L_0x0108;
        L_0x012c:
            r1 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r1.j6();	 Catch:{ ei -> 0x0032 }
        L_0x0131:
            r1 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.DW();	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x0145;
        L_0x0139:
            r1 = r13.yS;	 Catch:{ ei -> 0x0032 }
            r2 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r2 = r2.FH();	 Catch:{ ei -> 0x0032 }
            r1.j6(r2);	 Catch:{ ei -> 0x0032 }
            goto L_0x0131;
        L_0x0145:
            r0 = r13.er;	 Catch:{ ei -> 0x0032 }
            r0.j6();	 Catch:{ ei -> 0x0032 }
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0.j6();	 Catch:{ ei -> 0x0032 }
        L_0x0151:
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.DW();	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x0193;
        L_0x015b:
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.FH();	 Catch:{ ei -> 0x0032 }
            r1 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r1 = r1.DW;	 Catch:{ ei -> 0x0032 }
            r1 = r1.j6(r0);	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x018d;
        L_0x016d:
            if (r14 != 0) goto L_0x0171;
        L_0x016f:
            if (r16 == 0) goto L_0x017b;
        L_0x0171:
            r1 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r1 = r1.dx;	 Catch:{ ei -> 0x0032 }
            r1 = r1.VH(r0);	 Catch:{ ei -> 0x0032 }
            if (r1 != 0) goto L_0x018d;
        L_0x017b:
            if (r15 == 0) goto L_0x0151;
        L_0x017d:
            r1 = r0.BT();	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x0151;
        L_0x0183:
            r1 = r0.BT();	 Catch:{ ei -> 0x0032 }
            r1 = r1.u7();	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x0151;
        L_0x018d:
            r1 = r13.er;	 Catch:{ ei -> 0x0032 }
            r1.j6(r0);	 Catch:{ ei -> 0x0032 }
            goto L_0x0151;
        L_0x0193:
            r0 = r13.er;	 Catch:{ ei -> 0x0032 }
            r0 = r0.FH();	 Catch:{ ei -> 0x0032 }
            if (r0 <= 0) goto L_0x01a4;
        L_0x019b:
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.Zo;	 Catch:{ ei -> 0x0032 }
            r0.FH();	 Catch:{ ei -> 0x0032 }
        L_0x01a4:
            r0 = r13.er;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0.j6();	 Catch:{ ei -> 0x0032 }
        L_0x01ab:
            r0 = r13.er;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.DW();	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x01cb;
        L_0x01b5:
            r0 = r13.er;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.FH();	 Catch:{ ei -> 0x0032 }
            r1 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.Zo;	 Catch:{ ei -> 0x0032 }
            r0 = r0.er();	 Catch:{ ei -> 0x0032 }
            r1.j6(r0);	 Catch:{ ei -> 0x0032 }
            goto L_0x01ab;
        L_0x01cb:
            if (r15 == 0) goto L_0x01d4;
        L_0x01cd:
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.dx;	 Catch:{ ei -> 0x0032 }
            r0.FH();	 Catch:{ ei -> 0x0032 }
        L_0x01d4:
            r0 = r13.er;	 Catch:{ ei -> 0x0032 }
            r0.j6();	 Catch:{ ei -> 0x0032 }
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0.j6();	 Catch:{ ei -> 0x0032 }
            r1 = 0;
            r0 = 0;
            r12 = r0;
            r0 = r1;
            r1 = r12;
        L_0x01e5:
            r2 = 0;
            if (r0 != 0) goto L_0x022c;
        L_0x01e8:
            r0 = 0;
        L_0x01e9:
            r4 = 0;
            r3 = r8.Hw();	 Catch:{ ei -> 0x0032 }
            if (r1 >= r3) goto L_0x0231;
        L_0x01f0:
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.cn;	 Catch:{ ei -> 0x0032 }
            r2 = r8.FH(r1);	 Catch:{ ei -> 0x0032 }
            r0 = r0.gn(r2);	 Catch:{ ei -> 0x0032 }
            r2 = 1;
            r1 = r1 + 1;
            r7 = r1;
            r1 = r0;
        L_0x0201:
            if (r1 != 0) goto L_0x02ae;
        L_0x0203:
            if (r14 != 0) goto L_0x0207;
        L_0x0205:
            if (r15 == 0) goto L_0x0396;
        L_0x0207:
            r0 = 0;
        L_0x0208:
            r1 = r8.Hw();	 Catch:{ ei -> 0x0032 }
            if (r0 >= r1) goto L_0x0396;
        L_0x020e:
            r1 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r1 = r1.cn;	 Catch:{ ei -> 0x0032 }
            r2 = r8.FH(r0);	 Catch:{ ei -> 0x0032 }
            r1 = r1.gn(r2);	 Catch:{ ei -> 0x0032 }
            r2 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r2 = r2.FH(r1);	 Catch:{ ei -> 0x0032 }
            if (r2 != 0) goto L_0x0229;
        L_0x0222:
            r2 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r2 = r2.dx;	 Catch:{ ei -> 0x0032 }
            r2.gn(r1);	 Catch:{ ei -> 0x0032 }
        L_0x0229:
            r0 = r0 + 1;
            goto L_0x0208;
        L_0x022c:
            r0 = r0.gW();	 Catch:{ ei -> 0x0032 }
            goto L_0x01e9;
        L_0x0231:
            r3 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r3 = r3.sh;	 Catch:{ ei -> 0x0032 }
            r5 = r3.FH();	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x0254;
        L_0x023b:
            r3 = r5.FH(r0);	 Catch:{ ei -> 0x0032 }
            if (r3 == 0) goto L_0x0254;
        L_0x0241:
            r3 = r13.er;	 Catch:{ ei -> 0x0032 }
            r3 = r3.FH(r0);	 Catch:{ ei -> 0x0032 }
            if (r3 != 0) goto L_0x0254;
        L_0x0249:
            r3 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r3 = r3.FH(r0);	 Catch:{ ei -> 0x0032 }
            if (r3 == 0) goto L_0x0254;
        L_0x0251:
            r7 = r1;
            r1 = r0;
            goto L_0x0201;
        L_0x0254:
            r3 = r5.j6;	 Catch:{ ei -> 0x0032 }
            r3.j6();	 Catch:{ ei -> 0x0032 }
        L_0x0259:
            r3 = r5.j6;	 Catch:{ ei -> 0x0032 }
            r3 = r3.DW();	 Catch:{ ei -> 0x0032 }
            if (r3 == 0) goto L_0x027a;
        L_0x0261:
            r3 = r5.j6;	 Catch:{ ei -> 0x0032 }
            r3 = r3.FH();	 Catch:{ ei -> 0x0032 }
            r6 = r13.er;	 Catch:{ ei -> 0x0032 }
            r6 = r6.FH(r3);	 Catch:{ ei -> 0x0032 }
            if (r6 != 0) goto L_0x0259;
        L_0x026f:
            r6 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r6 = r6.FH(r3);	 Catch:{ ei -> 0x0032 }
            if (r6 == 0) goto L_0x0259;
        L_0x0277:
            r7 = r1;
            r1 = r3;
            goto L_0x0201;
        L_0x027a:
            if (r0 == 0) goto L_0x0290;
        L_0x027c:
            r3 = r13.er;	 Catch:{ ei -> 0x0032 }
            r3 = r3.FH(r0);	 Catch:{ ei -> 0x0032 }
            if (r3 != 0) goto L_0x0290;
        L_0x0284:
            r3 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r3 = r3.FH(r0);	 Catch:{ ei -> 0x0032 }
            if (r3 == 0) goto L_0x0290;
        L_0x028c:
            r7 = r1;
            r1 = r0;
            goto L_0x0201;
        L_0x0290:
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.DW();	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x0643;
        L_0x029a:
            r0 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.FH();	 Catch:{ ei -> 0x0032 }
            r3 = r13.er;	 Catch:{ ei -> 0x0032 }
            r3 = r3.FH(r0);	 Catch:{ ei -> 0x0032 }
            if (r3 != 0) goto L_0x0290;
        L_0x02aa:
            r7 = r1;
            r1 = r0;
            goto L_0x0201;
        L_0x02ae:
            r0 = r13.er;	 Catch:{ ei -> 0x0032 }
            r0.j6(r1);	 Catch:{ ei -> 0x0032 }
            r0 = r1.DW();	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x035e;
        L_0x02b9:
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.DW;	 Catch:{ ei -> 0x0032 }
            r0 = r0.j6(r1);	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x02e5;
        L_0x02c3:
            if (r14 != 0) goto L_0x02c7;
        L_0x02c5:
            if (r16 == 0) goto L_0x02d1;
        L_0x02c7:
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.dx;	 Catch:{ ei -> 0x0032 }
            r0 = r0.VH(r1);	 Catch:{ ei -> 0x0032 }
            if (r0 != 0) goto L_0x02e5;
        L_0x02d1:
            if (r15 == 0) goto L_0x02dd;
        L_0x02d3:
            r0 = r1.BT();	 Catch:{ ei -> 0x0032 }
            r0 = r0.u7();	 Catch:{ ei -> 0x0032 }
            if (r0 != 0) goto L_0x02e5;
        L_0x02dd:
            r0 = r13.rN;	 Catch:{ ei -> 0x0032 }
            r0 = r0.FH(r1);	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x030d;
        L_0x02e5:
            java.lang.System.currentTimeMillis();	 Catch:{ ei -> 0x0032 }
            r0 = r13.rN;	 Catch:{ ei -> 0x0032 }
            r3 = r0.FH(r1);	 Catch:{ ei -> 0x0032 }
            r0 = r13;
            r4 = r14;
            r5 = r15;
            r6 = r16;
            r0.j6(r1, r2, r3, r4, r5, r6);	 Catch:{ ei -> 0x0032 }
        L_0x02f6:
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r3 = r0.XL;	 Catch:{ ei -> 0x0032 }
            monitor-enter(r3);	 Catch:{ ei -> 0x0032 }
            r0 = r13.v5;	 Catch:{ all -> 0x035b }
            r0 = r0.VH();	 Catch:{ all -> 0x035b }
            if (r0 == 0) goto L_0x032e;
        L_0x0305:
            r0 = r13.j6;	 Catch:{ all -> 0x035b }
            r1 = 1;
            r0.nw = r1;	 Catch:{ all -> 0x035b }
            monitor-exit(r3);	 Catch:{ all -> 0x035b }
        L_0x030c:
            return;
        L_0x030d:
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.sG;	 Catch:{ ei -> 0x0032 }
            r0 = r0.Hw(r1);	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x0324;
        L_0x0317:
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.Zo;	 Catch:{ ei -> 0x0032 }
            r3 = r1.er();	 Catch:{ ei -> 0x0032 }
            r0.FH(r3);	 Catch:{ ei -> 0x0032 }
        L_0x0324:
            if (r2 == 0) goto L_0x02f6;
        L_0x0326:
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.J8;	 Catch:{ ei -> 0x0032 }
            r0.DW(r1);	 Catch:{ ei -> 0x0032 }
            goto L_0x02f6;
        L_0x032e:
            monitor-exit(r3);	 Catch:{ all -> 0x035b }
            if (r2 == 0) goto L_0x0357;
        L_0x0331:
            r0 = r13.yS;	 Catch:{ ei -> 0x0032 }
            r2 = r1.vy();	 Catch:{ ei -> 0x0032 }
            r2 = r0.FH(r2);	 Catch:{ ei -> 0x0032 }
            r4 = r1.aM();	 Catch:{ ei -> 0x0032 }
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 == 0) goto L_0x0357;
        L_0x0343:
            r0 = r13.yS;	 Catch:{ ei -> 0x0032 }
            r2 = r1.vy();	 Catch:{ ei -> 0x0032 }
            r4 = r1.aM();	 Catch:{ ei -> 0x0032 }
            r0.j6(r2, r4);	 Catch:{ ei -> 0x0032 }
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.Hw;	 Catch:{ ei -> 0x0032 }
            r0.j6(r1);	 Catch:{ ei -> 0x0032 }
        L_0x0357:
            r0 = r1;
            r1 = r7;
            goto L_0x01e5;
        L_0x035b:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x035b }
            throw r0;	 Catch:{ ei -> 0x0032 }
        L_0x035e:
            r0 = r1.FH();	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x0357;
        L_0x0364:
            if (r2 == 0) goto L_0x038c;
        L_0x0366:
            r0 = r13.yS;	 Catch:{ ei -> 0x0032 }
            r3 = r1.vy();	 Catch:{ ei -> 0x0032 }
            r4 = r0.FH(r3);	 Catch:{ ei -> 0x0032 }
            r10 = r1.aM();	 Catch:{ ei -> 0x0032 }
            r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
            if (r0 == 0) goto L_0x038c;
        L_0x0378:
            r0 = r13.yS;	 Catch:{ ei -> 0x0032 }
            r3 = r1.vy();	 Catch:{ ei -> 0x0032 }
            r4 = r1.aM();	 Catch:{ ei -> 0x0032 }
            r0.j6(r3, r4);	 Catch:{ ei -> 0x0032 }
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.Hw;	 Catch:{ ei -> 0x0032 }
            r0.j6(r1);	 Catch:{ ei -> 0x0032 }
        L_0x038c:
            if (r2 == 0) goto L_0x0357;
        L_0x038e:
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.J8;	 Catch:{ ei -> 0x0032 }
            r0.DW(r1);	 Catch:{ ei -> 0x0032 }
            goto L_0x0357;
        L_0x0396:
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.Zo;	 Catch:{ ei -> 0x0032 }
            r0.Hw();	 Catch:{ ei -> 0x0032 }
            if (r17 == 0) goto L_0x03c0;
        L_0x03a1:
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r0.XL;	 Catch:{ ei -> 0x0032 }
            monitor-enter(r1);	 Catch:{ ei -> 0x0032 }
            r0 = r13.j6;	 Catch:{ all -> 0x03ea }
            r2 = 0;
            r0.lp = r2;	 Catch:{ all -> 0x03ea }
            monitor-exit(r1);	 Catch:{ all -> 0x03ea }
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r0.aM;	 Catch:{ ei -> 0x0032 }
            monitor-enter(r1);	 Catch:{ ei -> 0x0032 }
            r0 = r13.j6;	 Catch:{ all -> 0x03ed }
            r0 = r0.aM;	 Catch:{ all -> 0x03ed }
            r0.notify();	 Catch:{ all -> 0x03ed }
            monitor-exit(r1);	 Catch:{ all -> 0x03ed }
        L_0x03c0:
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.Zo;	 Catch:{ ei -> 0x0032 }
            r0.j6();	 Catch:{ ei -> 0x0032 }
            r0 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r0 = r0.DW;	 Catch:{ ei -> 0x0032 }
            r0 = r0.v5();	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x03f0;
        L_0x03d3:
            r1 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r1.j6();	 Catch:{ ei -> 0x0032 }
        L_0x03d8:
            r1 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.DW();	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x03f0;
        L_0x03e0:
            r1 = r0.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.FH();	 Catch:{ ei -> 0x0032 }
            r13.j6(r1);	 Catch:{ ei -> 0x0032 }
            goto L_0x03d8;
        L_0x03ea:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x03ea }
            throw r0;	 Catch:{ ei -> 0x0032 }
        L_0x03ed:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x03ed }
            throw r0;	 Catch:{ ei -> 0x0032 }
        L_0x03f0:
            r1 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r1.j6();	 Catch:{ ei -> 0x0032 }
            r1 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r2 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r2 = r2.cn;	 Catch:{ ei -> 0x0032 }
            r2 = r2.Hw();	 Catch:{ ei -> 0x0032 }
            r1.j6(r2);	 Catch:{ ei -> 0x0032 }
            r1 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r1 = r1.j6;	 Catch:{ ei -> 0x0032 }
            r1.j6();	 Catch:{ ei -> 0x0032 }
        L_0x0409:
            r1 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r1 = r1.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.DW();	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x043b;
        L_0x0413:
            r1 = r13.lg;	 Catch:{ ei -> 0x0032 }
            r1 = r1.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.FH();	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x0423;
        L_0x041d:
            r2 = r0.FH(r1);	 Catch:{ ei -> 0x0032 }
            if (r2 != 0) goto L_0x0409;
        L_0x0423:
            r2 = r13.FH;	 Catch:{ ei -> 0x0032 }
            r2 = r2.sG;	 Catch:{ ei -> 0x0032 }
            r2 = r2.DW(r1);	 Catch:{ ei -> 0x0032 }
            if (r2 == 0) goto L_0x0409;
        L_0x042d:
            r2 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r2 = r2.Zo;	 Catch:{ ei -> 0x0032 }
            r1 = r1.er();	 Catch:{ ei -> 0x0032 }
            r2.DW(r1);	 Catch:{ ei -> 0x0032 }
            goto L_0x0409;
        L_0x043b:
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.Zo;	 Catch:{ ei -> 0x0032 }
            r0.DW();	 Catch:{ ei -> 0x0032 }
            if (r16 == 0) goto L_0x0476;
        L_0x0446:
            r0 = r13.j6;	 Catch:{ IOException -> 0x04c9 }
            r1 = r0.XL;	 Catch:{ IOException -> 0x04c9 }
            monitor-enter(r1);	 Catch:{ IOException -> 0x04c9 }
            r0 = r13.j6;	 Catch:{ all -> 0x04c6 }
            r2 = 0;
            r0.sy = r2;	 Catch:{ all -> 0x04c6 }
            monitor-exit(r1);	 Catch:{ all -> 0x04c6 }
            r0 = new java.util.HashSet;	 Catch:{ IOException -> 0x04c9 }
            r0.<init>();	 Catch:{ IOException -> 0x04c9 }
            r1 = new java.util.Hashtable;	 Catch:{ IOException -> 0x04c9 }
            r1.<init>();	 Catch:{ IOException -> 0x04c9 }
            r2 = r13.FH;	 Catch:{ IOException -> 0x04c9 }
            r2 = r2.dx;	 Catch:{ IOException -> 0x04c9 }
            r2.j6(r0, r1);	 Catch:{ IOException -> 0x04c9 }
            r2 = r13.j6;	 Catch:{ IOException -> 0x04c9 }
            r2 = r2.u7;	 Catch:{ IOException -> 0x04c9 }
            if (r2 == 0) goto L_0x0476;
        L_0x046d:
            r2 = r13.j6;	 Catch:{ IOException -> 0x04c9 }
            r2 = r2.u7;	 Catch:{ IOException -> 0x04c9 }
            r2.j6(r0, r1);	 Catch:{ IOException -> 0x04c9 }
        L_0x0476:
            if (r14 != 0) goto L_0x047a;
        L_0x0478:
            if (r15 == 0) goto L_0x04b3;
        L_0x047a:
            r0 = r13.v5;	 Catch:{ IOException -> 0x048a }
            r0 = r0.VH();	 Catch:{ IOException -> 0x048a }
            if (r0 == 0) goto L_0x04e1;
        L_0x0482:
            r0 = r13.j6;	 Catch:{ IOException -> 0x048a }
            r1 = 1;
            r0.nw = r1;	 Catch:{ IOException -> 0x048a }
            goto L_0x030c;
        L_0x048a:
            r0 = move-exception;
            r1 = java.lang.System.out;	 Catch:{ ei -> 0x0032 }
            r0.printStackTrace(r1);	 Catch:{ ei -> 0x0032 }
            r1 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.u7;	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x04a1;
        L_0x0498:
            r1 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.u7;	 Catch:{ ei -> 0x0032 }
            r1.j6(r0);	 Catch:{ ei -> 0x0032 }
        L_0x04a1:
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.u7;	 Catch:{ ei -> 0x0032 }
            if (r0 == 0) goto L_0x04b3;
        L_0x04a9:
            r0 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r0 = r0.u7;	 Catch:{ ei -> 0x0032 }
            r1 = 1;
            r0.j6(r1);	 Catch:{ ei -> 0x0032 }
        L_0x04b3:
            r0 = r13.U2;	 Catch:{ ei -> 0x0032 }
            if (r0 != 0) goto L_0x04be;
        L_0x04b7:
            r0 = 1;
            r13.U2 = r0;	 Catch:{ ei -> 0x0032 }
            r0 = 1;
            r13.j6(r0);	 Catch:{ ei -> 0x0032 }
        L_0x04be:
            r13.Zo();	 Catch:{ ei -> 0x0032 }
            r0 = 0;
            r13.a8 = r0;	 Catch:{ ei -> 0x0032 }
            goto L_0x030c;
        L_0x04c6:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x04c6 }
            throw r0;	 Catch:{ IOException -> 0x04c9 }
        L_0x04c9:
            r0 = move-exception;
            r1 = java.lang.System.out;	 Catch:{ ei -> 0x0032 }
            r0.printStackTrace(r1);	 Catch:{ ei -> 0x0032 }
            r1 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.u7;	 Catch:{ ei -> 0x0032 }
            if (r1 == 0) goto L_0x0476;
        L_0x04d7:
            r1 = r13.j6;	 Catch:{ ei -> 0x0032 }
            r1 = r1.u7;	 Catch:{ ei -> 0x0032 }
            r1.j6(r0);	 Catch:{ ei -> 0x0032 }
            goto L_0x0476;
        L_0x04e1:
            r0 = r13.j6;	 Catch:{ IOException -> 0x048a }
            r1 = r0.XL;	 Catch:{ IOException -> 0x048a }
            monitor-enter(r1);	 Catch:{ IOException -> 0x048a }
            r0 = r13.j6;	 Catch:{ all -> 0x054f }
            r2 = 0;
            r0.I = r2;	 Catch:{ all -> 0x054f }
            r0 = r13.j6;	 Catch:{ all -> 0x054f }
            r2 = 0;
            r0.Qq = r2;	 Catch:{ all -> 0x054f }
            monitor-exit(r1);	 Catch:{ all -> 0x054f }
            r0 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r0 = r0.dx;	 Catch:{ IOException -> 0x048a }
            r0.j6();	 Catch:{ IOException -> 0x048a }
            r0 = new java.util.HashSet;	 Catch:{ IOException -> 0x048a }
            r0.<init>();	 Catch:{ IOException -> 0x048a }
            r1 = new ec;	 Catch:{ IOException -> 0x048a }
            r1.<init>();	 Catch:{ IOException -> 0x048a }
            r2 = new java.util.HashSet;	 Catch:{ IOException -> 0x048a }
            r2.<init>();	 Catch:{ IOException -> 0x048a }
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3.j6();	 Catch:{ IOException -> 0x048a }
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r4 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r4 = r4.cn;	 Catch:{ IOException -> 0x048a }
            r4 = r4.Hw();	 Catch:{ IOException -> 0x048a }
            r3.j6(r4);	 Catch:{ IOException -> 0x048a }
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3 = r3.j6;	 Catch:{ IOException -> 0x048a }
            r3.j6();	 Catch:{ IOException -> 0x048a }
        L_0x0524:
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3 = r3.j6;	 Catch:{ IOException -> 0x048a }
            r3 = r3.DW();	 Catch:{ IOException -> 0x048a }
            if (r3 == 0) goto L_0x0552;
        L_0x052e:
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3 = r3.j6;	 Catch:{ IOException -> 0x048a }
            r3 = r3.FH();	 Catch:{ IOException -> 0x048a }
            r4 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r4 = r4.dx;	 Catch:{ IOException -> 0x048a }
            r4 = r4.FH(r3);	 Catch:{ IOException -> 0x048a }
            if (r4 == 0) goto L_0x0524;
        L_0x0540:
            r4 = r3.er();	 Catch:{ IOException -> 0x048a }
            r2.add(r4);	 Catch:{ IOException -> 0x048a }
            r3 = r3.gn();	 Catch:{ IOException -> 0x048a }
            r1.j6(r3);	 Catch:{ IOException -> 0x048a }
            goto L_0x0524;
        L_0x054f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x054f }
            throw r0;	 Catch:{ IOException -> 0x048a }
        L_0x0552:
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3.j6();	 Catch:{ IOException -> 0x048a }
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r4 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r4 = r4.cn;	 Catch:{ IOException -> 0x048a }
            r4 = r4.Zo();	 Catch:{ IOException -> 0x048a }
            r3.j6(r4);	 Catch:{ IOException -> 0x048a }
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3 = r3.j6;	 Catch:{ IOException -> 0x048a }
            r3.j6();	 Catch:{ IOException -> 0x048a }
        L_0x056b:
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3 = r3.j6;	 Catch:{ IOException -> 0x048a }
            r3 = r3.DW();	 Catch:{ IOException -> 0x048a }
            if (r3 == 0) goto L_0x0596;
        L_0x0575:
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3 = r3.j6;	 Catch:{ IOException -> 0x048a }
            r3 = r3.FH();	 Catch:{ IOException -> 0x048a }
            r4 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r4 = r4.dx;	 Catch:{ IOException -> 0x048a }
            r4 = r4.Zo(r3);	 Catch:{ IOException -> 0x048a }
            if (r4 == 0) goto L_0x056b;
        L_0x0587:
            r4 = r3.er();	 Catch:{ IOException -> 0x048a }
            r2.add(r4);	 Catch:{ IOException -> 0x048a }
            r3 = r3.gn();	 Catch:{ IOException -> 0x048a }
            r1.j6(r3);	 Catch:{ IOException -> 0x048a }
            goto L_0x056b;
        L_0x0596:
            r3 = r1.j6;	 Catch:{ IOException -> 0x048a }
            r3.j6();	 Catch:{ IOException -> 0x048a }
        L_0x059b:
            r3 = r1.j6;	 Catch:{ IOException -> 0x048a }
            r3 = r3.DW();	 Catch:{ IOException -> 0x048a }
            if (r3 == 0) goto L_0x05b5;
        L_0x05a3:
            r3 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r3 = r3.cn;	 Catch:{ IOException -> 0x048a }
            r4 = r1.j6;	 Catch:{ IOException -> 0x048a }
            r4 = r4.FH();	 Catch:{ IOException -> 0x048a }
            r3 = r3.Zo(r4);	 Catch:{ IOException -> 0x048a }
            r0.add(r3);	 Catch:{ IOException -> 0x048a }
            goto L_0x059b;
        L_0x05b5:
            r1 = new java.util.HashMap;	 Catch:{ IOException -> 0x048a }
            r1.<init>();	 Catch:{ IOException -> 0x048a }
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3.j6();	 Catch:{ IOException -> 0x048a }
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r4 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r4 = r4.cn;	 Catch:{ IOException -> 0x048a }
            r4 = r4.Hw();	 Catch:{ IOException -> 0x048a }
            r3.j6(r4);	 Catch:{ IOException -> 0x048a }
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3 = r3.j6;	 Catch:{ IOException -> 0x048a }
            r3.j6();	 Catch:{ IOException -> 0x048a }
        L_0x05d3:
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3 = r3.j6;	 Catch:{ IOException -> 0x048a }
            r3 = r3.DW();	 Catch:{ IOException -> 0x048a }
            if (r3 == 0) goto L_0x05fb;
        L_0x05dd:
            r3 = r13.lg;	 Catch:{ IOException -> 0x048a }
            r3 = r3.j6;	 Catch:{ IOException -> 0x048a }
            r3 = r3.FH();	 Catch:{ IOException -> 0x048a }
            r4 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r4 = r4.cb;	 Catch:{ IOException -> 0x048a }
            r4 = r4.DW(r3);	 Catch:{ IOException -> 0x048a }
            r5 = r4.length();	 Catch:{ IOException -> 0x048a }
            if (r5 <= 0) goto L_0x05d3;
        L_0x05f3:
            r3 = r3.er();	 Catch:{ IOException -> 0x048a }
            r1.put(r3, r4);	 Catch:{ IOException -> 0x048a }
            goto L_0x05d3;
        L_0x05fb:
            r3 = r13.j6;	 Catch:{ IOException -> 0x048a }
            r3 = r3.u7;	 Catch:{ IOException -> 0x048a }
            if (r3 == 0) goto L_0x060c;
        L_0x0603:
            r3 = r13.j6;	 Catch:{ IOException -> 0x048a }
            r3 = r3.u7;	 Catch:{ IOException -> 0x048a }
            r3.j6(r0, r2, r1);	 Catch:{ IOException -> 0x048a }
        L_0x060c:
            r0 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r0 = r0.dx;	 Catch:{ IOException -> 0x048a }
            r1 = 1;
            r0 = r0.j6(r1);	 Catch:{ IOException -> 0x048a }
            r1 = r13.j6;	 Catch:{ IOException -> 0x048a }
            r1 = r1.u7;	 Catch:{ IOException -> 0x048a }
            if (r1 == 0) goto L_0x0626;
        L_0x061d:
            r1 = r13.j6;	 Catch:{ IOException -> 0x048a }
            r1 = r1.u7;	 Catch:{ IOException -> 0x048a }
            r1.j6(r0);	 Catch:{ IOException -> 0x048a }
        L_0x0626:
            r0 = 0;
            r13.Mr = r0;	 Catch:{ IOException -> 0x048a }
            r0 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r0 = r0.dx;	 Catch:{ IOException -> 0x048a }
            r0 = r0.gn();	 Catch:{ IOException -> 0x048a }
            if (r0 != 0) goto L_0x063e;
        L_0x0633:
            r0 = r13.FH;	 Catch:{ IOException -> 0x048a }
            r0 = r0.dx;	 Catch:{ IOException -> 0x048a }
            r0.VH();	 Catch:{ IOException -> 0x048a }
            r0 = 1;
            r13.j6(r0);	 Catch:{ IOException -> 0x048a }
        L_0x063e:
            r13.gn();	 Catch:{ IOException -> 0x048a }
            goto L_0x04b3;
        L_0x0643:
            r7 = r1;
            r1 = r4;
            goto L_0x0201;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aide.engine.b.b.j6(boolean, boolean, boolean, boolean):void");
        }

        private void j6(bv bvVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            this.Mr = false;
            try {
                List<cj> DW = this.FH.sh.DW(bvVar);
                for (cj cjVar : DW) {
                    this.FH.sG.j6(bvVar, cjVar.tp());
                    if (cjVar.tp().u7() != null) {
                        cjVar.tp().u7().FH(cjVar);
                    }
                    this.FH.aM.j6(cjVar);
                    if (cjVar.tp().u7() != null) {
                        this.FH.Hw.j6(cjVar);
                    }
                    if (!bvVar.j3() || this.Hw.DW()) {
                        synchronized (this.j6.XL) {
                            if (this.v5.VH()) {
                                this.j6.nw = true;
                                return;
                            }
                            this.FH.DW.j6(cjVar);
                        }
                    } else {
                        synchronized (this.j6.XL) {
                            this.j6.nw = true;
                        }
                        return;
                    }
                }
                this.j6.Lz.remove(bvVar.er());
                br brVar = this.FH.dx;
                boolean z6 = z3 || z4 || z5;
                brVar.j6(bvVar, DW, z2, z6);
                if ((z3 || z4) && this.FH.dx.DW() > 200000) {
                    this.FH.dx.Zo();
                }
                if (z) {
                    this.FH.J8.j6(bvVar, (List) DW);
                }
                this.FH.j6.j6(bvVar);
                for (cj cjVar2 : DW) {
                    this.FH.sh.j6(cjVar2);
                }
                DW(bvVar);
                this.FH.FH();
                int i = this.a8;
                this.a8 = i + 1;
                if (i > 100) {
                    this.a8 = 0;
                    gn();
                }
            } catch (StackOverflowError e) {
                throw e;
            } catch (OutOfMemoryError e2) {
                throw e2;
            } catch (Throwable th) {
                com.aide.common.e.FH("Error compiling " + bvVar.er());
                if (this.j6.v5 == null) {
                    return;
                }
                if (th instanceof OutOfMemoryError) {
                    this.j6.v5.j6();
                } else {
                    this.j6.v5.j6(th);
                }
            }
        }

        private ea<bs> j6(List<v> list, List<k> list2) {
            ea<bs> eaVar = new ea(this.FH.cb);
            for (v vVar : list) {
                bv DW = this.FH.cn.DW(vVar.FH());
                if (!(DW.BT() == null || DW.BT().tp() == null)) {
                    try {
                        eaVar.j6(DW.BT().tp().j6(DW, vVar.j6(), vVar.DW()));
                    } catch (ej e) {
                    }
                }
            }
            for (k kVar : list2) {
                for (bh bhVar : this.FH.cn.DW()) {
                    if (bhVar.tp() != null) {
                        try {
                            eaVar.j6(bhVar.tp().j6(kVar.j6(), kVar.DW(), kVar.FH()));
                        } catch (ej e2) {
                        }
                    }
                }
            }
            return eaVar;
        }

        private eb DW(List<v> list, List<k> list2) {
            eb ebVar = new eb(this.FH.cn);
            for (v FH : list) {
                ebVar.j6(this.FH.cn.DW(FH.FH()));
            }
            for (k kVar : list2) {
                for (bh bhVar : this.FH.cn.DW()) {
                    if (bhVar.tp() != null) {
                        try {
                            ebVar.j6(bhVar.tp().j6(kVar.j6(), kVar.DW(), kVar.FH()).tp());
                        } catch (ej e) {
                        }
                    }
                }
            }
            return ebVar;
        }

        private void j6(bv bvVar) {
            int v5 = this.FH.sG.v5(bvVar);
            int i = 0;
            int i2 = 0;
            while (i < v5) {
                if (bvVar.DW() || j6(this.FH.sG.Zo(bvVar, i))) {
                    i2++;
                }
                i++;
            }
            SyntaxError[] syntaxErrorArr = new SyntaxError[i2];
            i = 0;
            int i3 = 0;
            while (i3 < v5) {
                if (bvVar.DW() || j6(this.FH.sG.Zo(bvVar, i3))) {
                    syntaxErrorArr[i3] = new SyntaxError();
                    syntaxErrorArr[i].EQ = bvVar.vy();
                    syntaxErrorArr[i].we = i3;
                    syntaxErrorArr[i].J0 = true;
                    syntaxErrorArr[i].j6 = DW(this.FH.sG.Zo(bvVar, i3));
                    syntaxErrorArr[i].FH = this.FH.sG.j6(bvVar, i3);
                    syntaxErrorArr[i].Hw = this.FH.sG.DW(bvVar, i3);
                    syntaxErrorArr[i].v5 = this.FH.sG.FH(bvVar, i3);
                    syntaxErrorArr[i].Zo = this.FH.sG.Hw(bvVar, i3);
                    syntaxErrorArr[i].VH = this.FH.sG.v5(bvVar, i3);
                    int VH = this.FH.sG.VH(bvVar, i3);
                    if (VH > 0) {
                        syntaxErrorArr[i].gn = new String[VH];
                        for (i2 = 0; i2 < VH; i2++) {
                            syntaxErrorArr[i].gn[i2] = this.FH.sG.j6(bvVar, i3, i2);
                        }
                    }
                }
                i3++;
                i++;
            }
            this.j6.Zo.j6(bvVar.er(), syntaxErrorArr);
        }

        private void QX() {
            this.j6.Zo.FH();
            this.lg.j6();
            this.lg.j6(this.FH.cn.Hw());
            eb j6 = this.FH.sG.j6();
            j6.j6.j6();
            while (j6.j6.DW()) {
                bv FH = j6.j6.FH();
                if (this.FH.sG.Hw(FH)) {
                    DW(FH);
                }
            }
            this.j6.Zo.Hw();
        }

        private void XL() {
            this.j6.Zo.j6();
            this.lg.j6();
            this.lg.j6(this.FH.cn.Hw());
            this.lg.j6.j6();
            while (this.lg.j6.DW()) {
                bv FH = this.lg.j6.FH();
                if (this.FH.sG.v5(FH) > 0) {
                    j6(FH);
                }
            }
            this.j6.Zo.DW();
        }

        private void DW(bv bvVar) {
            List<bj> Zo = bvVar.BT().Zo();
            int i = 0;
            for (bj bjVar : Zo) {
                int Hw = this.FH.sG.Hw(bvVar, bjVar);
                int i2 = 0;
                while (i2 < Hw) {
                    if (bvVar.DW() || j6(this.FH.sG.Zo(bvVar, bjVar, i2))) {
                        i++;
                    }
                    i2++;
                }
            }
            String j6 = bvVar.BT().j6();
            SyntaxError[] syntaxErrorArr = new SyntaxError[i];
            i = 0;
            for (bj bjVar2 : Zo) {
                String j62 = bjVar2.j6();
                int Hw2 = this.FH.sG.Hw(bvVar, bjVar2);
                int i3 = 0;
                while (i3 < Hw2) {
                    if (bvVar.DW() || j6(this.FH.sG.Zo(bvVar, bjVar2, i3))) {
                        syntaxErrorArr[i] = new SyntaxError();
                        syntaxErrorArr[i].EQ = bvVar.vy();
                        syntaxErrorArr[i].we = i3;
                        syntaxErrorArr[i].J8 = this.FH.cn.j6(bjVar2);
                        syntaxErrorArr[i].u7 = j6;
                        syntaxErrorArr[i].tp = j62;
                        syntaxErrorArr[i].J0 = false;
                        syntaxErrorArr[i].j6 = DW(this.FH.sG.Zo(bvVar, bjVar2, i3));
                        syntaxErrorArr[i].DW = this.FH.sG.VH(bvVar, bjVar2, i3);
                        syntaxErrorArr[i].FH = this.FH.sG.j6(bvVar, bjVar2, i3);
                        syntaxErrorArr[i].Hw = this.FH.sG.DW(bvVar, bjVar2, i3);
                        syntaxErrorArr[i].v5 = this.FH.sG.FH(bvVar, bjVar2, i3);
                        syntaxErrorArr[i].Zo = this.FH.sG.Hw(bvVar, bjVar2, i3);
                        syntaxErrorArr[i].VH = this.FH.sG.v5(bvVar, bjVar2, i3);
                        int gn = this.FH.sG.gn(bvVar, bjVar2, i3);
                        if (gn > 0) {
                            syntaxErrorArr[i].gn = new String[gn];
                            for (i2 = 0; i2 < gn; i2++) {
                                syntaxErrorArr[i].gn[i2] = this.FH.sG.j6(bvVar, bjVar2, i3, i2);
                            }
                        }
                        i++;
                    }
                    i3++;
                }
            }
            this.j6.Zo.j6(bvVar.er(), syntaxErrorArr, bvVar.FH());
        }

        private boolean j6(int i) {
            switch (i) {
                case 70:
                case 90:
                case 91:
                case 100:
                    return true;
                default:
                    return false;
            }
        }

        private int DW(int i) {
            switch (i) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case 21:
                    return 2;
                case 40:
                    return 104;
                case 41:
                    return 105;
                case 42:
                    return 106;
                case 43:
                    return 107;
                case 44:
                    return 108;
                case 45:
                    return 109;
                case 46:
                    return 110;
                case 47:
                    return 101;
                case 48:
                    return 102;
                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                    return 103;
                case 50:
                    return 112;
                case 51:
                    return 111;
                case 60:
                    return 250;
                case 61:
                    return 251;
                case 70:
                    return 1;
                case 80:
                    return 201;
                case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                    return 200;
                case 82:
                    return 203;
                case 83:
                    return 202;
                case 84:
                    return 204;
                case 90:
                    return 301;
                case 91:
                    return 300;
                case 100:
                    return 302;
                case 200:
                    return 400;
                case 300:
                    return 500;
                default:
                    return 0;
            }
        }

        private f j6(bl blVar, int i) {
            if (blVar.U2(i)) {
                return f.OPERATOR;
            }
            if (blVar.yS(i)) {
                return f.SEPARATOR;
            }
            if (blVar.er(i)) {
                return f.TYPE_IDENTIFIER;
            }
            if (blVar.Mr(i)) {
                return f.LITERAL;
            }
            if (blVar.a8(i)) {
                return f.KEYWORD;
            }
            if (blVar.rN(i)) {
                return f.DOC_COMMENT;
            }
            if (blVar.lg(i)) {
                return f.COMMENT;
            }
            return null;
        }
    }

    private enum c {
        IMPLEMENT,
        OVERRIDE,
        DOCUMENTIZE,
        DOCUMENTIZE_FILE,
        CONVERT_PROJECT,
        CONVERT_FILE,
        CREATE_PROPERTY,
        CREATE_CONSTRUCTOR,
        DO_EXTRACT,
        DO_EXTRACT_RESOURCES,
        INIT_INTRODUCE_VARIABLE,
        ADD_IMPORT,
        ORGANIZE,
        MOVE,
        COPY_CLASS,
        RENAME_FILE,
        DO_RENAME,
        INIT_CHANGE_SIGNATURE,
        DO_CHANGE_SIGNATURE,
        INIT_RENAME,
        INIT_MOVE,
        DO_MOVE,
        INLINE_VARIABLE,
        INLINE_METHOD,
        SURROUND_WITH_TRYCATCH,
        AUTOFORMAT,
        AUTOINDENTAFTERPASTE,
        OUTCOMMENT,
        UNOUTCOMMENT,
        LEARN,
        REPLACE_TEXT,
        INDENT_AFTER_ENTER,
        INDENT_AFTER_TYPING,
        AUTOFORMAT_ASYNC
    }

    static {
        j6 = System.getProperty("os.name").toUpperCase(Locale.US).indexOf("WINDOWS") != -1;
    }

    public b(e eVar) {
        this.DW = new HashMap();
        this.PT = new Stack();
        this.b1 = new Stack();
        this.AR = new Stack();
        this.TI = new Stack();
        this.T6 = new bq();
        this.cc = new String[0];
        this.Od = new boolean[0];
        this.fP = null;
        this.b = null;
        this.ba = 0;
        this.fh = eVar;
        this.XL = new Object();
        this.aM = new Object();
        this.j3 = new Object();
        synchronized (this.XL) {
            this.U2 = new Hashtable();
            this.J8 = false;
            this.er = 1;
        }
        Runnable bVar = new b(this, true);
        if (eq.j6() != null) {
            Thread j6 = eq.j6().j6(null, bVar, "Engine", 2000000);
            j6.setPriority(2);
            j6.start();
            return;
        }
        j6 = new Thread(null, bVar, "Engine", 1048576);
        j6.setPriority(2);
        j6.start();
    }

    public void j6(EngineSolution engineSolution) {
        synchronized (this.XL) {
            this.Mr = engineSolution;
            this.ro = true;
            this.vy = true;
        }
    }

    public void j6(SyntaxError syntaxError, int i) {
        synchronized (this.XL) {
            this.ei = true;
            this.Cz = syntaxError;
            this.pN = i;
            this.XL.notify();
        }
    }

    public void j6(boolean z, boolean z2, boolean z3, boolean z4, int i, String str, String[] strArr, boolean[] zArr, int i2, Map<String, Integer> map, Map<String, Set<? extends bd>> map2) {
        synchronized (this.XL) {
            if (str.length() > 0) {
                this.T6.j6 = str;
            } else {
                this.T6.j6 = null;
            }
            this.T6.DW = z2;
            this.T6.FH = z;
            this.T6.Hw = z3;
            this.T6.v5 = i;
            this.T6.Zo = z4;
            this.T6.VH = i2;
            this.T6.gn = map;
            this.T6.u7 = map2;
            this.cc = strArr;
            this.Od = zArr;
            this.ro = true;
            this.XL.notify();
        }
    }

    public void j6(String str, long j) {
        synchronized (this.XL) {
            this.Ws = str;
            this.QX = j;
            this.J8 = true;
            if (this.QX == 0 || this.Ws == null || "".equals(this.Ws) || !new File(this.Ws).exists()) {
                this.J8 = false;
            }
        }
    }

    public void j6(g gVar) {
        this.EQ = gVar;
    }

    public void j6(a aVar) {
        this.u7 = aVar;
    }

    public void j6(d dVar) {
        synchronized (this.XL) {
            this.Zo = dVar;
        }
    }

    public void j6(c cVar) {
        synchronized (this.XL) {
            this.v5 = cVar;
        }
    }

    public void j6(af afVar) {
        synchronized (this.XL) {
            this.FH = afVar;
        }
    }

    public void j6(ab abVar) {
        synchronized (this.XL) {
            this.Hw = abVar;
        }
    }

    public void j6(ad adVar) {
        this.VH = adVar;
    }

    public void j6(String str, int i) {
        synchronized (this.XL) {
            this.CU = str;
            this.Xa = i;
            this.g3 = true;
            this.XL.notify();
        }
    }

    public void DW(String str, int i) {
        synchronized (this.XL) {
            this.CU = str;
            this.Xa = i;
            this.Mz = true;
            this.XL.notify();
        }
    }

    public void j6(String str, int i, int i2) {
        synchronized (this.XL) {
            this.fY = i;
            this.qp = i2;
            this.jw = str;
            this.k2 = a.MEMBERS;
            this.cn = true;
            this.XL.notify();
        }
    }

    public void DW(String str, int i, int i2) {
        synchronized (this.XL) {
            this.kf = i;
            this.Jl = i2;
            this.Q6 = str;
            this.dx = true;
            this.XL.notify();
        }
    }

    public void j6(SourceEntity sourceEntity) {
        synchronized (this.XL) {
            this.n5 = sourceEntity;
            this.ef = true;
            this.XL.notify();
        }
    }

    public void j6() {
        synchronized (this.XL) {
            this.P8 = true;
            this.XL.notify();
        }
    }

    public void j6(String str, z zVar) {
        synchronized (this.XL) {
            this.U2.put(str, zVar);
            this.Sf = true;
        }
    }

    public void j6(String str) {
        synchronized (this.XL) {
            this.U2.remove(str);
            this.Sf = true;
            this.XL.notify();
        }
    }

    public void j6(String str, String str2) {
        synchronized (this.XL) {
            if (this.U2.containsKey(str)) {
                this.U2.put(str2, this.U2.get(str));
                this.U2.remove(str);
            }
            this.Sf = true;
            this.XL.notify();
        }
    }

    public void DW() {
        synchronized (this.XL) {
            this.er++;
        }
    }

    public void FH() {
        synchronized (this.XL) {
            if (this.er > 0) {
                this.er--;
            }
        }
    }

    public void Hw() {
        synchronized (this.XL) {
            this.nw = true;
            this.SI = true;
            this.XL.notify();
        }
    }

    public void v5() {
        synchronized (this.XL) {
            this.nw = true;
            this.KD = true;
            this.SI = true;
            this.XL.notify();
        }
    }

    public void Zo() {
        synchronized (this.XL) {
            this.I = true;
            this.nw = true;
            this.SI = true;
            this.XL.notify();
        }
    }

    public void VH() {
        synchronized (this.XL) {
            this.KD = true;
            this.Qq = true;
            this.nw = true;
            this.SI = true;
            this.XL.notify();
        }
    }

    public void gn() {
        synchronized (this.XL) {
            this.vy = true;
        }
    }

    public void DW(String str) {
        synchronized (this.XL) {
            this.et = null;
            this.WB = str;
            this.aq = false;
            this.FN = false;
            this.ye = true;
            this.mb = false;
            this.Ev = false;
            this.jO = false;
            this.oY = false;
            this.ko = false;
            this.Ev = false;
            this.gW = true;
            this.XL.notify();
        }
    }

    public void j6(String str, int i, int i2, boolean z) {
        synchronized (this.XL) {
            this.et = str;
            this.Eq = i;
            this.hz = i2;
            this.aq = z;
            this.ye = false;
            this.FN = false;
            this.mb = false;
            this.Ev = false;
            this.jO = false;
            this.oY = false;
            this.ko = false;
            this.gW = true;
            this.XL.notify();
        }
    }

    public void u7() {
        synchronized (this.XL) {
            this.a8 = true;
        }
    }

    public void j6(String str, int i, int i2, SourceEntity sourceEntity) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.OVERRIDE;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i;
            this.gG = i2;
            this.n5 = sourceEntity;
            this.XL.notify();
        }
    }

    public void j6(String str, int i, int i2, int i3, int i4) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.CREATE_PROPERTY;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i3;
            this.gG = i4;
            this.XL.notify();
        }
    }

    public void DW(String str, int i, int i2, int i3, int i4) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.CREATE_CONSTRUCTOR;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i3;
            this.gG = i4;
            this.XL.notify();
        }
    }

    public void j6(String str, Hashtable<String, String> hashtable) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.ORGANIZE;
            this.e9 = str;
            this.qP = hashtable;
            this.XL.notify();
        }
    }

    public void j6(String str, SourceEntity sourceEntity) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.ADD_IMPORT;
            this.e9 = str;
            this.MP = sourceEntity;
            this.XL.notify();
        }
    }

    public void j6(String str, int i, int i2, int i3, int i4, String str2, String str3) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.REPLACE_TEXT;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i3;
            this.gG = i4;
            this.sM = str2;
            this.QO = str3;
            this.XL.notify();
        }
    }

    public void FH(String str, int i, int i2, int i3, int i4) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.SURROUND_WITH_TRYCATCH;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i3;
            this.gG = i4;
            this.XL.notify();
        }
    }

    public void Hw(String str, int i, int i2, int i3, int i4) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.INIT_INTRODUCE_VARIABLE;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i3;
            this.gG = i4;
            this.XL.notify();
        }
    }

    public void FH(String str, int i, int i2) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.INLINE_VARIABLE;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i;
            this.gG = i2;
            this.XL.notify();
        }
    }

    public void j6(String str, String str2, int i, int i2, int i3, int i4) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.DO_EXTRACT_RESOURCES;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i3;
            this.gG = i4;
            this.oa = str2;
            this.XL.notify();
        }
    }

    public void v5(String str, int i, int i2, int i3, int i4) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.DO_EXTRACT;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i3;
            this.gG = i4;
            this.XL.notify();
        }
    }

    public void Hw(String str, int i, int i2) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.INIT_RENAME;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i;
            this.gG = i2;
            this.XL.notify();
        }
    }

    public void FH(String str) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.DO_RENAME;
            this.QO = str;
            this.XL.notify();
        }
    }

    public void DW(String str, String str2) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.RENAME_FILE;
            this.e9 = str;
            this.QO = str2;
            this.XL.notify();
        }
    }

    public List<Modification> j6(String str, int i, int i2, int i3) {
        System.currentTimeMillis();
        synchronized (this.XL) {
            this.Of = null;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i;
            this.gG = i2;
            this.Nh = i3;
            this.aX = c.INDENT_AFTER_ENTER;
            this.cb = true;
            this.SI = true;
            this.XL.notify();
        }
        synchronized (this.j3) {
            try {
                synchronized (this.XL) {
                    if (this.cb) {
                        this.j3.wait(1000);
                    }
                }
            } catch (InterruptedException e) {
            }
        }
        return this.Of;
    }

    public List<Modification> j6(String str, int i, int i2, char c, int i3) {
        System.currentTimeMillis();
        synchronized (this.XL) {
            this.Of = null;
            this.e9 = str;
            this.a5 = i;
            this.ys = i2;
            this.IS = i;
            this.gG = i2;
            this.Nh = i3;
            this.aX = c.INDENT_AFTER_TYPING;
            this.cb = true;
            this.SI = true;
            this.XL.notify();
        }
        synchronized (this.j3) {
            try {
                synchronized (this.XL) {
                    if (this.cb) {
                        this.j3.wait(1000);
                    }
                }
            } catch (InterruptedException e) {
            }
        }
        return this.Of;
    }

    public void Zo(String str, int i, int i2, int i3, int i4) {
        synchronized (this.XL) {
            this.XG = true;
            this.AE = str;
            this.Za = i;
            this.An = i2;
            this.Pa = i3;
            this.ce = i4;
            this.XL.notify();
        }
    }

    public void FH(String str, int i) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.LEARN;
            this.e9 = str;
            this.Nh = i;
            this.XL.notify();
        }
    }

    public void DW(String str, int i, int i2, int i3) {
        synchronized (this.XL) {
            this.cb = true;
            this.SI = true;
            this.Nh = i3;
            this.aX = c.AUTOFORMAT_ASYNC;
            this.e9 = str;
            this.a5 = i;
            this.ys = 1;
            this.IS = i2;
            this.gG = 1;
            this.XL.notify();
        }
    }

    public List<Modification> FH(String str, int i, int i2, int i3) {
        System.currentTimeMillis();
        synchronized (this.XL) {
            this.Of = null;
            this.Nh = i3;
            this.aX = c.AUTOFORMAT;
            this.e9 = str;
            this.a5 = i;
            this.IS = i2;
            this.cb = true;
            this.SI = true;
            this.XL.notify();
        }
        synchronized (this.j3) {
            try {
                synchronized (this.XL) {
                    if (this.cb) {
                        this.j3.wait(20000);
                    }
                }
            } catch (InterruptedException e) {
            }
        }
        return this.Of;
    }

    public List<Modification> Hw(String str, int i, int i2, int i3) {
        System.currentTimeMillis();
        synchronized (this.XL) {
            this.Of = null;
            this.Nh = i3;
            this.aX = c.AUTOINDENTAFTERPASTE;
            this.e9 = str;
            this.a5 = i;
            this.IS = i2;
            this.cb = true;
            this.SI = true;
            this.XL.notify();
        }
        synchronized (this.j3) {
            try {
                synchronized (this.XL) {
                    if (this.cb) {
                        this.j3.wait(1000);
                    }
                }
            } catch (InterruptedException e) {
            }
        }
        return this.Of;
    }

    public void v5(String str, int i, int i2) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.OUTCOMMENT;
            this.e9 = str;
            this.a5 = i;
            this.ys = 1;
            this.IS = i2;
            this.gG = 1;
            this.XL.notify();
        }
    }

    public void Zo(String str, int i, int i2) {
        synchronized (this.XL) {
            this.cb = true;
            this.aX = c.UNOUTCOMMENT;
            this.e9 = str;
            this.a5 = i;
            this.ys = 1;
            this.IS = i2;
            this.gG = 1;
            this.XL.notify();
        }
    }

    public void j6(String str, String str2, int i) {
        try {
            FileReader fileReader = new FileReader(str2);
            synchronized (this.XL) {
                this.b1.addElement(str);
                this.AR.addElement(Integer.valueOf(i));
                this.TI.addElement(fileReader);
                this.nw = true;
                this.SI = true;
                this.XL.notify();
            }
        } catch (Throwable e) {
            e.j6(e);
        }
    }

    public void tp() {
        synchronized (this.XL) {
            this.lg = true;
        }
    }
}
