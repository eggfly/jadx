import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public class bgo extends X509Certificate implements bgj {
    private bcq DW;
    private boolean[] FH;
    private boolean Hw;
    private bgj Zo;
    private bda j6;
    private int v5;

    public bgo(bda bda) {
        int i = 9;
        this.Zo = new bgb();
        this.j6 = bda;
        try {
            byte[] j6 = j6("2.5.29.19");
            if (j6 != null) {
                this.DW = bcq.j6(ayv.j6(j6));
            }
            try {
                j6 = j6("2.5.29.15");
                if (j6 != null) {
                    azu j62 = azu.j6(ayv.j6(j6));
                    byte[] FH = j62.FH();
                    int length = (FH.length * 8) - j62.Hw();
                    if (length >= 9) {
                        i = length;
                    }
                    this.FH = new boolean[i];
                    for (int i2 = 0; i2 != length; i2++) {
                        boolean z;
                        boolean[] zArr = this.FH;
                        if ((FH[i2 / 8] & (128 >>> (i2 % 8))) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zArr[i2] = z;
                    }
                    return;
                }
                this.FH = null;
            } catch (Exception e) {
                throw new CertificateParsingException("cannot construct KeyUsage: " + e);
            }
        } catch (Exception e2) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + e2);
        }
    }

    public void checkValidity() {
        checkValidity(new Date());
    }

    public void checkValidity(Date date) {
        if (date.getTime() > getNotAfter().getTime()) {
            throw new CertificateExpiredException("certificate expired on " + this.j6.gn().FH());
        } else if (date.getTime() < getNotBefore().getTime()) {
            throw new CertificateNotYetValidException("certificate not valid till " + this.j6.VH().FH());
        }
    }

    public int getVersion() {
        return this.j6.Hw();
    }

    public BigInteger getSerialNumber() {
        return this.j6.v5().FH();
    }

    public Principal getIssuerDN() {
        try {
            return new bgi(bcl.j6(this.j6.Zo().DW()));
        } catch (IOException e) {
            return null;
        }
    }

    public X500Principal getIssuerX500Principal() {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ayt(byteArrayOutputStream).j6(this.j6.Zo());
            return new X500Principal(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public Principal getSubjectDN() {
        return new bgi(bcl.j6(this.j6.u7().w_()));
    }

    public X500Principal getSubjectX500Principal() {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ayt(byteArrayOutputStream).j6(this.j6.u7());
            return new X500Principal(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public Date getNotBefore() {
        return this.j6.VH().Hw();
    }

    public Date getNotAfter() {
        return this.j6.gn().Hw();
    }

    public byte[] getTBSCertificate() {
        try {
            return this.j6.FH().j6("DER");
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public byte[] getSignature() {
        return this.j6.we().FH();
    }

    public String getSigAlgName() {
        Provider provider = Security.getProvider(bgk.j6);
        if (provider != null) {
            String property = provider.getProperty("Alg.Alias.Signature." + getSigAlgOID());
            if (property != null) {
                return property;
            }
        }
        Provider[] providers = Security.getProviders();
        for (int i = 0; i != providers.length; i++) {
            String property2 = providers[i].getProperty("Alg.Alias.Signature." + getSigAlgOID());
            if (property2 != null) {
                return property2;
            }
        }
        return getSigAlgOID();
    }

    public String getSigAlgOID() {
        return this.j6.EQ().Hw().FH();
    }

    public byte[] getSigAlgParams() {
        byte[] bArr = null;
        if (this.j6.EQ().v5() != null) {
            try {
                bArr = this.j6.EQ().v5().w_().j6("DER");
            } catch (IOException e) {
            }
        }
        return bArr;
    }

    public boolean[] getIssuerUniqueID() {
        azu EQ = this.j6.FH().EQ();
        if (EQ == null) {
            return null;
        }
        byte[] FH = EQ.FH();
        boolean[] zArr = new boolean[((FH.length * 8) - EQ.Hw())];
        for (int i = 0; i != zArr.length; i++) {
            boolean z;
            if ((FH[i / 8] & (128 >>> (i % 8))) != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
        }
        return zArr;
    }

    public boolean[] getSubjectUniqueID() {
        azu we = this.j6.FH().we();
        if (we == null) {
            return null;
        }
        byte[] FH = we.FH();
        boolean[] zArr = new boolean[((FH.length * 8) - we.Hw())];
        for (int i = 0; i != zArr.length; i++) {
            boolean z;
            if ((FH[i / 8] & (128 >>> (i % 8))) != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
        }
        return zArr;
    }

    public boolean[] getKeyUsage() {
        return this.FH;
    }

    public List getExtendedKeyUsage() {
        byte[] j6 = j6("2.5.29.37");
        if (j6 == null) {
            return null;
        }
        try {
            ayw ayw = (ayw) new aym(j6).Hw();
            List arrayList = new ArrayList();
            for (int i = 0; i != ayw.v5(); i++) {
                arrayList.add(((bag) ayw.j6(i)).FH());
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception e) {
            throw new CertificateParsingException("error processing extended key usage extension");
        }
    }

    public int getBasicConstraints() {
        if (this.DW == null || !this.DW.FH()) {
            return -1;
        }
        if (this.DW.Hw() == null) {
            return Integer.MAX_VALUE;
        }
        return this.DW.Hw().intValue();
    }

    public Set getCriticalExtensionOIDs() {
        if (getVersion() == 3) {
            Set hashSet = new HashSet();
            bdc J0 = this.j6.FH().J0();
            if (J0 != null) {
                Enumeration FH = J0.FH();
                while (FH.hasMoreElements()) {
                    bag bag = (bag) FH.nextElement();
                    if (J0.j6(bag).j6()) {
                        hashSet.add(bag.FH());
                    }
                }
                return hashSet;
            }
        }
        return null;
    }

    private byte[] j6(String str) {
        bdc J0 = this.j6.FH().J0();
        if (J0 != null) {
            bdb j6 = J0.j6(new bag(str));
            if (j6 != null) {
                return j6.DW().Hw();
            }
        }
        return null;
    }

    public byte[] getExtensionValue(String str) {
        bdc J0 = this.j6.FH().J0();
        if (J0 != null) {
            bdb j6 = J0.j6(new bag(str));
            if (j6 != null) {
                try {
                    return j6.DW().DW();
                } catch (Exception e) {
                    throw new IllegalStateException("error parsing " + e.toString());
                }
            }
        }
        return null;
    }

    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() == 3) {
            Set hashSet = new HashSet();
            bdc J0 = this.j6.FH().J0();
            if (J0 != null) {
                Enumeration FH = J0.FH();
                while (FH.hasMoreElements()) {
                    bag bag = (bag) FH.nextElement();
                    if (!J0.j6(bag).j6()) {
                        hashSet.add(bag.FH());
                    }
                }
                return hashSet;
            }
        }
        return null;
    }

    public boolean hasUnsupportedCriticalExtension() {
        if (getVersion() == 3) {
            bdc J0 = this.j6.FH().J0();
            if (J0 != null) {
                Enumeration FH = J0.FH();
                while (FH.hasMoreElements()) {
                    bag bag = (bag) FH.nextElement();
                    String FH2 = bag.FH();
                    if (!FH2.equals(bgn.J0) && !FH2.equals(bgn.j6) && !FH2.equals(bgn.DW) && !FH2.equals(bgn.FH) && !FH2.equals(bgn.u7) && !FH2.equals(bgn.Hw) && !FH2.equals(bgn.Zo) && !FH2.equals(bgn.VH) && !FH2.equals(bgn.gn) && !FH2.equals(bgn.tp) && !FH2.equals(bgn.EQ) && J0.j6(bag).j6()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public PublicKey getPublicKey() {
        try {
            return bgk.j6(this.j6.tp());
        } catch (IOException e) {
            return null;
        }
    }

    public byte[] getEncoded() {
        try {
            return this.j6.j6("DER");
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Certificate)) {
            return z;
        }
        try {
            return bhf.j6(getEncoded(), ((Certificate) obj).getEncoded());
        } catch (CertificateEncodingException e) {
            return z;
        }
    }

    public synchronized int hashCode() {
        if (!this.Hw) {
            this.v5 = j6();
            this.Hw = true;
        }
        return this.v5;
    }

    private int j6() {
        try {
            byte[] encoded = getEncoded();
            int i = 1;
            int i2 = 0;
            while (i < encoded.length) {
                int i3 = (encoded[i] * i) + i2;
                i++;
                i2 = i3;
            }
            return i2;
        } catch (CertificateEncodingException e) {
            return 0;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("  [0]         Version: ").append(getVersion()).append(property);
        stringBuffer.append("         SerialNumber: ").append(getSerialNumber()).append(property);
        stringBuffer.append("             IssuerDN: ").append(getIssuerDN()).append(property);
        stringBuffer.append("           Start Date: ").append(getNotBefore()).append(property);
        stringBuffer.append("           Final Date: ").append(getNotAfter()).append(property);
        stringBuffer.append("            SubjectDN: ").append(getSubjectDN()).append(property);
        stringBuffer.append("           Public Key: ").append(getPublicKey()).append(property);
        stringBuffer.append("  Signature Algorithm: ").append(getSigAlgName()).append(property);
        byte[] signature = getSignature();
        stringBuffer.append("            Signature: ").append(new String(bhn.j6(signature, 0, 20))).append(property);
        for (int i = 20; i < signature.length; i += 20) {
            if (i < signature.length - 20) {
                stringBuffer.append("                       ").append(new String(bhn.j6(signature, i, 20))).append(property);
            } else {
                stringBuffer.append("                       ").append(new String(bhn.j6(signature, i, signature.length - i))).append(property);
            }
        }
        bdc J0 = this.j6.FH().J0();
        if (J0 != null) {
            Enumeration FH = J0.FH();
            if (FH.hasMoreElements()) {
                stringBuffer.append("       Extensions: \n");
            }
            while (FH.hasMoreElements()) {
                bag bag = (bag) FH.nextElement();
                bdb j6 = J0.j6(bag);
                if (j6.DW() != null) {
                    aym aym = new aym(j6.DW().Hw());
                    stringBuffer.append("                       critical(").append(j6.j6()).append(") ");
                    try {
                        if (bag.equals(bdb.VH)) {
                            stringBuffer.append(bcq.j6(aym.Hw())).append(property);
                        } else if (bag.equals(bdb.FH)) {
                            stringBuffer.append(new bcu((azu) aym.Hw())).append(property);
                        } else if (bag.equals(bbw.DW)) {
                            stringBuffer.append(new bbx((azu) aym.Hw())).append(property);
                        } else if (bag.equals(bbw.Hw)) {
                            stringBuffer.append(new bby((bac) aym.Hw())).append(property);
                        } else if (bag.equals(bbw.EQ)) {
                            stringBuffer.append(new bbz((bac) aym.Hw())).append(property);
                        } else {
                            stringBuffer.append(bag.FH());
                            stringBuffer.append(" value = ").append(bci.j6(aym.Hw())).append(property);
                        }
                    } catch (Exception e) {
                        stringBuffer.append(bag.FH());
                        stringBuffer.append(" value = ").append("*****").append(property);
                    }
                } else {
                    stringBuffer.append(property);
                }
            }
        }
        return stringBuffer.toString();
    }

    public final void verify(PublicKey publicKey) {
        Signature instance;
        String j6 = bgp.j6(this.j6.EQ());
        try {
            instance = Signature.getInstance(j6, bgk.j6);
        } catch (Exception e) {
            instance = Signature.getInstance(j6);
        }
        j6(publicKey, instance);
    }

    public final void verify(PublicKey publicKey, String str) {
        j6(publicKey, Signature.getInstance(bgp.j6(this.j6.EQ()), str));
    }

    private void j6(PublicKey publicKey, Signature signature) {
        if (j6(this.j6.EQ(), this.j6.FH().v5())) {
            bgp.j6(signature, this.j6.EQ().v5());
            signature.initVerify(publicKey);
            signature.update(getTBSCertificate());
            if (!signature.verify(getSignature())) {
                throw new SignatureException("certificate does not verify with supplied key");
            }
            return;
        }
        throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
    }

    private boolean j6(bcp bcp, bcp bcp2) {
        if (!bcp.Hw().equals(bcp2.Hw())) {
            return false;
        }
        if (bcp.v5() == null) {
            if (bcp2.v5() == null || bcp2.v5().equals(bae.j6)) {
                return true;
            }
            return false;
        } else if (bcp2.v5() != null) {
            return bcp.v5().equals(bcp2.v5());
        } else {
            if (bcp.v5() == null || bcp.v5().equals(bae.j6)) {
                return true;
            }
            return false;
        }
    }
}
