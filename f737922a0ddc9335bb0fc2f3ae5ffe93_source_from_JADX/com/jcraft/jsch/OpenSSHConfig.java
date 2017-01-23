package com.jcraft.jsch;

import com.jcraft.jsch.ConfigRepository.Config;
import java.util.Hashtable;
import java.util.Vector;

public class OpenSSHConfig implements ConfigRepository {
    private static final Hashtable v5;
    private final Hashtable FH;
    private final Vector Hw;

    class MyConfig implements Config {
        private String DW;
        private Vector FH;
        final /* synthetic */ OpenSSHConfig j6;

        MyConfig(OpenSSHConfig openSSHConfig, String str) {
            this.j6 = openSSHConfig;
            this.FH = new Vector();
            this.DW = str;
            this.FH.addElement(openSSHConfig.FH.get(""));
            byte[] DW = Util.DW(str);
            if (openSSHConfig.Hw.size() > 1) {
                for (int i = 1; i < openSSHConfig.Hw.size(); i++) {
                    String[] split = ((String) openSSHConfig.Hw.elementAt(i)).split("[ \t]");
                    for (String trim : split) {
                        int i2;
                        String trim2 = trim2.trim();
                        if (trim2.startsWith("!")) {
                            trim2 = trim2.substring(1).trim();
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (Util.j6(Util.DW(trim2), DW)) {
                            if (i2 == 0) {
                                this.FH.addElement(openSSHConfig.FH.get((String) openSSHConfig.Hw.elementAt(i)));
                            }
                        } else if (i2 != 0) {
                            this.FH.addElement(openSSHConfig.FH.get((String) openSSHConfig.Hw.elementAt(i)));
                        }
                    }
                }
            }
        }

        private String FH(String str) {
            if (OpenSSHConfig.v5.get(str) != null) {
                str = (String) OpenSSHConfig.v5.get(str);
            }
            int i = 0;
            String str2 = null;
            while (i < this.FH.size()) {
                String str3;
                Vector vector = (Vector) this.FH.elementAt(i);
                for (int i2 = 0; i2 < vector.size(); i2++) {
                    String[] strArr = (String[]) vector.elementAt(i2);
                    if (strArr[0].equals(str)) {
                        str3 = strArr[1];
                        break;
                    }
                }
                str3 = str2;
                if (str3 != null) {
                    return str3;
                }
                i++;
                str2 = str3;
            }
            return str2;
        }

        private String[] Hw(String str) {
            Vector vector = new Vector();
            for (int i = 0; i < this.FH.size(); i++) {
                Vector vector2 = (Vector) this.FH.elementAt(i);
                for (int i2 = 0; i2 < vector2.size(); i2++) {
                    String[] strArr = (String[]) vector2.elementAt(i2);
                    if (strArr[0].equals(str)) {
                        Object obj = strArr[1];
                        if (obj != null) {
                            vector.remove(obj);
                            vector.addElement(obj);
                        }
                    }
                }
            }
            String[] strArr2 = new String[vector.size()];
            vector.toArray(strArr2);
            return strArr2;
        }

        public String j6() {
            return FH("Hostname");
        }

        public String DW() {
            return FH("User");
        }

        public int FH() {
            int i = -1;
            try {
                i = Integer.parseInt(FH("Port"));
            } catch (NumberFormatException e) {
            }
            return i;
        }

        public String j6(String str) {
            if (!str.equals("compression.s2c") && !str.equals("compression.c2s")) {
                return FH(str);
            }
            String FH = FH(str);
            if (FH == null || FH.equals("no")) {
                return "none,zlib@openssh.com,zlib";
            }
            return "zlib@openssh.com,zlib,none";
        }

        public String[] DW(String str) {
            return Hw(str);
        }
    }

    public Config j6(String str) {
        return new MyConfig(this, str);
    }

    static {
        v5 = new Hashtable();
        v5.put("kex", "KexAlgorithms");
        v5.put("server_host_key", "HostKeyAlgorithms");
        v5.put("cipher.c2s", "Ciphers");
        v5.put("cipher.s2c", "Ciphers");
        v5.put("mac.c2s", "Macs");
        v5.put("mac.s2c", "Macs");
        v5.put("compression.s2c", "Compression");
        v5.put("compression.c2s", "Compression");
        v5.put("compression_level", "CompressionLevel");
        v5.put("MaxAuthTries", "NumberOfPasswordPrompts");
    }
}
