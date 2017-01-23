import java.io.IOException;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.JGitText;

final class asg extends any implements asu {
    final arb DW;
    private Inflater FH;
    private aqx Hw;
    final byte[] j6;
    private aqz v5;

    public /* synthetic */ asv DW(aqg aqg) {
        return j6(aqg);
    }

    asg(arb arb) {
        this.j6 = new byte[20];
        this.DW = arb;
    }

    aqz Hw() {
        if (this.v5 == null) {
            this.v5 = new aqz();
        }
        return this.v5;
    }

    public any j6() {
        return new asg(this.DW);
    }

    public Collection<ans> j6(amz amz) {
        if (amz.DW()) {
            return Collections.singleton(amz.FH());
        }
        Set hashSet = new HashSet(4);
        this.DW.j6(hashSet, amz);
        return hashSet;
    }

    public boolean DW(anb anb) {
        return this.DW.j6(anb);
    }

    public anx FH(anb anb, int i) {
        anx j6 = this.DW.j6(this, anb);
        if (j6 == null) {
            if (i == -1) {
                throw new ali(anb.Hw(), "unknown");
            }
            throw new ali(anb.Hw(), i);
        } else if (i == -1 || j6.DW() == i) {
            return j6;
        } else {
            throw new alb(anb.Hw(), i);
        }
    }

    public long Hw(anb anb, int i) {
        long v5 = this.DW.v5(this, anb);
        if (v5 >= 0) {
            return v5;
        }
        if (i == -1) {
            throw new ali(anb.Hw(), "unknown");
        }
        throw new ali(anb.Hw(), i);
    }

    public arj j6(aqg aqg) {
        return new arj(aqg);
    }

    public void j6(asy asy, aob aob, Iterable<asv> iterable) {
        for (asv j6 : iterable) {
            this.DW.j6(asy, j6, this);
            aob.j6(1);
        }
    }

    public void j6(asx asx, asv asv, boolean z) {
        arj arj = (arj) asv;
        arj.VH.j6(asx, arj, z, this);
    }

    public void j6(asx asx, List<asv> list) {
        for (asv j6 : list) {
            asx.j6(j6);
        }
    }

    public Collection<ask> v5() {
        return this.DW.EQ();
    }

    int j6(aro aro, long j, byte[] bArr, int i, int i2) {
        long j2 = aro.FH;
        int i3 = i2;
        int i4 = i;
        long j3 = j;
        while (i3 > 0 && j3 < j2) {
            j6(aro, j3);
            int j6 = this.Hw.j6(j3, bArr, i4, i3);
            j3 += (long) j6;
            i4 += j6;
            i3 -= j6;
        }
        return i2 - i3;
    }

    public void j6(asx asx, ask ask, boolean z) {
        ((arh) ask).j6(asx, z, this);
    }

    void j6(aro aro, long j, boolean z, asx asx) {
        byte[] j6;
        MessageDigest messageDigest = null;
        if (z) {
            messageDigest = anj.j6();
            j6 = asx.j6();
            j6(aro, 0);
            if (this.Hw.j6(0, j6, 0, 12) != 12) {
                aro.Zo();
                throw new IOException(JGitText.j6().packfileIsTruncated);
            }
            messageDigest.update(j6, 0, 12);
        }
        long j2 = 12;
        long j3 = j - 32;
        while (0 < j3) {
            j6(aro, j2);
            int min = (int) Math.min((long) (this.Hw.j6() - ((int) (j2 - this.Hw.DW))), j3);
            this.Hw.j6(asx, j2, min, messageDigest);
            j2 += (long) min;
            j3 -= (long) min;
        }
        if (messageDigest != null) {
            byte[] bArr = new byte[20];
            j6 = messageDigest.digest();
            j6(aro, j2);
            if (this.Hw.j6(j2, bArr, 0, 20) != 20) {
                aro.Zo();
                throw new IOException(JGitText.j6().packfileIsTruncated);
            } else if (!Arrays.equals(j6, bArr)) {
                aro.Zo();
                throw new IOException(MessageFormat.format(JGitText.j6().packfileCorruptionDetected, new Object[]{aro.j6().getPath()}));
            }
        }
    }

    int j6(aro aro, long j, byte[] bArr, int i) {
        gn();
        j6(aro, j);
        long j6 = ((long) this.Hw.j6(j, this.FH)) + j;
        do {
            int inflate = this.FH.inflate(bArr, i, bArr.length - i);
            if (inflate == 0) {
                if (this.FH.needsInput()) {
                    j6(aro, j6);
                    j6 += (long) this.Hw.j6(j6, this.FH);
                } else if (this.FH.finished()) {
                    return i;
                } else {
                    throw new DataFormatException();
                }
            }
            i += inflate;
        } while (i < bArr.length);
        return i;
    }

    aqv j6(aro aro, long j, long j2) {
        j6(aro, j);
        if ((this.Hw instanceof aqv) && this.Hw.j6(aro, (j2 - 1) + j)) {
            return (aqv) this.Hw;
        }
        return null;
    }

    Inflater Zo() {
        gn();
        return this.FH;
    }

    private void gn() {
        if (this.FH == null) {
            this.FH = ann.j6();
        } else {
            this.FH.reset();
        }
    }

    void j6(aro aro, long j) {
        aqx aqx = this.Hw;
        if (aqx == null || !aqx.j6(aro, j)) {
            this.Hw = null;
            this.Hw = ase.j6(aro, j);
        }
    }

    int VH() {
        return ase.j6();
    }

    public void FH() {
        this.Hw = null;
        this.v5 = null;
        try {
            ann.j6(this.FH);
        } finally {
            this.FH = null;
        }
    }
}
