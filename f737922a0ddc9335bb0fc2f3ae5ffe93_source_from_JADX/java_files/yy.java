import com.aide.uidesigner.ProxyTextView;

public final class yy {
    private static final byte[] j6;

    static {
        j6 = new byte[255];
        for (int i = 1; i < 255; i++) {
            try {
                yo$a j6 = yo.j6(i);
                ym Hw = j6.Hw();
                yr FH = j6.FH();
                if (Hw == ym.NONE) {
                    j6[i] = j6(FH);
                } else {
                    byte j62 = j6(FH);
                    switch (yy$1.j6[Hw.ordinal()]) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            j62 = (byte) (j62 | 16);
                            break;
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            j62 = (byte) (j62 | 32);
                            break;
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            j62 = (byte) (j62 | 48);
                            break;
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                            j62 = (byte) (j62 | 64);
                            break;
                        default:
                            throw new RuntimeException("Unknown index type: " + Hw);
                    }
                    j6[i] = j62;
                }
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private static byte j6(yr yrVar) {
        switch (yy$1.DW[yrVar.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                throw new RuntimeException("Unexpected format");
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
                return (byte) 1;
            case 7:
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
                return (byte) 2;
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case 19:
                throw new RuntimeException("Unexpected format");
            case ProxyTextView.INPUTTYPE_date /*20*/:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
                return (byte) 3;
            case 29:
            case 30:
            case 31:
            case 32:
                throw new RuntimeException("Unexpected format");
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                throw new RuntimeException("Unexpected format");
            case 34:
                throw new RuntimeException("Jumbo opcodes not supported");
            case 35:
                return (byte) 5;
            case ProxyTextView.INPUTTYPE_time /*36*/:
            case 37:
                throw new RuntimeException("Jumbo opcodes not supported");
            default:
                throw new RuntimeException("Unknown opcode format");
        }
    }

    public static void j6(short[] sArr, yw ywVar) {
        byte[] bArr = j6;
        int i = 0;
        while (i < sArr.length) {
            int i2 = sArr[i] & 255;
            switch (i2) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    switch (sArr[i] & 65535) {
                        case 256:
                            i += ((sArr[i + 1] & 65535) * 2) + 3;
                            break;
                        case 512:
                            i += ((sArr[i + 1] & 65535) * 4) + 1;
                            break;
                        case 768:
                            i += ((((sArr[i + 1] & 65535) * (sArr[i + 2] & 65535)) + 1) / 2) + 3;
                            break;
                        default:
                            break;
                    }
                case 27:
                    throw new RuntimeException("Extended opcodes not supported");
                case 255:
                    throw new RuntimeException("Extended opcodes not supported");
                default:
                    byte b = bArr[i2];
                    if (b != null) {
                        if (b >= 15) {
                            switch (b & 240) {
                                case 16:
                                    sArr[i + 1] = (short) ywVar.DW(sArr[i + 1] & 65535);
                                    break;
                                case 32:
                                    sArr[i + 1] = (short) ywVar.j6(sArr[i + 1] & 65535);
                                    break;
                                case 48:
                                    sArr[i + 1] = (short) ywVar.Hw(sArr[i + 1] & 65535);
                                    break;
                                case 64:
                                    sArr[i + 1] = (short) ywVar.v5(sArr[i + 1] & 65535);
                                    break;
                                default:
                                    throw new RuntimeException("Unexpected mask");
                            }
                            i += (b & 15) - 1;
                            break;
                        }
                        i += b - 1;
                        break;
                    }
                    throw new RuntimeException("Opcode size not found for opcode " + Integer.toHexString(i2));
            }
            i++;
        }
    }
}
