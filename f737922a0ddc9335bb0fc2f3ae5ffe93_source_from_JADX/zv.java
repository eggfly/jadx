import com.aide.uidesigner.ProxyTextView;

public final class zv {
    public static String j6(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return "nop";
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return "move";
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return "move-param";
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return "move-exception";
            case 5:
                return "const";
            case 6:
                return "goto";
            case 7:
                return "if-eq";
            case 8:
                return "if-ne";
            case 9:
                return "if-lt";
            case 10:
                return "if-ge";
            case 11:
                return "if-le";
            case 12:
                return "if-gt";
            case 13:
                return "switch";
            case 14:
                return "add";
            case 15:
                return "sub";
            case 16:
                return "mul";
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                return "div";
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                return "rem";
            case 19:
                return "neg";
            case ProxyTextView.INPUTTYPE_date /*20*/:
                return "and";
            case 21:
                return "or";
            case 22:
                return "xor";
            case 23:
                return "shl";
            case 24:
                return "shr";
            case 25:
                return "ushr";
            case 26:
                return "not";
            case 27:
                return "cmpl";
            case 28:
                return "cmpg";
            case 29:
                return "conv";
            case 30:
                return "to-byte";
            case 31:
                return "to-char";
            case 32:
                return "to-short";
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                return "return";
            case 34:
                return "array-length";
            case 35:
                return "throw";
            case ProxyTextView.INPUTTYPE_time /*36*/:
                return "monitor-enter";
            case 37:
                return "monitor-exit";
            case 38:
                return "aget";
            case 39:
                return "aput";
            case 40:
                return "new-instance";
            case 41:
                return "new-array";
            case 42:
                return "filled-new-array";
            case 43:
                return "check-cast";
            case 44:
                return "instance-of";
            case 45:
                return "get-field";
            case 46:
                return "get-static";
            case 47:
                return "put-field";
            case 48:
                return "put-static";
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                return "invoke-static";
            case 50:
                return "invoke-virtual";
            case 51:
                return "invoke-super";
            case 52:
                return "invoke-direct";
            case 53:
                return "invoke-interface";
            case 55:
                return "move-result";
            case 56:
                return "move-result-pseudo";
            case 57:
                return "fill-array-data";
            default:
                return "unknown-" + add.v5(i);
        }
    }

    public static int DW(int i) {
        switch (i) {
            case 7:
            case 8:
                return i;
            case 9:
                return 12;
            case 10:
                return 11;
            case 11:
                return 10;
            case 12:
                return 9;
            default:
                throw new RuntimeException("Unrecognized IF regop: " + i);
        }
    }
}
