package com.xiaomi.push.protobuf;

import com.google.protobuf.micro.C3613a;
import com.google.protobuf.micro.C3615b;
import com.google.protobuf.micro.C3617d;
import com.nostra13.universalimageloader.BuildConfig;
import com.umeng.message.common.C4209a;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.xiaomi.push.protobuf.b */
public final class C4380b {

    /* renamed from: com.xiaomi.push.protobuf.b.a */
    public static final class C4379a extends C3617d {
        private boolean f14918a;
        private boolean f14919b;
        private boolean f14920c;
        private int f14921d;
        private boolean f14922e;
        private int f14923f;
        private boolean f14924g;
        private int f14925h;
        private int f14926i;

        public C4379a() {
            this.f14919b = false;
            this.f14921d = 0;
            this.f14923f = 0;
            this.f14925h = 0;
            this.f14926i = -1;
        }

        public static C4379a m17997b(byte[] bArr) {
            return (C4379a) new C4379a().m14875a(bArr);
        }

        public int m17998a() {
            int i = 0;
            if (m18007d()) {
                i = 0 + C3615b.m14838b(1, m18006c());
            }
            if (m18009f()) {
                i += C3615b.m14842c(3, m18008e());
            }
            if (m18011h()) {
                i += C3615b.m14842c(4, m18010g());
            }
            if (m18013j()) {
                i += C3615b.m14842c(5, m18012i());
            }
            this.f14926i = i;
            return i;
        }

        public /* synthetic */ C3617d m17999a(C3613a c3613a) {
            return m18004b(c3613a);
        }

        public C4379a m18000a(int i) {
            this.f14920c = true;
            this.f14921d = i;
            return this;
        }

        public C4379a m18001a(boolean z) {
            this.f14918a = true;
            this.f14919b = z;
            return this;
        }

        public void m18002a(C3615b c3615b) {
            if (m18007d()) {
                c3615b.m14853a(1, m18006c());
            }
            if (m18009f()) {
                c3615b.m14851a(3, m18008e());
            }
            if (m18011h()) {
                c3615b.m14851a(4, m18010g());
            }
            if (m18013j()) {
                c3615b.m14851a(5, m18012i());
            }
        }

        public C4379a m18003b(int i) {
            this.f14922e = true;
            this.f14923f = i;
            return this;
        }

        public C4379a m18004b(C3613a c3613a) {
            while (true) {
                int a = c3613a.m14820a();
                switch (a) {
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                        m18001a(c3613a.m14827d());
                        continue;
                    case C4209a.f14216s /*24*/:
                        m18000a(c3613a.m14824c());
                        continue;
                    case C4574a.ORDERED /*32*/:
                        m18003b(c3613a.m14824c());
                        continue;
                    case BuildConfig.VERSION_CODE /*40*/:
                        m18005c(c3613a.m14824c());
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

        public C4379a m18005c(int i) {
            this.f14924g = true;
            this.f14925h = i;
            return this;
        }

        public boolean m18006c() {
            return this.f14919b;
        }

        public boolean m18007d() {
            return this.f14918a;
        }

        public int m18008e() {
            return this.f14921d;
        }

        public boolean m18009f() {
            return this.f14920c;
        }

        public int m18010g() {
            return this.f14923f;
        }

        public boolean m18011h() {
            return this.f14922e;
        }

        public int m18012i() {
            return this.f14925h;
        }

        public boolean m18013j() {
            return this.f14924g;
        }
    }
}
