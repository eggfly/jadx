package com.p029a.p030a;

import android.util.Log;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.p029a.p030a.p031b.C1054a;
import com.p029a.p030a.p031b.C1071b;
import com.p029a.p030a.p031b.C1071b.C1068a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.a.a.a */
public class C1061a {
    public static boolean f3569a;
    public static boolean f3570b;
    public static int f3571c;

    /* renamed from: com.a.a.a.1 */
    static class C10551 extends C1054a {
        final /* synthetic */ List f3558a;

        C10551(int i, boolean z, String[] strArr, List list) {
            this.f3558a = list;
            super(i, z, strArr);
        }

        public void m4730a(int i, String str) {
            C1061a.m4746c(str);
            this.f3558a.add(str);
            super.m4719a(i, str);
        }
    }

    /* renamed from: com.a.a.a.2 */
    static class C10562 extends C1054a {
        final /* synthetic */ String f3559a;
        final /* synthetic */ List f3560b;
        final /* synthetic */ String f3561c;

        C10562(int i, boolean z, String[] strArr, String str, List list, String str2) {
            this.f3559a = str;
            this.f3560b = list;
            this.f3561c = str2;
            super(i, z, strArr);
        }

        public void m4731a(int i, String str) {
            if (str.contains("File: ") && str.contains(this.f3559a)) {
                this.f3560b.add(this.f3561c);
                C1061a.m4746c(this.f3559a + " was found here: " + this.f3561c);
            }
            C1061a.m4746c(str);
            super.m4719a(i, str);
        }
    }

    /* renamed from: com.a.a.a.3 */
    static class C10573 extends C1054a {
        final /* synthetic */ Set f3562a;

        C10573(int i, boolean z, String[] strArr, Set set) {
            this.f3562a = set;
            super(i, z, strArr);
        }

        public void m4732a(int i, String str) {
            if (i == 158) {
                this.f3562a.addAll(Arrays.asList(str.split(" ")));
            }
            super.m4719a(i, str);
        }
    }

    /* renamed from: com.a.a.a.4 */
    static /* synthetic */ class C10584 {
        static final /* synthetic */ int[] f3563a;

        static {
            f3563a = new int[C1059a.values().length];
            try {
                f3563a[C1059a.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3563a[C1059a.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3563a[C1059a.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3563a[C1059a.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.a.a.a.a */
    public enum C1059a {
        VERBOSE,
        ERROR,
        DEBUG,
        WARN
    }

    static {
        f3569a = false;
        f3570b = true;
        f3571c = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    }

    public static C1071b m4733a(boolean z) {
        return C1061a.m4734a(z, 0);
    }

    public static C1071b m4734a(boolean z, int i) {
        return C1061a.m4735a(z, i, C1071b.f3592a, 3);
    }

    public static C1071b m4735a(boolean z, int i, C1068a c1068a, int i2) {
        return z ? C1071b.m4753a(i, c1068a, i2) : C1071b.m4751a(i);
    }

    public static List<String> m4736a() {
        return Arrays.asList(System.getenv("PATH").split(":"));
    }

    public static List<String> m4737a(String str, List<String> list) {
        Object obj;
        List<String> arrayList = new ArrayList();
        if (list == null) {
            List a = C1061a.m4736a();
        }
        C1061a.m4746c("Checking for " + str);
        try {
            for (String str2 : r13) {
                String str22;
                C1054a c10562 = new C10562(0, false, new String[]{"stat " + (!str22.endsWith("/") ? str22 + "/" : str22) + str}, str, arrayList, !str22.endsWith("/") ? str22 + "/" : str22);
                C1061a.m4733a(false).m4784a(c10562);
                C1061a.m4738a(C1061a.m4733a(false), c10562);
            }
            if (arrayList.isEmpty()) {
                obj = null;
            } else {
                int i = 1;
            }
        } catch (Exception e) {
            C1061a.m4746c(str + " was not found, more information MAY be available with Debugging on.");
            obj = null;
        }
        if (obj == null) {
            C1061a.m4746c("Trying second method");
            for (String str222 : r13) {
                if (!str222.endsWith("/")) {
                    str222 = str222 + "/";
                }
                if (C1061a.m4742a(str222 + str)) {
                    C1061a.m4746c(str + " was found here: " + str222);
                    arrayList.add(str222);
                } else {
                    C1061a.m4746c(str + " was NOT found here: " + str222);
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    private static void m4738a(C1071b c1071b, C1054a c1054a) {
        while (!c1054a.m4727e()) {
            C1061a.m4740a("RootShell v1.3", c1071b.m4788c(c1054a));
            C1061a.m4740a("RootShell v1.3", "Processed " + c1054a.f3547g + " of " + c1054a.f3546f + " output from command.");
            synchronized (c1054a) {
                try {
                    if (!c1054a.m4727e()) {
                        c1054a.wait(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!(c1054a.m4726d() || c1054a.m4727e())) {
                Exception exception;
                if (!c1071b.f3598b && !c1071b.f3599c) {
                    C1061a.m4740a("RootShell v1.3", "Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: " + c1054a.m4724c());
                    exception = new Exception();
                    exception.setStackTrace(Thread.currentThread().getStackTrace());
                    exception.printStackTrace();
                } else if (!c1071b.f3598b || c1071b.f3599c) {
                    C1061a.m4740a("RootShell v1.3", "Waiting for a command to be executed in a shell that is not reading! \n\n Command: " + c1054a.m4724c());
                    exception = new Exception();
                    exception.setStackTrace(Thread.currentThread().getStackTrace());
                    exception.printStackTrace();
                } else {
                    C1061a.m4740a("RootShell v1.3", "Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: " + c1054a.m4724c());
                    exception = new Exception();
                    exception.setStackTrace(Thread.currentThread().getStackTrace());
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void m4739a(String str, C1059a c1059a, Exception exception) {
        C1061a.m4741a(null, str, c1059a, exception);
    }

    public static void m4740a(String str, String str2) {
        C1061a.m4741a(str, str2, C1059a.DEBUG, null);
    }

    public static void m4741a(String str, String str2, C1059a c1059a, Exception exception) {
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR) && f3569a) {
            if (str == null) {
                str = "RootShell v1.3";
            }
            switch (C10584.f3563a[c1059a.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    Log.v(str, str2);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    Log.e(str, str2, exception);
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    Log.d(str, str2);
                case SpdyProtocol.QUIC /*4*/:
                    Log.w(str, str2);
                default:
            }
        }
    }

    public static boolean m4742a(String str) {
        return C1061a.m4743a(str, false);
    }

    public static boolean m4743a(String str, boolean z) {
        Collection<String> arrayList = new ArrayList();
        String str2 = "ls " + (z ? "-d " : " ");
        C1054a c10551 = new C10551(0, false, new String[]{str2 + str}, arrayList);
        try {
            C1061a.m4733a(false).m4784a(c10551);
            C1061a.m4738a(C1061a.m4733a(false), c10551);
            for (String str22 : arrayList) {
                if (str22.trim().equals(str)) {
                    return true;
                }
            }
            arrayList.clear();
            try {
                C1061a.m4733a(true).m4784a(c10551);
                C1061a.m4738a(C1061a.m4733a(true), c10551);
                List<String> arrayList2 = new ArrayList();
                arrayList2.addAll(arrayList);
                for (String str222 : arrayList2) {
                    if (str222.trim().equals(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static List<String> m4744b(String str) {
        return C1061a.m4737a(str, null);
    }

    public static boolean m4745b() {
        Set<String> hashSet = new HashSet();
        try {
            C1061a.m4746c("Checking for Root access");
            C1054a c10573 = new C10573(158, false, new String[]{AgooConstants.MESSAGE_ID}, hashSet);
            C1071b.m4772h().m4784a(c10573);
            C1061a.m4738a(C1071b.m4772h(), c10573);
            for (String str : hashSet) {
                C1061a.m4746c(str);
                if (str.toLowerCase().contains("uid=0")) {
                    C1061a.m4746c("Access Given");
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void m4746c(String str) {
        C1061a.m4741a(null, str, C1059a.DEBUG, null);
    }

    public static boolean m4747c() {
        return C1061a.m4744b("su").size() > 0;
    }
}
