package anet.channel.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private int f2321a;

    public LruCache(int i) {
        super(i + 1, 1.0f, true);
        this.f2321a = i;
    }

    protected boolean m2879a(Entry<K, V> entry) {
        return true;
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.f2321a ? m2879a(entry) : false;
    }
}
