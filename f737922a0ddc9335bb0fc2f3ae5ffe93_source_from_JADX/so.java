import com.aide.uidesigner.ProxyTextView;

public class so extends rr {
    public so(abj abj) {
        super(abj);
    }

    public void j6(sa saVar, int i, int i2) {
        abm j6;
        switch (i2) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case 79:
            case 87:
            case 88:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 169:
            case 171:
            case 172:
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
            case 179:
            case 181:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                EQ();
                break;
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case ProxyTextView.INPUTTYPE_date /*20*/:
                j6((abm) Zo());
                break;
            case 21:
            case 54:
                j6(FH(0));
                break;
            case 46:
            case 96:
            case 100:
            case 104:
            case 108:
            case 112:
            case 116:
            case 120:
            case 122:
            case 124:
            case 126:
            case 128:
            case 130:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 190:
                j6(Hw());
                break;
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                EQ();
                for (int v5 = v5(); v5 != 0; v5 >>= 4) {
                    DW(FH((v5 & 15) - 1));
                }
                break;
            case 168:
                j6(new si(VH()));
                break;
            case 178:
            case 180:
            case 182:
            case 184:
            case 185:
                j6 = ((abm) Zo()).j6();
                if (j6 != abl.u7) {
                    j6(j6);
                    break;
                } else {
                    EQ();
                    break;
                }
            case 183:
                abl j62 = FH(0).j6();
                if (j62.aM()) {
                    saVar.j6(j62);
                }
                j6 = ((abm) Zo()).j6();
                if (j6 != abl.u7) {
                    j6(j6);
                    break;
                } else {
                    EQ();
                    break;
                }
            case 187:
                j6(((abf) Zo()).u7().j6(i));
                break;
            case 188:
            case 192:
            case 197:
                j6(((abf) Zo()).u7());
                break;
            case 189:
                j6(((abf) Zo()).u7().Mr());
                break;
            case ProxyTextView.INPUTTYPE_textPhonetic /*193*/:
                j6(abl.Zo);
                break;
            default:
                throw new RuntimeException("shouldn't happen: " + add.v5(i2));
        }
        j6(saVar);
    }
}
