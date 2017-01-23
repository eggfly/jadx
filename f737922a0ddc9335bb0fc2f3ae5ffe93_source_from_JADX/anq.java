import com.aide.uidesigner.ProxyTextView;
import java.text.MessageFormat;
import org.eclipse.jgit.JGitText;

public class anq {
    public static final byte[] DW;
    public static final byte[] FH;
    public static final byte[] Hw;
    public static final byte[] VH;
    public static final byte[] Zo;
    public static final byte[] gn;
    public static final byte[] j6;
    public static final byte[] u7;
    public static final byte[] v5;
    private final axa EQ;
    private final ano tp;

    public anq() {
        this.tp = new ano();
        this.EQ = new axa();
    }

    static {
        j6 = anj.j6("tree ");
        DW = anj.j6("parent ");
        FH = anj.j6("author ");
        Hw = anj.j6("committer ");
        v5 = anj.j6("encoding ");
        Zo = anj.j6("object ");
        VH = anj.j6("type ");
        gn = anj.j6("tag ");
        u7 = anj.j6("tagger ");
    }

    public void j6(int i, byte[] bArr) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j6(bArr);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                FH(bArr);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                Hw(bArr);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                DW(bArr);
            default:
                throw new ala(MessageFormat.format(JGitText.j6().corruptObjectInvalidType2, new Object[]{Integer.valueOf(i)}));
        }
    }

    private int j6(byte[] bArr, int i) {
        try {
            this.tp.v5(bArr, i);
            return i + 40;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    private int DW(byte[] bArr, int i) {
        int DW = axe.DW(bArr, i, '<');
        if (DW == i || bArr[DW - 1] != (byte) 60) {
            return -1;
        }
        int DW2 = axe.DW(bArr, DW, '>');
        if (DW2 == DW || bArr[DW2 - 1] != (byte) 62 || DW2 == bArr.length || bArr[DW2] != (byte) 32) {
            return -1;
        }
        axe.j6(bArr, DW2 + 1, this.EQ);
        DW = this.EQ.j6;
        if (DW2 + 1 == DW || DW == bArr.length || bArr[DW] != (byte) 32) {
            return -1;
        }
        axe.j6(bArr, DW + 1, this.EQ);
        if (DW + 1 != this.EQ.j6) {
            return this.EQ.j6;
        }
        return -1;
    }

    public void j6(byte[] bArr) {
        int j6 = axe.j6(bArr, 0, j6);
        if (j6 < 0) {
            throw new ala("no tree header");
        }
        int j62 = j6(bArr, j6);
        if (j62 >= 0) {
            j6 = j62 + 1;
            if (bArr[j62] == (byte) 10) {
                while (axe.j6(bArr, j6, DW) >= 0) {
                    j62 = j6(bArr, j6 + DW.length);
                    if (j62 >= 0) {
                        j6 = j62 + 1;
                        if (bArr[j62] != (byte) 10) {
                        }
                    }
                    throw new ala("invalid parent");
                }
                j6 = axe.j6(bArr, j6, FH);
                if (j6 < 0) {
                    throw new ala("no author");
                }
                j6 = DW(bArr, j6);
                if (j6 >= 0) {
                    j62 = j6 + 1;
                    if (bArr[j6] == (byte) 10) {
                        j6 = axe.j6(bArr, j62, Hw);
                        if (j6 < 0) {
                            throw new ala("no committer");
                        }
                        j6 = DW(bArr, j6);
                        if (j6 >= 0) {
                            j62 = j6 + 1;
                            if (bArr[j6] == (byte) 10) {
                                return;
                            }
                        }
                        throw new ala("invalid committer");
                    }
                }
                throw new ala("invalid author");
            }
        }
        throw new ala("invalid tree");
    }

    public void DW(byte[] bArr) {
        int j6 = axe.j6(bArr, 0, Zo);
        if (j6 < 0) {
            throw new ala("no object header");
        }
        j6 = j6(bArr, j6);
        if (j6 >= 0) {
            int i = j6 + 1;
            if (bArr[j6] == (byte) 10) {
                j6 = axe.j6(bArr, i, VH);
                if (j6 < 0) {
                    throw new ala("no type header");
                }
                j6 = axe.j6(bArr, axe.Hw(bArr, j6), gn);
                if (j6 < 0) {
                    throw new ala("no tag header");
                }
                j6 = axe.j6(bArr, axe.Hw(bArr, j6), u7);
                if (j6 > 0) {
                    j6 = DW(bArr, j6);
                    if (j6 >= 0) {
                        i = j6 + 1;
                        if (bArr[j6] == (byte) 10) {
                            return;
                        }
                    }
                    throw new ala("invalid tagger");
                }
                return;
            }
        }
        throw new ala("invalid object");
    }

    private static int j6(int i) {
        return anl.j6.DW(i) ? 47 : 0;
    }

    private static int j6(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        while (i < i2 && i4 < i5) {
            int i7 = i + 1;
            int i8 = i4 + 1;
            int i9 = (bArr[i] & 255) - (bArr[i4] & 255);
            if (i9 != 0) {
                return i9;
            }
            i4 = i8;
            i = i7;
        }
        if (i < i2) {
            return (bArr[i] & 255) - j6(i6);
        }
        if (i4 < i5) {
            return j6(i3) - (bArr[i4] & 255);
        }
        return 0;
    }

    private static boolean j6(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int i3 = (i2 + 1) + 20;
        while (true) {
            int i4 = 0;
            while (i3 < length) {
                int i5 = i3 + 1;
                byte b = bArr[i3];
                if (32 == b) {
                    i3 = i5;
                    while (i3 != length) {
                        int i6 = i3 + 1;
                        if (bArr[i3] != null) {
                            i3 = i6;
                        } else if (i5 + 1 == i6) {
                            return false;
                        } else {
                            i3 = j6(bArr, i, i2, anl.j6.FH(), i5, i6 - 1, i4);
                            if (i3 < 0) {
                                return false;
                            }
                            if (i3 == 0) {
                                return true;
                            }
                            i3 = i6 + 20;
                        }
                    }
                    return false;
                }
                i4 = (i4 << 3) + (b - 48);
                i3 = i5;
            }
            return false;
        }
    }

    public void FH(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            int i5 = 0;
            int i6 = i4;
            while (i6 != length) {
                i4 = i6 + 1;
                byte b = bArr[i6];
                if (32 == b) {
                    if (anl.j6(i5).DW() == -1) {
                        throw new ala("invalid mode " + i5);
                    }
                    i6 = i4;
                    while (i6 != length) {
                        int i7 = i6 + 1;
                        b = bArr[i6];
                        if (b == null) {
                            if (i4 + 1 == i7) {
                                throw new ala("zero length name");
                            }
                            if (bArr[i4] == (byte) 46) {
                                i6 = (i7 - 1) - i4;
                                if (i6 == 1) {
                                    throw new ala("invalid name '.'");
                                } else if (i6 == 2 && bArr[i4 + 1] == (byte) 46) {
                                    throw new ala("invalid name '..'");
                                }
                            }
                            if (j6(bArr, i4, i7 - 1)) {
                                throw new ala("duplicate entry names");
                            }
                            if (i3 != 0) {
                                if (j6(bArr, i3, i2, i, i4, i7 - 1, i5) > 0) {
                                    throw new ala("incorrectly sorted");
                                }
                            }
                            i2 = i7 - 1;
                            i6 = i7 + 20;
                            if (i6 > length) {
                                throw new ala("truncated in object id");
                            }
                            i = i5;
                            i3 = i4;
                            i4 = i6;
                        } else if (b == 47) {
                            throw new ala("name contains '/'");
                        } else {
                            i6 = i7;
                        }
                    }
                    throw new ala("truncated in name");
                } else if (b < (byte) 48 || b > 55) {
                    throw new ala("invalid mode character");
                } else if (i5 == 0 && b == (byte) 48) {
                    throw new ala("mode starts with '0'");
                } else {
                    i5 = (i5 << 3) + (b - 48);
                    i6 = i4;
                }
            }
            throw new ala("truncated in mode");
        }
    }

    public void Hw(byte[] bArr) {
    }
}
