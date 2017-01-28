import com.aide.uidesigner.ProxyTextView;

public class sy extends sr {
    public static final sy j6;

    static {
        j6 = new sy();
    }

    protected sz j6(su suVar, int i, String str, int i2, int i3, ti tiVar) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                if (str == "Deprecated") {
                    return v5(suVar, i2, i3, tiVar);
                }
                if (str == "EnclosingMethod") {
                    return Zo(suVar, i2, i3, tiVar);
                }
                if (str == "InnerClasses") {
                    return gn(suVar, i2, i3, tiVar);
                }
                if (str == "RuntimeInvisibleAnnotations") {
                    return we(suVar, i2, i3, tiVar);
                }
                if (str == "RuntimeVisibleAnnotations") {
                    return J0(suVar, i2, i3, tiVar);
                }
                if (str == "Synthetic") {
                    return aM(suVar, i2, i3, tiVar);
                }
                if (str == "Signature") {
                    return QX(suVar, i2, i3, tiVar);
                }
                if (str == "SourceFile") {
                    return XL(suVar, i2, i3, tiVar);
                }
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (str == "ConstantValue") {
                    return Hw(suVar, i2, i3, tiVar);
                }
                if (str == "Deprecated") {
                    return v5(suVar, i2, i3, tiVar);
                }
                if (str == "RuntimeInvisibleAnnotations") {
                    return we(suVar, i2, i3, tiVar);
                }
                if (str == "RuntimeVisibleAnnotations") {
                    return J0(suVar, i2, i3, tiVar);
                }
                if (str == "Signature") {
                    return QX(suVar, i2, i3, tiVar);
                }
                if (str == "Synthetic") {
                    return aM(suVar, i2, i3, tiVar);
                }
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                if (str == "AnnotationDefault") {
                    return DW(suVar, i2, i3, tiVar);
                }
                if (str == "Code") {
                    return FH(suVar, i2, i3, tiVar);
                }
                if (str == "Deprecated") {
                    return v5(suVar, i2, i3, tiVar);
                }
                if (str == "Exceptions") {
                    return VH(suVar, i2, i3, tiVar);
                }
                if (str == "RuntimeInvisibleAnnotations") {
                    return we(suVar, i2, i3, tiVar);
                }
                if (str == "RuntimeVisibleAnnotations") {
                    return J0(suVar, i2, i3, tiVar);
                }
                if (str == "RuntimeInvisibleParameterAnnotations") {
                    return J8(suVar, i2, i3, tiVar);
                }
                if (str == "RuntimeVisibleParameterAnnotations") {
                    return Ws(suVar, i2, i3, tiVar);
                }
                if (str == "Signature") {
                    return QX(suVar, i2, i3, tiVar);
                }
                if (str == "Synthetic") {
                    return aM(suVar, i2, i3, tiVar);
                }
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                if (str == "LineNumberTable") {
                    return u7(suVar, i2, i3, tiVar);
                }
                if (str == "LocalVariableTable") {
                    return tp(suVar, i2, i3, tiVar);
                }
                if (str == "LocalVariableTypeTable") {
                    return EQ(suVar, i2, i3, tiVar);
                }
                break;
        }
        return super.j6(suVar, i, str, i2, i3, tiVar);
    }

    private sz DW(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            j6();
        }
        return new qu(new sq(suVar, i, i2, tiVar).j6(), i2);
    }

    private sz FH(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 12) {
            return j6();
        }
        acu j6 = suVar.j6();
        aai Zo = suVar.Zo();
        int Zo2 = j6.Zo(i);
        int Zo3 = j6.Zo(i + 2);
        int FH = j6.FH(i + 4);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "max_stack: " + add.FH(Zo2));
            tiVar.j6(j6, i + 2, 2, "max_locals: " + add.FH(Zo3));
            tiVar.j6(j6, i + 4, 4, "code_length: " + add.j6(FH));
        }
        int i3 = i + 8;
        int i4 = i2 - 8;
        if (i4 < FH + 4) {
            return DW();
        }
        rv rvVar;
        int i5 = i3 + FH;
        i4 -= FH;
        rx rxVar = new rx(j6.j6(i3, FH + i3), Zo);
        if (tiVar != null) {
            rxVar.j6(new st(rxVar.j6(), tiVar));
        }
        int Zo4 = j6.Zo(i5);
        if (Zo4 == 0) {
            rvVar = rv.j6;
        } else {
            rvVar = new rv(Zo4);
        }
        if (tiVar != null) {
            tiVar.j6(j6, i5, 2, "exception_table_length: " + add.FH(Zo4));
        }
        i5 += 2;
        i4 -= 2;
        if (i4 < (Zo4 * 8) + 2) {
            return DW();
        }
        i3 = 0;
        int i6 = i4;
        int i7 = i5;
        while (i3 < Zo4) {
            if (tiVar != null) {
                tiVar.j6(1);
            }
            i4 = j6.Zo(i7);
            i5 = j6.Zo(i7 + 2);
            int Zo5 = j6.Zo(i7 + 4);
            abf abf = (abf) Zo.DW(j6.Zo(i7 + 6));
            rvVar.j6(i3, i4, i5, Zo5, abf);
            if (tiVar != null) {
                tiVar.j6(j6, i7, 8, add.FH(i4) + ".." + add.FH(i5) + " -> " + add.FH(Zo5) + " " + (abf == null ? "<any>" : abf.Hw()));
            }
            i5 = i7 + 8;
            i4 = i6 - 8;
            if (tiVar != null) {
                tiVar.j6(-1);
            }
            i3++;
            i6 = i4;
            i7 = i5;
        }
        rvVar.l_();
        ss ssVar = new ss(suVar, 3, i7, this);
        ssVar.j6(tiVar);
        ta DW = ssVar.DW();
        DW.l_();
        i3 = ssVar.j6() - i7;
        if (i3 != i6) {
            return j6((i7 - i) + i3);
        }
        return new qv(Zo2, Zo3, rxVar, rvVar, DW);
    }

    private sz Hw(su suVar, int i, int i2, ti tiVar) {
        if (i2 != 2) {
            return j6(2);
        }
        acu j6 = suVar.j6();
        abh abh = (abh) suVar.Zo().j6(j6.Zo(i));
        qw qwVar = new qw(abh);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "value: " + abh);
        }
        return qwVar;
    }

    private sz v5(su suVar, int i, int i2, ti tiVar) {
        if (i2 != 0) {
            return j6(0);
        }
        return new qx();
    }

    private sz Zo(su suVar, int i, int i2, ti tiVar) {
        if (i2 != 4) {
            j6(4);
        }
        acu j6 = suVar.j6();
        aai Zo = suVar.Zo();
        abf abf = (abf) Zo.j6(j6.Zo(i));
        Object obj = (abc) Zo.DW(j6.Zo(i + 2));
        sz qyVar = new qy(abf, obj);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "class: " + abf);
            tiVar.j6(j6, i + 2, 2, "method: " + su.j6(obj));
        }
        return qyVar;
    }

    private sz VH(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            return j6();
        }
        acu j6 = suVar.j6();
        int Zo = j6.Zo(i);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "number_of_exceptions: " + add.FH(Zo));
        }
        int i3 = i + 2;
        if (i2 - 2 != Zo * 2) {
            j6((Zo * 2) + 2);
        }
        return new qz(suVar.j6(i3, Zo));
    }

    private sz gn(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            return j6();
        }
        acu j6 = suVar.j6();
        aai Zo = suVar.Zo();
        int Zo2 = j6.Zo(i);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "number_of_classes: " + add.FH(Zo2));
        }
        int i3 = i + 2;
        if (i2 - 2 != Zo2 * 8) {
            j6((Zo2 * 8) + 2);
        }
        rp rpVar = new rp(Zo2);
        int i4 = 0;
        int i5 = i3;
        while (i4 < Zo2) {
            i3 = j6.Zo(i5);
            int Zo3 = j6.Zo(i5 + 2);
            int Zo4 = j6.Zo(i5 + 4);
            int Zo5 = j6.Zo(i5 + 6);
            Object obj = (abf) Zo.j6(i3);
            Object obj2 = (abf) Zo.DW(Zo3);
            Object obj3 = (abe) Zo.DW(Zo4);
            rpVar.j6(i4, obj, obj2, obj3, Zo5);
            if (tiVar != null) {
                tiVar.j6(j6, i5, 2, "inner_class: " + su.j6(obj));
                tiVar.j6(j6, i5 + 2, 2, "  outer_class: " + su.j6(obj2));
                tiVar.j6(j6, i5 + 4, 2, "  name: " + su.j6(obj3));
                tiVar.j6(j6, i5 + 6, 2, "  access_flags: " + zh.DW(Zo5));
            }
            i4++;
            i5 += 8;
        }
        rpVar.l_();
        return new ra(rpVar);
    }

    private sz u7(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            return j6();
        }
        acu j6 = suVar.j6();
        int Zo = j6.Zo(i);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "line_number_table_length: " + add.FH(Zo));
        }
        int i3 = i + 2;
        if (i2 - 2 != Zo * 4) {
            j6((Zo * 4) + 2);
        }
        sb sbVar = new sb(Zo);
        for (int i4 = 0; i4 < Zo; i4++) {
            int Zo2 = j6.Zo(i3);
            int Zo3 = j6.Zo(i3 + 2);
            sbVar.j6(i4, Zo2, Zo3);
            if (tiVar != null) {
                tiVar.j6(j6, i3, 4, add.FH(Zo2) + " " + Zo3);
            }
            i3 += 4;
        }
        sbVar.l_();
        return new rb(sbVar);
    }

    private sz tp(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            return j6();
        }
        acu j6 = suVar.j6();
        int Zo = j6.Zo(i);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "local_variable_table_length: " + add.FH(Zo));
        }
        return new rc(j6(j6.j6(i + 2, i + i2), suVar.Zo(), tiVar, Zo, false));
    }

    private sz EQ(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            return j6();
        }
        acu j6 = suVar.j6();
        int Zo = j6.Zo(i);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "local_variable_type_table_length: " + add.FH(Zo));
        }
        return new rd(j6(j6.j6(i + 2, i + i2), suVar.Zo(), tiVar, Zo, true));
    }

    private sc j6(acu acu, aai aai, ti tiVar, int i, boolean z) {
        if (acu.j6() != i * 10) {
            j6((i * 10) + 2);
        }
        acu$a DW = acu.DW();
        sc scVar = new sc(i);
        int i2 = 0;
        while (i2 < i) {
            try {
                int readUnsignedShort = DW.readUnsignedShort();
                int readUnsignedShort2 = DW.readUnsignedShort();
                int readUnsignedShort3 = DW.readUnsignedShort();
                int readUnsignedShort4 = DW.readUnsignedShort();
                int readUnsignedShort5 = DW.readUnsignedShort();
                abe abe = (abe) aai.j6(readUnsignedShort3);
                abe abe2 = (abe) aai.j6(readUnsignedShort4);
                abe abe3 = null;
                abe abe4 = null;
                if (z) {
                    abe4 = abe2;
                } else {
                    abe3 = abe2;
                }
                scVar.j6(i2, readUnsignedShort, readUnsignedShort2, abe, abe3, abe4, readUnsignedShort5);
                if (tiVar != null) {
                    tiVar.j6(acu, i2 * 10, 10, add.FH(readUnsignedShort) + ".." + add.FH(readUnsignedShort + readUnsignedShort2) + " " + add.FH(readUnsignedShort5) + " " + abe.Hw() + " " + abe2.Hw());
                }
                i2++;
            } catch (Throwable e) {
                throw new RuntimeException("shouldn't happen", e);
            }
        }
        scVar.l_();
        return scVar;
    }

    private sz we(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            j6();
        }
        return new re(new sq(suVar, i, i2, tiVar).DW(zd.BUILD), i2);
    }

    private sz J0(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            j6();
        }
        return new rg(new sq(suVar, i, i2, tiVar).DW(zd.RUNTIME), i2);
    }

    private sz J8(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            j6();
        }
        return new rf(new sq(suVar, i, i2, tiVar).j6(zd.BUILD), i2);
    }

    private sz Ws(su suVar, int i, int i2, ti tiVar) {
        if (i2 < 2) {
            j6();
        }
        return new rh(new sq(suVar, i, i2, tiVar).j6(zd.RUNTIME), i2);
    }

    private sz QX(su suVar, int i, int i2, ti tiVar) {
        if (i2 != 2) {
            j6(2);
        }
        acu j6 = suVar.j6();
        abe abe = (abe) suVar.Zo().j6(j6.Zo(i));
        sz riVar = new ri(abe);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "signature: " + abe);
        }
        return riVar;
    }

    private sz XL(su suVar, int i, int i2, ti tiVar) {
        if (i2 != 2) {
            j6(2);
        }
        acu j6 = suVar.j6();
        abe abe = (abe) suVar.Zo().j6(j6.Zo(i));
        sz rjVar = new rj(abe);
        if (tiVar != null) {
            tiVar.j6(j6, i, 2, "source: " + abe);
        }
        return rjVar;
    }

    private sz aM(su suVar, int i, int i2, ti tiVar) {
        if (i2 != 0) {
            return j6(0);
        }
        return new rk();
    }

    private static sz j6() {
        throw new th("severely truncated attribute");
    }

    private static sz DW() {
        throw new th("truncated attribute");
    }

    private static sz j6(int i) {
        throw new th("bad attribute length; expected length " + add.j6(i));
    }
}
