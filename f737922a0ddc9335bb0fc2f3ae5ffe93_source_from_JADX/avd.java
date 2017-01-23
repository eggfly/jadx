import com.aide.uidesigner.ProxyTextView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jgit.JGitText;

public abstract class avd {
    public static final auq DW;
    private static /* synthetic */ int[] j3;
    public static final auq j6;
    private static final List<WeakReference<avl>> v5;
    private List<auq> EQ;
    protected final aoh FH;
    protected final avn Hw;
    private boolean J0;
    private boolean J8;
    private int QX;
    private List<auq> VH;
    private boolean Ws;
    private asw XL;
    private String Zo;
    private atn aM;
    private auz gn;
    private String tp;
    private boolean u7;
    private boolean we;

    public abstract void DW();

    public abstract atq QX();

    public abstract auj XL();

    static /* synthetic */ int[] aM() {
        int[] iArr = j3;
        if (iArr == null) {
            iArr = new int[avd$a.values().length];
            try {
                iArr[avd$a.FETCH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[avd$a.PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            j3 = iArr;
        }
        return iArr;
    }

    static {
        v5 = new CopyOnWriteArrayList();
        j6(avk.v5);
        j6(avg.v5);
        j6(ave.v5);
        j6(avh.v5);
        j6(avm.v5);
        j6(avj.Zo);
        j6(avj.v5);
        j6(avi.v5);
        j6();
        j6 = new auq("refs/tags/*:refs/tags/*");
        DW = new auq("refs/heads/*:refs/heads/*");
    }

    private static void j6() {
        ClassLoader classLoader;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            classLoader = avd.class.getClassLoader();
        } else {
            classLoader = contextClassLoader;
        }
        Enumeration j6 = j6(classLoader);
        while (j6.hasMoreElements()) {
            j6(classLoader, (URL) j6.nextElement());
        }
    }

    private static Enumeration<URL> j6(ClassLoader classLoader) {
        try {
            return classLoader.getResources("META-INF/services/" + avd.class.getName());
        } catch (IOException e) {
            return new Vector().elements();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void j6(java.lang.ClassLoader r4, java.net.URL r5) {
        /*
        r0 = r5.openStream();	 Catch:{ IOException -> 0x003e }
        r1 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x003e }
        r2 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x003e }
        r3 = "UTF-8";
        r2.<init>(r0, r3);	 Catch:{ IOException -> 0x003e }
        r1.<init>(r2);	 Catch:{ IOException -> 0x003e }
    L_0x0011:
        r0 = r1.readLine();	 Catch:{ IOException -> 0x002e, all -> 0x0035 }
        if (r0 != 0) goto L_0x001b;
    L_0x0017:
        r1.close();	 Catch:{ IOException -> 0x003c }
    L_0x001a:
        return;
    L_0x001b:
        r2 = r0.length();	 Catch:{ IOException -> 0x002e, all -> 0x0035 }
        if (r2 <= 0) goto L_0x0011;
    L_0x0021:
        r2 = "#";
        r2 = r0.startsWith(r2);	 Catch:{ IOException -> 0x002e, all -> 0x0035 }
        if (r2 != 0) goto L_0x0011;
    L_0x002a:
        j6(r4, r0);	 Catch:{ IOException -> 0x002e, all -> 0x0035 }
        goto L_0x0011;
    L_0x002e:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0033 }
        goto L_0x001a;
    L_0x0033:
        r0 = move-exception;
        goto L_0x001a;
    L_0x0035:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x003a }
    L_0x0039:
        throw r0;
    L_0x003a:
        r1 = move-exception;
        goto L_0x0039;
    L_0x003c:
        r0 = move-exception;
        goto L_0x001a;
    L_0x003e:
        r0 = move-exception;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: avd.j6(java.lang.ClassLoader, java.net.URL):void");
    }

    private static void j6(ClassLoader classLoader, String str) {
        try {
            for (Field field : Class.forName(str, false, classLoader).getDeclaredFields()) {
                if ((field.getModifiers() & 8) == 8 && avl.class.isAssignableFrom(field.getType())) {
                    try {
                        avl avl = (avl) field.get(null);
                        if (avl != null) {
                            j6(avl);
                        }
                    } catch (IllegalArgumentException e) {
                    } catch (IllegalAccessException e2) {
                    }
                }
            }
        } catch (ClassNotFoundException e3) {
        }
    }

    public static void j6(avl avl) {
        v5.add(0, new WeakReference(avl));
    }

    public static List<avl> FH() {
        List arrayList = new ArrayList(v5.size());
        for (WeakReference weakReference : v5) {
            avl avl = (avl) weakReference.get();
            if (avl != null) {
                arrayList.add(avl);
            } else {
                v5.remove(weakReference);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static avd j6(aoh aoh, String str) {
        return j6(aoh, str, avd$a.FETCH);
    }

    public static avd j6(aoh aoh, String str, avd$a avd_a) {
        aur aur = new aur(aoh.VH(), str);
        if (DW(aur)) {
            return j6(aoh, new avn(str), null);
        }
        return j6(aoh, aur, avd_a);
    }

    public static List<avd> DW(aoh aoh, String str, avd$a avd_a) {
        aur aur = new aur(aoh.VH(), str);
        if (!DW(aur)) {
            return DW(aoh, aur, avd_a);
        }
        List arrayList = new ArrayList(1);
        arrayList.add(j6(aoh, new avn(str), null));
        return arrayList;
    }

    public static avd j6(aoh aoh, aur aur, avd$a avd_a) {
        List j6 = j6(aur, avd_a);
        if (j6.isEmpty()) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.j6().remoteConfigHasNoURIAssociated, new Object[]{aur.j6()}));
        }
        avd j62 = j6(aoh, (avn) j6.get(0), aur.j6());
        j62.j6(aur);
        return j62;
    }

    public static List<avd> DW(aoh aoh, aur aur, avd$a avd_a) {
        List<avn> j6 = j6(aur, avd_a);
        List<avd> arrayList = new ArrayList(j6.size());
        for (avn j62 : j6) {
            avd j63 = j6(aoh, j62, aur.j6());
            j63.j6(aur);
            arrayList.add(j63);
        }
        return arrayList;
    }

    private static List<avn> j6(aur aur, avd$a avd_a) {
        switch (aM()[avd_a.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return aur.DW();
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                List<avn> FH = aur.FH();
                if (FH.isEmpty()) {
                    return aur.DW();
                }
                return FH;
            default:
                throw new IllegalArgumentException(avd_a.toString());
        }
    }

    private static boolean DW(aur aur) {
        return aur.DW().isEmpty() && aur.FH().isEmpty();
    }

    public static avd j6(aoh aoh, avn avn, String str) {
        for (WeakReference weakReference : v5) {
            avl avl = (avl) weakReference.get();
            if (avl == null) {
                v5.remove(weakReference);
            } else if (avl.DW(avn, aoh, str)) {
                return avl.j6(avn, aoh, str);
            }
        }
        throw new alm(MessageFormat.format(JGitText.j6().URINotSupported, new Object[]{avn}));
    }

    public static Collection<aus> j6(aoh aoh, Collection<auq> collection, Collection<auq> collection2) {
        if (collection2 == null) {
            Collection emptyList = Collections.emptyList();
        }
        Collection linkedList = new LinkedList();
        for (auq auq : j6(aoh, (Collection) collection)) {
            String FH = auq.FH();
            aoc FH2 = aoh.FH(FH);
            if (FH2 != null) {
                FH = FH2.j6();
            }
            String Hw = auq.Hw();
            if (Hw == null) {
                Hw = FH;
            }
            if (!(FH2 == null || Hw.startsWith("refs/"))) {
                String j6 = FH2.j6();
                Hw = j6.substring(0, j6.indexOf(47, "refs/".length()) + 1) + Hw;
            }
            linkedList.add(new aus(aoh, FH, Hw, auq.j6(), j6(Hw, emptyList), null));
        }
        return linkedList;
    }

    private static Collection<auq> j6(aoh aoh, Collection<auq> collection) {
        Map J8 = aoh.J8();
        Collection<auq> hashSet = new HashSet();
        for (auq auq : collection) {
            if (auq.DW()) {
                for (aoc aoc : J8.values()) {
                    if (auq.j6(aoc)) {
                        hashSet.add(auq.DW(aoc));
                    }
                }
            } else {
                hashSet.add(auq);
            }
        }
        return hashSet;
    }

    private static String j6(String str, Collection<auq> collection) {
        for (auq auq : collection) {
            if (auq.Hw(str)) {
                if (auq.DW()) {
                    return auq.Zo(str).Hw();
                }
                return auq.Hw();
            }
        }
        return null;
    }

    protected avd(aoh aoh, avn avn) {
        this.Zo = "git-upload-pack";
        this.VH = Collections.emptyList();
        this.gn = auz.NO_TAGS;
        this.u7 = true;
        this.tp = "git-receive-pack";
        this.EQ = Collections.emptyList();
        this.we = false;
        avc avc = (avc) aoh.VH().j6(avc.j6);
        this.FH = aoh;
        this.Hw = avn;
        this.J8 = avc.j6();
        this.aM = atn.DW();
    }

    public avn Hw() {
        return this.Hw;
    }

    public String v5() {
        return this.Zo;
    }

    public void j6(String str) {
        if (str == null || str.length() <= 0) {
            this.Zo = "git-upload-pack";
        } else {
            this.Zo = str;
        }
    }

    public auz Zo() {
        return this.gn;
    }

    public void j6(auz auz) {
        if (auz == null) {
            auz = auz.AUTO_FOLLOW;
        }
        this.gn = auz;
    }

    public boolean VH() {
        return this.u7;
    }

    public void j6(boolean z) {
        this.u7 = z;
    }

    public boolean gn() {
        return this.J8;
    }

    public void DW(boolean z) {
        this.J8 = z;
    }

    public String u7() {
        return this.tp;
    }

    public void DW(String str) {
        if (str == null || str.length() <= 0) {
            this.tp = "git-receive-pack";
        } else {
            this.tp = str;
        }
    }

    public boolean tp() {
        return this.we;
    }

    public void FH(boolean z) {
        this.we = z;
    }

    public boolean EQ() {
        return this.Ws;
    }

    public void Hw(boolean z) {
        this.Ws = z;
    }

    public void j6(aur aur) {
        j6(aur.Zo());
        DW(aur.VH());
        j6(aur.gn());
        this.VH = aur.Hw();
        this.EQ = aur.v5();
        this.QX = aur.u7();
    }

    public boolean we() {
        return this.J0;
    }

    public void v5(boolean z) {
        this.J0 = z;
    }

    public int J0() {
        return this.QX;
    }

    public void j6(int i) {
        this.QX = i;
    }

    public asw J8() {
        if (this.XL == null) {
            this.XL = new asw(this.FH);
        }
        return this.XL;
    }

    public void j6(atn atn) {
        this.aM = atn;
    }

    public atn Ws() {
        return this.aM;
    }

    public att j6(aob aob, Collection<auq> collection) {
        if (collection == null || collection.isEmpty()) {
            if (this.VH.isEmpty()) {
                throw new amb(JGitText.j6().nothingToFetch);
            }
            collection = this.VH;
        } else if (!this.VH.isEmpty()) {
            Collection<auq> arrayList = new ArrayList(collection);
            for (auq FH : collection) {
                String FH2 = FH.FH();
                for (auq FH3 : this.VH) {
                    String FH4 = FH3.FH();
                    String Hw = FH3.Hw();
                    if (FH4.equals(FH2) && Hw != null) {
                        arrayList.add(FH3);
                        break;
                    }
                }
            }
            collection = arrayList;
        }
        att att = new att();
        new ats(this, collection).j6(aob, att);
        return att;
    }

    public aul DW(aob aob, Collection<aus> collection) {
        if (collection == null || collection.isEmpty()) {
            try {
                collection = j6(this.EQ);
                if (collection.isEmpty()) {
                    throw new amb(JGitText.j6().nothingToPush);
                }
            } catch (Throwable e) {
                throw new amb(MessageFormat.format(JGitText.j6().problemWithResolvingPushRefSpecsLocally, new Object[]{e.getMessage()}), e);
            }
        }
        return new auk(this, collection).j6(aob);
    }

    public Collection<aus> j6(Collection<auq> collection) {
        return j6(this.FH, (Collection) collection, this.VH);
    }
}
