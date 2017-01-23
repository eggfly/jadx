package com.antutu.benchmark.p045i;

import com.antutu.utils.HttpRequestTask;
import com.antutu.utils.RequestListener;
import java.util.HashMap;

/* renamed from: com.antutu.benchmark.i.a */
public class C1512a {
    private String f5185a;
    private HashMap<String, Object> f5186b;

    public C1512a() {
        this.f5185a = "http://autovote.antutu.net/proMoudule/index.php?action=seMobileSearchv6&data=1&act=MobileSearch";
    }

    public void m5996a(RequestListener requestListener) {
        HttpRequestTask httpRequestTask = new HttpRequestTask(this.f5186b, this.f5185a, requestListener);
        httpRequestTask.setEnc(true);
        httpRequestTask.submit();
    }

    public void m5997a(HashMap<String, Object> hashMap) {
        this.f5186b = hashMap;
    }
}
