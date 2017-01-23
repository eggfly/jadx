import java.security.AccessController;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public final class bgk extends Provider implements bgc {
    public static final bgd DW;
    private static String FH;
    private static final Map Hw;
    private static final String[] VH;
    private static final String[] Zo;
    private static final String[] gn;
    public static String j6;
    private static final String[] v5;

    static {
        FH = "BouncyCastle Security Provider v1.47";
        j6 = "SC";
        DW = new bgl();
        Hw = new HashMap();
        v5 = new String[]{"AES", "ARC4", "Blowfish", "Camellia", "CAST5", "CAST6", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Skipjack", "TEA", "Twofish", "VMPC", "VMPCKSA3", "XTEA"};
        Zo = new String[]{"X509"};
        VH = new String[]{"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal"};
        gn = new String[]{"GOST3411", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "Tiger", "Whirlpool"};
    }

    public bgk() {
        super(j6, 1.47d, FH);
        AccessController.doPrivileged(new bgk$1(this));
    }

    private void j6() {
        j6("org.spongycastle.jcajce.provider.digest.", gn);
        j6("org.spongycastle.jcajce.provider.symmetric.", v5);
        j6("org.spongycastle.jcajce.provider.asymmetric.", Zo);
        j6("org.spongycastle.jcajce.provider.asymmetric.", VH);
        put("X509Store.CERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.spongycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.spongycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.spongycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.spongycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.spongycastle.jce.provider.X509CertPairParser");
        put("KeyStore.BKS", "org.spongycastle.jce.provider.JDKKeyStore");
        put("KeyStore.BouncyCastle", "org.spongycastle.jce.provider.JDKKeyStore$BouncyCastleStore");
        put("KeyStore.PKCS12", "org.spongycastle.jce.provider.JDKPKCS12KeyStore$BCPKCS12KeyStore");
        put("KeyStore.BCPKCS12", "org.spongycastle.jce.provider.JDKPKCS12KeyStore$BCPKCS12KeyStore");
        put("KeyStore.PKCS12-DEF", "org.spongycastle.jce.provider.JDKPKCS12KeyStore$DefPKCS12KeyStore");
        put("KeyStore.PKCS12-3DES-40RC2", "org.spongycastle.jce.provider.JDKPKCS12KeyStore$BCPKCS12KeyStore");
        put("KeyStore.PKCS12-3DES-3DES", "org.spongycastle.jce.provider.JDKPKCS12KeyStore$BCPKCS12KeyStore3DES");
        put("KeyStore.PKCS12-DEF-3DES-40RC2", "org.spongycastle.jce.provider.JDKPKCS12KeyStore$DefPKCS12KeyStore");
        put("KeyStore.PKCS12-DEF-3DES-3DES", "org.spongycastle.jce.provider.JDKPKCS12KeyStore$DefPKCS12KeyStore3DES");
        put("Alg.Alias.KeyStore.UBER", "BouncyCastle");
        put("Alg.Alias.KeyStore.BOUNCYCASTLE", "BouncyCastle");
        put("Alg.Alias.KeyStore.spongycastle", "BouncyCastle");
        put("AlgorithmParameters.IES", "org.spongycastle.jce.provider.JDKAlgorithmParameters$IES");
        put("AlgorithmParameters.PKCS12PBE", "org.spongycastle.jce.provider.JDKAlgorithmParameters$PKCS12PBE");
        put("AlgorithmParameters." + bce.yS, "org.spongycastle.jce.provider.JDKAlgorithmParameters$PBKDF2");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC2", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC4", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES3KEY-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES2KEY-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC2-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND40BITRC4", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC2-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITRC4", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH-CBC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.1", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.2", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.3", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.4", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.5", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.6", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWithSHAAnd3KeyTripleDES", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + bbh.we.FH(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + bbh.J0.FH(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + bbh.J8.FH(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + bbh.Ws.FH(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + bbh.QX.FH(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters." + bbh.XL.FH(), "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE");
        put("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
        put("AlgorithmParameters.SHA1WITHECDSA", "org.spongycastle.jce.provider.JDKECDSAAlgParameters$SigAlgParameters");
        put("AlgorithmParameters.SHA224WITHECDSA", "org.spongycastle.jce.provider.JDKECDSAAlgParameters$SigAlgParameters");
        put("AlgorithmParameters.SHA256WITHECDSA", "org.spongycastle.jce.provider.JDKECDSAAlgParameters$SigAlgParameters");
        put("AlgorithmParameters.SHA384WITHECDSA", "org.spongycastle.jce.provider.JDKECDSAAlgParameters$SigAlgParameters");
        put("AlgorithmParameters.SHA512WITHECDSA", "org.spongycastle.jce.provider.JDKECDSAAlgParameters$SigAlgParameters");
        put("Alg.Alias.Cipher.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        put("Cipher.ECIES", "org.spongycastle.jce.provider.JCEIESCipher$ECIES");
        put("Cipher.BrokenECIES", "org.spongycastle.jce.provider.JCEIESCipher$BrokenECIES");
        put("Cipher.IES", "org.spongycastle.jce.provider.JCEIESCipher$IES");
        put("Cipher.BrokenIES", "org.spongycastle.jce.provider.JCEIESCipher$BrokenIES");
        put("Cipher.PBEWITHMD5ANDDES", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.PBEWITHMD5ANDRC2", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithMD5AndRC2");
        put("Cipher.PBEWITHSHA1ANDDES", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithSHA1AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.PBEWITHSHA1ANDRC2", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithSHA1AndRC2");
        put("Cipher.PBEWITHSHAAND128BITRC2-CBC", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithSHAAnd128BitRC2");
        put("Cipher.PBEWITHSHAAND40BITRC2-CBC", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithSHAAnd40BitRC2");
        put("Cipher.PBEWITHSHAAND128BITRC4", "org.spongycastle.jce.provider.JCEStreamCipher$PBEWithSHAAnd128BitRC4");
        put("Cipher.PBEWITHSHAAND40BITRC4", "org.spongycastle.jce.provider.JCEStreamCipher$PBEWithSHAAnd40BitRC4");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC2-CBC", "PBEWITHSHAAND128BITRC2-CBC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC2-CBC", "PBEWITHSHAAND40BITRC2-CBC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND128BITRC4", "PBEWITHSHAAND128BITRC4");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND40BITRC4", "PBEWITHSHAAND40BITRC4");
        put("Alg.Alias.Cipher." + bbh.we.FH(), "PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + bbh.J0.FH(), "PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + bbh.J8.FH(), "PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + bbh.Ws.FH(), "PBEWITHSHA256AND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + bbh.QX.FH(), "PBEWITHSHA256AND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher." + bbh.XL.FH(), "PBEWITHSHA256AND256BITAES-CBC-BC");
        put("Cipher.PBEWITHSHAAND128BITAES-CBC-BC", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHAAND256BITAES-CBC-BC", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
        put("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
        put("Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithAESCBC");
        put("Cipher.PBEWITHSHAANDTWOFISH-CBC", "org.spongycastle.jce.provider.JCEBlockCipher$PBEWithSHAAndTwofish");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        put("Alg.Alias.Cipher." + bce.m_, "PBEWITHMD2ANDDES");
        put("Alg.Alias.Cipher." + bce.n_, "PBEWITHMD2ANDRC2");
        put("Alg.Alias.Cipher." + bce.U2, "PBEWITHMD5ANDDES");
        put("Alg.Alias.Cipher." + bce.a8, "PBEWITHMD5ANDDES");
        put("Alg.Alias.Cipher." + bce.lg, "PBEWITHSHA1ANDDES");
        put("Alg.Alias.Cipher." + bce.rN, "PBEWITHSHA1ANDRC2");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.1", "PBEWITHSHAAND128BITRC4");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.2", "PBEWITHSHAAND40BITRC4");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
        put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
        put("SecretKeyFactory.PBEWITHMD2ANDDES", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithMD2AndDES");
        put("Alg.Alias.SecretKeyFactory." + bce.m_, "PBEWITHMD2ANDDES");
        put("Alg.Alias.SecretKeyFactory." + bce.n_, "PBEWITHMD2ANDRC2");
        put("Alg.Alias.SecretKeyFactory." + bce.U2, "PBEWITHMD5ANDDES");
        put("Alg.Alias.SecretKeyFactory." + bce.a8, "PBEWITHMD5ANDDES");
        put("Alg.Alias.SecretKeyFactory." + bce.lg, "PBEWITHSHA1ANDDES");
        put("Alg.Alias.SecretKeyFactory." + bce.rN, "PBEWITHSHA1ANDRC2");
        put("SecretKeyFactory.PBEWITHMD2ANDRC2", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithMD2AndRC2");
        put("SecretKeyFactory.PBEWITHMD5ANDDES", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5AndDES");
        put("SecretKeyFactory.PBEWITHMD5ANDRC2", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5AndRC2");
        put("SecretKeyFactory.PBEWITHSHA1ANDDES", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA1AndDES");
        put("SecretKeyFactory.PBEWITHSHA1ANDRC2", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA1AndRC2");
        put("SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAndDES3Key");
        put("SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAndDES2Key");
        put("SecretKeyFactory.PBEWITHSHAAND128BITRC4", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd128BitRC4");
        put("SecretKeyFactory.PBEWITHSHAAND40BITRC4", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd40BitRC4");
        put("SecretKeyFactory.PBEWITHSHAAND128BITRC2-CBC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd128BitRC2");
        put("SecretKeyFactory.PBEWITHSHAAND40BITRC2-CBC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd40BitRC2");
        put("SecretKeyFactory.PBEWITHSHAANDTWOFISH-CBC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAndTwofish");
        put("SecretKeyFactory.PBEWITHHMACRIPEMD160", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithRIPEMD160");
        put("SecretKeyFactory.PBEWITHHMACSHA1", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA");
        put("SecretKeyFactory.PBEWITHHMACTIGER", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithTiger");
        put("SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5And128BitAESCBCOpenSSL");
        put("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5And192BitAESCBCOpenSSL");
        put("SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithMD5And256BitAESCBCOpenSSL");
        put("Alg.Alias.SecretKeyFactory.PBE", "PBE/PKCS5");
        put("Alg.Alias.SecretKeyFactory.BROKENPBEWITHMD5ANDDES", "PBE/PKCS5");
        put("Alg.Alias.SecretKeyFactory.BROKENPBEWITHSHA1ANDDES", "PBE/PKCS5");
        put("Alg.Alias.SecretKeyFactory.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PBE/PKCS12");
        put("Alg.Alias.SecretKeyFactory.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PBE/PKCS12");
        put("Alg.Alias.SecretKeyFactory.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PBE/PKCS12");
        put("Alg.Alias.SecretKeyFactory.OLDPBEWITHSHAANDTWOFISH-CBC", "PBE/PKCS12");
        put("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
        put("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDRC2-CBC", "PBEWITHMD2ANDRC2");
        put("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
        put("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDRC2-CBC", "PBEWITHMD5ANDRC2");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDRC2-CBC", "PBEWITHSHA1ANDRC2");
        put("Alg.Alias.SecretKeyFactory." + bce.m_, "PBEWITHMD2ANDDES");
        put("Alg.Alias.SecretKeyFactory." + bce.n_, "PBEWITHMD2ANDRC2");
        put("Alg.Alias.SecretKeyFactory." + bce.U2, "PBEWITHMD5ANDDES");
        put("Alg.Alias.SecretKeyFactory." + bce.a8, "PBEWITHMD5ANDRC2");
        put("Alg.Alias.SecretKeyFactory." + bce.lg, "PBEWITHSHA1ANDDES");
        put("Alg.Alias.SecretKeyFactory." + bce.rN, "PBEWITHSHA1ANDRC2");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.1", "PBEWITHSHAAND128BITRC4");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.2", "PBEWITHSHAAND40BITRC4");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
        put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
        put("Alg.Alias.SecretKeyFactory.1.3.14.3.2.26", "PBEWITHHMACSHA1");
        put("Alg.Alias.SecretKeyFactory.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        put("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd128BitAESBC");
        put("SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd192BitAESBC");
        put("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHAAnd256BitAESBC");
        put("SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA256And128BitAESBC");
        put("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA256And192BitAESBC");
        put("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", "org.spongycastle.jce.provider.JCESecretKeyFactory$PBEWithSHA256And256BitAESBC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + bbh.we.FH(), "PBEWITHSHAAND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + bbh.J0.FH(), "PBEWITHSHAAND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + bbh.J8.FH(), "PBEWITHSHAAND256BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + bbh.Ws.FH(), "PBEWITHSHA256AND128BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + bbh.QX.FH(), "PBEWITHSHA256AND192BITAES-CBC-BC");
        put("Alg.Alias.SecretKeyFactory." + bbh.XL.FH(), "PBEWITHSHA256AND256BITAES-CBC-BC");
        DW();
        put("CertPathValidator.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        put("CertPathValidator.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertPathValidator.PKIX", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
        put("CertPathBuilder.PKIX", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
        put("CertStore.Collection", "org.spongycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.spongycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.spongycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }

    private void j6(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            Class cls = null;
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                if (classLoader != null) {
                    cls = classLoader.loadClass(new StringBuilder(String.valueOf(str)).append(strArr[i]).append("$Mappings").toString());
                } else {
                    cls = Class.forName(new StringBuilder(String.valueOf(str)).append(strArr[i]).append("$Mappings").toString());
                }
            } catch (ClassNotFoundException e) {
            }
            if (cls != null) {
                try {
                    ((bgf) cls.newInstance()).configure(this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    throw new InternalError("cannot create instance of " + str + strArr[i] + "$Mappings : " + e2);
                }
            }
        }
    }

    private void DW() {
        put("Mac.DESWITHISO9797", "org.spongycastle.jce.provider.JCEMac$DES9797Alg3");
        put("Alg.Alias.Mac.DESISO9797MAC", "DESWITHISO9797");
        put("Mac.ISO9797ALG3MAC", "org.spongycastle.jce.provider.JCEMac$DES9797Alg3");
        put("Alg.Alias.Mac.ISO9797ALG3", "ISO9797ALG3MAC");
        put("Mac.ISO9797ALG3WITHISO7816-4PADDING", "org.spongycastle.jce.provider.JCEMac$DES9797Alg3with7816d4");
        put("Alg.Alias.Mac.ISO9797ALG3MACWITHISO7816-4PADDING", "ISO9797ALG3WITHISO7816-4PADDING");
        put("Mac.OLDHMACSHA384", "org.spongycastle.jce.provider.JCEMac$OldSHA384");
        put("Mac.OLDHMACSHA512", "org.spongycastle.jce.provider.JCEMac$OldSHA512");
        put("Mac.PBEWITHHMACSHA", "org.spongycastle.jce.provider.JCEMac$PBEWithSHA");
        put("Mac.PBEWITHHMACSHA1", "org.spongycastle.jce.provider.JCEMac$PBEWithSHA");
        put("Mac.PBEWITHHMACRIPEMD160", "org.spongycastle.jce.provider.JCEMac$PBEWithRIPEMD160");
        put("Alg.Alias.Mac.1.3.14.3.2.26", "PBEWITHHMACSHA");
    }

    public void j6(String str, String str2) {
        if (containsKey(str)) {
            throw new IllegalStateException("duplicate provider key (" + str + ") found");
        }
        put(str, str2);
    }

    public static PublicKey j6(bcv bcv) {
        bgh bgh = (bgh) Hw.get(bcv.FH().FH());
        if (bgh == null) {
            return null;
        }
        return bgh.generatePublic(bcv);
    }
}
