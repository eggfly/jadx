import com.aide.uidesigner.ProxyTextView;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public final class anj {
    public static final Charset DW;
    public static final ans FH;
    private static final byte[] Hw;
    private static final byte[] VH;
    private static final byte[] Zo;
    public static final byte[] j6;
    private static final byte[] v5;

    static {
        Hw = j6("commit");
        v5 = j6("blob");
        Zo = j6("tree");
        VH = j6("tag");
        j6 = new byte[]{(byte) 80, (byte) 65, (byte) 67, (byte) 75};
        if (20 != j6().getDigestLength()) {
            throw new LinkageError(JGitText.j6().incorrectOBJECT_ID_LENGTH);
        }
        DW = Charset.forName("UTF-8");
        FH = ans.DW("e69de29bb2d1d6434b8b29ae775ad8c2e48c5391");
    }

    public static MessageDigest j6() {
        try {
            return MessageDigest.getInstance("SHA-1");
        } catch (Throwable e) {
            throw new RuntimeException(MessageFormat.format(JGitText.j6().requiredHashFunctionNotAvailable, new Object[]{"SHA-1"}), e);
        }
    }

    public static String j6(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return "commit";
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return "tree";
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return "blob";
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return "tag";
            default:
                throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().badObjectType, new Object[]{Integer.valueOf(i)}));
        }
    }

    public static byte[] DW(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return Hw;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return Zo;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return v5;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return VH;
            default:
                throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().badObjectType, new Object[]{Integer.valueOf(i)}));
        }
    }

    public static int j6(anb anb, byte[] bArr, byte b, axa axa) {
        try {
            int i = axa.j6;
            switch (bArr[i]) {
                case (byte) 98:
                    if (bArr[i + 1] == 108 && bArr[i + 2] == (byte) 111 && bArr[i + 3] == 98 && bArr[i + 4] == b) {
                        axa.j6 = i + 5;
                        return 3;
                    }
                    throw new ala(anb, JGitText.j6().corruptObjectInvalidType);
                case (byte) 99:
                    if (bArr[i + 1] == (byte) 111 && bArr[i + 2] == (byte) 109 && bArr[i + 3] == (byte) 109 && bArr[i + 4] == 105 && bArr[i + 5] == 116 && bArr[i + 6] == b) {
                        axa.j6 = i + 7;
                        return 1;
                    }
                    throw new ala(anb, JGitText.j6().corruptObjectInvalidType);
                case (byte) 116:
                    switch (bArr[i + 1]) {
                        case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                            if (bArr[i + 2] == 103 && bArr[i + 3] == b) {
                                axa.j6 = i + 4;
                                return 4;
                            }
                            throw new ala(anb, JGitText.j6().corruptObjectInvalidType);
                        case (byte) 114:
                            if (bArr[i + 2] == (byte) 101 && bArr[i + 3] == (byte) 101 && bArr[i + 4] == b) {
                                axa.j6 = i + 5;
                                return 2;
                            }
                            throw new ala(anb, JGitText.j6().corruptObjectInvalidType);
                        default:
                            throw new ala(anb, JGitText.j6().corruptObjectInvalidType);
                    }
                default:
                    throw new ala(anb, JGitText.j6().corruptObjectInvalidType);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ala(anb, JGitText.j6().corruptObjectInvalidType);
        }
        throw new ala(anb, JGitText.j6().corruptObjectInvalidType);
    }

    public static byte[] j6(long j) {
        return j6(Long.toString(j));
    }

    public static byte[] j6(String str) {
        byte[] bArr = new byte[str.length()];
        for (int length = bArr.length - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt > '\u007f') {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().notASCIIString, new Object[]{str}));
            }
            bArr[length] = (byte) charAt;
        }
        return bArr;
    }

    public static byte[] DW(String str) {
        byte[] array;
        ByteBuffer encode = DW.encode(str);
        int limit = encode.limit();
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            array = encode.array();
            if (array.length == limit) {
                return array;
            }
        }
        array = new byte[limit];
        encode.get(array);
        return array;
    }
}
