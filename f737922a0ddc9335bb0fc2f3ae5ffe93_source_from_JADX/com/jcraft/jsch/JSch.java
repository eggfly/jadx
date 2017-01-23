package com.jcraft.jsch;

import com.jcraft.jsch.IdentityRepository.Wrapper;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;

public class JSch {
    static Logger DW;
    private static final Logger gn;
    static Hashtable j6;
    private Vector FH;
    private IdentityRepository Hw;
    private HostKeyRepository VH;
    private ConfigRepository Zo;
    private IdentityRepository v5;

    class 1 implements Logger {
        1() {
        }

        public boolean j6(int i) {
            return false;
        }

        public void j6(int i, String str) {
        }
    }

    static {
        j6 = new Hashtable();
        j6.put("kex", "diffie-hellman-group1-sha1,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha1");
        j6.put("server_host_key", "ssh-rsa,ssh-dss");
        j6.put("cipher.s2c", "aes128-ctr,aes128-cbc,3des-ctr,3des-cbc,blowfish-cbc,aes192-cbc,aes256-cbc");
        j6.put("cipher.c2s", "aes128-ctr,aes128-cbc,3des-ctr,3des-cbc,blowfish-cbc,aes192-cbc,aes256-cbc");
        j6.put("mac.s2c", "hmac-md5,hmac-sha1,hmac-sha2-256,hmac-sha1-96,hmac-md5-96");
        j6.put("mac.c2s", "hmac-md5,hmac-sha1,hmac-sha2-256,hmac-sha1-96,hmac-md5-96");
        j6.put("compression.s2c", "none");
        j6.put("compression.c2s", "none");
        j6.put("lang.s2c", "");
        j6.put("lang.c2s", "");
        j6.put("compression_level", "6");
        j6.put("diffie-hellman-group-exchange-sha1", "com.jcraft.jsch.DHGEX");
        j6.put("diffie-hellman-group1-sha1", "com.jcraft.jsch.DHG1");
        j6.put("diffie-hellman-group14-sha1", "com.jcraft.jsch.DHG14");
        j6.put("diffie-hellman-group-exchange-sha256", "com.jcraft.jsch.DHGEX256");
        j6.put("dh", "com.jcraft.jsch.jce.DH");
        j6.put("3des-cbc", "com.jcraft.jsch.jce.TripleDESCBC");
        j6.put("blowfish-cbc", "com.jcraft.jsch.jce.BlowfishCBC");
        j6.put("hmac-sha1", "com.jcraft.jsch.jce.HMACSHA1");
        j6.put("hmac-sha1-96", "com.jcraft.jsch.jce.HMACSHA196");
        j6.put("hmac-sha2-256", "com.jcraft.jsch.jce.HMACSHA256");
        j6.put("hmac-md5", "com.jcraft.jsch.jce.HMACMD5");
        j6.put("hmac-md5-96", "com.jcraft.jsch.jce.HMACMD596");
        j6.put("sha-1", "com.jcraft.jsch.jce.SHA1");
        j6.put("sha-256", "com.jcraft.jsch.jce.SHA256");
        j6.put("md5", "com.jcraft.jsch.jce.MD5");
        j6.put("signature.dss", "com.jcraft.jsch.jce.SignatureDSA");
        j6.put("signature.rsa", "com.jcraft.jsch.jce.SignatureRSA");
        j6.put("keypairgen.dsa", "com.jcraft.jsch.jce.KeyPairGenDSA");
        j6.put("keypairgen.rsa", "com.jcraft.jsch.jce.KeyPairGenRSA");
        j6.put("random", "com.jcraft.jsch.jce.Random");
        j6.put("none", "com.jcraft.jsch.CipherNone");
        j6.put("aes128-cbc", "com.jcraft.jsch.jce.AES128CBC");
        j6.put("aes192-cbc", "com.jcraft.jsch.jce.AES192CBC");
        j6.put("aes256-cbc", "com.jcraft.jsch.jce.AES256CBC");
        j6.put("aes128-ctr", "com.jcraft.jsch.jce.AES128CTR");
        j6.put("aes192-ctr", "com.jcraft.jsch.jce.AES192CTR");
        j6.put("aes256-ctr", "com.jcraft.jsch.jce.AES256CTR");
        j6.put("3des-ctr", "com.jcraft.jsch.jce.TripleDESCTR");
        j6.put("arcfour", "com.jcraft.jsch.jce.ARCFOUR");
        j6.put("arcfour128", "com.jcraft.jsch.jce.ARCFOUR128");
        j6.put("arcfour256", "com.jcraft.jsch.jce.ARCFOUR256");
        j6.put("userauth.none", "com.jcraft.jsch.UserAuthNone");
        j6.put("userauth.password", "com.jcraft.jsch.UserAuthPassword");
        j6.put("userauth.keyboard-interactive", "com.jcraft.jsch.UserAuthKeyboardInteractive");
        j6.put("userauth.publickey", "com.jcraft.jsch.UserAuthPublicKey");
        j6.put("userauth.gssapi-with-mic", "com.jcraft.jsch.UserAuthGSSAPIWithMIC");
        j6.put("gssapi-with-mic.krb5", "com.jcraft.jsch.jgss.GSSContextKrb5");
        j6.put("zlib", "com.jcraft.jsch.jcraft.Compression");
        j6.put("zlib@openssh.com", "com.jcraft.jsch.jcraft.Compression");
        j6.put("pbkdf", "com.jcraft.jsch.jce.PBKDF");
        j6.put("StrictHostKeyChecking", "ask");
        j6.put("HashKnownHosts", "no");
        j6.put("PreferredAuthentications", "gssapi-with-mic,publickey,keyboard-interactive,password");
        j6.put("CheckCiphers", "aes256-ctr,aes192-ctr,aes128-ctr,aes256-cbc,aes192-cbc,aes128-cbc,3des-ctr,arcfour,arcfour128,arcfour256");
        j6.put("CheckKexes", "diffie-hellman-group14-sha1");
        j6.put("MaxAuthTries", "6");
        j6.put("ClearAllForwardings", "no");
        gn = new 1();
        DW = gn;
    }

    public synchronized void j6(IdentityRepository identityRepository) {
        if (identityRepository == null) {
            this.v5 = this.Hw;
        } else {
            this.v5 = identityRepository;
        }
    }

    public synchronized IdentityRepository j6() {
        return this.v5;
    }

    public ConfigRepository DW() {
        return this.Zo;
    }

    public JSch() {
        this.FH = new Vector();
        this.Hw = new LocalIdentityRepository(this);
        this.v5 = this.Hw;
        this.Zo = null;
        this.VH = null;
    }

    public Session j6(String str, String str2, int i) {
        if (str2 != null) {
            return new Session(this, str, str2, i);
        }
        throw new JSchException("host must not be null.");
    }

    protected void j6(Session session) {
        synchronized (this.FH) {
            this.FH.addElement(session);
        }
    }

    protected boolean DW(Session session) {
        boolean remove;
        synchronized (this.FH) {
            remove = this.FH.remove(session);
        }
        return remove;
    }

    public void j6(HostKeyRepository hostKeyRepository) {
        this.VH = hostKeyRepository;
    }

    public void j6(InputStream inputStream) {
        if (this.VH == null) {
            this.VH = new KnownHosts(this);
        }
        if (this.VH instanceof KnownHosts) {
            synchronized (this.VH) {
                ((KnownHosts) this.VH).j6(inputStream);
            }
        }
    }

    public HostKeyRepository FH() {
        if (this.VH == null) {
            this.VH = new KnownHosts(this);
        }
        return this.VH;
    }

    public void j6(String str) {
        j6(str, null);
    }

    public void j6(String str, byte[] bArr) {
        j6(IdentityFile.j6(str, null, this), bArr);
    }

    public void j6(Identity identity, byte[] bArr) {
        Throwable th;
        if (bArr != null) {
            try {
                byte[] bArr2 = new byte[bArr.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                try {
                    identity.j6(bArr2);
                    Util.Hw(bArr2);
                } catch (Throwable th2) {
                    th = th2;
                    bArr = bArr2;
                    Util.Hw(bArr);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                Util.Hw(bArr);
                throw th;
            }
        }
        if (this.v5 instanceof LocalIdentityRepository) {
            ((LocalIdentityRepository) this.v5).j6(identity);
        } else if (!(identity instanceof IdentityFile) || identity.Hw()) {
            synchronized (this) {
                if (!(this.v5 instanceof Wrapper)) {
                    j6(new Wrapper(this.v5));
                }
            }
            ((Wrapper) this.v5).j6(identity);
        } else {
            this.v5.j6(((IdentityFile) identity).Zo().j6());
        }
    }

    public Vector Hw() {
        Vector vector = new Vector();
        Vector j6 = this.v5.j6();
        for (int i = 0; i < j6.size(); i++) {
            vector.addElement(((Identity) j6.elementAt(i)).FH());
        }
        return vector;
    }

    public static String DW(String str) {
        String str2;
        synchronized (j6) {
            str2 = (String) j6.get(str);
        }
        return str2;
    }

    static Logger v5() {
        return DW;
    }
}
