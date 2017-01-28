import com.aide.uidesigner.ProxyTextView;

public class ik implements bl {
    public boolean j6(int i) {
        switch (i) {
            case 75:
            case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
            case 210:
            case 216:
            case 301:
            case 320:
                return true;
            default:
                return false;
        }
    }

    public int QX(cj cjVar, int i) {
        if (cjVar.rN(i) == 210) {
            return cjVar.Hw(cjVar.Hw(i, 0), 1);
        }
        return 0;
    }

    public boolean DW(int i) {
        return false;
    }

    public boolean FH(int i) {
        return false;
    }

    public boolean Hw(int i) {
        return false;
    }

    public boolean v5(int i) {
        return false;
    }

    public boolean er(int i) {
        return false;
    }

    public boolean Zo(int i) {
        return false;
    }

    public boolean VH(int i) {
        return i == 210;
    }

    public boolean lg(int i) {
        switch (i) {
            case 40:
            case 41:
            case 42:
            case 44:
            case 45:
            case 75:
                return true;
            default:
                return false;
        }
    }

    public boolean rN(int i) {
        return false;
    }

    public boolean a8(int i) {
        return i == 25;
    }

    public boolean gn(int i) {
        switch (i) {
            case 21:
            case 25:
            case 26:
            case 29:
            case 38:
            case 50:
                return true;
            default:
                return false;
        }
    }

    public boolean u7(int i) {
        return false;
    }

    public boolean tp(int i) {
        return false;
    }

    public boolean EQ(int i) {
        return i == 210;
    }

    public boolean we(int i) {
        return false;
    }

    public boolean J0(int i) {
        return false;
    }

    public boolean j3(int i) {
        switch (i) {
            case 46:
            case 47:
            case 77:
                return true;
            default:
                return false;
        }
    }

    public boolean Mr(int i) {
        switch (i) {
            case 16:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case ProxyTextView.INPUTTYPE_date /*20*/:
            case 21:
            case 22:
            case 23:
            case 37:
                return true;
            default:
                return false;
        }
    }

    public boolean J8(int i) {
        switch (i) {
            case 6:
            case 14:
            case 15:
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case ProxyTextView.INPUTTYPE_date /*20*/:
            case 37:
            case 41:
            case 46:
            case 48:
            case 77:
                return true;
            default:
                return false;
        }
    }

    public boolean QX(int i) {
        switch (i) {
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
            case 39:
            case 45:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 78:
                return true;
            default:
                return false;
        }
    }

    public boolean yS(int i) {
        switch (i) {
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 76:
            case 100:
                return true;
            default:
                return false;
        }
    }

    public boolean U2(int i) {
        return false;
    }

    public boolean Ws(int i) {
        return i < 200;
    }

    public String XL(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return "EOF";
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return "S";
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return "<![CDATA[";
            case 5:
                return "]]>";
            case 6:
                return "CDATA_CONTENT";
            case 7:
                return "<";
            case 8:
                return ">";
            case 11:
                return "</";
            case 12:
                return "/>";
            case 13:
                return "=";
            case 14:
                return "CHAR_DATA";
            case 15:
                return "WHITESPACE_CHAR_DATA";
            case 16:
                return "'";
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                return "\"";
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                return "ATTRIBUTE_VALUE_PART";
            case ProxyTextView.INPUTTYPE_date /*20*/:
                return "ATTRIBUTE_VALUE_CHAR_REFERENCE";
            case 21:
                return "ATTRIBUTE_VALUE_ENTITY_NAME";
            case 22:
                return "&";
            case 23:
                return ";";
            case 24:
                return "CHAR_REFERENCE";
            case 25:
                return "TAG_NAME";
            case 26:
                return "ATTRIBUTE_NAME";
            case 27:
                return "&";
            case 28:
                return ";";
            case 29:
                return "ENTITY_NAME";
            case 30:
                return "<?xml";
            case 31:
                return "<?";
            case 32:
                return "?>";
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                return "PI_CONTENT";
            case 34:
                return "<!DOCTYPE";
            case 35:
                return "SYSTEM";
            case ProxyTextView.INPUTTYPE_time /*36*/:
                return "PUBLIC";
            case 37:
                return "DOCTYPE_DECL_LITERAL";
            case 38:
                return "DOCTYPE_DECL_NAME";
            case 39:
                return "DOCTYPE_INTERNAL_MARKUP_DECLARATIONS";
            case 40:
                return "<!--";
            case 41:
                return "COMMENT_CONTENT_PART";
            case 44:
                return "-->";
            case 45:
                return "-- >";
            case 46:
                return "SCRIPT_CONTENT";
            case 47:
                return "SCRIPT_CONTENT_INVALID_LT_SLASH";
            case 48:
                return "STYLE_CONTENT";
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                return ":";
            case 50:
                return "INVALID_ATTRIBUTE_NAME";
            case 70:
                return "<% @";
            case 71:
                return "<%";
            case 72:
                return "<% =";
            case 73:
                return "<% #";
            case 74:
                return "<% $";
            case 75:
                return "ASP_COMMENT";
            case 76:
                return "%>";
            case 77:
                return "ASP_CODE_BLOCK_CONTENT";
            case 78:
                return "ASP_LOCALIZATION_EXPRESSION_CONTENT";
            case 100:
                return "<%!";
            case 200:
                return "STAG";
            case 201:
                return "EMPTY_ELEMENT_TAG";
            case 203:
                return "ATTRIBUTE";
            case 204:
                return "ATTRIBUTE_VALUE";
            case 205:
                return "ENTITY_REFERENCE";
            case 206:
                return "DOCUMENT";
            case 207:
                return "ETAG";
            case 208:
                return "HTML_SYNTHETIC_ETAG";
            case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
                return "CDATA_SECTION";
            case 210:
                return "FULL_ELEMENT";
            case 211:
                return "CONTENT";
            case 212:
                return "XML_DECL";
            case 213:
                return "DOCTYPE_DECL";
            case 214:
                return "EXTERNAL_SYSTEM_ID";
            case 215:
                return "EXTERNAL_PUBLIC_ID";
            case 216:
                return "COMMENT";
            case 217:
                return "QUALIFIED_TAG_NAME";
            case 218:
                return "QUALIFIED_ATTRIBUTE_NAME";
            case 300:
                return "ASP_DIRECTIVE";
            case 301:
                return "ASP_CODE_RENDER_BLOCK";
            case 302:
                return "ASP_CODE_RENDER_EXPRESSION";
            case 303:
                return "ASP_DATA_BINDING_EXPRESSION";
            case 304:
                return "ASP_DIRECTIVE_ATTRIBUTE";
            case 305:
                return "ASP_DIRECTIVE_ATTRIBUTE_VALUE";
            case 306:
                return "ASP_LOCALIZATION_EXPRESSION";
            case 320:
                return "JSP_CODE_DECLARATION_BLOCK";
            default:
                return "???" + i + "???";
        }
    }

    public int aM(int i) {
        switch (i) {
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return 9;
            case 5:
                return 3;
            case 7:
                return 1;
            case 8:
                return 1;
            case 11:
                return 2;
            case 12:
                return 2;
            case 13:
                return 1;
            case 16:
                return 1;
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                return 1;
            case 22:
                return 1;
            case 23:
                return 1;
            case 27:
                return 1;
            case 28:
                return 1;
            case 30:
                return 5;
            case 31:
                return 2;
            case 32:
                return 2;
            case 34:
                return 9;
            case 35:
                return 6;
            case ProxyTextView.INPUTTYPE_time /*36*/:
                return 6;
            case 40:
                return 3;
            case 44:
                return 3;
            case 47:
                return 2;
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                return 1;
            case 71:
                return 2;
            case 76:
                return 2;
            case 100:
                return 3;
            default:
                return 0;
        }
    }

    public boolean gW(int i) {
        return false;
    }

    public boolean BT(int i) {
        return false;
    }

    public boolean vy(int i) {
        return false;
    }

    public boolean P8(int i) {
        return false;
    }

    public boolean ei(int i) {
        return false;
    }

    public boolean j6(cj cjVar, int i) {
        return false;
    }

    public boolean DW(cj cjVar, int i) {
        return false;
    }

    public boolean FH(cj cjVar, int i) {
        return false;
    }

    public boolean Hw(cj cjVar, int i) {
        return false;
    }

    public int v5(cj cjVar, int i) {
        return 0;
    }

    public int Zo(cj cjVar, int i) {
        return 0;
    }

    public boolean VH(cj cjVar, int i) {
        return false;
    }

    public boolean gn(cj cjVar, int i) {
        return false;
    }

    public boolean u7(cj cjVar, int i) {
        return false;
    }

    public int j6(cj cjVar, int i, int i2) {
        return 0;
    }

    public int tp(cj cjVar, int i) {
        return 0;
    }

    public int EQ(cj cjVar, int i) {
        return 0;
    }

    public int we(cj cjVar, int i) {
        return 0;
    }

    public int DW(cj cjVar, int i, int i2) {
        return 0;
    }

    public int J0(cj cjVar, int i) {
        return 0;
    }

    public int J8(cj cjVar, int i) {
        return 0;
    }

    public int Ws(cj cjVar, int i) {
        return 0;
    }

    public do j6(cj cjVar) {
        return null;
    }

    public do DW(cj cjVar) {
        return null;
    }

    public int FH(cj cjVar) {
        return 0;
    }

    public int Hw(cj cjVar) {
        return 0;
    }

    public int v5(cj cjVar) {
        return 0;
    }

    public int Zo(cj cjVar) {
        return 0;
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

    public static boolean Mr(cj cjVar, int i) {
        int Hw = cjVar.Hw(i, 0);
        if (cjVar.er(cjVar.Hw(Hw, 0)) && cjVar.er(cjVar.Hw(Hw, 1))) {
            return true;
        }
        return false;
    }

    public static int U2(cj cjVar, int i) {
        if (Mr(cjVar, i)) {
            return cjVar.gW(cjVar.Hw(cjVar.Hw(i, 0), 2));
        }
        return 0;
    }

    public static int a8(cj cjVar, int i) {
        int U2 = U2(cjVar, i);
        if (U2 != 0) {
            return cjVar.EQ().ro.FH(U2);
        }
        return 0;
    }
}
