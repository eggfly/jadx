package com.aide.ui.build.android;

import com.aide.uidesigner.ProxyTextView;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.spec.SecretKeySpec;

public class h extends KeyStoreSpi {
    private final HashMap DW;
    private final HashMap FH;
    private final HashMap Hw;
    private final Vector j6;
    private final HashMap v5;

    public h() {
        this.j6 = new Vector();
        this.DW = new HashMap();
        this.FH = new HashMap();
        this.Hw = new HashMap();
        this.v5 = new HashMap();
    }

    public Key engineGetKey(String str, char[] cArr) {
        if (!this.FH.containsKey(str)) {
            return null;
        }
        byte[] j6 = j6((byte[]) this.FH.get(str), j6(cArr));
        Certificate[] engineGetCertificateChain = engineGetCertificateChain(str);
        if (engineGetCertificateChain.length <= 0) {
            return new SecretKeySpec(j6, str);
        }
        try {
            return KeyFactory.getInstance(engineGetCertificateChain[0].getPublicKey().getAlgorithm()).generatePrivate(new PKCS8EncodedKeySpec(j6));
        } catch (InvalidKeySpecException e) {
            throw new UnrecoverableKeyException(e.getMessage());
        }
    }

    public Certificate[] engineGetCertificateChain(String str) {
        return (Certificate[]) this.Hw.get(str);
    }

    public Certificate engineGetCertificate(String str) {
        return (Certificate) this.DW.get(str);
    }

    public Date engineGetCreationDate(String str) {
        return (Date) this.v5.get(str);
    }

    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        if (this.DW.containsKey(str)) {
            throw new KeyStoreException("\"" + str + " is a trusted certificate entry");
        }
        this.FH.put(str, j6(key, j6(cArr)));
        if (certificateArr != null) {
            this.Hw.put(str, certificateArr);
        } else {
            this.Hw.put(str, new Certificate[0]);
        }
        if (!this.j6.contains(str)) {
            this.v5.put(str, new Date());
            this.j6.add(str);
        }
    }

    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        if (this.DW.containsKey(str)) {
            throw new KeyStoreException("\"" + str + "\" is a trusted certificate entry");
        }
        try {
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(bArr);
            this.FH.put(str, bArr);
            if (certificateArr != null) {
                this.Hw.put(str, certificateArr);
            } else {
                this.Hw.put(str, new Certificate[0]);
            }
            if (!this.j6.contains(str)) {
                this.v5.put(str, new Date());
                this.j6.add(str);
            }
        } catch (IOException e) {
            throw new KeyStoreException("encoded key is not an EncryptedPrivateKeyInfo");
        }
    }

    public void engineSetCertificateEntry(String str, Certificate certificate) {
        if (this.FH.containsKey(str)) {
            throw new KeyStoreException("\"" + str + "\" is a private key entry");
        } else if (certificate == null) {
            throw new NullPointerException();
        } else {
            this.DW.put(str, certificate);
            if (!this.j6.contains(str)) {
                this.v5.put(str, new Date());
                this.j6.add(str);
            }
        }
    }

    public void engineDeleteEntry(String str) {
        this.j6.remove(str);
    }

    public Enumeration engineAliases() {
        return this.j6.elements();
    }

    public boolean engineContainsAlias(String str) {
        return this.j6.contains(str);
    }

    public int engineSize() {
        return this.j6.size();
    }

    public boolean engineIsKeyEntry(String str) {
        return this.FH.containsKey(str);
    }

    public boolean engineIsCertificateEntry(String str) {
        return this.DW.containsKey(str);
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        for (String str : this.DW.keySet()) {
            if (certificate.equals(this.DW.get(str))) {
                return str;
            }
        }
        return null;
    }

    public void engineStore(OutputStream outputStream, char[] cArr) {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        instance.update(j6(cArr));
        instance.update("Mighty Aphrodite".getBytes("UTF-8"));
        DataOutputStream dataOutputStream = new DataOutputStream(new DigestOutputStream(outputStream, instance));
        dataOutputStream.writeInt(-17957139);
        dataOutputStream.writeInt(2);
        dataOutputStream.writeInt(this.j6.size());
        Enumeration elements = this.j6.elements();
        while (elements.hasMoreElements()) {
            String str = (String) elements.nextElement();
            if (this.DW.containsKey(str)) {
                dataOutputStream.writeInt(2);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeLong(((Date) this.v5.get(str)).getTime());
                j6(dataOutputStream, (Certificate) this.DW.get(str));
            } else {
                dataOutputStream.writeInt(1);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeLong(((Date) this.v5.get(str)).getTime());
                byte[] bArr = (byte[]) this.FH.get(str);
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
                Certificate[] certificateArr = (Certificate[]) this.Hw.get(str);
                dataOutputStream.writeInt(certificateArr.length);
                for (Certificate j6 : certificateArr) {
                    j6(dataOutputStream, j6);
                }
            }
        }
        dataOutputStream.write(instance.digest());
    }

    public void engineLoad(InputStream inputStream, char[] cArr) {
        MessageDigest instance = MessageDigest.getInstance("SHA");
        if (cArr != null) {
            instance.update(j6(cArr));
        }
        instance.update("Mighty Aphrodite".getBytes("UTF-8"));
        this.j6.clear();
        this.DW.clear();
        this.FH.clear();
        this.Hw.clear();
        this.v5.clear();
        if (inputStream != null) {
            DataInputStream dataInputStream = new DataInputStream(new DigestInputStream(inputStream, instance));
            if (dataInputStream.readInt() != -17957139) {
                throw new IOException("not a JavaKeyStore");
            }
            dataInputStream.readInt();
            int readInt = dataInputStream.readInt();
            this.j6.ensureCapacity(readInt);
            if (readInt < 0) {
                throw new IOException("negative entry count");
            }
            for (int i = 0; i < readInt; i++) {
                int readInt2 = dataInputStream.readInt();
                String readUTF = dataInputStream.readUTF();
                this.j6.add(readUTF);
                this.v5.put(readUTF, new Date(dataInputStream.readLong()));
                switch (readInt2) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        Object obj = new byte[dataInputStream.readInt()];
                        dataInputStream.read(obj);
                        this.FH.put(readUTF, obj);
                        int readInt3 = dataInputStream.readInt();
                        Object obj2 = new Certificate[readInt3];
                        for (readInt2 = 0; readInt2 < readInt3; readInt2++) {
                            obj2[readInt2] = j6(dataInputStream);
                        }
                        this.Hw.put(readUTF, obj2);
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        this.DW.put(readUTF, j6(dataInputStream));
                        break;
                    default:
                        throw new IOException("malformed key store");
                }
            }
            dataInputStream.read(new byte[20]);
        }
    }

    private static Certificate j6(DataInputStream dataInputStream) {
        String readUTF = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.read(bArr);
        return CertificateFactory.getInstance(readUTF).generateCertificate(new ByteArrayInputStream(bArr));
    }

    private static void j6(DataOutputStream dataOutputStream, Certificate certificate) {
        dataOutputStream.writeUTF(certificate.getType());
        byte[] encoded = certificate.getEncoded();
        dataOutputStream.writeInt(encoded.length);
        dataOutputStream.write(encoded);
    }

    private static byte[] j6(byte[] bArr, byte[] bArr2) {
        try {
            Object encryptedData = new EncryptedPrivateKeyInfo(bArr).getEncryptedData();
            Object obj = new byte[20];
            System.arraycopy(encryptedData, 0, obj, 0, 20);
            Object obj2 = new byte[20];
            System.arraycopy(encryptedData, encryptedData.length - 20, obj2, 0, 20);
            byte[] bArr3 = new byte[(encryptedData.length - 40)];
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            int i;
            for (int i2 = 0; i2 < bArr3.length; i2 = i) {
                instance.reset();
                instance.update(bArr2);
                instance.update(obj);
                instance.digest(obj, 0, obj.length);
                i = i2;
                for (i2 = 0; i2 < obj.length && i < bArr3.length; i2++) {
                    bArr3[i] = (byte) (obj[i2] ^ encryptedData[i + 20]);
                    i++;
                }
            }
            instance.reset();
            instance.update(bArr2);
            instance.update(bArr3);
            if (MessageDigest.isEqual(obj2, instance.digest())) {
                return bArr3;
            }
            throw new UnrecoverableKeyException("checksum mismatch");
        } catch (Exception e) {
            throw new UnrecoverableKeyException(e.getMessage());
        }
    }

    private static byte[] j6(Key key, byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            SecureRandom.getInstance("SHA1PRNG");
            byte[] encoded = key.getEncoded();
            Object obj = new byte[(encoded.length + 40)];
            Object seed = SecureRandom.getSeed(20);
            System.arraycopy(seed, 0, obj, 0, 20);
            int i;
            for (int i2 = 0; i2 < encoded.length; i2 = i) {
                instance.reset();
                instance.update(bArr);
                instance.update(seed);
                instance.digest(seed, 0, seed.length);
                i = i2;
                for (i2 = 0; i2 < seed.length && i < encoded.length; i2++) {
                    obj[i + 20] = (byte) (seed[i2] ^ encoded[i]);
                    i++;
                }
            }
            instance.reset();
            instance.update(bArr);
            instance.update(encoded);
            instance.digest(obj, obj.length - 20, 20);
            return new EncryptedPrivateKeyInfo("1.3.6.1.4.1.42.2.17.1.1", obj).getEncoded();
        } catch (Exception e) {
            throw new KeyStoreException(e.getMessage());
        }
    }

    private static byte[] j6(char[] cArr) {
        int i = 0;
        byte[] bArr = new byte[(cArr.length * 2)];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            int i3 = i + 1;
            bArr[i] = (byte) (cArr[i2] >>> 8);
            i = i3 + 1;
            bArr[i3] = (byte) cArr[i2];
        }
        return bArr;
    }
}
