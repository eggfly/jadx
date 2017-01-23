import java.io.OutputStream;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class beb {
    static List j6(bhj bhj) {
        List arrayList = new ArrayList();
        try {
            for (bdl j6 : bhj.j6(null)) {
                arrayList.add(j6.j6());
            }
            return arrayList;
        } catch (Exception e) {
            throw new bdr("error processing certs", e);
        }
    }

    static ayy j6(List list) {
        ayi ayi = new ayi();
        for (ayh j6 : list) {
            ayi.j6(j6);
        }
        return new azn(ayi);
    }

    public static Provider j6(String str) {
        if (str == null) {
            return null;
        }
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return provider;
        }
        throw new NoSuchProviderException("provider " + str + " not found.");
    }

    static OutputStream j6(Collection collection, OutputStream outputStream) {
        for (bef j6 : collection) {
            outputStream = j6(outputStream, j6.j6());
        }
        return outputStream;
    }

    static OutputStream j6(OutputStream outputStream) {
        return outputStream == null ? new bee() : outputStream;
    }

    static OutputStream j6(OutputStream outputStream, OutputStream outputStream2) {
        if (outputStream == null) {
            return j6(outputStream2);
        }
        if (outputStream2 == null) {
            return j6(outputStream);
        }
        return new bhq(outputStream, outputStream2);
    }
}
