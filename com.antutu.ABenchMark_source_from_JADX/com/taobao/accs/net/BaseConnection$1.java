package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class BaseConnection$1 extends LinkedHashMap<Integer, Message> {
    final /* synthetic */ C4112a f13754a;

    BaseConnection$1(C4112a c4112a) {
        this.a = c4112a;
    }

    protected boolean removeEldestEntry(Entry<Integer, Message> entry) {
        return size() > 10;
    }
}
