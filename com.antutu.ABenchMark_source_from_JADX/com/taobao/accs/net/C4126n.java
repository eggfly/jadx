package com.taobao.accs.net;

/* renamed from: com.taobao.accs.net.n */
class C4126n implements Runnable {
    final /* synthetic */ String f13824a;
    final /* synthetic */ C4124l f13825b;

    C4126n(C4124l c4124l, String str) {
        this.f13825b = c4124l;
        this.f13824a = str;
    }

    public void run() {
        if (this.f13824a != null && this.f13824a.equals(this.f13825b.f13799G) && this.f13825b.f13805k == 2) {
            this.f13825b.f13795C = false;
            this.f13825b.f13797E = true;
            this.f13825b.m16889i();
            this.f13825b.f13793A.setCloseReason("conn timeout");
        }
    }
}
