package com.aide.licensing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.aide.uidesigner.ProxyTextView;
import com.android.vending.licensing.ILicensingService;
import io;
import ip;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class a {
    private ServiceConnection DW;
    private boolean FH;
    private long Hw;
    private boolean VH;
    private Context Zo;
    private Handler gn;
    private ILicensingService j6;
    private d u7;
    private long v5;

    class 1 implements ServiceConnection {
        final /* synthetic */ a j6;

        1(a aVar) {
            this.j6 = aVar;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            io.FH("Licensing service unexpectedly disconnected.");
            this.j6.FH = false;
            this.j6.j6 = null;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            io.j6("Licensing service connected.");
            this.j6.j6 = com.android.vending.licensing.ILicensingService.a.j6(iBinder);
            this.j6.FH = false;
            this.j6.v5();
        }
    }

    static /* synthetic */ class 2 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[com.aide.licensing.c.a.values().length];
            try {
                j6[com.aide.licensing.c.a.LICENSED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[com.aide.licensing.c.a.IN_GRACE_PERIOD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                j6[com.aide.licensing.c.a.OVER_GRACE_PERIOD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                j6[com.aide.licensing.c.a.NOT_LICENSED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                j6[com.aide.licensing.c.a.TEMPORARY_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private class a extends com.android.vending.licensing.a.a {
        private long DW;
        final /* synthetic */ a j6;

        class 1 implements Runnable {
            final /* synthetic */ String DW;
            final /* synthetic */ String FH;
            final /* synthetic */ a Hw;
            final /* synthetic */ int j6;

            1(a aVar, int i, String str, String str2) {
                this.Hw = aVar;
                this.j6 = i;
                this.DW = str;
                this.FH = str2;
            }

            public void run() {
                this.Hw.j6.v5 = 0;
                this.Hw.j6.j6(this.Hw.DW, this.j6, this.DW, this.FH);
            }
        }

        public a(a aVar, long j) {
            this.j6 = aVar;
            this.DW = j;
        }

        public void j6(int i, String str, String str2) {
            this.j6.gn.post(new 1(this, i, str, str2));
        }
    }

    public void j6(Context context, boolean z) {
        this.Zo = context;
        this.gn = new Handler();
        this.VH = z;
    }

    public void j6() {
        if (this.j6 != null) {
            io.j6("License service shutdown");
            this.Zo.unbindService(this.DW);
            this.DW = null;
            this.u7 = null;
            this.FH = false;
        }
    }

    public boolean DW() {
        return u7().isFile();
    }

    public void FH() {
        com.aide.licensing.c.a tp = tp();
        Object obj = 1;
        if ((tp == com.aide.licensing.c.a.IN_GRACE_PERIOD || tp == com.aide.licensing.c.a.OVER_GRACE_PERIOD) && j6(null)) {
            obj = null;
        }
        if (obj != null) {
            Hw();
        }
    }

    private void Hw() {
        io.j6("Stopping LicenseUpdateService");
        this.Zo.stopService(new Intent(this.Zo, LicenseUpdateService.class));
    }

    public boolean j6(d dVar) {
        this.u7 = dVar;
        if (System.currentTimeMillis() < this.Hw) {
            return false;
        }
        com.aide.licensing.c.a tp = tp();
        switch (2.j6[tp.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return false;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                if (this.j6 != null) {
                    v5();
                } else if (this.FH) {
                    io.j6("Licensing service bind already pending");
                } else {
                    this.DW = new 1(this);
                    Intent intent = new Intent("com.android.vending.licensing.ILicensingService");
                    intent.setPackage("com.android.vending");
                    boolean bindService = this.Zo.bindService(intent, this.DW, 1);
                    if (bindService) {
                        this.FH = bindService;
                    } else {
                        io.j6("Licensing service could not be bound");
                        return false;
                    }
                }
                return true;
            default:
                throw new RuntimeException("Unknown LicenseVerificationResult " + tp);
        }
    }

    private void v5() {
        if (System.currentTimeMillis() < this.v5 + 60000) {
            io.j6("License check responsed pending - throttled");
            return;
        }
        try {
            io.j6("Requesting license check");
            long j6 = e.j6(this.Zo);
            this.j6.j6(j6, Zo(), new a(this, j6));
            this.v5 = System.currentTimeMillis();
        } catch (Throwable e) {
            io.j6(e);
        }
    }

    private String Zo() {
        return this.Zo.getApplicationContext().getPackageName();
    }

    private String VH() {
        if (Zo().equals("com.aide.premium.key")) {
            return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkjXTkIvABlLJgyvluBm4h4Ytw87BbBrSRXohMVMvk0Eq2pYJKT1jYfC1W65/YY5GcFYwMiaemVlpH40h/h+rkm+GYYq04awtN8zv35+HymbrW6ztGgNv7gF7ksAOOb8swqQwlx6uzfZWzbny7r9kkKURlXWmpkcKpWUjfoQ1MIRFxuXoJ2owTjvdkezI2hjCxC+NJ57QCG8tBoWJo5jscDRylHuaXBGVX7fJx7NsWzlk9xTXUFE7F8J5OaPRpgCNwo+xC0pXSoA/yCv1dOy4v2tPr9L9rfB95nrTwRs1ob44LOY3UqYgVMC1wpy+nxU6UGch8g8/DfHXfaefBcsbfwIDAQAB";
        }
        if (Zo().equals("com.aide.java.premium.key")) {
            return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn+LHwdRGxOPUMAOl1xlpO/jK/2cqCBxkbIlP0fjvubrkNhj+TdoFzXAPEVJQDmBhRdgfOW7T1JyNDKjQYHqvsqxecl5DSxy+e2c3do2+OmtXDgsCZnwsPoQKZlXqYmr2m7oohe+ogGQ6dvK5ToyLEHtJu6zBs4HNrHEDJAZz4+eG8UydfPJut0VaBxFhLTwdInzILO27JcabVjNWSbMj/3ClErZjcaM9wBhPaftBFpyQWBiIVL5dULHspqlXsiVljpIvz1UTwkHwE+hqJPhPGLBIe6xqNPyv16IOssFskia97yekprSeoMaP0xzc/c7KT2sqsVuCUJsm41yDbqvIDwIDAQAB";
        }
        if (Zo().equals("com.aide.designer")) {
            return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAscoEgrFdBkxPcWpFbDQhJaTdZ92LV4sGN7NdUmkp1OIL9m9vO8cYFRU2ZCpHEQ+gilfA2T37855hqegNJfv3Uv/Rh9gZYy+cEGyqEnZyjZ0eYXEMcRmuvLNCrkFpg8xlzRpAvwMB7Tseez5GSYuwefuSle5OBLYrKYxZ14qIiHBwYrS338+v0jIav07YAlwxqkLIEWikNN0lI7ZuJlhcgIiwCJCDT9WtHaU8GgOGYh4cTLnuNAo5FOsSNnEmSmdc4jRyWCPSSETMs+fbEy3BsDKpaO4I2b/VO0/GVmyI9jkYJgkmx/33gYKSTRw9BZR3yy7Vtnq64/afnSoMYqzkDQIDAQAB";
        }
        return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh9PowqySSG6WBaQx3i5y+3vjHUlva+HzWV7ZlYCkMdY5rHxp48M566VZjQVPV9xF0a47f0n0kdECfNGcLvLtQdB6rhk1xW6ouQG+uCiLmjLomLVZbaHPS7kDDP0ETU7SpVksPfPFlHCNLgZ/68HQzWMv7WmQ5Y1+9x3QQ4EfC3gsQdftsNyjSr7GZ7oR3dMDPyMkjNa5tHi4ZzSEHJQyutD7ezURXAsmyEvFUphp871vKCHNrNA+NHt2KMptZdRuCpip6yr6yyD1uFGWZ7XDEtu9Gtt93dWlC6PyecA21LHbGGbv6M9T5WkyqYRyorDKxdfOXIYuuW2I5PdmiE//+wIDAQAB";
    }

    private com.aide.licensing.c.a j6(long j, int i, String str, String str2, boolean z) {
        int i2 = -1;
        try {
            i2 = z ? -1 : this.Zo.getPackageManager().getPackageInfo(this.Zo.getPackageName(), 0).versionCode;
        } catch (Throwable e) {
            io.j6(e);
        } catch (Throwable th) {
            if (!z && this.VH) {
                Hw();
            }
        }
        com.aide.licensing.c.a j6 = c.j6(this.Zo, j, i, i2, Zo(), str, str2, VH());
        switch (2.j6[j6.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                LicenseUpdateAlarmReceiver.j6(this.Zo);
                this.Hw = c.j6(str, str2, VH()).gn;
                if (!z && j6 == com.aide.licensing.c.a.LICENSED) {
                    j6(str, str2);
                }
                Object obj = (j6 == com.aide.licensing.c.a.LICENSED || j6 == com.aide.licensing.c.a.IN_GRACE_PERIOD) ? 1 : null;
                if (!(this.VH || this.u7 == null)) {
                    if (obj != null) {
                        try {
                            this.u7.j6(str, str2);
                        } catch (Throwable e2) {
                            io.j6(e2);
                        }
                    } else {
                        this.u7.j6();
                    }
                }
                LicenseUpdateAlarmReceiver.j6(this.Zo);
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                if (!(this.VH || this.u7 == null)) {
                    try {
                        this.u7.j6();
                    } catch (Throwable e22) {
                        io.j6(e22);
                    }
                }
                this.Hw = System.currentTimeMillis() + 3600000;
                break;
            case 5:
                break;
            default:
                if (!(this.VH || this.u7 == null)) {
                    try {
                        this.u7.j6();
                    } catch (Throwable e222) {
                        io.j6(e222);
                    }
                }
                this.Hw = System.currentTimeMillis() + 3600000;
                throw new RuntimeException("Unknown LicenseVerificationResult " + j6);
        }
        if (!z && this.VH) {
            Hw();
        }
        return j6;
    }

    private void j6(String str, String str2) {
        FileWriter fileWriter;
        Throwable e;
        try {
            fileWriter = new FileWriter(u7());
            try {
                fileWriter.write(str);
                fileWriter.write(0);
                fileWriter.write(str2);
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Throwable e2) {
                        io.j6(e2);
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    io.j6(e2);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable e22) {
                            io.j6(e22);
                        }
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable e4) {
                            io.j6(e4);
                        }
                    }
                    throw e22;
                }
            }
        } catch (IOException e5) {
            e22 = e5;
            fileWriter = null;
            io.j6(e22);
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (Throwable th2) {
            e22 = th2;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw e22;
        }
    }

    private String[] gn() {
        String[] strArr = null;
        File u7 = u7();
        if (u7.isFile()) {
            try {
                Reader fileReader = new FileReader(u7);
                Writer stringWriter = new StringWriter();
                ip.j6(fileReader, stringWriter);
                strArr = stringWriter.toString().split("\u0000");
            } catch (Throwable e) {
                io.j6(e);
            }
        }
        return strArr;
    }

    private File u7() {
        return new File(this.Zo.getFilesDir(), "license.txt");
    }

    private void j6(long j, int i, String str, String str2) {
        j6(j, i, str, str2, false);
    }

    private com.aide.licensing.c.a tp() {
        String[] gn = gn();
        if (gn == null || gn.length != 2) {
            return com.aide.licensing.c.a.NOT_LICENSED;
        }
        return j6(-1, -1, gn[0], gn[1], true);
    }
}
