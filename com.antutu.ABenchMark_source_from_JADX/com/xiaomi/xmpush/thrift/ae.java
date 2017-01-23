package com.xiaomi.xmpush.thrift;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.C4290b;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4305c;
import org.apache.thrift.C4454a;
import org.apache.thrift.C4596e;
import org.apache.thrift.C4597f;
import org.apache.thrift.C4598g;
import org.apache.thrift.protocol.C4608a.C4606a;
import org.apache.thrift.protocol.C4617k.C4616a;

public class ae {
    public static short m18791a(Context context, String str) {
        int i = 0;
        int a = (C4305c.m17662b(context) ? 4 : 0) + (0 + C4290b.m17602d(context, str).m17596a());
        if (C4305c.m17661a(context)) {
            i = 8;
        }
        return (short) (a + i);
    }

    public static <T extends C4454a<T, ?>> void m18792a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new C4597f("the message byte is empty.");
        }
        new C4596e(new C4616a(true, true, bArr.length)).m19299a(t, bArr);
    }

    public static <T extends C4454a<T, ?>> byte[] m18793a(T t) {
        byte[] bArr = null;
        if (t != null) {
            try {
                bArr = new C4598g(new C4606a()).m19300a(t);
            } catch (Throwable e) {
                C4302b.m17650a("convertThriftObjectToBytes catch TException.", e);
            }
        }
        return bArr;
    }
}
