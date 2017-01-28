import com.aide.uidesigner.ProxyTextView;

public class hu implements bl {
    private static boolean[] DW;
    private static boolean[] FH;
    private static boolean[] Hw;
    private static boolean[] v5;
    private final by j6;

    public hu(by byVar) {
        this.j6 = byVar;
    }

    public boolean j6(int i) {
        return false;
    }

    public boolean J8(int i) {
        return i <= 7 && i >= 2;
    }

    public boolean QX(int i) {
        return false;
    }

    public boolean j3(int i) {
        return false;
    }

    public boolean Mr(int i) {
        switch (i) {
            case 66:
            case 68:
            case 74:
                return true;
            default:
                return J8(i);
        }
    }

    public boolean DW(int i) {
        return i == 190;
    }

    public boolean v5(int i) {
        return i == 197;
    }

    public boolean Zo(int i) {
        return false;
    }

    public boolean Hw(int i) {
        return i == 207;
    }

    public boolean FH(int i) {
        return i == 125;
    }

    public boolean VH(int i) {
        return i == 133;
    }

    public boolean gn(int i) {
        return i == 1;
    }

    public boolean Ws(int i) {
        return i < 120;
    }

    public boolean we(int i) {
        return i == 125 || i == 207;
    }

    static {
        DW = new boolean[400];
        DW[66] = true;
        DW[68] = true;
        DW[74] = true;
        DW[2] = true;
        DW[3] = true;
        DW[4] = true;
        DW[5] = true;
        DW[6] = true;
        DW[7] = true;
        DW[159] = true;
        DW[ProxyTextView.INPUTTYPE_textWebEditText] = true;
        DW[165] = true;
        DW[196] = true;
        DW[166] = true;
        DW[168] = true;
        DW[178] = true;
        DW[170] = true;
        DW[171] = true;
        DW[172] = true;
        DW[175] = true;
        DW[ProxyTextView.INPUTTYPE_textFilter] = true;
        DW[173] = true;
        DW[163] = true;
        DW[164] = true;
        DW[176] = true;
        FH = new boolean[400];
        FH[146] = true;
        FH[151] = true;
        FH[135] = true;
        FH[137] = true;
        FH[136] = true;
        FH[211] = true;
        FH[212] = true;
        FH[ProxyTextView.INPUTTYPE_textVisiblePassword] = true;
        FH[148] = true;
        FH[138] = true;
        FH[139] = true;
        FH[146] = true;
        FH[142] = true;
        FH[141] = true;
        FH[150] = true;
        FH[149] = true;
        FH[147] = true;
        FH[133] = true;
        Hw = new boolean[400];
        Hw[1] = true;
        Hw[159] = true;
        Hw[ProxyTextView.INPUTTYPE_textWebEditText] = true;
        Hw[165] = true;
        Hw[166] = true;
        Hw[168] = true;
        Hw[178] = true;
        Hw[170] = true;
        Hw[171] = true;
        Hw[172] = true;
        Hw[175] = true;
        Hw[ProxyTextView.INPUTTYPE_textFilter] = true;
        Hw[176] = true;
        Hw[2] = true;
        Hw[3] = true;
        Hw[4] = true;
        Hw[5] = true;
        Hw[6] = true;
        Hw[7] = true;
        Hw[74] = true;
        Hw[68] = true;
        Hw[66] = true;
        v5 = new boolean[400];
        v5[ProxyTextView.INPUTTYPE_textWebEditText] = true;
        v5[159] = true;
        v5[168] = true;
        v5[178] = true;
        v5[170] = true;
        v5[172] = true;
        v5[3] = true;
        v5[4] = true;
        v5[5] = true;
        v5[6] = true;
        v5[7] = true;
        v5[74] = true;
        v5[68] = true;
    }

    public boolean u7(int i) {
        return DW[i];
    }

    public boolean tp(int i) {
        return i == 146;
    }

    public boolean EQ(int i) {
        return FH[i];
    }

    public boolean J0(int i) {
        return i == 223;
    }

    public boolean P8(int i) {
        return Hw[i];
    }

    public boolean gW(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case 147:
            case 205:
            case 211:
                return true;
            default:
                return false;
        }
    }

    public boolean BT(int i) {
        return i == 1;
    }

    public boolean vy(int i) {
        switch (i) {
            case 138:
            case 139:
                return true;
            default:
                return false;
        }
    }

    public boolean ei(int i) {
        return v5[i];
    }

    public boolean lg(int i) {
        return false;
    }

    public boolean rN(int i) {
        return false;
    }

    public boolean a8(int i) {
        switch (i) {
            case 54:
            case 55:
            case 56:
            case 58:
            case 59:
            case 61:
            case 63:
            case 64:
            case 66:
            case 67:
            case 68:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 114:
            case 118:
            case 119:
                return true;
            default:
                return false;
        }
    }

    public boolean er(int i) {
        switch (i) {
            case 57:
            case 60:
            case 62:
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
            case 69:
            case 76:
            case 77:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 89:
                return true;
            default:
                return false;
        }
    }

    public boolean yS(int i) {
        switch (i) {
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 26:
                return true;
            default:
                return false;
        }
    }

    public boolean U2(int i) {
        switch (i) {
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case 19:
            case ProxyTextView.INPUTTYPE_date /*20*/:
            case 21:
            case 22:
            case 23:
            case 24:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
            case 34:
            case 35:
            case ProxyTextView.INPUTTYPE_time /*36*/:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
            case 50:
            case 51:
            case 52:
            case 53:
            case 115:
            case 116:
                return true;
            default:
                return false;
        }
    }

    public int nw(int i) {
        switch (i) {
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                return 6;
            case 19:
            case 30:
            case 32:
                return 2;
            case 21:
                return 3;
            case 25:
                return 12;
            case 27:
                return 3;
            case 35:
                return 6;
            case ProxyTextView.INPUTTYPE_time /*36*/:
                return 8;
            case 38:
                return 9;
            case 39:
                return 11;
            case 41:
                return 7;
            case 42:
                return 10;
            case 44:
                return 5;
            case 45:
                return 5;
            case 46:
                return 4;
            case 48:
                return 5;
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                return 5;
            case 50:
                return 4;
            case 51:
                return 4;
            case 115:
                return 6;
            case 116:
                return 6;
            default:
                return 13;
        }
    }

    public String XL(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return "IDENTIFIER";
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return "STRING_LITERAL";
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return "CHAR_LITERAL";
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return "INT_LITERAL";
            case 5:
                return "LONG_LITERAL";
            case 6:
                return "FLOAT_LITERAL";
            case 7:
                return "DOUBLE_LITERAL";
            case 8:
                return "{";
            case 9:
                return "}";
            case 10:
                return "[";
            case 11:
                return "]";
            case 12:
                return "(";
            case 13:
                return ")";
            case 14:
                return ";";
            case 15:
                return ",";
            case 16:
                return ".";
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                return "=";
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                return "==";
            case 19:
                return "/";
            case ProxyTextView.INPUTTYPE_date /*20*/:
                return "/=";
            case 21:
                return "+";
            case 22:
                return "++";
            case 23:
                return "+=";
            case 24:
                return "~";
            case 25:
                return "?";
            case 26:
                return ":";
            case 27:
                return "-";
            case 28:
                return "--";
            case 29:
                return "-=";
            case 30:
                return "*";
            case 31:
                return "*=";
            case 32:
                return "%";
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                return "%=";
            case 34:
                return "!";
            case 35:
                return "!=";
            case ProxyTextView.INPUTTYPE_time /*36*/:
                return "^";
            case 37:
                return "^=";
            case 38:
                return "|";
            case 39:
                return "||";
            case 40:
                return "|=";
            case 41:
                return "&";
            case 42:
                return "&&";
            case 43:
                return "&=";
            case 44:
                return "<";
            case 45:
                return "<=";
            case 46:
                return "<<";
            case 47:
                return "<<=";
            case 48:
                return ">";
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                return ">=";
            case 50:
                return ">>";
            case 51:
                return ">>>";
            case 52:
                return ">>=";
            case 53:
                return ">>>=";
            case 54:
                return "do";
            case 55:
                return "if";
            case 56:
                return "for";
            case 57:
                return "int";
            case 58:
                return "new";
            case 59:
                return "try";
            case 60:
                return "byte";
            case 61:
                return "case";
            case 62:
                return "char";
            case 63:
                return "else";
            case 64:
                return "goto";
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                return "long";
            case 66:
                return "null";
            case 67:
                return "this";
            case 68:
                return "true";
            case 69:
                return "void";
            case 70:
                return "break";
            case 71:
                return "catch";
            case 72:
                return "class";
            case 73:
                return "const";
            case 74:
                return "false";
            case 75:
                return "final";
            case 76:
                return "float";
            case 77:
                return "short";
            case 78:
                return "super";
            case 79:
                return "throw";
            case 80:
                return "while";
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                return "double";
            case 82:
                return "import";
            case 83:
                return "native";
            case 84:
                return "public";
            case 85:
                return "return";
            case 86:
                return "static";
            case 87:
                return "switch";
            case 88:
                return "throws";
            case 89:
                return "boolean";
            case 90:
                return "default";
            case 91:
                return "extends";
            case 92:
                return "finally";
            case 93:
                return "package";
            case 94:
                return "private";
            case 95:
                return "abstract";
            case 96:
                return "continue";
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                return "function";
            case 98:
                return "var";
            case 99:
                return "interface";
            case 100:
                return "protected";
            case 101:
                return "transient";
            case 102:
                return "implements";
            case 103:
                return "instanceof";
            case 104:
                return "synchronized";
            case 105:
                return "typeof";
            case 106:
                return "with";
            case 107:
                return "label";
            case 114:
                return "in";
            case 115:
                return "===";
            case 116:
                return "!==";
            case 118:
                return "delete";
            case 119:
                return "debugger";
            case 124:
                return "FUNCTION_DECLARATION";
            case 125:
                return "GLOBAL_FUNCTION_DECLARATION";
            case 133:
                return "BLOCK";
            case 134:
                return "EMPTY_STATEMENT";
            case 135:
                return "IF_STATEMENT";
            case 136:
                return "IFELSE_STATEMENT";
            case 137:
                return "WHILE_STATEMENT";
            case 138:
                return "BREAK_STATEMENT";
            case 139:
                return "CONTINUE_STATEMENT";
            case 140:
                return "OBJECT";
            case 141:
                return "RETURN_STATEMENT";
            case 142:
                return "THROW_STATEMENT";
            case 143:
                return "CASE_LABEL";
            case 144:
                return "DEFAULT_LABEL";
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                return "DO_STATEMENT";
            case 146:
                return "EXPRESSION_STATEMENT";
            case 147:
                return "SWITCH_STATEMENT";
            case 148:
                return "LABELED_STATEMENT";
            case 149:
                return "FOR_STATEMENT";
            case 150:
                return "TRY_STATEMENT";
            case 151:
                return "VARIABLE_DECLARATION";
            case 152:
                return "GLOBAL_VARIABLE_DECLARATION";
            case 159:
                return "MEMBER_ACCESS";
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                return "VARIABLE_ACCESS";
            case 163:
                return "DELETE_EXPRESSION";
            case 164:
                return "VOID_EXPRESSION";
            case 165:
                return "ARRAY_ACCESS";
            case 166:
                return "THIS_LITERAL";
            case 168:
                return "PARENTHESIZED_EXPRESSION";
            case 170:
                return "PREFIX_EXPRESSION";
            case 171:
                return "POSTFIX_EXPRESSION";
            case 172:
                return "INFIX_EXPRESSION";
            case 173:
                return "TYPEOF_EXPRESSION";
            case 175:
                return "INVOCATION";
            case 176:
                return "OBJECT_CREATION";
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                return "INSTANCEOF_EXPRESSION";
            case 178:
                return "COMMA_EXPRESSION";
            case 190:
                return "PARAMETERS";
            case 191:
                return "PARAMETER";
            case 196:
                return "ARRAY";
            case 197:
                return "ARGUMENTS";
            case 199:
                return "DUMMY";
            case 200:
                return "VARIABLE";
            case 201:
                return "FOR_INIT_CLAUSE";
            case 202:
                return "FOR_UPDATE_CLAUSE";
            case 203:
                return "FOR_CONDITION_CLAUSE";
            case 204:
                return "CATCH_CLAUSE";
            case 205:
                return "FINALLY_CLAUSE";
            case 207:
                return "GLOBAL_VARIABLE";
            case 210:
                return "CONDITIONAL_OPERATOR";
            case 211:
                return "FOREACH_STATEMENT";
            case 212:
                return "WITH_STATEMENT";
            case 213:
                return "INCLUDE_STATEMENT";
            case 223:
                return "COMPILATIONUNIT";
            default:
                return "";
        }
    }

    public int aM(int i) {
        switch (i) {
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
            case 19:
            case 21:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 32:
            case 34:
            case ProxyTextView.INPUTTYPE_time /*36*/:
            case 38:
            case 41:
            case 44:
            case 48:
                return 1;
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                return 2;
            case ProxyTextView.INPUTTYPE_date /*20*/:
                return 2;
            case 22:
                return 2;
            case 23:
                return 2;
            case 28:
                return 2;
            case 29:
                return 2;
            case 31:
                return 2;
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                return 2;
            case 35:
                return 2;
            case 37:
                return 2;
            case 39:
                return 2;
            case 40:
                return 2;
            case 42:
                return 2;
            case 43:
                return 2;
            case 45:
                return 2;
            case 46:
                return 2;
            case 47:
                return 3;
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                return 2;
            case 50:
                return 2;
            case 51:
                return 3;
            case 52:
                return 3;
            case 53:
                return 4;
            case 54:
                return 2;
            case 55:
                return 2;
            case 56:
                return 3;
            case 57:
                return 3;
            case 58:
                return 3;
            case 59:
                return 3;
            case 60:
                return 4;
            case 61:
                return 4;
            case 62:
                return 4;
            case 63:
                return 4;
            case 64:
                return 4;
            case ProxyTextView.INPUTTYPE_textShortMessage /*65*/:
                return 4;
            case 66:
                return 4;
            case 67:
                return 4;
            case 68:
                return 4;
            case 69:
                return 4;
            case 70:
                return 5;
            case 71:
                return 5;
            case 72:
                return 5;
            case 73:
                return 5;
            case 74:
                return 5;
            case 75:
                return 5;
            case 76:
                return 5;
            case 77:
                return 5;
            case 78:
                return 5;
            case 79:
                return 5;
            case 80:
                return 5;
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
                return 6;
            case 82:
                return 6;
            case 83:
                return 6;
            case 84:
                return 6;
            case 85:
                return 6;
            case 86:
                return 6;
            case 87:
                return 6;
            case 88:
                return 6;
            case 89:
                return 7;
            case 90:
                return 7;
            case 91:
                return 7;
            case 92:
                return 7;
            case 93:
                return 7;
            case 94:
                return 7;
            case 95:
                return 8;
            case 96:
                return 8;
            case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                return 8;
            case 98:
                return 3;
            case 99:
                return 9;
            case 100:
                return 9;
            case 101:
                return 9;
            case 102:
                return 10;
            case 103:
                return 10;
            case 104:
                return 12;
            case 105:
                return 6;
            case 106:
                return 4;
            case 107:
                return 5;
            case 114:
                return 2;
            case 115:
                return 3;
            case 116:
                return 3;
            case 118:
                return 6;
            case 119:
                return 8;
            default:
                return 0;
        }
    }

    public boolean VH(cj cjVar, int i) {
        return false;
    }

    public boolean Hw(cj cjVar, int i) {
        return false;
    }

    public int v5(cj cjVar, int i) {
        return cjVar.aM(i);
    }

    public boolean FH(cj cjVar, int i) {
        return false;
    }

    public int Zo(cj cjVar, int i) {
        return 0;
    }

    public boolean DW(cj cjVar, int i) {
        return false;
    }

    public boolean j6(cj cjVar, int i) {
        if (cjVar.rN(cjVar.aM(i)) == 125 || cjVar.rN(cjVar.aM(i)) == 207 || lg(cjVar, i) || Mr(cjVar, i)) {
            return true;
        }
        return false;
    }

    public int tp(cj cjVar, int i) {
        return (cjVar.lg(i) - 1) / 2;
    }

    public int j6(cj cjVar, int i, int i2) {
        return cjVar.Hw(i, (i2 * 2) + 1);
    }

    public int EQ(cj cjVar, int i) {
        return cjVar.Hw(i, 0);
    }

    public int we(cj cjVar, int i) {
        return cjVar.Hw(i, cjVar.lg(i) - 1);
    }

    public int DW(cj cjVar, int i, int i2) {
        return cjVar.Hw(i, (i2 * 2) + 1);
    }

    public int J0(cj cjVar, int i) {
        return (cjVar.lg(i) - 1) / 2;
    }

    public int J8(cj cjVar, int i) {
        return cjVar.Hw(i, 0);
    }

    public int Ws(cj cjVar, int i) {
        return cjVar.Hw(i, cjVar.lg(i) - 1);
    }

    public do j6(cj cjVar) {
        return new do();
    }

    public do DW(cj cjVar) {
        return null;
    }

    public int FH(cj cjVar) {
        return 1;
    }

    public int Hw(cj cjVar) {
        return 1;
    }

    public int v5(cj cjVar) {
        return 0;
    }

    public int Zo(cj cjVar) {
        return 0;
    }

    public boolean gn(cj cjVar, int i) {
        return cjVar.rN(cjVar.aM(i)) == 172 && cjVar.rN(cjVar.Hw(cjVar.aM(i), 1)) == 17 && cjVar.Hw(cjVar.aM(i), 0) == i;
    }

    public boolean u7(cj cjVar, int i) {
        if (cjVar.rN(cjVar.aM(i)) == 172 && cjVar.Hw(cjVar.aM(i), 0) == i) {
            switch (cjVar.rN(cjVar.Hw(cjVar.aM(i), 1))) {
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                case ProxyTextView.INPUTTYPE_date /*20*/:
                case 23:
                case 29:
                case 31:
                case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                case 37:
                case 40:
                case 43:
                case 47:
                case 52:
                case 53:
                    return true;
            }
        }
        if (cjVar.rN(cjVar.aM(i)) == 171) {
            switch (cjVar.rN(cjVar.Hw(cjVar.aM(i), 1))) {
                case 22:
                case 28:
                    return true;
            }
        }
        if (cjVar.rN(cjVar.aM(i)) == 170) {
            switch (cjVar.rN(cjVar.Hw(cjVar.aM(i), 0))) {
                case 22:
                case 28:
                    return true;
            }
        }
        return false;
    }

    public int QX(cj cjVar, int i) {
        return 0;
    }

    public boolean Mr(cj cjVar, int i) {
        if (cjVar.rN(cjVar.aM(i)) == 140 && cjVar.rN(cjVar.dx(cjVar.dx(i))) == 124) {
            return true;
        }
        if (cjVar.rN(cjVar.aM(i)) == 159 && cjVar.rN(cjVar.aM(cjVar.aM(i))) == 172 && cjVar.rN(cjVar.Hw(cjVar.aM(cjVar.aM(i)), 2)) == 124 && cjVar.rN(cjVar.Hw(cjVar.aM(cjVar.aM(i)), 1)) == 17 && cjVar.Hw(cjVar.aM(cjVar.aM(i)), 0) == cjVar.aM(i)) {
            return true;
        }
        return false;
    }

    public int U2(cj cjVar, int i) {
        if (cjVar.rN(cjVar.aM(i)) == 140) {
            return cjVar.sh(cjVar.sh(i));
        }
        if (cjVar.rN(cjVar.aM(i)) == 172 && cjVar.rN(cjVar.Hw(cjVar.aM(i), 0)) == 159 && cjVar.rN(cjVar.Hw(cjVar.aM(i), 1)) == 17) {
            return cjVar.Hw(cjVar.Hw(cjVar.aM(i), 0), 2);
        }
        return -1;
    }

    public int a8(cj cjVar, int i) {
        int dx;
        if (cjVar.rN(cjVar.aM(i)) == 140 && cjVar.rN(cjVar.dx(cjVar.dx(i))) == 124) {
            dx = cjVar.dx(cjVar.dx(i));
            return cjVar.Hw(dx, cjVar.lg(dx) - 2);
        } else if (cjVar.rN(cjVar.aM(i)) != 159 || cjVar.rN(cjVar.aM(cjVar.aM(i))) != 172 || cjVar.rN(cjVar.Hw(cjVar.aM(cjVar.aM(i)), 2)) != 124 || cjVar.rN(cjVar.Hw(cjVar.aM(cjVar.aM(i)), 1)) != 17 || cjVar.Hw(cjVar.aM(cjVar.aM(i)), 0) != cjVar.aM(i)) {
            return -1;
        } else {
            dx = cjVar.Hw(cjVar.aM(cjVar.aM(i)), 2);
            return cjVar.Hw(dx, cjVar.lg(dx) - 2);
        }
    }

    public boolean lg(cj cjVar, int i) {
        if (cjVar.rN(cjVar.aM(i)) == 140 && cjVar.rN(cjVar.dx(cjVar.dx(i))) != 124) {
            return true;
        }
        if (cjVar.rN(cjVar.aM(i)) == 159 && cjVar.rN(cjVar.Hw(cjVar.aM(i), 0)) == 166 && cjVar.rN(cjVar.aM(cjVar.aM(i))) == 172 && cjVar.rN(cjVar.Hw(cjVar.aM(cjVar.aM(i)), 2)) != 124 && cjVar.rN(cjVar.Hw(cjVar.aM(cjVar.aM(i)), 1)) == 17 && cjVar.Hw(cjVar.aM(cjVar.aM(i)), 0) == cjVar.aM(i)) {
            return true;
        }
        return false;
    }

    public boolean XL(cj cjVar, int i) {
        return false;
    }

    public String aM(cj cjVar, int i) {
        return null;
    }

    public String j3(cj cjVar, int i) {
        return null;
    }

    public int rN(cj cjVar, int i) {
        int gW;
        int lg;
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                gW = cjVar.gW(i);
                break;
            case 165:
                gW = rN(cjVar, cjVar.Hw(i, 0));
                break;
            case 175:
                gW = rN(cjVar, cjVar.Hw(i, 0));
                break;
            case 176:
                gW = rN(cjVar, cjVar.Hw(i, 2));
                break;
            default:
                gW = -1;
                break;
        }
        if (gW == -1) {
            lg = cjVar.lg(i) - 1;
            while (lg >= 0) {
                int Hw = cjVar.Hw(i, lg);
                if (cjVar.rN(Hw) == 1) {
                    gW = cjVar.gW(Hw);
                } else {
                    lg--;
                }
            }
        }
        if (gW == -1) {
            lg = cjVar.lg(i) - 1;
            while (lg >= 0) {
                gW = rN(cjVar, cjVar.Hw(i, lg));
                if (gW == -1) {
                    lg--;
                }
            }
        }
        if (gW == -1) {
            return gW;
        }
        String j6 = this.j6.j6(gW);
        if ((j6.startsWith("get") || j6.startsWith("set")) && j6.length() > 3) {
            return this.j6.j6(j6.substring(3, 4).toLowerCase() + j6.substring(4, j6.length()));
        } else if (j6.length() <= 0) {
            return gW;
        } else {
            return this.j6.j6(j6.substring(0, 1).toLowerCase() + j6.substring(1, j6.length()));
        }
    }
}
