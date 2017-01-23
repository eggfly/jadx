package com.xiaomi.push.protobuf;

import com.antutu.redacc.C1692R;
import com.google.protobuf.micro.C3613a;
import com.google.protobuf.micro.C3615b;
import com.google.protobuf.micro.C3617d;
import com.umeng.message.common.C4209a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.xiaomi.push.protobuf.a */
public final class C4378a {

    /* renamed from: com.xiaomi.push.protobuf.a.a */
    public static final class C4377a extends C3617d {
        private boolean f14908a;
        private int f14909b;
        private boolean f14910c;
        private boolean f14911d;
        private boolean f14912e;
        private int f14913f;
        private boolean f14914g;
        private boolean f14915h;
        private List<String> f14916i;
        private int f14917j;

        public C4377a() {
            this.f14909b = 0;
            this.f14911d = false;
            this.f14913f = 0;
            this.f14915h = false;
            this.f14916i = Collections.emptyList();
            this.f14917j = -1;
        }

        public static C4377a m17976b(byte[] bArr) {
            return (C4377a) new C4377a().m14875a(bArr);
        }

        public static C4377a m17977c(C3613a c3613a) {
            return new C4377a().m17985b(c3613a);
        }

        public int m17978a() {
            int i = 0;
            int d = m17988d() ? C3615b.m14844d(1, m17987c()) + 0 : 0;
            if (m17990f()) {
                d += C3615b.m14838b(2, m17989e());
            }
            if (m17992h()) {
                d += C3615b.m14842c(3, m17991g());
            }
            int b = m17994j() ? d + C3615b.m14838b(4, m17993i()) : d;
            for (String b2 : m17995k()) {
                i += C3615b.m14839b(b2);
            }
            d = (b + i) + (m17995k().size() * 1);
            this.f14917j = d;
            return d;
        }

        public /* synthetic */ C3617d m17979a(C3613a c3613a) {
            return m17985b(c3613a);
        }

        public C4377a m17980a(int i) {
            this.f14908a = true;
            this.f14909b = i;
            return this;
        }

        public C4377a m17981a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f14916i.isEmpty()) {
                this.f14916i = new ArrayList();
            }
            this.f14916i.add(str);
            return this;
        }

        public C4377a m17982a(boolean z) {
            this.f14910c = true;
            this.f14911d = z;
            return this;
        }

        public void m17983a(C3615b c3615b) {
            if (m17988d()) {
                c3615b.m14860b(1, m17987c());
            }
            if (m17990f()) {
                c3615b.m14853a(2, m17989e());
            }
            if (m17992h()) {
                c3615b.m14851a(3, m17991g());
            }
            if (m17994j()) {
                c3615b.m14853a(4, m17993i());
            }
            for (String a : m17995k()) {
                c3615b.m14852a(5, a);
            }
        }

        public C4377a m17984b(int i) {
            this.f14912e = true;
            this.f14913f = i;
            return this;
        }

        public C4377a m17985b(C3613a c3613a) {
            while (true) {
                int a = c3613a.m14820a();
                switch (a) {
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                        m17980a(c3613a.m14829f());
                        continue;
                    case SpdyProtocol.CUSTOM /*16*/:
                        m17982a(c3613a.m14827d());
                        continue;
                    case C4209a.f14216s /*24*/:
                        m17984b(c3613a.m14824c());
                        continue;
                    case C4574a.ORDERED /*32*/:
                        m17986b(c3613a.m14827d());
                        continue;
                    case C1692R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        m17981a(c3613a.m14828e());
                        continue;
                    default:
                        if (!m14878a(c3613a, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public C4377a m17986b(boolean z) {
            this.f14914g = true;
            this.f14915h = z;
            return this;
        }

        public int m17987c() {
            return this.f14909b;
        }

        public boolean m17988d() {
            return this.f14908a;
        }

        public boolean m17989e() {
            return this.f14911d;
        }

        public boolean m17990f() {
            return this.f14910c;
        }

        public int m17991g() {
            return this.f14913f;
        }

        public boolean m17992h() {
            return this.f14912e;
        }

        public boolean m17993i() {
            return this.f14915h;
        }

        public boolean m17994j() {
            return this.f14914g;
        }

        public List<String> m17995k() {
            return this.f14916i;
        }

        public int m17996l() {
            return this.f14916i.size();
        }
    }
}
