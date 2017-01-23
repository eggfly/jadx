package p000a.p001a.p004e;

import anet.channel.util.HttpConstant;
import okio.ByteString;
import p000a.p001a.C0037c;

/* renamed from: a.a.e.c */
public final class C0049c {
    public static final ByteString f163a;
    public static final ByteString f164b;
    public static final ByteString f165c;
    public static final ByteString f166d;
    public static final ByteString f167e;
    public static final ByteString f168f;
    public final ByteString f169g;
    public final ByteString f170h;
    final int f171i;

    static {
        f163a = ByteString.encodeUtf8(":");
        f164b = ByteString.encodeUtf8(HttpConstant.STATUS);
        f165c = ByteString.encodeUtf8(":method");
        f166d = ByteString.encodeUtf8(":path");
        f167e = ByteString.encodeUtf8(":scheme");
        f168f = ByteString.encodeUtf8(":authority");
    }

    public C0049c(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public C0049c(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public C0049c(ByteString byteString, ByteString byteString2) {
        this.f169g = byteString;
        this.f170h = byteString2;
        this.f171i = (byteString.size() + 32) + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0049c)) {
            return false;
        }
        C0049c c0049c = (C0049c) obj;
        return this.f169g.equals(c0049c.f169g) && this.f170h.equals(c0049c.f170h);
    }

    public int hashCode() {
        return ((this.f169g.hashCode() + 527) * 31) + this.f170h.hashCode();
    }

    public String toString() {
        return C0037c.m153a("%s: %s", this.f169g.utf8(), this.f170h.utf8());
    }
}
