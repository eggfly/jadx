package com.taobao.accs.net;

import com.taobao.accs.data.Message;

/* renamed from: com.taobao.accs.net.m */
class C4125m implements Runnable {
    final /* synthetic */ Message f13821a;
    final /* synthetic */ boolean f13822b;
    final /* synthetic */ C4124l f13823c;

    C4125m(C4124l c4124l, Message message, boolean z) {
        this.f13823c = c4124l;
        this.f13821a = message;
        this.f13822b = z;
    }

    public void run() {
        synchronized (this.f13823c.f13806l) {
            this.f13823c.m16854a(this.f13821a);
            if (this.f13823c.f13806l.size() == 0) {
                this.f13823c.f13806l.add(this.f13821a);
            } else {
                Message message = (Message) this.f13823c.f13806l.getFirst();
                if (this.f13821a.getType() == 1 || this.f13821a.getType() == 0) {
                    this.f13823c.f13806l.addLast(this.f13821a);
                    if (message.getType() == 2) {
                        this.f13823c.f13806l.removeFirst();
                    }
                } else if (this.f13821a.getType() != 2 || message.getType() != 2) {
                    this.f13823c.f13806l.addLast(this.f13821a);
                } else if (!message.force && this.f13821a.force) {
                    this.f13823c.f13806l.removeFirst();
                    this.f13823c.f13806l.addFirst(this.f13821a);
                }
            }
            if (this.f13822b || this.f13823c.f13805k == 3) {
                try {
                    this.f13823c.f13806l.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
