package com.taobao.accs.data;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class MessageHandler$1 extends LinkedHashMap<String, String> {
    final /* synthetic */ C4097b f13685a;

    MessageHandler$1(C4097b c4097b) {
        this.a = c4097b;
    }

    protected boolean removeEldestEntry(Entry<String, String> entry) {
        return size() > 50;
    }
}
