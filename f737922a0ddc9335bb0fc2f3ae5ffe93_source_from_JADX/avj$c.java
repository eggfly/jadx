import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collection;
import org.eclipse.jgit.JGitText;

class avj$c extends avv {
    private final URL DW;
    final /* synthetic */ avj j6;

    avj$c(avj avj, URL url) {
        this.j6 = avj;
        this.DW = url;
    }

    avn j6() {
        return new avn(this.DW);
    }

    Collection<avv> DW() {
        try {
            return VH("info/http-alternates");
        } catch (FileNotFoundException e) {
            try {
                return VH("info/alternates");
            } catch (FileNotFoundException e2) {
                return null;
            }
        }
    }

    avv j6(String str) {
        return new avj$c(this.j6, new URL(this.DW, str));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    java.util.Collection<java.lang.String> FH() {
        /*
        r4 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = "info/packs";
        r2 = r4.Zo(r1);	 Catch:{ FileNotFoundException -> 0x0038 }
    L_0x000c:
        r1 = r2.readLine();	 Catch:{ all -> 0x0033 }
        if (r1 == 0) goto L_0x0018;
    L_0x0012:
        r3 = r1.length();	 Catch:{ all -> 0x0033 }
        if (r3 != 0) goto L_0x001c;
    L_0x0018:
        r2.close();	 Catch:{ FileNotFoundException -> 0x0038 }
    L_0x001b:
        return r0;
    L_0x001c:
        r3 = "P pack-";
        r3 = r1.startsWith(r3);	 Catch:{ all -> 0x0033 }
        if (r3 == 0) goto L_0x002e;
    L_0x0025:
        r3 = ".pack";
        r3 = r1.endsWith(r3);	 Catch:{ all -> 0x0033 }
        if (r3 != 0) goto L_0x003a;
    L_0x002e:
        r1 = r4.u7(r1);	 Catch:{ all -> 0x0033 }
        throw r1;	 Catch:{ all -> 0x0033 }
    L_0x0033:
        r1 = move-exception;
        r2.close();	 Catch:{ FileNotFoundException -> 0x0038 }
        throw r1;	 Catch:{ FileNotFoundException -> 0x0038 }
    L_0x0038:
        r1 = move-exception;
        goto L_0x001b;
    L_0x003a:
        r3 = 2;
        r1 = r1.substring(r3);	 Catch:{ all -> 0x0033 }
        r0.add(r1);	 Catch:{ all -> 0x0033 }
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: avj$c.FH():java.util.Collection<java.lang.String>");
    }

    avv$a DW(String str) {
        URL url = new URL(this.DW, str);
        HttpURLConnection j6 = this.j6.j6(url);
        switch (aww.j6(j6)) {
            case 200:
                return new avv$a(this.j6.j6(j6), (long) j6.getContentLength());
            case 404:
                throw new FileNotFoundException(url.toString());
            default:
                throw new IOException(url.toString() + ": " + aww.j6(j6) + " " + j6.getResponseMessage());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    java.util.Map<java.lang.String, aoc> j6(java.io.BufferedReader r8) {
        /*
        r7 = this;
        r6 = 0;
        r1 = new java.util.TreeMap;
        r1.<init>();
    L_0x0006:
        r0 = r8.readLine();
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return r1;
    L_0x000d:
        r2 = 9;
        r2 = r0.indexOf(r2);
        if (r2 >= 0) goto L_0x001a;
    L_0x0015:
        r0 = r7.u7(r0);
        throw r0;
    L_0x001a:
        r3 = r2 + 1;
        r3 = r0.substring(r3);
        r0 = r0.substring(r6, r2);
        r2 = ans.DW(r0);
        r0 = "^{}";
        r0 = r3.endsWith(r0);
        if (r0 == 0) goto L_0x0076;
    L_0x0031:
        r0 = r3.length();
        r0 = r0 + -3;
        r3 = r3.substring(r6, r0);
        r0 = r1.get(r3);
        r0 = (aoc) r0;
        if (r0 != 0) goto L_0x0048;
    L_0x0043:
        r0 = r7.gn(r3);
        throw r0;
    L_0x0048:
        r4 = r0.VH();
        if (r4 == 0) goto L_0x0067;
    L_0x004e:
        r0 = new java.lang.StringBuilder;
        r1 = java.lang.String.valueOf(r3);
        r0.<init>(r1);
        r1 = "^{}";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = r7.tp(r0);
        throw r0;
    L_0x0067:
        r4 = new anu$b;
        r5 = aoc$a.NETWORK;
        r0 = r0.v5();
        r4.<init>(r5, r3, r0, r2);
        r1.put(r3, r4);
        goto L_0x0006;
    L_0x0076:
        r0 = new anu$a;
        r4 = aoc$a.NETWORK;
        r0.<init>(r4, r3, r2);
        r0 = r1.put(r3, r0);
        r0 = (aoc) r0;
        if (r0 == 0) goto L_0x0006;
    L_0x0085:
        r0 = r7.tp(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: avj$c.j6(java.io.BufferedReader):java.util.Map<java.lang.String, aoc>");
    }

    private alq gn(String str) {
        return new alq(MessageFormat.format(JGitText.j6().advertisementOfCameBefore, new Object[]{str, str}));
    }

    private alq u7(String str) {
        return new alq(MessageFormat.format(JGitText.j6().invalidAdvertisementOf, new Object[]{str}));
    }

    private alq tp(String str) {
        return new alq(MessageFormat.format(JGitText.j6().duplicateAdvertisementsOf, new Object[]{str}));
    }

    void v5() {
    }
}
