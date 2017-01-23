import com.aide.uidesigner.ProxyTextView;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.JGitText;

public class aro implements Iterable<arp$b> {
    public static final Comparator<aro> j6;
    final int DW;
    private int EQ;
    long FH;
    private final File Hw;
    private byte[] J0;
    private arp J8;
    private volatile awz QX;
    private RandomAccessFile VH;
    private arx Ws;
    private volatile String Zo;
    private final Object gn;
    private int tp;
    private int u7;
    private final File v5;
    private volatile boolean we;

    static {
        j6 = new aro$1();
    }

    public aro(File file, File file2) {
        this.gn = new Object();
        this.Hw = file;
        this.v5 = file2;
        this.EQ = (int) (file2.lastModified() >> 10);
        this.DW = System.identityHashCode(this) * 31;
        this.FH = Long.MAX_VALUE;
    }

    private synchronized arp u7() {
        if (this.J8 == null) {
            if (this.we) {
                throw new alo(this.v5);
            }
            try {
                arp j6 = arp.j6(this.Hw);
                if (this.J0 == null) {
                    this.J0 = j6.j6;
                } else if (!Arrays.equals(this.J0, j6.j6)) {
                    throw new alp(JGitText.j6().packChecksumMismatch);
                }
                this.J8 = j6;
            } catch (IOException e) {
                this.we = true;
                throw e;
            }
        }
        return this.J8;
    }

    public File j6() {
        return this.v5;
    }

    public String DW() {
        String str = this.Zo;
        if (str == null) {
            str = j6().getName();
            if (str.startsWith("pack-")) {
                str = str.substring("pack-".length());
            }
            if (str.endsWith(".pack")) {
                str = str.substring(0, str.length() - ".pack".length());
            }
            this.Zo = str;
        }
        return str;
    }

    public boolean j6(anb anb) {
        long DW = u7().DW(anb);
        return 0 < DW && !FH(DW);
    }

    anx j6(asg asg, anb anb) {
        long DW = u7().DW(anb);
        return (0 >= DW || FH(DW)) ? null : j6(asg, DW);
    }

    void j6(Set<ans> set, amz amz, int i) {
        u7().j6(set, amz, i);
    }

    public void FH() {
        ase.j6(this);
        synchronized (this) {
            this.J8 = null;
            this.Ws = null;
        }
    }

    public Iterator<arp$b> iterator() {
        try {
            return u7().iterator();
        } catch (IOException e) {
            return Collections.emptyList().iterator();
        }
    }

    long Hw() {
        return u7().j6();
    }

    ans j6(long j) {
        return Ws().j6(j);
    }

    private final byte[] j6(long j, int i, asg asg) {
        try {
            byte[] bArr = new byte[i];
            if (asg.j6(this, j, bArr, 0) == i) {
                return bArr;
            }
            throw new EOFException(MessageFormat.format(JGitText.j6().shortCompressedStreamAt, new Object[]{Long.valueOf(j)}));
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    void j6(asx asx, boolean z, asg asg) {
        asg.j6(this, 0);
        asg.j6(this, this.FH, z, asx);
    }

    final void j6(asx asx, arj arj, boolean z, asg asg) {
        j6((asv) arj);
        try {
            DW(asx, arj, z, asg);
        } finally {
            tp();
        }
    }

    private void DW(asx asx, arj arj, boolean z, asg asg) {
        CRC32 crc32 = z ? new CRC32() : null;
        CRC32 crc322 = z ? new CRC32() : null;
        byte[] j6 = asx.j6();
        j6(arj.gn, j6, 0, 20, asg);
        int i = j6[0] & 255;
        int i2 = (i >> 4) & 7;
        int i3 = 1;
        long j = (long) (i & 15);
        int i4 = 4;
        int i5 = i;
        while ((i5 & 128) != 0) {
            int i6 = j6[i3] & 255;
            i4 += 7;
            i3++;
            j = ((long) ((i6 & 127) << i4)) + j;
            i5 = i6;
        }
        if (i2 == 6) {
            i5 = i3;
            while (true) {
                i4 = i5 + 1;
                if (((j6[i5] & 255) & 128) == 0) {
                    break;
                }
                i5 = i4;
            }
            if (z) {
                crc32.update(j6, 0, i4);
                crc322.update(j6, 0, i4);
                i3 = i4;
            } else {
                i3 = i4;
            }
        } else if (i2 == 7) {
            if (z) {
                crc32.update(j6, 0, i3);
                crc322.update(j6, 0, i3);
            }
            j6(arj.gn + ((long) i3), j6, 0, 20, asg);
            if (z) {
                crc32.update(j6, 0, 20);
                crc322.update(j6, 0, 20);
            }
            i3 += 20;
        } else if (z) {
            crc32.update(j6, 0, i3);
            crc322.update(j6, 0, i3);
        }
        long j2 = arj.gn + ((long) i3);
        long j3 = arj.u7;
        try {
            long j4;
            int min;
            aqv j62 = asg.j6(this, j2, j3);
            long FH;
            long j5;
            if (z && u7().FH()) {
                FH = u7().FH(arj);
                if (j62 != null) {
                    j62.j6(crc32, j2, (int) j3);
                } else {
                    j5 = j3;
                    j4 = j2;
                    while (j5 > 0) {
                        min = (int) Math.min(j5, (long) j6.length);
                        j6(j4, j6, 0, min, asg);
                        crc32.update(j6, 0, min);
                        j5 -= (long) min;
                        j4 = ((long) min) + j4;
                    }
                }
                if (crc32.getValue() != FH) {
                    Hw(arj.gn);
                    throw new ala(MessageFormat.format(JGitText.j6().objectAtHasBadZlibStream, new Object[]{Long.valueOf(arj.gn), j6()}));
                }
            } else if (z) {
                Inflater Zo = asg.Zo();
                byte[] bArr = new byte[1024];
                if (j62 != null) {
                    j62.j6(Zo, bArr, j2, (int) j3);
                } else {
                    j5 = j3;
                    j4 = j2;
                    while (j5 > 0) {
                        min = (int) Math.min(j5, (long) j6.length);
                        j6(j4, j6, 0, min, asg);
                        crc32.update(j6, 0, min);
                        Zo.setInput(j6, 0, min);
                        do {
                        } while (Zo.inflate(bArr, 0, bArr.length) > 0);
                        j5 -= (long) min;
                        j4 = ((long) min) + j4;
                    }
                }
                if (Zo.finished() && Zo.getBytesRead() == j3) {
                    FH = crc32.getValue();
                } else {
                    Hw(arj.gn);
                    throw new EOFException(MessageFormat.format(JGitText.j6().shortCompressedStreamAt, new Object[]{Long.valueOf(arj.gn)}));
                }
            } else {
                FH = -1;
            }
            if (j62 != null) {
                asx.j6((asv) arj, j);
                j62.j6(asx, j2, (int) j3, null);
            } else if (j3 <= ((long) j6.length)) {
                if (!z) {
                    j4 = j2;
                    j2 = j3;
                    while (j2 > 0) {
                        min = (int) Math.min(j2, (long) j6.length);
                        j6(j4, j6, 0, min, asg);
                        j4 += (long) min;
                        j2 -= (long) min;
                    }
                }
                asx.j6((asv) arj, j);
                asx.write(j6, 0, (int) j3);
            } else {
                asx.j6((asv) arj, j);
                j4 = j2;
                while (j3 > 0) {
                    min = (int) Math.min(j3, (long) j6.length);
                    j6(j4, j6, 0, min, asg);
                    if (z) {
                        crc322.update(j6, 0, min);
                    }
                    asx.write(j6, 0, min);
                    j4 += (long) min;
                    j3 -= (long) min;
                }
                if (z && crc322.getValue() != r18) {
                    throw new ala(MessageFormat.format(JGitText.j6().objectAtHasBadZlibStream, new Object[]{Long.valueOf(arj.gn), j6()}));
                }
            }
        } catch (Throwable e) {
            Hw(arj.gn);
            Throwable ala = new ala(MessageFormat.format(JGitText.j6().objectAtHasBadZlibStream, new Object[]{Long.valueOf(arj.gn), j6()}));
            ala.initCause(e);
            alw alw = new alw(arj);
            alw.initCause(ala);
            throw alw;
        } catch (Throwable e2) {
            alw alw2 = new alw(arj);
            alw2.initCause(e2);
            throw alw2;
        }
    }

    boolean v5() {
        return this.we;
    }

    void Zo() {
        this.we = true;
    }

    private void j6(long j, byte[] bArr, int i, int i2, asg asg) {
        if (asg.j6(this, j, bArr, i, i2) != i2) {
            throw new EOFException();
        }
    }

    private synchronized void j6(asv asv) {
        int i = this.tp + 1;
        this.tp = i;
        if (i == 1 && this.u7 == 0) {
            try {
                EQ();
            } catch (Throwable e) {
                alw alw = new alw(asv);
                alw.initCause(e);
                throw alw;
            }
        }
    }

    private synchronized void tp() {
        int i = this.tp - 1;
        this.tp = i;
        if (i == 0 && this.u7 == 0) {
            J0();
        }
    }

    synchronized boolean VH() {
        boolean z = true;
        synchronized (this) {
            int i = this.u7 + 1;
            this.u7 = i;
            if (i != 1) {
                z = false;
            } else if (this.tp == 0) {
                EQ();
            }
        }
        return z;
    }

    synchronized boolean gn() {
        boolean z;
        int i = this.u7 - 1;
        this.u7 = i;
        z = i == 0;
        if (z && this.tp == 0) {
            J0();
        }
        return z;
    }

    private void EQ() {
        try {
            if (this.we) {
                throw new alo(this.v5);
            }
            synchronized (this.gn) {
                this.VH = new RandomAccessFile(this.v5, "r");
                this.FH = this.VH.length();
                J8();
            }
        } catch (IOException e) {
            we();
            throw e;
        } catch (RuntimeException e2) {
            we();
            throw e2;
        } catch (Error e3) {
            we();
            throw e3;
        }
    }

    private void we() {
        this.u7 = 0;
        this.tp = 0;
        this.we = true;
        J0();
    }

    private void J0() {
        synchronized (this.gn) {
            if (this.VH != null) {
                try {
                    this.VH.close();
                } catch (IOException e) {
                }
                this.VH = null;
            }
        }
    }

    aqv j6(long j, int i) {
        aqv aqv;
        synchronized (this.gn) {
            if (this.FH < ((long) i) + j) {
                i = (int) (this.FH - j);
            }
            byte[] bArr = new byte[i];
            this.VH.seek(j);
            this.VH.readFully(bArr, 0, i);
            aqv = new aqv(this, j, bArr);
        }
        return aqv;
    }

    aqx DW(long j, int i) {
        aqx aqv;
        synchronized (this.gn) {
            if (this.FH < ((long) i) + j) {
                i = (int) (this.FH - j);
            }
            try {
                ByteBuffer map = this.VH.getChannel().map(MapMode.READ_ONLY, j, (long) i);
            } catch (IOException e) {
                System.gc();
                System.runFinalization();
                map = this.VH.getChannel().map(MapMode.READ_ONLY, j, (long) i);
            }
            if (map.hasArray()) {
                aqv = new aqv(this, j, map.array());
            } else {
                aqv = new aqw(this, j, map);
            }
        }
        return aqv;
    }

    private void J8() {
        arp u7 = u7();
        byte[] bArr = new byte[20];
        this.VH.seek(0);
        this.VH.readFully(bArr, 0, 12);
        if (axe.j6(bArr, 0, anj.j6) != 4) {
            throw new IOException(JGitText.j6().notAPACKFile);
        }
        long FH = axb.FH(bArr, 4);
        long FH2 = axb.FH(bArr, 8);
        if (FH != 2 && FH != 3) {
            throw new IOException(MessageFormat.format(JGitText.j6().unsupportedPackVersion, new Object[]{Long.valueOf(FH)}));
        } else if (FH2 != u7.j6()) {
            throw new alp(MessageFormat.format(JGitText.j6().packObjectCountMismatch, new Object[]{Long.valueOf(FH2), Long.valueOf(u7.j6()), j6()}));
        } else {
            this.VH.seek(this.FH - 20);
            this.VH.readFully(bArr, 0, 20);
            if (!Arrays.equals(bArr, this.J0)) {
                throw new alp(MessageFormat.format(JGitText.j6().packObjectCountMismatch, new Object[]{ans.j6(bArr).DW(), ans.j6(u7.j6).DW(), j6()}));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    anx j6(asg r27, long r28) {
        /*
        r26 = this;
        r0 = r27;
        r8 = r0.j6;	 Catch:{ DataFormatException -> 0x01db }
        r12 = 0;
        r4 = 0;
        r4 = (byte[]) r4;	 Catch:{ DataFormatException -> 0x01db }
        r23 = -1;
        r22 = 0;
        r13 = r12;
        r6 = r28;
    L_0x000f:
        r9 = 0;
        r10 = 20;
        r5 = r26;
        r11 = r27;
        r5.j6(r6, r8, r9, r10, r11);	 Catch:{ DataFormatException -> 0x004d }
        r5 = 0;
        r5 = r8[r5];	 Catch:{ DataFormatException -> 0x004d }
        r12 = r5 & 255;
        r5 = r12 >> 4;
        r9 = r5 & 7;
        r5 = r12 & 15;
        r10 = (long) r5;	 Catch:{ DataFormatException -> 0x004d }
        r5 = 4;
        r14 = 1;
        r24 = r5;
        r5 = r12;
        r12 = r24;
    L_0x002c:
        r5 = r5 & 128;
        if (r5 != 0) goto L_0x0072;
    L_0x0030:
        switch(r9) {
            case 1: goto L_0x0087;
            case 2: goto L_0x0087;
            case 3: goto L_0x0087;
            case 4: goto L_0x0087;
            case 5: goto L_0x0033;
            case 6: goto L_0x00c5;
            case 7: goto L_0x011d;
            default: goto L_0x0033;
        };	 Catch:{ DataFormatException -> 0x004d }
    L_0x0033:
        r4 = new java.io.IOException;	 Catch:{ DataFormatException -> 0x004d }
        r5 = org.eclipse.jgit.JGitText.j6();	 Catch:{ DataFormatException -> 0x004d }
        r5 = r5.unknownObjectType;	 Catch:{ DataFormatException -> 0x004d }
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ DataFormatException -> 0x004d }
        r10 = 0;
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ DataFormatException -> 0x004d }
        r8[r10] = r9;	 Catch:{ DataFormatException -> 0x004d }
        r5 = java.text.MessageFormat.format(r5, r8);	 Catch:{ DataFormatException -> 0x004d }
        r4.<init>(r5);	 Catch:{ DataFormatException -> 0x004d }
        throw r4;	 Catch:{ DataFormatException -> 0x004d }
    L_0x004d:
        r4 = move-exception;
    L_0x004e:
        r5 = new ala;
        r8 = org.eclipse.jgit.JGitText.j6();
        r8 = r8.objectAtHasBadZlibStream;
        r9 = 2;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r6 = java.lang.Long.valueOf(r6);
        r9[r10] = r6;
        r6 = 1;
        r7 = r26.j6();
        r9[r6] = r7;
        r6 = java.text.MessageFormat.format(r8, r9);
        r5.<init>(r6);
        r5.initCause(r4);
        throw r5;
    L_0x0072:
        r5 = r14 + 1;
        r14 = r8[r14];	 Catch:{ DataFormatException -> 0x004d }
        r0 = r14 & 255;
        r16 = r0;
        r14 = r16 & 127;
        r14 = r14 << r12;
        r14 = (long) r14;	 Catch:{ DataFormatException -> 0x004d }
        r14 = r14 + r10;
        r10 = r12 + 7;
        r12 = r10;
        r10 = r14;
        r14 = r5;
        r5 = r16;
        goto L_0x002c;
    L_0x0087:
        r5 = r27.VH();	 Catch:{ DataFormatException -> 0x004d }
        r0 = (long) r5;	 Catch:{ DataFormatException -> 0x004d }
        r16 = r0;
        r5 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r5 >= 0) goto L_0x009d;
    L_0x0092:
        r4 = (long) r14;	 Catch:{ DataFormatException -> 0x004d }
        r4 = r4 + r6;
        r8 = (int) r10;	 Catch:{ DataFormatException -> 0x004d }
        r0 = r26;
        r1 = r27;
        r4 = r0.j6(r4, r8, r1);	 Catch:{ DataFormatException -> 0x004d }
    L_0x009d:
        if (r13 == 0) goto L_0x00ae;
    L_0x009f:
        r10 = r22;
        r8 = r4;
        r4 = r13;
    L_0x00a3:
        if (r8 != 0) goto L_0x01e0;
    L_0x00a5:
        r0 = r26;
        r1 = r27;
        r8 = r4.j6(r0, r1);	 Catch:{ DataFormatException -> 0x004d }
    L_0x00ad:
        return r8;
    L_0x00ae:
        if (r4 == 0) goto L_0x00b6;
    L_0x00b0:
        r8 = new anx$a;	 Catch:{ DataFormatException -> 0x004d }
        r8.<init>(r9, r4);	 Catch:{ DataFormatException -> 0x004d }
        goto L_0x00ad;
    L_0x00b6:
        r8 = new arg;	 Catch:{ DataFormatException -> 0x004d }
        r0 = r27;
        r0 = r0.DW;	 Catch:{ DataFormatException -> 0x004d }
        r16 = r0;
        r12 = r6;
        r15 = r26;
        r8.<init>(r9, r10, r12, r14, r15, r16);	 Catch:{ DataFormatException -> 0x004d }
        goto L_0x00ad;
    L_0x00c5:
        r17 = r14 + 1;
        r5 = r8[r14];	 Catch:{ DataFormatException -> 0x004d }
        r5 = r5 & 255;
        r9 = r5 & 127;
        r14 = (long) r9;	 Catch:{ DataFormatException -> 0x004d }
    L_0x00ce:
        r5 = r5 & 128;
        if (r5 != 0) goto L_0x00eb;
    L_0x00d2:
        r18 = r6 - r14;
        r12 = new aro$a;	 Catch:{ DataFormatException -> 0x004d }
        r0 = (int) r10;	 Catch:{ DataFormatException -> 0x004d }
        r16 = r0;
        r14 = r6;
        r12.<init>(r13, r14, r16, r17, r18);	 Catch:{ DataFormatException -> 0x004d }
        r5 = r12.FH;	 Catch:{ DataFormatException -> 0x004d }
        r14 = (long) r5;	 Catch:{ DataFormatException -> 0x004d }
        r5 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r5 == 0) goto L_0x0102;
    L_0x00e4:
        r10 = r22;
        r9 = r23;
        r8 = r4;
        r4 = r12;
        goto L_0x00a3;
    L_0x00eb:
        r18 = 1;
        r14 = r14 + r18;
        r5 = r17 + 1;
        r9 = r8[r17];	 Catch:{ DataFormatException -> 0x004d }
        r9 = r9 & 255;
        r12 = 7;
        r14 = r14 << r12;
        r12 = r9 & 127;
        r0 = (long) r12;	 Catch:{ DataFormatException -> 0x004d }
        r16 = r0;
        r14 = r14 + r16;
        r17 = r5;
        r5 = r9;
        goto L_0x00ce;
    L_0x0102:
        r5 = r27.Hw();	 Catch:{ DataFormatException -> 0x004d }
        r0 = r26;
        r1 = r18;
        r5 = r5.j6(r0, r1);	 Catch:{ DataFormatException -> 0x004d }
        if (r5 == 0) goto L_0x0118;
    L_0x0110:
        r9 = r5.DW;	 Catch:{ DataFormatException -> 0x004d }
        r4 = r5.j6;	 Catch:{ DataFormatException -> 0x004d }
        r10 = 1;
        r8 = r4;
        r4 = r12;
        goto L_0x00a3;
    L_0x0118:
        r13 = r12;
        r6 = r18;
        goto L_0x000f;
    L_0x011d:
        r0 = (long) r14;	 Catch:{ DataFormatException -> 0x004d }
        r16 = r0;
        r16 = r16 + r6;
        r19 = 0;
        r20 = 20;
        r15 = r26;
        r18 = r8;
        r21 = r27;
        r15.j6(r16, r18, r19, r20, r21);	 Catch:{ DataFormatException -> 0x004d }
        r5 = ans.j6(r8);	 Catch:{ DataFormatException -> 0x004d }
        r0 = r26;
        r18 = r0.j6(r5);	 Catch:{ DataFormatException -> 0x004d }
        r12 = new aro$a;	 Catch:{ DataFormatException -> 0x004d }
        r0 = (int) r10;	 Catch:{ DataFormatException -> 0x004d }
        r16 = r0;
        r17 = r14 + 20;
        r14 = r6;
        r12.<init>(r13, r14, r16, r17, r18);	 Catch:{ DataFormatException -> 0x004d }
        r5 = r12.FH;	 Catch:{ DataFormatException -> 0x004d }
        r14 = (long) r5;	 Catch:{ DataFormatException -> 0x004d }
        r5 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r5 == 0) goto L_0x0153;
    L_0x014b:
        r10 = r22;
        r9 = r23;
        r8 = r4;
        r4 = r12;
        goto L_0x00a3;
    L_0x0153:
        r5 = r27.Hw();	 Catch:{ DataFormatException -> 0x004d }
        r0 = r26;
        r1 = r18;
        r5 = r5.j6(r0, r1);	 Catch:{ DataFormatException -> 0x004d }
        if (r5 == 0) goto L_0x016a;
    L_0x0161:
        r9 = r5.DW;	 Catch:{ DataFormatException -> 0x004d }
        r4 = r5.j6;	 Catch:{ DataFormatException -> 0x004d }
        r10 = 1;
        r8 = r4;
        r4 = r12;
        goto L_0x00a3;
    L_0x016a:
        r13 = r12;
        r6 = r18;
        goto L_0x000f;
    L_0x016f:
        r10 = r4;
        r11 = r8;
        r28 = r6;
        r8 = r5;
    L_0x0174:
        if (r10 == 0) goto L_0x0196;
    L_0x0176:
        r4 = 0;
    L_0x0177:
        r6 = r11.DW;	 Catch:{ DataFormatException -> 0x01db }
        r5 = r11.Hw;	 Catch:{ DataFormatException -> 0x004d }
        r12 = (long) r5;	 Catch:{ DataFormatException -> 0x004d }
        r12 = r12 + r6;
        r5 = r11.FH;	 Catch:{ DataFormatException -> 0x004d }
        r0 = r26;
        r1 = r27;
        r10 = r0.j6(r12, r5, r1);	 Catch:{ DataFormatException -> 0x004d }
        if (r10 != 0) goto L_0x01a7;
    L_0x0189:
        r4 = 0;
        r4 = (byte[]) r4;	 Catch:{ DataFormatException -> 0x004d }
        r0 = r26;
        r1 = r27;
        r8 = r11.j6(r0, r1);	 Catch:{ DataFormatException -> 0x004d }
        goto L_0x00ad;
    L_0x0196:
        r4 = r11.j6;	 Catch:{ DataFormatException -> 0x01db }
        if (r4 != 0) goto L_0x01a5;
    L_0x019a:
        r4 = r27.Hw();	 Catch:{ DataFormatException -> 0x01db }
        r6 = r11.v5;	 Catch:{ DataFormatException -> 0x01db }
        r5 = r26;
        r4.j6(r5, r6, r8, r9);	 Catch:{ DataFormatException -> 0x01db }
    L_0x01a5:
        r4 = r10;
        goto L_0x0177;
    L_0x01a7:
        r12 = asj.j6(r10);	 Catch:{ DataFormatException -> 0x004d }
        r14 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r5 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1));
        if (r5 > 0) goto L_0x01bc;
    L_0x01b2:
        r0 = r26;
        r1 = r27;
        r8 = r11.j6(r0, r1);	 Catch:{ DataFormatException -> 0x004d }
        goto L_0x00ad;
    L_0x01bc:
        r5 = (int) r12;
        r5 = new byte[r5];	 Catch:{ OutOfMemoryError -> 0x01cd }
        asj.j6(r8, r10, r5);	 Catch:{ DataFormatException -> 0x004d }
        r8 = r11.j6;	 Catch:{ DataFormatException -> 0x004d }
        if (r8 != 0) goto L_0x016f;
    L_0x01c6:
        r8 = new anx$a;	 Catch:{ DataFormatException -> 0x004d }
        r8.<init>(r9, r5);	 Catch:{ DataFormatException -> 0x004d }
        goto L_0x00ad;
    L_0x01cd:
        r4 = move-exception;
        r4 = 0;
        r4 = (byte[]) r4;	 Catch:{ DataFormatException -> 0x004d }
        r0 = r26;
        r1 = r27;
        r8 = r11.j6(r0, r1);	 Catch:{ DataFormatException -> 0x004d }
        goto L_0x00ad;
    L_0x01db:
        r4 = move-exception;
        r6 = r28;
        goto L_0x004e;
    L_0x01e0:
        r11 = r4;
        r28 = r6;
        goto L_0x0174;
        */
        throw new UnsupportedOperationException("Method not decompiled: aro.j6(asg, long):anx");
    }

    private long j6(ans ans) {
        long DW = u7().DW(ans);
        if (DW >= 0) {
            return DW;
        }
        throw new ali(ans, JGitText.j6().missingDeltaBase);
    }

    byte[] DW(asg asg, long j) {
        byte[] bArr = new byte[18];
        asg.j6(this, j, bArr, 0);
        return bArr;
    }

    int FH(asg asg, long j) {
        byte[] bArr = asg.j6;
        long j2 = j;
        while (true) {
            j6(j2, bArr, 0, 20, asg);
            int i = bArr[0] & 255;
            int i2 = (i >> 4) & 7;
            int i3;
            switch (i2) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    return i2;
                case 6:
                    i2 = 1;
                    while ((i & 128) != 0) {
                        i3 = i2 + 1;
                        i = bArr[i2] & 255;
                        i2 = i3;
                    }
                    int i4 = i2 + 1;
                    int i5 = bArr[i2] & 255;
                    long j3 = (long) (i5 & 127);
                    while ((i5 & 128) != 0) {
                        i5 = i4 + 1;
                        i4 = bArr[i4] & 255;
                        j3 = ((j3 + 1) << 7) + ((long) (i4 & 127));
                        i3 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                    j2 -= j3;
                    break;
                case 7:
                    i2 = 1;
                    while ((i & 128) != 0) {
                        i3 = i2 + 1;
                        i = bArr[i2] & 255;
                        i2 = i3;
                    }
                    j6(j2 + ((long) i2), bArr, 0, 20, asg);
                    j2 = j6(ans.j6(bArr));
                    break;
                default:
                    throw new IOException(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{Integer.valueOf(i2)}));
            }
        }
    }

    long DW(asg asg, anb anb) {
        long DW = u7().DW(anb);
        return 0 < DW ? Hw(asg, DW) : -1;
    }

    long Hw(asg asg, long j) {
        byte[] bArr = asg.j6;
        j6(j, bArr, 0, 20, asg);
        int i = bArr[0] & 255;
        int i2 = (i >> 4) & 7;
        long j2 = (long) (i & 15);
        int i3 = 1;
        int i4 = i;
        i = 4;
        while ((i4 & 128) != 0) {
            i4 = i3 + 1;
            i3 = bArr[i3] & 255;
            long j3 = ((long) ((i3 & 127) << i)) + j2;
            i += 7;
            j2 = j3;
            int i5 = i4;
            i4 = i3;
            i3 = i5;
        }
        switch (i2) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return j2;
            case 6:
                int i6 = i3 + 1;
                int i7 = bArr[i3] & 255;
                while ((i7 & 128) != 0) {
                    i5 = i6 + 1;
                    i7 = bArr[i6] & 255;
                    i6 = i5;
                }
                j2 = ((long) i6) + j;
                break;
            case 7:
                j2 = (((long) i3) + j) + 20;
                break;
            default:
                throw new IOException(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{Integer.valueOf(i2)}));
        }
        try {
            j2 = asj.j6(DW(asg, j2));
            return j2;
        } catch (DataFormatException e) {
            throw new ala(MessageFormat.format(JGitText.j6().objectAtHasBadZlibStream, new Object[]{Long.valueOf(j), j6()}));
        }
    }

    ari FH(asg asg, anb anb) {
        long DW = u7().DW(anb);
        if (DW < 0) {
            return null;
        }
        byte[] bArr = asg.j6;
        j6(DW, bArr, 0, 20, asg);
        int i = bArr[0] & 255;
        int i2 = 1;
        int i3 = (i >> 4) & 7;
        while ((i & 128) != 0) {
            int i4 = i2 + 1;
            i = bArr[i2] & 255;
            i2 = i4;
        }
        long DW2 = DW(DW) - DW;
        switch (i3) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return ari.j6(this, DW, DW2 - ((long) i2));
            case 6:
                i3 = i2 + 1;
                int i5 = bArr[i2] & 255;
                long j = (long) (i5 & 127);
                while ((i5 & 128) != 0) {
                    i5 = i3 + 1;
                    i3 = bArr[i3] & 255;
                    j = ((j + 1) << 7) + ((long) (i3 & 127));
                    i4 = i5;
                    i5 = i3;
                    i3 = i4;
                }
                return ari.j6(this, DW, DW2 - ((long) i3), DW - j);
            case 7:
                long j2 = (DW2 - ((long) i2)) - 20;
                j6(DW + ((long) i2), bArr, 0, 20, asg);
                return ari.j6(this, DW, j2, ans.j6(bArr));
            default:
                throw new IOException(MessageFormat.format(JGitText.j6().unknownObjectType, new Object[]{Integer.valueOf(i3)}));
        }
    }

    private long DW(long j) {
        return Ws().j6(j, this.FH - 20);
    }

    private synchronized arx Ws() {
        if (this.Ws == null) {
            this.Ws = new arx(u7());
        }
        return this.Ws;
    }

    private boolean FH(long j) {
        awz awz = this.QX;
        if (awz == null) {
            return false;
        }
        boolean j6;
        synchronized (awz) {
            j6 = awz.j6(j);
        }
        return j6;
    }

    private void Hw(long j) {
        awz awz = this.QX;
        if (awz == null) {
            synchronized (this.gn) {
                awz = this.QX;
                if (awz == null) {
                    awz = new awz();
                    this.QX = awz;
                }
            }
        }
        synchronized (awz) {
            awz.DW(j);
        }
    }
}
