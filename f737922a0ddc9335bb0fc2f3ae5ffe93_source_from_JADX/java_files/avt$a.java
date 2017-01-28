import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class avt$a {
    final String DW;
    final String FH;
    File Hw;
    final /* synthetic */ avt Zo;
    final avv j6;
    arp v5;

    avt$a(avt avt, avv avv, String str) {
        String substring;
        this.Zo = avt;
        this.j6 = avv;
        this.DW = str;
        this.FH = new StringBuilder(String.valueOf(this.DW.substring(0, this.DW.length() - 5))).append(".idx").toString();
        String str2 = this.FH;
        if (str2.startsWith("pack-")) {
            str2 = str2.substring(5);
        }
        if (str2.endsWith(".idx")) {
            substring = str2.substring(0, str2.length() - 4);
        } else {
            substring = str2;
        }
        if (avt.j6.FH() instanceof arl) {
            this.Hw = new File(((arl) avt.j6.FH()).gn(), "walk-" + substring + ".walkidx");
        }
    }

    void j6(aob aob) {
        int i = 0;
        if (this.v5 == null) {
            if (this.Hw == null) {
                this.Hw = File.createTempFile("jgit-walk-", ".idx");
            } else if (this.Hw.isFile()) {
                try {
                    this.v5 = arp.j6(this.Hw);
                    return;
                } catch (FileNotFoundException e) {
                }
            }
            avv$a DW = this.j6.DW("pack/" + this.FH);
            String str = "Get " + this.FH.substring(0, 12) + "..idx";
            if (DW.DW >= 0) {
                i = (int) (DW.DW / 1024);
            }
            aob.j6(str, i);
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(this.Hw);
                byte[] bArr = new byte[2048];
                while (!aob.j6()) {
                    int read = DW.j6.read(bArr);
                    if (read >= 0) {
                        fileOutputStream.write(bArr, 0, read);
                        aob.j6(read / 1024);
                    }
                }
                break;
                fileOutputStream.close();
                DW.j6.close();
                aob.DW();
                if (aob.j6()) {
                    awv.j6(this.Hw);
                    return;
                }
                try {
                    this.v5 = arp.j6(this.Hw);
                } catch (IOException e2) {
                    awv.j6(this.Hw);
                    throw e2;
                }
            } catch (IOException e22) {
                try {
                    awv.j6(this.Hw);
                    throw e22;
                } catch (Throwable th) {
                    DW.j6.close();
                }
            } catch (Throwable th2) {
                fileOutputStream.close();
            }
        }
    }

    void DW(aob aob) {
        aub j6 = this.Zo.Mr.j6(this.j6.DW("pack/" + this.DW).j6);
        j6.j6(false);
        j6.j6(this.Zo.DW);
        j6.j6(this.Zo.aM);
        arw j62 = j6.j6(aob);
        if (j62 != null) {
            this.Zo.j3.add(j62);
        }
        this.Zo.Mr.FH();
    }
}
