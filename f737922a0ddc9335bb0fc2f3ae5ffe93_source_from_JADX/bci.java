import java.io.IOException;
import java.util.Enumeration;

public class bci {
    static void j6(String str, boolean z, ayv ayv, StringBuffer stringBuffer) {
        String property = System.getProperty("line.separator");
        Enumeration Hw;
        String stringBuilder;
        Object nextElement;
        if (ayv instanceof ayw) {
            Hw = ((ayw) ayv).Hw();
            stringBuilder = new StringBuilder(String.valueOf(str)).append("    ").toString();
            stringBuffer.append(str);
            if (ayv instanceof azl) {
                stringBuffer.append("BER Sequence");
            } else if (ayv instanceof bal) {
                stringBuffer.append("DER Sequence");
            } else {
                stringBuffer.append("Sequence");
            }
            stringBuffer.append(property);
            while (Hw.hasMoreElements()) {
                nextElement = Hw.nextElement();
                if (nextElement == null || nextElement.equals(new bae())) {
                    stringBuffer.append(stringBuilder);
                    stringBuffer.append("NULL");
                    stringBuffer.append(property);
                } else if (nextElement instanceof ayv) {
                    j6(stringBuilder, z, (ayv) nextElement, stringBuffer);
                } else {
                    j6(stringBuilder, z, ((ayh) nextElement).w_(), stringBuffer);
                }
            }
        } else if (ayv instanceof baq) {
            r0 = new StringBuilder(String.valueOf(str)).append("    ").toString();
            stringBuffer.append(str);
            if (ayv instanceof azp) {
                stringBuffer.append("BER Tagged [");
            } else {
                stringBuffer.append("Tagged [");
            }
            baq baq = (baq) ayv;
            stringBuffer.append(Integer.toString(baq.FH()));
            stringBuffer.append(']');
            if (!baq.Hw()) {
                stringBuffer.append(" IMPLICIT ");
            }
            stringBuffer.append(property);
            if (baq.tp()) {
                stringBuffer.append(r0);
                stringBuffer.append("EMPTY");
                stringBuffer.append(property);
                return;
            }
            j6(r0, z, baq.EQ(), stringBuffer);
        } else if (ayv instanceof azn) {
            Hw = ((ayy) ayv).FH();
            stringBuilder = new StringBuilder(String.valueOf(str)).append("    ").toString();
            stringBuffer.append(str);
            stringBuffer.append("BER Set");
            stringBuffer.append(property);
            while (Hw.hasMoreElements()) {
                nextElement = Hw.nextElement();
                if (nextElement == null) {
                    stringBuffer.append(stringBuilder);
                    stringBuffer.append("NULL");
                    stringBuffer.append(property);
                } else if (nextElement instanceof ayv) {
                    j6(stringBuilder, z, (ayv) nextElement, stringBuffer);
                } else {
                    j6(stringBuilder, z, ((ayh) nextElement).w_(), stringBuffer);
                }
            }
        } else if (ayv instanceof ban) {
            Hw = ((ayy) ayv).FH();
            stringBuilder = new StringBuilder(String.valueOf(str)).append("    ").toString();
            stringBuffer.append(str);
            stringBuffer.append("DER Set");
            stringBuffer.append(property);
            while (Hw.hasMoreElements()) {
                nextElement = Hw.nextElement();
                if (nextElement == null) {
                    stringBuffer.append(stringBuilder);
                    stringBuffer.append("NULL");
                    stringBuffer.append(property);
                } else if (nextElement instanceof ayv) {
                    j6(stringBuilder, z, (ayv) nextElement, stringBuffer);
                } else {
                    j6(stringBuilder, z, ((ayh) nextElement).w_(), stringBuffer);
                }
            }
        } else if (ayv instanceof ayq) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("ObjectIdentifier(").append(((ayq) ayv).FH()).append(")").append(property).toString());
        } else if (ayv instanceof azv) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("Boolean(").append(((azv) ayv).FH()).append(")").append(property).toString());
        } else if (ayv instanceof ayn) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("Integer(").append(((ayn) ayv).FH()).append(")").append(property).toString());
        } else if (ayv instanceof azh) {
            r7 = (ayr) ayv;
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("BER Constructed Octet String").append("[").append(r7.Hw().length).append("] ").toString());
            if (z) {
                stringBuffer.append(j6(str, r7.Hw()));
            } else {
                stringBuffer.append(property);
            }
        } else if (ayv instanceof bah) {
            r7 = (ayr) ayv;
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("DER Octet String").append("[").append(r7.Hw().length).append("] ").toString());
            if (z) {
                stringBuffer.append(j6(str, r7.Hw()));
            } else {
                stringBuffer.append(property);
            }
        } else if (ayv instanceof azu) {
            azu azu = (azu) ayv;
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("DER Bit String").append("[").append(azu.FH().length).append(", ").append(azu.Hw()).append("] ").toString());
            if (z) {
                stringBuffer.append(j6(str, azu.FH()));
            } else {
                stringBuffer.append(property);
            }
        } else if (ayv instanceof bac) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("IA5String(").append(((bac) ayv).j6()).append(") ").append(property).toString());
        } else if (ayv instanceof bas) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("UTF8String(").append(((bas) ayv).j6()).append(") ").append(property).toString());
        } else if (ayv instanceof bak) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("PrintableString(").append(((bak) ayv).j6()).append(") ").append(property).toString());
        } else if (ayv instanceof bau) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("VisibleString(").append(((bau) ayv).j6()).append(") ").append(property).toString());
        } else if (ayv instanceof azt) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("BMPString(").append(((azt) ayv).j6()).append(") ").append(property).toString());
        } else if (ayv instanceof bap) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("T61String(").append(((bap) ayv).j6()).append(") ").append(property).toString());
        } else if (ayv instanceof bar) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("UTCTime(").append(((bar) ayv).v5()).append(") ").append(property).toString());
        } else if (ayv instanceof bab) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("GeneralizedTime(").append(((bab) ayv).FH()).append(") ").append(property).toString());
        } else if (ayv instanceof azf) {
            stringBuffer.append(j6("BER", str, z, ayv, property));
        } else if (ayv instanceof azs) {
            stringBuffer.append(j6("DER", str, z, ayv, property));
        } else if (ayv instanceof azw) {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("DER Enumerated(").append(((azw) ayv).FH()).append(")").append(property).toString());
        } else if (ayv instanceof azx) {
            azx azx = (azx) ayv;
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append("External ").append(property).toString());
            r0 = new StringBuilder(String.valueOf(str)).append("    ").toString();
            if (azx.Hw() != null) {
                stringBuffer.append(new StringBuilder(String.valueOf(r0)).append("Direct Reference: ").append(azx.Hw().FH()).append(property).toString());
            }
            if (azx.EQ() != null) {
                stringBuffer.append(new StringBuilder(String.valueOf(r0)).append("Indirect Reference: ").append(azx.EQ().toString()).append(property).toString());
            }
            if (azx.FH() != null) {
                j6(r0, z, azx.FH(), stringBuffer);
            }
            stringBuffer.append(new StringBuilder(String.valueOf(r0)).append("Encoding: ").append(azx.v5()).append(property).toString());
            j6(r0, z, azx.tp(), stringBuffer);
        } else {
            stringBuffer.append(new StringBuilder(String.valueOf(str)).append(ayv.toString()).append(property).toString());
        }
    }

    private static String j6(String str, String str2, boolean z, ayv ayv, String str3) {
        azs azs = (azs) ayv;
        StringBuffer stringBuffer = new StringBuffer();
        if (!azs.gn()) {
            return new StringBuilder(String.valueOf(str2)).append(str).append(" ApplicationSpecific[").append(azs.Hw()).append("] (").append(new String(bhn.j6(azs.FH()))).append(")").append(str3).toString();
        }
        try {
            ayw j6 = ayw.j6(azs.j6(16));
            stringBuffer.append(new StringBuilder(String.valueOf(str2)).append(str).append(" ApplicationSpecific[").append(azs.Hw()).append("]").append(str3).toString());
            Enumeration Hw = j6.Hw();
            while (Hw.hasMoreElements()) {
                j6(new StringBuilder(String.valueOf(str2)).append("    ").toString(), z, (ayv) Hw.nextElement(), stringBuffer);
            }
        } catch (IOException e) {
            stringBuffer.append(e);
        }
        return stringBuffer.toString();
    }

    public static String j6(Object obj) {
        return j6(obj, false);
    }

    public static String j6(Object obj, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof ayv) {
            j6("", z, (ayv) obj, stringBuffer);
        } else if (!(obj instanceof ayh)) {
            return "unknown object type " + obj.toString();
        } else {
            j6("", z, ((ayh) obj).w_(), stringBuffer);
        }
        return stringBuffer.toString();
    }

    private static String j6(String str, byte[] bArr) {
        String property = System.getProperty("line.separator");
        StringBuffer stringBuffer = new StringBuffer();
        String stringBuilder = new StringBuilder(String.valueOf(str)).append("    ").toString();
        stringBuffer.append(property);
        for (int i = 0; i < bArr.length; i += 32) {
            if (bArr.length - i > 32) {
                stringBuffer.append(stringBuilder);
                stringBuffer.append(new String(bhn.j6(bArr, i, 32)));
                stringBuffer.append("    ");
                stringBuffer.append(j6(bArr, i, 32));
                stringBuffer.append(property);
            } else {
                stringBuffer.append(stringBuilder);
                stringBuffer.append(new String(bhn.j6(bArr, i, bArr.length - i)));
                for (int length = bArr.length - i; length != 32; length++) {
                    stringBuffer.append("  ");
                }
                stringBuffer.append("    ");
                stringBuffer.append(j6(bArr, i, bArr.length - i));
                stringBuffer.append(property);
            }
        }
        return stringBuffer.toString();
    }

    private static String j6(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i;
        while (i3 != i + i2) {
            if (bArr[i3] >= 32 && bArr[i3] <= 126) {
                stringBuffer.append((char) bArr[i3]);
            }
            i3++;
        }
        return stringBuffer.toString();
    }
}
