package com.jcraft.jsch.jgss;

import com.jcraft.jsch.GSSContext;
import com.jcraft.jsch.JSchException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.MessageProp;
import org.ietf.jgss.Oid;

public class GSSContextKrb5 implements GSSContext {
    private static String j6;
    private org.ietf.jgss.GSSContext DW;

    public GSSContextKrb5() {
        this.DW = null;
    }

    static {
        j6 = j6("javax.security.auth.useSubjectCredsOnly");
    }

    public void j6(String str, String str2) {
        try {
            Oid oid = new Oid("1.2.840.113554.1.2.2");
            Oid oid2 = new Oid("1.2.840.113554.1.2.2.1");
            GSSManager instance = GSSManager.getInstance();
            try {
                str2 = InetAddress.getByName(str2).getCanonicalHostName();
            } catch (UnknownHostException e) {
            }
            this.DW = instance.createContext(instance.createName("host/" + str2, oid2), oid, null, 0);
            this.DW.requestMutualAuth(true);
            this.DW.requestConf(true);
            this.DW.requestInteg(true);
            this.DW.requestCredDeleg(true);
            this.DW.requestAnonymity(false);
        } catch (GSSException e2) {
            throw new JSchException(e2.toString());
        }
    }

    public boolean j6() {
        return this.DW.isEstablished();
    }

    public byte[] j6(byte[] bArr, int i, int i2) {
        try {
            if (j6 == null) {
                DW("javax.security.auth.useSubjectCredsOnly", "false");
            }
            byte[] initSecContext = this.DW.initSecContext(bArr, 0, i2);
            if (j6 == null) {
                DW("javax.security.auth.useSubjectCredsOnly", "true");
            }
            return initSecContext;
        } catch (GSSException e) {
            throw new JSchException(e.toString());
        } catch (SecurityException e2) {
            throw new JSchException(e2.toString());
        } catch (Throwable th) {
            if (j6 == null) {
                DW("javax.security.auth.useSubjectCredsOnly", "true");
            }
        }
    }

    public byte[] DW(byte[] bArr, int i, int i2) {
        try {
            return this.DW.getMIC(bArr, i, i2, new MessageProp(0, true));
        } catch (GSSException e) {
            return null;
        }
    }

    public void DW() {
        try {
            this.DW.dispose();
        } catch (GSSException e) {
        }
    }

    private static String j6(String str) {
        try {
            return System.getProperty(str);
        } catch (Exception e) {
            return null;
        }
    }

    private static void DW(String str, String str2) {
        try {
            System.setProperty(str, str2);
        } catch (Exception e) {
        }
    }
}
