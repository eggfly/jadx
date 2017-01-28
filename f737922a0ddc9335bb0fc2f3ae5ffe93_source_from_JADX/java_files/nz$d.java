import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class nz$d {
    public String DW;
    public String FH;
    public String Hw;
    private Map<String, nz$d$a> Zo;
    public long j6;
    private int v5;

    public nz$d(long j, String str, String str2, String str3) {
        this.Zo = new HashMap();
        this.j6 = j;
        this.DW = str;
        this.FH = str2;
        this.Hw = str3;
        this.v5 = 1;
    }

    public nz$d(String str) {
        this.Zo = new HashMap();
        this.FH = str;
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(str + "/" + ".aidedropbox"));
        if (dataInputStream.readInt() != 1) {
            throw new IOException("This directory was downloaded with an older version. Please download your folder again.");
        }
        try {
            this.j6 = dataInputStream.readLong();
            this.DW = dataInputStream.readUTF();
            this.Hw = dataInputStream.readUTF();
            int readInt = dataInputStream.readInt();
            for (int i = 0; i < readInt; i++) {
                this.Zo.put(dataInputStream.readUTF(), new nz$d$a(dataInputStream.readUTF(), dataInputStream.readLong()));
            }
            dataInputStream.close();
            this.v5 = 0;
        } catch (IOException e) {
            throw new IOException("Broken AIDE dropbox sync info. Please download your folder again.");
        }
    }

    public void j6() {
        if (this.v5 != 0) {
            this.v5 = 0;
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.FH + "/" + ".aidedropbox"));
            dataOutputStream.writeInt(1);
            dataOutputStream.writeLong(this.j6);
            dataOutputStream.writeUTF(this.DW);
            dataOutputStream.writeUTF(this.Hw);
            dataOutputStream.writeInt(this.Zo.size());
            for (Entry entry : this.Zo.entrySet()) {
                dataOutputStream.writeUTF((String) entry.getKey());
                dataOutputStream.writeUTF(((nz$d$a) entry.getValue()).j6);
                dataOutputStream.writeLong(((nz$d$a) entry.getValue()).DW);
            }
            dataOutputStream.close();
        }
    }

    public String j6(String str) {
        return this.Hw + str.substring(this.FH.length(), str.length());
    }

    public void j6(String str, String str2, long j) {
        this.Zo.put(Hw(str), new nz$d$a(str2, j));
        DW();
    }

    private void DW() {
        this.v5++;
        if (this.v5 > 100) {
            j6();
        }
    }

    private String Hw(String str) {
        return str.substring(this.FH.length(), str.length());
    }

    public void DW(String str) {
        Set<String> hashSet = new HashSet();
        String Hw = Hw(str);
        for (String str2 : this.Zo.keySet()) {
            if (j6(Hw, str2)) {
                hashSet.add(str2);
            }
        }
        for (String str22 : hashSet) {
            this.Zo.remove(str22);
        }
        DW();
    }

    private boolean j6(String str, String str2) {
        return str2.equals(str) || str2.startsWith(str + "/");
    }

    public nz$d$a FH(String str) {
        return (nz$d$a) this.Zo.get(Hw(str));
    }
}
