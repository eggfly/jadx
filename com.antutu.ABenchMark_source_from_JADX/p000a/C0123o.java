package p000a;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: a.o */
public interface C0123o {
    public static final C0123o f519a;

    /* renamed from: a.o.1 */
    static class C01241 implements C0123o {
        C01241() {
        }

        public List<InetAddress> m536a(String str) {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    }

    static {
        f519a = new C01241();
    }

    List<InetAddress> m535a(String str);
}
